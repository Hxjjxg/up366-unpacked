package io.objectbox.kotlin;

/* JADX INFO: compiled from: ToMany.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"applyChangesToDb", "", "T", "Lio/objectbox/relation/ToMany;", "resetFirst", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ToManyKt {
    public static /* synthetic */ void applyChangesToDb$default(io.objectbox.relation.ToMany toMany, boolean z, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toMany, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "body");
        if (z) {
            toMany.reset();
        }
        function1.invoke(toMany);
        toMany.applyChangesToDb();
    }

    public static final <T> void applyChangesToDb(io.objectbox.relation.ToMany<T> toMany, boolean z, kotlin.jvm.functions.Function1<? super io.objectbox.relation.ToMany<T>, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toMany, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "body");
        if (z) {
            toMany.reset();
        }
        function1.invoke(toMany);
        toMany.applyChangesToDb();
    }
}
