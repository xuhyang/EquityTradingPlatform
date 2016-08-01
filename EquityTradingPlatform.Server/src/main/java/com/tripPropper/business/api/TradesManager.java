package com.tripPropper.business.api;

import com.tripPropper.business.models.Trade;
import com.tripPropper.business.strategies.Strategy;
import com.tripPropper.orderExecution.TradePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 7/30/2016.
 */

@Component
public class TradesManager {

    //this might not needed
    private List<Trade> tradesSent = new CopyOnWriteArrayList<>();

    private List<Trade> answeredTrades = new CopyOnWriteArrayList<>();

    private Integer numTrades;

    @Autowired
    TradePublisher tradePublisher;




    @PostConstruct
    public void loadTradesFromDB() {

    }

    public void execute(boolean isBuy, String stockCode, int size, double price) {
        Trade trade = new Trade();
        trade.setBuy(isBuy);
        trade.setStock(stockCode);
        trade.setSize(size);
        trade.setPrice(price);

        tradePublisher.submit(trade);
        tradesSent.add(trade);
    }

    public List<Trade> getTradesSent() {
        return tradesSent;
    }

    public List<Trade> getAnsweredTrades() {
        return answeredTrades;
    }

}
