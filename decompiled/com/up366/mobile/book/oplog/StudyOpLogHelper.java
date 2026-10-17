package com.up366.mobile.book.oplog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyOpLogHelper {
    private static final java.lang.String PREFIX = "StudyOpLogHelper_";

    private static java.lang.String getLogKey(java.lang.String str) {
        return PREFIX + str;
    }

    public static void recordOpLog(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        try {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("studytaskid", str2);
            jSONObject.put("taskid", str3);
            jSONObject.put("bookid", str4);
            com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_TASK, com.up366.mobile.common.onlinelog.OpLogData.Control.STUDY_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.SUBMIT, jSONObject);
            com.up366.mobile.book.oplog.StudyOpLogHelper.LogEntry logEntry = new com.up366.mobile.book.oplog.StudyOpLogHelper.LogEntry(com.up366.mobile.common.onlinelog.OpLogData.Page.BOOK_TASK, com.up366.mobile.common.onlinelog.OpLogData.Control.STUDY_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.SUBMIT_OK, jSONObject.toJSONString());
            com.up366.common.log.Logger.info("TAG - StudyOpLogHelper - recordOpLog - entry:" + getLogKey(str) + "  : " + com.alibaba.fastjson.JSONObject.toJSONString(logEntry));
            com.up366.mobile.common.logic.Auth.cur().cache().put(getLogKey(str), com.alibaba.fastjson.JSONObject.toJSONString(logEntry));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - StudyOpLogHelper - recordOpLog - error", e);
        }
    }

    public static void recordOpLog(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("studytaskid", str2);
            jSONObject.put("courseid", str3);
            com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.SMART_PAPER, com.up366.mobile.common.onlinelog.OpLogData.Control.PHOTO_TASK, com.up366.mobile.common.onlinelog.OpLogData.Event.SUBMIT, jSONObject);
            com.up366.mobile.book.oplog.StudyOpLogHelper.LogEntry logEntry = new com.up366.mobile.book.oplog.StudyOpLogHelper.LogEntry(com.up366.mobile.common.onlinelog.OpLogData.Page.SMART_PAPER, com.up366.mobile.common.onlinelog.OpLogData.Control.PHOTO_TASK, com.up366.mobile.common.onlinelog.OpLogData.Event.SUBMIT_OK, jSONObject.toJSONString());
            com.up366.common.log.Logger.info("TAG - StudyOpLogHelper - recordBehavior - entry:" + com.alibaba.fastjson.JSONObject.toJSONString(logEntry));
            com.up366.mobile.common.logic.Auth.cur().cache().put(getLogKey(str), com.alibaba.fastjson.JSONObject.toJSONString(logEntry));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("recordBehavior error" + e.getMessage());
        }
    }

    public static void recordOpLogAfterUpload(java.lang.String str) {
        com.up366.mobile.book.oplog.StudyOpLogHelper.LogEntry logEntry;
        try {
            java.lang.String str2 = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadSync(getLogKey(str), java.lang.String.class);
            com.up366.common.log.Logger.info("TAG - StudyOpLogHelper - recordOpLogAfterUpload - :" + getLogKey(str) + ", logJson " + str2);
            if (com.up366.common.StringUtils.isEmptyOrNull(str2) || (logEntry = (com.up366.mobile.book.oplog.StudyOpLogHelper.LogEntry) com.alibaba.fastjson.JSONObject.parseObject(str2, com.up366.mobile.book.oplog.StudyOpLogHelper.LogEntry.class)) == null) {
                return;
            }
            com.up366.mobile.common.onlinelog.OpLog.report(logEntry.getPage(), logEntry.getControl(), logEntry.getEvent(), com.alibaba.fastjson.JSONObject.parseObject(logEntry.getExtra()));
            com.up366.mobile.common.logic.Auth.cur().cache().clear(getLogKey(str));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - StudyOpLogHelper - recordOpLogAfterUpload - error", e);
        }
    }

    private static final class LogEntry {
        private java.lang.String control;
        private java.lang.String event;
        private java.lang.String extra;
        private java.lang.String page;

        public LogEntry() {
        }

        public LogEntry(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.page = str;
            this.control = str2;
            this.event = str3;
            this.extra = str4;
        }

        public java.lang.String getPage() {
            return this.page;
        }

        public void setPage(java.lang.String str) {
            this.page = str;
        }

        public java.lang.String getControl() {
            return this.control;
        }

        public void setControl(java.lang.String str) {
            this.control = str;
        }

        public java.lang.String getEvent() {
            return this.event;
        }

        public void setEvent(java.lang.String str) {
            this.event = str;
        }

        public java.lang.String getExtra() {
            return this.extra;
        }

        public void setExtra(java.lang.String str) {
            this.extra = str;
        }
    }
}
