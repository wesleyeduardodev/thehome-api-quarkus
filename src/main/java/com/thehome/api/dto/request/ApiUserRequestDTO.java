package com.thehome.api.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Object that represents the data to create a new user.",
        name = "ApiUserRequestDTO",
        type = SchemaType.OBJECT
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiUserRequestDTO {

    @Schema(
            description = "User name",
            implementation = String.class,
            type = SchemaType.STRING
    )
    @NotBlank(message = "User name is required")
    private String userName;

    @Schema(
            description = "User password",
            implementation = String.class,
            type = SchemaType.STRING
    )
    @NotBlank(message = "User password is required")
    private String password;

    @Schema(
            description = "User role",
            implementation = String.class,
            type = SchemaType.STRING
    )
    @NotBlank(message = "User role is required")
    private String role;
}