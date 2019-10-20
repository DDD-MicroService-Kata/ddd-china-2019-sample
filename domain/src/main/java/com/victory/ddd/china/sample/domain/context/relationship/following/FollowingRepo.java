package com.victory.ddd.china.sample.domain.context.relationship.following;

import java.util.Optional;

public interface FollowingRepo {
    void save(Following following);

    Optional<Following> get(String followed, String followedBy);
}
