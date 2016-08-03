package com.tripPropper.business.strategies.Impl;

import com.tripPropper.business.api.StocksManager;
import com.tripPropper.business.api.TradesManager;
import com.tripPropper.business.models.Stock;
import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.models.Trade;
import com.tripPropper.business.strategies.Strategy;

/**
 * Created by xy30164 on 7/29/2016.
 */
public class BollingerBands implements Strategy {

    private Stock stock;

    private StrategyInfo strategyInfo;

    private TradesManager tradesManager;


    public BollingerBands(StrategyInfo strategyInfo, StocksManager stocksManager, TradesManager tradesManager) {
        this.tradesManager = tradesManager;
        this.strategyInfo = strategyInfo;
        this.stock = stocksManager.getStock(strategyInfo.getStockCode());
    }

    @Override
    public int getID() {
        return strategyInfo.getId();
    }

    @Override
    public void updatePriceAverage(){
        //recompute moving average price
        double avg = 0;
        for( Double p : stock.getBids()){
            avg += p;
        }
        avg /= stock.getBids().size();
        strategyInfo.setPriceAvg(avg);

        System.out.println("updated average of "+ stock.getStockCode()+" to "+strategyInfo.getPriceAvg());
    }

    @Override
    public void run() {}

    @Override
    public void recordExecution() {
        //if trade is executed then adjust position number of open shares and position
        Trade trade = tradesManager.getTradeById(strategyInfo.getTradeId());
        if (trade != null) {
            if (trade.isBuy()) {
                strategyInfo.setOpenShares(strategyInfo.getOpenShares() + trade.getSize());
                strategyInfo.setPosition(strategyInfo.getPosition() + trade.getSize() * trade.getPrice());
            } else {
                strategyInfo.setOpenShares(strategyInfo.getOpenShares() - trade.getSize());
                strategyInfo.setPosition(strategyInfo.getPosition() -  trade.getSize() * trade.getPrice());
            }
            if (!isOpen()) {
                strategyInfo.setIsOpen(true);
                strategyInfo.setIsBuy(trade.isBuy());
            } else {
                if (strategyInfo.getOpenShares() == 0) {
                    if (isBuy()) {
                        strategyInfo.setProfitLoss(strategyInfo.getProfitLoss() - strategyInfo.getPosition());
                        strategyInfo.setPosition(0);
                        strategyInfo.setRevenue( strategyInfo.getRevenue() + strategyInfo.getProfitLoss());
                    } else {
                        strategyInfo.setProfitLoss(strategyInfo.getProfitLoss() + strategyInfo.getPosition());
                        strategyInfo.setPosition(0);
                        strategyInfo.setRevenue( strategyInfo.getRevenue() + strategyInfo.getProfitLoss());
                    }
                    strategyInfo.setTradeId(-1);
                    strategyInfo.setIsOpen(false);
                }
            }
        }
    }

    @Override
    public void openPosition(){
        //time to buy
        if(stock.getAsk() < strategyInfo.getMovingAvgDays()*strategyInfo.getStandardDeviationThreshold()){
            System.out.println("[Bollinger Bands instance] time to BUY");
            int tradeID = tradesManager.execute(true, stock.getStockCode(), strategyInfo.getOrderSize(), stock.getAsk());
            strategyInfo.setTradeId(tradeID);
        }
        //time to sell
        if(stock.getBid() > strategyInfo.getMovingAvgDays()*strategyInfo.getStandardDeviationThreshold()){
            System.out.println("[Bollinger Bands instance] time to BUY");
            int tradeID = tradesManager.execute(false, stock.getStockCode(), strategyInfo.getOrderSize(), stock.getBid());
            strategyInfo.setTradeId(tradeID);
        }
    }

    @Override
    public void closePosition() {
        System.out.println("time to CLOSE");
        double currentValue = stock.getBid()*getOpenShares();
        double profitLossThreshold = strategyInfo.getProfitLossThreshold();
        //try to close buy position
        if(isBuy()){
            if(currentValue >= getPosition()*(1+profitLossThreshold) || currentValue <= getPosition()*(1-profitLossThreshold)){
                tradesManager.execute(false,stock.getStockCode(),getOpenShares(),stock.getBid());
            }
        }
        //try to close sell position
        if(!isBuy()){
            if(currentValue >= getPosition()*(1+profitLossThreshold) || currentValue <= getPosition() *(1-profitLossThreshold)){
                tradesManager.execute(true,stock.getStockCode(),getOpenShares(),stock.getBid());
            }
        }
    }


    public boolean isBuy() {
        return strategyInfo.isBuy();
    }

    public int getOpenShares() {
        return strategyInfo.getOpenShares();
    }

    public double getProfitLoss() {
        return strategyInfo.getProfitLoss();
    }

    public int getTradeId() {
        return strategyInfo.getTradeId();
    }

    public double getPosition() {
        return strategyInfo.getPosition();
    }

    public boolean isOpen() {
        return strategyInfo.isOpen();
    }

    public int getId() {
        return strategyInfo.getId();
    }

    @Override
    public StrategyInfo getStrategyInfo() {
        return strategyInfo;
    }


}
