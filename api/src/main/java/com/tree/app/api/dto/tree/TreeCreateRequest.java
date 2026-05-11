package com.tree.app.api.dto.tree;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class TreeCreateRequest {
    @NotBlank(message = "Species is required")
    private String species;

    private Double latitude;
    private Double longitude;
    private LocalDate plantedAt;

    // GETTERS & SETTERS

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public LocalDate getPlantedAt() { return plantedAt; }
    public void setPlantedAt(LocalDate plantedAt) { this.plantedAt = plantedAt; }
}
