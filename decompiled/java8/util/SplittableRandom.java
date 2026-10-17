package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class SplittableRandom {
    private static final java.lang.String BAD_BOUND = "bound must be positive";
    private static final java.lang.String BAD_RANGE = "bound must be greater than origin";
    private static final java.lang.String BAD_SIZE = "size must be non-negative";
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16d;
    private static final long GOLDEN_GAMMA = -7046029254386353131L;
    private static final java.util.concurrent.atomic.AtomicLong defaultGen = new java.util.concurrent.atomic.AtomicLong(mix64(java.lang.System.currentTimeMillis()) ^ mix64(java.lang.System.nanoTime()));
    private final long gamma;
    private long seed;

    private static int mix32(long j) {
        long j2 = (j ^ (j >>> 33)) * 7109453100751455733L;
        return (int) (((j2 ^ (j2 >>> 28)) * (-3808689974395783757L)) >>> 32);
    }

    private static long mix64(long j) {
        long j2 = (j ^ (j >>> 30)) * (-4658895280553007687L);
        long j3 = (j2 ^ (j2 >>> 27)) * (-7723592293110705685L);
        return j3 ^ (j3 >>> 31);
    }

    private SplittableRandom(long j, long j2) {
        this.seed = j;
        this.gamma = j2;
    }

    private static long mixGamma(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        long j4 = (j3 ^ (j3 >>> 33)) | 1;
        return java.lang.Long.bitCount((j4 >>> 1) ^ j4) < 24 ? j4 ^ (-6148914691236517206L) : j4;
    }

    private long nextSeed() {
        long j = this.seed + this.gamma;
        this.seed = j;
        return j;
    }

    static {
        if (((java.lang.Boolean) java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java.lang.Boolean>() { // from class: java8.util.SplittableRandom.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public java.lang.Boolean run() {
                return java.lang.Boolean.valueOf(java.lang.Boolean.getBoolean("java.util.secureRandomSeed"));
            }
        })).booleanValue()) {
            byte[] seed = java.security.SecureRandom.getSeed(8);
            long j = ((long) seed[0]) & 255;
            for (int i = 1; i < 8; i++) {
                j = (j << 8) | (((long) seed[i]) & 255);
            }
            defaultGen.set(j);
        }
    }

    final long internalNextLong(long j, long j2) {
        long jMix64 = mix64(nextSeed());
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
                jMix64 = mix64(nextSeed());
            }
        } else {
            while (true) {
                if (jMix64 >= j && jMix64 < j2) {
                    return jMix64;
                }
                jMix64 = mix64(nextSeed());
            }
        }
    }

    final int internalNextInt(int i, int i2) {
        int i3;
        int iMix32 = mix32(nextSeed());
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
                iMix322 = mix32(nextSeed()) >>> 1;
            }
        } else {
            while (true) {
                if (iMix32 >= i && iMix32 < i2) {
                    return iMix32;
                }
                iMix32 = mix32(nextSeed());
            }
        }
        return i3 + i;
    }

    final double internalNextDouble(double d, double d2) {
        double dNextLong = (nextLong() >>> 11) * DOUBLE_UNIT;
        if (d >= d2) {
            return dNextLong;
        }
        double d3 = (dNextLong * (d2 - d)) + d;
        return d3 >= d2 ? java.lang.Double.longBitsToDouble(java.lang.Double.doubleToLongBits(d2) - 1) : d3;
    }

    public SplittableRandom(long j) {
        this(j, GOLDEN_GAMMA);
    }

    public SplittableRandom() {
        long andAdd = defaultGen.getAndAdd(4354685564936845354L);
        this.seed = mix64(andAdd);
        this.gamma = mixGamma(andAdd + GOLDEN_GAMMA);
    }

    public java8.util.SplittableRandom split() {
        return new java8.util.SplittableRandom(nextLong(), mixGamma(nextSeed()));
    }

    public void nextBytes(byte[] bArr) {
        int length = bArr.length;
        int i = length >> 3;
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            long jNextLong = nextLong();
            int i4 = 8;
            while (true) {
                int i5 = i4 - 1;
                if (i4 > 0) {
                    bArr[i2] = (byte) jNextLong;
                    jNextLong >>>= 8;
                    i2++;
                    i4 = i5;
                }
            }
            i = i3;
        }
        if (i2 < length) {
            long jNextLong2 = nextLong();
            while (i2 < length) {
                bArr[i2] = (byte) jNextLong2;
                jNextLong2 >>>= 8;
                i2++;
            }
        }
    }

    public int nextInt() {
        return mix32(nextSeed());
    }

    public int nextInt(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException(BAD_BOUND);
        }
        int iMix32 = mix32(nextSeed());
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
            iMix32 = mix32(nextSeed());
        }
    }

    public int nextInt(int i, int i2) {
        if (i >= i2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return internalNextInt(i, i2);
    }

    public long nextLong() {
        return mix64(nextSeed());
    }

    public long nextLong(long j) {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException(BAD_BOUND);
        }
        long jMix64 = mix64(nextSeed());
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
            jMix64 = mix64(nextSeed());
        }
    }

    public long nextLong(long j, long j2) {
        if (j >= j2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return internalNextLong(j, j2);
    }

    public double nextDouble() {
        return (mix64(nextSeed()) >>> 11) * DOUBLE_UNIT;
    }

    public double nextDouble(double d) {
        if (d <= 0.0d) {
            throw new java.lang.IllegalArgumentException(BAD_BOUND);
        }
        double dMix64 = (mix64(nextSeed()) >>> 11) * DOUBLE_UNIT * d;
        return dMix64 < d ? dMix64 : java.lang.Double.longBitsToDouble(java.lang.Double.doubleToLongBits(d) - 1);
    }

    public double nextDouble(double d, double d2) {
        if (d >= d2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return internalNextDouble(d, d2);
    }

    public boolean nextBoolean() {
        return mix32(nextSeed()) < 0;
    }

    public java8.util.stream.IntStream ints(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.SplittableRandom.RandomIntsSpliterator(this, 0L, j, Integer.MAX_VALUE, 0), false);
    }

    public java8.util.stream.IntStream ints() {
        return java8.util.stream.StreamSupport.intStream(new java8.util.SplittableRandom.RandomIntsSpliterator(this, 0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false);
    }

    public java8.util.stream.IntStream ints(long j, int i, int i2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        if (i >= i2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.SplittableRandom.RandomIntsSpliterator(this, 0L, j, i, i2), false);
    }

    public java8.util.stream.IntStream ints(int i, int i2) {
        if (i >= i2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.intStream(new java8.util.SplittableRandom.RandomIntsSpliterator(this, 0L, Long.MAX_VALUE, i, i2), false);
    }

    public java8.util.stream.LongStream longs(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.SplittableRandom.RandomLongsSpliterator(this, 0L, j, Long.MAX_VALUE, 0L), false);
    }

    public java8.util.stream.LongStream longs() {
        return java8.util.stream.StreamSupport.longStream(new java8.util.SplittableRandom.RandomLongsSpliterator(this, 0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L), false);
    }

    public java8.util.stream.LongStream longs(long j, long j2, long j3) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        if (j2 >= j3) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.SplittableRandom.RandomLongsSpliterator(this, 0L, j, j2, j3), false);
    }

    public java8.util.stream.LongStream longs(long j, long j2) {
        if (j >= j2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.longStream(new java8.util.SplittableRandom.RandomLongsSpliterator(this, 0L, Long.MAX_VALUE, j, j2), false);
    }

    public java8.util.stream.DoubleStream doubles(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.SplittableRandom.RandomDoublesSpliterator(this, 0L, j, Double.MAX_VALUE, 0.0d), false);
    }

    public java8.util.stream.DoubleStream doubles() {
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.SplittableRandom.RandomDoublesSpliterator(this, 0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d), false);
    }

    public java8.util.stream.DoubleStream doubles(long j, double d, double d2) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        if (d >= d2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.SplittableRandom.RandomDoublesSpliterator(this, 0L, j, d, d2), false);
    }

    public java8.util.stream.DoubleStream doubles(double d, double d2) {
        if (d >= d2) {
            throw new java.lang.IllegalArgumentException(BAD_RANGE);
        }
        return java8.util.stream.StreamSupport.doubleStream(new java8.util.SplittableRandom.RandomDoublesSpliterator(this, 0L, Long.MAX_VALUE, d, d2), false);
    }

    private static final class RandomIntsSpliterator implements java8.util.Spliterator.OfInt {
        final int bound;
        final long fence;
        long index;
        final int origin;
        final java8.util.SplittableRandom rng;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        RandomIntsSpliterator(java8.util.SplittableRandom splittableRandom, long j, long j2, int i, int i2) {
            this.rng = splittableRandom;
            this.index = j;
            this.fence = j2;
            this.origin = i;
            this.bound = i2;
        }

        @Override // java8.util.Spliterator
        public java8.util.SplittableRandom.RandomIntsSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            java8.util.SplittableRandom splittableRandomSplit = this.rng.split();
            this.index = j2;
            return new java8.util.SplittableRandom.RandomIntsSpliterator(splittableRandomSplit, j, j2, this.origin, this.bound);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            intConsumer.accept(this.rng.internalNextInt(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
            java8.util.Objects.requireNonNull(intConsumer);
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                java8.util.SplittableRandom splittableRandom = this.rng;
                int i = this.origin;
                int i2 = this.bound;
                do {
                    intConsumer.accept(splittableRandom.internalNextInt(i, i2));
                    j++;
                } while (j < j2);
            }
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

        @Override // java8.util.Spliterator.OfInt, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
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
        final java8.util.SplittableRandom rng;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        RandomLongsSpliterator(java8.util.SplittableRandom splittableRandom, long j, long j2, long j3, long j4) {
            this.rng = splittableRandom;
            this.index = j;
            this.fence = j2;
            this.origin = j3;
            this.bound = j4;
        }

        @Override // java8.util.Spliterator
        public java8.util.SplittableRandom.RandomLongsSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            java8.util.SplittableRandom splittableRandomSplit = this.rng.split();
            this.index = j2;
            return new java8.util.SplittableRandom.RandomLongsSpliterator(splittableRandomSplit, j, j2, this.origin, this.bound);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            longConsumer.accept(this.rng.internalNextLong(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
            java8.util.Objects.requireNonNull(longConsumer);
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                java8.util.SplittableRandom splittableRandom = this.rng;
                long j3 = this.origin;
                long j4 = this.bound;
                do {
                    longConsumer.accept(splittableRandom.internalNextLong(j3, j4));
                    j++;
                } while (j < j2);
            }
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

        @Override // java8.util.Spliterator.OfLong, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
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
        final java8.util.SplittableRandom rng;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        RandomDoublesSpliterator(java8.util.SplittableRandom splittableRandom, long j, long j2, double d, double d2) {
            this.rng = splittableRandom;
            this.index = j;
            this.fence = j2;
            this.origin = d;
            this.bound = d2;
        }

        @Override // java8.util.Spliterator
        public java8.util.SplittableRandom.RandomDoublesSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            java8.util.SplittableRandom splittableRandomSplit = this.rng.split();
            this.index = j2;
            return new java8.util.SplittableRandom.RandomDoublesSpliterator(splittableRandomSplit, j, j2, this.origin, this.bound);
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            doubleConsumer.accept(this.rng.internalNextDouble(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // java8.util.Spliterator.OfPrimitive
        public void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
            java8.util.Objects.requireNonNull(doubleConsumer);
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                java8.util.SplittableRandom splittableRandom = this.rng;
                double d = this.origin;
                double d2 = this.bound;
                do {
                    doubleConsumer.accept(splittableRandom.internalNextDouble(d, d2));
                    j++;
                } while (j < j2);
            }
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

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
        }

        @Override // java8.util.Spliterator.OfDouble, java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
        }
    }
}
