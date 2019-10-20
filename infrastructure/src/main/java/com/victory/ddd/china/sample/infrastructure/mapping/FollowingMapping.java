package com.victory.ddd.china.sample.infrastructure.mapping;

import lombok.NonNull;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface FollowingMapping {
    @Insert("INSERT INTO t_following(followed, followed_by) VALUES(#{followed}, #{followedBy})")
    void insert(@NonNull FollowingPO followingPO);

    @Select("SELECT * FROM t_following WHERE followed = #{followed} and followed_by = #{followedBy}")
    Optional<FollowingPO> getFollowing(@Param("followed")String followed, @Param("followedBy")String followedBy);


    @Delete("DELETE FROM t_following WHERE followed = #{followed} and followed_by = #{followedBy}")
    void delete(FollowingPO followingPo);
}
