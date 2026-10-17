package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AnimUtils {
    private static final int DURATION = 450;

    public static void zoom(android.view.View view, boolean z) {
        if (z) {
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.12f), android.animation.ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.12f));
            animatorSet.setDuration(450L);
            animatorSet.start();
        }
    }

    public static void disZoom(android.view.View view, boolean z) {
        if (z) {
            android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
            animatorSet.playTogether(android.animation.ObjectAnimator.ofFloat(view, "scaleX", 1.12f, 1.0f), android.animation.ObjectAnimator.ofFloat(view, "scaleY", 1.12f, 1.0f));
            animatorSet.setDuration(450L);
            animatorSet.start();
        }
    }

    public static void rotateArrow(android.widget.ImageView imageView, boolean z) {
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(180.0f, 360.0f, imageView.getWidth() / 2.0f, imageView.getHeight() / 2.0f);
        rotateAnimation.setDuration(350L);
        imageView.startAnimation(rotateAnimation);
    }
}
