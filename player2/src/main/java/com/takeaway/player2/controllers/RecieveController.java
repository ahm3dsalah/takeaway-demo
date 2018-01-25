package com.takeaway.player2.controllers;

import com.takeaway.player2.asycnServices.ASyncService;
import com.takeaway.player2.models.Pass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("player2")
public class RecieveController {

    @Autowired
    ASyncService aSyncService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/pass", method = RequestMethod.POST)
    public void recieveScore(@RequestBody @Validated Pass passModel) {

        int val = 0;
        System.out.println("Receiving from the other player "+ passModel.getScore());
        if(passModel.getScore() % 3 == 0) {
            val = passModel.getScore() / 3;
        } else if((passModel.getScore()+1) % 3 == 0) {
            val = (passModel.getScore() + 1) /3;
        } else {
            val = (passModel.getScore() - 1) / 3;
        }

        if(val  == 1) {
            System.out.println("player 2 wins");
        } else {
            System.out.println("sending to player 1");
            aSyncService.send(val);
        }
    }

}
