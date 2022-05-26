package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.jobhunt.repository.EmployerRepository;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping
    public String listAllEmployers(Model model) {
        model.addAttribute("employers", employerRepository.getAll());
        return "employers";
    }

    @GetMapping("/{id}")
    public String showEmployerDetailById(Model model, @PathVariable String id) {
        model.addAttribute("employer", employerRepository.findById(id));
        return "employer";
    }

    @GetMapping("/add")
    

    @PostMapping("/add")
    public 
}
