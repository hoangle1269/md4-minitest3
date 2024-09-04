package com.example.md4sbminitestcomputer.service.manufacturer;

import com.example.md4sbminitestcomputer.model.Manufacturer;
import com.example.md4sbminitestcomputer.model.dto.ICountManufacturer;
import com.example.md4sbminitestcomputer.service.IGenerateService;

public interface IManufacturerService extends IGenerateService<Manufacturer> {
    void deleteManufacturerById(Long id);

    Iterable<ICountManufacturer> getNumbersOfManufacturer();
}
