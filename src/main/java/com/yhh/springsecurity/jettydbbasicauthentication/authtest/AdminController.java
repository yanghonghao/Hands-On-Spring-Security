package com.yhh.springsecurity.jettydbbasicauthentication.authtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("a")
    public String a() {
        return "admin a";
    }
}
