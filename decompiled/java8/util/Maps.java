package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Maps {
    public static <K, V> V putIfAbsent(java.util.Map<K, V> map, K k, V v) {
        java8.util.Objects.requireNonNull(map);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return (V) ((java.util.concurrent.ConcurrentMap) map).putIfAbsent(k, v);
        }
        V v2 = map.get(k);
        return v2 == null ? map.put(k, v) : v2;
    }

    public static <K, V> V getOrDefault(java.util.Map<K, V> map, java.lang.Object obj, V v) {
        java8.util.Objects.requireNonNull(map);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return (V) java8.util.concurrent.ConcurrentMaps.getOrDefault((java.util.concurrent.ConcurrentMap) map, obj, v);
        }
        V v2 = map.get(obj);
        return (v2 != null || map.containsKey(obj)) ? v2 : v;
    }

    public static <K, V> void forEach(java.util.Map<K, V> map, java8.util.function.BiConsumer<? super K, ? super V> biConsumer) {
        java8.util.Objects.requireNonNull(map);
        java8.util.Objects.requireNonNull(biConsumer);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            java8.util.concurrent.ConcurrentMaps.forEach((java.util.concurrent.ConcurrentMap) map, biConsumer);
            return;
        }
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (java.lang.IllegalStateException e) {
                java.util.ConcurrentModificationException concurrentModificationException = new java.util.ConcurrentModificationException();
                concurrentModificationException.initCause(e);
                throw concurrentModificationException;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [V, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [V, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static <K, V> V merge(java.util.Map<K, V> map, K k, V v, java8.util.function.BiFunction<? super V, ? super V, ? extends V> biFunction) {
        java8.util.Objects.requireNonNull(map);
        java8.util.Objects.requireNonNull(biFunction);
        java8.util.Objects.requireNonNull(v);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return (V) java8.util.concurrent.ConcurrentMaps.merge((java.util.concurrent.ConcurrentMap) map, k, v, biFunction);
        }
        java.lang.Object obj = (java.lang.Object) map.get(k);
        ?? Apply = v;
        if (obj != null) {
            Apply = biFunction.apply(obj, v);
        }
        if (Apply == 0) {
            map.remove(k);
        } else {
            map.put(k, (java.lang.Object) Apply);
        }
        return (V) Apply;
    }

    public static <K, V> V computeIfAbsent(java.util.Map<K, V> map, K k, java8.util.function.Function<? super K, ? extends V> function) {
        V vApply;
        java8.util.Objects.requireNonNull(map);
        java8.util.Objects.requireNonNull(function);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return (V) java8.util.concurrent.ConcurrentMaps.computeIfAbsent((java.util.concurrent.ConcurrentMap) map, k, function);
        }
        V v = map.get(k);
        if (v != null || (vApply = function.apply(k)) == null) {
            return v;
        }
        map.put(k, vApply);
        return vApply;
    }

    public static <K, V> boolean replace(java.util.Map<K, V> map, K k, V v, V v2) {
        java8.util.Objects.requireNonNull(map);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return ((java.util.concurrent.ConcurrentMap) map).replace(k, v, v2);
        }
        V v3 = map.get(k);
        if (!java8.util.Objects.equals(v3, v)) {
            return false;
        }
        if (v3 == null && !map.containsKey(k)) {
            return false;
        }
        map.put(k, v2);
        return true;
    }

    public static <K, V> V replace(java.util.Map<K, V> map, K k, V v) {
        java8.util.Objects.requireNonNull(map);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return (V) ((java.util.concurrent.ConcurrentMap) map).replace(k, v);
        }
        V v2 = map.get(k);
        return (v2 != null || map.containsKey(k)) ? map.put(k, v) : v2;
    }

    public static <K, V> void replaceAll(java.util.Map<K, V> map, java8.util.function.BiFunction<? super K, ? super V, ? extends V> biFunction) {
        java8.util.Objects.requireNonNull(map);
        java8.util.Objects.requireNonNull(biFunction);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            java8.util.concurrent.ConcurrentMaps.replaceAll((java.util.concurrent.ConcurrentMap) map, biFunction);
            return;
        }
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            try {
                try {
                    entry.setValue(biFunction.apply(entry.getKey(), entry.getValue()));
                } catch (java.lang.IllegalStateException e) {
                    java.util.ConcurrentModificationException concurrentModificationException = new java.util.ConcurrentModificationException();
                    concurrentModificationException.initCause(e);
                    throw concurrentModificationException;
                }
            } catch (java.lang.IllegalStateException e2) {
                java.util.ConcurrentModificationException concurrentModificationException2 = new java.util.ConcurrentModificationException();
                concurrentModificationException2.initCause(e2);
                throw concurrentModificationException2;
            }
        }
    }

    public static <K, V> V compute(java.util.Map<K, V> map, K k, java8.util.function.BiFunction<? super K, ? super V, ? extends V> biFunction) {
        java8.util.Objects.requireNonNull(map);
        java8.util.Objects.requireNonNull(biFunction);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return (V) java8.util.concurrent.ConcurrentMaps.compute((java.util.concurrent.ConcurrentMap) map, k, biFunction);
        }
        V v = map.get(k);
        V vApply = biFunction.apply(k, v);
        if (vApply == null) {
            if (v == null && !map.containsKey(k)) {
                return null;
            }
            map.remove(k);
            return null;
        }
        map.put(k, vApply);
        return vApply;
    }

    public static <K, V> V computeIfPresent(java.util.Map<K, V> map, K k, java8.util.function.BiFunction<? super K, ? super V, ? extends V> biFunction) {
        java8.util.Objects.requireNonNull(map);
        java8.util.Objects.requireNonNull(biFunction);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return (V) java8.util.concurrent.ConcurrentMaps.computeIfPresent((java.util.concurrent.ConcurrentMap) map, k, biFunction);
        }
        V v = map.get(k);
        if (v != null) {
            V vApply = biFunction.apply(k, v);
            if (vApply != null) {
                map.put(k, vApply);
                return vApply;
            }
            map.remove(k);
        }
        return null;
    }

    public static <K, V> boolean remove(java.util.Map<K, V> map, java.lang.Object obj, java.lang.Object obj2) {
        java8.util.Objects.requireNonNull(map);
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            return ((java.util.concurrent.ConcurrentMap) map).remove(obj, obj2);
        }
        V v = map.get(obj);
        if (!java8.util.Objects.equals(v, obj2)) {
            return false;
        }
        if (v == null && !map.containsKey(obj)) {
            return false;
        }
        map.remove(obj);
        return true;
    }

    public static final class Entry {
        public static <K extends java.lang.Comparable<? super K>, V> java.util.Comparator<java.util.Map.Entry<K, V>> comparingByKey() {
            return (java.util.Comparator) ((java.io.Serializable) java8.util.Maps$Entry$$Lambda$1.instance);
        }

        public static <K, V extends java.lang.Comparable<? super V>> java.util.Comparator<java.util.Map.Entry<K, V>> comparingByValue() {
            return (java.util.Comparator) ((java.io.Serializable) java8.util.Maps$Entry$$Lambda$2.instance);
        }

        static /* synthetic */ int lambda$comparingByValue$1065357e$1(java.util.Map.Entry entry, java.util.Map.Entry entry2) {
            return ((java.lang.Comparable) entry.getValue()).compareTo(entry2.getValue());
        }

        public static <K, V> java.util.Comparator<java.util.Map.Entry<K, V>> comparingByKey(java.util.Comparator<? super K> comparator) {
            java8.util.Objects.requireNonNull(comparator);
            return (java.util.Comparator) ((java.io.Serializable) java8.util.Maps$Entry$$Lambda$3.lambdaFactory$(comparator));
        }

        static /* synthetic */ int lambda$comparingByKey$6d558cbf$1(java.util.Comparator comparator, java.util.Map.Entry entry, java.util.Map.Entry entry2) {
            return comparator.compare(entry.getKey(), entry2.getKey());
        }

        public static <K, V> java.util.Comparator<java.util.Map.Entry<K, V>> comparingByValue(java.util.Comparator<? super V> comparator) {
            java8.util.Objects.requireNonNull(comparator);
            return (java.util.Comparator) ((java.io.Serializable) java8.util.Maps$Entry$$Lambda$4.lambdaFactory$(comparator));
        }

        static /* synthetic */ int lambda$comparingByValue$827a17d5$1(java.util.Comparator comparator, java.util.Map.Entry entry, java.util.Map.Entry entry2) {
            return comparator.compare(entry.getValue(), entry2.getValue());
        }

        private Entry() {
        }
    }

    public static <K, V> java.util.Map<K, V> of() {
        return java8.util.ImmutableCollections.EMPTY_MAP;
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v) {
        return new java8.util.ImmutableCollections.Map1(k, v);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    public static <K, V> java.util.Map<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return new java8.util.ImmutableCollections.MapN(k, v, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    public static <K, V> java.util.Map<K, V> ofEntries(java.util.Map.Entry<? extends K, ? extends V>... entryArr) {
        if (entryArr.length == 0) {
            return java8.util.ImmutableCollections.EMPTY_MAP;
        }
        if (entryArr.length == 1) {
            return new java8.util.ImmutableCollections.Map1(entryArr[0].getKey(), entryArr[0].getValue());
        }
        java.lang.Object[] objArr = new java.lang.Object[entryArr.length << 1];
        int i = 0;
        for (java.util.Map.Entry<? extends K, ? extends V> entry : entryArr) {
            int i2 = i + 1;
            objArr[i] = entry.getKey();
            i += 2;
            objArr[i2] = entry.getValue();
        }
        return new java8.util.ImmutableCollections.MapN(objArr);
    }

    public static <K, V> java.util.Map.Entry<K, V> entry(K k, V v) {
        return new java8.util.KeyValueHolder(k, v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> java.util.Map<K, V> copyOf(java.util.Map<? extends K, ? extends V> map) {
        return map instanceof java8.util.ImmutableCollections.AbstractImmutableMap ? map : ofEntries((java.util.Map.Entry[]) map.entrySet().toArray(new java.util.Map.Entry[0]));
    }

    private Maps() {
    }
}
