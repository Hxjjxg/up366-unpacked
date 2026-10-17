package com.up366.papercut;

/* JADX INFO: compiled from: DetectLib.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/up366/papercut/BlurResult;", "", "isBlur", "", "blurValue", "", "wPercent", "(ZDD)V", "getBlurValue", "()D", "()Z", "getWPercent", "lib_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlurResult {
    private final double blurValue;
    private final boolean isBlur;
    private final double wPercent;

    public BlurResult(boolean z, double d, double d2) {
        this.isBlur = z;
        this.blurValue = d;
        this.wPercent = d2;
    }

    public final double getBlurValue() {
        return this.blurValue;
    }

    public final double getWPercent() {
        return this.wPercent;
    }

    /* JADX INFO: renamed from: isBlur, reason: from getter */
    public final boolean getIsBlur() {
        return this.isBlur;
    }
}
