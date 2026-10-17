package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UploadOralResultCompat {
    private static final java.lang.String UPLOAD_DIR = com.up366.mobile.common.utils.AppFileUtils.getAppInternalCacheDir() + java.io.File.separator + "oralUpload";
    private com.up366.mobile.common.dialog.BaseDialog dialog;

    public boolean handle(android.app.Activity activity, java.lang.String str) throws java.lang.Throwable {
        if (!str.startsWith("UOR-")) {
            return false;
        }
        java.lang.String str2 = str.split("-")[1];
        java.lang.String recordBinPath = com.up366.mobile.common.utils.AppFileUtils.getRecordBinPath();
        java.lang.String[] strArrSplit = str2.replace("，", com.igexin.push.core.b.an).split(com.igexin.push.core.b.an);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str3 : strArrSplit) {
            com.alibaba.fastjson.JSONObject jSONObjectFindRecordObj = findRecordObj(str3, recordBinPath);
            if (jSONObjectFindRecordObj != null) {
                arrayList.add(jSONObjectFindRecordObj);
            }
        }
        if (arrayList.size() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("未找到数据");
            return true;
        }
        uploadOralData(arrayList);
        return true;
    }

    private com.alibaba.fastjson.JSONObject findRecordObj(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        com.alibaba.fastjson.JSONObject jSONObject;
        com.alibaba.fastjson.JSONObject fileInputStream;
        com.alibaba.fastjson.JSONObject jSONObject2 = null;
        try {
            if (!com.up366.common.FileUtilsUp.isFileExists(str2)) {
                return null;
            }
            try {
                fileInputStream = new java.io.FileInputStream(str2);
            } catch (java.lang.Exception e) {
                e = e;
                jSONObject = null;
            }
            try {
                byte[] bArr = new byte[4];
                while (true) {
                    if (fileInputStream.read(bArr) <= 0) {
                        com.up366.common.log.Logger.error("TAG - 2018/7/13 - UploadOralResultCompat - findRecordObj - len < 0");
                        break;
                    }
                    int iByteArrayToInt = com.up366.common.digest.Hex.byteArrayToInt(bArr, 0);
                    byte[] bArr2 = new byte[iByteArrayToInt];
                    int i = fileInputStream.read(bArr2);
                    if (i != iByteArrayToInt) {
                        com.up366.common.log.Logger.error("TAG - 2018/7/13 - UploadOralResultCompat - findRecordObj - len:" + i + " size:" + iByteArrayToInt);
                        break;
                    }
                    com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(new java.lang.String(com.up366.common.ZipStringUtils.gunzip(bArr2)));
                    if (object != null) {
                        java.lang.Object obj = object.get("app_object_id");
                        com.up366.common.log.Logger.info("TAG - 2018/7/13 - UploadOralResultCompat - findRecordObj - appObjectId:" + obj);
                        if (str.equals(obj)) {
                            jSONObject2 = object;
                        }
                    }
                }
                com.up366.mobile.common.utils.IOUtils.close(fileInputStream);
            } catch (java.lang.Exception e2) {
                e = e2;
                jSONObject = null;
                jSONObject2 = fileInputStream;
                com.up366.common.log.Logger.error("TAG - UploadOralResultCompat - findRecordObj - ", e);
                com.up366.mobile.common.utils.IOUtils.close(jSONObject2);
                jSONObject2 = jSONObject;
            } catch (java.lang.Throwable th) {
                th = th;
                jSONObject2 = fileInputStream;
            }
            return jSONObject2;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        com.up366.mobile.common.utils.IOUtils.close(jSONObject2);
        throw th;
    }

    private static java.lang.String getZipFile(java.util.List<com.alibaba.fastjson.JSONObject> list) throws java.lang.Throwable {
        for (com.alibaba.fastjson.JSONObject jSONObject : list) {
            java.lang.String string = jSONObject.getString("app_object_id");
            java.lang.String string2 = jSONObject.getString("app_wav");
            java.lang.String[] strArrSplit = jSONObject.getString("app_net").split(com.igexin.push.core.b.an);
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(UPLOAD_DIR, string.replace(com.up366.medialibrary.common.utils.MimeTypeUtils.MP3, ""));
            com.up366.common.FileUtilsUp.copyFileOrDir(string2, com.up366.common.FileUtilsUp.join(strJoin, new java.io.File(string2).getName()));
            if (strArrSplit.length > 0) {
                java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, "net");
                java.lang.String str = strArrSplit[0];
                if (com.up366.common.FileUtilsUp.isDir(str)) {
                    com.up366.common.FileUtilsUp.copyFileOrDir(str, strJoin2);
                }
                if (com.up366.common.FileUtilsUp.isFile(str)) {
                    com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(str).getParent(), strJoin2);
                }
            }
        }
        java.lang.String str2 = UPLOAD_DIR;
        com.up366.common.FileUtilsUp.saveContentToFile(com.up366.common.FileUtilsUp.join(str2, "answer.json"), list.toString());
        java.lang.String str3 = str2 + ".zip";
        if (com.up366.common.FileUtilsUp.zip(str2, str3)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(str2);
        }
        return str3;
    }

    private void uploadOralData(final java.util.List<com.alibaba.fastjson.JSONObject> list) {
        showUploadDialog();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$uploadOralData$1(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadOralData$1(java.util.List list) throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(getZipFile(list), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$uploadOralData$0(fileMapInfo);
            }
        });
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.compat.UploadOralResultCompat$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.mobile.common.utils.alifile.IOSSCallback {
        final /* synthetic */ com.up366.mobile.common.utils.alifile.FileMapInfo val$info;

        AnonymousClass1(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
            this.val$info = fileMapInfo;
        }

        @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
        public void onSuccess() {
            final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = this.val$info;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onSuccess$2(fileMapInfo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$2(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) throws java.lang.Exception {
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.create(com.up366.mobile.R.layout.oral_test_submit_upload_success).setOnClickListener(new int[]{com.up366.mobile.R.id.hw_submit_upload_success_tv_sure}, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$1$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$onSuccess$0(view);
                }
            }).setText(com.up366.mobile.R.id.upload_text, "数据上传成功").setBackListener(new com.up366.mobile.common.dialog.BaseDialog.BackPressedListener() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$1$$ExternalSyntheticLambda3
                @Override // com.up366.mobile.common.dialog.BaseDialog.BackPressedListener
                public final void onBackPressed() {
                    this.f$0.lambda$onSuccess$1();
                }
            });
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.showIfNot();
            android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) com.up366.common.global.GB.get().getCurrentActivity().getSystemService("clipboard");
            android.content.ClipData clipDataNewPlainText = android.content.ClipData.newPlainText("口语地址", fileMapInfo.getUrl());
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(clipDataNewPlainText);
            } else {
                com.up366.common.log.Logger.error("TAG - uploadOralData error  - ClipboardManager == null");
            }
            com.up366.mobile.common.utils.ToastPopupUtil.show("已复制到粘贴板");
            com.up366.common.log.Logger.info("TAG - UploadOralResultCompat - onSuccess - url:" + fileMapInfo.getUrl());
            com.up366.mobile.common.onlinelog.OpLog.report("UploadOralUrl", fileMapInfo.getUrl());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(android.view.View view) {
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$1() {
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.dismiss();
        }

        @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
        public void onFailure(int i, final java.lang.String str) {
            com.up366.common.log.Logger.error("TAG - UploadOralResultCompat - onFailure - code = [" + i + "], info = [" + str + "]");
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$1$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onFailure$3(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$3(java.lang.String str) throws java.lang.Exception {
            com.up366.mobile.common.compat.UploadOralResultCompat.this.uploadErrorDialog(str);
        }

        @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
        public void onProgress(final long j, final long j2) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onProgress$4(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onProgress$4(long j, long j2) throws java.lang.Exception {
            if (com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.getView(com.up366.mobile.R.id.my_progress) == null) {
                com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.create(com.up366.mobile.R.layout.oral_test_submit_upload);
            }
            android.widget.ProgressBar progressBar = (android.widget.ProgressBar) com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.getView(com.up366.mobile.R.id.my_progress);
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.setText(com.up366.mobile.R.id.oral_test_submit_upload_tv_title, "数据上传中");
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.setText(com.up366.mobile.R.id.hw_submit_upload_tv_size, com.up366.common.ByteUtilsUp.downloadSpeed(j, j2));
            int i = (int) ((j * 100.0f) / j2);
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.setText(com.up366.mobile.R.id.hw_submit_upload_tv_percent, i + "%");
            progressBar.setProgress(i);
            com.up366.mobile.common.compat.UploadOralResultCompat.this.dialog.showIfNot();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadOralData$0(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.compat.UploadOralResultCompat.AnonymousClass1(fileMapInfo));
    }

    private void showUploadDialog() {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(com.up366.common.global.GB.get().getCurrentActivity());
        this.dialog = baseDialog;
        baseDialog.create(com.up366.mobile.R.layout.oral_test_submit_upload).setText(com.up366.mobile.R.id.oral_test_submit_upload_tv_title, "数据上传中").show();
        this.dialog.setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadErrorDialog(final java.lang.String str) {
        this.dialog.setCancelable(true);
        this.dialog.create(com.up366.mobile.R.layout.oral_test_submit_upload_failed).setText(com.up366.mobile.R.id.hw_submit_upload_failed_tv_title, "错误信息：\n" + str).setOnClickListener(new int[]{com.up366.mobile.R.id.hw_submit_upload_failed_tv_again}, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.compat.UploadOralResultCompat$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$uploadErrorDialog$2(str, view);
            }
        });
        this.dialog.showIfNot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadErrorDialog$2(java.lang.String str, android.view.View view) {
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            uploadErrorDialog(str);
        } else {
            showUploadDialog();
        }
    }
}
