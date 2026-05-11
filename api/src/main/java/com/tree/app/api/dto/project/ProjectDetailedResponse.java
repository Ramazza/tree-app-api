package com.tree.app.api.dto.project;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "name",
    "status",
    "description",
    "created_at",
    "updated_at",
})

public class ProjectDetailedResponse {
    private Long id;
    private String name;
    private String status;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public LocalDate getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDate updatedAt) { this.updatedAt = updatedAt; }
}
