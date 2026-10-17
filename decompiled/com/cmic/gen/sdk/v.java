package com.cmic.gen.sdk;

/* JADX INFO: compiled from: HttpErrorResponse.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class v {
    private int a;
    private java.lang.String b;

    private v(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public int a() {
        return this.a;
    }

    public java.lang.String b() {
        return this.b;
    }

    public static com.cmic.gen.sdk.v a(int i) {
        switch (i) {
            case 102102:
                return new com.cmic.gen.sdk.v(102102, "网络异常");
            case 102223:
                return new com.cmic.gen.sdk.v(102223, "数据解析异常");
            case 102508:
                return new com.cmic.gen.sdk.v(102508, "数据网络切换失败");
            case 200025:
                return new com.cmic.gen.sdk.v(200025, "登录超时");
            case 200039:
                return new com.cmic.gen.sdk.v(200039, "电信取号接口失败");
            case 200050:
                return new com.cmic.gen.sdk.v(200050, "EOF异常");
            default:
                return new com.cmic.gen.sdk.v(i, "网络异常");
        }
    }
}
