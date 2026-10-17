package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class x extends android.net.ConnectivityManager.NetworkCallback {
    public final /* synthetic */ com.unicom.online.account.kernel.ab b;

    public x(com.unicom.online.account.kernel.ab abVar) {
        this.b = abVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(android.net.Network network) {
        super.onAvailable(network);
        java.lang.Thread.currentThread().getName();
        java.lang.System.currentTimeMillis();
        com.unicom.online.account.kernel.ab abVar = this.b;
        abVar.b = network;
        abVar.b(true, network);
        try {
            com.unicom.online.account.kernel.ab abVar2 = this.b;
            android.net.NetworkInfo networkInfo = abVar2.d.getNetworkInfo(abVar2.b);
            if (networkInfo != null) {
                java.lang.String extraInfo = networkInfo.getExtraInfo();
                if (android.text.TextUtils.isEmpty(extraInfo)) {
                    return;
                }
                java.lang.String str = com.unicom.online.account.kernel.ao.b;
                com.unicom.online.account.kernel.as.b("APN:" + extraInfo);
                com.unicom.online.account.kernel.ao.t = extraInfo;
            }
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        this.b.b(false, (android.net.Network) null);
        this.b.b();
    }
}
