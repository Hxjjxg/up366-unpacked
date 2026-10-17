package com.igexin.push.f;

import com.igexin.push.core.e.c.AnonymousClass1;
import com.igexin.push.core.e.c.AnonymousClass2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class c implements com.igexin.push.f.b.c {
    public static final java.lang.String a = "com.igexin.push.f.c";
    private static final long c = 3600000;
    private long b = 0;

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
        this.b = j;
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        com.igexin.c.a.c.a.a("start cron-keep task", new java.lang.Object[0]);
        com.igexin.sdk.main.FeedbackImpl.getInstance().clearFeedbackMessage();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.c.a().new AnonymousClass2(), false, true);
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.c.a().new AnonymousClass1(), false, true);
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.j();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.f.c.1
            @Override // com.igexin.push.b.d
            public final void a_() throws java.lang.Exception {
                com.igexin.push.g.k.h();
                com.igexin.push.g.k.i();
            }
        }, false, true);
    }

    @Override // com.igexin.push.f.b.c
    public final boolean d() {
        return java.lang.System.currentTimeMillis() - this.b > 3600000;
    }
}
