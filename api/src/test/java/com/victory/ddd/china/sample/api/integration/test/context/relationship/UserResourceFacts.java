package com.victory.ddd.china.sample.api.integration.test.context.relationship;

import com.victory.ddd.china.sample.api.controller.request.CreateUserRequest;
import com.victory.ddd.china.sample.api.integration.test.BaseApiFacts;

import org.junit.jupiter.api.Test;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class UserResourceFacts extends BaseApiFacts {

    @Test
    void should_get_the_other_profile() {

        CreateUserRequest request = new CreateUserRequest("test@email.com", "testuser", "1234");

        given()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON)
                .post("api/users/")
                .then()
                .header("Content-Type",MediaType.APPLICATION_JSON)
                .statusCode(201)
                .body("email", equalTo(request.getEmail()))
                .body("username", equalTo(request.getUsername()))
                .body("password", equalTo(request.getPassword()))
                .body("bio", equalTo(""))
                .body("image", equalTo(""));
    }

}
