package com.demo;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import org.junit.Test;
import org.springframework.cloud.schema.registry.model.Schema;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class SchemaTest {
    private static final String REQUEST = "{\"subject\":\"vnd.vgi.retail.account\",\"format\":\"OpenAPI2\",\"definition\":\"{\\\"swagger\\\":\\\"2.0\\\",\\\"info\\\":{\\\"title\\\":\\\"application/vnd.vgi.retail.account+json\\\",\\\"version\\\":\\\"1.0\\\"},\\\"paths\\\":{\\\"/\\\":{\\\"get\\\":{\\\"responses\\\":{\\\"200\\\":{\\\"description\\\":\\\"\\\",\\\"schema\\\":{\\\"$ref\\\":\\\"#/definitions/vnd.vgi.retail.account\\\"}}}}}},\\\"definitions\\\":{\\\"vnd.vgi.retail.account\\\":{\\\"type\\\":\\\"object\\\",\\\"properties\\\":{\\\"accountId\\\":{\\\"type\\\":\\\"string\\\"},\\\"accountNumber\\\":{\\\"type\\\":\\\"string\\\"}}}}}\"}";

    @Test
    public void tryIt(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Schema response = restTemplate.postForEntity("http://localhost:9999",new HttpEntity<String>(REQUEST,headers), Schema.class).getBody();
        System.out.println(response.getDefinition());

        Swagger swagger = new SwaggerParser().parse(response.getDefinition());

        System.out.println(swagger);
    }
}
