package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class IntSummaryStatistics implements java8.util.function.IntConsumer {
    private long count;
    private int max;
    private int min;
    private long sum;

    public IntSummaryStatistics() {
        this.min = Integer.MAX_VALUE;
        this.max = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
    }

    public IntSummaryStatistics(long j, int i, int i2, long j2) throws java.lang.IllegalArgumentException {
        this.min = Integer.MAX_VALUE;
        this.max = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Negative count value");
        }
        if (j > 0) {
            if (i > i2) {
                throw new java.lang.IllegalArgumentException("Minimum greater than maximum");
            }
            this.count = j;
            this.sum = j2;
            this.min = i;
            this.max = i2;
        }
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        this.count++;
        this.sum += (long) i;
        this.min = java.lang.Math.min(this.min, i);
        this.max = java.lang.Math.max(this.max, i);
    }

    public void combine(java8.util.IntSummaryStatistics intSummaryStatistics) {
        this.count += intSummaryStatistics.count;
        this.sum += intSummaryStatistics.sum;
        this.min = java.lang.Math.min(this.min, intSummaryStatistics.min);
        this.max = java.lang.Math.max(this.max, intSummaryStatistics.max);
    }

    public final long getCount() {
        return this.count;
    }

    public final long getSum() {
        return this.sum;
    }

    public final int getMin() {
        return this.min;
    }

    public final int getMax() {
        return this.max;
    }

    public final double getAverage() {
        if (getCount() > 0) {
            return getSum() / getCount();
        }
        return 0.0d;
    }

    public java.lang.String toString() {
        return java.lang.String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", getClass().getSimpleName(), java.lang.Long.valueOf(getCount()), java.lang.Long.valueOf(getSum()), java.lang.Integer.valueOf(getMin()), java.lang.Double.valueOf(getAverage()), java.lang.Integer.valueOf(getMax()));
    }
}
