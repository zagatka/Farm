package myApplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

}
