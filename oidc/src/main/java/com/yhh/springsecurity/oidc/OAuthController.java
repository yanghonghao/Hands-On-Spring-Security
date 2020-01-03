package com.yhh.springsecurity.oidc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OAuthController {
    @RequestMapping("/")
    public String home(Principal principal) {
        String result = "<h1>Hello ";
        if(principal != null) {
            result += principal.getName();
        }
        result += "</h1>";
        return result;
    }
}
