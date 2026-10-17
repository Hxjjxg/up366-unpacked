package com.up366.view.wheelview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class WheelView extends android.view.View {
    private static final float SCALE_CONTENT = 0.8f;
    private static final java.lang.String[] TIME_NUM = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    private static final int VELOCITY_FLING = 5;
    private float CENTER_CONTENT_OFFSET;
    private com.up366.view.wheelview.adapter.WheelAdapter adapter;
    private float centerY;
    private android.content.Context context;
    private int dividerColor;
    private com.up366.view.wheelview.WheelView.DividerType dividerType;
    private int dividerWidth;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private android.view.GestureDetector gestureDetector;
    private android.os.Handler handler;
    private int initPosition;
    private boolean isAlphaGradient;
    private boolean isCenterLabel;
    private boolean isLoop;
    private boolean isOptions;
    private float itemHeight;
    private int itemsVisible;
    private java.lang.String label;
    private float lineSpacingMultiplier;
    private java.util.concurrent.ScheduledExecutorService mExecutor;
    private java.util.concurrent.ScheduledFuture<?> mFuture;
    private int mGravity;
    private int mOffset;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    private com.up366.view.wheelview.listener.OnItemSelectedListener onItemSelectedListener;
    private android.graphics.Paint paintCenterText;
    private android.graphics.Paint paintIndicator;
    private android.graphics.Paint paintOuterText;
    private int preCurrentIndex;
    private float previousY;
    private int radius;
    private float secondLineY;
    private int selectedItem;
    private long startTime;
    private int textColorCenter;
    private int textColorOut;
    private int textLiftPadding;
    private int textRightPadding;
    private int textSize;
    private int textXOffset;
    private float totalScrollY;
    private android.graphics.Typeface typeface;
    private int widthMeasureSpec;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum DividerType {
        FILL,
        WRAP,
        CIRCLE
    }

    public WheelView(android.content.Context context) {
        this(context, null);
    }

    public WheelView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
        this.typeface = android.graphics.Typeface.MONOSPACE;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 9;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.isAlphaGradient = false;
        this.textSize = getResources().getDimensionPixelSize(com.up366.view.R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.CENTER_CONTENT_OFFSET = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.CENTER_CONTENT_OFFSET = 4.0f;
        } else if (2.0f <= f && f < 3.0f) {
            this.CENTER_CONTENT_OFFSET = 6.0f;
        } else if (f >= 3.0f) {
            this.CENTER_CONTENT_OFFSET = f * 2.5f;
        }
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.view.R.styleable.WheelView, 0, 0);
            this.mGravity = typedArrayObtainStyledAttributes.getInt(com.up366.view.R.styleable.WheelView_gravity, 17);
            this.textColorOut = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.WheelView_textColorOut, -5723992);
            this.textColorCenter = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.WheelView_textColorCenter, -14013910);
            this.dividerColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.WheelView_dividerColor, -2763307);
            this.dividerWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.up366.view.R.styleable.WheelView_dividerWidth, 2);
            this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.up366.view.R.styleable.WheelView_textSize, this.textSize);
            this.lineSpacingMultiplier = typedArrayObtainStyledAttributes.getFloat(com.up366.view.R.styleable.WheelView_lineSpacingMultiplier, this.lineSpacingMultiplier);
            typedArrayObtainStyledAttributes.recycle();
        }
        judgeLineSpace();
        initLoopView(context);
    }

    private void judgeLineSpace() {
        float f = this.lineSpacingMultiplier;
        if (f < 1.0f) {
            this.lineSpacingMultiplier = 1.0f;
        } else if (f > 4.0f) {
            this.lineSpacingMultiplier = 4.0f;
        }
    }

    private void initLoopView(android.content.Context context) {
        this.context = context;
        this.handler = new com.up366.view.wheelview.timer.MessageHandler(this);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(context, new com.up366.view.wheelview.listener.LoopViewGestureListener(this));
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    private void initPaints() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paintOuterText = paint;
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.textSize);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.textSize);
        android.graphics.Paint paint3 = new android.graphics.Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void reMeasure() {
        if (this.adapter == null) {
            return;
        }
        measureTextWidthHeight();
        int i = (int) (this.itemHeight * (this.itemsVisible - 1));
        this.measuredHeight = (int) (((double) (i * 2)) / 3.141592653589793d);
        this.radius = (int) (((double) i) / 3.141592653589793d);
        this.measuredWidth = android.view.View.MeasureSpec.getSize(this.widthMeasureSpec);
        int i2 = this.measuredHeight;
        float f = this.itemHeight;
        this.firstLineY = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.secondLineY = f2;
        this.centerY = (f2 - ((f - this.maxTextHeight) / 2.0f)) - this.CENTER_CONTENT_OFFSET;
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.adapter.getItemsCount() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    private void measureTextWidthHeight() {
        android.graphics.Rect rect = new android.graphics.Rect();
        for (int i = 0; i < this.adapter.getItemsCount(); i++) {
            java.lang.String contentText = getContentText(this.adapter.getItem(i));
            this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.maxTextWidth) {
                this.maxTextWidth = iWidth;
            }
        }
        this.paintCenterText.getTextBounds("星期", 0, 2, rect);
        int iHeight = rect.height() + 2;
        this.maxTextHeight = iHeight;
        this.itemHeight = this.lineSpacingMultiplier * iHeight;
    }

    public void smoothScroll(com.up366.view.wheelview.WheelView.ACTION action) {
        cancelFuture();
        if (action == com.up366.view.wheelview.WheelView.ACTION.FLING || action == com.up366.view.wheelview.WheelView.ACTION.DAGGLE) {
            float f = this.totalScrollY;
            float f2 = this.itemHeight;
            int i = (int) (((f % f2) + f2) % f2);
            this.mOffset = i;
            if (i > f2 / 2.0f) {
                this.mOffset = (int) (f2 - i);
            } else {
                this.mOffset = -i;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new com.up366.view.wheelview.timer.SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new com.up366.view.wheelview.timer.InertiaTimerTask(this, f), 0L, 5L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public final void setCyclic(boolean z) {
        this.isLoop = z;
    }

    public final void setTypeface(android.graphics.Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.textSize = i;
            this.paintOuterText.setTextSize(i);
            this.paintCenterText.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.selectedItem = i;
        this.initPosition = i;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(com.up366.view.wheelview.listener.OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setAdapter(com.up366.view.wheelview.adapter.WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        reMeasure();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0) {
            i++;
        }
        this.itemsVisible = i + 2;
    }

    public void setAlphaGradient(boolean z) {
        this.isAlphaGradient = z;
    }

    public final com.up366.view.wheelview.adapter.WheelAdapter getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        int i;
        com.up366.view.wheelview.adapter.WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter == null) {
            return 0;
        }
        if (this.isLoop && ((i = this.selectedItem) < 0 || i >= wheelAdapter.getItemsCount())) {
            return java.lang.Math.max(0, java.lang.Math.min(java.lang.Math.abs(java.lang.Math.abs(this.selectedItem) - this.adapter.getItemsCount()), this.adapter.getItemsCount() - 1));
        }
        return java.lang.Math.max(0, java.lang.Math.min(this.selectedItem, this.adapter.getItemsCount() - 1));
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new java.lang.Runnable() { // from class: com.up366.view.wheelview.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.view.wheelview.WheelView.this.onItemSelectedListener.onItemSelected(com.up366.view.wheelview.WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float f;
        java.lang.Object item;
        boolean z;
        float f2;
        java.lang.String contentText;
        int i;
        if (this.adapter == null) {
            return;
        }
        boolean z2 = false;
        int iMin = java.lang.Math.min(java.lang.Math.max(0, this.initPosition), this.adapter.getItemsCount() - 1);
        this.initPosition = iMin;
        try {
            this.preCurrentIndex = iMin + (((int) (this.totalScrollY / this.itemHeight)) % this.adapter.getItemsCount());
        } catch (java.lang.ArithmeticException unused) {
            android.util.Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex = this.adapter.getItemsCount() - 1;
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex -= this.adapter.getItemsCount();
            }
        }
        float f3 = this.totalScrollY % this.itemHeight;
        if (this.dividerType == com.up366.view.wheelview.WheelView.DividerType.WRAP) {
            if (android.text.TextUtils.isEmpty(this.label)) {
                i = (this.measuredWidth - this.maxTextWidth) / 2;
            } else {
                i = (this.measuredWidth - this.maxTextWidth) / 4;
            }
            float f4 = i - 12;
            float f5 = f4 <= 0.0f ? 10.0f : f4;
            float f6 = this.measuredWidth - f5;
            float f7 = this.firstLineY;
            float f8 = f5;
            canvas.drawLine(f8, f7, f6, f7, this.paintIndicator);
            float f9 = this.secondLineY;
            canvas.drawLine(f8, f9, f6, f9, this.paintIndicator);
        } else if (this.dividerType == com.up366.view.wheelview.WheelView.DividerType.CIRCLE) {
            this.paintIndicator.setStyle(android.graphics.Paint.Style.STROKE);
            this.paintIndicator.setStrokeWidth(this.dividerWidth);
            if (android.text.TextUtils.isEmpty(this.label)) {
                f = (this.measuredWidth - this.maxTextWidth) / 2.0f;
            } else {
                f = (this.measuredWidth - this.maxTextWidth) / 4.0f;
            }
            float f10 = f - 12.0f;
            float f11 = f10 > 0.0f ? f10 : 10.0f;
            canvas.drawCircle(this.measuredWidth / 2.0f, this.measuredHeight / 2.0f, java.lang.Math.max((this.measuredWidth - f11) - f11, this.itemHeight) / 1.8f, this.paintIndicator);
        } else {
            float f12 = this.firstLineY;
            canvas.drawLine(0.0f, f12, this.measuredWidth, f12, this.paintIndicator);
            float f13 = this.secondLineY;
            canvas.drawLine(0.0f, f13, this.measuredWidth, f13, this.paintIndicator);
        }
        if (!android.text.TextUtils.isEmpty(this.label) && this.isCenterLabel) {
            canvas.drawText(this.label, (this.measuredWidth - getTextWidth(this.paintCenterText, this.label)) - this.CENTER_CONTENT_OFFSET, this.centerY, this.paintCenterText);
        }
        int i2 = 0;
        while (true) {
            int i3 = this.itemsVisible;
            if (i2 >= i3) {
                return;
            }
            int i4 = this.preCurrentIndex - ((i3 / 2) - i2);
            if (this.isLoop) {
                item = this.adapter.getItem(getLoopMappingIndex(i4));
            } else {
                item = "";
                if (i4 >= 0 && i4 <= this.adapter.getItemsCount() - 1) {
                    item = this.adapter.getItem(i4);
                }
            }
            canvas.save();
            double d = ((this.itemHeight * i2) - f3) / this.radius;
            float f14 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f14 > 90.0f || f14 < -90.0f) {
                z = z2;
                f2 = f3;
                canvas.restore();
            } else {
                if (!this.isCenterLabel && !android.text.TextUtils.isEmpty(this.label) && !android.text.TextUtils.isEmpty(getContentText(item))) {
                    contentText = getContentText(item) + this.label;
                } else {
                    contentText = getContentText(item);
                }
                float fPow = (float) java.lang.Math.pow(java.lang.Math.abs(f14) / 90.0f, 2.2d);
                reMeasureTextSize(contentText);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                f2 = f3;
                float fCos = (float) ((((double) this.radius) - (java.lang.Math.cos(d) * ((double) this.radius))) - ((java.lang.Math.sin(d) * ((double) this.maxTextHeight)) / 2.0d));
                canvas.translate(0.0f, fCos);
                float f15 = this.firstLineY;
                if (fCos <= f15 && this.maxTextHeight + fCos >= f15) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - fCos);
                    canvas.scale(1.0f, ((float) java.lang.Math.sin(d)) * SCALE_CONTENT);
                    setOutPaintStyle(fPow, f14);
                    canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - fCos, this.measuredWidth, (int) this.itemHeight);
                    canvas.scale(1.0f, ((float) java.lang.Math.sin(d)) * 1.0f);
                    canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                    canvas.restore();
                } else {
                    float f16 = this.secondLineY;
                    if (fCos <= f16 && this.maxTextHeight + fCos >= f16) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - fCos);
                        canvas.scale(1.0f, ((float) java.lang.Math.sin(d)) * 1.0f);
                        canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - fCos, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) java.lang.Math.sin(d)) * SCALE_CONTENT);
                        setOutPaintStyle(fPow, f14);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else {
                        if (fCos >= f15) {
                            int i5 = this.maxTextHeight;
                            if (i5 + fCos <= f16) {
                                canvas.drawText(contentText, this.drawCenterContentStart, i5 - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                                this.selectedItem = this.preCurrentIndex - ((this.itemsVisible / 2) - i2);
                            }
                        }
                        canvas.save();
                        z = false;
                        canvas.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) java.lang.Math.sin(d)) * SCALE_CONTENT);
                        setOutPaintStyle(fPow, f14);
                        canvas.drawText(contentText, this.drawOutContentStart + (this.textXOffset * fPow), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.restore();
                        this.paintCenterText.setTextSize(this.textSize);
                    }
                }
                z = false;
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            }
            i2++;
            z2 = z;
            f3 = f2;
        }
    }

    private void setOutPaintStyle(float f, float f2) {
        int i = this.textXOffset;
        this.paintOuterText.setTextSkewX((i > 0 ? 1 : i < 0 ? -1 : 0) * (f2 <= 0.0f ? 1 : -1) * 0.5f * f);
        this.paintOuterText.setAlpha(this.isAlphaGradient ? (int) (((90.0f - java.lang.Math.abs(f2)) / 90.0f) * 255.0f) : 255);
    }

    private void reMeasureTextSize(java.lang.String str) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int iWidth = rect.width();
        int i = this.textSize;
        while (iWidth > this.measuredWidth) {
            i--;
            this.paintCenterText.setTextSize(i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
            int iWidth2 = rect.width();
            iWidth = iWidth2 + (iWidth2 / str.length());
        }
        this.paintOuterText.setTextSize(i);
    }

    private int getLoopMappingIndex(int i) {
        if (i < 0) {
            return getLoopMappingIndex(i + this.adapter.getItemsCount());
        }
        return i > this.adapter.getItemsCount() + (-1) ? getLoopMappingIndex(i - this.adapter.getItemsCount()) : i;
    }

    private java.lang.String getContentText(java.lang.Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.up366.view.wheelview.interfaces.IPickerViewData) {
            return ((com.up366.view.wheelview.interfaces.IPickerViewData) obj).getPickerViewText();
        }
        if (obj instanceof java.lang.Integer) {
            return getFixNum(((java.lang.Integer) obj).intValue());
        }
        return obj.toString();
    }

    private java.lang.String getFixNum(int i) {
        return (i < 0 || i >= 10) ? java.lang.String.valueOf(i) : TIME_NUM[i];
    }

    private void measuredCenterContentStart(java.lang.String str) {
        java.lang.String str2;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i == 3) {
            this.drawCenterContentStart = this.textLiftPadding;
            return;
        }
        if (i == 5) {
            this.drawCenterContentStart = ((this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET)) - this.textRightPadding;
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
            this.drawCenterContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.5d);
        } else {
            this.drawCenterContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.25d);
        }
    }

    public int getTextRightPadding() {
        return this.textRightPadding;
    }

    public void setTextRightPadding(int i) {
        this.textRightPadding = i;
    }

    public int getTextLiftPadding() {
        return this.textLiftPadding;
    }

    public void setTextLiftPadding(int i) {
        this.textLiftPadding = i;
    }

    private void measuredOutContentStart(java.lang.String str) {
        java.lang.String str2;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i == 3) {
            this.drawOutContentStart = this.textLiftPadding;
            return;
        }
        if (i == 5) {
            this.drawOutContentStart = ((this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET)) - this.textRightPadding;
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
            this.drawOutContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.5d);
        } else {
            this.drawOutContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.25d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        reMeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.initPosition) * this.itemHeight;
        float itemsCount = ((this.adapter.getItemsCount() - 1) - this.initPosition) * this.itemHeight;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTime = java.lang.System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
        } else {
            if (action == 2) {
                float rawY = this.previousY - motionEvent.getRawY();
                this.previousY = motionEvent.getRawY();
                float f2 = this.totalScrollY + rawY;
                this.totalScrollY = f2;
                if (!this.isLoop) {
                    float f3 = this.itemHeight;
                    if ((f2 - (f3 * 0.25f) < f && rawY < 0.0f) || ((f3 * 0.25f) + f2 > itemsCount && rawY > 0.0f)) {
                        this.totalScrollY = f2 - rawY;
                    }
                }
                return true;
            }
            if (!zOnTouchEvent) {
                float y = motionEvent.getY();
                int i = this.radius;
                double dAcos = java.lang.Math.acos((i - y) / i) * ((double) this.radius);
                float f4 = this.itemHeight;
                this.mOffset = (int) (((((int) ((dAcos + ((double) (f4 / 2.0f))) / ((double) f4))) - (this.itemsVisible / 2)) * f4) - (((this.totalScrollY % f4) + f4) % f4));
                if (java.lang.System.currentTimeMillis() - this.startTime > 120) {
                    smoothScroll(com.up366.view.wheelview.WheelView.ACTION.DAGGLE);
                } else {
                    smoothScroll(com.up366.view.wheelview.WheelView.ACTION.CLICK);
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public int getItemsCount() {
        com.up366.view.wheelview.adapter.WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public void setLabel(java.lang.String str) {
        this.label = str;
    }

    public void isCenterLabel(boolean z) {
        this.isCenterLabel = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public int getTextWidth(android.graphics.Paint paint, java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) java.lang.Math.ceil(r2[i]);
        }
        return iCeil;
    }

    public void setIsOptions(boolean z) {
        this.isOptions = z;
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        this.paintOuterText.setColor(i);
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        this.paintCenterText.setColor(i);
    }

    public void setTextXOffset(int i) {
        this.textXOffset = i;
        if (i != 0) {
            this.paintCenterText.setTextScaleX(1.0f);
        }
    }

    public void setDividerWidth(int i) {
        this.dividerWidth = i;
        this.paintIndicator.setStrokeWidth(i);
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        this.paintIndicator.setColor(i);
    }

    public void setDividerType(com.up366.view.wheelview.WheelView.DividerType dividerType) {
        this.dividerType = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.lineSpacingMultiplier = f;
            judgeLineSpace();
        }
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public float getTotalScrollY() {
        return this.totalScrollY;
    }

    public void setTotalScrollY(float f) {
        this.totalScrollY = f;
    }

    public float getItemHeight() {
        return this.itemHeight;
    }

    public int getInitPosition() {
        return this.initPosition;
    }

    @Override // android.view.View
    public android.os.Handler getHandler() {
        return this.handler;
    }
}
