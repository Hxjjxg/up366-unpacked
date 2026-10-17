package com.up366.mobile.common.utils.alifile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface AliFileOSSPrgoressCallBack {
    void onFailure(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, int i, java.lang.String str);

    void onProgress(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, long j, long j2);

    void onSuccess(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest);
}
