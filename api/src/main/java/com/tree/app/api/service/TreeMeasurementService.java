package com.tree.app.api.service;

import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.model.entity.TreeMeasurement;
import com.tree.app.api.repository.TreeRepository;
import com.tree.app.api.repository.TreeMeasurementRepository;

import org.springframework.stereotype.Service;

import com.tree.app.api.dto.measurement.TreeMeasurementResponse;
import com.tree.app.api.dto.project.ProjectSimpleResponse;
import com.tree.app.api.dto.local.LocalDetailedResponse;
import com.tree.app.api.dto.measurement.TreeMeasurementCreateRequest;
import com.tree.app.api.dto.measurement.TreeMeasurementDetailedResponse;
import com.tree.app.api.dto.measurement.TreeMeasurementListResponse;
import com.tree.app.api.dto.tree.TreeDetailedResponse;

import java.util.List;

@Service
public class TreeMeasurementService {

    private final TreeMeasurementRepository measurementRepository;
    private final TreeRepository treeRepository;

    public TreeMeasurementService(TreeMeasurementRepository measurementRepository,
                              TreeRepository treeRepository) {
        this.measurementRepository = measurementRepository;
        this.treeRepository = treeRepository;
    }

    // CREATE Measurement
    public TreeMeasurementResponse create(Long treeId, TreeMeasurementCreateRequest request) {

        Tree tree = treeRepository.findById(treeId)
                .orElseThrow(() -> new RuntimeException("Árvore não encontrada"));

        TreeMeasurement measurement = new TreeMeasurement();

        measurement.setStatus(request.getStatus());
        measurement.setHeight(request.getHeight());
        measurement.setDiameter(request.getDiameter());
        measurement.setNotes(request.getNotes());
        measurement.setPhotoUrl(request.getPhotoUrl());

        measurement.setTree(tree);

        TreeMeasurement saved = measurementRepository.save(measurement);

        return toSimpleDto(saved);
    }

    // LIST Measurements by Tree
    public List<TreeMeasurementListResponse> findByTree(Long treeId) {
        List<TreeMeasurement> measurements = measurementRepository.findByTreeId(treeId);

        return measurements.stream().map(m -> {
            TreeMeasurementListResponse dto = new TreeMeasurementListResponse();

            dto.setId(m.getId());
            dto.setHeight(m.getHeight());
            dto.setDiameter(m.getDiameter());
            dto.setStatus(m.getStatus());
            dto.setPhotoUrl(m.getPhotoUrl());
            dto.setCreatedAt(m.getCreatedAt());
            dto.setNotes(m.getNotes());

            return dto;
        }).toList();
    }

    // GET Measurement
    public TreeMeasurementDetailedResponse findByIdAndTree(Long id, Long treeId) {
        TreeMeasurement measurement = findEntityByIdAndTree(id, treeId);

        return toDto(measurement);
    }

    // UPDATE Measurement
    public TreeMeasurementResponse update(Long id, Long treeId, TreeMeasurement updated) {

        TreeMeasurement measurement = findEntityByIdAndTree(id, treeId);

        if (updated.getStatus() != null) {
            measurement.setStatus(updated.getStatus());
        }

        if (updated.getHeight() != null) {
            measurement.setHeight(updated.getHeight());
        }

        if (updated.getDiameter() != null) {
            measurement.setDiameter(updated.getDiameter());
        }

        if (updated.getPhotoUrl() != null) {
            measurement.setPhotoUrl(updated.getPhotoUrl());
        }

        if (updated.getNotes() != null) {
            measurement.setNotes(updated.getNotes());
        }

        TreeMeasurement saved = measurementRepository.save(measurement);

        return toSimpleDto(saved);
    }

    // DELETE Measurement
    public void delete(Long id, Long treeId) {
        TreeMeasurement measurement = findEntityByIdAndTree(id, treeId);

        measurementRepository.delete(measurement);
    }

    // INTERNAL
    private TreeMeasurement findEntityByIdAndTree(Long id, Long treeId) {
        return measurementRepository.findByIdAndTreeId(id, treeId)
                .orElseThrow(() -> new RuntimeException("Measurement não encontrada para esta árvore"));
    }

    // MAPPER Detailed
    private TreeMeasurementDetailedResponse toDto(TreeMeasurement m) {
        TreeMeasurementDetailedResponse dto = new TreeMeasurementDetailedResponse();

        dto.setId(m.getId());
        dto.setHeight(m.getHeight());
        dto.setDiameter(m.getDiameter());
        dto.setStatus(m.getStatus());
        dto.setPhotoUrl(m.getPhotoUrl());
        dto.setCreatedAt(m.getCreatedAt());
        dto.setNotes(m.getNotes());

        TreeDetailedResponse treeDto = new TreeDetailedResponse();
        treeDto.setId(m.getTree().getId());
        treeDto.setSpecies(m.getTree().getSpecies());
        treeDto.setLatitude(m.getTree().getLatitude());
        treeDto.setLongitude(m.getTree().getLongitude());
        treeDto.setPlantedAt(m.getTree().getPlantedAt());
        treeDto.setCreatedAt(m.getTree().getCreatedAt());
        treeDto.setUpdatedAt(m.getTree().getUpdatedAt());

        LocalDetailedResponse localDto = new LocalDetailedResponse();
        localDto.setId(m.getTree().getLocal().getId());
        localDto.setName(m.getTree().getLocal().getName());
        localDto.setDescription(m.getTree().getLocal().getDescription());
        localDto.setAddress(m.getTree().getLocal().getAddress());
        localDto.setCreatedAt(m.getTree().getLocal().getCreatedAt());
        localDto.setUpdatedAt(m.getTree().getLocal().getUpdatedAt());

        ProjectSimpleResponse projectDto = new ProjectSimpleResponse();
        projectDto.setId(m.getTree().getLocal().getProject().getId());
        projectDto.setName(m.getTree().getLocal().getProject().getName());
        projectDto.setDescription(m.getTree().getLocal().getProject().getDescription());
        projectDto.setStatus(m.getTree().getLocal().getProject().getStatus());

        localDto.setProject(projectDto);
        treeDto.setLocal(localDto);

        dto.setTree(treeDto);

        return dto;
    }

    // MAPPER Simple
    private TreeMeasurementResponse toSimpleDto(TreeMeasurement m) {
        TreeMeasurementResponse dto = new TreeMeasurementResponse();

        dto.setId(m.getId());
        dto.setHeight(m.getHeight());
        dto.setDiameter(m.getDiameter());
        dto.setStatus(m.getStatus());
        dto.setCreatedAt(m.getCreatedAt());
        dto.setNotes(m.getNotes());
        dto.setPhotoUrl(m.getPhotoUrl());

        return dto;
    }
}