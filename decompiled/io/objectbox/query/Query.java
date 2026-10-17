package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Query<T> implements java.io.Closeable {
    private static final int INITIAL_RETRY_BACK_OFF_IN_MS = 10;
    final io.objectbox.Box<T> box;

    @javax.annotation.Nullable
    private final java.util.Comparator<T> comparator;

    @javax.annotation.Nullable
    private final java.util.List<io.objectbox.query.EagerRelation<T, ?>> eagerRelations;

    @javax.annotation.Nullable
    private final io.objectbox.query.QueryFilter<T> filter;
    volatile long handle;
    private final io.objectbox.query.QueryPublisher<T> publisher;
    private final int queryAttempts;
    private final io.objectbox.BoxStore store;

    private native void nativeSetParameters(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, java.lang.String str2, java.lang.String str3);

    native long nativeClone(long j);

    native long nativeCount(long j, long j2);

    native java.lang.String nativeDescribeParameters(long j);

    native void nativeDestroy(long j);

    native java.util.List<T> nativeFind(long j, long j2, long j3, long j4) throws java.lang.Exception;

    native java.lang.Object nativeFindFirst(long j, long j2);

    native long nativeFindFirstId(long j, long j2);

    native long[] nativeFindIds(long j, long j2, long j3, long j4);

    native java.lang.Object nativeFindUnique(long j, long j2);

    native long nativeFindUniqueId(long j, long j2);

    native long nativeRemove(long j, long j2);

    native void nativeSetParameter(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, double d);

    native void nativeSetParameter(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, long j2);

    native void nativeSetParameter(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, java.lang.String str2);

    native void nativeSetParameter(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, byte[] bArr);

    native void nativeSetParameters(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, double d, double d2);

    native void nativeSetParameters(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, long j2, long j3);

    native void nativeSetParameters(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, int[] iArr);

    native void nativeSetParameters(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, long[] jArr);

    native void nativeSetParameters(long j, int i, int i2, @javax.annotation.Nullable java.lang.String str, java.lang.String[] strArr);

    native java.lang.String nativeToString(long j);

    Query(io.objectbox.Box<T> box, long j, @javax.annotation.Nullable java.util.List<io.objectbox.query.EagerRelation<T, ?>> list, @javax.annotation.Nullable io.objectbox.query.QueryFilter<T> queryFilter, @javax.annotation.Nullable java.util.Comparator<T> comparator) {
        this.box = box;
        io.objectbox.BoxStore store = box.getStore();
        this.store = store;
        this.queryAttempts = store.internalQueryAttempts();
        this.handle = j;
        this.publisher = new io.objectbox.query.QueryPublisher<>(this, box);
        this.eagerRelations = list;
        this.filter = queryFilter;
        this.comparator = comparator;
    }

    private Query(io.objectbox.query.Query<T> query, long j) {
        this(query.box, j, query.eagerRelations, query.filter, query.comparator);
    }

    protected void finalize() throws java.lang.Throwable {
        close();
        super.finalize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.handle != 0) {
            long j = this.handle;
            this.handle = 0L;
            nativeDestroy(j);
        }
    }

    public io.objectbox.query.Query<T> copy() {
        return new io.objectbox.query.Query<>(this, nativeClone(this.handle));
    }

    long cursorHandle() {
        return io.objectbox.InternalAccess.getActiveTxCursorHandle(this.box);
    }

    @javax.annotation.Nullable
    public T findFirst() {
        ensureNoFilterNoComparator();
        return (T) callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1420lambda$findFirst$0$ioobjectboxqueryQuery();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$findFirst$0$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.lang.Object m1420lambda$findFirst$0$ioobjectboxqueryQuery() throws java.lang.Exception {
        java.lang.Object objNativeFindFirst = nativeFindFirst(this.handle, cursorHandle());
        resolveEagerRelation(objNativeFindFirst);
        return objNativeFindFirst;
    }

    private void ensureNoFilterNoComparator() {
        ensureNoFilter();
        ensureNoComparator();
    }

    private void ensureNoFilter() {
        if (this.filter != null) {
            throw new java.lang.UnsupportedOperationException("Does not work with a filter. Only find() and forEach() support filters.");
        }
    }

    private void ensureNoComparator() {
        if (this.comparator != null) {
            throw new java.lang.UnsupportedOperationException("Does not work with a sorting comparator. Only find() supports sorting with a comparator.");
        }
    }

    @javax.annotation.Nullable
    public T findUnique() {
        ensureNoFilter();
        return (T) callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1423lambda$findUnique$1$ioobjectboxqueryQuery();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$findUnique$1$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.lang.Object m1423lambda$findUnique$1$ioobjectboxqueryQuery() throws java.lang.Exception {
        java.lang.Object objNativeFindUnique = nativeFindUnique(this.handle, cursorHandle());
        resolveEagerRelation(objNativeFindUnique);
        return objNativeFindUnique;
    }

    @javax.annotation.Nonnull
    public java.util.List<T> find() {
        return (java.util.List) callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1418lambda$find$2$ioobjectboxqueryQuery();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$find$2$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.util.List m1418lambda$find$2$ioobjectboxqueryQuery() throws java.lang.Exception {
        java.util.List<T> listNativeFind = nativeFind(this.handle, cursorHandle(), 0L, 0L);
        if (this.filter != null) {
            java.util.Iterator<T> it = listNativeFind.iterator();
            while (it.hasNext()) {
                if (!this.filter.keep(it.next())) {
                    it.remove();
                }
            }
        }
        resolveEagerRelations(listNativeFind);
        java.util.Comparator<T> comparator = this.comparator;
        if (comparator != null) {
            java.util.Collections.sort(listNativeFind, comparator);
        }
        return listNativeFind;
    }

    @javax.annotation.Nonnull
    public java.util.List<T> find(final long j, final long j2) {
        ensureNoFilterNoComparator();
        return (java.util.List) callInReadTx(new java.util.concurrent.Callable() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                return this.f$0.m1419lambda$find$3$ioobjectboxqueryQuery(j, j2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$find$3$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.util.List m1419lambda$find$3$ioobjectboxqueryQuery(long j, long j2) throws java.lang.Exception {
        java.util.List<T> listNativeFind = nativeFind(this.handle, cursorHandle(), j, j2);
        resolveEagerRelations(listNativeFind);
        return listNativeFind;
    }

    public long findFirstId() {
        checkOpen();
        return ((java.lang.Long) this.box.internalCallWithReaderHandle(new io.objectbox.internal.CallWithHandle() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda4
            @Override // io.objectbox.internal.CallWithHandle
            public final java.lang.Object call(long j) {
                return this.f$0.m1421lambda$findFirstId$4$ioobjectboxqueryQuery(j);
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$findFirstId$4$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.lang.Long m1421lambda$findFirstId$4$ioobjectboxqueryQuery(long j) {
        return java.lang.Long.valueOf(nativeFindFirstId(this.handle, j));
    }

    public long findUniqueId() {
        checkOpen();
        return ((java.lang.Long) this.box.internalCallWithReaderHandle(new io.objectbox.internal.CallWithHandle() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda6
            @Override // io.objectbox.internal.CallWithHandle
            public final java.lang.Object call(long j) {
                return this.f$0.m1424lambda$findUniqueId$5$ioobjectboxqueryQuery(j);
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$findUniqueId$5$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.lang.Long m1424lambda$findUniqueId$5$ioobjectboxqueryQuery(long j) {
        return java.lang.Long.valueOf(nativeFindUniqueId(this.handle, j));
    }

    @javax.annotation.Nonnull
    public long[] findIds() {
        return findIds(0L, 0L);
    }

    @javax.annotation.Nonnull
    public long[] findIds(final long j, final long j2) {
        checkOpen();
        return (long[]) this.box.internalCallWithReaderHandle(new io.objectbox.internal.CallWithHandle() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda1
            @Override // io.objectbox.internal.CallWithHandle
            public final java.lang.Object call(long j3) {
                return this.f$0.m1422lambda$findIds$6$ioobjectboxqueryQuery(j, j2, j3);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$findIds$6$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ long[] m1422lambda$findIds$6$ioobjectboxqueryQuery(long j, long j2, long j3) {
        return nativeFindIds(this.handle, j3, j, j2);
    }

    @javax.annotation.Nonnull
    public io.objectbox.query.LazyList<T> findLazy() {
        ensureNoFilterNoComparator();
        return new io.objectbox.query.LazyList<>(this.box, findIds(), false);
    }

    @javax.annotation.Nonnull
    public io.objectbox.query.LazyList<T> findLazyCached() {
        ensureNoFilterNoComparator();
        return new io.objectbox.query.LazyList<>(this.box, findIds(), true);
    }

    public io.objectbox.query.PropertyQuery property(io.objectbox.Property<T> property) {
        return new io.objectbox.query.PropertyQuery(this, property);
    }

    <R> R callInReadTx(java.util.concurrent.Callable<R> callable) {
        checkOpen();
        return (R) this.store.callInReadTxWithRetry(callable, this.queryAttempts, 10, true);
    }

    public void forEach(final io.objectbox.query.QueryConsumer<T> queryConsumer) {
        ensureNoComparator();
        checkOpen();
        this.box.getStore().runInReadTx(new java.lang.Runnable() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1425lambda$forEach$7$ioobjectboxqueryQuery(queryConsumer);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$forEach$7$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ void m1425lambda$forEach$7$ioobjectboxqueryQuery(io.objectbox.query.QueryConsumer queryConsumer) {
        io.objectbox.query.LazyList lazyList = new io.objectbox.query.LazyList(this.box, findIds(), false);
        int size = lazyList.size();
        for (int i = 0; i < size; i++) {
            java.lang.Object obj = lazyList.get(i);
            if (obj == null) {
                throw new java.lang.IllegalStateException("Internal error: data object was null");
            }
            io.objectbox.query.QueryFilter<T> queryFilter = this.filter;
            if (queryFilter == null || queryFilter.keep((T) obj)) {
                if (this.eagerRelations != null) {
                    resolveEagerRelationForNonNullEagerRelations(obj, i);
                }
                try {
                    queryConsumer.accept(obj);
                } catch (io.objectbox.query.BreakForEach unused) {
                    return;
                }
            }
        }
    }

    void resolveEagerRelations(java.util.List<T> list) {
        if (this.eagerRelations != null) {
            java.util.Iterator<T> it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                resolveEagerRelationForNonNullEagerRelations(it.next(), i);
                i++;
            }
        }
    }

    void resolveEagerRelationForNonNullEagerRelations(@javax.annotation.Nonnull T t, int i) {
        for (io.objectbox.query.EagerRelation<T, ?> eagerRelation : this.eagerRelations) {
            if (eagerRelation.limit == 0 || i < eagerRelation.limit) {
                resolveEagerRelation(t, eagerRelation);
            }
        }
    }

    void resolveEagerRelation(@javax.annotation.Nullable T t) {
        java.util.List<io.objectbox.query.EagerRelation<T, ?>> list = this.eagerRelations;
        if (list == null || t == null) {
            return;
        }
        java.util.Iterator<io.objectbox.query.EagerRelation<T, ?>> it = list.iterator();
        while (it.hasNext()) {
            resolveEagerRelation(t, it.next());
        }
    }

    void resolveEagerRelation(@javax.annotation.Nonnull T t, io.objectbox.query.EagerRelation<T, ?> eagerRelation) {
        if (this.eagerRelations != null) {
            io.objectbox.relation.RelationInfo<T, ?> relationInfo = eagerRelation.relationInfo;
            if (relationInfo.toOneGetter != null) {
                io.objectbox.relation.ToOne<?> toOne = relationInfo.toOneGetter.getToOne(t);
                if (toOne != null) {
                    toOne.getTarget();
                    return;
                }
                return;
            }
            if (relationInfo.toManyGetter == null) {
                throw new java.lang.IllegalStateException("Relation info without relation getter: " + relationInfo);
            }
            java.util.List<?> toMany = relationInfo.toManyGetter.getToMany(t);
            if (toMany != null) {
                toMany.size();
            }
        }
    }

    public long count() {
        checkOpen();
        ensureNoFilter();
        return ((java.lang.Long) this.box.internalCallWithReaderHandle(new io.objectbox.internal.CallWithHandle() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda3
            @Override // io.objectbox.internal.CallWithHandle
            public final java.lang.Object call(long j) {
                return this.f$0.m1417lambda$count$8$ioobjectboxqueryQuery(j);
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$count$8$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.lang.Long m1417lambda$count$8$ioobjectboxqueryQuery(long j) {
        return java.lang.Long.valueOf(nativeCount(this.handle, j));
    }

    public io.objectbox.query.Query<T> setParameter(io.objectbox.Property<?> property, java.lang.String str) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, str);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(java.lang.String str, java.lang.String str2) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, str2);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(io.objectbox.Property<?> property, long j) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, j);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(java.lang.String str, long j) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, j);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(io.objectbox.Property<?> property, double d) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, d);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(java.lang.String str, double d) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, d);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(io.objectbox.Property<?> property, java.util.Date date) {
        return setParameter(property, date.getTime());
    }

    public io.objectbox.query.Query<T> setParameter(java.lang.String str, java.util.Date date) {
        return setParameter(str, date.getTime());
    }

    public io.objectbox.query.Query<T> setParameter(io.objectbox.Property<?> property, boolean z) {
        return setParameter(property, z ? 1L : 0L);
    }

    public io.objectbox.query.Query<T> setParameter(java.lang.String str, boolean z) {
        return setParameter(str, z ? 1L : 0L);
    }

    public io.objectbox.query.Query<T> setParameters(io.objectbox.Property<?> property, long j, long j2) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, j, j2);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(java.lang.String str, long j, long j2) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, j, j2);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(io.objectbox.Property<?> property, int[] iArr) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, iArr);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(java.lang.String str, int[] iArr) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, iArr);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(io.objectbox.Property<?> property, long[] jArr) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, jArr);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(java.lang.String str, long[] jArr) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, jArr);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(io.objectbox.Property<?> property, double d, double d2) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, d, d2);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(java.lang.String str, double d, double d2) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, d, d2);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(io.objectbox.Property<?> property, java.lang.String[] strArr) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, strArr);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(java.lang.String str, java.lang.String[] strArr) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, strArr);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(io.objectbox.Property<?> property, java.lang.String str, java.lang.String str2) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, str, str2);
        return this;
    }

    public io.objectbox.query.Query<T> setParameters(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, str2, str3);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(io.objectbox.Property<?> property, byte[] bArr) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (java.lang.String) null, bArr);
        return this;
    }

    public io.objectbox.query.Query<T> setParameter(java.lang.String str, byte[] bArr) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, bArr);
        return this;
    }

    public long remove() {
        checkOpen();
        ensureNoFilter();
        return ((java.lang.Long) this.box.internalCallWithWriterHandle(new io.objectbox.internal.CallWithHandle() { // from class: io.objectbox.query.Query$$ExternalSyntheticLambda9
            @Override // io.objectbox.internal.CallWithHandle
            public final java.lang.Object call(long j) {
                return this.f$0.m1426lambda$remove$9$ioobjectboxqueryQuery(j);
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$remove$9$io-objectbox-query-Query, reason: not valid java name */
    /* synthetic */ java.lang.Long m1426lambda$remove$9$ioobjectboxqueryQuery(long j) {
        return java.lang.Long.valueOf(nativeRemove(this.handle, j));
    }

    public io.objectbox.reactive.SubscriptionBuilder<java.util.List<T>> subscribe() {
        checkOpen();
        return new io.objectbox.reactive.SubscriptionBuilder<>(this.publisher, null);
    }

    public io.objectbox.reactive.SubscriptionBuilder<java.util.List<T>> subscribe(io.objectbox.reactive.DataSubscriptionList dataSubscriptionList) {
        io.objectbox.reactive.SubscriptionBuilder<java.util.List<T>> subscriptionBuilderSubscribe = subscribe();
        subscriptionBuilderSubscribe.dataSubscriptionList(dataSubscriptionList);
        return subscriptionBuilderSubscribe;
    }

    public void publish() {
        this.publisher.publish();
    }

    public java.lang.String describe() {
        checkOpen();
        return nativeToString(this.handle);
    }

    public java.lang.String describeParameters() {
        checkOpen();
        return nativeDescribeParameters(this.handle);
    }

    private void checkOpen() {
        if (this.handle == 0) {
            throw new java.lang.IllegalStateException("This query is closed. Build and use a new one.");
        }
    }
}
