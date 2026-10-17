package com.up366.asecengine.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class KeyValue {
    public final java.lang.String key;
    public final java.lang.String value;

    public KeyValue(java.lang.String str, java.lang.String str2) {
        this.key = str;
        this.value = str2;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        java.lang.String str = this.key;
        java.lang.String str2 = ((com.up366.asecengine.model.KeyValue) obj).key;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        java.lang.String str = this.key;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public java.lang.String toString() {
        return "KeyValue{key='" + this.key + "', value=" + this.value + '}';
    }
}
