package com.victory.ddd.china.sample.api.integration.test.context.relationship;

import com.victory.ddd.china.sample.api.integration.test.BaseApiFacts;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class ProfileResourceFacts extends BaseApiFacts {
    @Inject
    private ProfileRepo profileRepo;

    private Profile theOtherOneProfile;
    private String theOtherOneUserName = "theOtherOne";

    @BeforeEach
    void dataPrepare() {
        theOtherOneProfile = new Profile(theOtherOneUserName);
        profileRepo.save(theOtherOneProfile);
    }

    @Test
    void should_get_the_other_profile() {

        given()
                .get("api/profiles/{username}", theOtherOneUserName)
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .statusCode(200)
                .body("username", equalTo(theOtherOneUserName))
                .body("bio", equalTo(theOtherOneProfile.getBio()))
                .body("image", equalTo(theOtherOneProfile.getImage()))
                .body("following", equalTo(false));

    }

    @Test
    void  should_get_the_empty_profile_when_user_not_exists(){
        given()
                .get("api/profiles/{username}", "NotTrue")
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .statusCode(200)
                .body("username", equalTo(null))
                .body("bio", equalTo(null))
                .body("image", equalTo(null))
                .body("following", equalTo(false));
    }
}
