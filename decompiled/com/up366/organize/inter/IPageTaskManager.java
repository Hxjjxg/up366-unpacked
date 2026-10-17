package com.up366.organize.inter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface IPageTaskManager {
    com.up366.organize.inter.IPageTaskManager addPageTaskAllRunListener(com.up366.organize.inter.PageTaskAllRunListener pageTaskAllRunListener);

    com.up366.organize.inter.IPageTaskManager addPageTaskRunListener(int i, com.up366.organize.inter.PageTaskRunListener pageTaskRunListener);

    com.up366.organize.inter.IPageTaskManager addTask(com.up366.organize.PageTask pageTask);

    void cancel(java.lang.String str);

    void finished(java.lang.String str);

    void ready(java.lang.String str);

    void reset();

    void reset(java.lang.String str);

    void startRun(java.lang.String str);

    void wait(java.lang.String str);

    void wakeUpStart();
}
