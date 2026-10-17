package com.up366.qmui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIInterpolatorStaticHolder {
    public static final android.view.animation.Interpolator LINEAR_INTERPOLATOR = new android.view.animation.LinearInterpolator();
    public static final android.view.animation.Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new androidx.interpolator.view.animation.FastOutSlowInInterpolator();
    public static final android.view.animation.Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new androidx.interpolator.view.animation.FastOutLinearInInterpolator();
    public static final android.view.animation.Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new androidx.interpolator.view.animation.LinearOutSlowInInterpolator();
    public static final android.view.animation.Interpolator DECELERATE_INTERPOLATOR = new android.view.animation.DecelerateInterpolator();
    public static final android.view.animation.Interpolator ACCELERATE_INTERPOLATOR = new android.view.animation.AccelerateInterpolator();
    public static final android.view.animation.Interpolator ACCELERATE_DECELERATE_INTERPOLATOR = new android.view.animation.AccelerateDecelerateInterpolator();
    public static final android.view.animation.Interpolator QUNITIC_INTERPOLATOR = new android.view.animation.Interpolator() { // from class: com.up366.qmui.QMUIInterpolatorStaticHolder.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
}
