package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CountHelper {
    public static void count(final android.content.Context context) {
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("logfile-size-counter", 10000, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.compat.CountHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.compat.CountHelper.lambda$count$0(context);
            }
        });
    }

    static /* synthetic */ void lambda$count$0(android.content.Context context) throws java.lang.Exception {
        java.lang.String logPath = com.up366.mobile.common.utils.AppFileUtils.getLogPath();
        if (com.up366.common.FileUtilsUp.isFileExists(logPath)) {
            if (!com.up366.common.FileUtilsUp.isDir(logPath)) {
                com.up366.mobile.common.onlinelog.OpLog.report("logfile-size-counter-dir-type-error", logPath);
                return;
            }
            java.io.File[] fileArrListFiles = new java.io.File(logPath).listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            long length = 0;
            int i = 0;
            for (java.io.File file : fileArrListFiles) {
                if (com.up366.common.FileUtilsUp.isFile(file.getAbsolutePath())) {
                    i++;
                    length += file.length();
                }
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("日志文件大小 size = ");
            sb.append(length);
            sb.append("  filesize:");
            long j = i;
            sb.append(com.up366.common.ByteUtilsUp.bytesToMKB(j));
            com.up366.mobile.common.onlinelog.OpLog.record("appStartModelInfo", sb.toString());
            com.up366.common.log.Logger.info("CountLogFileSize - count - size = " + length + "  filesize:" + com.up366.common.ByteUtilsUp.bytesToMKB(j));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("设备存储空间 : ");
            sb2.append(com.up366.mobile.common.utils.AppFileUtils.getStorageSizeString(context));
            com.up366.mobile.common.onlinelog.OpLog.report("appStartModelInfo", sb2.toString());
        }
    }
}
