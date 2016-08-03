package com.tripPropper.converters;


import com.tripPropper.business.models.StrategyInfo;
import com.tripPropper.database.entities.StrategyEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.List;
import java.lang.Iterable;
/**
 * Created by xy30164 on 8/2/2016.
 */

@Component
public class EntityDtoConverter {


    public StrategyInfo entityToDto(StrategyEntity strategyEntity) {
        return new ModelMapper().map(strategyEntity, StrategyInfo.class);
    }

    public List<StrategyInfo> entitiesToDtos(Iterable<StrategyEntity> strategyEntities) {
        List<StrategyInfo> strategyInfos = new ArrayList<>();
        strategyEntities.forEach(strategyEntity -> strategyInfos.add(entityToDto(strategyEntity)));

        return strategyInfos;
    }

    public StrategyEntity DtoToEntity(StrategyInfo strategyInfo) {
        return new ModelMapper().map(strategyInfo, StrategyEntity.class);
    }


}
