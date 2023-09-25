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
        description = "Object that represents the data to create a new client.",
        name = "ClientRequestDTO",
        type = SchemaType.OBJECT
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientRequestDTO {

    @Schema(
            description = "Cliente name",
            implementation = String.class,
            type = SchemaType.STRING
    )
    @NotBlank(message = "Client name is required")
    private String name;

    @Schema(
            description = "Client CPF",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String cpf;

    @Schema(
            description = "Client CNPJ",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String cnpj;

    @Schema(
            description = "Client telephone",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String telephone;

    @Schema(
            description = "Client email",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String email;

    @Schema(
            description = "Client address",
            implementation = String.class,
            type = SchemaType.STRING
    )
    private String address;
}