package org.example.NovCodes;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DataDrivenAPITest {

    @DataProvider(name= "UserData")

    public Object[][] createUserData()
    {
        return new Object[][]
                {
                        {"avijeet@test.com","newpassword"},
                        {"jana@test.com","password"},
                        {"Avijeetjana26@gmail.com","Password123"}
                };
    }


    @Test(dataProvider = "UserData")

    public void testCreateUser(String user, String password) {
        RestAssured.baseURI = "https://rahulshettyacademy.com/api/ecom/auth/login";

        given()
                .header("Content-Type", "application/json")
                .body("{\"userEmail\":\"" + user + "\", \"userPassword\":\"" + password + "\"}")
                .when()
                .post()
                .then()
                .statusCode(200)  // Validate status code
                .log().all();
    }

}
