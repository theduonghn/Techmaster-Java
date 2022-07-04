package vn.techmaster.jobhunt.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.jobhunt.model.Employer;
import vn.techmaster.jobhunt.repository.EmployerRepo;
import vn.techmaster.jobhunt.request.EmployerRequest;
import vn.techmaster.jobhunt.service.StorageService;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {
    @Autowired
    private EmployerRepo employerRepo;

    @Autowired
    private StorageService storageService;

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

    @GetMapping(value = "/add")
    public String addEmployerForm(Model model) {
        model.addAttribute("employer", new EmployerRequest("", "", "", "", null));
        return "employer_add";
    }

    @PostMapping(value = "/add", consumes = { "multipart/form-data" })
    public String addEmployer(
            @Valid @ModelAttribute("employer") EmployerRequest employerRequest,
            BindingResult result,
            Model model) {
        if (employerRequest.logo().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("employer", "logo", "Logo is required"));
        }

        // Nếu có lỗi thì trả về trình duyệt
        if (result.hasErrors()) {
            System.out.println("ERROR: " + result.toString());
            return "employer_add";
        }

        // Thêm vào CSDL
        Employer emp = employerRepo.add(Employer.builder()
                .name(employerRequest.name())
                .website(employerRequest.website())
                .email(employerRequest.email())
                .build());

        // Lưu logo vào ổ cứng
        try {
            String logoFileName = storageService.saveFile(employerRequest.logo(), emp.getId());
            employerRepo.updateLogo(emp.getId(), logoFileName);
        } catch (IOException e) {
            // Nếu ghi file bị lỗi thì hãy xoá bản ghi Employer
            e.printStackTrace();
        }

        return "redirect:/employer";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployerById(@PathVariable String id) {
        Employer emp = employerRepo.deleteById(id);
        storageService.deleteFile(emp.getLogo_path());
        return "redirect:/employer";
    }
}
