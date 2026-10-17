package io.objectbox.converter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class IntegerFlexMapConverter extends io.objectbox.converter.FlexObjectConverter {
    @Override // io.objectbox.converter.FlexObjectConverter
    protected void checkMapKeyType(java.lang.Object obj) {
        if (!(obj instanceof java.lang.Integer)) {
            throw new java.lang.IllegalArgumentException("Map keys must be Integer");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.objectbox.converter.FlexObjectConverter
    public java.lang.Integer convertToKey(java.lang.String str) {
        return java.lang.Integer.valueOf(str);
    }
}
