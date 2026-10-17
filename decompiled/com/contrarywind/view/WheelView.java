package com.contrarywind.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WheelView extends android.view.View {
    private static final float SCALE_CONTENT = 0.8f;
    private static final java.lang.String[] TIME_NUM = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    private static final int VELOCITY_FLING = 5;
    private float CENTER_CONTENT_OFFSET;
    private final float DEFAULT_TEXT_TARGET_SKEW_X;
    private com.contrarywind.adapter.WheelAdapter adapter;
    private float centerY;
    private int change;
    private android.content.Context context;
    private int dividerColor;
    private com.contrarywind.view.WheelView.DividerType dividerType;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private android.view.GestureDetector gestureDetector;
    private android.os.Handler handler;
    private int initPosition;
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
    private int measuredHeight;
    private int measuredWidth;
    private com.contrarywind.listener.OnItemSelectedListener onItemSelectedListener;
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
        WRAP
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
        this.itemsVisible = 11;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.DEFAULT_TEXT_TARGET_SKEW_X = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(com.contrarywind.view.R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.CENTER_CONTENT_OFFSET = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.CENTER_CONTENT_OFFSET = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.CENTER_CONTENT_OFFSET = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.CENTER_CONTENT_OFFSET = 6.0f;
        } else if (f >= 3.0f) {
            this.CENTER_CONTENT_OFFSET = f * 2.5f;
        }
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.contrarywind.view.R.styleable.pickerview, 0, 0);
            this.mGravity = typedArrayObtainStyledAttributes.getInt(com.contrarywind.view.R.styleable.pickerview_wheelview_gravity, 17);
            this.textColorOut = typedArrayObtainStyledAttributes.getColor(com.contrarywind.view.R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.textColorCenter = typedArrayObtainStyledAttributes.getColor(com.contrarywind.view.R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.dividerColor = typedArrayObtainStyledAttributes.getColor(com.contrarywind.view.R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.contrarywind.view.R.styleable.pickerview_wheelview_textSize, this.textSize);
            this.lineSpacingMultiplier = typedArrayObtainStyledAttributes.getFloat(com.contrarywind.view.R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.lineSpacingMultiplier);
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
        this.handler = new com.contrarywind.timer.MessageHandler(this);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(context, new com.contrarywind.listener.LoopViewGestureListener(this));
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
        this.paintCenterText.getTextBounds("星期", 0, 2, rect);
        int iHeight = rect.height() + 2;
        this.maxTextHeight = iHeight;
        this.itemHeight = this.lineSpacingMultiplier * iHeight;
    }

    public void smoothScroll(com.contrarywind.view.WheelView.ACTION action) {
        cancelFuture();
        if (action == com.contrarywind.view.WheelView.ACTION.FLING || action == com.contrarywind.view.WheelView.ACTION.DAGGLE) {
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
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new com.contrarywind.timer.SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new com.contrarywind.timer.InertiaTimerTask(this, f), 0L, 5L, java.util.concurrent.TimeUnit.MILLISECONDS);
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

    public final void setOnItemSelectedListener(com.contrarywind.listener.OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setAdapter(com.contrarywind.adapter.WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        reMeasure();
        invalidate();
    }

    public final com.contrarywind.adapter.WheelAdapter getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        int i;
        com.contrarywind.adapter.WheelAdapter wheelAdapter = this.adapter;
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
            postDelayed(new java.lang.Runnable() { // from class: com.contrarywind.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    com.contrarywind.view.WheelView.this.onItemSelectedListener.onItemSelected(com.contrarywind.view.WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        java.lang.String str;
        android.graphics.Canvas canvas2;
        int[] iArr;
        int i;
        java.lang.Object item;
        java.lang.Object itemCenter;
        java.lang.String str2;
        android.graphics.Canvas canvas3 = canvas;
        if (this.adapter == null) {
            return;
        }
        int i2 = 0;
        int iMin = java.lang.Math.min(java.lang.Math.max(0, this.initPosition), this.adapter.getItemsCount() - 1);
        this.initPosition = iMin;
        int[] iArr2 = new int[this.itemsVisible];
        int i3 = (int) (this.totalScrollY / this.itemHeight);
        this.change = i3;
        try {
            this.preCurrentIndex = iMin + (i3 % this.adapter.getItemsCount());
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
        float f = this.totalScrollY % this.itemHeight;
        int i4 = 0;
        while (true) {
            int i5 = this.itemsVisible;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.preCurrentIndex - ((i5 / 2) - i4);
            if (this.isLoop) {
                iArr2[i4] = getLoopMappingIndex(i6);
            } else if (i6 < 0) {
                iArr2[i4] = -1;
            } else if (i6 > this.adapter.getItemsCount() - 1) {
                iArr2[i4] = -1;
            } else {
                iArr2[i4] = i6;
            }
            i4++;
        }
        if (this.dividerType == com.contrarywind.view.WheelView.DividerType.WRAP) {
            float f2 = this.measuredWidth - 10.0f;
            float f3 = this.firstLineY;
            canvas.drawLine(10.0f, f3, f2, f3, this.paintIndicator);
            float f4 = this.secondLineY;
            canvas.drawLine(10.0f, f4, f2, f4, this.paintIndicator);
        } else {
            float f5 = this.firstLineY;
            canvas.drawLine(0.0f, f5, this.measuredWidth, f5, this.paintIndicator);
            float f6 = this.secondLineY;
            canvas.drawLine(0.0f, f6, this.measuredWidth, f6, this.paintIndicator);
        }
        java.lang.String str3 = "";
        java.lang.String[] strArrSplit = "".split("");
        if (!android.text.TextUtils.isEmpty(this.label) && this.isCenterLabel) {
            strArrSplit = this.label.split("\n");
        }
        java.lang.String str4 = "";
        int i7 = 0;
        while (i7 < this.itemsVisible) {
            canvas.save();
            double d = ((this.itemHeight * i7) - f) / this.radius;
            float f7 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f7 >= 90.0f || f7 <= -90.0f) {
                str = str3;
                canvas2 = canvas3;
                iArr = iArr2;
                i = 0;
                canvas.restore();
            } else {
                float fPow = (float) java.lang.Math.pow(java.lang.Math.abs(f7) / 90.0f, 2.2d);
                int i8 = iArr2[i7];
                if (i8 != -1) {
                    item = this.adapter.getItem(i8);
                    itemCenter = this.adapter.getItemCenter(iArr2[i7]);
                } else {
                    item = str3;
                    itemCenter = item;
                }
                java.lang.String contentText = getContentText(item);
                java.lang.String contentText2 = getContentText(itemCenter);
                reMeasureTextSize(contentText);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                iArr = iArr2;
                float fCos = (float) ((((double) this.radius) - (java.lang.Math.cos(d) * ((double) this.radius))) - ((java.lang.Math.sin(d) * ((double) this.maxTextHeight)) / 2.0d));
                canvas2 = canvas;
                canvas2.translate(0.0f, fCos);
                float f8 = this.firstLineY;
                if (fCos <= f8 && this.maxTextHeight + fCos >= f8) {
                    canvas.save();
                    canvas2.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - fCos);
                    canvas2.scale(1.0f, ((float) java.lang.Math.sin(d)) * SCALE_CONTENT);
                    canvas2.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas2.clipRect(0.0f, this.firstLineY - fCos, this.measuredWidth, (int) this.itemHeight);
                    canvas2.scale(1.0f, ((float) java.lang.Math.sin(d)) * 1.0f);
                    str2 = contentText2;
                    java.lang.String[] strArrSplit2 = str2.split("\n");
                    int iMeasureText = this.drawCenterContentStart;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= strArrSplit2.length && i9 >= strArrSplit.length) {
                            break;
                        }
                        java.lang.String str5 = strArrSplit2.length > i9 ? strArrSplit2[i9] : str3;
                        java.lang.String str6 = strArrSplit.length > i9 ? strArrSplit[i9] : str3;
                        canvas2.drawText(str5, iMeasureText, this.maxTextHeight - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                        iMeasureText = (int) (((int) (r6 + this.paintCenterText.measureText(str5))) + this.paintCenterText.measureText(str6));
                        i9++;
                    }
                    canvas.restore();
                } else {
                    str2 = contentText2;
                    float f9 = this.secondLineY;
                    if (fCos <= f9 && this.maxTextHeight + fCos >= f9) {
                        canvas.save();
                        canvas2.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - fCos);
                        canvas2.scale(1.0f, ((float) java.lang.Math.sin(d)) * 1.0f);
                        java.lang.String[] strArrSplit3 = str2.split("\n");
                        int iMeasureText2 = this.drawCenterContentStart;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= strArrSplit3.length && i10 >= strArrSplit.length) {
                                break;
                            }
                            java.lang.String str7 = strArrSplit3.length > i10 ? strArrSplit3[i10] : str3;
                            java.lang.String str8 = strArrSplit.length > i10 ? strArrSplit[i10] : str3;
                            canvas2.drawText(str7, iMeasureText2, this.maxTextHeight - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                            iMeasureText2 = (int) (((int) (r5 + this.paintCenterText.measureText(str7))) + this.paintCenterText.measureText(str8));
                            i10++;
                            str3 = str3;
                        }
                        canvas.restore();
                        canvas.save();
                        canvas2.clipRect(0.0f, this.secondLineY - fCos, this.measuredWidth, (int) this.itemHeight);
                        canvas2.scale(1.0f, ((float) java.lang.Math.sin(d)) * SCALE_CONTENT);
                        canvas2.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else {
                        str = str3;
                        if (fCos >= f8) {
                            int i11 = this.maxTextHeight;
                            if (i11 + fCos <= f9) {
                                float f10 = i11 - this.CENTER_CONTENT_OFFSET;
                                java.lang.String[] strArrSplit4 = str2.split("\n");
                                int iMeasureText3 = this.drawCenterContentStart;
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= strArrSplit4.length && i12 >= strArrSplit.length) {
                                        break;
                                    }
                                    java.lang.String str9 = strArrSplit4.length > i12 ? strArrSplit4[i12] : str;
                                    java.lang.String str10 = strArrSplit.length > i12 ? strArrSplit[i12] : str;
                                    canvas2.drawText(str9, iMeasureText3, f10, this.paintCenterText);
                                    iMeasureText3 = (int) (((int) (r5 + this.paintCenterText.measureText(str9))) + this.paintCenterText.measureText(str10));
                                    i12++;
                                }
                                this.selectedItem = this.preCurrentIndex - ((this.itemsVisible / 2) - i7);
                                str4 = str2;
                                i = 0;
                                canvas.restore();
                                this.paintCenterText.setTextSize(this.textSize);
                            }
                        }
                        canvas.save();
                        i = 0;
                        canvas2.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas2.scale(1.0f, ((float) java.lang.Math.sin(d)) * SCALE_CONTENT);
                        android.graphics.Paint paint = this.paintOuterText;
                        int i13 = this.textXOffset;
                        paint.setTextSkewX((i13 == 0 ? 0 : i13 > 0 ? 1 : -1) * (f7 > 0.0f ? -1 : 1) * 0.5f * fPow);
                        this.paintOuterText.setAlpha((int) ((1.0f - fPow) * 255.0f));
                        canvas2.drawText(contentText, this.drawOutContentStart + (this.textXOffset * fPow), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.restore();
                        this.paintCenterText.setTextSize(this.textSize);
                    }
                }
                str = str3;
                str4 = str2;
                i = 0;
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            }
            i7++;
            i2 = i;
            canvas3 = canvas2;
            iArr2 = iArr;
            str3 = str;
        }
        java.lang.String str11 = str3;
        android.graphics.Canvas canvas4 = canvas3;
        java.lang.String[] strArrSplit5 = str4.split("\n");
        int iMeasureText4 = this.drawCenterContentStart;
        while (true) {
            if (i2 >= strArrSplit5.length && i2 >= strArrSplit.length) {
                return;
            }
            java.lang.String str12 = strArrSplit5.length > i2 ? strArrSplit5[i2] : str11;
            java.lang.String str13 = strArrSplit.length > i2 ? strArrSplit[i2] : str11;
            float fMeasureText = (int) (iMeasureText4 + this.paintCenterText.measureText(str12));
            canvas4.drawText(str13, fMeasureText, this.centerY, this.paintCenterText);
            iMeasureText4 = (int) (fMeasureText + this.paintCenterText.measureText(str13));
            i2++;
        }
    }

    public android.graphics.Paint getCenterPaint() {
        return this.paintCenterText;
    }

    private void reMeasureTextSize(java.lang.String str) {
        android.graphics.Rect rect = new android.graphics.Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int iWidth = rect.width(); iWidth > this.measuredWidth; iWidth = rect.width()) {
            i--;
            this.paintCenterText.setTextSize(i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
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
        if (obj instanceof com.contrarywind.interfaces.IPickerViewData) {
            return ((com.contrarywind.interfaces.IPickerViewData) obj).getPickerViewText();
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
            this.drawCenterContentStart = 0;
            return;
        }
        if (i == 5) {
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET);
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

    private void measuredOutContentStart(java.lang.String str) {
        java.lang.String str2;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i == 3) {
            this.drawOutContentStart = 0;
            return;
        }
        if (i == 5) {
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET);
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
                    smoothScroll(com.contrarywind.view.WheelView.ACTION.DAGGLE);
                } else {
                    smoothScroll(com.contrarywind.view.WheelView.ACTION.CLICK);
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public int getItemsCount() {
        com.contrarywind.adapter.WheelAdapter wheelAdapter = this.adapter;
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

    public void setDividerColor(int i) {
        this.dividerColor = i;
        this.paintIndicator.setColor(i);
    }

    public void setDividerType(com.contrarywind.view.WheelView.DividerType dividerType) {
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

    public void setItemsVisible(int i) {
        this.itemsVisible = i;
        reMeasure();
        postInvalidate();
    }
}
