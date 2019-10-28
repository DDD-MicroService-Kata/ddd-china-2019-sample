package com.victory.ddd.china.sample.application.usecase.following;

import com.victory.ddd.china.sample.application.build.block.UseCase;
import com.victory.ddd.china.sample.application.exception.NoSuchUserExistsException;
import com.victory.ddd.china.sample.application.read.model.ProfilePublicRepresentationReadModel;
import com.victory.ddd.china.sample.application.read.model.PublicRepresentationService;
import com.victory.ddd.china.sample.domain.context.relationship.following.FollowingService;
import com.victory.ddd.china.sample.domain.user.IsUserExistsSpecification;
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
    private final IsUserExistsSpecification isUserExistsSpecification;

    @Inject
    public FollowUserUseCase(FollowingService followingService,
                             PublicRepresentationService publicRepresentationService,
                             IsUserExistsSpecification isUserExistsSpecification) {
        this.followingService = followingService;
        this.publicRepresentationService = publicRepresentationService;
        this.isUserExistsSpecification = isUserExistsSpecification;
    }

    @Transactional
    public ProfilePublicRepresentationReadModel follow(String currentUser, String toFollow) {
        validateUserExist(toFollow);
        followingService.follow(toFollow, currentUser);
        return markUpResult(currentUser, toFollow);
    }

    private ProfilePublicRepresentationReadModel markUpResult(String currentUser, String toFollow) {
        val publicRepresentation = publicRepresentationService.
                getPublicRepresentation(toFollow, Optional.of(currentUser));
        assert(publicRepresentation.isPresent());
        return publicRepresentation.get();
    }

    private void validateUserExist(String toFollow) {
        if(!isUserExistsSpecification.isUserExists(toFollow)) {
            throw new NoSuchUserExistsException(toFollow);
        }
    }

}
