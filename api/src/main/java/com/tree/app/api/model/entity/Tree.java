package com.tree.app.api.model.entity;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tree")
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "species", nullable = false)
    private String species;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "planted_at", nullable = false)
    private LocalDate plantedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "tree")
    private List<TreeMeasurement> measurements;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false)
    private Local local;

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

    public List<TreeMeasurement> getMeasurements() { return measurements; }
    public void setMeasurements(List<TreeMeasurement> measurements) { this.measurements = measurements; }

    public Local getLocal() { return local; }
    public void setLocal(Local local) { this.local = local; }
}