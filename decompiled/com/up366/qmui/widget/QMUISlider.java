package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISlider extends android.widget.FrameLayout implements com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
    private int mBarHeight;
    private int mBarNormalColor;
    private android.graphics.Paint mBarPaint;
    private int mBarProgressColor;
    private com.up366.qmui.widget.QMUISlider.Callback mCallback;
    private boolean mClickToChangeProgress;
    private boolean mConstraintThumbInMoving;
    private int mCurrentProgress;
    private int mDownTouchX;
    private boolean mIsMoving;
    private boolean mIsThumbTouched;
    private int mLastTouchX;
    private android.graphics.RectF mTempRect;
    private com.up366.qmui.widget.QMUISlider.IThumbView mThumbView;
    private com.up366.qmui.util.QMUIViewOffsetHelper mThumbViewOffsetHelper;
    private int mTickCount;
    private int mTouchSlop;

    public interface Callback {
        void onProgressChange(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2, boolean z);

        void onStartMoving(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2);

        void onStopMoving(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2);

        void onTouchDown(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2, boolean z);

        void onTouchUp(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2);
    }

    public static class DefaultCallback implements com.up366.qmui.widget.QMUISlider.Callback {
        @Override // com.up366.qmui.widget.QMUISlider.Callback
        public void onProgressChange(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2, boolean z) {
        }

        @Override // com.up366.qmui.widget.QMUISlider.Callback
        public void onStartMoving(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2) {
        }

        @Override // com.up366.qmui.widget.QMUISlider.Callback
        public void onStopMoving(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2) {
        }

        @Override // com.up366.qmui.widget.QMUISlider.Callback
        public void onTouchDown(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2, boolean z) {
        }

        @Override // com.up366.qmui.widget.QMUISlider.Callback
        public void onTouchUp(com.up366.qmui.widget.QMUISlider qMUISlider, int i, int i2) {
        }
    }

    public interface IThumbView {
        int getLeftRightMargin();

        void render(int i, int i2);

        void setPress(boolean z);
    }

    protected void drawTick(android.graphics.Canvas canvas, int i, int i2, int i3, int i4, float f, android.graphics.Paint paint, int i5, int i6) {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    static {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(2);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put("background", java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_slider_bar_bg_color));
        sDefaultSkinAttrs.put(com.up366.qmui.skin.QMUISkinValueBuilder.PROGRESS_COLOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_slider_bar_progress_color));
    }

    public QMUISlider(android.content.Context context) {
        this(context, null);
    }

    public QMUISlider(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUISliderStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QMUISlider(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mConstraintThumbInMoving = true;
        this.mCurrentProgress = 0;
        this.mClickToChangeProgress = false;
        this.mDownTouchX = 0;
        this.mLastTouchX = 0;
        this.mIsThumbTouched = false;
        this.mIsMoving = false;
        this.mTempRect = new android.graphics.RectF();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUISlider, i, 0);
        this.mBarHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_height, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 2));
        this.mBarNormalColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_normal_color, -1);
        this.mBarProgressColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_progress_color, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_PROGRESS_COLOR);
        this.mTickCount = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_tick_count, 100);
        this.mConstraintThumbInMoving = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_constraint_thumb_in_moving, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_thumb_size_size, com.up366.qmui.util.QMUIDisplayHelper.dp2px(getContext(), 24));
        java.lang.String string = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_thumb_style_attr);
        int identifier = string != null ? getResources().getIdentifier(string, "attr", context.getPackageName()) : 0;
        if (!typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_use_clip_children_by_developer, false)) {
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_padding_hor_for_thumb_shadow, 0);
            int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.qmuiteam.qmui.R.styleable.QMUISlider_qmui_slider_bar_padding_ver_for_thumb_shadow, 0);
            setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        }
        typedArrayObtainStyledAttributes.recycle();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mBarPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        this.mBarPaint.setAntiAlias(true);
        this.mTouchSlop = com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 2);
        setWillNotDraw(false);
        setClipToPadding(false);
        setClipChildren(false);
        com.up366.qmui.widget.QMUISlider.IThumbView iThumbViewOnCreateThumbView = onCreateThumbView(context, dimensionPixelSize, identifier);
        if (!(iThumbViewOnCreateThumbView instanceof android.view.View)) {
            throw new java.lang.IllegalArgumentException("thumbView must be a instance of View");
        }
        this.mThumbView = iThumbViewOnCreateThumbView;
        android.view.View view = (android.view.View) iThumbViewOnCreateThumbView;
        this.mThumbViewOffsetHelper = new com.up366.qmui.util.QMUIViewOffsetHelper(view);
        addView(view, onCreateThumbLayoutParams());
        iThumbViewOnCreateThumbView.render(this.mCurrentProgress, this.mTickCount);
    }

    public void setCallback(com.up366.qmui.widget.QMUISlider.Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrentProgress(int i) {
        int iConstrain;
        if (this.mIsMoving || this.mCurrentProgress == (iConstrain = com.up366.qmui.util.QMUILangHelper.constrain(i, 0, this.mTickCount))) {
            return;
        }
        safeSetCurrentProgress(iConstrain);
        com.up366.qmui.widget.QMUISlider.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onProgressChange(this, iConstrain, this.mTickCount, false);
        }
        invalidate();
    }

    public int getCurrentProgress() {
        return this.mCurrentProgress;
    }

    public void setTickCount(int i) {
        if (this.mTickCount != i) {
            this.mTickCount = i;
            invalidate();
        }
    }

    public int getTickCount() {
        return this.mTickCount;
    }

    public void setThumbSkin(com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(convertThumbToView(), qMUISkinValueBuilder);
    }

    private void safeSetCurrentProgress(int i) {
        this.mCurrentProgress = i;
        this.mThumbView.render(i, this.mTickCount);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int i3 = this.mBarHeight;
        if (measuredHeight < i3) {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(i3 + getPaddingTop() + getPaddingBottom(), com.up366.medialibrary.common.utils.PictureFileUtils.GB));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.view.View viewConvertThumbToView = convertThumbToView();
        int paddingTop = getPaddingTop();
        int measuredHeight = viewConvertThumbToView.getMeasuredHeight();
        int measuredWidth = viewConvertThumbToView.getMeasuredWidth();
        int paddingLeft = getPaddingLeft() + this.mThumbView.getLeftRightMargin();
        int paddingBottom = paddingTop + (((((i4 - i2) - paddingTop) - getPaddingBottom()) - viewConvertThumbToView.getMeasuredHeight()) / 2);
        viewConvertThumbToView.layout(paddingLeft, paddingBottom, measuredWidth + paddingLeft, measuredHeight + paddingBottom);
        this.mThumbViewOffsetHelper.onViewLayout();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int i;
        int i2;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int x = (int) motionEvent.getX();
            this.mDownTouchX = x;
            this.mLastTouchX = x;
            boolean zIsThumbTouched = isThumbTouched(motionEvent.getX(), motionEvent.getY());
            this.mIsThumbTouched = zIsThumbTouched;
            if (zIsThumbTouched) {
                this.mThumbView.setPress(true);
            }
            com.up366.qmui.widget.QMUISlider.Callback callback = this.mCallback;
            if (callback != null) {
                callback.onTouchDown(this, this.mCurrentProgress, this.mTickCount, this.mIsThumbTouched);
            }
        } else if (action == 2) {
            int x2 = (int) motionEvent.getX();
            int i3 = x2 - this.mLastTouchX;
            this.mLastTouchX = x2;
            if (!this.mIsMoving && this.mIsThumbTouched && java.lang.Math.abs(x2 - this.mDownTouchX) > this.mTouchSlop) {
                this.mIsMoving = true;
                com.up366.qmui.widget.QMUISlider.Callback callback2 = this.mCallback;
                if (callback2 != null) {
                    callback2.onStartMoving(this, this.mCurrentProgress, this.mTickCount);
                }
                i3 = i3 > 0 ? i3 - this.mTouchSlop : i3 + this.mTouchSlop;
            }
            if (this.mIsMoving) {
                com.up366.qmui.util.QMUIViewHelper.safeRequestDisallowInterceptTouchEvent(this, true);
                int maxThumbOffset = getMaxThumbOffset();
                int i4 = this.mCurrentProgress;
                if (this.mConstraintThumbInMoving) {
                    checkTouch(x2, maxThumbOffset);
                } else {
                    com.up366.qmui.util.QMUIViewOffsetHelper qMUIViewOffsetHelper = this.mThumbViewOffsetHelper;
                    qMUIViewOffsetHelper.setLeftAndRightOffset(com.up366.qmui.util.QMUILangHelper.constrain(qMUIViewOffsetHelper.getLeftAndRightOffset() + i3, 0, maxThumbOffset));
                    calculateByThumbPosition();
                }
                com.up366.qmui.widget.QMUISlider.Callback callback3 = this.mCallback;
                if (callback3 != null && i4 != (i2 = this.mCurrentProgress)) {
                    callback3.onProgressChange(this, i2, this.mTickCount, true);
                }
                invalidate();
            }
        } else if (action == 1 || action == 3) {
            this.mLastTouchX = -1;
            com.up366.qmui.util.QMUIViewHelper.safeRequestDisallowInterceptTouchEvent(this, false);
            if (this.mIsMoving) {
                this.mIsMoving = false;
                com.up366.qmui.widget.QMUISlider.Callback callback4 = this.mCallback;
                if (callback4 != null) {
                    callback4.onStopMoving(this, this.mCurrentProgress, this.mTickCount);
                }
            }
            if (this.mIsThumbTouched) {
                this.mIsThumbTouched = false;
                this.mThumbView.setPress(false);
            } else if (action == 1 && this.mClickToChangeProgress) {
                int x3 = (int) motionEvent.getX();
                if (java.lang.Math.abs(x3 - this.mDownTouchX) < this.mTouchSlop) {
                    int i5 = this.mCurrentProgress;
                    checkTouch(x3, getMaxThumbOffset());
                    invalidate();
                    com.up366.qmui.widget.QMUISlider.Callback callback5 = this.mCallback;
                    if (callback5 != null && i5 != (i = this.mCurrentProgress)) {
                        callback5.onProgressChange(this, i, this.mTickCount, true);
                    }
                }
            }
            com.up366.qmui.widget.QMUISlider.Callback callback6 = this.mCallback;
            if (callback6 != null) {
                callback6.onTouchUp(this, this.mCurrentProgress, this.mTickCount);
            }
        }
        return true;
    }

    private void checkTouch(int i, int i2) {
        float f = i2 / this.mTickCount;
        float paddingLeft = i - getPaddingLeft();
        float f2 = f / 2.0f;
        if (paddingLeft <= f2) {
            this.mThumbViewOffsetHelper.setLeftAndRightOffset(0);
            safeSetCurrentProgress(0);
        } else if (i >= (getWidth() - getPaddingRight()) - f2) {
            this.mThumbViewOffsetHelper.setLeftAndRightOffset(i2);
            safeSetCurrentProgress(this.mTickCount);
        } else {
            int width = (int) ((this.mTickCount * (paddingLeft / ((getWidth() - getPaddingLeft()) - getPaddingLeft()))) + 0.5f);
            this.mThumbViewOffsetHelper.setLeftAndRightOffset((int) (width * f));
            safeSetCurrentProgress(width);
        }
    }

    public void setClickToChangeProgress(boolean z) {
        this.mClickToChangeProgress = z;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i = this.mBarHeight;
        int i2 = paddingTop + ((height - i) / 2);
        int i3 = i + i2;
        this.mBarPaint.setColor(this.mBarNormalColor);
        float f = paddingLeft;
        float f2 = i2;
        float f3 = i3;
        this.mTempRect.set(f, f2, width, f3);
        drawRect(canvas, this.mTempRect, this.mBarHeight, this.mBarPaint, false);
        int maxThumbOffset = (int) ((getMaxThumbOffset() / this.mTickCount) * this.mCurrentProgress);
        this.mBarPaint.setColor(this.mBarProgressColor);
        android.view.View viewConvertThumbToView = convertThumbToView();
        if (viewConvertThumbToView != null && viewConvertThumbToView.getVisibility() == 0) {
            if (!this.mIsMoving) {
                this.mThumbViewOffsetHelper.setLeftAndRightOffset(maxThumbOffset);
            }
            this.mTempRect.set(f, f2, (viewConvertThumbToView.getRight() + viewConvertThumbToView.getLeft()) / 2.0f, f3);
            drawRect(canvas, this.mTempRect, this.mBarHeight, this.mBarPaint, true);
        } else {
            this.mTempRect.set(f, f2, maxThumbOffset + paddingLeft, f3);
            drawRect(canvas, this.mTempRect, this.mBarHeight, this.mBarPaint, true);
        }
        drawTick(canvas, this.mCurrentProgress, this.mTickCount, paddingLeft, width, this.mTempRect.centerY(), this.mBarPaint, this.mBarNormalColor, this.mBarProgressColor);
    }

    protected void drawRect(android.graphics.Canvas canvas, android.graphics.RectF rectF, int i, android.graphics.Paint paint, boolean z) {
        float f = i / 2;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    public void setBarHeight(int i) {
        if (this.mBarHeight != i) {
            this.mBarHeight = i;
            requestLayout();
        }
    }

    public void setBarNormalColor(int i) {
        if (this.mBarNormalColor != i) {
            this.mBarNormalColor = i;
            invalidate();
        }
    }

    public void setBarProgressColor(int i) {
        if (this.mBarProgressColor != i) {
            this.mBarProgressColor = i;
            invalidate();
        }
    }

    public void setConstraintThumbInMoving(boolean z) {
        this.mConstraintThumbInMoving = z;
    }

    private void calculateByThumbPosition() {
        int i = this.mTickCount;
        safeSetCurrentProgress(com.up366.qmui.util.QMUILangHelper.constrain((int) ((i * ((this.mThumbViewOffsetHelper.getLeftAndRightOffset() * 1.0f) / (((getWidth() - getPaddingLeft()) - getPaddingRight()) - convertThumbToView().getWidth()))) + 0.5f), 0, i));
    }

    protected com.up366.qmui.widget.QMUISlider.IThumbView onCreateThumbView(android.content.Context context, int i, int i2) {
        return new com.up366.qmui.widget.QMUISlider.DefaultThumbView(context, i, i2);
    }

    protected android.widget.FrameLayout.LayoutParams onCreateThumbLayoutParams() {
        return new android.widget.FrameLayout.LayoutParams(-2, -2);
    }

    private android.view.View convertThumbToView() {
        return (android.view.View) this.mThumbView;
    }

    private boolean isThumbTouched(float f, float f2) {
        return isThumbViewTouched(convertThumbToView(), f, f2);
    }

    protected boolean isThumbViewTouched(android.view.View view, float f, float f2) {
        return view.getVisibility() == 0 && ((float) view.getLeft()) <= f && ((float) view.getRight()) >= f && ((float) view.getTop()) <= f2 && ((float) view.getBottom()) >= f2;
    }

    private int getMaxThumbOffset() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mThumbView.getLeftRightMargin() * 2)) - convertThumbToView().getWidth();
    }

    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }

    public static class DefaultThumbView extends android.view.View implements com.up366.qmui.widget.QMUISlider.IThumbView, com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
        private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
        private final com.up366.qmui.layout.QMUILayoutHelper mLayoutHelper;
        private final int mSize;

        @Override // com.up366.qmui.widget.QMUISlider.IThumbView
        public int getLeftRightMargin() {
            return 0;
        }

        @Override // com.up366.qmui.widget.QMUISlider.IThumbView
        public void render(int i, int i2) {
        }

        @Override // com.up366.qmui.widget.QMUISlider.IThumbView
        public void setPress(boolean z) {
        }

        static {
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(2);
            sDefaultSkinAttrs = simpleArrayMap;
            simpleArrayMap.put("background", java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_slider_thumb_bg_color));
            sDefaultSkinAttrs.put(com.up366.qmui.skin.QMUISkinValueBuilder.BORDER, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_slider_thumb_border_color));
        }

        public DefaultThumbView(android.content.Context context, int i, int i2) {
            super(context, null, i2);
            this.mSize = i;
            com.up366.qmui.layout.QMUILayoutHelper qMUILayoutHelper = new com.up366.qmui.layout.QMUILayoutHelper(context, null, i2, this);
            this.mLayoutHelper = qMUILayoutHelper;
            qMUILayoutHelper.setRadius(i / 2);
            setPress(false);
        }

        @Override // android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            super.dispatchDraw(canvas);
            this.mLayoutHelper.drawDividers(canvas, getWidth(), getHeight());
            this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
        }

        public void setBorderColor(int i) {
            this.mLayoutHelper.setBorderColor(i);
            invalidate();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int i3 = this.mSize;
            setMeasuredDimension(i3, i3);
        }

        @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
        public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
            return sDefaultSkinAttrs;
        }
    }
}
