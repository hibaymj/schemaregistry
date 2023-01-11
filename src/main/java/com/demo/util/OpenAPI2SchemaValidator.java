package com.demo.util;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import org.springframework.cloud.schema.registry.model.Compatibility;
import org.springframework.cloud.schema.registry.model.Schema;
import org.springframework.cloud.schema.registry.support.SchemaValidator;

import java.util.List;

public class OpenAPI2SchemaValidator implements SchemaValidator {
    @Override
    public boolean isValid(String definition) {
        return new SwaggerParser().parse(definition) != null;
    }

    @Override
    public Compatibility compatibilityCheck(String source, String other) {
        return null;
    }

    @Override
    public Schema match(List<Schema> schemas, String definition) {
        Schema result = null;
        Swagger source = new SwaggerParser().parse(definition);
        for (Schema s : schemas) {
            Swagger target = new SwaggerParser().parse(s.getDefinition());
            if (target.equals(source)) {
                result = s;
                break;
            }
        }
        return result;
    }

    @Override
    public String getFormat() {
        return "OpenAPI2";
    }
}
