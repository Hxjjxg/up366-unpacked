package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class OptionalLong {
    private static final java8.util.OptionalLong EMPTY = new java8.util.OptionalLong();
    private final boolean isPresent;
    private final long value;

    private static final class OLCache {
        static final java8.util.OptionalLong[] cache = new java8.util.OptionalLong[256];

        private OLCache() {
        }

        static {
            int i = 0;
            while (true) {
                java8.util.OptionalLong[] optionalLongArr = cache;
                if (i >= optionalLongArr.length) {
                    return;
                }
                optionalLongArr[i] = new java8.util.OptionalLong(i - 128);
                i++;
            }
        }
    }

    private OptionalLong() {
        this.isPresent = false;
        this.value = 0L;
    }

    public static java8.util.OptionalLong empty() {
        return EMPTY;
    }

    OptionalLong(long j) {
        this.isPresent = true;
        this.value = j;
    }

    public static java8.util.OptionalLong of(long j) {
        if (j >= -128 && j <= 127) {
            return java8.util.OptionalLong.OLCache.cache[((int) j) + 128];
        }
        return new java8.util.OptionalLong(j);
    }

    public long getAsLong() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(java8.util.function.LongConsumer longConsumer) {
        if (this.isPresent) {
            longConsumer.accept(this.value);
        }
    }

    public void ifPresentOrElse(java8.util.function.LongConsumer longConsumer, java.lang.Runnable runnable) {
        if (this.isPresent) {
            longConsumer.accept(this.value);
        } else {
            runnable.run();
        }
    }

    public java8.util.stream.LongStream stream() {
        if (this.isPresent) {
            return java8.util.stream.LongStreams.of(this.value);
        }
        return java8.util.stream.LongStreams.empty();
    }

    public long orElse(long j) {
        return this.isPresent ? this.value : j;
    }

    public long orElseGet(java8.util.function.LongSupplier longSupplier) {
        return this.isPresent ? this.value : longSupplier.getAsLong();
    }

    public long orElseThrow() {
        if (!this.isPresent) {
            throw new java.util.NoSuchElementException("No value present");
        }
        return this.value;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public <X extends java.lang.Throwable> long orElseThrow(java8.util.function.Supplier<? extends X> supplier) throws java.lang.Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw supplier.get();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java8.util.OptionalLong)) {
            return false;
        }
        java8.util.OptionalLong optionalLong = (java8.util.OptionalLong) obj;
        boolean z = this.isPresent;
        if (z && optionalLong.isPresent) {
            if (this.value == optionalLong.value) {
                return true;
            }
        } else if (z == optionalLong.isPresent) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.isPresent) {
            return java8.lang.Longs.hashCode(this.value);
        }
        return 0;
    }

    public java.lang.String toString() {
        return this.isPresent ? java.lang.String.format("OptionalLong[%s]", java.lang.Long.valueOf(this.value)) : "OptionalLong.empty";
    }
}
