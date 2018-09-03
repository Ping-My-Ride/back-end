package com.endava.pingmyride;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloPMR {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Ping My Driver!";
    }
}
