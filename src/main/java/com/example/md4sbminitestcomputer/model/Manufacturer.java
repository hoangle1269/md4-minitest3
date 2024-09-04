package com.example.md4sbminitestcomputer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "manufacturer")
@Data
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;

    private String manufacturerName;
}
