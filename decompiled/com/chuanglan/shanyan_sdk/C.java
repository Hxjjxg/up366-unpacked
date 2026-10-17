package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class C implements com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks {
    private android.content.Context a;
    private boolean b = false;

    public C(android.content.Context context) {
        this.a = context;
    }

    @Override // com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks
    public void getPhoneInfoFailed(int i, int i2, java.lang.String str, java.lang.String str2, int i3, java.lang.String str3, long j, long j2, long j3) {
        char c;
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "preInfoFailed innerCode", java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(this.b), java.lang.Integer.valueOf(i3), "innerDesc", str2);
            com.chuanglan.shanyan_sdk.j0.a();
            com.chuanglan.shanyan_sdk.t0.h().d();
            java.lang.String strA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str, str3);
            long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
            long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
            try {
                if (i3 != 3) {
                    if (i3 != 4) {
                        com.chuanglan.shanyan_sdk.t0.h().a(i, i2, strA, str2, str3, i3, 2, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
                    } else {
                        com.chuanglan.shanyan_sdk.D.a();
                        com.chuanglan.shanyan_sdk.AbstractC0055l.w.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
                        com.chuanglan.shanyan_sdk.t0.h().c(i, i2, strA, str2, str3, 2, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
                    }
                } else {
                    if (this.b) {
                        return;
                    }
                    try {
                        this.b = true;
                        com.chuanglan.shanyan_sdk.AbstractC0055l.v.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
                        com.chuanglan.shanyan_sdk.AbstractC0055l.U.set(true);
                        c = 1;
                    } catch (java.lang.Exception e) {
                        e = e;
                        c = 1;
                    }
                    try {
                        com.chuanglan.shanyan_sdk.t0.h().a(i, i2, strA, str2, str3, 1, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        java.lang.Object[] objArr = new java.lang.Object[2];
                        objArr[0] = "getPhoneInfoFailed Exception";
                        objArr[c] = e;
                        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", objArr);
                    }
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                c = 1;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            c = 1;
        }
    }

    @Override // com.chuanglan.shanyan_sdk.listener.GetPhoneInfoCallbacks
    public void getPhoneInfoSuccessed(int i, int i2, java.lang.String str, java.lang.String str2, int i3, long j, long j2, long j3) {
        char c;
        try {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "preInfoSuccess", java.lang.Boolean.valueOf(this.b), java.lang.Integer.valueOf(i3));
            com.chuanglan.shanyan_sdk.j0.a();
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f4", true);
            com.chuanglan.shanyan_sdk.p0.b(this.a, "cl_jm_f1", true);
            com.chuanglan.shanyan_sdk.AbstractC0059p.d(this.a, "scripCache_sub");
            com.chuanglan.shanyan_sdk.AbstractC0059p.c(this.a, "scripCache_sub");
            java.lang.String strA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str, this.a);
            long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
            long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
            try {
                if (i3 != 3) {
                    if (i3 != 4) {
                        com.chuanglan.shanyan_sdk.t0.h().a(i, i2, strA, str2, com.chuanglan.shanyan_sdk.AbstractC0055l.m, i3, 2, com.chuanglan.shanyan_sdk.AbstractC0055l.s, j, jUptimeMillis2, jUptimeMillis);
                    } else {
                        com.chuanglan.shanyan_sdk.E.a().a(com.chuanglan.shanyan_sdk.AbstractC0055l.m, j, j2, j3);
                    }
                } else {
                    if (this.b) {
                        return;
                    }
                    c = 1;
                    try {
                        this.b = true;
                        com.chuanglan.shanyan_sdk.T.a().a(j, j2, j3);
                    } catch (java.lang.Exception e) {
                        e = e;
                        e.printStackTrace();
                        java.lang.Object[] objArr = new java.lang.Object[2];
                        objArr[0] = "getPhoneInfoSuccessed Exception";
                        objArr[c] = e;
                        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", objArr);
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                c = 1;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            c = 1;
        }
    }
}
