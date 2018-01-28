package com.takeway.player1.listners;


import com.takeway.player1.asycnServices.ASyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ApplicationReady implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    ASyncService aSyncService;

    @Value("${game.initialScore}")
    private Integer score;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        // if user didnt provide value at startup system will generate random value
        if(score != 0) {
            aSyncService.send(score);
        } else {
            Random rn = new Random();
            int result = rn.nextInt(10000 - 3 + 1) + 3;
            aSyncService.send(result);
        }

    }


}
