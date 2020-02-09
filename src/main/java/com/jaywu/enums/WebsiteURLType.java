package com.jaywu.enums;

public enum WebsiteURLType {
    MovieHeavenURL("[电影天堂www.dy2018.com]"),SunshineMovieURL("[阳光电影-www.ygdy8.com]"),
    MoveHeavenURL2("[电影天堂www.dytt89.com]"),MoveHeavenURL3("电影天堂.www.dy2018.com");

    private String value;

    WebsiteURLType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}