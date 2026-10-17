package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class f0 {
    public org.json.JSONArray a = new org.json.JSONArray();
    public org.json.JSONArray b = new org.json.JSONArray();

    public class a implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ java.lang.String b;
        public final /* synthetic */ java.lang.String c;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.zx.a.I8b7.f0.this.a.length() >= 100) {
                    com.zx.a.I8b7.c3.a("events length > MAX_COUNT " + com.zx.a.I8b7.f0.this.a.length());
                    return;
                }
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("ts", jCurrentTimeMillis);
                jSONObject.put("callId", this.a);
                jSONObject.put("action", this.b);
                jSONObject.put("params", this.c);
                com.zx.a.I8b7.f0.this.a.put(jSONObject);
                com.zx.a.I8b7.c3.a("events add:" + jSONObject.toString());
                if (com.zx.a.I8b7.x3.I) {
                    com.zx.a.I8b7.c3.a("events save:" + com.zx.a.I8b7.f0.this.a.toString());
                    com.zx.a.I8b7.w2 w2Var = com.zx.a.I8b7.w2.a.a;
                    com.zx.a.I8b7.h4 h4Var = w2Var.a;
                    java.lang.String string = com.zx.a.I8b7.f0.this.a.toString();
                    h4Var.getClass();
                    w2Var.a.a(23, string, true);
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.c3.a(th);
            }
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.f0 a = new com.zx.a.I8b7.f0();
    }

    public final void a(java.lang.Runnable runnable) {
        try {
            com.zx.a.I8b7.i4.f.a.b.execute(runnable);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }

    public final org.json.JSONArray a(org.json.JSONArray jSONArray, org.json.JSONArray jSONArray2, int i) throws org.json.JSONException {
        org.json.JSONArray jSONArray3 = new org.json.JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray3.length() >= i) {
                return jSONArray3;
            }
            jSONArray3.put(jSONArray.get(i2));
        }
        for (int i3 = 0; i3 < jSONArray2.length() && jSONArray3.length() < i; i3++) {
            jSONArray3.put(jSONArray2.get(i3));
        }
        return jSONArray3;
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            a(new com.zx.a.I8b7.f0.a(str, str2, str3));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }
}
