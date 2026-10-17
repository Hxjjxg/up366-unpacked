package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public final class C0067x implements android.app.Application.ActivityLifecycleCallbacks {
    private static volatile com.chuanglan.shanyan_sdk.C0067x h;
    private final android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());
    private final java.util.concurrent.CopyOnWriteArrayList b = new java.util.concurrent.CopyOnWriteArrayList();
    private boolean c = false;
    private final java.util.HashSet d = new java.util.HashSet();
    private final java.util.HashSet e = new java.util.HashSet();
    private final java.lang.Object f = new java.lang.Object();
    private java.lang.Runnable g;

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.x$a */
    class a implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;

        a(int i, java.lang.String str) {
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.C0067x.this.g = null;
            synchronized (com.chuanglan.shanyan_sdk.C0067x.this.f) {
                com.chuanglan.shanyan_sdk.C0067x.this.a();
                boolean z = com.chuanglan.shanyan_sdk.C0067x.this.d.isEmpty() && com.chuanglan.shanyan_sdk.C0067x.this.e.isEmpty();
                boolean z2 = com.chuanglan.shanyan_sdk.C0067x.this.d.contains(java.lang.Integer.valueOf(this.a)) || com.chuanglan.shanyan_sdk.C0067x.this.e.contains(java.lang.Integer.valueOf(this.a));
                if (!z || z2 || com.chuanglan.shanyan_sdk.C0067x.this.d() <= 0) {
                    com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onApplicationEnterBackground", "isEmpty=", java.lang.Boolean.valueOf(z), "isSameActivityRestarted=", java.lang.Boolean.valueOf(z2), "started=", java.lang.Integer.valueOf(com.chuanglan.shanyan_sdk.C0067x.this.d.size()), "resumed=", java.lang.Integer.valueOf(com.chuanglan.shanyan_sdk.C0067x.this.e.size()));
                } else {
                    com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onApplicationEnterBackground", this.b);
                    com.chuanglan.shanyan_sdk.C0067x.this.f();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.x$b */
    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.C0067x.this.f();
        }
    }

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.x$c */
    public interface c {
        void a();
    }

    private C0067x() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onActivityCreated", activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
        synchronized (this.f) {
            int iIdentityHashCode = java.lang.System.identityHashCode(activity);
            this.d.remove(java.lang.Integer.valueOf(iIdentityHashCode));
            this.e.remove(java.lang.Integer.valueOf(iIdentityHashCode));
            java.lang.Runnable runnable = this.g;
            if (runnable != null) {
                this.a.removeCallbacks(runnable);
                this.g = null;
            }
        }
        com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onActivityDestroyed", activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        synchronized (this.f) {
            this.e.remove(java.lang.Integer.valueOf(java.lang.System.identityHashCode(activity)));
            com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onActivityPaused", activity.getClass().getSimpleName() + ", resumed=" + this.e.size());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        boolean z;
        try {
            synchronized (this.f) {
                this.e.add(java.lang.Integer.valueOf(java.lang.System.identityHashCode(activity)));
                boolean zIsEmpty = this.e.isEmpty();
                com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onActivityResumed", activity.getClass().getSimpleName() + ", resumed=" + this.e.size());
                z = zIsEmpty && !this.e.isEmpty() && d() > 0;
            }
            if (z) {
                com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onApplicationEnterForeground", "App entered foreground");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        synchronized (this.f) {
            this.d.add(java.lang.Integer.valueOf(java.lang.System.identityHashCode(activity)));
            com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onActivityStarted", activity.getClass().getSimpleName() + ", started=" + this.d.size());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        try {
            int iIdentityHashCode = java.lang.System.identityHashCode(activity);
            java.lang.String simpleName = activity.getClass().getSimpleName();
            synchronized (this.f) {
                this.d.remove(java.lang.Integer.valueOf(iIdentityHashCode));
                com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onActivityStopped", simpleName + ", started=" + this.d.size() + ", resumed=" + this.e.size());
                if (this.d.isEmpty() && this.e.isEmpty() && d() > 0) {
                    java.lang.Runnable runnable = this.g;
                    if (runnable != null) {
                        this.a.removeCallbacks(runnable);
                        this.g = null;
                    }
                    com.chuanglan.shanyan_sdk.C0067x.a aVar = new com.chuanglan.shanyan_sdk.C0067x.a(iIdentityHashCode, simpleName);
                    this.g = aVar;
                    this.a.postDelayed(aVar, 50L);
                    com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "onActivityStopped", simpleName);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void c() {
        synchronized (com.chuanglan.shanyan_sdk.C0067x.class) {
            if (h != null) {
                h.b();
                h = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        java.util.Iterator it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((java.lang.ref.WeakReference) it.next()).get() != null) {
                i++;
            }
        }
        return i;
    }

    public static com.chuanglan.shanyan_sdk.C0067x e() {
        if (h == null) {
            synchronized (com.chuanglan.shanyan_sdk.C0067x.class) {
                if (h == null) {
                    h = new com.chuanglan.shanyan_sdk.C0067x();
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        a();
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            this.a.post(new com.chuanglan.shanyan_sdk.C0067x.b());
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            com.chuanglan.shanyan_sdk.C0067x.c cVar = (com.chuanglan.shanyan_sdk.C0067x.c) ((java.lang.ref.WeakReference) it.next()).get();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        java.util.Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((com.chuanglan.shanyan_sdk.C0067x.c) it2.next()).a();
        }
    }

    public void b(android.app.Application application, com.chuanglan.shanyan_sdk.C0067x.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            a();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.ref.WeakReference weakReference : this.b) {
                com.chuanglan.shanyan_sdk.C0067x.c cVar2 = (com.chuanglan.shanyan_sdk.C0067x.c) weakReference.get();
                if (cVar2 == null || cVar2 == cVar) {
                    arrayList.add(weakReference);
                }
            }
            this.b.removeAll(arrayList);
            if (d() == 0 && this.c) {
                this.c = false;
                application.unregisterActivityLifecycleCallbacks(this);
                synchronized (this.f) {
                    this.d.clear();
                    this.e.clear();
                }
                this.a.removeCallbacksAndMessages(null);
                this.g = null;
                com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "unregisterListener");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void a(android.app.Application application, com.chuanglan.shanyan_sdk.C0067x.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            a();
            java.util.Iterator it = this.b.iterator();
            while (it.hasNext()) {
                if (((com.chuanglan.shanyan_sdk.C0067x.c) ((java.lang.ref.WeakReference) it.next()).get()) == cVar) {
                    return;
                }
            }
            this.b.add(new java.lang.ref.WeakReference(cVar));
            if (this.c) {
                return;
            }
            this.c = true;
            application.registerActivityLifecycleCallbacks(this);
            synchronized (this.f) {
                this.d.clear();
                this.e.clear();
            }
            com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "registerListener", java.lang.Integer.valueOf(this.b.size()));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.ref.WeakReference weakReference : this.b) {
            if (weakReference.get() == null) {
                arrayList.add(weakReference);
            }
        }
        this.b.removeAll(arrayList);
    }

    private void b() {
        this.a.removeCallbacksAndMessages(null);
        synchronized (this.f) {
            this.b.clear();
            this.d.clear();
            this.e.clear();
            this.c = false;
            this.g = null;
        }
        com.chuanglan.shanyan_sdk.Q.a("ActivityLifecycleShanYanLogger", "Foreback instance destroyed");
    }
}
