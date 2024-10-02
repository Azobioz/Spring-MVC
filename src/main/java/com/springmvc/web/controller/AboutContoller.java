package com.springmvc.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutContoller {


    @GetMapping("/about")
    public String aboutCreatorPage() {
        return "about-creator";
    }

}
