package com.tree.app.api.dto.tree;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "species",
    "height",
    "diameter",
    "status",
    "photoUrl",
})

public class TreeResponse {
    private Long id;

    private String species;
    private Double height;
    private Double diameter;
    private String status;
    private String photoUrl;


    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
