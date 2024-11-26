package org.example.NovCodes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NormalLogin {

RequestSpecification req = RestAssured.given();

Response res ;
ValidatableResponse valRes;
String payload = "{\n" +
        "    \"userEmail\": \"Avijeetjana26@gmail.com\",\n" +
        "    \"userPassword\": \"Password123\"\n" +
        "}";
    @Test
    public void testLogin()
    {
        req.baseUri("https://rahulshettyacademy.com")
                .header("Content-Type","application/json")
                .body(payload);

        res = req.when().post("/api/ecom/auth/login");

        valRes = res.then().log().all();

        valRes.assertThat().statusCode(200);
    }



}
