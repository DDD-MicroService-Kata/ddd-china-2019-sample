package com.victory.ddd.china.sample.adapters.rest.resource.response;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryUserResponse {
    private String username;
    private String email;
    private String bio;
    private String image;

    public static QueryUserResponse from(User user, Profile profile) {
        return QueryUserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .bio(profile.getBio())
                .image(profile.getImage())
                .build();
    }
}
