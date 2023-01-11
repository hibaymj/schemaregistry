package com.demo.config;

import com.demo.util.OpenAPI2SchemaValidator;
import org.springframework.cloud.schema.registry.config.SchemaServerConfiguration;
import org.springframework.cloud.schema.registry.support.SchemaValidator;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class OpenAPI2SchemaServerConfig extends SchemaServerConfiguration{
    @Bean
    @Override
    public Map<String, SchemaValidator> schemaValidators() {
        Map<String, SchemaValidator> validatorMap = new HashMap<>();
        validatorMap.put("OpenAPI2", new OpenAPI2SchemaValidator());
//        validatorMap.put("avro", new AvroSchemaValidator());
        //TODO json schema
        return validatorMap;
    }
}
