package io.objectbox.kotlin;

/* JADX INFO: compiled from: QueryCondition.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0004\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0004¨\u0006\u0005"}, d2 = {"and", "Lio/objectbox/query/QueryCondition;", "T", "queryCondition", "or", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class QueryConditionKt {
    public static final <T> io.objectbox.query.QueryCondition<T> and(io.objectbox.query.QueryCondition<T> queryCondition, io.objectbox.query.QueryCondition<T> queryCondition2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryCondition, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryCondition2, "queryCondition");
        io.objectbox.query.QueryCondition<T> queryConditionAnd = queryCondition.and(queryCondition2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryConditionAnd, "and(queryCondition)");
        return queryConditionAnd;
    }

    public static final <T> io.objectbox.query.QueryCondition<T> or(io.objectbox.query.QueryCondition<T> queryCondition, io.objectbox.query.QueryCondition<T> queryCondition2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryCondition, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryCondition2, "queryCondition");
        io.objectbox.query.QueryCondition<T> queryConditionOr = queryCondition.or(queryCondition2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryConditionOr, "or(queryCondition)");
        return queryConditionOr;
    }
}
