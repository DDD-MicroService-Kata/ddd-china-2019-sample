package com.victory.ddd.china.sample.infrastructure.mapping;

import com.victory.ddd.china.sample.domain.context.relationship.following.Following;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
@AllArgsConstructor
@Builder
public class FollowingPO {
    private String followed;
    private String followedBy;

    public static FollowingPO from(Following following) {
        return new FollowingPO(following.getFollowedUsername(),
                following.getFollowByUsername());
    }

    public static Following toFollowing(FollowingPO followingPO) {
        return new Following(followingPO.followed, followingPO.followedBy);
    }
}
