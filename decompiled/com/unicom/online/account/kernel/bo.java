package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bo implements java.lang.Runnable {
    public final /* synthetic */ com.unicom.online.account.kernel.bp b;

    public bo(com.unicom.online.account.kernel.bp bpVar) {
        this.b = bpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.lang.System.currentTimeMillis();
            com.unicom.online.account.kernel.ao.o.size();
            for (int i = 0; i < com.unicom.online.account.kernel.ao.o.size(); i++) {
                com.unicom.online.account.kernel.t tVar = (com.unicom.online.account.kernel.t) com.unicom.online.account.kernel.ao.o.get(i);
                java.net.InetAddress[] allByName = java.net.InetAddress.getAllByName(tVar.b);
                if (allByName != null && allByName.length > 0) {
                    com.unicom.online.account.kernel.bp bpVar = this.b;
                    int length = allByName.length;
                    bpVar.getClass();
                    tVar.d = allByName[java.lang.Math.abs(new java.util.Random().nextInt() % length)].getHostAddress();
                    tVar.e = java.lang.System.currentTimeMillis() + 259200000;
                }
            }
            android.content.Context contextB = com.unicom.online.account.kernel.bp.b();
            boolean z = com.unicom.online.account.kernel.ap.b;
            com.unicom.online.account.kernel.bf.b(contextB, new java.util.ArrayList(com.unicom.online.account.kernel.ao.o));
            java.lang.System.currentTimeMillis();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
