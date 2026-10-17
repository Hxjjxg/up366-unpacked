package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class C0052i implements com.chuanglan.shanyan_sdk.listener.AuthCallbacks {
    @Override // com.chuanglan.shanyan_sdk.listener.AuthCallbacks
    public void authFailed(int i, int i2, java.lang.String str, java.lang.String str2, int i3, java.lang.String str3, long j, long j2, long j3) {
        java.lang.String strA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str);
        long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
        long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
        com.chuanglan.shanyan_sdk.AbstractC0055l.x.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
        com.chuanglan.shanyan_sdk.t0.h().b(i, i2, strA, str2, str3, 11, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
    }

    @Override // com.chuanglan.shanyan_sdk.listener.AuthCallbacks
    public void authSuccessed(int i, int i2, java.lang.String str, java.lang.String str2, int i3, java.lang.String str3, long j, long j2, long j3) {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
        long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
        com.chuanglan.shanyan_sdk.AbstractC0055l.x.set(com.chuanglan.shanyan_sdk.AbstractC0055l.s);
        com.chuanglan.shanyan_sdk.t0.h().b(i, i2, str, str2, str3, 11, com.chuanglan.shanyan_sdk.AbstractC0055l.s, j, jUptimeMillis2, jUptimeMillis);
    }
}
