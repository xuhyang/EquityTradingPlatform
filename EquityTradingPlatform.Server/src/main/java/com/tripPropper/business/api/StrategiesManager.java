package com.tripPropper.business.api;

import com.tripPropper.business.models.Stock;
import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.strategies.Impl.BollingerBands;
import com.tripPropper.business.strategies.Impl.PriceBreakout;
import com.tripPropper.business.strategies.Impl.TwoMovingAvg;
import com.tripPropper.business.strategies.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 7/31/2016.
 */

@Component
public class StrategiesManager {

    private Map<Integer, Strategy> strategies;

    private AtomicInteger numStrategies;


    @PostConstruct
    public void loadStrategiesFromDB() {
        strategies = new ConcurrentHashMap<>();
        numStrategies.set(strategies.size());
    }


    public void addNewStrategyByInfo(StrategyInfo strategyInfo) {
        int strategyID = numStrategies.get();
        strategyInfo.setId(strategyID);
        createStrategy(strategyInfo);
        numStrategies.set(strategies.size());
        //db
    }

    public void removeStrategyByID(int id) {
        strategies.remove(id).stop();
        //db
    }

    private void createStrategy(StrategyInfo strategyInfo) {
        Strategy strategy = null;
        String strategyType = strategyInfo.getStrategyType();

        if (strategyType.equals(TwoMovingAvg.class.getName()))
            strategy = new TwoMovingAvg(strategyInfo);
        else if (strategyType.equals(BollingerBands.class.getName()))
            strategy = new BollingerBands(strategyInfo);
        else if (strategyType.equals(PriceBreakout.class.getName()))
            strategy = new PriceBreakout(strategyInfo);

        strategies.put(strategyInfo.getId(), strategy);
    }


}
