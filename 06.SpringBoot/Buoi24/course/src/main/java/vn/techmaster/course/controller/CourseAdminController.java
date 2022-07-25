package vn.techmaster.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.course.model.Course;
import vn.techmaster.course.model.Image;
import vn.techmaster.course.request.CourseEditRequest;
import vn.techmaster.course.service.CourseService;
import vn.techmaster.course.service.ImageService;
import vn.techmaster.course.service.TopicService;
import vn.techmaster.course.service.UserService;

@Controller
@RequestMapping("/admin/courses")
public class CourseAdminController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;

    @GetMapping("")
    public String showCourseList(Model model) {
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("courseService", courseService);
        return "course-admin/course-list";
    }

    @GetMapping("/course-create")
    public String showCourseCreate(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("topics", topicService.findAll());
        model.addAttribute("users", userService.findAll());
        return "course-admin/course-create";
    }

    @PostMapping("/course-create")
    public String submitCourseCreate(@ModelAttribute Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "course-admin/course-create";
        }

        courseService.add(course);

        return "redirect:/admin/courses";
    }

    @GetMapping("/{id}/course-edit")
    public String showCourseEdit(Model model, @PathVariable("id") Integer id) {
        Course course = courseService.findById(id);
        CourseEditRequest courseEditRequest = courseService.toEditRequest(course);
        model.addAttribute("courseEditRequest", courseEditRequest);
        model.addAttribute("topics", topicService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("thumbnail", imageService.showLink(courseEditRequest.getThumbnail()));
        return "course-admin/course-edit";
    }

    @PostMapping("/{id}/course-edit")
    public String submitCourseEdit(@PathVariable("id") Integer id, @ModelAttribute CourseEditRequest courseEditRequest,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "course-admin/course-edit";
        }

        Image image;
        if (courseEditRequest.getImage() != null && !courseEditRequest.getImage().isEmpty()) {
            image = imageService.uploadImage(courseEditRequest.getImage());
            courseEditRequest.setThumbnail(image.getLink());
        }

        Course course = courseService.fromEditRequest(courseEditRequest);

        courseService.update(course);

        return "redirect:/admin/courses/" + id + "/course-edit";
    }

    @GetMapping("/{id}/course-delete")
    public String deleteCourse(@PathVariable("id") Integer id) {
        Course course = courseService.findById(id);
        courseService.delete(course);
        return "redirect:/admin/courses";
    }
}
