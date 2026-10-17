package com.igexin.push.core.e;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class d {
    private static final java.lang.String a = "MsgSPManager";
    private static final java.lang.String b = "gx_msg_sp";
    private static final java.lang.String c = "taskIdList";
    private static final java.lang.String d = "gx_vendor_token";
    private static final java.lang.String e = "tokeninfo";
    private static final java.lang.String f = "usfdl";
    private static final java.lang.Object h = new java.lang.Object();
    private static final java.lang.Object i = new java.lang.Object();
    private static volatile com.igexin.push.core.e.d j;
    private android.content.SharedPreferences g;

    private d(android.content.Context context) {
        if (context != null) {
            this.g = context.getSharedPreferences(b, 0);
        }
    }

    public static com.igexin.push.core.e.d a(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (j == null) {
            synchronized (com.igexin.push.core.e.d.class) {
                if (j == null) {
                    j = new com.igexin.push.core.e.d(applicationContext);
                }
            }
        }
        return j;
    }

    private void a(java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences.Editor editorEdit = this.g.edit();
        if (obj instanceof java.lang.String) {
            editorEdit.putString(str, (java.lang.String) obj);
        }
        editorEdit.apply();
    }

    private java.lang.Object b(java.lang.String str, java.lang.Object obj) {
        return obj instanceof java.lang.String ? this.g.getString(str, (java.lang.String) obj) : obj;
    }

    private static void b(org.json.JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 150) {
                return;
            }
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            java.lang.String str = null;
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                long j3 = jSONObject.getLong(next);
                if (j2 > j3) {
                    str = next;
                    j2 = j3;
                }
                if (j3 < java.lang.System.currentTimeMillis() - 432000000) {
                    itKeys.remove();
                    z = true;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void c(java.lang.String str) {
        try {
            a(d, str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void c(org.json.JSONObject jSONObject) {
        try {
            if (jSONObject.length() < 20) {
                return;
            }
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            boolean z = false;
            long j2 = Long.MAX_VALUE;
            java.lang.String str = null;
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                long j3 = java.lang.Long.parseLong(jSONObject.getJSONObject(next).getString("timestamp"));
                if (j2 > j3) {
                    str = next;
                    j2 = j3;
                }
                if (j3 < java.lang.System.currentTimeMillis() - 432000000) {
                    itKeys.remove();
                    z = true;
                }
            }
            if (z || str == null) {
                return;
            }
            jSONObject.remove(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private org.json.JSONObject d() {
        try {
            java.lang.String str = (java.lang.String) b(c, "");
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private org.json.JSONObject e() {
        try {
            java.lang.String str = (java.lang.String) b(f, "");
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private java.lang.String f() {
        try {
            return (java.lang.String) b(d, null);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    public final org.json.JSONObject a() {
        synchronized (h) {
            try {
                java.lang.String str = (java.lang.String) b(f, "");
                if (android.text.TextUtils.isEmpty(str)) {
                    return null;
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(itKeys.next());
                    if (!jSONObject2.has("timestamp") || java.lang.Long.parseLong(jSONObject2.getString("timestamp")) < java.lang.System.currentTimeMillis() - 432000000) {
                        itKeys.remove();
                    }
                }
                return jSONObject;
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return null;
            }
        }
    }

    public final void a(java.lang.String str, org.json.JSONObject jSONObject) {
        if (this.g == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (h) {
            try {
                org.json.JSONObject jSONObjectE = e();
                if (jSONObjectE == null) {
                    jSONObjectE = new org.json.JSONObject();
                }
                if (jSONObjectE.length() > 0) {
                    c(jSONObjectE);
                }
                jSONObjectE.put(str, jSONObject);
                a(f, jSONObjectE.toString());
            } finally {
            }
        }
    }

    public final void a(org.json.JSONObject jSONObject) {
        try {
            a(e, jSONObject.toString());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final boolean a(java.lang.String str) {
        if (this.g != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject jSONObjectD = d();
                if (jSONObjectD != null && jSONObjectD.has(str)) {
                    com.igexin.c.a.c.a.a("sp task " + str + " already exists", new java.lang.Object[0]);
                    return true;
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        return false;
    }

    public final void b() {
        synchronized (h) {
            try {
            } finally {
            }
            if (this.g != null) {
                a(f, "");
            }
        }
    }

    public final void b(java.lang.String str) {
        if (this.g == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (i) {
            try {
                org.json.JSONObject jSONObjectD = d();
                if (jSONObjectD == null) {
                    jSONObjectD = new org.json.JSONObject();
                }
                if (jSONObjectD.length() > 0) {
                    b(jSONObjectD);
                }
                jSONObjectD.put(str, java.lang.System.currentTimeMillis());
                a(c, jSONObjectD.toString());
            } finally {
            }
        }
    }

    public final org.json.JSONObject c() {
        try {
            java.lang.String strValueOf = java.lang.String.valueOf(b(e, ""));
            return strValueOf.isEmpty() ? new org.json.JSONObject() : new org.json.JSONObject(strValueOf);
        } catch (org.json.JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            return new org.json.JSONObject();
        }
    }
}
