package com.github.mosinpower.kubercrud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

/**
 * User
 */
@Validated
@Data
public class UserDto {
    @JsonProperty("id")
    private Long id = null;
    @JsonProperty("username")
    private String username = null;
    @JsonProperty("firstName")
    private String firstName = null;
    @JsonProperty("lastName")
    private String lastName = null;
    @JsonProperty("email")
    private String email = null;
    @JsonProperty("phone")
    private String phone = null;


    @Schema(description = "unique id")
    public Long getId() {
        return id;
    }

    @Schema(description = "")
    @Size(max = 256)
    public String getUsername() {
        return username;
    }

    @Schema(description = "")
    public String getFirstName() {
        return firstName;
    }

    @Schema(description = "")
    public String getLastName() {
        return lastName;
    }

    @Schema(description = "")
    public String getEmail() {
        return email;
    }

    @Schema(description = "")
    public String getPhone() {
        return phone;
    }

}
