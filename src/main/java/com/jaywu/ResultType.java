package com.jaywu;

public enum ResultType {
    SUCCESS("Success"), FAILED("Failed"), NOT_AUDIO("NotAudio");

    private String value;

    ResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
