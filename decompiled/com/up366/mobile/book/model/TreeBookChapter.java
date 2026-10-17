package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TreeBookChapter {
    private com.up366.mobile.book.model.BookInfoStudy book;
    private java.util.List<com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage>> chapterList;
    private java.util.Map<java.lang.String, com.up366.mobile.book.model.CatalogChapter> chapterMap;
    private java.util.List<com.up366.mobile.book.model.CatalogChapter> chapters;
    private java.util.List<com.up366.mobile.book.model.CustomChapterInfo> customChapterList;
    private java.lang.String htmlJsonStr;
    private java.util.Map<java.lang.String, com.up366.mobile.book.model.CatalogChapter> localChapterMap;
    private java.util.List<com.up366.mobile.book.model.CatalogChapter> localChapters;
    private java.util.Map<java.lang.String, com.up366.mobile.book.model.CatalogPage> localPageMap;
    private java.util.List<com.up366.mobile.book.model.CatalogPage> localPages;
    private int openPage;
    private java.util.Map<java.lang.String, com.up366.mobile.book.model.CatalogPage> pageMap;
    private java.util.List<com.up366.mobile.book.model.CatalogPage> pages;
    private java.util.List<com.up366.mobile.book.model.CatalogChapter> tempChapters;
    private java.util.Map<java.lang.String, java.util.List<com.up366.mobile.book.model.CatalogChapter>> tempChaptersMap;
    private java.util.List<com.up366.mobile.book.model.ChapterInfo> treeChapters;
    private boolean useInHtmlChapter;
    private java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> planMap = new java.util.HashMap();
    private java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> taskMap = new java.util.HashMap();
    private boolean ignoreCloseChapter = true;
    private boolean ignoreCustomChapter = false;
    private boolean hasLoadTreeChapterData = false;
    private com.up366.common.task.Task asyncTreeDataLoadedCallbackRunnable = null;
    private final java.util.Map<java.lang.String, com.up366.mobile.book.model.CustomChapterInfo> customChapterMap = new java.util.HashMap();
    private final java.util.Map<java.lang.String, com.up366.mobile.book.model.CustomChapterInfo> customTaskMap = new java.util.HashMap();
    private final java.util.Map<java.lang.String, com.up366.mobile.book.model.ChapterInfo> originBeReplaceChapterMap = new java.util.HashMap();
    private int htmlJsonStrHashOld = -1;
    private int htmlJsonStrHashNew = -1;

    public TreeBookChapter(boolean z) {
        this.useInHtmlChapter = z;
    }

    public com.up366.mobile.book.model.TreeBookChapter setIsIgnoreCloseChapter(boolean z) {
        this.ignoreCloseChapter = z;
        return this;
    }

    public TreeBookChapter(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, java.util.List<com.up366.mobile.book.model.ChapterInfo> list) {
        init(bookInfoStudy, list);
    }

    public void init(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        init(bookInfoStudy, this.treeChapters);
    }

    public void init(java.util.List<com.up366.mobile.book.model.ChapterInfo> list) {
        init(this.book, list);
    }

    private synchronized void init(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, java.util.List<com.up366.mobile.book.model.ChapterInfo> list) {
        this.book = bookInfoStudy;
        if (list == null) {
            list = new java.util.ArrayList<>();
        }
        this.treeChapters = list;
        java.util.List<com.up366.mobile.book.model.CatalogChapter> list2 = this.tempChapters;
        if (list2 == null) {
            this.tempChapters = new java.util.ArrayList();
            this.tempChaptersMap = new java.util.HashMap();
        } else {
            list2.clear();
            this.tempChaptersMap.clear();
        }
        this.localChapters = new java.util.ArrayList();
        this.localPages = new java.util.ArrayList();
        this.localChapterMap = new java.util.HashMap();
        this.localPageMap = new java.util.HashMap();
        initCustomChapterMap();
        sortCoverList();
        initChapters();
        initPageNo();
        initChapterMap();
        initPageMap();
        this.chapters = this.localChapters;
        this.pages = this.localPages;
        this.chapterMap = this.localChapterMap;
        this.pageMap = this.localPageMap;
        this.chapterList = com.up366.mobile.book.helper.ParseNodeHelper.parse(this);
        initHtmlJsonStr();
    }

    private void initCustomChapterMap() {
        this.customChapterMap.clear();
        this.customTaskMap.clear();
        java.util.List<com.up366.mobile.book.model.CustomChapterInfo> list = this.customChapterList;
        if (list == null) {
            return;
        }
        for (com.up366.mobile.book.model.CustomChapterInfo customChapterInfo : list) {
            if (customChapterInfo.isChapter()) {
                this.customChapterMap.put(customChapterInfo.getChapterId(), customChapterInfo);
            }
            if (customChapterInfo.isPage()) {
                this.customChapterMap.put(customChapterInfo.getId(), customChapterInfo);
            }
            if (customChapterInfo.isTask()) {
                this.customChapterMap.put(customChapterInfo.getFlipTaskId(), customChapterInfo);
                this.customTaskMap.put(customChapterInfo.getTaskId(), customChapterInfo);
            }
        }
    }

    private void initPageMap() {
        for (com.up366.mobile.book.model.CatalogPage catalogPage : this.localPages) {
            this.localPageMap.put(catalogPage.obj.getId(), catalogPage);
        }
    }

    private void initChapterMap() {
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter : this.tempChapters) {
            this.localChapterMap.put(catalogChapter.obj.getId(), catalogChapter);
        }
    }

    public void initHtmlJsonStr() {
        if (this.useInHtmlChapter) {
            this.htmlJsonStr = new com.up366.mobile.book.model.HtmlBookChapterInfoParser(this).toJSONStr();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            this.htmlJsonStrHashNew = this.htmlJsonStr.hashCode();
            com.up366.common.log.Logger.debug("count TreeBookChapter.initHtmlJsonStr time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
    }

    public boolean isHtmlJsonHasChange() {
        com.up366.common.log.Logger.info("TAG TreeBookChapter - isHtmlJsonHasChange - " + this.htmlJsonStrHashOld + " - " + this.htmlJsonStrHashNew);
        return this.htmlJsonStrHashNew != this.htmlJsonStrHashOld;
    }

    public void newHtmlJsonHasUpdate() {
        this.htmlJsonStrHashOld = this.htmlJsonStrHashNew;
    }

    public void invalidHtmlJsonStrHash() {
        this.htmlJsonStrHashOld = -1;
    }

    public com.up366.mobile.book.model.BookInfoStudy getBook() {
        return this.book;
    }

    public void setBook(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        this.book = bookInfoStudy;
    }

    public java.util.List<com.up366.mobile.book.model.CatalogChapter> getChapters() {
        return this.chapters;
    }

    public void setChapters(java.util.List<com.up366.mobile.book.model.CatalogChapter> list) {
        this.chapters = list;
    }

    public java.util.List<com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage>> getChapterList() {
        return this.chapterList;
    }

    public java.util.List<com.up366.mobile.book.model.CatalogPage> getPages() {
        return this.pages;
    }

    public java.util.Map<java.lang.String, com.up366.mobile.book.model.CatalogChapter> getChapterMap() {
        return this.chapterMap;
    }

    public java.util.Map<java.lang.String, com.up366.mobile.book.model.CatalogPage> getPageMap() {
        return this.pageMap;
    }

    public com.up366.mobile.book.model.CatalogPage getPage(java.lang.String str) {
        return this.pageMap.get(str);
    }

    public com.up366.mobile.book.model.CatalogPage getPageByTaskId(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return null;
        }
        for (com.up366.mobile.book.model.CatalogPage catalogPage : this.pageMap.values()) {
            if (str.equals(catalogPage.getObj().getTaskId())) {
                return catalogPage;
            }
        }
        return null;
    }

    public com.up366.mobile.book.model.CatalogChapter getChapter(java.lang.String str) {
        return this.chapterMap.get(str);
    }

    public com.up366.mobile.book.model.CatalogChapter getTask(java.lang.String str) {
        return this.chapterMap.get(str);
    }

    private void initPageNo() {
        for (int i = 0; i < this.localPages.size(); i++) {
            this.localPages.get(i).setPageNo(i);
        }
        for (int i2 = 0; i2 < this.localChapters.size(); i2++) {
            com.up366.mobile.book.model.CatalogChapter catalogChapter = this.localChapters.get(i2);
            if (catalogChapter.obj.isChapter()) {
                setPageNo(catalogChapter);
            }
        }
    }

    private void setPageNo(com.up366.mobile.book.model.CatalogChapter catalogChapter) {
        com.up366.mobile.book.model.CatalogChapter nextPage = catalogChapter.getNextPage();
        if (nextPage != null) {
            catalogChapter.setPageNo(nextPage.getPageNo());
        }
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter2 : catalogChapter.pages) {
            if (catalogChapter2.obj.isChapter()) {
                setPageNo(catalogChapter2);
            }
        }
    }

    private synchronized void sortCoverList() {
        this.originBeReplaceChapterMap.clear();
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.up366.mobile.book.model.ChapterInfo chapterInfoCreateReplaceCopy : this.treeChapters) {
            hashSet.add(chapterInfoCreateReplaceCopy.getId());
            if (!this.ignoreCustomChapter && this.customChapterMap.size() > 0) {
                if (chapterInfoCreateReplaceCopy.isPage()) {
                    com.up366.mobile.book.model.CustomChapterInfo customChapterInfo = this.customChapterMap.get(chapterInfoCreateReplaceCopy.getTaskId());
                    if (customChapterInfo != null) {
                        chapterInfoCreateReplaceCopy = customChapterInfo.createReplaceCopy(chapterInfoCreateReplaceCopy);
                    }
                } else {
                    com.up366.mobile.book.model.CustomChapterInfo customChapterInfo2 = this.customChapterMap.get(chapterInfoCreateReplaceCopy.getId());
                    if (customChapterInfo2 != null) {
                        this.originBeReplaceChapterMap.put(chapterInfoCreateReplaceCopy.getId(), new com.up366.mobile.book.model.ChapterInfo(chapterInfoCreateReplaceCopy));
                        chapterInfoCreateReplaceCopy = customChapterInfo2.createReplaceCopy(chapterInfoCreateReplaceCopy);
                    }
                }
            }
            buildChapterInfoWithPlanAndFinishedInfo(chapterInfoCreateReplaceCopy);
        }
        handleNewCustomChapter(this.customChapterList, hashSet);
        java.util.Collections.sort(this.tempChapters);
    }

    private void handleNewCustomChapter(java.util.List<com.up366.mobile.book.model.CustomChapterInfo> list, java.util.Set<java.lang.String> set) {
        if (list == null || this.ignoreCustomChapter) {
            return;
        }
        java.util.Iterator<com.up366.mobile.book.model.CustomChapterInfo> it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.book.model.ChapterInfo chapterInfoCreateNewChapterInfoNode = it.next().createNewChapterInfoNode();
            if (!set.contains(chapterInfoCreateNewChapterInfoNode.getId())) {
                buildChapterInfoWithPlanAndFinishedInfo(chapterInfoCreateNewChapterInfoNode);
            }
        }
    }

    private void buildChapterInfoWithPlanAndFinishedInfo(com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        if (this.book.isHasBuy()) {
            chapterInfo.setIsFree(1);
        }
        com.up366.mobile.book.model.CourseBookPlan courseBookPlan = this.planMap.get(chapterInfo.getId());
        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo = this.taskMap.get(chapterInfo.getId());
        com.up366.mobile.book.model.CatalogChapter catalogChapter = new com.up366.mobile.book.model.CatalogChapter(chapterInfo);
        chapterInfo.setIsLock(0);
        if (courseBookPlan != null) {
            if (courseBookPlan.isClose() && this.ignoreCloseChapter) {
                return;
            }
            catalogChapter.setPlan(courseBookPlan);
            chapterInfo.setIsLock(courseBookPlan.getIsLock());
        }
        if (bookTaskFinishedInfo != null) {
            catalogChapter.setTaskInfo(bookTaskFinishedInfo);
        } else if (chapterInfo.isTask()) {
            com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo2 = new com.up366.mobile.book.model.BookTaskFinishedInfo();
            bookTaskFinishedInfo2.setTaskId(chapterInfo.getId());
            bookTaskFinishedInfo2.setUid(com.up366.mobile.common.logic.Auth.UID());
            bookTaskFinishedInfo2.setAddDate(0L);
            bookTaskFinishedInfo2.setBookId(chapterInfo.getBookId());
            this.taskMap.put(chapterInfo.getId(), bookTaskFinishedInfo2);
            catalogChapter.setTaskInfo(bookTaskFinishedInfo2);
        } else {
            catalogChapter.setTaskInfo(new com.up366.mobile.book.model.BookTaskFinishedInfo());
        }
        this.tempChapters.add(catalogChapter);
        java.lang.String parentId = chapterInfo.getParentId();
        java.util.List<com.up366.mobile.book.model.CatalogChapter> arrayList = this.tempChaptersMap.get(parentId);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.tempChaptersMap.put(parentId, arrayList);
        }
        arrayList.add(catalogChapter);
    }

    private void initChapters() {
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter : this.tempChapters) {
            if (catalogChapter.obj.isRootNode() && catalogChapter.obj.isChapter()) {
                this.localChapters.add(catalogChapter);
                initChapterPages(catalogChapter, 0);
                if (catalogChapter.obj.isPage() || catalogChapter.obj.isWelcome()) {
                    addToPages(catalogChapter);
                }
            }
        }
    }

    private void initChapterPages(com.up366.mobile.book.model.CatalogChapter catalogChapter, int i) {
        java.util.List<com.up366.mobile.book.model.CatalogChapter> list = this.tempChaptersMap.get(catalogChapter.obj.getId());
        if (list == null) {
            return;
        }
        java.util.Collections.sort(list);
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter2 : list) {
            catalogChapter.pages.add(catalogChapter2);
            catalogChapter2.setpPage(catalogChapter);
            if (catalogChapter2.obj.isPage() || catalogChapter.obj.isWelcome()) {
                addToPages(catalogChapter2);
            }
            if (catalogChapter2.obj.isTask()) {
                catalogChapter.tasks.add(catalogChapter2);
            }
            if (catalogChapter2.obj.isChapter()) {
                if (i < 10) {
                    initChapterPages(catalogChapter2, i + 1);
                } else {
                    com.up366.common.log.Logger.warn("ldx chapters too deep ........");
                }
            }
        }
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter3 : catalogChapter.tasks) {
            for (com.up366.mobile.book.model.CatalogChapter catalogChapter4 : catalogChapter.pages) {
                if (catalogChapter3.obj.getId().equals(catalogChapter4.obj.getTaskId())) {
                    catalogChapter3.pages.add(catalogChapter4);
                }
            }
        }
        if (catalogChapter.pages.size() == 0) {
            addToPages(catalogChapter);
        }
    }

    void addToPages(com.up366.mobile.book.model.CatalogChapter catalogChapter) {
        if (catalogChapter.isInLockChapter()) {
            return;
        }
        if (catalogChapter.isInOnlinePaperChapter()) {
            com.up366.common.log.Logger.debug("isInOnlinePaperChapter-------------");
        } else {
            this.localPages.add(catalogChapter);
        }
    }

    public java.util.List<com.up366.mobile.book.model.ChapterInfo> getTreeChapters() {
        if (this.ignoreCustomChapter || this.customChapterMap.size() == 0) {
            return this.treeChapters;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.treeChapters.size());
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.up366.mobile.book.model.ChapterInfo chapterInfoCreateReplaceCopy : this.treeChapters) {
            hashSet.add(chapterInfoCreateReplaceCopy.getId());
            if (chapterInfoCreateReplaceCopy.isPage()) {
                com.up366.mobile.book.model.CustomChapterInfo customChapterInfo = this.customChapterMap.get(chapterInfoCreateReplaceCopy.getTaskId());
                if (customChapterInfo != null) {
                    chapterInfoCreateReplaceCopy = customChapterInfo.createReplaceCopy(chapterInfoCreateReplaceCopy);
                }
            } else {
                com.up366.mobile.book.model.CustomChapterInfo customChapterInfo2 = this.customChapterMap.get(chapterInfoCreateReplaceCopy.getId());
                if (customChapterInfo2 != null) {
                    this.originBeReplaceChapterMap.put(chapterInfoCreateReplaceCopy.getId(), new com.up366.mobile.book.model.ChapterInfo(chapterInfoCreateReplaceCopy));
                    chapterInfoCreateReplaceCopy = customChapterInfo2.createReplaceCopy(chapterInfoCreateReplaceCopy);
                }
            }
            arrayList.add(chapterInfoCreateReplaceCopy);
        }
        java.util.List<com.up366.mobile.book.model.CustomChapterInfo> list = this.customChapterList;
        if (list != null) {
            java.util.Iterator<com.up366.mobile.book.model.CustomChapterInfo> it = list.iterator();
            while (it.hasNext()) {
                com.up366.mobile.book.model.ChapterInfo chapterInfoCreateNewChapterInfoNode = it.next().createNewChapterInfoNode();
                if (!hashSet.contains(chapterInfoCreateNewChapterInfoNode.getId())) {
                    arrayList.add(chapterInfoCreateNewChapterInfoNode);
                }
            }
        }
        return arrayList;
    }

    public int[] getPageRange(java.lang.String str) {
        int pageNo;
        java.util.List<com.up366.mobile.book.model.CatalogPage> list = this.pages;
        if (list == null) {
            return new int[]{0, 1};
        }
        int size = list.size();
        for (int i = 0; i < this.chapterList.size() && !com.up366.common.StringUtils.isEmptyOrNull(str); i++) {
            com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> treeNode = this.chapterList.get(i);
            if (treeNode.obj != null && str.equals(treeNode.obj.obj.getId())) {
                int pageNo2 = treeNode.obj.getPageNo();
                com.up366.mobile.book.model.CatalogChapter endPage = ((com.up366.mobile.book.model.CatalogChapter) treeNode.obj).getEndPage();
                if (endPage == null) {
                    pageNo = this.pages.size();
                } else {
                    pageNo = endPage.getPageNo();
                }
                return new int[]{pageNo2, pageNo};
            }
        }
        return new int[]{0, size};
    }

    public long getChapterSize(java.lang.String str) {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), str);
        if (com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
            return getFileOrDirSize(new java.io.File(strJoin));
        }
        return 0L;
    }

    private long getFileOrDirSize(java.io.File file) {
        if (file.isFile()) {
            return file.length();
        }
        long fileOrDirSize = 0;
        if (file.isDirectory()) {
            for (java.io.File file2 : file.listFiles()) {
                fileOrDirSize += getFileOrDirSize(file2);
            }
        }
        return fileOrDirSize;
    }

    public java.lang.String getHtmlJsonStr() {
        if (!this.useInHtmlChapter) {
            throw new java.lang.IllegalStateException("需要先调用 setUseInHtmlChapter(boolean useInHtmlChapter)");
        }
        return this.htmlJsonStr;
    }

    public boolean isUseInHtmlChapter() {
        return this.useInHtmlChapter;
    }

    public void setUseInHtmlChapter(boolean z) {
        this.useInHtmlChapter = z;
    }

    public void setPlanAndTaskMap(java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> map, java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> map2) {
        if (map != null) {
            this.planMap = map;
        }
        if (map2 != null) {
            this.taskMap = map2;
        }
    }

    public java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> getTaskMap() {
        return this.taskMap;
    }

    public java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> getPlanMap() {
        return this.planMap;
    }

    public void setAsyncTreeDataLoadedCallbackRunnable(com.up366.common.task.Task task) {
        this.asyncTreeDataLoadedCallbackRunnable = task;
    }

    public boolean isHasLoadTreeChapterData() {
        return this.hasLoadTreeChapterData;
    }

    public void setHasLoadTreeChapterData(boolean z) {
        this.hasLoadTreeChapterData = z;
        com.up366.common.task.Task task = this.asyncTreeDataLoadedCallbackRunnable;
        if (task != null) {
            com.up366.common.task.TaskUtils.postGlobalTask(task);
        }
    }

    public void setCustomChapterList(java.util.List<com.up366.mobile.book.model.CustomChapterInfo> list) {
        this.customChapterList = list;
    }

    public void setIgnoreCustomChapter(boolean z) {
        this.ignoreCustomChapter = z;
    }

    public boolean isBeReplacedOriginTask(java.lang.String str) {
        return this.originBeReplaceChapterMap.get(str) != null;
    }

    public boolean isCustomChapterId(java.lang.String str) {
        return (this.ignoreCustomChapter || this.customChapterMap.get(str) == null) ? false : true;
    }

    public boolean isCustomTaskId(java.lang.String str) {
        return (this.ignoreCustomChapter || this.customTaskMap.get(str) == null) ? false : true;
    }
}
