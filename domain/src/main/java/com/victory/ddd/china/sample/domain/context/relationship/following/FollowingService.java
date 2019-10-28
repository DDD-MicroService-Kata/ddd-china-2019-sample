package com.victory.ddd.china.sample.domain.context.relationship.following;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FollowingService {

    private final FollowingRepo followingRepo;
    private final IsFollowingSpecification isFollowingSpecification;
    private final IsUserExistsProvider isUserExistsProvider;

    @Inject
    public FollowingService(FollowingRepo followingRepo,
                            IsFollowingSpecification isFollowingSpecification, IsUserExistsProvider isUserExistsProvider) {
        this.followingRepo = followingRepo;
        this.isFollowingSpecification = isFollowingSpecification;
        this.isUserExistsProvider = isUserExistsProvider;
    }

    public void follow(String toFollow, String currentUser) {
        validateUserExists(toFollow);
        boolean isFollowed = isFollowingSpecification.isFollowing(toFollow, currentUser);
        if(!isFollowed) {
            Following following = new Following(toFollow, currentUser);
            followingRepo.save(following);
        }
    }

    private void validateUserExists(String toFollow) {
        if(!isUserExistsProvider.isUserExists(toFollow)) {
            throw new NoSuchUserToFollowException(toFollow);
        }
    }
}

