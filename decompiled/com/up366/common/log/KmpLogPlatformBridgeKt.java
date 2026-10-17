package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogPlatformBridge.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"renderPlatformLog", "", "tag", "message", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpLogPlatformBridgeKt {
    public static final java.lang.String renderPlatformLog(java.lang.String str, java.lang.String str2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "tag");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str2, "message");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!kotlin.text.StringsKt.isBlank(str)) {
            sb.append(str);
            sb.append(": ");
        }
        sb.append(str2);
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
