package com.tree.app.api.repository;

import com.tree.app.api.model.entity.TreeMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<TreeMeasurement, Long>{
    
}
