package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class bh {
    public static java.lang.Boolean b(java.lang.String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || com.igexin.push.core.b.m.equals(str)) ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public static java.lang.Boolean c(java.lang.String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || com.igexin.push.core.b.m.equals(str) || str.equals("")) ? java.lang.Boolean.FALSE : java.lang.Boolean.TRUE;
    }
}
