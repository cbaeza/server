package com.cbaeza.frontend.controllers;

import com.cbaeza.frontend.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * User: cbaeza
 * Since: 31.01.14
 */
@Controller
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public @ResponseBody Hello sayHello(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }
}
