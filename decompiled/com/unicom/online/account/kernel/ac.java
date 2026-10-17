package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class ac {
    public static void b(android.content.Context context, java.lang.String str) {
        int i;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            android.net.NetworkInfo.State state = connectivityManager.getNetworkInfo(5).getState();
            java.util.Objects.toString(state);
            if (state.compareTo(android.net.NetworkInfo.State.CONNECTED) != 0 && state.compareTo(android.net.NetworkInfo.State.CONNECTING) != 0) {
                java.lang.reflect.Method method = android.net.ConnectivityManager.class.getMethod("startUsingNetworkFeature", java.lang.Integer.TYPE, java.lang.String.class);
                method.setAccessible(true);
                int iIntValue = ((java.lang.Integer) method.invoke(connectivityManager, 0, "enableHIPRI")).intValue();
                if (-1 == iIntValue || iIntValue == 0) {
                    return;
                }
                try {
                    byte[] address = java.net.InetAddress.getByName(str).getAddress();
                    i = (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
                } catch (java.net.UnknownHostException unused) {
                    i = -1;
                }
                if (-1 == i) {
                    return;
                }
                for (int i2 = 0; i2 < 5; i2++) {
                    try {
                        if (connectivityManager.getNetworkInfo(5).getState().compareTo(android.net.NetworkInfo.State.CONNECTED) == 0) {
                            break;
                        }
                        java.lang.Thread.sleep(500L);
                    } catch (java.lang.InterruptedException e) {
                        com.unicom.online.account.kernel.as.b(e);
                        return;
                    }
                }
                java.lang.Class cls = java.lang.Integer.TYPE;
                java.lang.reflect.Method method2 = android.net.ConnectivityManager.class.getMethod("requestRouteToHost", cls, cls);
                method2.setAccessible(true);
                ((java.lang.Boolean) method2.invoke(connectivityManager, 5, java.lang.Integer.valueOf(i))).booleanValue();
            }
        } catch (java.lang.Exception e2) {
            com.unicom.online.account.kernel.as.b(e2);
        }
    }
}
