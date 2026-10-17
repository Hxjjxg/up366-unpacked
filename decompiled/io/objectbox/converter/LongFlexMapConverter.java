package io.objectbox.converter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LongFlexMapConverter extends io.objectbox.converter.FlexObjectConverter {
    @Override // io.objectbox.converter.FlexObjectConverter
    protected void checkMapKeyType(java.lang.Object obj) {
        if (!(obj instanceof java.lang.Long)) {
            throw new java.lang.IllegalArgumentException("Map keys must be Long");
        }
    }

    @Override // io.objectbox.converter.FlexObjectConverter
    java.lang.Object convertToKey(java.lang.String str) {
        return java.lang.Long.valueOf(str);
    }
}
