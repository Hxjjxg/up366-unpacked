package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface ArrayPool {
    void clearMemory();

    <T> T get(int i, java.lang.Class<T> cls);

    <T> void put(T t);

    @java.lang.Deprecated
    <T> void put(T t, java.lang.Class<T> cls);
}
