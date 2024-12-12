package org.example.NovCodes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @DataProvider(name = "testData")

    public Object[][] createUser()
    {
        return new Object[][]
                {
                        {"avijeet@test.com","newpassword"},
                        {"jana@test.com","password"},
                        {"Avijeetjana26@gmail.com","Password123"}

                };
    }
    RequestSpecification req = RestAssured.given();
    Response res;
    ValidatableResponse valres ;
    @Test(dataProvider = "testData")
    public void testLogin(String user, String pass)
    {
        req.baseUri("https://rahulshettyacademy.com/api/ecom/auth/login")
                .header("Content-Type","application/json")
                .body("{\"userEmail\":\"" + user + "\", \"userPassword\":\"" + pass + "\"}");

        res = req.when().post();

        valres = res.then().statusCode(200);

    }
}
