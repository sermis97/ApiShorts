package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class SpartanTestWithQueryParams {

    @BeforeClass
    public void setUpClass() {
        RestAssured.baseURI = "http://54.234.100.110:8000";
    }


    @Test
    public void QueryParam1() {
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "J")
                .when().get("/api/spartans/search");

        //verify status code

        assertEquals(response.statusCode(), 200);

        //verify Content type

        Assert.assertEquals(response.contentType(), "application/json;charset=UTF-8");

        //verify female
       // assertEquals(response.body().asString().contains("Female"));

        //verify Janette
        assertEquals(response.body().asString(), "Janette");

        response.prettyPrint();

    }
    @Test
    public void queryParams2(){
        //creating map for query params

        Map<String ,Object> paramsMap= new HashMap<>();
        paramsMap.put("gender","Female");
        paramsMap.put("nameContains","J");

        //send request
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "J")
                .when().get("/api/spartans/search");

        //verify status code

        assertEquals(response.statusCode(), 200);

        //verify Content type

        assertEquals(response.contentType(), "application/json;charset=UTF-8");

        //verify female
        //assertEquals(response.body().asString().contains("Female"));

        //verify Janette
        assertEquals(response.body().asString(), "Janette");

        response.prettyPrint();


    }
}



