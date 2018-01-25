package com.takeway.player1.listners;


import com.takeway.player1.asycnServices.ASyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ApplicationReady implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    ASyncService aSyncService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        Random rn = new Random();
        int result = rn.nextInt(10000 - 3 + 1) + 3;
        aSyncService.send(result);
    }


}
