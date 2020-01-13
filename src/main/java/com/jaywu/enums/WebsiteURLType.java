package com.jaywu.enums;

public enum WebsiteURLType {
    MovieHeavenURL("[电影天堂www.dy2018.com]"),SunshineMovieURL("[阳光电影-www.ygdy8.com]");

    private String value;

    WebsiteURLType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}