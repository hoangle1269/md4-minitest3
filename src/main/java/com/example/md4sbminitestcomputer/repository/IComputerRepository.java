package com.example.md4sbminitestcomputer.repository;

import com.example.md4sbminitestcomputer.model.Computer;
import com.example.md4sbminitestcomputer.model.Manufacturer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends JpaRepository<Computer, Long> {

    Iterable<Computer> findAllByManufacturer(Manufacturer manufacturer);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByComputerNameContaining(Pageable pageable, String computerName);
}
