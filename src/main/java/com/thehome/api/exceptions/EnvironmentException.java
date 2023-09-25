package com.thehome.api.exceptions;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnvironmentException extends Exception {
    private String code;
    private String orientation;
}
