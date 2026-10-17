package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class Y {
    private static int a;

    public static com.chuanglan.shanyan_sdk.c0 a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("SAMSUNG")) {
            a = 10;
        }
        if (str.equals("XIAOMI")) {
            a = 5;
        }
        if (str.equals("BLACKSHARK")) {
            a = 4;
        }
        if (str.equals("IQOO")) {
            a = 1;
        }
        if (str.equals(com.up366.multimediav2.util.RomUtils.ROM_OPPO)) {
            a = 0;
        }
        if (str.equals(com.up366.multimediav2.util.RomUtils.ROM_VIVO)) {
            a = 2;
        }
        if (str.equals("HONOR")) {
            a = 6;
        }
        if (str.equals("MEIZU")) {
            a = 9;
        }
        if (str.equals("REDMI")) {
            a = 3;
        }
        if (str.equals("HUA_WEI")) {
            a = 7;
        }
        if (str.equals("HUAWEI")) {
            a = 8;
        }
        switch (a) {
        }
        return null;
    }
}
