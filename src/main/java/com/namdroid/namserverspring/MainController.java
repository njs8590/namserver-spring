package com.namdroid.namserverspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    public String getHello(){
        return "Hello JSNAM";
    }
}
