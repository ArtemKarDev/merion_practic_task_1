package ru.merion.aqa.lesson17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReatAssuredDemo {

    public static final String URL = "https://todo-app=sky.herokuapp.com";

    public static void main(String[] args) {
        RestAssured.baseURI = URL;
        RestAssured.basePath = "/company";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.


        given()
                .when().get("")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON);

        String json = "{\"title\":\"456\",\"completed\":false}";

        given()
                .body(json)
                .contentType(ContentType.JSON)
                .when().post(URL)
                .then()
                .onFailMessage("Не смогли создать задачу")
                .statusCode(201)
                .header("Connection", "keep-alive")
                .body("title", equalTo("456"));

    }
}
