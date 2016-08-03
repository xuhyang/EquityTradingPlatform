package com.tripPropper.business.api;

import com.tripPropper.business.models.Trade;
import com.tripPropper.business.strategies.Strategy;
import com.tripPropper.orderExecution.TradePublisher;
import com.tripPropper.orderExecution.TradeSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 7/30/2016.
 */

@Component
public class TradesManager {

    //this might not needed
    private List<Trade> tradesSent = new CopyOnWriteArrayList<>();

    private Map<Integer, Trade> answeredTrades = new ConcurrentHashMap<>();

    //private Integer numTrades;
    private int counter = - 1;

    @Autowired
    TradePublisher tradePublisher;

    @Autowired
    TradeSubscriber tradeSubscriber;

    @Autowired
    StrategiesManager strategiesManager;

    @PostConstruct
    public void loadTradesFromDB() {

    }

    public Trade getTradeById(Integer tradeId){
        return answeredTrades.get(tradeId);
    }

    public int execute(boolean isBuy, String stockCode, int size, double price) {
        Trade trade = new Trade();
        trade.setId(getNumTrades() + 1);
        trade.setBuy(isBuy);
        trade.setStock(stockCode);
        trade.setSize(size);
        trade.setPrice(price);
        trade.setWhenAsDate(new Date());

        tradePublisher.submit(trade);
        tradesSent.add(trade);

        return trade.getId();
    }

    private int getNumTrades() {
        return counter++;
    }

    public void addResponse(Trade trade) {
        answeredTrades.put(trade.getId(), trade);
    }
}
