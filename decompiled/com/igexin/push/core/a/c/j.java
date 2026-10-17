package com.igexin.push.core.a.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class j implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = "com.igexin.push.core.a.c.j";

    private static void a(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(270532608);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045 A[Catch: Exception -> 0x00d1, TRY_ENTER, TryCatch #0 {Exception -> 0x00d1, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:27:0x00a9, B:29:0x00ad, B:30:0x00bb, B:32:0x00c1), top: B:37:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[Catch: Exception -> 0x00d1, TryCatch #0 {Exception -> 0x00d1, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:27:0x00a9, B:29:0x00ad, B:30:0x00bb, B:32:0x00c1), top: B:37:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1 A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d1, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:27:0x00a9, B:29:0x00ad, B:30:0x00bb, B:32:0x00c1), top: B:37:0x0043 }] */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean executeAction(com.igexin.push.extension.mod.PushTaskBean r9, com.igexin.push.extension.mod.BaseActionBean r10) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.j.executeAction(com.igexin.push.extension.mod.PushTaskBean, com.igexin.push.extension.mod.BaseActionBean):boolean");
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            com.igexin.push.core.b.p pVar = new com.igexin.push.core.b.p();
            pVar.setType(com.igexin.push.core.b.q);
            pVar.setActionId(jSONObject.getString("actionid"));
            pVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("appstartupid")) {
                pVar.a = jSONObject.getJSONObject("appstartupid").getString("android");
            }
            if (jSONObject.has("is_autostart")) {
                pVar.d = jSONObject.getString("is_autostart");
            }
            if (jSONObject.has("appid")) {
                pVar.b = jSONObject.getString("appid");
            }
            if (jSONObject.has("noinstall_action")) {
                pVar.c = jSONObject.getString("noinstall_action");
            }
            return pVar;
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
