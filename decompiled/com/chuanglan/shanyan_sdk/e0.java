package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class e0 implements com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks {
    private android.content.Context a;

    public e0(android.content.Context context) {
        this.a = context;
    }

    @Override // com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks
    public void openPageFailed(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, long j, long j2, long j3) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "openPageFailed innerCode", java.lang.Integer.valueOf(i2), "operator", str3, "msg", str);
            com.chuanglan.shanyan_sdk.t0.h().d();
            java.lang.String strA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str);
            long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
            long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
            com.chuanglan.shanyan_sdk.AbstractC0055l.v.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
            com.chuanglan.shanyan_sdk.AbstractC0055l.U.set(true);
            com.chuanglan.shanyan_sdk.t0.h().a(i, i2, strA, str2, str3, 3, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "openPageFailed Exception", e);
        }
    }

    @Override // com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks
    public void openPageSuccessed(int i, int i2, java.lang.String str, java.lang.String str2, long j, long j2, long j3) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "openPageSuccessed innerCode", java.lang.Integer.valueOf(i2), "operator", com.chuanglan.shanyan_sdk.AbstractC0055l.m, "msg", str);
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f1", true);
            com.chuanglan.shanyan_sdk.AbstractC0055l.v.set(com.chuanglan.shanyan_sdk.AbstractC0055l.s);
            long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
            com.chuanglan.shanyan_sdk.t0.h().a(i, i2, com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str), str2, com.chuanglan.shanyan_sdk.AbstractC0055l.m, 3, com.chuanglan.shanyan_sdk.AbstractC0055l.s, j, android.os.SystemClock.uptimeMillis() - j2, jUptimeMillis);
        } catch (java.lang.Exception e2) {
            e = e2;
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "openPageSuccessed Exception", e);
        }
    }
}
