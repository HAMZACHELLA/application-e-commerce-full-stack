package com.ecommerce.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageService {

    private static final String UPLOAD_DIR = "C:/uploads";

    public String saveImageLocally(MultipartFile image) {
        try {
            File uploadPath = new File(UPLOAD_DIR);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            File file = new File(UPLOAD_DIR + "/" + fileName);
            image.transferTo(file);

            return "/uploads/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image locally", e);
        }
    }
}

