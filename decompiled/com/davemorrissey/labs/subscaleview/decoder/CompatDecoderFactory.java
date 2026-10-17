package com.davemorrissey.labs.subscaleview.decoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CompatDecoderFactory<T> implements com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<T> {
    private final android.graphics.Bitmap.Config bitmapConfig;
    private final java.lang.Class<? extends T> clazz;

    public CompatDecoderFactory(java.lang.Class<? extends T> cls) {
        this(cls, null);
    }

    public CompatDecoderFactory(java.lang.Class<? extends T> cls, android.graphics.Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.DecoderFactory
    public T make() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
        return this.bitmapConfig == null ? this.clazz.newInstance() : this.clazz.getConstructor(android.graphics.Bitmap.Config.class).newInstance(this.bitmapConfig);
    }
}
