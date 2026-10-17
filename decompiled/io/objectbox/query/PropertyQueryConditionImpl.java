package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class PropertyQueryConditionImpl<T> extends io.objectbox.query.QueryConditionImpl<T> implements io.objectbox.query.PropertyQueryCondition<T> {
    private java.lang.String alias;
    public final io.objectbox.Property<T> property;

    abstract void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder);

    @Override // io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
    public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
        return super.and(queryCondition);
    }

    @Override // io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
    public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
        return super.or(queryCondition);
    }

    PropertyQueryConditionImpl(io.objectbox.Property<T> property) {
        this.property = property;
    }

    @Override // io.objectbox.query.PropertyQueryCondition
    public io.objectbox.query.QueryCondition<T> alias(java.lang.String str) {
        this.alias = str;
        return this;
    }

    @Override // io.objectbox.query.QueryConditionImpl
    public void apply(io.objectbox.query.QueryBuilder<T> queryBuilder) {
        applyCondition(queryBuilder);
        java.lang.String str = this.alias;
        if (str == null || str.length() == 0) {
            return;
        }
        queryBuilder.parameterAlias(this.alias);
    }

    public static class NullCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation op;

        public enum Operation {
            IS_NULL,
            NOT_NULL
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public NullCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation operation) {
            super(property);
            this.op = operation;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            int i = io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.isNull(this.property);
            } else {
                if (i == 2) {
                    queryBuilder.notNull(this.property);
                    return;
                }
                throw new java.lang.UnsupportedOperationException(this.op + " is not supported");
            }
        }
    }

    public static class IntArrayCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation op;
        private final int[] value;

        public enum Operation {
            IN,
            NOT_IN
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public IntArrayCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation operation, int[] iArr) {
            super(property);
            this.op = operation;
            this.value = iArr;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            int i = io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.in((io.objectbox.Property) this.property, this.value);
            } else {
                if (i == 2) {
                    queryBuilder.notIn((io.objectbox.Property) this.property, this.value);
                    return;
                }
                throw new java.lang.UnsupportedOperationException(this.op + " is not supported for int[]");
            }
        }
    }

    public static class LongCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation op;
        private final long value;

        public enum Operation {
            EQUAL,
            NOT_EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public LongCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation operation, long j) {
            super(property);
            this.op = operation;
            this.value = j;
        }

        public LongCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation operation, boolean z) {
            this(property, operation, z ? 1L : 0L);
        }

        public LongCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation operation, java.util.Date date) {
            this(property, operation, date.getTime());
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            switch (io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation[this.op.ordinal()]) {
                case 1:
                    queryBuilder.equal(this.property, this.value);
                    return;
                case 2:
                    queryBuilder.notEqual(this.property, this.value);
                    return;
                case 3:
                    queryBuilder.greater((io.objectbox.Property) this.property, this.value);
                    return;
                case 4:
                    queryBuilder.greaterOrEqual((io.objectbox.Property) this.property, this.value);
                    return;
                case 5:
                    queryBuilder.less((io.objectbox.Property) this.property, this.value);
                    return;
                case 6:
                    queryBuilder.lessOrEqual((io.objectbox.Property) this.property, this.value);
                    return;
                default:
                    throw new java.lang.UnsupportedOperationException(this.op + " is not supported for String");
            }
        }
    }

    public static class LongLongCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final long leftValue;
        private final io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition.Operation op;
        private final long rightValue;

        public enum Operation {
            BETWEEN
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public LongLongCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition.Operation operation, long j, long j2) {
            super(property);
            this.op = operation;
            this.leftValue = j;
            this.rightValue = j2;
        }

        public LongLongCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition.Operation operation, java.util.Date date, java.util.Date date2) {
            this(property, operation, date.getTime(), date2.getTime());
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            if (this.op == io.objectbox.query.PropertyQueryConditionImpl.LongLongCondition.Operation.BETWEEN) {
                queryBuilder.between((io.objectbox.Property) this.property, this.leftValue, this.rightValue);
                return;
            }
            throw new java.lang.UnsupportedOperationException(this.op + " is not supported with two long values");
        }
    }

    public static class LongArrayCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation op;
        private final long[] value;

        public enum Operation {
            IN,
            NOT_IN
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public LongArrayCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation operation, long[] jArr) {
            super(property);
            this.op = operation;
            this.value = jArr;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            int i = io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.in(this.property, this.value);
            } else {
                if (i == 2) {
                    queryBuilder.notIn(this.property, this.value);
                    return;
                }
                throw new java.lang.UnsupportedOperationException(this.op + " is not supported for long[]");
            }
        }
    }

    public static class DoubleCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation op;
        private final double value;

        public enum Operation {
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public DoubleCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation operation, double d) {
            super(property);
            this.op = operation;
            this.value = d;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            int i = io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.greater(this.property, this.value);
                return;
            }
            if (i == 2) {
                queryBuilder.greaterOrEqual(this.property, this.value);
                return;
            }
            if (i == 3) {
                queryBuilder.less(this.property, this.value);
            } else {
                if (i == 4) {
                    queryBuilder.lessOrEqual(this.property, this.value);
                    return;
                }
                throw new java.lang.UnsupportedOperationException(this.op + " is not supported for double");
            }
        }
    }

    public static class DoubleDoubleCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final double leftValue;
        private final io.objectbox.query.PropertyQueryConditionImpl.DoubleDoubleCondition.Operation op;
        private final double rightValue;

        public enum Operation {
            BETWEEN
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public DoubleDoubleCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.DoubleDoubleCondition.Operation operation, double d, double d2) {
            super(property);
            this.op = operation;
            this.leftValue = d;
            this.rightValue = d2;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            if (this.op == io.objectbox.query.PropertyQueryConditionImpl.DoubleDoubleCondition.Operation.BETWEEN) {
                queryBuilder.between(this.property, this.leftValue, this.rightValue);
                return;
            }
            throw new java.lang.UnsupportedOperationException(this.op + " is not supported with two double values");
        }
    }

    public static class StringCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation op;
        private final io.objectbox.query.QueryBuilder.StringOrder order;
        private final java.lang.String value;

        public enum Operation {
            EQUAL,
            NOT_EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL,
            CONTAINS,
            CONTAINS_ELEMENT,
            STARTS_WITH,
            ENDS_WITH
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public StringCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation operation, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.op = operation;
            this.value = str;
            this.order = stringOrder;
        }

        public StringCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation operation, java.lang.String str) {
            this(property, operation, str, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            switch (io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[this.op.ordinal()]) {
                case 1:
                    queryBuilder.equal(this.property, this.value, this.order);
                    return;
                case 2:
                    queryBuilder.notEqual(this.property, this.value, this.order);
                    return;
                case 3:
                    queryBuilder.greater(this.property, this.value, this.order);
                    return;
                case 4:
                    queryBuilder.greaterOrEqual(this.property, this.value, this.order);
                    return;
                case 5:
                    queryBuilder.less(this.property, this.value, this.order);
                    return;
                case 6:
                    queryBuilder.lessOrEqual(this.property, this.value, this.order);
                    return;
                case 7:
                    queryBuilder.contains(this.property, this.value, this.order);
                    return;
                case 8:
                    queryBuilder.containsElement(this.property, this.value, this.order);
                    return;
                case 9:
                    queryBuilder.startsWith(this.property, this.value, this.order);
                    return;
                case 10:
                    queryBuilder.endsWith(this.property, this.value, this.order);
                    return;
                default:
                    throw new java.lang.UnsupportedOperationException(this.op + " is not supported for String");
            }
        }
    }

    public static class StringStringCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final java.lang.String leftValue;
        private final io.objectbox.query.PropertyQueryConditionImpl.StringStringCondition.Operation op;
        private final io.objectbox.query.QueryBuilder.StringOrder order;
        private final java.lang.String rightValue;

        public enum Operation {
            CONTAINS_KEY_VALUE
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public StringStringCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.StringStringCondition.Operation operation, java.lang.String str, java.lang.String str2, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.op = operation;
            this.leftValue = str;
            this.rightValue = str2;
            this.order = stringOrder;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            if (this.op == io.objectbox.query.PropertyQueryConditionImpl.StringStringCondition.Operation.CONTAINS_KEY_VALUE) {
                queryBuilder.containsKeyValue(this.property, this.leftValue, this.rightValue, this.order);
                return;
            }
            throw new java.lang.UnsupportedOperationException(this.op + " is not supported with two String values");
        }
    }

    public static class StringArrayCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition.Operation op;
        private final io.objectbox.query.QueryBuilder.StringOrder order;
        private final java.lang.String[] value;

        public enum Operation {
            IN
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public StringArrayCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition.Operation operation, java.lang.String[] strArr, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.op = operation;
            this.value = strArr;
            this.order = stringOrder;
        }

        public StringArrayCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition.Operation operation, java.lang.String[] strArr) {
            this(property, operation, strArr, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            if (this.op == io.objectbox.query.PropertyQueryConditionImpl.StringArrayCondition.Operation.IN) {
                queryBuilder.in(this.property, this.value, this.order);
                return;
            }
            throw new java.lang.UnsupportedOperationException(this.op + " is not supported for String[]");
        }
    }

    public static class ByteArrayCondition<T> extends io.objectbox.query.PropertyQueryConditionImpl<T> {
        private final io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation op;
        private final byte[] value;

        public enum Operation {
            EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
            return super.and(queryCondition);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
        public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
            return super.or(queryCondition);
        }

        public ByteArrayCondition(io.objectbox.Property<T> property, io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation operation, byte[] bArr) {
            super(property);
            this.op = operation;
            this.value = bArr;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        void applyCondition(io.objectbox.query.QueryBuilder<T> queryBuilder) {
            int i = io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.equal(this.property, this.value);
                return;
            }
            if (i == 2) {
                queryBuilder.greater(this.property, this.value);
                return;
            }
            if (i == 3) {
                queryBuilder.greaterOrEqual(this.property, this.value);
                return;
            }
            if (i == 4) {
                queryBuilder.less(this.property, this.value);
            } else {
                if (i == 5) {
                    queryBuilder.lessOrEqual(this.property, this.value);
                    return;
                }
                throw new java.lang.UnsupportedOperationException(this.op + " is not supported for byte[]");
            }
        }
    }

    /* JADX INFO: renamed from: io.objectbox.query.PropertyQueryConditionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation;

        static {
            int[] iArr = new int[io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.values().length];
            $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation = iArr;
            try {
                iArr[io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.EQUAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS_OR_EQUAL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.values().length];
            $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation = iArr2;
            try {
                iArr2[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.EQUAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.NOT_EQUAL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.GREATER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.LESS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.LESS_OR_EQUAL.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS_ELEMENT.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.STARTS_WITH.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.ENDS_WITH.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.values().length];
            $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation = iArr3;
            try {
                iArr3[io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.LESS.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.LESS_OR_EQUAL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            int[] iArr4 = new int[io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.values().length];
            $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation = iArr4;
            try {
                iArr4[io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.IN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.NOT_IN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            int[] iArr5 = new int[io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.values().length];
            $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation = iArr5;
            try {
                iArr5[io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.EQUAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS_OR_EQUAL.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused27) {
            }
            int[] iArr6 = new int[io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.values().length];
            $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation = iArr6;
            try {
                iArr6[io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.IN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.NOT_IN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused29) {
            }
            int[] iArr7 = new int[io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.values().length];
            $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation = iArr7;
            try {
                iArr7[io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.IS_NULL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation[io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.NOT_NULL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused31) {
            }
        }
    }
}
