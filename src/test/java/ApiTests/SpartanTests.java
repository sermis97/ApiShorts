package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpartanTests {

    String spartanBaseUrl= "http://54.234.100.110:8000";

    @Test
    public void viewSpartanTest1(){

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

        //print the status code

        System.out.println("response.statusCode() = " + response.statusCode());

        //to print body  // tüm bilgileri string formatında  tek bir satırda alır.
       System.out.println("response.body().asString() = " + response.body().asString());




        //response.body().prettyPrint(); tüm bilgileri alt alta json formatında alır.


    }
    //when user send  GET  request to /api/spartans end point
    //then status code must be 200
    //and body should contains Allen

    @Test
    public void viewSpartanTest2 () {

        Response response= RestAssured.get(spartanBaseUrl+"/api/spartans");

        //verify status code 200
        Assert.assertEquals(response.statusCode(),200);


        //verify body contains ALlen
        Assert.assertTrue(response.body().asString().contains("Allen"));

    }

    /*Given accept type is Json
    When user sends a get request to spartanAllURL
    THen Response status code is 200
    And response body should be json format
     */

    @Test
    public void viewSpartanTest3 () {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseUrl + "/api/spartans");

        //verify status code

        Assert.assertEquals(response.statusCode(),200);

        //verify that response body json
        Assert.assertEquals(response.contentType(), "application/json");

    }
}
