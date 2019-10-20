package com.victory.ddd.china.sample.infrastructure.mapping;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProfilePO {
    private String username;
    private String bio;
    private String image;

    public static ProfilePO from(Profile theOtherOneProfile) {
        return new ProfilePO(theOtherOneProfile.getUsername(),
                theOtherOneProfile.getBio(),
                theOtherOneProfile.getImage());
    }

    public Profile toProfile() {
        return new Profile(
                this.getUsername(),
                this.getBio(),
                this.image);
    }
}
