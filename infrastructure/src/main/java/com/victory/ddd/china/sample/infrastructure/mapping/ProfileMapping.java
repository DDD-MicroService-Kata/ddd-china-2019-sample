package com.victory.ddd.china.sample.infrastructure.mapping;

import lombok.NonNull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Optional;

@Mapper
public interface ProfileMapping {
    @Insert("INSERT INTO t_profile(username,bio,image) VALUES(#{username}, #{bio}, #{image})")
    void insert(@NonNull ProfilePO profilePO);

    @Update("UPDATE t_profile set bio=#{profilePo.bio},image=#{profilePo.image} where username=#{username}")
    void update(@NonNull @Param("username") String username, @NonNull @Param("profilePo") ProfilePO profilePo);

    @Select("SELECT * FROM t_profile WHERE username = #{username}")
    Optional<ProfilePO> findByUsername(@NonNull String username);
}

