package org.example.GoogleMapAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Files.payloads;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class BasicAPINonBDD {
    RequestSpecification req = RestAssured.given();
    Response res;
    ValidatableResponse valRes;

    @Test
    public void addPlace()
    {

        //Post API
        String newAdd = "11, side layout, cohen 101";
        req.baseUri("https://rahulshettyacademy.com").queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payloads.AddPlace());


               res =  req.when().post("/maps/api/place/add/json");

               valRes = res.then().log().all();

               valRes.assertThat().statusCode(200).body("scope", equalTo("APP"))
                .extract().response().asString();

//        JsonPath js = new JsonPath();
//        String placeId =  js.getString("place_id");
//        System.out.println(placeId);
//

    }
}
