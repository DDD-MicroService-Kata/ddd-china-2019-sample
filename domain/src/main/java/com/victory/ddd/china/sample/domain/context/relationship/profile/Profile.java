package com.victory.ddd.china.sample.domain.context.relationship.profile;

import com.victory.ddd.china.sample.domain.types.AggregateRoot;
import com.victory.ddd.china.sample.domain.types.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@AggregateRoot
@Entity
public class Profile {
    private String username;
    private String bio;
    private String image;

    public Profile(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(!Objects.equals(obj.getClass(), Profile.class))
            return false;
        Profile anOtherObj = (Profile) obj;
        return this.getUsername().equals(anOtherObj.getUsername());
    }
}
