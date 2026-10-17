package com.up366.mobile.common.receiver;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class NetBroadcastReceiver extends android.content.BroadcastReceiver {
    private boolean firstMessage = true;

    public void registerNetListener(android.content.Context context) {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        context.registerReceiver(this, intentFilter);
    }

    public void unRegisterNetListener(android.content.Context context) {
        context.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (this.firstMessage) {
            this.firstMessage = false;
            return;
        }
        com.up366.common.NetworkUtilsUp.checkNetworkConnect();
        java.lang.String netType = com.up366.common.NetworkUtilsUp.getNetType();
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            netType.hashCode();
            if (netType.equals(com.up366.common.NetworkUtilsUp.TYPE_WIFI)) {
                com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().checkProxy();
            } else {
                com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().stopPrivateCloudModel(false);
            }
        }
    }
}
