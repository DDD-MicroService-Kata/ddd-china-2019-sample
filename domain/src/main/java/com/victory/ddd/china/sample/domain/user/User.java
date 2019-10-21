package com.victory.ddd.china.sample.domain.user;

import com.victory.ddd.china.sample.domain.types.AggregateRoot;
import com.victory.ddd.china.sample.domain.types.Entity;
import lombok.Getter;
import lombok.Setter;

@AggregateRoot
@Getter
@Entity
public class User {
    private String username;
    private String email;
    private String password;
}
