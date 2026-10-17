package com.up366.medialibrary.third.photoview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class Util {
    static int getPointerIndex(int i) {
        return (i & 65280) >> 8;
    }

    Util() {
    }

    static void checkZoomLevels(float f, float f2, float f3) {
        if (f >= f2) {
            throw new java.lang.IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f2 >= f3) {
            throw new java.lang.IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    static boolean hasDrawable(android.widget.ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* JADX INFO: renamed from: com.up366.medialibrary.third.photoview.Util$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
        }
    }

    static boolean isSupportedScaleType(android.widget.ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (com.up366.medialibrary.third.photoview.Util.AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new java.lang.IllegalStateException("Matrix scale type is not supported");
    }
}
