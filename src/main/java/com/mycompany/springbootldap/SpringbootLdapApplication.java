package com.mycompany.springbootldap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootLdapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLdapApplication.class, args);
    }
}
