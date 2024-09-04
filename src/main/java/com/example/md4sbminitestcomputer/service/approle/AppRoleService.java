package com.example.md4sbminitestcomputer.service.approle;

import com.example.md4sbminitestcomputer.model.AppRole;
import com.example.md4sbminitestcomputer.repository.AppRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private AppRoleRepo appRoleRepo;

    @Override
    public Iterable<AppRole> findAll() {
        return appRoleRepo.findAll();
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return appRoleRepo.findById(id);
    }

    @Override
    public AppRole findByAppRoleName(String name) {
        return appRoleRepo.findByAppRoleName(name);
    }

    @Override
    public void save(AppRole appRole) {
        appRoleRepo.save(appRole);
    }

    @Override
    public void remove(Long id) {
        appRoleRepo.deleteById(id);
    }
}