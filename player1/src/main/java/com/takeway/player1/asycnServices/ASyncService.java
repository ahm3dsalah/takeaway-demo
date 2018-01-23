package com.takeway.player1.asycnServices;

import com.takeway.player1.configuration.GameProperties;
import com.takeway.player1.models.Pass;
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
        ResponseEntity<String> response = restTemplate.exchange(gameProperties.getAnotherPlayerUrl()+ gameProperties.getPassUri(), HttpMethod.POST, httpRequest, String.class);

    }
}
