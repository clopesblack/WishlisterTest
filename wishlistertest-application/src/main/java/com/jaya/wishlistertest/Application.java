package com.jaya.wishlistertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Caroline Lopes on 30/09/17.
 */
@EnableRedisHttpSession
@SpringBootApplication
@Configuration
public class Application {

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}