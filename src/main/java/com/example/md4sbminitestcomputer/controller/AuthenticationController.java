package com.example.md4sbminitestcomputer.controller;

import com.example.md4sbminitestcomputer.model.AppUser;
import com.example.md4sbminitestcomputer.service.approle.IAppRoleService;
import com.example.md4sbminitestcomputer.service.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

import static com.example.md4sbminitestcomputer.model.ROLE.ROLE_USER;
import com.example.md4sbminitestcomputer.model.AppRole;

@Controller
public class AuthenticationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IAppRoleService appRoleService;

    @GetMapping("/register")
    public String showRegisterForm( Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String showLoginForm(AppUser user) {
//        set role mac dinh la user
//        AppRole appRole = appRoleService.findByName("ROLE_USER");
        AppRole appRole = appRoleService.findByAppRoleName(ROLE_USER.toString());
        user.setRoles(Collections.singleton(appRole));

//        nhap password moi
        String newp = passwordEncoder.encode(user.getPassword());
        user.setPassword(newp);
        appUserService.save(user);

        return "redirect:/login";
    }

//    public String login() {
//        return "authen/login";
//    }
}