package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NetworkUtilsUp {
    public static final java.lang.String TYPE_MOBILE = "MOBILE";
    public static final java.lang.String TYPE_NO = "NO";
    public static final java.lang.String TYPE_UNKNOWN = "Unknown";
    public static final java.lang.String TYPE_WIFI = "WIFI";
    private static final com.up366.common.NetworkUtilsUp instance = new com.up366.common.NetworkUtilsUp();
    private volatile boolean connectState;
    private volatile boolean lastConnectState;
    private android.net.ConnectivityManager.NetworkCallback networkCallback;
    private volatile java.lang.String type = TYPE_NO;
    private boolean isCallbackRegistered = false;
    private volatile long lastCheckTime = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    public static boolean isConnected() {
        return instance.connectState;
    }

    public static void initNetworkListener(android.content.Context context) {
        instance.registerNetworkCallback(context);
    }

    public static java.lang.String getNetType() {
        return instance.type;
    }

    public static boolean isWifiConnect() {
        return TYPE_WIFI.equals(instance.type);
    }

    public static boolean isMobileConnect() {
        return TYPE_MOBILE.equals(instance.type);
    }

    private synchronized void registerNetworkCallback(android.content.Context context) {
        if (this.isCallbackRegistered) {
            return;
        }
        final android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return;
        }
        this.networkCallback = new android.net.ConnectivityManager.NetworkCallback() { // from class: com.up366.common.NetworkUtilsUp.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(android.net.Network network) {
                com.up366.common.NetworkUtilsUp.this.updateNetworkStatus(connectivityManager, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(android.net.Network network) {
                com.up366.common.NetworkUtilsUp networkUtilsUp = com.up366.common.NetworkUtilsUp.this;
                android.net.ConnectivityManager connectivityManager2 = connectivityManager;
                networkUtilsUp.updateNetworkStatus(connectivityManager2, connectivityManager2.getActiveNetwork());
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) {
                com.up366.common.NetworkUtilsUp.this.updateNetworkStatus(connectivityManager, network);
            }
        };
        try {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(connectivityManager, this.networkCallback);
            }
            this.isCallbackRegistered = true;
            updateNetworkStatus(connectivityManager, connectivityManager.getActiveNetwork());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("NetworkCallback registration failed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNetworkStatus(android.net.ConnectivityManager connectivityManager, android.net.Network network) {
        android.net.NetworkCapabilities networkCapabilities;
        java.lang.String str;
        try {
            this.lastCheckTime = android.os.SystemClock.uptimeMillis();
            boolean z = false;
            if (network == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null || !networkCapabilities.hasCapability(12)) {
                str = TYPE_NO;
            } else {
                if (networkCapabilities.hasTransport(1)) {
                    str = TYPE_WIFI;
                } else if (networkCapabilities.hasTransport(0)) {
                    str = TYPE_MOBILE;
                } else {
                    str = TYPE_UNKNOWN;
                }
                z = true;
            }
            synchronized (this) {
                this.connectState = z;
                this.type = str;
            }
            if (this.lastConnectState != z) {
                this.lastConnectState = z;
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.common.NetworkUtilsUp$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.common.EventBusUtilsUp.post(new com.up366.common.event.NetStatusChangeEvent());
                    }
                });
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("Network status update failed", e);
        }
    }

    public static boolean isNeedCheck() {
        return android.os.SystemClock.uptimeMillis() - instance.lastCheckTime > com.igexin.push.config.c.s;
    }

    public static void checkNetworkConnect() {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.up366.common.global.GB.get().getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return;
        }
        com.up366.common.NetworkUtilsUp networkUtilsUp = instance;
        networkUtilsUp.lastCheckTime = android.os.SystemClock.uptimeMillis();
        networkUtilsUp.updateNetworkStatus(connectivityManager, connectivityManager.getActiveNetwork());
    }

    private NetworkUtilsUp() {
    }
}
