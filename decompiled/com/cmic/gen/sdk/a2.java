package com.cmic.gen.sdk;

/* JADX INFO: compiled from: WifiNetworkUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class a2 {
    private static com.cmic.gen.sdk.a2 b;
    private android.net.ConnectivityManager a;

    /* JADX INFO: compiled from: WifiNetworkUtils.java */
    class a extends android.net.ConnectivityManager.NetworkCallback {
        final /* synthetic */ com.cmic.gen.sdk.a2.b a;

        a(com.cmic.gen.sdk.a2.b bVar) {
            this.a = bVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            try {
                if (com.cmic.gen.sdk.a2.this.a.getNetworkCapabilities(network).hasTransport(0)) {
                    this.a.a(network, this);
                } else {
                    com.cmic.gen.sdk.h0.b("WifiNetworkUtils", "切换失败，未开启数据网络");
                    this.a.a(null, this);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                this.a.a(null, this);
            }
        }
    }

    /* JADX INFO: compiled from: WifiNetworkUtils.java */
    public interface b {
        void a(android.net.Network network, android.net.ConnectivityManager.NetworkCallback networkCallback);
    }

    private a2(android.content.Context context) {
        try {
            this.a = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static com.cmic.gen.sdk.a2 a(android.content.Context context) {
        if (b == null) {
            synchronized (com.cmic.gen.sdk.a2.class) {
                if (b == null) {
                    b = new com.cmic.gen.sdk.a2(context);
                }
            }
        }
        return b;
    }

    public synchronized void a(com.cmic.gen.sdk.a2.b bVar) {
        if (this.a == null) {
            com.cmic.gen.sdk.h0.b("WifiNetworkUtils", "mConnectivityManager 为空");
            bVar.a(null, null);
            return;
        }
        android.net.NetworkRequest networkRequestBuild = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        com.cmic.gen.sdk.a2.a aVar = new com.cmic.gen.sdk.a2.a(bVar);
        try {
            this.a.requestNetwork(networkRequestBuild, aVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            bVar.a(null, aVar);
        }
    }

    public void a(android.net.ConnectivityManager.NetworkCallback networkCallback) {
        if (this.a == null || networkCallback == null) {
            return;
        }
        try {
            com.cmic.gen.sdk.h0.a("WifiNetworkUtils", "unregisterNetworkCallback");
            this.a.unregisterNetworkCallback(networkCallback);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
