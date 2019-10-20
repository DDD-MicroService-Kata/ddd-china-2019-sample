package com.victory.ddd.china.sample.infrastructure.dao;

import lombok.NonNull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface ProfileMapping {
    @Insert("INSERT INTO t_profile(username,bio,image) VALUES(#{username}, #{bio}, #{image})")
    void insert(@NonNull ProfilePO profilePO);

    @Select("SELECT * FROM t_profile WHERE username = #{username}")
    Optional<ProfilePO> findByUsername(String username);
}
