package com.up366.qmui.kotlin;

/* JADX INFO: compiled from: ViewKt.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a$\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a(\u0010\t\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a(\u0010\n\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a#\u0010\u000b\u001a\u00020\u0007*\u00020\u00062\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"debounceClick", "Landroid/view/View$OnClickListener;", "wait", "", "block", "Lkotlin/Function1;", "Landroid/view/View;", "", "throttleClick", "onClick", "onDebounceClick", "skin", "Lcom/up366/qmui/skin/QMUISkinValueBuilder;", "Lkotlin/ExtensionFunctionType;", "qmui_release"}, k = 2, mv = {1, 1, 16})
public final class ViewKtKt {
    public static /* synthetic */ android.view.View.OnClickListener throttleClick$default(long j, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        return throttleClick(j, function1);
    }

    public static final android.view.View.OnClickListener throttleClick(final long j, final kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(function1, "block");
        return new android.view.View.OnClickListener() { // from class: com.up366.qmui.kotlin.ViewKtKt.throttleClick.1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                java.lang.Object tag = view.getTag(com.qmuiteam.qmui.R.id.qmui_click_timestamp);
                if (!(tag instanceof java.lang.Long)) {
                    tag = null;
                }
                java.lang.Long l = (java.lang.Long) tag;
                if (jCurrentTimeMillis - (l != null ? l.longValue() : 0L) > j) {
                    view.setTag(com.qmuiteam.qmui.R.id.qmui_click_timestamp, java.lang.Long.valueOf(jCurrentTimeMillis));
                    kotlin.jvm.functions.Function1 function12 = function1;
                    kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(view, "v");
                    function12.invoke(view);
                }
            }
        };
    }

    public static /* synthetic */ android.view.View.OnClickListener debounceClick$default(long j, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        return debounceClick(j, function1);
    }

    public static final android.view.View.OnClickListener debounceClick(final long j, final kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(function1, "block");
        return new android.view.View.OnClickListener() { // from class: com.up366.qmui.kotlin.ViewKtKt.debounceClick.1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                java.lang.Object tag = view.getTag(com.qmuiteam.qmui.R.id.qmui_click_debounce_action);
                if (!(tag instanceof com.up366.qmui.kotlin.DebounceAction)) {
                    tag = null;
                }
                com.up366.qmui.kotlin.DebounceAction debounceAction = (com.up366.qmui.kotlin.DebounceAction) tag;
                if (debounceAction == null) {
                    kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(view, "v");
                    debounceAction = new com.up366.qmui.kotlin.DebounceAction(view, function1);
                    view.setTag(com.qmuiteam.qmui.R.id.qmui_click_debounce_action, debounceAction);
                } else {
                    debounceAction.setBlock(function1);
                }
                com.up366.qmui.kotlin.DebounceAction debounceAction2 = debounceAction;
                view.removeCallbacks(debounceAction2);
                view.postDelayed(debounceAction2, j);
            }
        };
    }

    public static /* synthetic */ void onClick$default(android.view.View view, long j, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        onClick(view, j, function1);
    }

    public static final void onClick(android.view.View view, long j, kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$onClick");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(function1, "block");
        view.setOnClickListener(throttleClick(j, function1));
    }

    public static /* synthetic */ void onDebounceClick$default(android.view.View view, long j, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = 200;
        }
        onDebounceClick(view, j, function1);
    }

    public static final void onDebounceClick(android.view.View view, long j, kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$onDebounceClick");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(function1, "block");
        view.setOnClickListener(debounceClick(j, function1));
    }

    public static final void skin(android.view.View view, kotlin.jvm.functions.Function1<? super com.up366.qmui.skin.QMUISkinValueBuilder, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "$this$skin");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(function1, "block");
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(qMUISkinValueBuilderAcquire, "builder");
        function1.invoke(qMUISkinValueBuilderAcquire);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(view, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
    }
}
