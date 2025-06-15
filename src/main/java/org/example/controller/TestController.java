package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/demo")
    public String demo() {
        String s = null;
        if (s.length() == 2) {
            return "2";
        }
        return "try again\n";
    }

    // 存在命令注入漏洞（ CWE-78 ）
    @GetMapping("/run")
    public String runCommand(@RequestParam String cmd) throws Exception {
        Process process = Runtime.getRuntime().exec(cmd);  // ❌ 不安全的调用
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {

            output.append(line).append("\n");
        }
        return output.toString();
    }
}
