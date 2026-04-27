package com.tree.app.api.controller;

import com.tree.app.api.model.entity.Local;
import com.tree.app.api.service.LocalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projects/{projectId}/locals")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    @PostMapping
    public Local create(@PathVariable Long projectId, @RequestBody Local local) {
        return service.create(projectId, local);
    }

    @GetMapping
    public List<Local> list(@PathVariable Long projectId) {
        return service.findByProject(projectId);
    }
}