package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogRuntimeState.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/up366/common/log/KmpLogRuntimeState;", "", "config", "Lcom/up366/common/log/KmpLogConfig;", "isConsoleLogEnabled", "", "loggers", "", "Lcom/up366/common/log/KmpLogger;", "addedLoggers", "<init>", "(Lcom/up366/common/log/KmpLogConfig;ZLjava/util/List;Ljava/util/List;)V", "getConfig", "()Lcom/up366/common/log/KmpLogConfig;", "()Z", "getLoggers", "()Ljava/util/List;", "getAddedLoggers", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class KmpLogRuntimeState {
    private final java.util.List<com.up366.common.log.KmpLogger> addedLoggers;
    private final com.up366.common.log.KmpLogConfig config;
    private final boolean isConsoleLogEnabled;
    private final java.util.List<com.up366.common.log.KmpLogger> loggers;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.up366.common.log.KmpLogRuntimeState copy$default(com.up366.common.log.KmpLogRuntimeState kmpLogRuntimeState, com.up366.common.log.KmpLogConfig kmpLogConfig, boolean z, java.util.List list, java.util.List list2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            kmpLogConfig = kmpLogRuntimeState.config;
        }
        if ((i & 2) != 0) {
            z = kmpLogRuntimeState.isConsoleLogEnabled;
        }
        if ((i & 4) != 0) {
            list = kmpLogRuntimeState.loggers;
        }
        if ((i & 8) != 0) {
            list2 = kmpLogRuntimeState.addedLoggers;
        }
        return kmpLogRuntimeState.copy(kmpLogConfig, z, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final com.up366.common.log.KmpLogConfig getConfig() {
        return this.config;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsConsoleLogEnabled() {
        return this.isConsoleLogEnabled;
    }

    public final java.util.List<com.up366.common.log.KmpLogger> component3() {
        return this.loggers;
    }

    public final java.util.List<com.up366.common.log.KmpLogger> component4() {
        return this.addedLoggers;
    }

    public final com.up366.common.log.KmpLogRuntimeState copy(com.up366.common.log.KmpLogConfig config, boolean isConsoleLogEnabled, java.util.List<? extends com.up366.common.log.KmpLogger> loggers, java.util.List<? extends com.up366.common.log.KmpLogger> addedLoggers) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(loggers, "loggers");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(addedLoggers, "addedLoggers");
        return new com.up366.common.log.KmpLogRuntimeState(config, isConsoleLogEnabled, loggers, addedLoggers);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.common.log.KmpLogRuntimeState)) {
            return false;
        }
        com.up366.common.log.KmpLogRuntimeState kmpLogRuntimeState = (com.up366.common.log.KmpLogRuntimeState) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.config, kmpLogRuntimeState.config) && this.isConsoleLogEnabled == kmpLogRuntimeState.isConsoleLogEnabled && kotlin.jvm.internal.Intrinsics.areEqual(this.loggers, kmpLogRuntimeState.loggers) && kotlin.jvm.internal.Intrinsics.areEqual(this.addedLoggers, kmpLogRuntimeState.addedLoggers);
    }

    public int hashCode() {
        return (((((this.config.hashCode() * 31) + kotlin.UByte$.ExternalSyntheticBackport0.m(this.isConsoleLogEnabled)) * 31) + this.loggers.hashCode()) * 31) + this.addedLoggers.hashCode();
    }

    public java.lang.String toString() {
        return "KmpLogRuntimeState(config=" + this.config + ", isConsoleLogEnabled=" + this.isConsoleLogEnabled + ", loggers=" + this.loggers + ", addedLoggers=" + this.addedLoggers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KmpLogRuntimeState(com.up366.common.log.KmpLogConfig kmpLogConfig, boolean z, java.util.List<? extends com.up366.common.log.KmpLogger> list, java.util.List<? extends com.up366.common.log.KmpLogger> list2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogConfig, "config");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "loggers");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list2, "addedLoggers");
        this.config = kmpLogConfig;
        this.isConsoleLogEnabled = z;
        this.loggers = list;
        this.addedLoggers = list2;
    }

    public final com.up366.common.log.KmpLogConfig getConfig() {
        return this.config;
    }

    public final boolean isConsoleLogEnabled() {
        return this.isConsoleLogEnabled;
    }

    public final java.util.List<com.up366.common.log.KmpLogger> getLoggers() {
        return this.loggers;
    }

    public final java.util.List<com.up366.common.log.KmpLogger> getAddedLoggers() {
        return this.addedLoggers;
    }
}
