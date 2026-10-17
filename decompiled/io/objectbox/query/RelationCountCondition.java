package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RelationCountCondition<T> extends io.objectbox.query.QueryConditionImpl<T> {
    private final int relationCount;
    private final io.objectbox.relation.RelationInfo<T, ?> relationInfo;

    @Override // io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
    public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition and(io.objectbox.query.QueryCondition queryCondition) {
        return super.and(queryCondition);
    }

    @Override // io.objectbox.query.QueryConditionImpl, io.objectbox.query.QueryCondition
    public /* bridge */ /* synthetic */ io.objectbox.query.QueryCondition or(io.objectbox.query.QueryCondition queryCondition) {
        return super.or(queryCondition);
    }

    public RelationCountCondition(io.objectbox.relation.RelationInfo<T, ?> relationInfo, int i) {
        this.relationInfo = relationInfo;
        this.relationCount = i;
    }

    @Override // io.objectbox.query.QueryConditionImpl
    void apply(io.objectbox.query.QueryBuilder<T> queryBuilder) {
        queryBuilder.relationCount(this.relationInfo, this.relationCount);
    }
}
