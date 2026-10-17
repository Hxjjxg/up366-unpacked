package com.up366.medialibrary.common.animators;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ViewHelper {
    public static void clear(android.view.View view) {
        view.setAlpha(1.0f);
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setPivotY(view.getMeasuredHeight() / 2);
        view.setPivotX(view.getMeasuredWidth() / 2);
        androidx.core.view.ViewCompat.animate(view).setInterpolator((android.view.animation.Interpolator) null).setStartDelay(0L);
    }
}
