package vn.techmaster.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.course.model.Image;
import vn.techmaster.course.service.ImageService;

@RestController
@RequestMapping("upload/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] readImage(@PathVariable Integer id) {
        Image image = imageService.findById(id);
        return imageService.readImage(image.getLink());
    }
}
