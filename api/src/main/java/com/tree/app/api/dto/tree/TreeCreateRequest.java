package com.tree.app.api.dto.tree;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TreeCreateRequest {
    @NotBlank(message = "Species is required")
    private String species;

    @NotNull(message = "Height is required")
    @Positive(message = "Height must be greater than 0")
    private Double height;

    @NotNull(message = "Diameter is required")
    @Positive(message = "Diameter must be greater than 0")
    private Double diameter;

    @NotBlank(message = "Status is required")
    private String status;

    private String photoUrl;

    // GETTERS & SETTERS

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getDiameter() { return diameter; }
    public void setDiameter(Double diameter) { this.diameter = diameter; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
}
