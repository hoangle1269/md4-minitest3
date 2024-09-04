package com.example.md4sbminitestcomputer.service.computer;

import com.example.md4sbminitestcomputer.model.Computer;
import com.example.md4sbminitestcomputer.model.Manufacturer;
import com.example.md4sbminitestcomputer.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IComputerService extends IGenerateService<Computer> {
    Iterable<Computer> findAllByManufacturer(Manufacturer manufacturer);

    Page<Computer> findAll(Pageable pageable);

    Page<Computer> findAllByNameContaining(Pageable pageable, String computerName);
}
