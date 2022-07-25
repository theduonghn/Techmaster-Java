package vn.techmaster.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.course.exception.BadRequestException;
import vn.techmaster.course.exception.StorageException;
import vn.techmaster.course.model.Image;
import vn.techmaster.course.repository.ImageRepository;
import vn.techmaster.course.util.Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    // Folder path to upload file
    private final Path rootPath = Paths.get("upload");
    private final Path imagesPath = rootPath.resolve("images");

    public ImageService() {
        createFolder(rootPath.toString());
    }

    // Create folder if not exists
    public void createFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Upload file
    public Image uploadImage(MultipartFile file) {
        // Create image path if not exist
        createFolder(imagesPath.toString());

        // Validate file
        validate(file);

        // Create image instance
        Image image = new Image();
        imageRepository.saveAndFlush(image);
        Path linkPath = imagesPath.resolve(String.valueOf(image.getId()));
        image.setLink(linkPath.toString());
        imageRepository.saveAndFlush(image);

        // Create path of file
        File fileServer = new File(image.getLink());
        try {
            // Use Buffer to store data
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileServer));
            stream.write(file.getBytes());
            stream.close();

            return image;
        } catch (Exception e) {
            throw new StorageException("Errors occur while uploading file");
        }
    }

    public void validate(MultipartFile file) {
        // Validate file name
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.equals("")) {
            throw new BadRequestException("Invalid file name");
        }

        // Validate file extension
        String fileExtension = Utils.getExtensionFile(fileName);
        if (!Utils.checkFileExtenstion(fileExtension)) {
            throw new BadRequestException("Invalid file");
        }

        // Kiểm tra size (upload dưới 2MB)
        if ((double) file.getSize() > (2 * 1024 * 1024)) {
            throw new BadRequestException("File must not excess 2MB");
        }
    }

    // Read image
    public byte[] readImage(String link) {
        // Lấy đường dẫn file
        Path path = Paths.get(link);

        // Kiểm tra path có tồn tại hay không
        if (!Files.exists(path)) {
            throw new StorageException("Errors occur while reading file " + link);
        }

        try {
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable()) {
                InputStream inputStream = resource.getInputStream();
                byte[] byteArray = StreamUtils.copyToByteArray(inputStream);
                inputStream.close(); // Remember to close InputStream
                return byteArray;
            } else {
                throw new StorageException("Errors occur while reading file " + link);
            }
        } catch (Exception e) {
            throw new StorageException("Errors occur while reading file " + link);
        }
    }

    // Delete image
    public void deleteImage(String link) {
        try {
            Files.deleteIfExists(Paths.get(link));
            Image image = imageRepository.findByLink(link)
                    .orElseThrow(() -> new StorageException("Errors occur while deleting file " + link));
            imageRepository.delete(image);
        } catch (IOException e) {
            throw new StorageException("Errors occur while deleting file " + link);
        }
    }

    public Image findById(Integer id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new StorageException("Errors occur while reading file " + id));
    }

    public String showLink(String link) {
        if (link == null) {
            return "";
        }
        else if (!link.contains("http")) {
           return "\\" + link;
        } else {
            return link;
        }
    }
}
