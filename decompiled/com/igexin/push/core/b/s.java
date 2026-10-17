package com.igexin.push.core.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class s extends com.igexin.push.extension.mod.BaseActionBean {
    public java.lang.String a;
    public boolean b;
    public boolean c;
    public java.lang.String d;

    private void a(java.lang.String str) {
        this.a = str;
    }

    private java.lang.String b() {
        return this.a;
    }

    private void b(java.lang.String str) {
        this.d = str;
    }

    private boolean c() {
        return this.b;
    }

    private void d() {
        this.b = true;
    }

    private boolean e() {
        return this.c;
    }

    private void f() {
        this.c = true;
    }

    private java.lang.String g() {
        return this.d;
    }

    public final java.lang.String a() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.StringBuilder sb2;
        java.lang.String str2;
        java.lang.String string = this.a;
        if (this.b) {
            if (string.indexOf("?") > 0) {
                sb2 = new java.lang.StringBuilder();
                sb2.append(string);
                str2 = "&cid=";
            } else {
                sb2 = new java.lang.StringBuilder();
                sb2.append(string);
                str2 = "?cid=";
            }
            sb2.append(str2);
            sb2.append(com.igexin.push.core.e.A);
            string = sb2.toString();
        }
        if (!this.c) {
            return string;
        }
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        java.lang.String strH = com.igexin.push.core.d.h();
        if (strH == null) {
            return string;
        }
        if (string.indexOf("?") > 0) {
            sb = new java.lang.StringBuilder();
            sb.append(string);
            str = "&nettype=";
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(string);
            str = "?nettype=";
        }
        sb.append(str);
        sb.append(strH);
        return sb.toString();
    }
}
