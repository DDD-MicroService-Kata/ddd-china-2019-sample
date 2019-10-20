package com.victory.ddd.china.sample.infrastructure.providers;

import com.victory.ddd.china.sample.domain.context.relationship.IsUserExistsProvider;

import javax.inject.Named;

@Named
public class IsUserExistsProviderImpl implements IsUserExistsProvider {
    @Override
    public boolean isUserExists(String userName) {
        return false;
    }
}
