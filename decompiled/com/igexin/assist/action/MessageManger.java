package com.igexin.assist.action;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MessageManger {
    private static final java.lang.String a = "Assist_MessageManger";
    private java.lang.String b;

    /* JADX INFO: renamed from: com.igexin.assist.action.MessageManger$1, reason: invalid class name */
    final class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ android.content.Context c;

        AnonymousClass1(java.lang.String str, boolean z, android.content.Context context) {
            this.a = str;
            this.b = z;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.igexin.push.core.e.m.get()) {
                com.igexin.c.a.c.a.b(com.igexin.assist.action.MessageManger.a, "delay 1s save token = " + this.a);
                com.igexin.assist.action.MessageManger.b(this.a, this.b);
                return;
            }
            android.content.Context context = this.c;
            if (context == null) {
                com.igexin.c.a.c.a.b(com.igexin.assist.action.MessageManger.a, " save token in SP ,but context is null " + this.a);
                return;
            }
            com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(context);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, this.a);
                jSONObject.put("isForce", this.b);
            } catch (org.json.JSONException e) {
                com.igexin.c.a.c.a.a(e);
            }
            dVarA.a(jSONObject);
        }
    }

    class a implements java.lang.Runnable {
        com.igexin.assist.MessageBean a;

        a(com.igexin.assist.MessageBean messageBean) {
            this.a = messageBean;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 209
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.action.MessageManger.a.run():void");
        }
    }

    static class b {
        private static final com.igexin.assist.action.MessageManger a = new com.igexin.assist.action.MessageManger(0);

        private b() {
        }
    }

    private MessageManger() {
    }

    /* synthetic */ MessageManger(byte b2) {
        this();
    }

    private static com.igexin.push.extension.mod.PushTaskBean a(com.igexin.assist.action.a aVar) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
        pushTaskBean.setAppid(aVar.d);
        pushTaskBean.setMessageId(aVar.c);
        pushTaskBean.setTaskId(aVar.b);
        pushTaskBean.setId(java.lang.String.valueOf(jCurrentTimeMillis));
        pushTaskBean.setCurrentActionid(1);
        return pushTaskBean;
    }

    static /* synthetic */ void a(android.content.Context context, com.igexin.assist.action.a aVar) {
        if (!com.igexin.push.core.e.m.get()) {
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = com.igexin.push.core.b.T;
        messageObtain.obj = aVar.f;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.igexin.sdk.FlymePushReceiver.CONTENT, aVar.f);
        if (aVar.a != null) {
            bundle.putByteArray(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, aVar.a);
        }
        messageObtain.setData(bundle);
        com.igexin.push.core.d.a.a.a(messageObtain);
    }

    private void a(android.content.Context context, java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(a, "other token = ".concat(java.lang.String.valueOf(str)));
        if (com.igexin.push.core.e.m.get()) {
            b(str, z);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.igexin.assist.action.MessageManger.AnonymousClass1(str, z, context), 1000L);
        }
    }

    static /* synthetic */ void a(com.igexin.assist.action.MessageManger messageManger, android.content.Context context, java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.igexin.c.a.c.a.e.a(a, "other token = ".concat(java.lang.String.valueOf(str)));
        if (com.igexin.push.core.e.m.get()) {
            b(str, z);
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(messageManger.new AnonymousClass1(str, z, context), 1000L);
        }
    }

    static /* synthetic */ void a(com.igexin.assist.action.MessageManger messageManger, com.igexin.assist.action.a aVar, android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(context);
            if (dVarA.a(aVar.b)) {
                messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "1");
                return;
            }
            dVarA.b(aVar.b);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_MESSAGE_DATA, new com.igexin.sdk.message.GTTransmitMessage(aVar.b, aVar.c, aVar.c + ":" + aVar.b, aVar.a, false, true));
            com.igexin.push.core.l.a(context);
            com.igexin.push.core.l.a().a(bundle);
            messageManger.feedbackPushMessage(context, aVar, messageManger.getBrandCode() + "0");
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(com.igexin.assist.action.a aVar, android.content.Context context) {
        if (aVar == null || context == null) {
            return;
        }
        try {
            com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(context);
            if (dVarA.a(aVar.b)) {
                feedbackPushMessage(context, aVar, getBrandCode() + "1");
                return;
            }
            dVarA.b(aVar.b);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_MESSAGE_DATA, new com.igexin.sdk.message.GTTransmitMessage(aVar.b, aVar.c, aVar.c + ":" + aVar.b, aVar.a, false, true));
            com.igexin.push.core.l.a(context);
            com.igexin.push.core.l.a().a(bundle);
            feedbackPushMessage(context, aVar, getBrandCode() + "0");
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(java.lang.String str) {
        try {
            com.igexin.push.core.l.a().a(str);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void b(android.content.Context context, com.igexin.assist.action.a aVar) {
        if (!com.igexin.push.core.e.m.get()) {
            com.igexin.assist.util.AssistUtils.startGetuiService(context);
        }
        if (aVar == null) {
            return;
        }
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = com.igexin.push.core.b.T;
        messageObtain.obj = aVar.f;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.igexin.sdk.FlymePushReceiver.CONTENT, aVar.f);
        if (aVar.a != null) {
            bundle.putByteArray(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, aVar.a);
        }
        messageObtain.setData(bundle);
        com.igexin.push.core.d.a.a.a(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.lang.String str, boolean z) {
        a(str);
        if (!z) {
            try {
                if (str.equals(com.igexin.push.core.e.I)) {
                    return;
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                return;
            }
        }
        com.igexin.push.core.e.f.a().b(str);
        if (com.igexin.push.core.e.u) {
            com.igexin.c.a.c.a.b(a, "online, send addphoneinfo");
            com.igexin.push.core.a.b.d().i();
        } else if (z) {
            com.igexin.push.core.e.f.a().c("");
        }
    }

    public static com.igexin.assist.action.MessageManger getInstance() {
        return com.igexin.assist.action.MessageManger.b.a;
    }

    public void addMessage(com.igexin.assist.MessageBean messageBean) {
        com.igexin.b.a.a().a.execute(new com.igexin.assist.action.MessageManger.a(messageBean));
    }

    public void feedbackPushMessage(android.content.Context context, com.igexin.assist.action.a aVar, java.lang.String str) {
        try {
            if (com.igexin.push.core.e.m.get()) {
                com.igexin.sdk.main.FeedbackImpl feedbackImpl = com.igexin.sdk.main.FeedbackImpl.getInstance();
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                pushTaskBean.setAppid(aVar.d);
                pushTaskBean.setMessageId(aVar.c);
                pushTaskBean.setTaskId(aVar.b);
                pushTaskBean.setId(java.lang.String.valueOf(jCurrentTimeMillis));
                pushTaskBean.setCurrentActionid(1);
                feedbackImpl.feedbackMultiBrandMessageAction(pushTaskBean, str);
                return;
            }
            com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(context);
            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis2));
            jSONObject.put("messageid", aVar.c);
            jSONObject.put("taskid", aVar.b);
            jSONObject.put("multaid", str);
            jSONObject.put("timestamp", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
            dVarA.a(aVar.b, jSONObject);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public java.lang.String getBrandCode() {
        if (!android.text.TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        com.igexin.assist.sdk.a aVarA = com.igexin.assist.sdk.a.a();
        java.lang.String brandCode = aVarA.b == null ? "" : aVarA.b.getBrandCode();
        this.b = brandCode;
        return brandCode;
    }
}
