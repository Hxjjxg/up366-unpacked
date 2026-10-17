package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ContentDownloadHelper {
    private static final int CATALOG = 1;
    public static final int CATALOG_AND_CHAPTER = 5;
    private static final int CHAPTER = 2;
    private static final int HOMEWORK = 3;
    private com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper;
    private com.up366.common.download.DownloadInfo catalogDownloadInfo;
    private com.up366.common.download.DownloadInfo chapterDownloadInfo;
    private android.app.Activity context;
    private com.up366.mobile.book.model.ChapterInfo curChapterInfo;
    private int curDownloadType;
    private com.up366.common.download.DownloadInfo currentDownloadInfo;
    private com.up366.mobile.book.StudyActivityInterface studyActivityInterface;
    private com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager = new com.up366.mobile.common.utils.MultiFileDownloadManager(0);
    private final java.util.List<com.up366.mobile.common.utils.ParamHolder2<java.lang.String, java.lang.String>> downloadMultiTempResourceV2BatchKeys = new java.util.ArrayList();

    public ContentDownloadHelper(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper) {
        this.studyActivityInterface = studyActivityInterface;
        this.context = studyActivityInterface.getContext();
        this.bookFilePathHelper = bookFilePathHelper;
    }

    public ContentDownloadHelper(android.app.Activity activity) {
        this.context = activity;
    }

    public boolean checkChapter(java.lang.String str) {
        return com.up366.common.FileUtilsUp.isCheckFileExists(this.bookFilePathHelper.getContentDir(str));
    }

    public com.up366.common.download.DownloadInfo fetchCatalogDownloadInfoSync() throws java.lang.InterruptedException {
        final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.studyActivityInterface.getBookInfoStudy();
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.bookFilePathHelper.getFileId())) {
            return fetchDownloadInfoByFileIdSync(this.bookFilePathHelper.getDownloadInfo(), this.bookFilePathHelper.getFileId());
        }
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.up366.mobile.common.logic.Auth.cur().book().fetchBookDetail(bookInfoStudy.getBookId(), bookInfoStudy.getBookType(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda10
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.book.helper.ContentDownloadHelper.lambda$fetchCatalogDownloadInfoSync$0(bookInfoStudy, countDownLatch, response, (com.up366.mobile.book.model.BookDetailInfo) obj);
            }
        });
        countDownLatch.await();
        return fetchDownloadInfoByFileIdSync(this.bookFilePathHelper.getDownloadInfo(), this.bookFilePathHelper.getFileId());
    }

    static /* synthetic */ void lambda$fetchCatalogDownloadInfoSync$0(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        if (response.isError()) {
            com.up366.common.log.Logger.error("ContentDownloadHelper - downloadCatalog - fetchBookDetail ERROR " + response.toString());
            com.up366.mobile.common.onlinelog.OpLog.report("Download-fetch-fileId-ERROR", response.toString());
        } else {
            java.lang.String bookId = bookInfoStudy.getBookId();
            java.lang.String fileId = bookDetailInfo.getFileId();
            if (android.text.TextUtils.isEmpty(fileId)) {
                com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002003));
            }
            bookInfoStudy.setFileId(com.up366.mobile.common.logic.Auth.cur().config().convertBookFileId(bookId, fileId));
            com.up366.mobile.common.onlinelog.OpLog.report("Download-fetch-fileId-OK", bookDetailInfo.getBookName() + " = " + bookDetailInfo.getBookId());
        }
        countDownLatch.countDown();
    }

    private void toDownloadFileByFileId(final com.up366.common.download.DownloadInfo downloadInfo, final java.lang.String str) {
        this.currentDownloadInfo = downloadInfo;
        com.up366.mobile.common.logic.Auth.cur().book().fetchFileInfo(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda9
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$toDownloadFileByFileId$1(downloadInfo, str, response, (com.up366.mobile.book.model.FileInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toDownloadFileByFileId$1(com.up366.common.download.DownloadInfo downloadInfo, java.lang.String str, com.up366.common.http.Response response, com.up366.mobile.book.model.FileInfo fileInfo) {
        if (response.isError()) {
            downloadInfo.setState(5);
            com.up366.common.EventBusUtilsUp.post(new com.up366.common.event.DownloadEvent(downloadInfo.getKey(), downloadInfo.getState(), downloadInfo.getDownType(), downloadInfo.getName(), 0L, 0L, -104, "获取下载信息失败！\n" + response.getInfo()));
            return;
        }
        applyFileInfo(downloadInfo, str, fileInfo);
        if (hasDestroy()) {
            return;
        }
        com.up366.mobile.common.utils.DownloadHelper.add(downloadInfo);
    }

    private com.up366.common.download.DownloadInfo fetchDownloadInfoByFileIdSync(final com.up366.common.download.DownloadInfo downloadInfo, final java.lang.String str) throws java.lang.InterruptedException {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.download.DownloadInfo[] downloadInfoArr = new com.up366.common.download.DownloadInfo[1];
        com.up366.mobile.common.logic.Auth.cur().book().fetchFileInfo(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$fetchDownloadInfoByFileIdSync$2(downloadInfo, str, downloadInfoArr, countDownLatch, response, (com.up366.mobile.book.model.FileInfo) obj);
            }
        });
        countDownLatch.await();
        if (downloadInfoArr[0] == null && downloadInfo.getDownType() == 1) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-catalog", 3000);
        }
        if (downloadInfoArr[0] == null && downloadInfo.getDownType() == 2) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-content", 3000);
        }
        return downloadInfoArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchDownloadInfoByFileIdSync$2(com.up366.common.download.DownloadInfo downloadInfo, java.lang.String str, com.up366.common.download.DownloadInfo[] downloadInfoArr, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.mobile.book.model.FileInfo fileInfo) {
        if (response.isError()) {
            com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - fetchDownloadInfoByFileIdSync - error : " + response);
        } else {
            applyFileInfo(downloadInfo, str, fileInfo);
            downloadInfoArr[0] = downloadInfo;
        }
        countDownLatch.countDown();
    }

    private com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> fetchDownloadInfoByFileId(final com.up366.common.download.DownloadInfo downloadInfo, final java.lang.String str) throws java.lang.InterruptedException {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolder = new com.up366.common.http.NetHolder<>();
        com.up366.mobile.common.logic.Auth.cur().book().fetchFileInfo(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$fetchDownloadInfoByFileId$3(netHolder, downloadInfo, str, countDownLatch, response, (com.up366.mobile.book.model.FileInfo) obj);
            }
        });
        countDownLatch.await();
        return netHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchDownloadInfoByFileId$3(com.up366.common.http.NetHolder netHolder, com.up366.common.download.DownloadInfo downloadInfo, java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.mobile.book.model.FileInfo fileInfo) {
        netHolder.initWith(response, downloadInfo);
        if (response.isError()) {
            com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - fetchDownloadInfoByFileId - error : " + response);
        } else {
            applyFileInfo(downloadInfo, str, fileInfo);
            downloadInfo.setName(fileInfo.getFileName());
        }
        netHolder.initWith(response, downloadInfo);
        countDownLatch.countDown();
    }

    private void applyFileInfo(com.up366.common.download.DownloadInfo downloadInfo, java.lang.String str, com.up366.mobile.book.model.FileInfo fileInfo) {
        downloadInfo.setDownloadUrl(fileInfo.getDownloadUrl());
        downloadInfo.setFileMD5(fileInfo.getFileMd5());
        downloadInfo.setFileSize(fileInfo.getFileSize());
        com.up366.mobile.book.helper.DownloadExtHelper.apply(downloadInfo, fileInfo);
    }

    public void downloadContentFromJS(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        downloadContent(chapterInfo);
    }

    public void downloadContent(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        this.curChapterInfo = chapterInfo;
        this.curDownloadType = 2;
        toDownloadFileByFileId(this.bookFilePathHelper.getDownloadInfo(chapterInfo), chapterInfo.getFileId());
    }

    public com.up366.common.download.DownloadInfo fetchContentDownloadInfoSync(com.up366.mobile.book.model.ChapterInfo chapterInfo) throws java.lang.InterruptedException {
        this.curChapterInfo = chapterInfo;
        this.curDownloadType = 2;
        if (android.text.TextUtils.isEmpty(chapterInfo.getFileId())) {
            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002002));
        }
        return fetchDownloadInfoByFileIdSync(this.bookFilePathHelper.getDownloadInfo(chapterInfo), chapterInfo.getFileId());
    }

    public void deleteChapter(java.lang.String str) {
        com.up366.common.FileUtilsUp.deleteDirOrFile(this.bookFilePathHelper.getContentDir(str));
    }

    public java.lang.String getChapterDownloadState(java.lang.String str) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return jSONObject.toJSONString();
        }
        java.lang.String[] strArrSplit = str.split(com.igexin.push.core.b.an);
        if (strArrSplit.length == 0) {
            return jSONObject.toJSONString();
        }
        for (java.lang.String str2 : strArrSplit) {
            java.lang.String strTrim = str2.trim();
            if (strTrim.length() >= 10) {
                jSONObject.put(strTrim, java.lang.Integer.valueOf(checkChapter(strTrim) ? 2 : 0));
            }
        }
        return jSONObject.toJSONString();
    }

    public boolean hasCatalogDownload() {
        return com.up366.common.FileUtilsUp.isCheckFileExists(this.bookFilePathHelper.getCatalogDir());
    }

    public boolean hasCatalogUpdate() throws java.lang.Throwable {
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(this.bookFilePathHelper.getCatalogDir(), "checkFile"));
        java.lang.String fileId = this.bookFilePathHelper.getFileId();
        com.up366.common.log.Logger.info("TAG - ContentDownloadHelper - hasCatalogUpdate - old:" + fileContent + " new:" + fileId);
        if (fileId == null) {
            return false;
        }
        if (fileContent == null) {
            return true;
        }
        return !fileContent.trim().equals(fileId);
    }

    public void validAsync(final java.lang.String str, final com.up366.common.task.Task task) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.ContentDownloadHelper.lambda$validAsync$4(str, task);
            }
        });
    }

    static /* synthetic */ void lambda$validAsync$4(java.lang.String str, com.up366.common.task.Task task) throws java.lang.Exception {
        if (com.up366.common.utils.EncryptUtil.valid(str)) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, task);
    }

    public boolean validSync(java.lang.String str) {
        return com.up366.common.utils.EncryptUtil.valid(str);
    }

    public boolean hasDownloadChapter(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        return com.up366.common.FileUtilsUp.isCheckFileExists(this.bookFilePathHelper.getContentDir(chapterInfo.getId()));
    }

    public boolean hasUpdateChapter(com.up366.mobile.book.model.ChapterInfo chapterInfo) throws java.lang.Throwable {
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(this.bookFilePathHelper.getContentDir(chapterInfo.getId()), "checkFile"));
        return !com.up366.common.StringUtils.isEmptyOrNull(chapterInfo.getFileId()) && (fileContent == null || !fileContent.trim().equals(chapterInfo.getFileId()));
    }

    public boolean checkHomeworkResourceUpdateSync(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, com.up366.common.download.DownloadInfo downloadInfo) throws java.lang.Throwable {
        if (downloadInfo == null) {
            return false;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getHomeworkDir(), com.alibaba.fastjson.JSON.parseObject(openConfigInfo.exerciseData).getString("testId"));
        java.lang.String fileVersion = downloadInfo.getFileVersion();
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(strJoin, "checkFile"));
        return !com.up366.common.StringUtils.isEmptyOrNull(fileVersion) && (fileContent == null || !fileContent.trim().equals(fileVersion));
    }

    public com.up366.common.download.DownloadInfo getHomeworkResourceDownloadInfoSync(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) throws java.lang.InterruptedException {
        final com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(openConfigInfo.exerciseData);
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getHomeworkDir(), object.getString("testId"));
        final java.lang.String string = object.getString("paperId");
        final com.up366.common.download.DownloadInfo[] downloadInfoArr = new com.up366.common.download.DownloadInfo[1];
        final com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(string);
        downloadInfo.setFilePath(com.up366.common.FileUtilsUp.join(strJoin, "/"));
        downloadInfo.setName(object.getString("testName"));
        downloadInfo.setDownType(7);
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setState(1);
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda7
            public final void accept(java.lang.Object obj) {
                com.up366.mobile.book.helper.ContentDownloadHelper.lambda$getHomeworkResourceDownloadInfoSync$5(string, object, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
        com.up366.mobile.common.logic.Auth.cur().homework().getDownInfoByPaperId(string, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda8
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.book.helper.ContentDownloadHelper.lambda$getHomeworkResourceDownloadInfoSync$6(downloadInfo, downloadInfoArr, countDownLatch, response, (com.up366.mobile.course.homework.model.PaperDownInfo) obj);
            }
        });
        countDownLatch.await();
        if (downloadInfoArr[0] == null) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.putCache("no-test-res", 3000);
        }
        return downloadInfoArr[0];
    }

    static /* synthetic */ void lambda$getHomeworkResourceDownloadInfoSync$5(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject, com.alibaba.fastjson.JSONObject jSONObject2) {
        jSONObject2.put("paperid", str);
        jSONObject2.put("testid", jSONObject.getString("testId"));
    }

    static /* synthetic */ void lambda$getHomeworkResourceDownloadInfoSync$6(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.download.DownloadInfo[] downloadInfoArr, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.mobile.course.homework.model.PaperDownInfo paperDownInfo) {
        if (!response.isError()) {
            downloadInfo.setFileVersion(java.lang.String.valueOf(paperDownInfo.getFileId()));
            downloadInfo.setDownloadUrl(paperDownInfo.getDownloadUrl());
            downloadInfo.setFileMD5(paperDownInfo.getFileMd5());
            downloadInfo.setFileSize(paperDownInfo.getFileSize());
            downloadInfoArr[0] = downloadInfo;
        }
        countDownLatch.countDown();
    }

    public boolean hasDestroy() {
        return com.up366.common.global.GB.get().getCurrentActivity() != this.context;
    }

    public boolean isSelf(java.lang.String str) {
        com.up366.common.download.DownloadInfo downloadInfo = this.currentDownloadInfo;
        return downloadInfo != null && downloadInfo.getKey().equals(str);
    }

    public com.up366.common.download.DownloadInfo getCurrentDownloadInfo() {
        com.up366.common.download.DownloadInfo downloadInfo = this.currentDownloadInfo;
        if (downloadInfo != null) {
            return downloadInfo;
        }
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager = this.multiFileDownloadManager;
        if (multiFileDownloadManager != null) {
            return multiFileDownloadManager.getCurrentDownloadInfo();
        }
        return null;
    }

    public boolean hasHomeworkDownload(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        return com.up366.common.FileUtilsUp.isCheckFileExists(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getHomeworkDir(), com.alibaba.fastjson.JSON.parseObject(openConfigInfo.exerciseData).getString("testId")));
    }

    public boolean validHomeworkResourceSync(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        return validSync(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getHomeworkDir(), com.alibaba.fastjson.JSON.parseObject(openConfigInfo.exerciseData).getString("testId")));
    }

    public void pauseCurrentDownload() {
        com.up366.common.download.DownloadInfo currentDownloadInfo;
        if (this.currentDownloadInfo != null) {
            com.up366.common.download.DownloadManager.getInstance().pauseDownload(this.currentDownloadInfo.getKey());
        }
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager = this.multiFileDownloadManager;
        if (multiFileDownloadManager == null || (currentDownloadInfo = multiFileDownloadManager.getCurrentDownloadInfo()) == null) {
            return;
        }
        com.up366.common.download.DownloadManager.getInstance().pauseDownload(currentDownloadInfo.getKey());
    }

    public void pauseAllDownload() {
        com.up366.common.download.DownloadManager.getInstance().pauseAllDownload();
    }

    public void resetMultiFileDownloadManager() {
        this.multiFileDownloadManager = new com.up366.mobile.common.utils.MultiFileDownloadManager(0L);
    }

    public void setUpMultiFileDownloadManagerHasDownloadSize() {
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager = this.multiFileDownloadManager;
        this.multiFileDownloadManager = new com.up366.mobile.common.utils.MultiFileDownloadManager(multiFileDownloadManager != null ? multiFileDownloadManager.getHasSuccessSize() : 0L);
    }

    public void downloadCombine(java.util.List<com.up366.common.download.DownloadInfo> list, com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback iDownloadManagerCallback) {
        java.util.Iterator<com.up366.common.download.DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            this.multiFileDownloadManager.add(it.next());
        }
        this.multiFileDownloadManager.setCallback(iDownloadManagerCallback);
        this.multiFileDownloadManager.startDownload();
    }

    public java.lang.String getTempResourcePath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalCacheDir(), "temp-resource", str, "/");
    }

    public boolean isTempResourceExists(java.lang.String str) {
        java.lang.String tempResourcePath = getTempResourcePath(str);
        boolean zValidSync = validSync(tempResourcePath);
        if (!zValidSync && com.up366.common.FileUtilsUp.isFileExists(tempResourcePath)) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(tempResourcePath);
        }
        return zValidSync;
    }

    public void downloadTempResource(final java.lang.String str, final androidx.core.util.Consumer<com.up366.common.event.DownloadEvent> consumer) throws java.lang.InterruptedException {
        java.lang.String tempResourcePath = getTempResourcePath(str);
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(tempResourcePath);
        downloadInfo.setName(str);
        downloadInfo.setDownType(20);
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setState(1);
        downloadInfo.setFileVersion(str);
        final com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolderFetchDownloadInfoByFileId = fetchDownloadInfoByFileId(downloadInfo, str);
        if (netHolderFetchDownloadInfoByFileId.resp.isError()) {
            consumer.accept(new com.up366.common.event.DownloadEvent(str, 5, netHolderFetchDownloadInfoByFileId.info.getDownType(), str, 0L, 1L, netHolderFetchDownloadInfoByFileId.resp.getCode(), netHolderFetchDownloadInfoByFileId.resp.getInfo()));
            return;
        }
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager = new com.up366.mobile.common.utils.MultiFileDownloadManager(0L);
        multiFileDownloadManager.add(netHolderFetchDownloadInfoByFileId.info);
        multiFileDownloadManager.setCallback(new com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback
            public final void onResult(int i, long j, long j2, int i2, java.lang.String str2) {
                java.lang.String str3 = str;
                consumer.accept(new com.up366.common.event.DownloadEvent(str3, i, ((com.up366.common.download.DownloadInfo) netHolderFetchDownloadInfoByFileId.info).getDownType(), str3, j, j2, i2, str2));
            }
        });
        this.currentDownloadInfo = downloadInfo;
        multiFileDownloadManager.startDownload();
    }

    public void downloadMultiTempResource(final java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray, final androidx.core.util.Consumer<com.up366.common.event.DownloadEvent> consumer) throws java.lang.InterruptedException {
        final com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager = new com.up366.mobile.common.utils.MultiFileDownloadManager(0L);
        for (int i = 0; i < jSONArray.size(); i++) {
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) jSONArray.get(i);
            java.lang.String string = jSONObject.getString("key");
            java.lang.String string2 = jSONObject.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            java.lang.String string3 = jSONObject.getString("type");
            boolean booleanValue = jSONObject.getBooleanValue("disablePrivateCloud");
            java.lang.String cacheFilePath = getCacheFilePath(string2);
            if (com.up366.common.FileUtilsUp.isFileExists(cacheFilePath) && !string2.endsWith(".net") && com.up366.common.FileUtilsUp.isDir(cacheFilePath) && validSync(cacheFilePath)) {
                com.up366.common.log.Logger.info("TAG - ContentDownloadHelper - downloadMultiTempResource - exists skip key:" + string + " path:" + cacheFilePath);
            } else {
                com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
                downloadInfo.setKey(string);
                downloadInfo.setFilePath(cacheFilePath);
                downloadInfo.setName(string);
                downloadInfo.setDownType(20);
                downloadInfo.setState(1);
                downloadInfo.setFileVersion(string2);
                downloadInfo.setFileSize(com.up366.medialibrary.config.PictureConstants.MB);
                downloadInfo.setDisablePrivateCloud(booleanValue);
                if (android.text.TextUtils.equals(string3, com.up366.mobile.commonui.CommonWebViewActivity.URL)) {
                    downloadInfo.setDownloadUrl(string2);
                    if (string2.endsWith(".zip")) {
                        downloadInfo.setNeedUnzip(true);
                    }
                } else if (android.text.TextUtils.equals(string3, "fileId")) {
                    downloadInfo.setNeedCheck(true);
                    com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolderFetchDownloadInfoByFileId = fetchDownloadInfoByFileId(downloadInfo, string2);
                    if (netHolderFetchDownloadInfoByFileId.resp.isError()) {
                        consumer.accept(new com.up366.common.event.DownloadEvent(str, 5, 20, downloadInfo.getName(), 0L, 1L, netHolderFetchDownloadInfoByFileId.resp.getCode(), netHolderFetchDownloadInfoByFileId.resp.getInfo()));
                        return;
                    } else if (downloadInfo.getName().endsWith(".zip")) {
                        downloadInfo.setNeedUnzip(true);
                    }
                } else {
                    throw new java.lang.IllegalStateException("unknown type:" + string3);
                }
                multiFileDownloadManager.add(downloadInfo);
            }
        }
        multiFileDownloadManager.setCallback(new com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback
            public final void onResult(int i2, long j, long j2, int i3, java.lang.String str2) {
                this.f$0.lambda$downloadMultiTempResource$8(multiFileDownloadManager, str, consumer, i2, j, j2, i3, str2);
            }
        });
        this.currentDownloadInfo = multiFileDownloadManager.getCurrentDownloadInfo();
        multiFileDownloadManager.startDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadMultiTempResource$8(com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager, java.lang.String str, androidx.core.util.Consumer consumer, int i, long j, long j2, int i2, java.lang.String str2) {
        this.currentDownloadInfo = multiFileDownloadManager.getCurrentDownloadInfo();
        consumer.accept(new com.up366.common.event.DownloadEvent(str, i, 20, str, j, j2, i2, str2));
    }

    public void downloadMultiTempResourceV2(final java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray, final androidx.core.util.Consumer<com.up366.common.event.DownloadEvent> consumer) throws java.lang.InterruptedException {
        java.lang.String str2;
        androidx.core.util.Consumer<com.up366.common.event.DownloadEvent> consumer2;
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager;
        androidx.core.util.Consumer<com.up366.common.event.DownloadEvent> consumer3 = consumer;
        com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager2 = new com.up366.mobile.common.utils.MultiFileDownloadManager(0L);
        java.util.HashMap map = new java.util.HashMap();
        int i = 0;
        while (i < jSONArray.size()) {
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) jSONArray.get(i);
            java.lang.String string = jSONObject.getString("key");
            this.downloadMultiTempResourceV2BatchKeys.add(new com.up366.mobile.common.utils.ParamHolder2<>(str, string));
            java.lang.String string2 = jSONObject.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            if (string2 == null) {
                string2 = "";
            }
            java.lang.String str3 = string2;
            java.lang.String string3 = jSONObject.getString("fileId");
            java.lang.String string4 = jSONObject.getString("type");
            java.lang.String string5 = jSONObject.getString("filePath");
            final java.lang.String string6 = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            final java.lang.String string7 = jSONObject.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
            java.lang.Boolean bool = jSONObject.containsKey("unzip") ? jSONObject.getBoolean("unzip") : null;
            boolean booleanValue = jSONObject.getBooleanValue("append");
            boolean booleanValue2 = jSONObject.getBooleanValue("disablePrivateCloud");
            int i2 = i;
            com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager3 = multiFileDownloadManager2;
            java.lang.String cacheFilePathV2 = getCacheFilePathV2(string, string4, string3, string5, str3);
            java.util.HashMap map2 = map;
            collectExplicitDirectorySnapshot(map, string5, string4, str3, bool, booleanValue);
            boolean zEndsWith = str3.endsWith(".net");
            if (shouldSkipExistingExplicitPath(string4, string5, str3, bool, booleanValue)) {
                com.up366.common.log.Logger.info("TAG - ContentDownloadHelper - downloadMultiTempResourceV2 - explicit path exists skip key:" + string + " path:" + string5);
            } else {
                if (com.up366.common.FileUtilsUp.isFileExists(cacheFilePathV2) && !zEndsWith && com.up366.common.FileUtilsUp.isDir(cacheFilePathV2)) {
                    str2 = cacheFilePathV2;
                    if (validSync(str2)) {
                        com.up366.common.log.Logger.info("TAG - ContentDownloadHelper - downloadMultiTempResource - exists skip key:" + string + " path:" + str2);
                    }
                } else {
                    str2 = cacheFilePathV2;
                }
                com.up366.mobile.common.logic.Auth.cur().db1().saveOrUpdate(new com.up366.mobile.book.model.BookResourceMapInfo(string, string6, str2));
                com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
                downloadInfo.setKey(string);
                downloadInfo.setFilePath(str2);
                downloadInfo.setName(string);
                downloadInfo.setDownType(20);
                downloadInfo.setState(1);
                downloadInfo.setFileVersion(str3);
                downloadInfo.setFileSize(com.up366.medialibrary.config.PictureConstants.MB);
                downloadInfo.setDisablePrivateCloud(booleanValue2);
                if (bool != null) {
                    downloadInfo.setNeedUnzip(bool.booleanValue());
                }
                com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda4
                    public final void accept(java.lang.Object obj) {
                        com.up366.mobile.book.helper.ContentDownloadHelper.lambda$downloadMultiTempResourceV2$9(string6, string7, (com.alibaba.fastjson.JSONObject) obj);
                    }
                });
                if (android.text.TextUtils.equals(string4, com.up366.mobile.commonui.CommonWebViewActivity.URL)) {
                    downloadInfo.setDownloadUrl(str3);
                    if (str3.endsWith(".zip") && bool == null) {
                        downloadInfo.setNeedUnzip(true);
                    }
                    consumer2 = consumer;
                } else if (android.text.TextUtils.equals(string4, "fileId")) {
                    downloadInfo.setNeedCheck(true);
                    com.up366.common.http.NetHolder<com.up366.common.download.DownloadInfo> netHolderFetchDownloadInfoByFileId = fetchDownloadInfoByFileId(downloadInfo, string3);
                    if (netHolderFetchDownloadInfoByFileId.resp.isError()) {
                        consumer.accept(new com.up366.common.event.DownloadEvent(str, 5, 20, downloadInfo.getName(), 0L, 1L, netHolderFetchDownloadInfoByFileId.resp.getCode(), netHolderFetchDownloadInfoByFileId.resp.getInfo()));
                        return;
                    }
                    consumer2 = consumer;
                    if (downloadInfo.getName().endsWith(".zip") && bool == null) {
                        downloadInfo.setNeedUnzip(true);
                    }
                } else {
                    com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - downloadMultiTempResourceV2 - unknown type:" + string4);
                    consumer.accept(new com.up366.common.event.DownloadEvent(str, 5, 20, downloadInfo.getName(), 0L, 1L, -6, "unknown type:" + string4));
                    return;
                }
                multiFileDownloadManager = multiFileDownloadManager3;
                multiFileDownloadManager.add(downloadInfo);
                i = i2 + 1;
                consumer3 = consumer2;
                multiFileDownloadManager2 = multiFileDownloadManager;
                map = map2;
            }
            consumer2 = consumer;
            multiFileDownloadManager = multiFileDownloadManager3;
            i = i2 + 1;
            consumer3 = consumer2;
            multiFileDownloadManager2 = multiFileDownloadManager;
            map = map2;
        }
        final com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager4 = multiFileDownloadManager2;
        final java.util.HashMap map3 = map;
        multiFileDownloadManager4.setCallback(new com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback() { // from class: com.up366.mobile.book.helper.ContentDownloadHelper$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.utils.MultiFileDownloadManager.IDownloadManagerCallback
            public final void onResult(int i3, long j, long j2, int i4, java.lang.String str4) {
                this.f$0.lambda$downloadMultiTempResourceV2$10(multiFileDownloadManager4, map3, str, consumer, i3, j, j2, i4, str4);
            }
        });
        this.currentDownloadInfo = multiFileDownloadManager4.getCurrentDownloadInfo();
        multiFileDownloadManager4.startDownload();
    }

    static /* synthetic */ void lambda$downloadMultiTempResourceV2$9(java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("bookid", str);
        jSONObject.put("taskid", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadMultiTempResourceV2$10(com.up366.mobile.common.utils.MultiFileDownloadManager multiFileDownloadManager, java.util.Map map, java.lang.String str, androidx.core.util.Consumer consumer, int i, long j, long j2, int i2, java.lang.String str2) {
        this.currentDownloadInfo = multiFileDownloadManager.getCurrentDownloadInfo();
        if (i == 4) {
            finalizeExplicitDirectoryValidation(map);
        }
        consumer.accept(new com.up366.common.event.DownloadEvent(str, i, 20, str, j, j2, i2, str2));
    }

    public com.alibaba.fastjson.JSONArray getMultiTempResourcePathList(com.alibaba.fastjson.JSONArray jSONArray) {
        com.alibaba.fastjson.JSONArray jSONArray2 = new com.alibaba.fastjson.JSONArray();
        for (int i = 0; i < jSONArray.size(); i++) {
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) jSONArray.get(i);
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            java.lang.String string = jSONObject.getString("key");
            java.lang.String string2 = jSONObject.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            jSONObject.getString("type");
            java.lang.String cacheFilePath = getCacheFilePath(string2);
            jSONObject2.put("key", string);
            jSONObject2.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, cacheFilePath);
            com.up366.common.log.Logger.info("TAG - ContentDownloadHelper - getMultiTempResourcePathList - key:" + string + " url:" + string2 + " path:" + cacheFilePath);
            jSONArray2.add(jSONObject2);
        }
        return jSONArray2;
    }

    public com.alibaba.fastjson.JSONArray getMultiTempResourcePathListV2(com.alibaba.fastjson.JSONArray jSONArray) {
        com.alibaba.fastjson.JSONArray jSONArray2 = new com.alibaba.fastjson.JSONArray();
        for (int i = 0; i < jSONArray.size(); i++) {
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) jSONArray.get(i);
            com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
            java.lang.String string = jSONObject.getString("key");
            java.lang.String string2 = jSONObject.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            if (string2 == null) {
                string2 = "";
            }
            java.lang.String str = string2;
            java.lang.String string3 = jSONObject.getString("fileId");
            java.lang.String string4 = jSONObject.getString("type");
            if (android.text.TextUtils.isEmpty(string4) || android.text.TextUtils.equals(com.up366.mobile.commonui.CommonWebViewActivity.URL, string4) || android.text.TextUtils.equals("fileId", string4)) {
                java.lang.String cacheFilePathV2 = getCacheFilePathV2(string, string4, string3, jSONObject.getString("filePath"), str);
                jSONObject2.put("key", string);
                jSONObject2.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, cacheFilePathV2);
                com.up366.common.log.Logger.info("TAG - ContentDownloadHelper - getMultiTempResourcePathList - key:" + string + " fileId:" + string3 + " url:" + str + " path:" + cacheFilePathV2);
                jSONArray2.add(jSONObject2);
            }
        }
        return jSONArray2;
    }

    private java.lang.String getCacheFilePath(java.lang.String str) {
        java.lang.String strSubstring;
        int iLastIndexOf;
        java.lang.String cacheFile = com.up366.mobile.common.logic.Auth.cur().fileMgr().getCacheFile(2592000000L, com.up366.common.digest.MD5.md5(str));
        if (str != null && str.endsWith(".net") && (iLastIndexOf = str.lastIndexOf("/")) > 0) {
            strSubstring = str.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "res";
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(cacheFile, strSubstring);
        com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        return strJoin;
    }

    private java.lang.String getCacheFilePathV2(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        java.lang.String strSubstring;
        int iLastIndexOf;
        if (!android.text.TextUtils.isEmpty(str4)) {
            return str4;
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            str = str3;
        }
        java.lang.String cacheFileV2 = com.up366.mobile.common.logic.Auth.cur().fileMgr().getCacheFileV2(2592000000L, str);
        if (str5.endsWith(".net") && (iLastIndexOf = str5.lastIndexOf("/")) > 0) {
            strSubstring = str5.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "res/";
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(cacheFileV2, android.text.TextUtils.equals(str2, "fileId") ? "/" : strSubstring);
        com.up366.common.FileUtilsUp.mkdirParentDir(strJoin);
        return strJoin;
    }

    private boolean shouldSkipExistingExplicitPath(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Boolean bool, boolean z) {
        return !android.text.TextUtils.isEmpty(str2) && com.up366.common.FileUtilsUp.isFileExists(str2) && isDirectoryResourcePath(str, str3, bool) && !z && com.up366.common.FileUtilsUp.isDir(str2) && validSync(str2);
    }

    private boolean isDirectoryResourcePath(java.lang.String str, java.lang.String str2, java.lang.Boolean bool) {
        if (java.lang.Boolean.FALSE.equals(bool)) {
            return false;
        }
        return android.text.TextUtils.equals(str, "fileId") || str2.endsWith(".zip");
    }

    private void collectExplicitDirectorySnapshot(java.util.Map<java.lang.String, java.util.Set<java.lang.String>> map, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Boolean bool, boolean z) {
        if (!z || android.text.TextUtils.isEmpty(str) || !isDirectoryResourcePath(str2, str3, bool) || map.containsKey(str)) {
            return;
        }
        map.put(str, listChildDirectoryNames(str));
    }

    private java.util.Set<java.lang.String> listChildDirectoryNames(java.lang.String str) {
        java.io.File[] fileArrListFiles;
        java.util.HashSet hashSet = new java.util.HashSet();
        if (android.text.TextUtils.isEmpty(str) || !com.up366.common.FileUtilsUp.isDir(str) || (fileArrListFiles = new java.io.File(str).listFiles()) == null) {
            return hashSet;
        }
        for (java.io.File file : fileArrListFiles) {
            if (file != null && file.isDirectory()) {
                hashSet.add(file.getName());
            }
        }
        return hashSet;
    }

    private void finalizeExplicitDirectoryValidation(java.util.Map<java.lang.String, java.util.Set<java.lang.String>> map) {
        for (java.util.Map.Entry<java.lang.String, java.util.Set<java.lang.String>> entry : map.entrySet()) {
            applyExplicitDirectoryValidation(entry.getKey(), entry.getValue());
        }
    }

    private void applyExplicitDirectoryValidation(java.lang.String str, java.util.Set<java.lang.String> set) {
        java.io.File[] fileArrListFiles;
        if (android.text.TextUtils.isEmpty(str) || !com.up366.common.FileUtilsUp.isDir(str)) {
            return;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str, "checkFile");
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(str, "valid.bin");
        if ((com.up366.common.FileUtilsUp.isFileExists(strJoin) || com.up366.common.FileUtilsUp.isFileExists(strJoin2)) && (fileArrListFiles = new java.io.File(str).listFiles()) != null) {
            boolean z = true;
            boolean z2 = false;
            for (java.io.File file : fileArrListFiles) {
                if (file != null && file.isDirectory()) {
                    boolean z3 = set != null && set.contains(file.getName());
                    java.lang.String absolutePath = file.getAbsolutePath();
                    boolean zIsFileExists = com.up366.common.FileUtilsUp.isFileExists(com.up366.common.FileUtilsUp.join(absolutePath, "checkFile"));
                    boolean zValid = com.up366.common.utils.EncryptUtil.valid(absolutePath);
                    if ((z3 && zIsFileExists && zValid) || generateDirectoryValidationFiles(absolutePath)) {
                        z2 = true;
                    } else {
                        z2 = true;
                        z = false;
                    }
                }
            }
            if (z2 && z) {
                com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
                com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
            }
        }
    }

    private boolean generateDirectoryValidationFiles(java.lang.String str) throws java.lang.Throwable {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str, "checkFile");
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(str, "valid.bin");
        try {
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
            boolean zGenerateValid = com.up366.common.utils.EncryptUtil.generateValid(str);
            com.up366.common.log.Logger.info("TAG - ContentDownloadHelper - generateDirectoryValidationFiles - generateValid dirPath:" + str + " result:" + zGenerateValid);
            if (zGenerateValid && com.up366.common.FileUtilsUp.isFileExists(strJoin2)) {
                com.up366.common.FileUtilsUp.saveContentToFile(strJoin, buildDirectoryCheckContent(str));
                boolean z = com.up366.common.FileUtilsUp.isFileExists(strJoin2) && com.up366.common.utils.EncryptUtil.valid(str);
                if (!z) {
                    com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - generateDirectoryValidationFiles - verify failed path:" + str + " err:" + com.up366.common.utils.EncryptUtil.errMsg());
                }
                return z;
            }
            com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - generateDirectoryValidationFiles - valid not exists path:" + strJoin2 + " err:" + com.up366.common.utils.EncryptUtil.errMsg());
            return false;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - ContentDownloadHelper - generateDirectoryValidationFiles - error path:" + str, e);
            return false;
        }
    }

    private java.lang.String buildDirectoryCheckContent(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        collectDirectoryCheckEntries(new java.io.File(str), "", arrayList);
        java.util.Collections.sort(arrayList);
        return com.up366.common.digest.MD5.md5(android.text.TextUtils.join("\n", arrayList));
    }

    private void collectDirectoryCheckEntries(java.io.File file, java.lang.String str, java.util.List<java.lang.String> list) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (java.io.File file2 : fileArrListFiles) {
                if (file2 != null) {
                    java.lang.String name = file2.getName();
                    if (!"checkFile".equals(name) && !"valid.bin".equals(name)) {
                        if (!android.text.TextUtils.isEmpty(str)) {
                            name = str + "/" + name;
                        }
                        collectDirectoryCheckEntries(file2, name, list);
                    }
                }
            }
            return;
        }
        list.add(str + ":" + file.length());
    }

    public void cancelDownload(java.lang.String str) {
        for (com.up366.mobile.common.utils.ParamHolder2<java.lang.String, java.lang.String> paramHolder2 : this.downloadMultiTempResourceV2BatchKeys) {
            if (android.text.TextUtils.equals(paramHolder2.a, str)) {
                com.up366.common.download.DownloadManager.getInstance().pauseDownload(paramHolder2.b);
            }
        }
    }
}
