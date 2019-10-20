package com.victory.ddd.china.sample.application.usecase.profile;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublicRepresentationDto {
    private String username;
    private String bio;
    private String image;
    private boolean following;

    static PublicRepresentationDto from(Profile profile) {
        return PublicRepresentationDto.
                builder().
                username(profile.getUsername()).
                bio(profile.getBio()).
                image(profile.getImage()).
                build();
    }
}
