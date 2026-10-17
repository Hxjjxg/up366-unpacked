package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class q2 {
    public static org.json.JSONArray b = new org.json.JSONArray();
    public final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    public class a implements android.app.Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: com.zx.a.I8b7.q2$a$a, reason: collision with other inner class name */
        public class RunnableC0034a implements java.lang.Runnable {
            public RunnableC0034a(com.zx.a.I8b7.q2.a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.zx.a.I8b7.w2.a.a.a.c(com.zx.a.I8b7.q2.b.toString());
                } catch (java.lang.Throwable unused) {
                }
            }
        }

        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            try {
                if (com.zx.a.I8b7.q2.this.a() && com.zx.a.I8b7.q2.b.length() < 200) {
                    java.lang.String strA = com.zx.a.I8b7.q2.a((android.view.ViewGroup) activity.findViewById(android.R.id.content));
                    if (android.text.TextUtils.isEmpty(strA)) {
                        return;
                    }
                    com.zx.a.I8b7.q2.b.put(activity.getClass().getName() + "###" + strA + "###" + (java.lang.System.currentTimeMillis() / 1000) + "###" + com.zx.a.I8b7.j4.a("6") + "###" + com.zx.a.I8b7.j4.a(com.up366.mobile.common.helper.UserFunAccreditHelper.FUN_ID_HAND_REVIEW));
                    com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.q2.a.RunnableC0034a(this));
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.q2 a = new com.zx.a.I8b7.q2();
    }

    public static java.lang.String a(android.view.ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount >= 20) {
            childCount = 20;
        }
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof android.webkit.WebView) {
                return ((android.webkit.WebView) childAt).getUrl();
            }
            if (childAt instanceof android.view.ViewGroup) {
                java.lang.String strA = a((android.view.ViewGroup) childAt);
                if (!android.text.TextUtils.isEmpty(strA)) {
                    return strA;
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            if (a() && !this.a.getAndSet(true)) {
                com.zx.a.I8b7.c3.a("zx vb start");
                if (com.zx.a.I8b7.x3.a.getApplicationContext() instanceof android.app.Application) {
                    android.app.Application application = (android.app.Application) com.zx.a.I8b7.x3.a.getApplicationContext();
                    try {
                        b = new org.json.JSONArray(com.zx.a.I8b7.w2.a.a.a.a(6001));
                    } catch (java.lang.Throwable unused) {
                        b = new org.json.JSONArray();
                    }
                    application.registerActivityLifecycleCallbacks(new com.zx.a.I8b7.q2.a());
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public boolean a() {
        try {
            return new org.json.JSONObject(com.zx.a.I8b7.x3.m).has("zxc5");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
