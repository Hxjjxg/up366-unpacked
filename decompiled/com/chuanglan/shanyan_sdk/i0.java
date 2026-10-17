package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class i0 {
    private final java.lang.String[] a = {"www.cmpassport.com", "ecm.cmpassport.com", "onekey.cmpassport.com", "onekey1.cmpassport.com", "onekey2.cmpassport.com", "auth.wosms.cn", "msv6.wosms.cn", "card.e.189.cn", "id6.me"};

    class a implements java.util.concurrent.Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Void call() {
            for (java.lang.String str : com.chuanglan.shanyan_sdk.i0.this.a) {
                com.chuanglan.shanyan_sdk.i0.this.a(str);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        try {
            java.net.InetAddress[] allByName = java.net.InetAddress.getAllByName(str);
            if (allByName != null) {
                for (java.net.InetAddress inetAddress : allByName) {
                    if (inetAddress != null) {
                        com.chuanglan.shanyan_sdk.Q.c("PreFetchDnsShanYanLogger", "getDomainName inetAddress", inetAddress, "ip", inetAddress.getHostAddress());
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("PreFetchDnsShanYanLogger", "getDomainName Exception", th);
        }
    }

    public java.util.concurrent.FutureTask a() {
        try {
            return new java.util.concurrent.FutureTask(new com.chuanglan.shanyan_sdk.i0.a());
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.d("PreFetchDnsShanYanLogger", "preFetchDns Exception", e);
            return null;
        }
    }
}
