package com.example.pokedex.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class HTTPRequest {
    // I send the JSONObject which contains the data
    public static JSONObject run(int id) {
        String jsonResponse = "";
        JSONObject obj = new JSONObject() ;
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + id); // Modif
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);

            if (resultObject instanceof JSONObject) {
                obj =(JSONObject)resultObject ;
                return obj ;

            } else {
                System.err.println("Error, we expected a JSON Object from the API");
                return obj ;
            }


        } catch (IOException e) {
            e.printStackTrace();
            return obj ;
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
            return obj ;
        }
    }
}
