package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FeedbackMgr {
    public FeedbackMgr(com.up366.mobile.common.logic.Manager manager) {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.Object> buildBatchUploadLog(java.io.File r9, java.util.List<java.lang.String> r10) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.logic.FeedbackMgr.buildBatchUploadLog(java.io.File, java.util.List):java.util.Map");
    }

    private void submitToServer(final int i, final java.lang.String str, final java.lang.String str2, final java.util.Map<java.lang.String, java.lang.Object> map) {
        com.up366.common.http.RequestParams<java.lang.String> requestParams = new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.feedBack) { // from class: com.up366.mobile.common.logic.FeedbackMgr.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map2) {
                java.lang.String str3;
                map2.put("suggestion", str);
                map2.put("contactInfo", str2);
                map2.put("picFilePath", map.get("picFilePath"));
                map2.put("logFilePath", map.get("logFilePath"));
                if (android.os.Build.VERSION.RELEASE == null) {
                    str3 = "";
                } else {
                    str3 = "android" + android.os.Build.VERSION.RELEASE;
                }
                map2.put("osVersion", str3);
                map2.put("appVersion", com.up366.common.PackageUtils.getVersionName());
                map2.put("mobileModel", com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel() + "  " + android.os.Build.MODEL);
                map2.put("type", java.lang.Integer.valueOf(i));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str3) {
                super.onResponse(response, str3);
                if (response.getCode() != 0) {
                    com.up366.common.log.Logger.error("upload log error:" + response.toString());
                }
            }
        };
        com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = (com.up366.mobile.common.logic.log.model.BatchUploadLog) map.get("BatchUploadLog");
        if (batchUploadLog == null) {
            return;
        }
        batchUploadLog.addTask(requestParams);
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }

    public com.up366.common.http.NetHolder<java.lang.String> submitOralSync(final java.lang.String str) throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.feedBack) { // from class: com.up366.mobile.common.logic.FeedbackMgr.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("suggestion", "近30天音频和评分结果文件");
                java.lang.String str2 = "";
                map.put("contactInfo", "");
                map.put("logFilePath", str);
                if (android.os.Build.VERSION.RELEASE != null) {
                    str2 = "android" + android.os.Build.VERSION.RELEASE;
                }
                map.put("osVersion", str2);
                map.put("appVersion", com.up366.common.PackageUtils.getVersionName());
                map.put("mobileModel", com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel() + "  " + android.os.Build.MODEL);
                map.put("type", 16);
            }
        });
    }

    public void uploadFeedBack(final int i, final java.lang.String str, final java.lang.String str2, final boolean z, java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> list) {
        final java.util.List<java.lang.String> listCovert = covert(list);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.FeedbackMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadFeedBack$0(z, listCovert, i, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadFeedBack$0(boolean z, java.util.List list, int i, java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        submitToServer(i, str, str2, buildBatchUploadLog(z ? com.up366.mobile.common.compat.CopyAppDataToSdcardCompat.getZipFile(true, null) : null, list));
    }

    private java.util.List<java.lang.String> covert(java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() != 0) {
            java.util.Iterator<com.up366.multimedia.util.AlbumHelper.ImageItem> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().imagePath);
            }
        }
        return arrayList;
    }
}
