package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class z3 {
    public final java.lang.String[] a = f();
    public final java.lang.String[] b = d();
    public final java.lang.String[] c = c();

    public static final class b {
        public static final com.zx.a.I8b7.z3 a = new com.zx.a.I8b7.z3();
    }

    @com.zx.module.annotation.Java2C.Method2C
    private native java.lang.String a(com.zx.module.base.Callback callback) throws java.lang.Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str) throws java.lang.Exception;

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str, java.lang.String str2) throws javax.crypto.BadPaddingException, org.json.JSONException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native org.json.JSONObject a() throws org.json.JSONException;

    @com.zx.module.annotation.Java2C.Method2C
    private native void a(org.json.JSONObject jSONObject, com.zx.module.base.Callback callback, int i) throws java.lang.Throwable;

    @com.zx.module.annotation.Java2C.Method2C
    private native java.lang.String b(com.zx.module.base.Callback callback) throws java.lang.Exception;

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] b();

    /* JADX INFO: Access modifiers changed from: private */
    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String c(java.lang.String str);

    @com.zx.module.annotation.Java2C.Method2C
    private native org.json.JSONObject c(com.zx.module.base.Callback callback) throws java.lang.Throwable;

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] c();

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] d();

    @com.zx.module.annotation.Java2C.Method2C
    private native java.lang.String e();

    @com.zx.module.annotation.Java2C.Method2C
    private final native java.lang.String[] f();

    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(org.json.JSONObject r10, com.zx.module.base.Callback r11, int r12) throws java.lang.Throwable {
        /*
            r9 = this;
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            java.lang.String r1 = "android.permission.ACCESS_WIFI_STATE"
            r2 = 0
            boolean r0 = com.zx.a.I8b7.j4.a(r0, r1, r2)
            android.content.Context r1 = com.zx.a.I8b7.x3.a
            java.lang.String r3 = "android.permission.CHANGE_NETWORK_STATE"
            boolean r1 = com.zx.a.I8b7.j4.a(r1, r3, r2)
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r0 == 0) goto Lb4
            if (r1 == 0) goto Lb4
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            java.lang.String r1 = "getUAID:forceSendRequestByMobileData with cb"
            com.zx.a.I8b7.c3.a(r1)
            r1 = 24
            r4 = 1
            if (r3 >= r1) goto L24
            goto L42
        L24:
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L42
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L42
            java.lang.Class r3 = r1.getClass()     // Catch: java.lang.Exception -> L42
            java.lang.String r5 = "getDataEnabled"
            r6 = 0
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r5, r6)     // Catch: java.lang.Exception -> L42
            java.lang.Object r1 = r3.invoke(r1, r6)     // Catch: java.lang.Exception -> L42
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Exception -> L42
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Exception -> L42
            goto L43
        L42:
            r1 = r4
        L43:
            if (r1 == 0) goto La7
            java.lang.String r1 = "wifi"
            java.lang.Object r3 = r0.getSystemService(r1)
            android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3
            boolean r3 = r3.isWifiEnabled()
            if (r3 == 0) goto L73
            java.lang.Object r1 = r0.getSystemService(r1)
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1
            android.net.wifi.WifiInfo r3 = r1.getConnectionInfo()
            if (r3 != 0) goto L61
            r3 = r2
            goto L65
        L61:
            int r3 = r3.getIpAddress()
        L65:
            boolean r1 = r1.isWifiEnabled()
            if (r1 == 0) goto L6f
            if (r3 == 0) goto L6f
            r1 = r4
            goto L70
        L6f:
            r1 = r2
        L70:
            if (r1 == 0) goto L73
            goto L74
        L73:
            r4 = r2
        L74:
            if (r4 == 0) goto L9e
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkRequest$Builder r1 = new android.net.NetworkRequest$Builder
            r1.<init>()
            r3 = 12
            r1.addCapability(r3)
            r1.addTransportType(r2)
            android.net.NetworkRequest r1 = r1.build()
            com.zx.a.I8b7.z3$a r2 = new com.zx.a.I8b7.z3$a
            r3 = r2
            r4 = r9
            r5 = r10
            r6 = r0
            r7 = r11
            r8 = r12
            r3.<init>(r5, r6, r7, r8)
            r0.requestNetwork(r1, r2)
            goto Lbc
        L9e:
            java.lang.String r0 = "zx 网络切换: 直接可以使用移动网络访问"
            com.zx.a.I8b7.c3.a(r0)
            r9.a(r10, r11, r12)
            goto Lbc
        La7:
            java.lang.String r10 = "zx 网络切换: 移动网络不可用，提示请打开移动网络"
            com.zx.a.I8b7.c3.a(r10)
            java.lang.String r10 = r9.a(r10, r4)
            r11.callback(r10)
            goto Lbc
        Lb4:
            java.lang.String r0 = "开始执行getUAID333"
            com.zx.a.I8b7.c3.a(r0)
            r9.a(r10, r11, r12)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.z3.b(org.json.JSONObject, com.zx.module.base.Callback, int):void");
    }

    public final void a(org.json.JSONObject jSONObject, com.zx.module.base.Callback callback, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        if (i == 0) {
            try {
                callback.callback(a(com.zx.a.I8b7.e2.b(jSONObject, str, str2, str3), 0));
                return;
            } catch (java.lang.Throwable th) {
                java.lang.String message = th.getMessage();
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("msg", message);
                jSONObject2.put("code", 10011);
                callback.callback(jSONObject2.toString());
                return;
            }
        }
        if (i != 1) {
            if (i != 2) {
                return;
            }
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put("code", str2);
            jSONObject3.put("type", str);
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            jSONObject4.put("data", jSONObject3);
            jSONObject4.put("code", 0);
            callback.callback(jSONObject4.toString());
            return;
        }
        java.lang.String string = jSONObject.getString("callerId");
        org.json.JSONObject jSONObject5 = new org.json.JSONObject();
        jSONObject5.put("data", com.zx.a.I8b7.w.d(string + "|" + com.zx.a.I8b7.x3.g + "|" + com.zx.a.I8b7.x3.a(com.zx.a.I8b7.x3.h) + "|" + str + "|" + str2, b()[0]));
        jSONObject5.put("code", 0);
        callback.callback(jSONObject5.toString());
    }

    public class a extends android.net.ConnectivityManager.NetworkCallback {
        public android.net.ConnectivityManager a;
        public com.zx.module.base.Callback b;
        public java.util.TimerTask d;
        public org.json.JSONObject e;
        public int f;
        public final java.util.concurrent.atomic.AtomicBoolean g = new java.util.concurrent.atomic.AtomicBoolean(false);
        public java.util.Timer c = new java.util.Timer();

        /* JADX INFO: renamed from: com.zx.a.I8b7.z3$a$a, reason: collision with other inner class name */
        public class C0036a extends java.util.TimerTask {
            public C0036a(com.zx.a.I8b7.z3 z3Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    com.zx.a.I8b7.z3.a aVar = com.zx.a.I8b7.z3.a.this;
                    com.zx.module.base.Callback callback = aVar.b;
                    if (callback != null) {
                        callback.callback(com.zx.a.I8b7.z3.this.a("wifi 情况下切换数据网络超时, 检查是否打开数据网络!", 1));
                    }
                } catch (org.json.JSONException e) {
                    com.zx.a.I8b7.c3.a(e);
                }
            }
        }

        public a(org.json.JSONObject jSONObject, android.net.ConnectivityManager connectivityManager, com.zx.module.base.Callback callback, int i) {
            this.e = jSONObject;
            this.f = i;
            this.a = connectivityManager;
            this.b = callback;
            com.zx.a.I8b7.z3.a.C0036a c0036a = new com.zx.a.I8b7.z3.a.C0036a(com.zx.a.I8b7.z3.this);
            this.d = c0036a;
            this.c.schedule(c0036a, 7000L);
        }

        @com.zx.module.annotation.Java2C.Method2C
        private native void a(android.net.Network network, java.lang.String str);

        public final void b(android.net.Network network) throws java.lang.Exception {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(com.zx.a.I8b7.z3.this.c[0]));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            java.lang.String strSubstring = java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
            java.lang.String strA = com.zx.a.I8b7.z3.this.a(strSubstring);
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(strA);
            bufferedWriter.close();
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.c2.a(com.zx.a.I8b7.e1.b(""), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            httpURLConnection.disconnect();
            jSONObject.getString("msg");
            int i = jSONObject.getInt("result");
            java.lang.String strOptString = jSONObject.optString("data");
            if (i != 0 || android.text.TextUtils.isEmpty(strOptString)) {
                this.b.callback(com.zx.a.I8b7.z3.this.b(jSONObject.toString()));
            } else {
                com.zx.a.I8b7.z3.this.a(this.e, this.b, this.f, "ct", com.zx.a.I8b7.z3.this.a(strSubstring, strOptString), null);
            }
        }

        public final void c(android.net.Network network) throws java.lang.Throwable {
            com.zx.a.I8b7.z3 z3Var = com.zx.a.I8b7.z3.this;
            java.lang.String strC = z3Var.c(z3Var.a[0]);
            com.zx.a.I8b7.c3.a("unicomUAIDNisportalUrl: " + strC);
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(strC));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.connect();
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.c2.a(com.zx.a.I8b7.e1.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b());
            java.lang.String strOptString = jSONObject.optString("authurl");
            if (android.text.TextUtils.isEmpty(strOptString)) {
                this.b.callback(com.zx.a.I8b7.z3.this.b(jSONObject.toString()));
                return;
            }
            java.lang.String strC2 = com.zx.a.I8b7.z3.this.c(strOptString);
            com.zx.a.I8b7.c3.a("unicomUAIDAuthUrl: " + strC2);
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(strC2));
            httpURLConnection2.setConnectTimeout(7000);
            httpURLConnection2.setReadTimeout(7000);
            httpURLConnection2.connect();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(com.zx.a.I8b7.c2.a(com.zx.a.I8b7.e1.b("text/json; charset=utf-8"), httpURLConnection2.getContentLength(), httpURLConnection2.getResponseCode() == 200 ? httpURLConnection2.getInputStream() : httpURLConnection2.getErrorStream()).b());
            java.lang.String strOptString2 = jSONObject2.optString("code");
            if (android.text.TextUtils.isEmpty(strOptString2)) {
                this.b.callback(com.zx.a.I8b7.z3.this.b(jSONObject2.toString()));
                return;
            }
            com.zx.a.I8b7.c3.a("unicomUAID code: " + strOptString2);
            a(network, strOptString2);
            httpURLConnection.disconnect();
            httpURLConnection2.disconnect();
            com.zx.a.I8b7.z3.this.a(this.e, this.b, this.f, "unicom", strOptString2, jSONObject2.optString("province", null));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            try {
                if (this.g.getAndSet(true)) {
                    return;
                }
                com.zx.a.I8b7.c3.a("zx 网络切换: 使用移动网络访问");
                this.d.cancel();
                this.c.cancel();
                java.lang.String strB = com.zx.a.I8b7.j4.b(com.zx.a.I8b7.x3.a);
                if ("中国联通".equals(strB)) {
                    c(network);
                } else if ("中国移动".equals(strB)) {
                    a(network);
                } else if ("中国电信".equals(strB)) {
                    b(network);
                } else {
                    this.b.callback(com.zx.a.I8b7.z3.this.a("暂不支持该运营商", 1));
                }
                this.a.unregisterNetworkCallback(this);
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
                com.zx.module.base.Callback callback = this.b;
                if (callback != null) {
                    try {
                        callback.callback(com.zx.a.I8b7.z3.this.a(th.getMessage(), 1));
                        this.a.unregisterNetworkCallback(this);
                    } catch (org.json.JSONException e) {
                        com.zx.a.I8b7.c3.a(e);
                    }
                }
            }
        }

        public final void a(android.net.Network network) throws java.lang.Throwable {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(com.zx.a.I8b7.z3.this.b[0]));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            org.json.JSONObject jSONObjectA = com.zx.a.I8b7.z3.this.a();
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(jSONObjectA.toString());
            bufferedWriter.close();
            org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.c2.a(com.zx.a.I8b7.e1.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()).b()).getJSONObject("body");
            java.lang.String string = jSONObject.getString("resultCode");
            jSONObject.getString("resultDesc");
            httpURLConnection.disconnect();
            if ("103000".equals(string)) {
                com.zx.a.I8b7.z3.this.a(this.e, this.b, this.f, "cmcc", jSONObject.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN), null);
            } else {
                this.b.callback(com.zx.a.I8b7.z3.this.b(jSONObject.toString()));
            }
        }
    }

    public final java.lang.String b(java.lang.String str) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("msg", str);
        jSONObject.put("code", 10010);
        return jSONObject.toString();
    }

    public final java.lang.String a(java.lang.String str, int i) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("code", i);
        return jSONObject.toString();
    }
}
