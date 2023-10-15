package com.thehome.api.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;

@AllArgsConstructor
public enum PaymentType {

    PIX(0, "Pix"),
    CREDIT_CARD(1, "Credit Card"),
    DEBIT_CARD(2, "Debit Card"),
    MONEY(3, "Money");

    @Getter
    private final int code;

    @Getter
    private final String description;

    public static PaymentType valueOfCodigo(Integer code) {
        return Arrays.stream(PaymentType.values())
                .filter(tipo -> tipo.getCode() == code)
                .findFirst()
                .orElse(null);
    }
}