package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class d0 implements com.chuanglan.shanyan_sdk.c0 {
    protected static boolean e;
    private static java.lang.String f;
    protected boolean a = false;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String[] d;

    public d0(java.lang.String str, java.lang.String str2) {
        this.b = str;
        this.c = str2;
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public boolean a(android.content.Context context) {
        if (this.a) {
            return e;
        }
        if (context == null) {
            return false;
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            e = (packageManager == null || packageManager.resolveContentProvider(this.b, 0) == null) ? false : true;
        } catch (java.lang.Throwable unused) {
            e = false;
        }
        this.a = true;
        return e;
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public boolean b(android.content.Context context) {
        return true;
    }

    @Override // com.chuanglan.shanyan_sdk.c0
    public java.lang.String c(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(f)) {
            try {
                android.database.Cursor cursorQuery = context.getContentResolver().query(android.net.Uri.parse("content://" + this.b + "/" + this.c), null, null, this.d, null);
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                    f = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                }
            } catch (java.lang.Throwable unused) {
                f = null;
            }
        }
        return f;
    }
}
