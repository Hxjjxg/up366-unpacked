package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FeedbackTaskRecord {
    private static final int STATE_NO_DATA = 6;
    private static final int STATE_PREPAREING = 2;
    private static final int STATE_TIP = 1;
    private static final int STATE_UPLOADING = 3;
    private static final int STATE_UPLOAD_FAILED = 5;
    private static final int STATE_UPLOAD_SUCCESS = 4;
    private static final int STATE_WAITING = 0;
    private static boolean hasShow;
    private final com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding b;
    private android.content.Context context;
    private int currentState = 0;
    private com.up366.mobile.common.dialog.BaseDialog dialog;
    private com.up366.mobile.common.compat.FeedbackTaskRecord.Holder h;
    private com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo;
    private android.app.ProgressDialog progressDialog;

    public FeedbackTaskRecord(android.content.Context context, java.lang.String str) {
        this.context = context;
        com.up366.mobile.common.compat.FeedbackTaskRecord.Holder holder = new com.up366.mobile.common.compat.FeedbackTaskRecord.Holder();
        this.h = holder;
        holder.taskId = str;
        this.dialog = new com.up366.mobile.common.dialog.BaseDialog(context);
        com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding feedbackTaskRecordDialogBinding = (com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.feedback_task_record_dialog, (android.view.ViewGroup) null, false);
        this.b = feedbackTaskRecordDialogBinding;
        this.dialog.setContentView(feedbackTaskRecordDialogBinding.getRoot());
        initView();
    }

    public FeedbackTaskRecord(android.content.Context context, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        this.context = context;
        com.up366.mobile.common.compat.FeedbackTaskRecord.Holder holder = new com.up366.mobile.common.compat.FeedbackTaskRecord.Holder();
        this.h = holder;
        holder.taskId = str;
        this.dialog = new com.up366.mobile.common.dialog.BaseDialog(context);
        com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding feedbackTaskRecordDialogBinding = (com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.feedback_task_record_dialog, (android.view.ViewGroup) null, false);
        this.b = feedbackTaskRecordDialogBinding;
        this.dialog.setContentView(feedbackTaskRecordDialogBinding.getRoot());
        initView();
        this.iCallbackCodeInfo = iCallbackCodeInfo;
    }

    private void initView() {
        this.dialog.setCancelable(false);
        android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(this.context);
        this.progressDialog = progressDialog;
        progressDialog.setMessage("请等待...");
        this.b.stCancel.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        this.b.stContinue.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.b.sfCancel.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
        this.b.sfContinue.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        this.b.sfCancel.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        this.b.sfContinue.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(android.view.View view) {
        this.h.uploadPercent = 0;
        detectState(2);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4() throws java.lang.Exception {
        buildZipFile();
        uploadRecordLog();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3() throws java.lang.Exception {
        detectState(3);
    }

    public void show() {
        if (hasShow) {
            return;
        }
        hasShow = true;
        this.dialog.show();
        com.up366.common.EventBusUtilsUp.register(this);
        this.dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$show$6(dialogInterface);
            }
        });
        detectState(0);
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("FeedbackTaskRecord", 456, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$show$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$6(android.content.DialogInterface dialogInterface) {
        com.up366.common.EventBusUtilsUp.unregister(this);
        hasShow = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$9() throws java.lang.Exception {
        buildUploadFile();
        if (this.h.recordInfos == null || this.h.recordInfos.size() == 0) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$show$7();
                }
            });
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda5
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$show$8();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$7() throws java.lang.Exception {
        detectState(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$8() throws java.lang.Exception {
        detectState(1);
    }

    private void detectState(int i) {
        int i2 = this.currentState;
        if (i2 == 4) {
            return;
        }
        if (i2 != i && i != 3) {
            com.up366.mobile.common.utils.ViewUtil.invisible(this.b.stateTip, this.b.stateProgress, this.b.stateSuccess, this.b.stateFailed);
        }
        if (this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
        switch (i) {
            case 0:
                this.progressDialog.show();
                break;
            case 1:
                com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateTip);
                java.lang.String strBytesToMKB = com.up366.common.ByteUtilsUp.bytesToMKB(this.h.countFinalZipSize);
                this.b.stMessage.setText("需要上传你的录音用作于分析，我们不\n会泄露用户的隐私。上传的内容大概\n" + strBytesToMKB + "，是否要继续反馈？");
                break;
            case 2:
                com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateProgress);
                this.b.spTitle.setText("准备中");
                this.b.spProgress.setProgress(this.h.uploadPercent);
                this.dialog.setText(com.up366.mobile.R.id.percent_text, this.h.uploadPercent + "%");
                break;
            case 3:
                com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateProgress);
                this.b.spTitle.setText("数据上传中…");
                this.b.spProgress.setProgress(this.h.uploadPercent);
                this.dialog.setText(com.up366.mobile.R.id.percent_text, this.h.uploadPercent + "%");
                break;
            case 4:
                com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateSuccess);
                com.up366.common.task.TaskUtils.postMainTaskDelay(2000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda4
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$detectState$10();
                    }
                });
                com.up366.common.FileUtilsUp.deleteDirOrFile(this.h.zipPath);
                break;
            case 5:
                com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateFailed);
                break;
            case 6:
                com.up366.mobile.common.utils.ToastPopupUtil.show("没有数据，提交失败");
                this.dialog.dismiss();
                break;
        }
        this.currentState = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectState$10() throws java.lang.Exception {
        this.dialog.dismiss();
    }

    private void buildUploadFile() throws java.lang.Throwable {
        if (this.h.recordInfos != null) {
            return;
        }
        java.util.List list = com.up366.mobile.common.logic.Auth.cur().db().getBookTaskLogHistoryDao().queryBuilder().where(com.up366.greendao.BookTaskLogHistoryDao.Properties.TaskId.eq(this.h.taskId), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        com.up366.common.log.Logger.info("TAG - 2019/8/26 - buildUploadFile find wav size : " + list.size());
        if (list.size() == 0) {
            com.up366.common.log.Logger.error("TAG - 2019/8/23 - FeedbackTaskRecord - buildUploadFile - 没有找到本地的提交记录 : " + this.h.taskId);
            return;
        }
        com.up366.common.log.Logger.info("TAG - 2019/8/23 - FeedbackTaskRecord - buildUploadFile - size:" + list.size() + " taskId:" + this.h.taskId);
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda8
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.book.model.BookTaskLogHistory) obj2).getInsertTime(), ((com.up366.mobile.book.model.BookTaskLogHistory) obj).getInsertTime());
            }
        });
        com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory = (com.up366.mobile.book.model.BookTaskLogHistory) list.get(0);
        com.alibaba.fastjson.JSONObject jSONObjectDecodeZipData = decodeZipData(bookTaskLogHistory);
        if (jSONObjectDecodeZipData == null) {
            com.up366.common.log.Logger.error("TAG - 2019/8/23 -  buildUploadFile decode task data error! taskGuid : " + bookTaskLogHistory.getGuid());
            return;
        }
        this.h.countFinalZipSize = (int) (jSONObjectDecodeZipData.getIntValue("totalFileSize") * 5.05f);
        int intValue = jSONObjectDecodeZipData.getIntValue("type");
        java.util.List<java.lang.String> arrayList = new java.util.ArrayList<>();
        this.h.answersString = jSONObjectDecodeZipData.toJSONString();
        if (intValue == 0) {
            com.alibaba.fastjson.JSONObject jSONObjectFindHomeworkJson = findHomeworkJson(jSONObjectDecodeZipData);
            if (jSONObjectFindHomeworkJson == null) {
                com.up366.common.log.Logger.error("TAG -  buildUploadFile taskJson == null");
                return;
            } else {
                this.h.answersString = jSONObjectFindHomeworkJson.toJSONString();
                arrayList = findUploadUrlsFromHomeworkJSON(jSONObjectFindHomeworkJson);
            }
        }
        if (intValue == 1) {
            com.up366.common.log.Logger.info("TAG -  buildUploadFile taskInfo:" + jSONObjectDecodeZipData);
            com.alibaba.fastjson.JSONObject jSONObjectFindTaskJson = findTaskJson(jSONObjectDecodeZipData);
            if (jSONObjectFindTaskJson == null) {
                com.up366.common.log.Logger.error("TAG -  buildUploadFile taskJson == null");
                return;
            }
            arrayList = findUploadUrlsFromTaskJSON(jSONObjectFindTaskJson);
            com.up366.common.log.Logger.info("TAG -  buildUploadFile urls:" + java.util.Arrays.toString(arrayList.toArray()));
            this.h.answersString = jSONObjectFindTaskJson.toJSONString();
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        convertToObjectIds(arrayList2, arrayList);
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        convertToRecordInfos(jSONArray, arrayList2);
        this.h.recordInfos = jSONArray;
    }

    private void uploadRecordLog() {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.h.uploadId)) {
            com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
            com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
            return;
        }
        this.h.uploadId = "oral-feedback-" + this.h.taskId + "-" + java.lang.System.currentTimeMillis();
        final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(21, this.h.uploadId);
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(this.h.zipPath, ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(this.h.zipPath, ".zip", false, com.up366.mobile.common.utils.alifile.OssObjectKey.Business.FEEDBACK), new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$uploadRecordLog$12(batchUploadLog, fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadRecordLog$12(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.feedBack) { // from class: com.up366.mobile.common.compat.FeedbackTaskRecord.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                java.lang.String str;
                map.put("suggestion", "口语题评测不准-用户原音数据");
                map.put("logFilePath", fileMapInfo.getUrl());
                if (android.os.Build.VERSION.RELEASE == null) {
                    str = "";
                } else {
                    str = "android " + android.os.Build.VERSION.RELEASE;
                }
                map.put("osVersion", str);
                map.put("appVersion", com.up366.common.PackageUtils.getVersionName());
                map.put("mobileModel", com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel() + "  " + android.os.Build.MODEL);
                map.put("type", 2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str) {
                super.onResponse(response, str);
                if (response.getCode() != 0) {
                    com.up366.common.log.Logger.error("upload log error:" + response.toString());
                }
            }
        });
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }

    private java.util.List<java.lang.String> findUploadUrlsFromHomeworkJSON(com.alibaba.fastjson.JSONObject jSONObject) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("<answer_url>(http[^<]*aliyuncs[^<]*mp3)</answer_url>").matcher(jSONObject.getString("answerData"));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
        }
        return arrayList;
    }

    private com.alibaba.fastjson.JSONObject findHomeworkJson(com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObject2;
        java.util.Iterator it = jSONObject.getJSONArray("tasks").iterator();
        while (true) {
            if (!it.hasNext()) {
                jSONObject2 = null;
                break;
            }
            jSONObject2 = (com.alibaba.fastjson.JSONObject) it.next();
            if (jSONObject2.getIntValue("type") == 0) {
                break;
            }
        }
        if (jSONObject2 == null) {
            return null;
        }
        try {
            return com.alibaba.fastjson.JSON.parseObject(jSONObject2.getString("postParams"));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - 2019/8/23 -  findTaskJson ", e);
            return null;
        }
    }

    private void buildZipFile() throws java.lang.Throwable {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.h.zipPath)) {
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "oralupload", java.util.UUID.randomUUID().toString());
            java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, "data");
            java.lang.String strJoin3 = com.up366.common.FileUtilsUp.join(strJoin2, "answer.js");
            java.lang.String strJoin4 = com.up366.common.FileUtilsUp.join(strJoin, "index.html");
            java.lang.String strJoin5 = com.up366.common.FileUtilsUp.join(strJoin, "answers.json");
            java.lang.String str = strJoin + ".zip";
            java.util.Iterator it = this.h.recordInfos.iterator();
            while (it.hasNext()) {
                com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) it.next();
                java.lang.String string = jSONObject.getString("app_time");
                java.lang.String string2 = jSONObject.getString("app_wav");
                java.lang.String[] strArrSplit = jSONObject.getString("app_net").split(com.igexin.push.core.b.an);
                java.lang.String name = new java.io.File(string2).getName();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.util.Iterator it2 = it;
                sb.append(name.replace(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV, ""));
                sb.append("-");
                sb.append(string);
                java.lang.String string3 = sb.toString();
                java.lang.String strJoin6 = com.up366.common.FileUtilsUp.join(strJoin2, string3 + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
                java.lang.String strJoin7 = com.up366.common.FileUtilsUp.join(strJoin2, string3, "net");
                java.lang.String str2 = strJoin2;
                jSONObject.put("app_wav", string3 + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
                jSONObject.put("app_net_dir", com.up366.common.FileUtilsUp.join(string3, "net"));
                com.up366.common.FileUtilsUp.copyFileOrDir(string2, strJoin6);
                if (strArrSplit.length > 0) {
                    java.lang.String str3 = strArrSplit[0];
                    if (com.up366.common.FileUtilsUp.isDir(str3)) {
                        com.up366.common.FileUtilsUp.copyFileOrDir(str3, strJoin7);
                    }
                    if (com.up366.common.FileUtilsUp.isFile(str3)) {
                        com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(str3).getParent(), strJoin7);
                    }
                }
                it = it2;
                strJoin2 = str2;
            }
            java.lang.String str4 = "var data = " + this.h.recordInfos.toJSONString();
            java.lang.String assetFile = com.up366.common.FileUtilsUp.getAssetFile("oraltest/show.html");
            com.up366.common.FileUtilsUp.saveContentToFile(strJoin3, str4);
            com.up366.common.FileUtilsUp.saveContentToFile(strJoin4, assetFile);
            com.up366.common.FileUtilsUp.saveContentToFile(strJoin5, this.h.answersString);
            com.up366.common.FileUtilsUp.zip(strJoin, str);
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
            this.h.zipPath = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        com.up366.common.log.Logger.error("convertToRecordInfos - len:" + r6 + " size:" + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void convertToRecordInfos(com.alibaba.fastjson.JSONArray r9, java.util.List<java.lang.String> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.compat.FeedbackTaskRecord.convertToRecordInfos(com.alibaba.fastjson.JSONArray, java.util.List):void");
    }

    static /* synthetic */ void lambda$convertToRecordInfos$13(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, java.lang.Exception exc, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        com.up366.mobile.common.onlinelog.OpLog.record("ParseRecordBinError", "uploadUrl:" + fileMapInfo.getUrl());
        com.up366.mobile.common.onlinelog.OpLog.report("ParseRecordBinError", exc.getMessage(), exc);
    }

    private void convertToObjectIds(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
        for (java.lang.String str : list2) {
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSync(str, null);
            if (fileMapInfoLoadSync == null) {
                com.up366.common.log.Logger.error("TAG -  buildUploadFile uploadUrl:" + str + " not found!");
            } else {
                list.add(fileMapInfoLoadSync.getObjectId());
            }
        }
    }

    private java.util.List<java.lang.String> findUploadUrlsFromTaskJSON(com.alibaba.fastjson.JSONObject jSONObject) {
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator it = jSONObject.getJSONArray("qstJson").iterator();
        while (it.hasNext()) {
            java.lang.String string = com.alibaba.fastjson.JSON.parseObject(((com.alibaba.fastjson.JSONObject) it.next()).getString("elementAttr")).getString("record_url");
            if (!com.up366.common.StringUtils.isEmptyOrNull(string)) {
                hashSet.add(string);
            }
        }
        java.lang.String string2 = jSONObject.getString("result");
        if (!com.up366.common.StringUtils.isEmptyOrNull(string2)) {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("<answer_url>(http[^<]*aliyuncs[^<]*mp3)</answer_url>").matcher(com.alibaba.fastjson.JSON.parseObject(string2).getJSONObject("testInfo").getString("answerdata"));
            while (matcher.find()) {
                hashSet.add(matcher.group(1));
            }
        }
        return new java.util.ArrayList(hashSet);
    }

    private com.alibaba.fastjson.JSONObject findTaskJson(com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObject2;
        java.util.Iterator it = jSONObject.getJSONArray("tasks").iterator();
        while (true) {
            if (!it.hasNext()) {
                jSONObject2 = null;
                break;
            }
            jSONObject2 = (com.alibaba.fastjson.JSONObject) it.next();
            if (jSONObject2.getIntValue("type") == 0) {
                break;
            }
        }
        if (jSONObject2 == null) {
            return null;
        }
        try {
            return (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSON.parseArray(com.alibaba.fastjson.JSON.parseObject(jSONObject2.getString("postParams")).getString("tasksJson")).get(0);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - 2019/8/23 -  findTaskJson ", e);
            return null;
        }
    }

    private com.alibaba.fastjson.JSONObject decodeZipData(com.up366.mobile.book.model.BookTaskLogHistory bookTaskLogHistory) {
        try {
            return com.alibaba.fastjson.JSON.parseObject(new java.lang.String(com.up366.common.ZipStringUtils.gunzip(bookTaskLogHistory.getLogData())));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - 2019/8/23 -  decodeZipData ", e);
            try {
                return com.alibaba.fastjson.JSON.parseObject(new java.lang.String(bookTaskLogHistory.getLogData()));
            } catch (java.lang.Exception e2) {
                com.up366.common.log.Logger.error("TAG - 2019/8/23 -  decodeZipData ", e2);
                return null;
            }
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.isFailed()) {
            com.up366.common.log.Logger.error("FeedbackTaskRecord - onMessageEvent - ERROR : " + commonUploadLogEvent.toString());
            detectState(5);
        }
        if (commonUploadLogEvent.getType() == 21 && commonUploadLogEvent.getRefKey().equals(this.h.uploadId)) {
            if (commonUploadLogEvent.isSuccess()) {
                detectState(4);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.FeedbackTaskUploadSuccess(this.h.taskId));
                com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo = this.iCallbackCodeInfo;
                if (iCallbackCodeInfo != null) {
                    iCallbackCodeInfo.onResult(0, "success");
                }
            }
            if (this.currentState == 5) {
                com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo2 = this.iCallbackCodeInfo;
                if (iCallbackCodeInfo2 != null) {
                    iCallbackCodeInfo2.onResult(-1, "fail");
                    return;
                }
                return;
            }
            if (commonUploadLogEvent.isProgressUpdate()) {
                detectState(3);
                this.h.uploadPercent = commonUploadLogEvent.getPercent();
            }
        }
    }

    class Holder {
        java.lang.String answersString;
        int countFinalZipSize;
        com.alibaba.fastjson.JSONArray recordInfos;
        java.lang.String taskId;
        java.lang.String uploadId;
        int uploadPercent;
        java.lang.String zipPath;

        Holder() {
        }
    }
}
