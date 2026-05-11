package com.tree.app.api.dto.tree;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "species",
    "plantedAt"
})

public class TreeListResponse {

    private Long id;
    private String species;
    private LocalDate plantedAt;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public LocalDate getPlantedAt() { return plantedAt; }
    public void setPlantedAt(LocalDate plantedAt) { this.plantedAt = plantedAt; }

}