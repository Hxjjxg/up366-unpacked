package com.igexin.push.core.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class q extends com.igexin.push.extension.mod.BaseActionBean {
    private long a;

    private long a() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.igexin.push.core.b.q a(java.lang.String r5) throws org.json.JSONException {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L5d
            com.igexin.push.core.b.q r0 = new com.igexin.push.core.b.q
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r5)
            java.lang.String r5 = "actionid"
            boolean r2 = r1.has(r5)
            if (r2 == 0) goto L1f
            java.lang.String r5 = r1.getString(r5)
            r0.setActionId(r5)
        L1f:
            java.lang.String r5 = "type"
            boolean r2 = r1.has(r5)
            if (r2 == 0) goto L2f
            java.lang.String r5 = r1.getString(r5)
            r0.setType(r5)
        L2f:
            java.lang.String r5 = "do"
            boolean r2 = r1.has(r5)
            if (r2 == 0) goto L3e
            java.lang.String r5 = r1.getString(r5)
            r0.setDoActionId(r5)
        L3e:
            java.lang.String r5 = "delay"
            boolean r2 = r1.has(r5)
            if (r2 == 0) goto L58
            double r1 = r1.getDouble(r5)
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L58
            r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r1 = r1 * r3
            long r1 = (long) r1
            goto L5a
        L58:
            r1 = 200(0xc8, double:9.9E-322)
        L5a:
            r0.a = r1
            goto L5e
        L5d:
            r0 = 0
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.q.a(java.lang.String):com.igexin.push.core.b.q");
    }

    private void a(long j) {
        this.a = j;
    }
}
