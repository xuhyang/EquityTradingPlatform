package com.tripPropper.marketData;




import com.tripPropper.Application;
import com.tripPropper.business.api.StocksManager;
import com.tripPropper.business.api.StrategiesManager;
import com.tripPropper.business.api.TradesManager;
import com.tripPropper.business.models.Stock;
import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.business.strategies.Impl.BollingerBands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 7/30/2016.
 */

@SpringBootApplication
public class MarketDataFeedTests {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        StocksManager stocksManager = context.getBean(StocksManager.class);
        StrategiesManager strategiesManager = context.getBean(StrategiesManager.class);
        TradesManager tradesManager = context.getBean(TradesManager.class);

        stocksManager.getStock("IBM");
        stocksManager.getStock("AAPL");
        stocksManager.getStock("MSFT");


    }
}
