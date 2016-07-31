package com.tripPropper.marketData;




import com.tripPropper.business.api.StocksManager;
import com.tripPropper.business.models.Stock;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 7/30/2016.
 */


public class MarketDataFeedTests {


    public static void main(String[] args) {
        StocksManager stocksManager = new StocksManager();
        stocksManager.getStock("IBM");
        stocksManager.getStock("AAPL");

        MarketDataFeed mdf = new MarketDataFeed(stocksManager);
        mdf.start();

    }
}
