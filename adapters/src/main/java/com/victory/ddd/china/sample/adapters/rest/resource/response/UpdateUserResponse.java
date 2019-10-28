package com.victory.ddd.china.sample.adapters.rest.resource.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUserResponse {
    private String bio;
    private String image;

    public static UpdateUserResponse from(String bio, String image) {
        return UpdateUserResponse.builder()
                .bio(bio)
                .image(image)
                .build();
    }
}
