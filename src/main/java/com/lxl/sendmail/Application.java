package com.lxl.sendmail;

/**
 * Created by lxl on 16/7/19.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}