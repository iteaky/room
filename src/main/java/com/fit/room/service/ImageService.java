package com.fit.room.service;

import com.fit.room.dao.PhotoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private PhotoDAO photoDAO;

    public byte[] getImage(Long photoId) throws IOException {
        String imageURI = photoDAO.getOne(photoId).getImageURI();

        // Retrieve image from the classpath.
        InputStream is = this.getClass().getResourceAsStream(imageURI);

        // Prepare buffered image.
        BufferedImage img = ImageIO.read(is);

        // Create a byte array output stream.
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        // Write to output stream
        ImageIO.write(img, "jpg", bao);

        return bao.toByteArray();
    }


    public String addImage(MultipartFile image) throws IOException {

        Files.createDirectories(Paths.get("src/main/resources/photo"));
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
        Path resultPath = Paths.get("src/main/resources/photo", image.getOriginalFilename());
        ImageIO.write(img, "jpg", resultPath.toFile());
        return "/photo/" + image.getOriginalFilename();

    }

    public List<String> addImage(MultipartFile file1, MultipartFile file2) throws IOException {
        List<MultipartFile> files = Arrays.asList(file1, file2);
        for (MultipartFile file : files) {
            Files.createDirectories(Paths.get("src/main/resources/photo"));
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(file1.getBytes()));
            Path resultPath = Paths.get("src/main/resources/photo", file1.getOriginalFilename());
            ImageIO.write(img, "jpg", resultPath.toFile());
        }
        return Arrays.asList("/photo/" + file1.getOriginalFilename(), "/photo/" + file2.getOriginalFilename());
    }

}
