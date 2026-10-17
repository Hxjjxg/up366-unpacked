package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Optional<T> {
    private static final java8.util.Optional<?> EMPTY = new java8.util.Optional<>(null);
    private final T value;

    public static <T> java8.util.Optional<T> empty() {
        return (java8.util.Optional<T>) EMPTY;
    }

    private Optional(T t) {
        this.value = t;
    }

    public static <T> java8.util.Optional<T> of(T t) {
        return new java8.util.Optional<>(java8.util.Objects.requireNonNull(t));
    }

    public static <T> java8.util.Optional<T> ofNullable(T t) {
        return t == null ? (java8.util.Optional<T>) EMPTY : new java8.util.Optional<>(t);
    }

    public T get() {
        return orElseThrow();
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public void ifPresent(java8.util.function.Consumer<? super T> consumer) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        }
    }

    public void ifPresentOrElse(java8.util.function.Consumer<? super T> consumer, java.lang.Runnable runnable) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        } else {
            runnable.run();
        }
    }

    public java8.util.Optional<T> filter(java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(predicate);
        if (isPresent() && !predicate.test(this.value)) {
            return empty();
        }
        return this;
    }

    public <U> java8.util.Optional<U> map(java8.util.function.Function<? super T, ? extends U> function) {
        java8.util.Objects.requireNonNull(function);
        if (!isPresent()) {
            return empty();
        }
        return ofNullable(function.apply(this.value));
    }

    public <U> java8.util.Optional<U> flatMap(java8.util.function.Function<? super T, ? extends java8.util.Optional<? extends U>> function) {
        java8.util.Objects.requireNonNull(function);
        if (!isPresent()) {
            return empty();
        }
        return (java8.util.Optional) java8.util.Objects.requireNonNull(function.apply(this.value));
    }

    public java8.util.Optional<T> or(java8.util.function.Supplier<? extends java8.util.Optional<? extends T>> supplier) {
        java8.util.Objects.requireNonNull(supplier);
        return isPresent() ? this : (java8.util.Optional) java8.util.Objects.requireNonNull(supplier.get());
    }

    public java8.util.stream.Stream<T> stream() {
        if (!isPresent()) {
            return java8.util.stream.RefStreams.empty();
        }
        return java8.util.stream.RefStreams.of(this.value);
    }

    public T orElse(T t) {
        T t2 = this.value;
        return t2 != null ? t2 : t;
    }

    public T orElseGet(java8.util.function.Supplier<? extends T> supplier) {
        T t = this.value;
        return t != null ? t : supplier.get();
    }

    public T orElseThrow() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new java.util.NoSuchElementException("No value present");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public <X extends java.lang.Throwable> T orElseThrow(java8.util.function.Supplier<? extends X> supplier) throws java.lang.Throwable {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw supplier.get();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof java8.util.Optional) {
            return java8.util.Objects.equals(this.value, ((java8.util.Optional) obj).value);
        }
        return false;
    }

    public int hashCode() {
        return java8.util.Objects.hashCode(this.value);
    }

    public java.lang.String toString() {
        T t = this.value;
        return t != null ? java.lang.String.format("Optional[%s]", t) : "Optional.empty";
    }
}
