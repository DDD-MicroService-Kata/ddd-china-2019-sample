package com.victory.ddd.china.sample.infrastructure.repo;

import com.victory.ddd.china.sample.domain.context.relationship.following.Following;
import com.victory.ddd.china.sample.domain.context.relationship.following.FollowingRepo;
import com.victory.ddd.china.sample.infrastructure.mapping.FollowingMapping;
import com.victory.ddd.china.sample.infrastructure.mapping.FollowingPO;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class FollowingRepoImpl implements FollowingRepo {

    private final FollowingMapping followingMapping;

    @Inject
    public FollowingRepoImpl(FollowingMapping followingMapping) {
        this.followingMapping = followingMapping;
    }

    @Override
    public void save(Following following) {
        val followingPo  = FollowingPO.from(following);
        this.followingMapping.insert(followingPo);
    }

    @Override
    public Optional<Following> get(String followed, String followedBy) {
        return followingMapping.
                getFollowing(followed, followedBy).
                map(FollowingPO::toFollowing);
    }

    @Override
    public void remove(Following following) {
        val followingPo  = FollowingPO.from(following);
        followingMapping.delete(followingPo);
    }
}
