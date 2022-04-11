package com.codedifferently.firebaseauthenticationstarter.domain.controllers;

import com.codedifferently.firebaseauthenticationstarter.domain.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

@Controller
public class ImageController {

    @Autowired
    ImageService imageService;



}
