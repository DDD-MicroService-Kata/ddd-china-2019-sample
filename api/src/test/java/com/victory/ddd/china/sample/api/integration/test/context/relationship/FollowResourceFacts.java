package com.victory.ddd.china.sample.api.integration.test.context.relationship;

import com.victory.ddd.china.sample.api.integration.test.BaseApiFacts;
import com.victory.ddd.china.sample.api.integration.test.fixtures.data.FollowFixture;
import com.victory.ddd.china.sample.api.integration.test.fixtures.data.ProfileFixture;
import com.victory.ddd.china.sample.api.integration.test.fixtures.data.Usernames;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;
import org.hamcrest.Matchers;
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
    private ProfileFixture profileFixture;

    @Inject
    private FollowFixture followFixture;

    @BeforeEach
    void dataPrepare() {
        theOtherOneProfile = profileFixture.createTheOtherUserProfile();
    }

    @Test
    void should_follow_the_other_user_successfully(){
        given().
                header(HttpHeaders.AUTHORIZATION, jwtTokenService.issue(Usernames.CURRENT_USER)).
                post("api/profiles/{username}/follow", theOtherOneProfile.getUsername()).
                then().
                statusCode(200).
                body("username", equalTo(theOtherOneProfile.getUsername())).
                body("bio", equalTo(theOtherOneProfile.getBio())).
                body("image", equalTo(theOtherOneProfile.getImage())).
                body("following", equalTo(true));
    }

    @Test
    void should_follow_the_other_user_successfully_when_the_following_exists(){
        followFixture.createTheOtherOneFollowedByCurrent();
        given().
                header(HttpHeaders.AUTHORIZATION, jwtTokenService.issue(Usernames.CURRENT_USER)).
                post("api/profiles/{username}/follow", theOtherOneProfile.getUsername()).
                then().statusCode(200).
                body("username", equalTo(theOtherOneProfile.getUsername())).
                body("bio", equalTo(theOtherOneProfile.getBio())).
                body("image", equalTo(theOtherOneProfile.getImage())).
                body("following", equalTo(true));
    }

    @Test
    void should_follow_failed_when_the_to_follow_user_is_not_exits() {
        given().
                header(HttpHeaders.AUTHORIZATION, jwtTokenService.issue(Usernames.CURRENT_USER)).
                post("api/profiles/{username}/follow", Usernames.Not_Exists).
                then().
                statusCode(422).
                body("errors", Matchers.hasSize(1)).
                body("errors[0]", equalTo(String.format("no such user to follow %s", Usernames.Not_Exists)));
    }

    @Test
    void should_unFollow_the_other_user_successfully() {
        followFixture.createTheOtherOneFollowedByCurrent();
        given().
                header(HttpHeaders.AUTHORIZATION, jwtTokenService.issue(Usernames.CURRENT_USER)).
                delete("api/profiles/{username}/follow", theOtherOneProfile.getUsername()).
                then().statusCode(200).
                body("username", equalTo(theOtherOneProfile.getUsername())).
                body("bio", equalTo(theOtherOneProfile.getBio())).
                body("image", equalTo(theOtherOneProfile.getImage())).
                body("following", equalTo(false));
    }

    @Test
    void should_unFollow_successfully_when_no_following() {
        given().
                header(HttpHeaders.AUTHORIZATION, jwtTokenService.issue(Usernames.CURRENT_USER)).
                delete("api/profiles/{username}/follow", theOtherOneProfile.getUsername()).
                then().statusCode(200).
                body("username", equalTo(theOtherOneProfile.getUsername())).
                body("bio", equalTo(theOtherOneProfile.getBio())).
                body("image", equalTo(theOtherOneProfile.getImage())).
                body("following", equalTo(false));
    }

}

