package com.victory.ddd.china.sample.application.usecase.following;

import com.victory.ddd.china.sample.application.build.block.UseCase;
import com.victory.ddd.china.sample.application.read.model.ProfilePublicRepresentationReadModel;
import com.victory.ddd.china.sample.application.read.model.PublicRepresentationService;
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
    private final PublicRepresentationService publicRepresentationService;

    @Inject
    public FollowUserUseCase(FollowingService followingService, PublicRepresentationService publicRepresentationService) {
        this.followingService = followingService;
        this.publicRepresentationService = publicRepresentationService;
    }

    @Transactional
    public ProfilePublicRepresentationReadModel follow(String currentUser, String toFollow) {
        followingService.follow(toFollow, currentUser);
        val publicRepresentation = publicRepresentationService.
                getPublicRepresentation(toFollow, Optional.of(currentUser));
        assert(publicRepresentation.isPresent());
        return publicRepresentation.get();
    }

}
