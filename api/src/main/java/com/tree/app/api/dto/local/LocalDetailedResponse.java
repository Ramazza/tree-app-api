package com.tree.app.api.dto.local;

import com.tree.app.api.dto.project.ProjectSimpleResponse;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "name",
})

public class LocalDetailedResponse {
    private Long id;
    private String name;

    private ProjectSimpleResponse project;

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ProjectSimpleResponse getProject() { return project; }
    public void setProject(ProjectSimpleResponse project) { this.project = project; }
}
