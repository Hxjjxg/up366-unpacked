package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class OptionalInt {
    private static final java8.util.OptionalInt EMPTY = new java8.util.OptionalInt();
    private final boolean isPresent;
    private final int value;

    private static final class OICache {
        static final java8.util.OptionalInt[] cache = new java8.util.OptionalInt[256];

        private OICache() {
        }

        static {
            int i = 0;
            while (true) {
                java8.util.OptionalInt[] optionalIntArr = cache;
                if (i >= optionalIntArr.length) {
                    return;
                }
                optionalIntArr[i] = new java8.util.OptionalInt(i - 128);
                i++;
            }
        }
    }

    private OptionalInt() {
        this.isPresent = false;
        this.value = 0;
    }

    public static java8.util.OptionalInt empty() {
        return EMPTY;
    }

    OptionalInt(int i) {
        this.isPresent = true;
        this.value = i;
    }

    public static java8.util.OptionalInt of(int i) {
        if (i >= -128 && i <= 127) {
            return java8.util.OptionalInt.OICache.cache[i + 128];
        }
        return new java8.util.OptionalInt(i);
    }

    public int getAsInt() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(java8.util.function.IntConsumer intConsumer) {
        if (this.isPresent) {
            intConsumer.accept(this.value);
        }
    }

    public void ifPresentOrElse(java8.util.function.IntConsumer intConsumer, java.lang.Runnable runnable) {
        if (this.isPresent) {
            intConsumer.accept(this.value);
        } else {
            runnable.run();
        }
    }

    public java8.util.stream.IntStream stream() {
        if (this.isPresent) {
            return java8.util.stream.IntStreams.of(this.value);
        }
        return java8.util.stream.IntStreams.empty();
    }

    public int orElse(int i) {
        return this.isPresent ? this.value : i;
    }

    public int orElseGet(java8.util.function.IntSupplier intSupplier) {
        return this.isPresent ? this.value : intSupplier.getAsInt();
    }

    public int orElseThrow() {
        if (!this.isPresent) {
            throw new java.util.NoSuchElementException("No value present");
        }
        return this.value;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public <X extends java.lang.Throwable> int orElseThrow(java8.util.function.Supplier<? extends X> supplier) throws java.lang.Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw supplier.get();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java8.util.OptionalInt)) {
            return false;
        }
        java8.util.OptionalInt optionalInt = (java8.util.OptionalInt) obj;
        boolean z = this.isPresent;
        if (z && optionalInt.isPresent) {
            if (this.value == optionalInt.value) {
                return true;
            }
        } else if (z == optionalInt.isPresent) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.isPresent) {
            return this.value;
        }
        return 0;
    }

    public java.lang.String toString() {
        return this.isPresent ? java.lang.String.format("OptionalInt[%s]", java.lang.Integer.valueOf(this.value)) : "OptionalInt.empty";
    }
}
