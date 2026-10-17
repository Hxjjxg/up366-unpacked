package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class n1 {
    public static final byte[] a = {-95, -8, -49, 34, 91, -116, -29, -2, -106, 39, -56, 39, -121, 112, -22, 21};
    public static final byte[] b = {-84, -2, -56, -72, -90, 65, -76, -48, -92, 30, -27, -64, -102, 101, 95, 24};

    public class a extends android.net.ConnectivityManager.NetworkCallback {
        public android.net.ConnectivityManager a;
        public java.util.TimerTask c;
        public final java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean(false);
        public java.util.Timer b = new java.util.Timer();

        /* JADX INFO: renamed from: com.zx.a.I8b7.n1$a$a, reason: collision with other inner class name */
        public class C0032a extends java.util.TimerTask {
            public C0032a(com.zx.a.I8b7.n1.a aVar, com.zx.a.I8b7.n1 n1Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
            }
        }

        public a(android.net.ConnectivityManager connectivityManager) {
            this.a = connectivityManager;
            com.zx.a.I8b7.n1.a.C0032a c0032a = new com.zx.a.I8b7.n1.a.C0032a(this, com.zx.a.I8b7.n1.this);
            this.c = c0032a;
            this.b.schedule(c0032a, 7000L);
        }

        public final void a(android.net.Network network) throws java.lang.Exception {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a(com.zx.a.I8b7.n1.this.c());
            sbA.append(java.net.URLEncoder.encode(com.zx.a.I8b7.x3.i, "UTF-8"));
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) network.openConnection(new java.net.URL(sbA.toString()));
            httpURLConnection.setConnectTimeout(7000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.connect();
            com.zx.a.I8b7.c2 c2VarA = com.zx.a.I8b7.c2.a(com.zx.a.I8b7.e1.b("text/json; charset=utf-8"), httpURLConnection.getContentLength(), httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream());
            java.lang.StringBuilder sbA2 = com.zx.a.I8b7.q3.a("cmd 8 suc!");
            sbA2.append(c2VarA.b());
            com.zx.a.I8b7.c3.a(sbA2.toString());
            httpURLConnection.disconnect();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            try {
                if (this.d.getAndSet(true)) {
                    return;
                }
                this.c.cancel();
                this.b.cancel();
                a(network);
                this.a.unregisterNetworkCallback(this);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.n1 a = new com.zx.a.I8b7.n1();
    }

    public n1() {
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = com.zx.a.I8b7.x3.i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La6
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            java.lang.String r1 = "android.permission.ACCESS_WIFI_STATE"
            r2 = 0
            boolean r0 = com.zx.a.I8b7.j4.a(r0, r1, r2)
            android.content.Context r1 = com.zx.a.I8b7.x3.a
            java.lang.String r3 = "android.permission.CHANGE_NETWORK_STATE"
            boolean r1 = com.zx.a.I8b7.j4.a(r1, r3, r2)
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r0 == 0) goto La3
            if (r1 == 0) goto La3
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            r1 = 24
            r4 = 1
            if (r3 >= r1) goto L27
            goto L45
        L27:
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L45
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Exception -> L45
            java.lang.Class r1 = r0.getClass()     // Catch: java.lang.Exception -> L45
            java.lang.String r3 = "getDataEnabled"
            r5 = 0
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r5)     // Catch: java.lang.Exception -> L45
            java.lang.Object r0 = r1.invoke(r0, r5)     // Catch: java.lang.Exception -> L45
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L45
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L45
            goto L46
        L45:
            r0 = r4
        L46:
            if (r0 == 0) goto La6
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            java.lang.String r1 = "wifi"
            java.lang.Object r3 = r0.getSystemService(r1)
            android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3
            boolean r3 = r3.isWifiEnabled()
            if (r3 == 0) goto L78
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0
            android.net.wifi.WifiInfo r1 = r0.getConnectionInfo()
            if (r1 != 0) goto L66
            r1 = r2
            goto L6a
        L66:
            int r1 = r1.getIpAddress()
        L6a:
            boolean r0 = r0.isWifiEnabled()
            if (r0 == 0) goto L74
            if (r1 == 0) goto L74
            r0 = r4
            goto L75
        L74:
            r0 = r2
        L75:
            if (r0 == 0) goto L78
            goto L79
        L78:
            r4 = r2
        L79:
            if (r4 == 0) goto L9f
            android.content.Context r0 = com.zx.a.I8b7.x3.a
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkRequest$Builder r1 = new android.net.NetworkRequest$Builder
            r1.<init>()
            r3 = 12
            r1.addCapability(r3)
            r1.addTransportType(r2)
            android.net.NetworkRequest r1 = r1.build()
            com.zx.a.I8b7.n1$a r2 = new com.zx.a.I8b7.n1$a
            r2.<init>(r0)
            r0.requestNetwork(r1, r2)
            goto La6
        L9f:
            r6.d()
            goto La6
        La3:
            r6.d()
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.n1.a():void");
    }

    public final java.lang.String[] b() {
        return new java.lang.String[]{"https://nisportal.10010.com:9001", "1073741824000"};
    }

    public final java.lang.String c() throws java.lang.Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new javax.crypto.spec.SecretKeySpec(a, "AES"), new javax.crypto.spec.IvParameterSpec(b));
        return new java.lang.String(cipher.doFinal(android.util.Base64.decode("xxXbFehPQ+Zs/VtAtd6DL3ogem3eY/0zoVy6qWtcMuI5NPlB0yUsMmvUu+oK7CzNKOAIJmt5N8/SdP04E4O7Tw==", 2)), "UTF-8");
    }

    public final void d() {
        try {
            com.zx.a.I8b7.z2 z2Var = new com.zx.a.I8b7.z2(new com.zx.a.I8b7.z2.a());
            com.zx.a.I8b7.y1.a aVar = new com.zx.a.I8b7.y1.a();
            com.zx.a.I8b7.y1.a aVarA = aVar.a(c() + java.net.URLEncoder.encode(com.zx.a.I8b7.x3.i, "UTF-8"));
            aVarA.b = "GET";
            aVarA.e = "unicom uaid nisportal api";
            new com.zx.a.I8b7.q1(z2Var, new com.zx.a.I8b7.y1(aVar)).a();
            com.zx.a.I8b7.c3.a("l t s u c!");
        } catch (java.lang.Throwable unused) {
        }
    }
}
