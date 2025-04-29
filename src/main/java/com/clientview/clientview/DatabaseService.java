package com.clientview.clientview;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DatabaseService {
    public FeedbackData getReviewById(Long id){RestTemplate restTemplate = new RestTemplate();
        try {
            String url = "http://localhost:8086/getFeedback/%s".formatted(id);
            return restTemplate.getForObject(url, FeedbackData.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            String url = "http://localhost:8081/id?id=%s".formatted(id);
            return restTemplate.getForObject(url, FeedbackData.class);
        }
    }

    public void editFeedback(FeedbackData feedback){
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
