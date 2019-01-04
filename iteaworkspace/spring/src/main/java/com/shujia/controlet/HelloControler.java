package com.shujia.controlet;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloSpringBoot() {
        return "Hello SpringBoot!";
    }
}
