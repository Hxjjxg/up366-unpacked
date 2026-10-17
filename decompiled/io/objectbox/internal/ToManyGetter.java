package io.objectbox.internal;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface ToManyGetter<SOURCE, TARGET> extends java.io.Serializable {
    java.util.List<TARGET> getToMany(SOURCE source);
}
