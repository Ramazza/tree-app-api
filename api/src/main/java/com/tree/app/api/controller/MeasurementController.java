package com.tree.app.api.controller;

import com.tree.app.api.dto.measurement.TreeMeasurementCreateRequest;
import com.tree.app.api.dto.measurement.TreeMeasurementDetailedResponse;
import com.tree.app.api.dto.measurement.TreeMeasurementListResponse;
import com.tree.app.api.dto.measurement.TreeMeasurementResponse;
import com.tree.app.api.model.entity.TreeMeasurement;
import com.tree.app.api.service.TreeMeasurementService;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Validated
@RestController
@RequestMapping("projects/{projectId}/locals/{localId}/trees/{treeId}/measurements")
public class MeasurementController {

    private final TreeMeasurementService service;

    public MeasurementController(TreeMeasurementService service) {
        this.service = service;
    }

    // CREATE measurement
    @PostMapping
    public TreeMeasurementResponse create(
            @PathVariable Long treeId,
            @Valid @RequestBody TreeMeasurementCreateRequest request) {

        return service.create(treeId, request);
    }

    // LIST measurements
    @GetMapping
    public List<TreeMeasurementListResponse> list(
            @PathVariable Long treeId) {

        return service.findByTree(treeId);
    }

    // GET specific measurement
    @GetMapping("/{id}")
    public TreeMeasurementDetailedResponse findById(
            @PathVariable Long treeId,
            @PathVariable Long id) {

        return service.findByIdAndTree(id, treeId);
    }

    // UPDATE measurement
    @PatchMapping("/{id}")
    public TreeMeasurementResponse update(
            @PathVariable Long id,
            @PathVariable Long treeId,
            @RequestBody TreeMeasurement updatedMeasurement) {

        return service.update(id, treeId, updatedMeasurement);
    }

    // DELETE measurement
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id,
            @PathVariable Long treeId) {

        service.delete(id, treeId);
    }
}