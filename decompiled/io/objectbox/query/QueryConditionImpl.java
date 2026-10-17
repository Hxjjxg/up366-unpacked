package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class QueryConditionImpl<T> implements io.objectbox.query.QueryCondition<T> {
    abstract void apply(io.objectbox.query.QueryBuilder<T> queryBuilder);

    QueryConditionImpl() {
    }

    @Override // io.objectbox.query.QueryCondition
    public io.objectbox.query.QueryCondition<T> and(io.objectbox.query.QueryCondition<T> queryCondition) {
        return new io.objectbox.query.LogicQueryCondition.AndCondition(this, (io.objectbox.query.QueryConditionImpl) queryCondition);
    }

    @Override // io.objectbox.query.QueryCondition
    public io.objectbox.query.QueryCondition<T> or(io.objectbox.query.QueryCondition<T> queryCondition) {
        return new io.objectbox.query.LogicQueryCondition.OrCondition(this, (io.objectbox.query.QueryConditionImpl) queryCondition);
    }
}
