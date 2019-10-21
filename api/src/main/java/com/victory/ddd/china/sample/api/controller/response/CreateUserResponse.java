package com.victory.ddd.china.sample.api.controller.response;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponse {
    private String username;
    private String email;
    private String bio;
    private String image;

    public static CreateUserResponse from(User user, Profile profile) {
        return CreateUserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .bio(profile.getBio())
                .image(profile.getImage())
                .build();
    }
}
