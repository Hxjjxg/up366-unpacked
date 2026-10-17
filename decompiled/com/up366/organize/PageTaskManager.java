package com.up366.organize;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageTaskManager implements com.up366.organize.inter.IPageTaskManager {
    private static com.up366.organize.PageTaskManager manager = new com.up366.organize.PageTaskManager();
    private java.util.List<com.up366.organize.PageTask> pageTasks = new java.util.LinkedList();
    private java.util.List<com.up366.organize.PageTask> finishedPageTasks = new java.util.LinkedList();
    private com.up366.organize.PageTaskBuilder builder = new com.up366.organize.PageTaskBuilder();
    private android.util.SparseArray<com.up366.organize.inter.PageTaskRunListener> listeners = new android.util.SparseArray<>();
    private java.util.Set<com.up366.organize.inter.PageTaskAllRunListener> allListeners = new java.util.LinkedHashSet();

    static /* synthetic */ void lambda$notifyListener$1() {
    }

    private PageTaskManager() {
    }

    public static com.up366.organize.PageTaskManager getInst() {
        return manager;
    }

    public static com.up366.organize.PageTaskBuilder getBuilder() {
        return manager.builder;
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void reset() {
        this.pageTasks.clear();
        this.finishedPageTasks.clear();
        this.listeners.clear();
        this.allListeners.clear();
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void reset(java.lang.String str) {
        if (str == null) {
            return;
        }
        com.up366.common.log.Logger.info("PageTaskManager - reset task: " + str);
        com.up366.organize.PageTask task = getTask(str);
        if (task != null) {
            this.pageTasks.remove(task);
            this.listeners.remove(task.getTaskId());
        }
        java.util.Iterator<com.up366.organize.PageTask> it = this.finishedPageTasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (str.equals(it.next().getName())) {
                it.remove();
                break;
            }
        }
        com.up366.common.log.Logger.info("PageTaskManager - reset completed, current tasks: " + this.pageTasks.size() + ", finished: " + this.finishedPageTasks.size());
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void startRun(java.lang.String str) {
        changeStage(str, 3);
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void wait(java.lang.String str) {
        changeStage(str, 0);
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void ready(java.lang.String str) {
        changeStage(str, 1);
        wakeUpStart();
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void finished(java.lang.String str) {
        changeStage(str, 4);
        wakeUpStart();
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void cancel(java.lang.String str) {
        changeStage(str, 5);
        com.up366.organize.PageTask task = getTask(str);
        if (task == null) {
            return;
        }
        this.pageTasks.remove(task);
        this.finishedPageTasks.add(task);
        wakeUpStart();
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public com.up366.organize.inter.IPageTaskManager addTask(com.up366.organize.PageTask pageTask) {
        if (hasFinished(pageTask.getName())) {
            com.up366.common.log.Logger.info(pageTask + " has finished ");
            return this;
        }
        if (hasAddWaiter(pageTask.getName())) {
            com.up366.common.log.Logger.info(pageTask + " has areadly in waitting queue ");
            return this;
        }
        this.pageTasks.add(pageTask);
        java.util.Collections.sort(this.pageTasks, new java.util.Comparator() { // from class: com.up366.organize.PageTaskManager$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.organize.PageTaskManager.lambda$addTask$0((com.up366.organize.PageTask) obj, (com.up366.organize.PageTask) obj2);
            }
        });
        return this;
    }

    static /* synthetic */ int lambda$addTask$0(com.up366.organize.PageTask pageTask, com.up366.organize.PageTask pageTask2) {
        int iCompare = java.lang.Integer.compare(pageTask2.getLevel(), pageTask.getLevel());
        return iCompare == 0 ? java.lang.Integer.compare(pageTask2.getGroupLevel(), pageTask.getGroupLevel()) : iCompare;
    }

    private boolean hasAddWaiter(java.lang.String str) {
        return getTask(str) != null;
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public com.up366.organize.inter.IPageTaskManager addPageTaskRunListener(int i, com.up366.organize.inter.PageTaskRunListener pageTaskRunListener) {
        this.listeners.put(i, pageTaskRunListener);
        return this;
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public com.up366.organize.inter.IPageTaskManager addPageTaskAllRunListener(com.up366.organize.inter.PageTaskAllRunListener pageTaskAllRunListener) {
        this.allListeners.add(pageTaskAllRunListener);
        return this;
    }

    @Override // com.up366.organize.inter.IPageTaskManager
    public void wakeUpStart() {
        com.up366.organize.PageTask pageTaskLoadNeedRunTask = loadNeedRunTask();
        if (pageTaskLoadNeedRunTask == null) {
            this.finishedPageTasks.clear();
            return;
        }
        if (pageTaskLoadNeedRunTask.isReady()) {
            changeStage(pageTaskLoadNeedRunTask.getName(), 2);
            com.up366.common.log.Logger.info("PageTaskManager " + pageTaskLoadNeedRunTask.getName() + " pageTask waitRunning ");
            notifyListener(pageTaskLoadNeedRunTask);
            return;
        }
        if (pageTaskLoadNeedRunTask.isWaitRunning()) {
            startRun(pageTaskLoadNeedRunTask.getName());
            notifyListener(pageTaskLoadNeedRunTask);
        }
    }

    private void notifyListener(com.up366.organize.PageTask pageTask) {
        this.listeners.get(pageTask.getTaskId(), new com.up366.organize.inter.PageTaskRunListener() { // from class: com.up366.organize.PageTaskManager$$ExternalSyntheticLambda1
            @Override // com.up366.organize.inter.PageTaskRunListener
            public final void onWaitRunning() {
                com.up366.organize.PageTaskManager.lambda$notifyListener$1();
            }
        }).onWaitRunning();
        java.util.Iterator<com.up366.organize.inter.PageTaskAllRunListener> it = this.allListeners.iterator();
        while (it.hasNext()) {
            it.next().onWaitRunning(pageTask);
        }
    }

    private void changeStage(java.lang.String str, int i) {
        com.up366.organize.PageTask task = getTask(str);
        if (task == null) {
            com.up366.common.log.Logger.error("changeStage error no key :" + str);
        } else {
            com.up366.common.log.Logger.info("PageTaskManager " + str + " is  " + i);
            task.setState(i);
        }
    }

    private com.up366.organize.PageTask loadNeedRunTask() {
        if (this.pageTasks.isEmpty()) {
            com.up366.common.log.Logger.info("wakeUpStart no pageTask");
            return null;
        }
        com.up366.organize.PageTask pageTask = this.pageTasks.get(0);
        if (pageTask.isRunning()) {
            return null;
        }
        removeFinished(pageTask);
        if (this.pageTasks.isEmpty()) {
            com.up366.common.log.Logger.info("wakeUpStart has clear pageTask");
            return null;
        }
        com.up366.organize.PageTask pageTask2 = this.pageTasks.get(0);
        if (pageTask2.isRunning()) {
            return null;
        }
        return pageTask2;
    }

    private void removeFinished(com.up366.organize.PageTask pageTask) {
        if (pageTask.isFinished()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.up366.organize.PageTask pageTask2 : this.pageTasks) {
                if (pageTask2.getGroup().equals(pageTask.getGroup())) {
                    arrayList.add(pageTask2);
                }
            }
            this.pageTasks.removeAll(arrayList);
            this.finishedPageTasks.addAll(arrayList);
        }
    }

    private com.up366.organize.PageTask getTask(java.lang.String str) {
        for (com.up366.organize.PageTask pageTask : this.pageTasks) {
            if (pageTask.getName().equals(str)) {
                return pageTask;
            }
        }
        return null;
    }

    private boolean hasFinished(java.lang.String str) {
        java.util.Iterator<com.up366.organize.PageTask> it = this.finishedPageTasks.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
