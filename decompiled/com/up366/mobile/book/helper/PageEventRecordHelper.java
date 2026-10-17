package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PageEventRecordHelper {
    private final com.up366.mobile.book.model.BookInfoStudy book;
    private final com.up366.mobile.book.model.OpenConfigInfo cfg;
    private java.lang.String control;
    private final com.alibaba.fastjson.JSONObject extData = new com.alibaba.fastjson.JSONObject();
    private java.lang.String page;

    public PageEventRecordHelper(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        this.book = bookInfoStudy;
        this.cfg = openConfigInfo;
        initDataByBehavior();
    }

    private void initDataByBehavior() {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy;
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.cfg;
        if (openConfigInfo == null || openConfigInfo.isDict()) {
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(this.cfg.behavior)) {
            com.up366.common.log.Logger.error("PageEventRecordHelper initExtData behavior is null or empty: " + this.cfg.behavior);
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(this.cfg.behavior);
            if (object == null) {
                return;
            }
            boolean booleanValue = object.getBooleanValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_REPORT);
            boolean booleanValue2 = object.getBooleanValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.IS_FINISH);
            java.lang.String string = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
            java.lang.String string2 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
            int intValue = object.getIntValue(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID);
            java.lang.String string3 = object.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
            if (com.up366.common.StringUtils.isEmptyOrNull(string3) && (bookInfoStudy = this.book) != null) {
                string3 = bookInfoStudy.getBookId();
            }
            this.page = findPage(string, string2, booleanValue);
            this.control = findControl(string, string2, booleanValue, booleanValue2);
            if (!com.up366.common.StringUtils.isEmptyOrNull(string)) {
                this.extData.put("taskid", string);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                this.extData.put("studytaskid", string2);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(string3)) {
                this.extData.put("bookid", string3);
            }
            if (intValue > 0) {
                this.extData.put("courseid", java.lang.Integer.valueOf(intValue));
            }
            java.lang.String strConvertPackType = convertPackType(this.book);
            if (com.up366.common.StringUtils.isEmptyOrNull(strConvertPackType)) {
                return;
            }
            this.extData.put("jssdk", strConvertPackType);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("PageEventRecordHelper getExtData error: " + e.getMessage() + this.cfg.behavior);
        }
    }

    private boolean isNotNeedRecord() {
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.cfg;
        return openConfigInfo == null || openConfigInfo.isDict() || this.page == null;
    }

    public void onEnter() {
        if (isNotNeedRecord()) {
            com.up366.common.log.Logger.error("PageEventRecordHelper onExit isNotNeedRecord");
        } else {
            com.up366.mobile.common.onlinelog.OpLog.report(this.page, this.control, com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE, this.extData);
        }
    }

    public void onStart() {
        if (isNotNeedRecord()) {
            com.up366.common.log.Logger.error("PageEventRecordHelper onExit isNotNeedRecord");
        } else {
            com.up366.mobile.common.onlinelog.OpLog.report(this.page, this.control, com.up366.mobile.common.onlinelog.OpLogData.Event.RESUME_PAGE, this.extData);
        }
    }

    public void onStop(long j, long j2) {
        if (isNotNeedRecord()) {
            return;
        }
        if (j2 < 0 || j2 > 18000000) {
            com.up366.common.log.Logger.error("PageEventRecordHelper onStop duration is invalid: " + j2 + ", startEnterTime: " + j);
            return;
        }
        this.extData.put("duration", java.lang.Long.valueOf(j2));
        this.extData.put("entertime", java.lang.Long.valueOf(j));
        com.up366.mobile.common.onlinelog.OpLog.report(this.page, this.control, com.up366.mobile.common.onlinelog.OpLogData.Event.PAUSE_PAGE, this.extData);
    }

    public void onExit(long j, long j2) {
        if (isNotNeedRecord()) {
            com.up366.common.log.Logger.error("PageEventRecordHelper onExit isNotNeedRecord");
            return;
        }
        if (j2 < 0 || j2 > 18000000) {
            com.up366.common.log.Logger.error("PageEventRecordHelper onExit duration is invalid: " + j2 + ", startEnterTime: " + j);
            return;
        }
        this.extData.put("duration", java.lang.Long.valueOf(j2));
        this.extData.put("entertime", java.lang.Long.valueOf(j));
        com.up366.mobile.common.onlinelog.OpLog.report(this.page, this.control, com.up366.mobile.common.onlinelog.OpLogData.Event.LEAVE_PAGE, this.extData);
    }

    private java.lang.String findControl(java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        if (z) {
            return com.up366.mobile.common.onlinelog.OpLogData.Control.REPORT_PAGE;
        }
        if (z2) {
            return com.up366.mobile.common.onlinelog.OpLogData.Control.REVIEW_PAGE;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str) && com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return com.up366.mobile.common.onlinelog.OpLogData.Control.CATALOG_PAGE;
        }
        return com.up366.mobile.common.onlinelog.OpLogData.Control.STUDY_PAGE;
    }

    private java.lang.String findPage(java.lang.String str, java.lang.String str2, boolean z) {
        if (z) {
            return com.up366.mobile.common.onlinelog.OpLogData.Page.TASK_REPORT;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str) && com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_HOME;
        }
        return com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_TASK;
    }

    private java.lang.String convertPackType(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        com.up366.mobile.book.model.BookDetailInfo bookDetailInfoLoadBookDetailInfo;
        if (bookInfoStudy == null) {
            return "";
        }
        int packType = bookInfoStudy.getPackType();
        if (packType == 0 && (bookDetailInfoLoadBookDetailInfo = com.up366.mobile.common.logic.Auth.cur().book().loadBookDetailInfo(bookInfoStudy.getBookId())) != null) {
            packType = bookDetailInfoLoadBookDetailInfo.getPackType();
        }
        if (packType <= 6) {
            return "2016";
        }
        if (packType == 7) {
            return "2019";
        }
        if (packType == 8) {
            return "2023";
        }
        if (packType == 9) {
            return "2025";
        }
        return packType + "";
    }
}
