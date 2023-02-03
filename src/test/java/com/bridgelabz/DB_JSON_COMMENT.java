
/******************************************************************************************************************************
 Author Name : Surabhi Sanjan
 Project : API Automation on db.json with restassured
 Date : 31/01/2023
 *********************************************************************************************************************************/
package com.bridgelabz;
import io.restassured.response.Response;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;

public class DB_JSON_COMMENT {
    @Test
    public void get_COMMENT(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .queryParam("postId", "1")
                .when()
                .get("http://localhost:3000/comments");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void post_COMMENT(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .body(" {\n" +
                        "        \"id\": 4,\n" +
                        "        \"body\": \"more comments\",\n" +
                        "        \"postId\": 3\n" +
                        "      }")
                .when()
                .post(" http://localhost:3000/comments");
        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }

    @Test
    public void delete_COMMENT(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .when()
                .delete(" http://localhost:3000/comments/4");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void put_COMMENT(){
        Response res = given().contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "      \"id\": 2,\n" +
                        "      \"body\": \"more and more comments\",\n" +
                        "      \"postId\": 2\n" +
                        "    }")
                .when()
                .put(" http://localhost:3000/comments/2");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}
