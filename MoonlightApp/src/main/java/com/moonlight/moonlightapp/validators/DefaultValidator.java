package com.moonlight.moonlightapp.validators;

public abstract class DefaultValidator {
    public static boolean isBlankOrEmpty(String input) {
        return isNull(input) || input.isEmpty() || input.isBlank();
    }

    public static boolean isNull(Object input) {
        return input == null;
    }

    public static boolean isZeroOrNegative(Integer input) {
        return isNull(input) || input <= 0;
    }

    public static boolean isZeroOrNegative(Double input) {
        return isNull(input) || input <= 0;
    }

    public static boolean isZeroOrNegative(Float input) {
        return isNull(input) || input <= 0;
    }
}
