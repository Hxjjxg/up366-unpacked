package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AnimUtils {

    public static class AnimationAdapter implements android.view.animation.Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    public static void delay2sHide(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.delay_2sec_hide));
    }

    public static void delay2sHideAnimFullAfter(android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.delay_2sec_hide_full_after));
        }
    }

    public static void fadeOut(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), android.R.anim.fade_out));
    }

    public static void fadeOutAndGone(final android.view.View view) {
        android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), android.R.anim.fade_out);
        view.startAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.up366.mobile.common.utils.AnimUtils.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                view.setVisibility(8);
            }
        });
    }

    public static void fadeIn(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), android.R.anim.fade_in));
    }

    public static void inFromRight(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.in_from_right));
    }

    public static void inFromBottom(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.in_from_bottom_with_alpha));
    }

    public static void outToTop(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.out_to_bottom_with_alpha));
    }

    public static void outToBottom(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.out_to_bottom_with_alpha));
    }

    public static void outToRight(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.out_to_right));
    }

    public static void popIn(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.pop_in));
    }

    public static void popIn(android.view.View view, com.up366.mobile.common.utils.AnimUtils.AnimationAdapter animationAdapter) {
        android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.pop_in);
        animationLoadAnimation.setAnimationListener(animationAdapter);
        view.startAnimation(animationLoadAnimation);
    }

    public static void popOut(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.pop_out));
    }

    public static void popOut(android.view.View view, com.up366.mobile.common.utils.AnimUtils.AnimationAdapter animationAdapter) {
        android.view.animation.Animation animationLoadAnimation = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.pop_out);
        animationLoadAnimation.setAnimationListener(animationAdapter);
        view.clearAnimation();
        view.startAnimation(animationLoadAnimation);
    }

    public static void roate1(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.roate_180_full_after_1));
    }

    public static void roate90(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.roate_90_full_after_1));
    }

    public static void roate2(android.view.View view) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), com.up366.mobile.R.anim.roate_180_full_after_2));
    }

    public static void start(android.view.View view, int i) {
        view.startAnimation(android.view.animation.AnimationUtils.loadAnimation(view.getContext(), i));
    }

    public static void showAnimation(android.widget.ImageView imageView) {
        android.view.animation.RotateAnimation rotateAnimation = new android.view.animation.RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1200L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(false);
        imageView.startAnimation(rotateAnimation);
    }

    public static void cancelAnimation(android.widget.ImageView imageView) {
        if (imageView == null || imageView.getAnimation() == null) {
            return;
        }
        imageView.getAnimation().cancel();
    }
}
