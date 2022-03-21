package com.careerdevs.HelloInternet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController

//create a path for all associated route handlers
@RequestMapping("/nasa")
public class NasaController {

    private final String myNasaKey = "Ra46Z9dcQW0m3hoGcYugzrhHZ1NPY4SmPjP5dN3g";
    private final String nasaApodEndPoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;

    //this is an individual route handler for the nasa apod
    @GetMapping("/apod")
    public Object apodHandler (RestTemplate restTemplate) {
        return restTemplate.getForObject(nasaApodEndPoint, Object.class);
    }

    @GetMapping("/pickFive")
    public Object pickFive(@RequestParam int count, RestTemplate restTemplate){

        String pickFiveURL = nasaApodEndPoint + "&count=" + count;

        return restTemplate.getForObject(pickFiveURL, Object.class);
    }

    @GetMapping("/getPhotosInRange")
    public Object getPhotosInRange(@RequestParam("start_date") String startDate,
                                   @RequestParam("end_date") String endDate,
                                   RestTemplate restTemplate) {

        //https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2017-07-08&end_date=2017-07-10

        String getPhotosInRangeURL = nasaApodEndPoint + "&start_date=" + startDate + "&end_date=" + endDate;

        return restTemplate.getForObject(getPhotosInRangeURL, Object.class);
    }


}
