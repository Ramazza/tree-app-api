package com.tree.app.api.service;

import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.model.entity.Local;
import com.tree.app.api.repository.TreeRepository;
import com.tree.app.api.repository.LocalRepository;

import org.springframework.stereotype.Service;

import com.tree.app.api.dto.tree.TreeResponse;
import com.tree.app.api.dto.tree.TreeDetailedResponse;
import com.tree.app.api.dto.tree.TreeListResponse;
import com.tree.app.api.dto.project.ProjectSimpleResponse;
import com.tree.app.api.dto.local.LocalDetailedResponse;

import java.util.List;

@Service
public class TreeService {

    private final TreeRepository treeRepository;
    private final LocalRepository localRepository;

    public TreeService(TreeRepository treeRepository, LocalRepository localRepository) {
        this.treeRepository = treeRepository;
        this.localRepository = localRepository;
    }

    // CREATE Tree (DTO)
    public TreeResponse create(Long localId, TreeResponse response) {
        Local local = localRepository.findById(localId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        Tree tree = new Tree();

        tree.setSpecies(response.getSpecies());
        tree.setHeight(response.getHeight());
        tree.setDiameter(response.getDiameter());
        tree.setStatus(response.getStatus());
        tree.setPhotoUrl(response.getPhotoUrl());

        tree.setLocal(local);

        Tree savedTree = treeRepository.save(tree);

        return toSimpleDto(savedTree);
    }

    
    // LIST Tress (DTO)
    public List<TreeListResponse> findByLocal(Long localId) {
        List<Tree> trees = treeRepository.findByLocalId(localId);

        return trees.stream().map(tree -> {
            TreeListResponse dto = new TreeListResponse();

            dto.setId(tree.getId());
            dto.setSpecies(tree.getSpecies());
            dto.setStatus(tree.getStatus());

            return dto;
        }).toList();
    }

    // GET Tree (DTO)
    public TreeDetailedResponse findByIdAndLocal(Long id, Long localId) {
        Tree tree = findEntityByIdAndLocal(id, localId); 

        return toDto(tree);
    }

    // UPDATE Tree (DTO)
    public TreeResponse updateTree(Long id, Long localId, Tree updatedTree) {

        Tree tree = findEntityByIdAndLocal(id, localId); 

        if (updatedTree.getSpecies() != null) {
            tree.setSpecies(updatedTree.getSpecies());
        }

        if (updatedTree.getHeight() != null) {
            tree.setHeight(updatedTree.getHeight());
        }

        if (updatedTree.getDiameter() != null) {
            tree.setDiameter(updatedTree.getDiameter());
        }
        
        if (updatedTree.getStatus() != null) {
            tree.setStatus(updatedTree.getStatus());
        }

        if (updatedTree.getPhotoUrl() != null) {
            tree.setPhotoUrl(updatedTree.getPhotoUrl());
        }

        Tree savedTree = treeRepository.save(tree);

        return toSimpleDto(savedTree);
    }

    // DELETE Tree (Entity)
    public void deleteTree(Long id, Long localId) {
        Tree tree = findEntityByIdAndLocal(id, localId);

        treeRepository.delete(tree);
    }

    // INTERNAL METHOD (Entity)
    private Tree findEntityByIdAndLocal(Long id, Long localId) {
        return treeRepository.findByIdAndLocalId(id, localId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado neste projeto"));
    }

    // MAPPER (Entity → DTO)
    private TreeDetailedResponse toDto(Tree tree) {
        TreeDetailedResponse dto = new TreeDetailedResponse();

        dto.setId(tree.getId());
        dto.setSpecies(tree.getSpecies());
        dto.setHeight(tree.getHeight());
        dto.setDiameter(tree.getDiameter());
        dto.setStatus(tree.getStatus());
        dto.setPhotoUrl(tree.getPhotoUrl());

        LocalDetailedResponse localDto = new LocalDetailedResponse();
        localDto.setId(tree.getLocal().getId());
        localDto.setName(tree.getLocal().getName());

        ProjectSimpleResponse projectDto = new ProjectSimpleResponse();
        projectDto.setId(tree.getLocal().getProject().getId());
        projectDto.setName(tree.getLocal().getProject().getName());
        projectDto.setDescription(tree.getLocal().getProject().getDescription());

        localDto.setProject(projectDto);
        dto.setLocal(localDto);

        return dto;
    }

    private TreeResponse toSimpleDto(Tree tree) {
        TreeResponse dto = new TreeResponse();

        dto.setId(tree.getId());
        dto.setSpecies(tree.getSpecies());
        dto.setHeight(tree.getHeight());
        dto.setDiameter(tree.getDiameter());
        dto.setStatus(tree.getStatus());
        dto.setPhotoUrl(tree.getPhotoUrl());

        return dto;
    }
}