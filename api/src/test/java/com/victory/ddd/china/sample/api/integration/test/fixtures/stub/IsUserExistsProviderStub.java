package com.victory.ddd.china.sample.api.integration.test.fixtures.stub;

import com.victory.ddd.china.sample.api.integration.test.fixtures.data.Usernames;
import com.victory.ddd.china.sample.domain.context.relationship.IsUserExistsProvider;

import javax.annotation.Priority;
import javax.inject.Named;

@Named
@Priority(Integer.MAX_VALUE)
public class IsUserExistsProviderStub implements IsUserExistsProvider {
    @Override
    public boolean isUserExists(String userName) {
        return Usernames.CURRENT_USER.equals(userName) || Usernames.THE_OTHER_ONE.equals(userName);
    }
}
