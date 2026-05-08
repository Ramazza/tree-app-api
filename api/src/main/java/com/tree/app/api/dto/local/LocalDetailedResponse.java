package com.tree.app.api.dto.local;

import com.tree.app.api.dto.project.ProjectSimpleResponse;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "name",
    "description",
    "address",
    "createdAt",
    "updatedAt",
    "project",
})

public class LocalDetailedResponse {
    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProjectSimpleResponse project;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public ProjectSimpleResponse getProject() { return project; }
    public void setProject(ProjectSimpleResponse project) { this.project = project; }
}
