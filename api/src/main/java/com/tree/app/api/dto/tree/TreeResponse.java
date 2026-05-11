package com.tree.app.api.dto.tree;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "species",
    "latitude",
    "longitude",
    "plantedAt",
    "createdAt",
    "updatedAt",
})

public class TreeResponse {
    private Long id;

    private String species;
    private Double latitude;
    private Double longitude;
    private LocalDate plantedAt;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public LocalDate getPlantedAt() { return plantedAt; }
    public void setPlantedAt(LocalDate plantedAt) { this.plantedAt = plantedAt; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public LocalDate getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDate updatedAt) { this.updatedAt = updatedAt; }
}
