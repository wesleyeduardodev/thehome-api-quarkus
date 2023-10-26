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
        description = "Object that represents the data to create a new task.",
        name = "TaskRequestDTO",
        type = SchemaType.OBJECT
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TaskRequestDTO {

    @Schema(
            description = "Task name",
            implementation = String.class,
            type = SchemaType.STRING
    )
    @NotBlank(message = "Task name is required")
    private String name;
}