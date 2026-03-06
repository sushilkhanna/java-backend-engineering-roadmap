package org.learn.hello_restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello API";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hii";
    }
}
