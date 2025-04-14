package com.clientview.clientview;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DatabaseService {
    public void testDB(){
        RestTemplate restTemplate = new RestTemplate();

        String testDB = restTemplate.getForObject("http://localhost:8081/ping", String.class);
        System.out.println(testDB);
    }

    public Review getReviewById(Long id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/id/?id=%s".formatted(id);
        return restTemplate.getForObject(url, Review.class);
    }
}
