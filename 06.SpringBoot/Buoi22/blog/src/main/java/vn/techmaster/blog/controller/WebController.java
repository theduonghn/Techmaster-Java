package vn.techmaster.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.blog.repository.CategoryRepository;
import vn.techmaster.blog.service.BlogService;

@Controller
public class WebController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogInfo());
        model.addAttribute("blogsPopular", blogService.getBlogPopular(3));
        model.addAttribute("categories", categoryRepository.getCategoriesPopular());
        return "index";
    }

    @GetMapping("/blogs/{id}/{slug}")
    public String getDetailPage(Model model, @PathVariable String id) {
        model.addAttribute("blog", blogService.getBlogInfoById(id));
        return "detail";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }
}
