package com.victory.ddd.china.sample.infrastructure.mapping;

import lombok.NonNull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapping {
    @Insert("INSERT INTO t_user(username,email,password) VALUES(#{username}, #{email}, #{password})")
    void insert(@NonNull UserPO userPO);

    @Select("SELECT * FROM t_profile WHERE username = #{username}")
    Optional<UserPO> findByUsername(@NonNull String username);
}
