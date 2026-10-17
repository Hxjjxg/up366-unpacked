package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MyBookListEvent {
    public final java.util.List<com.up366.mobile.common.logic.model.MyBook> books;
    public final java.util.List<com.up366.mobile.course.mgr.CourseInfo> courseInfoS;
    public final com.up366.common.http.Response resp;

    public MyBookListEvent(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.MyBook> list, java.util.List<com.up366.mobile.course.mgr.CourseInfo> list2) {
        this.resp = response;
        this.books = list;
        this.courseInfoS = list2;
    }

    public MyBookListEvent(java.util.List<com.up366.mobile.common.logic.model.MyBook> list, java.util.List<com.up366.mobile.course.mgr.CourseInfo> list2) {
        this.resp = null;
        this.books = list;
        this.courseInfoS = list2;
    }
}
