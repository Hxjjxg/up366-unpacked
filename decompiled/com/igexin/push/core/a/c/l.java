package com.igexin.push.core.a.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class l implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = com.igexin.push.config.c.a;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[PHI: r1 r11
  0x0029: PHI (r1v6 java.lang.String) = (r1v4 java.lang.String), (r1v8 java.lang.String) binds: [B:16:0x005f, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]
  0x0029: PHI (r11v8 java.lang.String) = (r11v7 java.lang.String), (r11v9 java.lang.String) binds: [B:16:0x005f, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.igexin.push.core.b.s r10, java.lang.String r11) {
        /*
            java.lang.String r0 = r10.a
            if (r0 != 0) goto L5
            return
        L5:
            int r11 = r0.indexOf(r11)
            r1 = -1
            if (r11 != r1) goto Ld
            return
        Ld:
            java.lang.String r2 = "&"
            int r3 = r0.indexOf(r2)
            r4 = 0
            java.lang.String r5 = "="
            r6 = 0
            if (r3 != r1) goto L34
            int r1 = r11 + (-1)
            java.lang.String r1 = r0.substring(r4, r1)
            java.lang.String r11 = r0.substring(r11)
            boolean r0 = r11.contains(r5)
            if (r0 == 0) goto L9e
        L29:
            int r0 = r11.indexOf(r5)
            int r0 = r0 + 1
            java.lang.String r6 = r11.substring(r0)
            goto L9e
        L34:
            int r7 = r11 + (-1)
            char r8 = r0.charAt(r7)
            r9 = 63
            if (r8 != r9) goto L62
            java.lang.String r1 = r0.substring(r4, r11)
            int r2 = r3 + 1
            java.lang.String r2 = r0.substring(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            java.lang.String r11 = r0.substring(r11, r3)
            boolean r0 = r11.contains(r5)
            if (r0 == 0) goto L9e
            goto L29
        L62:
            char r3 = r0.charAt(r7)
            r8 = 38
            java.lang.String r9 = ""
            if (r3 != r8) goto L9d
            java.lang.String r3 = r0.substring(r4, r7)
            java.lang.String r11 = r0.substring(r11)
            int r0 = r11.indexOf(r2)
            if (r0 == r1) goto L82
            java.lang.String r9 = r11.substring(r0)
            java.lang.String r11 = r11.substring(r4, r0)
        L82:
            int r0 = r11.indexOf(r5)
            int r0 = r0 + 1
            java.lang.String r11 = r11.substring(r0)
            r6 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r3)
            r11.append(r9)
            java.lang.String r1 = r11.toString()
            goto L9e
        L9d:
            r1 = r9
        L9e:
            r10.a = r1
            r10.d = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.l.a(com.igexin.push.core.b.s, java.lang.String):void");
    }

    private static void a(java.lang.String str, android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.push.core.b.s sVar = new com.igexin.push.core.b.s();
            sVar.a = str;
            a(sVar, com.igexin.push.core.b.A);
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setFlags(268435456);
            intent.setPackage(sVar.d);
            intent.setData(android.net.Uri.parse(sVar.a()));
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        com.igexin.push.core.b.s sVar = (com.igexin.push.core.b.s) baseActionBean;
        a(sVar, com.igexin.push.core.b.A);
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setFlags(268435456);
        intent.setPackage(sVar.d);
        intent.setData(android.net.Uri.parse(sVar.a()));
        try {
            com.igexin.push.core.e.l.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        sVar.a();
        if (baseActionBean.getDoActionId().equals("")) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has(com.up366.mobile.commonui.CommonWebViewActivity.URL) || !jSONObject.has("do") || !jSONObject.has("actionid")) {
                return null;
            }
            java.lang.String string = jSONObject.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            if (string.equals("")) {
                return null;
            }
            com.igexin.push.core.b.s sVar = new com.igexin.push.core.b.s();
            sVar.setType(com.igexin.push.core.b.u);
            sVar.setActionId(jSONObject.getString("actionid"));
            sVar.setDoActionId(jSONObject.getString("do"));
            sVar.a = string;
            if (jSONObject.has("is_withcid") && "true".equals(jSONObject.getString("is_withcid"))) {
                sVar.b = true;
            }
            if (jSONObject.has("is_withnettype") && "true".equals(jSONObject.getString("is_withnettype"))) {
                sVar.c = true;
            }
            return sVar;
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }
}
