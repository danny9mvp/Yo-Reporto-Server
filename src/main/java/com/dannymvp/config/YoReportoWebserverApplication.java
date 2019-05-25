package com.dannymvp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.dannymvp.restful","com.dannymvp.services","com.dannymvp.controllers"})
@EntityScan("com.dannymvp.entities")
@EnableJpaRepositories("com.dannymvp.repositories")
public class YoReportoWebserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoReportoWebserverApplication.class, args);
    }

}
