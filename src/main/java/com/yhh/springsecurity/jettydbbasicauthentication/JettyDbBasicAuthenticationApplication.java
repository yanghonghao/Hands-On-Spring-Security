package com.yhh.springsecurity.jettydbbasicauthentication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JettyDbBasicAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JettyDbBasicAuthenticationApplication.class, args);
    }

}
