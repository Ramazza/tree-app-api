package com.tree.app.api.controller;

import com.tree.app.api.dto.tree.TreeCreateRequest;
import com.tree.app.api.dto.tree.TreeDetailedResponse;
import com.tree.app.api.dto.tree.TreeListResponse;
import com.tree.app.api.dto.tree.TreeResponse;
import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.service.TreeService;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Validated
@RestController
@RequestMapping("projects/{projectId}/locals/{localId}/trees")
public class TreeController {

    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    // Create a tree
    @PostMapping
    public TreeResponse create(@PathVariable Long localId, @Valid @RequestBody TreeCreateRequest request) {
        return service.create(localId, request);
    }

    // List all trees
    @GetMapping
    public List<TreeListResponse> list(@PathVariable Long localId) {
        return service.findByLocal(localId);
    }

    // List a specific tree
    @GetMapping("/{id}")
    public TreeDetailedResponse findById(@PathVariable Long localId, @PathVariable Long id) {
        return service.findByIdAndLocal(id, localId);
    }

    // Updates a tree
    @PatchMapping("/{id}")
    public TreeResponse updateTree(@PathVariable Long id, @PathVariable Long localId, @RequestBody Tree updatedTree){
        return service.updateTree(id, localId, updatedTree);
    }

    // Deletes a tree
    @DeleteMapping("/{id}")
    public void deleteTree(@PathVariable Long id, @PathVariable Long localId) {
        service.deleteTree(id, localId);
    }
}