package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LineSheetViewV3 extends android.view.View {
    private static final java.lang.String TAG = "LineSheetView";
    private android.animation.ValueAnimator anim;
    private final android.graphics.Paint axisDashPaint;
    private final android.graphics.Paint axisPaint;
    private final android.graphics.Point base;
    private final android.graphics.Paint circlePaint;
    private int curSel;
    private long downTime;
    private float downX;
    private float downY;
    private float dp;
    private int[] firstLineDataSet;
    private final float fontHeight;
    private int lastSel;
    private final android.graphics.Paint lineBgPaint;
    private final android.graphics.Paint linePaint;
    private android.graphics.drawable.Drawable noData;
    private int oldStartX;
    private android.graphics.Path path;
    private android.graphics.Rect rect;
    private int[] secondLineDataSet;
    private final android.graphics.Paint selectLinePaint;
    private boolean showToast;
    private float sp;
    private int startX;
    private final android.graphics.Paint textPaint;
    private final android.graphics.Paint textSelPaint;
    private int[] thirdLineDataSet;
    private final android.graphics.Paint toastBgPaint;
    private java.lang.String[] toastData;
    private int touchSlop;
    private android.view.VelocityTracker tracker;
    private android.graphics.RectF viewPort;
    private java.lang.String[] xAxis;
    private java.lang.String[] yAxis;

    public LineSheetViewV3(android.content.Context context) {
        this(context, null);
    }

    public LineSheetViewV3(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineSheetViewV3(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dp = getResources().getDisplayMetrics().density;
        this.sp = getResources().getDisplayMetrics().scaledDensity;
        this.curSel = 0;
        this.lastSel = -1;
        this.startX = 0;
        this.oldStartX = 0;
        this.showToast = false;
        this.downTime = 0L;
        this.path = new android.graphics.Path();
        this.rect = new android.graphics.Rect();
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.textPaint = paint;
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.axisPaint = paint2;
        android.graphics.Paint paint3 = new android.graphics.Paint(1);
        this.axisDashPaint = paint3;
        android.graphics.Paint paint4 = new android.graphics.Paint(1);
        this.linePaint = paint4;
        android.graphics.Paint paint5 = new android.graphics.Paint(1);
        this.selectLinePaint = paint5;
        android.graphics.Paint paint6 = new android.graphics.Paint(1);
        this.circlePaint = paint6;
        android.graphics.Paint paint7 = new android.graphics.Paint(1);
        android.graphics.Paint paint8 = new android.graphics.Paint(1);
        android.graphics.Paint paint9 = new android.graphics.Paint(1);
        this.lineBgPaint = paint9;
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setTextSize(this.sp * 11.0f);
        paint.setColor(-6710887);
        android.graphics.Paint paint10 = new android.graphics.Paint(paint);
        this.textSelPaint = paint10;
        paint10.setColor(-9661697);
        android.graphics.Paint paint11 = new android.graphics.Paint();
        this.toastBgPaint = paint11;
        paint11.setColor(1711276032);
        paint11.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        paint2.setStrokeWidth(this.dp * 1.0f);
        paint2.setColor(-2236963);
        paint3.setStyle(android.graphics.Paint.Style.STROKE);
        paint3.setStrokeWidth(this.dp * 0.5f);
        paint3.setColor(-2236963);
        float f = this.dp;
        paint3.setPathEffect(new android.graphics.DashPathEffect(new float[]{2.0f * f, f * 4.0f}, 0.0f));
        paint4.setStyle(android.graphics.Paint.Style.STROKE);
        paint4.setStrokeWidth(this.dp * 1.5f);
        paint4.setColor(-22911);
        paint5.setStyle(android.graphics.Paint.Style.STROKE);
        paint5.setStrokeWidth(this.dp * 1.0f);
        paint5.setColor(-37780);
        paint6.setStyle(android.graphics.Paint.Style.FILL);
        paint6.setStrokeWidth(this.dp * 6.0f);
        paint6.setColor(-22911);
        paint7.setStyle(android.graphics.Paint.Style.FILL);
        paint7.setColor(-1);
        paint8.setStyle(android.graphics.Paint.Style.STROKE);
        paint8.setStrokeWidth(this.dp * 1.0f);
        paint8.setColor(-1184275);
        paint9.setStyle(android.graphics.Paint.Style.FILL);
        paint9.setColor(436178527);
        this.viewPort = new android.graphics.RectF(0.0f, 0.0f, 4.0f, 110.0f);
        this.base = new android.graphics.Point(0, 0);
        android.graphics.Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.fontHeight = java.lang.Math.abs(fontMetrics.top - fontMetrics.bottom);
        this.touchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        java.lang.String[] strArr = this.yAxis;
        java.lang.String[] strArr2 = this.xAxis;
        initBasePoint(strArr);
        drawAxisY(canvas, strArr);
        drawAxisYDash(canvas, strArr);
        canvas.save();
        this.rect.set((int) getScaleX(0.0f), (int) getScaleY(200.0f), (int) getScaleX(4.0f), (int) getScaleY(-100.0f));
        canvas.clipRect(this.rect);
        drawAxisX(canvas, strArr2);
        int[] iArr = this.firstLineDataSet;
        if (iArr == null || iArr.length == 0) {
            return;
        }
        drawDataSetLine(canvas, iArr, -12465522);
        int[] iArr2 = this.secondLineDataSet;
        if (iArr2 != null && iArr2.length > 0) {
            drawDataSetLine(canvas, iArr2, -9661697);
        }
        int[] iArr3 = this.thirdLineDataSet;
        if (iArr3 != null && iArr3.length > 0) {
            drawDataSetLine(canvas, iArr3, -27802);
        }
        if (this.showToast) {
            drawSelectYLine(canvas);
            drawCurDataSet(canvas, this.firstLineDataSet, -12465522);
            int[] iArr4 = this.secondLineDataSet;
            if (iArr4 != null && iArr4.length > 0) {
                drawCurDataSet(canvas, iArr4, -9661697);
            }
            int[] iArr5 = this.thirdLineDataSet;
            if (iArr5 != null && iArr5.length > 0) {
                drawCurDataSet(canvas, iArr5, -27802);
            }
            drawToast(canvas);
        }
        canvas.restore();
    }

    private void drawSelectYLine(android.graphics.Canvas canvas) {
        for (int i = 0; i < this.firstLineDataSet.length; i++) {
            if (this.curSel == i) {
                float scaleX = this.startX + getScaleX(i + 0.5f);
                if (scaleX < getScaleX(0.0f) || scaleX > getScaleX(5.0f)) {
                    return;
                } else {
                    canvas.drawLine(scaleX, this.base.y, scaleX, 0.0f, this.selectLinePaint);
                }
            }
        }
    }

    public boolean isShowToast() {
        return this.showToast;
    }

    public void setShowToast(boolean z) {
        if (this.showToast == z) {
            return;
        }
        this.showToast = z;
        postInvalidate();
    }

    private void drawToast(android.graphics.Canvas canvas) {
        int iMeasureText;
        float f = 0.0f;
        java.lang.String str = "";
        float scaleX = 0.0f;
        for (int i = 0; i < this.firstLineDataSet.length; i++) {
            if (this.curSel == i) {
                scaleX = getScaleX(i + 0.5f) + this.startX;
                str = this.toastData[i];
            }
        }
        if (scaleX == 0.0f && str.length() == 0) {
            return;
        }
        java.lang.String[] strArrSplit = str.split("\n");
        if (strArrSplit.length == 1) {
            iMeasureText = (int) this.textPaint.measureText(strArrSplit[0]);
        } else {
            int iMax = 0;
            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                iMax = (int) java.lang.Math.max(iMax, this.textPaint.measureText(strArrSplit[i2]));
            }
            int i3 = (int) (iMax + (this.dp * 20.0f));
            java.lang.String str2 = strArrSplit[0];
            int length = str2.length();
            float[] fArr = new float[length];
            this.textPaint.setFakeBoldText(true);
            this.textPaint.getTextWidths(str2, fArr);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                float f2 = fArr[i5];
                if (f + f2 < i3) {
                    f += f2;
                } else {
                    sb.append(str2.substring(i4, i5));
                    sb.append("\n");
                    i4 = i5;
                    f = f2;
                }
            }
            if (i4 < str2.length()) {
                sb.append(str2.substring(i4));
                sb.append("\n");
            }
            for (int i6 = 1; i6 < strArrSplit.length; i6++) {
                sb.append(strArrSplit[i6]);
                sb.append("\n");
            }
            strArrSplit = sb.toString().split("\n");
            iMeasureText = i3;
        }
        float f3 = this.fontHeight;
        float length2 = (strArrSplit.length * f3) + (f3 / 2.0f);
        this.textPaint.setTextAlign(android.graphics.Paint.Align.LEFT);
        this.textPaint.setColor(-1);
        float f4 = iMeasureText + (this.dp * 16.0f);
        float f5 = f4 / 2.0f;
        float width = scaleX - f5;
        if (width < this.base.x) {
            width = this.base.x + (this.dp * 5.0f);
        } else if (scaleX + f5 > getWidth()) {
            width = (getWidth() - f4) - (this.dp * 5.0f);
        }
        float f6 = this.dp;
        android.graphics.RectF rectF = new android.graphics.RectF(width, f6 * 15.0f, f4 + width, (f6 * 15.0f) + length2);
        float f7 = this.dp;
        canvas.drawRoundRect(rectF, f7 * 4.0f, f7 * 4.0f, this.toastBgPaint);
        for (int length3 = strArrSplit.length - 1; length3 > -1; length3--) {
            if (strArrSplit.length > 1 && length3 < strArrSplit.length - 3) {
                this.textPaint.setFakeBoldText(true);
            } else {
                this.textPaint.setFakeBoldText(false);
            }
            canvas.drawText(strArrSplit[length3], rectF.left + (this.dp * 8.0f), rectF.top + (this.fontHeight * (length3 + 1)), this.textPaint);
        }
    }

    private void drawCurDataSet(android.graphics.Canvas canvas, int[] iArr, int i) {
        this.textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.textSelPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (this.curSel == i2) {
                float scaleX = this.startX + getScaleX(i2 + 0.5f);
                if (scaleX < getScaleX(0.0f) || scaleX > ((int) getScaleX(5.0f))) {
                    return;
                }
                float scaleY = getScaleY(iArr[i2]);
                this.circlePaint.setColor(i);
                canvas.drawCircle(scaleX, scaleY, this.dp * 4.0f, this.circlePaint);
                this.circlePaint.setColor(-1);
                canvas.drawCircle(scaleX, scaleY, this.dp * 3.0f, this.circlePaint);
            }
        }
    }

    private void drawDataSetLine(android.graphics.Canvas canvas, int[] iArr, int i) {
        this.path.reset();
        this.linePaint.setColor(i);
        int i2 = 0;
        while (i2 < iArr.length) {
            int i3 = i2 + 1;
            if (i3 != iArr.length) {
                canvas.drawLine(this.startX + getScaleX(i2 + 0.5f), getScaleY(iArr[i2]), this.startX + getScaleX(i3 + 0.5f), getScaleY(iArr[i3]), this.linePaint);
            }
            i2 = i3;
        }
    }

    private void drawBackgroundColor(android.graphics.Canvas canvas, int[] iArr) {
        this.path.reset();
        this.path.moveTo(this.startX + getScaleX(0.5f), getScaleY(0.0f));
        for (int i = 0; i < iArr.length; i++) {
            float f = i + 0.5f;
            this.path.lineTo(this.startX + getScaleX(f), getScaleY(iArr[i]));
            if (i == iArr.length - 1) {
                this.path.lineTo(this.startX + getScaleX(f), getScaleY(0.0f));
            }
        }
        this.path.lineTo(this.startX + getScaleX(0.5f), getScaleY(0.0f));
        canvas.drawPath(this.path, this.lineBgPaint);
    }

    private void drawAxisX(android.graphics.Canvas canvas, java.lang.String[] strArr) {
        this.textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.textPaint.setColor(-6710887);
        this.textSelPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        float f = this.base.y + (this.dp * 8.0f) + (this.fontHeight / 2.0f);
        for (int i = 0; i < strArr.length; i++) {
            float scaleX = this.startX + getScaleX(i + 0.5f);
            if (this.curSel == i && this.showToast) {
                canvas.drawText(strArr[i], scaleX, f, this.textSelPaint);
            } else {
                canvas.drawText(strArr[i], scaleX, f, this.textPaint);
            }
            canvas.drawLine(scaleX, this.base.y, scaleX, this.base.y - (this.dp * 4.0f), this.axisPaint);
        }
        canvas.drawLine(this.base.x, this.base.y, getScaleX(4.0f), this.base.y, this.axisPaint);
    }

    private void drawAxisY(android.graphics.Canvas canvas, java.lang.String[] strArr) {
        this.textPaint.setTextAlign(android.graphics.Paint.Align.LEFT);
        this.textPaint.setColor(-6710887);
        for (int i = 0; i < strArr.length; i++) {
            float scaleY = getScaleY(java.lang.Integer.valueOf(strArr[i]).intValue());
            canvas.drawText(strArr[i], 0.0f, (this.fontHeight / 4.0f) + scaleY, this.textPaint);
            canvas.drawLine(this.base.x, scaleY, this.base.x + (this.dp * 4.0f), scaleY, this.axisPaint);
        }
        canvas.drawLine(this.base.x, this.base.y, this.base.x, 0.0f, this.axisPaint);
    }

    private void drawAxisYDash(android.graphics.Canvas canvas, java.lang.String[] strArr) {
        for (java.lang.String str : strArr) {
            float scaleY = getScaleY(java.lang.Integer.valueOf(str).intValue());
            this.path.reset();
            this.path.moveTo(this.base.x, scaleY);
            this.path.lineTo(getScaleX(5.0f), scaleY);
            canvas.drawPath(this.path, this.axisDashPaint);
        }
    }

    private void initBasePoint(java.lang.String[] strArr) {
        int iMax = 0;
        for (java.lang.String str : strArr) {
            iMax = (int) java.lang.Math.max(iMax, this.textPaint.measureText(str));
        }
        this.base.x = (int) (iMax + (this.dp * 8.0f));
        this.base.y = getHeight() - ((int) (this.fontHeight + (this.dp * 8.0f)));
    }

    public float getScaleX(float f) {
        return this.base.x + (((f * 1.0f) / this.viewPort.width()) * (getWidth() - this.base.x));
    }

    public float getScaleY(float f) {
        return this.base.y - (((f * 1.0f) / this.viewPort.height()) * this.base.y);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        this.tracker.addMovement(motionEvent);
        int[] iArr = this.firstLineDataSet;
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            this.downTime = java.lang.System.currentTimeMillis();
            this.showToast = false;
            this.oldStartX = this.startX;
            android.animation.ValueAnimator valueAnimator = this.anim;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.anim = null;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
            if (java.lang.Math.abs(motionEvent.getX() - this.downX) < this.touchSlop && java.lang.Math.abs(motionEvent.getY() - this.downY) < this.touchSlop && java.lang.System.currentTimeMillis() - this.downTime < 100 && this.downX > this.base.x && this.downY < this.base.y) {
                this.showToast = true;
            } else {
                this.showToast = false;
            }
            this.oldStartX = this.startX;
            this.downX = motionEvent.getX();
            this.tracker.computeCurrentVelocity(1, 10.0f);
            final float xVelocity = this.tracker.getXVelocity();
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.anim = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration((long) ((xVelocity < 0.0f ? -xVelocity : xVelocity) * 100.0f));
            this.anim.setInterpolator(new android.view.animation.DecelerateInterpolator());
            this.anim.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.views.LineSheetViewV3$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator2) {
                    this.f$0.lambda$onTouchEvent$0(xVelocity, valueAnimator2);
                }
            });
            this.anim.start();
        }
        float x = motionEvent.getX();
        int i = this.oldStartX + ((int) (x - this.downX));
        this.startX = i;
        if (i < (-getScaleX(this.firstLineDataSet.length - 4.5f))) {
            this.startX = (int) (-getScaleX(this.firstLineDataSet.length - 4.5f));
        }
        if (this.startX > 0) {
            this.startX = 0;
        }
        float f = 2.14748365E9f;
        int i2 = -1;
        for (int i3 = 0; i3 < this.firstLineDataSet.length; i3++) {
            float fAbs = java.lang.Math.abs((this.startX + getScaleX(i3 + 0.5f)) - x);
            if (fAbs < f) {
                i2 = i3;
                f = fAbs;
            }
        }
        this.curSel = i2;
        postInvalidate();
        int i4 = this.lastSel;
        int i5 = this.curSel;
        if (i4 != i5) {
            this.lastSel = i5;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$0(float f, android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        int i = (int) (this.oldStartX + (f * fFloatValue * 300.0f));
        this.startX = i;
        if (i < (-getScaleX(this.firstLineDataSet.length - 4.5f))) {
            this.startX = (int) (-getScaleX(this.firstLineDataSet.length - 4.5f));
        }
        if (this.startX > 0) {
            this.startX = 0;
        }
        if (fFloatValue == 1.0f) {
            this.oldStartX = this.startX;
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.tracker == null) {
            this.tracker = android.view.VelocityTracker.obtain();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        android.view.VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.tracker = null;
        }
        super.onDetachedFromWindow();
    }

    public void setData(int[] iArr, int[] iArr2, int[] iArr3, java.lang.String[] strArr) {
        this.firstLineDataSet = iArr;
        this.secondLineDataSet = iArr2;
        this.thirdLineDataSet = iArr3;
        this.toastData = strArr;
        this.curSel = iArr.length - 1;
        if (iArr.length > 5) {
            initBasePoint(this.yAxis);
            this.startX = (int) (-getScaleX(iArr.length - 4.5f));
        }
        postInvalidate();
    }

    public void setAxis(java.lang.String[] strArr, int i, int i2) {
        this.xAxis = strArr;
        int i3 = i * i2;
        this.viewPort.bottom = (i / 2) + i3;
        int i4 = i2 + 1;
        this.yAxis = new java.lang.String[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            this.yAxis[i5] = java.lang.String.valueOf(i * i5);
        }
        this.viewPort = new android.graphics.RectF(0.0f, 0.0f, 4.0f, i3 + (i / 2.0f));
        postInvalidate();
    }
}
