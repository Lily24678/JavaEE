package com.lsy.code.utils;

import java.util.UUID;

public class StringUtils {
    /**
     * 判断字符串为空
     *
     * @param str
     * @return
     */
    public static Boolean isBlank(String str) {
        if (null == str) return true;
        if (str.trim().length() == 0) return true;
        return false;
    }

    /**
     * 判断字符串不为空
     *
     * @param str
     * @return
     */
    public static Boolean isNotBlank(String str) {
        if (null != str && str.trim().length() > 0) return true;
        return false;
    }


    public static String createStrByUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 字符串转16进制字符串
     *
     * @param str
     * @return
     */
    public static String string2HexString(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i);
            String hexString = Integer.toHexString(ascii);
            sb.append(hexString);
        }
        return sb.toString();
    }
}
