package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpartanTestsWithPathParameters {


@BeforeClass
    public void setUpClass(){

    RestAssured.baseURI="http://54.234.100.110:8000";
}



@Test
    public void PathTest1() {
    //given accept type is Json
    //and id parameter value is 18
    //when user sends Get request to /api/spartans/{id}
    Response response = RestAssured.given().accept(ContentType.JSON)
            .and().pathParam("id", "18")
            .when().get("/api/spartans/{id}");

    //And response status code should be 200 - verify status code
    assertEquals(response.statusCode(),200);

    //and response content-type : application/json;charset=UTF-8-VERIFY CONTENT TYPE


    assertEquals(response.contentType(),"application/json");

    //And "Allen"  should be in the response payload-VERIFY ALLEN EXIST
    assertTrue(response.body().asString().contains("Allen"));

    response.body().prettyPrint();

}

    /*
            TASK
            Given accept type is Json
            And Id parameter value is 500
            When user sends GET request to /api/spartans/{id}
            Then response status code should be 404
            And response content-type: application/json;charset=UTF-8
            And "Spartan Not Found" message should be in response payload
         */
    @Test
    public void getSpartanID_Negative_PathParam(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/spartans/{id}");

        Assert.assertEquals(response.statusCode(),404);

        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");

        Assert.assertTrue(response.body().asString().contains("Spartan Not Found"));

        response.prettyPrint();

    }







}
