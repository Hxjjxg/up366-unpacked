package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class v {
    public static java.lang.String b() {
        return "设备信息如下：\n手机厂商 = " + android.os.Build.BRAND + "\n手机型号= " + android.os.Build.MODEL + "\n安卓版本 = " + android.os.Build.VERSION.RELEASE + "\n设备名称 = " + android.os.Build.DEVICE + "\n主板名称 = " + android.os.Build.BOARD + "\n生产制造商 = " + android.os.Build.MANUFACTURER + "\n";
    }

    public static void b(android.content.Context context) {
        java.lang.String string;
        try {
            string = context.getSharedPreferences("cu_auth", 0).getString("auth02", "");
        } catch (java.lang.Exception e) {
            com.unicom.online.account.kernel.as.b(e);
            string = "";
        }
        if (android.text.TextUtils.isEmpty(string)) {
            java.lang.String strB = com.unicom.online.account.kernel.au.b(java.util.UUID.randomUUID().toString().replace("-", "") + java.lang.System.currentTimeMillis());
            try {
                android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("cu_auth", 0).edit();
                editorEdit.putString("auth02", strB);
                editorEdit.commit();
            } catch (java.lang.Exception e2) {
                com.unicom.online.account.kernel.as.b(e2);
            }
        }
    }
}
