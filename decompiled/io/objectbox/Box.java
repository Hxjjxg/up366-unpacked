package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Box<T> {
    private volatile java.lang.reflect.Field boxStoreField;
    private final java.lang.Class<T> entityClass;
    private io.objectbox.EntityInfo<T> entityInfo;
    private final io.objectbox.internal.IdGetter<T> idGetter;
    private final io.objectbox.BoxStore store;
    final java.lang.ThreadLocal<io.objectbox.Cursor<T>> activeTxCursor = new java.lang.ThreadLocal<>();
    private final java.lang.ThreadLocal<io.objectbox.Cursor<T>> threadLocalReader = new java.lang.ThreadLocal<>();

    private boolean isChanged(T t) {
        return false;
    }

    private boolean putIfChanged(T t) {
        return false;
    }

    Box(io.objectbox.BoxStore boxStore, java.lang.Class<T> cls) {
        this.store = boxStore;
        this.entityClass = cls;
        this.idGetter = boxStore.getEntityInfo(cls).getIdGetter();
    }

    io.objectbox.Cursor<T> getReader() {
        io.objectbox.Cursor<T> activeTxCursor = getActiveTxCursor();
        if (activeTxCursor != null) {
            return activeTxCursor;
        }
        io.objectbox.Cursor<T> cursor = this.threadLocalReader.get();
        if (cursor != null) {
            io.objectbox.Transaction transaction = cursor.tx;
            if (transaction.isClosed() || !transaction.isRecycled()) {
                throw new java.lang.IllegalStateException("Illegal reader TX state");
            }
            transaction.renew();
            cursor.renew();
            return cursor;
        }
        io.objectbox.Cursor<T> cursorCreateCursor = this.store.beginReadTx().createCursor(this.entityClass);
        this.threadLocalReader.set(cursorCreateCursor);
        return cursorCreateCursor;
    }

    io.objectbox.Cursor<T> getActiveTxCursor() {
        io.objectbox.Transaction transaction = this.store.activeTx.get();
        if (transaction == null) {
            return null;
        }
        if (transaction.isClosed()) {
            throw new java.lang.IllegalStateException("Active TX is closed");
        }
        io.objectbox.Cursor<T> cursor = this.activeTxCursor.get();
        if (cursor != null && !cursor.getTx().isClosed()) {
            return cursor;
        }
        io.objectbox.Cursor<T> cursorCreateCursor = transaction.createCursor(this.entityClass);
        this.activeTxCursor.set(cursorCreateCursor);
        return cursorCreateCursor;
    }

    io.objectbox.Cursor<T> getWriter() {
        io.objectbox.Cursor<T> activeTxCursor = getActiveTxCursor();
        if (activeTxCursor != null) {
            return activeTxCursor;
        }
        io.objectbox.Transaction transactionBeginTx = this.store.beginTx();
        try {
            return transactionBeginTx.createCursor(this.entityClass);
        } catch (java.lang.RuntimeException e) {
            transactionBeginTx.close();
            throw e;
        }
    }

    void commitWriter(io.objectbox.Cursor<T> cursor) {
        if (this.activeTxCursor.get() == null) {
            cursor.close();
            cursor.getTx().commitAndClose();
        }
    }

    void releaseWriter(io.objectbox.Cursor<T> cursor) {
        if (this.activeTxCursor.get() == null) {
            io.objectbox.Transaction tx = cursor.getTx();
            if (tx.isClosed()) {
                return;
            }
            cursor.close();
            tx.abort();
            tx.close();
        }
    }

    void releaseReader(io.objectbox.Cursor<T> cursor) {
        if (this.activeTxCursor.get() == null) {
            io.objectbox.Transaction tx = cursor.getTx();
            if (tx.isClosed() || tx.isRecycled() || !tx.isReadOnly()) {
                throw new java.lang.IllegalStateException("Illegal reader TX state");
            }
            tx.recycle();
        }
    }

    public void closeThreadResources() {
        io.objectbox.Cursor<T> cursor = this.threadLocalReader.get();
        if (cursor != null) {
            cursor.close();
            cursor.getTx().close();
            this.threadLocalReader.remove();
        }
    }

    void txCommitted(io.objectbox.Transaction transaction) {
        io.objectbox.Cursor<T> cursor = this.activeTxCursor.get();
        if (cursor != null) {
            this.activeTxCursor.remove();
            cursor.close();
        }
    }

    void readTxFinished(io.objectbox.Transaction transaction) {
        io.objectbox.Cursor<T> cursor = this.activeTxCursor.get();
        if (cursor == null || cursor.getTx() != transaction) {
            return;
        }
        this.activeTxCursor.remove();
        cursor.close();
    }

    int getPropertyId(java.lang.String str) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader.getPropertyId(str);
        } finally {
            releaseReader(reader);
        }
    }

    public long getId(T t) {
        return this.idGetter.getId(t);
    }

    public T get(long j) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader.get(j);
        } finally {
            releaseReader(reader);
        }
    }

    public java.util.List<T> get(java.lang.Iterable<java.lang.Long> iterable) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        io.objectbox.Cursor<T> reader = getReader();
        try {
            java.util.Iterator<java.lang.Long> it = iterable.iterator();
            while (it.hasNext()) {
                T t = reader.get(it.next().longValue());
                if (t != null) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        } finally {
            releaseReader(reader);
        }
    }

    public java.util.List<T> get(long[] jArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(jArr.length);
        io.objectbox.Cursor<T> reader = getReader();
        try {
            for (long j : jArr) {
                java.lang.Long.valueOf(j).getClass();
                T t = reader.get(j);
                if (t != null) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        } finally {
            releaseReader(reader);
        }
    }

    public java.util.Map<java.lang.Long, T> getMap(java.lang.Iterable<java.lang.Long> iterable) {
        java.util.HashMap map = new java.util.HashMap();
        io.objectbox.Cursor<T> reader = getReader();
        try {
            for (java.lang.Long l : iterable) {
                map.put(l, reader.get(l.longValue()));
            }
            return map;
        } finally {
            releaseReader(reader);
        }
    }

    public long count() {
        return count(0L);
    }

    public long count(long j) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader.count(j);
        } finally {
            releaseReader(reader);
        }
    }

    public boolean isEmpty() {
        return count(1L) == 0;
    }

    public java.util.List<T> getAll() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        io.objectbox.Cursor<T> reader = getReader();
        try {
            for (T tFirst = reader.first(); tFirst != null; tFirst = reader.next()) {
                arrayList.add(tFirst);
            }
            return arrayList;
        } finally {
            releaseReader(reader);
        }
    }

    public boolean contains(long j) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader.seek(j);
        } finally {
            releaseReader(reader);
        }
    }

    public long put(T t) {
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            long jPut = writer.put(t);
            commitWriter(writer);
            return jPut;
        } finally {
            releaseWriter(writer);
        }
    }

    @java.lang.SafeVarargs
    public final void put(@javax.annotation.Nullable T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return;
        }
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            for (T t : tArr) {
                writer.put(t);
            }
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    public void put(@javax.annotation.Nullable java.util.Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            java.util.Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                writer.put(it.next());
            }
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    public void putBatched(@javax.annotation.Nullable java.util.Collection<T> collection, int i) {
        if (i < 1) {
            throw new java.lang.IllegalArgumentException("Batch size must be 1 or greater but was " + i);
        }
        if (collection == null) {
            return;
        }
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            io.objectbox.Cursor<T> writer = getWriter();
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    break;
                }
                try {
                    if (!it.hasNext()) {
                        break;
                    }
                    writer.put(it.next());
                    i2 = i3;
                } finally {
                    releaseWriter(writer);
                }
            }
            commitWriter(writer);
        }
    }

    public boolean remove(long j) {
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            boolean zDeleteEntity = writer.deleteEntity(j);
            commitWriter(writer);
            return zDeleteEntity;
        } finally {
            releaseWriter(writer);
        }
    }

    public void remove(@javax.annotation.Nullable long... jArr) {
        if (jArr == null || jArr.length == 0) {
            return;
        }
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            for (long j : jArr) {
                writer.deleteEntity(j);
            }
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    @java.lang.Deprecated
    public void removeByKeys(@javax.annotation.Nullable java.util.Collection<java.lang.Long> collection) {
        removeByIds(collection);
    }

    public void removeByIds(@javax.annotation.Nullable java.util.Collection<java.lang.Long> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            java.util.Iterator<java.lang.Long> it = collection.iterator();
            while (it.hasNext()) {
                writer.deleteEntity(it.next().longValue());
            }
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    public boolean remove(T t) {
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            boolean zDeleteEntity = writer.deleteEntity(writer.getId(t));
            commitWriter(writer);
            return zDeleteEntity;
        } finally {
            releaseWriter(writer);
        }
    }

    @java.lang.SafeVarargs
    public final void remove(@javax.annotation.Nullable T... tArr) {
        if (tArr == null || tArr.length == 0) {
            return;
        }
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            for (T t : tArr) {
                writer.deleteEntity(writer.getId(t));
            }
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    public void remove(@javax.annotation.Nullable java.util.Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            java.util.Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                writer.deleteEntity(writer.getId(it.next()));
            }
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    public void removeAll() {
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            writer.deleteAll();
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    public long panicModeRemoveAll() {
        return this.store.panicModeRemoveAllObjects(getEntityInfo().getEntityId());
    }

    public io.objectbox.query.QueryBuilder<T> query() {
        return new io.objectbox.query.QueryBuilder<>(this, this.store.getNativeStore(), this.store.getDbName(this.entityClass));
    }

    public io.objectbox.query.QueryBuilder<T> query(io.objectbox.query.QueryCondition<T> queryCondition) {
        return query().apply(queryCondition);
    }

    public io.objectbox.BoxStore getStore() {
        return this.store;
    }

    public synchronized io.objectbox.EntityInfo<T> getEntityInfo() {
        if (this.entityInfo == null) {
            io.objectbox.Cursor<T> reader = getReader();
            try {
                this.entityInfo = reader.getEntityInfo();
                releaseReader(reader);
            } catch (java.lang.Throwable th) {
                releaseReader(reader);
                throw th;
            }
        }
        return this.entityInfo;
    }

    public void attach(T t) {
        if (this.boxStoreField == null) {
            try {
                this.boxStoreField = io.objectbox.internal.ReflectionCache.getInstance().getField(this.entityClass, "__boxStore");
            } catch (java.lang.Exception e) {
                throw new io.objectbox.exception.DbException("Entity cannot be attached - only active entities with relationships support attaching (class has no __boxStore field(?)) : " + this.entityClass, e);
            }
        }
        try {
            this.boxStoreField.set(t, this.store);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public java.lang.Class<T> getEntityClass() {
        return this.entityClass;
    }

    public java.util.List<T> internalGetBacklinkEntities(int i, io.objectbox.Property<?> property, long j) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader.getBacklinkEntities(i, property, j);
        } finally {
            releaseReader(reader);
        }
    }

    public java.util.List<T> internalGetRelationEntities(int i, int i2, long j, boolean z) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader.getRelationEntities(i, i2, j, z);
        } finally {
            releaseReader(reader);
        }
    }

    public long[] internalGetRelationIds(int i, int i2, long j, boolean z) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader.getRelationIds(i, i2, j, z);
        } finally {
            releaseReader(reader);
        }
    }

    public java.util.List<T> getRelationEntities(io.objectbox.relation.RelationInfo<?, T> relationInfo, long j) {
        return internalGetRelationEntities(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, false);
    }

    public java.util.List<T> getRelationBacklinkEntities(io.objectbox.relation.RelationInfo<T, ?> relationInfo, long j) {
        return internalGetRelationEntities(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, true);
    }

    public long[] getRelationIds(io.objectbox.relation.RelationInfo<?, T> relationInfo, long j) {
        return internalGetRelationIds(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, false);
    }

    public long[] getRelationBacklinkIds(io.objectbox.relation.RelationInfo<T, ?> relationInfo, long j) {
        return internalGetRelationIds(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, true);
    }

    public <RESULT> RESULT internalCallWithReaderHandle(io.objectbox.internal.CallWithHandle<RESULT> callWithHandle) {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return callWithHandle.call(reader.internalHandle());
        } finally {
            releaseReader(reader);
        }
    }

    public <RESULT> RESULT internalCallWithWriterHandle(io.objectbox.internal.CallWithHandle<RESULT> callWithHandle) {
        io.objectbox.Cursor<T> writer = getWriter();
        try {
            RESULT resultCall = callWithHandle.call(writer.internalHandle());
            commitWriter(writer);
            return resultCall;
        } finally {
            releaseWriter(writer);
        }
    }

    public java.lang.String getReaderDebugInfo() {
        io.objectbox.Cursor<T> reader = getReader();
        try {
            return reader + " with " + reader.getTx() + "; store's commit count: " + getStore().commitCount;
        } finally {
            releaseReader(reader);
        }
    }
}
