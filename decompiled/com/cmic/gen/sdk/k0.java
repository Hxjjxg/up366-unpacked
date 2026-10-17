package com.cmic.gen.sdk;

/* JADX INFO: compiled from: MeiZuOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class k0 extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;

    k0(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        try {
            android.database.Cursor cursorQuery = this.a.getContentResolver().query(android.net.Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new java.lang.String[]{"oaid"}, null);
            if (cursorQuery == null) {
                return "";
            }
            cursorQuery.moveToFirst();
            int columnIndex = cursorQuery.getColumnIndex("value");
            java.lang.String string = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : "";
            cursorQuery.close();
            return string;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
