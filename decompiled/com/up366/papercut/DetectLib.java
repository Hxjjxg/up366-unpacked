package com.up366.papercut;

/* JADX INFO: compiled from: DetectLib.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ!\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0082 J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\t\u0010\u0014\u001a\u00020\bH\u0086 J)\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0082 J,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bJ,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bJ!\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0086 J\u0013\u0010\"\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086 J!\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0086 J\t\u0010&\u001a\u00020'H\u0086 ¨\u0006)"}, d2 = {"Lcom/up366/papercut/DetectLib;", "", "()V", "checkBlur", "Lcom/up366/papercut/BlurResult;", "bitmap", "Landroid/graphics/Bitmap;", "threshold", "", "", "outputArray", "", "convertToObjects", "", "Lcom/up366/papercut/Detect;", "array", "", "countRectCornerPoints", "", "detects", "destroy", "detect", "buffer", "Ljava/nio/ByteBuffer;", "width", "height", "rotationDegrees", "detectImage", "detectImageCorners", "enhancement", "mgr", "Landroid/content/res/AssetManager;", "srcBitmap", "destBitmap", "loadModel", "perspectiveCorrection", "srcPoints", "", "stringFromJNI", "", "Companion", "lib_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DetectLib {
    private final native boolean checkBlur(android.graphics.Bitmap bitmap, int threshold, double[] outputArray);

    private final native float[] detect(java.nio.ByteBuffer buffer, int width, int height, int rotationDegrees);

    public final native int destroy();

    public final native int enhancement(android.content.res.AssetManager mgr, android.graphics.Bitmap srcBitmap, android.graphics.Bitmap destBitmap);

    public final native boolean loadModel(android.content.res.AssetManager mgr);

    public final native int perspectiveCorrection(android.graphics.Bitmap srcBitmap, android.graphics.Bitmap destBitmap, int[] srcPoints);

    public final native java.lang.String stringFromJNI();

    static {
        java.lang.System.loadLibrary("sign");
    }

    public final com.up366.papercut.BlurResult checkBlur(android.graphics.Bitmap bitmap, int threshold) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        double[] dArr = new double[2];
        return new com.up366.papercut.BlurResult(checkBlur(bitmap, threshold, dArr), dArr[0], dArr[1]);
    }

    public final java.util.List<com.up366.papercut.Detect> convertToObjects(float[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        float fMax = 0.0f;
        int i = 0;
        while (i < array.length) {
            float f = array[i];
            float f2 = array[i + 1];
            float f3 = array[i + 2];
            float f4 = array[i + 3];
            float f5 = array[i + 4];
            float f6 = f3 + f;
            arrayList.add(new com.up366.papercut.Detect(new android.graphics.RectF(f, f2, f6, f4 + f2), (int) f5, array[i + 5]));
            i += 6;
            fMax = java.lang.Math.max(f6, fMax);
        }
        if (arrayList.size() > 1) {
            kotlin.collections.CollectionsKt.sortWith(arrayList, new java.util.Comparator() { // from class: com.up366.papercut.DetectLib$convertToObjects$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Float.valueOf(((com.up366.papercut.Detect) t2).getProb()), java.lang.Float.valueOf(((com.up366.papercut.Detect) t).getProb()));
                }
            });
        }
        return arrayList;
    }

    public final java.util.List<com.up366.papercut.Detect> detectImage(java.nio.ByteBuffer buffer, int width, int height, int rotationDegrees) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(buffer, "buffer");
        return countRectCornerPoints(convertToObjects(detect(buffer, width, height, rotationDegrees)));
    }

    public final java.util.List<com.up366.papercut.Detect> detectImageCorners(java.nio.ByteBuffer buffer, int width, int height, int rotationDegrees) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(buffer, "buffer");
        return convertToObjects(detect(buffer, width, height, rotationDegrees));
    }

    public final java.util.List<com.up366.papercut.Detect> countRectCornerPoints(java.util.List<com.up366.papercut.Detect> detects) {
        com.up366.papercut.Detect detect;
        com.up366.papercut.Detect next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detects, "detects");
        java.util.Iterator<com.up366.papercut.Detect> it = detects.iterator();
        while (true) {
            detect = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getType() == com.up366.papercut.DetectLibKt.getTYPE_C() && next.getProb() > 0.03d) {
                break;
            }
        }
        if (next == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        float fWidth = next.getRect().width() * 0.1f;
        float fHeight = next.getRect().height() * 0.1f;
        final android.graphics.RectF rectF = new android.graphics.RectF(next.getRect().left - fWidth, next.getRect().top - fHeight, next.getRect().right + fWidth, next.getRect().bottom + fHeight);
        kotlin.jvm.functions.Function1<com.up366.papercut.Detect, java.lang.Boolean> function1 = new kotlin.jvm.functions.Function1<com.up366.papercut.Detect, java.lang.Boolean>() { // from class: com.up366.papercut.DetectLib$countRectCornerPoints$inFP$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final java.lang.Boolean invoke(com.up366.papercut.Detect detect2) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detect2, com.igexin.push.g.q.f);
                return java.lang.Boolean.valueOf(rectF.contains(detect2.getRect().centerX(), detect2.getRect().centerY()));
            }
        };
        com.up366.papercut.Detect detect2 = null;
        com.up366.papercut.Detect detect3 = null;
        com.up366.papercut.Detect detect4 = null;
        for (com.up366.papercut.Detect detect5 : detects) {
            if (((java.lang.Boolean) function1.invoke(detect5)).booleanValue()) {
                if (detect == null && detect5.getType() == com.up366.papercut.DetectLibKt.getTYPE_LT() && detect5.getProb() > 0.03d) {
                    detect = detect5;
                }
                if (detect2 == null && detect5.getType() == com.up366.papercut.DetectLibKt.getTYPE_RT() && detect5.getProb() > 0.03d) {
                    detect2 = detect5;
                }
                if (detect3 == null && detect5.getType() == com.up366.papercut.DetectLibKt.getTYPE_LB() && detect5.getProb() > 0.03d) {
                    detect3 = detect5;
                }
                if (detect4 == null && detect5.getType() == com.up366.papercut.DetectLibKt.getTYPE_RB() && detect5.getProb() > 0.03d) {
                    detect4 = detect5;
                }
            }
        }
        return (detect == null || detect2 == null || detect3 == null || detect4 == null) ? kotlin.collections.CollectionsKt.emptyList() : kotlin.collections.CollectionsKt.listOf(new com.up366.papercut.Detect[]{detect, detect2, detect4, detect3});
    }
}
