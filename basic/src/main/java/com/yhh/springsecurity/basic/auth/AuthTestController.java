package com.yhh.springsecurity.basic.auth;

import com.yhh.springsecurity.basic.mapper.Users;
import com.yhh.springsecurity.basic.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthTestController {

    @Autowired
    UsersMapper usersMapper;

    @RequestMapping("/")
    public String home(Principal principal) {
        String result = "<h1>home page</h1>";
        if(principal != null) {
            result += "<br/>role: " + principal.getName();
        }
        Users user = usersMapper.selectByPrimaryKey("user");
        result += user.getUsername();
        return result;
    }

    @RequestMapping("/public")
    public String p1(Principal principal) {
        String result = "path: /public";
        if(principal != null) {
            result += "<br/>role: " + principal.getName();
        }
        return result;
    }

    @RequestMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String u1(Principal principal) {
        String result = "path: /user";
        if(principal != null) {
            result += "<br/>role: " + principal.getName();
        }
        return result;
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String a1(Principal principal) {
        String result = "path: /admin";
        if(principal != null) {
            result += "<br/>role: " + principal.getName();
        }
        return result;
    }
}