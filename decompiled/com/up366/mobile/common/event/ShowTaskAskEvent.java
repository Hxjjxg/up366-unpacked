package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShowTaskAskEvent {
    private java.util.List<com.up366.mobile.course.task.TaskInfoV2> taskInfoV2s;

    public ShowTaskAskEvent() {
    }

    public ShowTaskAskEvent(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        this.taskInfoV2s = list;
    }

    public java.util.List<com.up366.mobile.course.task.TaskInfoV2> getTaskInfoV2s() {
        return this.taskInfoV2s;
    }

    public void setTaskInfoV2s(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        this.taskInfoV2s = list;
    }
}
