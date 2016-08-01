package com.tripPropper.business.strategies.Impl;

import com.tripPropper.business.models.Stock;
import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.strategies.Strategy;

/**
 * Created by xy30164 on 7/29/2016.
 */
public class BollingerBands implements Strategy {

    private int id;

    private Stock stock;

    public BollingerBands(StrategyInfo strategyInfo) {
//        this.id =
//        this.stock = stock;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public int getID() {
        return id;
    }
}
