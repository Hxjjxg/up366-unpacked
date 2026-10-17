package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class S implements com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks {
    private android.content.Context a;
    private boolean b = false;

    public S(android.content.Context context) {
        this.a = context;
    }

    @Override // com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks
    public void getTokenFailed(int i, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3, long j, long j2, long j3) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getTokenFailed innerCode", java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(this.b), str3, "msg", str);
            if (this.b) {
                return;
            }
            this.b = true;
            com.chuanglan.shanyan_sdk.D.a();
            java.lang.String strA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str);
            long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
            long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
            com.chuanglan.shanyan_sdk.AbstractC0055l.w.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
            com.chuanglan.shanyan_sdk.t0.h().c(i, i2, strA, str2, str3, 4, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getTokenFailed Exception", e);
        }
    }

    @Override // com.chuanglan.shanyan_sdk.listener.LoginAuthCallbacks
    public void getTokenSuccessed(int i, int i2, java.lang.String str, java.lang.String str2, long j, long j2, long j3) {
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getTokenSuccessed innerCode", java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(this.b), com.chuanglan.shanyan_sdk.AbstractC0055l.m);
            if (this.b) {
                return;
            }
            this.b = true;
            com.chuanglan.shanyan_sdk.D.a();
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f1", true);
            com.chuanglan.shanyan_sdk.AbstractC0055l.w.set(com.chuanglan.shanyan_sdk.AbstractC0055l.s);
            com.chuanglan.shanyan_sdk.t0.h().c(i, i2, str, str2, com.chuanglan.shanyan_sdk.AbstractC0055l.m, 4, com.chuanglan.shanyan_sdk.AbstractC0055l.s, j, android.os.SystemClock.uptimeMillis() - j2, android.os.SystemClock.uptimeMillis() - j3);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getTokenSuccessed Exception", e);
        }
    }
}
