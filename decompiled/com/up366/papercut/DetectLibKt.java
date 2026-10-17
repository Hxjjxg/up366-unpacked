package com.up366.papercut;

/* JADX INFO: compiled from: DetectLib.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d\"\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0014\u0010\f\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\"\u0014\u0010\u000e\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0014\u0010\u0010\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0014\u0010\u0012\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0014\u0010\u0014\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0014\u0010\u0016\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0014\u0010\u0018\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\t¨\u0006!"}, d2 = {"DETECT_TYPES", "", "", "getDETECT_TYPES", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TYPE_B", "", "getTYPE_B", "()I", "TYPE_C", "getTYPE_C", "TYPE_L", "getTYPE_L", "TYPE_LB", "getTYPE_LB", "TYPE_LT", "getTYPE_LT", "TYPE_R", "getTYPE_R", "TYPE_RB", "getTYPE_RB", "TYPE_RT", "getTYPE_RT", "TYPE_T", "getTYPE_T", "detectPerspectiveDeformation", "", "lt", "Lcom/up366/papercut/Detect;", "rt", "lb", "rb", "lib_debug"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DetectLibKt {
    private static final int TYPE_LT = 0;
    private static final java.lang.String[] DETECT_TYPES = {"LT", "RT", "LB", "RB", "C", "T", "R", "B", "L"};
    private static final int TYPE_RT = 1;
    private static final int TYPE_LB = 2;
    private static final int TYPE_RB = 3;
    private static final int TYPE_C = 4;
    private static final int TYPE_T = 5;
    private static final int TYPE_R = 6;
    private static final int TYPE_B = 7;
    private static final int TYPE_L = 8;

    public static final float detectPerspectiveDeformation(com.up366.papercut.Detect detect, com.up366.papercut.Detect detect2, com.up366.papercut.Detect detect3, com.up366.papercut.Detect detect4) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detect, "lt");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detect2, "rt");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detect3, "lb");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detect4, "rb");
        double dCenterX = detect.getRect().centerX();
        double dCenterY = detect.getRect().centerY();
        double dCenterX2 = detect2.getRect().centerX();
        double dCenterY2 = detect2.getRect().centerY();
        double dCenterX3 = detect3.getRect().centerX();
        double dCenterY3 = detect3.getRect().centerY();
        double dCenterX4 = detect4.getRect().centerX();
        double dCenterY4 = detect4.getRect().centerY();
        double dHypot = java.lang.Math.hypot(dCenterX - dCenterX2, dCenterY - dCenterY2);
        double dHypot2 = java.lang.Math.hypot(dCenterX3 - dCenterX4, dCenterY3 - dCenterY4);
        double dHypot3 = java.lang.Math.hypot(dCenterX - dCenterX3, dCenterY - dCenterY3);
        double dHypot4 = java.lang.Math.hypot(dCenterX2 - dCenterX4, dCenterY2 - dCenterY4);
        return 1 - ((float) java.lang.Math.min(java.lang.Math.min(dHypot, dHypot2) / java.lang.Math.max(dHypot, dHypot2), java.lang.Math.min(dHypot3, dHypot4) / java.lang.Math.max(dHypot3, dHypot4)));
    }

    public static final java.lang.String[] getDETECT_TYPES() {
        return DETECT_TYPES;
    }

    public static final int getTYPE_LT() {
        return TYPE_LT;
    }

    public static final int getTYPE_RT() {
        return TYPE_RT;
    }

    public static final int getTYPE_LB() {
        return TYPE_LB;
    }

    public static final int getTYPE_RB() {
        return TYPE_RB;
    }

    public static final int getTYPE_C() {
        return TYPE_C;
    }

    public static final int getTYPE_T() {
        return TYPE_T;
    }

    public static final int getTYPE_R() {
        return TYPE_R;
    }

    public static final int getTYPE_B() {
        return TYPE_B;
    }

    public static final int getTYPE_L() {
        return TYPE_L;
    }
}
