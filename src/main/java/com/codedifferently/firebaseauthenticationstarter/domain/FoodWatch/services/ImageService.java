package com.codedifferently.firebaseauthenticationstarter.domain.FoodWatch.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageService {
    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "/foodWatchImages";
        byte[] bytes = imageFile.getBytes();

        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path,bytes);

    }
}
