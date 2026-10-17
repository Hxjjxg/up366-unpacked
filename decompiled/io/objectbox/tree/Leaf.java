package io.objectbox.tree;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Leaf {
    private final io.objectbox.tree.LeafNode node;

    public Leaf(io.objectbox.tree.LeafNode leafNode) {
        this.node = leafNode;
    }

    public long getId() {
        return this.node.id;
    }

    public long getParentBranchId() {
        return this.node.branchId;
    }

    public long getMetaId() {
        return this.node.metaId;
    }

    public short getValueType() {
        return this.node.valueType;
    }

    public boolean isInt() {
        return this.node.valueType == 6;
    }

    public boolean isDouble() {
        return this.node.valueType == 8;
    }

    public boolean isString() {
        return this.node.valueType == 23;
    }

    public boolean isStringArray() {
        return this.node.valueType == 24;
    }

    private void verifyIsInt() {
        if (isInt()) {
            return;
        }
        throw new java.lang.IllegalStateException("value is not integer (" + ((int) this.node.valueType) + ")");
    }

    private void verifyIsDouble() {
        if (isDouble()) {
            return;
        }
        throw new java.lang.IllegalStateException("value is not floating point (" + ((int) this.node.valueType) + ")");
    }

    private void verifyIsString() {
        if (isString()) {
            return;
        }
        throw new java.lang.IllegalStateException("value is not string (" + ((int) this.node.valueType) + ")");
    }

    private void verifyIsStringArray() {
        if (!isStringArray()) {
            throw new java.lang.IllegalStateException("value is not string array");
        }
    }

    public long getInt() {
        verifyIsInt();
        return this.node.integerValue;
    }

    public double getDouble() {
        verifyIsDouble();
        return this.node.floatingValue;
    }

    @javax.annotation.Nullable
    public java.lang.String getString() {
        verifyIsString();
        if (this.node.objectValue instanceof java.lang.String) {
            return (java.lang.String) this.node.objectValue;
        }
        return new java.lang.String((byte[]) this.node.objectValue, java.nio.charset.StandardCharsets.UTF_8);
    }

    @javax.annotation.Nullable
    public java.lang.String[] getStringArray() {
        verifyIsStringArray();
        return (java.lang.String[]) this.node.objectValue;
    }

    @javax.annotation.Nullable
    public java.lang.Long asInt() {
        java.lang.String string;
        if (isInt()) {
            return java.lang.Long.valueOf(getInt());
        }
        if (isDouble()) {
            return java.lang.Long.valueOf((long) getDouble());
        }
        if (!isString() || (string = getString()) == null) {
            return null;
        }
        try {
            return java.lang.Long.valueOf(string);
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    @javax.annotation.Nullable
    public java.lang.Double asDouble() {
        java.lang.String string;
        if (isDouble()) {
            return java.lang.Double.valueOf(getDouble());
        }
        if (isInt()) {
            return java.lang.Double.valueOf(getInt());
        }
        if (!isString() || (string = getString()) == null) {
            return null;
        }
        try {
            return java.lang.Double.valueOf(string);
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    @javax.annotation.Nullable
    public java.lang.String asString() {
        java.lang.String[] stringArray;
        if (isString()) {
            return getString();
        }
        if (isInt()) {
            return java.lang.String.valueOf(getInt());
        }
        if (isDouble()) {
            return java.lang.String.valueOf(getDouble());
        }
        if (!isStringArray() || (stringArray = getStringArray()) == null) {
            return null;
        }
        return kotlin.UByte$.ExternalSyntheticBackport0.m(", ", stringArray);
    }

    @javax.annotation.Nullable
    public java.lang.String[] asStringArray() {
        if (isStringArray()) {
            return getStringArray();
        }
        java.lang.String strAsString = asString();
        if (strAsString != null) {
            return new java.lang.String[]{strAsString};
        }
        return null;
    }

    public void setInt(long j) {
        verifyIsInt();
        this.node.integerValue = j;
    }

    public void setDouble(double d) {
        verifyIsDouble();
        this.node.floatingValue = d;
    }

    public void setString(@javax.annotation.Nullable java.lang.String str) {
        verifyIsString();
        this.node.objectValue = str;
    }

    public void setStringArray(@javax.annotation.Nullable java.lang.String[] strArr) {
        verifyIsStringArray();
        this.node.objectValue = strArr;
    }
}
