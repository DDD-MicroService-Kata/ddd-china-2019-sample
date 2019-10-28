package com.victory.ddd.china.sample.application.usecase.following;

import com.victory.ddd.china.sample.application.build.block.UseCase;
import com.victory.ddd.china.sample.application.read.model.ProfilePublicRepresentationReadModel;
import com.victory.ddd.china.sample.application.read.model.PublicRepresentationService;
import com.victory.ddd.china.sample.domain.context.relationship.following.UnFollowingService;
import lombok.val;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@UseCase
@Named
public class UnFollowUserUseCase {
    private final UnFollowingService unFollowingService;
    private final PublicRepresentationService publicRepresentationService;

    @Inject
    public UnFollowUserUseCase(UnFollowingService unFollowingService,
                               PublicRepresentationService publicRepresentationService) {

        this.unFollowingService = unFollowingService;
        this.publicRepresentationService = publicRepresentationService;
    }

    @Transactional
    public ProfilePublicRepresentationReadModel unFollow(String currentUser, String toUnFollowUsername) {
        unFollowingService.unFollow(toUnFollowUsername, currentUser);
        val publicRepresentation = this.publicRepresentationService.
                getPublicRepresentation(toUnFollowUsername, Optional.of(currentUser));
        assert (publicRepresentation.isPresent());
        return publicRepresentation.get();
    }
}
