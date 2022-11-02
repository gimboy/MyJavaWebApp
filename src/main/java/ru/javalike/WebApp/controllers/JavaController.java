package ru.javalike.WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/java")
public class JavaController {

    @GetMapping()
    public String goJava() {
        return "java/java";
    }

    @GetMapping("/start")
    public String goJavaStart() {
        return "java/java-start";
    }
}
