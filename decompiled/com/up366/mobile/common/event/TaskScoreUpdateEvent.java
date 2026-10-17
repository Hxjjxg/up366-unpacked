package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskScoreUpdateEvent {
    java.lang.String chapterId;
    int percent;
    float score;
    java.lang.String taskId;

    public TaskScoreUpdateEvent(java.lang.String str, java.lang.String str2, float f, int i) {
        this.chapterId = str;
        this.taskId = str2;
        this.score = f;
        this.percent = i;
    }

    public java.lang.String getChapterId() {
        return this.chapterId;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public float getScore() {
        return this.score;
    }

    public int getPercent() {
        return this.percent;
    }
}
