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
public class MainClassTest extends BaseClassTest {

    private static final String FIB_ENDPOINT = "fib";

    @Override
    public Application configure() {
        return new ResourceConfig(FibClass.class);
    }

    @Test
    public void shouldReturnStatusCode200WhenFibCalled() {
        given()
                .when().get(FIB_ENDPOINT)
                .then().statusCode(200);
    }

    @Test
    public void shouldReturnListOfFibValues() {
        given()
                .when().get(FIB_ENDPOINT)
                .then()
                .body(containsString("[1, 2]"));
    }
}
