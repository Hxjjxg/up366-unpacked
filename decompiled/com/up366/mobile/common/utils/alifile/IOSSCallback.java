package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IOSSCallback {

    /* JADX INFO: renamed from: com.up366.mobile.common.utils.alifile.IOSSCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onProgress(com.up366.mobile.common.utils.alifile.IOSSCallback _this, long j, long j2) {
        }
    }

    void onFailure(int i, java.lang.String str);

    void onProgress(long j, long j2);

    void onSuccess();
}
