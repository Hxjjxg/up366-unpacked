package com.up366.mobile.jssdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageEvent2019RecordHelper {
    private int courseId;
    private boolean hasInit = false;
    private java.lang.String studyTaskId;

    public PageEvent2019RecordHelper(java.lang.String str) {
        java.lang.String query;
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        try {
            query = new java.net.URI(str).getQuery();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("PageEvent2019RecordHelper parse url error: " + str + e.getMessage());
            return;
        }
        if (query != null) {
            for (java.lang.String str2 : query.split("&")) {
                java.lang.String[] strArrSplit = str2.split("=", 2);
                if (strArrSplit.length == 2 && com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID.equals(strArrSplit[0])) {
                    this.studyTaskId = strArrSplit[1];
                    return;
                }
                if (strArrSplit.length == 2 && com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID.equals(strArrSplit[0])) {
                    try {
                        this.courseId = java.lang.Integer.parseInt(strArrSplit[1]);
                    } catch (java.lang.NumberFormatException unused) {
                        com.up366.common.log.Logger.error("PageEvent2019RecordHelper parse courseId error: " + strArrSplit[1]);
                    }
                }
                com.up366.common.log.Logger.error("PageEvent2019RecordHelper parse url error: " + str + e.getMessage());
                return;
            }
        }
    }

    public void onStart() {
        java.lang.String str;
        if (com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId)) {
            return;
        }
        com.alibaba.fastjson.JSONObject extData = getExtData();
        if (this.hasInit) {
            str = com.up366.mobile.common.onlinelog.OpLogData.Event.RESUME_PAGE;
        } else {
            this.hasInit = true;
            str = com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE;
        }
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.TASK_REPORT, com.up366.mobile.common.onlinelog.OpLogData.Control.REPORT_PAGE, str, extData);
    }

    public void onStop() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId)) {
            return;
        }
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.TASK_REPORT, com.up366.mobile.common.onlinelog.OpLogData.Control.REPORT_PAGE, com.up366.mobile.common.onlinelog.OpLogData.Event.LEAVE_PAGE, getExtData());
    }

    private com.alibaba.fastjson.JSONObject getExtData() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId)) {
            jSONObject.put("studytaskid", this.studyTaskId);
        }
        int i = this.courseId;
        if (i > 0) {
            jSONObject.put("courseid", java.lang.Integer.valueOf(i));
        }
        return jSONObject;
    }
}
