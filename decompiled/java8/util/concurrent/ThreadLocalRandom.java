package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ThreadLocalRandom extends java.util.Random {
    private static final java.lang.String BAD_BOUND = "bound must be positive";
    private static final java.lang.String BAD_RANGE = "bound must be greater than origin";
    private static final java.lang.String BAD_SIZE = "size must be non-negative";
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16d;
    private static final float FLOAT_UNIT = 5.9604645E-8f;
    private static final long serialVersionUID = 9123313859120073139L;
    private boolean initialized = true;
    private static final java.io.ObjectStreamField[] serialPersistentFields = {new java.io.ObjectStreamField("rnd", java.lang.Long.TYPE), new java.io.ObjectStreamField("initialized", java.lang.Boolean.TYPE)};
    private static final java.lang.ThreadLocal<java.lang.Double> nextLocalGaussian = new java.lang.ThreadLocal<>();
    private static final java8.util.concurrent.ThreadLocalRandom instance = new java8.util.concurrent.ThreadLocalRandom();

    private ThreadLocalRandom() {
    }

    public static java8.util.concurrent.ThreadLocalRandom current() {
        if (java8.util.concurrent.TLRandom.getThreadLocalRandomProbe() == 0) {
            java8.util.concurrent.TLRandom.localInit();
        }
        return instance;
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.initialized) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    private final long nextSeed() {
        return java8.util.concurrent.TLRandom.nextSeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long internalNextLong(long j, long j2) {
        long jMix64 = java8.util.concurrent.TLRandom.mix64(nextSeed());
        if (j >= j2) {
            return jMix64;
        }
        long j3 = j2 - j;
        long j4 = j3 - 1;
        if ((j3 & j4) == 0) {
            return (jMix64 & j4) + j;
        }
        if (j3 > 0) {
            while (true) {
                long j5 = jMix64 >>> 1;
                long j6 = j5 + j4;
                long j7 = j5 % j3;
                if (j6 - j7 >= 0) {
                    return j7 + j;
                }
                jMix64 = java8.util.concurrent.TLRandom.mix64(nextSeed());
            }
        } else {
            while (true) {
                if (jMix64 >= j && jMix64 < j2) {
                    return jMix64;
                }
                jMix64 = java8.util.concurrent.TLRandom.mix64(nextSeed());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int internalNextInt(int i, int i2) {
        int i3;
        int iMix32 = java8.util.concurrent.TLRandom.mix32(nextSeed());
        if (i >= i2) {
            return iMix32;
        }
        int i4 = i2 - i;
        int i5 = i4 - 1;
        if ((i4 & i5) == 0) {
            i3 = iMix32 & i5;
        } else if (i4 > 0) {
            int iMix322 = iMix32 >>> 1;
            while (true) {
                int i6 = iMix322 + i5;
                i3 = iMix322 % i4;
                if (i6 - i3 >= 0) {
                    break;
                }
                iMix322 = java8.util.concurrent.TLRandom.mix32(nextSeed()) >>> 1;
            }
        } else {
            while (true) {
                if (iMix32 >= i && iMix32 < i2) {
                    return iMix32;
                }
                iMix32 = java8.util.concurrent.TLRandom.mix32(nextSeed());
            }
        }
        return i3 + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double internalNextDouble(double d, double d2) {
        double dNextLong = (nextLong() >>> 11) * DOUBLE_UNIT;
        if (d >= d2) {
            return dNextLong;
        }
        double d3 = (dNextLong * (d2 - d)) + d;
        return d3 >= d2 ? java.lang.Double.longBitsToDouble(java.lang.Double.doubleToLongBits(d2) - 1) : d3;
    }

    @Override // java.util.Random
    public int nextInt() {
        return java8.util.concurrent.TLRandom.mix32(nextSeed());
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException(BAD_BOUND);
        }
        int iMix32 = java8.util.concurrent.TLRandom.mix32(nextSeed());
        int i2 = i - 1;
        if ((i & i2) == 0) {
            return iMix32 & i2;
        }
        while (true) {
            int i3 = iMix32 >>> 1;
            int i4 = i3 + i2;
            int i5 = i3 % i;
            if (i4 - i5 >= 0) {
                return i5;
            }
            iMix32 = java8.util.concurrent.TLRandom.mix32(nextSeed());
        }
    }

    public int nextInt(int i, int i2) {
        if (i >= i2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return internalNextInt(i, i2);
    }

    @Override // java.util.Random
    public long nextLong() {
        return java8.util.concurrent.TLRandom.mix64(nextSeed());
    }

    public long nextLong(long j) {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException(BAD_BOUND);
        }
        long jMix64 = java8.util.concurrent.TLRandom.mix64(nextSeed());
        long j2 = j - 1;
        if ((j & j2) == 0) {
            return jMix64 & j2;
        }
        while (true) {
            long j3 = jMix64 >>> 1;
            long j4 = j3 + j2;
            long j5 = j3 % j;
            if (j4 - j5 >= 0) {
                return j5;
            }
            jMix64 = java8.util.concurrent.TLRandom.mix64(nextSeed());
        }
    }

    public long nextLong(long j, long j2) {
        if (j >= j2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return internalNextLong(j, j2);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return (java8.util.concurrent.TLRandom.mix64(nextSeed()) >>> 11) * DOUBLE_UNIT;
    }

    public double nextDouble(double d) {
        if (d <= 0.0d) {
            throw new java.lang.IllegalArgumentException(BAD_BOUND);
        }
        double dMix64 = (java8.util.concurrent.TLRandom.mix64(nextSeed()) >>> 11) * DOUBLE_UNIT * d;
        return dMix64 < d ? dMix64 : java.lang.Double.longBitsToDouble(java.lang.Double.doubleToLongBits(d) - 1);
    }

    public double nextDouble(double d, double d2) {
        if (d >= d2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return internalNextDouble(d, d2);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return java8.util.concurrent.TLRandom.mix32(nextSeed()) < 0;
    }

    @Override // java.util.Random
    public float nextFloat() {
        return (java8.util.concurrent.TLRandom.mix32(nextSeed()) >>> 8) * FLOAT_UNIT;
    }

    @Override // java.util.Random
    public double nextGaussian() {
        java.lang.ThreadLocal<java.lang.Double> threadLocal = nextLocalGaussian;
        java.lang.Double d = threadLocal.get();
        if (d != null) {
            threadLocal.set(null);
            return d.doubleValue();
        }
        while (true) {
            double dNextDouble = (nextDouble() * 2.0d) - 1.0d;
            double dNextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d2 = (dNextDouble * dNextDouble) + (dNextDouble2 * dNextDouble2);
            if (d2 < 1.0d && d2 != 0.0d) {
                double dSqrt = java.lang.StrictMath.sqrt((java.lang.StrictMath.log(d2) * (-2.0d)) / d2);
                nextLocalGaussian.set(java.lang.Double.valueOf(dNextDouble2 * dSqrt));
                return dNextDouble * dSqrt;
            }
        }
    }

    @Override // java.util.Random
    public java8.util.stream.IntStream ints(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.concurrent.ThreadLocalRandom.RandomIntsSpliterator(0L, j, Integer.MAX_VALUE, 0), false);
    }

    @Override // java.util.Random
    public java8.util.stream.IntStream ints() {
        return java8.util.stream.StreamSupport.intStream(new java8.util.concurrent.ThreadLocalRandom.RandomIntsSpliterator(0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false);
    }

    @Override // java.util.Random
    public java8.util.stream.IntStream ints(long j, int i, int i2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        if (i >= i2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.concurrent.ThreadLocalRandom.RandomIntsSpliterator(0L, j, i, i2), false);
    }

    @Override // java.util.Random
    public java8.util.stream.IntStream ints(int i, int i2) {
        if (i >= i2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.concurrent.ThreadLocalRandom.RandomIntsSpliterator(0L, Long.MAX_VALUE, i, i2), false);
    }

    @Override // java.util.Random
    public java8.util.stream.LongStream longs(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.concurrent.ThreadLocalRandom.RandomLongsSpliterator(0L, j, Long.MAX_VALUE, 0L), false);
    }

    @Override // java.util.Random
    public java8.util.stream.LongStream longs() {
        return java8.util.stream.StreamSupport.longStream(new java8.util.concurrent.ThreadLocalRandom.RandomLongsSpliterator(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L), false);
    }

    @Override // java.util.Random
    public java8.util.stream.LongStream longs(long j, long j2, long j3) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        if (j2 >= j3) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.concurrent.ThreadLocalRandom.RandomLongsSpliterator(0L, j, j2, j3), false);
    }

    @Override // java.util.Random
    public java8.util.stream.LongStream longs(long j, long j2) {
        if (j >= j2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.concurrent.ThreadLocalRandom.RandomLongsSpliterator(0L, Long.MAX_VALUE, j, j2), false);
    }

    @Override // java.util.Random
    public java8.util.stream.DoubleStream doubles(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.concurrent.ThreadLocalRandom.RandomDoublesSpliterator(0L, j, Double.MAX_VALUE, 0.0d), false);
    }

    @Override // java.util.Random
    public java8.util.stream.DoubleStream doubles() {
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.concurrent.ThreadLocalRandom.RandomDoublesSpliterator(0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d), false);
    }

    @Override // java.util.Random
    public java8.util.stream.DoubleStream doubles(long j, double d, double d2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        if (d >= d2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.concurrent.ThreadLocalRandom.RandomDoublesSpliterator(0L, j, d, d2), false);
    }

    @Override // java.util.Random
    public java8.util.stream.DoubleStream doubles(double d, double d2) {
        if (d >= d2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.concurrent.ThreadLocalRandom.RandomDoublesSpliterator(0L, Long.MAX_VALUE, d, d2), false);
    }

    private static final class RandomIntsSpliterator implements java8.util.Spliterator.OfInt {
        final int bound;
        final long fence;
        long index;
        final int origin;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        RandomIntsSpliterator(long j, long j2, int i, int i2) {
            this.index = j;
            this.fence = j2;
            this.origin = i;
            this.bound = i2;
        }

        @Override // java8.util.Spliterator
        public java8.util.concurrent.ThreadLocalRandom.RandomIntsSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.index = j2;
            return new java8.util.concurrent.ThreadLocalRandom.RandomIntsSpliterator(j, j2, this.origin, this.bound);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Integer> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            intConsumer.accept(java8.util.concurrent.ThreadLocalRandom.current().internalNextInt(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                int i = this.origin;
                int i2 = this.bound;
                java8.util.concurrent.ThreadLocalRandom threadLocalRandomCurrent = java8.util.concurrent.ThreadLocalRandom.current();
                do {
                    intConsumer.accept(threadLocalRandomCurrent.internalNextInt(i, i2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
        }
    }

    private static final class RandomLongsSpliterator implements java8.util.Spliterator.OfLong {
        final long bound;
        final long fence;
        long index;
        final long origin;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        RandomLongsSpliterator(long j, long j2, long j3, long j4) {
            this.index = j;
            this.fence = j2;
            this.origin = j3;
            this.bound = j4;
        }

        @Override // java8.util.Spliterator
        public java8.util.concurrent.ThreadLocalRandom.RandomLongsSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.index = j2;
            return new java8.util.concurrent.ThreadLocalRandom.RandomLongsSpliterator(j, j2, this.origin, this.bound);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Long> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            longConsumer.accept(java8.util.concurrent.ThreadLocalRandom.current().internalNextLong(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                long j3 = this.origin;
                long j4 = this.bound;
                java8.util.concurrent.ThreadLocalRandom threadLocalRandomCurrent = java8.util.concurrent.ThreadLocalRandom.current();
                do {
                    longConsumer.accept(threadLocalRandomCurrent.internalNextLong(j3, j4));
                    j++;
                } while (j < j2);
            }
        }

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
        }
    }

    private static final class RandomDoublesSpliterator implements java8.util.Spliterator.OfDouble {
        final double bound;
        final long fence;
        long index;
        final double origin;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        RandomDoublesSpliterator(long j, long j2, double d, double d2) {
            this.index = j;
            this.fence = j2;
            this.origin = d;
            this.bound = d2;
        }

        @Override // java8.util.Spliterator
        public java8.util.concurrent.ThreadLocalRandom.RandomDoublesSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.index = j2;
            return new java8.util.concurrent.ThreadLocalRandom.RandomDoublesSpliterator(j, j2, this.origin, this.bound);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator
        public long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown(this);
        }

        @Override // java8.util.Spliterator
        public boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics(this, i);
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.lang.Double> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            doubleConsumer.accept(java8.util.concurrent.ThreadLocalRandom.current().internalNextDouble(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                double d = this.origin;
                double d2 = this.bound;
                java8.util.concurrent.ThreadLocalRandom threadLocalRandomCurrent = java8.util.concurrent.ThreadLocalRandom.current();
                do {
                    doubleConsumer.accept(threadLocalRandomCurrent.internalNextDouble(d, d2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
        }
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("rnd", java8.util.concurrent.TLRandom.getThreadLocalRandomSeed());
        putFieldPutFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    private java.lang.Object readResolve() {
        return current();
    }
}
