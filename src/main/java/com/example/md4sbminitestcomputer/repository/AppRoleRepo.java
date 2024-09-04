package com.example.md4sbminitestcomputer.repository;

import com.example.md4sbminitestcomputer.model.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends CrudRepository<AppRole, Long> {
    AppRole findByAppRoleName(String name);
}
