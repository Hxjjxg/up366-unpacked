package com.up366.mobile.cloud;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudMgr {
    public static final java.lang.String HTTP = "http://";
    public static final java.lang.String OPLOG_TAG = "private_cloud";
    private static final int check_over = 2;
    private static final int checking = 1;
    private static final int no_check = 0;
    private android.os.Handler mHandler;
    private final com.up366.mobile.common.logic.Manager manager;
    private com.up366.mobile.cloud.model.ServerInfo serverInfo;
    private java.util.List<com.up366.mobile.cloud.model.ServerInfo> servers = new java.util.ArrayList();
    private java.util.List<com.up366.mobile.cloud.CheckResultCallback> callbacks = new java.util.ArrayList();
    private int checkState = 0;

    public PrivateCloudMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("cloud_state");
        handlerThread.start();
        this.mHandler = new android.os.Handler(handlerThread.getLooper());
    }

    public void startPrivateCloudModel(final java.util.List<com.up366.mobile.common.logic.model.AppConfigMiniCloud> list) {
        this.mHandler.post(new java.lang.Runnable() { // from class: com.up366.mobile.cloud.PrivateCloudMgr$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startPrivateCloudModel$0(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPrivateCloudModel$0(java.util.List list) {
        this.checkState = 0;
        this.serverInfo = null;
        if (list == null) {
            getAllServerAddress();
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.common.logic.model.AppConfigMiniCloud appConfigMiniCloud = (com.up366.mobile.common.logic.model.AppConfigMiniCloud) it.next();
            com.up366.mobile.cloud.model.ServerInfo serverInfo = new com.up366.mobile.cloud.model.ServerInfo();
            serverInfo.setOrganId(appConfigMiniCloud.getOrganId());
            serverInfo.setServerId(appConfigMiniCloud.getServerId());
            serverInfo.setServerIp(appConfigMiniCloud.getServerIp());
            serverInfo.setPort(appConfigMiniCloud.getPort());
            arrayList.add(serverInfo);
        }
        netDateCheck(arrayList);
    }

    public void stopPrivateCloudModel(final boolean z) {
        this.mHandler.post(new java.lang.Runnable() { // from class: com.up366.mobile.cloud.PrivateCloudMgr$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopPrivateCloudModel$1(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopPrivateCloudModel$1(boolean z) {
        com.up366.common.log.Logger.info("PrivateCloudMgr stopPrivateCloudModel");
        if (z) {
            this.servers.clear();
        }
        notifyUiCloudNullOrError(-2);
    }

    private void getAllServerAddress() {
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.cloud.model.ServerInfo>>(com.up366.mobile.common.http.HttpMgrUtils.GET_PRIVATE_SERVER_LIST) { // from class: com.up366.mobile.cloud.PrivateCloudMgr.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("organId", java.lang.String.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId()));
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.cloud.model.ServerInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                com.up366.common.log.Logger.info("PrivateCloudMgr getAllServerAddress result=" + str);
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.cloud.model.ServerInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.cloud.model.ServerInfo> list) {
                super.onResponse(response, list);
                if (response.isError() || list == null) {
                    com.up366.common.log.Logger.info("PrivateCloudMgr getAllServerAddress  minicloud/list pull null and check consumeTime=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                    com.up366.mobile.cloud.PrivateCloudMgr.this.notifyUiCloudNullOrError(-2);
                    return;
                }
                com.up366.common.log.Logger.info("PrivateCloudMgr getAllServerAddress  minicloud/list pull consumeTime=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                com.up366.mobile.cloud.PrivateCloudMgr.this.netDateCheck(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void netDateCheck(java.util.List<com.up366.mobile.cloud.model.ServerInfo> list) {
        java.util.Iterator<com.up366.mobile.cloud.model.ServerInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getPort() == 0) {
                it.remove();
            }
        }
        this.servers.clear();
        this.servers.addAll(list);
        if (this.servers.isEmpty()) {
            com.up366.common.log.Logger.info("PrivateCloudMgr getAllServerAddress  minicloud/list null no check");
            notifyUiCloudNullOrError(-2);
        } else {
            checkProxy();
        }
    }

    public void checkProxy() {
        this.mHandler.post(new java.lang.Runnable() { // from class: com.up366.mobile.cloud.PrivateCloudMgr$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkProxy$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkProxy$2() {
        if (this.servers.isEmpty()) {
            com.up366.common.log.Logger.info("PrivateCloudMgr checkProxy  minicloud/list null no check");
            notifyUiCloudNullOrError(-2);
        } else {
            if (this.checkState == 1) {
                return;
            }
            this.checkState = 1;
            this.serverInfo = null;
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(1));
            com.up366.mobile.cloud.PrivateCloudCheck.startCheck(this.servers, new com.up366.mobile.cloud.PrivateCloudCheck.CheckCallback() { // from class: com.up366.mobile.cloud.PrivateCloudMgr$$ExternalSyntheticLambda6
                @Override // com.up366.mobile.cloud.PrivateCloudCheck.CheckCallback
                public final void onReuslt(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
                    this.f$0.setCheckOverState(serverInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckOverState(final com.up366.mobile.cloud.model.ServerInfo serverInfo) {
        this.mHandler.post(new java.lang.Runnable() { // from class: com.up366.mobile.cloud.PrivateCloudMgr$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setCheckOverState$3(serverInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCheckOverState$3(com.up366.mobile.cloud.model.ServerInfo serverInfo) {
        this.checkState = 2;
        this.serverInfo = serverInfo;
        com.up366.common.log.Logger.info("PrivateCloudMgr check over select server=" + this.serverInfo);
        if (!com.up366.common.NetworkUtilsUp.isWifiConnect()) {
            notifyUiCloudNullOrError(-2);
            return;
        }
        if (this.serverInfo == null) {
            notifyUiCloudNullOrError(-1);
            return;
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(0).setIp(this.serverInfo.getServerIp()));
        java.util.Iterator<com.up366.mobile.cloud.CheckResultCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().checkOver(this.serverInfo);
        }
        this.callbacks.clear();
    }

    public com.up366.mobile.common.event.PrivateCloudCheckEvent postPrivateCloudState() {
        if (this.servers.isEmpty() || !com.up366.common.NetworkUtilsUp.isWifiConnect()) {
            return new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(-2);
        }
        int i = this.checkState;
        if (i == 2) {
            if (this.serverInfo == null) {
                return new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(-1);
            }
            return new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(0).setIp(this.serverInfo.getServerIp());
        }
        if (i == 1) {
            return new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(1);
        }
        return new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(-2);
    }

    public boolean isPrivateCloudState(com.up366.common.download.DownloadInfo downloadInfo) {
        return postPrivateCloudState().getState() == 0 || (downloadInfo != null ? com.up366.mobile.cloud.PrivateCloudDownload.isPrivateDownloadKey(downloadInfo.getKey()) : false);
    }

    public java.lang.String getOnServer() {
        if (this.servers.size() <= 0) {
            return null;
        }
        java.util.Random random = new java.util.Random();
        java.util.List<com.up366.mobile.cloud.model.ServerInfo> list = this.servers;
        return list.get(random.nextInt(list.size())).getServerIp();
    }

    public com.up366.mobile.cloud.model.ServerInfo getUsedServer() {
        return this.serverInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUiCloudNullOrError(final int i) {
        this.mHandler.post(new java.lang.Runnable() { // from class: com.up366.mobile.cloud.PrivateCloudMgr$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notifyUiCloudNullOrError$4(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyUiCloudNullOrError$4(int i) {
        this.checkState = 2;
        this.serverInfo = null;
        com.up366.common.log.Logger.info("PrivateCloudMgr check over server state=" + i);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.PrivateCloudCheckEvent().setState(i));
        java.util.Iterator<com.up366.mobile.cloud.CheckResultCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().checkOver(this.serverInfo);
        }
        this.callbacks.clear();
    }

    public void checkResult(final com.up366.mobile.cloud.CheckResultCallback checkResultCallback) {
        this.mHandler.post(new java.lang.Runnable() { // from class: com.up366.mobile.cloud.PrivateCloudMgr$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkResult$5(checkResultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkResult$5(com.up366.mobile.cloud.CheckResultCallback checkResultCallback) {
        int i = this.checkState;
        if (i == 0) {
            checkProxy();
            this.callbacks.add(checkResultCallback);
        } else if (i == 1) {
            this.callbacks.add(checkResultCallback);
        } else {
            checkResultCallback.checkOver(this.serverInfo);
        }
    }
}
