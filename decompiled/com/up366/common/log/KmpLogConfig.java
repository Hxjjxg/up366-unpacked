package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogConfig.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/up366/common/log/KmpLogConfig;", "", "isAutoSyncErrorEnable", "", "minLevel", "Lcom/up366/common/log/KmpLogLevel;", "directoryPath", "", "<init>", "(ZLcom/up366/common/log/KmpLogLevel;Ljava/lang/String;)V", "()Z", "getMinLevel", "()Lcom/up366/common/log/KmpLogLevel;", "getDirectoryPath", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class KmpLogConfig {
    private final java.lang.String directoryPath;
    private final boolean isAutoSyncErrorEnable;
    private final com.up366.common.log.KmpLogLevel minLevel;

    public static /* synthetic */ com.up366.common.log.KmpLogConfig copy$default(com.up366.common.log.KmpLogConfig kmpLogConfig, boolean z, com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = kmpLogConfig.isAutoSyncErrorEnable;
        }
        if ((i & 2) != 0) {
            kmpLogLevel = kmpLogConfig.minLevel;
        }
        if ((i & 4) != 0) {
            str = kmpLogConfig.directoryPath;
        }
        return kmpLogConfig.copy(z, kmpLogLevel, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsAutoSyncErrorEnable() {
        return this.isAutoSyncErrorEnable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final com.up366.common.log.KmpLogLevel getMinLevel() {
        return this.minLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final java.lang.String getDirectoryPath() {
        return this.directoryPath;
    }

    public final com.up366.common.log.KmpLogConfig copy(boolean isAutoSyncErrorEnable, com.up366.common.log.KmpLogLevel minLevel, java.lang.String directoryPath) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minLevel, "minLevel");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        return new com.up366.common.log.KmpLogConfig(isAutoSyncErrorEnable, minLevel, directoryPath);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.common.log.KmpLogConfig)) {
            return false;
        }
        com.up366.common.log.KmpLogConfig kmpLogConfig = (com.up366.common.log.KmpLogConfig) other;
        return this.isAutoSyncErrorEnable == kmpLogConfig.isAutoSyncErrorEnable && this.minLevel == kmpLogConfig.minLevel && kotlin.jvm.internal.Intrinsics.areEqual(this.directoryPath, kmpLogConfig.directoryPath);
    }

    public int hashCode() {
        return (((kotlin.UByte$.ExternalSyntheticBackport0.m(this.isAutoSyncErrorEnable) * 31) + this.minLevel.hashCode()) * 31) + this.directoryPath.hashCode();
    }

    public java.lang.String toString() {
        return "KmpLogConfig(isAutoSyncErrorEnable=" + this.isAutoSyncErrorEnable + ", minLevel=" + this.minLevel + ", directoryPath=" + this.directoryPath + ")";
    }

    public KmpLogConfig(boolean z, com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogLevel, "minLevel");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "directoryPath");
        this.isAutoSyncErrorEnable = z;
        this.minLevel = kmpLogLevel;
        this.directoryPath = str;
    }

    public final boolean isAutoSyncErrorEnable() {
        return this.isAutoSyncErrorEnable;
    }

    public /* synthetic */ KmpLogConfig(boolean z, com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? com.up366.common.log.KmpLogLevel.DEBUG : kmpLogLevel, (i & 4) != 0 ? "/" : str);
    }

    public final com.up366.common.log.KmpLogLevel getMinLevel() {
        return this.minLevel;
    }

    public final java.lang.String getDirectoryPath() {
        return this.directoryPath;
    }
}
