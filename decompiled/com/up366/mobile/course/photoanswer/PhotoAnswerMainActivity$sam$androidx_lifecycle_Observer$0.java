package com.up366.mobile.course.photoanswer;

/* JADX INFO: compiled from: PhotoAnswerMainActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PhotoAnswerMainActivity$sam$androidx_lifecycle_Observer$0 implements androidx.lifecycle.Observer, kotlin.jvm.internal.FunctionAdapter {
    private final /* synthetic */ kotlin.jvm.functions.Function1 function;

    PhotoAnswerMainActivity$sam$androidx_lifecycle_Observer$0(kotlin.jvm.functions.Function1 function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "function");
        this.function = function1;
    }

    public final boolean equals(java.lang.Object obj) {
        if ((obj instanceof androidx.lifecycle.Observer) && (obj instanceof kotlin.jvm.internal.FunctionAdapter)) {
            return kotlin.jvm.internal.Intrinsics.areEqual(getFunctionDelegate(), ((kotlin.jvm.internal.FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    public final kotlin.Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(java.lang.Object obj) {
        this.function.invoke(obj);
    }
}
