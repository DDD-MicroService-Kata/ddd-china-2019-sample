package com.victory.ddd.china.sample.application.usecase.following;

import com.victory.ddd.china.sample.application.build.block.UseCase;
import com.victory.ddd.china.sample.application.query.ProfilePublicRepresentationReadModel;
import com.victory.ddd.china.sample.application.query.PublicRepresentationQueryService;
import com.victory.ddd.china.sample.domain.context.relationship.following.FollowingService;
import lombok.val;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@UseCase
@Named
public class FollowUserUseCase {
    private final FollowingService followingService;
    private final PublicRepresentationQueryService publicRepresentationQueryService;

    @Inject
    public FollowUserUseCase(FollowingService followingService, PublicRepresentationQueryService publicRepresentationQueryService) {
        this.followingService = followingService;
        this.publicRepresentationQueryService = publicRepresentationQueryService;
    }

    @Transactional
    public ProfilePublicRepresentationReadModel follow(String currentUser, String toFollow) {
        followingService.follow(toFollow, currentUser);
        val publicRepresentation = publicRepresentationQueryService.
                getPublicRepresentation(toFollow, Optional.of(currentUser));
        assert(publicRepresentation.isPresent());
        return publicRepresentation.get();
    }

}
