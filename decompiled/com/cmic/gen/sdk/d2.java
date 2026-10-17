package com.cmic.gen.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class d2 {
    public com.cmic.gen.sdk.b.a a;
    public android.content.Context b;
    public final com.cmic.gen.sdk.d2.a c = new com.cmic.gen.sdk.d2.a();
    public final com.cmic.gen.sdk.d2.b d = new com.cmic.gen.sdk.d2.b();
    public final java.util.concurrent.CountDownLatch e = new java.util.concurrent.CountDownLatch(2);

    public class a extends com.cmic.gen.sdk.e2.a {
        public a() {
        }

        @Override // com.cmic.gen.sdk.e2
        public void a(int i, long j, boolean z, float f, double d, java.lang.String str) {
        }

        @Override // com.cmic.gen.sdk.e2
        public void a(int i, android.os.Bundle bundle) {
            android.util.Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            try {
                if (i == 0) {
                    try {
                        com.cmic.gen.sdk.b.a aVar = com.cmic.gen.sdk.d2.this.a;
                        if (aVar != null) {
                            aVar.a = bundle.getString("oa_id_flag");
                            android.util.Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult success");
                        }
                    } catch (java.lang.Exception e) {
                        android.util.Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult error: " + e.getMessage());
                    }
                }
            } finally {
                com.cmic.gen.sdk.d2.a(com.cmic.gen.sdk.d2.this);
            }
        }
    }

    public class b extends com.cmic.gen.sdk.e2.a {
        public b() {
        }

        @Override // com.cmic.gen.sdk.e2
        public void a(int i, long j, boolean z, float f, double d, java.lang.String str) {
        }

        @Override // com.cmic.gen.sdk.e2
        public void a(int i, android.os.Bundle bundle) {
            android.util.Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            try {
                if (i == 0) {
                    try {
                        if (com.cmic.gen.sdk.d2.this.a != null) {
                            boolean z = bundle.getBoolean("oa_id_limit_state");
                            com.cmic.gen.sdk.d2.this.a.b = z;
                            android.util.Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult success  isLimit=" + z);
                        }
                    } catch (java.lang.Exception e) {
                        android.util.Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult error:  " + e.getMessage());
                    }
                }
            } finally {
                com.cmic.gen.sdk.d2.a(com.cmic.gen.sdk.d2.this);
            }
        }
    }

    public static void a(com.cmic.gen.sdk.d2 d2Var) {
        d2Var.getClass();
        try {
            d2Var.e.countDown();
        } catch (java.lang.Exception e) {
            android.util.Log.i("AdvertisingIdPlatform", "doCountDown  error:  " + e.getMessage());
        }
    }

    public final void a() {
        android.util.Log.i("AdvertisingIdPlatform", "release");
        try {
            this.e.countDown();
            this.e.countDown();
        } catch (java.lang.Exception e) {
            android.util.Log.e("AdvertisingIdPlatform", "release error=" + e.getMessage() + " : " + e.getClass().getSimpleName());
        }
    }

    public boolean a(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.hihonor.id", 0);
            new android.content.Intent("com.hihonor.id.HnOaIdService").setPackage("com.hihonor.id");
            return !r5.queryIntentServices(r2, 0).isEmpty();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
