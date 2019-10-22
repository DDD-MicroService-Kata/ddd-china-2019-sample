package com.victory.ddd.china.sample.application.query;

import com.victory.ddd.china.sample.application.build.block.ReadModel;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import lombok.Builder;
import lombok.Value;


@ReadModel
@Builder
@Value
public class ProfilePublicRepresentationReadModel {
    private String username;
    private String bio;
    private String image;
    private boolean following;

    public static ProfilePublicRepresentationReadModel defaultInstance() {
        return ProfilePublicRepresentationReadModel.builder().build();
    }

    static ProfilePublicRepresentationReadModel from(Profile profile, Boolean isFollowing) {
        return ProfilePublicRepresentationReadModel.
                builder().
                username(profile.getUsername()).
                bio(profile.getBio()).
                image(profile.getImage()).
                following(isFollowing).
                build();
    }

}
