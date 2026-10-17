package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PropertyQuery {
    boolean distinct;
    boolean enableNull;
    boolean noCaseIfDistinct = true;
    double nullValueDouble;
    float nullValueFloat;
    long nullValueLong;
    java.lang.String nullValueString;
    final io.objectbox.Property<?> property;
    final int propertyId;
    final io.objectbox.query.Query<?> query;
    final long queryHandle;
    boolean unique;

    native double nativeAvg(long j, long j2, int i);

    native long nativeAvgLong(long j, long j2, int i);

    native long nativeCount(long j, long j2, int i, boolean z);

    native byte[] nativeFindBytes(long j, long j2, int i, boolean z, boolean z2, byte b);

    native char[] nativeFindChars(long j, long j2, int i, boolean z, boolean z2, char c);

    native double[] nativeFindDoubles(long j, long j2, int i, boolean z, boolean z2, double d);

    native float[] nativeFindFloats(long j, long j2, int i, boolean z, boolean z2, float f);

    native int[] nativeFindInts(long j, long j2, int i, boolean z, boolean z2, int i2);

    native long[] nativeFindLongs(long j, long j2, int i, boolean z, boolean z2, long j3);

    native java.lang.Object nativeFindNumber(long j, long j2, int i, boolean z, boolean z2, boolean z3, long j3, float f, double d);

    native short[] nativeFindShorts(long j, long j2, int i, boolean z, boolean z2, short s);

    native java.lang.String nativeFindString(long j, long j2, int i, boolean z, boolean z2, boolean z3, boolean z4, java.lang.String str);

    native java.lang.String[] nativeFindStrings(long j, long j2, int i, boolean z, boolean z2, boolean z3, java.lang.String str);

    native long nativeMax(long j, long j2, int i);

    native double nativeMaxDouble(long j, long j2, int i);

    native long nativeMin(long j, long j2, int i);

    native double nativeMinDouble(long j, long j2, int i);

    native long nativeSum(long j, long j2, int i);

    native double nativeSumDouble(long j, long j2, int i);

    PropertyQuery(io.objectbox.query.Query<?> query, io.objectbox.Property<?> property) {
        this.query = query;
        this.queryHandle = query.handle;
        this.property = property;
        this.propertyId = property.id;
    }

    public io.objectbox.query.PropertyQuery reset() {
        this.distinct = false;
        this.noCaseIfDistinct = true;
        this.unique = false;
        this.enableNull = false;
        this.nullValueDouble = 0.0d;
        this.nullValueFloat = 0.0f;
        this.nullValueString = null;
        this.nullValueLong = 0L;
        return this;
    }

    public io.objectbox.query.PropertyQuery distinct() {
        this.distinct = true;
        return this;
    }

    public io.objectbox.query.PropertyQuery distinct(io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        if (this.property.type != java.lang.String.class) {
            throw new java.lang.RuntimeException("Reserved for string properties, but got " + this.property);
        }
        this.distinct = true;
        this.noCaseIfDistinct = stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_INSENSITIVE;
        return this;
    }

    public io.objectbox.query.PropertyQuery unique() {
        this.unique = true;
        return this;
    }

    public io.objectbox.query.PropertyQuery nullValue(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("Null values are not allowed");
        }
        boolean z = obj instanceof java.lang.String;
        boolean z2 = obj instanceof java.lang.Number;
        if (!z && !z2) {
            throw new java.lang.IllegalArgumentException("Unsupported value class: " + obj.getClass());
        }
        this.enableNull = true;
        this.nullValueString = z ? (java.lang.String) obj : null;
        boolean z3 = obj instanceof java.lang.Float;
        this.nullValueFloat = z3 ? ((java.lang.Float) obj).floatValue() : 0.0f;
        boolean z4 = obj instanceof java.lang.Double;
        this.nullValueDouble = z4 ? ((java.lang.Double) obj).doubleValue() : 0.0d;
        this.nullValueLong = (!z2 || z3 || z4) ? 0L : ((java.lang.Number) obj).longValue();
        return this;
    }

    public java.lang.String[] findStrings() {
        return (java.lang.String[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1410lambda$findStrings$0$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findStrings$0$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.String[] m1410lambda$findStrings$0$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindStrings(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.distinct && this.noCaseIfDistinct, this.enableNull, this.nullValueString);
    }

    public long[] findLongs() {
        return (long[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1406lambda$findLongs$1$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findLongs$1$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ long[] m1406lambda$findLongs$1$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindLongs(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, this.nullValueLong);
    }

    public int[] findInts() {
        return (int[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda16
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1405lambda$findInts$2$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findInts$2$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ int[] m1405lambda$findInts$2$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindInts(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (int) this.nullValueLong);
    }

    public short[] findShorts() {
        return (short[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1408lambda$findShorts$3$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findShorts$3$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ short[] m1408lambda$findShorts$3$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindShorts(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (short) this.nullValueLong);
    }

    public char[] findChars() {
        return (char[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1402lambda$findChars$4$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findChars$4$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ char[] m1402lambda$findChars$4$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindChars(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (char) this.nullValueLong);
    }

    public byte[] findBytes() {
        return (byte[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda17
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1401lambda$findBytes$5$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findBytes$5$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ byte[] m1401lambda$findBytes$5$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindBytes(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (byte) this.nullValueLong);
    }

    public float[] findFloats() {
        return (float[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1404lambda$findFloats$6$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findFloats$6$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ float[] m1404lambda$findFloats$6$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindFloats(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, this.nullValueFloat);
    }

    public double[] findDoubles() {
        return (double[]) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1403lambda$findDoubles$7$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findDoubles$7$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ double[] m1403lambda$findDoubles$7$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindDoubles(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, this.nullValueDouble);
    }

    public java.lang.String findString() {
        return (java.lang.String) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1409lambda$findString$8$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findString$8$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.String m1409lambda$findString$8$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindString(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.unique, this.distinct, this.distinct && !this.noCaseIfDistinct, this.enableNull, this.nullValueString);
    }

    private java.lang.Object findNumber() {
        return this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1407lambda$findNumber$9$ioobjectboxqueryPropertyQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findNumber$9$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Object m1407lambda$findNumber$9$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return nativeFindNumber(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.unique, this.distinct, this.enableNull, this.nullValueLong, this.nullValueFloat, this.nullValueDouble);
    }

    public java.lang.Long findLong() {
        return (java.lang.Long) findNumber();
    }

    public java.lang.Integer findInt() {
        return (java.lang.Integer) findNumber();
    }

    public java.lang.Short findShort() {
        return (java.lang.Short) findNumber();
    }

    public java.lang.Character findChar() {
        return (java.lang.Character) findNumber();
    }

    public java.lang.Byte findByte() {
        return (java.lang.Byte) findNumber();
    }

    public java.lang.Boolean findBoolean() {
        return (java.lang.Boolean) findNumber();
    }

    public java.lang.Float findFloat() {
        return (java.lang.Float) findNumber();
    }

    public java.lang.Double findDouble() {
        return (java.lang.Double) findNumber();
    }

    public long sum() {
        return ((java.lang.Long) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1415lambda$sum$10$ioobjectboxqueryPropertyQuery();
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$sum$10$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Long m1415lambda$sum$10$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Long.valueOf(nativeSum(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double sumDouble() {
        return ((java.lang.Double) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1416lambda$sumDouble$11$ioobjectboxqueryPropertyQuery();
            }
        })).doubleValue();
    }

    /* JADX INFO: renamed from: lambda$sumDouble$11$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Double m1416lambda$sumDouble$11$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Double.valueOf(nativeSumDouble(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long max() {
        return ((java.lang.Long) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1411lambda$max$12$ioobjectboxqueryPropertyQuery();
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$max$12$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Long m1411lambda$max$12$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Long.valueOf(nativeMax(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double maxDouble() {
        return ((java.lang.Double) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1412lambda$maxDouble$13$ioobjectboxqueryPropertyQuery();
            }
        })).doubleValue();
    }

    /* JADX INFO: renamed from: lambda$maxDouble$13$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Double m1412lambda$maxDouble$13$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Double.valueOf(nativeMaxDouble(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long min() {
        return ((java.lang.Long) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1413lambda$min$14$ioobjectboxqueryPropertyQuery();
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$min$14$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Long m1413lambda$min$14$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Long.valueOf(nativeMin(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double minDouble() {
        return ((java.lang.Double) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda18
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1414lambda$minDouble$15$ioobjectboxqueryPropertyQuery();
            }
        })).doubleValue();
    }

    /* JADX INFO: renamed from: lambda$minDouble$15$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Double m1414lambda$minDouble$15$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Double.valueOf(nativeMinDouble(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double avg() {
        return ((java.lang.Double) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1398lambda$avg$16$ioobjectboxqueryPropertyQuery();
            }
        })).doubleValue();
    }

    /* JADX INFO: renamed from: lambda$avg$16$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Double m1398lambda$avg$16$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Double.valueOf(nativeAvg(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long avgLong() {
        return ((java.lang.Long) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1399lambda$avgLong$17$ioobjectboxqueryPropertyQuery();
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$avgLong$17$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Long m1399lambda$avgLong$17$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Long.valueOf(nativeAvgLong(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long count() {
        return ((java.lang.Long) this.query.callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.PropertyQuery$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1400lambda$count$18$ioobjectboxqueryPropertyQuery();
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$count$18$io-objectbox-query-PropertyQuery, reason: not valid java name */
    /* synthetic */ java.lang.Long m1400lambda$count$18$ioobjectboxqueryPropertyQuery() throws java.lang.Exception {
        return java.lang.Long.valueOf(nativeCount(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct));
    }
}
