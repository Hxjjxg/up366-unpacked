package com.davemorrissey.labs.subscaleview.decoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public interface DecoderFactory<T> {
    T make() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException;
}
