package org.example.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetReqNonBDDTestNG {

    @Test
    public void testGetbookingpositive()
    {

        RequestSpecification r = new RestAssured().given();

        r.baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/2846")
                .when().log().all().get()
                .then().log().all();
    }

    }

