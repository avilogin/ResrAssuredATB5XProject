package org.example.JIRA;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.Files.payloads;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;

import static io.restassured.RestAssured.*;

public class CreateIssue {

    @Test
    public void Creatingissue() {
        RestAssured.baseURI = "https://avijeetj85.atlassian.net";
        String issueResponse = given().log().all().header("Content-Type", "application/json")
                .header("Accept", "*/*")
                .header("Authorization", payloads.token())
                .body(payloads.issue()).log().all()
                .when().post("/rest/api/3/issue")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();

        JsonPath js = new JsonPath(issueResponse);
        String id = js.getString("id");
        String key = js.getString("key");
        System.out.println(id);
        System.out.println(key);


        //Adding Attachment in issue
        String AttachResponse = given().log().all().pathParams("id", id)
                .header("Accept", "*/*")
                .header("X-Atlassian-Token","no-check")
                .header("Authorization", payloads.token())
                .multiPart("file",new File("C:\\Users\\HP\\OneDrive\\Desktop\\Image001.jpg")).log().all()
                .when().post("/rest/api/3/issue/{id}/attachments")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
    }

}
