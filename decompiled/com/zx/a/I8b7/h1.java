package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class h1 {
    public static final com.zx.a.I8b7.h1.a a;
    public static volatile com.zx.a.I8b7.h1 b;
    public static android.content.Context c;
    public static boolean d;

    public interface a {
        boolean a(android.content.Context context);

        java.lang.String b(android.content.Context context);

        boolean c(android.content.Context context);
    }

    public static class b implements com.zx.a.I8b7.h1.a {
        public static java.lang.String f;
        public static boolean g;
        public static boolean h;
        public static final java.util.concurrent.CountDownLatch i = new java.util.concurrent.CountDownLatch(1);
        public final java.lang.String a;
        public final java.lang.String b;
        public final java.lang.String c;
        public final java.lang.String d;
        public com.zx.a.I8b7.h1.e e;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        public int a() {
            return 1;
        }

        @Override // com.zx.a.I8b7.h1.a
        public boolean a(android.content.Context context) {
            if (context == null || android.text.TextUtils.isEmpty(this.a)) {
                return false;
            }
            if (this.e == null) {
                this.e = new com.zx.a.I8b7.h1.e(this.d, i);
            }
            android.content.Intent intent = new android.content.Intent();
            if (android.text.TextUtils.isEmpty(this.b)) {
                intent.setPackage(this.a);
            } else {
                intent.setComponent(new android.content.ComponentName(this.a, this.b));
            }
            if (!android.text.TextUtils.isEmpty(this.c)) {
                intent.setAction(this.c);
            }
            return this.e.a(context, intent);
        }

        public java.lang.String b() {
            return null;
        }

        @Override // com.zx.a.I8b7.h1.a
        public java.lang.String b(android.content.Context context) {
            com.zx.a.I8b7.h1.e eVar;
            com.zx.a.I8b7.h1.d dVar;
            com.zx.a.I8b7.h1.e eVar2;
            if (!android.text.TextUtils.isEmpty(f) || (eVar = this.e) == null || (dVar = eVar.a) == null) {
                return f;
            }
            try {
                java.lang.String strA = dVar.a(d(context), e(context), b(), a());
                f = strA;
                if (!android.text.TextUtils.isEmpty(strA) && (eVar2 = this.e) != null) {
                    context.unbindService(eVar2);
                }
            } catch (java.lang.Throwable unused) {
            }
            return f;
        }

        @Override // com.zx.a.I8b7.h1.a
        public boolean c(android.content.Context context) {
            if (h) {
                return g;
            }
            boolean z = false;
            if (context == null || android.text.TextUtils.isEmpty(this.a)) {
                g = false;
            } else {
                try {
                    android.content.pm.PackageInfo packageInfoA = com.zx.a.I8b7.t3.a(this.a, 0);
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        if (packageInfoA != null) {
                            if (com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(packageInfoA) >= 1) {
                                return true;
                            }
                        }
                        return false;
                    }
                    if (packageInfoA != null && packageInfoA.versionCode >= 1) {
                        z = true;
                    }
                    g = z;
                } catch (java.lang.Throwable unused) {
                    return false;
                }
            }
            h = true;
            return g;
        }

        public java.lang.String d(android.content.Context context) {
            return null;
        }

        public java.lang.String e(android.content.Context context) {
            return null;
        }
    }

    public static class c implements com.zx.a.I8b7.h1.a {
        public static java.lang.String e;
        public static boolean f;
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String[] c;
        public boolean d = false;

        public c(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.zx.a.I8b7.h1.a
        public boolean a(android.content.Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.h1.a
        public java.lang.String b(android.content.Context context) {
            android.database.Cursor cursorQuery;
            if (android.text.TextUtils.isEmpty(e)) {
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("content://");
                sbA.append(this.a);
                sbA.append("/");
                sbA.append(this.b);
                try {
                    cursorQuery = context.getContentResolver().query(android.net.Uri.parse(sbA.toString()), null, null, this.c, null);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.moveToFirst();
                            e = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        } catch (java.lang.Throwable unused) {
                            try {
                                e = null;
                                return e;
                            } finally {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable unused2) {
                    cursorQuery = null;
                }
                if (cursorQuery != null) {
                }
            }
            return e;
        }

        @Override // com.zx.a.I8b7.h1.a
        public boolean c(android.content.Context context) {
            if (this.d) {
                return f;
            }
            if (context == null) {
                return false;
            }
            try {
                android.content.pm.PackageManager packageManagerD = com.zx.a.I8b7.j4.d(context);
                f = (packageManagerD == null || packageManagerD.resolveContentProvider(this.a, 0) == null) ? false : true;
            } catch (java.lang.Throwable unused) {
                f = false;
            }
            this.d = true;
            return f;
        }
    }

    public static class d implements android.os.IInterface {
        public android.os.IBinder a;
        public java.lang.String b;

        public d(android.os.IBinder iBinder, java.lang.String str) {
            this.a = iBinder;
            this.b = str;
        }

        public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
            android.os.Parcel parcelObtain = android.os.Parcel.obtain();
            android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken(this.b);
                    if (!android.text.TextUtils.isEmpty(str)) {
                        parcelObtain.writeString(str);
                    }
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        parcelObtain.writeString(str2);
                    }
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        parcelObtain.writeString(str3);
                    }
                    this.a.transact(i, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } catch (java.lang.Exception unused) {
                    return "";
                }
            } catch (java.lang.Throwable unused2) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return "";
            }
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.a;
        }
    }

    public static class e implements android.content.ServiceConnection {
        public com.zx.a.I8b7.h1.d a;
        public java.lang.String b;
        public java.util.concurrent.CountDownLatch c;
        public android.os.IBinder d;

        public e(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
            this.b = str;
            this.c = countDownLatch;
        }

        public boolean a(android.content.Context context, android.content.Intent intent) {
            com.zx.a.I8b7.h1.d dVar;
            if (this.a != null) {
                return true;
            }
            try {
                boolean zBindService = context.bindService(intent, this, 1);
                this.c.await(1L, java.util.concurrent.TimeUnit.SECONDS);
                android.os.IBinder iBinder = this.d;
                java.lang.String str = this.b;
                if (iBinder == null) {
                    dVar = null;
                } else {
                    android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(str);
                    dVar = iInterfaceQueryLocalInterface instanceof com.zx.a.I8b7.h1.d ? (com.zx.a.I8b7.h1.d) iInterfaceQueryLocalInterface : new com.zx.a.I8b7.h1.d(iBinder, str);
                }
                this.a = dVar;
                return zBindService;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.d = iBinder;
                this.c.countDown();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            this.a = null;
            this.d = null;
        }
    }

    public static class f extends com.zx.a.I8b7.h1.b {
        public f() {
            super(a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQ="), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuU3VwcGxlbWVudGFyeURJRFNlcnZpY2U="), a("Y29tLmFzdXMubXNhLmFjdGlvbi5BQ0NFU1NfRElE"), a("Y29tLmFzdXMubXNhLlN1cHBsZW1lbnRhcnlESUQuSURpZEFpZGxJbnRlcmZhY2U="));
        }

        public static java.lang.String a(java.lang.String str) {
            return new java.lang.String(android.util.Base64.decode(str, 0));
        }

        @Override // com.zx.a.I8b7.h1.b
        public int a() {
            return 2;
        }
    }

    public static class g extends com.zx.a.I8b7.h1.b {
        public g() {
            super("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService", null, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        @Override // com.zx.a.I8b7.h1.b
        public int a() {
            return 2;
        }
    }

    public static class h extends com.zx.a.I8b7.h1.b {
        public h() {
            super("com.huawei.hwid", null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }
    }

    public static class i extends com.zx.a.I8b7.h1.c {
        public i() {
            super("com.meizu.flyme.openidsdk", "");
        }

        @Override // com.zx.a.I8b7.h1.c, com.zx.a.I8b7.h1.a
        public java.lang.String b(android.content.Context context) {
            this.c = new java.lang.String[]{"oaid"};
            return super.b(context);
        }

        @Override // com.zx.a.I8b7.h1.c, com.zx.a.I8b7.h1.a
        public boolean c(android.content.Context context) {
            if (super.c(context)) {
                com.zx.a.I8b7.h1.c.f = true;
            } else {
                try {
                    android.database.Cursor cursorQuery = context.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"support"}, null);
                    if (cursorQuery == null) {
                        return false;
                    }
                    cursorQuery.moveToFirst();
                    int columnIndex = cursorQuery.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        java.lang.String string = cursorQuery.getString(columnIndex);
                        if (android.text.TextUtils.isEmpty(string)) {
                            return false;
                        }
                        com.zx.a.I8b7.h1.c.f = "0".equals(string);
                    } else {
                        com.zx.a.I8b7.h1.c.f = false;
                    }
                } catch (java.lang.Throwable unused) {
                    com.zx.a.I8b7.h1.c.f = false;
                    return false;
                }
            }
            this.d = true;
            return com.zx.a.I8b7.h1.c.f;
        }
    }

    public static class j implements com.zx.a.I8b7.h1.a {
        public boolean a = false;
        public boolean b = false;
        public java.lang.String c = null;

        @Override // com.zx.a.I8b7.h1.a
        public boolean a(android.content.Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.h1.a
        public java.lang.String b(android.content.Context context) {
            android.os.Bundle bundleCall;
            try {
                if (android.text.TextUtils.isEmpty(this.c)) {
                    android.net.Uri uri = android.net.Uri.parse("content://cn.nubia.identity/identity");
                    int i = android.os.Build.VERSION.SDK_INT;
                    android.content.ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
                    if (contentProviderClientAcquireContentProviderClient != null) {
                        bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                        try {
                            if (i >= 24) {
                                java.lang.Class.forName("android.content.ContentProviderClient").getMethod("close", null).invoke(contentProviderClientAcquireContentProviderClient, null);
                            } else {
                                contentProviderClientAcquireContentProviderClient.release();
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                    } else {
                        bundleCall = null;
                    }
                    if (bundleCall == null) {
                        return this.c;
                    }
                    if (bundleCall.getInt("code", -1) == 0) {
                        this.c = bundleCall.getString(com.igexin.push.core.b.C);
                    }
                }
            } catch (java.lang.Throwable unused2) {
                this.c = null;
            }
            return this.c;
        }

        @Override // com.zx.a.I8b7.h1.a
        public boolean c(android.content.Context context) {
            if (this.b) {
                return this.a;
            }
            if (context == null) {
                return false;
            }
            try {
                android.content.pm.PackageManager packageManagerD = com.zx.a.I8b7.j4.d(context);
                this.a = (packageManagerD == null || packageManagerD.resolveContentProvider("cn.nubia.identity", 0) == null) ? false : true;
            } catch (java.lang.Throwable unused) {
                this.a = false;
            }
            this.b = true;
            return this.a;
        }
    }

    public static class k extends com.zx.a.I8b7.h1.b {
        public java.lang.String j;
        public java.lang.String k;

        public k() {
            super("com.heytap.openid", "com.heytap.openid.IdentifyService", "action.com.heytap.openid.OPEN_ID_SERVICE", "com.heytap.openid.IOpenID");
        }

        @Override // com.zx.a.I8b7.h1.b
        public java.lang.String b() {
            return "OUID";
        }

        @Override // com.zx.a.I8b7.h1.b
        public java.lang.String d(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(this.k)) {
                this.k = context.getPackageName();
            }
            return this.k;
        }

        @Override // com.zx.a.I8b7.h1.b
        public java.lang.String e(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(this.j)) {
                try {
                    if (android.text.TextUtils.isEmpty(this.k)) {
                        this.k = context.getPackageName();
                    }
                    java.lang.String str = this.k;
                    this.k = str;
                    android.content.pm.Signature[] signatureArr = com.zx.a.I8b7.t3.a(str, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] bArrDigest = java.security.MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.j = sb.toString();
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            return this.j;
        }
    }

    public static class l extends com.zx.a.I8b7.h1.b {
        public l() {
            super("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService", null, "com.samsung.android.deviceidservice.IDeviceIdService");
        }
    }

    public static class m extends com.zx.a.I8b7.h1.c {
        public m() {
            super("com.vivo.vms.IdProvider", "IdentifierId/OAID");
        }
    }

    public static class n implements com.zx.a.I8b7.h1.a {
        public static java.lang.String b;
        public java.lang.Class<?> a = null;

        @Override // com.zx.a.I8b7.h1.a
        public boolean a(android.content.Context context) {
            return true;
        }

        @Override // com.zx.a.I8b7.h1.a
        public java.lang.String b(android.content.Context context) {
            if (android.text.TextUtils.isEmpty(b)) {
                try {
                    b = java.lang.String.valueOf(this.a.getMethod("getOAID", android.content.Context.class).invoke(this.a.newInstance(), context));
                } catch (java.lang.Throwable unused) {
                    b = null;
                }
            }
            return b;
        }

        @Override // com.zx.a.I8b7.h1.a
        public boolean c(android.content.Context context) {
            try {
                this.a = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
    }

    public static class o extends com.zx.a.I8b7.h1.b {
        public o() {
            super("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService", null, "com.zui.deviceidservice.IDeviceidInterface");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static {
        com.zx.a.I8b7.h1.a oVar;
        java.lang.String upperCase = android.os.Build.MANUFACTURER.toUpperCase();
        upperCase.getClass();
        upperCase.hashCode();
        byte b2 = -1;
        switch (upperCase.hashCode()) {
            case -2053026509:
                if (upperCase.equals("LENOVO")) {
                    b2 = 0;
                }
                break;
            case -1881642058:
                if (upperCase.equals("REALME")) {
                    b2 = 1;
                }
                break;
            case -1712043046:
                if (upperCase.equals("SAMSUNG")) {
                    b2 = 2;
                }
                break;
            case -1706170181:
                if (upperCase.equals("XIAOMI")) {
                    b2 = 3;
                }
                break;
            case -1134767290:
                if (upperCase.equals("BLACKSHARK")) {
                    b2 = 4;
                }
                break;
            case -602397472:
                if (upperCase.equals("ONEPLUS")) {
                    b2 = 5;
                }
                break;
            case 89198:
                if (upperCase.equals("ZUI")) {
                    b2 = 6;
                }
                break;
            case 89200:
                if (upperCase.equals("ZUK")) {
                    b2 = 7;
                }
                break;
            case 2018896:
                if (upperCase.equals("ASUS")) {
                    b2 = 8;
                }
                break;
            case 2255112:
                if (upperCase.equals("IQOO")) {
                    b2 = 9;
                }
                break;
            case 2432928:
                if (upperCase.equals(com.up366.multimediav2.util.RomUtils.ROM_OPPO)) {
                    b2 = 10;
                }
                break;
            case 2634924:
                if (upperCase.equals(com.up366.multimediav2.util.RomUtils.ROM_VIVO)) {
                    b2 = com.igexin.push.core.b.n.l;
                }
                break;
            case 68924490:
                if (upperCase.equals("HONOR")) {
                    b2 = 12;
                }
                break;
            case 73239724:
                if (upperCase.equals("MEIZU")) {
                    b2 = 13;
                }
                break;
            case 74632627:
                if (upperCase.equals("NUBIA")) {
                    b2 = 14;
                }
                break;
            case 77852109:
                if (upperCase.equals("REDMI")) {
                    b2 = 15;
                }
                break;
            case 630905871:
                if (upperCase.equals("MOTOLORA")) {
                    b2 = 16;
                }
                break;
            case 1670208650:
                if (upperCase.equals("COOLPAD")) {
                    b2 = 17;
                }
                break;
            case 1972178256:
                if (upperCase.equals("HUA_WEI")) {
                    b2 = 18;
                }
                break;
            case 2141820391:
                if (upperCase.equals("HUAWEI")) {
                    b2 = 19;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 6:
            case 7:
            case 16:
                oVar = new com.zx.a.I8b7.h1.o();
                break;
            case 1:
            case 5:
            case 10:
                oVar = new com.zx.a.I8b7.h1.k();
                break;
            case 2:
                oVar = new com.zx.a.I8b7.h1.l();
                break;
            case 3:
            case 4:
            case 15:
                oVar = new com.zx.a.I8b7.h1.n();
                break;
            case 8:
                oVar = new com.zx.a.I8b7.h1.f();
                break;
            case 9:
            case 11:
                oVar = new com.zx.a.I8b7.h1.m();
                break;
            case 12:
            case 18:
            case 19:
                oVar = new com.zx.a.I8b7.h1.h();
                break;
            case 13:
                oVar = new com.zx.a.I8b7.h1.i();
                break;
            case 14:
                oVar = new com.zx.a.I8b7.h1.j();
                break;
            case 17:
                oVar = new com.zx.a.I8b7.h1.g();
                break;
            default:
                oVar = null;
                break;
        }
        a = oVar;
    }

    public static com.zx.a.I8b7.h1 a() {
        if (b == null) {
            synchronized (com.zx.a.I8b7.h1.class) {
                if (b == null) {
                    b = new com.zx.a.I8b7.h1();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(android.content.Context r4) {
        /*
            r3 = this;
            com.zx.a.I8b7.h1$a r0 = com.zx.a.I8b7.h1.a
            if (r0 == 0) goto L22
            if (r4 != 0) goto L7
            goto L22
        L7:
            android.content.Context r4 = r4.getApplicationContext()
            com.zx.a.I8b7.h1.c = r4
            if (r4 != 0) goto L10
            goto L15
        L10:
            boolean r4 = r0.c(r4)     // Catch: java.lang.Throwable -> L15
            goto L16
        L15:
            r4 = 0
        L16:
            if (r4 == 0) goto L22
            com.zx.a.I8b7.h1$a r4 = com.zx.a.I8b7.h1.a
            android.content.Context r0 = com.zx.a.I8b7.h1.c
            boolean r4 = r4.a(r0)
            com.zx.a.I8b7.h1.d = r4
        L22:
            boolean r4 = com.zx.a.I8b7.h1.d
            r0 = 0
            if (r4 == 0) goto L37
            android.content.Context r1 = com.zx.a.I8b7.h1.c     // Catch: java.lang.Throwable -> L37
            if (r1 != 0) goto L2c
            goto L37
        L2c:
            com.zx.a.I8b7.h1$a r2 = com.zx.a.I8b7.h1.a     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L37
            if (r4 != 0) goto L33
            goto L37
        L33:
            java.lang.String r0 = r2.b(r1)     // Catch: java.lang.Throwable -> L37
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.h1.a(android.content.Context):java.lang.String");
    }
}
