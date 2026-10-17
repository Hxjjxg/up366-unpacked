package com.up366.common.log;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: KmpLogConfig.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/up366/common/log/KmpLogLevel;", "", "value", "", "label", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getLabel", "()Ljava/lang/String;", "DEBUG", "INFO", "WARN", "ERROR", "FATAL", "Companion", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KmpLogLevel {
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES;
    private static final /* synthetic */ com.up366.common.log.KmpLogLevel[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.common.log.KmpLogLevel.Companion INSTANCE;
    private final java.lang.String label;
    private final int value;
    public static final com.up366.common.log.KmpLogLevel DEBUG = new com.up366.common.log.KmpLogLevel("DEBUG", 0, 3, "DEBUG");
    public static final com.up366.common.log.KmpLogLevel INFO = new com.up366.common.log.KmpLogLevel("INFO", 1, 4, "INFO");
    public static final com.up366.common.log.KmpLogLevel WARN = new com.up366.common.log.KmpLogLevel("WARN", 2, 5, "WARN");
    public static final com.up366.common.log.KmpLogLevel ERROR = new com.up366.common.log.KmpLogLevel("ERROR", 3, 6, "ERROR");
    public static final com.up366.common.log.KmpLogLevel FATAL = new com.up366.common.log.KmpLogLevel("FATAL", 4, 7, "FATAL");

    private static final /* synthetic */ com.up366.common.log.KmpLogLevel[] $values() {
        return new com.up366.common.log.KmpLogLevel[]{DEBUG, INFO, WARN, ERROR, FATAL};
    }

    public static kotlin.enums.EnumEntries<com.up366.common.log.KmpLogLevel> getEntries() {
        return $ENTRIES;
    }

    private KmpLogLevel(java.lang.String str, int i, int i2, java.lang.String str2) {
        this.value = i2;
        this.label = str2;
    }

    public final int getValue() {
        return this.value;
    }

    public final java.lang.String getLabel() {
        return this.label;
    }

    static {
        com.up366.common.log.KmpLogLevel[] kmpLogLevelArr$values = $values();
        $VALUES = kmpLogLevelArr$values;
        $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(kmpLogLevelArr$values);
        INSTANCE = new com.up366.common.log.KmpLogLevel.Companion(null);
    }

    /* JADX INFO: compiled from: KmpLogConfig.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/up366/common/log/KmpLogLevel$Companion;", "", "<init>", "()V", "fromValue", "Lcom/up366/common/log/KmpLogLevel;", "value", "", "fromName", "name", "", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final com.up366.common.log.KmpLogLevel fromValue(int value) {
            java.lang.Object next;
            java.util.Iterator it = com.up366.common.log.KmpLogLevel.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((com.up366.common.log.KmpLogLevel) next).getValue() == value) {
                    break;
                }
            }
            com.up366.common.log.KmpLogLevel kmpLogLevel = (com.up366.common.log.KmpLogLevel) next;
            return kmpLogLevel == null ? com.up366.common.log.KmpLogLevel.INFO : kmpLogLevel;
        }

        public final com.up366.common.log.KmpLogLevel fromName(java.lang.String name) {
            java.lang.Object next;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            java.util.Iterator it = com.up366.common.log.KmpLogLevel.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                com.up366.common.log.KmpLogLevel kmpLogLevel = (com.up366.common.log.KmpLogLevel) next;
                if (kotlin.text.StringsKt.equals(kmpLogLevel.name(), name, true) || kotlin.text.StringsKt.equals(kmpLogLevel.getLabel(), name, true)) {
                    break;
                }
            }
            com.up366.common.log.KmpLogLevel kmpLogLevel2 = (com.up366.common.log.KmpLogLevel) next;
            return kmpLogLevel2 == null ? com.up366.common.log.KmpLogLevel.INFO : kmpLogLevel2;
        }
    }

    public static com.up366.common.log.KmpLogLevel valueOf(java.lang.String str) {
        return (com.up366.common.log.KmpLogLevel) java.lang.Enum.valueOf(com.up366.common.log.KmpLogLevel.class, str);
    }

    public static com.up366.common.log.KmpLogLevel[] values() {
        return (com.up366.common.log.KmpLogLevel[]) $VALUES.clone();
    }
}
