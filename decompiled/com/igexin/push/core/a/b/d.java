package com.igexin.push.core.a.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d extends com.igexin.push.core.a.a {
    private static final java.lang.String b = "FormatMsgAction";
    private static java.util.Map<java.lang.String, com.igexin.push.core.a.b.a> c;

    public d() {
        java.util.HashMap map = new java.util.HashMap();
        c = map;
        map.put(com.igexin.push.core.b.G, new com.igexin.push.core.a.b.h());
        c.put("response_deviceid", new com.igexin.push.core.a.b.i());
        c.put(com.igexin.push.core.b.E, new com.igexin.push.core.a.b.e());
        c.put(com.igexin.push.core.b.F, new com.igexin.push.core.a.b.g());
        c.put("sendmessage_feedback", new com.igexin.push.core.a.b.j());
        c.put("block_client", new com.igexin.push.core.a.b.c());
        c.put("settag_result", new com.igexin.push.core.a.b.k());
        c.put("query_tag_result", new com.igexin.push.core.a.b.f());
        c.put("response_bind", new com.igexin.push.core.a.b.b());
        c.put("response_unbind", new com.igexin.push.core.a.b.l());
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        if (!(obj instanceof com.igexin.push.d.c.n)) {
            return false;
        }
        com.igexin.push.d.c.n nVar = (com.igexin.push.d.c.n) obj;
        if (!nVar.d() || nVar.f == null) {
            return false;
        }
        try {
            final org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) nVar.f);
            if (jSONObject.has("action") && !jSONObject.getString("action").equals(com.igexin.push.core.b.F) && !jSONObject.getString("action").equals(com.igexin.push.core.b.G) && jSONObject.has(com.igexin.push.core.b.C)) {
                com.igexin.sdk.main.FeedbackImpl.getInstance().asyncFeedback(new java.lang.Runnable() { // from class: com.igexin.push.core.a.b.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        java.lang.String strOptString = jSONObject.optString(com.igexin.push.core.b.C);
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.a(strOptString);
                    }
                });
            }
            if (!jSONObject.has("action")) {
                return false;
            }
            com.igexin.push.core.a.b.a aVar = c.get(jSONObject.getString("action"));
            if (aVar != null) {
                return aVar.a(obj, jSONObject);
            }
            return false;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
