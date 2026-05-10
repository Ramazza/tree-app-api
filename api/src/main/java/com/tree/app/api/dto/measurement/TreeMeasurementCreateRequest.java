package com.tree.app.api.dto.measurement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TreeMeasurementCreateRequest {
    
    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Height is required")
    private Double height;

    @NotNull(message = "Diameter is required")
    private Double diameter;
    
    private String notes;
    private String photoUrl;

    // GETTERS & SETTERS

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getDiameter() { return diameter; }
    public void setDiameter(Double diameter) { this.diameter = diameter; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
}
