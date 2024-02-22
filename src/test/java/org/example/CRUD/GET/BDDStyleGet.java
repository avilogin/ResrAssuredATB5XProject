package org.example.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BDDStyleGet {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us").basePath("/IN/765017")

                .when().log().all()
                .get()

                .then().log().all().statusCode(200);
    }
}
