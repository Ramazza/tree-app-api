package com.tree.app.api.dto.measurement;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.tree.app.api.dto.tree.TreeDetailedResponse;

@JsonPropertyOrder({
    "id",
    "height",
    "diameter",
    "status",
    "photoUrl",
    "createdAt",
    "notes",
    "tree"
})

public class TreeMeasurementDetailedResponse {
    
    private Long id;
    private Double height;
    private Double diameter;
    private String status;
    private String photoUrl;
    private LocalDateTime createdAt;
    private String notes;
    
    private TreeDetailedResponse tree;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getDiameter() { return diameter; }
    public void setDiameter(Double diameter) { this.diameter = diameter; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public TreeDetailedResponse getTree() { return tree; }
    public void setTree(TreeDetailedResponse tree) { this.tree = tree; }
}
