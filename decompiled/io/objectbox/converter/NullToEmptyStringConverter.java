package io.objectbox.converter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class NullToEmptyStringConverter implements io.objectbox.converter.PropertyConverter<java.lang.String, java.lang.String> {
    @Override // io.objectbox.converter.PropertyConverter
    public java.lang.String convertToDatabaseValue(java.lang.String str) {
        return str;
    }

    @Override // io.objectbox.converter.PropertyConverter
    public java.lang.String convertToEntityProperty(@javax.annotation.Nullable java.lang.String str) {
        return str == null ? "" : str;
    }
}
