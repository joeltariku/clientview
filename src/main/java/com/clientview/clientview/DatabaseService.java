package com.clientview.clientview;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerMapping;

@Service
public class DatabaseService {
    private final HandlerMapping resourceHandlerMapping;

    public DatabaseService(HandlerMapping resourceHandlerMapping) {
        this.resourceHandlerMapping = resourceHandlerMapping;
    }

    public void testDB(){
        RestTemplate restTemplate = new RestTemplate();

        String testDB = restTemplate.getForObject("http://localhost:8081/ping", String.class);
        System.out.println(testDB);
    }

    public FeedbackData getReviewById(Long id){
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = "http://localhost:8084/getFeedback/%s".formatted(id);
            return restTemplate.getForObject(url, FeedbackData.class);
        } catch (Exception e) {
            String url = "http://localhost:8081/id?id=%s".formatted(id);
            return restTemplate.getForObject(url, FeedbackData.class);
        }
    }

    public void editFeedback(FeedbackData feedback){
        /*
        RestTemplate template = new RestTemplate();
        String resourceUrl =
                "http://localhost:8081/edit";
        HttpEntity<FeedbackData> requestUpdate = new HttpEntity<>(feedback);
        template.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);*/

        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(feedback.getProductName());
        HttpEntity<FeedbackData> request = new HttpEntity<>(feedback);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                "http://localhost:8081/edit",
                HttpMethod.PUT,
                request,
                Void.class
        );
    }
}
