package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogFormatter.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003JX\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\fHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/up366/common/log/KmpLogRecord;", "", "level", "Lcom/up366/common/log/KmpLogLevel;", "message", "", "tag", "timestampMillis", "", "sourceFile", "sourceFunction", "sourceLine", "", "<init>", "(Lcom/up366/common/log/KmpLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;I)V", "getLevel", "()Lcom/up366/common/log/KmpLogLevel;", "getMessage", "()Ljava/lang/String;", "getTag", "getTimestampMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSourceFile", "getSourceFunction", "getSourceLine", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/up366/common/log/KmpLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;I)Lcom/up366/common/log/KmpLogRecord;", "equals", "", "other", "hashCode", "toString", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class KmpLogRecord {
    private final com.up366.common.log.KmpLogLevel level;
    private final java.lang.String message;
    private final java.lang.String sourceFile;
    private final java.lang.String sourceFunction;
    private final int sourceLine;
    private final java.lang.String tag;
    private final java.lang.Long timestampMillis;

    public static /* synthetic */ com.up366.common.log.KmpLogRecord copy$default(com.up366.common.log.KmpLogRecord kmpLogRecord, com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, java.lang.String str2, java.lang.Long l, java.lang.String str3, java.lang.String str4, int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            kmpLogLevel = kmpLogRecord.level;
        }
        if ((i2 & 2) != 0) {
            str = kmpLogRecord.message;
        }
        java.lang.String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = kmpLogRecord.tag;
        }
        java.lang.String str6 = str2;
        if ((i2 & 8) != 0) {
            l = kmpLogRecord.timestampMillis;
        }
        java.lang.Long l2 = l;
        if ((i2 & 16) != 0) {
            str3 = kmpLogRecord.sourceFile;
        }
        java.lang.String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = kmpLogRecord.sourceFunction;
        }
        java.lang.String str8 = str4;
        if ((i2 & 64) != 0) {
            i = kmpLogRecord.sourceLine;
        }
        return kmpLogRecord.copy(kmpLogLevel, str5, str6, l2, str7, str8, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final com.up366.common.log.KmpLogLevel getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final java.lang.String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final java.lang.String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final java.lang.Long getTimestampMillis() {
        return this.timestampMillis;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final java.lang.String getSourceFile() {
        return this.sourceFile;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final java.lang.String getSourceFunction() {
        return this.sourceFunction;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSourceLine() {
        return this.sourceLine;
    }

    public final com.up366.common.log.KmpLogRecord copy(com.up366.common.log.KmpLogLevel level, java.lang.String message, java.lang.String tag, java.lang.Long timestampMillis, java.lang.String sourceFile, java.lang.String sourceFunction, int sourceLine) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceFunction, "sourceFunction");
        return new com.up366.common.log.KmpLogRecord(level, message, tag, timestampMillis, sourceFile, sourceFunction, sourceLine);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.common.log.KmpLogRecord)) {
            return false;
        }
        com.up366.common.log.KmpLogRecord kmpLogRecord = (com.up366.common.log.KmpLogRecord) other;
        return this.level == kmpLogRecord.level && kotlin.jvm.internal.Intrinsics.areEqual(this.message, kmpLogRecord.message) && kotlin.jvm.internal.Intrinsics.areEqual(this.tag, kmpLogRecord.tag) && kotlin.jvm.internal.Intrinsics.areEqual(this.timestampMillis, kmpLogRecord.timestampMillis) && kotlin.jvm.internal.Intrinsics.areEqual(this.sourceFile, kmpLogRecord.sourceFile) && kotlin.jvm.internal.Intrinsics.areEqual(this.sourceFunction, kmpLogRecord.sourceFunction) && this.sourceLine == kmpLogRecord.sourceLine;
    }

    public int hashCode() {
        int iHashCode = ((this.level.hashCode() * 31) + this.message.hashCode()) * 31;
        java.lang.String str = this.tag;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        java.lang.Long l = this.timestampMillis;
        return ((((((iHashCode2 + (l != null ? l.hashCode() : 0)) * 31) + this.sourceFile.hashCode()) * 31) + this.sourceFunction.hashCode()) * 31) + this.sourceLine;
    }

    public java.lang.String toString() {
        return "KmpLogRecord(level=" + this.level + ", message=" + this.message + ", tag=" + this.tag + ", timestampMillis=" + this.timestampMillis + ", sourceFile=" + this.sourceFile + ", sourceFunction=" + this.sourceFunction + ", sourceLine=" + this.sourceLine + ")";
    }

    public KmpLogRecord(com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, java.lang.String str2, java.lang.Long l, java.lang.String str3, java.lang.String str4, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogLevel, "level");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "message");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str3, "sourceFile");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str4, "sourceFunction");
        this.level = kmpLogLevel;
        this.message = str;
        this.tag = str2;
        this.timestampMillis = l;
        this.sourceFile = str3;
        this.sourceFunction = str4;
        this.sourceLine = i;
    }

    public /* synthetic */ KmpLogRecord(com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, java.lang.String str2, java.lang.Long l, java.lang.String str3, java.lang.String str4, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(kmpLogLevel, str, str2, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? 0 : i);
    }

    public final com.up366.common.log.KmpLogLevel getLevel() {
        return this.level;
    }

    public final java.lang.String getMessage() {
        return this.message;
    }

    public final java.lang.String getTag() {
        return this.tag;
    }

    public final java.lang.Long getTimestampMillis() {
        return this.timestampMillis;
    }

    public final java.lang.String getSourceFile() {
        return this.sourceFile;
    }

    public final java.lang.String getSourceFunction() {
        return this.sourceFunction;
    }

    public final int getSourceLine() {
        return this.sourceLine;
    }
}
