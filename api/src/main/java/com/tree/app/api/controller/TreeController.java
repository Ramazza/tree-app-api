package com.tree.app.api.controller;

import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.repository.LocalRepository;
import com.tree.app.api.repository.TreeRepository;
import com.tree.app.api.service.TreeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("projects/{projectId}/locals/{localId}/trees")
public class TreeController {

    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    // Create a tree
    @PostMapping
    public Tree create(@PathVariable Long localId, @RequestBody Tree tree) {
        return service.create(localId, tree);
    }

    // List all trees
    @GetMapping
    public List<Tree> list(@PathVariable Long localId) {
        return service.findByLocal(localId);
    }

    // List a specific tree
    @GetMapping("/{id}")
    public Tree findById(@PathVariable Long localId, @PathVariable Long id) {
        return service.findByIdAndLocal(id, localId);
    }

    // Updates a tree
    @PatchMapping("/{id}")
    public Tree updateTree(@PathVariable Long id, @PathVariable Long localId, @RequestBody Tree updatedTree){
        return service.updateTree(id, localId, updatedTree);
    }

    // Deletes a tree
    @DeleteMapping("/{id}")
    public void deleteTree(@PathVariable Long id, @PathVariable Long localId) {
        service.deleteTree(id, localId);
    }
}