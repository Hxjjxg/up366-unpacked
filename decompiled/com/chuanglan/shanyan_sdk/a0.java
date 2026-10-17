package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class a0 {
    private static com.chuanglan.shanyan_sdk.a0 e;
    private android.content.Context b;
    private com.chuanglan.shanyan_sdk.c0 a = com.chuanglan.shanyan_sdk.Y.a(com.chuanglan.shanyan_sdk.C0065v.g().e());
    private boolean c = false;
    private boolean d = false;

    private void a(android.content.Context context) {
        if (this.a != null && context != null) {
            this.b = context.getApplicationContext();
        }
        boolean zC = c();
        this.c = zC;
        if (zC) {
            this.d = this.a.b(this.b);
        }
    }

    public static com.chuanglan.shanyan_sdk.a0 b() {
        if (e == null) {
            e = new com.chuanglan.shanyan_sdk.a0();
        }
        return e;
    }

    private boolean c() {
        com.chuanglan.shanyan_sdk.c0 c0Var;
        try {
            android.content.Context context = this.b;
            if (context != null && (c0Var = this.a) != null) {
                return c0Var.a(context);
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private java.lang.String b(android.content.Context context) {
        a(context);
        if (this.d) {
            return a();
        }
        return null;
    }

    public void c(android.content.Context context) {
        try {
            java.lang.String strA = com.chuanglan.shanyan_sdk.p0.a(context, com.chuanglan.shanyan_sdk.v0.a, "");
            if (com.chuanglan.shanyan_sdk.AbstractC0055l.J && com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA)) {
                java.lang.String strB = b(context);
                com.chuanglan.shanyan_sdk.Q.c("LogInfoShanYanLogger", "init token dv", strB);
                if (!a(strB)) {
                    com.chuanglan.shanyan_sdk.p0.b(context, com.chuanglan.shanyan_sdk.v0.a, "-1");
                } else {
                    com.chuanglan.shanyan_sdk.Q.a("LogInfoShanYanLogger", "init od is valid");
                    com.chuanglan.shanyan_sdk.p0.b(context, com.chuanglan.shanyan_sdk.v0.a, strB);
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private java.lang.String a() {
        com.chuanglan.shanyan_sdk.c0 c0Var;
        try {
            android.content.Context context = this.b;
            if (context != null && (c0Var = this.a) != null && this.d) {
                return c0Var.c(context);
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    static boolean a(java.lang.String str) {
        java.lang.String strReplace;
        int length;
        if (str == null || str.isEmpty() || "-1".equals(str) || (length = (strReplace = str.replace("-", "")).length()) < 32) {
            return false;
        }
        char cCharAt = strReplace.charAt(0);
        for (int i = 1; i < length; i++) {
            if (strReplace.charAt(i) != cCharAt) {
                for (int i2 = 1; i2 < 8 && strReplace.charAt(i2) == cCharAt; i2++) {
                    if (i2 == 7) {
                        return false;
                    }
                }
                for (int i3 = 2; i3 <= 8; i3++) {
                    if (length % i3 == 0) {
                        for (int i4 = i3; i4 < length; i4++) {
                            if (strReplace.charAt(i4) != strReplace.charAt(i4 % i3)) {
                                break;
                            }
                        }
                        return false;
                    }
                }
                for (int i5 = 1; i5 < length; i5++) {
                    if (strReplace.charAt(i5) - strReplace.charAt(i5 - 1) != 1) {
                        for (int i6 = 1; i6 < length; i6++) {
                            if (strReplace.charAt(i6 - 1) - strReplace.charAt(i6) != 1) {
                                int[] iArr = new int[128];
                                int i7 = 0;
                                for (int i8 = 0; i8 < length; i8++) {
                                    char cCharAt2 = strReplace.charAt(i8);
                                    int i9 = iArr[cCharAt2];
                                    if (i9 == 0) {
                                        i7++;
                                    }
                                    iArr[cCharAt2] = i9 + 1;
                                }
                                return i7 >= 8;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
