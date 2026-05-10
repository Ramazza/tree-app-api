package com.tree.app.api.repository;

import com.tree.app.api.model.entity.TreeMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TreeMeasurementRepository extends JpaRepository<TreeMeasurement, Long>{
    List<TreeMeasurement> findByTreeId(Long treeId);

    Optional<TreeMeasurement> findByIdAndTreeId(Long id, Long treeId);
}
