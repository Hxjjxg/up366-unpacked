package com.up366.common.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskUtils {
    private static final com.up366.common.task.MainThreadTaskExecutor gMainThreadTaskExecutor = new com.up366.common.task.MainThreadTaskExecutor();
    private static final com.up366.common.task.ConcurrentTaskExecutor gConcurrentTaskExecutor = new com.up366.common.task.ConcurrentTaskExecutor("GlobalConcurrent");
    private static android.os.Handler lazyHandler = null;
    private static final java.util.concurrent.ConcurrentMap<java.lang.Object, com.up366.common.task.TaskWrapper> map = new java.util.concurrent.ConcurrentHashMap();

    static {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.up366.common.task.TaskUtils.1
            @Override // java.lang.Runnable
            public void run() {
                android.os.Looper.prepare();
                com.up366.common.task.TaskUtils.lazyHandler = new android.os.Handler(android.os.Looper.myLooper());
                android.os.Looper.loop();
            }
        }).start();
    }

    public static com.up366.common.task.TaskExecutor createSerialExecutor(java.lang.String str) {
        return new com.up366.common.task.SerialTaskExecutor(str);
    }

    public static boolean isMainThread() {
        return java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread();
    }

    public static void postMainTask(com.up366.common.task.Task task) {
        gMainThreadTaskExecutor.post(task);
    }

    public static void postMainTaskWithStackRecord(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task) {
        gMainThreadTaskExecutor.post(stackRecordException, task);
    }

    public static void postMainTaskDelay(long j, com.up366.common.task.Task task) {
        gMainThreadTaskExecutor.postDelayed(task, j);
    }

    public static void postGlobalTask(com.up366.common.task.Task task) {
        gConcurrentTaskExecutor.post(task);
    }

    public static void postGlobalTaskWithStackRecord(com.up366.common.task.StackRecordException stackRecordException, com.up366.common.task.Task task) {
        gConcurrentTaskExecutor.post(stackRecordException, task);
    }

    public static void postLazyTaskMain(java.lang.Object obj, com.up366.common.task.Task task) {
        postLazyTaskMain(obj, 300, task);
    }

    public static void postLazyTaskMain(final java.lang.Object obj, int i, final com.up366.common.task.Task task) {
        java.util.concurrent.ConcurrentMap<java.lang.Object, com.up366.common.task.TaskWrapper> concurrentMap = map;
        com.up366.common.task.TaskWrapper taskWrapperRemove = concurrentMap.remove(obj);
        if (taskWrapperRemove != null) {
            getLazyHandler().removeCallbacks(taskWrapperRemove);
        }
        if (task == null) {
            return;
        }
        final com.up366.common.task.StackRecordException stackRecordException = new com.up366.common.task.StackRecordException();
        com.up366.common.task.TaskWrapper taskWrapper = new com.up366.common.task.TaskWrapper(stackRecordException, new com.up366.common.task.Task() { // from class: com.up366.common.task.TaskUtils.2
            @Override // com.up366.common.task.Task
            public void run() {
                com.up366.common.task.TaskUtils.map.remove(obj, taskWrapperArr[0]);
                com.up366.common.task.TaskUtils.gMainThreadTaskExecutor.post(stackRecordException, task);
            }
        });
        final com.up366.common.task.TaskWrapper[] taskWrapperArr = {taskWrapper};
        concurrentMap.put(obj, taskWrapper);
        getLazyHandler().postDelayed(taskWrapper, i);
    }

    public static void postLazyTaskGlobal(java.lang.Object obj, com.up366.common.task.Task task) {
        postLazyTaskGlobal(obj, 300, task);
    }

    public static void postLazyTaskGlobal(final java.lang.Object obj, int i, final com.up366.common.task.Task task) {
        java.util.concurrent.ConcurrentMap<java.lang.Object, com.up366.common.task.TaskWrapper> concurrentMap = map;
        com.up366.common.task.TaskWrapper taskWrapperRemove = concurrentMap.remove(obj);
        if (taskWrapperRemove != null) {
            getLazyHandler().removeCallbacks(taskWrapperRemove);
        }
        if (task == null) {
            return;
        }
        final com.up366.common.task.StackRecordException stackRecordException = new com.up366.common.task.StackRecordException();
        com.up366.common.task.TaskWrapper taskWrapper = new com.up366.common.task.TaskWrapper(stackRecordException, new com.up366.common.task.Task() { // from class: com.up366.common.task.TaskUtils.3
            @Override // com.up366.common.task.Task
            public void run() {
                com.up366.common.task.TaskUtils.map.remove(obj, taskWrapperArr[0]);
                com.up366.common.task.TaskUtils.gConcurrentTaskExecutor.post(stackRecordException, task);
            }
        });
        final com.up366.common.task.TaskWrapper[] taskWrapperArr = {taskWrapper};
        concurrentMap.put(obj, taskWrapper);
        getLazyHandler().postDelayed(taskWrapper, i);
    }

    private static android.os.Handler getLazyHandler() {
        android.os.Handler handler = lazyHandler;
        return handler == null ? new android.os.Handler(android.os.Looper.getMainLooper()) : handler;
    }

    @java.lang.Deprecated
    public static void postGlobleTask(com.up366.common.task.Task task) {
        postGlobalTask(task);
    }

    @java.lang.Deprecated
    public static void postLazyTaskGloble(java.lang.Object obj, int i, com.up366.common.task.Task task) {
        postLazyTaskGlobal(obj, i, task);
    }

    @java.lang.Deprecated
    public static void postLazyTaskGloble(java.lang.Object obj, com.up366.common.task.Task task) {
        postLazyTaskGlobal(obj, task);
    }
}
