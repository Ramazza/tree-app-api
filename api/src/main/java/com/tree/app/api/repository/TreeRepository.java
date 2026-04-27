package com.tree.app.api.repository;

import com.tree.app.api.model.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TreeRepository extends JpaRepository<Tree, Long> {
    List<Tree> findByLocalId(Long localId);
}