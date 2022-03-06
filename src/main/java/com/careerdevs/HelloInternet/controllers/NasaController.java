package com.careerdevs.HelloInternet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa")
public class NasaController {
    private final String myNasaKey = "Ra46Z9dcQW0m3hoGcYugzrhHZ1NPY4SmPjP5dN3g";
    private final String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;
    @GetMapping("/apod")
    public Object apodHandler(RestTemplate restTemplate) {
        return restTemplate.getForObject(nasaApodEndpoint, Object.class);
    }

}