package com.tripPropper.business.models;

/**
 * Created by xy30164 on 7/29/2016.
 */
public class StrategyInfo {

    private int id;

    private String status;

    private String stockCode;

    private String strategyType;

    private int longAvgMins;

    private int shortAvgMins;

    private int movingAvgDays;

    private double priceAvg;

    private double revenue;

    private int breakoutMins;

    private int orderSize;

    private double profitLossThreshold;

    private int standardDeviationThreshold;

    private boolean isOpen = false;

    private boolean isBuy = false;

    private double position = 0;

    private double profitLoss = 0;

    private int openShares = 0;

    private int tradeId = -1;

    private boolean isActive = true;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    public int getLongAvgMins() {
        return longAvgMins;
    }

    public void setLongAvgMins(int longAvgMins) {
        this.longAvgMins = longAvgMins;
    }

    public int getShortAvgMins() {
        return shortAvgMins;
    }

    public void setShortAvgMins(int shortAvgMins) {
        this.shortAvgMins = shortAvgMins;
    }

    public int getMovingAvgDays() {
        return movingAvgDays;
    }

    public void setMovingAvgDays(int movingAvgDays) {
        this.movingAvgDays = movingAvgDays;
    }

    public double getPriceAvg() {
        return priceAvg;
    }

    public void setPriceAvg(double priceAvg) {
        this.priceAvg = priceAvg;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getBreakoutMins() {
        return breakoutMins;
    }

    public void setBreakoutMins(int breakoutMins) {
        this.breakoutMins = breakoutMins;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    public double getProfitLossThreshold() {
        return profitLossThreshold;
    }

    public void setProfitLossThreshold(double profitLossThreshold) {
        this.profitLossThreshold = profitLossThreshold;
    }

    public int getStandardDeviationThreshold() {
        return standardDeviationThreshold;
    }

    public void setStandardDeviationThreshold(int standardDeviationThreshold) {
        this.standardDeviationThreshold = standardDeviationThreshold;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public void setIsBuy(boolean isBuy) {
        this.isBuy = isBuy;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(double profitLoss) {
        this.profitLoss = profitLoss;
    }

    public int getOpenShares() {
        return openShares;
    }

    public void setOpenShares(int openShares) {
        this.openShares = openShares;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setBuy(boolean buy) {
        isBuy = buy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}


