package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Iterators {
    public static <E> void forEachRemaining(java.util.Iterator<E> it, java8.util.function.Consumer<? super E> consumer) {
        java8.util.Objects.requireNonNull(it);
        java8.util.Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static void forEachRemaining(java8.util.PrimitiveIterator.OfInt ofInt, java8.util.function.IntConsumer intConsumer) {
        java8.util.Objects.requireNonNull(ofInt);
        java8.util.Objects.requireNonNull(intConsumer);
        while (ofInt.hasNext()) {
            intConsumer.accept(ofInt.nextInt());
        }
    }

    public static void forEachRemaining(java8.util.PrimitiveIterator.OfLong ofLong, java8.util.function.LongConsumer longConsumer) {
        java8.util.Objects.requireNonNull(ofLong);
        java8.util.Objects.requireNonNull(longConsumer);
        while (ofLong.hasNext()) {
            longConsumer.accept(ofLong.nextLong());
        }
    }

    public static void forEachRemaining(java8.util.PrimitiveIterator.OfDouble ofDouble, java8.util.function.DoubleConsumer doubleConsumer) {
        java8.util.Objects.requireNonNull(ofDouble);
        java8.util.Objects.requireNonNull(doubleConsumer);
        while (ofDouble.hasNext()) {
            doubleConsumer.accept(ofDouble.nextDouble());
        }
    }

    public static <E> java.util.Iterator<E> asIterator(final java.util.Enumeration<E> enumeration) {
        java8.util.Objects.requireNonNull(enumeration);
        return new java8.util.Iterators.ImmutableIt<E>() { // from class: java8.util.Iterators.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override // java.util.Iterator
            public E next() {
                return (E) enumeration.nextElement();
            }
        };
    }

    public static <T> java.util.Iterator<T> emptyIterator() {
        return java8.util.Iterators.EmptyIt.EMPTY_ITERATOR;
    }

    static <E> java.util.Iterator<E> singletonIterator(final E e) {
        return new java8.util.Iterators.ImmutableIt<E>() { // from class: java8.util.Iterators.2
            private boolean hasNext = true;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.hasNext;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.hasNext) {
                    this.hasNext = false;
                    return (E) e;
                }
                throw new java.util.NoSuchElementException();
            }
        };
    }

    static final class EmptyIt<E> extends java8.util.Iterators.ImmutableIt<E> {
        static final java8.util.Iterators.EmptyIt<java.lang.Object> EMPTY_ITERATOR = new java8.util.Iterators.EmptyIt<>();

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        EmptyIt() {
        }

        @Override // java.util.Iterator
        public E next() {
            throw new java.util.NoSuchElementException();
        }
    }

    static abstract class ImmutableIt<T> implements java.util.Iterator<T> {
        ImmutableIt() {
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove");
        }
    }

    private Iterators() {
    }
}
