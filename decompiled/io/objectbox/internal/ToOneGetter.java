package io.objectbox.internal;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface ToOneGetter<SOURCE, TARGET> extends java.io.Serializable {
    io.objectbox.relation.ToOne<TARGET> getToOne(SOURCE source);
}
