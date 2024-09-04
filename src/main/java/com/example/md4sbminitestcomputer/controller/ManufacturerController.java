package com.example.md4sbminitestcomputer.controller;

import com.example.md4sbminitestcomputer.model.Manufacturer;
import com.example.md4sbminitestcomputer.model.dto.ICountManufacturer;
import com.example.md4sbminitestcomputer.service.computer.ComputerService;
import com.example.md4sbminitestcomputer.service.manufacturer.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private ComputerService computerService;

}

