package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QueryBuilder<T> {
    public static final int CASE_SENSITIVE = 2;
    public static final int DESCENDING = 1;
    public static final int NULLS_LAST = 8;
    public static final int NULLS_ZERO = 16;
    public static final int UNSIGNED = 4;
    private final io.objectbox.Box<T> box;
    private io.objectbox.query.QueryBuilder.Operator combineNextWith;

    @javax.annotation.Nullable
    private java.util.Comparator<T> comparator;

    @javax.annotation.Nullable
    private java.util.List<io.objectbox.query.EagerRelation<T, ?>> eagerRelations;

    @javax.annotation.Nullable
    private io.objectbox.query.QueryFilter<T> filter;
    private long handle;
    private final boolean isSubQuery;
    private long lastCondition;
    private long lastPropertyCondition;
    private final long storeHandle;

    enum Operator {
        NONE,
        AND,
        OR
    }

    public enum StringOrder {
        CASE_INSENSITIVE,
        CASE_SENSITIVE
    }

    private native long nativeBetween(long j, int i, double d, double d2);

    private native long nativeBetween(long j, int i, long j2, long j3);

    private native long nativeBuild(long j);

    private native long nativeCombine(long j, long j2, long j3, boolean z);

    private native long nativeContains(long j, int i, java.lang.String str, boolean z);

    private native long nativeContainsElement(long j, int i, java.lang.String str, boolean z);

    private native long nativeContainsKeyValue(long j, int i, java.lang.String str, java.lang.String str2, boolean z);

    private native long nativeCreate(long j, java.lang.String str);

    private native void nativeDestroy(long j);

    private native long nativeEndsWith(long j, int i, java.lang.String str, boolean z);

    private native long nativeEqual(long j, int i, long j2);

    private native long nativeEqual(long j, int i, java.lang.String str, boolean z);

    private native long nativeEqual(long j, int i, byte[] bArr);

    private native long nativeGreater(long j, int i, double d, boolean z);

    private native long nativeGreater(long j, int i, long j2, boolean z);

    private native long nativeGreater(long j, int i, java.lang.String str, boolean z, boolean z2);

    private native long nativeGreater(long j, int i, byte[] bArr, boolean z);

    private native long nativeIn(long j, int i, int[] iArr, boolean z);

    private native long nativeIn(long j, int i, long[] jArr, boolean z);

    private native long nativeIn(long j, int i, java.lang.String[] strArr, boolean z);

    private native long nativeLess(long j, int i, double d, boolean z);

    private native long nativeLess(long j, int i, long j2, boolean z);

    private native long nativeLess(long j, int i, java.lang.String str, boolean z, boolean z2);

    private native long nativeLess(long j, int i, byte[] bArr, boolean z);

    private native long nativeLink(long j, long j2, int i, int i2, int i3, int i4, boolean z);

    private native long nativeNotEqual(long j, int i, long j2);

    private native long nativeNotEqual(long j, int i, java.lang.String str, boolean z);

    private native long nativeNotNull(long j, int i);

    private native long nativeNull(long j, int i);

    private native void nativeOrder(long j, int i, int i2);

    private native long nativeRelationCount(long j, long j2, int i, int i2, int i3);

    private native void nativeSetParameterAlias(long j, java.lang.String str);

    private native long nativeStartsWith(long j, int i, java.lang.String str, boolean z);

    public QueryBuilder(io.objectbox.Box<T> box, long j, java.lang.String str) {
        this.combineNextWith = io.objectbox.query.QueryBuilder.Operator.NONE;
        this.box = box;
        this.storeHandle = j;
        long jNativeCreate = nativeCreate(j, str);
        this.handle = jNativeCreate;
        if (jNativeCreate == 0) {
            throw new io.objectbox.exception.DbException("Could not create native query builder");
        }
        this.isSubQuery = false;
    }

    private QueryBuilder(long j, long j2) {
        this.combineNextWith = io.objectbox.query.QueryBuilder.Operator.NONE;
        this.box = null;
        this.storeHandle = j;
        this.handle = j2;
        this.isSubQuery = true;
    }

    protected void finalize() throws java.lang.Throwable {
        close();
        super.finalize();
    }

    public synchronized void close() {
        long j = this.handle;
        if (j != 0) {
            this.handle = 0L;
            if (!this.isSubQuery) {
                nativeDestroy(j);
            }
        }
    }

    public io.objectbox.query.Query<T> build() {
        verifyNotSubQuery();
        verifyHandle();
        if (this.combineNextWith != io.objectbox.query.QueryBuilder.Operator.NONE) {
            throw new java.lang.IllegalStateException("Incomplete logic condition. Use or()/and() between two conditions only.");
        }
        long jNativeBuild = nativeBuild(this.handle);
        if (jNativeBuild == 0) {
            throw new io.objectbox.exception.DbException("Could not create native query");
        }
        io.objectbox.query.Query<T> query = new io.objectbox.query.Query<>(this.box, jNativeBuild, this.eagerRelations, this.filter, this.comparator);
        close();
        return query;
    }

    private void verifyNotSubQuery() {
        if (this.isSubQuery) {
            throw new java.lang.IllegalStateException("This call is not supported on sub query builders (links)");
        }
    }

    private void verifyHandle() {
        if (this.handle == 0) {
            throw new java.lang.IllegalStateException("This QueryBuilder has already been closed. Please use a new instance.");
        }
    }

    public io.objectbox.query.QueryBuilder<T> apply(io.objectbox.query.QueryCondition<T> queryCondition) {
        ((io.objectbox.query.QueryConditionImpl) queryCondition).apply(this);
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> order(io.objectbox.Property<T> property) {
        return order(property, 0);
    }

    public io.objectbox.query.QueryBuilder<T> orderDesc(io.objectbox.Property<T> property) {
        return order(property, 1);
    }

    public io.objectbox.query.QueryBuilder<T> order(io.objectbox.Property<T> property, int i) {
        verifyNotSubQuery();
        verifyHandle();
        checkNoOperatorPending();
        nativeOrder(this.handle, property.getId(), i);
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> sort(java.util.Comparator<T> comparator) {
        this.comparator = comparator;
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> parameterAlias(java.lang.String str) {
        verifyHandle();
        long j = this.lastPropertyCondition;
        if (j == 0) {
            throw new java.lang.IllegalStateException("No previous condition. Before you can assign an alias, you must first have a condition.");
        }
        nativeSetParameterAlias(j, str);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TARGET> io.objectbox.query.QueryBuilder<TARGET> link(io.objectbox.relation.RelationInfo<?, TARGET> relationInfo) {
        boolean zIsBacklink = relationInfo.isBacklink();
        return link(relationInfo, zIsBacklink ? relationInfo.targetInfo : relationInfo.sourceInfo, relationInfo.targetInfo, zIsBacklink);
    }

    private <TARGET> io.objectbox.query.QueryBuilder<TARGET> link(io.objectbox.relation.RelationInfo<?, ?> relationInfo, io.objectbox.EntityInfo<?> entityInfo, io.objectbox.EntityInfo<?> entityInfo2, boolean z) {
        return new io.objectbox.query.QueryBuilder<>(this.storeHandle, nativeLink(this.handle, this.storeHandle, entityInfo.getEntityId(), entityInfo2.getEntityId(), relationInfo.targetIdProperty != null ? relationInfo.targetIdProperty.id : 0, relationInfo.targetRelationId != 0 ? relationInfo.targetRelationId : relationInfo.relationId, z));
    }

    public <TARGET> io.objectbox.query.QueryBuilder<TARGET> backlink(io.objectbox.relation.RelationInfo<TARGET, ?> relationInfo) {
        if (relationInfo.isBacklink()) {
            throw new java.lang.IllegalArgumentException("Double backlink: The relation is already a backlink, please use a regular link on the original relation instead.");
        }
        return link(relationInfo, relationInfo.sourceInfo, relationInfo.sourceInfo, true);
    }

    public io.objectbox.query.QueryBuilder<T> eager(io.objectbox.relation.RelationInfo relationInfo, io.objectbox.relation.RelationInfo... relationInfoArr) {
        return eager(0, relationInfo, relationInfoArr);
    }

    public io.objectbox.query.QueryBuilder<T> eager(int i, io.objectbox.relation.RelationInfo relationInfo, @javax.annotation.Nullable io.objectbox.relation.RelationInfo... relationInfoArr) {
        verifyNotSubQuery();
        if (this.eagerRelations == null) {
            this.eagerRelations = new java.util.ArrayList();
        }
        this.eagerRelations.add(new io.objectbox.query.EagerRelation<>(i, relationInfo));
        if (relationInfoArr != null) {
            for (io.objectbox.relation.RelationInfo relationInfo2 : relationInfoArr) {
                this.eagerRelations.add(new io.objectbox.query.EagerRelation<>(i, relationInfo2));
            }
        }
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> filter(io.objectbox.query.QueryFilter<T> queryFilter) {
        verifyNotSubQuery();
        if (this.filter != null) {
            throw new java.lang.IllegalStateException("A filter was already defined, you can only assign one filter");
        }
        this.filter = queryFilter;
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> or() {
        combineOperator(io.objectbox.query.QueryBuilder.Operator.OR);
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> and() {
        combineOperator(io.objectbox.query.QueryBuilder.Operator.AND);
        return this;
    }

    private void combineOperator(io.objectbox.query.QueryBuilder.Operator operator) {
        verifyHandle();
        if (this.lastCondition == 0) {
            throw new java.lang.IllegalStateException("No previous condition. Use operators like and() and or() only between two conditions.");
        }
        checkNoOperatorPending();
        this.combineNextWith = operator;
    }

    private void checkNoOperatorPending() {
        if (this.combineNextWith != io.objectbox.query.QueryBuilder.Operator.NONE) {
            throw new java.lang.IllegalStateException("Another operator is pending. Use operators like and() and or() only between two conditions.");
        }
    }

    private void checkCombineCondition(long j) {
        if (this.combineNextWith != io.objectbox.query.QueryBuilder.Operator.NONE) {
            this.lastCondition = nativeCombine(this.handle, this.lastCondition, j, this.combineNextWith == io.objectbox.query.QueryBuilder.Operator.OR);
            this.combineNextWith = io.objectbox.query.QueryBuilder.Operator.NONE;
        } else {
            this.lastCondition = j;
        }
        this.lastPropertyCondition = j;
    }

    long internalGetLastCondition() {
        return this.lastCondition;
    }

    void internalAnd(long j, long j2) {
        this.lastCondition = nativeCombine(this.handle, j, j2, false);
    }

    void internalOr(long j, long j2) {
        this.lastCondition = nativeCombine(this.handle, j, j2, true);
    }

    public io.objectbox.query.QueryBuilder<T> isNull(io.objectbox.Property<T> property) {
        verifyHandle();
        checkCombineCondition(nativeNull(this.handle, property.getId()));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> notNull(io.objectbox.Property<T> property) {
        verifyHandle();
        checkCombineCondition(nativeNotNull(this.handle, property.getId()));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> relationCount(io.objectbox.relation.RelationInfo<T, ?> relationInfo, int i) {
        verifyHandle();
        checkCombineCondition(nativeRelationCount(this.handle, this.storeHandle, relationInfo.targetInfo.getEntityId(), relationInfo.targetIdProperty.id, i));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> equal(io.objectbox.Property<T> property, long j) {
        verifyHandle();
        checkCombineCondition(nativeEqual(this.handle, property.getId(), j));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> notEqual(io.objectbox.Property<T> property, long j) {
        verifyHandle();
        checkCombineCondition(nativeNotEqual(this.handle, property.getId(), j));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> less(io.objectbox.Property<T> property, long j) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), j, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.Property<T> property, long j) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), j, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greater(io.objectbox.Property<T> property, long j) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), j, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.Property<T> property, long j) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), j, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> between(io.objectbox.Property<T> property, long j, long j2) {
        verifyHandle();
        checkCombineCondition(nativeBetween(this.handle, property.getId(), j, j2));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> in(io.objectbox.Property<T> property, long[] jArr) {
        verifyHandle();
        checkCombineCondition(nativeIn(this.handle, property.getId(), jArr, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> notIn(io.objectbox.Property<T> property, long[] jArr) {
        verifyHandle();
        checkCombineCondition(nativeIn(this.handle, property.getId(), jArr, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> in(io.objectbox.Property<T> property, int[] iArr) {
        verifyHandle();
        checkCombineCondition(nativeIn(this.handle, property.getId(), iArr, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> notIn(io.objectbox.Property<T> property, int[] iArr) {
        verifyHandle();
        checkCombineCondition(nativeIn(this.handle, property.getId(), iArr, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> equal(io.objectbox.Property<T> property, boolean z) {
        verifyHandle();
        checkCombineCondition(nativeEqual(this.handle, property.getId(), z ? 1L : 0L));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> notEqual(io.objectbox.Property<T> property, boolean z) {
        verifyHandle();
        checkCombineCondition(nativeNotEqual(this.handle, property.getId(), z ? 1L : 0L));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> equal(io.objectbox.Property<T> property, java.util.Date date) {
        verifyHandle();
        checkCombineCondition(nativeEqual(this.handle, property.getId(), date.getTime()));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> notEqual(io.objectbox.Property<T> property, java.util.Date date) {
        verifyHandle();
        checkCombineCondition(nativeNotEqual(this.handle, property.getId(), date.getTime()));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> less(io.objectbox.Property<T> property, java.util.Date date) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), date.getTime(), false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.Property<T> property, java.util.Date date) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), date.getTime(), true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greater(io.objectbox.Property<T> property, java.util.Date date) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), date.getTime(), false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.Property<T> property, java.util.Date date) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), date.getTime(), true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> between(io.objectbox.Property<T> property, java.util.Date date, java.util.Date date2) {
        verifyHandle();
        checkCombineCondition(nativeBetween(this.handle, property.getId(), date.getTime(), date2.getTime()));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> equal(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeEqual(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> notEqual(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeNotEqual(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> contains(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        if (java.lang.String[].class == property.type) {
            throw new java.lang.UnsupportedOperationException("For String[] only containsElement() is supported at this time.");
        }
        verifyHandle();
        checkCombineCondition(nativeContains(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> containsElement(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeContainsElement(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> containsKeyValue(io.objectbox.Property<T> property, java.lang.String str, java.lang.String str2, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeContainsKeyValue(this.handle, property.getId(), str, str2, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> startsWith(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeStartsWith(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> endsWith(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeEndsWith(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> less(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greater(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), str, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> in(io.objectbox.Property<T> property, java.lang.String[] strArr, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        verifyHandle();
        checkCombineCondition(nativeIn(this.handle, property.getId(), strArr, stringOrder == io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> equal(io.objectbox.Property<T> property, double d, double d2) {
        return between(property, d - d2, d + d2);
    }

    public io.objectbox.query.QueryBuilder<T> less(io.objectbox.Property<T> property, double d) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), d, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.Property<T> property, double d) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), d, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greater(io.objectbox.Property<T> property, double d) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), d, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.Property<T> property, double d) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), d, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> between(io.objectbox.Property<T> property, double d, double d2) {
        verifyHandle();
        checkCombineCondition(nativeBetween(this.handle, property.getId(), d, d2));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> equal(io.objectbox.Property<T> property, byte[] bArr) {
        verifyHandle();
        checkCombineCondition(nativeEqual(this.handle, property.getId(), bArr));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> less(io.objectbox.Property<T> property, byte[] bArr) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), bArr, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.Property<T> property, byte[] bArr) {
        verifyHandle();
        checkCombineCondition(nativeLess(this.handle, property.getId(), bArr, true));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greater(io.objectbox.Property<T> property, byte[] bArr) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), bArr, false));
        return this;
    }

    public io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.Property<T> property, byte[] bArr) {
        verifyHandle();
        checkCombineCondition(nativeGreater(this.handle, property.getId(), bArr, true));
        return this;
    }
}
