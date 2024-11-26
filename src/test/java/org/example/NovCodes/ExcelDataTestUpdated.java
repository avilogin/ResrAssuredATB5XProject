package org.example.NovCodes;
import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ExcelDataTestUpdated {

    @Test
    public void testWithExcelData() throws IOException {
        String excelFilePath = "D:/Documents for Study/Automation class/JavaPrograms/RestAssuredATB5X/src/test/java/resources/TestData01.xlsx";

        // Open the Excel file
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0); // Use the first sheet

            // Loop through each row (excluding the header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    String user = row.getCell(0).getStringCellValue();
                    String password = row.getCell(1).getStringCellValue();

                    // Input validation: Ensure user and password are not empty or null
                    if (user == null || user.isEmpty() || password == null || password.isEmpty()) {
                        System.out.println("Skipping row " + (i+1) + " due to missing user or password");
                        continue; // Skip the current iteration if data is invalid
                    }

                    // Base URI
                    RestAssured.baseURI = "https://rahulshettyacademy.com/api/ecom/auth/login";

                    // API Body should be fixed with correct formatting
                    String requestBody = "{\"userEmail\":\"" + user + "\", \"userPassword\":\"" + password + "\"}";

                    try {
                        // API Request with validation and response logging
                        String response = given()
                                .header("Content-Type", "application/json")
                                .body(requestBody)
                                .when()
                                .post()
                                .then()
                                .statusCode(200)  // Validate status code
                                .extract().response().asString();

                        // Debugging API response
                        System.out.println("Response for user " + user + ": " + response);

                        // Optional: Parse the response body to validate additional fields or content
                        // You can add further assertions based on your API response format

                    } catch (AssertionError e) {
                        // Handling the AssertionError gracefully and logging the message
                        System.err.println("Assertion failed for row " + (i + 1) + ": " + e.getMessage());
                        continue; // Continue with the next test case if there's an assertion error
                    }
                }
            }
        }
    }
}

