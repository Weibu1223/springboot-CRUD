package com.example.test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.test")
@MapperScan("com.example.test.Dao")
public class testApplication {
    public static void main(String[] args){
        SpringApplication.run(testApplication.class, args);
    }
}
