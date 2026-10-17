package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDraggableScrollBar extends android.view.View {
    private int[] STATE_NORMAL;
    private int[] STATE_PRESSED;
    private boolean enableFadeInAndOut;
    private int mAdjustDistanceProtection;
    private int mAdjustMaxDistanceOnce;
    private com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback mCallback;
    private float mCurrentAlpha;
    private java.lang.Runnable mDelayInvalidateRunnable;
    private android.graphics.drawable.Drawable mDragDrawable;
    private float mDragInnerTop;
    private int mDrawableDrawTop;
    private boolean mIsInDragging;
    private int mKeepShownTime;
    private float mPercent;
    private long mStartTransitionTime;
    private int mTransitionDuration;

    interface Callback {
        void onDragEnd();

        void onDragStarted();

        void onDragToPercent(float f);
    }

    protected int getScrollBarBottomMargin() {
        return 0;
    }

    protected int getScrollBarTopMargin() {
        return 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QMUIDraggableScrollBar(android.content.Context context) {
        this(context, (android.util.AttributeSet) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QMUIDraggableScrollBar(android.content.Context context, android.graphics.drawable.Drawable drawable) {
        this(context, (android.util.AttributeSet) null);
        this.mDragDrawable = drawable.mutate();
    }

    public QMUIDraggableScrollBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.STATE_PRESSED = new int[]{android.R.attr.state_pressed};
        this.STATE_NORMAL = new int[0];
        this.mKeepShownTime = 800;
        this.mTransitionDuration = 100;
        this.mStartTransitionTime = 0L;
        this.mCurrentAlpha = 0.0f;
        this.mPercent = 0.0f;
        this.mDelayInvalidateRunnable = new java.lang.Runnable() { // from class: com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.this.invalidate();
            }
        };
        this.mIsInDragging = false;
        this.mDrawableDrawTop = -1;
        this.mDragInnerTop = 0.0f;
        this.mAdjustDistanceProtection = com.up366.qmui.util.QMUIDisplayHelper.dp2px(getContext(), 20);
        this.mAdjustMaxDistanceOnce = com.up366.qmui.util.QMUIDisplayHelper.dp2px(getContext(), 4);
        this.enableFadeInAndOut = true;
    }

    public void setCallback(com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback callback) {
        this.mCallback = callback;
    }

    public void setKeepShownTime(int i) {
        this.mKeepShownTime = i;
    }

    public void setTransitionDuration(int i) {
        this.mTransitionDuration = i;
    }

    public void setEnableFadeInAndOut(boolean z) {
        this.enableFadeInAndOut = z;
    }

    public boolean isEnableFadeInAndOut() {
        return this.enableFadeInAndOut;
    }

    public void setDragDrawable(android.graphics.drawable.Drawable drawable) {
        this.mDragDrawable = drawable.mutate();
        invalidate();
    }

    public void setPercent(float f) {
        if (this.mIsInDragging) {
            return;
        }
        setPercentInternal(f);
    }

    private void setPercentInternal(float f) {
        this.mPercent = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        android.graphics.drawable.Drawable drawable = this.mDragDrawable;
        if (drawable == null) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(drawable.getIntrinsicWidth(), com.up366.medialibrary.common.utils.PictureFileUtils.GB), i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.graphics.drawable.Drawable drawable = this.mDragDrawable;
        if (drawable == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.mIsInDragging = false;
            if (this.mCurrentAlpha > 0.0f && x > getWidth() - drawable.getIntrinsicWidth()) {
                if (y >= this.mDrawableDrawTop && y <= r1 + drawable.getIntrinsicHeight()) {
                    this.mDragInnerTop = y - this.mDrawableDrawTop;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.mIsInDragging = true;
                    com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback callback = this.mCallback;
                    if (callback != null) {
                        callback.onDragStarted();
                        this.mDragDrawable.setState(this.STATE_PRESSED);
                    }
                }
            }
        } else if (action == 2) {
            if (this.mIsInDragging) {
                getParent().requestDisallowInterceptTouchEvent(true);
                onDragging(drawable, y);
            }
        } else if ((action == 1 || action == 3) && this.mIsInDragging) {
            this.mIsInDragging = false;
            onDragging(drawable, y);
            com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback callback2 = this.mCallback;
            if (callback2 != null) {
                callback2.onDragEnd();
                this.mDragDrawable.setState(this.STATE_NORMAL);
            }
        }
        return this.mIsInDragging;
    }

    private void onDragging(android.graphics.drawable.Drawable drawable, float f) {
        float fConstrain = com.up366.qmui.util.QMUILangHelper.constrain(((f - getScrollBarTopMargin()) - this.mDragInnerTop) / (((getHeight() - getScrollBarBottomMargin()) - getScrollBarTopMargin()) - drawable.getIntrinsicHeight()), 0.0f, 1.0f);
        com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragToPercent(fConstrain);
        }
        setPercentInternal(fConstrain);
    }

    public void awakenScrollBar() {
        if (this.mDragDrawable == null) {
            this.mDragDrawable = androidx.core.content.ContextCompat.getDrawable(getContext(), com.qmuiteam.qmui.R.drawable.qmui_icon_scroll_bar);
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.mStartTransitionTime;
        int i = this.mTransitionDuration;
        if (j > i) {
            this.mStartTransitionTime = jCurrentTimeMillis - ((long) i);
        }
        androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062 A[RETURN] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r16) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.nestedScroll.QMUIDraggableScrollBar.onDraw(android.graphics.Canvas):void");
    }
}
