package com.tripPropper.business.models;

/**
 * Created by xy30164 on 7/29/2016.
 */
public class StrategyInfo {

    private int id;

    private String stockCode;

    private String strategyType;

    private int longAvgMins;

    private int shortAvgMins;

    private int movingAvgDays;

    private int breakoutMins;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    public int getLongAvgMins() {
        return longAvgMins;
    }

    public void setLongAvgMins(int longAvgMins) {
        this.longAvgMins = longAvgMins;
    }

    public int getShortAvgMins() {
        return shortAvgMins;
    }

    public void setShortAvgMins(int shortAvgMins) {
        this.shortAvgMins = shortAvgMins;
    }

    public int getMovingAvgDays() {
        return movingAvgDays;
    }

    public void setMovingAvgDays(int movingAvgDays) {
        this.movingAvgDays = movingAvgDays;
    }

    public int getBreakoutMins() {
        return breakoutMins;
    }

    public void setBreakoutMins(int breakoutMins) {
        this.breakoutMins = breakoutMins;
    }
}
