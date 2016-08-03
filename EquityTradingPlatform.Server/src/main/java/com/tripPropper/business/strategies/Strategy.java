package com.tripPropper.business.strategies;

import com.tripPropper.business.models.Stock;
import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.models.Trade;

/**
 * Created by admin on 7/31/2016.
 */
public interface Strategy {



    void openPosition();

    void closePosition();

    void recordExecution();

    boolean isOpen();

    int getID();

//    Stock getStock();

    void updatePriceAverage();

    void run();

    StrategyInfo getStrategyInfo();

}
