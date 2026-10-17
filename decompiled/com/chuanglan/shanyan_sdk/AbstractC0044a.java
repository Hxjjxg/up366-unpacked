package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0044a {
    public static void a(android.content.Context context, long j, long j2, long j3) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.class);
        intent.putExtra("beginTime", j);
        intent.putExtra("stepStartTime", j2);
        intent.putExtra("methodStartTime", j3);
        intent.setFlags(268435456);
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigA = com.chuanglan.shanyan_sdk.tool.a.b().a();
        a(context, intent, shanYanUIConfigA != null ? shanYanUIConfigA.getEnterAnim() : null, shanYanUIConfigA != null ? shanYanUIConfigA.getExitAnim() : null, false);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.chuanglan.shanyan_sdk.view.CTCCPrivacyProtocolActivity.class);
            intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
            intent.putExtra("title", str2);
            intent.setFlags(268435456);
            com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigA = com.chuanglan.shanyan_sdk.tool.a.b().a();
            a(context, intent, shanYanUIConfigA != null ? shanYanUIConfigA.getPrivacyEnterAnim() : null, shanYanUIConfigA != null ? shanYanUIConfigA.getPrivacyExitAnim() : null, true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(android.content.Context context, android.content.Intent intent, java.lang.String str, java.lang.String str2, boolean z) {
        int iA;
        android.os.Bundle bundle = null;
        if (str != null) {
            try {
                iA = com.chuanglan.shanyan_sdk.O.a(context).a(str);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else {
            iA = 0;
        }
        int iA2 = str2 != null ? com.chuanglan.shanyan_sdk.O.a(context).a(str2) : 0;
        if (iA != 0 || iA2 != 0 || z) {
            bundle = android.app.ActivityOptions.makeCustomAnimation(context, iA, iA2).toBundle();
        }
        if (bundle != null) {
            context.startActivity(intent, bundle);
            return;
        }
        context.startActivity(intent);
        if (z && (context instanceof android.app.Activity)) {
            ((android.app.Activity) context).overridePendingTransition(0, 0);
        }
    }
}
