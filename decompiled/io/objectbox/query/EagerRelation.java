package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class EagerRelation<S, T> {
    public final int limit;
    public final io.objectbox.relation.RelationInfo<S, T> relationInfo;

    EagerRelation(int i, io.objectbox.relation.RelationInfo<S, T> relationInfo) {
        this.limit = i;
        this.relationInfo = relationInfo;
    }
}
