package ru.merion.aqa.lesson18.contract;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.merion.aqa.lesson15.model.Company;

import java.io.IOException;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XClientsCompanyTest {
    public static final String URL = "https://x-clients-be.onrender.com";
    public static final String COMPANY_ENDPOINT = "/company";
    public static final String LOGIN_ENDPOINT = "/auth/login";
    public static final String X_CLIENT_TOKEN = "x-clients-token";


    @BeforeAll
    public static void detUp() {
        RestAssured.baseURI = URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    public void shouldReturnArrayOnGetCompanyList() {

        given()
                .get(COMPANY_ENDPOINT)
                .then()
                .statusCode(200).extract().jsonPath().getList("", Company.class);

        assertTrue(list.isEmpty());

    }

    @Test
    public void shouldReturn401OWithoutToken() throws IOException{
        String json = """
                {
                  "username": "leonardo",
                  "password": "leads"
                }                
                """;
        given().body(json).contentType(ContentType.JSON)
                .post(COMPANY_ENDPOINT)
                .then()
                .statusCode(401)
                .body("statusCode", equalTo(401))
                .body("message", equalTo("Unauthorize"));

    }



    @Test
    public void shouldReturn401WithoutValidToken() throws IOException{
        String json = """
                {
                  "name": "Contract Test Company",
                  "description": "Contract Test Company"
                }                
                """;

        given().body(json)
                .contentType(ContentType.JSON)
                .header(X_CLIENT_TOKEN,"NON_VALID_TOKEN")
                .post(COMPANY_ENDPOINT)
                .then()
                .statusCode(401)
                .body("statusCode", equalTo(401))
                .body("message", equalTo("Unauthorized"));
    }

    @Test
    public void shouldReturn2O1OnCompanyCreated() throws IOException{

        String creds = """
                {
                  "name": "Contract Test Company",
                  "description": "Contract Test Company"
                }                
                """;

        String json = """
                {
                  "name": "Contract Test Company",
                  "description": "Contract Test Company"
                }                
                """;

        String token = given().body(creds)
                .contentType(ContentType.JSON)
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(201)
                .extract().path("userToken");

        given().body(json)
                .contentType(ContentType.JSON)
                .header(X_CLIENT_TOKEN,token)
                .post(COMPANY_ENDPOINT)
                .then()
                .statusCode(201)
                .body("id", greaterThanOrEqualTo(1));

    }

    @Test
    public void shouldDeleteCompany() throws IOException{
        int id = createDummyCompany();

        given().basePath(COMPANY_ENDPOINT)
                .contentType(ContentType.JSON)
                .header(X_CLIENT_TOKEN,getToken())
                .get("/delete/{id}")
                .then()
                .statusCode(200)
                .body("id",equalTo(id));
    }

    private String getToken(){
        String creds = """
                {
                  "name": "Contract Test Company",
                  "description": "Contract Test Company"
                }                
                """;

        return given().body(creds)
                .contentType(ContentType.JSON)
                .post(LOGIN_ENDPOINT)
                .then()
                .extract().path("userToken");
    }
    private int createDummyCompany(){

        String json = """
                {
                  "name": "Contract Test Company",
                  "description": "Contract Test Company"
                }                
                """;

        return given().body(json)
                .contentType(ContentType.JSON)
                .header(X_CLIENT_TOKEN,getToken())
                .post(COMPANY_ENDPOINT)
                .then()
                .extract().path("id");

    }

    @Test
    @Tag("Defect")
    public void shouldGET404OnDeleteNonExistCompany() throws IOException{
        int id = createDummyCompany();

        given().basePath(COMPANY_ENDPOINT)
                .contentType(ContentType.JSON)
                .header(X_CLIENT_TOKEN,getToken())
                .get("/delete/{id}")
                .andReturn();

        given().basePath(COMPANY_ENDPOINT)
                .contentType(ContentType.JSON)
                .header(X_CLIENT_TOKEN,getToken())
                .get("/delete/{id}")
                .then()
                .statusCode(404);
    }


}
