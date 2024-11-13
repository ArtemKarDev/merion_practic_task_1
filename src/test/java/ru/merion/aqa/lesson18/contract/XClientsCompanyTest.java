package ru.merion.aqa.lesson18.contract;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.merion.aqa.lesson15.model.Company;

import java.io.IOException;
import java.util.List;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XClientsCompanyTest {

    public static final String SWAGGER = "https://x-clients-be.onrender.com/doc-json";
    public static final String URL = "https://x-clients-be.onrender.com";
    public static final String COMPANY_ENDPOINT = "/company";
    public static final String DELETE_ENDPOINT = "/company/delete/{id}";
    public static final String LOGIN_ENDPOINT = "/auth/login";
    private static final String X_CLIENT_TOKEN = "x-clients-token";
    private static ResponseSpecification RESPONSE_401;
    private static RequestSpecification CREATE_REQUEST;
    private static RequestSpecification DELETE_REQUEST;


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RESPONSE_401 = new ResponseSpecBuilder()
                .expectStatusCode(401)
                .expectBody("message", equalTo("Unauthorized"))
                .expectBody("statusCode", equalTo(401))
                .build();

        String json = """
                {
                  "name": "Contract Test Company",
                  "description": "Contract Test Company"
                }                
                """;

        CREATE_REQUEST = new RequestSpecBuilder()
                .addHeader(X_CLIENT_TOKEN, getToken())
                .setContentType(ContentType.JSON)
                .setBody(json)
                .build();

        DELETE_REQUEST = new RequestSpecBuilder()
                .addHeader(X_CLIENT_TOKEN, getToken())
                .setBasePath(DELETE_ENDPOINT)
                .build();

        OpenApiValidationFilter filter = new OpenApiValidationFilter(SWAGGER);
        RestAssured.filters(filter);


    }

    @Test
    public void shouldReturnArrayOnGetCompanyList() {
        List<Company> list = given()
                .get(COMPANY_ENDPOINT)
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("", Company.class);

        assertTrue(list.isEmpty());

    }

    @Test
    public void shouldReturn401OWithoutToken() throws IOException{

        given().spec(CREATE_REQUEST)
                .post(COMPANY_ENDPOINT)
                .then()
                .spec(RESPONSE_401);
    }

    @Test
    public void shouldReturn401WithoutValidToken() throws IOException{
        String json = """
                {
                  "name": "Contract Test Company",
                  "description": "Contract Test Company"
                }                
                """;

        given()
                .spec(CREATE_REQUEST)
                .header(X_CLIENT_TOKEN,"NON_VALID_TOKEN")
                .post(COMPANY_ENDPOINT)
                .then()
                .spec(RESPONSE_401);
    }

    @Test
    public void shouldReturn2O1OnCompanyCreated() {

        given()
                .spec(CREATE_REQUEST)
                .post(COMPANY_ENDPOINT)
                .then()
                .statusCode(201)
                .body("id", greaterThanOrEqualTo(0));

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
    public void shouldGet404OnDeleteNonExistCompany() {
        int id = createDummyCompany();

        given()
                .spec(DELETE_REQUEST)
                .get("",id)
                .andReturn();

        given()
                .spec(DELETE_REQUEST)
                .get("",id)
                .then()
                .statusCode(404);
    }

    @Test
    public void shouldReturn401OnDeleteCompany(){
        int id = createDummyCompany();

        given()
                .spec(DELETE_REQUEST)
                .header(X_CLIENT_TOKEN, "")
                .get("",id)
                .then()
                .spec(RESPONSE_401);
    }


}
