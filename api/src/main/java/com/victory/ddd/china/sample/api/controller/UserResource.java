package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.api.controller.request.CreateUserRequest;
import com.victory.ddd.china.sample.api.controller.request.UpdateUserRequest;
import com.victory.ddd.china.sample.api.controller.request.UserLoginRequest;
import com.victory.ddd.china.sample.api.controller.response.CreateUserResponse;
import com.victory.ddd.china.sample.api.controller.response.QueryUserResponse;
import com.victory.ddd.china.sample.api.controller.response.UpdateUserResponse;
import com.victory.ddd.china.sample.api.controller.response.UserLoginResponse;
import com.victory.ddd.china.sample.application.usecase.user.QueryUserUseCase;
import com.victory.ddd.china.sample.application.usecase.user.RegisterUserUseCase;
import com.victory.ddd.china.sample.application.usecase.user.UpdateUserUseCase;
import com.victory.ddd.china.sample.application.usecase.user.UserLoginUseCase;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.user.User;
import org.apache.commons.lang3.tuple.Triple;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;

@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Context
    SecurityContext securityContext;


    private final RegisterUserUseCase registerUserUseCase;

    private final QueryUserUseCase queryUserUseCase;

    private final UserLoginUseCase userLoginUseCase;

    private final UpdateUserUseCase updateUserUseCase;

    @Autowired
    public UserResource(final RegisterUserUseCase registerUserUseCase,
                        final QueryUserUseCase queryUserUseCase,
                        final UserLoginUseCase userLoginUseCase,
                        final UpdateUserUseCase updateUserUseCase
    ) {
        this.registerUserUseCase = registerUserUseCase;
        this.queryUserUseCase = queryUserUseCase;
        this.userLoginUseCase = userLoginUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @POST
    @Path("/")
    public ResponseEntity<CreateUserResponse> register(CreateUserRequest createUserRequest) {
        Triple<User, Profile, String> triple = registerUserUseCase.register(
                createUserRequest.getEmail(),
                createUserRequest.getUsername(),
                createUserRequest.getPassword()
        );

        return ResponseEntity.created(URI.create("/users/" + createUserRequest.getUsername())).body(
                CreateUserResponse.from(triple.getLeft(), triple.getMiddle(), triple.getRight())
        );
    }

    /**
     * API 文档设计有误，更新用户信息，除了登录不应该再次返回 Token
     *
     * @return
     */
    @GET
    @Path("/")
    public ResponseEntity<QueryUserResponse> getCurrentUser() {
        String username = securityContext.getUserPrincipal().getName();
        Pair<User, Profile> pair = queryUserUseCase.queryUserWithProfile(username);
        return ResponseEntity.ok(
                QueryUserResponse.from(pair.getLeft(), pair.getRight())
        );
    }


    @POST
    @Path("/login")
    public ResponseEntity<UserLoginResponse> login(UserLoginRequest userLoginRequest) {
        Triple<User, Profile, String> triple = userLoginUseCase.login(userLoginRequest.getEmail(), userLoginRequest.getPassword());

        return ResponseEntity.ok(
                UserLoginResponse.from(triple.getLeft(), triple.getMiddle(), triple.getRight())
        );
    }

    /**
     * API 文档设计有误，更新用户信息，不应该允许修改 username、password
     *
     * @return
     */
    @PUT
    @Path("/")
    public ResponseEntity<UpdateUserResponse> updateCurrentUser(UpdateUserRequest updateUserRequest) {
        String username = securityContext.getUserPrincipal().getName();
        updateUserUseCase.updateUserCase(username, updateUserRequest.getBio(), updateUserRequest.getImage());
        return ResponseEntity.ok(
                UpdateUserResponse.from(updateUserRequest.getBio(), updateUserRequest.getImage())
        );
    }
}
