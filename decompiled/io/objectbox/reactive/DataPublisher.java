package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface DataPublisher<T> {
    void publishSingle(io.objectbox.reactive.DataObserver<T> dataObserver, @javax.annotation.Nullable java.lang.Object obj);

    void subscribe(io.objectbox.reactive.DataObserver<T> dataObserver, @javax.annotation.Nullable java.lang.Object obj);

    void unsubscribe(io.objectbox.reactive.DataObserver<T> dataObserver, @javax.annotation.Nullable java.lang.Object obj);
}
