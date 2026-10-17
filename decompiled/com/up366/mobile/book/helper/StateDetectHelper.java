package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StateDetectHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int STATE_BOOK_NOT_SUPPORT = 22;
    public static final int STATE_DIALOG_TIP_BACK = 2;
    public static final int STATE_DIALOG_TIP_NO_CHAPTER = 3;
    public static final int STATE_DOWNLOAD_COMBINE = 24;
    public static final int STATE_DOWNLOAD_ERROR = 25;
    public static final int STATE_LOADING = 0;
    public static final int STATE_OPEN_CHAPTER_NOT_FOUND = 4;
    public static final int STATE_OPEN_PAGE_NOT_FOUND = 5;
    public static final int STATE_PAGE_NO_FREE = 7;
    public static final int STATE_PLAN_NO_OPEN = 6;
    public static final int STATE_SHOW_2016_HTML_CATALOG = 9;
    public static final int STATE_SHOW_2019_HTML_CATALOG = 10;
    public static final int STATE_SHOW_2025_COMMON_PAGE = 26;
    public static final int STATE_SHOW_APP_CATALOG = 8;
    public static final int STATE_SHOW_COMMON_PAGE = 21;
    public static final int STATE_SHOW_DICT_PAGE = 23;
    public static final int STATE_SHOW_EXERCISE_PAGE = 20;
    public static final int STATE_SHOW_PACK_TYPE_GJS = 16;
    public static final int STATE_SHOW_PACK_TYPE_L = 11;
    public static final int STATE_SHOW_PACK_TYPE_LDX = 14;
    public static final int STATE_SHOW_PACK_TYPE_LS = 15;
    public static final int STATE_SHOW_PACK_TYPE_S = 13;
    public static final int STATE_SHOW_PACK_TYPE_TX = 17;
    public static final int STATE_SHOW_PACK_TYPE_VLS = 12;
    public static final int STATE_SHOW_SCHOOL_PAGE = 19;
    public static final int STATE_SHOW_TEST_CHAPTER = 18;
    private final com.up366.mobile.book.StudyActivity context;
    private int oldState = -1;

    public interface IStateDectectHelper {
        void onResult(int i, java.lang.String str, java.lang.Object obj, boolean z);
    }

    public StateDetectHelper(com.up366.mobile.book.StudyActivity studyActivity) {
        this.context = studyActivity;
    }

    public void detect(final com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, final boolean z, final boolean z2, final com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.StateDetectHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$detect$0(openConfigInfo, z, z2, iStateDectectHelper);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: detectImpl, reason: merged with bridge method [inline-methods] */
    public void lambda$detect$0(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, boolean z, boolean z2, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) throws java.lang.InterruptedException {
        boolean z3;
        if (this.context.bookChapterInfo != null && (openConfigInfo.range == null || openConfigInfo.range[1] == 0 || !openConfigInfo.initRangeFromIntent)) {
            openConfigInfo.range = this.context.bookChapterInfo.getPageRange(openConfigInfo.chapterId);
        }
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.context.contentDownloadHelper;
        com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper = this.context.bookFilePathHelper;
        if (openConfigInfo.isSDKV9()) {
            detectSDKV9(openConfigInfo, z2, iStateDectectHelper);
            return;
        }
        if (openConfigInfo.isSDKV8()) {
            detectSDKV8(openConfigInfo, z2, iStateDectectHelper);
            return;
        }
        if (openConfigInfo.isExercise()) {
            if (openConfigInfo.exerciseType.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.TX_DICT)) {
                com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
                if (appResourceUpdateHelper.checkResourceAses() && appResourceUpdateHelper.checkResourceDict()) {
                    setState(23, iStateDectectHelper);
                }
                if (z || !z2) {
                    return;
                }
                com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllConfig = fetchAllConfig();
                boolean z4 = netHolderFetchAllConfig != null && netHolderFetchAllConfig.resp.getCode() == -10002;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (!appResourceUpdateHelper.checkResourceDict() || appResourceUpdateHelper.checkUpdateDict() || !appResourceUpdateHelper.checkValidDict()) {
                    if (z4) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download dict 获取下载信息失败 timeout");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    com.up366.common.download.DownloadInfo downloadInfoFetchDictModelDownloadInfoSync = appResourceUpdateHelper.fetchDictModelDownloadInfoSync();
                    if (downloadInfoFetchDictModelDownloadInfoSync == null) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download dict 获取下载信息失败");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    arrayList.add(downloadInfoFetchDictModelDownloadInfoSync);
                }
                if (!appResourceUpdateHelper.checkResourceAses() || appResourceUpdateHelper.checkUpdateAses() || !appResourceUpdateHelper.checkValidAses()) {
                    if (z4) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败 timeout");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    com.up366.common.download.DownloadInfo downloadInfoFetchAsesModelDownloadInfoSync = appResourceUpdateHelper.fetchAsesModelDownloadInfoSync();
                    if (downloadInfoFetchAsesModelDownloadInfoSync == null) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    arrayList.add(downloadInfoFetchAsesModelDownloadInfoSync);
                }
                if (arrayList.size() > 0) {
                    setState(24, "download size:" + arrayList.size(), arrayList, iStateDectectHelper);
                    return;
                }
                return;
            }
            if (openConfigInfo.exerciseType.equals("homework") || openConfigInfo.exerciseType.equals(com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.HOMEWORK_REPORT)) {
                com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper2 = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
                if (contentDownloadHelper.hasHomeworkDownload(openConfigInfo) && appResourceUpdateHelper2.checkResourceAses() && appResourceUpdateHelper2.checkResourceXot()) {
                    setState(20, iStateDectectHelper);
                }
                if (z || !z2) {
                    return;
                }
                com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllConfig2 = fetchAllConfig();
                boolean z5 = netHolderFetchAllConfig2 != null && netHolderFetchAllConfig2.resp.getCode() == -10002;
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                com.up366.common.download.DownloadInfo homeworkResourceDownloadInfoSync = contentDownloadHelper.getHomeworkResourceDownloadInfoSync(openConfigInfo);
                if (!contentDownloadHelper.hasHomeworkDownload(openConfigInfo) || contentDownloadHelper.checkHomeworkResourceUpdateSync(openConfigInfo, homeworkResourceDownloadInfoSync) || !contentDownloadHelper.validHomeworkResourceSync(openConfigInfo)) {
                    if (homeworkResourceDownloadInfoSync == null) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download homework resource 获取下载信息失败");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    arrayList2.add(homeworkResourceDownloadInfoSync);
                }
                if (!appResourceUpdateHelper2.checkResourceXot() || appResourceUpdateHelper2.checkUpdateXot() || !appResourceUpdateHelper2.checkValidXot()) {
                    if (z5) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download xot 获取下载信息失败 timeout");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    com.up366.common.download.DownloadInfo downloadInfoFetchXotEngineDownloadInfoSync = appResourceUpdateHelper2.fetchXotEngineDownloadInfoSync();
                    if (downloadInfoFetchXotEngineDownloadInfoSync == null) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download xot 获取下载信息失败");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    arrayList2.add(downloadInfoFetchXotEngineDownloadInfoSync);
                }
                if (!appResourceUpdateHelper2.checkResourceAses() || appResourceUpdateHelper2.checkUpdateAses() || !appResourceUpdateHelper2.checkValidAses()) {
                    if (z5) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败 timeout");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    com.up366.common.download.DownloadInfo downloadInfoFetchAsesModelDownloadInfoSync2 = appResourceUpdateHelper2.fetchAsesModelDownloadInfoSync();
                    if (downloadInfoFetchAsesModelDownloadInfoSync2 == null) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    arrayList2.add(downloadInfoFetchAsesModelDownloadInfoSync2);
                }
                if (arrayList2.size() > 0) {
                    setState(24, "download size:" + arrayList2.size(), arrayList2, iStateDectectHelper);
                    return;
                }
                return;
            }
            com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper3 = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
            if (appResourceUpdateHelper3.checkResourceAses() && appResourceUpdateHelper3.checkResourceXot()) {
                setState(20, iStateDectectHelper);
            }
            if (z || !z2) {
                return;
            }
            com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllConfig3 = fetchAllConfig();
            boolean z6 = netHolderFetchAllConfig3 != null && netHolderFetchAllConfig3.resp.getCode() == -10002;
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            if (!appResourceUpdateHelper3.checkResourceXot() || appResourceUpdateHelper3.checkUpdateXot() || !appResourceUpdateHelper3.checkValidXot()) {
                if (z6) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download xot 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchXotEngineDownloadInfoSync2 = appResourceUpdateHelper3.fetchXotEngineDownloadInfoSync();
                if (downloadInfoFetchXotEngineDownloadInfoSync2 == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download xot 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return;
                }
                arrayList3.add(downloadInfoFetchXotEngineDownloadInfoSync2);
            }
            if (!appResourceUpdateHelper3.checkResourceAses() || appResourceUpdateHelper3.checkUpdateAses() || !appResourceUpdateHelper3.checkValidAses()) {
                if (z6) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchAsesModelDownloadInfoSync3 = appResourceUpdateHelper3.fetchAsesModelDownloadInfoSync();
                if (downloadInfoFetchAsesModelDownloadInfoSync3 == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return;
                }
                arrayList3.add(downloadInfoFetchAsesModelDownloadInfoSync3);
            }
            if (arrayList3.size() > 0) {
                setState(24, "download size:" + arrayList3.size(), arrayList3, iStateDectectHelper);
                return;
            }
            return;
        }
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        com.up366.mobile.book.model.TreeBookChapter treeBookChapter = this.context.bookChapterInfo;
        if (bookInfoStudy.getBookType() == 1 && !bookInfoStudy.toMobile()) {
            if (z) {
                return;
            }
            setState(22, iStateDectectHelper);
            return;
        }
        if (treeBookChapter.getChapters().size() == 0 && bookInfoStudy.getPackType() != 7) {
            if (!z) {
                setState(3, iStateDectectHelper);
                return;
            } else {
                setState(0, iStateDectectHelper);
                return;
            }
        }
        if (bookInfoStudy.getBookType() == 1) {
            if (!bookInfoStudy.toMobile()) {
                if (z) {
                    return;
                }
                setState(22, iStateDectectHelper);
                return;
            }
            if (openConfigInfo.isOpenPage()) {
                checkPage(openConfigInfo, z, z2, iStateDectectHelper, bookInfoStudy, true);
                return;
            }
            com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper4 = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
            if (!appResourceUpdateHelper4.checkResourceAses() || !contentDownloadHelper.hasCatalogDownload()) {
                z3 = true;
            } else if (bookFilePathHelper.existsHtmlChapter()) {
                if (bookInfoStudy.getPackType() == 7) {
                    treeBookChapter.setUseInHtmlChapter(true);
                    this.context.bookChapterInfo.initHtmlJsonStr();
                    if (treeBookChapter.isHtmlJsonHasChange() || !com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.openUrl)) {
                        treeBookChapter.newHtmlJsonHasUpdate();
                        setState(10, iStateDectectHelper);
                    } else {
                        com.up366.common.log.Logger.info("TAG - StateDetectHelper - detect - book json no change.");
                    }
                    z3 = true;
                } else {
                    z3 = true;
                    treeBookChapter.setUseInHtmlChapter(true);
                    this.context.bookChapterInfo.initHtmlJsonStr();
                    if (treeBookChapter.isHtmlJsonHasChange() || !com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.openUrl)) {
                        treeBookChapter.newHtmlJsonHasUpdate();
                        setState(9, iStateDectectHelper);
                    } else {
                        com.up366.common.log.Logger.info("TAG - 2019/9/26 - StateDetectHelper - detect - book json no change.");
                    }
                }
            } else {
                z3 = true;
                setState(8, iStateDectectHelper);
            }
            if (z || !z2) {
                return;
            }
            com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllConfig4 = fetchAllConfig();
            boolean z7 = (netHolderFetchAllConfig4 == null || netHolderFetchAllConfig4.resp.getCode() != -10002) ? false : z3;
            java.util.ArrayList arrayList4 = new java.util.ArrayList();
            if (!appResourceUpdateHelper4.checkResourceAses() || appResourceUpdateHelper4.checkUpdateAses() || !appResourceUpdateHelper4.checkValidAses()) {
                if (z7) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchAsesModelDownloadInfoSync4 = appResourceUpdateHelper4.fetchAsesModelDownloadInfoSync();
                if (downloadInfoFetchAsesModelDownloadInfoSync4 != null) {
                    arrayList4.add(downloadInfoFetchAsesModelDownloadInfoSync4);
                } else if (com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance().isUpdateAsesModelByAssets() && !com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance().initAsesModelFromAssets()) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return;
                }
            }
            java.lang.String catalogDir = bookFilePathHelper.getCatalogDir();
            if (!contentDownloadHelper.hasCatalogDownload() || contentDownloadHelper.hasCatalogUpdate() || !contentDownloadHelper.validSync(catalogDir)) {
                if (z7) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download catalog 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchCatalogDownloadInfoSync = contentDownloadHelper.fetchCatalogDownloadInfoSync();
                if (downloadInfoFetchCatalogDownloadInfoSync == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download catalog 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return;
                }
                arrayList4.add(downloadInfoFetchCatalogDownloadInfoSync);
            }
            if (arrayList4.size() > 0) {
                setState(24, "download size:" + arrayList4.size(), arrayList4, iStateDectectHelper);
                return;
            }
            return;
        }
        if (bookInfoStudy.getBookType() == 2) {
            if (openConfigInfo.isOpenPage()) {
                checkPage(openConfigInfo, z, z2, iStateDectectHelper, bookInfoStudy, true);
                return;
            } else {
                setState(8, iStateDectectHelper);
                return;
            }
        }
        setState(2, "未知的教材类型:" + bookInfoStudy.getBookType(), iStateDectectHelper);
        com.up366.common.log.Logger.error("StateDetectHelper - detect - unknown book type:" + bookInfoStudy.getBookType() + " bookId:" + bookInfoStudy.getBookId() + " bookName:" + bookInfoStudy.getBookName());
    }

    public boolean checkSupportPackTypeLoose(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        int packType;
        return bookInfoStudy == null || bookInfoStudy.getBookType() == 2 || (packType = bookInfoStudy.getPackType()) == 0 || packType == 1 || packType == 2 || packType == 3 || packType == 4 || packType == 5 || packType == 6 || packType == 7 || packType == 8;
    }

    private void detectSDKV8(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, boolean z, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) throws java.lang.InterruptedException {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
        com.up366.mobile.book.helper.V8ResourceHelper v8ResourceHelper = new com.up366.mobile.book.helper.V8ResourceHelper();
        java.util.List<java.lang.String> allFileIds = v8ResourceHelper.parseAllFileIds(openConfigInfo, bookInfoStudy);
        if (!android.text.TextUtils.isEmpty(openConfigInfo.openUrl) && openConfigInfo.openUrl.startsWith("http")) {
            allFileIds.remove(bookInfoStudy.getFileId());
        }
        if (!android.text.TextUtils.isEmpty(bookInfoStudy.getFileId())) {
            com.up366.mobile.common.logic.Auth.cur().db1().saveOrUpdate(new com.up366.mobile.book.model.BookResourceMapInfo(bookInfoStudy.getFileId(), bookInfoStudy.getBookId(), new com.up366.mobile.book.helper.V8FilePathHelper().getResourceDir(bookInfoStudy.getFileId())));
        }
        if (appResourceUpdateHelper.checkResourceAses() && v8ResourceHelper.checkResource(allFileIds)) {
            setState(21, iStateDectectHelper);
        }
        if (z) {
            com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllConfig = fetchAllConfig();
            boolean z2 = netHolderFetchAllConfig != null && netHolderFetchAllConfig.resp.getCode() == -10002;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str : allFileIds) {
                if (!v8ResourceHelper.checkResource(str) || !v8ResourceHelper.checkValid(str)) {
                    if (z2) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV8 - download " + str + " 获取下载信息失败 timeout");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    com.up366.common.download.DownloadInfo downloadInfoFetchResourceDownloadInfoSync = v8ResourceHelper.fetchResourceDownloadInfoSync(str);
                    if (downloadInfoFetchResourceDownloadInfoSync == null) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV8 - download " + str + " 获取下载信息失败");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    arrayList.add(downloadInfoFetchResourceDownloadInfoSync);
                }
            }
            if (!appResourceUpdateHelper.checkResourceAses() || appResourceUpdateHelper.checkUpdateAses() || !appResourceUpdateHelper.checkValidAses()) {
                if (z2) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV8 - download ases 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchAsesModelDownloadInfoSync = appResourceUpdateHelper.fetchAsesModelDownloadInfoSync();
                if (downloadInfoFetchAsesModelDownloadInfoSync == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV8 - download ases 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return;
                }
                arrayList.add(downloadInfoFetchAsesModelDownloadInfoSync);
            }
            if (arrayList.size() > 0) {
                setState(24, "download size:" + arrayList.size(), arrayList, iStateDectectHelper);
            }
        }
    }

    private void detectSDKV9(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, boolean z, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) throws java.lang.InterruptedException {
        int iAddPendingV9ResourceDownloads;
        com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
        com.up366.mobile.book.helper.V9ResourceHelper v9ResourceHelper = new com.up366.mobile.book.helper.V9ResourceHelper();
        if (appResourceUpdateHelper.checkResourceAses() && checkV9ResourceReady(openConfigInfo.getResourceListObj(), v9ResourceHelper)) {
            setState(26, iStateDectectHelper);
        }
        if (z) {
            com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllConfig = fetchAllConfig();
            boolean z2 = netHolderFetchAllConfig != null && netHolderFetchAllConfig.resp.getCode() == -10002;
            java.util.List<com.up366.common.download.DownloadInfo> arrayList = new java.util.ArrayList<>();
            int iAddPendingV9ResourceDownloads2 = addPendingV9ResourceDownloads(arrayList, openConfigInfo.getResourceListObj().getDirGlobal(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_GLOBAL, z2, v9ResourceHelper, iStateDectectHelper);
            if (iAddPendingV9ResourceDownloads2 >= 0 && (iAddPendingV9ResourceDownloads = addPendingV9ResourceDownloads(arrayList, openConfigInfo.getResourceListObj().getDirBooks(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_BOOKS, z2, v9ResourceHelper, iStateDectectHelper)) >= 0) {
                int i = iAddPendingV9ResourceDownloads2 + iAddPendingV9ResourceDownloads;
                int iAddPendingV9ResourceDownloads3 = addPendingV9ResourceDownloads(arrayList, openConfigInfo.getResourceListObj().getDirChapters(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_CHAPTERS, z2, v9ResourceHelper, iStateDectectHelper);
                if (iAddPendingV9ResourceDownloads3 < 0) {
                    return;
                }
                int i2 = i + iAddPendingV9ResourceDownloads3;
                int iAddPendingV9ResourceDownloads4 = addPendingV9ResourceDownloads(arrayList, openConfigInfo.getResourceListObj().getDirExtend(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_EXTEND, z2, v9ResourceHelper, iStateDectectHelper);
                if (iAddPendingV9ResourceDownloads4 < 0) {
                    return;
                }
                int i3 = i2 + iAddPendingV9ResourceDownloads4;
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                for (java.lang.String str : openConfigInfo.getResourceListObj().getDirQuestions()) {
                    if (!com.up366.common.StringUtils.isEmptyOrNull(str) && (!v9ResourceHelper.checkResource(str, com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS) || !v9ResourceHelper.checkValid(str, com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS))) {
                        if (z2) {
                            com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - download " + str + " 获取下载信息失败 timeout");
                            setState(25, iStateDectectHelper);
                            return;
                        }
                        arrayList2.add(str);
                    }
                }
                int downloadLimit = com.up366.mobile.common.logic.Auth.cur().config().getDownloadLimit();
                int i4 = downloadLimit - i3;
                boolean z3 = arrayList2.size() > i4 && hasResourceIds(openConfigInfo.getResourceListObj().getDirAllQuestions());
                com.up366.common.log.Logger.info("TAG - StateDetectHelper - detectSDKV9 - baseDownloadCount=" + i3 + " downloadLimit=" + downloadLimit + " questionsLimit=" + i4 + " questionsPendingCount=" + arrayList2.size() + " useAllQuestionsPackage=" + z3);
                if (z3) {
                    if (addPendingAllQuestionDownloads(arrayList, openConfigInfo.getResourceListObj().getDirAllQuestions(), z2, v9ResourceHelper, iStateDectectHelper) < 0) {
                        return;
                    }
                } else if (!addPendingQuestionBatchDownloads(arrayList, arrayList2, v9ResourceHelper, iStateDectectHelper)) {
                    return;
                }
                if (!appResourceUpdateHelper.checkResourceAses() || appResourceUpdateHelper.checkUpdateAses() || !appResourceUpdateHelper.checkValidAses()) {
                    if (z2) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - download ases 获取下载信息失败 timeout");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    com.up366.common.download.DownloadInfo downloadInfoFetchAsesModelDownloadInfoSync = appResourceUpdateHelper.fetchAsesModelDownloadInfoSync();
                    if (downloadInfoFetchAsesModelDownloadInfoSync == null) {
                        com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - download ases 获取下载信息失败");
                        setState(25, iStateDectectHelper);
                        return;
                    }
                    arrayList.add(downloadInfoFetchAsesModelDownloadInfoSync);
                }
                if (arrayList.size() > 0) {
                    setState(24, "download size:" + arrayList.size(), arrayList, iStateDectectHelper);
                }
            }
        }
    }

    private boolean checkV9ResourceReady(com.up366.mobile.book.model.OpenConfigInfo.ResourceList resourceList, com.up366.mobile.book.helper.V9ResourceHelper v9ResourceHelper) {
        return checkV9ResourceArray(resourceList.getDirGlobal(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_GLOBAL, v9ResourceHelper) && checkV9ResourceArray(resourceList.getDirBooks(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_BOOKS, v9ResourceHelper) && checkV9ResourceArray(resourceList.getDirChapters(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_CHAPTERS, v9ResourceHelper) && checkV9ResourceArray(resourceList.getDirExtend(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_EXTEND, v9ResourceHelper) && checkV9QuestionResourceReady(resourceList, v9ResourceHelper);
    }

    private boolean checkV9QuestionResourceReady(com.up366.mobile.book.model.OpenConfigInfo.ResourceList resourceList, com.up366.mobile.book.helper.V9ResourceHelper v9ResourceHelper) {
        if (hasResourceIds(resourceList.getDirQuestions())) {
            return checkV9ResourceArray(resourceList.getDirQuestions(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS, v9ResourceHelper);
        }
        return true;
    }

    private boolean checkV9ResourceArray(java.lang.String[] strArr, java.lang.String str, com.up366.mobile.book.helper.V9ResourceHelper v9ResourceHelper) {
        for (java.lang.String str2 : strArr) {
            if (!com.up366.common.StringUtils.isEmptyOrNull(str2) && !v9ResourceHelper.checkResource(str2, str)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasResourceIds(java.lang.String[] strArr) {
        for (java.lang.String str : strArr) {
            if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
                return true;
            }
        }
        return false;
    }

    private int addPendingV9ResourceDownloads(java.util.List<com.up366.common.download.DownloadInfo> list, java.lang.String[] strArr, java.lang.String str, boolean z, com.up366.mobile.book.helper.V9ResourceHelper v9ResourceHelper, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) throws java.lang.InterruptedException {
        int i = 0;
        for (java.lang.String str2 : strArr) {
            if (!com.up366.common.StringUtils.isEmptyOrNull(str2) && (!v9ResourceHelper.checkResource(str2, str) || !v9ResourceHelper.checkValid(str2, str))) {
                if (z) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - download " + str2 + " 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return -1;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchResourceDownloadInfoSync = v9ResourceHelper.fetchResourceDownloadInfoSync(str2, str);
                if (downloadInfoFetchResourceDownloadInfoSync == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - download " + str2 + " 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return -1;
                }
                list.add(downloadInfoFetchResourceDownloadInfoSync);
                i++;
            }
        }
        return i;
    }

    private boolean addPendingQuestionBatchDownloads(java.util.List<com.up366.common.download.DownloadInfo> list, java.util.List<java.lang.String> list2, com.up366.mobile.book.helper.V9ResourceHelper v9ResourceHelper, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) throws java.lang.InterruptedException {
        int i = 0;
        while (i < list2.size()) {
            int i2 = i + 100;
            int iMin = java.lang.Math.min(i2, list2.size());
            java.util.List<com.up366.common.download.DownloadInfo> listFetchDownloadInfoByFileIdBatchSync = v9ResourceHelper.fetchDownloadInfoByFileIdBatchSync(com.up366.common.StringUtils.join(list2.subList(i, iMin), com.igexin.push.core.b.an), com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS);
            if (listFetchDownloadInfoByFileIdBatchSync == null) {
                com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - downloadInfoList 批量获取下载信息失败, start=" + i + " end=" + iMin);
                setState(25, iStateDectectHelper);
                return false;
            }
            com.up366.common.log.Logger.info("TAG - StateDetectHelper - detectSDKV9 - downloadInfoList 批量获取下载信息成功, batchSize=" + (iMin - i) + " downloadInfoSize=" + listFetchDownloadInfoByFileIdBatchSync.size());
            list.addAll(listFetchDownloadInfoByFileIdBatchSync);
            i = i2;
        }
        return true;
    }

    private int addPendingAllQuestionDownloads(java.util.List<com.up366.common.download.DownloadInfo> list, java.lang.String[] strArr, boolean z, com.up366.mobile.book.helper.V9ResourceHelper v9ResourceHelper, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) throws java.lang.InterruptedException {
        int i = 0;
        for (java.lang.String str : strArr) {
            if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
                if (z) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - download " + str + " 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return -1;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchResourceDownloadQuestionsInfoSync = v9ResourceHelper.fetchResourceDownloadQuestionsInfoSync(str, com.up366.mobile.book.helper.V9ResourceHelper.DIR_ALL_QUESTIONS);
                if (downloadInfoFetchResourceDownloadQuestionsInfoSync == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectSDKV9 - download " + str + " 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return -1;
                }
                list.add(downloadInfoFetchResourceDownloadQuestionsInfoSync);
                i++;
            }
        }
        return i;
    }

    private void checkPage(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, boolean z, boolean z2, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, boolean z3) throws java.lang.InterruptedException {
        boolean z4;
        boolean z5;
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = this.context.contentDownloadHelper;
        com.up366.mobile.book.helper.BookFilePathHelper bookFilePathHelper = this.context.bookFilePathHelper;
        com.up366.mobile.book.model.CatalogPage catalogPageFindOpenNode = findOpenNode(openConfigInfo);
        if (catalogPageFindOpenNode == null) {
            if (z) {
                return;
            }
            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002001));
            setState(5, iStateDectectHelper);
            return;
        }
        openConfigInfo.pageNo = catalogPageFindOpenNode.getPageNo();
        com.up366.mobile.book.helper.Tools.alarmLogTrackContext.taskId = catalogPageFindOpenNode.obj.getTaskId();
        com.up366.mobile.book.model.ChapterInfo chapterInfoFindContentNode = findContentNode(openConfigInfo);
        if (chapterInfoFindContentNode == null && catalogPageFindOpenNode.getContentPPage() != null) {
            chapterInfoFindContentNode = catalogPageFindOpenNode.getContentPPage().obj;
        }
        if (chapterInfoFindContentNode == null) {
            if (z) {
                return;
            }
            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002001));
            setState(4, iStateDectectHelper);
            return;
        }
        if (catalogPageFindOpenNode.isInLockChapter()) {
            if (z) {
                return;
            }
            setState(6, iStateDectectHelper);
            return;
        }
        if (!checkIsFree(catalogPageFindOpenNode)) {
            if (tryFixHasBuyByBookDetail(bookInfoStudy, iStateDectectHelper) || z) {
                return;
            }
            setState(7, iStateDectectHelper);
            return;
        }
        com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
        if (bookInfoStudy.getBookType() == 2) {
            z4 = true;
            z5 = false;
        } else {
            if (catalogPageFindOpenNode.obj.isPage()) {
                catalogPageFindOpenNode = catalogPageFindOpenNode.getChapterPPage();
            }
            if (catalogPageFindOpenNode.obj.getChapterType() == 4) {
                z5 = true;
                z4 = false;
            } else {
                z4 = false;
                z5 = false;
            }
        }
        if ((contentDownloadHelper.hasDownloadChapter(chapterInfoFindContentNode) && (!z4 ? contentDownloadHelper.hasCatalogDownload() : appResourceUpdateHelper.checkResourceXot()) && appResourceUpdateHelper.checkResourceAses()) || z5) {
            showPage(openConfigInfo, iStateDectectHelper, bookInfoStudy);
        }
        if (z || !z2 || z5) {
            return;
        }
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllConfig = fetchAllConfig();
        boolean z6 = netHolderFetchAllConfig != null && netHolderFetchAllConfig.resp.getCode() == -10002;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (z4) {
            if (!appResourceUpdateHelper.checkResourceXot() || appResourceUpdateHelper.checkUpdateXot() || !appResourceUpdateHelper.checkValidXot()) {
                if (z6) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download xot 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchXotEngineDownloadInfoSync = appResourceUpdateHelper.fetchXotEngineDownloadInfoSync();
                if (downloadInfoFetchXotEngineDownloadInfoSync == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download xot 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return;
                }
                arrayList.add(downloadInfoFetchXotEngineDownloadInfoSync);
            }
        } else {
            java.lang.String catalogDir = bookFilePathHelper.getCatalogDir();
            if (!contentDownloadHelper.hasCatalogDownload() || contentDownloadHelper.hasCatalogUpdate() || !contentDownloadHelper.validSync(catalogDir)) {
                if (z6) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download catalog 获取下载信息失败 timeout");
                    setState(25, iStateDectectHelper);
                    return;
                }
                com.up366.common.download.DownloadInfo downloadInfoFetchCatalogDownloadInfoSync = contentDownloadHelper.fetchCatalogDownloadInfoSync();
                if (downloadInfoFetchCatalogDownloadInfoSync == null) {
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download catalog 获取下载信息失败");
                    setState(25, iStateDectectHelper);
                    return;
                }
                arrayList.add(downloadInfoFetchCatalogDownloadInfoSync);
            }
        }
        java.lang.String contentDir = bookFilePathHelper.getContentDir(chapterInfoFindContentNode.getId());
        if (!contentDownloadHelper.hasDownloadChapter(chapterInfoFindContentNode) || contentDownloadHelper.hasUpdateChapter(chapterInfoFindContentNode) || !contentDownloadHelper.validSync(contentDir)) {
            if (z6) {
                com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download content 获取下载信息失败 timeout");
                setState(25, iStateDectectHelper);
                return;
            }
            com.up366.common.download.DownloadInfo downloadInfoFetchContentDownloadInfoSync = contentDownloadHelper.fetchContentDownloadInfoSync(chapterInfoFindContentNode);
            if (downloadInfoFetchContentDownloadInfoSync == null) {
                com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download content 获取下载信息失败");
                setState(25, iStateDectectHelper);
                return;
            }
            arrayList.add(downloadInfoFetchContentDownloadInfoSync);
        }
        if (!appResourceUpdateHelper.checkResourceAses() || appResourceUpdateHelper.checkUpdateAses() || !appResourceUpdateHelper.checkValidAses()) {
            if (z6) {
                com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败 timeout");
                setState(25, iStateDectectHelper);
                return;
            }
            com.up366.common.download.DownloadInfo downloadInfoFetchAsesModelDownloadInfoSync = appResourceUpdateHelper.fetchAsesModelDownloadInfoSync();
            if (downloadInfoFetchAsesModelDownloadInfoSync == null) {
                com.up366.common.log.Logger.error("TAG - StateDetectHelper - detectImpl - download ases 获取下载信息失败");
                setState(25, iStateDectectHelper);
                return;
            }
            arrayList.add(downloadInfoFetchAsesModelDownloadInfoSync);
        }
        if (arrayList.size() > 0) {
            setState(24, "download size:" + arrayList.size(), arrayList, iStateDectectHelper);
        }
    }

    private void showPage(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        if (bookInfoStudy.getBookType() == 2) {
            setState(19, iStateDectectHelper);
            return;
        }
        com.up366.mobile.book.model.CatalogPage catalogPageFindOpenNode = findOpenNode(openConfigInfo);
        openConfigInfo.pageNo = catalogPageFindOpenNode.getPageNo();
        com.up366.mobile.book.model.CatalogPage chapterPPage = catalogPageFindOpenNode.obj.isPage() ? catalogPageFindOpenNode.getChapterPPage() : catalogPageFindOpenNode;
        if (openConfigInfo.isSDKV8()) {
            return;
        }
        if (chapterPPage.obj.getChapterType() == 4) {
            com.up366.mobile.book.model.ChapterInfo chapterInfo = chapterPPage.obj;
            openConfigInfo.extFileIds = com.alibaba.fastjson.JSONObject.toJSONString(com.up366.mobile.book.helper.Tools.buildPendingInfosFileId(chapterInfo.getFileId()));
            java.lang.String xotPaperId = chapterInfo.getXotPaperId();
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("scenario", com.up366.mobile.book.helper.Tools.getBookScenario(bookInfoStudy.getBookType()));
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
            jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
            jSONObject.put("paperId", xotPaperId);
            jSONObject.put("chapterId", openConfigInfo.chapterId);
            openConfigInfo.commonParams = jSONObject.toJSONString();
            this.context.book = bookInfoStudy.m466clone();
            com.up366.mobile.book.model.BookInfoStudy bookInfoStudy2 = this.context.book;
            openConfigInfo.bookId = com.up366.mobile.book.helper.Tools.commonBookId;
            bookInfoStudy2.setBookId(com.up366.mobile.book.helper.Tools.commonBookId);
            openConfigInfo.pageNo = -1;
            setState(18, iStateDectectHelper);
            return;
        }
        if (chapterPPage.obj.getChapterType() == 1 || chapterPPage.obj.getChapterType() == 3 || chapterPPage.obj.getChapterType() == 5) {
            switch (bookInfoStudy.getPackType()) {
                case 1:
                    setState(11, iStateDectectHelper);
                    break;
                case 2:
                    setState(12, iStateDectectHelper);
                    break;
                case 3:
                    setState(13, iStateDectectHelper);
                    break;
                case 4:
                    setState(14, iStateDectectHelper);
                    break;
                case 5:
                    setState(15, iStateDectectHelper);
                    break;
                case 6:
                    if (!this.context.bookChapterInfo.isUseInHtmlChapter()) {
                        this.context.bookChapterInfo.setUseInHtmlChapter(true);
                        this.context.bookChapterInfo.initHtmlJsonStr();
                    }
                    setState(16, iStateDectectHelper);
                    break;
                case 7:
                    if (!this.context.bookChapterInfo.isUseInHtmlChapter()) {
                        this.context.bookChapterInfo.setUseInHtmlChapter(true);
                        this.context.bookChapterInfo.initHtmlJsonStr();
                    }
                    setState(17, iStateDectectHelper);
                    break;
                default:
                    setState(2, "未知的打包类型:" + bookInfoStudy.getPackType(), iStateDectectHelper);
                    com.up366.common.log.Logger.error("StateDetectHelper - detect - unknown pack type:" + bookInfoStudy.getPackType() + " bookId:" + bookInfoStudy.getBookId() + " bookName:" + bookInfoStudy.getBookName());
                    break;
            }
            return;
        }
        setState(2, "未知的章节类型:" + catalogPageFindOpenNode.obj.getChapterType(), iStateDectectHelper);
        com.up366.common.log.Logger.error("未知的章节类型！！！" + catalogPageFindOpenNode.obj.getChapterType());
    }

    private boolean checkIsFree(com.up366.mobile.book.model.CatalogPage catalogPage) {
        while (catalogPage != null && catalogPage.obj != null) {
            if (catalogPage.obj.isFree()) {
                return true;
            }
            if (catalogPage.obj.isChapter()) {
                break;
            }
            catalogPage = catalogPage.getpPage();
        }
        return false;
    }

    private boolean tryFixHasBuyByBookDetail(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) throws java.lang.InterruptedException {
        com.up366.mobile.book.model.BookDetailInfo bookDetailInfoLoadBookDetailInfo = com.up366.mobile.common.logic.Auth.cur().book().loadBookDetailInfo(bookInfoStudy.getBookId());
        if (!isBookOwned(bookDetailInfoLoadBookDetailInfo)) {
            com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolderFetchBookDetailSync = com.up366.mobile.common.logic.Auth.cur().book().fetchBookDetailSync(bookInfoStudy.getBookId(), bookInfoStudy.getBookType());
            if (netHolderFetchBookDetailSync.resp.isError()) {
                com.up366.common.log.Logger.error("TAG - StateDetectHelper - tryFixHasBuyByBookDetail - fetch detail error " + netHolderFetchBookDetailSync.resp);
                return false;
            }
            bookDetailInfoLoadBookDetailInfo = netHolderFetchBookDetailSync.info;
        }
        if (!isBookOwned(bookDetailInfoLoadBookDetailInfo)) {
            return false;
        }
        com.up366.common.log.Logger.info("TAG - StateDetectHelper - tryFixHasBuyByBookDetail - fix hasBuy by isOwned");
        setState(0, iStateDectectHelper);
        bookInfoStudy.initWithBookDetailInfo(bookDetailInfoLoadBookDetailInfo);
        bookInfoStudy.setHasBuy(true);
        this.context.bookChapterInfo.init(bookInfoStudy);
        this.context.detectCurrentState(true);
        return true;
    }

    private boolean isBookOwned(com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        if (bookDetailInfo == null) {
            return false;
        }
        if (!bookDetailInfo.isGoods() || bookDetailInfo.getGoodsPrice() == 0.0f) {
            return true;
        }
        if (bookDetailInfo.getIsOwned() != 1) {
            return false;
        }
        long endDate = bookDetailInfo.getEndDate();
        return endDate < 1 || com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() < endDate;
    }

    private com.up366.mobile.book.model.CatalogPage findOpenNode(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        com.up366.mobile.book.model.TreeBookChapter treeBookChapter = this.context.bookChapterInfo;
        if (!com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.taskId)) {
            com.up366.mobile.book.model.CatalogPage pageByTaskId = treeBookChapter.getPageByTaskId(openConfigInfo.taskId);
            if (pageByTaskId != null) {
                return pageByTaskId;
            }
            if (treeBookChapter.isBeReplacedOriginTask(openConfigInfo.taskId)) {
                treeBookChapter.setIgnoreCustomChapter(true);
                treeBookChapter.invalidHtmlJsonStrHash();
                treeBookChapter.init(treeBookChapter.getBook());
                com.up366.mobile.book.model.CatalogPage pageByTaskId2 = treeBookChapter.getPageByTaskId(openConfigInfo.taskId);
                if (pageByTaskId2 != null) {
                    return pageByTaskId2;
                }
            }
        }
        com.up366.mobile.book.model.CatalogPage page = treeBookChapter.getPage(openConfigInfo.pageId);
        if (page != null) {
            return page;
        }
        com.up366.mobile.book.model.CatalogChapter chapter = treeBookChapter.getChapter(openConfigInfo.chapterId);
        if (chapter == null && !com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.pageId) && bookInfoStudy.getBookType() == 2) {
            chapter = treeBookChapter.getChapter(openConfigInfo.pageId);
        }
        if (chapter != null) {
            return chapter;
        }
        return null;
    }

    private com.up366.mobile.book.model.ChapterInfo findContentNode(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        com.up366.mobile.book.model.TreeBookChapter treeBookChapter = this.context.bookChapterInfo;
        if (bookInfoStudy.getBookType() == 2) {
            return treeBookChapter.getChapter(openConfigInfo.chapterId).obj;
        }
        if (bookInfoStudy.getBookType() == 1) {
            switch (bookInfoStudy.getPackType()) {
                case 1:
                    return treeBookChapter.getChapter(openConfigInfo.chapterId).obj;
                case 2:
                case 3:
                    return null;
                case 4:
                case 6:
                case 7:
                    com.up366.mobile.book.model.CatalogChapter chapter = treeBookChapter.getChapter(openConfigInfo.chapterId);
                    if (chapter == null) {
                        return null;
                    }
                    com.up366.mobile.book.model.ChapterInfo chapterInfo = chapter.obj;
                    if (chapter.obj.isContent()) {
                        return chapterInfo;
                    }
                    if (chapter.getContentPPage() == null) {
                        return null;
                    }
                    return chapter.getContentPPage().obj;
                case 5:
                    return null;
                default:
                    com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "错误的打包类型:" + bookInfoStudy.getPackType());
                    com.up366.common.log.Logger.error("TAG - StateDetectHelper - findContentNode - packType : " + bookInfoStudy.getPackType());
                    break;
            }
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "未知类型 BookType=" + bookInfoStudy.getBookType());
            com.up366.common.log.Logger.error("TAG - StateDetectHelper - findContentNode - cfg = [" + openConfigInfo + "]");
        }
        return null;
    }

    private void setState(int i, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) {
        setState(i, "", iStateDectectHelper);
    }

    private void setState(int i, java.lang.String str, com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) {
        setState(i, str, null, iStateDectectHelper);
    }

    private void setState(final int i, final java.lang.String str, final java.lang.Object obj, final com.up366.mobile.book.helper.StateDetectHelper.IStateDectectHelper iStateDectectHelper) {
        com.up366.common.log.Logger.info("TAG - StateDetectHelper - setState - state = [" + getStateName(i) + "], info = [" + str + "], obj = [" + obj + "], callback = [" + iStateDectectHelper.hashCode() + "]");
        final boolean z = this.oldState == i;
        this.oldState = i;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.StateDetectHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                iStateDectectHelper.onResult(i, str, obj, z);
            }
        });
    }

    public void resetOldState() {
        this.oldState = -1;
    }

    private com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> fetchAllConfig() throws java.lang.InterruptedException {
        if (!com.up366.mobile.common.utils.ViewDataInvalidRecord.$("state-detect-fetch-all").isInvalid()) {
            return null;
        }
        com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllSync = com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
        if (netHolderFetchAllSync.resp.isError()) {
            com.up366.mobile.common.utils.ViewDataInvalidRecord.$("state-detect-fetch-all").invalid();
        }
        return netHolderFetchAllSync;
    }

    public java.lang.String getStateName(int i) {
        if (i == 0) {
            return "STATE_LOADING";
        }
        switch (i) {
            case 2:
                return "STATE_DIALOG_TIP_BACK";
            case 3:
                return "STATE_DIALOG_TIP_NO_CHAPTER";
            case 4:
                return "STATE_OPEN_CHAPTER_NOT_FOUND";
            case 5:
                return "STATE_OPEN_PAGE_NOT_FOUND";
            case 6:
                return "STATE_PLAN_NO_OPEN";
            case 7:
                return "STATE_PAGE_NO_FREE";
            case 8:
                return "STATE_SHOW_APP_CATALOG";
            case 9:
                return "STATE_SHOW_2016_HTML_CATALOG";
            case 10:
                return "STATE_SHOW_2019_HTML_CATALOG";
            case 11:
                return "STATE_SHOW_PACK_TYPE_L";
            case 12:
                return "STATE_SHOW_PACK_TYPE_VLS";
            case 13:
                return "STATE_SHOW_PACK_TYPE_S";
            case 14:
                return "STATE_SHOW_PACK_TYPE_LDX";
            case 15:
                return "STATE_SHOW_PACK_TYPE_LS";
            case 16:
                return "STATE_SHOW_PACK_TYPE_GJS";
            case 17:
                return "STATE_SHOW_PACK_TYPE_TX";
            case 18:
                return "STATE_SHOW_TEST_CHAPTER";
            case 19:
                return "STATE_SHOW_SCHOOL_PAGE";
            case 20:
                return "STATE_SHOW_EXERCISE_PAGE";
            case 21:
                return "STATE_SHOW_COMMON_PAGE";
            case 22:
                return "STATE_BOOK_NOT_SUPPORT";
            case 23:
                return "STATE_SHOW_DICT_PAGE";
            case 24:
                return "STATE_DOWNLOAD_COMBINE";
            case 25:
                return "STATE_DOWNLOAD_ERROR";
            case 26:
                return "STATE_SHOW_2025_COMMON_PAGE";
            default:
                return "unknown state:" + i;
        }
    }
}
