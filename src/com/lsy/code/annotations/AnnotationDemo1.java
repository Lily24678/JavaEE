package com.lsy.code.annotations;

@Anno1
@Anno2(a = 0,b=false,s="ABC",c = AnnotationDemo1.class, anno1  = @Anno1, color = Color.black, arrs = { "aa", "bb" })// 对带有参数的注解的使用
@Anno3("注解中只有一个属性且属性名是value，则@Anno3(value=\"abc\")中value可以省略不写")
public class AnnotationDemo1 {
    @MyTest
    public void demo1() {
        System.out.println("AnnotationDemo1执行了...");
    }
}

