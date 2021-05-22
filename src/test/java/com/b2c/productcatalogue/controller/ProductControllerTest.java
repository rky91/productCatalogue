package com.b2c.productcatalogue.controller;

import com.b2c.productcatalogue.ProductCatalogueApplication;
import com.b2c.productcatalogue.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ProductCatalogueApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class ProductControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();


    @Test
    @DisplayName("Get all products from DB")
    void getAllProducts() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createUrlWithPort("/products"), HttpMethod.GET, entity, String.class);
        log.info("Response ============= : {}", getListOfProducts(response.getBody()).size());
        Assertions.assertEquals(14, getListOfProducts(response.getBody()).size());
    }

    @Test
    void getProductBySku() {
    }

    @Test
    void getProductWithFilter() {
    }

    @Test
    void buyProduct() {
    }

    private String createUrlWithPort(String uri){
        return "http://localhost:"+port+uri;
    }

    private List<Product> getListOfProducts(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> list = mapper.readValue(response, new TypeReference<List<Product>>() {});
        return list;
    }
}