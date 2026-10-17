package com.cmic.gen.sdk;

/* JADX INFO: compiled from: BridgeJSUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class g {
    private static com.cmic.gen.sdk.g d;
    private int a = -1;
    private int b = 0;
    private int c = 1;

    private g() {
    }

    public static com.cmic.gen.sdk.g a() {
        if (d == null) {
            synchronized (com.cmic.gen.sdk.g.class) {
                if (d == null) {
                    d = new com.cmic.gen.sdk.g();
                }
            }
        }
        return d;
    }

    public void a(android.view.View view, java.lang.Object obj, java.lang.String str) {
        this.a = this.b;
        try {
            java.lang.reflect.Method method = view.getClass().getMethod("addJavascriptInterface", java.lang.Object.class, java.lang.String.class);
            method.setAccessible(true);
            method.invoke(view, obj, str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void a(android.view.View view, java.lang.String str) {
        this.a = this.c;
        try {
            java.lang.reflect.Method method = view.getClass().getMethod("removeJavascriptInterface", java.lang.String.class);
            method.setAccessible(true);
            method.invoke(view, str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void a(android.view.View view, java.lang.String str, android.webkit.ValueCallback<java.lang.String> valueCallback) throws java.lang.Exception {
        java.lang.Class<?> cls;
        if (this.a != this.c) {
            java.lang.Class<?> cls2 = view.getClass();
            if (cls2.getName().toLowerCase().contains("tencent")) {
                cls = java.lang.Class.forName("com.tencent.smtt.sdk.ValueCallback");
            } else {
                cls = java.lang.Class.forName("android.webkit.ValueCallback");
            }
            java.lang.reflect.Method method = cls2.getMethod("evaluateJavascript", java.lang.String.class, cls);
            method.setAccessible(true);
            method.invoke(view, str, valueCallback);
            return;
        }
        throw new java.lang.RuntimeException("js bridge state is " + this.a);
    }
}
