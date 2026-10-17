package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogFormatter.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"formatDefaultLogTime", "", "timestampMillis", "", "(Ljava/lang/Long;)Ljava/lang/String;", "renderSourceLocation", "Lcom/up366/common/log/KmpLogRecord;", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpLogFormatterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String formatDefaultLogTime(java.lang.Long l) {
        java.lang.String str;
        java.lang.Character orNull;
        java.lang.String logTime = com.up366.common.log.KmpLogPlatformKt.formatLogTime(l != null ? l.longValue() : com.up366.common.log.KmpLogPlatformKt.currentTimeMillis());
        int length = logTime.length();
        int i = length - 4;
        return (i < 0 || (orNull = kotlin.text.StringsKt.getOrNull((str = logTime), i)) == null || orNull.charValue() != '.') ? logTime : kotlin.text.StringsKt.replaceRange(str, i, length - 3, ":").toString();
    }

    public static final java.lang.String renderSourceLocation(com.up366.common.log.KmpLogRecord kmpLogRecord) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmpLogRecord, "<this>");
        java.lang.String strSubstringAfterLast$default = kotlin.text.StringsKt.substringAfterLast$default(kotlin.text.StringsKt.substringAfterLast$default(kmpLogRecord.getSourceFile(), '/', (java.lang.String) null, 2, (java.lang.Object) null), '\\', (java.lang.String) null, 2, (java.lang.Object) null);
        java.lang.String sourceFunction = kmpLogRecord.getSourceFunction();
        java.lang.String str = kotlin.text.StringsKt.isBlank(sourceFunction) ^ true ? sourceFunction : null;
        if (str == null) {
            str = "";
        }
        if (kotlin.text.StringsKt.isBlank(str) && kmpLogRecord.getSourceLine() <= 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!kotlin.text.StringsKt.isBlank(r3)) {
            sb.append('[');
            sb.append(str);
            sb.append(']');
        }
        if (kmpLogRecord.getSourceLine() > 0) {
            sb.append('(');
            if (!kotlin.text.StringsKt.isBlank(strSubstringAfterLast$default)) {
                sb.append(strSubstringAfterLast$default);
                sb.append(':');
            } else {
                sb.append("line ");
            }
            sb.append(kmpLogRecord.getSourceLine());
            sb.append(')');
        }
        sb.append(':');
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
