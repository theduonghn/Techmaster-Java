package vn.techmaster.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.techmaster.course.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public String showCourseList(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course/course-list";
    }

    @GetMapping("/{id}/{slug}")
    public String showCourseDetail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("course", courseService.findById(id));
        return "course/detail";
    }
}
