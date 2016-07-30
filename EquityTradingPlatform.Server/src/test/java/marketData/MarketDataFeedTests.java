package marketData;


import models.Stock;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 7/30/2016.
 */
public class MarketDataFeedTests {


    public static void main(String[] args) {
        List<Stock> stocks = new CopyOnWriteArrayList<>();
        stocks.add(new Stock("IBM"));
        stocks.add(new Stock("AAPL"));

        MarketDataFeed mdf = new MarketDataFeed(stocks);
        mdf.start();

    }
}
