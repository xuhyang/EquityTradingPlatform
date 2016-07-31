package com.tripPropper.business.api;

import com.tripPropper.business.models.Stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 7/30/2016.
 */

@Component
public class StocksManager {

    private List<Stock> stocks = new CopyOnWriteArrayList<>();


    public StocksManager() {}


    public Stock getStock(String stockCode,int longAvgMins) {
        Stock stock = getStockByCode(stockCode);

        if (stock == null) {
            stock = new Stock(stockCode, longAvgMins);
            stocks.add(stock);
        }else
            stock.setMinAvgSize(longAvgMins);

        return stock;
    }

    private Stock getStockByCode(String stockCode) {
        for (Stock stock : stocks)
            if (stock.getStockCode().equals(stockCode))
                return stock;

        return null;
    }

    public Stock getStock(String stockCode) {
        Stock stock = getStockByCode(stockCode);

        if (stock == null) {
            stock = new Stock(stockCode);
            stocks.add(stock);
        }
        return stock;
    }

    public List<Stock> getStocks() {
        return stocks;
    }





}
