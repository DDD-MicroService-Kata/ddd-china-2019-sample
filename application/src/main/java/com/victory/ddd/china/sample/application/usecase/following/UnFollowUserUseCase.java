package com.victory.ddd.china.sample.application.usecase.following;

import com.victory.ddd.china.sample.application.query.ProfilePublicRepresentationQueryModel;
import com.victory.ddd.china.sample.application.query.PublicRepresentationQueryService;
import com.victory.ddd.china.sample.domain.context.relationship.following.UnFollowingService;
import lombok.val;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class UnFollowUserUseCase {
    private final UnFollowingService unFollowingService;
    private final PublicRepresentationQueryService publicRepresentationQueryService;

    @Inject
    public UnFollowUserUseCase(UnFollowingService unFollowingService,
                               PublicRepresentationQueryService publicRepresentationQueryService) {

        this.unFollowingService = unFollowingService;
        this.publicRepresentationQueryService = publicRepresentationQueryService;
    }

    @Transactional
    public ProfilePublicRepresentationQueryModel unFollow(String currentUser, String toUnFollowUsername) {
        unFollowingService.unFollow(toUnFollowUsername, currentUser);
        val publicRepresentation = this.publicRepresentationQueryService.
                getPublicRepresentation(toUnFollowUsername, Optional.of(currentUser));
        assert (publicRepresentation.isPresent());
        return publicRepresentation.get();
    }
}
