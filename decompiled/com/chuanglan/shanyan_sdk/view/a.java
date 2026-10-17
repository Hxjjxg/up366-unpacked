package com.chuanglan.shanyan_sdk.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
abstract class a {

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.view.a$a, reason: collision with other inner class name */
    class C0001a implements android.window.OnBackInvokedCallback {
        final /* synthetic */ java.lang.Runnable a;

        C0001a(java.lang.Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            java.lang.Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    static boolean a() {
        return android.os.Build.VERSION.SDK_INT >= 33;
    }

    static java.lang.Object a(android.app.Activity activity, java.lang.Runnable runnable) {
        if (!a()) {
            return null;
        }
        com.chuanglan.shanyan_sdk.view.a.C0001a c0001a = new com.chuanglan.shanyan_sdk.view.a.C0001a(runnable);
        androidx.activity.ComponentDialog$.ExternalSyntheticApiModelOutline0.m(androidx.activity.ComponentDialog$.ExternalSyntheticApiModelOutline0.m(activity), 0, c0001a);
        return c0001a;
    }

    static void a(android.app.Activity activity, java.lang.Object obj) {
        if (!a() || obj == null) {
            return;
        }
        androidx.activity.ComponentDialog$.ExternalSyntheticApiModelOutline0.m(androidx.activity.ComponentDialog$.ExternalSyntheticApiModelOutline0.m(activity), androidx.activity.ComponentDialog$.ExternalSyntheticApiModelOutline0.m(obj));
    }
}
