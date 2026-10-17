package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
interface Node<T> {

    public interface Builder<T> extends java8.util.stream.Sink<T> {

        public interface OfDouble extends java8.util.stream.Node.Builder<java.lang.Double>, java8.util.stream.Sink.OfDouble {
            @Override // java8.util.stream.Node.Builder
            /* JADX INFO: renamed from: build */
            java8.util.stream.Node<java.lang.Double> build2();
        }

        public interface OfInt extends java8.util.stream.Node.Builder<java.lang.Integer>, java8.util.stream.Sink.OfInt {
            @Override // java8.util.stream.Node.Builder
            /* JADX INFO: renamed from: build */
            java8.util.stream.Node<java.lang.Integer> build2();
        }

        public interface OfLong extends java8.util.stream.Node.Builder<java.lang.Long>, java8.util.stream.Sink.OfLong {
            @Override // java8.util.stream.Node.Builder
            /* JADX INFO: renamed from: build */
            java8.util.stream.Node<java.lang.Long> build2();
        }

        /* JADX INFO: renamed from: build */
        java8.util.stream.Node<T> build2();
    }

    public interface OfDouble extends java8.util.stream.Node.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, double[], java8.util.Spliterator.OfDouble, java8.util.stream.Node.OfDouble> {
        void copyInto(java.lang.Double[] dArr, int i);

        @Override // java8.util.stream.Node
        void forEach(java8.util.function.Consumer<? super java.lang.Double> consumer);

        @Override // java8.util.stream.Node
        java8.util.stream.StreamShape getShape();

        @Override // java8.util.stream.Node.OfPrimitive
        double[] newArray(int i);

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        java8.util.stream.Node.OfDouble truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Double[]> intFunction);
    }

    public interface OfInt extends java8.util.stream.Node.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, int[], java8.util.Spliterator.OfInt, java8.util.stream.Node.OfInt> {
        void copyInto(java.lang.Integer[] numArr, int i);

        @Override // java8.util.stream.Node
        void forEach(java8.util.function.Consumer<? super java.lang.Integer> consumer);

        @Override // java8.util.stream.Node
        java8.util.stream.StreamShape getShape();

        @Override // java8.util.stream.Node.OfPrimitive
        int[] newArray(int i);

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        java8.util.stream.Node.OfInt truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Integer[]> intFunction);
    }

    public interface OfLong extends java8.util.stream.Node.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, long[], java8.util.Spliterator.OfLong, java8.util.stream.Node.OfLong> {
        void copyInto(java.lang.Long[] lArr, int i);

        @Override // java8.util.stream.Node
        void forEach(java8.util.function.Consumer<? super java.lang.Long> consumer);

        @Override // java8.util.stream.Node
        java8.util.stream.StreamShape getShape();

        @Override // java8.util.stream.Node.OfPrimitive
        long[] newArray(int i);

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        java8.util.stream.Node.OfLong truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Long[]> intFunction);
    }

    public interface OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends java8.util.stream.Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends java8.util.stream.Node<T> {
        @Override // java8.util.stream.Node
        T[] asArray(java8.util.function.IntFunction<T[]> intFunction);

        T_ARR asPrimitiveArray();

        void copyInto(T_ARR t_arr, int i);

        void forEach(T_CONS t_cons);

        @Override // java8.util.stream.Node
        T_NODE getChild(int i);

        T_ARR newArray(int i);

        @Override // java8.util.stream.Node
        T_SPLITR spliterator();

        @Override // java8.util.stream.Node
        T_NODE truncate(long j, long j2, java8.util.function.IntFunction<T[]> intFunction);
    }

    T[] asArray(java8.util.function.IntFunction<T[]> intFunction);

    void copyInto(T[] tArr, int i);

    long count();

    void forEach(java8.util.function.Consumer<? super T> consumer);

    java8.util.stream.Node<T> getChild(int i);

    int getChildCount();

    java8.util.stream.StreamShape getShape();

    java8.util.Spliterator<T> spliterator();

    java8.util.stream.Node<T> truncate(long j, long j2, java8.util.function.IntFunction<T[]> intFunction);
}
