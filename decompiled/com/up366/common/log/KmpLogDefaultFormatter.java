package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogFormatter.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/up366/common/log/KmpLogDefaultFormatter;", "Lcom/up366/common/log/KmpLogFormatter;", "<init>", "()V", "format", "", "record", "Lcom/up366/common/log/KmpLogRecord;", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KmpLogDefaultFormatter implements com.up366.common.log.KmpLogFormatter {
    public static final com.up366.common.log.KmpLogDefaultFormatter INSTANCE = new com.up366.common.log.KmpLogDefaultFormatter();

    private KmpLogDefaultFormatter() {
    }

    @Override // com.up366.common.log.KmpLogFormatter
    public java.lang.String format(com.up366.common.log.KmpLogRecord record) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(record, "record");
        java.lang.String tag = record.getTag();
        if (tag == null || !(!kotlin.text.StringsKt.isBlank(tag))) {
            tag = null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.up366.common.log.KmpLogFormatterKt.formatDefaultLogTime(record.getTimestampMillis()));
        sb.append(" - ");
        sb.append(record.getLevel().getLabel());
        sb.append(" - ");
        sb.append(com.up366.common.log.KmpLogFormatterKt.renderSourceLocation(record));
        if (tag != null) {
            sb.append('[');
            sb.append(tag);
            sb.append(']');
        }
        sb.append(record.getMessage());
        if (tag != null) {
            sb.append("[/");
            sb.append(tag);
            sb.append(']');
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
