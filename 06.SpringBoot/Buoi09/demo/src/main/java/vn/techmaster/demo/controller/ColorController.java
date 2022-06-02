package vn.techmaster.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import vn.techmaster.demo.service.ColorService;

@RestController
@AllArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @GetMapping("/random-color")
    public String getRandomColor(@RequestParam int type) {
        return colorService.getRandomColor(type);
    }
}
