package vn.techmaster.hellojpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.hellojpa.repository.EmployerRepo;
import vn.techmaster.hellojpa.model.Employer;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
    @Autowired
    private EmployerRepo employerRepo;

    @GetMapping
    public List<Employer> getAll() {
        return employerRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employer> findById(@PathVariable Long id) {
        return employerRepo.findById(id);
    }
}
