package com.up366.qmui.widget.popup;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIFullScreenPopup extends com.up366.qmui.widget.popup.QMUIBasePopup<com.up366.qmui.widget.popup.QMUIFullScreenPopup> {
    private static com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener sOffsetHalfKeyboardHeightListener;
    private static com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener sOffsetKeyboardHeightListener;
    private boolean mAddCloseBtn;
    private int mAnimStyle;
    private android.graphics.drawable.Drawable mCloseIcon;
    private int mCloseIconAttr;
    private androidx.constraintlayout.widget.ConstraintLayout.LayoutParams mCloseIvLayoutParams;
    private com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnBlankClickListener mOnBlankClickListener;
    private java.util.ArrayList<com.up366.qmui.widget.popup.QMUIFullScreenPopup.ViewInfo> mViews;

    public interface OnBlankClickListener {
        void onBlankClick(com.up366.qmui.widget.popup.QMUIFullScreenPopup qMUIFullScreenPopup);
    }

    public interface OnKeyBoardListener {
        void onKeyboardToggle(android.view.View view, boolean z, int i, int i2);
    }

    public static com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener getOffsetKeyboardHeightListener() {
        if (sOffsetKeyboardHeightListener == null) {
            sOffsetKeyboardHeightListener = new com.up366.qmui.widget.popup.QMUIFullScreenPopup.KeyboardPercentOffsetListener(1.0f);
        }
        return sOffsetKeyboardHeightListener;
    }

    public static com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener getOffsetHalfKeyboardHeightListener() {
        if (sOffsetHalfKeyboardHeightListener == null) {
            sOffsetHalfKeyboardHeightListener = new com.up366.qmui.widget.popup.QMUIFullScreenPopup.KeyboardPercentOffsetListener(0.5f);
        }
        return sOffsetHalfKeyboardHeightListener;
    }

    public QMUIFullScreenPopup(android.content.Context context) {
        super(context);
        this.mAddCloseBtn = false;
        this.mCloseIconAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_popup_close_icon;
        this.mCloseIcon = null;
        this.mAnimStyle = -1;
        this.mViews = new java.util.ArrayList<>();
        this.mWindow.setWidth(-1);
        this.mWindow.setHeight(-1);
        dimAmount(0.6f);
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup onBlankClick(com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnBlankClickListener onBlankClickListener) {
        this.mOnBlankClickListener = onBlankClickListener;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup closeBtn(boolean z) {
        this.mAddCloseBtn = z;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup closeIcon(android.graphics.drawable.Drawable drawable) {
        this.mCloseIcon = drawable;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup closeIconAttr(int i) {
        this.mCloseIconAttr = i;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup closeLp(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
        this.mCloseIvLayoutParams = layoutParams;
        return this;
    }

    public int getCloseBtnId() {
        return com.qmuiteam.qmui.R.id.qmui_popup_close_btn_id;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup animStyle(int i) {
        this.mAnimStyle = i;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup addView(android.view.View view, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams, com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener onKeyBoardListener) {
        this.mViews.add(new com.up366.qmui.widget.popup.QMUIFullScreenPopup.ViewInfo(view, layoutParams, onKeyBoardListener));
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup addView(android.view.View view, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
        return addView(view, layoutParams, null);
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup addView(android.view.View view, com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener onKeyBoardListener) {
        this.mViews.add(new com.up366.qmui.widget.popup.QMUIFullScreenPopup.ViewInfo(view, defaultContentLp(), onKeyBoardListener));
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIFullScreenPopup addView(android.view.View view) {
        return addView(view, defaultContentLp());
    }

    private androidx.constraintlayout.widget.ConstraintLayout.LayoutParams defaultContentLp() {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        return layoutParams;
    }

    private androidx.constraintlayout.widget.ConstraintLayout.LayoutParams defaultCloseIvLp() {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.bottomMargin = com.up366.qmui.util.QMUIDisplayHelper.dp2px(this.mContext, 48);
        return layoutParams;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.up366.qmui.alpha.QMUIAlphaImageButton] */
    private com.up366.qmui.alpha.QMUIAlphaImageButton createCloseIv() {
        ?? qMUIAlphaImageButton = new com.up366.qmui.alpha.QMUIAlphaImageButton(this.mContext);
        qMUIAlphaImageButton.setPadding(0, 0, 0, 0);
        qMUIAlphaImageButton.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        qMUIAlphaImageButton.setId(com.qmuiteam.qmui.R.id.qmui_popup_close_btn_id);
        qMUIAlphaImageButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.popup.QMUIFullScreenPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.up366.qmui.widget.popup.QMUIFullScreenPopup.this.dismiss();
            }
        });
        qMUIAlphaImageButton.setFitsSystemWindows(true);
        android.graphics.drawable.Drawable attrDrawable = this.mCloseIcon;
        if (attrDrawable == null) {
            if (this.mCloseIconAttr != 0) {
                com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderSrc = com.up366.qmui.skin.QMUISkinValueBuilder.acquire().src(this.mCloseIconAttr);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUIAlphaImageButton, qMUISkinValueBuilderSrc);
                qMUISkinValueBuilderSrc.release();
                attrDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(this.mContext, this.mCloseIconAttr);
            } else {
                attrDrawable = null;
            }
        }
        qMUIAlphaImageButton.setImageDrawable(attrDrawable);
        return qMUIAlphaImageButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.up366.qmui.widget.popup.QMUIFullScreenPopup$RootView] */
    public void show(android.view.View view) {
        if (this.mViews.isEmpty()) {
            throw new java.lang.RuntimeException("you should call addView() to add content view");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mViews);
        ?? rootView = new com.up366.qmui.widget.popup.QMUIFullScreenPopup.RootView(this.mContext);
        for (int i = 0; i < arrayList.size(); i++) {
            com.up366.qmui.widget.popup.QMUIFullScreenPopup.ViewInfo viewInfo = this.mViews.get(i);
            android.view.View view2 = viewInfo.view;
            if (view2.getParent() != null) {
                ((android.view.ViewGroup) view2.getParent()).removeView(view2);
            }
            rootView.addView(view2, viewInfo.lp);
        }
        if (this.mAddCloseBtn) {
            if (this.mCloseIvLayoutParams == null) {
                this.mCloseIvLayoutParams = defaultCloseIvLp();
            }
            rootView.addView(createCloseIv(), this.mCloseIvLayoutParams);
        }
        this.mWindow.setContentView(rootView);
        if (this.mAnimStyle != -1) {
            this.mWindow.setAnimationStyle(this.mAnimStyle);
        }
        showAtLocation(view, 0, 0);
    }

    @Override // com.up366.qmui.widget.popup.QMUIBasePopup
    protected void modifyWindowLayoutParams(android.view.WindowManager.LayoutParams layoutParams) {
        layoutParams.flags |= 65792;
        super.modifyWindowLayoutParams(layoutParams);
    }

    class RootView extends com.up366.qmui.widget.QMUIWindowInsetLayout2 implements com.up366.qmui.widget.IWindowInsetKeyboardConsumer {
        private androidx.core.view.GestureDetectorCompat mGestureDetector;
        private int mLastKeyboardShowHeight;

        public RootView(android.content.Context context) {
            super(context);
            this.mLastKeyboardShowHeight = 0;
            this.mGestureDetector = new androidx.core.view.GestureDetectorCompat(context, new android.view.GestureDetector.SimpleOnGestureListener() { // from class: com.up366.qmui.widget.popup.QMUIFullScreenPopup.RootView.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
                    return true;
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            if (this.mGestureDetector.onTouchEvent(motionEvent)) {
                android.view.View viewFindChildViewUnder = findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                boolean zIsTouchInBlank = viewFindChildViewUnder == 0;
                if (!zIsTouchInBlank && (viewFindChildViewUnder instanceof com.up366.qmui.widget.IBlankTouchDetector)) {
                    android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(getScrollX() - viewFindChildViewUnder.getLeft(), getScrollY() - viewFindChildViewUnder.getTop());
                    zIsTouchInBlank = ((com.up366.qmui.widget.IBlankTouchDetector) viewFindChildViewUnder).isTouchInBlank(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zIsTouchInBlank && com.up366.qmui.widget.popup.QMUIFullScreenPopup.this.mOnBlankClickListener != null) {
                    com.up366.qmui.widget.popup.QMUIFullScreenPopup.this.mOnBlankClickListener.onBlankClick(com.up366.qmui.widget.popup.QMUIFullScreenPopup.this);
                }
            }
            return true;
        }

        private android.view.View findChildViewUnder(float f, float f2) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                android.view.View childAt = getChildAt(childCount);
                float translationX = childAt.getTranslationX();
                float translationY = childAt.getTranslationY();
                if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.up366.qmui.widget.QMUIWindowInsetLayout2, com.up366.qmui.widget.IWindowInsetLayout
        public boolean applySystemWindowInsets19(android.graphics.Rect rect) {
            super.applySystemWindowInsets19(rect);
            return true;
        }

        @Override // com.up366.qmui.widget.QMUIWindowInsetLayout2, com.up366.qmui.widget.IWindowInsetLayout
        public boolean applySystemWindowInsets21(java.lang.Object obj) {
            super.applySystemWindowInsets21(obj);
            return true;
        }

        @Override // com.up366.qmui.widget.IWindowInsetKeyboardConsumer
        public void onHandleKeyboard(int i) {
            if (i <= 0) {
                for (com.up366.qmui.widget.popup.QMUIFullScreenPopup.ViewInfo viewInfo : com.up366.qmui.widget.popup.QMUIFullScreenPopup.this.mViews) {
                    if (viewInfo.onKeyBoardListener != null) {
                        viewInfo.onKeyBoardListener.onKeyboardToggle(viewInfo.view, false, this.mLastKeyboardShowHeight, getHeight());
                    }
                }
                return;
            }
            this.mLastKeyboardShowHeight = i;
            for (com.up366.qmui.widget.popup.QMUIFullScreenPopup.ViewInfo viewInfo2 : com.up366.qmui.widget.popup.QMUIFullScreenPopup.this.mViews) {
                if (viewInfo2.onKeyBoardListener != null) {
                    viewInfo2.onKeyBoardListener.onKeyboardToggle(viewInfo2.view, true, i, getHeight());
                }
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            java.util.Iterator it = com.up366.qmui.widget.popup.QMUIFullScreenPopup.this.mViews.iterator();
            while (it.hasNext()) {
                com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = (com.up366.qmui.util.QMUIViewOffsetHelper) ((com.up366.qmui.widget.popup.QMUIFullScreenPopup.ViewInfo) it.next()).view.getTag(com.qmuiteam.qmui.R.id.qmui_view_offset_helper);
                if (qMUIViewOffsetHelper != null) {
                    qMUIViewOffsetHelper.onViewLayout();
                }
            }
        }
    }

    class ViewInfo {
        private androidx.constraintlayout.widget.ConstraintLayout.LayoutParams lp;
        private com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener onKeyBoardListener;
        private android.view.View view;

        public ViewInfo(android.view.View view, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams, com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener onKeyBoardListener) {
            this.view = view;
            this.lp = layoutParams;
            this.onKeyBoardListener = onKeyBoardListener;
        }
    }

    public static com.up366.qmui.util.QMUIViewOffsetHelper getOrCreateViewOffsetHelper(android.view.View view) {
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = (com.up366.qmui.util.QMUIViewOffsetHelper) view.getTag(com.qmuiteam.qmui.R.id.qmui_view_offset_helper);
        if (qMUIViewOffsetHelper != null) {
            return qMUIViewOffsetHelper;
        }
        com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper2 = new com.up366.qmui.util.QMUIViewOffsetHelper(view);
        view.setTag(com.qmuiteam.qmui.R.id.qmui_view_offset_helper, qMUIViewOffsetHelper2);
        return qMUIViewOffsetHelper2;
    }

    public static class KeyboardPercentOffsetListener implements com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener {
        private android.animation.ValueAnimator mAnimator;
        private float mPercent;

        public KeyboardPercentOffsetListener(float f) {
            this.mPercent = f;
        }

        @Override // com.up366.qmui.widget.popup.QMUIFullScreenPopup.OnKeyBoardListener
        public void onKeyboardToggle(android.view.View view, boolean z, int i, int i2) {
            final com.up366.qmui.util.QMUIViewOffsetHelper orCreateViewOffsetHelper = com.up366.qmui.widget.popup.QMUIFullScreenPopup.getOrCreateViewOffsetHelper(view);
            android.animation.ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                com.up366.qmui.util.QMUIViewHelper.clearValueAnimator(valueAnimator);
            }
            android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(orCreateViewOffsetHelper.getTopAndBottomOffset(), z ? (int) ((-i) * this.mPercent) : 0);
            this.mAnimator = valueAnimatorOfInt;
            valueAnimatorOfInt.setInterpolator(com.up366.qmui.QMUIInterpolatorStaticHolder.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.mAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.widget.popup.QMUIFullScreenPopup.KeyboardPercentOffsetListener.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    orCreateViewOffsetHelper.setTopAndBottomOffset(((java.lang.Integer) valueAnimator2.getAnimatedValue()).intValue());
                }
            });
            this.mAnimator.start();
        }
    }
}
