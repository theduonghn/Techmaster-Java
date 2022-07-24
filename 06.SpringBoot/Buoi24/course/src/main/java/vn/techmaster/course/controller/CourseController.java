package vn.techmaster.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.course.service.CourseService;
import vn.techmaster.course.service.TopicService;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TopicService topicService;

    @GetMapping("")
    public String showCourseList(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                                 @RequestParam(value = "topic", required = false) Integer topicId) {
        model.addAttribute("courses", courseService.findByNameAndTopicId(name, topicId));
        model.addAttribute("topics", topicService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("topicId", topicId);
        return "course/course-list";
    }

    @GetMapping("/course-onlab-list")
    public String showCourseOnlabList(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "topic", required = false) Integer topicId) {
        model.addAttribute("courses", courseService.findByTypeAndNameAndTopicId("onlab", name, topicId));
        model.addAttribute("topics", topicService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("topicId", topicId);
        return "course/course-list";
    }

    @GetMapping("/course-online-list")
    public String showCourseOnlineList(Model model, @RequestParam(value = "name", defaultValue = "") String name,
                                       @RequestParam(value = "topic", required = false) Integer topicId) {
        model.addAttribute("courses", courseService.findByTypeAndNameAndTopicId("online", name, topicId));
        model.addAttribute("topics", topicService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("topicId", topicId);
        return "course/course-list";
    }

    @GetMapping("/{id}/{slug}")
    public String showCourseDetail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("course", courseService.findById(id));
        return "course/detail";
    }
}
