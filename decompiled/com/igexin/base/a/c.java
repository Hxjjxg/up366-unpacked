package com.igexin.base.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class c implements com.igexin.base.a.a {
    public java.lang.String e;
    public java.lang.String f;
    final java.util.List<java.lang.String> a = new java.util.concurrent.CopyOnWriteArrayList();
    public int b = 10;
    public long c = 30000;
    private final java.util.regex.Pattern g = java.util.regex.Pattern.compile("(.+)?[$][{](.+)?[}].+");
    private final java.util.concurrent.atomic.AtomicBoolean h = new java.util.concurrent.atomic.AtomicBoolean(true);
    long d = android.os.SystemClock.elapsedRealtime();

    public c() {
        com.igexin.base.a.b bVarA = com.igexin.base.a.b.a();
        if (bVarA.a.contains(this)) {
            return;
        }
        bVarA.a.add(this);
    }

    final java.lang.String a(java.lang.String str) {
        try {
            java.util.regex.Matcher matcher = this.g.matcher(str);
            return matcher.find() ? str.replaceFirst("[$][{](.+)?[}]", new java.text.SimpleDateFormat(matcher.group(2)).format(new java.util.Date())) : str;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    @Override // com.igexin.base.a.a
    public final void enableLog(boolean z) {
        this.h.set(z);
    }

    @Override // com.igexin.base.a.a
    public final boolean isEnabled() {
        return this.h.get();
    }

    @Override // com.igexin.base.a.a
    public final void log(java.lang.String str) {
        if (isEnabled()) {
            this.a.add(str);
        }
    }
}
