package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class x {
    public static java.util.Map<java.lang.Class<? extends com.zx.a.I8b7.e>, com.zx.a.I8b7.e> a = new java.util.HashMap();

    public static void a(android.content.Context context, java.lang.Class<? extends com.zx.a.I8b7.e> cls, java.lang.Class<? extends com.zx.a.I8b7.f>... clsArr) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        android.content.Context applicationContext = context.getApplicationContext();
        com.zx.a.I8b7.e eVarNewInstance = (com.zx.a.I8b7.e) ((java.util.HashMap) a).get(cls);
        if (eVarNewInstance == null) {
            eVarNewInstance = cls.newInstance();
            ((java.util.HashMap) a).put(cls, eVarNewInstance);
        }
        for (java.lang.Class<? extends com.zx.a.I8b7.f> cls2 : clsArr) {
            com.zx.a.I8b7.f fVarNewInstance = eVarNewInstance.a.get(cls2);
            if (fVarNewInstance == null) {
                fVarNewInstance = cls2.newInstance();
                eVarNewInstance.a.put(cls2, fVarNewInstance);
            }
            fVarNewInstance.a = eVarNewInstance;
        }
        if (eVarNewInstance.c.getAndSet(true)) {
            return;
        }
        eVarNewInstance.b = new com.zx.a.I8b7.d(eVarNewInstance, applicationContext, eVarNewInstance.a(), null, eVarNewInstance.c());
        java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.f>> it = eVarNewInstance.a.keySet().iterator();
        while (it.hasNext()) {
            eVarNewInstance.a.get(it.next()).getClass();
        }
    }

    public static <T extends com.zx.a.I8b7.f> T a(java.lang.Class<? extends com.zx.a.I8b7.e> cls, java.lang.Class<T> cls2) {
        com.zx.a.I8b7.e eVar = (com.zx.a.I8b7.e) ((java.util.HashMap) a).get(cls);
        if (eVar != null) {
            T t = (T) eVar.a.get(cls2);
            if (t != null) {
                return t;
            }
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("table ");
            sbA.append(cls2.getSimpleName());
            sbA.append(" has not been added to db ");
            sbA.append(eVar.a());
            throw new java.lang.RuntimeException(sbA.toString());
        }
        java.lang.StringBuilder sbA2 = com.zx.a.I8b7.q3.a("db ");
        sbA2.append(cls.getSimpleName());
        sbA2.append(" has not been initialized");
        throw new java.lang.RuntimeException(sbA2.toString());
    }
}
