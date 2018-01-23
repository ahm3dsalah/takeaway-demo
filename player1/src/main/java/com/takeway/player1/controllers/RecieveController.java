package com.takeway.player1.controllers;

import com.takeway.player1.asycnServices.ASyncService;
import com.takeway.player1.models.Pass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("player1")
public class RecieveController {

    @Autowired
    ASyncService aSyncService;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/pass", method = RequestMethod.POST)
    public void recieveScore(@RequestBody @Validated Pass passModel) {

        if (passModel.getScore() % 3 == 0 && passModel.getScore() / 3 == 1) {
            System.out.println("player 1 wins");
        } else if (passModel.getScore() % 3 == 0) {
            aSyncService.send(passModel.getScore()/3);
        } else if (passModel.getScore() - 1 % 3 == 0) {
            aSyncService.send(passModel.getScore() - 1);

        } else {
            aSyncService.send(passModel.getScore() + 1);
        }
    }

}
