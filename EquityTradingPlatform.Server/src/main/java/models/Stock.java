package models;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xy30164 on 7/29/2016.
 */
public class Stock {

    private String stockCode;

    private BlockingDeque<Double> asks;

    private BlockingDeque<Double> bids;

    private Double ask;

    private Double bid;

    private Map<LocalDate, Double> openPrices;

    private Map<LocalDate, Double> closingPrices;


    public Stock(String stockCode) {
        this.stockCode = stockCode;
        setMinAvgSize(10);
        this.closingPrices = new ConcurrentHashMap<>();
        this.openPrices = new ConcurrentHashMap<>();
    }

    public Stock(String stockCode, int longAvgMins) {
        this.stockCode = stockCode;
        setMinAvgSize(longAvgMins);
        this.closingPrices = new ConcurrentHashMap<>();
        this.openPrices = new ConcurrentHashMap<>();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setMinAvgSize(int longAvgMins) {
        int size = longAvgMins * 60;

        if (asks == null && bids == null) {
            asks = new LinkedBlockingDeque<>(size);
            bids = new LinkedBlockingDeque<>(size);
        } else {
            if (size > asks.size()) {
                BlockingDeque<Double> asks = new LinkedBlockingDeque<>(size);
                BlockingDeque<Double> bids = new LinkedBlockingDeque<>(size);
                this.bids.forEach(bids::add);
                this.asks.forEach(asks::add);
                this.bids = bids;
                this.asks = asks;
            }
        }
    }

    public void setAsk(double ask) {
        if (asks.remainingCapacity() == 0)
            asks.poll();
        asks.offer(ask);
        setCurrentAsk(ask);
    }

    public void setBid(double bid) {
        if (bids.remainingCapacity() == 0)
            bids.poll();
        bids.offer(bid);
        setCurrentBid(bid);
    }

    public Map<LocalDate, Double> getOpenPrices() {
        return openPrices;
    }

    public Map<LocalDate, Double> getClosingPrices() {
        return closingPrices;
    }

    public void setOpenPrice(LocalDate date, Double price) {
        openPrices.put(date, price);
    }

    public void setClosingPrice(LocalDate date, Double price) {
        closingPrices.put(date, price);
    }

    public synchronized double getBid() {
        return bid;
    }

    public synchronized double getAsk() {
        return ask;
    }

    private synchronized void setCurrentBid(double bid) {
        this.bid = bid;
    }

    private synchronized void setCurrentAsk(double ask) {
        this.ask = ask;
    }

















}
