package com.demo.springboot.demosecurity.controller;

import com.demo.springboot.demosecurity.entity.Member;
import com.demo.springboot.demosecurity.entity.Role;
import com.demo.springboot.demosecurity.repository.MembersRepository;
import com.demo.springboot.demosecurity.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

    private MembersRepository membersRepository;
    private RolesRepository rolesRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public DemoController(MembersRepository theMembersRepository, RolesRepository theRolesRepository , BCryptPasswordEncoder thePasswordEncoder) {
        membersRepository = theMembersRepository;
        rolesRepository = theRolesRepository;
        passwordEncoder = thePasswordEncoder;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    // add a request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    // add a request mapping for /systems
    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

    @GetMapping("/add-user-form")
    public String showAddForm(Model theModel) {
        theModel.addAttribute("member", new Member());
        theModel.addAttribute("role", new Role());
        return "add-user-form";
    }

    @PostMapping("/saveUser")
    public String add(@ModelAttribute Member theMember, @ModelAttribute Role theRole) {

        theMember.setPassword(passwordEncoder.encode(theMember.getPassword()));
        theMember.setActive(true);
        membersRepository.save(theMember);

        // Manually set the user_id for theRole
        theRole.setUser_id(theMember.getUser_id());
        theRole.setRole("ROLE_" + theRole.getRole());
        rolesRepository.save(theRole);

        return "redirect:/";
    }
}
