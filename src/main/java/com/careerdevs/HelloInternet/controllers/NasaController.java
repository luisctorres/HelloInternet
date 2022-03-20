package com.careerdevs.HelloInternet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

//create a path for all associated route handlers
@RequestMapping("/nasa")
public class NasaController {

    @Autowired
    RestTemplate restTemplate;
    private final String myNasaKey = "Ra46Z9dcQW0m3hoGcYugzrhHZ1NPY4SmPjP5dN3g";
    private final String nasaApodEndPoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;

    //this is an individual route handler for the nasa apod
    @GetMapping("/apod")
    public Object apodHandler (RestTemplate restTemplate) {
        return restTemplate.getForObject(nasaApodEndPoint, Object.class);
    }

    @GetMapping("/pickFive")
    public Object pickFive(@RequestParam int count, RestTemplate restTemplate){
        return restTemplate.getForObject(nasaApodEndPoint, Object.class);
    }

    @GetMapping("/getPhotosInRange")
    public Object getPhotosInRange(@RequestParam String start_date,
                                   @RequestParam String end_date,
                                   RestTemplate restTemplate) {
        return restTemplate.getForObject(nasaApodEndPoint, Object.class);
    }


}
