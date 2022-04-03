package com.yourlogo.webproject.test.util;

public enum Timeoutkey {
    TIME_OUT_RESOURCE(10),
    TIME_SLEEP_RESOURCE(2000);


    private final int value;

    Timeoutkey(Integer value) {

        this.value = value;
    }

    public int getValue() {

        return value;
    }
}
