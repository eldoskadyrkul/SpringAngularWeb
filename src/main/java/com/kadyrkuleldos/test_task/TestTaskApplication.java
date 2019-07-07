package com.kadyrkuleldos.test_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kadyrkuleldos.test_task.controllers", "com.kadyrkuleldos.test_task.service"})
@EnableJpaRepositories(basePackages = {"com.kadyrkuleldos.test_task.repository"})
public class TestTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }

}
