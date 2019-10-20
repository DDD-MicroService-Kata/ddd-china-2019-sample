package com.victory.ddd.china.sample.domain.context.relationship.following;

import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class IsFollowedSpecification {
    private final FollowingRepo followingRepo;

    @Inject
    public IsFollowedSpecification(FollowingRepo followingRepo) {
        this.followingRepo = followingRepo;
    }

    public boolean isFollowing(String toFollow, String currentUser) {
        val existedFollow = followingRepo.get(toFollow, currentUser);
        return existedFollow.isPresent();
    }
}
