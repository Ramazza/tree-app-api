package com.tree.app.api.service;

import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.model.entity.Local;
import com.tree.app.api.repository.TreeRepository;
import com.tree.app.api.repository.LocalRepository;

import org.springframework.stereotype.Service;

import com.tree.app.api.dto.tree.TreeResponse;
import com.tree.app.api.dto.tree.TreeCreateRequest;
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
    public TreeResponse create(Long localId, TreeCreateRequest request) {
        Local local = localRepository.findById(localId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        Tree tree = new Tree();

        tree.setSpecies(request.getSpecies());
        tree.setLatitude(request.getLatitude());
        tree.setLongitude(request.getLongitude());
        tree.setPlantedAt(request.getPlantedAt());

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
            dto.setPlantedAt(tree.getPlantedAt());

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

        if (updatedTree.getLatitude() != null) {
            tree.setLatitude(updatedTree.getLatitude());
        }

        if (updatedTree.getLongitude() != null) {
            tree.setLongitude(updatedTree.getLongitude());
        }
        
        if (updatedTree.getPlantedAt() != null) {
            tree.setPlantedAt(updatedTree.getPlantedAt());
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
        dto.setLatitude(tree.getLatitude());
        dto.setLongitude(tree.getLongitude());
        dto.setPlantedAt(tree.getPlantedAt());
        dto.setCreatedAt(tree.getCreatedAt());
        dto.setUpdatedAt(tree.getUpdatedAt());

        LocalDetailedResponse localDto = new LocalDetailedResponse();
        localDto.setId(tree.getLocal().getId());
        localDto.setName(tree.getLocal().getName());
        localDto.setDescription(tree.getLocal().getDescription());
        localDto.setAddress(tree.getLocal().getAddress());
        localDto.setCreatedAt(tree.getLocal().getCreatedAt());
        localDto.setUpdatedAt(tree.getLocal().getUpdatedAt());

        ProjectSimpleResponse projectDto = new ProjectSimpleResponse();
        projectDto.setId(tree.getLocal().getProject().getId());
        projectDto.setName(tree.getLocal().getProject().getName());
        projectDto.setDescription(tree.getLocal().getProject().getDescription());
        projectDto.setStatus(tree.getLocal().getProject().getStatus());

        localDto.setProject(projectDto);
        dto.setLocal(localDto);

        return dto;
    }

    private TreeResponse toSimpleDto(Tree tree) {
        TreeResponse dto = new TreeResponse();

        dto.setId(tree.getId());
        dto.setSpecies(tree.getSpecies());
        dto.setLatitude(tree.getLatitude());
        dto.setLongitude(tree.getLongitude());
        dto.setPlantedAt(tree.getPlantedAt());
        dto.setCreatedAt(tree.getCreatedAt());
        dto.setUpdatedAt(tree.getUpdatedAt());

        return dto;
    }
}