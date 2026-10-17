package io.objectbox.relation;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ToMany<TARGET> implements java.util.List<TARGET>, java.io.Serializable {
    private static final java.lang.Integer ONE = 1;
    private static final long serialVersionUID = 2367317778240689006L;
    private transient io.objectbox.BoxStore boxStore;
    private transient java.util.Comparator<TARGET> comparator;
    private java.util.List<TARGET> entities;
    private volatile java.util.Map<TARGET, java.lang.Boolean> entitiesAdded;
    private java.util.Map<TARGET, java.lang.Boolean> entitiesRemoved;
    java.util.List<TARGET> entitiesToPut;
    java.util.List<TARGET> entitiesToRemoveFromDb;
    private final java.lang.Object entity;
    private transient io.objectbox.Box<java.lang.Object> entityBox;
    private java.util.Map<TARGET, java.lang.Integer> entityCounts;
    private volatile io.objectbox.relation.ListFactory listFactory;
    private final io.objectbox.relation.RelationInfo<java.lang.Object, TARGET> relationInfo;
    private transient boolean removeFromTargetBox;
    private volatile transient io.objectbox.Box<TARGET> targetBox;

    public ToMany(java.lang.Object obj, io.objectbox.relation.RelationInfo<?, TARGET> relationInfo) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("No source entity given (null)");
        }
        if (relationInfo == null) {
            throw new java.lang.IllegalArgumentException("No relation info given (null)");
        }
        this.entity = obj;
        this.relationInfo = relationInfo;
    }

    public void setListFactory(io.objectbox.relation.ListFactory listFactory) {
        if (listFactory == null) {
            throw new java.lang.IllegalArgumentException("ListFactory is null");
        }
        this.listFactory = listFactory;
    }

    public void setComparator(java.util.Comparator<TARGET> comparator) {
        this.comparator = comparator;
    }

    public synchronized void setRemoveFromTargetBox(boolean z) {
        this.removeFromTargetBox = z;
    }

    public io.objectbox.relation.ListFactory getListFactory() {
        io.objectbox.relation.ListFactory copyOnWriteArrayListFactory = this.listFactory;
        if (copyOnWriteArrayListFactory == null) {
            synchronized (this) {
                copyOnWriteArrayListFactory = this.listFactory;
                if (copyOnWriteArrayListFactory == null) {
                    copyOnWriteArrayListFactory = new io.objectbox.relation.ListFactory.CopyOnWriteArrayListFactory();
                    this.listFactory = copyOnWriteArrayListFactory;
                }
            }
        }
        return copyOnWriteArrayListFactory;
    }

    private void ensureBoxes() {
        if (this.targetBox == null) {
            try {
                io.objectbox.BoxStore boxStore = (io.objectbox.BoxStore) io.objectbox.internal.ReflectionCache.getInstance().getField(this.entity.getClass(), "__boxStore").get(this.entity);
                this.boxStore = boxStore;
                if (boxStore == null) {
                    throw new io.objectbox.exception.DbDetachedException("Cannot resolve relation for detached entities, call box.attach(entity) beforehand.");
                }
                this.entityBox = boxStore.boxFor(this.relationInfo.sourceInfo.getEntityClass());
                this.targetBox = this.boxStore.boxFor(this.relationInfo.targetInfo.getEntityClass());
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
    }

    private void ensureEntitiesWithTrackingLists() {
        ensureEntities();
        if (this.entitiesAdded == null) {
            synchronized (this) {
                if (this.entitiesAdded == null) {
                    this.entitiesAdded = new java.util.LinkedHashMap();
                    this.entitiesRemoved = new java.util.LinkedHashMap();
                    this.entityCounts = new java.util.HashMap();
                    for (TARGET target : this.entities) {
                        java.lang.Integer numPut = this.entityCounts.put(target, ONE);
                        if (numPut != null) {
                            this.entityCounts.put(target, java.lang.Integer.valueOf(numPut.intValue() + 1));
                        }
                    }
                }
            }
        }
    }

    private void ensureEntities() {
        java.util.List<TARGET> listInternalGetRelationEntities;
        if (this.entities == null) {
            long id = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
            if (id == 0) {
                synchronized (this) {
                    if (this.entities == null) {
                        this.entities = getListFactory().createList();
                    }
                }
                return;
            }
            ensureBoxes();
            int i = this.relationInfo.relationId;
            if (i != 0) {
                listInternalGetRelationEntities = this.targetBox.internalGetRelationEntities(this.relationInfo.sourceInfo.getEntityId(), i, id, false);
            } else if (this.relationInfo.targetIdProperty != null) {
                listInternalGetRelationEntities = this.targetBox.internalGetBacklinkEntities(this.relationInfo.targetInfo.getEntityId(), this.relationInfo.targetIdProperty, id);
            } else {
                listInternalGetRelationEntities = this.targetBox.internalGetRelationEntities(this.relationInfo.targetInfo.getEntityId(), this.relationInfo.targetRelationId, id, true);
            }
            java.util.Comparator<TARGET> comparator = this.comparator;
            if (comparator != null) {
                java.util.Collections.sort(listInternalGetRelationEntities, comparator);
            }
            synchronized (this) {
                if (this.entities == null) {
                    this.entities = listInternalGetRelationEntities;
                }
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean add(TARGET target) {
        trackAdd(target);
        return this.entities.add(target);
    }

    private void trackAdd(TARGET target) {
        ensureEntitiesWithTrackingLists();
        java.lang.Integer numPut = this.entityCounts.put(target, ONE);
        if (numPut != null) {
            this.entityCounts.put(target, java.lang.Integer.valueOf(numPut.intValue() + 1));
        }
        this.entitiesAdded.put(target, java.lang.Boolean.TRUE);
        this.entitiesRemoved.remove(target);
    }

    private void trackAdd(java.util.Collection<? extends TARGET> collection) {
        ensureEntitiesWithTrackingLists();
        java.util.Iterator<? extends TARGET> it = collection.iterator();
        while (it.hasNext()) {
            trackAdd(it.next());
        }
    }

    private void trackRemove(TARGET target) {
        ensureEntitiesWithTrackingLists();
        java.lang.Integer numRemove = this.entityCounts.remove(target);
        if (numRemove != null) {
            if (numRemove.intValue() == 1) {
                this.entityCounts.remove(target);
                this.entitiesAdded.remove(target);
                this.entitiesRemoved.put(target, java.lang.Boolean.TRUE);
            } else if (numRemove.intValue() > 1) {
                this.entityCounts.put(target, java.lang.Integer.valueOf(numRemove.intValue() - 1));
            } else {
                throw new java.lang.IllegalStateException("Illegal count: " + numRemove);
            }
        }
    }

    @Override // java.util.List
    public synchronized void add(int i, TARGET target) {
        trackAdd(target);
        this.entities.add(i, target);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean addAll(java.util.Collection<? extends TARGET> collection) {
        trackAdd((java.util.Collection) collection);
        return this.entities.addAll(collection);
    }

    @Override // java.util.List
    public synchronized boolean addAll(int i, java.util.Collection<? extends TARGET> collection) {
        trackAdd((java.util.Collection) collection);
        return this.entities.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public synchronized void clear() {
        ensureEntitiesWithTrackingLists();
        java.util.List<TARGET> list = this.entities;
        if (list != null) {
            java.util.Iterator<TARGET> it = list.iterator();
            while (it.hasNext()) {
                this.entitiesRemoved.put(it.next(), java.lang.Boolean.TRUE);
            }
            list.clear();
        }
        java.util.Map<TARGET, java.lang.Boolean> map = this.entitiesAdded;
        if (map != null) {
            map.clear();
        }
        java.util.Map<TARGET, java.lang.Integer> map2 = this.entityCounts;
        if (map2 != null) {
            map2.clear();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(java.lang.Object obj) {
        ensureEntities();
        return this.entities.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(java.util.Collection<?> collection) {
        ensureEntities();
        return this.entities.containsAll(collection);
    }

    @Override // java.util.List
    public TARGET get(int i) {
        ensureEntities();
        return this.entities.get(i);
    }

    @Override // java.util.List
    public int indexOf(java.lang.Object obj) {
        ensureEntities();
        return this.entities.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        ensureEntities();
        return this.entities.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @javax.annotation.Nonnull
    public java.util.Iterator<TARGET> iterator() {
        ensureEntities();
        return this.entities.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(java.lang.Object obj) {
        ensureEntities();
        return this.entities.lastIndexOf(obj);
    }

    @Override // java.util.List
    @javax.annotation.Nonnull
    public java.util.ListIterator<TARGET> listIterator() {
        ensureEntities();
        return this.entities.listIterator();
    }

    @Override // java.util.List
    @javax.annotation.Nonnull
    public java.util.ListIterator<TARGET> listIterator(int i) {
        ensureEntities();
        return this.entities.listIterator(i);
    }

    @Override // java.util.List
    public synchronized TARGET remove(int i) {
        TARGET targetRemove;
        ensureEntitiesWithTrackingLists();
        targetRemove = this.entities.remove(i);
        trackRemove(targetRemove);
        return targetRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public synchronized boolean remove(java.lang.Object obj) {
        boolean zRemove;
        ensureEntitiesWithTrackingLists();
        zRemove = this.entities.remove(obj);
        if (zRemove) {
            trackRemove(obj);
        }
        return zRemove;
    }

    public synchronized TARGET removeById(long j) {
        ensureEntities();
        int size = this.entities.size();
        io.objectbox.internal.IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        for (int i = 0; i < size; i++) {
            TARGET target = this.entities.get(i);
            if (idGetter.getId(target) == j) {
                TARGET targetRemove = remove(i);
                if (targetRemove == target) {
                    return target;
                }
                throw new java.lang.IllegalStateException("Mismatch: " + targetRemove + " vs. " + target);
            }
        }
        return null;
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean removeAll(java.util.Collection<?> collection) {
        boolean zRemove;
        java.util.Iterator<?> it = collection.iterator();
        zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public synchronized boolean retainAll(java.util.Collection<?> collection) {
        boolean z;
        ensureEntitiesWithTrackingLists();
        z = false;
        java.util.ArrayList arrayList = null;
        for (TARGET target : this.entities) {
            if (!collection.contains(target)) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                arrayList.add(target);
                z = true;
            }
        }
        if (arrayList != null) {
            removeAll(arrayList);
        }
        return z;
    }

    @Override // java.util.List
    public synchronized TARGET set(int i, TARGET target) {
        TARGET target2;
        ensureEntitiesWithTrackingLists();
        target2 = this.entities.set(i, target);
        trackRemove(target2);
        trackAdd(target);
        return target2;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        ensureEntities();
        return this.entities.size();
    }

    @Override // java.util.List
    @javax.annotation.Nonnull
    public java.util.List<TARGET> subList(int i, int i2) {
        ensureEntities();
        return this.entities.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @javax.annotation.Nonnull
    public java.lang.Object[] toArray() {
        ensureEntities();
        return this.entities.toArray();
    }

    @Override // java.util.List, java.util.Collection
    @javax.annotation.Nonnull
    public <T> T[] toArray(T[] tArr) {
        ensureEntities();
        return (T[]) this.entities.toArray(tArr);
    }

    public synchronized void reset() {
        this.entities = null;
        this.entitiesAdded = null;
        this.entitiesRemoved = null;
        this.entitiesToRemoveFromDb = null;
        this.entitiesToPut = null;
        this.entityCounts = null;
    }

    public boolean isResolved() {
        return this.entities != null;
    }

    public int getAddCount() {
        java.util.Map<TARGET, java.lang.Boolean> map = this.entitiesAdded;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public int getRemoveCount() {
        java.util.Map<TARGET, java.lang.Boolean> map = this.entitiesRemoved;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public void sortById() {
        ensureEntities();
        java.util.Collections.sort(this.entities, new java.util.Comparator<TARGET>() { // from class: io.objectbox.relation.ToMany.1
            io.objectbox.internal.IdGetter<TARGET> idGetter;

            {
                this.idGetter = io.objectbox.relation.ToMany.this.relationInfo.targetInfo.getIdGetter();
            }

            @Override // java.util.Comparator
            public int compare(TARGET target, TARGET target2) {
                long id = this.idGetter.getId(target);
                long id2 = this.idGetter.getId(target2);
                if (id == 0) {
                    id = Long.MAX_VALUE;
                }
                if (id2 == 0) {
                    id2 = Long.MAX_VALUE;
                }
                long j = id - id2;
                if (j < 0) {
                    return -1;
                }
                return j > 0 ? 1 : 0;
            }
        });
    }

    public void applyChangesToDb() {
        if (this.relationInfo.sourceInfo.getIdGetter().getId(this.entity) == 0) {
            throw new java.lang.IllegalStateException("The source entity was not yet persisted (no ID), use box.put() on it instead");
        }
        try {
            ensureBoxes();
            if (internalCheckApplyToDbRequired()) {
                this.boxStore.runInTx(new java.lang.Runnable() { // from class: io.objectbox.relation.ToMany$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1428lambda$applyChangesToDb$0$ioobjectboxrelationToMany();
                    }
                });
            }
        } catch (io.objectbox.exception.DbDetachedException unused) {
            throw new java.lang.IllegalStateException("The source entity was not yet persisted, use box.put() on it instead");
        }
    }

    /* JADX INFO: renamed from: lambda$applyChangesToDb$0$io-objectbox-relation-ToMany, reason: not valid java name */
    /* synthetic */ void m1428lambda$applyChangesToDb$0$ioobjectboxrelationToMany() {
        internalApplyToDb(io.objectbox.InternalAccess.getActiveTxCursor(this.entityBox), io.objectbox.InternalAccess.getActiveTxCursor(this.targetBox));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasA(io.objectbox.query.QueryFilter<TARGET> queryFilter) {
        for (java.lang.Object obj : toArray()) {
            if (queryFilter.keep(obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasAll(io.objectbox.query.QueryFilter<TARGET> queryFilter) {
        java.lang.Object[] array = toArray();
        if (array.length == 0) {
            return false;
        }
        for (java.lang.Object obj : array) {
            if (!queryFilter.keep(obj)) {
                return false;
            }
        }
        return true;
    }

    public TARGET getById(long j) {
        ensureEntities();
        java.lang.Object[] array = this.entities.toArray();
        io.objectbox.internal.IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        for (java.lang.Object obj : array) {
            TARGET target = (TARGET) obj;
            if (idGetter.getId(target) == j) {
                return target;
            }
        }
        return null;
    }

    public int indexOfId(long j) {
        ensureEntities();
        java.lang.Object[] array = this.entities.toArray();
        io.objectbox.internal.IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        int i = 0;
        for (java.lang.Object obj : array) {
            if (idGetter.getId(obj) == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean hasPendingDbChanges() {
        java.util.Map<TARGET, java.lang.Boolean> map = this.entitiesAdded;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        java.util.Map<TARGET, java.lang.Boolean> map2 = this.entitiesRemoved;
        return (map2 == null || map2.isEmpty()) ? false : true;
    }

    public boolean internalCheckApplyToDbRequired() {
        if (!hasPendingDbChanges()) {
            return false;
        }
        synchronized (this) {
            if (this.entitiesToPut == null) {
                this.entitiesToPut = new java.util.ArrayList();
                this.entitiesToRemoveFromDb = new java.util.ArrayList();
            }
        }
        if (this.relationInfo.relationId != 0) {
            return true;
        }
        long id = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
        if (id == 0) {
            throw new java.lang.IllegalStateException("Source entity has no ID (should have been put before)");
        }
        io.objectbox.internal.IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        java.util.Map<TARGET, java.lang.Boolean> map = this.entitiesAdded;
        java.util.Map<TARGET, java.lang.Boolean> map2 = this.entitiesRemoved;
        if (this.relationInfo.targetRelationId != 0) {
            return prepareToManyBacklinkEntitiesForDb(id, idGetter, map, map2);
        }
        return prepareToOneBacklinkEntitiesForDb(id, idGetter, map, map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean prepareToManyBacklinkEntitiesForDb(long j, io.objectbox.internal.IdGetter<TARGET> idGetter, @javax.annotation.Nullable java.util.Map<TARGET, java.lang.Boolean> map, @javax.annotation.Nullable java.util.Map<TARGET, java.lang.Boolean> map2) {
        boolean z;
        io.objectbox.internal.ToManyGetter<TARGET, java.lang.Object> toManyGetter = this.relationInfo.backlinkToManyGetter;
        synchronized (this) {
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        for (TARGET target : map.keySet()) {
                            io.objectbox.relation.ToMany toMany = (io.objectbox.relation.ToMany) toManyGetter.getToMany(target);
                            if (toMany == 0) {
                                throw new java.lang.IllegalStateException("The ToMany property for " + this.relationInfo.targetInfo.getEntityName() + " is null");
                            }
                            if (toMany.getById(j) == null) {
                                toMany.add(this.entity);
                                this.entitiesToPut.add(target);
                            } else if (idGetter.getId(target) == 0) {
                                this.entitiesToPut.add(target);
                            }
                        }
                        map.clear();
                    }
                } finally {
                }
            }
            if (map2 != null) {
                for (TARGET target2 : map2.keySet()) {
                    io.objectbox.relation.ToMany toMany2 = (io.objectbox.relation.ToMany) toManyGetter.getToMany(target2);
                    if (toMany2.getById(j) != null) {
                        toMany2.removeById(j);
                        if (idGetter.getId(target2) != 0) {
                            if (this.removeFromTargetBox) {
                                this.entitiesToRemoveFromDb.add(target2);
                            } else {
                                this.entitiesToPut.add(target2);
                            }
                        }
                    }
                }
                map2.clear();
            }
            z = (this.entitiesToPut.isEmpty() && this.entitiesToRemoveFromDb.isEmpty()) ? false : true;
        }
        return z;
    }

    private boolean prepareToOneBacklinkEntitiesForDb(long j, io.objectbox.internal.IdGetter<TARGET> idGetter, @javax.annotation.Nullable java.util.Map<TARGET, java.lang.Boolean> map, @javax.annotation.Nullable java.util.Map<TARGET, java.lang.Boolean> map2) {
        boolean z;
        io.objectbox.internal.ToOneGetter<TARGET, java.lang.Object> toOneGetter = this.relationInfo.backlinkToOneGetter;
        synchronized (this) {
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        for (TARGET target : map.keySet()) {
                            io.objectbox.relation.ToOne<java.lang.Object> toOne = toOneGetter.getToOne(target);
                            if (toOne == null) {
                                throw new java.lang.IllegalStateException("The ToOne property for " + this.relationInfo.targetInfo.getEntityName() + "." + this.relationInfo.targetIdProperty.name + " is null");
                            }
                            if (toOne.getTargetId() != j) {
                                toOne.setTarget(this.entity);
                                this.entitiesToPut.add(target);
                            } else if (idGetter.getId(target) == 0) {
                                this.entitiesToPut.add(target);
                            }
                        }
                        map.clear();
                    }
                } finally {
                }
            }
            if (map2 != null) {
                for (TARGET target2 : map2.keySet()) {
                    io.objectbox.relation.ToOne<java.lang.Object> toOne2 = toOneGetter.getToOne(target2);
                    if (toOne2.getTargetId() == j) {
                        toOne2.setTarget(null);
                        if (idGetter.getId(target2) != 0) {
                            if (this.removeFromTargetBox) {
                                this.entitiesToRemoveFromDb.add(target2);
                            } else {
                                this.entitiesToPut.add(target2);
                            }
                        }
                    }
                }
                map2.clear();
            }
            z = (this.entitiesToPut.isEmpty() && this.entitiesToRemoveFromDb.isEmpty()) ? false : true;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void internalApplyToDb(io.objectbox.Cursor<?> cursor, io.objectbox.Cursor<TARGET> cursor2) {
        java.lang.Object[] array;
        java.lang.Object[] array2;
        java.util.ArrayList arrayList;
        java.lang.Object[] objArr;
        java.lang.Object[] array3;
        boolean z = this.relationInfo.relationId != 0;
        io.objectbox.internal.IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        synchronized (this) {
            array = null;
            if (z) {
                for (TARGET target : this.entitiesAdded.keySet()) {
                    if (idGetter.getId(target) == 0) {
                        this.entitiesToPut.add(target);
                    }
                }
                if (this.removeFromTargetBox) {
                    this.entitiesToRemoveFromDb.addAll(this.entitiesRemoved.keySet());
                }
                if (this.entitiesAdded.isEmpty()) {
                    array2 = null;
                } else {
                    array2 = this.entitiesAdded.keySet().toArray();
                    this.entitiesAdded.clear();
                }
                if (this.entitiesRemoved.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new java.util.ArrayList(this.entitiesRemoved.keySet());
                    this.entitiesRemoved.clear();
                }
                objArr = array2;
            } else {
                arrayList = null;
                objArr = null;
            }
            array3 = this.entitiesToRemoveFromDb.isEmpty() ? null : this.entitiesToRemoveFromDb.toArray();
            this.entitiesToRemoveFromDb.clear();
            if (!this.entitiesToPut.isEmpty()) {
                array = this.entitiesToPut.toArray();
            }
            this.entitiesToPut.clear();
        }
        if (array3 != null) {
            for (java.lang.Object obj : array3) {
                long id = idGetter.getId(obj);
                if (id != 0) {
                    cursor2.deleteEntity(id);
                }
            }
        }
        if (array != null) {
            for (java.lang.Object obj2 : array) {
                cursor2.put(obj2);
            }
        }
        if (z) {
            long id2 = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
            if (id2 == 0) {
                throw new java.lang.IllegalStateException("Source entity has no ID (should have been put before)");
            }
            if (arrayList != null) {
                removeStandaloneRelations(cursor, id2, arrayList, idGetter);
            }
            if (objArr != null) {
                addStandaloneRelations(cursor, id2, objArr, idGetter);
            }
        }
    }

    private void removeStandaloneRelations(io.objectbox.Cursor<?> cursor, long j, java.util.List<TARGET> list, io.objectbox.internal.IdGetter<TARGET> idGetter) {
        java.util.Iterator<TARGET> it = list.iterator();
        while (it.hasNext()) {
            if (idGetter.getId(it.next()) == 0) {
                it.remove();
            }
        }
        int size = list.size();
        if (size > 0) {
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = idGetter.getId(list.get(i));
            }
            cursor.modifyRelations(this.relationInfo.relationId, j, jArr, true);
        }
    }

    private void addStandaloneRelations(io.objectbox.Cursor<?> cursor, long j, TARGET[] targetArr, io.objectbox.internal.IdGetter<TARGET> idGetter) {
        int length = targetArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            long id = idGetter.getId(targetArr[i]);
            if (id == 0) {
                throw new java.lang.IllegalStateException("Target entity has no ID (should have been put before)");
            }
            jArr[i] = id;
        }
        cursor.modifyRelations(this.relationInfo.relationId, j, jArr, false);
    }

    java.lang.Object getEntity() {
        return this.entity;
    }
}
