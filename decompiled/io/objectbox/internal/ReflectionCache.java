package io.objectbox.internal;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ReflectionCache {
    private static final io.objectbox.internal.ReflectionCache instance = new io.objectbox.internal.ReflectionCache();
    private final java.util.Map<java.lang.Class<?>, java.util.Map<java.lang.String, java.lang.reflect.Field>> fields = new java.util.HashMap();

    public static io.objectbox.internal.ReflectionCache getInstance() {
        return instance;
    }

    @javax.annotation.Nonnull
    public synchronized java.lang.reflect.Field getField(java.lang.Class<?> cls, java.lang.String str) {
        java.lang.reflect.Field declaredField;
        java.util.Map<java.lang.String, java.lang.reflect.Field> map = this.fields.get(cls);
        if (map == null) {
            map = new java.util.HashMap<>();
            this.fields.put(cls, map);
        }
        declaredField = map.get(str);
        if (declaredField == null) {
            try {
                declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                map.put(str, declaredField);
            } catch (java.lang.NoSuchFieldException e) {
                throw new java.lang.IllegalStateException(e);
            }
        }
        return declaredField;
    }
}
