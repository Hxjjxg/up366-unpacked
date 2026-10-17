package com.up366.mobile.common.onlinelog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LocalLogTool {
    public static void onReceiveMessages(java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
        if (list == null) {
            return;
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.up366.mobile.common.logic.model.Messages messages : list) {
                if (handle(messages)) {
                    arrayList.add(messages);
                }
            }
            list.removeAll(arrayList);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - LocalLogTool - onReceiveMessages - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-LocalLogTool", e.getMessage(), e);
        }
    }

    public static boolean handle(final com.up366.mobile.common.logic.model.Messages messages) {
        com.alibaba.fastjson.JSONObject object;
        if (messages == null || (object = com.alibaba.fastjson.JSON.parseObject(messages.getExtend())) == null || !"uploadClientLog".equals(object.getString("type"))) {
            return false;
        }
        boolean zBooleanValue = object.getBoolean("showTipDialog").booleanValue();
        final com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("uploadFileOrDirs");
        final boolean zBooleanValue2 = object.getBoolean("full").booleanValue();
        if (zBooleanValue) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.onlinelog.LocalLogTool$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.logic.model.Messages messages2 = messages;
                    com.up366.mobile.common.dialog.DialogOkCancleV2.create(com.up366.common.global.GB.get().getCurrentActivity()).title(messages2.getSubject()).message(messages2.getContent()).ok(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.onlinelog.LocalLogTool$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.common.onlinelog.LocalLogTool.doUpload(z, jSONArray);
                        }
                    }).cancle(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.onlinelog.LocalLogTool$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.common.onlinelog.LocalLogTool.cancelUpload("用户拒绝上传日志文件");
                        }
                    }).setCancelable(false).show();
                }
            });
            return true;
        }
        doUpload(zBooleanValue2, jSONArray);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doUpload(final boolean z, final com.alibaba.fastjson.JSONArray jSONArray) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.onlinelog.LocalLogTool$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.onlinelog.LocalLogTool.lambda$doUpload$3(jSONArray, z);
            }
        });
    }

    static /* synthetic */ void lambda$doUpload$3(com.alibaba.fastjson.JSONArray jSONArray, boolean z) throws java.lang.Exception {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (jSONArray != null) {
                java.util.Iterator it = jSONArray.iterator();
                while (it.hasNext()) {
                    arrayList.add((java.lang.String) it.next());
                }
            }
            java.io.File zipFile = com.up366.mobile.common.compat.CopyAppDataToSdcardCompat.getZipFile(z, arrayList);
            if (zipFile.length() > 3145728 && !com.up366.common.NetworkUtilsUp.isWifiConnect()) {
                cancelUpload("日志文件过大! zipFile.length() = " + zipFile.length());
                return;
            }
            submitToServer(zipFile);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - LocalLogTool - doUpload - ", e);
            cancelUpload("获取日志文件出错:\n" + android.util.Log.getStackTraceString(e));
        }
    }

    private static void submitToServer(final java.io.File file) {
        final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(23, java.util.UUID.randomUUID().toString());
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(file.getAbsolutePath(), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.onlinelog.LocalLogTool$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                com.up366.mobile.common.onlinelog.LocalLogTool.lambda$submitToServer$4(batchUploadLog, file, fileMapInfo);
            }
        });
    }

    static /* synthetic */ void lambda$submitToServer$4(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, java.io.File file, final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        batchUploadLog.addFile(file, fileMapInfo.getObjectId());
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.feedBack) { // from class: com.up366.mobile.common.onlinelog.LocalLogTool.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                java.lang.String str;
                map.put("suggestion", "获取用户本地日志");
                map.put("logFilePath", fileMapInfo.getUrl());
                if (android.os.Build.VERSION.RELEASE == null) {
                    str = "";
                } else {
                    str = "android " + android.os.Build.VERSION.RELEASE;
                }
                map.put("osVersion", str);
                map.put("appVersion", com.up366.common.PackageUtils.getVersionName());
                map.put("mobileModel", com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel() + "  " + android.os.Build.MODEL);
                map.put("type", 3);
            }
        });
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cancelUpload(final java.lang.String str) {
        com.up366.mobile.common.onlinelog.OpLog.report("LocalLog-upload-cancel", "LocalLog-upload-cancel");
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(23, java.util.UUID.randomUUID().toString());
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.feedBack) { // from class: com.up366.mobile.common.onlinelog.LocalLogTool.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("suggestion", "获取用户本地日志-\n" + str);
                java.lang.String str2 = "";
                map.put("logFilePath", "");
                if (android.os.Build.VERSION.RELEASE != null) {
                    str2 = "android " + android.os.Build.VERSION.RELEASE;
                }
                map.put("osVersion", str2);
                map.put("appVersion", com.up366.common.PackageUtils.getVersionName());
                map.put("mobileModel", com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel() + "  " + android.os.Build.MODEL);
                map.put("type", 3);
            }
        });
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }
}
