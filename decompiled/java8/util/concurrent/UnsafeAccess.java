package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class UnsafeAccess {
    static final sun.misc.Unsafe unsafe;

    static {
        java.lang.reflect.Field declaredField;
        try {
            try {
                declaredField = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            } catch (java.lang.NoSuchFieldException unused) {
                declaredField = sun.misc.Unsafe.class.getDeclaredField("THE_ONE");
            }
            declaredField.setAccessible(true);
            unsafe = (sun.misc.Unsafe) declaredField.get(null);
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }

    private UnsafeAccess() {
    }
}
