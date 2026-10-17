package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MemoryLeaksCheckTool {
    private static final long WATCH_DELAY_MS = 30000;
    private static final java.util.List<com.up366.mobile.common.utils.MemoryLeaksCheckTool.WatchTarget> array = new java.util.ArrayList();
    private static boolean hasStart = false;

    /* JADX INFO: Access modifiers changed from: private */
    static final class WatchTarget {
        private boolean hasReported;
        private final java.lang.ref.WeakReference<java.lang.Object> reference;
        private final long watchAt;

        private WatchTarget(java.lang.Object obj) {
            this.reference = new java.lang.ref.WeakReference<>(obj);
            this.watchAt = android.os.SystemClock.uptimeMillis();
        }
    }

    public static void watch(java.lang.Object obj) {
        if (obj == null) {
            return;
        }
        java.util.List<com.up366.mobile.common.utils.MemoryLeaksCheckTool.WatchTarget> list = array;
        synchronized (list) {
            list.add(new com.up366.mobile.common.utils.MemoryLeaksCheckTool.WatchTarget(obj));
        }
        if (hasStart) {
            return;
        }
        hasStart = true;
        loopCheck();
    }

    private static void loopCheck() {
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("MemoryLeaksCheckTool", 30000, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MemoryLeaksCheckTool$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.utils.MemoryLeaksCheckTool.lambda$loopCheck$0();
            }
        });
    }

    static /* synthetic */ void lambda$loopCheck$0() throws java.lang.Exception {
        java.lang.System.gc();
        java.lang.System.runFinalization();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        java.util.List<com.up366.mobile.common.utils.MemoryLeaksCheckTool.WatchTarget> list = array;
        synchronized (list) {
            java.util.Iterator<com.up366.mobile.common.utils.MemoryLeaksCheckTool.WatchTarget> it = list.iterator();
            while (it.hasNext()) {
                com.up366.mobile.common.utils.MemoryLeaksCheckTool.WatchTarget next = it.next();
                java.lang.Object obj = next.reference.get();
                if (obj == null) {
                    it.remove();
                } else if (jUptimeMillis - next.watchAt >= 30000 && !next.hasReported) {
                    if (obj instanceof android.app.Activity) {
                        android.app.Activity activity = (android.app.Activity) obj;
                        if (activity.isFinishing() || activity.isDestroyed()) {
                            arrayList.add(activity);
                            next.hasReported = true;
                        }
                    } else {
                        arrayList.add(obj);
                        next.hasReported = true;
                    }
                }
            }
        }
        for (java.lang.Object obj2 : arrayList) {
            if (obj2 instanceof android.app.Activity) {
                com.up366.common.log.Logger.error("TAG - MemoryLeaksCheckTool - leaks Activity - " + obj2);
            } else {
                com.up366.common.log.Logger.error("TAG - MemoryLeaksCheckTool - leaks Object - " + obj2);
            }
        }
        loopCheck();
    }
}
