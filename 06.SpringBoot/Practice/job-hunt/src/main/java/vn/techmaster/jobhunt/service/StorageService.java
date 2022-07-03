package vn.techmaster.jobhunt.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.techmaster.jobhunt.exception.StorageException;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;

    // id của Employer id
    public String saveFile(MultipartFile file, String id) throws IOException {
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
        }

        // Lấy extension
        String extension = getFileExtension(file.getOriginalFilename());

        String newFileName = path + id + "." + extension;
        try {
            var is = file.getInputStream();
            Files.copy(is, Paths.get(newFileName), StandardCopyOption.REPLACE_EXISTING);
            return id + "." + extension;
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s", newFileName);
            throw new StorageException(msg, e);
        }
    }

    /*
     * Bóc tách file extension từ file name.
     * Ví dụ
     * input: pic1.png
     * output: png
     */
    public String getFileExtension(String fileName) {
        int posOfDot = fileName.lastIndexOf(".");
        if (posOfDot >= 0) {
            return fileName.substring(posOfDot + 1);
        } else {
            return null;
        }
    }
}
