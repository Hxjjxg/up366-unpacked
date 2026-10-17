package java8.lang;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Iterables {
    public static <T> void forEach(java.lang.Iterable<? extends T> iterable, java8.util.function.Consumer<? super T> consumer) {
        java8.util.Objects.requireNonNull(iterable);
        java8.util.Objects.requireNonNull(consumer);
        java.util.Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static <T> boolean removeIf(java.lang.Iterable<? extends T> iterable, java8.util.function.Predicate<? super T> predicate) {
        java8.util.Objects.requireNonNull(iterable);
        java8.util.Objects.requireNonNull(predicate);
        java.util.Iterator<? extends T> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> java8.util.Spliterator<T> spliterator(java.lang.Iterable<? extends T> iterable) {
        if (iterable instanceof java.util.Collection) {
            return java8.util.Spliterators.spliterator((java.util.Collection) iterable);
        }
        return java8.util.Spliterators.spliteratorUnknownSize(iterable.iterator(), 0);
    }

    private Iterables() {
    }
}
