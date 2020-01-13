package com.jaywu.enums;

public enum DefinitionType {
    BD("BD"), HD("HD"), HD2("高清");
    private String value;

    DefinitionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
