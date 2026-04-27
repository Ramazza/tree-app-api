package com.tree.app.api.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tree")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String species;

    private Double height;
    private Double diameter;
    private String status;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false)
    private Local local;

    public Long getId() {
        return id;
    }

    public Local getLocal() {
        return local;
    }

    public String getSpecies() {
        return species;
    }

    public Double getHeight() {
        return height;
    }

    public Double getDiameter() {
        return diameter;
    }

    public String getStatus() {
        return status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}