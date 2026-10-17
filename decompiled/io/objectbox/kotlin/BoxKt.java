package io.objectbox.kotlin;

/* JADX INFO: compiled from: Box.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"query", "Lio/objectbox/query/Query;", "T", "Lio/objectbox/Box;", "block", "Lkotlin/Function1;", "Lio/objectbox/query/QueryBuilder;", "", "Lkotlin/ExtensionFunctionType;", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BoxKt {
    public static final <T> io.objectbox.query.Query<T> query(io.objectbox.Box<T> box, kotlin.jvm.functions.Function1<? super io.objectbox.query.QueryBuilder<T>, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(box, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "block");
        io.objectbox.query.QueryBuilder<T> queryBuilderQuery = box.query();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderQuery, "builder");
        function1.invoke(queryBuilderQuery);
        io.objectbox.query.Query<T> queryBuild = queryBuilderQuery.build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuild, "builder.build()");
        return queryBuild;
    }
}
