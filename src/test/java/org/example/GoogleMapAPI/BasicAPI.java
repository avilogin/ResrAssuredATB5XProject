package org.example.GoogleMapAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.Files.payloads;
import org.testng.Assert;

import java.util.jar.JarEntry;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class BasicAPI {

    public static void main(String[] args)
    {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String newAdd = "11, side layout, cohen 101";
        String postResponse = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payloads.AddPlace())
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .extract().response().asString();

        JsonPath js = new JsonPath(postResponse);
       String placeId =  js.getString("place_id");
        System.out.println(placeId);

        //UPDATE API
     given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAdd+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));


     // Get Place API
        String getResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).body("address", equalTo(newAdd))
                .extract().response().asString();

        JsonPath js2 = new JsonPath(getResponse);
        String address = js2.getString("address");
        Assert.assertEquals(address,newAdd);
        System.out.println(address);

    }
}
