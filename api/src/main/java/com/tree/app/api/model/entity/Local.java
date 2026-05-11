package com.tree.app.api.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "local")
    private List<Tree> trees;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public LocalDate getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDate updatedAt) { this.updatedAt = updatedAt; }

    public List<Tree> getTrees() { return trees; }
    public void setTrees(List<Tree> trees) { this.trees = trees; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}