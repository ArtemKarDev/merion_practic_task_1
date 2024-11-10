package ru.merion.aqa.lesson17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import ru.merion.aqa.lesson15.XClientsWebClient;
import ru.merion.aqa.lesson15.model.Company;

import java.util.List;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class XClientWebClientRA {
    public XClientWebClientRA(String url){
        RestAssured.baseURI = url;
        RestAssured.basePath = "/company";

    }

    public String getToken(String userName, String password){
        String authJson = "{\"username\":\"" + userName +"\",\"password\":\"" + password +"\"}";
        return given()
                .contentType(ContentType.JSON)
                .body(authJson).post()
                .then().extract().path("userToken");
    }
    public Response create(String name, String description, String token){
        String json = "{\"name\":\"" + name +"\",\"description\":\"" + description +"\"}";
        return given()
                .contentType(ContentType.JSON)
                .body(json)
                .header("x-client-token",token)
                .post();
    }




    public Company getById(int companyId){
        return given().pathParams("id",companyId)
                .get("/{id}")
                .then().extract().as(Company.class);
    }

    public List<Company> getAll() {
        return given()
                .get()
                .jsonPath().getList("", Company.class);
    }
}
