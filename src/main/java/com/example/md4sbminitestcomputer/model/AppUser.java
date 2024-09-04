package com.example.md4sbminitestcomputer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appUserId;

    private String appUserName;

    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;
}