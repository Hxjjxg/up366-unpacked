package com.up366.common.log;

/* JADX INFO: compiled from: KmpLog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0005J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010J\"\u0010\u0019\u001a\u00020\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0007J\u0012\u0010\u001c\u001a\u00020\u00132\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0007J\u0012\u0010\u001f\u001a\u00020\u00132\b\b\u0001\u0010 \u001a\u00020\u0010H\u0007J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0015J\u0016\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0017J \u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u0017J:\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00172\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001bJ\u0010\u0010)\u001a\u00020\u00132\b\b\u0001\u0010$\u001a\u00020\u0017J\u0010\u0010*\u001a\u00020\u00132\b\b\u0001\u0010$\u001a\u00020\u0017J\u0010\u0010+\u001a\u00020\u00132\b\b\u0001\u0010$\u001a\u00020\u0017J\u0010\u0010,\u001a\u00020\u00132\b\b\u0001\u0010$\u001a\u00020\u0017J\u0010\u0010-\u001a\u00020\u00132\b\b\u0001\u0010$\u001a\u00020\u0017J@\u0010.\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u001bH\u0002J&\u0010/\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e01H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u00062"}, d2 = {"Lcom/up366/common/log/KmpLog;", "", "<init>", "()V", "defaultConfig", "Lcom/up366/common/log/KmpLogConfig;", "runtimeState", "Lcom/up366/common/log/KmpLogAtomicState;", "Lcom/up366/common/log/KmpLogRuntimeState;", "value", "config", "getConfig", "()Lcom/up366/common/log/KmpLogConfig;", "setConfig", "(Lcom/up366/common/log/KmpLogConfig;)V", "isConsoleLogEnabled", "", "()Z", "setup", "", "minLevel", "Lcom/up366/common/log/KmpLogLevel;", "directoryPath", "", "isAutoSyncErrorEnable", "setupWithMinLevelValue", "minLevelValue", "", "addLogger", "logger", "Lcom/up366/common/log/KmpLogger;", "setConsoleLogEnabled", "enabled", "setMinLevel", "level", "log", "message", "tag", "sourceFile", "sourceFunction", "sourceLine", com.up366.papercut.library.BuildConfig.BUILD_TYPE, "info", "warn", "error", "fatal", "internalLog", "createRuntimeState", "addedLoggers", "", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KmpLog {
    public static final com.up366.common.log.KmpLog INSTANCE;
    private static final com.up366.common.log.KmpLogConfig defaultConfig;
    private static final com.up366.common.log.KmpLogAtomicState<com.up366.common.log.KmpLogRuntimeState> runtimeState;

    private KmpLog() {
    }

    static {
        com.up366.common.log.KmpLog kmpLog = new com.up366.common.log.KmpLog();
        INSTANCE = kmpLog;
        com.up366.common.log.KmpLogConfig kmpLogConfig = new com.up366.common.log.KmpLogConfig(false, com.up366.common.log.KmpLogLevel.DEBUG, "/");
        defaultConfig = kmpLogConfig;
        runtimeState = com.up366.common.log.KmpLogRuntimeStateKt.createKmpLogAtomicState(kmpLog.createRuntimeState(kmpLogConfig, true, kotlin.collections.CollectionsKt.emptyList()));
    }

    public final com.up366.common.log.KmpLogConfig getConfig() {
        return com.up366.common.log.KmpLogConfig.copy$default(runtimeState.get().getConfig(), false, null, null, 7, null);
    }

    private final void setConfig(com.up366.common.log.KmpLogConfig kmpLogConfig) {
        final com.up366.common.log.KmpLogConfig kmpLogConfigCopy$default = com.up366.common.log.KmpLogConfig.copy$default(kmpLogConfig, false, null, null, 7, null);
        runtimeState.update(new kotlin.jvm.functions.Function1() { // from class: com.up366.common.log.KmpLog$$ExternalSyntheticLambda0
            public final java.lang.Object invoke(java.lang.Object obj) {
                return com.up366.common.log.KmpLog._set_config_$lambda$0(kmpLogConfigCopy$default, (com.up366.common.log.KmpLogRuntimeState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.common.log.KmpLogRuntimeState _set_config_$lambda$0(com.up366.common.log.KmpLogConfig kmpLogConfig, com.up366.common.log.KmpLogRuntimeState kmpLogRuntimeState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogRuntimeState, "current");
        return INSTANCE.createRuntimeState(kmpLogConfig, kmpLogRuntimeState.isConsoleLogEnabled(), kmpLogRuntimeState.getAddedLoggers());
    }

    public final boolean isConsoleLogEnabled() {
        return runtimeState.get().isConsoleLogEnabled();
    }

    public final void setup(com.up366.common.log.KmpLogConfig config) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(config, "config");
        setConfig(config);
    }

    public final void setup(com.up366.common.log.KmpLogLevel minLevel, java.lang.String directoryPath, boolean isAutoSyncErrorEnable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(minLevel, "minLevel");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        setup(new com.up366.common.log.KmpLogConfig(isAutoSyncErrorEnable, minLevel, directoryPath));
    }

    public final void setupWithMinLevelValue(int minLevelValue, java.lang.String directoryPath, boolean isAutoSyncErrorEnable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        setup(com.up366.common.log.KmpLogLevel.INSTANCE.fromValue(minLevelValue), directoryPath, isAutoSyncErrorEnable);
    }

    public final void addLogger(final com.up366.common.log.KmpLogger logger) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(logger, "logger");
        runtimeState.update(new kotlin.jvm.functions.Function1() { // from class: com.up366.common.log.KmpLog$$ExternalSyntheticLambda1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return com.up366.common.log.KmpLog.addLogger$lambda$2(logger, (com.up366.common.log.KmpLogRuntimeState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.common.log.KmpLogRuntimeState addLogger$lambda$2(com.up366.common.log.KmpLogger kmpLogger, com.up366.common.log.KmpLogRuntimeState kmpLogRuntimeState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogRuntimeState, "current");
        java.util.List<com.up366.common.log.KmpLogger> addedLoggers = kmpLogRuntimeState.getAddedLoggers();
        if (!(addedLoggers instanceof java.util.Collection) || !addedLoggers.isEmpty()) {
            java.util.Iterator<T> it = addedLoggers.iterator();
            while (it.hasNext()) {
                if (((com.up366.common.log.KmpLogger) it.next()) == kmpLogger) {
                    return kmpLogRuntimeState;
                }
            }
        }
        return INSTANCE.createRuntimeState(kmpLogRuntimeState.getConfig(), kmpLogRuntimeState.isConsoleLogEnabled(), kotlin.collections.CollectionsKt.plus(kmpLogRuntimeState.getAddedLoggers(), kmpLogger));
    }

    public final void setConsoleLogEnabled(final boolean enabled) {
        runtimeState.update(new kotlin.jvm.functions.Function1() { // from class: com.up366.common.log.KmpLog$$ExternalSyntheticLambda3
            public final java.lang.Object invoke(java.lang.Object obj) {
                return com.up366.common.log.KmpLog.setConsoleLogEnabled$lambda$3(enabled, (com.up366.common.log.KmpLogRuntimeState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.common.log.KmpLogRuntimeState setConsoleLogEnabled$lambda$3(boolean z, com.up366.common.log.KmpLogRuntimeState kmpLogRuntimeState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogRuntimeState, "current");
        return kmpLogRuntimeState.isConsoleLogEnabled() == z ? kmpLogRuntimeState : INSTANCE.createRuntimeState(kmpLogRuntimeState.getConfig(), z, kmpLogRuntimeState.getAddedLoggers());
    }

    public final void setMinLevel(final com.up366.common.log.KmpLogLevel level) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        runtimeState.update(new kotlin.jvm.functions.Function1() { // from class: com.up366.common.log.KmpLog$$ExternalSyntheticLambda2
            public final java.lang.Object invoke(java.lang.Object obj) {
                return com.up366.common.log.KmpLog.setMinLevel$lambda$4(level, (com.up366.common.log.KmpLogRuntimeState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.common.log.KmpLogRuntimeState setMinLevel$lambda$4(com.up366.common.log.KmpLogLevel kmpLogLevel, com.up366.common.log.KmpLogRuntimeState kmpLogRuntimeState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogRuntimeState, "current");
        return com.up366.common.log.KmpLogRuntimeState.copy$default(kmpLogRuntimeState, com.up366.common.log.KmpLogConfig.copy$default(kmpLogRuntimeState.getConfig(), false, kmpLogLevel, null, 5, null), false, null, null, 14, null);
    }

    public final void log(com.up366.common.log.KmpLogLevel level, java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        internalLog$default(this, message, level, null, null, null, 0, 56, null);
    }

    public final void log(com.up366.common.log.KmpLogLevel level, java.lang.String message, java.lang.String tag) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        internalLog$default(this, message, level, tag, null, null, 0, 56, null);
    }

    public static /* synthetic */ void log$default(com.up366.common.log.KmpLog kmpLog, com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, int i2, java.lang.Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        kmpLog.log(kmpLogLevel, str, str2, str3, str4, i);
    }

    public final void log(com.up366.common.log.KmpLogLevel level, java.lang.String message, java.lang.String tag, java.lang.String sourceFile, java.lang.String sourceFunction, int sourceLine) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(level, "level");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceFunction, "sourceFunction");
        internalLog(message, level, tag, sourceFile, sourceFunction, sourceLine);
    }

    public final void debug(java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        log(com.up366.common.log.KmpLogLevel.DEBUG, message);
    }

    public final void info(java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        log(com.up366.common.log.KmpLogLevel.INFO, message);
    }

    public final void warn(java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        log(com.up366.common.log.KmpLogLevel.WARN, message);
    }

    public final void error(java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        log(com.up366.common.log.KmpLogLevel.ERROR, message);
    }

    public final void fatal(java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        log(com.up366.common.log.KmpLogLevel.FATAL, message);
    }

    static /* synthetic */ void internalLog$default(com.up366.common.log.KmpLog kmpLog, java.lang.String str, com.up366.common.log.KmpLogLevel kmpLogLevel, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, int i2, java.lang.Object obj) {
        kmpLog.internalLog(str, kmpLogLevel, str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? 0 : i);
    }

    private final void internalLog(java.lang.String message, com.up366.common.log.KmpLogLevel level, java.lang.String tag, java.lang.String sourceFile, java.lang.String sourceFunction, int sourceLine) {
        com.up366.common.log.KmpLogRuntimeState kmpLogRuntimeState = runtimeState.get();
        if (level.getValue() < kmpLogRuntimeState.getConfig().getMinLevel().getValue()) {
            return;
        }
        com.up366.common.log.KmpLogDispatcherKt.dispatchSafely(kmpLogRuntimeState.getLoggers(), new com.up366.common.log.KmpLogRecord(level, message, (tag == null || !(kotlin.text.StringsKt.isBlank(tag) ^ true)) ? null : tag, java.lang.Long.valueOf(com.up366.common.log.KmpLogPlatformKt.currentTimeMillis()), sourceFile, sourceFunction, kotlin.ranges.RangesKt.coerceAtLeast(sourceLine, 0)));
    }

    private final com.up366.common.log.KmpLogRuntimeState createRuntimeState(com.up366.common.log.KmpLogConfig config, boolean isConsoleLogEnabled, java.util.List<? extends com.up366.common.log.KmpLogger> addedLoggers) {
        java.util.List list = kotlin.collections.CollectionsKt.toList(addedLoggers);
        java.util.List listCreateListBuilder = kotlin.collections.CollectionsKt.createListBuilder();
        if (isConsoleLogEnabled) {
            com.up366.common.log.KmpLogFormatter kmpLogFormatter = null;
            listCreateListBuilder.add(new com.up366.common.log.KmpConsoleLogger(kmpLogFormatter, 1, kmpLogFormatter));
        }
        listCreateListBuilder.add(new com.up366.common.log.KmpFileLogger(config.getDirectoryPath(), config.isAutoSyncErrorEnable(), null, 4, null));
        return new com.up366.common.log.KmpLogRuntimeState(config, isConsoleLogEnabled, kotlin.collections.CollectionsKt.plus(kotlin.collections.CollectionsKt.build(listCreateListBuilder), list), list);
    }
}
