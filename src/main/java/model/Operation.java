package model;

import java.util.Arrays;

public enum Operation {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/"),
    SQUARE("^2"),
    ROOT("sqrt"),

    EXTRA("extra");

    private final String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static Operation getBySign(String sign) {
        var optionalOperation =  Arrays.stream(Operation.values()).filter(operation -> operation.sign.equals(sign)).findFirst();
        return optionalOperation.orElse(null);
    }
}
