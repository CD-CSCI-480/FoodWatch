package com.codedifferently.firebaseauthenticationstarter.domain.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;

public class ImageService {
    public ImageService() {
    }

    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "/foodWatchImages";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes, new OpenOption[0]);
    }
}
