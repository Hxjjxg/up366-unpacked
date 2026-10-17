package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongNoteRankCourseListRefresh {
    private final com.up366.common.http.Response resp;
    private final java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> wrongNoteCourseList;

    public WrongNoteRankCourseListRefresh(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> list) {
        this.resp = response;
        this.wrongNoteCourseList = list;
    }

    public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> getWrongNoteCourseList() {
        return this.wrongNoteCourseList;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }
}
