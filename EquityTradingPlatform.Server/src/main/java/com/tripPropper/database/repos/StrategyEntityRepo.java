package com.tripPropper.database.repos;

import com.tripPropper.database.entities.StrategyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by xy30164 on 8/2/2016.
 */

@Repository
public interface StrategyEntityRepo extends CrudRepository<StrategyEntity, Integer> {
    Iterable<StrategyEntity> findByStatus(String status);

    Iterable<StrategyEntity> findByIsActive(Boolean IsActive);
}
