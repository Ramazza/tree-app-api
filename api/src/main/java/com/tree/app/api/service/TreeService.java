package com.tree.app.api.service;

import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.model.entity.Local;
import com.tree.app.api.repository.TreeRepository;

import jakarta.persistence.Column;

import com.tree.app.api.repository.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    private final TreeRepository treeRepository;
    private final LocalRepository localRepository;

    public TreeService(TreeRepository treeRepository, LocalRepository localRepository) {
        this.treeRepository = treeRepository;
        this.localRepository = localRepository;
    }

    //Create a tree
    public Tree create(Long localId, Tree tree) {
        Local local = localRepository.findById(localId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        tree.setLocal(local);
        return treeRepository.save(tree);
    }

    // List the trees
    public List<Tree> findByLocal(Long localId) {
        return treeRepository.findByLocalId(localId);
    }

    // List a specific tree
    public Tree findByIdAndLocal(Long id, Long localId) {
        return treeRepository.findByIdAndLocalId(id, localId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado neste projeto"));
    }

    // Update a tree
    public Tree updateTree(Long id, Long localId, Tree updatedTree) {
        Tree tree = findByIdAndLocal(id, localId);

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

        return treeRepository.save(tree);
    }

    // Delete a tree
    public void deleteTree(Long id, Long localId) {
        Tree tree = findByIdAndLocal(id, localId);
        treeRepository.delete(tree);
    }
}