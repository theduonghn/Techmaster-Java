package vn.techmaster.course.controller;

import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.course.repository.CourseRepository;
import vn.techmaster.course.service.CourseService;

@Controller
@RequestMapping("/admin/courses")
public class CourseAdminController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public String showCourseList(Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("courseService", courseService);
        return "course-admin/course-list";
    }

    @GetMapping("/course-create")
    public String showCourseCreate(Model model) {
        return "course-admin/course-create";
    }

    @GetMapping("{id}/course-edit")
    public String showCourseEdit(Model model, @Param("id") String id) {
        return "course-admin/course-edit";
    }
}
