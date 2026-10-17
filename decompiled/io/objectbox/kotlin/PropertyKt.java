package io.objectbox.kotlin;

/* JADX INFO: compiled from: Property.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0086\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0086\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0086\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0086\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0086\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0086\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0086\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0086\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0086\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0013H\u0086\u0004\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0014H\u0086\u0004\u001a2\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0086\u0004¢\u0006\u0002\u0010\u0017\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0013H\u0086\u0004\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0014H\u0086\u0004\u001a'\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\u0004¨\u0006\u0019"}, d2 = {"contains", "Lio/objectbox/query/PropertyQueryCondition;", "T", "Lio/objectbox/Property;", "value", "", "endsWith", "equal", "Ljava/util/Date;", "", "", "", "", "", "greater", "", "less", "notEqual", "notOneOf", "", "", "oneOf", "", "(Lio/objectbox/Property;[Ljava/lang/String;)Lio/objectbox/query/PropertyQueryCondition;", "startsWith", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PropertyKt {
    public static final <T> io.objectbox.query.PropertyQueryCondition<T> equal(io.objectbox.Property<T> property, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEqual = property.equal(z);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEqual, "equal(value)");
        return propertyQueryConditionEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notEqual(io.objectbox.Property<T> property, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotEqual = property.notEqual(z);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotEqual, "notEqual(value)");
        return propertyQueryConditionNotEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> equal(io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEqual = property.equal(s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEqual, "equal(value)");
        return propertyQueryConditionEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notEqual(io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotEqual = property.notEqual(s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotEqual, "notEqual(value)");
        return propertyQueryConditionNotEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> greater(io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionGreater = property.greater(s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionGreater, "greater(value)");
        return propertyQueryConditionGreater;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> less(io.objectbox.Property<T> property, short s) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionLess = property.less(s);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionLess, "less(value)");
        return propertyQueryConditionLess;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> equal(io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEqual = property.equal(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEqual, "equal(value)");
        return propertyQueryConditionEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notEqual(io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotEqual = property.notEqual(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotEqual, "notEqual(value)");
        return propertyQueryConditionNotEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> greater(io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionGreater = property.greater(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionGreater, "greater(value)");
        return propertyQueryConditionGreater;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> less(io.objectbox.Property<T> property, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionLess = property.less(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionLess, "less(value)");
        return propertyQueryConditionLess;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> oneOf(io.objectbox.Property<T> property, int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionOneOf = property.oneOf(iArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionOneOf, "oneOf(value)");
        return propertyQueryConditionOneOf;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notOneOf(io.objectbox.Property<T> property, int[] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotOneOf = property.notOneOf(iArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotOneOf, "notOneOf(value)");
        return propertyQueryConditionNotOneOf;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> equal(io.objectbox.Property<T> property, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEqual = property.equal(j);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEqual, "equal(value)");
        return propertyQueryConditionEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notEqual(io.objectbox.Property<T> property, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotEqual = property.notEqual(j);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotEqual, "notEqual(value)");
        return propertyQueryConditionNotEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> greater(io.objectbox.Property<T> property, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionGreater = property.greater(j);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionGreater, "greater(value)");
        return propertyQueryConditionGreater;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> less(io.objectbox.Property<T> property, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionLess = property.less(j);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionLess, "less(value)");
        return propertyQueryConditionLess;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> oneOf(io.objectbox.Property<T> property, long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionOneOf = property.oneOf(jArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionOneOf, "oneOf(value)");
        return propertyQueryConditionOneOf;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notOneOf(io.objectbox.Property<T> property, long[] jArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotOneOf = property.notOneOf(jArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotOneOf, "notOneOf(value)");
        return propertyQueryConditionNotOneOf;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> greater(io.objectbox.Property<T> property, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionGreater = property.greater(d);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionGreater, "greater(value)");
        return propertyQueryConditionGreater;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> less(io.objectbox.Property<T> property, double d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionLess = property.less(d);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionLess, "less(value)");
        return propertyQueryConditionLess;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> equal(io.objectbox.Property<T> property, java.util.Date date) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(date, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEqual = property.equal(date);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEqual, "equal(value)");
        return propertyQueryConditionEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notEqual(io.objectbox.Property<T> property, java.util.Date date) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(date, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotEqual = property.notEqual(date);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotEqual, "notEqual(value)");
        return propertyQueryConditionNotEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> greater(io.objectbox.Property<T> property, java.util.Date date) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(date, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionGreater = property.greater(date);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionGreater, "greater(value)");
        return propertyQueryConditionGreater;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> less(io.objectbox.Property<T> property, java.util.Date date) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(date, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionLess = property.less(date);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionLess, "less(value)");
        return propertyQueryConditionLess;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> equal(io.objectbox.Property<T> property, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEqual = property.equal(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEqual, "equal(value)");
        return propertyQueryConditionEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> notEqual(io.objectbox.Property<T> property, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionNotEqual = property.notEqual(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionNotEqual, "notEqual(value)");
        return propertyQueryConditionNotEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> greater(io.objectbox.Property<T> property, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionGreater = property.greater(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionGreater, "greater(value)");
        return propertyQueryConditionGreater;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> less(io.objectbox.Property<T> property, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionLess = property.less(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionLess, "less(value)");
        return propertyQueryConditionLess;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> contains(io.objectbox.Property<T> property, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionContains = property.contains(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionContains, "contains(value)");
        return propertyQueryConditionContains;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> startsWith(io.objectbox.Property<T> property, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionStartsWith = property.startsWith(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionStartsWith, "startsWith(value)");
        return propertyQueryConditionStartsWith;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> endsWith(io.objectbox.Property<T> property, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEndsWith = property.endsWith(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEndsWith, "endsWith(value)");
        return propertyQueryConditionEndsWith;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> oneOf(io.objectbox.Property<T> property, java.lang.String[] strArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionOneOf = property.oneOf(strArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionOneOf, "oneOf(value)");
        return propertyQueryConditionOneOf;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> equal(io.objectbox.Property<T> property, byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionEqual = property.equal(bArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionEqual, "equal(value)");
        return propertyQueryConditionEqual;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> greater(io.objectbox.Property<T> property, byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionGreater = property.greater(bArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionGreater, "greater(value)");
        return propertyQueryConditionGreater;
    }

    public static final <T> io.objectbox.query.PropertyQueryCondition<T> less(io.objectbox.Property<T> property, byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "value");
        io.objectbox.query.PropertyQueryCondition<T> propertyQueryConditionLess = property.less(bArr);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyQueryConditionLess, "less(value)");
        return propertyQueryConditionLess;
    }
}
