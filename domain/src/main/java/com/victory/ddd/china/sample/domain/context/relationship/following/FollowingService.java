package com.victory.ddd.china.sample.domain.context.relationship.following;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class FollowingService {

    private final FollowingRepo followingRepo;
    private final IsFollowedSpecification isFollowedSpecification;

    @Inject
    public FollowingService(FollowingRepo followingRepo, IsFollowedSpecification isFollowedSpecification) {
        this.followingRepo = followingRepo;
        this.isFollowedSpecification = isFollowedSpecification;
    }

    public void follow(String toFollow, String currentUser) {
        boolean isFollowed = isFollowedSpecification.isFollowing(toFollow, currentUser);
        if(!isFollowed) {
            Following following = new Following(toFollow, currentUser);
            followingRepo.save(following);
        }
    }
}

