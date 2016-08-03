package com.tripPropper.business.strategies.Impl;

import com.tripPropper.business.models.Stock;
import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.strategies.Strategy;

/**
 * Created by xy30164 on 7/29/2016.
 */
public class TwoMovingAvg implements Strategy {

    int longAvgMins;
    int shortAvgMins;
    Stock stock;


    int id;


    public TwoMovingAvg(StrategyInfo strategyInfo) {

    }

    @Override
    public void updatePriceAverage() {

    }

    @Override
    public void run() {

    }

    @Override
    public StrategyInfo getStrategyInfo() {
        return null;
    }

    @Override
    public void openPosition() {

    }

    @Override
    public void closePosition() {

    }

    @Override
    public void recordExecution() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public int getID() {
        return id;
    }
}
