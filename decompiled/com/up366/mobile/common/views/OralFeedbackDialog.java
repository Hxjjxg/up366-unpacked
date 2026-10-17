package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OralFeedbackDialog {
    private static final int STATE_FAILED = 4;
    private static final int STATE_PREPARE = 0;
    private static final int STATE_SELECT = 1;
    private static final int STATE_SUCCESS = 3;
    private static final int STATE_UPLOADING = 2;
    private final com.up366.mobile.databinding.OralFeedbackDialogBinding b;
    private com.up366.common.callback.ICallbackCodeInfo callbackCodeInfo;
    private int currentState;
    private com.up366.mobile.common.dialog.BaseDialog dialog;
    private com.up366.mobile.common.views.OralFeedbackDialog.Holder h;

    public OralFeedbackDialog(android.content.Context context, java.lang.String str) {
        this(context, str, null);
    }

    public OralFeedbackDialog(android.content.Context context, final java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        this.currentState = 1;
        this.h = new com.up366.mobile.common.views.OralFeedbackDialog.Holder();
        this.dialog = new com.up366.mobile.common.dialog.BaseDialog(context);
        com.up366.mobile.databinding.OralFeedbackDialogBinding oralFeedbackDialogBinding = (com.up366.mobile.databinding.OralFeedbackDialogBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.oral_feedback_dialog, (android.view.ViewGroup) null, false);
        this.b = oralFeedbackDialogBinding;
        this.dialog.setContentView(oralFeedbackDialogBinding.getRoot());
        this.dialog.setCancelable(false);
        initView();
        this.callbackCodeInfo = iCallbackCodeInfo;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(java.lang.String str) throws java.lang.Exception {
        this.h.params = com.alibaba.fastjson.JSON.parseObject(str);
        com.up366.mobile.common.views.OralFeedbackDialog.Holder holder = this.h;
        holder.score = holder.params.getFloatValue("score");
        com.up366.mobile.common.views.OralFeedbackDialog.Holder holder2 = this.h;
        holder2.taskInfo = holder2.params.getString("taskInfo");
        com.up366.mobile.common.views.OralFeedbackDialog.Holder holder3 = this.h;
        holder3.recordUrl = holder3.params.getString("recordUrl");
        com.up366.mobile.common.views.OralFeedbackDialog.Holder holder4 = this.h;
        holder4.courseId = holder4.params.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
        buildUploadData();
        buildFileSize();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() {
                this.f$0.initViewData();
            }
        });
    }

    public void show() {
        this.dialog.show();
        com.up366.common.EventBusUtilsUp.register(this);
        this.dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$show$1(dialogInterface);
            }
        });
        detectState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(android.content.DialogInterface dialogInterface) {
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    private void initView() {
        this.b.slFeedbackTypeGroup.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda6
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(android.widget.RadioGroup radioGroup, int i) {
                this.f$0.lambda$initView$2(radioGroup, i);
            }
        });
        this.b.suProgressBar.setProgressDrawable(new com.up366.mobile.common.views.FixedLinearGradientProgressBarDrawable(this.b.suProgressBar));
        this.b.slSubmit.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$5(view);
            }
        });
        this.b.slCancle.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$6(view);
            }
        });
        this.b.sfCancle.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$7(view);
            }
        });
        this.b.sfRetry.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.widget.RadioGroup radioGroup, int i) {
        this.b.slSubmit.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(android.view.View view) {
        this.h.uploadPercent = 0;
        detectState(0);
        if (this.b.slFeedbackTypeGroup.getCheckedRadioButtonId() == this.b.slScoreLow.getId()) {
            this.h.evaluation = 1;
        } else {
            this.h.evaluation = 2;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4() throws java.lang.Exception {
        buildUploadData();
        buildZipFile();
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(this.h.zipPath, ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(this.h.zipPath, ".zip", false, com.up366.mobile.common.utils.alifile.OssObjectKey.Business.FEEDBACK), new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$initView$3(fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        this.h.ossUrl = fileMapInfo.getUrl();
        addToUploadQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(android.view.View view) {
        this.dialog.dismiss();
        com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo = this.callbackCodeInfo;
        if (iCallbackCodeInfo != null) {
            iCallbackCodeInfo.onResult(-1, "fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$7(android.view.View view) {
        this.b.slCancle.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$9(android.view.View view) {
        detectState(0);
        com.up366.mobile.common.logic.Auth.cur().logMgr().decreaseTryCount();
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewData() {
        java.lang.String strBytesToMKB = com.up366.common.ByteUtilsUp.bytesToMKB(this.h.countFinalZipSize);
        this.b.slDescription.setText("需要上传你的录音用作于分析,我们不会泄露\n你的隐私,上传的内容大概 " + strBytesToMKB);
    }

    private synchronized void buildUploadData() {
        if (this.h.recordInfos != null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.h.recordUrl);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        convertToObjectIds(arrayList2, arrayList);
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        convertToRecordInfos(jSONArray, arrayList2);
        this.h.recordInfos = jSONArray;
    }

    private void addToUploadQueue() {
        this.h.uploadId = "oral-feedback-" + java.lang.System.currentTimeMillis();
        final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(22, this.h.uploadId);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$addToUploadQueue$11(batchUploadLog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addToUploadQueue$11(final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(this.h.zipPath, ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(this.h.zipPath, ".zip", false, com.up366.mobile.common.utils.alifile.OssObjectKey.Business.FEEDBACK), new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda11
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$addToUploadQueue$10(batchUploadLog, fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addToUploadQueue$10(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        batchUploadLog.addFile(new java.io.File(this.h.zipPath), fileMapInfo.getObjectId());
        batchUploadLog.addTask(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.feedBackOral) { // from class: com.up366.mobile.common.views.OralFeedbackDialog.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                java.lang.String str;
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(com.up366.mobile.common.views.OralFeedbackDialog.this.h.courseId));
                if (!com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getMobile())) {
                    map.put("contactInfo", com.up366.mobile.common.logic.Auth.getUserInfo().getMobile());
                }
                if (android.os.Build.VERSION.RELEASE == null) {
                    str = "";
                } else {
                    str = "android " + android.os.Build.VERSION.RELEASE;
                }
                map.put("osVersion", str);
                map.put("mobileModel", com.up366.mobile.common.helper.AppModelHelper.getInst().getAppModel() + "  " + android.os.Build.MODEL);
                map.put("taskInfo", com.up366.mobile.common.views.OralFeedbackDialog.this.h.taskInfo);
                map.put("score", java.lang.Float.valueOf(com.up366.mobile.common.views.OralFeedbackDialog.this.h.score));
                map.put("evaluation", java.lang.Integer.valueOf(com.up366.mobile.common.views.OralFeedbackDialog.this.h.evaluation));
                map.put("zippath", com.up366.mobile.common.views.OralFeedbackDialog.this.h.ossUrl);
                map.put("engineVersion", com.up366.mobile.common.views.OralFeedbackDialog.this.h.engineVersion);
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

    private void buildFileSize() {
        long length = 0;
        for (com.alibaba.fastjson.JSONObject jSONObject : this.h.recordInfos) {
            java.lang.String string = jSONObject.getString("app_wav");
            java.lang.String[] strArrSplit = jSONObject.getString("app_net").split(com.igexin.push.core.b.an);
            length += new java.io.File(string).length();
            for (java.lang.String str : strArrSplit) {
                if (!com.up366.common.FileUtilsUp.isDir(str)) {
                    length += new java.io.File(str).length();
                }
            }
        }
        this.h.countFinalZipSize = length + ((long) this.h.recordInfos.toJSONString().length());
    }

    private synchronized void buildZipFile() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.h.zipPath)) {
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getUserRootPath(), "oralupload", java.util.UUID.randomUUID().toString());
            java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, "data");
            java.lang.String strJoin3 = com.up366.common.FileUtilsUp.join(strJoin2, "answer.js");
            java.lang.String strJoin4 = com.up366.common.FileUtilsUp.join(strJoin, "index.html");
            java.lang.String strJoin5 = com.up366.common.FileUtilsUp.join(strJoin, "answers.json");
            java.lang.String str = strJoin + ".zip";
            for (com.alibaba.fastjson.JSONObject jSONObject : this.h.recordInfos) {
                java.lang.String string = jSONObject.getString("app_time");
                java.lang.String string2 = jSONObject.getString("app_wav");
                java.lang.String[] strArrSplit = jSONObject.getString("app_net").split(com.igexin.push.core.b.an);
                java.lang.String str2 = new java.io.File(string2).getName().replace(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV, "") + "-" + string;
                java.lang.String strJoin6 = com.up366.common.FileUtilsUp.join(strJoin2, str2 + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
                java.lang.String strJoin7 = com.up366.common.FileUtilsUp.join(strJoin2, str2, "net");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str2);
                java.lang.String str3 = strJoin2;
                sb.append(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
                jSONObject.put("app_wav", sb.toString());
                jSONObject.put("app_net_dir", com.up366.common.FileUtilsUp.join(str2, "net"));
                com.up366.common.FileUtilsUp.copyFileOrDir(string2, strJoin6);
                if (strArrSplit.length > 0) {
                    java.lang.String str4 = strArrSplit[0];
                    if (com.up366.common.FileUtilsUp.isDir(str4)) {
                        com.up366.common.FileUtilsUp.copyFileOrDir(str4, strJoin7);
                    }
                    if (com.up366.common.FileUtilsUp.isFile(str4)) {
                        com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(str4).getParent(), strJoin7);
                    }
                }
                strJoin2 = str3;
            }
            java.lang.String str5 = "var data = " + this.h.recordInfos.toJSONString();
            java.lang.String assetFile = com.up366.common.FileUtilsUp.getAssetFile("oraltest/show.html");
            com.up366.common.FileUtilsUp.saveContentToFile(strJoin3, str5);
            com.up366.common.FileUtilsUp.saveContentToFile(strJoin4, assetFile);
            com.up366.common.FileUtilsUp.saveContentToFile(strJoin5, this.h.params.toJSONString());
            com.up366.common.FileUtilsUp.zip(strJoin, str);
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
            this.h.zipPath = str;
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        com.up366.common.log.Logger.error("convertToRecordInfos - len:" + r7 + " size:" + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void convertToRecordInfos(com.alibaba.fastjson.JSONArray r18, java.util.List<java.lang.String> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.views.OralFeedbackDialog.convertToRecordInfos(com.alibaba.fastjson.JSONArray, java.util.List):void");
    }

    static /* synthetic */ void lambda$convertToRecordInfos$12(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, java.lang.Exception exc, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        com.up366.mobile.common.onlinelog.OpLog.record("ParseRecordBinError2", "uploadUrl:" + fileMapInfo.getUrl());
        com.up366.mobile.common.onlinelog.OpLog.report("ParseRecordBinError2", exc.getMessage(), exc);
    }

    private void detectState(int i) {
        int i2 = this.currentState;
        if (i2 == 3) {
            return;
        }
        if (i2 != i && i != 2) {
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.stateFailed, this.b.stateSuccess, this.b.stateUploading, this.b.stateSelect);
        }
        if (i == 0) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateUploading);
            this.b.suProgressBar.setProgress(this.h.uploadPercent);
            this.b.suProgressBar.invalidate();
            this.b.suProgressText.setText(com.up366.common.StringUtils.format("%d%%", java.lang.Integer.valueOf(this.h.uploadPercent)));
        } else if (i == 1) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateSelect);
        } else if (i == 2) {
            this.b.suProgressBar.setProgress(this.h.uploadPercent);
            this.b.suProgressBar.invalidate();
            this.b.suProgressText.setText(com.up366.common.StringUtils.format("%d%%", java.lang.Integer.valueOf(this.h.uploadPercent)));
        } else if (i == 3) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateSuccess);
            com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.OralFeedbackDialog$$ExternalSyntheticLambda14
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$detectState$13();
                }
            });
        } else if (i == 4) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.stateFailed);
        }
        this.currentState = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$detectState$13() throws java.lang.Exception {
        this.dialog.dismiss();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.FeedbackOralUploadSuccess());
        com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo = this.callbackCodeInfo;
        if (iCallbackCodeInfo != null) {
            iCallbackCodeInfo.onResult(0, "success");
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.isFailed()) {
            com.up366.common.log.Logger.error("FeedbackTaskRecord - onMessageEvent - ERROR : " + commonUploadLogEvent.toString());
            detectState(4);
        }
        if (commonUploadLogEvent.getType() == 22 && commonUploadLogEvent.getRefKey().equals(this.h.uploadId)) {
            if (commonUploadLogEvent.isSuccess()) {
                detectState(3);
                com.up366.common.FileUtilsUp.deleteDirOrFile(this.h.zipPath);
            }
            if (this.currentState != 4 && commonUploadLogEvent.isProgressUpdate()) {
                this.h.uploadPercent = commonUploadLogEvent.getPercent();
                detectState(2);
            }
        }
    }

    class Holder {
        long countFinalZipSize;
        int courseId;
        java.lang.String engineVersion;
        int evaluation;
        java.lang.String ossUrl;
        com.alibaba.fastjson.JSONObject params;
        com.alibaba.fastjson.JSONArray recordInfos;
        java.lang.String recordUrl;
        float score;
        java.lang.String taskInfo;
        java.lang.String uploadId;
        int uploadPercent;
        java.lang.String zipPath;

        Holder() {
        }
    }
}
