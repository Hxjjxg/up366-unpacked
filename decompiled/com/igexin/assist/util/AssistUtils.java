package com.igexin.assist.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AssistUtils {
    public static final java.lang.String BRAND_HON = "honor";
    public static final java.lang.String BRAND_HW = "huawei";
    public static final java.lang.String BRAND_MZ = "meizu";
    public static final java.lang.String BRAND_OPPO = "oppo";
    public static final java.lang.String BRAND_STP = "stp";
    public static final java.lang.String BRAND_VIVO = "vivo";
    public static final java.lang.String BRAND_XIAOMI = "xiaomi";
    static java.lang.String a = "";

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[PHI: r1
  0x002c: PHI (r1v5 java.lang.String) = 
  (r1v0 java.lang.String)
  (r1v1 java.lang.String)
  (r1v2 java.lang.String)
  (r1v3 java.lang.String)
  (r1v4 java.lang.String)
  (r1v6 java.lang.String)
 binds: [B:12:0x002a, B:15:0x003c, B:18:0x004b, B:21:0x005a, B:24:0x006a, B:9:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDeviceBrand() {
        /*
            java.lang.String r0 = com.igexin.assist.util.AssistUtils.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r0 = com.igexin.assist.util.AssistUtils.a
            return r0
        Lb:
            boolean r0 = com.igexin.push.config.d.U
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "honor"
            boolean r0 = com.igexin.push.g.b.a(r0, r1)
            if (r0 == 0) goto L1e
            goto L2c
        L1e:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "huawei"
            boolean r0 = com.igexin.push.g.b.a(r0, r1)
            if (r0 == 0) goto L2f
        L2c:
            com.igexin.assist.util.AssistUtils.a = r1
            goto L7d
        L2f:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "xiaomi"
            boolean r0 = com.igexin.push.g.b.a(r0, r1)
            if (r0 == 0) goto L3f
            goto L2c
        L3f:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "oppo"
            boolean r0 = com.igexin.push.g.b.a(r0, r1)
            if (r0 == 0) goto L4e
            goto L2c
        L4e:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "meizu"
            boolean r0 = com.igexin.push.g.b.a(r0, r1)
            if (r0 == 0) goto L5d
            goto L2c
        L5d:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "vivo"
            boolean r0 = com.igexin.push.g.b.a(r0, r1)
            if (r0 == 0) goto L6d
            goto L2c
        L6d:
            android.content.Context r0 = com.igexin.push.core.ServiceManager.b
            boolean r0 = com.igexin.push.g.b.a(r0)
            if (r0 == 0) goto L79
            java.lang.String r0 = "stp"
            goto L7b
        L79:
            java.lang.String r0 = android.os.Build.BRAND
        L7b:
            com.igexin.assist.util.AssistUtils.a = r0
        L7d:
            java.lang.String r0 = com.igexin.assist.util.AssistUtils.a
            java.lang.String r0 = r0.toLowerCase()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.util.AssistUtils.getDeviceBrand():java.lang.String");
    }

    public static void startGetuiService(android.content.Context context) {
        if (context != null) {
            try {
                com.igexin.sdk.PushManager.getInstance().initialize(context);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }
}
