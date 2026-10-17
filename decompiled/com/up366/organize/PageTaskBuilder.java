package com.up366.organize;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageTaskBuilder {
    private java.util.concurrent.atomic.AtomicInteger taskIdCreator = new java.util.concurrent.atomic.AtomicInteger();

    protected PageTaskBuilder() {
    }

    public com.up366.organize.PageTask createTask(java.lang.String str, int i) {
        return createTask(str, i, str, 0);
    }

    public com.up366.organize.PageTask createTask(java.lang.String str, int i, java.lang.String str2, int i2) {
        com.up366.organize.PageTask pageTask = new com.up366.organize.PageTask();
        pageTask.setTaskId(this.taskIdCreator.incrementAndGet());
        pageTask.setState(0);
        pageTask.setLevel(i);
        pageTask.setName(str);
        pageTask.setGroup(str2);
        pageTask.setGroupLevel(i2);
        return pageTask;
    }
}
