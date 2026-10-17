package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UmcIPUtils.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class w1 {
    public static java.lang.String[] a(boolean z) {
        java.lang.String[] strArr = {"", ""};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (!z || !networkInterfaceNextElement.getName().toLowerCase().contains("wlan")) {
                    java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        java.net.InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                            java.lang.String hostAddress = inetAddressNextElement.getHostAddress();
                            if (!android.text.TextUtils.isEmpty(hostAddress)) {
                                if (inetAddressNextElement instanceof java.net.Inet6Address) {
                                    sb.append(hostAddress);
                                    sb.append(com.igexin.push.core.b.an);
                                } else if (inetAddressNextElement instanceof java.net.Inet4Address) {
                                    sb2.append(hostAddress);
                                    sb2.append(com.igexin.push.core.b.an);
                                }
                            }
                        }
                    }
                }
            }
            if (!android.text.TextUtils.isEmpty(sb)) {
                sb = sb.delete(sb.length() - 1, sb.length());
            }
            if (!android.text.TextUtils.isEmpty(sb2)) {
                sb2 = sb2.delete(sb2.length() - 1, sb2.length());
            }
            strArr[0] = sb2.toString();
            strArr[1] = sb.toString();
            com.cmic.gen.sdk.h0.a("UmcIPUtils", "onlyMobileDataIp " + z + " IPV6 ip：" + sb.toString());
            com.cmic.gen.sdk.h0.a("UmcIPUtils", "onlyMobileDataIp " + z + " IPV4 ip：" + sb2.toString());
            return strArr;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return strArr;
        }
    }
}
