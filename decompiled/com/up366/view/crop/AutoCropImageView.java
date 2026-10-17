package com.up366.view.crop;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AutoCropImageView extends androidx.appcompat.widget.AppCompatImageView {
    private static final int DEFAULT_GUIDE_LINE_COLOR = -1;
    private static final float DEFAULT_GUIDE_LINE_WIDTH = 0.3f;
    private static final int DEFAULT_LINE_COLOR = -16711681;
    private static final float DEFAULT_LINE_WIDTH = 1.0f;
    private static final int DEFAULT_MAGNIFIER_CROSS_COLOR = -49023;
    private static final int DEFAULT_MASK_ALPHA = 86;
    private static final int DEFAULT_POINT_FILL_ALPHA = 175;
    private static final int DEFAULT_POINT_FILL_COLOR = -1;
    private static final float MAGNIFIER_BORDER_WIDTH = 1.0f;
    private static final float MAGNIFIER_CROSS_LINE_LENGTH = 3.0f;
    private static final float MAGNIFIER_CROSS_LINE_WIDTH = 0.8f;
    private static final float POINT_RADIUS = 9.0f;
    private static final int P_LB = 3;
    private static final int P_LT = 0;
    private static final int P_RB = 2;
    private static final int P_RT = 1;
    private static final java.lang.String TAG = "AutoCropImageView";
    private static final float TOUCH_POINT_CATCH_DISTANCE = 15.0f;
    private int mActHeight;
    private int mActLeft;
    private int mActTop;
    private int mActWidth;
    boolean mAutoScanEnable;
    android.graphics.Point[] mCropPoints;
    private float mCropRectInitRatio;
    private float mDensity;
    boolean mDragLimit;
    private android.graphics.Point mDraggingPoint;
    android.graphics.Point[] mEdgeMidPoints;
    int mGuideLineColor;
    private android.graphics.Paint mGuideLinePaint;
    float mGuideLineWidth;
    int mLineColor;
    private android.graphics.Paint mLinePaint;
    float mLineWidth;
    int mMagnifierCrossColor;
    private android.graphics.Paint mMagnifierCrossPaint;
    private android.graphics.drawable.ShapeDrawable mMagnifierDrawable;
    private android.graphics.Matrix mMagnifierMatrix;
    private android.graphics.Paint mMagnifierPaint;
    float mMagnifierScale;
    int mMaskAlpha;
    private android.graphics.Paint mMaskPaint;
    private android.graphics.Xfermode mMaskXfermode;
    private float[] mMatrixValue;
    int mPointColor;
    int mPointFillAlpha;
    int mPointFillColor;
    private android.graphics.Paint mPointFillPaint;
    private android.graphics.Path mPointLinePath;
    float mPointMinDistance;
    private android.graphics.Paint mPointPaint;
    float mPointWidth;
    private float mScaleX;
    private float mScaleY;
    boolean mShowEdgeMidPoint;
    boolean mShowGuideLine;
    boolean mShowMagnifier;

    enum DragPointType {
        LEFT_TOP,
        RIGHT_TOP,
        RIGHT_BOTTOM,
        LEFT_BOTTOM,
        TOP,
        RIGHT,
        BOTTOM,
        LEFT;

        public static boolean isEdgePoint(com.up366.view.crop.AutoCropImageView.DragPointType dragPointType) {
            return dragPointType == TOP || dragPointType == RIGHT || dragPointType == BOTTOM || dragPointType == LEFT;
        }
    }

    public AutoCropImageView(android.content.Context context) {
        this(context, null);
    }

    public AutoCropImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoCropImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDraggingPoint = null;
        this.mMatrixValue = new float[9];
        this.mMaskXfermode = new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT);
        this.mPointLinePath = new android.graphics.Path();
        this.mMagnifierMatrix = new android.graphics.Matrix();
        this.mPointFillColor = -1;
        this.mPointFillAlpha = DEFAULT_POINT_FILL_ALPHA;
        this.mLineColor = DEFAULT_LINE_COLOR;
        this.mMagnifierCrossColor = DEFAULT_MAGNIFIER_CROSS_COLOR;
        this.mGuideLineColor = -1;
        this.mMaskAlpha = 86;
        this.mShowGuideLine = true;
        this.mShowMagnifier = true;
        this.mShowEdgeMidPoint = true;
        this.mAutoScanEnable = true;
        this.mMagnifierScale = 1.0f;
        this.mPointMinDistance = 100.0f;
        this.mDragLimit = true;
        this.mCropRectInitRatio = 0.95f;
        android.widget.ImageView.ScaleType scaleType = getScaleType();
        if (scaleType == android.widget.ImageView.ScaleType.FIT_END || scaleType == android.widget.ImageView.ScaleType.FIT_START || scaleType == android.widget.ImageView.ScaleType.MATRIX) {
            throw new java.lang.RuntimeException("Image in CropImageView must be in center");
        }
        this.mDensity = getResources().getDisplayMetrics().density;
        initAttrs(context, attributeSet);
        initPaints();
    }

    private void initAttrs(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.view.R.styleable.AutoCropImageView);
        this.mMaskAlpha = java.lang.Math.min(java.lang.Math.max(0, typedArrayObtainStyledAttributes.getInt(com.up366.view.R.styleable.AutoCropImageView_acivMaskAlpha, 86)), 255);
        this.mShowGuideLine = typedArrayObtainStyledAttributes.getBoolean(com.up366.view.R.styleable.AutoCropImageView_acivShowGuideLine, true);
        this.mLineColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.AutoCropImageView_acivLineColor, DEFAULT_LINE_COLOR);
        this.mLineWidth = typedArrayObtainStyledAttributes.getDimension(com.up366.view.R.styleable.AutoCropImageView_acivLineWidth, dp2px(1.0f));
        this.mPointColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.AutoCropImageView_acivPointColor, DEFAULT_LINE_COLOR);
        this.mPointWidth = typedArrayObtainStyledAttributes.getDimension(com.up366.view.R.styleable.AutoCropImageView_acivPointWidth, dp2px(1.0f));
        this.mMagnifierCrossColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.AutoCropImageView_acivMagnifierCrossColor, DEFAULT_MAGNIFIER_CROSS_COLOR);
        this.mShowMagnifier = typedArrayObtainStyledAttributes.getBoolean(com.up366.view.R.styleable.AutoCropImageView_acivShowMagnifier, true);
        this.mGuideLineWidth = typedArrayObtainStyledAttributes.getDimension(com.up366.view.R.styleable.AutoCropImageView_acivGuideLineWidth, dp2px(DEFAULT_GUIDE_LINE_WIDTH));
        this.mGuideLineColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.AutoCropImageView_acivGuideLineColor, -1);
        this.mPointFillColor = typedArrayObtainStyledAttributes.getColor(com.up366.view.R.styleable.AutoCropImageView_acivPointFillColor, -1);
        this.mShowEdgeMidPoint = typedArrayObtainStyledAttributes.getBoolean(com.up366.view.R.styleable.AutoCropImageView_acivShowEdgeMidPoint, true);
        this.mAutoScanEnable = typedArrayObtainStyledAttributes.getBoolean(com.up366.view.R.styleable.AutoCropImageView_acivAutoScanEnable, true);
        this.mMagnifierScale = typedArrayObtainStyledAttributes.getFloat(com.up366.view.R.styleable.AutoCropImageView_acivMagnifierBitmapScale, 1.0f);
        this.mPointMinDistance = typedArrayObtainStyledAttributes.getDimension(com.up366.view.R.styleable.AutoCropImageView_acivPointMinDistance, 100.0f);
        this.mPointFillAlpha = java.lang.Math.min(java.lang.Math.max(0, typedArrayObtainStyledAttributes.getInt(com.up366.view.R.styleable.AutoCropImageView_acivPointFillAlpha, DEFAULT_POINT_FILL_ALPHA)), 255);
        typedArrayObtainStyledAttributes.recycle();
        this.mCropRectInitRatio = getResources().getInteger(com.up366.view.R.integer.ucrop_default_crop_rect_init_ratio) / 100.0f;
    }

    public void setAutoScanEnable(boolean z) {
        this.mAutoScanEnable = z;
    }

    public void setCropPoints(android.graphics.Point[] pointArr) {
        if (getDrawable() == null) {
            android.util.Log.w(TAG, "should call after set drawable");
        } else if (!checkPoints(pointArr)) {
            setFullImgCrop();
        } else {
            this.mCropPoints = pointArr;
            invalidate();
        }
    }

    public void setEdgeMidPoints() {
        int i = 0;
        if (this.mEdgeMidPoints == null) {
            this.mEdgeMidPoints = new android.graphics.Point[4];
            int i2 = 0;
            while (true) {
                android.graphics.Point[] pointArr = this.mEdgeMidPoints;
                if (i2 >= pointArr.length) {
                    break;
                }
                pointArr[i2] = new android.graphics.Point();
                i2++;
            }
        }
        int length = this.mCropPoints.length;
        while (i < length) {
            int i3 = i + 1;
            int i4 = i3 % length;
            this.mEdgeMidPoints[i].set(this.mCropPoints[i].x + ((this.mCropPoints[i4].x - this.mCropPoints[i].x) / 2), this.mCropPoints[i].y + ((this.mCropPoints[i4].y - this.mCropPoints[i].y) / 2));
            i = i3;
        }
    }

    public void setFullImgCrop() {
        if (getDrawable() == null) {
            android.util.Log.w(TAG, "should call after set drawable");
        } else {
            this.mCropPoints = getFullImgCropPoints();
            invalidate();
        }
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mMagnifierDrawable = null;
    }

    public void setImageToCrop(android.graphics.Bitmap bitmap) {
        setImageBitmap(bitmap);
        setCropPoints(null);
    }

    public android.graphics.Point[] getCropPoints() {
        return this.mCropPoints;
    }

    public void setPointFillColor(int i) {
        this.mPointFillColor = i;
    }

    public void setPointFillAlpha(int i) {
        this.mPointFillAlpha = i;
    }

    public void setMaskAlpha(int i) {
        this.mMaskAlpha = java.lang.Math.min(java.lang.Math.max(0, i), 255);
        invalidate();
    }

    public void setShowGuideLine(boolean z) {
        this.mShowGuideLine = z;
        invalidate();
    }

    public void setGuideLineColor(int i) {
        this.mGuideLineColor = i;
    }

    public void setGuideLineWidth(float f) {
        this.mGuideLineWidth = f;
    }

    public void setLineColor(int i) {
        this.mLineColor = i;
        invalidate();
    }

    public void setMagnifierCrossColor(int i) {
        this.mMagnifierCrossColor = i;
    }

    public void setLineWidth(int i) {
        this.mLineWidth = i;
        invalidate();
    }

    public void setPointColor(int i) {
        this.mPointColor = i;
        invalidate();
    }

    public void setPointWidth(float f) {
        this.mPointWidth = f;
        invalidate();
    }

    public void setShowMagnifier(boolean z) {
        this.mShowMagnifier = z;
    }

    public void setDragLimit(boolean z) {
        this.mDragLimit = z;
    }

    public boolean canRightCrop() {
        if (!checkPoints(this.mCropPoints)) {
            return false;
        }
        android.graphics.Point[] pointArr = this.mCropPoints;
        android.graphics.Point point = pointArr[0];
        android.graphics.Point point2 = pointArr[1];
        android.graphics.Point point3 = pointArr[2];
        android.graphics.Point point4 = pointArr[3];
        return pointSideLine(point, point3, point4) * pointSideLine(point, point3, point2) < 0 && pointSideLine(point4, point2, point) * pointSideLine(point4, point2, point3) < 0;
    }

    public boolean checkPoints(android.graphics.Point[] pointArr) {
        return (pointArr == null || pointArr.length != 4 || pointArr[0] == null || pointArr[1] == null || pointArr[2] == null || pointArr[3] == null) ? false : true;
    }

    private long pointSideLine(android.graphics.Point point, android.graphics.Point point2, android.graphics.Point point3) {
        return pointSideLine(point, point2, point3.x, point3.y);
    }

    private long pointSideLine(android.graphics.Point point, android.graphics.Point point2, int i, int i2) {
        long j = point.x;
        long j2 = point.y;
        return ((((long) i) - j) * (((long) point2.y) - j2)) - ((((long) i2) - j2) * (((long) point2.x) - j));
    }

    public android.graphics.Bitmap getBitmap() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    private void initPaints() {
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.mPointPaint = paint;
        paint.setColor(this.mPointColor);
        this.mPointPaint.setStrokeWidth(this.mPointWidth);
        this.mPointPaint.setStyle(android.graphics.Paint.Style.STROKE);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.mPointFillPaint = paint2;
        paint2.setColor(this.mPointFillColor);
        this.mPointFillPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPointFillPaint.setAlpha(this.mPointFillAlpha);
        android.graphics.Paint paint3 = new android.graphics.Paint(1);
        this.mLinePaint = paint3;
        paint3.setColor(this.mLineColor);
        this.mLinePaint.setStrokeWidth(this.mLineWidth);
        this.mLinePaint.setStyle(android.graphics.Paint.Style.STROKE);
        android.graphics.Paint paint4 = new android.graphics.Paint(1);
        this.mMaskPaint = paint4;
        paint4.setColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        this.mMaskPaint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint5 = new android.graphics.Paint(1);
        this.mGuideLinePaint = paint5;
        paint5.setColor(this.mGuideLineColor);
        this.mGuideLinePaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mGuideLinePaint.setStrokeWidth(this.mGuideLineWidth);
        android.graphics.Paint paint6 = new android.graphics.Paint(1);
        this.mMagnifierPaint = paint6;
        paint6.setColor(android.graphics.Color.parseColor("#FFD8D8D8"));
        this.mMagnifierPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mMagnifierPaint.setAntiAlias(true);
        this.mMagnifierPaint.setStrokeWidth(dp2px(1.0f));
        android.graphics.Paint paint7 = new android.graphics.Paint(1);
        this.mMagnifierCrossPaint = paint7;
        paint7.setColor(this.mMagnifierCrossColor);
        this.mMagnifierCrossPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mMagnifierCrossPaint.setStrokeWidth(dp2px(MAGNIFIER_CROSS_LINE_WIDTH));
    }

    private void initMagnifier() {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(getWidth() + 2, getHeight() + 2, android.graphics.Bitmap.Config.RGB_565);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        canvas.drawColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        android.graphics.Bitmap bitmap = getBitmap();
        int i = this.mActLeft;
        int i2 = this.mActTop;
        canvas.drawBitmap(bitmap, (android.graphics.Rect) null, new android.graphics.Rect(i + 1, i2 + 1, this.mActWidth + i + 1, this.mActHeight + i2 + 1), (android.graphics.Paint) null);
        canvas.save();
        android.graphics.Bitmap bitmapCreateScaledBitmap = android.graphics.Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (getWidth() * this.mMagnifierScale), (int) (getHeight() * this.mMagnifierScale), false);
        if (bitmapCreateBitmap != bitmapCreateScaledBitmap) {
            bitmapCreateBitmap.recycle();
        }
        android.graphics.BitmapShader bitmapShader = new android.graphics.BitmapShader(bitmapCreateScaledBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.OvalShape());
        this.mMagnifierDrawable = shapeDrawable;
        shapeDrawable.getPaint().setShader(bitmapShader);
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        getDrawablePosition();
        onDrawCropPoint(canvas);
    }

    protected void onDrawCropPoint(android.graphics.Canvas canvas) {
        onDrawMask(canvas);
        onDrawGuideLine(canvas);
        onDrawLines(canvas);
        onDrawPoints(canvas);
        onDrawCusMagnifier(canvas);
    }

    protected void onDrawCusMagnifier(android.graphics.Canvas canvas) {
        float width;
        com.up366.view.crop.AutoCropImageView.DragPointType pointType = getPointType(this.mDraggingPoint);
        if (pointType == null || com.up366.view.crop.AutoCropImageView.DragPointType.isEdgePoint(pointType) || !this.mShowMagnifier || this.mDraggingPoint == null) {
            return;
        }
        if (this.mMagnifierDrawable == null) {
            initMagnifier();
        }
        float viewPointX = getViewPointX(this.mDraggingPoint);
        float viewPointY = getViewPointY(this.mDraggingPoint);
        float width2 = getWidth() / 7;
        int iDp2px = (int) dp2px(1.0f);
        if (this.mDraggingPoint.x >= 0 && this.mDraggingPoint.x < getDrawable().getIntrinsicWidth() / 2) {
            int i = ((int) width2) * 2;
            this.mMagnifierDrawable.setBounds((getWidth() - i) + iDp2px, iDp2px, getWidth() - iDp2px, i - iDp2px);
            width = getWidth() - width2;
        } else {
            int i2 = (((int) width2) * 2) - iDp2px;
            this.mMagnifierDrawable.setBounds(iDp2px, iDp2px, i2, i2);
            width = width2;
        }
        android.graphics.Matrix matrix = this.mMagnifierMatrix;
        float f = this.mMagnifierScale;
        matrix.setTranslate(width2 - (viewPointX * f), width2 - (viewPointY * f));
        this.mMagnifierDrawable.getPaint().getShader().setLocalMatrix(this.mMagnifierMatrix);
        this.mMagnifierDrawable.draw(canvas);
        if (pointType == com.up366.view.crop.AutoCropImageView.DragPointType.LEFT_TOP) {
            android.graphics.Point[] pointArr = this.mCropPoints;
            float f2 = width;
            android.graphics.Point pointLinePointCircle = linePointCircle(pointArr[0], pointArr[3], f2, width2, width2);
            android.graphics.Point[] pointArr2 = this.mCropPoints;
            android.graphics.Point pointLinePointCircle2 = linePointCircle(pointArr2[0], pointArr2[1], f2, width2, width2);
            float f3 = width;
            canvas.drawLine(f3, width2, pointLinePointCircle.x, pointLinePointCircle.y, this.mLinePaint);
            canvas.drawLine(f3, width2, pointLinePointCircle2.x, pointLinePointCircle2.y, this.mLinePaint);
        }
        if (pointType == com.up366.view.crop.AutoCropImageView.DragPointType.RIGHT_TOP) {
            android.graphics.Point[] pointArr3 = this.mCropPoints;
            float f4 = width;
            android.graphics.Point pointLinePointCircle3 = linePointCircle(pointArr3[1], pointArr3[0], f4, width2, width2);
            android.graphics.Point[] pointArr4 = this.mCropPoints;
            android.graphics.Point pointLinePointCircle4 = linePointCircle(pointArr4[1], pointArr4[2], f4, width2, width2);
            float f5 = width;
            canvas.drawLine(f5, width2, pointLinePointCircle3.x, pointLinePointCircle3.y, this.mLinePaint);
            canvas.drawLine(f5, width2, pointLinePointCircle4.x, pointLinePointCircle4.y, this.mLinePaint);
        }
        if (pointType == com.up366.view.crop.AutoCropImageView.DragPointType.RIGHT_BOTTOM) {
            android.graphics.Point[] pointArr5 = this.mCropPoints;
            android.graphics.Point pointLinePointCircle5 = linePointCircle(pointArr5[2], pointArr5[1], width, width2, width2);
            android.graphics.Point[] pointArr6 = this.mCropPoints;
            android.graphics.Point pointLinePointCircle6 = linePointCircle(pointArr6[2], pointArr6[3], width, width2, width2);
            float f6 = width;
            canvas.drawLine(f6, width2, pointLinePointCircle5.x, pointLinePointCircle5.y, this.mLinePaint);
            canvas.drawLine(f6, width2, pointLinePointCircle6.x, pointLinePointCircle6.y, this.mLinePaint);
        }
        if (pointType == com.up366.view.crop.AutoCropImageView.DragPointType.LEFT_BOTTOM) {
            android.graphics.Point[] pointArr7 = this.mCropPoints;
            float f7 = width;
            android.graphics.Point pointLinePointCircle7 = linePointCircle(pointArr7[3], pointArr7[0], f7, width2, width2);
            android.graphics.Point[] pointArr8 = this.mCropPoints;
            android.graphics.Point pointLinePointCircle8 = linePointCircle(pointArr8[3], pointArr8[2], f7, width2, width2);
            float f8 = width;
            canvas.drawLine(f8, width2, pointLinePointCircle7.x, pointLinePointCircle7.y, this.mLinePaint);
            canvas.drawLine(f8, width2, pointLinePointCircle8.x, pointLinePointCircle8.y, this.mLinePaint);
        }
        canvas.drawCircle(width, width2, width2 - (this.mMagnifierPaint.getStrokeWidth() / 2.0f), this.mMagnifierPaint);
        canvas.drawCircle(width, width2, dp2px(POINT_RADIUS), this.mPointFillPaint);
        canvas.drawCircle(width, width2, dp2px(POINT_RADIUS), this.mPointPaint);
    }

    private android.graphics.Point linePointCircle(android.graphics.Point point, android.graphics.Point point2, float f, float f2, float f3) {
        float f4 = point.x - f;
        float f5 = point2.x - f4;
        float f6 = point2.y - (point.y - f3);
        double pointsDistance = ((double) f3) / getPointsDistance(f, f2, f5, f6);
        return new android.graphics.Point((int) (((double) f) - (((double) (f - f5)) * pointsDistance)), (int) (((double) f2) + (((double) (f6 - f2)) * pointsDistance)));
    }

    protected void onDrawMagnifier(android.graphics.Canvas canvas) {
        float width;
        if (!this.mShowMagnifier || this.mDraggingPoint == null) {
            return;
        }
        if (this.mMagnifierDrawable == null) {
            initMagnifier();
        }
        float viewPointX = getViewPointX(this.mDraggingPoint);
        float viewPointY = getViewPointY(this.mDraggingPoint);
        float width2 = getWidth() / 8;
        int iDp2px = (int) dp2px(1.0f);
        int i = ((int) width2) * 2;
        int i2 = i - iDp2px;
        this.mMagnifierDrawable.setBounds(iDp2px, iDp2px, i2, i2);
        if (getPointsDistance(viewPointX, viewPointY, 0.0f, 0.0f) < ((double) width2) * 2.5d) {
            this.mMagnifierDrawable.setBounds((getWidth() - i) + iDp2px, iDp2px, getWidth() - iDp2px, i2);
            width = getWidth() - width2;
        } else {
            width = width2;
        }
        canvas.drawCircle(width, width2, width2, this.mMagnifierPaint);
        this.mMagnifierMatrix.setTranslate(width2 - viewPointX, width2 - viewPointY);
        this.mMagnifierDrawable.getPaint().getShader().setLocalMatrix(this.mMagnifierMatrix);
        this.mMagnifierDrawable.draw(canvas);
        float fDp2px = dp2px(MAGNIFIER_CROSS_LINE_LENGTH);
        canvas.drawLine(width, width2 - fDp2px, width, width2 + fDp2px, this.mMagnifierCrossPaint);
        canvas.drawLine(width - fDp2px, width2, width + fDp2px, width2, this.mMagnifierCrossPaint);
    }

    protected void onDrawGuideLine(android.graphics.Canvas canvas) {
        if (this.mShowGuideLine) {
            int i = this.mActWidth / 3;
            int i2 = this.mActHeight / 3;
            int i3 = this.mActLeft;
            canvas.drawLine(i3 + i, this.mActTop, i3 + i, r4 + r1, this.mGuideLinePaint);
            int i4 = this.mActLeft;
            int i5 = i * 2;
            canvas.drawLine(i4 + i5, this.mActTop, i4 + i5, r3 + this.mActHeight, this.mGuideLinePaint);
            int i6 = this.mActLeft;
            int i7 = this.mActTop;
            canvas.drawLine(i6, i7 + i2, i6 + this.mActWidth, i7 + i2, this.mGuideLinePaint);
            int i8 = this.mActLeft;
            int i9 = this.mActTop;
            int i10 = i2 * 2;
            canvas.drawLine(i8, i9 + i10, i8 + this.mActWidth, i9 + i10, this.mGuideLinePaint);
        }
    }

    protected void onDrawMask(android.graphics.Canvas canvas) {
        android.graphics.Path pathResetPointPath;
        if (this.mMaskAlpha > 0 && (pathResetPointPath = resetPointPath()) != null) {
            int iSaveLayer = canvas.saveLayer(this.mActLeft, this.mActTop, r1 + this.mActWidth, r2 + this.mActHeight, this.mMaskPaint, 31);
            this.mMaskPaint.setAlpha(this.mMaskAlpha);
            canvas.drawRect(this.mActLeft, this.mActTop, r2 + this.mActWidth, r3 + this.mActHeight, this.mMaskPaint);
            this.mMaskPaint.setXfermode(this.mMaskXfermode);
            this.mMaskPaint.setAlpha(255);
            canvas.drawPath(pathResetPointPath, this.mMaskPaint);
            this.mMaskPaint.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
        }
    }

    private android.graphics.Path resetPointPath() {
        if (!checkPoints(this.mCropPoints)) {
            return null;
        }
        this.mPointLinePath.reset();
        android.graphics.Point[] pointArr = this.mCropPoints;
        android.graphics.Point point = pointArr[0];
        android.graphics.Point point2 = pointArr[1];
        android.graphics.Point point3 = pointArr[2];
        android.graphics.Point point4 = pointArr[3];
        this.mPointLinePath.moveTo(getViewPointX(point), getViewPointY(point));
        this.mPointLinePath.lineTo(getViewPointX(point2), getViewPointY(point2));
        this.mPointLinePath.lineTo(getViewPointX(point3), getViewPointY(point3));
        this.mPointLinePath.lineTo(getViewPointX(point4), getViewPointY(point4));
        this.mPointLinePath.close();
        return this.mPointLinePath;
    }

    private void getDrawablePosition() {
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable != null) {
            getImageMatrix().getValues(this.mMatrixValue);
            float[] fArr = this.mMatrixValue;
            this.mScaleX = fArr[0];
            this.mScaleY = fArr[4];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.mActWidth = java.lang.Math.round(intrinsicWidth * this.mScaleX);
            this.mActHeight = java.lang.Math.round(intrinsicHeight * this.mScaleY);
            this.mActLeft = (getWidth() - this.mActWidth) / 2;
            this.mActTop = (getHeight() - this.mActHeight) / 2;
        }
    }

    protected void onDrawLines(android.graphics.Canvas canvas) {
        android.graphics.Path pathResetPointPath = resetPointPath();
        if (pathResetPointPath != null) {
            canvas.drawPath(pathResetPointPath, this.mLinePaint);
        }
    }

    protected void onDrawPoints(android.graphics.Canvas canvas) {
        if (checkPoints(this.mCropPoints)) {
            for (android.graphics.Point point : this.mCropPoints) {
                canvas.drawCircle(getViewPointX(point), getViewPointY(point), dp2px(POINT_RADIUS), this.mPointFillPaint);
                canvas.drawCircle(getViewPointX(point), getViewPointY(point), dp2px(POINT_RADIUS), this.mPointPaint);
            }
            if (this.mShowEdgeMidPoint) {
                setEdgeMidPoints();
                for (android.graphics.Point point2 : this.mEdgeMidPoints) {
                    canvas.drawCircle(getViewPointX(point2), getViewPointY(point2), dp2px(POINT_RADIUS), this.mPointFillPaint);
                    canvas.drawCircle(getViewPointX(point2), getViewPointY(point2), dp2px(POINT_RADIUS), this.mPointPaint);
                }
            }
        }
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        if (action == 0) {
            android.graphics.Point nearbyPoint = getNearbyPoint(motionEvent);
            this.mDraggingPoint = nearbyPoint;
            if (nearbyPoint == null) {
                z = false;
            }
            invalidate();
            return !z || super.onTouchEvent(motionEvent);
        }
        if (action == 1) {
            this.mDraggingPoint = null;
        } else if (action == 2) {
            toImagePointSize(this.mDraggingPoint, motionEvent);
        }
        z = true;
        invalidate();
        if (z) {
        }
    }

    private android.graphics.Point getNearbyPoint(android.view.MotionEvent motionEvent) {
        if (checkPoints(this.mCropPoints)) {
            for (android.graphics.Point point : this.mCropPoints) {
                if (isTouchPoint(point, motionEvent)) {
                    return point;
                }
            }
        }
        if (!checkPoints(this.mEdgeMidPoints)) {
            return null;
        }
        for (android.graphics.Point point2 : this.mEdgeMidPoints) {
            if (isTouchPoint(point2, motionEvent)) {
                return point2;
            }
        }
        return null;
    }

    private boolean isTouchPoint(android.graphics.Point point, android.view.MotionEvent motionEvent) {
        return java.lang.Math.sqrt(java.lang.Math.pow((double) (motionEvent.getX() - getViewPointX(point)), 2.0d) + java.lang.Math.pow((double) (motionEvent.getY() - getViewPointY(point)), 2.0d)) < ((double) dp2px(TOUCH_POINT_CATCH_DISTANCE));
    }

    private void toImagePointSize(android.graphics.Point point, android.view.MotionEvent motionEvent) {
        if (point == null) {
            return;
        }
        com.up366.view.crop.AutoCropImageView.DragPointType pointType = getPointType(point);
        int iMin = (int) ((java.lang.Math.min(java.lang.Math.max(motionEvent.getX(), this.mActLeft), this.mActLeft + this.mActWidth) - this.mActLeft) / this.mScaleX);
        int iMin2 = (int) ((java.lang.Math.min(java.lang.Math.max(motionEvent.getY(), this.mActTop), this.mActTop + this.mActHeight) - this.mActTop) / this.mScaleY);
        if (this.mDragLimit && pointType != null) {
            switch (com.up366.view.crop.AutoCropImageView.AnonymousClass1.$SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[pointType.ordinal()]) {
                case 1:
                    if (!canMoveLeftTop(iMin, iMin2)) {
                        return;
                    }
                    break;
                case 2:
                    if (!canMoveRightTop(iMin, iMin2)) {
                        return;
                    }
                    break;
                case 3:
                    if (!canMoveRightBottom(iMin, iMin2)) {
                        return;
                    }
                    break;
                case 4:
                    if (!canMoveLeftBottom(iMin, iMin2)) {
                        return;
                    }
                    break;
                case 5:
                    if (!canMoveLeftTop(iMin, iMin2) || !canMoveRightTop(iMin, iMin2)) {
                        return;
                    }
                    break;
                case 6:
                    if (!canMoveRightTop(iMin, iMin2) || !canMoveRightBottom(iMin, iMin2)) {
                        return;
                    }
                    break;
                case 7:
                    if (!canMoveLeftBottom(iMin, iMin2) || !canMoveRightBottom(iMin, iMin2)) {
                        return;
                    }
                    break;
                case 8:
                    if (!canMoveLeftBottom(iMin, iMin2) || !canMoveLeftTop(iMin, iMin2)) {
                        return;
                    }
                    break;
            }
        }
        if (com.up366.view.crop.AutoCropImageView.DragPointType.isEdgePoint(pointType)) {
            moveEdge(pointType, iMin - point.x, iMin2 - point.y);
        } else {
            point.y = iMin2;
            point.x = iMin;
        }
    }

    /* JADX INFO: renamed from: com.up366.view.crop.AutoCropImageView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType;

        static {
            int[] iArr = new int[com.up366.view.crop.AutoCropImageView.DragPointType.values().length];
            $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType = iArr;
            try {
                iArr[com.up366.view.crop.AutoCropImageView.DragPointType.LEFT_TOP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[com.up366.view.crop.AutoCropImageView.DragPointType.RIGHT_TOP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[com.up366.view.crop.AutoCropImageView.DragPointType.RIGHT_BOTTOM.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[com.up366.view.crop.AutoCropImageView.DragPointType.LEFT_BOTTOM.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[com.up366.view.crop.AutoCropImageView.DragPointType.TOP.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[com.up366.view.crop.AutoCropImageView.DragPointType.RIGHT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[com.up366.view.crop.AutoCropImageView.DragPointType.BOTTOM.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[com.up366.view.crop.AutoCropImageView.DragPointType.LEFT.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    private void moveEdge(com.up366.view.crop.AutoCropImageView.DragPointType dragPointType, int i, int i2) {
        int i3 = com.up366.view.crop.AutoCropImageView.AnonymousClass1.$SwitchMap$com$up366$view$crop$AutoCropImageView$DragPointType[dragPointType.ordinal()];
        if (i3 == 5) {
            movePoint(this.mCropPoints[0], 0, i2);
            movePoint(this.mCropPoints[1], 0, i2);
            return;
        }
        if (i3 == 6) {
            movePoint(this.mCropPoints[1], i, 0);
            movePoint(this.mCropPoints[2], i, 0);
        } else if (i3 == 7) {
            movePoint(this.mCropPoints[3], 0, i2);
            movePoint(this.mCropPoints[2], 0, i2);
        } else {
            if (i3 != 8) {
                return;
            }
            movePoint(this.mCropPoints[0], i, 0);
            movePoint(this.mCropPoints[3], i, 0);
        }
    }

    private void movePoint(android.graphics.Point point, int i, int i2) {
        if (point == null) {
            return;
        }
        int i3 = point.x + i;
        int i4 = point.y + i2;
        if (i3 < 0 || i3 > getDrawable().getIntrinsicWidth() || i4 < 0 || i4 > getDrawable().getIntrinsicHeight()) {
            return;
        }
        point.x = i3;
        point.y = i4;
    }

    private boolean canMoveLeftTop(int i, int i2) {
        android.graphics.Point[] pointArr = this.mCropPoints;
        long jPointSideLine = pointSideLine(pointArr[1], pointArr[3], i, i2);
        android.graphics.Point[] pointArr2 = this.mCropPoints;
        if (jPointSideLine * pointSideLine(pointArr2[1], pointArr2[3], pointArr2[2]) > 0) {
            return false;
        }
        android.graphics.Point[] pointArr3 = this.mCropPoints;
        long jPointSideLine2 = pointSideLine(pointArr3[1], pointArr3[2], i, i2);
        android.graphics.Point[] pointArr4 = this.mCropPoints;
        if (jPointSideLine2 * pointSideLine(pointArr4[1], pointArr4[2], pointArr4[3]) < 0) {
            return false;
        }
        android.graphics.Point[] pointArr5 = this.mCropPoints;
        long jPointSideLine3 = pointSideLine(pointArr5[3], pointArr5[2], i, i2);
        android.graphics.Point[] pointArr6 = this.mCropPoints;
        if (jPointSideLine3 * pointSideLine(pointArr6[3], pointArr6[2], pointArr6[1]) < 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        return getPointsDistance(this.mCropPoints[1], f, f2) >= ((double) this.mPointMinDistance) && getPointsDistance(this.mCropPoints[3], f, f2) >= ((double) this.mPointMinDistance);
    }

    private boolean canMoveRightTop(int i, int i2) {
        android.graphics.Point[] pointArr = this.mCropPoints;
        long jPointSideLine = pointSideLine(pointArr[0], pointArr[2], i, i2);
        android.graphics.Point[] pointArr2 = this.mCropPoints;
        if (jPointSideLine * pointSideLine(pointArr2[0], pointArr2[2], pointArr2[3]) > 0) {
            return false;
        }
        android.graphics.Point[] pointArr3 = this.mCropPoints;
        long jPointSideLine2 = pointSideLine(pointArr3[0], pointArr3[3], i, i2);
        android.graphics.Point[] pointArr4 = this.mCropPoints;
        if (jPointSideLine2 * pointSideLine(pointArr4[0], pointArr4[3], pointArr4[2]) < 0) {
            return false;
        }
        android.graphics.Point[] pointArr5 = this.mCropPoints;
        long jPointSideLine3 = pointSideLine(pointArr5[3], pointArr5[2], i, i2);
        android.graphics.Point[] pointArr6 = this.mCropPoints;
        if (jPointSideLine3 * pointSideLine(pointArr6[3], pointArr6[2], pointArr6[0]) < 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        return getPointsDistance(this.mCropPoints[0], f, f2) >= ((double) this.mPointMinDistance) && getPointsDistance(this.mCropPoints[2], f, f2) >= ((double) this.mPointMinDistance);
    }

    private boolean canMoveRightBottom(int i, int i2) {
        android.graphics.Point[] pointArr = this.mCropPoints;
        long jPointSideLine = pointSideLine(pointArr[1], pointArr[3], i, i2);
        android.graphics.Point[] pointArr2 = this.mCropPoints;
        if (jPointSideLine * pointSideLine(pointArr2[1], pointArr2[3], pointArr2[0]) > 0) {
            return false;
        }
        android.graphics.Point[] pointArr3 = this.mCropPoints;
        long jPointSideLine2 = pointSideLine(pointArr3[0], pointArr3[1], i, i2);
        android.graphics.Point[] pointArr4 = this.mCropPoints;
        if (jPointSideLine2 * pointSideLine(pointArr4[0], pointArr4[1], pointArr4[3]) < 0) {
            return false;
        }
        android.graphics.Point[] pointArr5 = this.mCropPoints;
        long jPointSideLine3 = pointSideLine(pointArr5[0], pointArr5[3], i, i2);
        android.graphics.Point[] pointArr6 = this.mCropPoints;
        if (jPointSideLine3 * pointSideLine(pointArr6[0], pointArr6[3], pointArr6[1]) < 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        return getPointsDistance(this.mCropPoints[1], f, f2) >= ((double) this.mPointMinDistance) && getPointsDistance(this.mCropPoints[3], f, f2) >= ((double) this.mPointMinDistance);
    }

    private boolean canMoveLeftBottom(int i, int i2) {
        android.graphics.Point[] pointArr = this.mCropPoints;
        long jPointSideLine = pointSideLine(pointArr[0], pointArr[2], i, i2);
        android.graphics.Point[] pointArr2 = this.mCropPoints;
        if (jPointSideLine * pointSideLine(pointArr2[0], pointArr2[2], pointArr2[1]) > 0) {
            return false;
        }
        android.graphics.Point[] pointArr3 = this.mCropPoints;
        long jPointSideLine2 = pointSideLine(pointArr3[0], pointArr3[1], i, i2);
        android.graphics.Point[] pointArr4 = this.mCropPoints;
        if (jPointSideLine2 * pointSideLine(pointArr4[0], pointArr4[1], pointArr4[2]) < 0) {
            return false;
        }
        android.graphics.Point[] pointArr5 = this.mCropPoints;
        long jPointSideLine3 = pointSideLine(pointArr5[1], pointArr5[2], i, i2);
        android.graphics.Point[] pointArr6 = this.mCropPoints;
        if (jPointSideLine3 * pointSideLine(pointArr6[1], pointArr6[2], pointArr6[0]) < 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        return getPointsDistance(this.mCropPoints[0], f, f2) >= ((double) this.mPointMinDistance) && getPointsDistance(this.mCropPoints[2], f, f2) >= ((double) this.mPointMinDistance);
    }

    private com.up366.view.crop.AutoCropImageView.DragPointType getPointType(android.graphics.Point point) {
        if (point == null) {
            return null;
        }
        int i = 0;
        if (checkPoints(this.mCropPoints)) {
            int i2 = 0;
            while (true) {
                android.graphics.Point[] pointArr = this.mCropPoints;
                if (i2 >= pointArr.length) {
                    break;
                }
                if (point == pointArr[i2]) {
                    return com.up366.view.crop.AutoCropImageView.DragPointType.values()[i2];
                }
                i2++;
            }
        }
        if (checkPoints(this.mEdgeMidPoints)) {
            while (true) {
                android.graphics.Point[] pointArr2 = this.mEdgeMidPoints;
                if (i >= pointArr2.length) {
                    break;
                }
                if (point == pointArr2[i]) {
                    return com.up366.view.crop.AutoCropImageView.DragPointType.values()[i + 4];
                }
                i++;
            }
        }
        return null;
    }

    public float getmMagnifierScale() {
        return this.mMagnifierScale;
    }

    public void setmMagnifierScale(float f) {
        this.mMagnifierScale = f;
        initMagnifier();
        postInvalidate();
    }

    private float getViewPointX(android.graphics.Point point) {
        return getViewPointX(point.x);
    }

    private float getViewPointX(float f) {
        return (f * this.mScaleX) + this.mActLeft;
    }

    private float getViewPointY(android.graphics.Point point) {
        return getViewPointY(point.y);
    }

    private float getViewPointY(float f) {
        return (f * this.mScaleY) + this.mActTop;
    }

    private float dp2px(float f) {
        return f * this.mDensity;
    }

    public double getPointsDistance(android.graphics.Point point, float f, float f2) {
        return getPointsDistance(point.x, point.y, f, f2);
    }

    public double getPointsDistance(android.graphics.Point point, android.graphics.Point point2) {
        return getPointsDistance(point.x, point.y, point2.x, point2.y);
    }

    public double getPointsDistance(float f, float f2, float f3, float f4) {
        return java.lang.Math.sqrt(java.lang.Math.pow(f - f3, 2.0d) + java.lang.Math.pow(f2 - f4, 2.0d));
    }

    private android.graphics.Point[] getFullImgCropPoints() {
        return getFullImgCropPoints(this.mCropRectInitRatio);
    }

    public android.graphics.Point[] getFullImgCropPoints(float f) {
        android.graphics.Point[] pointArr = new android.graphics.Point[4];
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null) {
            return pointArr;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float fSqrt = (1.0f - ((float) java.lang.Math.sqrt(java.lang.Math.max(0.1f, java.lang.Math.min(f, 1.0f))))) / 2.0f;
        int iRound = java.lang.Math.round(intrinsicWidth * fSqrt);
        int iRound2 = java.lang.Math.round(intrinsicHeight * fSqrt);
        pointArr[0] = new android.graphics.Point(iRound, iRound2);
        int i = intrinsicWidth - iRound;
        pointArr[1] = new android.graphics.Point(i, iRound2);
        int i2 = intrinsicHeight - iRound2;
        pointArr[2] = new android.graphics.Point(i, i2);
        pointArr[3] = new android.graphics.Point(iRound, i2);
        return pointArr;
    }
}
