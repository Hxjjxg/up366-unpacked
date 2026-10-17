package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class x2 {

    public class a extends android.net.ConnectivityManager.NetworkCallback {
        public android.net.ConnectivityManager a;
        public com.zx.a.I8b7.x2.b b;
        public java.util.TimerTask d;
        public final java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
        public java.util.Timer c = new java.util.Timer();

        /* JADX INFO: renamed from: com.zx.a.I8b7.x2$a$a, reason: collision with other inner class name */
        public class C0035a extends java.util.TimerTask {
            public C0035a(com.zx.a.I8b7.x2 x2Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    com.zx.a.I8b7.x2.b bVar = com.zx.a.I8b7.x2.a.this.b;
                    if (bVar != null) {
                        bVar.a(1, "time out 7s!");
                    }
                } catch (java.lang.Throwable th) {
                    com.zx.a.I8b7.c3.a(th);
                }
            }
        }

        public a(com.zx.a.I8b7.x2 x2Var, android.net.ConnectivityManager connectivityManager, com.zx.a.I8b7.x2.b bVar) {
            this.a = connectivityManager;
            this.b = bVar;
            com.zx.a.I8b7.x2.a.C0035a c0035a = new com.zx.a.I8b7.x2.a.C0035a(x2Var);
            this.d = c0035a;
            this.c.schedule(c0035a, 7000L);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            try {
                if (this.e.getAndSet(true)) {
                    return;
                }
                this.d.cancel();
                this.c.cancel();
                this.b.a(network);
                this.a.unregisterNetworkCallback(this);
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
                com.zx.a.I8b7.x2.b bVar = this.b;
                if (bVar != null) {
                    try {
                        bVar.a(1, th.getMessage());
                        this.a.unregisterNetworkCallback(this);
                    } catch (java.lang.Throwable th2) {
                        com.zx.a.I8b7.c3.a(th2);
                    }
                }
            }
        }
    }

    public interface b {
        void a();

        void a(int i, java.lang.String str);

        void a(android.net.Network network);
    }

    public static final class c {
        public static final com.zx.a.I8b7.x2 a = new com.zx.a.I8b7.x2();
    }

    public void a(com.zx.a.I8b7.x2.b bVar) throws java.lang.Throwable {
        boolean zA = com.zx.a.I8b7.j4.a(com.zx.a.I8b7.x3.a, "android.permission.ACCESS_WIFI_STATE", false);
        boolean zA2 = com.zx.a.I8b7.j4.a(com.zx.a.I8b7.x3.a, "android.permission.CHANGE_NETWORK_STATE", false);
        if (zA && zA2 && a(com.zx.a.I8b7.x3.a)) {
            if (!b(com.zx.a.I8b7.x3.a)) {
                bVar.a();
                return;
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.zx.a.I8b7.x3.a.getSystemService("connectivity");
            android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            connectivityManager.requestNetwork(builder.build(), new com.zx.a.I8b7.x2.a(this, connectivityManager, bVar));
        }
    }

    public boolean b(android.content.Context context) {
        if (!((android.net.wifi.WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
            return false;
        }
        android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService("wifi");
        android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return wifiManager.isWifiEnabled() && (connectionInfo == null ? 0 : connectionInfo.getIpAddress()) != 0;
    }

    public boolean a(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return true;
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            return ((java.lang.Boolean) telephonyManager.getClass().getDeclaredMethod("getDataEnabled", null).invoke(telephonyManager, null)).booleanValue();
        } catch (java.lang.Exception unused) {
            return true;
        }
    }
}
