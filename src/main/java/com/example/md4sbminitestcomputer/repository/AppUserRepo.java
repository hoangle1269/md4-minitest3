package com.example.md4sbminitestcomputer.repository;

import com.example.md4sbminitestcomputer.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByAppUserName(String name);
}
