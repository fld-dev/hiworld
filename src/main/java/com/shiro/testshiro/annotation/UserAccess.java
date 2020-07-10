package com.shiro.testshiro.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解,用来配合切入点表达式做细粒度的锁定目标方法，为目标方法实现拓展功能
@Retention(RetentionPolicy.RUNTIME)//表示此注解修饰的类或方法在运行时有效
//@Retention(RetentionPolicy.SOURCE)//表示此注解修饰的方法在编译时有效
@Target(ElementType.METHOD)//表示此注解只能用来修饰方法
//@Target(ElementType.ANNOTATION_TYPE)表示此注解只能用来修饰类
public @interface UserAccess {
    String value() default "";//此代码块用来表示注解中的参数，这里表示@UserAccess这个注解拥有一个value参数，且此参数的默认值为""
}
