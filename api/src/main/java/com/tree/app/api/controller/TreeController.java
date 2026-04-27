package com.tree.app.api.controller;

import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.service.TreeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/locals/{localId}/trees")
public class TreeController {

    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    @PostMapping
    public Tree create(@PathVariable Long localId, @RequestBody Tree tree) {
        return service.create(localId, tree);
    }

    @GetMapping
    public List<Tree> list(@PathVariable Long localId) {
        return service.findByLocal(localId);
    }
}