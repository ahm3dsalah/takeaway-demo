package com.takeaway.player2.asycnServices;


import com.takeaway.player2.configuration.GameProperties;
import com.takeaway.player2.models.Pass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ASyncService {



    @Autowired
    GameProperties gameProperties;

    private final RestTemplate restTemplate = new RestTemplate();
    @Async
    public void send(int  score) {
        Pass p = new Pass();
        p.setScore(score);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpRequest = new HttpEntity(p, headers);

        // send the score over rest
        try {
            ResponseEntity<String> response = restTemplate.exchange(gameProperties.getAnotherPlayerUrl()+ gameProperties.getPassUri(), HttpMethod.POST, httpRequest, String.class);
        } catch (Exception exp) {
            System.out.println("other player is offline");
        }
    }
}
