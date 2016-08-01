package com.tripPropper.business.strategies.Impl;

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
    @PostConstruct
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
