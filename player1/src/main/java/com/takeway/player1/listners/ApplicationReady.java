package com.takeway.player1.listners;


import com.takeway.player1.asycnServices.ASyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReady implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    ASyncService aSyncService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("asdasdasd");
        //aSyncService.send(56);
    }


}
