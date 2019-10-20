package com.victory.ddd.china.sample.domain.context.relationship.following;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FollowingService {

    private final FollowingRepo followingRepo;
    private final IsFollowingSpecification isFollowingSpecification;

    @Inject
    public FollowingService(FollowingRepo followingRepo, IsFollowingSpecification isFollowingSpecification) {
        this.followingRepo = followingRepo;
        this.isFollowingSpecification = isFollowingSpecification;
    }

    public void follow(String toFollow, String currentUser) {
        boolean isFollowed = isFollowingSpecification.isFollowing(toFollow, currentUser);
        if(!isFollowed) {
            Following following = new Following(toFollow, currentUser);
            followingRepo.save(following);
        }
    }
}

