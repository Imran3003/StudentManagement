package com.ib.stm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ib.stm","com.ib.stm.parser"})
public class StudentManagementFeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementFeApplication.class, args);
    }

}
