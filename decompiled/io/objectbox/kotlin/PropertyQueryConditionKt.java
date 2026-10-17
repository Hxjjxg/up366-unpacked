package io.objectbox.kotlin;

/* JADX INFO: compiled from: PropertyQueryCondition.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a'\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004¨\u0006\u0006"}, d2 = {"alias", "Lio/objectbox/query/QueryCondition;", "T", "Lio/objectbox/query/PropertyQueryCondition;", "name", "", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PropertyQueryConditionKt {
    public static final <T> io.objectbox.query.QueryCondition<T> alias(io.objectbox.query.PropertyQueryCondition<T> propertyQueryCondition, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyQueryCondition, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "name");
        io.objectbox.query.QueryCondition<T> queryConditionAlias = propertyQueryCondition.alias(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryConditionAlias, "alias(name)");
        return queryConditionAlias;
    }
}
