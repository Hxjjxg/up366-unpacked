package com.igexin.sdk.router;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TransferGtcProcess implements com.getui.gtc.base.publish.Subscriber {
    public static final java.lang.String POPUACTION_METHODNAME = "checkTopActivityInfo";
    private static java.lang.String methodName;

    static class a {
        private static final com.igexin.sdk.router.TransferGtcProcess a = new com.igexin.sdk.router.TransferGtcProcess();

        private a() {
        }
    }

    private android.os.Bundle createBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("base-0", getClass().getName());
        bundle.putString("base-1", methodName);
        return bundle;
    }

    public static com.igexin.sdk.router.TransferGtcProcess getInstance() {
        methodName = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
        return com.igexin.sdk.router.TransferGtcProcess.a.a;
    }

    public void receive(android.os.Bundle bundle, android.os.Bundle bundle2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.Throwable th = (java.lang.Throwable) bundle2.getSerializable("base-4");
            if (th != null) {
                arrayList.add(th);
            }
            java.lang.String string = bundle.getString("base-2");
            if (android.text.TextUtils.isEmpty(string)) {
                throw new java.lang.RuntimeException("methodName missed");
            }
            if (POPUACTION_METHODNAME.equals(string)) {
                new com.igexin.push.core.a.c.i();
                bundle2.putSerializable("map", com.igexin.push.core.a.c.i.a(com.getui.gtc.base.GtcProvider.context()));
            }
        } catch (java.lang.Throwable th2) {
            try {
                arrayList.add(th2);
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.igexin.c.a.c.a.a((java.lang.Throwable) it.next());
                }
            } finally {
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.igexin.c.a.c.a.a((java.lang.Throwable) it2.next());
                }
            }
        }
    }

    public android.os.Bundle transferGtcProcess(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        com.getui.gtc.base.GtcProvider.setContext(context);
        android.os.Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString("base-2", str);
        bundleCreateBundle.putParcelable("intent", intent);
        return com.getui.gtc.base.publish.Broker.getInstance().subscribe(bundleCreateBundle);
    }
}
