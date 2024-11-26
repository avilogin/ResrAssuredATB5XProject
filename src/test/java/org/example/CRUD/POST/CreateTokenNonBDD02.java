package org.example.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateTokenNonBDD02 {
    @Test
 public void CreateTokNonBDD()
    {


        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

       String resp =  RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .header("ContentType","application/json")
               .basePath("/auth")
                .body(payload).log().all()
                .when().post()
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

       JsonPath js  = new JsonPath(resp);
       String token = js.getString("token");
        System.out.println(token);






    }


}
