package com.patern.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patern.entity.Guess;

@Controller
public class GuessController {
    @RequestMapping("/guess")
    public String guess(@RequestBody Guess guess) throws Exception{
        System.out.println("GuessController.guess()"+guess);
        return "user/list";
    }
}