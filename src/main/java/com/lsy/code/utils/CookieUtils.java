package com.lsy.code.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie getCookie(Cookie[] cookies, String cookie) {
        if (null == cookies) return null;
        for (Cookie c : cookies
        ) {
            if (cookie.equals(c.getName())) return c;
        }
        return null;
    }

}
