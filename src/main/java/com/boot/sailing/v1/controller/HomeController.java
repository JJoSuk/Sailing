package com.boot.sailing.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class HomeController {

    @GetMapping("/home")
    public String doHome() {
        return "/v1/home/home";
    }

    @GetMapping("/rest2")
    @ResponseBody
    public String doRest2() {
        String strHtml = "<html><h2>Hello</h2>Rest Controller</html>";

        return strHtml;
    }
}
