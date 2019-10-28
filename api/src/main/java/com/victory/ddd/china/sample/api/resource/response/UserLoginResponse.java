package com.victory.ddd.china.sample.api.resource.response;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginResponse {
    private String username;
    private String email;
    private String bio;
    private String image;
    private String token;

    public static UserLoginResponse from(User user, Profile profile, String token) {
        return UserLoginResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .bio(profile.getBio())
                .image(profile.getImage())
                .token(token)
                .build();
    }
}
