package com.igexin.push.core.a.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class j extends com.igexin.push.core.a.b.a {
    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.lang.String str2;
        long j;
        java.lang.String str3;
        java.lang.String str4;
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("sendmessage_feedback")) {
                return true;
            }
            java.lang.String string = jSONObject.getString("appid");
            java.lang.String string2 = jSONObject.getString("taskid");
            java.lang.String string3 = jSONObject.getString("actionid");
            java.lang.String string4 = jSONObject.getString("result");
            long j2 = jSONObject.getLong("timestamp");
            com.igexin.c.a.c.a.a("SendMessageFeedbackAction|appid:" + string + "|taskid:" + string2 + "|actionid:" + string3, new java.lang.Object[0]);
            com.igexin.push.core.l lVarA = com.igexin.push.core.l.a();
            if (com.igexin.push.core.e.a == null || !com.igexin.push.core.e.a.equals(string)) {
                str = "timestamp";
                str2 = "result";
                j = j2;
                str3 = string4;
                str4 = string3;
            } else {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putInt("action", 10010);
                str = "timestamp";
                j = j2;
                str2 = "result";
                str3 = string4;
                str4 = string3;
                bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_CMD_MSG, new com.igexin.sdk.message.FeedbackCmdMessage(string2, string3, string4, j, com.igexin.sdk.PushConsts.THIRDPART_FEEDBACK));
                lVarA.a(bundle);
            }
            android.content.Intent intentD = com.igexin.push.core.l.d();
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putInt("action", com.igexin.sdk.PushConsts.THIRDPART_FEEDBACK);
            bundle2.putString("appid", string);
            bundle2.putString("taskid", string2);
            bundle2.putString("actionid", str4);
            bundle2.putString(str2, str3);
            bundle2.putLong(str, j);
            intentD.putExtras(bundle2);
            com.igexin.push.core.e.l.sendBroadcast(intentD, com.igexin.push.core.e.ac);
            return true;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
