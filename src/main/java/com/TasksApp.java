package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by ryandesmond on 7/30/18.
 */

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class TasksApp {

    public static void main(String[] args) {
        SpringApplication.run(TasksApp.class, args);
    }

}
