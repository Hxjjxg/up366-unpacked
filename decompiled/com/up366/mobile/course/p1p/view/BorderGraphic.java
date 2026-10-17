package com.up366.mobile.course.p1p.view;

/* JADX INFO: compiled from: BorderGraphic.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/up366/mobile/course/p1p/view/BorderGraphic;", "Lcom/up366/mobile/course/p1p/view/GraphicOverlay$Graphic;", "overlay", "Lcom/up366/mobile/course/p1p/view/GraphicOverlay;", "analyzeResult", "Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "<init>", "(Lcom/up366/mobile/course/p1p/view/GraphicOverlay;Lcom/up366/mobile/course/p1p/PaperRecognitionResult;)V", "getAnalyzeResult", "()Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "mPaint", "Landroid/graphics/Paint;", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, "Landroid/graphics/Path;", "mPoints", "", "Landroid/graphics/PointF;", "getMPoints", "()Ljava/util/List;", "copyDataToMPoints", "", "applyScreenPoints", "translatePoints", "draw", "canvas", "Landroid/graphics/Canvas;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BorderGraphic extends com.up366.mobile.course.p1p.view.GraphicOverlay.Graphic {
    private final com.up366.mobile.course.p1p.PaperRecognitionResult analyzeResult;
    private final android.graphics.Paint mPaint;
    private final java.util.List<android.graphics.PointF> mPoints;
    private final android.graphics.Path path;

    public final com.up366.mobile.course.p1p.PaperRecognitionResult getAnalyzeResult() {
        return this.analyzeResult;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderGraphic(com.up366.mobile.course.p1p.view.GraphicOverlay graphicOverlay, com.up366.mobile.course.p1p.PaperRecognitionResult paperRecognitionResult) {
        super(graphicOverlay);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(graphicOverlay, "overlay");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperRecognitionResult, "analyzeResult");
        this.analyzeResult = paperRecognitionResult;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        this.path = new android.graphics.Path();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.mPoints = arrayList;
        paint.setColor(-65536);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(com.up366.qmui.util.QMUIDisplayHelper.dpToPx(2));
        arrayList.clear();
        arrayList.add(new android.graphics.PointF());
        arrayList.add(new android.graphics.PointF());
        arrayList.add(new android.graphics.PointF());
        arrayList.add(new android.graphics.PointF());
    }

    public final java.util.List<android.graphics.PointF> getMPoints() {
        return this.mPoints;
    }

    private final void copyDataToMPoints() {
        this.mPoints.get(0).x = this.analyzeResult.getMPoints().get(0).x;
        this.mPoints.get(0).y = this.analyzeResult.getMPoints().get(0).y;
        this.mPoints.get(1).x = this.analyzeResult.getMPoints().get(1).x;
        this.mPoints.get(1).y = this.analyzeResult.getMPoints().get(1).y;
        this.mPoints.get(2).x = this.analyzeResult.getMPoints().get(2).x;
        this.mPoints.get(2).y = this.analyzeResult.getMPoints().get(2).y;
        this.mPoints.get(3).x = this.analyzeResult.getMPoints().get(3).x;
        this.mPoints.get(3).y = this.analyzeResult.getMPoints().get(3).y;
    }

    private final void applyScreenPoints() {
        android.graphics.Rect realCropRect = this.analyzeResult.getRealCropRect();
        if (realCropRect.width() == this.analyzeResult.getImageWidth() && realCropRect.height() == this.analyzeResult.getImageHeight()) {
            return;
        }
        this.mPoints.get(0).x -= realCropRect.left;
        this.mPoints.get(0).y -= realCropRect.top;
        this.mPoints.get(1).x -= realCropRect.left;
        this.mPoints.get(1).y -= realCropRect.top;
        this.mPoints.get(2).x -= realCropRect.left;
        this.mPoints.get(2).y -= realCropRect.top;
        this.mPoints.get(3).x -= realCropRect.left;
        this.mPoints.get(3).y -= realCropRect.top;
    }

    private final void translatePoints() {
        this.mPoints.get(0).x = translateX(this.mPoints.get(0).x);
        this.mPoints.get(0).y = translateY(this.mPoints.get(0).y);
        this.mPoints.get(1).x = translateX(this.mPoints.get(1).x);
        this.mPoints.get(1).y = translateY(this.mPoints.get(1).y);
        this.mPoints.get(2).x = translateX(this.mPoints.get(2).x);
        this.mPoints.get(2).y = translateY(this.mPoints.get(2).y);
        this.mPoints.get(3).x = translateX(this.mPoints.get(3).x);
        this.mPoints.get(3).y = translateY(this.mPoints.get(3).y);
    }

    @Override // com.up366.mobile.course.p1p.view.GraphicOverlay.Graphic
    public void draw(android.graphics.Canvas canvas) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
        copyDataToMPoints();
        applyScreenPoints();
        translatePoints();
        if (this.analyzeResult.getOutScreen() || !this.analyzeResult.getIsAllowArea() || !this.analyzeResult.getIsRactangle()) {
            this.mPaint.setColor(android.graphics.Color.parseColor("#FF7B11"));
        } else {
            this.mPaint.setColor(android.graphics.Color.parseColor("#4D2F79FC"));
            this.mPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            this.path.reset();
            this.path.moveTo(this.mPoints.get(0).x, this.mPoints.get(0).y);
            this.path.lineTo(this.mPoints.get(1).x, this.mPoints.get(1).y);
            this.path.lineTo(this.mPoints.get(2).x, this.mPoints.get(2).y);
            this.path.lineTo(this.mPoints.get(3).x, this.mPoints.get(3).y);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setColor(android.graphics.Color.parseColor("#2F79FC"));
        }
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.path.reset();
        this.path.moveTo(this.mPoints.get(0).x, this.mPoints.get(0).y);
        this.path.lineTo(this.mPoints.get(1).x, this.mPoints.get(1).y);
        this.path.lineTo(this.mPoints.get(2).x, this.mPoints.get(2).y);
        this.path.lineTo(this.mPoints.get(3).x, this.mPoints.get(3).y);
        this.path.close();
        canvas.drawPath(this.path, this.mPaint);
    }
}
