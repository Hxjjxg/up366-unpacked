package com.up366.mobile.cloud;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudCheck {
    private static long startCheckTime;
    private static java.util.List<com.up366.mobile.cloud.model.ServerInfo> serverInfos = new java.util.LinkedList();
    private static java.util.List<com.up366.mobile.cloud.model.ServerInfo> okServerInfos = new java.util.LinkedList();
    private static okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder().connectTimeout(5, java.util.concurrent.TimeUnit.SECONDS).writeTimeout(5, java.util.concurrent.TimeUnit.SECONDS).readTimeout(5, java.util.concurrent.TimeUnit.SECONDS).build();

    public interface CheckCallback {
        void onReuslt(com.up366.mobile.cloud.model.ServerInfo serverInfo);
    }

    public static void startCheck(java.util.List<com.up366.mobile.cloud.model.ServerInfo> list, final com.up366.mobile.cloud.PrivateCloudCheck.CheckCallback checkCallback) {
        startCheckTime = java.lang.System.currentTimeMillis();
        com.up366.common.log.Logger.info("PrivateCloudMgr check start");
        serverInfos.clear();
        okServerInfos.clear();
        if (list.isEmpty() || !com.up366.common.NetworkUtilsUp.isWifiConnect()) {
            checkCallback.onReuslt(null);
            return;
        }
        serverInfos.addAll(list);
        for (final com.up366.mobile.cloud.model.ServerInfo serverInfo : new java.util.LinkedList(serverInfos)) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.cloud.PrivateCloudCheck$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.cloud.PrivateCloudCheck.checkHttp(serverInfo, checkCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkHttp(final com.up366.mobile.cloud.model.ServerInfo serverInfo, final com.up366.mobile.cloud.PrivateCloudCheck.CheckCallback checkCallback) {
        okhttp3.Request requestBuild = new okhttp3.Request.Builder().url(com.up366.mobile.cloud.PrivateCloudMgr.HTTP + serverInfo.getServerIp() + ":" + serverInfo.getPort() + com.up366.mobile.common.http.HttpMgrUtils.PRIVATE_SERVER_CHECK_STATUS).build();
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        okHttpClient.newCall(requestBuild).enqueue(new okhttp3.Callback() { // from class: com.up366.mobile.cloud.PrivateCloudCheck.1
            public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
                com.up366.mobile.common.onlinelog.OpLog.record(com.up366.mobile.cloud.PrivateCloudMgr.OPLOG_TAG, " checkhttp exception serverId=" + serverInfo.getServerId() + " serverIp=" + serverInfo.getServerIp() + " time=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                java.lang.StringBuilder sb = new java.lang.StringBuilder("PrivateCloudCheck checkHttp ");
                sb.append(serverInfo.getServerIp());
                sb.append(" error consumeTime=");
                sb.append(java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
                sb.append("ms");
                com.up366.common.log.Logger.info(sb.toString());
                com.up366.mobile.cloud.PrivateCloudCheck.removeServerInfo(serverInfo, checkCallback);
            }

            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
                if (response.isSuccessful() && response.body() != null) {
                    java.lang.String strString = response.body().string();
                    try {
                        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(strString);
                        if (object == null) {
                            com.up366.mobile.cloud.PrivateCloudCheck.removeServerInfo(serverInfo, checkCallback);
                            return;
                        }
                        int intValue = object.getJSONObject("result").getIntValue("code");
                        if (intValue != 1 && intValue != 2) {
                            if (intValue == 0) {
                                com.up366.common.log.Logger.info("PrivateCloudCheck checkHttp " + serverInfo.getServerIp() + " ok consumeTime=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                                com.up366.mobile.cloud.PrivateCloudCheck.addSuccessServerInfo(serverInfo, checkCallback);
                                return;
                            }
                            return;
                        }
                        com.up366.mobile.common.onlinelog.OpLog.record(com.up366.mobile.cloud.PrivateCloudMgr.OPLOG_TAG, " checkhttp error serverId=" + serverInfo.getServerId() + " serverIp=" + serverInfo.getServerIp() + " time=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("PrivateCloudCheck checkHttp ");
                        sb.append(serverInfo.getServerIp());
                        sb.append(" error consumeTime=");
                        sb.append(java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
                        sb.append("ms");
                        com.up366.common.log.Logger.info(sb.toString());
                        com.up366.mobile.cloud.PrivateCloudCheck.removeServerInfo(serverInfo, checkCallback);
                        return;
                    } catch (com.alibaba.fastjson.JSONException unused) {
                        com.up366.common.log.Logger.error("PrivateCloudCheck checkHttp " + serverInfo.getServerIp() + " error consumeTime=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms  JSONException content=" + strString);
                        com.up366.mobile.cloud.PrivateCloudCheck.removeServerInfo(serverInfo, checkCallback);
                        return;
                    }
                }
                com.up366.common.log.Logger.info("PrivateCloudCheck checkHttp " + serverInfo.getServerIp() + " error consumeTime=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                com.up366.mobile.cloud.PrivateCloudCheck.removeServerInfo(serverInfo, checkCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void removeServerInfo(com.up366.mobile.cloud.model.ServerInfo serverInfo, com.up366.mobile.cloud.PrivateCloudCheck.CheckCallback checkCallback) {
        serverInfos.remove(serverInfo);
        if (serverInfos.size() == 0) {
            com.up366.common.log.Logger.info("PrivateCloudCheck check over consumeTime=" + (java.lang.System.currentTimeMillis() - startCheckTime) + "ms");
            if (okServerInfos.size() == 0) {
                checkCallback.onReuslt(null);
            } else {
                java.util.Random random = new java.util.Random();
                java.util.List<com.up366.mobile.cloud.model.ServerInfo> list = okServerInfos;
                checkCallback.onReuslt(list.get(random.nextInt(list.size())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void addSuccessServerInfo(com.up366.mobile.cloud.model.ServerInfo serverInfo, com.up366.mobile.cloud.PrivateCloudCheck.CheckCallback checkCallback) {
        serverInfos.remove(serverInfo);
        okServerInfos.add(serverInfo);
        if (serverInfos.size() == 0) {
            com.up366.common.log.Logger.info("PrivateCloudCheck check over consumeTime=" + (java.lang.System.currentTimeMillis() - startCheckTime));
            if (okServerInfos.size() == 0) {
                checkCallback.onReuslt(null);
            } else {
                java.util.Random random = new java.util.Random();
                java.util.List<com.up366.mobile.cloud.model.ServerInfo> list = okServerInfos;
                checkCallback.onReuslt(list.get(random.nextInt(list.size())));
            }
        }
    }
}
