package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bg {
    public java.lang.String b;
    public long c;
    public long d;
    public long e;

    public final java.util.HashMap b() {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, this.b);
        map.put("startTime", this.c + "");
        map.put("endTime", this.d + "");
        map.put("forcedTime", this.e + "");
        return map;
    }

    public final java.lang.String toString() {
        return "{url':" + this.b + "', startTime:" + this.c + ", endTime:" + this.d + '}';
    }
}
