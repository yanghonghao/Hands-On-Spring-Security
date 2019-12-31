package com.yhh.springsecurity.jettydbbasicauthentication.authtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("a")
    public String a() {
        return "user a";
    }
}
