package com.tree.app.api.repository;

import com.tree.app.api.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}