package com.igexin.push.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class a {
    private static volatile com.igexin.push.a.a a;

    public static com.igexin.push.a.a a() {
        if (a == null) {
            synchronized (com.igexin.push.a.a.class) {
                if (a == null) {
                    a = new com.igexin.push.a.a();
                }
            }
        }
        return a;
    }

    public static com.igexin.push.a.b a(android.app.Activity activity) {
        java.lang.String stringExtra = activity.getIntent().getStringExtra("action");
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            activity.finish();
            return null;
        }
        stringExtra.hashCode();
        if (stringExtra.equals(com.igexin.push.core.b.r)) {
            return new com.igexin.push.a.g();
        }
        if (stringExtra.equals("com.igexin.action.notification.click")) {
            return new com.igexin.push.a.f();
        }
        activity.finish();
        return null;
    }
}
