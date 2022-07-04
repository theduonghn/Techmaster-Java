package vn.techmaster.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.techmaster.jobhunt.model.City;
import vn.techmaster.jobhunt.model.Job;
import vn.techmaster.jobhunt.repository.JobRepo;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobRepo jobRepo;

    @GetMapping
    public String listAllJobs(Model model) {
        model.addAttribute("jobs", jobRepo.getAll());
        return "jobs";
    }

    @GetMapping("/add")
    public String showAddJobForm(Model model, @RequestParam("emp_id") String emp_id) {
        Job job = new Job();
        job.setEmp_id(emp_id);
        model.addAttribute("job", job);
        model.addAttribute("cities", City.values());
        return "job_add";
    }
}
