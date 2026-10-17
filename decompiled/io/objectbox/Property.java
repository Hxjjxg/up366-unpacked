package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Property<ENTITY> implements java.io.Serializable {
    private static final long serialVersionUID = 8613291105982758093L;
    public final java.lang.Class<? extends io.objectbox.converter.PropertyConverter> converterClass;
    public final java.lang.Class<?> customType;
    public final java.lang.String dbName;
    public final io.objectbox.EntityInfo<ENTITY> entity;
    public final int id;
    private boolean idVerified;
    public final boolean isId;
    public final boolean isVirtual;
    public final java.lang.String name;
    public final int ordinal;
    public final java.lang.Class<?> type;

    public Property(io.objectbox.EntityInfo<ENTITY> entityInfo, int i, int i2, java.lang.Class<?> cls, java.lang.String str) {
        this(entityInfo, i, i2, cls, str, false, str, null, null);
    }

    public Property(io.objectbox.EntityInfo<ENTITY> entityInfo, int i, int i2, java.lang.Class<?> cls, java.lang.String str, boolean z) {
        this(entityInfo, i, i2, cls, str, false, z, str, null, null);
    }

    public Property(io.objectbox.EntityInfo<ENTITY> entityInfo, int i, int i2, java.lang.Class<?> cls, java.lang.String str, boolean z, @javax.annotation.Nullable java.lang.String str2) {
        this(entityInfo, i, i2, cls, str, z, str2, null, null);
    }

    public Property(io.objectbox.EntityInfo<ENTITY> entityInfo, int i, int i2, java.lang.Class<?> cls, java.lang.String str, boolean z, @javax.annotation.Nullable java.lang.String str2, @javax.annotation.Nullable java.lang.Class<? extends io.objectbox.converter.PropertyConverter> cls2, @javax.annotation.Nullable java.lang.Class<?> cls3) {
        this(entityInfo, i, i2, cls, str, z, false, str2, cls2, cls3);
    }

    public Property(io.objectbox.EntityInfo<ENTITY> entityInfo, int i, int i2, java.lang.Class<?> cls, java.lang.String str, boolean z, boolean z2, @javax.annotation.Nullable java.lang.String str2, @javax.annotation.Nullable java.lang.Class<? extends io.objectbox.converter.PropertyConverter> cls2, @javax.annotation.Nullable java.lang.Class<?> cls3) {
        this.entity = entityInfo;
        this.ordinal = i;
        this.id = i2;
        this.type = cls;
        this.name = str;
        this.isId = z;
        this.isVirtual = z2;
        this.dbName = str2;
        this.converterClass = cls2;
        this.customType = cls3;
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> isNull() {
        return new io.objectbox.query.PropertyQueryConditionImpl.NullCondition(this, io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.IS_NULL);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notNull() {
        return new io.objectbox.query.PropertyQueryConditionImpl.NullCondition(this, io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.NOT_NULL);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(boolean z) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.EQUAL, z);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEqual(boolean z) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL, z);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(short s) {
        return equal(s);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEqual(short s) {
        return notEqual(s);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(short s) {
        return greater(s);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greaterOrEqual(short s) {
        return greaterOrEqual(s);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(short s) {
        return less(s);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> lessOrEqual(short s) {
        return lessOrEqual(s);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> between(short s, short s2) {
        return between(s, s2);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(int i) {
        return equal(i);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEqual(int i) {
        return notEqual(i);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(int i) {
        return greater(i);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greaterOrEqual(int i) {
        return greaterOrEqual(i);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(int i) {
        return less(i);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> lessOrEqual(int i) {
        return lessOrEqual(i);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> between(int i, int i2) {
        return between(i, i2);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> oneOf(int[] iArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.IN, iArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notOneOf(int[] iArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.NOT_IN, iArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(long j) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.EQUAL, j);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEqual(long j) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL, j);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(long j) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER, j);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greaterOrEqual(long j) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER_OR_EQUAL, j);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(long j) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS, j);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> lessOrEqual(long j) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS_OR_EQUAL, j);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> between(long j, long j2) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition.Operation.BETWEEN, j, j2);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> oneOf(long[] jArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.IN, jArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notOneOf(long[] jArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.NOT_IN, jArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(double d, double d2) {
        return new io.objectbox.query.PropertyQueryConditionImpl.DoubleDoubleCondition(this, io.objectbox.query.PropertyQueryConditionImpl.DoubleDoubleCondition.Operation.BETWEEN, d - d2, d + d2);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(double d) {
        return new io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition(this, io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER, d);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greaterOrEqual(double d) {
        return new io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition(this, io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER_OR_EQUAL, d);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(double d) {
        return new io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition(this, io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.LESS, d);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> lessOrEqual(double d) {
        return new io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition(this, io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.LESS_OR_EQUAL, d);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> between(double d, double d2) {
        return new io.objectbox.query.PropertyQueryConditionImpl.DoubleDoubleCondition(this, io.objectbox.query.PropertyQueryConditionImpl.DoubleDoubleCondition.Operation.BETWEEN, d, d2);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(java.util.Date date) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.EQUAL, date);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEqual(java.util.Date date) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL, date);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(java.util.Date date) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER, date);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greaterOrEqual(java.util.Date date) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER_OR_EQUAL, date);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(java.util.Date date) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS, date);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> lessOrEqual(java.util.Date date) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS_OR_EQUAL, date);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> between(java.util.Date date, java.util.Date date2) {
        return new io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition(this, io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition.Operation.BETWEEN, date, date2);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(java.lang.String str) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.EQUAL, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.EQUAL, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEqual(java.lang.String str) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.NOT_EQUAL, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEqual(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.NOT_EQUAL, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(java.lang.String str) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.GREATER, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.GREATER, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greaterOrEqual(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.GREATER_OR_EQUAL, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(java.lang.String str) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.LESS, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.LESS, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> lessOrEqual(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.LESS_OR_EQUAL, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> contains(java.lang.String str) {
        checkNotStringArray();
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> contains(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        checkNotStringArray();
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS, str, stringOrder);
    }

    private void checkNotStringArray() {
        if (java.lang.String[].class == this.type) {
            throw new java.lang.IllegalArgumentException("For a String[] property use containsElement() instead.");
        }
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> containsElement(java.lang.String str) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS_ELEMENT, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> containsElement(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS_ELEMENT, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> containsKeyValue(java.lang.String str, java.lang.String str2) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringStringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringStringCondition.Operation.CONTAINS_KEY_VALUE, str, str2, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> containsKeyValue(java.lang.String str, java.lang.String str2, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringStringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringStringCondition.Operation.CONTAINS_KEY_VALUE, str, str2, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> startsWith(java.lang.String str) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.STARTS_WITH, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> startsWith(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.STARTS_WITH, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> endsWith(java.lang.String str) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.ENDS_WITH, str);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> endsWith(java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.ENDS_WITH, str, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> oneOf(java.lang.String[] strArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition.Operation.IN, strArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> oneOf(java.lang.String[] strArr, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        return new io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition.Operation.IN, strArr, stringOrder);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> equal(byte[] bArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.EQUAL, bArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greater(byte[] bArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER, bArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> greaterOrEqual(byte[] bArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER_OR_EQUAL, bArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> less(byte[] bArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS, bArr);
    }

    public io.objectbox.query.PropertyQueryCondition<ENTITY> lessOrEqual(byte[] bArr) {
        return new io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition(this, io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS_OR_EQUAL, bArr);
    }

    @java.lang.Deprecated
    public io.objectbox.query.PropertyQueryCondition<ENTITY> eq(java.lang.Object obj) {
        if (obj instanceof java.lang.Long) {
            return equal(((java.lang.Long) obj).longValue());
        }
        if (obj instanceof java.lang.Integer) {
            return equal(((java.lang.Integer) obj).intValue());
        }
        if (obj instanceof java.lang.String) {
            return equal((java.lang.String) obj);
        }
        throw new java.lang.IllegalArgumentException("Only LONG, INTEGER or STRING values are supported.");
    }

    @java.lang.Deprecated
    public io.objectbox.query.PropertyQueryCondition<ENTITY> notEq(java.lang.Object obj) {
        if (obj instanceof java.lang.Long) {
            return notEqual(((java.lang.Long) obj).longValue());
        }
        if (obj instanceof java.lang.Integer) {
            return notEqual(((java.lang.Integer) obj).intValue());
        }
        if (obj instanceof java.lang.String) {
            return notEqual((java.lang.String) obj);
        }
        throw new java.lang.IllegalArgumentException("Only LONG, INTEGER or STRING values are supported.");
    }

    @java.lang.Deprecated
    public io.objectbox.query.PropertyQueryCondition<ENTITY> in(java.lang.Object... objArr) {
        int i = 0;
        java.lang.Object obj = objArr[0];
        if (obj instanceof java.lang.Long) {
            long[] jArr = new long[objArr.length];
            while (i < objArr.length) {
                jArr[i] = ((java.lang.Long) objArr[i]).longValue();
                i++;
            }
            return oneOf(jArr);
        }
        if (obj instanceof java.lang.Integer) {
            int[] iArr = new int[objArr.length];
            while (i < objArr.length) {
                iArr[i] = ((java.lang.Integer) objArr[i]).intValue();
                i++;
            }
            return oneOf(iArr);
        }
        throw new java.lang.IllegalArgumentException("The IN condition only supports LONG or INTEGER values.");
    }

    @java.lang.Deprecated
    public io.objectbox.query.PropertyQueryCondition<ENTITY> in(java.util.Collection<?> collection) {
        return in(collection.toArray());
    }

    @java.lang.Deprecated
    public io.objectbox.query.PropertyQueryCondition<ENTITY> gt(java.lang.Object obj) {
        if (obj instanceof java.lang.Long) {
            return greater(((java.lang.Long) obj).longValue());
        }
        if (obj instanceof java.lang.Integer) {
            return greater(((java.lang.Integer) obj).intValue());
        }
        if (obj instanceof java.lang.Double) {
            return greater(((java.lang.Double) obj).doubleValue());
        }
        if (obj instanceof java.lang.Float) {
            return greater(((java.lang.Float) obj).floatValue());
        }
        throw new java.lang.IllegalArgumentException("Only LONG, INTEGER, DOUBLE or FLOAT values are supported.");
    }

    @java.lang.Deprecated
    public io.objectbox.query.PropertyQueryCondition<ENTITY> lt(java.lang.Object obj) {
        if (obj instanceof java.lang.Long) {
            return less(((java.lang.Long) obj).longValue());
        }
        if (obj instanceof java.lang.Integer) {
            return less(((java.lang.Integer) obj).intValue());
        }
        if (obj instanceof java.lang.Double) {
            return less(((java.lang.Double) obj).doubleValue());
        }
        if (obj instanceof java.lang.Float) {
            return less(((java.lang.Float) obj).floatValue());
        }
        throw new java.lang.IllegalArgumentException("Only LONG, INTEGER, DOUBLE or FLOAT values are supported.");
    }

    @java.lang.Deprecated
    public io.objectbox.query.PropertyQueryCondition<ENTITY> isNotNull() {
        return notNull();
    }

    public int getEntityId() {
        return this.entity.getEntityId();
    }

    public int getId() {
        int i = this.id;
        if (i > 0) {
            return i;
        }
        throw new java.lang.IllegalStateException("Illegal property ID " + this.id + " for " + this);
    }

    boolean isIdVerified() {
        return this.idVerified;
    }

    void verifyId(int i) {
        int i2 = this.id;
        if (i2 <= 0) {
            throw new java.lang.IllegalStateException("Illegal property ID " + this.id + " for " + this);
        }
        if (i2 != i) {
            throw new io.objectbox.exception.DbException(this + " does not match ID in DB: " + i);
        }
        this.idVerified = true;
    }

    public java.lang.String toString() {
        return "Property \"" + this.name + "\" (ID: " + this.id + ")";
    }
}
