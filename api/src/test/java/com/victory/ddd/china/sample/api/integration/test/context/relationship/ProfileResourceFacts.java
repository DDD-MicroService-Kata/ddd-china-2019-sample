package com.victory.ddd.china.sample.api.integration.test.context.relationship;

import com.victory.ddd.china.sample.api.integration.test.BaseApiFacts;
import com.victory.ddd.china.sample.api.integration.test.fixtures.Username;
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

    @BeforeEach
    void dataPrepare() {
        theOtherOneProfile = new Profile(Username.THE_OTHER_ONE);
        profileRepo.save(theOtherOneProfile);
    }

    @Test
    void should_get_the_other_profile() {

        given()
                .get("api/profiles/{username}", Username.THE_OTHER_ONE)
                .then()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .statusCode(200)
                .body("username", equalTo(Username.THE_OTHER_ONE))
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
