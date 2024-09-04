package com.example.md4sbminitestcomputer.controller;

import com.example.md4sbminitestcomputer.model.Computer;
import com.example.md4sbminitestcomputer.model.ComputerForm;
import com.example.md4sbminitestcomputer.model.Manufacturer;
import com.example.md4sbminitestcomputer.service.computer.IComputerService;
import com.example.md4sbminitestcomputer.service.manufacturer.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/computers")
public class ComputerController {
    @Autowired
    private IComputerService computerService;

    @Autowired
    private IManufacturerService manufacturerService;

    @GetMapping
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/computer/list");
        modelAndView.addObject("computers", computerService.findAll());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String upload;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/computer/create");
        modelAndView.addObject("computer", new Computer());
        return modelAndView;
    }
//
//    @PostMapping("/create")
//    public ModelAndView saveCustomer(@ModelAttribute("computer") Computer computer) {
//        computerService.save(computer);
//        ModelAndView modelAndView = new ModelAndView("/computer/create");
//        modelAndView.addObject("computer", new Computer());
//        modelAndView.addObject("message", "New computer created successfully");
//        return modelAndView;
//    }

    @PostMapping("/save")
    public String save(ComputerForm computerForm) {
        return getComputerInfo(computerForm);

    }


    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Computer> computer = computerService.findById(id);
        if (computer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/computer/update");
            modelAndView.addObject("computer", computer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }
//
//    @PostMapping("/update")
//    public ModelAndView updateCustomer(@ModelAttribute("computer") Computer computer) {
//        computerService.save(computer);
//        ModelAndView modelAndView = new ModelAndView("/computer/update");
//        modelAndView.addObject("computer", computer);
//        modelAndView.addObject("message", "Computer updated successfully");
//        return modelAndView;
//    }

    @PostMapping("/update")
    public String update(ComputerForm computerForm) {
        return getComputerInfo(computerForm);

    }

    private String getComputerInfo(ComputerForm computerForm) {
        MultipartFile file = computerForm.getImg();

        String fileName = file.getOriginalFilename();

        try {
            FileCopyUtils.copy(file.getBytes(), new File(upload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            Computer computer = new Computer();
            computer.setComputerId(computerForm.getComputerId());
            computer.setComputerCode(computerForm.getComputerCode());
            computer.setComputerName(computerForm.getComputerName());
            computer.setPrice(String.valueOf(computerForm.getPrice()));
            computer.setManufacturer(computerForm.getManufacturerId());
            computer.setDescription(computerForm.getDescription());
            computer.setImg(fileName);
            computerService.save(computer);
            return "redirect:/computers";
        }
    }


    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Computer> computer = computerService.findById(id);
        if (computer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/computer/delete");
            modelAndView.addObject("computer", computer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Computer computer) {
        computerService.remove(computer.getComputerId());
        return "redirect:/computers";
    }

}
