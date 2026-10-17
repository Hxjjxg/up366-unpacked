package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class h0 {
    private java.util.concurrent.ExecutorService a = java.util.concurrent.Executors.newSingleThreadExecutor();

    class a implements java.util.concurrent.Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String call() {
            java.util.Iterator it = com.chuanglan.shanyan_sdk.AbstractC0055l.N.iterator();
            while (it.hasNext()) {
                java.lang.String strA = com.chuanglan.shanyan_sdk.h0.this.a((java.lang.String) it.next());
                if (strA != null) {
                    return strA;
                }
            }
            return "sysdk.cl2009.com";
        }
    }

    public java.lang.String b() {
        try {
            java.util.concurrent.FutureTask futureTaskA = a();
            this.a.execute(futureTaskA);
            return (java.lang.String) futureTaskA.get(2L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.util.concurrent.TimeoutException e) {
            com.chuanglan.shanyan_sdk.Q.d("PreFetchDnsShanYanLogger", "preFetchLogDnsMethod  TimeoutException=", e);
            return "sysdk.cl2009.com";
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("PreFetchDnsShanYanLogger", "preFetchDnsMethod  Exception_e=", e2);
            return "sysdk.cl2009.com";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized java.lang.String a(java.lang.String str) {
        java.lang.String hostAddress;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            java.net.InetAddress[] allByName = java.net.InetAddress.getAllByName(str);
            if (allByName != null) {
                for (java.net.InetAddress inetAddress : allByName) {
                    if (inetAddress != null && (hostAddress = inetAddress.getHostAddress()) != null) {
                        if (!"0.0.0.0".equals(hostAddress) && !"255.255.255.255".equals(hostAddress) && !"127.0.0.1".equals(hostAddress) && !"224.0.0.1".equals(hostAddress) && !hostAddress.startsWith("169.254.") && !hostAddress.contains(" ") && !hostAddress.startsWith("::")) {
                            com.chuanglan.shanyan_sdk.Q.c("PreFetchDnsShanYanLogger", "getDomainName log domainName", str);
                            return str;
                        }
                        com.chuanglan.shanyan_sdk.Q.c("PreFetchDnsShanYanLogger", "getDomainName name", str);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("PreFetchDnsShanYanLogger", "getDomainName  Exception_e=", th, "__耗时", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return null;
    }

    private java.util.concurrent.FutureTask a() {
        return new java.util.concurrent.FutureTask(new com.chuanglan.shanyan_sdk.h0.a());
    }
}
