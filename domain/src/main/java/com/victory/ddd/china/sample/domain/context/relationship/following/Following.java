package com.victory.ddd.china.sample.domain.context.relationship.following;

import com.victory.ddd.china.sample.domain.build.block.AggregateRoot;
import com.victory.ddd.china.sample.domain.build.block.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@AggregateRoot
@ValueObject
public class Following {
    private String followedUsername;
    private String followByUsername;
}


