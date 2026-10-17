package com.cmic.gen.sdk;

/* JADX INFO: compiled from: VivoOAID.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class y1 extends com.cmic.gen.sdk.o0 {
    private final android.content.Context a;

    y1(android.content.Context context) {
        this.a = context;
    }

    @Override // com.cmic.gen.sdk.o0
    public java.lang.String a() {
        java.lang.String string;
        android.net.Uri uri = android.net.Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        android.content.ContentResolver contentResolver = this.a.getContentResolver();
        string = "";
        if (contentResolver == null) {
            return "";
        }
        android.database.Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToNext();
            int columnIndex = cursorQuery.getColumnIndex("value");
            string = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : "";
            cursorQuery.close();
        }
        return string;
    }
}
