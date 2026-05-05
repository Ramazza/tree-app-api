package com.tree.app.api.dto.local;

import jakarta.validation.constraints.NotBlank;

public class LocalCreateRequest {

    @NotBlank(message = "Name is required")
    private String name;

    // GETTERS & SETTERS

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
