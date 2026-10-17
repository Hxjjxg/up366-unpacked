package io.objectbox.converter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class StringLongMapConverter extends io.objectbox.converter.StringFlexMapConverter {
    @Override // io.objectbox.converter.FlexObjectConverter
    protected boolean shouldRestoreAsLong(io.objectbox.flatbuffers.FlexBuffers.Reference reference) {
        return true;
    }
}
