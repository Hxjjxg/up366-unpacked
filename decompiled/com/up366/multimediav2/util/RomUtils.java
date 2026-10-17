package com.up366.multimediav2.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RomUtils {
    private static final java.lang.String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final java.lang.String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final java.lang.String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final java.lang.String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final java.lang.String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final java.lang.String ROM_EMUI = "EMUI";
    public static final java.lang.String ROM_FLYME = "FLYME";
    public static final java.lang.String ROM_MIUI = "MIUI";
    public static final java.lang.String ROM_OPPO = "OPPO";
    public static final java.lang.String ROM_QIKU = "QIKU";
    public static final java.lang.String ROM_SMARTISAN = "SMARTISAN";
    public static final java.lang.String ROM_VIVO = "VIVO";
    private static final java.lang.String TAG = "Rom";
    private static java.lang.String sName;
    private static java.lang.String sVersion;

    public static boolean isEmui() {
        return check(ROM_EMUI);
    }

    public static boolean isMiui() {
        return check(ROM_MIUI);
    }

    public static boolean isVivo() {
        return check(ROM_VIVO);
    }

    public static boolean isOppo() {
        return check(ROM_OPPO);
    }

    public static boolean isFlyme() {
        return check(ROM_FLYME);
    }

    public static boolean is360() {
        return check(ROM_QIKU) || check("360");
    }

    public static boolean isSmartisan() {
        return check(ROM_SMARTISAN);
    }

    public static java.lang.String getName() throws java.lang.Throwable {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static java.lang.String getVersion() throws java.lang.Throwable {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean check(java.lang.String str) throws java.lang.Throwable {
        java.lang.String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        java.lang.String prop = getProp("ro.miui.ui.version.name");
        sVersion = prop;
        if (!android.text.TextUtils.isEmpty(prop)) {
            sName = ROM_MIUI;
        } else {
            java.lang.String prop2 = getProp(KEY_VERSION_EMUI);
            sVersion = prop2;
            if (!android.text.TextUtils.isEmpty(prop2)) {
                sName = ROM_EMUI;
            } else {
                java.lang.String prop3 = getProp(KEY_VERSION_OPPO);
                sVersion = prop3;
                if (!android.text.TextUtils.isEmpty(prop3)) {
                    sName = ROM_OPPO;
                } else {
                    java.lang.String prop4 = getProp(KEY_VERSION_VIVO);
                    sVersion = prop4;
                    if (!android.text.TextUtils.isEmpty(prop4)) {
                        sName = ROM_VIVO;
                    } else {
                        java.lang.String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sVersion = prop5;
                        if (!android.text.TextUtils.isEmpty(prop5)) {
                            sName = ROM_SMARTISAN;
                        } else {
                            java.lang.String str3 = android.os.Build.DISPLAY;
                            sVersion = str3;
                            if (str3.toUpperCase().contains(ROM_FLYME)) {
                                sName = ROM_FLYME;
                            } else {
                                sVersion = "unknown";
                                sName = android.os.Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return sName.equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getProp(java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Unable to read prop "
            java.lang.String r1 = "getprop "
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r4.append(r6)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.lang.Process r1 = r3.exec(r1)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            r1 = 1024(0x400, float:1.435E-42)
            r3.<init>(r4, r1)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            java.lang.String r1 = r3.readLine()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L5b
            r3.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L5b
            r3.close()     // Catch: java.io.IOException -> L34
            goto L38
        L34:
            r6 = move-exception
            r6.printStackTrace()
        L38:
            return r1
        L39:
            r1 = move-exception
            goto L3f
        L3b:
            r6 = move-exception
            goto L5d
        L3d:
            r1 = move-exception
            r3 = r2
        L3f:
            java.lang.String r4 = "Rom"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L5b
            r5.append(r6)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = r5.toString()     // Catch: java.lang.Throwable -> L5b
            android.util.Log.e(r4, r6, r1)     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L5a
            r3.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r6 = move-exception
            r6.printStackTrace()
        L5a:
            return r2
        L5b:
            r6 = move-exception
            r2 = r3
        L5d:
            if (r2 == 0) goto L67
            r2.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r0 = move-exception
            r0.printStackTrace()
        L67:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.multimediav2.util.RomUtils.getProp(java.lang.String):java.lang.String");
    }
}
