package com.tripPropper.marketData;



import com.sun.xml.internal.bind.v2.TODO;
import com.tripPropper.business.api.StocksManager;
import com.tripPropper.business.models.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by xy30164 on 7/29/2016.
 * http://www.jarloo.com/yahoo_finance/
 */
@Component
public class MarketDataFeed {

    private List<Stock> stocks;

    private int second = 2;


    @Autowired
    public MarketDataFeed(StocksManager stocksManager) {
        this.stocks = stocksManager.getStocks();
    }


    //use a scheduler and add a stop function
    @PostConstruct
    public void start() {
        new Thread(this::updateStocksInRate).start();
    }

    private void updateStocksInRate() {
        while (true) {
            updateStocks();
            try {
                Thread.sleep(second * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateStocks() {
        URLConnection urlConnection = createConnection();
        readResponseAndUpdate(urlConnection);
    }


    private URLConnection createConnection() {
        URL url;
        URLConnection urlConnection = null;
        StringBuilder stringBuilder;
        String baseUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=";

        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(baseUrl);
            //if (i != stocksSize - 1)
            stocks.forEach(stock -> stringBuilder.append(stock.getStockCode() + ","));
            stringBuilder.append("&f=");
            stringBuilder.append("b2b3op");
            stringBuilder.append("&e=.csv");
            url = new URL(stringBuilder.toString());
            urlConnection = url.openConnection();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return urlConnection;
    }

    private void readResponseAndUpdate(URLConnection urlConnection) {
        if (urlConnection == null)
            return;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            stocks.forEach(stock -> updateStockByResponse(stock, bufferedReader));
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("[MarketDataFeed] No response from yahoo api");
        }
    }

    //TODO: modify date for closing price
    private void updateStockByResponse(Stock stock, BufferedReader bufferedReader) {
        String[] stockInfoList;
        LocalDate today = LocalDate.now();// set this up however you need it.
        DayOfWeek dow = today.getDayOfWeek();

        if (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY ) {
            System.out.println("today is not a working day");
            return;
        }

        try {
            stockInfoList = bufferedReader.readLine().split(",");
            if (!stockInfoList[0].equals("N/A"))
                stock.setAsk(Double.valueOf(stockInfoList[0]));
            if (!stockInfoList[1].equals("N/A"))
                stock.setBid(Double.valueOf(stockInfoList[1]));
            if (!stockInfoList[2].equals("N/A"))
                stock.setOpenPrice(today, Double.valueOf(stockInfoList[2]));
            if (!stockInfoList[3].equals("N/A"))
                stock.setClosingPrice(today, Double.valueOf(stockInfoList[3]));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }








}

