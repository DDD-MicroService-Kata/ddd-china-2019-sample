package com.victory.ddd.china.sample.application.usecase.profile;

import com.victory.ddd.china.sample.application.query.ProfilePublicRepresentationQueryModel;
import com.victory.ddd.china.sample.application.query.PublicRepresentationQueryService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class QueryPublicRepresentationUseCase {
    private final PublicRepresentationQueryService publicRepresentationQueryService;

    @Inject
    public QueryPublicRepresentationUseCase(PublicRepresentationQueryService publicRepresentationQueryService) {
            this.publicRepresentationQueryService = publicRepresentationQueryService;
    }

    public ProfilePublicRepresentationQueryModel get(String userName, Optional<String> currentUser) {
        return this.publicRepresentationQueryService.
                getPublicRepresentation(userName, currentUser).
                orElse(ProfilePublicRepresentationQueryModel.defaultInstance());
    }

}

