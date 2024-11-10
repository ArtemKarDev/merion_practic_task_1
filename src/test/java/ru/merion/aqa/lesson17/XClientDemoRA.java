package ru.merion.aqa.lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.merion.aqa.lesson15.model.Company;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;



public class XClientDemoRA {
    public static void main(String[] args) {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        XClientWebClientRA clientRA = new XClientWebClientRA("https://x-clients-be.onrender.com");

        String token = clientRA.getToken("leonardo","leads");
        Response response = clientRA.create("Demo", "RestAssured", token);
        int id = response.then().body("id",notNullValue()).extract().path("id");

        Company company = clientRA.getById(id);
        System.out.println(company.id());
        System.out.println(company.name());

        List<Company> all = clientRA.getAll();
        all.forEach(c -> System.out.println(c.name()));

    }


}
