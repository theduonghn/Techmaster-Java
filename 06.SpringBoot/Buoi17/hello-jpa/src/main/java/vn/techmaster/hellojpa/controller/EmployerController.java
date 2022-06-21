package vn.techmaster.hellojpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import vn.techmaster.hellojpa.repository.EmployerRepo;
import vn.techmaster.hellojpa.model.Employer;

@RestController
@RequestMapping("/api/employer")
@AllArgsConstructor
public class EmployerController {
    private final EmployerRepo employerRepo;

    @GetMapping
    public List<Employer> getAll() {
        return employerRepo.findAll();
    }
}
