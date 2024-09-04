package com.example.md4sbminitestcomputer.repository;

import com.example.md4sbminitestcomputer.model.Manufacturer;
import com.example.md4sbminitestcomputer.model.dto.ICountManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    @Modifying
    @Transactional
    @Query(value = "CALL deletemanufacturerbyid(:id)", nativeQuery = true)
    void deleteManufacturerById(@Param("id")Long manufacturerId);

    @Query(nativeQuery = true, value = "CALL countNumbersOfManufacturer()")
    Iterable<ICountManufacturer> getNumbersOfManufacturer();

}
