package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookInfoStudy implements java.io.Serializable, java.lang.Cloneable {
    private long addTime;
    private java.lang.String bigPicture;
    private transient com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    private java.lang.String bookId;
    private java.lang.String bookName;
    private int bookType;
    private int categoryType;
    private int courseId;
    private long endTime;
    private java.lang.String fileId;
    private boolean forceReloadChapterData;
    private boolean hasBuy;
    private int isGoods;
    private int isOwned;
    private int isShelf;
    private java.lang.String jumpBehavior;
    private java.lang.String jumpCommonParams;
    private java.lang.String jumpExtDailyDate;
    private java.lang.String jumpExtFileIds;
    private boolean jumpFromTaskHistory;
    private java.lang.String jumpOpenChapter;
    private java.lang.String jumpOpenPage;
    private java.lang.String jumpOpenTask;
    private boolean jumpReTest;
    private java.lang.String jumpStudyTaskId;
    private java.lang.String jumpXotParam;
    private int packType;
    private int percent;
    private java.lang.String picture;
    private float price;
    private int productId;
    private int stageId;
    private long startTime;
    private int subjectId;
    private int toMobile = 1;
    private int toPC;
    private int validDays;

    public BookInfoStudy() {
    }

    public BookInfoStudy(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo) {
        setBookId(courseBookInfo.getBookId());
        setProductId(courseBookInfo.getGoodsId());
        setBookName(courseBookInfo.getBookName());
        setPicture(courseBookInfo.getGoodsImg());
        setBigPicture(courseBookInfo.getGoodsBigImg());
        setCourseId(courseBookInfo.getCourseId());
        setBookType(courseBookInfo.getBookType());
        setPackType(courseBookInfo.getPackType());
        setSubjectId(courseBookInfo.getSubjectId());
        setStageId(courseBookInfo.getStageId());
        setIsShelf(courseBookInfo.getIsShelf());
        setIsGoods(courseBookInfo.getIsGoods());
        setPrice(courseBookInfo.getGoodsPrice());
        com.up366.mobile.common.logic.model.ProductInfo productInfo = com.up366.mobile.common.logic.Auth.cur().book().getProductInfo(courseBookInfo.getBookId());
        if (productInfo != null) {
            setValidDays(productInfo.getValidDays());
            setStartTime(productInfo.getStartDate());
            setEndTime(productInfo.getEndDate());
            setAddTime(productInfo.getAddTime());
        }
    }

    public BookInfoStudy(com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        initWithBookDetailInfo(bookDetailInfo);
    }

    public BookInfoStudy(com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        initWithProductInfo(productInfo);
    }

    public BookInfoStudy(com.up366.mobile.common.logic.model.MyBook myBook) {
        initWithMyBook(myBook);
    }

    public int getRemainDay() {
        return (int) java.lang.Math.ceil((((((getEndTime() - com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) * 1.0f) / 24.0f) / 60.0f) / 60.0f) / 1000.0f);
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public java.lang.String getBookName() {
        return this.bookName;
    }

    public void setBookName(java.lang.String str) {
        this.bookName = str;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setPicture(java.lang.String str) {
        this.picture = str;
    }

    public void setBigPicture(java.lang.String str) {
        this.bigPicture = str;
    }

    public java.lang.String getPicture() {
        return this.picture;
    }

    public java.lang.String getBigPicture() {
        return this.bigPicture;
    }

    public java.lang.String getFileId() {
        return this.fileId;
    }

    public void setFileId(java.lang.String str) {
        this.fileId = str;
    }

    public int getBookType() {
        return this.bookType;
    }

    public boolean isShelf() {
        return this.isShelf == 1;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public int getIsGoods() {
        return this.isGoods;
    }

    public boolean isGoods() {
        return this.isGoods == 1;
    }

    public void setIsGoods(int i) {
        this.isGoods = i;
    }

    public void setIsShelf(int i) {
        this.isShelf = i;
    }

    public void setBookType(int i) {
        this.bookType = i;
    }

    public int getPackType() {
        return this.packType;
    }

    public void setPackType(int i) {
        this.packType = i;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public void setCategoryType(int i) {
        this.categoryType = i;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public int getStageId() {
        return this.stageId;
    }

    public void setStageId(int i) {
        this.stageId = i;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int i) {
        this.subjectId = i;
    }

    public boolean isHasBuy() {
        int iLoadTempCacheCanUse = com.up366.mobile.common.logic.Auth.cur().book().loadTempCacheCanUse(this.bookId);
        if (iLoadTempCacheCanUse == 0) {
            return this.hasBuy;
        }
        boolean z = iLoadTempCacheCanUse == 1;
        this.hasBuy = z;
        return z;
    }

    public void setHasBuy(boolean z) {
        this.hasBuy = z;
    }

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i) {
        this.productId = i;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float f) {
        this.price = f;
    }

    public int getValidDays() {
        return this.validDays;
    }

    public void setValidDays(int i) {
        this.validDays = i;
    }

    public void initHasBuy() {
        setHasBuy(canUseByBookInfo());
        com.up366.common.log.Logger.info("TAG - BookInfoStudy - initHasBuy - hasBuy:" + this.hasBuy);
    }

    private boolean canUseByBookInfo() {
        if (!isGoods() || this.price == 0.0f) {
            return true;
        }
        if (this.isOwned != 1) {
            return false;
        }
        return this.endTime < 1 || com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() < this.endTime;
    }

    private void initWithMyBook(com.up366.mobile.common.logic.model.MyBook myBook) {
        setBookId(myBook.getBookId());
        setProductId(myBook.getGoodsId());
        setBookName(myBook.getBookName());
        setPicture(myBook.getGoodsImg());
        setBigPicture(myBook.getGoodsBigImg());
        if (this.courseId < 1) {
            setCourseId(-1);
        }
        setPackType(myBook.getPackType());
        setIsShelf(myBook.getIsShelf());
        setPrice(myBook.getGoodsPrice());
        setValidDays(myBook.getValidDays());
        setStartTime(myBook.getStartDate());
        setAddTime(myBook.getAddTime());
        setEndTime(myBook.getEndDate());
        setBookType(myBook.getBookType());
        setIsGoods(myBook.getIsGoods());
        setStageId(myBook.getStageId());
        setSubjectId(myBook.getSubjectId());
        setToMobile(myBook.getToMobile());
        setToPC(myBook.getToPC());
    }

    private void initWithProductInfo(com.up366.mobile.common.logic.model.ProductInfo productInfo) {
        setBookId(productInfo.getBookId());
        setProductId(productInfo.getGoodsId());
        setBookName(productInfo.getBookName());
        setPicture(productInfo.getGoodsImg());
        setBigPicture(productInfo.getGoodsBigImg());
        if (this.courseId < 1) {
            setCourseId(-1);
        }
        setPackType(productInfo.getPackType());
        setIsShelf(productInfo.getIsShelf());
        setPrice(productInfo.getGoodsPrice());
        setValidDays(productInfo.getValidDays());
        setStartTime(productInfo.getStartDate());
        setAddTime(productInfo.getAddTime());
        setEndTime(productInfo.getEndDate());
        setBookType(productInfo.getBookType());
        setIsGoods(productInfo.getIsGoods());
        setStageId(productInfo.getStageId());
        setSubjectId(productInfo.getSubjectId());
        setToMobile(productInfo.getToMobile());
        setToPC(productInfo.getToPC());
    }

    public void initWithBookDetailInfo(com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        setBookId(bookDetailInfo.getBookId());
        setProductId(bookDetailInfo.getGoodsId());
        setBookName(bookDetailInfo.getBookName());
        setPicture(bookDetailInfo.getGoodsImg());
        setBigPicture(bookDetailInfo.getGoodsBigImg());
        if (this.courseId < 1) {
            setCourseId(-1);
        }
        setPackType(bookDetailInfo.getPackType());
        setIsShelf(bookDetailInfo.getIsShelf());
        setPrice(bookDetailInfo.getGoodsPrice());
        setValidDays(bookDetailInfo.getValidDays());
        setStartTime(bookDetailInfo.getStartDate());
        setAddTime(bookDetailInfo.getAddTime());
        setEndTime(bookDetailInfo.getEndDate());
        this.isOwned = bookDetailInfo.getIsOwned();
        setBookType(bookDetailInfo.getBookType());
        setIsGoods(bookDetailInfo.getIsGoods());
        setStageId(bookDetailInfo.getStageId());
        setSubjectId(bookDetailInfo.getSubjectId());
        setToMobile(bookDetailInfo.getToMobile());
        setToPC(bookDetailInfo.getToPC());
        setHasBuy(canUseByBookInfo());
    }

    private boolean checkIsJumpFreePage(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        if (this.hasBuy) {
            return true;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.chapterId) && com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.pageId) && com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.taskId)) {
            return false;
        }
        com.up366.mobile.book.model.CatalogPage catalogPageFindJumpPage = findJumpPage(openConfigInfo);
        if (catalogPageFindJumpPage == null) {
            catalogPageFindJumpPage = findJumpChapter(openConfigInfo);
        }
        while (catalogPageFindJumpPage != null && catalogPageFindJumpPage.obj != null) {
            if (catalogPageFindJumpPage.obj.isFree()) {
                return true;
            }
            catalogPageFindJumpPage = catalogPageFindJumpPage.getpPage();
        }
        return false;
    }

    public com.up366.mobile.book.model.CatalogPage findJumpPage(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.up366.mobile.book.model.CatalogPage pageByTaskId;
        if (!com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.taskId) && (pageByTaskId = this.bookChapterInfo.getPageByTaskId(openConfigInfo.taskId)) != null) {
            openConfigInfo.pageId = pageByTaskId.obj.getId();
        }
        return this.bookChapterInfo.getPage(openConfigInfo.pageId);
    }

    public com.up366.mobile.book.model.CatalogChapter findJumpChapter(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        com.up366.mobile.book.model.CatalogPage pageByTaskId;
        if (!com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.taskId) && (pageByTaskId = this.bookChapterInfo.getPageByTaskId(openConfigInfo.taskId)) != null) {
            openConfigInfo.pageId = pageByTaskId.obj.getId();
        }
        com.up366.mobile.book.model.CatalogChapter chapter = this.bookChapterInfo.getChapter(openConfigInfo.chapterId);
        return (chapter == null && !com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.pageId) && getBookType() == 2) ? this.bookChapterInfo.getChapter(openConfigInfo.pageId) : chapter;
    }

    public boolean isShowNotBuyDialog(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        if (this.bookChapterInfo.getChapters().size() == 0) {
            return false;
        }
        boolean zCheckIsJumpFreePage = checkIsJumpFreePage(openConfigInfo);
        if (this.hasBuy || zCheckIsJumpFreePage) {
            return false;
        }
        return (com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.pageId) && com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.taskId)) ? false : true;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public void setBookChapterInfo(com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        this.bookChapterInfo = treeBookChapter;
    }

    public int getToPC() {
        return this.toPC;
    }

    public void setToPC(int i) {
        this.toPC = i;
    }

    public int getToMobile() {
        return this.toMobile;
    }

    public void setToMobile(int i) {
        this.toMobile = i;
    }

    public boolean toMobile() {
        return this.toMobile == 1;
    }

    public com.up366.mobile.book.model.TreeBookChapter getBookChapterInfo() {
        return this.bookChapterInfo;
    }

    public java.lang.String toString() {
        return "BookInfoStudy{bookId='" + this.bookId + "', bookName='" + this.bookName + "', courseId=" + this.courseId + ", picture='" + this.picture + "', bigPicture='" + this.bigPicture + "', fileId='" + this.fileId + "', isShelf=" + this.isShelf + ", isGoods=" + this.isGoods + ", bookType=" + this.bookType + ", packType=" + this.packType + ", categoryType=" + this.categoryType + ", addTime=" + this.addTime + ", endTime=" + this.endTime + ", startTime=" + this.startTime + ", stageId=" + this.stageId + ", subjectId=" + this.subjectId + ", hasBuy=" + this.hasBuy + ", percent=" + this.percent + ", productId=" + this.productId + ", price=" + this.price + ", validDays=" + this.validDays + ", toPC=" + this.toPC + ", toMobile=" + this.toMobile + ", forceReloadChapterData=" + this.forceReloadChapterData + ", jumpOpenChapter='" + this.jumpOpenChapter + "', jumpOpenPage='" + this.jumpOpenPage + "', jumpOpenTask='" + this.jumpOpenTask + "', jumpStudyTaskId='" + this.jumpStudyTaskId + "', jumpReTest='" + this.jumpReTest + "', jumpExtDailyDate='" + this.jumpExtDailyDate + "', jumpHistory=" + this.jumpFromTaskHistory + ", jumpXotParam='" + this.jumpXotParam + "', jumpExtFileIds='" + this.jumpExtFileIds + "', bookChapterInfo=" + this.bookChapterInfo + '}';
    }

    public void setForceReloadChapterData(boolean z) {
        this.forceReloadChapterData = z;
    }

    public boolean isForceReloadChapterData() {
        return this.forceReloadChapterData;
    }

    public void setJumpOpenChapter(java.lang.String str) {
        this.jumpOpenChapter = str;
    }

    public void setJumpOpenPage(java.lang.String str) {
        this.jumpOpenPage = str;
    }

    public void setJumpOpenTask(java.lang.String str) {
        this.jumpOpenTask = str;
    }

    public void setJumpStudyTaskId(java.lang.String str) {
        this.jumpStudyTaskId = str;
    }

    public void setJumpReTest(boolean z) {
        this.jumpReTest = z;
    }

    public void setJumpExtDailyDate(java.lang.String str) {
        this.jumpExtDailyDate = str;
    }

    public void setJumpFromTaskHistory(boolean z) {
        this.jumpFromTaskHistory = z;
    }

    public void setJumpXotParam(java.lang.String str) {
        this.jumpXotParam = str;
    }

    public void setJumpExtFileIds(java.util.List<com.up366.mobile.book.helper.Tools.PendingInfo> list) {
        this.jumpExtFileIds = com.alibaba.fastjson.JSON.toJSONString(list);
    }

    public void setJumpCommonParams(java.lang.String str) {
        this.jumpCommonParams = str;
    }

    public void setJumpBehavior(java.lang.String str) {
        this.jumpBehavior = str;
    }

    public java.lang.String getJumpBehavior() {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.jumpBehavior)) {
            return this.jumpBehavior;
        }
        java.lang.String fromJumpCommonParams = getFromJumpCommonParams();
        if (!com.up366.common.StringUtils.isEmptyOrNull(fromJumpCommonParams)) {
            return fromJumpCommonParams;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.jumpOpenTask)) {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, this.jumpOpenTask);
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.jumpStudyTaskId)) {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, this.jumpStudyTaskId);
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.bookId)) {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.bookId);
        }
        int i = this.courseId;
        if (i > 0) {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(i));
        }
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_REPORT, false);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_FINISH, java.lang.Boolean.valueOf(this.jumpFromTaskHistory));
        return jSONObject.toJSONString();
    }

    private java.lang.String getFromJumpCommonParams() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.jumpCommonParams)) {
            return null;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.jumpCommonParams);
            java.lang.String string = object.getString("scenario");
            if ("_SCHOOL_BOOK_PRACTICE_".equals(string) || "_STANDARD_BOOK_".equals(string)) {
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                if (com.up366.common.StringUtils.isEmptyOrNull(object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID))) {
                    jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID));
                }
                java.lang.String string2 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
                if (com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                    string2 = object.getString("chapterId");
                }
                if (!com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                    jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, string2);
                }
                int i = this.courseId;
                if (i > 0) {
                    jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(i));
                }
                jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_REPORT, false);
                jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_FINISH, java.lang.Boolean.valueOf(this.jumpFromTaskHistory));
                return jSONObject.toJSONString();
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - BookInfoStudy - getJumpBehavior - parse jumpCommonParams error: " + e.getMessage());
        }
        return null;
    }

    public void setUpJumpParams(com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        openConfigInfo.chapterId = this.jumpOpenChapter;
        openConfigInfo.pageId = this.jumpOpenPage;
        openConfigInfo.taskId = this.jumpOpenTask;
        openConfigInfo.studyTaskId = this.jumpStudyTaskId;
        openConfigInfo.reTest = this.jumpReTest;
        openConfigInfo.extDailyDate = this.jumpExtDailyDate;
        openConfigInfo.fromTaskHistory = this.jumpFromTaskHistory;
        openConfigInfo.xotParam = this.jumpXotParam;
        openConfigInfo.extFileIds = this.jumpExtFileIds;
        openConfigInfo.commonParams = this.jumpCommonParams;
        openConfigInfo.behavior = getJumpBehavior();
        this.jumpOpenChapter = null;
        this.jumpOpenPage = null;
        this.jumpOpenTask = null;
        this.jumpStudyTaskId = null;
        this.jumpReTest = false;
        this.jumpExtDailyDate = null;
        this.jumpFromTaskHistory = false;
        this.jumpXotParam = null;
        this.jumpExtFileIds = null;
        this.jumpCommonParams = null;
        this.jumpBehavior = null;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.up366.mobile.book.model.BookInfoStudy m466clone() {
        try {
            return (com.up366.mobile.book.model.BookInfoStudy) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.IllegalStateException(e);
        }
    }
}
