package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/demo")
    public String demo() {
        String s = null;
        if (s.length() == 2) {
            return "2";
        }
        return "success123124444444\n";
    }
}
