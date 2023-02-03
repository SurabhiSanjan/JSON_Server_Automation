/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : API Automation on db.json with restassured
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.response.Response;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;
public class DB_JSON_POST {
    @Test
    public void get_POSTS(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .queryParam("id", "1")
                .when()
                .get("  http://localhost:3000/posts");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void post_POSTS(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "      \"id\": 4,\n" +
                        "      \"title\": \"test\",\n" +
                        "      \"author\": \"testing\"\n" +
                        "    }")
                .when()
                .post("http://localhost:3000/posts");
        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }

    @Test
    public void delete_POSTS(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .when()
                .delete("http://localhost:3000/posts/4");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void put_POSTS(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "      \"id\": 3,\n" +
                        "      \"title\": \"testing put\",\n" +
                        "      \"author\": \"Test\"\n" +
                        "    }")
                .when()
                .put("http://localhost:3000/posts/3");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}
