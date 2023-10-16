package com.thehome.api.model.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;

@AllArgsConstructor
public enum ProjectStatus {

    VISIT(0, "Visit"),
    BUDGET(1, "Budget"),
    APPROVAL(2, "Approval"),
    PURCHASE_MATERIALS(3, "Purchase Materials"),
    EXECUTION(4, "Execution"),
    FINISHED(5, "Finished");

    @Getter
    private final int code;

    @Getter
    private final String description;

    public static ProjectStatus valueOfCodigo(Integer code) {
        return Arrays.stream(ProjectStatus.values())
                .filter(projectStatus -> projectStatus.getCode() == code)
                .findFirst()
                .orElse(null);
    }
}