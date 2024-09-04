package com.example.md4sbminitestcomputer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "computer")
@Data
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;

    private String computerCode;
    private String computerName;
    private String price;
    private String description;
    private String img;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

}
