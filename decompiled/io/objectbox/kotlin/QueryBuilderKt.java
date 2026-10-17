package io.objectbox.kotlin;

/* JADX INFO: compiled from: QueryBuilder.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\b\u0004\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\b\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0086\b\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0086\b\u001a?\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0086\b\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0086\b\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0086\b\u001a7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\b\u001a7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0086\b\u001a7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0086\b\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0086\b\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0086\b\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0086\b¢\u0006\u0002\u0010\u0015\u001a7\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0016H\u0086\b\u001a7\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0017H\u0086\b\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0086\b\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0086\b\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0086\b\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0086\b\u001a7\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0086\b\u001a7\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0086\b¨\u0006\u001b"}, d2 = {"between", "Lio/objectbox/query/QueryBuilder;", "T", "property", "Lio/objectbox/Property;", "value1", "", "value2", "", "", "equal", "value", "tolerance", "greater", "greaterOrEqual", "inValues", "values", "", "", "stringOrder", "Lio/objectbox/query/QueryBuilder$StringOrder;", "(Lio/objectbox/query/QueryBuilder;Lio/objectbox/Property;[Ljava/lang/String;Lio/objectbox/query/QueryBuilder$StringOrder;)Lio/objectbox/query/QueryBuilder;", "", "", "less", "lessOrEqual", "notEqual", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class QueryBuilderKt {
    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> inValues(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "values");
        io.objectbox.query.QueryBuilder<T> queryBuilderIn = queryBuilder.in(property, jArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderIn, "`in`(property, values)");
        return queryBuilderIn;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> inValues(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "values");
        io.objectbox.query.QueryBuilder<T> queryBuilderIn = queryBuilder.in((io.objectbox.Property) property, iArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderIn, "`in`(property, values)");
        return queryBuilderIn;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> inValues(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, java.lang.String[] strArr, io.objectbox.query.QueryBuilder.StringOrder stringOrder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strArr, "values");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stringOrder, "stringOrder");
        io.objectbox.query.QueryBuilder<T> queryBuilderIn = queryBuilder.in(property, strArr, stringOrder);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderIn, "`in`(property, values, stringOrder)");
        return queryBuilderIn;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> equal(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderEqual = queryBuilder.equal(property, s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderEqual, "equal(property, value.toLong())");
        return queryBuilderEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> notEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderNotEqual = queryBuilder.notEqual(property, s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderNotEqual, "notEqual(property, value.toLong())");
        return queryBuilderNotEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> less(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderLess = queryBuilder.less((io.objectbox.Property) property, s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderLess, "less(property, value.toLong())");
        return queryBuilderLess;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderLessOrEqual = queryBuilder.lessOrEqual((io.objectbox.Property) property, s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderLessOrEqual, "lessOrEqual(property, value.toLong())");
        return queryBuilderLessOrEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> greater(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderGreater = queryBuilder.greater((io.objectbox.Property) property, s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderGreater, "greater(property, value.toLong())");
        return queryBuilderGreater;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderGreaterOrEqual = queryBuilder.greaterOrEqual((io.objectbox.Property) property, s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderGreaterOrEqual, "greaterOrEqual(property, value.toLong())");
        return queryBuilderGreaterOrEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> between(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, short s, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderBetween = queryBuilder.between((io.objectbox.Property) property, s, s2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderBetween, "between(property, value1…oLong(), value2.toLong())");
        return queryBuilderBetween;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> equal(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderEqual = queryBuilder.equal(property, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderEqual, "equal(property, value.toLong())");
        return queryBuilderEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> notEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderNotEqual = queryBuilder.notEqual(property, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderNotEqual, "notEqual(property, value.toLong())");
        return queryBuilderNotEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> less(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderLess = queryBuilder.less((io.objectbox.Property) property, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderLess, "less(property, value.toLong())");
        return queryBuilderLess;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderLessOrEqual = queryBuilder.lessOrEqual((io.objectbox.Property) property, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderLessOrEqual, "lessOrEqual(property, value.toLong())");
        return queryBuilderLessOrEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> greater(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderGreater = queryBuilder.greater((io.objectbox.Property) property, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderGreater, "greater(property, value.toLong())");
        return queryBuilderGreater;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderGreaterOrEqual = queryBuilder.greaterOrEqual((io.objectbox.Property) property, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderGreaterOrEqual, "greaterOrEqual(property, value.toLong())");
        return queryBuilderGreaterOrEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> between(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderBetween = queryBuilder.between((io.objectbox.Property) property, i, i2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderBetween, "between(property, value1…oLong(), value2.toLong())");
        return queryBuilderBetween;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> equal(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, float f, float f2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderEqual = queryBuilder.equal(property, f, f2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderEqual, "equal(property, value.to…(), tolerance.toDouble())");
        return queryBuilderEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> less(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderLess = queryBuilder.less(property, f);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderLess, "less(property, value.toDouble())");
        return queryBuilderLess;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> lessOrEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderLessOrEqual = queryBuilder.lessOrEqual(property, f);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderLessOrEqual, "lessOrEqual(property, value.toDouble())");
        return queryBuilderLessOrEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> greater(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderGreater = queryBuilder.greater(property, f);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderGreater, "greater(property, value.toDouble())");
        return queryBuilderGreater;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> greaterOrEqual(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderGreaterOrEqual = queryBuilder.greaterOrEqual(property, f);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderGreaterOrEqual, "greaterOrEqual(property, value.toDouble())");
        return queryBuilderGreaterOrEqual;
    }

    public static final /* synthetic */ <T> io.objectbox.query.QueryBuilder<T> between(io.objectbox.query.QueryBuilder<T> queryBuilder, io.objectbox.Property<T> property, float f, float f2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        io.objectbox.query.QueryBuilder<T> queryBuilderBetween = queryBuilder.between(property, f, f2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(queryBuilderBetween, "between(property, value1…ble(), value2.toDouble())");
        return queryBuilderBetween;
    }
}
