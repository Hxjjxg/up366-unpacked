package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIViewHelper {
    private static final java.util.concurrent.atomic.AtomicInteger sNextGeneratedId = new java.util.concurrent.atomic.AtomicInteger(1);
    private static final int[] APPCOMPAT_CHECK_ATTRS = {androidx.appcompat.R.attr.colorPrimary};

    public static boolean getIsLastLineSpacingExtraError() {
        return false;
    }

    public static void checkAppCompatTheme(android.content.Context context) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        boolean z = !typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            throw new java.lang.IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }

    public static android.view.View getActivityRoot(android.app.Activity activity) {
        return ((android.view.ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    }

    public static void requestApplyInsets(android.view.Window window) {
        window.getDecorView().requestApplyInsets();
    }

    public static void expendTouchArea(final android.view.View view, final int i) {
        if (view != null) {
            final android.view.View view2 = (android.view.View) view.getParent();
            view2.post(new java.lang.Runnable() { // from class: com.up366.qmui.util.QMUIViewHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    android.graphics.Rect rect = new android.graphics.Rect();
                    view.getHitRect(rect);
                    rect.left -= i;
                    rect.top -= i;
                    rect.right += i;
                    rect.bottom += i;
                    view2.setTouchDelegate(new android.view.TouchDelegate(rect, view));
                }
            });
        }
    }

    public static void setBackground(android.view.View view, android.graphics.drawable.Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundKeepingPadding(android.view.View view, android.graphics.drawable.Drawable drawable) {
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        view.setBackground(drawable);
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public static void setBackgroundKeepingPadding(android.view.View view, int i) {
        setBackgroundKeepingPadding(view, androidx.core.content.ContextCompat.getDrawable(view.getContext(), i));
    }

    public static void setBackgroundColorKeepPadding(android.view.View view, int i) {
        int[] iArr = {view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        view.setBackgroundColor(i);
        view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public static void playBackgroundBlinkAnimation(android.view.View view, int i) {
        if (view == null) {
            return;
        }
        playViewBackgroundAnimation(view, i, new int[]{0, 255, 0}, 300);
    }

    public static android.animation.Animator playViewBackgroundAnimation(final android.view.View view, int i, int[] iArr, int i2, final java.lang.Runnable runnable) {
        int length = iArr.length - 1;
        android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable(i);
        final android.graphics.drawable.Drawable background = view.getBackground();
        setBackgroundKeepingPadding(view, colorDrawable);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i3 = 0;
        while (i3 < length) {
            android.graphics.drawable.Drawable background2 = view.getBackground();
            int i4 = iArr[i3];
            i3++;
            arrayList.add(android.animation.ObjectAnimator.ofInt(background2, com.up366.qmui.skin.QMUISkinValueBuilder.ALPHA, i4, iArr[i3]));
        }
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.setDuration(i2);
        animatorSet.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.up366.qmui.util.QMUIViewHelper.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.up366.qmui.util.QMUIViewHelper.setBackgroundKeepingPadding(view, background);
                java.lang.Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
        animatorSet.playSequentially(arrayList);
        animatorSet.start();
        return animatorSet;
    }

    public static void playViewBackgroundAnimation(android.view.View view, int i, int[] iArr, int i2) {
        playViewBackgroundAnimation(view, i, iArr, i2, null);
    }

    public static void playViewBackgroundAnimation(final android.view.View view, int i, int i2, long j, int i3, int i4, final java.lang.Runnable runnable) {
        final android.graphics.drawable.Drawable background = view.getBackground();
        setBackgroundColorKeepPadding(view, i);
        android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
        valueAnimator.setIntValues(i, i2);
        valueAnimator.setDuration(j / ((long) (i3 + 1)));
        valueAnimator.setRepeatCount(i3);
        valueAnimator.setRepeatMode(2);
        valueAnimator.setEvaluator(new android.animation.ArgbEvaluator());
        valueAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.util.QMUIViewHelper.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                com.up366.qmui.util.QMUIViewHelper.setBackgroundColorKeepPadding(view, ((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
            }
        });
        if (i4 != 0) {
            view.setTag(i4, valueAnimator);
        }
        valueAnimator.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.up366.qmui.util.QMUIViewHelper.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.up366.qmui.util.QMUIViewHelper.setBackgroundKeepingPadding(view, background);
                java.lang.Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
        valueAnimator.start();
    }

    public static void playViewBackgroundAnimation(android.view.View view, int i, int i2, long j) {
        playViewBackgroundAnimation(view, i, i2, j, 0, 0, null);
    }

    public static int generateViewId() {
        return android.view.View.generateViewId();
    }

    public static android.view.animation.AlphaAnimation fadeIn(android.view.View view, int i, android.view.animation.Animation.AnimationListener animationListener, boolean z) {
        if (view == null) {
            return null;
        }
        if (z) {
            view.setVisibility(0);
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            alphaAnimation.setDuration(i);
            alphaAnimation.setFillAfter(true);
            if (animationListener != null) {
                alphaAnimation.setAnimationListener(animationListener);
            }
            view.startAnimation(alphaAnimation);
            return alphaAnimation;
        }
        view.setAlpha(1.0f);
        view.setVisibility(0);
        return null;
    }

    public static android.view.animation.AlphaAnimation fadeOut(final android.view.View view, int i, final android.view.animation.Animation.AnimationListener animationListener, boolean z) {
        if (view == null) {
            return null;
        }
        if (z) {
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            alphaAnimation.setDuration(i);
            alphaAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.up366.qmui.util.QMUIViewHelper.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationStart(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    view.setVisibility(8);
                    android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationEnd(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                    android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationRepeat(animation);
                    }
                }
            });
            view.startAnimation(alphaAnimation);
            return alphaAnimation;
        }
        view.setVisibility(8);
        return null;
    }

    public static void clearValueAnimator(android.animation.Animator animator) {
        if (animator != null) {
            animator.removeAllListeners();
            if (animator instanceof android.animation.ValueAnimator) {
                ((android.animation.ValueAnimator) animator).removeAllUpdateListeners();
            }
            animator.pause();
            animator.cancel();
        }
    }

    public static android.graphics.Rect calcViewScreenLocation(android.view.View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new android.graphics.Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
    }

    /* JADX INFO: renamed from: com.up366.qmui.util.QMUIViewHelper$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$up366$qmui$util$QMUIDirection;

        static {
            int[] iArr = new int[com.up366.qmui.util.QMUIDirection.values().length];
            $SwitchMap$com$up366$qmui$util$QMUIDirection = iArr;
            try {
                iArr[com.up366.qmui.util.QMUIDirection.LEFT_TO_RIGHT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$up366$qmui$util$QMUIDirection[com.up366.qmui.util.QMUIDirection.TOP_TO_BOTTOM.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$up366$qmui$util$QMUIDirection[com.up366.qmui.util.QMUIDirection.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$up366$qmui$util$QMUIDirection[com.up366.qmui.util.QMUIDirection.BOTTOM_TO_TOP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public static android.view.animation.TranslateAnimation slideIn(android.view.View view, int i, android.view.animation.Animation.AnimationListener animationListener, boolean z, com.up366.qmui.util.QMUIDirection qMUIDirection) {
        android.view.animation.TranslateAnimation translateAnimation = null;
        if (view == null) {
            return null;
        }
        if (z) {
            int i2 = com.up366.qmui.util.QMUIViewHelper.AnonymousClass7.$SwitchMap$com$up366$qmui$util$QMUIDirection[qMUIDirection.ordinal()];
            if (i2 == 1) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            } else if (i2 == 2) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            } else if (i2 == 3) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            } else if (i2 == 4) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            }
            translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            translateAnimation.setDuration(i);
            translateAnimation.setFillAfter(true);
            if (animationListener != null) {
                translateAnimation.setAnimationListener(animationListener);
            }
            view.setVisibility(0);
            view.startAnimation(translateAnimation);
            return translateAnimation;
        }
        view.clearAnimation();
        view.setVisibility(0);
        return null;
    }

    public static android.view.animation.TranslateAnimation slideOut(final android.view.View view, int i, final android.view.animation.Animation.AnimationListener animationListener, boolean z, com.up366.qmui.util.QMUIDirection qMUIDirection) {
        android.view.animation.TranslateAnimation translateAnimation = null;
        if (view == null) {
            return null;
        }
        if (z) {
            int i2 = com.up366.qmui.util.QMUIViewHelper.AnonymousClass7.$SwitchMap$com$up366$qmui$util$QMUIDirection[qMUIDirection.ordinal()];
            if (i2 == 1) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            } else if (i2 == 2) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            } else if (i2 == 3) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            } else if (i2 == 4) {
                translateAnimation = new android.view.animation.TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            }
            translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            translateAnimation.setDuration(i);
            translateAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.up366.qmui.util.QMUIViewHelper.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationStart(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    view.setVisibility(8);
                    android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationEnd(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                    android.view.animation.Animation.AnimationListener animationListener2 = animationListener;
                    if (animationListener2 != null) {
                        animationListener2.onAnimationRepeat(animation);
                    }
                }
            });
            view.startAnimation(translateAnimation);
            return translateAnimation;
        }
        view.clearAnimation();
        view.setVisibility(8);
        return null;
    }

    public static void setPaddingLeft(android.view.View view, int i) {
        if (i != view.getPaddingLeft()) {
            view.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setPaddingTop(android.view.View view, int i) {
        if (i != view.getPaddingTop()) {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void setPaddingRight(android.view.View view, int i) {
        if (i != view.getPaddingRight()) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i, view.getPaddingBottom());
        }
    }

    public static void setPaddingBottom(android.view.View view, int i) {
        if (i != view.getPaddingBottom()) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
        }
    }

    public static void safeRequestDisallowInterceptTouchEvent(android.view.View view, boolean z) {
        android.view.ViewParent parent = view.getParent();
        if (parent != null) {
            for (android.view.ViewParent parent2 = parent; parent2 != null; parent2 = parent2.getParent()) {
                if (parent2 instanceof com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout) {
                    ((com.up366.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout) parent2).openSafeDisallowInterceptTouchEvent();
                }
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public static android.view.View findViewFromViewStub(android.view.View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        android.view.View viewFindViewById = view.findViewById(i2);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        android.view.ViewStub viewStub = (android.view.ViewStub) view.findViewById(i);
        if (viewStub == null) {
            return null;
        }
        android.view.View viewInflate = viewStub.inflate();
        return viewInflate != null ? viewInflate.findViewById(i2) : viewInflate;
    }

    public static android.view.View findViewFromViewStub(android.view.View view, int i, int i2, int i3) {
        if (view == null) {
            return null;
        }
        android.view.View viewFindViewById = view.findViewById(i2);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        android.view.ViewStub viewStub = (android.view.ViewStub) view.findViewById(i);
        if (viewStub == null) {
            return null;
        }
        if (viewStub.getLayoutResource() < 1 && i3 > 0) {
            viewStub.setLayoutResource(i3);
        }
        android.view.View viewInflate = viewStub.inflate();
        return viewInflate != null ? viewInflate.findViewById(i2) : viewInflate;
    }

    public static void safeSetImageViewSelected(android.widget.ImageView imageView, boolean z) {
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        imageView.setSelected(z);
        if (drawable.getIntrinsicWidth() == intrinsicWidth && drawable.getIntrinsicHeight() == intrinsicHeight) {
            return;
        }
        imageView.requestLayout();
    }

    @java.lang.Deprecated
    public static android.graphics.ColorFilter setImageViewTintColor(android.widget.ImageView imageView, int i) {
        android.graphics.LightingColorFilter lightingColorFilter = new android.graphics.LightingColorFilter(android.graphics.Color.argb(255, 0, 0, 0), i);
        imageView.setColorFilter(lightingColorFilter);
        return lightingColorFilter;
    }

    public static boolean isListViewAlreadyAtBottom(android.widget.ListView listView) {
        android.view.View childAt;
        return (listView.getAdapter() == null || listView.getHeight() == 0 || listView.getLastVisiblePosition() != listView.getAdapter().getCount() - 1 || (childAt = listView.getChildAt(listView.getChildCount() - 1)) == null || childAt.getBottom() != listView.getHeight()) ? false : true;
    }

    public static void getDescendantRect(android.view.ViewGroup viewGroup, android.view.View view, android.graphics.Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        com.up366.qmui.util.QMUIViewHelper.ViewGroupHelper.offsetDescendantRect(viewGroup, view, rect);
    }

    private static class ViewGroupHelper {
        private static final java.lang.ThreadLocal<android.graphics.Matrix> sMatrix = new java.lang.ThreadLocal<>();
        private static final java.lang.ThreadLocal<android.graphics.RectF> sRectF = new java.lang.ThreadLocal<>();

        private ViewGroupHelper() {
        }

        public static void offsetDescendantRect(android.view.ViewGroup viewGroup, android.view.View view, android.graphics.Rect rect) {
            java.lang.ThreadLocal<android.graphics.Matrix> threadLocal = sMatrix;
            android.graphics.Matrix matrix = threadLocal.get();
            if (matrix == null) {
                matrix = new android.graphics.Matrix();
                threadLocal.set(matrix);
            } else {
                matrix.reset();
            }
            offsetDescendantMatrix(viewGroup, view, matrix);
            java.lang.ThreadLocal<android.graphics.RectF> threadLocal2 = sRectF;
            android.graphics.RectF rectF = threadLocal2.get();
            if (rectF == null) {
                rectF = new android.graphics.RectF();
                threadLocal2.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }

        static void offsetDescendantMatrix(android.view.ViewParent viewParent, android.view.View view, android.graphics.Matrix matrix) {
            java.lang.Object parent = view.getParent();
            if ((parent instanceof android.view.View) && parent != viewParent) {
                offsetDescendantMatrix(viewParent, (android.view.View) parent, matrix);
                matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
            }
            matrix.preTranslate(view.getLeft(), view.getTop());
            if (view.getMatrix().isIdentity()) {
                return;
            }
            matrix.preConcat(view.getMatrix());
        }
    }
}
