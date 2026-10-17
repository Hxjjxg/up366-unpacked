package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogFilePolicy.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"KMP_LOG_FILE_RETENTION_COUNT", "", "formattedLogTime", "", "year", "month", "day", "hour", "minute", "second", "millisecond", "datedLogFileName", "expiredLogFileNames", "", "fileNames", "isDatedLogFileName", "", "kmpLog_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KmpLogFilePolicyKt {
    public static final int KMP_LOG_FILE_RETENTION_COUNT = 10;

    public static final java.lang.String formattedLogTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        java.lang.String str = kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i), 4, '0') + '-' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i2), 2, '0') + '-' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i3), 2, '0') + ' ' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i4), 2, '0') + ':' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i5), 2, '0') + ':' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i6), 2, '0') + '.' + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i7), 3, '0');
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    public static final java.lang.String datedLogFileName(int i, int i2, int i3) {
        java.lang.String str = kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i), 4, '0') + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i2), 2, '0') + kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i3), 2, '0') + ".log";
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    public static final java.util.List<java.lang.String> expiredLogFileNames(java.util.List<java.lang.String> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "fileNames");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : list) {
            if (kotlin.text.StringsKt.endsWith((java.lang.String) obj, ".log", true)) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        if (arrayList2.size() <= 10) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        final java.util.Comparator comparator = new java.util.Comparator() { // from class: com.up366.common.log.KmpLogFilePolicyKt$expiredLogFileNames$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.ComparisonsKt.compareValues(com.up366.common.log.KmpLogFilePolicyKt.isDatedLogFileName((java.lang.String) t) ? (java.lang.Comparable) 1 : (java.lang.Comparable) 0, com.up366.common.log.KmpLogFilePolicyKt.isDatedLogFileName((java.lang.String) t2) ? (java.lang.Comparable) 1 : (java.lang.Comparable) 0);
            }
        };
        return kotlin.collections.CollectionsKt.dropLast(kotlin.collections.CollectionsKt.sortedWith(arrayList2, new java.util.Comparator() { // from class: com.up366.common.log.KmpLogFilePolicyKt$expiredLogFileNames$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : kotlin.comparisons.ComparisonsKt.compareValues((java.lang.String) t, (java.lang.String) t2);
            }
        }), 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDatedLogFileName(java.lang.String str) {
        if (str.length() != 12) {
            return false;
        }
        java.lang.String strSubstring = str.substring(0, 8);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        java.lang.String str2 = strSubstring;
        for (int i = 0; i < str2.length(); i++) {
            if (!java.lang.Character.isDigit(str2.charAt(i))) {
                return false;
            }
        }
        java.lang.String strSubstring2 = str.substring(8);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return kotlin.jvm.internal.Intrinsics.areEqual(strSubstring2, ".log");
    }
}
