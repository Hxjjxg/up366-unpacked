package com.up366.multimediav2.views;

/* JADX INFO: compiled from: BorderGraphic.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0003R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/up366/multimediav2/views/BorderGraphic;", "Lcom/up366/smart/paper/view/GraphicOverlay$Graphic;", "overlay", "Lcom/up366/smart/paper/view/GraphicOverlay;", "points", "", "Lorg/opencv/core/Point;", "allowArea", "", "(Lcom/up366/smart/paper/view/GraphicOverlay;Ljava/util/List;Z)V", "getAllowArea", "()Z", "mPaint", "Landroid/graphics/Paint;", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, "Landroid/graphics/Path;", "getPoints", "()Ljava/util/List;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "translatePoint", "point", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BorderGraphic extends com.up366.smart.paper.view.GraphicOverlay.Graphic {
    private final boolean allowArea;
    private final android.graphics.Paint mPaint;
    private final android.graphics.Path path;
    private final java.util.List<org.opencv.core.Point> points;

    public final boolean getAllowArea() {
        return this.allowArea;
    }

    public final java.util.List<org.opencv.core.Point> getPoints() {
        return this.points;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderGraphic(com.up366.smart.paper.view.GraphicOverlay graphicOverlay, java.util.List<org.opencv.core.Point> list, boolean z) {
        super(graphicOverlay);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(graphicOverlay, "overlay");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "points");
        this.points = list;
        this.allowArea = z;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        this.path = new android.graphics.Path();
        paint.setColor(-65536);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(com.up366.qmui.util.QMUIDisplayHelper.dpToPx(2));
    }

    @Override // com.up366.smart.paper.view.GraphicOverlay.Graphic
    public void draw(android.graphics.Canvas canvas) {
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.points.size() < 4) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= 4) {
                z = true;
                break;
            } else {
                if (this.points.get(i) == null) {
                    z = false;
                    break;
                }
                i++;
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(translatePoint(this.points.get(0)));
        arrayList.add(translatePoint(this.points.get(1)));
        arrayList.add(translatePoint(this.points.get(2)));
        arrayList.add(translatePoint(this.points.get(3)));
        if (z) {
            if (this.allowArea) {
                this.mPaint.setColor(android.graphics.Color.parseColor("#4D01E6B7"));
                this.mPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
                this.path.reset();
                this.path.moveTo((float) ((org.opencv.core.Point) arrayList.get(0)).x, (float) ((org.opencv.core.Point) arrayList.get(0)).y);
                this.path.lineTo((float) ((org.opencv.core.Point) arrayList.get(1)).x, (float) ((org.opencv.core.Point) arrayList.get(1)).y);
                this.path.lineTo((float) ((org.opencv.core.Point) arrayList.get(2)).x, (float) ((org.opencv.core.Point) arrayList.get(2)).y);
                this.path.lineTo((float) ((org.opencv.core.Point) arrayList.get(3)).x, (float) ((org.opencv.core.Point) arrayList.get(3)).y);
                this.path.close();
                canvas.drawPath(this.path, this.mPaint);
                this.mPaint.setColor(android.graphics.Color.parseColor("#01E6B7"));
            } else {
                this.mPaint.setColor(android.graphics.Color.parseColor("#FF7B11"));
            }
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.path.reset();
            this.path.moveTo((float) ((org.opencv.core.Point) arrayList.get(0)).x, (float) ((org.opencv.core.Point) arrayList.get(0)).y);
            this.path.lineTo((float) ((org.opencv.core.Point) arrayList.get(1)).x, (float) ((org.opencv.core.Point) arrayList.get(1)).y);
            this.path.lineTo((float) ((org.opencv.core.Point) arrayList.get(2)).x, (float) ((org.opencv.core.Point) arrayList.get(2)).y);
            this.path.lineTo((float) ((org.opencv.core.Point) arrayList.get(3)).x, (float) ((org.opencv.core.Point) arrayList.get(3)).y);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
    }

    private final org.opencv.core.Point translatePoint(org.opencv.core.Point point) {
        org.opencv.core.Point point2 = new org.opencv.core.Point();
        point2.x = translateX((float) point.x);
        point2.y = translateY((float) point.y);
        return point2;
    }
}
