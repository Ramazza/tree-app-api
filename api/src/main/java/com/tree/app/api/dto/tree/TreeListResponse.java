package com.tree.app.api.dto.tree;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "species",
    "status"
})

public class TreeListResponse {

    private Long id;
    private String species;
    private String status;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}