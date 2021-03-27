package com.github.mosinpower.kubercrud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Validated
@Data
public class ErrorDto {
    @JsonProperty("code")
    private Integer code = null;
    @JsonProperty("message")
    private String message = null;


    @Schema(required = true, description = "Error code")
    @NotNull
    public Integer getCode() {
        return code;
    }

    @Schema(required = true, description = "Error message")
    @NotNull
    public String getMessage() {
        return message;
    }

}
