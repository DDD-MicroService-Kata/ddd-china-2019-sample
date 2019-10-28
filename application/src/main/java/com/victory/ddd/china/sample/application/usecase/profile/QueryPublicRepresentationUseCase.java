package com.victory.ddd.china.sample.application.usecase.profile;

import com.victory.ddd.china.sample.application.build.block.UseCase;
import com.victory.ddd.china.sample.application.read.model.ProfilePublicRepresentationReadModel;
import com.victory.ddd.china.sample.application.read.model.PublicRepresentationQueryService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@UseCase
@Named
public class QueryPublicRepresentationUseCase {
    private final PublicRepresentationQueryService publicRepresentationQueryService;

    @Inject
    public QueryPublicRepresentationUseCase(PublicRepresentationQueryService publicRepresentationQueryService) {
            this.publicRepresentationQueryService = publicRepresentationQueryService;
    }

    public ProfilePublicRepresentationReadModel get(String userName, Optional<String> currentUser) {
        return this.publicRepresentationQueryService.
                getPublicRepresentation(userName, currentUser).
                orElse(ProfilePublicRepresentationReadModel.defaultInstance());
    }

}

