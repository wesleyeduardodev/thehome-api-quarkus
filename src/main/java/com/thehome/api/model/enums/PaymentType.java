package com.thehome.api.model.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PaymentType {

    PIX(0, "Pix"),
    CREDIT_CARD(1, "Credit Card"),
    DEBIT_CARD(2, "Debit Card"),
    MONEY(3, "Money"),
    OTHER(4, "Other");

    private final int code;

    private final String description;

    public static PaymentType valueOfCodigo(Integer code) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.getCode() == code)
                .findFirst()
                .orElse(null);
    }
}