package com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data;

import com.victory.ddd.china.sample.domain.context.relationship.following.Following;
import com.victory.ddd.china.sample.domain.context.relationship.following.FollowingRepo;

import javax.inject.Named;

@Named
public class FollowFixture {
    private final FollowingRepo followingRepo;

    public FollowFixture(FollowingRepo followingRepo) {
        this.followingRepo = followingRepo;
    }

    public Following createTheOtherOneFollowedByCurrent() {
        Following following = new Following(Usernames.THE_OTHER_ONE, Usernames.CURRENT_USER);
        followingRepo.save(following);
        return following;
    }
}
