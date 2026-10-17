package com.warkiz.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class IndicatorSeekBar extends android.view.View {
    private static final int GAP_BETWEEN_SEEK_BAR_AND_BELOW_TEXT = 3;
    private static final java.lang.String INSTANCE_STATE_KEY = "isb_instance_state";
    private boolean hasMeasured;
    private float lastProgress;
    private android.content.Context mContext;
    private float mFaultTolerance;
    private boolean mFirstDraw;
    private com.warkiz.widget.Indicator mIndicator;
    private boolean mIsTouching;
    private com.warkiz.widget.IndicatorSeekBar.OnSeekBarChangeListener mListener;
    private int mMeasuredWidth;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private android.graphics.Rect mRect;
    private float mSeekBlockLength;
    private float mSeekEnd;
    private float mSeekLength;
    private float mSeekStart;
    private android.graphics.Paint mStockPaint;
    private int mTextHeight;
    private java.util.ArrayList<java.lang.String> mTextList;
    private java.util.List<java.lang.Float> mTextLocationList;
    private android.graphics.Paint mTextPaint;
    private android.graphics.Bitmap mThumbDraw;
    private float mThumbRadius;
    private android.graphics.Bitmap mTickDraw;
    private float mTickRadius;
    private float mTouchX;
    private float mTrackY;
    private com.warkiz.widget.BuilderParams p;

    public interface OnSeekBarChangeListener {
        void onProgressChanged(com.warkiz.widget.IndicatorSeekBar indicatorSeekBar, int i, float f, boolean z);

        void onSectionChanged(com.warkiz.widget.IndicatorSeekBar indicatorSeekBar, int i, java.lang.String str, boolean z);

        void onStartTrackingTouch(com.warkiz.widget.IndicatorSeekBar indicatorSeekBar, int i);

        void onStopTrackingTouch(com.warkiz.widget.IndicatorSeekBar indicatorSeekBar);
    }

    public IndicatorSeekBar(android.content.Context context) {
        this(context, null, 0);
    }

    public IndicatorSeekBar(com.warkiz.widget.IndicatorSeekBar.Builder builder) {
        super(builder.getContext(), null, 0);
        this.mTextLocationList = new java.util.ArrayList();
        this.mTextList = new java.util.ArrayList<>();
        this.mFirstDraw = true;
        this.mFaultTolerance = -1.0f;
        this.mContext = builder.getContext();
        this.p = builder.p;
        initData();
    }

    public IndicatorSeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorSeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextLocationList = new java.util.ArrayList();
        this.mTextList = new java.util.ArrayList<>();
        this.mFirstDraw = true;
        this.mFaultTolerance = -1.0f;
        this.mContext = context;
        initAttrs(context, attributeSet);
        initData();
    }

    private void initAttrs(android.content.Context context, android.util.AttributeSet attributeSet) {
        this.p = new com.warkiz.widget.BuilderParams(context);
        if (attributeSet == null) {
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.warkiz.widget.R.styleable.IndicatorSeekBar);
        this.p.mSeekBarType = typedArrayObtainStyledAttributes.getInt(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_seek_bar_type, this.p.mSeekBarType);
        this.p.mMax = typedArrayObtainStyledAttributes.getFloat(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_max, this.p.mMax);
        this.p.mMin = typedArrayObtainStyledAttributes.getFloat(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_min, this.p.mMin);
        this.p.mProgress = typedArrayObtainStyledAttributes.getFloat(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_progress, this.p.mProgress);
        this.p.mClearPadding = typedArrayObtainStyledAttributes.getBoolean(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_clear_default_padding, this.p.mClearPadding);
        this.p.mIsFloatProgress = typedArrayObtainStyledAttributes.getBoolean(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_progress_value_float, this.p.mIsFloatProgress);
        this.p.mBackgroundTrackSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_track_background_bar_size, this.p.mBackgroundTrackSize);
        this.p.mProgressTrackSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_track_progress_bar_size, this.p.mProgressTrackSize);
        this.p.mBackgroundTrackColor = typedArrayObtainStyledAttributes.getColor(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_track_background_bar_color, this.p.mBackgroundTrackColor);
        this.p.mProgressTrackColor = typedArrayObtainStyledAttributes.getColor(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_track_progress_bar_color, this.p.mProgressTrackColor);
        this.p.mTrackRoundedCorners = typedArrayObtainStyledAttributes.getBoolean(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_track_rounded_corners, this.p.mTrackRoundedCorners);
        this.p.mThumbColor = typedArrayObtainStyledAttributes.getColor(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_thumb_color, this.p.mThumbColor);
        this.p.mThumbSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_thumb_width, this.p.mThumbSize);
        this.p.mThumbProgressStay = typedArrayObtainStyledAttributes.getBoolean(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_thumb_progress_stay, this.p.mThumbProgressStay);
        this.p.mThumbDrawable = typedArrayObtainStyledAttributes.getDrawable(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_thumb_drawable);
        this.p.mIndicatorType = typedArrayObtainStyledAttributes.getInt(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_indicator_type, this.p.mIndicatorType);
        this.p.mIndicatorColor = typedArrayObtainStyledAttributes.getColor(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_indicator_color, this.p.mIndicatorColor);
        this.p.mIndicatorTextColor = typedArrayObtainStyledAttributes.getColor(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_indicator_text_color, this.p.mIndicatorTextColor);
        this.p.mShowIndicator = typedArrayObtainStyledAttributes.getBoolean(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_show_indicator, this.p.mShowIndicator);
        this.p.mIndicatorTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_indicator_text_size, this.p.mIndicatorTextSize);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_indicator_custom_layout, 0);
        if (resourceId > 0) {
            this.p.mIndicatorCustomView = android.view.View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_indicator_custom_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.p.mIndicatorCustomTopContentView = android.view.View.inflate(this.mContext, resourceId2, null);
        }
        this.p.mTickDrawable = typedArrayObtainStyledAttributes.getDrawable(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_tick_drawable);
        this.p.mTickNum = typedArrayObtainStyledAttributes.getInt(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_tick_num, this.p.mTickNum);
        this.p.mTickColor = typedArrayObtainStyledAttributes.getColor(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_tick_color, this.p.mTickColor);
        this.p.mTickType = typedArrayObtainStyledAttributes.getInt(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_tick_type, this.p.mTickType);
        this.p.mTickHideBothEnds = typedArrayObtainStyledAttributes.getBoolean(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_tick_both_end_hide, this.p.mTickHideBothEnds);
        this.p.mTickOnThumbLeftHide = typedArrayObtainStyledAttributes.getBoolean(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_tick_on_thumb_left_hide, this.p.mTickOnThumbLeftHide);
        this.p.mTickSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_tick_size, this.p.mTickSize);
        this.p.mTextArray = typedArrayObtainStyledAttributes.getTextArray(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_text_array);
        this.p.mLeftEndText = typedArrayObtainStyledAttributes.getString(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_text_left_end);
        this.p.mRightEndText = typedArrayObtainStyledAttributes.getString(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_text_right_end);
        this.p.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_text_size, this.p.mTextSize);
        this.p.mTextColor = typedArrayObtainStyledAttributes.getColor(com.warkiz.widget.R.styleable.IndicatorSeekBar_isb_text_color, this.p.mTextColor);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initData() {
        if (this.p.mMax < this.p.mMin) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mMax = builderParams.mMin;
        }
        if (this.p.mProgress < this.p.mMin) {
            com.warkiz.widget.BuilderParams builderParams2 = this.p;
            builderParams2.mProgress = builderParams2.mMin;
        }
        if (this.p.mProgress > this.p.mMax) {
            com.warkiz.widget.BuilderParams builderParams3 = this.p;
            builderParams3.mProgress = builderParams3.mMax;
        }
        if (this.p.mBackgroundTrackSize > this.p.mProgressTrackSize) {
            com.warkiz.widget.BuilderParams builderParams4 = this.p;
            builderParams4.mBackgroundTrackSize = builderParams4.mProgressTrackSize;
        }
        if ((this.p.mThumbSize * 2) / 3.0f < this.p.mProgressTrackSize) {
            this.p.mThumbSize = java.lang.Math.round((r0.mProgressTrackSize * 3) / 2.0f);
        }
        if (this.p.mTickNum < 0) {
            this.p.mTickNum = 0;
        }
        if (this.p.mTickNum > 100) {
            this.p.mTickNum = 100;
        }
        if (this.p.mLeftEndText == null) {
            if (this.p.mIsFloatProgress) {
                this.p.mLeftEndText = this.p.mMin + "";
            } else {
                this.p.mLeftEndText = java.lang.Math.round(this.p.mMin) + "";
            }
        }
        if (this.p.mRightEndText == null) {
            if (this.p.mIsFloatProgress) {
                this.p.mRightEndText = this.p.mMax + "";
            } else {
                this.p.mRightEndText = java.lang.Math.round(this.p.mMax) + "";
            }
        }
        if (this.p.mTickDrawable != null) {
            this.p.mTickType = 1;
        }
        this.mThumbRadius = this.p.mThumbSize / 2.0f;
        this.mTickRadius = this.p.mTickSize / 2.0f;
        initStrokePaint();
        if (this.mThumbRadius < this.p.mProgressTrackSize) {
            this.mThumbRadius = this.p.mProgressTrackSize;
        }
        initDefaultPadding();
        if (this.p.mShowIndicator) {
            this.mIndicator = new com.warkiz.widget.Indicator(this.mContext, this, this.p);
        }
        if (this.mTickRadius > (this.mThumbRadius * 2.0f) / 3.0f) {
            this.mTickRadius = (int) ((r8 * 2.0f) / 3.0f);
        }
        if (noMarks()) {
            if (this.p.mMax - this.p.mMin > 100.0f) {
                com.warkiz.widget.BuilderParams builderParams5 = this.p;
                builderParams5.mTickNum = java.lang.Math.round(builderParams5.mMax - this.p.mMin);
            } else {
                this.p.mTickNum = 100;
            }
            if (this.p.mIsFloatProgress) {
                this.p.mTickNum *= 10;
            }
        } else {
            com.warkiz.widget.BuilderParams builderParams6 = this.p;
            builderParams6.mTickNum = builderParams6.mTickNum >= 2 ? this.p.mTickNum - 1 : 2;
        }
        if (needDrawText()) {
            if (this.mTextPaint == null) {
                initTextPaint();
            }
            this.mTextPaint.getTextBounds("jf1", 0, 3, this.mRect);
            this.mTextHeight += this.mRect.height() + com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 6.0f);
        }
        this.lastProgress = this.p.mProgress;
    }

    private boolean noMarks() {
        return this.p.mSeekBarType == 0 || this.p.mSeekBarType == 1;
    }

    private void initEndTexts() {
        if (this.mTextList.size() == 0) {
            if (this.p.mLeftEndText != null) {
                this.mTextList.add(this.p.mLeftEndText);
                this.mTextLocationList.add(java.lang.Float.valueOf(this.mPaddingLeft));
            }
            if (this.p.mRightEndText != null) {
                this.mTextList.add(this.p.mRightEndText);
                this.mTextLocationList.add(java.lang.Float.valueOf(this.mMeasuredWidth - this.mPaddingRight));
                return;
            }
            return;
        }
        if (this.mTextList.size() == 1) {
            if (this.p.mLeftEndText != null) {
                this.mTextList.set(0, this.p.mLeftEndText);
            }
            if (this.p.mRightEndText != null) {
                this.mTextList.add(this.p.mRightEndText);
                this.mTextLocationList.add(java.lang.Float.valueOf(this.mMeasuredWidth - this.mPaddingRight));
                return;
            }
            return;
        }
        if (this.p.mLeftEndText != null) {
            this.mTextList.set(0, this.p.mLeftEndText);
        }
        if (this.p.mLeftEndText != null) {
            java.util.ArrayList<java.lang.String> arrayList = this.mTextList;
            arrayList.set(arrayList.size() - 1, this.p.mRightEndText);
        }
    }

    private void initDefaultPadding() {
        if (this.mPaddingLeft == 0 && this.mPaddingRight == 0 && !this.p.mClearPadding) {
            int iDp2px = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 16.0f);
            setPadding(iDp2px, getPaddingTop(), iDp2px, getPaddingBottom());
        }
    }

    private void initStrokePaint() {
        this.mStockPaint = new android.graphics.Paint();
        if (this.p.mTrackRoundedCorners) {
            this.mStockPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        }
        this.mStockPaint.setAntiAlias(true);
        if (this.p.mBackgroundTrackSize > this.p.mProgressTrackSize) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mProgressTrackSize = builderParams.mBackgroundTrackSize;
        }
    }

    private void initTextPaint() {
        if (needDrawText()) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.mTextPaint = paint;
            paint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.p.mTextSize);
            this.mTextPaint.setColor(this.p.mTextColor);
            this.mRect = new android.graphics.Rect();
        }
    }

    private boolean needDrawText() {
        return this.p.mSeekBarType == 1 || this.p.mSeekBarType == 3 || this.p.mSeekBarType == 4 || this.p.mThumbProgressStay;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(android.view.View.MeasureSpec.getSize(i), ((int) ((this.mThumbRadius * 2.0f) + 0.6f + getPaddingTop() + getPaddingBottom())) + this.mTextHeight);
        initSeekBarInfo();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        this.mStockPaint.setColor(this.p.mProgressTrackColor);
        if (this.mFirstDraw) {
            calculateTouchX((((this.p.mProgress - this.p.mMin) * this.mSeekLength) / (this.p.mMax - this.p.mMin)) + this.mPaddingLeft);
            this.mFirstDraw = false;
        }
        float thumbX = getThumbX();
        this.mStockPaint.setStrokeWidth(this.p.mProgressTrackSize);
        float f = this.mSeekStart;
        float f2 = this.mTrackY;
        canvas.drawLine(f, f2, thumbX, f2, this.mStockPaint);
        this.mStockPaint.setStrokeWidth(this.p.mBackgroundTrackSize);
        this.mStockPaint.setColor(this.p.mBackgroundTrackColor);
        float f3 = this.mTrackY;
        canvas.drawLine(thumbX, f3, this.mSeekEnd, f3, this.mStockPaint);
        drawTicks(canvas, thumbX);
        drawText(canvas);
        drawThumbText(canvas, thumbX);
        drawThumb(canvas, thumbX);
    }

    private void drawThumb(android.graphics.Canvas canvas, float f) {
        this.mStockPaint.setColor(this.p.mThumbColor);
        if (this.p.mThumbDrawable != null) {
            if (this.mThumbDraw == null) {
                this.mThumbDraw = getBitmapDraw(this.p.mThumbDrawable);
            }
            canvas.drawBitmap(this.mThumbDraw, f - (r0.getWidth() / 2.0f), this.mTrackY - (this.mThumbDraw.getHeight() / 2.0f), this.mStockPaint);
            return;
        }
        canvas.drawCircle(f + (this.p.mBackgroundTrackSize / 2.0f), this.mTrackY, this.mIsTouching ? this.mThumbRadius : (this.mThumbRadius * 2.0f) / 3.0f, this.mStockPaint);
    }

    private void drawThumbText(android.graphics.Canvas canvas, float f) {
        if ((this.p.mSeekBarType == 0 || this.p.mSeekBarType == 2) && this.p.mThumbProgressStay) {
            canvas.drawText(getProgressString(this.p.mProgress), f + (this.p.mBackgroundTrackSize / 2.0f), this.mPaddingTop + (this.mThumbRadius * 2.0f) + this.mRect.height() + com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 2.0f), this.mTextPaint);
        }
    }

    private void initSeekBarInfo() {
        this.mMeasuredWidth = getMeasuredWidth();
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        float f = (this.mMeasuredWidth - this.mPaddingLeft) - this.mPaddingRight;
        this.mSeekLength = f;
        this.mSeekBlockLength = f / this.p.mTickNum;
        this.mTrackY = this.mPaddingTop + this.mThumbRadius;
        this.mSeekStart = this.p.mTrackRoundedCorners ? this.mPaddingLeft + (this.p.mBackgroundTrackSize / 2.0f) : this.mPaddingLeft;
        this.mSeekEnd = (this.mMeasuredWidth - this.mPaddingRight) - (this.p.mBackgroundTrackSize / 2.0f);
        if (this.hasMeasured) {
            return;
        }
        initLocationListData();
        this.hasMeasured = true;
    }

    private void drawTicks(android.graphics.Canvas canvas, float f) {
        int i;
        if (this.p.mSeekBarType == 0 || this.p.mSeekBarType == 1 || this.p.mTickType == 0 || this.mTextLocationList.size() == 0) {
            return;
        }
        this.mStockPaint.setColor(this.p.mTickColor);
        for (int i2 = 0; i2 < this.mTextLocationList.size(); i2++) {
            float fFloatValue = this.mTextLocationList.get(i2).floatValue();
            if (getThumbPosOnTick() != i2 && ((!this.p.mTickOnThumbLeftHide || f < fFloatValue) && (!this.p.mTickHideBothEnds || (i2 != 0 && i2 != this.mTextLocationList.size() - 1)))) {
                int iDp2px = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 1.0f);
                if (this.p.mTickDrawable != null) {
                    if (this.mTickDraw == null) {
                        this.mTickDraw = getBitmapDraw(this.p.mTickDrawable);
                    }
                    if (this.p.mTickType == 1) {
                        canvas.drawBitmap(this.mTickDraw, (fFloatValue - (r4.getWidth() / 2.0f)) + iDp2px, this.mTrackY - (this.mTickDraw.getHeight() / 2.0f), this.mStockPaint);
                    } else {
                        canvas.drawBitmap(this.mTickDraw, fFloatValue - (r3.getWidth() / 2.0f), this.mTrackY - (this.mTickDraw.getHeight() / 2.0f), this.mStockPaint);
                    }
                } else if (this.p.mTickType == 2) {
                    canvas.drawCircle(fFloatValue, this.mTrackY, this.mTickRadius, this.mStockPaint);
                } else if (this.p.mTickType == 1) {
                    if (f >= fFloatValue) {
                        i = this.p.mProgressTrackSize;
                    } else {
                        i = this.p.mBackgroundTrackSize;
                    }
                    float f2 = iDp2px;
                    float f3 = this.mTrackY;
                    float f4 = i / 2.0f;
                    canvas.drawRect(fFloatValue - f2, f3 - f4, fFloatValue + f2, f3 + f4 + 0.5f, this.mStockPaint);
                }
            }
        }
    }

    private android.graphics.Bitmap getBitmapDraw(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int iDp2px = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 14.0f);
        if (intrinsicWidth > iDp2px) {
            intrinsicWidth = iDp2px;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= iDp2px) {
            iDp2px = intrinsicHeight;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, iDp2px, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void drawText(android.graphics.Canvas canvas) {
        if (this.p.mSeekBarType == 0 || this.p.mSeekBarType == 2 || this.mTextList.size() == 0) {
            return;
        }
        this.mStockPaint.setColor(this.p.mTickColor);
        java.lang.String allText = getAllText();
        this.mTextPaint.getTextBounds(allText, 0, allText.length(), this.mRect);
        int iHeight = this.mRect.height();
        int iDp2px = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 3.0f);
        for (int i = 0; i < this.mTextList.size(); i++) {
            java.lang.String stringText = getStringText(i);
            this.mTextPaint.getTextBounds(stringText, 0, stringText.length(), this.mRect);
            if (i == 0) {
                canvas.drawText(stringText, this.mTextLocationList.get(i).floatValue() + (this.mRect.width() / 2.0f), this.mPaddingTop + (this.mThumbRadius * 2.0f) + iHeight + iDp2px, this.mTextPaint);
            } else if (i == this.mTextList.size() - 1) {
                canvas.drawText(stringText, this.mTextLocationList.get(i).floatValue() - (this.mRect.width() / 2.0f), this.mPaddingTop + (this.mThumbRadius * 2.0f) + iHeight + iDp2px, this.mTextPaint);
            } else if (this.p.mSeekBarType != 1 && this.p.mSeekBarType != 4) {
                canvas.drawText(stringText, this.mTextLocationList.get(i).floatValue(), this.mPaddingTop + (this.mThumbRadius * 2.0f) + iHeight + iDp2px, this.mTextPaint);
            }
        }
    }

    private java.lang.String getStringText(int i) {
        if (this.p.mTextArray != null) {
            if (i < this.p.mTextArray.length) {
                return ((java.lang.Object) this.p.mTextArray[i]) + "";
            }
            return " ";
        }
        return this.mTextList.get(i) + "";
    }

    private java.lang.String getAllText() {
        java.lang.String str = "9f";
        if (this.p.mTextArray != null) {
            for (java.lang.CharSequence charSequence : this.p.mTextArray) {
                str = str + ((java.lang.Object) charSequence);
            }
        }
        return str;
    }

    private void initLocationListData() {
        if (this.p.mSeekBarType == 0) {
            return;
        }
        if (this.p.mSeekBarType == 1) {
            initEndTexts();
            return;
        }
        if (this.p.mTickNum > 1) {
            this.mTextLocationList.clear();
            this.mTextList.clear();
            for (int i = 0; i < this.p.mTickNum + 1; i++) {
                float f = this.mSeekBlockLength * i;
                this.mTextLocationList.add(java.lang.Float.valueOf(this.mPaddingLeft + f));
                this.mTextList.add(getProgressString(this.p.mMin + (((this.p.mMax - this.p.mMin) * f) / this.mSeekLength)));
            }
            initEndTexts();
        }
    }

    private float getThumbX() {
        float paddingLeft;
        int i;
        float f = this.mTouchX - (this.p.mBackgroundTrackSize / 2.0f);
        if (f <= this.mSeekStart) {
            if (f <= this.mPaddingLeft) {
                paddingLeft = getPaddingLeft();
                i = this.p.mBackgroundTrackSize;
            } else {
                return f + (this.p.mBackgroundTrackSize / 2.0f);
            }
        } else {
            if (f < (this.mMeasuredWidth - this.mPaddingRight) - (this.p.mBackgroundTrackSize / 2.0f)) {
                return f;
            }
            paddingLeft = this.mMeasuredWidth - this.mPaddingRight;
            i = this.p.mBackgroundTrackSize;
        }
        return paddingLeft - (i / 2.0f);
    }

    public int getThumbPosOnTick() {
        if (this.p.mSeekBarType > 1) {
            return java.lang.Math.round(this.mTouchX / this.mSeekBlockLength);
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L30
            if (r0 == r2) goto L18
            r3 = 2
            if (r0 == r3) goto L11
            r5 = 3
            if (r0 == r5) goto L18
            goto L45
        L11:
            r4.setListener()
            r4.refreshSeekBar(r5, r2)
            goto L45
        L18:
            com.warkiz.widget.IndicatorSeekBar$OnSeekBarChangeListener r5 = r4.mListener
            if (r5 == 0) goto L1f
            r5.onStopTrackingTouch(r4)
        L1f:
            r4.mIsTouching = r1
            r4.invalidate()
            com.warkiz.widget.BuilderParams r5 = r4.p
            boolean r5 = r5.mShowIndicator
            if (r5 == 0) goto L45
            com.warkiz.widget.Indicator r5 = r4.mIndicator
            r5.hideIndicator()
            goto L45
        L30:
            boolean r0 = r4.isTouchSeekBar(r5)
            if (r0 == 0) goto L45
            com.warkiz.widget.IndicatorSeekBar$OnSeekBarChangeListener r0 = r4.mListener
            if (r0 == 0) goto L41
            int r3 = r4.getThumbPosOnTick()
            r0.onStartTrackingTouch(r4, r3)
        L41:
            r4.refreshSeekBar(r5, r1)
            return r2
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.widget.IndicatorSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void setListener() {
        com.warkiz.widget.IndicatorSeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.mListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(this, getProgress(), getProgressFloat(), true);
            if (this.p.mSeekBarType > 1) {
                int thumbPosOnTick = getThumbPosOnTick();
                if (this.p.mTextArray != null && thumbPosOnTick < this.p.mTextArray.length) {
                    this.mListener.onSectionChanged(this, thumbPosOnTick, ((java.lang.Object) this.p.mTextArray[thumbPosOnTick]) + "", true);
                    return;
                }
                this.mListener.onSectionChanged(this, thumbPosOnTick, "", true);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(INSTANCE_STATE_KEY, super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.p.mProgress);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof android.os.Bundle) {
            android.os.Bundle bundle = (android.os.Bundle) parcelable;
            this.p.mProgress = bundle.getFloat("isb_progress");
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE_KEY));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        com.warkiz.widget.Indicator indicator;
        super.setVisibility(i);
        if ((8 == i || 4 == i) && (indicator = this.mIndicator) != null && indicator.isShowing()) {
            this.mIndicator.hideIndicator();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.warkiz.widget.Indicator indicator = this.mIndicator;
        if (indicator == null || !indicator.isShowing()) {
            return;
        }
        this.mIndicator.hideIndicator();
    }

    private void refreshSeekBar(android.view.MotionEvent motionEvent, int i) {
        calculateTouchX(adjustTouchX(motionEvent));
        calculateProgress();
        this.mIsTouching = true;
        if (i == 0) {
            if (this.lastProgress != this.p.mProgress) {
                setListener();
            }
            invalidate();
            if (this.p.mShowIndicator) {
                this.mIndicator.showIndicator(this.mTouchX, this.p.mSeekBarType, getThumbPosOnTick());
                return;
            }
            return;
        }
        if (this.lastProgress != this.p.mProgress) {
            setListener();
            invalidate();
            if (this.p.mShowIndicator) {
                this.mIndicator.update(this.mTouchX, this.p.mSeekBarType, getThumbPosOnTick());
            }
        }
    }

    private float adjustTouchX(android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int i = this.mPaddingLeft;
        if (x >= i) {
            float x2 = motionEvent.getX();
            int i2 = this.mMeasuredWidth;
            int i3 = this.mPaddingRight;
            if (x2 <= i2 - i3) {
                return motionEvent.getX();
            }
            i = i2 - i3;
        }
        return i;
    }

    private void calculateProgress() {
        this.lastProgress = this.p.mProgress;
        com.warkiz.widget.BuilderParams builderParams = this.p;
        builderParams.mProgress = builderParams.mMin + (((this.p.mMax - this.p.mMin) * (this.mTouchX - this.mPaddingLeft)) / this.mSeekLength);
    }

    private void calculateTouchX(float f) {
        this.mTouchX = (this.mSeekBlockLength * java.lang.Math.round((f - this.mPaddingLeft) / this.mSeekBlockLength)) + this.mPaddingLeft;
    }

    private boolean isTouchSeekBar(android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.mFaultTolerance == -1.0f) {
            this.mFaultTolerance = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 5.0f);
        }
        float f = this.mPaddingLeft;
        float f2 = this.mFaultTolerance;
        boolean z = x >= f - (f2 * 2.0f) && x <= ((float) (this.mMeasuredWidth - this.mPaddingRight)) + (2.0f * f2);
        float f3 = this.mTrackY;
        float f4 = this.mThumbRadius;
        return z && ((y > ((f3 - f4) - f2) ? 1 : (y == ((f3 - f4) - f2) ? 0 : -1)) >= 0 && (y > ((f3 + f4) + f2) ? 1 : (y == ((f3 + f4) + f2) ? 0 : -1)) <= 0);
    }

    private float getProgressFloat(int i) {
        return java.math.BigDecimal.valueOf(this.p.mProgress).setScale(i, 4).floatValue();
    }

    private float getProgressFloat(int i, float f) {
        return java.math.BigDecimal.valueOf(f).setScale(i, 4).floatValue();
    }

    private int getProgress(float f) {
        return java.lang.Math.round(f);
    }

    private java.lang.String getProgressString(float f) {
        if (this.p.mIsFloatProgress) {
            return java.lang.String.valueOf(getProgressFloat(1, f));
        }
        return java.lang.String.valueOf(getProgress(f));
    }

    public int getProgress() {
        return java.lang.Math.round(this.p.mProgress);
    }

    public void setProgress(float f) {
        if (f < this.p.mMin) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mProgress = builderParams.mMin;
        } else if (f > this.p.mMax) {
            com.warkiz.widget.BuilderParams builderParams2 = this.p;
            builderParams2.mProgress = builderParams2.mMax;
        } else {
            this.p.mProgress = f;
        }
        com.warkiz.widget.IndicatorSeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.mListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(this, getProgress(), getProgressFloat(), false);
            if (this.p.mSeekBarType > 1) {
                int thumbPosOnTick = getThumbPosOnTick();
                if (this.p.mTextArray != null && thumbPosOnTick < this.p.mTextArray.length - 1) {
                    this.mListener.onSectionChanged(this, thumbPosOnTick, ((java.lang.Object) this.p.mTextArray[thumbPosOnTick]) + "", false);
                } else {
                    this.mListener.onSectionChanged(this, thumbPosOnTick, "", true);
                }
            }
        }
        calculateTouchX((((this.p.mProgress - this.p.mMin) * this.mSeekLength) / (this.p.mMax - this.p.mMin)) + this.mPaddingLeft);
        postInvalidate();
    }

    public float getProgressFloat() {
        return getProgressFloat(1);
    }

    public java.lang.String getProgressString() {
        return getProgressString(this.p.mProgress);
    }

    public float getMax() {
        return this.p.mMax;
    }

    public float getMin() {
        return this.p.mMin;
    }

    public com.warkiz.widget.Indicator getIndicator() {
        return this.mIndicator;
    }

    public void setCustomIndicator(android.view.View view) {
        this.mIndicator.setCustomIndicator(view);
    }

    public void setCustomIndicator(int i) {
        this.mIndicator.setCustomIndicator(android.view.View.inflate(this.mContext, i, null));
    }

    public void setCustomIndicator(android.view.View view, int i) {
        android.view.View viewFindViewById = view.findViewById(i);
        if (viewFindViewById == null) {
            throw new java.lang.IllegalArgumentException(" can not find the textView in topContentView by progressTextViewId. ");
        }
        if (!(viewFindViewById instanceof android.widget.TextView)) {
            throw new java.lang.ClassCastException(" the view identified by progressTextViewId can not be cast to TextView. ");
        }
        this.mIndicator.setProgressTextView((android.widget.TextView) viewFindViewById);
        this.mIndicator.setCustomIndicator(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apply(com.warkiz.widget.BuilderParams builderParams) {
        if (builderParams == null) {
            throw new java.lang.NullPointerException(" BuilderParams can not be a null value. ");
        }
        this.p = builderParams;
        initData();
        requestLayout();
    }

    public java.lang.CharSequence[] getTextArray() {
        return this.p.mTextArray;
    }

    public void setTextArray(int i) {
        this.p.mTextArray = this.mContext.getResources().getStringArray(i);
        invalidate();
    }

    public void setTextArray(java.lang.CharSequence[] charSequenceArr) {
        this.p.mTextArray = charSequenceArr;
        invalidate();
    }

    public void setOnSeekChangeListener(com.warkiz.widget.IndicatorSeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mListener = onSeekBarChangeListener;
    }

    public static class Builder {
        com.warkiz.widget.BuilderParams p;

        public Builder(android.content.Context context) {
            this.p = new com.warkiz.widget.BuilderParams(context);
        }

        public com.warkiz.widget.IndicatorSeekBar build() {
            com.warkiz.widget.IndicatorSeekBar indicatorSeekBar = new com.warkiz.widget.IndicatorSeekBar(this.p.mContext);
            indicatorSeekBar.apply(this.p);
            return indicatorSeekBar;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setProgress(float f) {
            this.p.mProgress = f;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setMax(float f) {
            this.p.mMax = f;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setMin(float f) {
            this.p.mMin = f;
            return this;
        }

        public android.content.Context getContext() {
            return this.p.mContext;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder clearPadding(boolean z) {
            this.p.mClearPadding = z;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder showIndicator(boolean z) {
            this.p.mShowIndicator = z;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setBackgroundTrackSize(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mBackgroundTrackSize = com.warkiz.widget.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTextSize(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mTextSize = com.warkiz.widget.IndicatorUtils.sp2px(builderParams.mContext, i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setBackgroundTrackColor(int i) {
            this.p.mBackgroundTrackColor = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setProgressTrackColor(int i) {
            this.p.mProgressTrackColor = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setThumbColor(int i) {
            this.p.mThumbColor = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTickNum(int i) {
            this.p.mTickNum = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTickSize(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mTickSize = com.warkiz.widget.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTickType(int i) {
            this.p.mTickType = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTickColor(int i) {
            this.p.mTickColor = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setSeekBarType(int i) {
            this.p.mSeekBarType = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder hideBothEndsTicks(boolean z) {
            this.p.mTickHideBothEnds = z;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder hideTickOnThumbLeft(boolean z) {
            this.p.mTickOnThumbLeftHide = z;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder isRoundedTrackCorner(boolean z) {
            this.p.mTrackRoundedCorners = z;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setProgressTrackSize(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mProgressTrackSize = com.warkiz.widget.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTextArray(java.lang.CharSequence[] charSequenceArr) {
            this.p.mTextArray = charSequenceArr;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTextArray(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mTextArray = builderParams.mContext.getResources().getStringArray(i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setThumbWidth(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mThumbSize = com.warkiz.widget.IndicatorUtils.dp2px(builderParams.mContext, i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorColor(int i) {
            this.p.mIndicatorColor = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorCustomLayout(int i) {
            this.p.mIndicatorType = 2;
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mIndicatorCustomView = android.view.View.inflate(builderParams.mContext, i, null);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorCustomView(android.view.View view) {
            this.p.mIndicatorType = 2;
            this.p.mIndicatorCustomView = view;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorCustomTopContentLayout(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mIndicatorCustomTopContentView = android.view.View.inflate(builderParams.mContext, i, null);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorCustomTopContentView(android.view.View view) {
            this.p.mIndicatorCustomTopContentView = view;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorType(int i) {
            this.p.mIndicatorType = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder thumbProgressStay(boolean z) {
            this.p.mThumbProgressStay = z;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder isFloatProgress(boolean z) {
            this.p.mIsFloatProgress = z;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setLeftEndText(java.lang.String str) {
            this.p.mLeftEndText = str;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setRightEndText(java.lang.String str) {
            this.p.mRightEndText = str;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTickDrawableId(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mTickDrawable = builderParams.mContext.getResources().getDrawable(i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTickDrawable(android.graphics.drawable.Drawable drawable) {
            this.p.mTickDrawable = drawable;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setThumbDrawable(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mThumbDrawable = builderParams.mContext.getResources().getDrawable(i);
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setThumbDrawable(android.graphics.drawable.Drawable drawable) {
            this.p.mThumbDrawable = drawable;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setTextColor(int i) {
            this.p.mTextColor = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorTextColor(int i) {
            this.p.mIndicatorTextColor = i;
            return this;
        }

        public com.warkiz.widget.IndicatorSeekBar.Builder setIndicatorTextSize(int i) {
            com.warkiz.widget.BuilderParams builderParams = this.p;
            builderParams.mIndicatorTextSize = com.warkiz.widget.IndicatorUtils.sp2px(builderParams.mContext, i);
            return this;
        }
    }
}
