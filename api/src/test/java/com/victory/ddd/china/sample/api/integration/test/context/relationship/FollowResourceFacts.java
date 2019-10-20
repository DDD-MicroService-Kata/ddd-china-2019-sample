package com.victory.ddd.china.sample.api.integration.test.context.relationship;

import com.victory.ddd.china.sample.api.integration.test.BaseApiFacts;
import com.victory.ddd.china.sample.api.integration.test.fixtures.Username;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class FollowResourceFacts extends BaseApiFacts {
    private Profile theOtherOneProfile;

    @Inject
    private JwtTokenService jwtTokenService;

    @Inject
    private ProfileRepo profileRepo;

    @BeforeEach
    void dataPrepare() {
        theOtherOneProfile = new Profile(Username.THE_OTHER_ONE);
        profileRepo.save(theOtherOneProfile);
    }

    @Test
    void should_follow_the_other_user_successfully(){
        given().
                header(HttpHeaders.AUTHORIZATION, jwtTokenService.issue(Username.CURRENT_USER)).
                post("api/profiles/{username}/follow", theOtherOneProfile.getUsername()).
                then().statusCode(200).
                body("username", equalTo(theOtherOneProfile.getUsername())).
                body("bio", equalTo(theOtherOneProfile.getBio())).
                body("image", equalTo(theOtherOneProfile.getImage())).
                body("following", equalTo(true));
    }

}
