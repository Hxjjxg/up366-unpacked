package com.cmic.gen.sdk;

/* JADX INFO: compiled from: HuaWeiOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class z extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;
    private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b = new java.util.concurrent.LinkedBlockingQueue<>(1);
    private final android.content.ServiceConnection c = new com.cmic.gen.sdk.z.a();

    /* JADX INFO: compiled from: HuaWeiOAID.java */
    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.cmic.gen.sdk.z.this.b.offer(iBinder, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    z(android.content.Context context) {
        this.a = context;
    }

    private static android.content.pm.PackageInfo b(android.content.Context context, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && context != null) {
            try {
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 128);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    private static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        return str.replaceAll("0", "").replaceAll("-", "").isEmpty();
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        java.lang.String string;
        try {
            java.lang.String string2 = android.provider.Settings.Global.getString(this.a.getContentResolver(), "pps_oaid");
            if (!a(string2)) {
                return string2;
            }
            android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(a(this.a));
            if (this.a.bindService(intent, this.c, 1)) {
                try {
                    try {
                        android.os.IBinder iBinderPoll = this.b.poll(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
                        if (iBinderPoll == null) {
                            return "";
                        }
                        android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                        android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                        try {
                            parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                            iBinderPoll.transact(1, parcelObtain, parcelObtain2, 0);
                            parcelObtain2.readException();
                            string = parcelObtain2.readString();
                            parcelObtain.recycle();
                        } catch (java.lang.Throwable th) {
                            try {
                                th.printStackTrace();
                                parcelObtain.recycle();
                                string = "";
                            } catch (java.lang.Throwable th2) {
                                parcelObtain.recycle();
                                parcelObtain2.recycle();
                                throw th2;
                            }
                        }
                        parcelObtain2.recycle();
                        return string;
                    } catch (java.lang.Exception unused) {
                    }
                } finally {
                    this.a.unbindService(this.c);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static java.lang.String a(android.content.Context context) {
        if (a(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        java.lang.String str = "com.huawei.hms";
        if (!a(context, "com.huawei.hms")) {
            str = "com.huawei.hwid.tv";
            if (!a(context, "com.huawei.hwid.tv")) {
                return "com.huawei.hwid";
            }
        }
        return str;
    }

    private static boolean a(android.content.Context context, java.lang.String str) {
        return b(context, str) != null;
    }
}
