package com.up366.photopicker.ui;

/* JADX INFO: compiled from: SafeClick.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001e\u0010\t\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a(\u0010\u000b\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DEFAULT_CLICK_INTERVAL_MS", "", "DEFAULT_NORMAL_ALPHA", "", "DEFAULT_PRESSED_ALPHA", "disablePressedAlphaFeedback", "", "Landroid/view/View;", "normalAlpha", "enablePressedAlphaFeedback", "pressedAlpha", "setSafeClickListener", "intervalMs", "onSafeClick", "Lkotlin/Function1;", "photopicker_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SafeClickKt {
    private static final long DEFAULT_CLICK_INTERVAL_MS = 600;
    private static final float DEFAULT_NORMAL_ALPHA = 1.0f;
    private static final float DEFAULT_PRESSED_ALPHA = 0.6f;

    public static /* synthetic */ void enablePressedAlphaFeedback$default(android.view.View view, float f, float f2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = DEFAULT_PRESSED_ALPHA;
        }
        if ((i & 2) != 0) {
            f2 = DEFAULT_NORMAL_ALPHA;
        }
        enablePressedAlphaFeedback(view, f, f2);
    }

    public static final void enablePressedAlphaFeedback(final android.view.View view, final float f, final float f2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.photopicker.ui.SafeClickKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                return com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$lambda$0(view, f2, f, view2, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean enablePressedAlphaFeedback$lambda$0(android.view.View r4, float r5, float r6, android.view.View r7, android.view.MotionEvent r8) {
        /*
            java.lang.String r0 = "$this_enablePressedAlphaFeedback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4.isEnabled()
            r1 = 0
            if (r0 != 0) goto L10
            r4.setAlpha(r5)
            return r1
        L10:
            int r0 = r8.getActionMasked()
            if (r0 == 0) goto L54
            r2 = 1
            if (r0 == r2) goto L50
            r2 = 2
            if (r0 == r2) goto L20
            r6 = 3
            if (r0 == r6) goto L50
            goto L57
        L20:
            float r0 = r8.getX()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L4c
            float r0 = r8.getX()
            int r3 = r7.getWidth()
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L4c
            float r0 = r8.getY()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L4c
            float r8 = r8.getY()
            int r7 = r7.getHeight()
            float r7 = (float) r7
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 > 0) goto L4c
            r5 = r6
        L4c:
            r4.setAlpha(r5)
            goto L57
        L50:
            r4.setAlpha(r5)
            goto L57
        L54:
            r4.setAlpha(r6)
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$lambda$0(android.view.View, float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    public static /* synthetic */ void disablePressedAlphaFeedback$default(android.view.View view, float f, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            f = DEFAULT_NORMAL_ALPHA;
        }
        disablePressedAlphaFeedback(view, f);
    }

    public static final void disablePressedAlphaFeedback(android.view.View view, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOnTouchListener(null);
        view.setAlpha(f);
    }

    public static /* synthetic */ void setSafeClickListener$default(android.view.View view, long j, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            j = DEFAULT_CLICK_INTERVAL_MS;
        }
        setSafeClickListener(view, j, function1);
    }

    public static final void setSafeClickListener(android.view.View view, final long j, final kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "onSafeClick");
        final kotlin.jvm.internal.Ref.LongRef longRef = new kotlin.jvm.internal.Ref.LongRef();
        view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.SafeClickKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$lambda$1(longRef, j, function1, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSafeClickListener$lambda$1(kotlin.jvm.internal.Ref.LongRef longRef, long j, kotlin.jvm.functions.Function1 function1, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longRef, "$lastClickTime");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "$onSafeClick");
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (jElapsedRealtime - longRef.element >= j) {
            longRef.element = jElapsedRealtime;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(view, "v");
            function1.invoke(view);
        }
    }
}
