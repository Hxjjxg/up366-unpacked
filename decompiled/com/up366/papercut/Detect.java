package com.up366.papercut;

/* JADX INFO: compiled from: DetectLib.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/up366/papercut/Detect;", "", "rect", "Landroid/graphics/RectF;", "type", "", "prob", "", "(Landroid/graphics/RectF;IF)V", "getProb", "()F", "getRect", "()Landroid/graphics/RectF;", "getType", "()I", "lib_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Detect {
    private final float prob;
    private final android.graphics.RectF rect;
    private final int type;

    public Detect(android.graphics.RectF rectF, int i, float f) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rectF, "rect");
        this.rect = rectF;
        this.type = i;
        this.prob = f;
    }

    public final float getProb() {
        return this.prob;
    }

    public final android.graphics.RectF getRect() {
        return this.rect;
    }

    public final int getType() {
        return this.type;
    }
}
