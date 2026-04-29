package com.tree.app.api.repository;

import com.tree.app.api.model.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {
    List<Local> findByProjectId(Long projectId);
    Optional<Local> findByIdAndProjectId(Long id, Long projectId);
}