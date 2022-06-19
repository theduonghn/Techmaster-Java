package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.jobhunt.repository.EmployerRepo;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {
    @Autowired
    private EmployerRepo employerRepo;

    @GetMapping
    public String listAllEmployers(Model model) {
        model.addAttribute("employers", employerRepo.getAll());
        return "employers";
    }

    @GetMapping("/{id}")
    public String showEmployerDetailById(Model model, @PathVariable String id) {
        model.addAttribute("employer", employerRepo.findById(id));
        return "employer";
    }
}
