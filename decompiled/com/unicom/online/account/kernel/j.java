package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class j {
    public static java.lang.String b = "";

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: JSONException -> 0x006f, TRY_LEAVE, TryCatch #3 {JSONException -> 0x006f, blocks: (B:12:0x0027, B:23:0x0047, B:38:0x006b, B:36:0x0067, B:15:0x0030, B:21:0x0043, B:10:0x0023, B:26:0x004f, B:31:0x005c, B:33:0x0063, B:30:0x0059, B:27:0x0053, B:16:0x0034, B:18:0x003f, B:7:0x000b), top: B:49:0x0008, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject b(android.content.Context r6) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "n"
            r2 = 0
            if (r6 != 0) goto Lb
            goto L26
        Lb:
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: java.lang.Exception -> L22
            java.lang.String r4 = r6.getPackageName()     // Catch: java.lang.Exception -> L22
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r3.getApplicationInfo(r4, r5)     // Catch: java.lang.Exception -> L22
            java.lang.CharSequence r3 = r3.getApplicationLabel(r4)     // Catch: java.lang.Exception -> L22
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L22
            goto L27
        L22:
            r3 = move-exception
            r3.getMessage()     // Catch: org.json.JSONException -> L6f
        L26:
            r3 = r2
        L27:
            r0.put(r1, r3)     // Catch: org.json.JSONException -> L6f
            java.lang.String r1 = "v"
            if (r6 != 0) goto L30
            goto L46
        L30:
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: org.json.JSONException -> L6f
            java.lang.String r4 = r6.getPackageName()     // Catch: java.lang.Exception -> L42
            r5 = 0
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r5)     // Catch: java.lang.Exception -> L42
            if (r3 == 0) goto L46
            java.lang.String r3 = r3.versionName     // Catch: java.lang.Exception -> L42
            goto L47
        L42:
            r3 = move-exception
            r3.getMessage()     // Catch: org.json.JSONException -> L6f
        L46:
            r3 = r2
        L47:
            r0.put(r1, r3)     // Catch: org.json.JSONException -> L6f
            java.lang.String r1 = "c"
            if (r6 != 0) goto L4f
            goto L6a
        L4f:
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: java.lang.Exception -> L66
            java.lang.String r2 = r6.getPackageName()     // Catch: java.lang.Exception -> L58
            goto L5c
        L58:
            r6 = move-exception
            r6.getMessage()     // Catch: java.lang.Exception -> L66
        L5c:
            r6 = 1
            android.content.pm.PackageInfo r6 = r3.getPackageInfo(r2, r6)     // Catch: java.lang.Exception -> L66
            if (r6 == 0) goto L6a
            int r6 = r6.versionCode     // Catch: java.lang.Exception -> L66
            goto L6b
        L66:
            r6 = move-exception
            r6.getMessage()     // Catch: org.json.JSONException -> L6f
        L6a:
            r6 = -1
        L6b:
            r0.put(r1, r6)     // Catch: org.json.JSONException -> L6f
            goto L73
        L6f:
            r6 = move-exception
            r6.getMessage()
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.kernel.j.b(android.content.Context):org.json.JSONObject");
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            jSONObject.put("app", b(context));
            boolean z = com.unicom.online.account.kernel.ap.b;
            java.lang.String string = jSONObject.toString();
            b = string;
            return string;
        } catch (org.json.JSONException e) {
            e.getMessage();
            return str;
        }
    }
}
