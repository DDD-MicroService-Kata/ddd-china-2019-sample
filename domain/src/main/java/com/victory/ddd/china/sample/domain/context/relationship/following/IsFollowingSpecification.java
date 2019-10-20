package com.victory.ddd.china.sample.domain.context.relationship.following;

import com.victory.ddd.china.sample.domain.types.Specification;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Specification
public class IsFollowingSpecification {
    private final FollowingRepo followingRepo;

    @Inject
    public IsFollowingSpecification(FollowingRepo followingRepo) {
        this.followingRepo = followingRepo;
    }

    public boolean isFollowing(String toFollow, String currentUser) {
        val existedFollow = followingRepo.get(toFollow, currentUser);
        return existedFollow.isPresent();
    }
}
