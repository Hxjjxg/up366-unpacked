package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class DelegatingSpliterator<T> implements java8.util.Spliterator<T> {
    private final java.util.Spliterator<T> spliter;

    DelegatingSpliterator(java.util.Spliterator<T> spliterator) {
        java8.util.Objects.requireNonNull(spliterator);
        this.spliter = spliterator;
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
        return this.spliter.tryAdvance(new java8.util.DelegatingSpliterator.ConsumerDelegate(consumer));
    }

    @Override // java8.util.Spliterator
    public java8.util.Spliterator<T> trySplit() {
        java.util.Spliterator spliteratorTrySplit = this.spliter.trySplit();
        if (spliteratorTrySplit == null) {
            return null;
        }
        return new java8.util.DelegatingSpliterator(spliteratorTrySplit);
    }

    @Override // java8.util.Spliterator
    public long estimateSize() {
        return this.spliter.estimateSize();
    }

    @Override // java8.util.Spliterator
    public int characteristics() {
        return this.spliter.characteristics();
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
        this.spliter.forEachRemaining(new java8.util.DelegatingSpliterator.ConsumerDelegate(consumer));
    }

    @Override // java8.util.Spliterator
    public long getExactSizeIfKnown() {
        return this.spliter.getExactSizeIfKnown();
    }

    @Override // java8.util.Spliterator
    public boolean hasCharacteristics(int i) {
        return this.spliter.hasCharacteristics(i);
    }

    @Override // java8.util.Spliterator
    public java.util.Comparator<? super T> getComparator() {
        return this.spliter.getComparator();
    }

    private static final class ConsumerDelegate<T> implements java.util.function.Consumer<T> {
        private final java8.util.function.Consumer<T> delegate;

        ConsumerDelegate(java8.util.function.Consumer<T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            this.delegate = consumer;
        }

        @Override // java.util.function.Consumer
        public void accept(T t) {
            this.delegate.accept(t);
        }

        @Override // java.util.function.Consumer
        public java.util.function.Consumer<T> andThen(final java.util.function.Consumer<? super T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            return new java8.util.DelegatingSpliterator.ConsumerDelegate(java8.util.function.Consumers.andThen(this.delegate, new java8.util.function.Consumer<T>() { // from class: java8.util.DelegatingSpliterator.ConsumerDelegate.1
                @Override // java8.util.function.Consumer
                public void accept(T t) {
                    com.alibaba.fastjson2.JSON$.ExternalSyntheticApiModelOutline0.m(consumer, t);
                }
            }));
        }
    }
}
