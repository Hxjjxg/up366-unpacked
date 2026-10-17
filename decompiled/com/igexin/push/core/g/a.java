package com.igexin.push.core.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class a<T> {
    public final com.igexin.push.core.g.a<T> a(final com.igexin.push.core.g.a<? super T> aVar) {
        return new com.igexin.push.core.g.a<T>() { // from class: com.igexin.push.core.g.a.1
            @Override // com.igexin.push.core.g.a
            public final void a(T t) {
                com.igexin.push.core.g.a.this.a(t);
                com.igexin.push.core.g.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(t);
                }
            }
        };
    }

    public abstract void a(T t);
}
