package com.examples;


import com.jayway.restassured.RestAssured;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Unit test for simple App.
 */
public class MainClassTest extends JerseyTest {
    private static final int TEST_PORT = 9998;
    private static final String TEST_URL = "http://localhost";

    private static final String FIB_ENDPOINT = "fib";

    @Override
    public Application configure() {
        return new ResourceConfig(FibClass.class);
    }

    @BeforeClass
    public static void configureRestAssured() throws Exception
    {
        RestAssured.port = TEST_PORT;
        RestAssured.baseURI = TEST_URL;
    }

    @Test
    public void shouldReturnStatusCode200WhenFibCalled() {
        given().when().get(FIB_ENDPOINT).then().statusCode(200);
    }

    @Test
    public void shouldReturnListOfFibValues() {
        given()
                .when().get(FIB_ENDPOINT)
                .then()
                .body(containsString("[1, 2]"));
    }
}
