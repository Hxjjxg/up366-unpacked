package com.igexin.push.g;

import com.igexin.push.core.e.f.AnonymousClass35;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class i {
    public static final java.lang.String a = "g_";
    private static final java.lang.String b = "FenceLabelsUtils";
    private static final java.lang.String c = "com.huawei.hms.contentprovider";
    private static final java.lang.String d = "com.huawei.hms.location.features";
    private static final java.lang.String e = "content://com.huawei.hms.contentprovider/com.huawei.hms.location.features";
    private static final java.lang.String f = "content://com.huawei.hms.contentprovider";
    private static final java.lang.String g = "hms_cp_bundle_key";
    private static final java.lang.String h = "calling_package";
    private static final java.lang.String i = "app_id";
    private static final java.lang.String j = "mt_labels";
    private static final java.lang.String k = "setting_type";
    private static final java.lang.String l = "location_fence_settings";

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.aN)) {
                com.igexin.c.a.c.a.b(b, "gt label already set");
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            java.lang.String str3 = java.lang.String.format("%03d", java.lang.Integer.valueOf(new java.util.Random().nextInt(100) + 1));
            com.igexin.sdk.message.Label label = new com.igexin.sdk.message.Label();
            label.setTagId("g_all");
            label.setTagName("g_all");
            label.setEndTime(Long.MAX_VALUE);
            com.igexin.sdk.message.Label label2 = new com.igexin.sdk.message.Label();
            label2.setTagId(a.concat(java.lang.String.valueOf(str3)));
            label2.setTagName(a.concat(java.lang.String.valueOf(str3)));
            label2.setEndTime(Long.MAX_VALUE);
            jSONArray.put(label.getJsonObject());
            jSONArray.put(label2.getJsonObject());
            java.lang.String string = jSONArray.toString();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(g, e);
            bundle.putString(h, str);
            bundle.putString(i, str2);
            bundle.putInt(k, 2);
            bundle.putString(j, string);
            android.os.Bundle bundleCall = context.getContentResolver().call(android.net.Uri.parse(f), l, (java.lang.String) null, bundle);
            if (bundleCall != null) {
                int i2 = bundleCall.getInt("statusCode", -1);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(" statusCode ");
                sb.append(i2);
                sb.append(" ; ");
                sb.append(i2 == 0 ? "success" : "fail");
                com.igexin.c.a.c.a.b(b, sb.toString());
                if (i2 == 0) {
                    com.igexin.push.core.e.f.a().f(string);
                    if (com.igexin.push.g.d.b("3.2.18.0")) {
                        return;
                    }
                    com.getui.gtc.api.GtcManager.getInstance().onHWSmartFenceLabelChanged(com.igexin.push.core.e.l, com.getui.gtc.dim.Caller.PUSH, com.igexin.push.core.e.A, string);
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.aN)) {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str3);
                org.json.JSONArray jSONArray2 = new org.json.JSONArray(com.igexin.push.core.e.aN);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    jSONArray.put(jSONArray2.optJSONObject(i2));
                }
                str3 = jSONArray.toString();
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(g, e);
            bundle.putString(h, str);
            bundle.putString(i, str2);
            bundle.putInt(k, 2);
            bundle.putString(j, str3);
            android.os.Bundle bundleCall = context.getContentResolver().call(android.net.Uri.parse(f), l, (java.lang.String) null, bundle);
            if (bundleCall != null) {
                int i3 = bundleCall.getInt("statusCode", -1);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(" statusCode ");
                sb.append(i3);
                sb.append(" ; ");
                sb.append(i3 == 0 ? "success" : "fail");
                com.igexin.c.a.c.a.b(b, sb.toString());
                if (i3 == 0) {
                    com.igexin.push.core.l.a().b("0");
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass35(str3), false, true);
                    if (com.igexin.push.g.d.b("3.2.18.0")) {
                        return;
                    }
                    com.getui.gtc.api.GtcManager.getInstance().onHWSmartFenceLabelChanged(com.igexin.push.core.e.l, com.getui.gtc.dim.Caller.PUSH, com.igexin.push.core.e.A, str3);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(b, th.toString());
        }
        com.igexin.push.core.l.a().b("40005");
    }
}
