package com.tripPropper.business.api;



import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.strategies.Impl.BollingerBands;
import com.tripPropper.business.strategies.Impl.PriceBreakout;
import com.tripPropper.business.strategies.Impl.TwoMovingAvg;
import com.tripPropper.business.strategies.Strategy;
import com.tripPropper.converters.EntityDtoConverter;
import com.tripPropper.database.repos.StrategyEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by admin on 7/31/2016.
 */

@Service
public class StrategiesManager {

    private Map<Integer, Strategy> strategies = new ConcurrentHashMap<>();

    private AtomicInteger numStrategies = new AtomicInteger();

    @Autowired
    private StrategyEntityRepo strategyEntityRepo;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @Autowired
    private TradesManager tradesManager;

    @Autowired
    private StocksManager stocksManager;



    @PostConstruct
    public void loadStrategiesFromDB() {
        List<StrategyInfo> activeStrategyInfoList = entityDtoConverter.entitiesToDtos(strategyEntityRepo.findByIsActive(Boolean.TRUE));
        activeStrategyInfoList.forEach(this::createStrategy);
        setNumStrategies();
    }


    public void runStrategies() {
        strategies.forEach((strategyId, strategy) -> strategy.run());
    }

    public void addNewStrategyByInfo(StrategyInfo strategyInfo) {
        int strategyID = numStrategies.get();
        strategyInfo.setId(strategyID);
        createStrategy(strategyInfo);

        strategyEntityRepo.save(entityDtoConverter.DtoToEntity(strategyInfo));
        setNumStrategies();
    }

    public void deactivateStrategyByID(int id) {
        StrategyInfo strategyInfo = strategies.remove(id).getStrategyInfo();
        strategyInfo.setActive(false);

        strategyEntityRepo.save(entityDtoConverter.DtoToEntity(strategyInfo));
    }

    public Iterable<StrategyInfo> getAllStrategyInfo() {
        List<StrategyInfo> AllStrategyInfoList = entityDtoConverter.entitiesToDtos(strategyEntityRepo.findAll());

        return AllStrategyInfoList;
    }

    private void createStrategy(StrategyInfo strategyInfo) {
        Strategy strategy = null;
        String strategyType = strategyInfo.getStrategyType();

        if (strategyType.equals(TwoMovingAvg.class.getName()))
            strategy = new TwoMovingAvg(strategyInfo);
        else if (strategyType.equals(BollingerBands.class.getName()))
            strategy = new BollingerBands(strategyInfo, stocksManager, tradesManager);
        else if (strategyType.equals(PriceBreakout.class.getName()))
            strategy = new PriceBreakout(strategyInfo);

        strategies.put(strategyInfo.getId(), strategy);
    }

    private void setNumStrategies() {
        numStrategies.set((int)strategyEntityRepo.count());
    }

    public StrategyInfo getStrategyInfoByID(int id) {
        return strategies.get(id).getStrategyInfo();
    }
}
