package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface Scheduler {
    <T> void run(io.objectbox.reactive.RunWithParam<T> runWithParam, T t);
}
