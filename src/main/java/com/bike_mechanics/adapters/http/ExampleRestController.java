package com.bike_mechanics.adapters.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController{

    @GetMapping("/test_route")
    public String testMethod(){
        return "This worked out!";
    }
}
