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
        description = "Object that represents a client data.",
        name = "ClientResponseDTO",
        type = SchemaType.OBJECT
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientResponseDTO {

    @Schema(
            description = "Client ID",
            implementation = Long.class,
            type = SchemaType.NUMBER
    )
    private Long id;

    @Schema(
            description = "Cliente name",
            implementation = String.class,
            type = SchemaType.STRING
    )
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
}