package com.lsy.code.utils;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDataConverter implements Converter {
    @Override
    public Object convert(Class aClass, Object o) {
        String dateStr = (String) o;
        SimpleDateFormat spdt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = spdt.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }
}
