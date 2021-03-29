package com.github.mosinpower.kubercrud.api;

import com.github.mosinpower.kubercrud.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
public interface UserApi {

    @Operation(summary = "Create user", description = "This can only be done by the logged in user.", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation"),
            @ApiResponse(responseCode = "500", description = "internal error")
    })
    @RequestMapping(value = "/user",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<UserDto> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "Created user object", required = true, schema = @Schema())
                                       @Valid @RequestBody UserDto body);


    @Operation(summary = "", description = "deletes a single user based on the ID supplied", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "user deleted"),
            @ApiResponse(responseCode = "200", description = "not found"),
            @ApiResponse(responseCode = "500", description = "internal error"),
    })
    @DeleteMapping(value = "/user/{userId}", produces = {"application/json"})
    ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "ID of user", required = true, schema = @Schema())
                                    @PathVariable("userId") Long userId);


    @Operation(summary = "", description = "Returns a user based on a single ID, if the user does not have access to the user", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user response", content = @Content(schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "internal error"),
    })
    @GetMapping(value = "/user/{userId}", produces = {"application/json"})
    ResponseEntity<UserDto> findUserById(@Parameter(in = ParameterIn.PATH, description = "ID of user", required = true, schema = @Schema())
                                         @PathVariable("userId") Long userId);


    @Operation(summary = "", description = "Update user with User ID supplied", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user updated"),
            @ApiResponse(responseCode = "500", description = "unexpected error"),
    })
    @PutMapping(value = "/user/{userId}",
            produces = {"application/json"},
            consumes = {"application/json"})
    ResponseEntity<Void> updateUser(@Parameter(in = ParameterIn.PATH, description = "ID of user", required = true, schema = @Schema()) @PathVariable("userId") Long userId, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema())
    @Valid @RequestBody UserDto body);

}

