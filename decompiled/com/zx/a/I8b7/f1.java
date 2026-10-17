package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class f1 implements com.zx.module.base.Listener {
    public final java.util.Map<java.lang.String, java.util.Set<com.zx.a.I8b7.g1>> a = new java.util.HashMap();

    public synchronized void a(java.lang.String str, com.zx.a.I8b7.g1 g1Var) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, new java.util.HashSet());
        }
        this.a.get(str).add(g1Var);
    }

    @Override // com.zx.module.base.Listener
    public void onMessage(java.lang.String str, java.lang.String str2) {
        java.util.Set<com.zx.a.I8b7.g1> set = this.a.get(str);
        if (set != null) {
            java.util.Iterator<com.zx.a.I8b7.g1> it = set.iterator();
            while (it.hasNext()) {
                it.next().a(str2);
            }
        }
    }
}
