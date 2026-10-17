package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ab {
    public android.net.Network b = null;
    public com.unicom.online.account.kernel.x c = null;
    public android.net.ConnectivityManager d = null;
    public final java.util.ArrayList e = new java.util.ArrayList();
    public java.util.Timer f = null;

    public final void b(android.content.Context context, com.unicom.online.account.kernel.z zVar) {
        int i = android.os.Build.VERSION.SDK_INT;
        synchronized (this) {
            android.net.Network network = this.b;
            if (network != null) {
                zVar.b(network, true);
                return;
            }
            b(zVar);
            if (this.c == null || this.e.size() < 2) {
                try {
                    try {
                        this.d = (android.net.ConnectivityManager) context.getSystemService("connectivity");
                        android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
                        builder.addTransportType(0);
                        builder.addCapability(12);
                        android.net.NetworkRequest networkRequestBuild = builder.build();
                        this.c = new com.unicom.online.account.kernel.x(this);
                        int i2 = com.unicom.online.account.kernel.ao.u;
                        if (i2 > 2000) {
                            i2 = 2000;
                        }
                        java.lang.Thread.currentThread().getName();
                        java.lang.System.currentTimeMillis();
                        if (i >= 26) {
                            com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(this.d, networkRequestBuild, this.c, i2);
                        } else {
                            java.util.Timer timer = new java.util.Timer();
                            this.f = timer;
                            timer.schedule(new com.unicom.online.account.kernel.y(this), i2);
                            this.d.requestNetwork(networkRequestBuild, this.c);
                        }
                    } catch (java.lang.Exception e) {
                        com.unicom.online.account.kernel.as.b(e);
                        b(false, (android.net.Network) null);
                    }
                } catch (java.lang.Exception e2) {
                    com.unicom.online.account.kernel.as.b(e2);
                    b(false, (android.net.Network) null);
                }
            }
        }
    }

    public final synchronized void b() {
        com.unicom.online.account.kernel.x xVar;
        try {
            java.util.Timer timer = this.f;
            if (timer != null) {
                timer.cancel();
                this.f = null;
            }
            android.net.ConnectivityManager connectivityManager = this.d;
            if (connectivityManager != null && (xVar = this.c) != null) {
                try {
                    connectivityManager.unregisterNetworkCallback(xVar);
                } catch (java.lang.IllegalArgumentException e) {
                    e.getMessage();
                }
            }
            this.d = null;
            this.c = null;
            this.b = null;
            java.util.ArrayList arrayList = this.e;
            if (arrayList != null) {
                arrayList.clear();
            }
        } catch (java.lang.Exception e2) {
            com.unicom.online.account.kernel.as.b(e2);
        }
    }

    public final synchronized void b(com.unicom.online.account.kernel.z zVar) {
        try {
            this.e.add(zVar);
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
        }
    }

    public final synchronized void b(boolean z, android.net.Network network) {
        try {
            java.util.Timer timer = this.f;
            if (timer != null) {
                timer.cancel();
                this.f = null;
            }
            java.util.Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((com.unicom.online.account.kernel.z) it.next()).b(network, z);
            }
            this.e.clear();
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
        }
    }
}
