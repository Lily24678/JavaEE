package com.lsy.code.utils;

import java.io.File;

public class FIleUtils {
    public static final String uploadfileDir="/home/smates/temp/JavaEE_Demo/uploadfile/";
    public static final String downloadfileDir="/home/smates/temp/JavaEE_Demo/downloadfile/";
    public static void deleteFile(String filepath){
        File file = new File(filepath);
        if (file.exists())file.delete();
    }

    public static void main(String[] args) {
        deleteFile("/home/smates/temp/JavaEE_Demo/uploadfile/c_0001.png");
    }
}
