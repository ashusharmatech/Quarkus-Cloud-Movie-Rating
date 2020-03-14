package com.ms.resources;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class MovieResourceTest {

    @Test
    public void testMovieEndpoint() {
        given()
                .when().get("/movie/tt7131622")
                .then()
                .statusCode(200);
    }
}
