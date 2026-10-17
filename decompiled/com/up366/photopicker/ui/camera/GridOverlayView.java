package com.up366.photopicker.ui.camera;

/* JADX INFO: compiled from: GridOverlayView.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/up366/photopicker/ui/camera/GridOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gridPaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GridOverlayView extends android.view.View {
    private final android.graphics.Paint gridPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridOverlayView(android.content.Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridOverlayView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GridOverlayView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridOverlayView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setColor(androidx.core.content.ContextCompat.getColor(context, android.R.color.white));
        paint.setStrokeWidth(2.0f);
        paint.setAlpha(128);
        this.gridPaint = paint;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float f = 3;
        float f2 = width / f;
        float f3 = 2;
        float f4 = (width * f3) / f;
        canvas.drawLine(f2, 0.0f, f2, height, this.gridPaint);
        canvas.drawLine(f4, 0.0f, f4, height, this.gridPaint);
        float f5 = height / f;
        float f6 = (height * f3) / f;
        canvas.drawLine(0.0f, f5, width, f5, this.gridPaint);
        canvas.drawLine(0.0f, f6, width, f6, this.gridPaint);
    }
}
