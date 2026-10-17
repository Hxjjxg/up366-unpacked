package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0046c {
    private static android.os.Handler a;

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.c$a */
    class a implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;

        a(android.content.Context context, java.lang.String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.widget.Toast.makeText(this.a, this.b, 0).show();
        }
    }

    public static int a(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        a = new android.os.Handler(android.os.Looper.getMainLooper());
        a(new com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, str));
    }

    private static void a(java.lang.Runnable runnable) {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }
}
