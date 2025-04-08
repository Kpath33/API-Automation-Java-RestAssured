package API;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class ApiTests {
    
    @Test
    public void testGet() {
        // Basic GET request to JSONPlaceholder API
        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }
    
    @Test
    public void testPost() {
        // Basic POST request to create a resource
        String jsonBody = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";
        given()
            .header("Content-type", "application/json")
            .and()
            .body(jsonBody)
        .when()
            .post("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("foo"));
    }
    
    @Test
    public void testPut() {
        // Basic PUT request to update a resource
        String jsonBody = "{\"id\":1,\"title\":\"foo updated\",\"body\":\"bar updated\",\"userId\":1}";
        given()
            .header("Content-type", "application/json")
            .and()
            .body(jsonBody)
        .when()
            .put("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .statusCode(200)
            .body("title", equalTo("foo updated"));
    }
    
    @Test
    public void testDelete() {
        // Basic DELETE request to remove a resource
        when()
            .delete("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .statusCode(200);
    }
}
