// Package declaration for organizing the code
package API;

// Importing RestAssured library for API testing
import io.restassured.RestAssured;
// Importing static methods from RestAssured for cleaner syntax
import static io.restassured.RestAssured.*;
// Importing JUnit 5's Test annotation for marking test methods
import org.junit.jupiter.api.Test;
// Importing Hamcrest matchers for assertions
import static org.hamcrest.Matchers.*;

// Main class containing API test cases
public class ApiTests {

    // Test case for performing a GET request
    @Test
    public void testGet() {
        // Sends a GET request to the specified URL and validates the response
        given() // Prepares the request
        .when() // Specifies the action to perform
            .get("https://jsonplaceholder.typicode.com/posts/1") // Sends a GET request to fetch a specific post
        .then() // Validates the response
            .statusCode(200) // Asserts that the HTTP status code is 200 (OK)
            .body("id", equalTo(1)); // Asserts that the "id" field in the response body equals 1
    }

    // Test case for performing a POST request
    @Test
    public void testPost() {
        // Sends a POST request to create a new resource and validates the response
        String jsonBody = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}"; // JSON payload for the POST request
        given()
            .header("Content-type", "application/json") // Sets the Content-Type header to JSON
            .and()
            .body(jsonBody) // Attaches the JSON payload to the request
        .when()
            .post("https://jsonplaceholder.typicode.com/posts") // Sends a POST request to create a new post
        .then()
            .statusCode(201) // Asserts that the HTTP status code is 201 (Created)
            .body("title", equalTo("foo")); // Asserts that the "title" field in the response body equals "foo"
    }

    // Test case for performing a PUT request
    @Test
    public void testPut() {
        // Sends a PUT request to update an existing resource and validates the response
        String jsonBody = "{\"id\":1,\"title\":\"foo updated\",\"body\":\"bar updated\",\"userId\":1}"; // JSON payload for the PUT request
        given()
            .header("Content-type", "application/json") // Sets the Content-Type header to JSON
            .and()
            .body(jsonBody) // Attaches the JSON payload to the request
        .when()
            .put("https://jsonplaceholder.typicode.com/posts/1") // Sends a PUT request to update the post with ID 1
        .then()
            .statusCode(200) // Asserts that the HTTP status code is 200 (OK)
            .body("title", equalTo("foo updated")); // Asserts that the "title" field in the response body equals "foo updated"
    }

    // Test case for performing a DELETE request
    @Test
    public void testDelete() {
        // Sends a DELETE request to remove a resource and validates the response
        when()
            .delete("https://jsonplaceholder.typicode.com/posts/1") // Sends a DELETE request to delete the post with ID 1
        .then()
            .statusCode(200); // Asserts that the HTTP status code is 200 (OK)
    }
}
