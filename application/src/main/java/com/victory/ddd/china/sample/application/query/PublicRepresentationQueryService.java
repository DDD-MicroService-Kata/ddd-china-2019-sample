package com.victory.ddd.china.sample.application.query;

import com.victory.ddd.china.sample.domain.context.relationship.following.IsFollowingSpecification;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class PublicRepresentationQueryService {
    private final ProfileRepo profileRepo;
    private final IsFollowingSpecification isFollowingSpecification;

    @Inject
    public PublicRepresentationQueryService(ProfileRepo profileRepo, IsFollowingSpecification isFollowingSpecification) {
        this.profileRepo = profileRepo;
        this.isFollowingSpecification = isFollowingSpecification;
    }

    public Optional<ProfilePublicRepresentationReadModel> getPublicRepresentation(String profileOwner, Optional<String> browser) {
        return profileRepo.
                get(profileOwner).
                map(profile -> {
                    val isFollowing = browser.
                            map(current -> isFollowingSpecification.isFollowing(profile.getUsername(), current)).
                            orElse(false);
                    return ProfilePublicRepresentationReadModel.from(profile, isFollowing);
                });
    }
}
