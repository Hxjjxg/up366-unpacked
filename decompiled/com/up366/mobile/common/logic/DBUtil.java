package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DBUtil {
    private final io.objectbox.BoxStore db;

    public DBUtil(io.objectbox.BoxStore boxStore) {
        this.db = boxStore;
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void delete(T t) {
        io.objectbox.Property<?> property = com.up366.mobile.common.logic.DBIndexMap.dbMap.get(t.getClass().getSimpleName());
        if (property == null) {
            throw new java.lang.RuntimeException("has not put into map ");
        }
        if (property.type == java.lang.String.class) {
            this.db.boxFor(getClass(t)).query().equal(property, (java.lang.String) getFieldValueByName(property.name, t), io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE).build().remove();
        } else if (property.type == java.lang.Long.class) {
            this.db.boxFor(getClass(t)).query().equal(property, ((java.lang.Long) getFieldValueByName(property.name, t)).longValue()).build().remove();
        } else if (property.type == java.lang.Integer.TYPE) {
            this.db.boxFor(getClass(t)).query().equal(property, ((java.lang.Integer) getFieldValueByName(property.name, t)).intValue()).build().remove();
        } else {
            throw new java.lang.RuntimeException("has not support type : " + property.type);
        }
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> T findOne(io.objectbox.Property<T> property, java.lang.String str) {
        return (T) this.db.boxFor(property.entity.getEntityClass()).query().equal(property, str, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE).build().findFirst();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> T findOneByPropertyDesc(io.objectbox.Property<T> property, java.lang.String str, io.objectbox.Property<T> property2) {
        return (T) this.db.boxFor(property.entity.getEntityClass()).query().equal(property, str, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE).orderDesc(property).build().findFirst();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> T findOne(io.objectbox.Property<T> property, boolean z) {
        return (T) this.db.boxFor(property.entity.getEntityClass()).query().equal(property, z).build().findFirst();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> T findOne(io.objectbox.Property<T> property, int i) {
        return (T) this.db.boxFor(property.entity.getEntityClass()).query().equal(property, i).build().findFirst();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> T findOneByPropertyDesc(io.objectbox.Property<T> property) {
        return (T) this.db.boxFor(property.entity.getEntityClass()).query().orderDesc(property).build().findFirst();
    }

    public <T> void deleteAll(java.lang.Class<T> cls) {
        this.db.boxFor(cls).removeAll();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void delete(java.util.List<T> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            delete(it.next());
        }
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void delete(final io.objectbox.Property<T> property, final java.lang.String str) {
        delete(property.entity.getEntityClass(), new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda7
            public final java.lang.Object apply(java.lang.Object obj) {
                return ((io.objectbox.query.QueryBuilder) obj).equal(property, str, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE);
            }
        });
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void delete(final io.objectbox.Property<T> property, final long j) {
        delete(property.entity.getEntityClass(), new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda5
            public final java.lang.Object apply(java.lang.Object obj) {
                return ((io.objectbox.query.QueryBuilder) obj).equal(property, j);
            }
        });
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void delete(java.lang.Class<T> cls, androidx.arch.core.util.Function<io.objectbox.query.QueryBuilder<T>, io.objectbox.query.QueryBuilder<T>> function) {
        io.objectbox.Box boxBoxFor = this.db.boxFor(cls);
        boxBoxFor.remove(((io.objectbox.query.QueryBuilder) function.apply(boxBoxFor.query())).build().findIds());
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void remove(T t) {
        this.db.boxFor(getClass(t)).remove(t);
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void remove(java.util.List<T> list) {
        if (list.size() > 0) {
            this.db.boxFor(getClass(list.get(0))).remove(list.toArray(new com.up366.mobile.common.logic.model.DBModel[0]));
        }
    }

    public synchronized <T extends com.up366.mobile.common.logic.model.DBModel> void saveOrUpdate(T t) {
        this.db.boxFor(getClass(t)).put(t);
    }

    private java.lang.Object getFieldValueByName(java.lang.String str, java.lang.Object obj) {
        try {
            return obj.getClass().getMethod("get" + str.substring(0, 1).toUpperCase() + str.substring(1), null).invoke(obj, null);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getFieldValueByName error : " + e.getMessage(), e);
            return null;
        }
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void saveOrUpdate(java.util.List<T> list) {
        if (list.size() > 0) {
            this.db.boxFor(getClass(list.get(0))).put((java.util.Collection) list);
        }
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void saveAllWithClearAll(final java.lang.Class<T> cls, final java.util.List<T> list) {
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveAllWithClearAll$2(cls, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveAllWithClearAll$2(java.lang.Class cls, java.util.List list) {
        deleteAll(cls);
        saveOrUpdate(list);
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> void saveAllWithDelete(final java.lang.Class<T> cls, final androidx.arch.core.util.Function<io.objectbox.query.QueryBuilder<T>, io.objectbox.query.QueryBuilder<T>> function, final java.util.List<T> list) {
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveAllWithDelete$3(cls, function, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveAllWithDelete$3(java.lang.Class cls, androidx.arch.core.util.Function function, java.util.List list) {
        delete(cls, function);
        saveOrUpdate(list);
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> java.util.List<T> find(final io.objectbox.Property<T> property, final long j) {
        return find(property.entity.getEntityClass(), new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda2
            public final java.lang.Object apply(java.lang.Object obj) {
                return ((io.objectbox.query.QueryBuilder) obj).equal(property, j);
            }
        });
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> java.util.List<T> find(final io.objectbox.Property<T> property, final boolean z) {
        return find(property.entity.getEntityClass(), new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda6
            public final java.lang.Object apply(java.lang.Object obj) {
                return ((io.objectbox.query.QueryBuilder) obj).equal(property, z);
            }
        });
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> java.util.List<T> find(final io.objectbox.Property<T> property, final java.lang.String str) {
        return find(property.entity.getEntityClass(), new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda0
            public final java.lang.Object apply(java.lang.Object obj) {
                return ((io.objectbox.query.QueryBuilder) obj).equal(property, str, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE);
            }
        });
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> java.util.List<T> find(final io.objectbox.Property<T> property, final byte[] bArr) {
        return find(property.entity.getEntityClass(), new androidx.arch.core.util.Function() { // from class: com.up366.mobile.common.logic.DBUtil$$ExternalSyntheticLambda3
            public final java.lang.Object apply(java.lang.Object obj) {
                return ((io.objectbox.query.QueryBuilder) obj).equal(property, bArr);
            }
        });
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> java.util.List<T> find(java.lang.Class<T> cls, androidx.arch.core.util.Function<io.objectbox.query.QueryBuilder<T>, io.objectbox.query.QueryBuilder<T>> function) {
        return ((io.objectbox.query.QueryBuilder) function.apply(this.db.boxFor(cls).query())).build().find();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> T findOne(java.lang.Class<T> cls, androidx.arch.core.util.Function<io.objectbox.query.QueryBuilder<T>, io.objectbox.query.QueryBuilder<T>> function) {
        java.util.List listFind = ((io.objectbox.query.QueryBuilder) function.apply(this.db.boxFor(cls).query())).build().find();
        if (listFind.size() == 0) {
            return null;
        }
        return (T) listFind.get(0);
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> java.util.List<T> findAll(java.lang.Class<T> cls) {
        return this.db.boxFor(cls).getAll();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> long count(java.lang.Class<T> cls) {
        return this.db.boxFor(cls).count();
    }

    public <T extends com.up366.mobile.common.logic.model.DBModel> long count(java.lang.Class<T> cls, androidx.arch.core.util.Function<io.objectbox.query.QueryBuilder<T>, io.objectbox.query.QueryBuilder<T>> function) {
        return find(cls, function).size();
    }

    private <T extends com.up366.mobile.common.logic.model.DBModel> java.lang.Class<T> getClass(T t) {
        return (java.lang.Class<T>) t.getClass();
    }

    public void runInTx(java.lang.Runnable runnable) {
        this.db.runInTx(runnable);
    }
}
