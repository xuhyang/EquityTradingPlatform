package com.tripPropper.business.strategies.Impl;

import com.tripPropper.business.models.Stock;
import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.strategies.Strategy;

import javax.annotation.PostConstruct;

/**
 * Created by xy30164 on 7/29/2016.
 */
public class PriceBreakout implements Strategy {
    int id;

    public PriceBreakout(StrategyInfo strategyInfo) {

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
