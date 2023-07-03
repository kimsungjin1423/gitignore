package com.tj.edu.practice1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController1 {

    @GetMapping("/test2View")
    public String test2() {
        return "test2";
    }
}
