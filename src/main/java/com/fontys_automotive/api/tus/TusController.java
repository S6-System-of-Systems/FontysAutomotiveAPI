package com.fontys_automotive.api.tus;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/tus")

public class TusController {

    private String uri = "https://countriesnow.space/api/v0.1";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder rtb)
    {
        return rtb.build();
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getCountryResponse(RestTemplate restTemplate)
    {
        try
        {
            return restTemplate.getForEntity(uri + "/countries" , String.class);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("kanker", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
