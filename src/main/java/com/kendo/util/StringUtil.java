package com.kendo.util;

/**
 * @author kendone
 */
public class StringUtil {

    public static boolean isWhitespaceOrTrue(String str) {
        return "".equals(str) || "true".equalsIgnoreCase(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0
                || str.matches("\\s*");
    }

    private StringUtil() {
    }
}
