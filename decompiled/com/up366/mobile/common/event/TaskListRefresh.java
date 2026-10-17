package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskListRefresh {
    private boolean fetchData = true;
    private com.up366.common.http.Response resp;
    private int status;
    private java.util.List<com.up366.mobile.course.task.TaskInfoV2> taskInfoV2s;

    public TaskListRefresh(int i) {
        this.status = i;
    }

    public TaskListRefresh(int i, java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, com.up366.common.http.Response response) {
        this.status = i;
        this.taskInfoV2s = list;
        this.resp = response;
    }

    public java.util.List<com.up366.mobile.course.task.TaskInfoV2> getTaskInfoV2s() {
        return this.taskInfoV2s;
    }

    public com.up366.common.http.Response getResp() {
        return this.resp;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isCurrent() {
        return this.status == 1;
    }

    public boolean isFetchData() {
        return this.fetchData;
    }
}
