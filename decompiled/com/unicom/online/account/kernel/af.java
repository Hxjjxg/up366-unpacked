package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class af {
    public int b;
    public java.lang.String c;
    public java.lang.String d;
    public java.util.HashMap e = new java.util.HashMap();

    public final java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("HttpResult{statusCode=");
        sb.append(this.b);
        sb.append(", responseBody='");
        java.lang.String str2 = this.c;
        if (str2 == null) {
            str = com.igexin.push.core.b.m;
        } else if (str2.length() > 100) {
            str = this.c.substring(0, 100) + "...";
        } else {
            str = this.c;
        }
        sb.append(str);
        sb.append("', redirectUrl='");
        sb.append(this.d);
        sb.append("', headers=");
        sb.append(this.e.size());
        sb.append('}');
        return sb.toString();
    }
}
