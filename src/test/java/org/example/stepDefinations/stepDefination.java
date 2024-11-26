package org.example.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.pojo.AddPlace;
import org.example.pojo.Location;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class stepDefination {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;

    @Given("Add Place payloads")
    public void add_place_payloads() {

        RestAssured.baseURI="https://rahulshettyacademy.com";

        //creating an object of AddPlace class
        AddPlace p = new AddPlace();

        //providing all the values using the setter method in AddPlace class
        p.setAccuracy(50);
        p.setAddress("29, side layout, cohen 08");
        p.setLanguage("French-IN");
        p.setPhone_number("(+91) 983 893 9992");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName("Max Black");

        //created ArrayList for the Types field as it has multiple values
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);

        //creating object of Location class
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);

        p.setLocation(l);

        //created object of RequestSpecBuilder class
        RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();

        //Created object of ResponseSpecBuilder class
         resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

         res=given().log().all().spec(req).body(p);
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {
        response = res
                .when().post("/maps/api/place/add/json")
                .then().spec(resspec).extract().response();
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
     assertEquals(response.getStatusCode(),200);

    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String actualString, String ExpectedString) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        assertEquals(js.get(actualString).toString(),ExpectedString);
    }

}
