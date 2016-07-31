package com.tripPropper.business.api;

import com.tripPropper.business.models.Trade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 7/30/2016.
 */

@Component
public class TradesManager {

    List<Trade> tradesSent = new CopyOnWriteArrayList<>();

    List<Trade> answeredTrades = new CopyOnWriteArrayList<>();


    public List<Trade> getTradesSent() {
        return tradesSent;
    }

    public List<Trade> getAnsweredTrades() {
        return answeredTrades;
    }

}
