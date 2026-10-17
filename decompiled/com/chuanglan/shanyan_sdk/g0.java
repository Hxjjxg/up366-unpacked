package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class g0 {
    private java.util.concurrent.ExecutorService a = java.util.concurrent.Executors.newSingleThreadExecutor();

    class a implements java.util.concurrent.Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.String call() {
            java.util.Iterator it = com.chuanglan.shanyan_sdk.AbstractC0055l.M.iterator();
            while (it.hasNext()) {
                java.lang.String strA = com.chuanglan.shanyan_sdk.g0.this.a((java.lang.String) it.next());
                if (strA != null) {
                    return strA;
                }
            }
            return "sy.cl2m.cn";
        }
    }

    public java.lang.String b() {
        try {
            java.util.concurrent.FutureTask futureTaskA = a();
            this.a.execute(futureTaskA);
            return (java.lang.String) futureTaskA.get(2L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.util.concurrent.TimeoutException e) {
            com.chuanglan.shanyan_sdk.Q.d("PreFetchDnsShanYanLogger", "preFetchDnsMethod  TimeoutException=", e);
            return "sy.cl2m.cn";
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("PreFetchDnsShanYanLogger", "preFetchDnsMethod  Exception_e=", e2);
            return "sy.cl2m.cn";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized java.lang.String a(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            java.net.InetAddress[] allByName = java.net.InetAddress.getAllByName(str);
            if (allByName != null) {
                for (java.net.InetAddress inetAddress : allByName) {
                    if (inetAddress != null) {
                        java.lang.String hostAddress = inetAddress.getHostAddress();
                        if (!"0.0.0.0".equals(hostAddress) && !"255.255.255.255".equals(hostAddress) && !"127.0.0.1".equals(hostAddress) && !"224.0.0.1".equals(hostAddress) && !hostAddress.startsWith("169.254.") && !hostAddress.contains(" ") && !hostAddress.startsWith("::")) {
                            com.chuanglan.shanyan_sdk.Q.c("PreFetchDnsShanYanLogger", "getDomainName init domainName", str);
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
        return new java.util.concurrent.FutureTask(new com.chuanglan.shanyan_sdk.g0.a());
    }
}
