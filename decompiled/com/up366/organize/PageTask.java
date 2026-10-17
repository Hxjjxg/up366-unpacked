package com.up366.organize;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageTask {
    protected static final int CANCELED = 5;
    protected static final int FINISHED = 4;
    protected static final int READY = 1;
    protected static final int RUNNING = 3;
    protected static final int WAITING = 0;
    protected static final int WAITING_RUN = 2;
    private java.lang.String group;
    private int groupLevel;
    private int level;
    private java.lang.String name;
    private int state = 0;
    private int taskId;

    protected PageTask() {
    }

    public int getState() {
        return this.state;
    }

    protected void setState(int i) {
        this.state = i;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public java.lang.String getGroup() {
        return this.group;
    }

    public void setGroup(java.lang.String str) {
        this.group = str;
    }

    public int getGroupLevel() {
        return this.groupLevel;
    }

    public void setGroupLevel(int i) {
        this.groupLevel = i;
    }

    public boolean isRunning() {
        return this.state == 3;
    }

    public boolean isFinished() {
        return this.state == 4;
    }

    protected boolean isReady() {
        return this.state == 1;
    }

    public boolean isWaitRunning() {
        return this.state == 2;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public java.lang.String toString() {
        return "PageTask{state=" + this.state + ", name='" + this.name + "', level=" + this.level + ", group='" + this.group + "', groupLevel=" + this.groupLevel + ", taskId=" + this.taskId + '}';
    }
}
