package com.victory.ddd.china.sample.application.query;

import com.victory.ddd.china.sample.domain.context.relationship.following.IsFollowedSpecification;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class PublicRepresentationQueryService {
    private final ProfileRepo profileRepo;
    private final IsFollowedSpecification isFollowedSpecification;

    @Inject
    public PublicRepresentationQueryService(ProfileRepo profileRepo, IsFollowedSpecification isFollowedSpecification) {
        this.profileRepo = profileRepo;
        this.isFollowedSpecification = isFollowedSpecification;
    }

    public Optional<ProfilePublicRepresentationQueryModel> getPublicRepresentation(String profileOwner,
                                                                                   Optional<String> browser) {
        return profileRepo.
                get(profileOwner).
                map(profile -> {
                    val isFollowing = browser.
                            map(current ->
                                    isFollowedSpecification.isFollowing(profile.getUsername(), current)).
                            orElse(false);
                    return ProfilePublicRepresentationQueryModel.from(profile, isFollowing);
                });
    }
}
