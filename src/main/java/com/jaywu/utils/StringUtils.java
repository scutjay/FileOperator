package com.jaywu.utils;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String removeTargetString(String origin, String target) throws StringUtilsException {
        String rtn = origin;
        if (isEmpty(origin))
            throw new StringUtilsException("No input string found");
        if (!isEmpty(target)) {
            int idx;
            while((idx = rtn.indexOf(target)) >= 0)
                rtn = rtn.substring(0, idx) + rtn.substring(idx + target.length());
        }
        return rtn;
    }
}
