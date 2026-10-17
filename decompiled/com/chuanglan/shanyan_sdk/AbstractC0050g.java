package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0050g {
    public static synchronized boolean a(int i, android.content.Context context) {
        try {
            if (!com.chuanglan.shanyan_sdk.AbstractC0055l.C) {
                return true;
            }
            return com.chuanglan.shanyan_sdk.l0.c(context);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "checkProcess Exception", e, "processName", java.lang.Integer.valueOf(i));
            return true;
        }
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_a4", "");
            if (!com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA)) {
                return strA;
            }
            java.lang.String str = com.chuanglan.shanyan_sdk.AbstractC0047d.a() + java.lang.System.currentTimeMillis() + "|" + com.chuanglan.shanyan_sdk.C0065v.g().b() + "|" + com.chuanglan.shanyan_sdk.C0065v.g().f() + "|" + com.chuanglan.shanyan_sdk.C0065v.g().a();
            com.chuanglan.shanyan_sdk.p0.b(context, "cl_jm_a4", str);
            java.lang.String strA2 = com.chuanglan.shanyan_sdk.p0.a(context, com.chuanglan.shanyan_sdk.v0.a, "-1");
            if ((!"-1".equals(strA2)) & com.chuanglan.shanyan_sdk.AbstractC0049f.b(strA2)) {
                com.chuanglan.shanyan_sdk.p0.b(context, "cl_jm_a3", com.chuanglan.shanyan_sdk.AbstractC0045b.b(strA2));
            }
            return str;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void c(android.content.Context context) {
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_a3", ""))) {
            com.chuanglan.shanyan_sdk.p0.b(context, "cl_jm_a3", com.chuanglan.shanyan_sdk.AbstractC0047d.a());
        }
    }

    public static void d(android.content.Context context) {
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_f5", ""))) {
            com.chuanglan.shanyan_sdk.p0.b(context, "cl_jm_f5", com.chuanglan.shanyan_sdk.AbstractC0047d.a() + java.lang.System.currentTimeMillis());
        }
    }

    public static void e(android.content.Context context) {
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_a2", ""))) {
            com.chuanglan.shanyan_sdk.p0.b(context, "cl_jm_a2", com.chuanglan.shanyan_sdk.AbstractC0047d.a() + java.lang.System.currentTimeMillis());
        }
    }

    public static void a(java.lang.Runnable runnable) {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            runnable.run();
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
        }
    }

    public static java.lang.String a() {
        try {
            if (com.chuanglan.shanyan_sdk.AbstractC0055l.F) {
                java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    java.lang.String name = networkInterfaceNextElement.getName();
                    if (name == null || (!name.contains("wlan") && !name.contains("eth0") && !name.contains("ap"))) {
                        java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                        com.chuanglan.shanyan_sdk.Q.a("LogInfoShanYanLogger", "get addresses from system", name);
                        while (inetAddresses.hasMoreElements()) {
                            java.net.InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                                java.lang.String hostAddress = inetAddressNextElement.getHostAddress();
                                com.chuanglan.shanyan_sdk.Q.a("LogInfoShanYanLogger", "get hostAddress from system", hostAddress);
                                if (com.chuanglan.shanyan_sdk.AbstractC0049f.b(hostAddress)) {
                                    com.chuanglan.shanyan_sdk.Q.a("LogInfoShanYanLogger", "get first valid ip from system", hostAddress);
                                    return hostAddress;
                                }
                            }
                        }
                    }
                }
            }
            return "";
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.d("LogInfoShanYanLogger", "getIp exception", e);
            return "";
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        return context == null || context.getPackageManager().checkPermission(str, com.chuanglan.shanyan_sdk.C0065v.g().c(context)) == 0;
    }

    public static void a(android.content.Context context) {
        try {
            for (java.lang.String str : com.chuanglan.shanyan_sdk.AbstractC0061r.d) {
                if (a(context, str)) {
                    com.chuanglan.shanyan_sdk.Q.a("CheckPermissionShanYanLogger", "getPermission success:", str);
                } else {
                    com.chuanglan.shanyan_sdk.Q.a("CheckPermissionShanYanLogger", "getPermission lacks:", str);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getPermission Exception_e:", e);
        }
    }
}
