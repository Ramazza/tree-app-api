package com.tree.app.api.service;

import com.tree.app.api.model.entity.Tree;
import com.tree.app.api.model.entity.Local;
import com.tree.app.api.repository.TreeRepository;
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

    public Tree create(Long localId, Tree tree) {
        Local local = localRepository.findById(localId)
                .orElseThrow(() -> new RuntimeException("Local não encontrado"));

        tree.setLocal(local);
        return treeRepository.save(tree);
    }

    public List<Tree> findByLocal(Long localId) {
        return treeRepository.findByLocalId(localId);
    }
}