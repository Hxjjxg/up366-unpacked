package io.objectbox.sync;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface ObjectsMessageBuilder {
    io.objectbox.sync.ObjectsMessageBuilder addBytes(long j, byte[] bArr, boolean z);

    io.objectbox.sync.ObjectsMessageBuilder addString(long j, java.lang.String str);

    boolean send();
}
