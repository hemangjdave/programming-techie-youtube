package com.techrevolution.ms.productservice;

import com.techrevolution.ms.productservice.dto.ProductResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @ServiceConnection
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort
    private int port;


    @BeforeEach
    void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }


    @Test
    void testCreateProductApi() {
        String requestBody = """
                {
                    "name" : "iphone 16",
                    "description" : "iphone 16 is a smartphone from apple",
                    "price" : 2200
                }
                """;
        RestAssured.given()
                .body(requestBody)
                .contentType("application/json")
                .when()
                .post("api/product")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("iphone 16"))
                .body("description", Matchers.equalTo("iphone 16 is a smartphone from apple"))
                .body("price", Matchers.equalTo(2200));
    }

    @Test
    void testGetProductApi() {
        RequestSpecification specification = RestAssured.given();
        Response response = specification.get("/api/product");
        ProductResponse[] productResponses = response.then().statusCode(200).extract().as(ProductResponse[].class);
        Assertions.assertEquals(1, productResponses.length);
    }

}
