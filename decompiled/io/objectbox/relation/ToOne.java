package io.objectbox.relation;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ToOne<TARGET> implements java.io.Serializable {
    private static final long serialVersionUID = 5092547044335989281L;
    private transient io.objectbox.BoxStore boxStore;
    private boolean checkIdOfTargetForPut;
    private boolean debugRelations;
    private final java.lang.Object entity;
    private transient io.objectbox.Box<java.lang.Object> entityBox;
    private final io.objectbox.relation.RelationInfo<java.lang.Object, TARGET> relationInfo;
    private volatile long resolvedTargetId;
    private TARGET target;
    private volatile transient io.objectbox.Box<TARGET> targetBox;
    private long targetId;
    private transient java.lang.reflect.Field targetIdField;
    private final boolean virtualProperty;

    public ToOne(java.lang.Object obj, io.objectbox.relation.RelationInfo<?, TARGET> relationInfo) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("No source entity given (null)");
        }
        if (relationInfo == null) {
            throw new java.lang.IllegalArgumentException("No relation info given (null)");
        }
        this.entity = obj;
        this.relationInfo = relationInfo;
        this.virtualProperty = relationInfo.targetIdProperty.isVirtual;
    }

    public TARGET getTarget() {
        return getTarget(getTargetId());
    }

    public TARGET getTarget(long j) {
        synchronized (this) {
            if (this.resolvedTargetId == j) {
                return this.target;
            }
            ensureBoxes(null);
            TARGET target = this.targetBox.get(j);
            setResolvedTarget(target, j);
            return target;
        }
    }

    private void ensureBoxes(@javax.annotation.Nullable TARGET target) {
        if (this.targetBox == null) {
            try {
                io.objectbox.BoxStore boxStore = (io.objectbox.BoxStore) io.objectbox.internal.ReflectionCache.getInstance().getField(this.entity.getClass(), "__boxStore").get(this.entity);
                this.boxStore = boxStore;
                if (boxStore == null) {
                    if (target != null) {
                        this.boxStore = (io.objectbox.BoxStore) io.objectbox.internal.ReflectionCache.getInstance().getField(target.getClass(), "__boxStore").get(target);
                    }
                    if (this.boxStore == null) {
                        throw new io.objectbox.exception.DbDetachedException("Cannot resolve relation for detached entities, call box.attach(entity) beforehand.");
                    }
                }
                this.debugRelations = this.boxStore.isDebugRelations();
                this.entityBox = this.boxStore.boxFor(this.relationInfo.sourceInfo.getEntityClass());
                this.targetBox = this.boxStore.boxFor(this.relationInfo.targetInfo.getEntityClass());
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    public TARGET getCachedTarget() {
        return this.target;
    }

    public boolean isResolved() {
        return this.resolvedTargetId == getTargetId();
    }

    public boolean isResolvedAndNotNull() {
        return this.resolvedTargetId != 0 && this.resolvedTargetId == getTargetId();
    }

    public boolean isNull() {
        return getTargetId() == 0 && this.target == null;
    }

    public void setTargetId(long j) {
        if (this.virtualProperty) {
            this.targetId = j;
        } else {
            try {
                getTargetIdField().set(this.entity, java.lang.Long.valueOf(j));
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException("Could not update to-one ID in entity", e);
            }
        }
        if (j != 0) {
            this.checkIdOfTargetForPut = false;
        }
    }

    void setAndUpdateTargetId(long j) {
        setTargetId(j);
        ensureBoxes(null);
        throw new java.lang.UnsupportedOperationException("Not implemented yet");
    }

    public void setTarget(@javax.annotation.Nullable TARGET target) {
        if (target != null) {
            long id = this.relationInfo.targetInfo.getIdGetter().getId(target);
            this.checkIdOfTargetForPut = id == 0;
            setTargetId(id);
            setResolvedTarget(target, id);
            return;
        }
        setTargetId(0L);
        clearResolved();
    }

    public void setAndPutTarget(@javax.annotation.Nullable TARGET target) {
        ensureBoxes(target);
        if (target != null) {
            long id = this.targetBox.getId(target);
            if (id == 0) {
                setAndPutTargetAlways(target);
                return;
            }
            setTargetId(id);
            setResolvedTarget(target, id);
            this.entityBox.put(this.entity);
            return;
        }
        setTargetId(0L);
        clearResolved();
        this.entityBox.put(this.entity);
    }

    public void setAndPutTargetAlways(@javax.annotation.Nullable final TARGET target) {
        ensureBoxes(target);
        if (target != null) {
            this.boxStore.runInTx(new java.lang.Runnable() { // from class: io.objectbox.relation.ToOne$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1429lambda$setAndPutTargetAlways$0$ioobjectboxrelationToOne(target);
                }
            });
            return;
        }
        setTargetId(0L);
        clearResolved();
        this.entityBox.put(this.entity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$setAndPutTargetAlways$0$io-objectbox-relation-ToOne, reason: not valid java name */
    /* synthetic */ void m1429lambda$setAndPutTargetAlways$0$ioobjectboxrelationToOne(java.lang.Object obj) {
        setResolvedTarget(obj, this.targetBox.put(obj));
        this.entityBox.put(this.entity);
    }

    private synchronized void setResolvedTarget(@javax.annotation.Nullable TARGET target, long j) {
        if (this.debugRelations) {
            java.io.PrintStream printStream = java.lang.System.out;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Setting resolved ToOne target to ");
            sb.append(target == null ? com.igexin.push.core.b.m : "non-null");
            sb.append(" for ID ");
            sb.append(j);
            printStream.println(sb.toString());
        }
        this.resolvedTargetId = j;
        this.target = target;
    }

    private synchronized void clearResolved() {
        this.resolvedTargetId = 0L;
        this.target = null;
    }

    public long getTargetId() {
        if (this.virtualProperty) {
            return this.targetId;
        }
        java.lang.reflect.Field targetIdField = getTargetIdField();
        try {
            java.lang.Long l = (java.lang.Long) targetIdField.get(this.entity);
            if (l != null) {
                return l.longValue();
            }
            return 0L;
        } catch (java.lang.IllegalAccessException unused) {
            throw new java.lang.RuntimeException("Could not access field " + targetIdField);
        }
    }

    private java.lang.reflect.Field getTargetIdField() {
        if (this.targetIdField == null) {
            this.targetIdField = io.objectbox.internal.ReflectionCache.getInstance().getField(this.entity.getClass(), this.relationInfo.targetIdProperty.name);
        }
        return this.targetIdField;
    }

    public boolean internalRequiresPutTarget() {
        return this.checkIdOfTargetForPut && this.target != null && getTargetId() == 0;
    }

    public void internalPutTarget(io.objectbox.Cursor<TARGET> cursor) {
        this.checkIdOfTargetForPut = false;
        long jPut = cursor.put(this.target);
        setTargetId(jPut);
        setResolvedTarget(this.target, jPut);
    }

    java.lang.Object getEntity() {
        return this.entity;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof io.objectbox.relation.ToOne)) {
            return false;
        }
        io.objectbox.relation.ToOne toOne = (io.objectbox.relation.ToOne) obj;
        return this.relationInfo == toOne.relationInfo && getTargetId() == toOne.getTargetId();
    }

    public int hashCode() {
        long targetId = getTargetId();
        return (int) (targetId ^ (targetId >>> 32));
    }
}
