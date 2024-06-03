package org.example.GoogleMapAPI;

import io.restassured.path.json.JsonPath;
import org.example.Files.payloads;
import org.testng.Assert;

public class CourseDetails {

    /*
    1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount
     */
    public static void main(String[] args) {

        JsonPath js = new JsonPath(payloads.dummyResponse());

        // 1. Print No of courses returned by API
       Integer courcesSize =  js.getInt("courses.size()");
        System.out.println(courcesSize);

        // 2.Print Purchase Amount
       Integer purAmt =  js.getInt("dashboard.purchaseAmount");
        System.out.println(purAmt);

        // 3. Print Title of the first course
       String title =  js.get("courses[0].title");
        System.out.println(title);

        //4. Print All course titles and their respective Prices
        for (int i = 0; i<courcesSize; i++)
        {
            String allTitle = js.get("courses["+i+"].title");
            Integer courcePrice = js.getInt("courses["+i+"].price");
            System.out.print(allTitle +"\t");
            System.out.println(courcePrice);
        }

        // 5. Print no of copies sold by RPA Course

        for (int j = 0; j< courcesSize; j++)
        {
            String CorTitle = js.getString("courses["+j+"].title");
            if (CorTitle.equalsIgnoreCase("RPA"))
            {
              Integer copies =  js.getInt("courses["+j+"].copies");
                System.out.println("Number of copies of RPA cources are "+ copies);
            }
        }

        // 6. Verify if Sum of all Course prices matches with Purchase Amount

        Integer sum = 0;
        for (int k =0; k<courcesSize; k++)
        {
            Integer perPrice = js.getInt("courses["+k+"].price");
            Integer perCopies = js.getInt("courses["+k+"].copies");
            Integer amount = perCopies * perPrice;
            System.out.println(amount);
            sum = sum+amount;
            System.out.println(sum);

        }
       Integer purchaseAmt =  js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmt);
        Assert.assertEquals(sum, purchaseAmt);



    }
}
