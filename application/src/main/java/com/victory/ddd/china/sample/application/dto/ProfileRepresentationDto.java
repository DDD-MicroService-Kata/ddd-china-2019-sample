package com.victory.ddd.china.sample.application.dto;

import com.victory.ddd.china.sample.domain.context.relationship.Profile;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileRepresentationDto {
    private String username;
    private String bio;
    private String image;
    private boolean following;

    public static ProfileRepresentationDto from(Profile profile) {
        return ProfileRepresentationDto.
                builder().
                username(profile.getUsername()).
                bio(profile.getBio()).
                image(profile.getImage()).
                build();
    }
}
