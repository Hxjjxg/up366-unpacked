package com.up366.mobile.common.logic;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final /* synthetic */ class AppConfigMgr$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static /* synthetic */ int m(java.lang.Class cls, java.lang.Object[] objArr) {
        return (java.util.Arrays.hashCode(objArr) * 31) + cls.hashCode();
    }

    public static /* synthetic */ int m(boolean z) {
        return z ? 1231 : 1237;
    }

    public static /* synthetic */ java.lang.String m(java.lang.Object[] objArr, java.lang.Class cls, java.lang.String str) {
        java.lang.String[] strArrSplit = str.length() == 0 ? new java.lang.String[0] : str.split(";");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(cls.getSimpleName());
        sb.append("[");
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            sb.append("=");
            sb.append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static /* synthetic */ java.util.List m(java.lang.Object[] objArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(objArr.length);
        for (java.lang.Object obj : objArr) {
            arrayList.add(java.util.Objects.requireNonNull(obj));
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }
}
