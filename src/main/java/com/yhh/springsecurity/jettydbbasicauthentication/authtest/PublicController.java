package com.yhh.springsecurity.jettydbbasicauthentication.authtest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/public")
public class PublicController {
    @RequestMapping("a")
    public String a() {
        return "public a";
    }

    @RequestMapping("b")
    @Secured("ROLE_ADMIN")
    public String b() {
        return "public b";
    }

    @RequestMapping("c")
    @Secured("ROLE_USER")
    public String c() {
        return "public c";
    }

}