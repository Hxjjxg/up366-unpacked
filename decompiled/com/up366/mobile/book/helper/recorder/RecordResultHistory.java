package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecordResultHistory extends com.up366.mobile.common.logic.model.DBModel {
    public byte[] buffer;
    public java.lang.String objectId;
    public long rowId;

    public RecordResultHistory() {
    }

    public RecordResultHistory(java.lang.String str, byte[] bArr) {
        this.objectId = str;
        this.buffer = bArr;
    }
}
