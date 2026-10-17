package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class as {
    public static boolean b;
    public static long c;
    public static int d;
    public static int e;
    public static final java.lang.StringBuilder f = new java.lang.StringBuilder();
    public static final java.lang.StringBuilder g = new java.lang.StringBuilder();
    public static final java.lang.StringBuilder h = new java.lang.StringBuilder();
    public static final java.lang.StringBuilder i = new java.lang.StringBuilder();

    public static void b(java.lang.String str, int i2) {
        if (b) {
            if (i2 == 3) {
                if (e < 1000) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("【");
                    int i3 = e;
                    e = i3 + 1;
                    sb.append(i3);
                    sb.append("】:");
                    sb.append(str);
                    sb.append("\n");
                    java.lang.String string = sb.toString();
                    if (b) {
                        if (i2 == 0) {
                            g.append(string);
                        } else if (i2 == 2) {
                            h.append(string);
                        } else if (i2 == 3) {
                            i.append(string);
                        }
                        f.append(string);
                    }
                }
                i2 = 1;
            }
            if (d > 1000) {
                d = 0;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("【");
            int i4 = d;
            d = i4 + 1;
            sb2.append(i4);
            sb2.append("】\n时间戳:");
            sb2.append(java.lang.System.currentTimeMillis());
            sb2.append("\n时间差:");
            sb2.append(java.lang.System.currentTimeMillis() - c);
            sb2.append("\n数据:\n");
            sb2.append(str);
            sb2.append("\n\n");
            java.lang.String string2 = sb2.toString();
            if (b) {
                if (i2 == 0) {
                    g.append(string2);
                } else if (i2 == 2) {
                    h.append(string2);
                } else if (i2 == 3) {
                    i.append(string2);
                }
                f.append(string2);
            }
            c = java.lang.System.currentTimeMillis();
        }
    }

    public static void b(java.lang.String str) {
        if (b) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("6.3.3CR001B1208 ");
            boolean z = com.unicom.online.account.kernel.ap.b;
            sb.append(str);
            android.util.Log.d("UniAccount", sb.toString());
            b(str, 0);
        }
    }

    public static void b(java.lang.Exception exc) {
        if (b) {
            exc.printStackTrace();
        }
    }
}
