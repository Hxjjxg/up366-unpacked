package com.cmic.gen.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class b {

    public static final class a {
        public java.lang.String a;
        public boolean b;
    }

    public static com.cmic.gen.sdk.b.a a(android.content.Context context) throws java.io.IOException {
        com.cmic.gen.sdk.b.a aVar;
        java.lang.StringBuilder sb;
        java.lang.String string;
        java.lang.String string2;
        com.cmic.gen.sdk.d2 d2Var = new com.cmic.gen.sdk.d2();
        d2Var.b = context;
        com.cmic.gen.sdk.f2 c0006a = null;
        try {
            android.util.Log.i("AdvertisingIdPlatform", "1.0.3.300 getCache start");
            string = android.provider.Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
            string2 = android.provider.Settings.Global.getString(context.getContentResolver(), "oaid");
            if (android.text.TextUtils.isEmpty(string) || android.text.TextUtils.isEmpty(string2)) {
                android.util.Log.i("AdvertisingIdPlatform", "getCache from sec");
                string = android.provider.Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state");
                string2 = android.provider.Settings.Secure.getString(context.getContentResolver(), "oaid");
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo cache error=" + th);
        }
        if (android.text.TextUtils.isEmpty(string) || android.text.TextUtils.isEmpty(string2)) {
            aVar = null;
        } else {
            boolean z = java.lang.Boolean.parseBoolean(string);
            aVar = new com.cmic.gen.sdk.b.a();
            aVar.b = z;
            aVar.a = string2;
            android.util.Log.i("AdvertisingIdPlatform", "getAdvertisingIdInfo cache success");
        }
        if (aVar != null) {
            return aVar;
        }
        if (!d2Var.a(context)) {
            throw new java.io.IOException("Service not found or advertisingId not available");
        }
        android.util.Log.i("AdvertisingIdPlatform", "bindService start");
        com.cmic.gen.sdk.g2 g2Var = new com.cmic.gen.sdk.g2();
        try {
            try {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("com.hihonor.id.HnOaIdService");
                intent.setPackage("com.hihonor.id");
                if (context.bindService(intent, g2Var, 1)) {
                    android.util.Log.i("AdvertisingIdPlatform", "bind success,start get oaid");
                    d2Var.a = new com.cmic.gen.sdk.b.a();
                    android.os.IBinder iBinderA = g2Var.a();
                    int i = com.cmic.gen.sdk.f2.a.a;
                    if (iBinderA != null) {
                        android.os.IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                        c0006a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.cmic.gen.sdk.f2)) ? new com.cmic.gen.sdk.f2.a.C0006a(iBinderA) : (com.cmic.gen.sdk.f2) iInterfaceQueryLocalInterface;
                    }
                    c0006a.b(d2Var.c);
                    c0006a.a(d2Var.d);
                }
                d2Var.e.await(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
                android.util.Log.i("AdvertisingIdPlatform", "unbindService");
                try {
                    d2Var.b.unbindService(g2Var);
                } catch (java.lang.Exception e) {
                    e = e;
                    sb = new java.lang.StringBuilder("OAIDClientImpl#unbindService error::");
                    sb.append(e.getMessage());
                    android.util.Log.e("AdvertisingIdPlatform", sb.toString());
                }
            } catch (java.lang.Throwable th2) {
                android.util.Log.i("AdvertisingIdPlatform", "unbindService");
                try {
                    d2Var.b.unbindService(g2Var);
                } catch (java.lang.Exception e2) {
                    android.util.Log.e("AdvertisingIdPlatform", "OAIDClientImpl#unbindService error::" + e2.getMessage());
                }
                d2Var.a();
                throw th2;
            }
        } catch (java.lang.Exception e3) {
            android.util.Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e3.getMessage() + " : " + e3.getClass().getSimpleName());
            android.util.Log.i("AdvertisingIdPlatform", "unbindService");
            try {
                d2Var.b.unbindService(g2Var);
            } catch (java.lang.Exception e4) {
                e = e4;
                sb = new java.lang.StringBuilder("OAIDClientImpl#unbindService error::");
                sb.append(e.getMessage());
                android.util.Log.e("AdvertisingIdPlatform", sb.toString());
            }
        }
        d2Var.a();
        return d2Var.a;
    }
}
