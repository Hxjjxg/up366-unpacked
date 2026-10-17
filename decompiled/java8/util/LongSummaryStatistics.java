package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LongSummaryStatistics implements java8.util.function.LongConsumer, java8.util.function.IntConsumer {
    private long count;
    private long max;
    private long min;
    private long sum;

    public LongSummaryStatistics() {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
    }

    public LongSummaryStatistics(long j, long j2, long j3, long j4) throws java.lang.IllegalArgumentException {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Negative count value");
        }
        if (j > 0) {
            if (j2 > j3) {
                throw new java.lang.IllegalArgumentException("Minimum greater than maximum");
            }
            this.count = j;
            this.sum = j4;
            this.min = j2;
            this.max = j3;
        }
    }

    @Override // java8.util.function.IntConsumer
    public void accept(int i) {
        accept(i);
    }

    @Override // java8.util.function.LongConsumer
    public void accept(long j) {
        this.count++;
        this.sum += j;
        this.min = java.lang.Math.min(this.min, j);
        this.max = java.lang.Math.max(this.max, j);
    }

    public void combine(java8.util.LongSummaryStatistics longSummaryStatistics) {
        this.count += longSummaryStatistics.count;
        this.sum += longSummaryStatistics.sum;
        this.min = java.lang.Math.min(this.min, longSummaryStatistics.min);
        this.max = java.lang.Math.max(this.max, longSummaryStatistics.max);
    }

    public final long getCount() {
        return this.count;
    }

    public final long getSum() {
        return this.sum;
    }

    public final long getMin() {
        return this.min;
    }

    public final long getMax() {
        return this.max;
    }

    public final double getAverage() {
        if (getCount() > 0) {
            return getSum() / getCount();
        }
        return 0.0d;
    }

    public java.lang.String toString() {
        return java.lang.String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", getClass().getSimpleName(), java.lang.Long.valueOf(getCount()), java.lang.Long.valueOf(getSum()), java.lang.Long.valueOf(getMin()), java.lang.Double.valueOf(getAverage()), java.lang.Long.valueOf(getMax()));
    }
}
