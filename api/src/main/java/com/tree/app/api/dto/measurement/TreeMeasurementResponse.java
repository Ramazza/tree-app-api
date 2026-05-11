package com.tree.app.api.dto.measurement;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "status",
    "createdAt",
    "photoUrl"
})

public class TreeMeasurementResponse {
    
    private Long id;
    private Double height;
    private Double diameter;
    private String status;
    private LocalDate createdAt;
    private String photoUrl;
    private String notes;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getDiameter() { return diameter; }
    public void setDiameter(Double diameter) { this.diameter = diameter; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
