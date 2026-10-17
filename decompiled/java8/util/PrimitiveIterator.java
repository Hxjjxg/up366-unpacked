package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface PrimitiveIterator<T, T_CONS> extends java.util.Iterator<T> {

    public interface OfDouble extends java8.util.PrimitiveIterator<java.lang.Double, java8.util.function.DoubleConsumer> {
        void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer);

        @Override // java.util.Iterator
        java.lang.Double next();

        double nextDouble();
    }

    public interface OfInt extends java8.util.PrimitiveIterator<java.lang.Integer, java8.util.function.IntConsumer> {
        void forEachRemaining(java8.util.function.IntConsumer intConsumer);

        @Override // java.util.Iterator
        java.lang.Integer next();

        int nextInt();
    }

    public interface OfLong extends java8.util.PrimitiveIterator<java.lang.Long, java8.util.function.LongConsumer> {
        void forEachRemaining(java8.util.function.LongConsumer longConsumer);

        @Override // java.util.Iterator
        java.lang.Long next();

        long nextLong();
    }

    void forEachRemaining(T_CONS t_cons);
}
