package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class O {
    private static volatile com.chuanglan.shanyan_sdk.O e;
    private android.content.Context a;
    private android.content.res.Resources b;
    private android.view.LayoutInflater c;
    private int d = 0;

    private O(android.content.Context context) {
        this.a = null;
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = this.a.getResources();
        this.c = android.view.LayoutInflater.from(this.a);
    }

    public static com.chuanglan.shanyan_sdk.O a(android.content.Context context) {
        if (e == null) {
            try {
                e = new com.chuanglan.shanyan_sdk.O(context);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "LCMResource  Exception_e=", e2);
            }
        }
        return e;
    }

    public int b(java.lang.String str) {
        android.content.res.Resources resources = this.b;
        return resources != null ? resources.getIdentifier(str, com.igexin.push.core.b.C, com.chuanglan.shanyan_sdk.C0065v.g().c(this.a)) : this.d;
    }

    public android.view.View c(java.lang.String str) {
        android.content.res.Resources resources = this.b;
        if (resources != null) {
            int identifier = resources.getIdentifier(str, "layout", com.chuanglan.shanyan_sdk.C0065v.g().c(this.a));
            android.view.LayoutInflater layoutInflater = this.c;
            if (layoutInflater != null && identifier != 0) {
                return layoutInflater.inflate(identifier, (android.view.ViewGroup) null);
            }
        }
        return null;
    }

    public int a(java.lang.String str) {
        try {
            android.content.res.Resources resources = this.b;
            if (resources != null) {
                return resources.getIdentifier(str, "anim", com.chuanglan.shanyan_sdk.C0065v.g().c(this.a));
            }
            return this.d;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return this.d;
        }
    }
}
