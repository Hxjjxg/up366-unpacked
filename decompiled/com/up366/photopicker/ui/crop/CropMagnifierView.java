package com.up366.photopicker.ui.crop;

/* JADX INFO: compiled from: CropMagnifierView.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J \u00101\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0019H\u0002J\u0018\u00104\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u0019H\u0002J\u0010\u00108\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0014J)\u00109\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0011J \u0010>\u001a\u00020.2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0011R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/up366/photopicker/ui/crop/CropMagnifierView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bitmap", "Landroid/graphics/Bitmap;", "bitmapBounds", "Landroid/graphics/RectF;", "bitmapPaint", "Landroid/graphics/Paint;", "borderPaint", "borderWidth", "", "circleRadius", "clipPath", "Landroid/graphics/Path;", "contentPadding", "contentRect", "corners", "", "Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "cropHandlePaint", "cropLinePaint", "cropRect", "desiredSrcRectF", "destRectF", "draggingType", "focusPoint", "frameRect", "handleRadius", "imageRect", "overlayPath", "quadCornerGuideLength", "scaleFactor", "shadowPaint", "srcRect", "Landroid/graphics/Rect;", "visibleSrcRectF", "zoomFactor", "drawCropOverlay", "", "canvas", "Landroid/graphics/Canvas;", "drawGuideSegment", "start", "end", "drawQuadCornerGuide", com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, "mapPointToMagnifier", "point", "onDraw", "updateCropOverlay", "(Landroid/graphics/RectF;[Landroid/graphics/PointF;I)V", "updateFocusPoint", "x", "y", "updateSource", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CropMagnifierView extends android.view.View {
    private android.graphics.Bitmap bitmap;
    private final android.graphics.RectF bitmapBounds;
    private final android.graphics.Paint bitmapPaint;
    private final android.graphics.Paint borderPaint;
    private final float borderWidth;
    private float circleRadius;
    private final android.graphics.Path clipPath;
    private final float contentPadding;
    private final android.graphics.RectF contentRect;
    private android.graphics.PointF[] corners;
    private final android.graphics.Paint cropHandlePaint;
    private final android.graphics.Paint cropLinePaint;
    private final android.graphics.RectF cropRect;
    private final android.graphics.RectF desiredSrcRectF;
    private final android.graphics.RectF destRectF;
    private int draggingType;
    private android.graphics.PointF focusPoint;
    private final android.graphics.RectF frameRect;
    private final float handleRadius;
    private final android.graphics.RectF imageRect;
    private final android.graphics.Path overlayPath;
    private final float quadCornerGuideLength;
    private float scaleFactor;
    private final android.graphics.Paint shadowPaint;
    private final android.graphics.Rect srcRect;
    private final android.graphics.RectF visibleSrcRectF;
    private final float zoomFactor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropMagnifierView(android.content.Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropMagnifierView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CropMagnifierView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropMagnifierView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.quadCornerGuideLength = com.up366.photopicker.ui.crop.CropMagnifierViewKt.dpToPx(10.0f, context);
        this.handleRadius = com.up366.photopicker.ui.crop.CropMagnifierViewKt.dpToPx(4.0f, context);
        this.frameRect = new android.graphics.RectF();
        this.contentRect = new android.graphics.RectF();
        this.srcRect = new android.graphics.Rect();
        this.desiredSrcRectF = new android.graphics.RectF();
        this.visibleSrcRectF = new android.graphics.RectF();
        this.destRectF = new android.graphics.RectF();
        this.bitmapBounds = new android.graphics.RectF();
        this.clipPath = new android.graphics.Path();
        this.overlayPath = new android.graphics.Path();
        this.imageRect = new android.graphics.RectF();
        this.cropRect = new android.graphics.RectF();
        android.graphics.PointF[] pointFArr = new android.graphics.PointF[4];
        for (int i2 = 0; i2 < 4; i2++) {
            pointFArr[i2] = new android.graphics.PointF();
        }
        this.corners = pointFArr;
        this.scaleFactor = 1.0f;
        float fDpToPx = com.up366.photopicker.ui.crop.CropMagnifierViewKt.dpToPx(2.0f, context);
        this.borderWidth = fDpToPx;
        this.contentPadding = com.up366.photopicker.ui.crop.CropMagnifierViewKt.dpToPx(5.0f, context);
        this.zoomFactor = 2.4f;
        android.graphics.Paint paint = new android.graphics.Paint(1);
        paint.setColor(android.graphics.Color.parseColor("#33000000"));
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setShadowLayer(com.up366.photopicker.ui.crop.CropMagnifierViewKt.dpToPx(12.0f, context), 0.0f, com.up366.photopicker.ui.crop.CropMagnifierViewKt.dpToPx(4.0f, context), paint.getColor());
        this.shadowPaint = paint;
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        paint2.setStrokeWidth(fDpToPx);
        this.borderPaint = paint2;
        this.bitmapPaint = new android.graphics.Paint(3);
        android.graphics.Paint paint3 = new android.graphics.Paint(1);
        paint3.setColor(-1);
        paint3.setStyle(android.graphics.Paint.Style.STROKE);
        paint3.setStrokeWidth(com.up366.photopicker.ui.crop.CropMagnifierViewKt.dpToPx(2.0f, context));
        this.cropLinePaint = paint3;
        android.graphics.Paint paint4 = new android.graphics.Paint(1);
        paint4.setColor(-1);
        paint4.setStyle(android.graphics.Paint.Style.FILL);
        this.cropHandlePaint = paint4;
        setLayerType(1, null);
    }

    public final void updateSource(android.graphics.Bitmap bitmap, android.graphics.RectF imageRect, float scaleFactor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRect, "imageRect");
        this.bitmap = bitmap;
        this.imageRect.set(imageRect);
        this.scaleFactor = scaleFactor;
        invalidate();
    }

    public final void updateFocusPoint(float x, float y) {
        this.focusPoint = new android.graphics.PointF(x, y);
        invalidate();
    }

    public final void updateCropOverlay(android.graphics.RectF cropRect, android.graphics.PointF[] corners, int draggingType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropRect, "cropRect");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(corners, "corners");
        this.cropRect.set(cropRect);
        this.draggingType = draggingType;
        int length = corners.length;
        android.graphics.PointF[] pointFArr = new android.graphics.PointF[length];
        for (int i = 0; i < length; i++) {
            pointFArr[i] = new android.graphics.PointF(corners[i].x, corners[i].y);
        }
        this.corners = pointFArr;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.PointF pointF;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        android.graphics.Bitmap bitmap = this.bitmap;
        if (bitmap == null || (pointF = this.focusPoint) == null || this.imageRect.isEmpty() || this.scaleFactor <= 0.0f) {
            return;
        }
        this.bitmapBounds.set(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        this.frameRect.set(0.0f, 0.0f, getWidth(), getHeight());
        android.graphics.RectF rectF = this.contentRect;
        float f = this.contentPadding;
        rectF.set(f, f, getWidth() - this.contentPadding, getHeight() - this.contentPadding);
        this.circleRadius = java.lang.Math.min(this.contentRect.width(), this.contentRect.height()) / 2.0f;
        this.clipPath.reset();
        this.clipPath.addCircle(this.contentRect.centerX(), this.contentRect.centerY(), this.circleRadius, android.graphics.Path.Direction.CW);
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn((pointF.x - this.imageRect.left) / this.scaleFactor, 0.0f, bitmap.getWidth());
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn((pointF.y - this.imageRect.top) / this.scaleFactor, 0.0f, bitmap.getHeight());
        float fCoerceIn3 = kotlin.ranges.RangesKt.coerceIn(this.contentRect.width() / (this.scaleFactor * this.zoomFactor), 1.0f, bitmap.getWidth()) / 2.0f;
        float fCoerceIn4 = kotlin.ranges.RangesKt.coerceIn(this.contentRect.height() / (this.scaleFactor * this.zoomFactor), 1.0f, bitmap.getHeight()) / 2.0f;
        this.desiredSrcRectF.set(fCoerceIn - fCoerceIn3, fCoerceIn2 - fCoerceIn4, fCoerceIn + fCoerceIn3, fCoerceIn2 + fCoerceIn4);
        this.visibleSrcRectF.set(this.desiredSrcRectF);
        boolean zIntersect = this.visibleSrcRectF.intersect(this.bitmapBounds);
        if (zIntersect) {
            this.srcRect.set((int) this.visibleSrcRectF.left, (int) this.visibleSrcRectF.top, (int) this.visibleSrcRectF.right, (int) this.visibleSrcRectF.bottom);
            this.destRectF.set(this.contentRect.left + (((this.visibleSrcRectF.left - this.desiredSrcRectF.left) / this.desiredSrcRectF.width()) * this.contentRect.width()), this.contentRect.top + (((this.visibleSrcRectF.top - this.desiredSrcRectF.top) / this.desiredSrcRectF.height()) * this.contentRect.height()), this.contentRect.left + (((this.visibleSrcRectF.right - this.desiredSrcRectF.left) / this.desiredSrcRectF.width()) * this.contentRect.width()), this.contentRect.top + (((this.visibleSrcRectF.bottom - this.desiredSrcRectF.top) / this.desiredSrcRectF.height()) * this.contentRect.height()));
        }
        canvas.drawCircle(this.contentRect.centerX(), this.contentRect.centerY(), this.circleRadius, this.shadowPaint);
        canvas.save();
        canvas.clipPath(this.clipPath);
        canvas.drawColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        if (zIntersect) {
            canvas.drawBitmap(bitmap, this.srcRect, this.destRectF, this.bitmapPaint);
        }
        drawCropOverlay(canvas);
        canvas.restore();
        canvas.drawCircle(this.contentRect.centerX(), this.contentRect.centerY(), this.circleRadius, this.borderPaint);
    }

    private final void drawCropOverlay(android.graphics.Canvas canvas) {
        if (this.cropRect.isEmpty()) {
            return;
        }
        if (this.draggingType == 1) {
            this.overlayPath.reset();
            android.graphics.PointF[] pointFArr = this.corners;
            int length = pointFArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                android.graphics.PointF pointFMapPointToMagnifier = mapPointToMagnifier(pointFArr[i]);
                if (i2 == 0) {
                    this.overlayPath.moveTo(pointFMapPointToMagnifier.x, pointFMapPointToMagnifier.y);
                } else {
                    this.overlayPath.lineTo(pointFMapPointToMagnifier.x, pointFMapPointToMagnifier.y);
                }
                drawQuadCornerGuide(canvas, i2);
                canvas.drawCircle(pointFMapPointToMagnifier.x, pointFMapPointToMagnifier.y, this.handleRadius, this.cropHandlePaint);
                i++;
                i2 = i3;
            }
            this.overlayPath.close();
            canvas.drawPath(this.overlayPath, this.cropLinePaint);
            return;
        }
        android.graphics.PointF pointFMapPointToMagnifier2 = mapPointToMagnifier(new android.graphics.PointF(this.cropRect.left, this.cropRect.top));
        android.graphics.PointF pointFMapPointToMagnifier3 = mapPointToMagnifier(new android.graphics.PointF(this.cropRect.right, this.cropRect.top));
        android.graphics.PointF pointFMapPointToMagnifier4 = mapPointToMagnifier(new android.graphics.PointF(this.cropRect.right, this.cropRect.bottom));
        android.graphics.PointF pointFMapPointToMagnifier5 = mapPointToMagnifier(new android.graphics.PointF(this.cropRect.left, this.cropRect.bottom));
        this.overlayPath.reset();
        this.overlayPath.moveTo(pointFMapPointToMagnifier2.x, pointFMapPointToMagnifier2.y);
        this.overlayPath.lineTo(pointFMapPointToMagnifier3.x, pointFMapPointToMagnifier3.y);
        this.overlayPath.lineTo(pointFMapPointToMagnifier4.x, pointFMapPointToMagnifier4.y);
        this.overlayPath.lineTo(pointFMapPointToMagnifier5.x, pointFMapPointToMagnifier5.y);
        this.overlayPath.close();
        canvas.drawPath(this.overlayPath, this.cropLinePaint);
        canvas.drawCircle(pointFMapPointToMagnifier2.x, pointFMapPointToMagnifier2.y, this.handleRadius, this.cropHandlePaint);
        canvas.drawCircle(pointFMapPointToMagnifier3.x, pointFMapPointToMagnifier3.y, this.handleRadius, this.cropHandlePaint);
        canvas.drawCircle(pointFMapPointToMagnifier5.x, pointFMapPointToMagnifier5.y, this.handleRadius, this.cropHandlePaint);
        canvas.drawCircle(pointFMapPointToMagnifier4.x, pointFMapPointToMagnifier4.y, this.handleRadius, this.cropHandlePaint);
    }

    private final void drawQuadCornerGuide(android.graphics.Canvas canvas, int index) {
        android.graphics.PointF pointFMapPointToMagnifier = mapPointToMagnifier(this.corners[index]);
        android.graphics.PointF[] pointFArr = this.corners;
        android.graphics.PointF pointFMapPointToMagnifier2 = mapPointToMagnifier(pointFArr[((pointFArr.length + index) - 1) % pointFArr.length]);
        android.graphics.PointF[] pointFArr2 = this.corners;
        android.graphics.PointF pointFMapPointToMagnifier3 = mapPointToMagnifier(pointFArr2[(index + 1) % pointFArr2.length]);
        drawGuideSegment(canvas, pointFMapPointToMagnifier, pointFMapPointToMagnifier2);
        drawGuideSegment(canvas, pointFMapPointToMagnifier, pointFMapPointToMagnifier3);
    }

    private final void drawGuideSegment(android.graphics.Canvas canvas, android.graphics.PointF start, android.graphics.PointF end) {
        float f = end.x - start.x;
        float f2 = end.y - start.y;
        float fHypot = (float) java.lang.Math.hypot(f, f2);
        if (fHypot <= 0.0f) {
            return;
        }
        float fMin = java.lang.Math.min(this.quadCornerGuideLength, fHypot) / fHypot;
        canvas.drawLine(start.x, start.y, start.x + (f * fMin), start.y + (f2 * fMin), this.cropLinePaint);
    }

    private final android.graphics.PointF mapPointToMagnifier(android.graphics.PointF point) {
        if (this.desiredSrcRectF.isEmpty() || this.scaleFactor <= 0.0f) {
            return new android.graphics.PointF(this.contentRect.centerX(), this.contentRect.centerY());
        }
        float f = (point.x - this.imageRect.left) / this.scaleFactor;
        float f2 = (point.y - this.imageRect.top) / this.scaleFactor;
        return new android.graphics.PointF(this.contentRect.left + (((f - this.desiredSrcRectF.left) / this.desiredSrcRectF.width()) * this.contentRect.width()), this.contentRect.top + (((f2 - this.desiredSrcRectF.top) / this.desiredSrcRectF.height()) * this.contentRect.height()));
    }
}
