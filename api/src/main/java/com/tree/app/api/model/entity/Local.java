package com.tree.app.api.model.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "local")
    private List<Tree> trees;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}