package business.api;

import models.Stock;

import java.util.List;

/**
 * Created by admin on 7/30/2016.
 */
public class StocksManager {

    List<Stock> stocks;


    public StocksManager(List<Stock> stocks) {
        this.stocks = stocks;
    }


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


}
