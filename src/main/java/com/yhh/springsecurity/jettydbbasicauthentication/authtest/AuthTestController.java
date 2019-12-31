package com.yhh.springsecurity.jettydbbasicauthentication.authtest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class AuthTestController {
    @RequestMapping("/public")
    public String a(Principal principal) {
        if(principal != null) {
            return "public " + principal.getName();
        }
        return "public";
    }

    @RequestMapping("/admin")
    public String b(Principal principal) {
        if(principal!= null) {
            return "admin " + principal.getName();
        }
        return "admin";
    }


    @RequestMapping("/user")
    public String c(Principal principal) {
        if(principal != null) {
            return "user " + principal.getName();
        }
        return "user";
    }


}