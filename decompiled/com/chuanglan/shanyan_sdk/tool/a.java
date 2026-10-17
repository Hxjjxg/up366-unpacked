package com.chuanglan.shanyan_sdk.tool;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class a {
    private static volatile com.chuanglan.shanyan_sdk.tool.a d;
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig a;
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig b = null;
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig c = null;

    public static com.chuanglan.shanyan_sdk.tool.a b() {
        if (d == null) {
            synchronized (com.chuanglan.shanyan_sdk.tool.a.class) {
                if (d == null) {
                    d = new com.chuanglan.shanyan_sdk.tool.a();
                }
            }
        }
        return d;
    }

    public void a(com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig2, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig3) {
        this.c = shanYanUIConfig;
        this.b = shanYanUIConfig2;
        this.a = shanYanUIConfig3;
    }

    public com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig c() {
        return this.b;
    }

    public void d() {
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig = this.a;
        if (shanYanUIConfig != null) {
            shanYanUIConfig.remove();
            this.a = null;
        }
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig2 = this.b;
        if (shanYanUIConfig2 != null) {
            shanYanUIConfig2.remove();
            this.b = null;
        }
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig3 = this.c;
        if (shanYanUIConfig3 != null) {
            shanYanUIConfig3.remove();
            this.c = null;
        }
    }

    public com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig a() {
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig = this.c;
        if (shanYanUIConfig != null) {
            return shanYanUIConfig;
        }
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig2 = this.a;
        return shanYanUIConfig2 != null ? shanYanUIConfig2 : new com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig.Builder().build();
    }
}
