package com.up366.qmui.kotlin;

/* JADX INFO: compiled from: DimenKt.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\r"}, d2 = {"dimen", "", "Landroid/content/Context;", "resource", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "dip", "value", "", "px2dp", "px", "px2sp", "sp", "qmui_release"}, k = 2, mv = {1, 1, 16})
public final class DimenKtKt {
    public static final int dip(android.content.Context context, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "$this$dip");
        android.content.res.Resources resources = context.getResources();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (i * resources.getDisplayMetrics().density);
    }

    public static final int dip(android.content.Context context, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "$this$dip");
        android.content.res.Resources resources = context.getResources();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().density);
    }

    public static final int sp(android.content.Context context, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "$this$sp");
        android.content.res.Resources resources = context.getResources();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (i * resources.getDisplayMetrics().scaledDensity);
    }

    public static final int sp(android.content.Context context, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "$this$sp");
        android.content.res.Resources resources = context.getResources();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().scaledDensity);
    }

    public static final float px2dp(android.content.Context context, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "$this$px2dp");
        android.content.res.Resources resources = context.getResources();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return i / resources.getDisplayMetrics().density;
    }

    public static final float px2sp(android.content.Context context, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "$this$px2sp");
        android.content.res.Resources resources = context.getResources();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return i / resources.getDisplayMetrics().scaledDensity;
    }

    public static final int dimen(android.content.Context context, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "$this$dimen");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final int dip(android.view.View view, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$dip");
        android.content.Context context = view.getContext();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dip(context, i);
    }

    public static final int dip(android.view.View view, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$dip");
        android.content.Context context = view.getContext();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dip(context, f);
    }

    public static final int sp(android.view.View view, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$sp");
        android.content.Context context = view.getContext();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return sp(context, i);
    }

    public static final int sp(android.view.View view, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$sp");
        android.content.Context context = view.getContext();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return sp(context, f);
    }

    public static final float px2dp(android.view.View view, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$px2dp");
        android.content.Context context = view.getContext();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return px2dp(context, i);
    }

    public static final float px2sp(android.view.View view, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$px2sp");
        android.content.Context context = view.getContext();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return px2sp(context, i);
    }

    public static final int dimen(android.view.View view, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$dimen");
        android.content.Context context = view.getContext();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return dimen(context, i);
    }

    public static final int dip(androidx.fragment.app.Fragment fragment, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fragment, "$this$dip");
        android.content.Context context = fragment.getContext();
        if (context == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return dip(context, i);
    }

    public static final int dip(androidx.fragment.app.Fragment fragment, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fragment, "$this$dip");
        android.content.Context context = fragment.getContext();
        if (context == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return dip(context, f);
    }

    public static final int sp(androidx.fragment.app.Fragment fragment, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fragment, "$this$sp");
        android.content.Context context = fragment.getContext();
        if (context == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return sp(context, i);
    }

    public static final int sp(androidx.fragment.app.Fragment fragment, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fragment, "$this$sp");
        android.content.Context context = fragment.getContext();
        if (context == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return sp(context, f);
    }

    public static final float px2dp(androidx.fragment.app.Fragment fragment, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fragment, "$this$px2dp");
        android.content.Context context = fragment.getContext();
        if (context == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return px2dp(context, i);
    }

    public static final float px2sp(androidx.fragment.app.Fragment fragment, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fragment, "$this$px2sp");
        android.content.Context context = fragment.getContext();
        if (context == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return px2sp(context, i);
    }

    public static final int dimen(androidx.fragment.app.Fragment fragment, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fragment, "$this$dimen");
        android.content.Context context = fragment.getContext();
        if (context == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        return dimen(context, i);
    }
}
