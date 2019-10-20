package com.victory.ddd.china.sample.application.query;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfilePublicRepresentationQueryModel {
    private String username;
    private String bio;
    private String image;
    private boolean following;

    public static ProfilePublicRepresentationQueryModel defaultInstance() {
        return ProfilePublicRepresentationQueryModel.builder().build();
    }

    static ProfilePublicRepresentationQueryModel from(Profile profile, Boolean isFollowing) {
        return ProfilePublicRepresentationQueryModel.
                builder().
                username(profile.getUsername()).
                bio(profile.getBio()).
                image(profile.getImage()).
                following(isFollowing).
                build();
    }

}
