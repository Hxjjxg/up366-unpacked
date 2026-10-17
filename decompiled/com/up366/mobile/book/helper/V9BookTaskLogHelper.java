package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V9BookTaskLogHelper {
    private final com.up366.mobile.book.model.OpenConfigInfo cfg;
    private boolean isActive = false;
    private long time;

    public void onEnterPage() {
    }

    public void onStop() {
    }

    public V9BookTaskLogHelper(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        this.cfg = openConfigInfo;
    }

    private long getStudyTime() {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.time;
        this.time = android.os.SystemClock.elapsedRealtime();
        return jElapsedRealtime;
    }

    public void onResume() {
        this.time = android.os.SystemClock.elapsedRealtime();
        if (this.isActive) {
            return;
        }
        this.isActive = true;
    }

    public void onPause() {
        this.isActive = false;
    }

    private void submitTaskImpl(java.lang.String str, java.lang.String str2) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str2);
        final java.lang.String string = object.getString("key");
        final int intValue = object.getIntValue("submitType");
        final com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("tasksJson");
        com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("urlList");
        if (jSONArray == null) {
            jSONArray = new com.alibaba.fastjson.JSONArray();
        }
        final java.lang.String string2 = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        final java.lang.String string3 = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
        final float floatValue = jSONObject.getFloatValue("score");
        final float floatValue2 = jSONObject.getFloatValue("percent");
        final long longValue = jSONObject.getLongValue("studyDate");
        final java.util.List javaList = jSONArray.toJavaList(java.lang.String.class);
        final long studyTime = getStudyTime();
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("key", string);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("code", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("info", "上传中");
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("status", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("max", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("progress", 0);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9BookTaskLogHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.V9BookTaskLogHelper.lambda$submitTaskImpl$0(string2, studyTime, floatValue, floatValue2, longValue, javaList, string3, intValue, jSONObject, string);
            }
        });
    }

    static /* synthetic */ void lambda$submitTaskImpl$0(java.lang.String str, long j, float f, float f2, long j2, java.util.List list, java.lang.String str2, int i, com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str3) throws java.lang.Exception {
        com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2 = new com.up366.mobile.book.model.BookTaskLogV2();
        bookTaskLogV2.setTaskId(str);
        bookTaskLogV2.addStudyTime(j);
        bookTaskLogV2.setScore(f);
        bookTaskLogV2.setPercent(f2);
        bookTaskLogV2.setStudyDate(j2);
        bookTaskLogV2.setGuid(com.up366.mobile.book.model.AnswerEleAttrInfo.UUID());
        bookTaskLogV2.setFileUrls(android.text.TextUtils.join(";", list));
        bookTaskLogV2.setStudyTaskId(str2);
        bookTaskLogV2.setSubmitType(i);
        if (!jSONObject.containsKey("uid")) {
            jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        }
        bookTaskLogV2.setAnswers(jSONObject.toJSONString());
        com.up366.mobile.common.logic.Auth.cur().bookLog().addTaskLog(str3, bookTaskLogV2);
    }

    public void submitTaskV1(java.lang.String str, java.lang.String str2) {
        submitTaskImpl(str, str2);
    }

    public com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder submitBatch(java.lang.String str) throws java.lang.Throwable {
        try {
            com.up366.mobile.book.helper.V9BookTaskLogHelper.BatchUploadParam batchUploadParam = (com.up366.mobile.book.helper.V9BookTaskLogHelper.BatchUploadParam) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.book.helper.V9BookTaskLogHelper.BatchUploadParam.class);
            if (android.text.TextUtils.isEmpty(batchUploadParam.key)) {
                return new com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder(1, "参数错误，缺少 key");
            }
            com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(28, batchUploadParam.key);
            if (batchUploadParam.items != null && batchUploadParam.items.size() != 0) {
                com.up366.mobile.common.logic.Manager managerCur = com.up366.mobile.common.logic.Auth.cur();
                for (final com.up366.mobile.book.helper.V9BookTaskLogHelper.BatchUploadParamItem batchUploadParamItem : batchUploadParam.items) {
                    if (android.text.TextUtils.equals(batchUploadParamItem.type, "file")) {
                        com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder holderAddUploadFile = addUploadFile(batchUploadLog, managerCur, batchUploadParamItem, false);
                        if (holderAddUploadFile != null) {
                            return holderAddUploadFile;
                        }
                    } else if (android.text.TextUtils.equals(batchUploadParamItem.type, "record")) {
                        com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder holderAddUploadFile2 = addUploadFile(batchUploadLog, managerCur, batchUploadParamItem, true);
                        if (holderAddUploadFile2 != null) {
                            return holderAddUploadFile2;
                        }
                    } else if (android.text.TextUtils.equals(batchUploadParamItem.type, "http")) {
                        batchUploadLog.addTask(new com.up366.common.http.RequestParams(com.up366.common.global.GB.get().getServerUrl(batchUploadParamItem.requestUrl)).addHeaders(new com.up366.common.http.RequestParams.IAddHeaders() { // from class: com.up366.mobile.book.helper.V9BookTaskLogHelper$$ExternalSyntheticLambda1
                            @Override // com.up366.common.http.RequestParams.IAddHeaders
                            public final void addHeaders(java.util.Map map) {
                                com.up366.mobile.book.helper.V9BookTaskLogHelper.lambda$submitBatch$1(batchUploadParamItem, map);
                            }
                        }));
                    } else {
                        return new com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder(5, "类型错误：" + batchUploadParamItem);
                    }
                }
                batchUploadLog.setParams(new com.alibaba.fastjson.JSONObject().toJSONString());
                managerCur.logMgr().addToBatchQueueSync(batchUploadLog);
                return new com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder(0, "success");
            }
            return new com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder(2, "缺少上传数据");
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - V9BookTaskLogHelper - submitBatch - error", e);
            return new com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder(-2, e.getMessage());
        }
    }

    static /* synthetic */ void lambda$submitBatch$1(com.up366.mobile.book.helper.V9BookTaskLogHelper.BatchUploadParamItem batchUploadParamItem, java.util.Map map) {
        if (batchUploadParamItem.headers != null) {
            map.putAll(batchUploadParamItem.headers);
        }
        if (batchUploadParamItem.gzip) {
            map.put("___gzip_content___", batchUploadParamItem.body);
        } else {
            map.put("___raw_content___", batchUploadParamItem.body);
        }
    }

    private com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder addUploadFile(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.logic.Manager manager, com.up366.mobile.book.helper.V9BookTaskLogHelper.BatchUploadParamItem batchUploadParamItem, boolean z) throws java.lang.Throwable {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = manager.fileMgr().loadSync(batchUploadParamItem.url, null);
        if (fileMapInfoLoadSync == null) {
            return new com.up366.mobile.book.helper.V9BookTaskLogHelper.Holder(3, "文件不存在：" + batchUploadParamItem);
        }
        if (z) {
            manager.bookLog().addRecordBatchUploadFile(batchUploadLog, fileMapInfoLoadSync);
        } else {
            manager.bookLog().addBatchUploadFile(batchUploadLog, fileMapInfoLoadSync);
        }
        return null;
    }

    public static class Holder {
        public int code;
        public java.lang.String message;

        public Holder(int i, java.lang.String str) {
            this.code = i;
            this.message = str;
        }
    }

    static class BatchUploadParam {
        public java.util.List<com.up366.mobile.book.helper.V9BookTaskLogHelper.BatchUploadParamItem> items;
        public java.lang.String key;

        BatchUploadParam() {
        }
    }

    static class BatchUploadParamItem {
        public java.lang.String body;
        public boolean gzip;
        public java.util.Map<java.lang.String, java.lang.Object> headers;
        public java.lang.String requestUrl;
        public java.lang.String type;
        public java.lang.String url;

        BatchUploadParamItem() {
        }

        public java.lang.String toString() {
            return "BatchUploadParamItem{type='" + this.type + "', url='" + this.url + "', requestUrl='" + this.requestUrl + "', body='" + this.body + "', headers=" + this.headers + ", gzip=" + this.gzip + '}';
        }
    }
}
