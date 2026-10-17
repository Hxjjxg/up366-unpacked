package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ConcurrentMaps {
    public static <K, V> V merge(java.util.concurrent.ConcurrentMap<K, V> concurrentMap, K k, V v, java8.util.function.BiFunction<? super V, ? super V, ? extends V> biFunction) {
        java8.util.Objects.requireNonNull(concurrentMap);
        java8.util.Objects.requireNonNull(biFunction);
        java8.util.Objects.requireNonNull(v);
        while (true) {
            V v2 = (java.lang.Object) concurrentMap.get(k);
            while (v2 == null) {
                v2 = (java.lang.Object) concurrentMap.putIfAbsent(k, v);
                if (v2 == null) {
                    return v;
                }
            }
            V vApply = biFunction.apply(v2, v);
            if (vApply != null) {
                if (concurrentMap.replace(k, v2, vApply)) {
                    return vApply;
                }
            } else if (concurrentMap.remove(k, v2)) {
                return null;
            }
        }
    }

    public static <K, V> V computeIfAbsent(java.util.concurrent.ConcurrentMap<K, V> concurrentMap, K k, java8.util.function.Function<? super K, ? extends V> function) {
        V vApply;
        java8.util.Objects.requireNonNull(concurrentMap);
        java8.util.Objects.requireNonNull(function);
        V vPutIfAbsent = concurrentMap.get(k);
        return (vPutIfAbsent == null && (vApply = function.apply(k)) != null && (vPutIfAbsent = concurrentMap.putIfAbsent(k, vApply)) == null) ? vApply : vPutIfAbsent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> V computeIfPresent(java.util.concurrent.ConcurrentMap<K, V> concurrentMap, K k, java8.util.function.BiFunction<? super K, ? super V, ? extends V> biFunction) {
        V vApply;
        java8.util.Objects.requireNonNull(concurrentMap);
        java8.util.Objects.requireNonNull(biFunction);
        while (true) {
            android.R.bool boolVar = (java.lang.Object) concurrentMap.get(k);
            if (boolVar == 0) {
                return null;
            }
            vApply = biFunction.apply(k, boolVar);
            if (vApply == null) {
                if (concurrentMap.remove(k, boolVar)) {
                    break;
                }
            } else if (concurrentMap.replace(k, boolVar, vApply)) {
                break;
            }
        }
        return vApply;
    }

    public static <K, V> V compute(java.util.concurrent.ConcurrentMap<K, V> concurrentMap, K k, java8.util.function.BiFunction<? super K, ? super V, ? extends V> biFunction) {
        V vApply;
        java8.util.Objects.requireNonNull(concurrentMap);
        while (true) {
            V v = (java.lang.Object) concurrentMap.get(k);
            do {
                vApply = biFunction.apply(k, v);
                if (vApply != null) {
                    if (v != null) {
                        if (concurrentMap.replace(k, v, vApply)) {
                            return vApply;
                        }
                    } else {
                        v = (java.lang.Object) concurrentMap.putIfAbsent(k, vApply);
                    }
                } else if (v == null || concurrentMap.remove(k, v)) {
                    return null;
                }
            } while (v != null);
            return vApply;
        }
    }

    public static <K, V> void replaceAll(java.util.concurrent.ConcurrentMap<K, V> concurrentMap, java8.util.function.BiFunction<? super K, ? super V, ? extends V> biFunction) {
        java8.util.Objects.requireNonNull(concurrentMap);
        java8.util.Objects.requireNonNull(biFunction);
        forEach(concurrentMap, java8.util.concurrent.ConcurrentMaps$$Lambda$1.lambdaFactory$(concurrentMap, biFunction));
    }

    static /* synthetic */ void lambda$replaceAll$132(java.util.concurrent.ConcurrentMap concurrentMap, java8.util.function.BiFunction biFunction, java.lang.Object obj, java.lang.Object obj2) {
        while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
        }
    }

    public static <K, V> V getOrDefault(java.util.concurrent.ConcurrentMap<K, V> concurrentMap, java.lang.Object obj, V v) {
        java8.util.Objects.requireNonNull(concurrentMap);
        V v2 = concurrentMap.get(obj);
        return v2 != null ? v2 : v;
    }

    public static <K, V> void forEach(java.util.concurrent.ConcurrentMap<K, V> concurrentMap, java8.util.function.BiConsumer<? super K, ? super V> biConsumer) {
        java8.util.Objects.requireNonNull(concurrentMap);
        java8.util.Objects.requireNonNull(biConsumer);
        for (java.util.Map.Entry<K, V> entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (java.lang.IllegalStateException unused) {
            }
        }
    }

    private ConcurrentMaps() {
    }
}
