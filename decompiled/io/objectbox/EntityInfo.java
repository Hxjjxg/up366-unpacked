package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface EntityInfo<T> extends java.io.Serializable {
    io.objectbox.Property<T>[] getAllProperties();

    io.objectbox.internal.CursorFactory<T> getCursorFactory();

    java.lang.String getDbName();

    java.lang.Class<T> getEntityClass();

    int getEntityId();

    java.lang.String getEntityName();

    io.objectbox.internal.IdGetter<T> getIdGetter();

    io.objectbox.Property<T> getIdProperty();
}
