package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class j4 {
    public static android.content.pm.PackageManager a;
    public static com.zx.a.I8b7.i2 b;
    public static java.util.HashMap<java.lang.String, java.lang.String> c = new java.util.HashMap<>();
    public static final java.util.HashMap<java.lang.String, java.lang.Boolean> d;

    static {
        java.util.HashMap<java.lang.String, java.lang.Boolean> map = new java.util.HashMap<>();
        java.lang.Boolean bool = java.lang.Boolean.TRUE;
        map.put("00000000-0000-0000-0000-000000000000", bool);
        map.put("00000000000000000000000000000000", bool);
        map.put(com.igexin.push.core.b.m, bool);
        map.put("0000000000000000000000000000000000000000000000000000000000000000", bool);
        map.put("", bool);
        map.put(null, bool);
        d = map;
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a(java.lang.String str);

    public static boolean a(android.content.Context context, java.lang.String str, boolean z) {
        try {
            return d(context).checkPermission(str, context.getPackageName()) == 0;
        } catch (java.lang.Throwable th) {
            try {
                com.zx.a.I8b7.c3.a.a.a.a.a(4, null, null, th);
                return z;
            } catch (java.lang.Throwable unused) {
                return z;
            }
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String b(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native boolean b(java.lang.String str);

    @com.zx.module.annotation.Java2C.Method2C
    public static native int c(android.content.Context context);

    public static android.content.pm.PackageManager d(android.content.Context context) {
        if (a == null) {
            a = context.getPackageManager();
        }
        return a;
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String d();

    @com.zx.module.annotation.Java2C.Method2C
    public static native com.zx.a.I8b7.i2 e(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String e();

    @com.zx.module.annotation.Java2C.Method2C
    private static native boolean f(android.content.Context context);

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String g();

    public static boolean g(android.content.Context context) {
        try {
            if (context == null) {
                context = null;
                try {
                    java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null);
                    declaredMethod.setAccessible(true);
                    context = (android.content.Context) declaredMethod.invoke(null, null);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
            if (context != null) {
                java.lang.String str = context.getApplicationInfo().processName;
                java.lang.String strF = f();
                if (str != null) {
                    if (str.equals(strF)) {
                        return true;
                    }
                }
                return false;
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String h();

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String i();

    public static boolean j() throws java.lang.Throwable {
        try {
            return new org.json.JSONObject(com.zx.a.I8b7.x3.m).has("zxc4");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean k() {
        try {
            return (com.zx.a.I8b7.x3.a.getApplicationInfo().flags & 2) != 0;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a("j4", th);
            return true;
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native int l();

    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f() {
        /*
            java.lang.String r0 = "/proc/"
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L27
            r3 = 28
            if (r2 < r3) goto Lf
            java.lang.String r0 = com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m()     // Catch: java.lang.Throwable -> L27
            goto L7d
        Lf:
            java.lang.String r2 = "android.app.ActivityThread"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "currentProcessName"
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r1)     // Catch: java.lang.Throwable -> L27
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Throwable -> L27
            java.lang.Object r2 = r2.invoke(r1, r1)     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L27
            r0 = r2
            goto L7d
        L27:
            r2 = move-exception
            r2.printStackTrace()
            int r2 = android.os.Process.myPid()
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L64
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L64
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r5.append(r2)     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = "/cmdline"
            r5.append(r0)     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L64
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L64
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L62
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L58
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L62
        L58:
            r1 = r0
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L73
        L5d:
            r0 = move-exception
            r0.printStackTrace()
            goto L73
        L62:
            r0 = move-exception
            goto L66
        L64:
            r0 = move-exception
            r3 = r1
        L66:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7e
            if (r3 == 0) goto L73
            r3.close()     // Catch: java.io.IOException -> L6f
            goto L73
        L6f:
            r0 = move-exception
            r0.printStackTrace()
        L73:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L7b
            r0 = r1
            goto L7d
        L7b:
            java.lang.String r0 = "unknown.process"
        L7d:
            return r0
        L7e:
            r0 = move-exception
            if (r3 == 0) goto L89
            r3.close()     // Catch: java.io.IOException -> L85
            goto L89
        L85:
            r1 = move-exception
            r1.printStackTrace()
        L89:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.j4.f():java.lang.String");
    }

    public static boolean a(android.content.Context context, boolean z) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return z;
        }
    }

    public static java.lang.String c() {
        java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
        java.lang.String str = "";
        if (strArr != null && strArr.length > 0) {
            for (java.lang.String str2 : strArr) {
                str = str + str2 + com.igexin.push.core.b.an;
            }
        }
        return str;
    }

    public static java.lang.String b() {
        try {
            java.lang.String str = android.os.Build.BRAND;
            return (android.text.TextUtils.isEmpty(str) || str.equals("unknown")) ? android.os.Build.MANUFACTURER : str;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
            return "";
        }
    }

    public static android.content.pm.PackageInfo c(java.lang.String str) {
        try {
            return com.zx.a.I8b7.t3.a(str, 0);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject) {
        long jLastModified;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            java.lang.String absolutePath = com.zx.a.I8b7.x3.a.getExternalFilesDir(null).getParentFile().getParentFile().getAbsolutePath();
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                org.json.JSONArray jSONArray2 = jSONObject.getJSONArray(next);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    try {
                        jLastModified = new java.io.File(absolutePath + "/" + next + "/" + jSONArray2.getString(i)).lastModified() / 1000;
                    } catch (java.lang.Throwable unused) {
                        jLastModified = 0;
                    }
                    jSONArray.put(jLastModified);
                }
                jSONObject2.put(next, jSONArray);
            }
        } catch (java.lang.Throwable unused2) {
        }
        return jSONObject2;
    }

    public static java.lang.String a(java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str) {
        return map.containsKey(str) ? map.get(str) : "";
    }

    public static javax.crypto.Cipher a(int i) throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, new javax.crypto.spec.SecretKeySpec(android.util.Base64.decode("5B2l1AZMmqOanvxq+udGBw==", 2), "AES"), new javax.crypto.spec.IvParameterSpec(android.util.Base64.decode("PwxJxtddgqbC+tq14Vrmxx==", 2)));
        return cipher;
    }
}
