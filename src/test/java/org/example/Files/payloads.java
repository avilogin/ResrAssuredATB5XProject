package org.example.Files;

import org.example.GoogleMapAPI.BasicAPI;

public class payloads
{

    public static String token()
    {
        return "Basic YXZpamVldGo4NUBnbWFpbC5jb206QVRBVFQzeEZmR0YwTHAzWnh1cFhCXzlGWXJvUWtpektnWU5LdndFV0thVDB5M2RvNHlEc1lNcWd4OXdwV2sxX0ZnSm4zbXl5cGgwQVA3MVpuN3oyQUJhWnZQczZFVjhtcl9VUnlBRWRCYVZFendPUkRjS3FTNTcxUXVpenJueFBkWTItaDFCanROZjExOXpZSUZJRXRpR3V3UEo4aklMRzVOeWlyd3VVQWlEa0tfUVgzYVQ0NGpFPUY2MjFENTJC";
    }

    public static String issue()
    {
        return "{\n" +
                "    \"fields\": {\n" +
                "       \"project\":\n" +
                "       {\n" +
                "          \"key\": \"SCRUM\"\n" +
                "       },\n" +
                "       \"summary\": \"Creating Demo issue with Attachments\",\n" +
                "       \n" +
                "       \"issuetype\": {\n" +
                "          \"name\": \"Bug\"\n" +
                "       }\n" +
                "   }\n" +
                "}";
    }


    public static String AddPlace()
    {
       return  "{\n" +
               "  \"location\": {\n" +
               "    \"lat\": -38.383494,\n" +
               "    \"lng\": 33.427362\n" +
               "  },\n" +
               "  \"accuracy\": 50,\n" +
               "  \"name\": \"Avijeet mohanty\",\n" +
               "  \"phone_number\": \"(+91) 983 894 3938\",\n" +
               "  \"address\": \"11, side layout, cohen 99\",\n" +
               "  \"types\": [\n" +
               "    \"shoe park\",\n" +
               "    \"shop\"\n" +
               "  ],\n" +
               "  \"website\": \"http://google.com\",\n" +
               "  \"language\": \"French-IN\"\n" +
               "}";
    }

    public static String dummyResponse()
    {
        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 3110,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"SQL\",\n" +
                "\n" +
                "\"price\": 22,\n" +
                "\n" +
                "\"copies\": 100\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
    }


}
