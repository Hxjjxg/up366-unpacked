package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class OptionalDouble {
    private static final java8.util.OptionalDouble EMPTY = new java8.util.OptionalDouble();
    private final boolean isPresent;
    private final double value;

    private OptionalDouble() {
        this.isPresent = false;
        this.value = Double.NaN;
    }

    public static java8.util.OptionalDouble empty() {
        return EMPTY;
    }

    private OptionalDouble(double d) {
        this.isPresent = true;
        this.value = d;
    }

    public static java8.util.OptionalDouble of(double d) {
        return new java8.util.OptionalDouble(d);
    }

    public double getAsDouble() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.isPresent;
    }

    public boolean isEmpty() {
        return !this.isPresent;
    }

    public void ifPresent(java8.util.function.DoubleConsumer doubleConsumer) {
        if (this.isPresent) {
            doubleConsumer.accept(this.value);
        }
    }

    public void ifPresentOrElse(java8.util.function.DoubleConsumer doubleConsumer, java.lang.Runnable runnable) {
        if (this.isPresent) {
            doubleConsumer.accept(this.value);
        } else {
            runnable.run();
        }
    }

    public java8.util.stream.DoubleStream stream() {
        if (this.isPresent) {
            return java8.util.stream.DoubleStreams.of(this.value);
        }
        return java8.util.stream.DoubleStreams.empty();
    }

    public double orElse(double d) {
        return this.isPresent ? this.value : d;
    }

    public double orElseGet(java8.util.function.DoubleSupplier doubleSupplier) {
        return this.isPresent ? this.value : doubleSupplier.getAsDouble();
    }

    public double orElseThrow() {
        if (!this.isPresent) {
            throw new java.util.NoSuchElementException("No value present");
        }
        return this.value;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public <X extends java.lang.Throwable> double orElseThrow(java8.util.function.Supplier<? extends X> supplier) throws java.lang.Throwable {
        if (this.isPresent) {
            return this.value;
        }
        throw supplier.get();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java8.util.OptionalDouble)) {
            return false;
        }
        java8.util.OptionalDouble optionalDouble = (java8.util.OptionalDouble) obj;
        boolean z = this.isPresent;
        if (z && optionalDouble.isPresent) {
            if (java.lang.Double.compare(this.value, optionalDouble.value) == 0) {
                return true;
            }
        } else if (z == optionalDouble.isPresent) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.isPresent) {
            return java8.lang.Doubles.hashCode(this.value);
        }
        return 0;
    }

    public java.lang.String toString() {
        return this.isPresent ? java.lang.String.format("OptionalDouble[%s]", java.lang.Double.valueOf(this.value)) : "OptionalDouble.empty";
    }
}
