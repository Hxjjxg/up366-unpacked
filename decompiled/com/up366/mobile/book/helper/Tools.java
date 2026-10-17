package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Tools {
    private static final int BUFFER_SIZE = 4096;
    public static final java.lang.String KEY_EXTRA_DATA_DISMISS_LOADING = "key_extra_data_dismiss_loading";
    public static final java.lang.String KEY_EXTRA_DATA_SHOW_TITLE_BAR = "key_extra_data_show_title_bar";
    public static final java.lang.String KEY_EXTRA_DATA_UPDATE_TITLE_FROM_HTML = "key_extra_data_update_title_from_html";
    public static final java.lang.String RESOURCE_TEST_CACHE_ID = "resource_test_cacheId";
    public static java.lang.String SDK_VERSION = "1.0.0";
    public static final java.lang.String common2025BookId = "16E8112B4C537956FD0A2060E3D86644";
    public static final java.lang.String commonBookId = "5DCDFABF59D854C9B01C9811B08548D0";
    public static androidx.core.util.Supplier<java.lang.String> env = new androidx.core.util.Supplier() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda13
        public final java.lang.Object get() {
            return com.up366.mobile.book.helper.Tools.lambda$static$0();
        }
    };
    public static java.lang.String platform = "UP366";
    public static java.lang.String client = "STUDENT";
    public static androidx.core.util.Supplier<java.lang.String> clientId = new androidx.core.util.Supplier() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda14
        public final java.lang.Object get() {
            return com.up366.mobile.common.helper.DeviceIdHelper.getDeviceId();
        }
    };
    public static boolean gray = com.up366.mobile.common.utils.PlatformUtils.isGray();
    private static final java.util.Map<java.lang.String, com.alibaba.fastjson.JSONArray> apiMap = new java.util.HashMap();
    public static final com.up366.mobile.book.helper.Tools.StudyTrackContext alarmLogTrackContext = new com.up366.mobile.book.helper.Tools.StudyTrackContext();

    public static class AlarmCode {
        public static final java.lang.String _004002001 = "004002001";
        public static final java.lang.String _004002002 = "004002002";
        public static final java.lang.String _004002003 = "004002003";
        public static final java.lang.String _004002004 = "004002004";
        public static final java.lang.String _004002005 = "004002005";
        public static final java.lang.String _004002006 = "004002006";
        public static final java.lang.String _004003001 = "004003001";
        public static final java.lang.String _004004001 = "004004001";
        public static final java.lang.String _004004002 = "004004002";
        public static final java.lang.String _004004006 = "004004006";
        public static final java.lang.String _004004007 = "004004007";
        public static final java.lang.String _004004008 = "004004008";
        public static final java.lang.String _004005001 = "004005001";
    }

    public static class StudyTrackContext {
        public java.lang.String bookId;
        public java.lang.Integer courseId;
        public java.lang.String extData;
        public java.lang.String fileId;
        public java.lang.String ipAddress;
        public java.lang.String localMd5;
        public java.lang.String md5;
        public java.lang.String msg;
        public java.lang.String params;
        public java.lang.String src;
        public java.lang.String studyTaskId;
        public java.lang.String taskId;
        public java.lang.String url;
    }

    public static void checkResourceRootDirV9(java.lang.String str) {
    }

    public static boolean isSDKV9(int i) {
        return i == 9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.String lambda$static$0() {
        /*
            java.lang.String r0 = com.up366.mobile.common.utils.PlatformUtils.getTargetHost()
            int r1 = r0.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case -1284762386: goto L2f;
                case -548733026: goto L24;
                case -121843615: goto L19;
                case 772114063: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L3a
        Le:
            java.lang.String r1 = "up366test.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = 0
            goto L3b
        L19:
            java.lang.String r1 = "up366.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = 3
            goto L3b
        L24:
            java.lang.String r1 = "up366demo.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = r3
            goto L3b
        L2f:
            java.lang.String r1 = "up366.com.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            r0 = r2
            goto L3b
        L3a:
            r0 = -1
        L3b:
            if (r0 == 0) goto L4a
            if (r0 == r3) goto L47
            if (r0 == r2) goto L44
            java.lang.String r0 = "PRODUCT"
            return r0
        L44:
            java.lang.String r0 = "UAT"
            return r0
        L47:
            java.lang.String r0 = "DEMO"
            return r0
        L4a:
            java.lang.String r0 = "TEST"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.Tools.lambda$static$0():java.lang.String");
    }

    public static com.up366.common.http.NetHolder<com.alibaba.fastjson.JSONObject> getBookInfo(java.lang.String str, java.lang.String str2, int i) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<com.alibaba.fastjson.JSONObject> netHolder = new com.up366.common.http.NetHolder<>();
        com.up366.mobile.book.model.BookDetailInfo bookDetailInfoLoadBookDetailInfo = com.up366.mobile.common.logic.Auth.cur().book().loadBookDetailInfo(str2);
        if (bookDetailInfoLoadBookDetailInfo == null || !android.text.TextUtils.equals(str, str2)) {
            com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolderFetchBookDetailSync = com.up366.mobile.common.logic.Auth.cur().book().fetchBookDetailSync(str2, 1);
            if (!netHolderFetchBookDetailSync.resp.isError()) {
                bookDetailInfoLoadBookDetailInfo = netHolderFetchBookDetailSync.info;
            }
            if (bookDetailInfoLoadBookDetailInfo == null) {
                netHolder.initWith(netHolderFetchBookDetailSync.resp, null);
                return netHolder;
            }
        }
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy(bookDetailInfoLoadBookDetailInfo);
        if (i > 0) {
            bookInfoStudy.setCourseId(i);
        }
        bookInfoStudy.setFileId(com.up366.mobile.common.logic.Auth.cur().config().convertBookFileId(str2, bookDetailInfoLoadBookDetailInfo.getFileId()));
        bookInfoStudy.initHasBuy();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put("bookName", bookInfoStudy.getBookName());
        jSONObject.put("isFree", java.lang.Integer.valueOf(bookInfoStudy.isHasBuy() ? 1 : 0));
        jSONObject.put("startTime", java.lang.Long.valueOf(bookInfoStudy.getStartTime()));
        jSONObject.put("endTime", java.lang.Long.valueOf(bookInfoStudy.getEndTime()));
        jSONObject.put("authDate", java.lang.Integer.valueOf(bookInfoStudy.getValidDays()));
        jSONObject.put("price", java.lang.Float.valueOf(bookInfoStudy.getPrice()));
        jSONObject.put("productId", java.lang.Integer.valueOf(bookInfoStudy.getProductId()));
        jSONObject.put("stageId", java.lang.Integer.valueOf(bookInfoStudy.getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(bookInfoStudy.getSubjectId()));
        jSONObject.put("extDailyDate", com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd"));
        jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, new com.up366.mobile.book.helper.V8FilePathHelper().getResourceDir(bookInfoStudy.getFileId()));
        netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), jSONObject);
        return netHolder;
    }

    public static boolean zip(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.io.File[] fileArrListFiles;
        java.io.File file = new java.io.File(str);
        java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(str2)), 4096));
        try {
            boolean zZipFile = true;
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    zZipFile &= zipFile(file2, zipOutputStream, "");
                }
            }
            zipOutputStream.flush();
            zipOutputStream.close();
            return zZipFile;
        } catch (java.lang.Throwable th) {
            try {
                zipOutputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static boolean zipFile(java.io.File file, java.util.zip.ZipOutputStream zipOutputStream, java.lang.String str) throws java.lang.Exception {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : java.io.File.separator);
        sb.append(file.getName());
        java.lang.String string = sb.toString();
        if (file.isDirectory()) {
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return true;
            }
            for (java.io.File file2 : fileArrListFiles) {
                zipFile(file2, zipOutputStream, string);
            }
            return true;
        }
        byte[] bArr = new byte[4096];
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file), 4096);
        try {
            zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(string));
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i != -1) {
                    zipOutputStream.write(bArr, 0, i);
                } else {
                    bufferedInputStream.close();
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void uploadAppLogs(final java.lang.String str, final com.up366.mobile.book.helper.V8RegisterHelper v8RegisterHelper) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda18
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.Tools.lambda$uploadAppLogs$1(str, v8RegisterHelper);
            }
        });
    }

    static /* synthetic */ void lambda$uploadAppLogs$1(java.lang.String str, com.up366.mobile.book.helper.V8RegisterHelper v8RegisterHelper) throws java.lang.Exception {
        try {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put(com.igexin.push.core.b.C, str);
            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject.put("msg", "");
            jSONObject.put("uploadSize", 0);
            jSONObject.put("totalSize", 0);
            jSONObject.put("code", 1);
            v8RegisterHelper.callJsEvent("appLogsUpload", "(%s)", jSONObject.toJSONString());
            java.io.File zipFile = com.up366.mobile.common.compat.CopyAppDataToSdcardCompat.getZipFile(true, null);
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(zipFile.getPath(), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(zipFile.getPath(), ".zip", false, com.up366.mobile.common.utils.alifile.OssObjectKey.Business.FEEDBACK));
            com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(25, java.util.UUID.randomUUID().toString());
            batchUploadLog.addFile(zipFile, fileMapInfoSaveSync.getObjectId());
            java.lang.String url = fileMapInfoSaveSync.getUrl();
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, url);
            batchUploadLog.setRefKey(str);
            batchUploadLog.setParams(jSONObject2.toJSONString());
            com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - JSInterfaceV8 - uploadAppLogs - ", e);
            com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
            jSONObject3.put(com.igexin.push.core.b.C, str);
            jSONObject3.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject3.put("msg", e.getMessage());
            jSONObject3.put("uploadSize", 0);
            jSONObject3.put("totalSize", 0);
            jSONObject3.put("code", -1);
            v8RegisterHelper.callJsEvent("appLogsUpload", "(%s)", jSONObject3.toJSONString());
        }
    }

    public static void uploadAppLogsV9(final java.lang.String str, final com.up366.mobile.book.helper.V9RegisterHelper v9RegisterHelper) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda15
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.Tools.lambda$uploadAppLogsV9$2(str, v9RegisterHelper);
            }
        });
    }

    static /* synthetic */ void lambda$uploadAppLogsV9$2(java.lang.String str, com.up366.mobile.book.helper.V9RegisterHelper v9RegisterHelper) throws java.lang.Exception {
        try {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put(com.igexin.push.core.b.C, str);
            jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject.put("msg", "");
            jSONObject.put("uploadSize", 0);
            jSONObject.put("totalSize", 0);
            jSONObject.put("code", 1);
            v9RegisterHelper.callJsEvent("appLogsUpload", "(%s)", jSONObject.toJSONString());
            java.io.File zipFile = com.up366.mobile.common.compat.CopyAppDataToSdcardCompat.getZipFile(true, null);
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(zipFile.getPath(), ".zip", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(27, java.util.UUID.randomUUID().toString());
            batchUploadLog.addFile(zipFile, fileMapInfoSaveSync.getObjectId());
            java.lang.String url = fileMapInfoSaveSync.getUrl();
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, url);
            batchUploadLog.setRefKey(str);
            batchUploadLog.setParams(jSONObject2.toJSONString());
            com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - JSInterfaceV9 - uploadAppLogs - ", e);
            com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
            jSONObject3.put(com.igexin.push.core.b.C, str);
            jSONObject3.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject3.put("msg", e.getMessage());
            jSONObject3.put("uploadSize", 0);
            jSONObject3.put("totalSize", 0);
            jSONObject3.put("code", -1);
            v9RegisterHelper.callJsEvent("appLogsUpload", "(%s)", jSONObject3.toJSONString());
        }
    }

    public static void uploadFile(java.lang.String str, com.up366.mobile.book.helper.V8RegisterHelper v8RegisterHelper) {
        java.lang.String string;
        java.lang.String string2;
        java.lang.String string3;
        com.up366.mobile.book.helper.V8RegisterHelper v8RegisterHelper2 = v8RegisterHelper;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string4 = object.getString(com.igexin.push.core.b.C);
        try {
            string = object.getString("type");
            string2 = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            string3 = object.getString("localPath");
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(10, java.util.UUID.randomUUID().toString());
            batchUploadLog.setRefKey(string4);
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = null;
            if (android.text.TextUtils.equals(com.up366.mobile.commonui.CommonWebViewActivity.URL, string)) {
                fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSync(string2, null);
            } else if (android.text.TextUtils.equals("file", string) && com.up366.common.FileUtilsUp.isFileExists(string3)) {
                fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(string3, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getExtensionName(string3), com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            }
            if (fileMapInfoSaveSync != null) {
                if (fileMapInfoSaveSync.getPath().endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
                    batchUploadLog.addWav(new java.io.File(fileMapInfoSaveSync.getPath()), fileMapInfoSaveSync.getObjectId());
                } else {
                    batchUploadLog.addFile(new java.io.File(fileMapInfoSaveSync.getPath()), fileMapInfoSaveSync.getObjectId());
                }
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfoSaveSync.getUrl());
                batchUploadLog.setRefKey(string4);
                batchUploadLog.setParams(jSONObject.toJSONString());
                com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
                return;
            }
            com.up366.common.log.Logger.error("TAG - Tools - uploadFile - file not exists " + string3 + " url:" + string2);
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put(com.igexin.push.core.b.C, string4);
            jSONObject2.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject2.put("msg", "文件不存在!");
            jSONObject2.put("progress", 0);
            jSONObject2.put("status", -1);
            v8RegisterHelper.callJsEvent("fileUpload", "(%s)", jSONObject2.toJSONString());
        } catch (java.lang.Exception e2) {
            e = e2;
            v8RegisterHelper2 = v8RegisterHelper;
            com.up366.common.log.Logger.error("TAG - JSInterfaceV8 - uploadFile - ", e);
            com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
            jSONObject3.put(com.igexin.push.core.b.C, string4);
            jSONObject3.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject3.put("msg", e.getMessage());
            jSONObject3.put("progress", 0);
            jSONObject3.put("status", -1);
            v8RegisterHelper2.callJsEvent("fileUpload", "(%s)", jSONObject3.toJSONString());
        }
    }

    public static void uploadFileV9(java.lang.String str, com.up366.mobile.book.helper.V9RegisterHelper v9RegisterHelper) {
        java.lang.String string;
        java.lang.String string2;
        java.lang.String string3;
        com.up366.mobile.book.helper.V9RegisterHelper v9RegisterHelper2 = v9RegisterHelper;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string4 = object.getString(com.igexin.push.core.b.C);
        try {
            string = object.getString("type");
            string2 = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            string3 = object.getString("localPath");
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(10, java.util.UUID.randomUUID().toString());
            batchUploadLog.setRefKey(string4);
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = null;
            if (android.text.TextUtils.equals(com.up366.mobile.commonui.CommonWebViewActivity.URL, string)) {
                fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSync(string2, null);
            } else if (android.text.TextUtils.equals("file", string) && com.up366.common.FileUtilsUp.isFileExists(string3)) {
                fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(string3, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getExtensionName(string3), com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366);
            }
            if (fileMapInfoSaveSync != null) {
                if (fileMapInfoSaveSync.getPath().endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
                    batchUploadLog.addWav(new java.io.File(fileMapInfoSaveSync.getPath()), fileMapInfoSaveSync.getObjectId());
                } else {
                    batchUploadLog.addFile(new java.io.File(fileMapInfoSaveSync.getPath()), fileMapInfoSaveSync.getObjectId());
                }
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                jSONObject.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, fileMapInfoSaveSync.getUrl());
                batchUploadLog.setRefKey(string4);
                batchUploadLog.setParams(jSONObject.toJSONString());
                com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
                return;
            }
            com.up366.common.log.Logger.error("TAG - Tools - uploadFile - file not exists " + string3 + " url:" + string2);
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            jSONObject2.put(com.igexin.push.core.b.C, string4);
            jSONObject2.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject2.put("msg", "文件不存在!");
            jSONObject2.put("progress", 0);
            jSONObject2.put("status", -1);
            v9RegisterHelper.callJsEvent("fileUpload", "(%s)", jSONObject2.toJSONString());
        } catch (java.lang.Exception e2) {
            e = e2;
            v9RegisterHelper2 = v9RegisterHelper;
            com.up366.common.log.Logger.error("TAG - JSInterfaceV9 - uploadFile - ", e);
            com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
            jSONObject3.put(com.igexin.push.core.b.C, string4);
            jSONObject3.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, "");
            jSONObject3.put("msg", e.getMessage());
            jSONObject3.put("progress", 0);
            jSONObject3.put("status", -1);
            v9RegisterHelper2.callJsEvent("fileUpload", "(%s)", jSONObject3.toJSONString());
        }
    }

    public static void cancelAppLogs(java.lang.String str, com.up366.mobile.book.helper.V8RegisterHelper v8RegisterHelper) {
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList()) {
            if (android.text.TextUtils.equals(str, batchUploadLog.getRefKey())) {
                com.up366.mobile.common.logic.Auth.cur().logMgr().deleteTask(batchUploadLog.getBatchId());
            }
        }
    }

    public static void cancelAppLogsV9(java.lang.String str, com.up366.mobile.book.helper.V9RegisterHelper v9RegisterHelper) {
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList()) {
            if (android.text.TextUtils.equals(str, batchUploadLog.getRefKey())) {
                com.up366.mobile.common.logic.Auth.cur().logMgr().deleteTask(batchUploadLog.getBatchId());
            }
        }
    }

    public static void setSystemViewColor(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (android.text.TextUtils.isEmpty(str3)) {
            str3 = str2;
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            str2 = str4;
        }
        android.view.Window window = activity.getWindow();
        window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
        window.clearFlags(67108864);
        window.clearFlags(134217728);
        if (!android.text.TextUtils.isEmpty(str3)) {
            int color = android.graphics.Color.parseColor(str3);
            window.setStatusBarColor(color);
            applyTopSystemAreaBackground(activity, color);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            window.setNavigationBarColor(android.graphics.Color.parseColor(str2));
        }
        applyStatusBarTextAppearance(activity, isStatusBarTextHidden(window), android.text.TextUtils.isEmpty(str) ? null : java.lang.Integer.valueOf(android.graphics.Color.parseColor(str)), android.text.TextUtils.isEmpty(str3) ? null : java.lang.Integer.valueOf(android.graphics.Color.parseColor(str3)));
    }

    public static void setStatusBarTextHidden(android.app.Activity activity, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        android.view.View decorView = window.getDecorView();
        android.view.View viewFindViewById = activity.findViewById(android.R.id.content);
        if (z) {
            window.addFlags(1024);
            window.clearFlags(io.objectbox.model.PropertyFlags.INDEX_HASH);
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                window.setDecorFitsSystemWindows(false);
                android.view.WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.hide(android.view.WindowInsets.Type.statusBars());
                    insetsController.setSystemBarsBehavior(2);
                }
            } else {
                decorView.setSystemUiVisibility(5894);
            }
            viewFindViewById.setFitsSystemWindows(false);
            viewFindViewById.setPadding(0, 0, 0, 0);
        } else {
            window.clearFlags(1024);
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                window.setDecorFitsSystemWindows(true);
                android.view.WindowInsetsController insetsController2 = window.getInsetsController();
                if (insetsController2 != null) {
                    insetsController2.show(android.view.WindowInsets.Type.statusBars());
                }
            } else {
                decorView.setSystemUiVisibility(256);
            }
            viewFindViewById.setFitsSystemWindows(true);
        }
        viewFindViewById.requestLayout();
    }

    public static void setFullScreen(android.app.Activity activity, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        android.view.View decorView = window.getDecorView();
        android.view.View viewFindViewById = activity.findViewById(android.R.id.content);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = z ? 1 : 0;
            window.setAttributes(attributes);
        }
        if (z) {
            window.addFlags(1024);
            window.clearFlags(io.objectbox.model.PropertyFlags.INDEX_HASH);
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                window.setDecorFitsSystemWindows(false);
                android.view.WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.hide(android.view.WindowInsets.Type.systemBars());
                    insetsController.setSystemBarsBehavior(2);
                }
            } else {
                decorView.setSystemUiVisibility(5894);
            }
            setContentFitsSystemWindows(viewFindViewById, false);
            return;
        }
        window.clearFlags(1024);
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(true);
            android.view.WindowInsetsController insetsController2 = window.getInsetsController();
            if (insetsController2 != null) {
                insetsController2.show(android.view.WindowInsets.Type.systemBars());
            }
        } else {
            decorView.setSystemUiVisibility(256);
        }
        setContentFitsSystemWindows(viewFindViewById, true);
    }

    private static void setContentFitsSystemWindows(android.view.View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setFitsSystemWindows(z);
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                android.view.View childAt = viewGroup.getChildAt(0);
                childAt.setFitsSystemWindows(z);
                if (!z) {
                    childAt.setPadding(0, 0, 0, 0);
                }
                childAt.requestApplyInsets();
            }
        }
        view.requestApplyInsets();
        view.requestLayout();
    }

    private static void applyTopSystemAreaBackground(android.app.Activity activity, int i) {
        activity.getWindow().getDecorView().setBackgroundColor(i);
        android.view.View viewFindViewById = activity.findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(i);
        }
        android.view.View viewFindViewById2 = activity.findViewById(com.up366.mobile.R.id.root_container);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setBackgroundColor(i);
        }
        android.view.View viewFindViewById3 = activity.findViewById(com.up366.mobile.R.id.title_bar);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setBackgroundColor(i);
        }
    }

    private static boolean isStatusBarTextHidden(android.view.Window window) {
        android.view.WindowInsets rootWindowInsets;
        if (window == null) {
            return false;
        }
        if ((window.getAttributes().flags & 1024) != 0) {
            return true;
        }
        android.view.View decorView = window.getDecorView();
        if (decorView == null) {
            return false;
        }
        if ((decorView.getSystemUiVisibility() & 4) != 0) {
            return true;
        }
        if (android.os.Build.VERSION.SDK_INT < 30 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return false;
        }
        return !rootWindowInsets.isVisible(android.view.WindowInsets.Type.statusBars());
    }

    private static void applyStatusBarTextAppearance(android.app.Activity activity, boolean z, java.lang.Integer num, java.lang.Integer num2) {
        int iIntValue;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        android.view.Window window = activity.getWindow();
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            iIntValue = num2 != null ? num2.intValue() : window.getStatusBarColor();
        }
        int iRed = ((android.graphics.Color.red(iIntValue) + android.graphics.Color.green(iIntValue)) + android.graphics.Color.blue(iIntValue)) / 3;
        if (!z ? iRed > 128 : iRed < 128) {
            com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(activity);
        } else {
            com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarDarkMode(activity);
        }
    }

    public static boolean unzip(java.lang.String str, java.lang.String str2) {
        final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        com.up366.common.download.ZipHelper.unzip(str, str2, new com.up366.common.download.ZipHelper.ZipCallback() { // from class: com.up366.mobile.book.helper.Tools.1
            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onProgress(int i) {
            }

            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onSuccess() {
                atomicBoolean.set(true);
            }

            @Override // com.up366.common.download.ZipHelper.ZipCallback
            public void onFail(java.lang.Exception exc) {
                atomicBoolean.set(false);
            }
        });
        return atomicBoolean.get();
    }

    public static java.lang.Object[] convertDownloadErrorCodeInfo(com.up366.common.event.DownloadEvent downloadEvent) {
        int i;
        int errCode;
        int state = downloadEvent.getState();
        java.lang.String str = "";
        if (state != 3) {
            i = 4;
            if (state != 4) {
                i = 5;
                if (state == 5) {
                    int errCode2 = downloadEvent.getErrCode();
                    i = errCode2 == -111 ? 3 : 2;
                    java.lang.String errInfo = downloadEvent.getErrInfo();
                    if (errInfo != null && !errInfo.contains("失败")) {
                        errInfo = "下载失败：" + errInfo;
                    } else if (errInfo == null) {
                        errInfo = "下载失败";
                    }
                    str = errInfo;
                    errCode = errCode2;
                } else if (state != 6) {
                    errCode = 0;
                    i = 0;
                } else {
                    errCode = downloadEvent.getErrCode();
                    str = "取消下载";
                }
            }
            return new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(errCode), str};
        }
        i = 1;
        errCode = 0;
        return new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(errCode), str};
    }

    public static java.lang.String getUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static boolean canIUse(java.lang.String str) {
        com.alibaba.fastjson.JSONArray jSONArray;
        if (apiMap.size() == 0) {
            com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(com.up366.common.FileUtilsUp.getAssetFile("api.json"));
            for (int i = 0; i < array.size(); i++) {
                com.alibaba.fastjson.JSONArray jSONArray2 = array.getJSONArray(i);
                apiMap.put(jSONArray2.getString(0), jSONArray2);
            }
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("method");
        java.lang.String string2 = object.getString("api");
        java.lang.String string3 = object.getString("param");
        java.lang.Object obj = object.get("option");
        if (android.text.TextUtils.isEmpty(string)) {
            string = "callHandler";
        }
        java.lang.String str2 = string + "|" + string2;
        if (!android.text.TextUtils.isEmpty(string3)) {
            str2 = str2 + "|" + string3;
        }
        com.alibaba.fastjson.JSONArray jSONArray3 = apiMap.get(str2);
        if (jSONArray3 == null) {
            return false;
        }
        java.lang.String string4 = jSONArray3.getString(1);
        jSONArray = jSONArray3.size() == 3 ? jSONArray3.getJSONArray(2) : null;
        string4.hashCode();
        switch (string4) {
            case "enum":
                if (obj != null && jSONArray != null) {
                    return jSONArray.contains(obj);
                }
            case "api":
            case "var":
                return true;
            case "range":
                if (obj == null || jSONArray == null) {
                    return true;
                }
                double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                return dDoubleValue >= jSONArray.getDoubleValue(0) && dDoubleValue <= jSONArray.getDoubleValue(1);
            default:
                return false;
        }
    }

    public static java.util.List<java.lang.String> initLocalFileIds(java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list) {
        java.lang.String strLoadFileIdByPaperId;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < list.size(); i++) {
            final com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo = list.get(i);
            if (pendingInfo.type == 0) {
                com.up366.mobile.book.helper.Tools.SimpleTreeInfo simpleTreeInfoLoadSimpleTreeInfo = com.up366.mobile.common.logic.Auth.cur().book().loadSimpleTreeInfo(pendingInfo);
                strLoadFileIdByPaperId = simpleTreeInfoLoadSimpleTreeInfo != null ? simpleTreeInfoLoadSimpleTreeInfo.fileId : null;
                com.up366.common.log.Logger.info("TAG - Tools - initLocalFileIds - loadFileIdByTaskId taskId:" + pendingInfo.taskId + " fileId:" + strLoadFileIdByPaperId);
                com.up366.mobile.common.utils.FileDownloadRecord.add(strLoadFileIdByPaperId, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda16
                    public final void accept(java.lang.Object obj) {
                        com.up366.mobile.book.helper.Tools.lambda$initLocalFileIds$3(pendingInfo, (com.alibaba.fastjson.JSONObject) obj);
                    }
                });
            } else if (pendingInfo.type == 1) {
                strLoadFileIdByPaperId = com.up366.mobile.common.logic.Auth.cur().homework().loadFileIdByPaperId(pendingInfo.paperId);
                com.up366.common.log.Logger.info("TAG - Tools - initLocalFileIds - loadFileIdByPaperId paperId:" + pendingInfo.paperId + " fileId:" + strLoadFileIdByPaperId);
                com.up366.mobile.common.utils.FileDownloadRecord.add(strLoadFileIdByPaperId, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda17
                    public final void accept(java.lang.Object obj) {
                        ((com.alibaba.fastjson.JSONObject) obj).put("paperid", pendingInfo.paperId);
                    }
                });
            } else if (pendingInfo.type == 2) {
                strLoadFileIdByPaperId = pendingInfo.fileId;
            } else {
                throw new java.lang.IllegalStateException("unknown type : " + pendingInfo.type);
            }
            arrayList.add(strLoadFileIdByPaperId);
        }
        return arrayList;
    }

    static /* synthetic */ void lambda$initLocalFileIds$3(com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("bookid", pendingInfo.bookId);
        jSONObject.put("taskid", pendingInfo.taskId);
    }

    public static java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> buildPendingInfosPaper(java.lang.String str) {
        com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo = new com.up366.mobile.book.helper.Tools.PendingInfo();
        pendingInfo.type = 1;
        pendingInfo.paperId = str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(pendingInfo);
        return arrayList;
    }

    public static java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> buildPendingInfosTask(java.lang.String str, java.lang.String str2, int i) {
        com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo = new com.up366.mobile.book.helper.Tools.PendingInfo();
        pendingInfo.type = 0;
        pendingInfo.bookId = str;
        pendingInfo.taskId = str2;
        pendingInfo.bookType = i;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(pendingInfo);
        return arrayList;
    }

    public static java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> buildPendingInfosFileId(java.lang.String str) {
        com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo = new com.up366.mobile.book.helper.Tools.PendingInfo();
        pendingInfo.type = 2;
        pendingInfo.fileId = str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(pendingInfo);
        return arrayList;
    }

    public static com.up366.mobile.book.helper.Tools.HolderBuildURL buildOSSURL(java.lang.String str) {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            return new com.up366.mobile.book.helper.Tools.HolderBuildURL(1, "文件不存在", null);
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = com.up366.mobile.common.logic.Auth.cur().fileMgr().getFileMapInfo(null, str);
        if (fileMapInfo == null) {
            return new com.up366.mobile.book.helper.Tools.HolderBuildURL(2, "生成URL失败", null);
        }
        return new com.up366.mobile.book.helper.Tools.HolderBuildURL(0, "success", fileMapInfo.getUrl());
    }

    public static com.alibaba.fastjson.JSONArray buildOSSURLBatch(java.util.List<java.lang.String> list) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        for (java.lang.String str : list) {
            com.up366.mobile.book.helper.Tools.HolderBuildURL holderBuildURLBuildOSSURL = buildOSSURL(str);
            if (holderBuildURLBuildOSSURL.code == 0) {
                jSONArray.add(new java.lang.Object(str, holderBuildURLBuildOSSURL.url, holderBuildURLBuildOSSURL.msg) { // from class: com.up366.mobile.book.helper.Tools.1OSSURLHolder
                    public final java.lang.String filePath;
                    public final java.lang.String msg;
                    public final java.lang.String ossUrl;

                    {
                        this.filePath = str;
                        this.ossUrl = str;
                        this.msg = str;
                    }
                });
            } else {
                com.up366.common.log.Logger.error("TAG - Tools - buildOSSURLBatch - error:" + holderBuildURLBuildOSSURL.msg);
                jSONArray.add(new java.lang.Object(str, "", holderBuildURLBuildOSSURL.msg) { // from class: com.up366.mobile.book.helper.Tools.1OSSURLHolder
                    public final java.lang.String filePath;
                    public final java.lang.String msg;
                    public final java.lang.String ossUrl;

                    {
                        this.filePath = str;
                        this.ossUrl = str;
                        this.msg = str;
                    }
                });
            }
        }
        return jSONArray;
    }

    public static com.up366.common.http.NetHolder<com.alibaba.fastjson.JSONObject> getTaskList() throws java.lang.InterruptedException {
        com.up366.common.http.Response responseFetchTaskList = com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchTaskList();
        com.up366.common.http.NetHolder<com.alibaba.fastjson.JSONObject> netHolder = new com.up366.common.http.NetHolder<>();
        if (responseFetchTaskList.isError()) {
            netHolder.initWith(responseFetchTaskList, null);
            return netHolder;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("all", com.up366.mobile.common.logic.Auth.cur().taskMgr().loadAllJob());
        jSONObject.put("finish", com.up366.mobile.common.logic.Auth.cur().taskMgr().loadFinish());
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RefreshTaskListEvent());
        netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), jSONObject);
        return netHolder;
    }

    public static class HolderBuildURL {
        public int code;
        public java.lang.String msg;
        public java.lang.String url;

        public HolderBuildURL(int i, java.lang.String str, java.lang.String str2) {
            this.code = i;
            this.msg = str;
            this.url = str2;
        }
    }

    public static class PendingInfo {
        public static final int TYPE_FILE_ID = 2;
        public static final int TYPE_TASK = 0;
        public static final int TYPE_TEST = 1;
        public java.lang.String bookId;
        public int bookType;
        public java.lang.String fileId;
        public java.lang.String paperId;
        public java.lang.String taskId;
        public int type;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface FileIdType {
        }

        public static java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> parse(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return new java.util.ArrayList();
            }
            return com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.book.helper.Tools.PendingInfo.class);
        }
    }

    public static java.util.List<java.lang.String> initWebFileIds(java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list, com.up366.common.http.NetHolder<java.lang.Object> netHolder) throws java.lang.InterruptedException {
        java.lang.String fileId;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < list.size(); i++) {
            final com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo = list.get(i);
            java.lang.String str = null;
            if (pendingInfo.type == 0) {
                com.up366.mobile.book.helper.Tools.StudyTrackContext studyTrackContext = alarmLogTrackContext;
                studyTrackContext.bookId = pendingInfo.bookId;
                studyTrackContext.taskId = pendingInfo.taskId;
                com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> netHolderFetchSimpleTreeByTaskId = com.up366.mobile.common.logic.Auth.cur().book().fetchSimpleTreeByTaskId(pendingInfo.bookId, pendingInfo.taskId, pendingInfo.bookType);
                com.up366.common.log.Logger.info("TAG - Tools - initWebFileIds - fetchFileIdByTaskId - bookId:" + pendingInfo.bookId + " taskId:" + pendingInfo.taskId + " fileId:" + netHolderFetchSimpleTreeByTaskId.info);
                if (!netHolderFetchSimpleTreeByTaskId.resp.isError()) {
                    str = netHolderFetchSimpleTreeByTaskId.info.fileId;
                    com.up366.mobile.common.utils.FileDownloadRecord.add(str, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda11
                        public final void accept(java.lang.Object obj) {
                            com.up366.mobile.book.helper.Tools.lambda$initWebFileIds$5(pendingInfo, (com.alibaba.fastjson.JSONObject) obj);
                        }
                    });
                } else {
                    com.up366.common.log.Logger.error("TAG - Tools - initWebFileIds - fetchFileIdByTaskId - error : " + netHolderFetchSimpleTreeByTaskId.resp);
                    netHolder.initWith(netHolderFetchSimpleTreeByTaskId.resp, null);
                }
                studyTrackContext.fileId = str;
                if (android.text.TextUtils.isEmpty(str)) {
                    if (pendingInfo.bookType == 1) {
                        com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-fileId-standard", 3000);
                        com.up366.common.log.Logger.error(studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002002));
                    }
                    if (pendingInfo.bookType == 2) {
                        com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-fileId-school", 3000);
                        com.up366.common.log.Logger.error(studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002002));
                    }
                }
            } else if (pendingInfo.type == 1) {
                com.up366.common.http.NetHolder<com.up366.mobile.course.homework.model.PaperDownInfo> netHolderFetchDownInfoByPaperIdSync = com.up366.mobile.common.logic.Auth.cur().homework().fetchDownInfoByPaperIdSync(pendingInfo.paperId);
                com.up366.common.log.Logger.info("TAG - Tools - initWebFileIds - fetchDownInfoByPaperIdSync - paperId:" + pendingInfo.paperId + " info:" + netHolderFetchDownInfoByPaperIdSync.info);
                if (!netHolderFetchDownInfoByPaperIdSync.resp.isError()) {
                    fileId = netHolderFetchDownInfoByPaperIdSync.info.getFileId();
                    com.up366.mobile.common.utils.FileDownloadRecord.add(fileId, new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda12
                        public final void accept(java.lang.Object obj) {
                            ((com.alibaba.fastjson.JSONObject) obj).put("paperid", pendingInfo.paperId);
                        }
                    });
                } else {
                    com.up366.common.log.Logger.error("TAG - Tools - initWebFileIds - fetchDownInfoByPaperIdSync - error : " + netHolderFetchDownInfoByPaperIdSync.resp);
                    netHolder.initWith(netHolderFetchDownInfoByPaperIdSync.resp, null);
                    fileId = null;
                }
                com.up366.mobile.book.helper.Tools.StudyTrackContext studyTrackContext2 = alarmLogTrackContext;
                studyTrackContext2.bookId = null;
                studyTrackContext2.taskId = null;
                studyTrackContext2.fileId = fileId;
                if (android.text.TextUtils.isEmpty(fileId)) {
                    com.up366.common.log.Logger.error(studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002002));
                    com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-fileId-test", 3000);
                }
                str = fileId;
            } else if (pendingInfo.type == 2) {
                str = pendingInfo.fileId;
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    static /* synthetic */ void lambda$initWebFileIds$5(com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("bookid", pendingInfo.bookId);
        jSONObject.put("taskid", pendingInfo.taskId);
    }

    public static boolean hasReadyFileIds(java.lang.String str, java.util.List<java.lang.String> list) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (list.size() == 0) {
            return true;
        }
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            if (android.text.TextUtils.isEmpty(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean initCheckBook(final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolder, androidx.core.util.Consumer<com.up366.mobile.book.helper.Tools.JsSdkType> consumer, androidx.core.util.Consumer<java.lang.Boolean> consumer2, androidx.core.util.Consumer<com.up366.common.http.Response> consumer3, java.lang.Runnable runnable) throws java.lang.InterruptedException {
        boolean z;
        com.up366.common.http.Response response;
        java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list = com.up366.mobile.book.helper.Tools.PendingInfo.parse(openConfigInfo.extFileIds);
        com.up366.mobile.book.helper.Tools.PendingInfo taskPendingInfo = getTaskPendingInfo(list);
        com.up366.mobile.book.helper.Tools.SimpleTreeInfo simpleTreeInfoLoadSimpleTreeInfo = com.up366.mobile.common.logic.Auth.cur().book().loadSimpleTreeInfo(taskPendingInfo);
        java.lang.String bookId = bookInfoStudy.getBookId();
        int bookType = bookInfoStudy.getBookType();
        java.lang.String bookId2 = bookInfoStudy.getBookId();
        if (simpleTreeInfoLoadSimpleTreeInfo != null) {
            java.lang.String openBookId = simpleTreeInfoLoadSimpleTreeInfo.getOpenBookId();
            if (!android.text.TextUtils.isEmpty(openBookId)) {
                bookId2 = openBookId;
            }
        }
        com.up366.mobile.book.model.BookDetailInfo bookDetailInfoLoadBookDetailInfo = com.up366.mobile.common.logic.Auth.cur().book().loadBookDetailInfo(bookId2);
        com.up366.mobile.book.helper.Tools.JsSdkType jsSdkTypeDetectSdkType = detectSdkType(bookId2, bookDetailInfoLoadBookDetailInfo);
        if (jsSdkTypeDetectSdkType != com.up366.mobile.book.helper.Tools.JsSdkType.NONE) {
            updateBookAndConfigFromDetail(bookInfoStudy, openConfigInfo, bookDetailInfoLoadBookDetailInfo, jsSdkTypeDetectSdkType);
            consumer.accept(jsSdkTypeDetectSdkType);
            java.util.List<java.lang.String> listInitLocalFileIds = initLocalFileIds(list);
            if (hasReadyFileIds(bookInfoStudy.getFileId(), listInitLocalFileIds)) {
                openConfigInfo.setExtFileIdList(listInitLocalFileIds);
                if (jsSdkTypeDetectSdkType == com.up366.mobile.book.helper.Tools.JsSdkType.V8) {
                    consumer2.accept(false);
                }
            }
            z = true;
        } else {
            z = false;
        }
        com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> netHolderFetchSimpleTreeInfo = fetchSimpleTreeInfo(taskPendingInfo, bookInfoStudy, openConfigInfo);
        com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolderFetchBookDetailInfo = fetchBookDetailInfo(netHolderFetchSimpleTreeInfo, bookId, bookType, jsSdkTypeDetectSdkType);
        if (netHolderFetchSimpleTreeInfo == null || !netHolderFetchSimpleTreeInfo.resp.isError()) {
            response = null;
        } else {
            response = netHolderFetchSimpleTreeInfo.resp;
            com.up366.common.log.Logger.error("Tools - initCheckBook - treeInfo:" + netHolderFetchSimpleTreeInfo.resp);
        }
        if (netHolderFetchBookDetailInfo != null && netHolderFetchBookDetailInfo.resp.isError()) {
            response = netHolderFetchBookDetailInfo.resp;
            com.up366.common.log.Logger.error("Tools - initCheckBook - bookDetail:" + netHolderFetchBookDetailInfo.resp);
        }
        if (response != null && bookDetailInfoLoadBookDetailInfo == null) {
            consumer3.accept(response);
            com.up366.common.log.Logger.info("initCheckBook  data is null skip " + jsSdkTypeDetectSdkType);
            return true;
        }
        if (response != null) {
            com.up366.mobile.book.helper.Tools.JsSdkType jsSdkTypeDetectSdkType2 = detectSdkType(bookId2, bookDetailInfoLoadBookDetailInfo);
            if (jsSdkTypeDetectSdkType2 != com.up366.mobile.book.helper.Tools.JsSdkType.NONE) {
                if (!z) {
                    consumer.accept(jsSdkTypeDetectSdkType2);
                }
                updateBookAndConfigFromDetail(bookInfoStudy, openConfigInfo, bookDetailInfoLoadBookDetailInfo, jsSdkTypeDetectSdkType2);
                java.util.List<java.lang.String> listInitLocalFileIds2 = initLocalFileIds(list);
                if (hasReadyFileIds(bookInfoStudy.getFileId(), listInitLocalFileIds2)) {
                    com.up366.mobile.common.utils.FileDownloadRecord.add(bookInfoStudy.getFileId(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda9
                        public final void accept(java.lang.Object obj) {
                            ((com.alibaba.fastjson.JSONObject) obj).put("bookid", bookInfoStudy.getBookId());
                        }
                    });
                    openConfigInfo.setExtFileIdList(listInitLocalFileIds2);
                    consumer2.accept(true);
                    return true;
                }
                consumer3.accept(response);
                return true;
            }
            runnable.run();
            updateBookAndConfigFromDetail(bookInfoStudy, openConfigInfo, bookDetailInfoLoadBookDetailInfo, jsSdkTypeDetectSdkType2);
            return false;
        }
        if (netHolderFetchBookDetailInfo != null) {
            com.up366.mobile.book.model.BookDetailInfo bookDetailInfo = netHolderFetchBookDetailInfo.info;
            java.lang.String bookId3 = bookDetailInfo.getBookId();
            netHolder.initWith(netHolderFetchBookDetailInfo.resp, netHolderFetchBookDetailInfo.info);
            com.up366.mobile.book.helper.Tools.JsSdkType jsSdkTypeDetectSdkType3 = detectSdkType(bookId3, bookDetailInfo);
            if (jsSdkTypeDetectSdkType3 != com.up366.mobile.book.helper.Tools.JsSdkType.NONE) {
                if (!z) {
                    consumer.accept(jsSdkTypeDetectSdkType3);
                }
                updateBookAndConfigFromDetail(bookInfoStudy, openConfigInfo, bookDetailInfo, jsSdkTypeDetectSdkType3);
                getAllResourceList(netHolderFetchSimpleTreeInfo, bookDetailInfo, openConfigInfo, jsSdkTypeDetectSdkType3);
                saveResourceMap(netHolderFetchSimpleTreeInfo, jsSdkTypeDetectSdkType3);
                com.up366.common.http.NetHolder netHolder2 = new com.up366.common.http.NetHolder();
                netHolder2.initWith(new com.up366.common.http.Response(0, "", "", 0, null), null);
                java.util.List<java.lang.String> listInitWebFileIds = initWebFileIds(list, netHolder2);
                if (netHolder.resp.isError()) {
                    consumer3.accept(netHolder.resp);
                } else if (netHolder2.resp.isError()) {
                    consumer3.accept(netHolder2.resp);
                } else {
                    if (!hasReadyFileIds(bookInfoStudy.getFileId(), listInitWebFileIds)) {
                        com.up366.common.log.Logger.error("TAG - Tools - initCheckV9Book - hasReadyFileIds == false book.fileId:" + bookInfoStudy.getFileId() + " extFileIds:" + listInitWebFileIds + " size:" + listInitWebFileIds.size());
                    }
                    com.up366.mobile.common.utils.FileDownloadRecord.add(bookInfoStudy.getFileId(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.Tools$$ExternalSyntheticLambda10
                        public final void accept(java.lang.Object obj) {
                            ((com.alibaba.fastjson.JSONObject) obj).put("bookid", bookInfoStudy.getBookId());
                        }
                    });
                    openConfigInfo.setExtFileIdList(listInitWebFileIds);
                    consumer2.accept(true);
                    return true;
                }
                return true;
            }
            runnable.run();
            updateBookAndConfigFromDetail(bookInfoStudy, openConfigInfo, bookDetailInfo, jsSdkTypeDetectSdkType3);
            return false;
        }
        throw new java.lang.IllegalStateException("unknown state");
    }

    private static void saveResourceMap(com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> netHolder, com.up366.mobile.book.helper.Tools.JsSdkType jsSdkType) {
        if (netHolder == null || jsSdkType != com.up366.mobile.book.helper.Tools.JsSdkType.V8 || android.text.TextUtils.isEmpty(netHolder.info.fileId)) {
            return;
        }
        java.lang.String str = netHolder.info.fileId;
        com.up366.mobile.common.logic.Auth.cur().db1().saveOrUpdate(new com.up366.mobile.book.model.BookResourceMapInfo(str, netHolder.info.bookId, new com.up366.mobile.book.helper.V8FilePathHelper().getResourceDir(str)));
    }

    public enum JsSdkType {
        V8(1),
        V9(2),
        NONE(-1);

        final int sdkCode;

        JsSdkType(int i) {
            this.sdkCode = i;
        }
    }

    private static com.up366.mobile.book.helper.Tools.JsSdkType detectSdkType(java.lang.String str, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        if (checkIsSDKV9(bookDetailInfo)) {
            return com.up366.mobile.book.helper.Tools.JsSdkType.V9;
        }
        if (checkIsSDKV8(str, bookDetailInfo)) {
            return com.up366.mobile.book.helper.Tools.JsSdkType.V8;
        }
        return com.up366.mobile.book.helper.Tools.JsSdkType.NONE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void getAllResourceList(com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> r9, com.up366.mobile.book.model.BookDetailInfo r10, com.up366.mobile.book.model.OpenConfigInfo r11, com.up366.mobile.book.helper.Tools.JsSdkType r12) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.Tools.getAllResourceList(com.up366.common.http.NetHolder, com.up366.mobile.book.model.BookDetailInfo, com.up366.mobile.book.model.OpenConfigInfo, com.up366.mobile.book.helper.Tools$JsSdkType):void");
    }

    private static com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> fetchBookDetailInfo(com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> netHolder, java.lang.String str, int i, com.up366.mobile.book.helper.Tools.JsSdkType jsSdkType) throws java.lang.InterruptedException {
        if (netHolder != null) {
            if (netHolder.resp.isError()) {
                return null;
            }
            java.lang.String openBookId = netHolder.info.getOpenBookId();
            if (!android.text.TextUtils.isEmpty(openBookId)) {
                i = 1;
                if (netHolder.info.isOpenTypeGeneralBook2025() && jsSdkType != com.up366.mobile.book.helper.Tools.JsSdkType.V9) {
                    return com.up366.mobile.common.logic.Auth.cur().book().fetchBookDetailSync(openBookId, str, 1);
                }
                str = openBookId;
            }
        }
        return com.up366.mobile.common.logic.Auth.cur().book().fetchBookDetailSync(str, i);
    }

    private static com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> fetchSimpleTreeInfo(com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) throws java.lang.InterruptedException {
        if (pendingInfo != null && pendingInfo.type == 0) {
            return com.up366.mobile.common.logic.Auth.cur().book().fetchSimpleTreeByTaskId(pendingInfo.bookId, pendingInfo.taskId, pendingInfo.bookType);
        }
        java.lang.String bookId = bookInfoStudy.getBookId();
        java.lang.String str = openConfigInfo.taskId;
        if (!android.text.TextUtils.isEmpty(openConfigInfo.bookId)) {
            bookId = openConfigInfo.bookId;
        }
        if (android.text.TextUtils.isEmpty(bookId) || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return com.up366.mobile.common.logic.Auth.cur().book().fetchSimpleTreeByTaskId(bookId, str, 1);
    }

    private static boolean checkIsSDKV8(java.lang.String str, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        return isSDKV8(str, bookDetailInfo != null ? bookDetailInfo.getPackType() : -1);
    }

    public static boolean isSDKV8(java.lang.String str, int i) {
        return android.text.TextUtils.equals(commonBookId, str) || i == 8;
    }

    private static boolean checkIsSDKV9(com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        return isSDKV9(bookDetailInfo != null ? bookDetailInfo.getPackType() : -1);
    }

    private static void updateBookAndConfigFromDetail(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo, com.up366.mobile.book.helper.Tools.JsSdkType jsSdkType) {
        if (bookDetailInfo != null) {
            openConfigInfo.bookId = bookDetailInfo.getBookId();
            openConfigInfo.packType = bookDetailInfo.getPackType();
            if (jsSdkType == com.up366.mobile.book.helper.Tools.JsSdkType.V9 && com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.openUrl) && !com.up366.common.StringUtils.isEmptyOrNull(bookDetailInfo.getOpenUrl())) {
                openConfigInfo.openUrl = bookDetailInfo.getOpenUrl();
            }
            bookInfoStudy.initWithBookDetailInfo(bookDetailInfo);
            bookInfoStudy.setFileId(com.up366.mobile.common.logic.Auth.cur().config().convertBookFileId(bookInfoStudy.getBookId(), bookDetailInfo.getFileId()));
        }
    }

    private static com.up366.mobile.book.helper.Tools.PendingInfo getTaskPendingInfo(java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list) {
        for (com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo : list) {
            if (pendingInfo.type == 0) {
                return pendingInfo;
            }
        }
        return null;
    }

    private static com.up366.mobile.book.helper.Tools.PendingInfo getTestPendingInfo(java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list) {
        for (com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo : list) {
            if (pendingInfo.type == 1) {
                return pendingInfo;
            }
        }
        return null;
    }

    private static com.up366.mobile.book.helper.Tools.PendingInfo getFileIdPendingInfo(java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list) {
        for (com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo : list) {
            if (pendingInfo.type == 2) {
                return pendingInfo;
            }
        }
        return null;
    }

    public static java.util.List<java.lang.String> readDir(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.String[] list;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File file = new java.io.File(str2);
        if (!file.isDirectory() || (list = file.list()) == null) {
            return arrayList;
        }
        for (java.lang.String str3 : list) {
            if (z) {
                if (new java.io.File(str2, str3).isDirectory()) {
                    arrayList.add(com.up366.common.FileUtilsUp.join(str, str3, "/"));
                    arrayList.addAll(readDir(com.up366.common.FileUtilsUp.join(str, str3), com.up366.common.FileUtilsUp.join(str2, str3), z));
                } else {
                    arrayList.add(com.up366.common.FileUtilsUp.join(str, str3));
                }
            } else if (new java.io.File(str2, str3).isDirectory()) {
                arrayList.add(com.up366.common.FileUtilsUp.join(str, str3, "/"));
            } else {
                arrayList.add(com.up366.common.FileUtilsUp.join(str, str3));
            }
        }
        return arrayList;
    }

    public static void checkResourceRootDir(java.lang.String str) {
        java.lang.String rootResourceDir = com.up366.mobile.common.utils.AppFileUtils.getRootResourceDir();
        if (str != null) {
            int iIndexOf = rootResourceDir.indexOf("/Android/data/");
            int iIndexOf2 = str.indexOf("/Android/data/");
            if (iIndexOf < 0) {
                return;
            }
            if (iIndexOf2 > 0 && str.substring(iIndexOf2).startsWith(rootResourceDir.substring(iIndexOf))) {
                return;
            }
        }
        com.up366.common.log.Logger.error("TAG - Tools - checkResourceRootDir - root:" + rootResourceDir + " path:" + str);
        throw new java.lang.IllegalStateException("访问路径错误");
    }

    public static class SimpleTreeInfo {
        public static final java.lang.String OPEN_TYPE_2025 = "GeneralBook2025";
        public static final java.lang.String OPEN_TYPE_SELF = "Self";
        private java.lang.String bookId;
        public java.lang.String fileId;
        public java.lang.String openType;
        private java.lang.String treeJson;

        public java.lang.String getOpenBookId() {
            if (android.text.TextUtils.isEmpty(this.openType) || android.text.TextUtils.equals(OPEN_TYPE_SELF, this.openType)) {
                com.up366.common.log.Logger.info("TAG - SimpleTreeInfo - getOpenBookId - openType:" + this.openType);
                return null;
            }
            if (android.text.TextUtils.equals(OPEN_TYPE_2025, this.openType)) {
                return com.up366.mobile.book.helper.Tools.common2025BookId;
            }
            java.lang.String string = com.up366.mobile.common.logic.Auth.cur().config().getBookOpenType().getString(this.openType);
            if (android.text.TextUtils.isEmpty(string)) {
                com.up366.common.log.Logger.info("TAG - SimpleTreeInfo - getOpenBookId - openType:" + this.openType + " commonBookId:5DCDFABF59D854C9B01C9811B08548D0");
                return com.up366.mobile.book.helper.Tools.commonBookId;
            }
            com.up366.common.log.Logger.info("TAG - SimpleTreeInfo - getOpenBookId - openType:" + this.openType + " openBookId:" + string);
            return string;
        }

        public boolean isOpenTypeGeneralBook2025() {
            return android.text.TextUtils.equals(OPEN_TYPE_2025, this.openType);
        }

        public SimpleTreeInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.bookId = str;
            this.treeJson = str2;
            this.fileId = str3;
            this.openType = str4;
        }

        public java.lang.String toString() {
            return "SimpleTreeInfo{bookId='" + this.bookId + "', fileId='" + this.fileId + "', openType='" + this.openType + "'}";
        }
    }

    public static java.lang.String getMainFileIdFromCfg(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list = com.up366.mobile.book.helper.Tools.PendingInfo.parse(openConfigInfo.extFileIds);
        com.up366.mobile.book.helper.Tools.SimpleTreeInfo simpleTreeInfoLoadSimpleTreeInfo = com.up366.mobile.common.logic.Auth.cur().book().loadSimpleTreeInfo(getTaskPendingInfo(list));
        if (simpleTreeInfoLoadSimpleTreeInfo != null) {
            return simpleTreeInfoLoadSimpleTreeInfo.fileId;
        }
        com.up366.mobile.book.helper.Tools.PendingInfo testPendingInfo = getTestPendingInfo(list);
        if (testPendingInfo != null) {
            return com.up366.mobile.common.logic.Auth.cur().homework().loadFileIdByPaperId(testPendingInfo.paperId);
        }
        com.up366.mobile.book.helper.Tools.PendingInfo fileIdPendingInfo = getFileIdPendingInfo(list);
        if (fileIdPendingInfo != null) {
            return fileIdPendingInfo.fileId;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.exerciseData)) {
            return null;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(openConfigInfo.exerciseData);
        if (!object.containsKey(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID) || !object.containsKey(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID)) {
            return null;
        }
        java.lang.String string = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        com.up366.mobile.book.helper.Tools.SimpleTreeInfo simpleTreeInfoLoadSimpleTreeInfo2 = com.up366.mobile.common.logic.Auth.cur().book().loadSimpleTreeInfo(object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID), string);
        if (simpleTreeInfoLoadSimpleTreeInfo2 != null) {
            return simpleTreeInfoLoadSimpleTreeInfo2.fileId;
        }
        return null;
    }

    public static com.alibaba.fastjson.JSONObject getSimpleTreeInfoByCfg(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.up366.mobile.book.helper.Tools.SimpleTreeInfo simpleTreeInfoLoadSimpleTreeInfo = com.up366.mobile.common.logic.Auth.cur().book().loadSimpleTreeInfo(getTaskPendingInfo(com.up366.mobile.book.helper.Tools.PendingInfo.parse(openConfigInfo.extFileIds)));
        if (simpleTreeInfoLoadSimpleTreeInfo == null || simpleTreeInfoLoadSimpleTreeInfo.treeJson == null) {
            return null;
        }
        return com.alibaba.fastjson.JSON.parseObject(simpleTreeInfoLoadSimpleTreeInfo.treeJson);
    }

    public static com.up366.mobile.book.model.BookInfoStudy convertToRealOpenBook(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.alibaba.fastjson.JSONObject object;
        if (bookInfoStudy != null && !isSDKV8(bookInfoStudy.getBookId(), bookInfoStudy.getPackType())) {
            return bookInfoStudy;
        }
        if (openConfigInfo == null) {
            return null;
        }
        try {
            object = com.alibaba.fastjson.JSON.parseObject(openConfigInfo.commonParams);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - Tools - convertToRealOpenBook - ", e);
        }
        if (object == null) {
            return null;
        }
        java.lang.String string = object.getString("scenario");
        if (android.text.TextUtils.equals(string, "_STANDARD_BOOK_") || android.text.TextUtils.equals(string, "_SCHOOL_BOOK_PRACTICE_")) {
            java.lang.String string2 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            com.up366.mobile.book.model.BookDetailInfo bookDetailInfoLoadBookDetailInfo = com.up366.mobile.common.logic.Auth.cur().book().loadBookDetailInfo(string2);
            if (bookDetailInfoLoadBookDetailInfo == null) {
                com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolderFetchBookDetailSync = com.up366.mobile.common.logic.Auth.cur().book().fetchBookDetailSync(string2, object.getIntValue("bookType"));
                if (netHolderFetchBookDetailSync.resp.isError()) {
                    com.up366.common.log.Logger.error("Tools - convertToRealOpenBook - " + netHolderFetchBookDetailSync.resp);
                    return null;
                }
                return new com.up366.mobile.book.model.BookInfoStudy(netHolderFetchBookDetailSync.info);
            }
            return new com.up366.mobile.book.model.BookInfoStudy(bookDetailInfoLoadBookDetailInfo);
        }
        return null;
    }

    public static boolean filterNoDisplayBook(java.lang.String str) {
        if (android.text.TextUtils.equals(str, commonBookId)) {
            return true;
        }
        return com.up366.mobile.common.logic.Auth.cur().config().getBookOpenType().containsValue(str);
    }

    public static java.lang.String getBookScenario(int i) {
        if (i == 2) {
            return "_SCHOOL_BOOK_PRACTICE_";
        }
        return "_STANDARD_BOOK_";
    }

    public static void openJSV8WebViewWithUrl(android.app.Activity activity, java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("scene", "common");
        jSONObject2.put("title", str);
        jSONObject2.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str2);
        jSONObject2.put("extraData", jSONObject);
        com.up366.mobile.book.helper.V8OpenHelper.openWebView(activity, jSONObject2.toJSONString(), null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static java.lang.String studyAlarmLog(java.lang.String str) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.book.helper.Tools.StudyTrackContext studyTrackContext = alarmLogTrackContext;
        appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, studyTrackContext.courseId);
        appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, studyTrackContext.studyTaskId);
        appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, studyTrackContext.bookId);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 1517665779:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004002001)) {
                    b = 0;
                }
                break;
            case 1517665780:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004002002)) {
                    b = 1;
                }
                break;
            case 1517665782:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004002004)) {
                    b = 2;
                }
                break;
            case 1517665783:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004002005)) {
                    b = 3;
                }
                break;
            case 1517665784:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004002006)) {
                    b = 4;
                }
                break;
            case 1517695570:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004003001)) {
                    b = 5;
                }
                break;
            case 1517725361:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004004001)) {
                    b = 6;
                }
                break;
            case 1517725362:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004004002)) {
                    b = 7;
                }
                break;
            case 1517725366:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004004006)) {
                    b = 8;
                }
                break;
            case 1517725367:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004004007)) {
                    b = 9;
                }
                break;
            case 1517725368:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004004008)) {
                    b = 10;
                }
                break;
            case 1517755152:
                if (str.equals(com.up366.mobile.book.helper.Tools.AlarmCode._004005001)) {
                    b = com.igexin.push.core.b.n.l;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                break;
            case 2:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                appendAlarmLogField(jSONObject, "fileId", studyTrackContext.fileId);
                appendAlarmLogField(jSONObject, com.up366.mobile.commonui.CommonWebViewActivity.URL, studyTrackContext.url);
                appendAlarmLogField(jSONObject, "ipAddr", studyTrackContext.ipAddress);
                appendAlarmLogField(jSONObject, "msg", studyTrackContext.msg);
                break;
            case 3:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                appendAlarmLogField(jSONObject, "fileId", studyTrackContext.fileId);
                appendAlarmLogField(jSONObject, com.up366.mobile.commonui.CommonWebViewActivity.URL, studyTrackContext.url);
                appendAlarmLogField(jSONObject, "ipAddr", studyTrackContext.ipAddress);
                appendAlarmLogField(jSONObject, "md5", studyTrackContext.md5);
                appendAlarmLogField(jSONObject, "localMd5", studyTrackContext.localMd5);
                appendAlarmLogField(jSONObject, "msg", studyTrackContext.msg);
                break;
            case 4:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                appendAlarmLogField(jSONObject, "fileId", studyTrackContext.fileId);
                appendAlarmLogField(jSONObject, com.up366.mobile.commonui.CommonWebViewActivity.URL, studyTrackContext.url);
                appendAlarmLogField(jSONObject, "ipAddr", studyTrackContext.ipAddress);
                appendAlarmLogField(jSONObject, "msg", studyTrackContext.msg);
                break;
            case 5:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                break;
            case 6:
            case 7:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                appendAlarmLogField(jSONObject, com.up366.qmui.skin.QMUISkinValueBuilder.SRC, studyTrackContext.src);
                appendAlarmLogField(jSONObject, "msg", studyTrackContext.msg);
                break;
            case 8:
            case 9:
            case 10:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                appendAlarmLogField(jSONObject, "msg", studyTrackContext.msg);
                appendAlarmLogField(jSONObject, "params", studyTrackContext.params);
                appendAlarmLogField(jSONObject, "extData", studyTrackContext.extData);
                break;
            case 11:
                appendAlarmLogField(jSONObject, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, studyTrackContext.taskId);
                appendAlarmLogField(jSONObject, "msg", studyTrackContext.msg);
                appendAlarmLogField(jSONObject, "params", studyTrackContext.params);
                break;
        }
        return com.up366.mobile.common.helper.AlarmLogHelper.INSTANCE.buildAlarmLog(str, jSONObject);
    }

    private static void appendAlarmLogField(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) {
        if (obj != null) {
            jSONObject.put(str, obj);
        }
    }

    public static void setupTrackContext(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.alibaba.fastjson.JSONObject object;
        java.lang.String bookId = openConfigInfo.bookId;
        java.lang.String string = openConfigInfo.studyTaskId;
        if (bookInfoStudy != null) {
            integer = bookInfoStudy.getCourseId() > 0 ? java.lang.Integer.valueOf(bookInfoStudy.getCourseId()) : null;
            if (bookId == null) {
                bookId = bookInfoStudy.getBookId();
            }
        }
        if (openConfigInfo.commonParams != null && (object = com.alibaba.fastjson.JSON.parseObject(openConfigInfo.commonParams)) != null && object.containsKey("studyTaskDetail")) {
            com.alibaba.fastjson.JSONObject jSONObject = object.getJSONObject("studyTaskDetail");
            integer = jSONObject.getInteger(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
            string = jSONObject.getString("jobId");
        }
        com.up366.mobile.book.helper.Tools.StudyTrackContext studyTrackContext = alarmLogTrackContext;
        studyTrackContext.bookId = bookId;
        studyTrackContext.taskId = openConfigInfo.taskId;
        studyTrackContext.studyTaskId = string;
        studyTrackContext.courseId = integer;
    }
}
