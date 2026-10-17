package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogFileQueue.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/up366/common/log/KmpLogFileRecord;", "", "directoryPath", "", "fileName", "line", "level", "Lcom/up366/common/log/KmpLogLevel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/up366/common/log/KmpLogLevel;)V", "getDirectoryPath", "()Ljava/lang/String;", "getFileName", "getLine", "getLevel", "()Lcom/up366/common/log/KmpLogLevel;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class KmpLogFileRecord {
    private final java.lang.String directoryPath;
    private final java.lang.String fileName;
    private final com.up366.common.log.KmpLogLevel level;
    private final java.lang.String line;

    public static /* synthetic */ com.up366.common.log.KmpLogFileRecord copy$default(com.up366.common.log.KmpLogFileRecord kmpLogFileRecord, java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.common.log.KmpLogLevel kmpLogLevel, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = kmpLogFileRecord.directoryPath;
        }
        if ((i & 2) != 0) {
            str2 = kmpLogFileRecord.fileName;
        }
        if ((i & 4) != 0) {
            str3 = kmpLogFileRecord.line;
        }
        if ((i & 8) != 0) {
            kmpLogLevel = kmpLogFileRecord.level;
        }
        return kmpLogFileRecord.copy(str, str2, str3, kmpLogLevel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final java.lang.String getDirectoryPath() {
        return this.directoryPath;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final java.lang.String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final java.lang.String getLine() {
        return this.line;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final com.up366.common.log.KmpLogLevel getLevel() {
        return this.level;
    }

    public final com.up366.common.log.KmpLogFileRecord copy(java.lang.String directoryPath, java.lang.String fileName, java.lang.String line, com.up366.common.log.KmpLogLevel level) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fileName, "fileName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(line, "line");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        return new com.up366.common.log.KmpLogFileRecord(directoryPath, fileName, line, level);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.common.log.KmpLogFileRecord)) {
            return false;
        }
        com.up366.common.log.KmpLogFileRecord kmpLogFileRecord = (com.up366.common.log.KmpLogFileRecord) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.directoryPath, kmpLogFileRecord.directoryPath) && kotlin.jvm.internal.Intrinsics.areEqual(this.fileName, kmpLogFileRecord.fileName) && kotlin.jvm.internal.Intrinsics.areEqual(this.line, kmpLogFileRecord.line) && this.level == kmpLogFileRecord.level;
    }

    public int hashCode() {
        return (((((this.directoryPath.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.line.hashCode()) * 31) + this.level.hashCode();
    }

    public java.lang.String toString() {
        return "KmpLogFileRecord(directoryPath=" + this.directoryPath + ", fileName=" + this.fileName + ", line=" + this.line + ", level=" + this.level + ")";
    }

    public KmpLogFileRecord(java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.common.log.KmpLogLevel kmpLogLevel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "directoryPath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str2, "fileName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str3, "line");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogLevel, "level");
        this.directoryPath = str;
        this.fileName = str2;
        this.line = str3;
        this.level = kmpLogLevel;
    }

    public final java.lang.String getDirectoryPath() {
        return this.directoryPath;
    }

    public final java.lang.String getFileName() {
        return this.fileName;
    }

    public final java.lang.String getLine() {
        return this.line;
    }

    public final com.up366.common.log.KmpLogLevel getLevel() {
        return this.level;
    }
}
