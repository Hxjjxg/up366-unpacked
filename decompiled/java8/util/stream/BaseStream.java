package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface BaseStream<T, S extends java8.util.stream.BaseStream<T, S>> {
    void close();

    boolean isParallel();

    java.util.Iterator<T> iterator();

    S onClose(java.lang.Runnable runnable);

    S parallel();

    S sequential();

    /* JADX INFO: renamed from: spliterator */
    java8.util.Spliterator<T> spliterator2();

    S unordered();
}
