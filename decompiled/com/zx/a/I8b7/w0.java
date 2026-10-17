package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class w0 implements com.zx.a.I8b7.r0 {
    @Override // com.zx.a.I8b7.r0
    public void a(int i, java.lang.String str, java.lang.String str2) {
        if (i == 1) {
            android.util.Log.v(str, str2);
            return;
        }
        if (i == 2) {
            android.util.Log.d(str, str2);
            return;
        }
        if (i == 3) {
            android.util.Log.i(str, str2);
        } else if (i == 4) {
            android.util.Log.w(str, str2);
        } else {
            if (i != 5) {
                return;
            }
            android.util.Log.e(str, str2);
        }
    }
}
