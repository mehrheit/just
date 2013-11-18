package com.berk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Oleg
 * Date: 18.11.13
 */
@Controller
@RequestMapping("/")
public class MediatorController {

    @RequestMapping
    public String getHomePage(){
        return "redirect:/accounts";
    }
}
