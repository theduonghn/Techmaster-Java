package vn.techmaster.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import vn.techmaster.demo.exception.BadRequestException;

@Service
public class ColorService {

    private Random random = new Random();

    public String getRandomColor(int type) {
        return switch (type) {
            case 1 -> randomColorName();
            case 2 -> randomHexColor();
            case 3 -> randomRgbColor();
            default -> throw new BadRequestException("Type không hợp lệ");
        };
    }

    public String randomColorName() {
        List<String> colorNames = Arrays.asList("black",
                "silver",
                "gray",
                "white",
                "maroon",
                "red",
                "purple",
                "fuchsia",
                "green",
                "lime",
                "olive",
                "yellow",
                "navy",
                "blue",
                "teal",
                "aqua");
        return colorNames.get(random.nextInt(colorNames.size()));
    }

    public String randomHexColor() {
        int randNum = random.nextInt(0xffffff + 1);
        return String.format("#%06x", randNum);
    }

    public String randomRgbColor() {
        return String.format("rgb(%d, %d, %d)", random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
