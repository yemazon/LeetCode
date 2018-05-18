package com.hipster.phone;

public class NumberPrefixConverter {

    public ValidTextKeyPress transfer(String prefix) {

        if (prefix == null || prefix.length() != 1) {
            throw new IllegalArgumentException("Input is invalid!");
        }

        if (prefix.matches("[a-cA-C]+")) {
            return ValidTextKeyPress.Two;
        } else if (prefix.matches("[d-fD-F]+")) {
            return ValidTextKeyPress.Three;
        } else if (prefix.matches("[g-iG-I]+")) {
            return ValidTextKeyPress.Four;
        } else if (prefix.matches("[j-lJ-L]+")) {
            return ValidTextKeyPress.Five;
        } else if (prefix.matches("[m-oM-O]+")) {
            return ValidTextKeyPress.Six;
        } else if (prefix.matches("[p-sP-S]+")) {
            return ValidTextKeyPress.Seven;
        } else if (prefix.matches("[t-vT-V]+")) {
            return ValidTextKeyPress.Eight;
        } else {
            return ValidTextKeyPress.Nine;
        }
    }
}
