package com.tree.app.api.dto.tree;

import java.time.LocalDateTime;

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
    private LocalDateTime plantedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public LocalDateTime getPlantedAt() { return plantedAt; }
    public void setPlantedAt(LocalDateTime plantedAt) { this.plantedAt = plantedAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
