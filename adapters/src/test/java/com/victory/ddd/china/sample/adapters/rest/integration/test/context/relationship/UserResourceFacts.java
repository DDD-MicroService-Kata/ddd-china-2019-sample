package com.victory.ddd.china.sample.adapters.rest.integration.test.context.relationship;

import com.victory.ddd.china.sample.adapters.rest.resource.request.CreateUserRequest;
import com.victory.ddd.china.sample.adapters.rest.resource.request.UpdateUserRequest;
import com.victory.ddd.china.sample.adapters.rest.resource.request.UserLoginRequest;
import com.victory.ddd.china.sample.adapters.rest.integration.test.BaseApiFacts;

import com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data.ProfileFixture;
import com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data.UserFixture;
import com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data.Usernames;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

class UserResourceFacts extends BaseApiFacts {

    @Inject
    private UserFixture userFixture;

    @Inject
    private ProfileFixture profileFixture;

    @Test
    void should_login_user() {
        userFixture.createCurrentUser();
        profileFixture.createCurrentUserProfile();

        UserLoginRequest userLoginRequest = new UserLoginRequest("test@email.com","123456");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userLoginRequest)
                .post("api/users/login")
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("statusCodeValue", equalTo(200))
                .body("body.email", equalTo("test@email.com"))
                .body("body.token",isA(String.class))
                .body("body.username", equalTo(Usernames.CURRENT_USER))
                .body("body.bio", equalTo("I like default"))
                .body("body.image", equalTo("default image"));
    }

    @Test
    void should_register_a_new_user() {

        CreateUserRequest request = new CreateUserRequest("test@email.com", Usernames.CURRENT_USER, "1234");

        given()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON)
                .post("api/users/")
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("statusCodeValue", equalTo(201))
                .body("body.email", equalTo(request.getEmail()))
                .body("body.username", equalTo(request.getUsername()))
                .body("body.bio", equalTo(null))
                .body("body.image", equalTo(null))
                .body("body.token", isA(String.class));
    }

    @Test
    void should_get_the_current_login_user() {
        userFixture.createCurrentUser();
        profileFixture.createCurrentUserProfile();

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .auth()
                .oauth2("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2Y2IyMjYxMy02MDFlLTQ4ZGItODQ5YS0wZjQxMjhlZTU1MTEiLCJpc3MiOiJUZXN0aW5nIiwiYXVkIjoiYXBpIiwic3ViIjoiY3VycmVudFVzZXIiLCJpYXQiOjE1NzE2NzM2MDAsImV4cCI6MTg4NzI5MjgwMH0.0DD8xVIC2UhYm5DTNbjblRjo_tt9zcVb4W7Nnp3hLYM")
                .get("api/users/")
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("statusCodeValue", equalTo(200))
                .body("body.email", equalTo("test@email.com"))
                .body("body.username", equalTo(Usernames.CURRENT_USER))
                .body("body.bio", equalTo("I like default"))
                .body("body.image", equalTo("default image"));
    }
    @Test
    void should_update_the_current_login_user() {
        userFixture.createCurrentUser();
        profileFixture.createCurrentUserProfile();
        UpdateUserRequest updateUserRequest = new UpdateUserRequest("I like default","default image");
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updateUserRequest)
                .auth()
                .oauth2("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2Y2IyMjYxMy02MDFlLTQ4ZGItODQ5YS0wZjQxMjhlZTU1MTEiLCJpc3MiOiJUZXN0aW5nIiwiYXVkIjoiYXBpIiwic3ViIjoiY3VycmVudFVzZXIiLCJpYXQiOjE1NzE2NzM2MDAsImV4cCI6MTg4NzI5MjgwMH0.0DD8xVIC2UhYm5DTNbjblRjo_tt9zcVb4W7Nnp3hLYM")
                .put("api/users/")
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body("statusCodeValue", equalTo(200))
                .body("body.bio", equalTo("I like default"))
                .body("body.image", equalTo("default image"));
    }
}
