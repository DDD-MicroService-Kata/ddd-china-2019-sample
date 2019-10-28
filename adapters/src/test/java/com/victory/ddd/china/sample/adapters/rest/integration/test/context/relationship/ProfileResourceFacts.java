package com.victory.ddd.china.sample.adapters.rest.integration.test.context.relationship;

import com.victory.ddd.china.sample.adapters.rest.integration.test.BaseApiFacts;
import com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data.FollowFixture;
import com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data.ProfileFixture;
import com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data.Usernames;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class ProfileResourceFacts extends BaseApiFacts {

    @Inject
    private ProfileFixture profileFixture;

    @Inject
    private FollowFixture followFixture;

    @Inject
    private JwtTokenService jwtTokenService;

    private Profile theOtherOneProfile;

    @BeforeEach
    void dataPrepare() {
        theOtherOneProfile = profileFixture.createTheOtherUserProfile();

    }

    @Test
    void should_get_the_other_profile() {

        given()
                .get("api/profiles/{username}", Usernames.THE_OTHER_ONE)
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .statusCode(200)
                .body("username", equalTo(Usernames.THE_OTHER_ONE))
                .body("bio", equalTo(theOtherOneProfile.getBio()))
                .body("image", equalTo(theOtherOneProfile.getImage()))
                .body("following", equalTo(false));

    }

    @Test
    void should_get_the_empty_profile_when_user_not_exists() {
        given()
                .get("api/profiles/{username}", Usernames.Not_Exists)
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .statusCode(200)
                .body("username", equalTo(null))
                .body("bio", equalTo(null))
                .body("image", equalTo(null))
                .body("following", equalTo(false));
    }

    @Test
    void should_get_the_other_profile_with_following_when_the_users_followed() {
        followFixture.createTheOtherOneFollowedByCurrent();

        given()
                .header(HttpHeaders.AUTHORIZATION, jwtTokenService.issue(Usernames.CURRENT_USER))
                .get("api/profiles/{username}", Usernames.THE_OTHER_ONE)
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .statusCode(200)
                .body("following", equalTo(true));
    }
}
