package com.victory.ddd.china.sample.domain.context.relationship.following;

import lombok.val;

import javax.inject.Named;
import java.util.Optional;

@Named
public class UnFollowingService {

    private final FollowingRepo followingRepo;
    private final IsFollowingSpecification isFollowingSpecification;

    public UnFollowingService(FollowingRepo followingRepo, IsFollowingSpecification isFollowingSpecification) {
        this.followingRepo = followingRepo;
        this.isFollowingSpecification = isFollowingSpecification;
    }

    public void unFollow(String toUnFollowUser, String currentUser) {
        val isFollowing = isFollowingSpecification.isFollowing(toUnFollowUser, currentUser);
        if (isFollowing) {
            val following = followingRepo.get(toUnFollowUser, currentUser);
            assert(following.isPresent());
            followingRepo.remove(following.get());
        }
    }
}
