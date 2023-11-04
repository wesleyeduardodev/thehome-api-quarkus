package com.thehome.api.dto.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Object that represents a user data.",
        name = "ApiUserResponseDTO",
        type = SchemaType.OBJECT
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiUserResponseDTO {

    @Schema(
            description = "User ID",
            implementation = Long.class,
            type = SchemaType.NUMBER
    )
    private Long id;


    @Schema(
            description = "User name",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String userName;

    @Schema(
            description = "User password",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String password;

    @Schema(
            description = "User role",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String role;
}