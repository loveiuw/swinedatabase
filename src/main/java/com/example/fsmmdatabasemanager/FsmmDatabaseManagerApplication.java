package com.example.fsmmdatabasemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.fsmmdatabasemanager")

public class FsmmDatabaseManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsmmDatabaseManagerApplication.class, args);
    }

}
