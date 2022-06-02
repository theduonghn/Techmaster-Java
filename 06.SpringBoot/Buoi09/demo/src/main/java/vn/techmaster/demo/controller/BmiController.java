package vn.techmaster.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import vn.techmaster.demo.request.BmiRequest;
import vn.techmaster.demo.service.BmiService;

@RestController
@RequestMapping("/bmi")
@AllArgsConstructor
public class BmiController {
    private BmiService bmiService;

    @GetMapping()
    public Double getBmi(@RequestParam double weight, @RequestParam double height) {
        return bmiService.getBmi(weight, height);
    }

    @PostMapping()
    public Double getBmi(@RequestBody BmiRequest request) {
        return bmiService.getBmi(request.weight(), request.height());
    }
}
