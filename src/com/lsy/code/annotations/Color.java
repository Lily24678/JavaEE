package com.lsy.code.annotations;

public enum Color {
    // 枚举的属性字段正例
    black("",""),blue("","");

    // final 修饰
    private final String describeEN;
    private final String describeCH;

    private Color(String describeEN, String describeCH) {
        this.describeEN = describeEN;
        this.describeCH = describeCH;
    }

    // 没有Setter 方法
    public String getDescribeEN() {
        return describeEN;
    }

    public String getDescribeCH() {
        return describeCH;
    }
}
