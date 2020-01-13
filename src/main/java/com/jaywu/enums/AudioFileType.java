package com.jaywu.enums;

public enum AudioFileType {
    MKV("mkv"), MP4("mp4"), RMVB("rmvb"), AVI("avi");

    private String value;

    AudioFileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
