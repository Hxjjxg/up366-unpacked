package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
abstract class BaseKeyPool<T extends com.up366.medialibrary.common.io.PoolAble> {
    private static final int MAX_SIZE = 20;
    private final java.util.Queue<T> keyPool = createQueue(20);

    abstract T create();

    BaseKeyPool() {
    }

    T get() {
        T tPoll = this.keyPool.poll();
        return tPoll == null ? (T) create() : tPoll;
    }

    public void offer(T t) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t);
        }
    }

    public static <T> java.util.Queue<T> createQueue(int i) {
        return new java.util.ArrayDeque(i);
    }
}
