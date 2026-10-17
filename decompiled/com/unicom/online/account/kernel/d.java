package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d {
    public int b;
    public long c;
    public java.lang.String d;
    public int e;
    public com.unicom.online.account.kernel.bg f;
    public com.unicom.online.account.kernel.bg g;
    public com.unicom.online.account.kernel.bg h;
    public com.unicom.online.account.kernel.bg i;

    public final void b(com.unicom.online.account.kernel.bg bgVar) {
        int i = this.e;
        if (i < 10) {
            this.e = i + 1;
        } else {
            this.e = 10;
        }
        int i2 = this.e;
        if (i2 == 1) {
            this.f = bgVar;
            return;
        }
        if (i2 == 2) {
            this.g = bgVar;
        } else if (i2 == 3) {
            this.h = bgVar;
        } else {
            if (i2 != 4) {
                return;
            }
            this.i = bgVar;
        }
    }

    public final java.lang.String toString() {
        return "{ifProtal:" + this.b + ", step1:" + this.f + ", step2:" + this.g + ", step3:" + this.h + ", step4:" + this.i + '}';
    }
}
