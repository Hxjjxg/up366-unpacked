package com.up366.mobile.course.p1p.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class RecursiveFileCleanupHelper {
    private final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("RecursiveFileCleanupUtils");

    public void cleanupInBack(final java.lang.String str, final int i) {
        this.executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.p1p.helper.RecursiveFileCleanupHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$cleanupInBack$0(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: cleanup, reason: merged with bridge method [inline-methods] */
    public void lambda$cleanupInBack$0(java.lang.String str, int i) {
        java.io.File[] fileArrListFiles;
        java.io.File file = new java.io.File(str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    lambda$cleanupInBack$0(file2.getAbsolutePath(), i);
                } else if ((com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - file2.lastModified()) / 86400000 > i) {
                    file2.delete();
                    com.up366.common.log.Logger.info("delete file: " + file2.getAbsolutePath());
                }
            }
            java.io.File[] fileArrListFiles2 = file.listFiles();
            if (fileArrListFiles2 != null && fileArrListFiles2.length == 0) {
                file.delete();
            }
        }
    }
}
