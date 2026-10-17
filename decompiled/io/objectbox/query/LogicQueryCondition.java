package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class LogicQueryCondition<T> extends io.objectbox.query.QueryConditionImpl<T> {
    private final io.objectbox.query.QueryConditionImpl<T> leftCondition;
    private final io.objectbox.query.QueryConditionImpl<T> rightCondition;

    abstract void applyOperator(io.objectbox.query.QueryBuilder<T> queryBuilder, long j, long j2);

    LogicQueryCondition(io.objectbox.query.QueryConditionImpl<T> queryConditionImpl, io.objectbox.query.QueryConditionImpl<T> queryConditionImpl2) {
        this.leftCondition = queryConditionImpl;
        this.rightCondition = queryConditionImpl2;
    }

    @Override // io.objectbox.query.QueryConditionImpl
    void apply(io.objectbox.query.QueryBuilder<T> queryBuilder) {
        this.leftCondition.apply(queryBuilder);
        long jInternalGetLastCondition = queryBuilder.internalGetLastCondition();
        this.rightCondition.apply(queryBuilder);
        applyOperator(queryBuilder, jInternalGetLastCondition, queryBuilder.internalGetLastCondition());
    }

    static class AndCondition<T> extends io.objectbox.query.LogicQueryCondition<T> {
        AndCondition(io.objectbox.query.QueryConditionImpl<T> queryConditionImpl, io.objectbox.query.QueryConditionImpl<T> queryConditionImpl2) {
            super(queryConditionImpl, queryConditionImpl2);
        }

        @Override // io.objectbox.query.LogicQueryCondition
        void applyOperator(io.objectbox.query.QueryBuilder<T> queryBuilder, long j, long j2) {
            queryBuilder.internalAnd(j, j2);
        }
    }

    static class OrCondition<T> extends io.objectbox.query.LogicQueryCondition<T> {
        OrCondition(io.objectbox.query.QueryConditionImpl<T> queryConditionImpl, io.objectbox.query.QueryConditionImpl<T> queryConditionImpl2) {
            super(queryConditionImpl, queryConditionImpl2);
        }

        @Override // io.objectbox.query.LogicQueryCondition
        void applyOperator(io.objectbox.query.QueryBuilder<T> queryBuilder, long j, long j2) {
            queryBuilder.internalOr(j, j2);
        }
    }
}
