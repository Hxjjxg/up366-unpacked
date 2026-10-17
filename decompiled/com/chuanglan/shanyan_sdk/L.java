package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class L implements com.chuanglan.shanyan_sdk.listener.InitCallbacks {
    private android.content.Context a;
    private boolean b = false;

    public L(android.content.Context context) {
        this.a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.chuanglan.shanyan_sdk.L] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // com.chuanglan.shanyan_sdk.listener.InitCallbacks
    public void initFailed(int i, int i2, java.lang.String str, java.lang.String str2, int i3, long j, long j2, long j3) {
        java.lang.String strB;
        java.lang.String strA;
        long jUptimeMillis;
        long jUptimeMillis2;
        ?? r1 = this;
        try {
            strB = com.chuanglan.shanyan_sdk.C0065v.g().b(r1.a);
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "InitFailed innerCode", java.lang.Integer.valueOf(i2), "operator", strB, "processName", java.lang.Integer.valueOf(i3), "msg", str);
            com.chuanglan.shanyan_sdk.AbstractC0055l.u.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
            strA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str);
            jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
            jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
            try {
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            r1 = 1;
        }
        if (i3 == 2) {
            r1 = 1;
            com.chuanglan.shanyan_sdk.t0.h().a(i, i2, strA, str2, strB, i3, 1, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
        } else if (i3 == 3) {
            r1 = 1;
            com.chuanglan.shanyan_sdk.AbstractC0055l.v.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
            com.chuanglan.shanyan_sdk.AbstractC0055l.U.set(true);
            com.chuanglan.shanyan_sdk.t0.h().a(i, i2, strA, str2, strB, 1, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
        } else {
            if (i3 != 4) {
                if (i3 == 11) {
                    com.chuanglan.shanyan_sdk.AbstractC0055l.x.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
                    com.chuanglan.shanyan_sdk.t0.h().b(i, i2, strA, str2, strB, 1, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
                }
                com.chuanglan.shanyan_sdk.M.a();
                if (r1.b) {
                    return;
                }
                r1.b = true;
                r1 = 1;
                com.chuanglan.shanyan_sdk.t0.h().d(i, i2, strA, str2, strB, i3, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
                e.printStackTrace();
                java.lang.Object[] objArr = new java.lang.Object[2];
                objArr[0] = "initFailed Exception";
                objArr[r1] = e;
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", objArr);
                return;
            }
            r1 = 1;
            com.chuanglan.shanyan_sdk.D.a();
            com.chuanglan.shanyan_sdk.AbstractC0055l.w.set(com.chuanglan.shanyan_sdk.AbstractC0055l.r);
            com.chuanglan.shanyan_sdk.t0.h().c(i, i2, strA, str2, strB, 1, com.chuanglan.shanyan_sdk.AbstractC0055l.r, j, jUptimeMillis2, jUptimeMillis);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.chuanglan.shanyan_sdk.L] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.chuanglan.shanyan_sdk.listener.InitCallbacks
    public void initSuccessed(int i, int i2, java.lang.String str, java.lang.String str2, int i3, long j, long j2, long j3) {
        char c;
        int i4 = this;
        try {
            java.lang.String strB = com.chuanglan.shanyan_sdk.C0065v.g().b(i4.a);
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "initSuccessed processName", java.lang.Integer.valueOf(i3));
            com.chuanglan.shanyan_sdk.AbstractC0055l.u.set(com.chuanglan.shanyan_sdk.AbstractC0055l.s);
            com.chuanglan.shanyan_sdk.N.b().d();
            java.lang.String strA = com.chuanglan.shanyan_sdk.AbstractC0049f.a(i2, str2, str);
            long jUptimeMillis = android.os.SystemClock.uptimeMillis() - j3;
            long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - j2;
            if (-1 == i3) {
                com.chuanglan.shanyan_sdk.M.a();
                if (i4.b) {
                    return;
                }
                i4.b = true;
                com.chuanglan.shanyan_sdk.t0.h().d(i, i2, strA, str2, strB, 1, com.chuanglan.shanyan_sdk.AbstractC0055l.s, j, jUptimeMillis2, jUptimeMillis);
                return;
            }
            try {
                if (i3 == 2 || i3 == 3 || i3 == 4) {
                    i4 = 2;
                    c = 1;
                    com.chuanglan.shanyan_sdk.k0.b().c(i3, null, j, j2, j3);
                } else {
                    if (i3 == 11) {
                        com.chuanglan.shanyan_sdk.C0053j.a().c(j, j2, j3);
                    }
                    com.chuanglan.shanyan_sdk.M.a();
                    if (i4.b) {
                        return;
                    }
                    i4.b = true;
                    i4 = 2;
                    c = 1;
                    com.chuanglan.shanyan_sdk.t0.h().d(i, i2, strA, str2, strB, i3, com.chuanglan.shanyan_sdk.AbstractC0055l.s, j, jUptimeMillis2, jUptimeMillis);
                }
            } catch (java.lang.Exception e) {
                e = e;
                e.printStackTrace();
                java.lang.Object[] objArr = new java.lang.Object[i4];
                objArr[0] = "initSuccessed Exception";
                objArr[c] = e;
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", objArr);
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            i4 = 2;
            c = 1;
        }
    }
}
