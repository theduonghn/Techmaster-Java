package vn.techmaster.demo.service;

import org.springframework.stereotype.Service;

import vn.techmaster.demo.exception.BadRequestException;

@Service
public class BmiService {
    public double getBmi(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new BadRequestException("Chiều cao và cân nặng phải lớn hơn 0");
        }
        return weight / (height * height);
    }
}
