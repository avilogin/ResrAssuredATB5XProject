package org.example.Files;

import org.example.GoogleMapAPI.BasicAPI;

public class payloads
{


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


}
