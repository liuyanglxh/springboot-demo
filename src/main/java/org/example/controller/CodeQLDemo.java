package org.example.controller;

import java.io.*;
import java.util.*;

public class CodeQLDemo {

    // 1. security: Command Injection（命令注入）
    public void commandInjection(String userInput) throws IOException {
        Runtime.getRuntime().exec("echo " + userInput); // BAD: unsafe concatenation
    }

    // 2. security: Hardcoded Password（硬编码密码）
    public void hardcodedPassword() {
        String password = "SuperSecret123"; // BAD: hardcoded credential
        System.out.println("Logging in with: " + password);
    }

    // 3. security-extended: Null Dereference（空指针解引用）
    public int nullDereference(String input) {
        return input.length(); // BAD: may throw NullPointerException
    }

    // 4. correctness: Redundant Comparison（冗余比较）
    public boolean redundantComparison(int x) {
        return x > 5 || x == 10; // BAD: 'x == 10' is redundant when 'x > 5'
    }

    // 5. performance: Inefficient Use of String Concatenation in Loop（低效字符串拼接）
    public String stringConcatInLoop(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "data"; // BAD: inefficient, use StringBuilder
        }
        return result;
    }

    // 6. maintainability: Large Class / Too Many Methods（类膨胀）
    // This class will trigger this if you have many methods
    public void dummyMethod1() {}
    public void dummyMethod2() {}
    public void dummyMethod3() {}
    public void dummyMethod4() {}
    public void dummyMethod5() {}
    public void dummyMethod6() {}
    public void dummyMethod7() {}
    public void dummyMethod8() {}
    public void dummyMethod9() {}
    public void dummyMethod10() {}

    // 7. quality-model: Unused Method Parameter（未使用的参数）
    public void unusedParameter(int x, int y) {
        System.out.println(x); // y is unused
    }

    // 8. security-and-quality: Resource Leak（资源泄漏）
    public void resourceLeak(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename); // BAD: not closed
        fis.read();
    }

    // 9. experimental or correctness: Infinite Loop（可能的死循环）
    public void infiniteLoop() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            // i is never incremented → possible infinite loop
        }
    }

    // 10. maintainability: Long Method（方法过长）
    public void longMethod() {
        System.out.println("Step 1");
        System.out.println("Step 2");
        System.out.println("Step 3");
        System.out.println("Step 4");
        System.out.println("Step 5");
        System.out.println("Step 6");
        System.out.println("Step 7");
        System.out.println("Step 8");
        System.out.println("Step 9");
        System.out.println("Step 10");
        // 过多行代码会触发 Maintainability 警告
    }
}