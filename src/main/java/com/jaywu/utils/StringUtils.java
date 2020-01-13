package com.jaywu.utils;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String removeTargetString(String origin, String target) throws StringUtilsException {
        if (isEmpty(origin))
            throw new StringUtilsException("No input string found");
        if (!isEmpty(target)) {
            return origin.replaceAll(target, "");
        }
        return origin;
    }
}
