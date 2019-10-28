package com.victory.ddd.china.sample.application.usecase.profile;

import com.victory.ddd.china.sample.application.build.block.UseCase;
import com.victory.ddd.china.sample.application.read.model.ProfilePublicRepresentationReadModel;
import com.victory.ddd.china.sample.application.read.model.PublicRepresentationService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@UseCase
@Named
public class QueryPublicRepresentationUseCase {
    private final PublicRepresentationService publicRepresentationService;

    @Inject
    public QueryPublicRepresentationUseCase(PublicRepresentationService publicRepresentationService) {
            this.publicRepresentationService = publicRepresentationService;
    }

    public ProfilePublicRepresentationReadModel get(String userName, Optional<String> currentUser) {
        return this.publicRepresentationService.
                getPublicRepresentation(userName, currentUser).
                orElse(ProfilePublicRepresentationReadModel.defaultInstance());
    }

}

