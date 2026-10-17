package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogPlatform.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\b\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"fileLogLock", "", "lastRetentionCheckKey", "", "writePlatformLog", "", "level", "Lcom/up366/common/log/KmpLogLevel;", "tag", "message", "appendPlatformLogFile", "directoryPath", "fileName", "line", "enqueuePlatformLogFile", "", "record", "Lcom/up366/common/log/KmpLogFileRecord;", "currentTimeMillis", "", "formatLogTime", "timestampMillis", "currentLogFileName", "deleteExpiredLogFiles", "directory", "Ljava/io/File;", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpLogPlatformKt {
    private static final java.lang.Object fileLogLock = new java.lang.Object();
    private static java.lang.String lastRetentionCheckKey;

    /* JADX INFO: compiled from: KmpLogPlatform.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.up366.common.log.KmpLogLevel.values().length];
            try {
                iArr[com.up366.common.log.KmpLogLevel.DEBUG.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[com.up366.common.log.KmpLogLevel.INFO.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[com.up366.common.log.KmpLogLevel.WARN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[com.up366.common.log.KmpLogLevel.ERROR.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[com.up366.common.log.KmpLogLevel.FATAL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final void writePlatformLog(com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, java.lang.String str2) throws kotlin.NoWhenBranchMatchedException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogLevel, "level");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "tag");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str2, "message");
        int i = com.up366.common.log.KmpLogPlatformKt.WhenMappings.$EnumSwitchMapping$0[kmpLogLevel.ordinal()];
        int i2 = 3;
        if (i != 1) {
            if (i == 2) {
                i2 = 4;
            } else if (i == 3) {
                i2 = 5;
            } else if (i == 4) {
                i2 = 6;
            } else {
                if (i != 5) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                i2 = 7;
            }
        }
        android.util.Log.println(i2, str, str2);
    }

    public static final void appendPlatformLogFile(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.io.File file;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "directoryPath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str2, "fileName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str3, "line");
        if (kotlin.text.StringsKt.isBlank(str) || kotlin.jvm.internal.Intrinsics.areEqual(str, "/")) {
            file = new java.io.File(java.lang.System.getProperty("java.io.tmpdir"), "kmp-logs");
        } else {
            file = new java.io.File(str);
        }
        synchronized (fileLogLock) {
            java.io.File file2 = new java.io.File(file, str2);
            java.io.File parentFile = file2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            kotlin.io.FilesKt.appendText$default(file2, str3, (java.nio.charset.Charset) null, 2, (java.lang.Object) null);
            java.lang.String str4 = file.getAbsolutePath() + "/" + str2;
            if (!kotlin.jvm.internal.Intrinsics.areEqual(lastRetentionCheckKey, str4)) {
                deleteExpiredLogFiles(file);
                lastRetentionCheckKey = str4;
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    public static final boolean enqueuePlatformLogFile(com.up366.common.log.KmpLogFileRecord kmpLogFileRecord) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogFileRecord, "record");
        return com.up366.common.log.AndroidFileLogWriter.INSTANCE.enqueue(kmpLogFileRecord);
    }

    public static final long currentTimeMillis() {
        return java.lang.System.currentTimeMillis();
    }

    public static final java.lang.String formatLogTime(long j) {
        java.lang.String str = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", java.util.Locale.US).format(new java.util.Date(j));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final java.lang.String currentLogFileName(long j) {
        java.lang.String str = new java.text.SimpleDateFormat("yyyyMMdd'.log'", java.util.Locale.US).format(new java.util.Date(j));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private static final void deleteExpiredLogFiles(java.io.File file) {
        java.util.LinkedHashMap linkedHashMapEmptyMap;
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            linkedHashMapEmptyMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            for (java.lang.Object obj : arrayList2) {
                linkedHashMapEmptyMap.put(((java.io.File) obj).getName(), obj);
            }
        } else {
            linkedHashMapEmptyMap = null;
        }
        if (linkedHashMapEmptyMap == null) {
            linkedHashMapEmptyMap = kotlin.collections.MapsKt.emptyMap();
        }
        java.util.Iterator<T> it = com.up366.common.log.KmpLogFilePolicyKt.expiredLogFileNames(kotlin.collections.CollectionsKt.toList(linkedHashMapEmptyMap.keySet())).iterator();
        while (it.hasNext()) {
            java.io.File file3 = (java.io.File) linkedHashMapEmptyMap.get((java.lang.String) it.next());
            if (file3 != null) {
                file3.delete();
            }
        }
    }
}
