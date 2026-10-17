package com.up366.smartscan2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class SmartScan2ConfigHelper {
    private static final int ASSETS_VERSION_NO = 35;
    private static final java.lang.String BACKUP_DIR_NAME = "smart_scan2_config.backup";
    private static final int BUFFER_SIZE = 65536;
    private static final java.lang.String CONFIG_DIR_NAME = "smart_scan2_config";
    private static final java.lang.String LOCK_FILE_NAME = "smart_scan2_config.prepare.lock";
    private static final int MAX_ENTRY_COUNT = 256;
    private static final long MAX_EXTRACTED_BYTES = 536870912;
    private static final long MIN_USABLE_SPACE_BYTES = 268435456;
    private static final java.lang.String MODEL_KEY = "###UP366-P1P-MODEL";
    private static final java.lang.Object MODEL_LOCK = new java.lang.Object();
    private static final java.lang.String MODEL_NAME = "p1pmodel2.zip";
    private static final java.lang.String STAGING_DIR_NAME = "smart_scan2_config.preparing";
    private static final java.lang.String TAG = "SmartScan2ConfigHelper";

    private SmartScan2ConfigHelper() {
    }

    public static java.lang.String getConfigFileDirPath(android.content.Context context) {
        return new java.io.File(context.getFilesDir(), CONFIG_DIR_NAME).getAbsolutePath() + java.io.File.separator;
    }

    public static void initConfigFile(android.content.Context context) {
        prepareModel(context);
    }

    public static boolean prepareModel(android.content.Context context) {
        boolean zPrepareModelLocked;
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        synchronized (MODEL_LOCK) {
            try {
                java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(new java.io.File(context.getFilesDir(), LOCK_FILE_NAME), "rw");
                try {
                    java.nio.channels.FileChannel channel = randomAccessFile.getChannel();
                    try {
                        java.nio.channels.FileLock fileLockLock = channel.lock();
                        try {
                            zPrepareModelLocked = prepareModelLocked(context);
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            randomAccessFile.close();
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (java.lang.Throwable th) {
                com.up366.common.log.Logger.error("SmartScan2ConfigHelper prepareModel lock failed", th);
                return getLocalVersionNo(context) >= 35;
            }
        }
        return zPrepareModelLocked;
    }

    private static boolean prepareModelLocked(android.content.Context context) {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        java.io.File filesDir = context.getFilesDir();
        java.io.File file = new java.io.File(filesDir, CONFIG_DIR_NAME);
        java.io.File file2 = new java.io.File(filesDir, STAGING_DIR_NAME);
        java.io.File file3 = new java.io.File(filesDir, BACKUP_DIR_NAME);
        recoverInterruptedSwap(file, file2, file3);
        if (readVersion(file) >= 35) {
            deleteQuietly(file2);
            deleteQuietly(file3);
            return true;
        }
        int version = readVersion(file);
        long usableSpace = filesDir.getUsableSpace();
        if (usableSpace < MIN_USABLE_SPACE_BYTES) {
            com.up366.common.log.Logger.warn("SmartScan2ConfigHelper insufficient storage, usable:" + usableSpace + " oldVersion:" + version);
            return false;
        }
        deleteQuietly(file2);
        if (!file2.mkdirs() && !file2.isDirectory()) {
            com.up366.common.log.Logger.error("SmartScan2ConfigHelper cannot create staging directory:" + file2);
            return false;
        }
        try {
            com.up366.smartscan2.SmartScan2ConfigHelper.ExtractResult extractResultExtractAsset = extractAsset(context, file2);
            if (extractResultExtractAsset.entryCount <= 0 || !new java.io.File(file2, "config.ini").isFile()) {
                throw new java.io.IOException("model archive is incomplete");
            }
            writeVersionMarker(file2);
            if (readVersion(file2) != 35) {
                throw new java.io.IOException("model version marker validation failed");
            }
            if (!swapDirectories(file, file2, file3)) {
                throw new java.io.IOException("cannot commit prepared model");
            }
            com.up366.common.log.Logger.info("SmartScan2ConfigHelper prepare success oldVersion:" + version + " newVersion:35 entries:" + extractResultExtractAsset.entryCount + " bytes:" + extractResultExtractAsset.totalBytes + " cost:" + (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime));
            return true;
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("SmartScan2ConfigHelper prepare failed oldVersion:" + version + " cost:" + (android.os.SystemClock.elapsedRealtime() - jElapsedRealtime), th);
            deleteQuietly(file2);
            recoverInterruptedSwap(file, file2, file3);
            return readVersion(file) >= 35;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.up366.smartscan2.SmartScan2ConfigHelper.ExtractResult extractAsset(android.content.Context r12, java.io.File r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.smartscan2.SmartScan2ConfigHelper.extractAsset(android.content.Context, java.io.File):com.up366.smartscan2.SmartScan2ConfigHelper$ExtractResult");
    }

    private static void writeVersionMarker(java.io.File file) throws java.io.IOException {
        java.io.File file2 = new java.io.File(file, "checkFile");
        byte[] bytes = "35###UP366-P1P-MODEL".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
        try {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
        } catch (java.lang.Throwable th) {
            try {
                fileOutputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static boolean swapDirectories(java.io.File file, java.io.File file2, java.io.File file3) {
        deleteQuietly(file3);
        boolean zExists = file.exists();
        if (zExists && !file.renameTo(file3)) {
            com.up366.common.log.Logger.error("SmartScan2ConfigHelper cannot move current model to backup");
            return false;
        }
        if (file2.renameTo(file)) {
            deleteQuietly(file3);
            return true;
        }
        com.up366.common.log.Logger.error("SmartScan2ConfigHelper cannot move staging model into place");
        if (zExists && file3.exists() && !file3.renameTo(file)) {
            com.up366.common.log.Logger.error("SmartScan2ConfigHelper cannot restore model backup");
        }
        return false;
    }

    private static void recoverInterruptedSwap(java.io.File file, java.io.File file2, java.io.File file3) {
        int version = readVersion(file);
        int version2 = readVersion(file3);
        if (version <= 0 && version2 > 0) {
            deleteQuietly(file);
            if (!file3.renameTo(file)) {
                com.up366.common.log.Logger.error("SmartScan2ConfigHelper interrupted swap recovery failed");
            } else {
                com.up366.common.log.Logger.warn("SmartScan2ConfigHelper restored model backup version:" + version2);
            }
        }
        deleteQuietly(file2);
    }

    public static int getLocalVersionNo(android.content.Context context) {
        return readVersion(new java.io.File(context.getFilesDir(), CONFIG_DIR_NAME));
    }

    private static int readVersion(java.io.File file) {
        java.io.File file2 = new java.io.File(file, "checkFile");
        if (file2.isFile() && file2.canRead()) {
            if (file2.length() <= 0 || file2.length() > 128) {
                com.up366.common.log.Logger.warn("SmartScan2ConfigHelper invalid version marker length:" + file2.length());
            } else {
                int length = (int) file2.length();
                byte[] bArr = new byte[length];
                try {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file2);
                    int i = 0;
                    while (i < length) {
                        try {
                            int i2 = fileInputStream.read(bArr, i, length - i);
                            if (i2 < 0) {
                                break;
                            }
                            i += i2;
                        } finally {
                        }
                    }
                    java.lang.String str = new java.lang.String(bArr, 0, i, java.nio.charset.StandardCharsets.UTF_8);
                    if (str.endsWith(MODEL_KEY)) {
                        int i3 = java.lang.Integer.parseInt(str.substring(0, str.length() - 18));
                        fileInputStream.close();
                        return i3;
                    }
                    fileInputStream.close();
                    return 0;
                } catch (java.lang.Throwable th) {
                    com.up366.common.log.Logger.error("SmartScan2ConfigHelper readVersion failed:" + file2, th);
                    return 0;
                }
            }
        }
        return 0;
    }

    private static void deleteQuietly(java.io.File file) {
        try {
            com.up366.common.FileUtilsUp.deleteDirOrFile(file.getAbsolutePath());
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.warn("SmartScan2ConfigHelper cleanup failed:" + file + " " + th.getMessage());
        }
    }

    private static final class ExtractResult {
        final int entryCount;
        final long totalBytes;

        ExtractResult(int i, long j) {
            this.entryCount = i;
            this.totalBytes = j;
        }
    }
}
