package com.up366.papercut;

/* JADX INFO: compiled from: DetectLib.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/up366/papercut/ValueTracker;", "", "size", "", "(I)V", "deltas", "", "getDeltas", "()[F", com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, "getIndex", "()I", "setIndex", "getSize", "clear", "", "countMaxValue", "", "countMeanSquareError", "track", "value", "lib_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ValueTracker {
    private final float[] deltas;
    private int index;
    private final int size;

    public ValueTracker(int i) {
        this.size = i;
        this.deltas = new float[i];
    }

    public final int getSize() {
        return this.size;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final float[] getDeltas() {
        return this.deltas;
    }

    public final void track(float value) {
        float[] fArr = this.deltas;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        fArr[i] = value;
        if (i2 >= fArr.length) {
            this.index = 0;
        }
    }

    public final float countMeanSquareError() {
        float[] fArr = this.deltas;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (float f : fArr) {
            if (f > -1.0f) {
                arrayList.add(java.lang.Float.valueOf(f));
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        double dAverageOfFloat = kotlin.collections.CollectionsKt.averageOfFloat(arrayList2);
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        java.util.Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            double dFloatValue = ((double) ((java.lang.Number) it.next()).floatValue()) - dAverageOfFloat;
            arrayList3.add(java.lang.Double.valueOf(java.lang.Math.sqrt(dFloatValue * dFloatValue)));
        }
        return (float) kotlin.collections.CollectionsKt.averageOfDouble(arrayList3);
    }

    public final float countMaxValue() {
        return kotlin.collections.ArraysKt.maxOrThrow(this.deltas);
    }

    public final void clear() {
        kotlin.collections.ArraysKt.fill$default(this.deltas, -1.0f, 0, 0, 6, (java.lang.Object) null);
    }
}
