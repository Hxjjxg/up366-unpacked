package com.up366.asmlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
public @interface AsmMethodReplace {
    boolean hook() default false;

    java.lang.String targetClass();

    java.lang.String targetDesc() default "";

    int targetMethodOpcode();

    java.lang.String targetName() default "";
}
