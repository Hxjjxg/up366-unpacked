package com.up366.mobile.user.setting.clearcache;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CacheMgr {
    public static final java.lang.String GOOD_SDK_CACHE_NAME = "下载";
    com.up366.greendao.DaoSession dbMgr;
    com.up366.mobile.common.logic.Manager manager;

    public CacheMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.dbMgr = manager.db();
    }

    java.util.List<com.up366.mobile.user.setting.clearcache.CacheInfo> getBookCaches() {
        java.util.ArrayList<com.up366.mobile.user.setting.clearcache.CacheInfo> arrayList = new java.util.ArrayList();
        final java.util.List<com.up366.mobile.book.model.BookResourceMapInfo> listFindAll = this.manager.db1().findAll(com.up366.mobile.book.model.BookResourceMapInfo.class);
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo : listFindAll) {
            if (com.up366.common.FileUtilsUp.isFileExists(bookResourceMapInfo.path)) {
                if (!android.text.TextUtils.isEmpty(bookResourceMapInfo.bookId) && !android.text.TextUtils.equals(com.up366.mobile.book.helper.Tools.RESOURCE_TEST_CACHE_ID, bookResourceMapInfo.bookId) && !android.text.TextUtils.equals(com.up366.mobile.book.helper.Tools.commonBookId, bookResourceMapInfo.bookId)) {
                    hashSet.add(bookResourceMapInfo.bookId);
                }
            } else {
                this.manager.db1().delete(bookResourceMapInfo);
            }
        }
        for (final com.up366.mobile.book.model.BookDetailInfo bookDetailInfo : this.dbMgr.getBookDetailInfoDao().loadAll()) {
            final java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), bookDetailInfo.getBookId());
            if (com.up366.common.FileUtilsUp.isFileExists(strJoin) || hashSet.contains(bookDetailInfo.getBookId())) {
                com.up366.mobile.user.setting.clearcache.CacheInfo cacheInfo = new com.up366.mobile.user.setting.clearcache.CacheInfo(bookDetailInfo.getBookName(), new java.lang.Runnable() { // from class: com.up366.mobile.user.setting.clearcache.CacheMgr$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getBookCaches$0(strJoin, listFindAll, bookDetailInfo);
                    }
                }, 7);
                cacheInfo.setBookName(bookDetailInfo.getBookName());
                cacheInfo.setBookId(bookDetailInfo.getBookId());
                cacheInfo.setBookPicUrl(bookDetailInfo.getGoodsImg());
                cacheInfo.setBookRemainDays(bookDetailInfo.getRemainDay());
                cacheInfo.setBookIsOwn(com.up366.mobile.common.logic.Auth.cur().book().hasBuy(-1, bookDetailInfo.getBookId(), bookDetailInfo.isGoods()));
                arrayList.add(cacheInfo);
            }
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        long j = 0;
        for (com.up366.mobile.user.setting.clearcache.CacheInfo cacheInfo2 : arrayList) {
            cacheInfo2.setShowDotLine(false);
            long fileOrDirSize = getFileOrDirSize(new java.io.File(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), cacheInfo2.getBookId())));
            if (hashSet.contains(cacheInfo2.getBookId())) {
                for (com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo2 : listFindAll) {
                    if (android.text.TextUtils.equals(cacheInfo2.getBookId(), bookResourceMapInfo2.bookId)) {
                        fileOrDirSize += getFileOrDirSize(new java.io.File(bookResourceMapInfo2.path));
                    }
                }
            }
            if (fileOrDirSize != 0) {
                arrayList2.add(cacheInfo2);
                cacheInfo2.setCacheSize(fileOrDirSize);
                j += fileOrDirSize;
            }
        }
        if (j > 0) {
            arrayList2.add(0, new com.up366.mobile.user.setting.clearcache.CacheInfo("课本", new java.lang.Runnable() { // from class: com.up366.mobile.user.setting.clearcache.CacheMgr$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getBookCaches$1(listFindAll);
                }
            }, 6, j));
        }
        long fileOrDirSize2 = getFileOrDirSize(new java.io.File(com.up366.mobile.common.utils.AppFileUtils.getV9RootResourceDir()));
        if (fileOrDirSize2 > 0) {
            arrayList2.add(0, new com.up366.mobile.user.setting.clearcache.CacheInfo(GOOD_SDK_CACHE_NAME, new java.lang.Runnable() { // from class: com.up366.mobile.user.setting.clearcache.CacheMgr$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.mobile.common.utils.AppFileUtils.getV9RootResourceDir());
                }
            }, 6, fileOrDirSize2));
        }
        if (arrayList2.size() == 0) {
            com.up366.common.log.Logger.info("TAG - CacheMgr - getBookCaches - 不存在飞书缓存");
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBookCaches$0(java.lang.String str, java.util.List list, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        com.up366.common.FileUtilsUp.deleteDirOrFile(str);
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo = (com.up366.mobile.book.model.BookResourceMapInfo) it.next();
            if (android.text.TextUtils.equals(bookDetailInfo.getBookId(), bookResourceMapInfo.bookId) && com.up366.common.FileUtilsUp.isFileExists(bookResourceMapInfo.path)) {
                com.up366.common.FileUtilsUp.deleteDirOrFile(bookResourceMapInfo.path);
                this.manager.db1().delete(bookResourceMapInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBookCaches$1(java.util.List list) {
        com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir());
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo = (com.up366.mobile.book.model.BookResourceMapInfo) it.next();
            if (!android.text.TextUtils.isEmpty(bookResourceMapInfo.bookId) && com.up366.common.FileUtilsUp.isFileExists(bookResourceMapInfo.path)) {
                com.up366.common.FileUtilsUp.deleteDirOrFile(bookResourceMapInfo.path);
                this.manager.db1().delete(bookResourceMapInfo);
            }
        }
    }

    private long getFileOrDirSize(java.io.File file) {
        java.io.File[] fileArrListFiles;
        long fileOrDirSize = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (java.io.File file2 : fileArrListFiles) {
                fileOrDirSize += getFileOrDirSize(file2);
            }
        }
        return fileOrDirSize;
    }

    com.up366.mobile.user.setting.clearcache.CacheInfo getHomeWorkCache() {
        long fileOrDirSize = getFileOrDirSize(new java.io.File(com.up366.mobile.common.utils.AppFileUtils.getHomeworkDir()));
        java.util.List<com.up366.mobile.book.model.BookResourceMapInfo> listFind = this.manager.db1().find(com.up366.mobile.book.model.BookResourceMapInfo_.bookId, com.up366.mobile.book.helper.Tools.RESOURCE_TEST_CACHE_ID);
        final java.util.HashSet hashSet = new java.util.HashSet();
        for (com.up366.mobile.book.model.BookResourceMapInfo bookResourceMapInfo : listFind) {
            if (com.up366.common.FileUtilsUp.isFileExists(bookResourceMapInfo.path)) {
                hashSet.add(bookResourceMapInfo.path);
            } else {
                this.manager.db1().delete(bookResourceMapInfo);
            }
        }
        java.util.Iterator it = hashSet.iterator();
        long fileOrDirSize2 = fileOrDirSize;
        while (it.hasNext()) {
            fileOrDirSize2 += getFileOrDirSize(new java.io.File((java.lang.String) it.next()));
        }
        return new com.up366.mobile.user.setting.clearcache.CacheInfo("练习", new java.lang.Runnable() { // from class: com.up366.mobile.user.setting.clearcache.CacheMgr$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.user.setting.clearcache.CacheMgr.lambda$getHomeWorkCache$3(hashSet);
            }
        }, 5, fileOrDirSize2);
    }

    static /* synthetic */ void lambda$getHomeWorkCache$3(java.util.Set set) {
        com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.mobile.common.utils.AppFileUtils.getHomeworkDir());
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            com.up366.common.FileUtilsUp.deleteDirOrFile((java.lang.String) it.next());
        }
    }
}
