/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : API Automation on db.json with restassured
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DB_JSON_PROFILE {
    @Test
    public void get_PROFILE(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .when()
                .get("http://localhost:3000/profile");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void post_PROFILE(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .body("   {\n" +
                        "      \"id\": 4,\n" +
                        "      \"name\": \"typicod4\",\n" +
                        "      \"postId\" : 2\n" +
                        "    }")
                .when()
                .post(" http://localhost:3000/profile");
        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }

    @Test
    public void delete_PROFILE(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .when()
                .delete(" http://localhost:3000/profile/4");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void put_PROFILE(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .body(" {\n" +
                        "      \"id\": 3,\n" +
                        "      \"name\": \"testing\",\n" +
                        "      \"postId\": 1\n" +
                        "    }")
                .when()
                .put(" http://localhost:3000/profile/3");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}
