package com.demo;

import com.demo.config.OpenAPI2SchemaServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(OpenAPI2SchemaServerConfig.class)
public class SchemaRegistryApp {
    public static void main(String[] args) {
        SpringApplication.run(SchemaRegistryApp.class, args);
    }
}
