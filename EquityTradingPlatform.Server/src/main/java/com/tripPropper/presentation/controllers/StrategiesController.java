package com.tripPropper.presentation.controllers;

import com.tripPropper.business.api.StrategiesManager;
import com.tripPropper.business.models.StrategyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xy30164 on 8/2/2016.
 */

@RestController
public class StrategiesController {

    @Autowired
    private StrategiesManager strategiesManager;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StrategyInfo> getAllStrategyInfo() {
        return  strategiesManager.getAllStrategyInfo();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public StrategyInfo getStrategyInfoByID(@PathVariable("id") int id) {
        return strategiesManager.getStrategyInfoByID(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void addStrategy(@RequestBody StrategyInfo strategyInfo) {
        strategiesManager.addNewStrategyByInfo(strategyInfo);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void removeStrategyByID(@PathVariable("id") int id) {
        strategiesManager.deactivateStrategyByID(id);
    }


//    @RequestMapping(method=RequestMethod.PUT, consumes="application/json")
//    public void update(@RequestBody StrategyInfo strategyInfo) {
//
//    }

}
