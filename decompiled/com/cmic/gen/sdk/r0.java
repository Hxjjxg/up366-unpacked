package com.cmic.gen.sdk;

/* JADX INFO: compiled from: OverTimeUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class r0 {
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.cmic.gen.sdk.auth.GenTokenListener> a = new java.util.concurrent.ConcurrentHashMap<>(16);
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.cmic.gen.sdk.i> b = new java.util.concurrent.ConcurrentHashMap<>();

    public static void a(java.lang.String str, com.cmic.gen.sdk.auth.GenTokenListener genTokenListener) {
        a.put(str, genTokenListener);
    }

    public static com.cmic.gen.sdk.auth.GenTokenListener b(java.lang.String str) {
        return a.get(str);
    }

    public static void c(java.lang.String str) {
        a.remove(str);
    }

    public static boolean d(java.lang.String str) {
        return !a.containsKey(str);
    }

    public static com.cmic.gen.sdk.i a(java.lang.String str) {
        return str != null ? b.get(str) : new com.cmic.gen.sdk.i(0);
    }

    public static void a(java.lang.String str, com.cmic.gen.sdk.i iVar) {
        if (str == null || iVar == null) {
            return;
        }
        b.put(str, iVar);
    }
}
