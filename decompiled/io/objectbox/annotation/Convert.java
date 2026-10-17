package io.objectbox.annotation;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
public @interface Convert {
    java.lang.Class<? extends io.objectbox.converter.PropertyConverter> converter();

    java.lang.Class dbType();
}
