package com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.stub;

import com.victory.ddd.china.sample.adapters.rest.integration.test.fixtures.data.Usernames;
import com.victory.ddd.china.sample.domain.user.IsUserExistsSpecification;

import javax.annotation.Priority;
import javax.inject.Named;

@Named
@Priority(Integer.MAX_VALUE)
public class IsUserExistsProviderStub implements IsUserExistsSpecification {
    @Override
    public boolean isUserExists(String userName) {
        return Usernames.CURRENT_USER.equals(userName) || Usernames.THE_OTHER_ONE.equals(userName);
    }
}
