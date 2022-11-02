package ru.javalike.WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    public String goCourses() {
        return "courses";
    }
}
