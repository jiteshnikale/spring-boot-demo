package com.fiserv.spring.boot.demo.controller;

import com.fiserv.spring.boot.demo.models.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String getMessage() {
        return "Hello World";
    }

    @GetMapping("/greeting/{id}")
    public HelloWorldBean getGreeting(@PathVariable int id) {
        HelloWorldBean helloWorldBean = new HelloWorldBean();
        helloWorldBean.setMessage("Good Morning");
        helloWorldBean.setName(id + " - Jitesh Nikale");
        return helloWorldBean;
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String getGreetingInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
