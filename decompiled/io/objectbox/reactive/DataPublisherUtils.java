package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DataPublisherUtils {
    public static <T> void removeObserverFromCopyOnWriteSet(java.util.Set<io.objectbox.reactive.DataObserver<T>> set, io.objectbox.reactive.DataObserver<T> dataObserver) {
        if (set != null) {
            for (io.objectbox.reactive.DataObserver<T> dataObserver2 : set) {
                if (dataObserver2.equals(dataObserver)) {
                    set.remove(dataObserver2);
                } else if (dataObserver2 instanceof io.objectbox.reactive.DelegatingObserver) {
                    io.objectbox.reactive.DataObserver<T> observerDelegate = dataObserver2;
                    while (observerDelegate instanceof io.objectbox.reactive.DelegatingObserver) {
                        observerDelegate = ((io.objectbox.reactive.DelegatingObserver) observerDelegate).getObserverDelegate();
                    }
                    if (observerDelegate == null || observerDelegate.equals(dataObserver)) {
                        set.remove(dataObserver2);
                    }
                }
            }
        }
    }
}
