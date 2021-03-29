package com.github.mosinpower.kubercrud.api;

import com.github.mosinpower.kubercrud.dto.UserDto;
import com.github.mosinpower.kubercrud.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserApiController implements UserApi {

    private final UserService userService;

    public ResponseEntity<UserDto> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "Created user object", required = true, schema = @Schema())
                                              @Valid
                                              @RequestBody UserDto userDto) {
        UserDto savedUser = null;
        try {
            savedUser = userService.create(userDto);
        } catch (Exception e) {
            log.error("User({}) not saved", userDto, e);
        }

        return savedUser == null ?
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "ID of user", required = true, schema = @Schema())
                                           @PathVariable("userId") Long userId) {
        HttpStatus resultStatus;
        try {
            userService.delete(userId);
            resultStatus = HttpStatus.NO_CONTENT;
        } catch (IllegalArgumentException e) {
            resultStatus = HttpStatus.OK;
            log.warn("No user for deletion with id {}", userId, e);
        } catch (Exception e) {
            resultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Failed to delete user with id {}", userId, e);
        }

        return new ResponseEntity<>(resultStatus);
    }

    public ResponseEntity<UserDto> findUserById(@Parameter(in = ParameterIn.PATH, description = "ID of user", required = true, schema = @Schema())
                                                @PathVariable("userId") Long userId) {
        UserDto result = null;
        HttpStatus resultStatus;
        try {
            result = userService.get(userId);
            resultStatus = result == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        } catch (IllegalArgumentException e) {
            resultStatus = HttpStatus.NOT_FOUND;
            log.warn("No user with id={}", userId, e);
        } catch (Exception e) {
            resultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Couldn't retrive user with id={}", userId, e);
        }

        return new ResponseEntity<>(result, resultStatus);
    }

    public ResponseEntity<Void> updateUser(@Parameter(in = ParameterIn.PATH, description = "ID of user", required = true, schema = @Schema()) @PathVariable("userId") Long userId, @Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema())
    @Valid @RequestBody UserDto userDto) {
        HttpStatus resultStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            boolean updated = userService.update(userDto);
            if (updated) {
                resultStatus = HttpStatus.OK;
            }
        } catch (Exception e) {
            log.error("Couldn't retrive user with id={}", userId, e);
        }

        return new ResponseEntity<>(resultStatus);
    }

}
