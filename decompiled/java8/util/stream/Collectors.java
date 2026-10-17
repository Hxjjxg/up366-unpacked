package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Collectors {
    static final java.util.Set<java8.util.stream.Collector.Characteristics> CH_CONCURRENT_ID = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(java8.util.stream.Collector.Characteristics.CONCURRENT, java8.util.stream.Collector.Characteristics.UNORDERED, java8.util.stream.Collector.Characteristics.IDENTITY_FINISH));
    static final java.util.Set<java8.util.stream.Collector.Characteristics> CH_CONCURRENT_NOID = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(java8.util.stream.Collector.Characteristics.CONCURRENT, java8.util.stream.Collector.Characteristics.UNORDERED));
    static final java.util.Set<java8.util.stream.Collector.Characteristics> CH_ID = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH));
    static final java.util.Set<java8.util.stream.Collector.Characteristics> CH_UNORDERED_ID = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(java8.util.stream.Collector.Characteristics.UNORDERED, java8.util.stream.Collector.Characteristics.IDENTITY_FINISH));
    static final java.util.Set<java8.util.stream.Collector.Characteristics> CH_NOID = java.util.Collections.emptySet();
    static final java.util.Set<java8.util.stream.Collector.Characteristics> CH_UNORDERED_NOID = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(java8.util.stream.Collector.Characteristics.UNORDERED));
    static final java8.util.function.Supplier<java8.util.DoubleSummaryStatistics> DBL_SUM_STATS = java8.util.stream.Collectors$$Lambda$91.instance;
    static final java8.util.function.Supplier<java8.util.IntSummaryStatistics> INT_SUM_STATS = java8.util.stream.Collectors$$Lambda$92.instance;
    static final java8.util.function.Supplier<java8.util.LongSummaryStatistics> LNG_SUM_STATS = java8.util.stream.Collectors$$Lambda$93.instance;
    private static final java8.util.function.Function<java.util.Map<?, ?>, java.util.Map<?, ?>> UNMOD_MAP_FINISHER = java8.util.stream.Collectors$$Lambda$94.instance;
    private static final java8.util.function.BiConsumer<java.util.List<java.lang.Object>, ?> LIST_ADD = java8.util.stream.Collectors$$Lambda$95.instance;
    private static final java8.util.function.BiConsumer<java.util.Set<java.lang.Object>, ?> SET_ADD = java8.util.stream.Collectors$$Lambda$96.instance;

    static /* synthetic */ long lambda$counting$19(java.lang.Object obj) {
        return 1L;
    }

    private Collectors() {
    }

    private static <K, V> java8.util.function.Supplier<java.util.Map<K, V>> hashMapNew() {
        return java8.util.stream.Collectors$$Lambda$1.instance;
    }

    private static <K, V> java8.util.function.Supplier<java.util.concurrent.ConcurrentMap<K, V>> concHashMapNew() {
        return java8.util.stream.Collectors$$Lambda$2.instance;
    }

    private static <K, V> java8.util.function.Supplier<java.util.Map<K, V>> concHashMapNew2() {
        return concHashMapNew();
    }

    private static <T> java8.util.function.Supplier<java.util.List<T>> arrayListNew() {
        return java8.util.stream.Collectors$$Lambda$3.instance;
    }

    private static <T> java8.util.function.Supplier<java.util.Set<T>> hashSetNew() {
        return java8.util.stream.Collectors$$Lambda$4.instance;
    }

    static /* synthetic */ java.util.Map lambda$static$0(java.util.Map map) {
        return java8.util.Maps.ofEntries((java.util.Map.Entry[]) map.entrySet().toArray(new java.util.Map.Entry[0]));
    }

    private static final <K, U> java8.util.function.Function<java.util.Map<K, U>, java.util.Map<K, U>> unmodMapFinisher() {
        return (java8.util.function.Function<java.util.Map<K, U>, java.util.Map<K, U>>) UNMOD_MAP_FINISHER;
    }

    private static final <T> java8.util.function.BiConsumer<java.util.List<T>, T> listAdd() {
        return (java8.util.function.BiConsumer<java.util.List<T>, T>) LIST_ADD;
    }

    private static final <T> java8.util.function.BiConsumer<java.util.Set<T>, T> setAdd() {
        return (java8.util.function.BiConsumer<java.util.Set<T>, T>) SET_ADD;
    }

    public static <T, R> java8.util.stream.Collector<T, R, R> of(java8.util.function.Supplier<R> supplier, java8.util.function.BiConsumer<R, T> biConsumer, java8.util.function.BinaryOperator<R> binaryOperator, java8.util.stream.Collector.Characteristics... characteristicsArr) {
        java8.util.Objects.requireNonNull(supplier);
        java8.util.Objects.requireNonNull(biConsumer);
        java8.util.Objects.requireNonNull(binaryOperator);
        java8.util.Objects.requireNonNull(characteristicsArr);
        return new java8.util.stream.Collectors.CollectorImpl(supplier, biConsumer, binaryOperator, characteristicsArr.length == 0 ? CH_ID : java.util.Collections.unmodifiableSet(java.util.EnumSet.of(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH, characteristicsArr)));
    }

    public static <T, A, R> java8.util.stream.Collector<T, A, R> of(java8.util.function.Supplier<A> supplier, java8.util.function.BiConsumer<A, T> biConsumer, java8.util.function.BinaryOperator<A> binaryOperator, java8.util.function.Function<A, R> function, java8.util.stream.Collector.Characteristics... characteristicsArr) {
        java8.util.Objects.requireNonNull(supplier);
        java8.util.Objects.requireNonNull(biConsumer);
        java8.util.Objects.requireNonNull(binaryOperator);
        java8.util.Objects.requireNonNull(function);
        java8.util.Objects.requireNonNull(characteristicsArr);
        java.util.Set<java8.util.stream.Collector.Characteristics> setUnmodifiableSet = CH_NOID;
        if (characteristicsArr.length > 0) {
            java.util.EnumSet enumSetNoneOf = java.util.EnumSet.noneOf(java8.util.stream.Collector.Characteristics.class);
            java.util.Collections.addAll(enumSetNoneOf, characteristicsArr);
            setUnmodifiableSet = java.util.Collections.unmodifiableSet(enumSetNoneOf);
        }
        return new java8.util.stream.Collectors.CollectorImpl(supplier, biConsumer, binaryOperator, function, setUnmodifiableSet);
    }

    private static java.lang.IllegalStateException duplicateKeyException(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        return new java.lang.IllegalStateException(java.lang.String.format("Duplicate key %s (attempted merging values %s and %s)", obj, obj2, obj3));
    }

    private static <K, V, M extends java.util.Map<K, V>> java8.util.function.BinaryOperator<M> uniqKeysMapMerger() {
        return java8.util.stream.Collectors$$Lambda$5.instance;
    }

    static /* synthetic */ java.util.Map lambda$uniqKeysMapMerger$1(java.util.Map map, java.util.Map map2) {
        java.lang.Object objPutIfAbsent;
        for (java.util.Map.Entry entry : map2.entrySet()) {
            java.lang.Object key = entry.getKey();
            java.lang.Object objRequireNonNull = java8.util.Objects.requireNonNull(entry.getValue());
            if (map instanceof java.util.concurrent.ConcurrentMap) {
                objPutIfAbsent = ((java.util.concurrent.ConcurrentMap) map).putIfAbsent(key, objRequireNonNull);
            } else {
                objPutIfAbsent = java8.util.Maps.putIfAbsent(map, key, objRequireNonNull);
            }
            if (objPutIfAbsent != null) {
                throw duplicateKeyException(key, objPutIfAbsent, objRequireNonNull);
            }
        }
        return map;
    }

    private static <T, K, V> java8.util.function.BiConsumer<java.util.Map<K, V>, T> uniqKeysMapAccumulator(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends V> function2) {
        return java8.util.stream.Collectors$$Lambda$6.lambdaFactory$(function, function2);
    }

    static /* synthetic */ void lambda$uniqKeysMapAccumulator$2(java8.util.function.Function function, java8.util.function.Function function2, java.util.Map map, java.lang.Object obj) {
        java.lang.Object objPutIfAbsent;
        java.lang.Object objApply = function.apply(obj);
        java.lang.Object objRequireNonNull = java8.util.Objects.requireNonNull(function2.apply(obj));
        if (map instanceof java.util.concurrent.ConcurrentMap) {
            objPutIfAbsent = ((java.util.concurrent.ConcurrentMap) map).putIfAbsent(objApply, objRequireNonNull);
        } else {
            objPutIfAbsent = java8.util.Maps.putIfAbsent(map, objApply, objRequireNonNull);
        }
        if (objPutIfAbsent != null) {
            throw duplicateKeyException(objApply, objPutIfAbsent, objRequireNonNull);
        }
    }

    static class CollectorImpl<T, A, R> implements java8.util.stream.Collector<T, A, R> {
        private final java8.util.function.BiConsumer<A, T> accumulator;
        private final java.util.Set<java8.util.stream.Collector.Characteristics> characteristics;
        private final java8.util.function.BinaryOperator<A> combiner;
        private final java8.util.function.Function<A, R> finisher;
        private final java8.util.function.Supplier<A> supplier;

        static /* synthetic */ java.lang.Object lambda$new$3(java.lang.Object obj) {
            return obj;
        }

        CollectorImpl(java8.util.function.Supplier<A> supplier, java8.util.function.BiConsumer<A, T> biConsumer, java8.util.function.BinaryOperator<A> binaryOperator, java8.util.function.Function<A, R> function, java.util.Set<java8.util.stream.Collector.Characteristics> set) {
            this.supplier = supplier;
            this.accumulator = biConsumer;
            this.combiner = binaryOperator;
            this.finisher = function;
            this.characteristics = set;
        }

        CollectorImpl(java8.util.function.Supplier<A> supplier, java8.util.function.BiConsumer<A, T> biConsumer, java8.util.function.BinaryOperator<A> binaryOperator, java.util.Set<java8.util.stream.Collector.Characteristics> set) {
            this(supplier, biConsumer, binaryOperator, java8.util.stream.Collectors$CollectorImpl$$Lambda$1.instance, set);
        }

        @Override // java8.util.stream.Collector
        public java8.util.function.BiConsumer<A, T> accumulator() {
            return this.accumulator;
        }

        @Override // java8.util.stream.Collector
        public java8.util.function.Supplier<A> supplier() {
            return this.supplier;
        }

        @Override // java8.util.stream.Collector
        public java8.util.function.BinaryOperator<A> combiner() {
            return this.combiner;
        }

        @Override // java8.util.stream.Collector
        public java8.util.function.Function<A, R> finisher() {
            return this.finisher;
        }

        @Override // java8.util.stream.Collector
        public java.util.Set<java8.util.stream.Collector.Characteristics> characteristics() {
            return this.characteristics;
        }
    }

    public static <T, C extends java.util.Collection<T>> java8.util.stream.Collector<T, ?, C> toCollection(java8.util.function.Supplier<C> supplier) {
        return new java8.util.stream.Collectors.CollectorImpl(supplier, java8.util.stream.Collectors$$Lambda$7.instance, java8.util.stream.Collectors$$Lambda$8.instance, CH_ID);
    }

    static /* synthetic */ java.util.Collection lambda$toCollection$4(java.util.Collection collection, java.util.Collection collection2) {
        collection.addAll(collection2);
        return collection;
    }

    public static <T> java8.util.stream.Collector<T, ?, java.util.List<T>> toList() {
        return new java8.util.stream.Collectors.CollectorImpl(arrayListNew(), listAdd(), java8.util.stream.Collectors$$Lambda$9.instance, CH_ID);
    }

    static /* synthetic */ java.util.List lambda$toList$5(java.util.List list, java.util.List list2) {
        list.addAll(list2);
        return list;
    }

    public static <T> java8.util.stream.Collector<T, ?, java.util.List<T>> toUnmodifiableList() {
        return new java8.util.stream.Collectors.CollectorImpl(arrayListNew(), listAdd(), java8.util.stream.Collectors$$Lambda$10.instance, java8.util.stream.Collectors$$Lambda$11.instance, CH_NOID);
    }

    static /* synthetic */ java.util.List lambda$toUnmodifiableList$6(java.util.List list, java.util.List list2) {
        list.addAll(list2);
        return list;
    }

    public static <T> java8.util.stream.Collector<T, ?, java.util.Set<T>> toSet() {
        return new java8.util.stream.Collectors.CollectorImpl(hashSetNew(), setAdd(), java8.util.stream.Collectors$$Lambda$12.instance, CH_UNORDERED_ID);
    }

    static /* synthetic */ java.util.Set lambda$toSet$8(java.util.Set set, java.util.Set set2) {
        if (set.size() < set2.size()) {
            set2.addAll(set);
            return set2;
        }
        set.addAll(set2);
        return set;
    }

    public static <T> java8.util.stream.Collector<T, ?, java.util.Set<T>> toUnmodifiableSet() {
        return new java8.util.stream.Collectors.CollectorImpl(hashSetNew(), setAdd(), java8.util.stream.Collectors$$Lambda$13.instance, java8.util.stream.Collectors$$Lambda$14.instance, CH_UNORDERED_NOID);
    }

    static /* synthetic */ java.util.Set lambda$toUnmodifiableSet$9(java.util.Set set, java.util.Set set2) {
        if (set.size() < set2.size()) {
            set2.addAll(set);
            return set2;
        }
        set.addAll(set2);
        return set;
    }

    static /* synthetic */ java.util.Set lambda$toUnmodifiableSet$10(java.util.Set set) {
        return java8.util.Sets.of(set.toArray());
    }

    public static java8.util.stream.Collector<java.lang.CharSequence, ?, java.lang.String> joining() {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$15.instance, java8.util.stream.Collectors$$Lambda$16.instance, java8.util.stream.Collectors$$Lambda$17.instance, java8.util.stream.Collectors$$Lambda$18.instance, CH_NOID);
    }

    static /* synthetic */ java.lang.StringBuilder lambda$joining$11(java.lang.StringBuilder sb, java.lang.StringBuilder sb2) {
        sb.append((java.lang.CharSequence) sb2);
        return sb;
    }

    public static java8.util.stream.Collector<java.lang.CharSequence, ?, java.lang.String> joining(java.lang.CharSequence charSequence) {
        return joining(charSequence, "", "");
    }

    public static java8.util.stream.Collector<java.lang.CharSequence, ?, java.lang.String> joining(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$19.lambdaFactory$(charSequence, charSequence2, charSequence3), java8.util.stream.Collectors$$Lambda$20.instance, java8.util.stream.Collectors$$Lambda$21.instance, java8.util.stream.Collectors$$Lambda$22.instance, CH_NOID);
    }

    static /* synthetic */ java8.util.StringJoiner lambda$joining$12(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        return new java8.util.StringJoiner(charSequence, charSequence2, charSequence3);
    }

    private static <K, V, M extends java.util.Map<K, V>> java8.util.function.BinaryOperator<M> mapMerger(java8.util.function.BinaryOperator<V> binaryOperator) {
        return java8.util.stream.Collectors$$Lambda$23.lambdaFactory$(binaryOperator);
    }

    static /* synthetic */ java.util.Map lambda$mapMerger$13(java8.util.function.BinaryOperator binaryOperator, java.util.Map map, java.util.Map map2) {
        for (java.util.Map.Entry entry : map2.entrySet()) {
            java8.util.Maps.merge(map, entry.getKey(), entry.getValue(), binaryOperator);
        }
        return map;
    }

    private static <K, V, M extends java.util.concurrent.ConcurrentMap<K, V>> java8.util.function.BinaryOperator<M> mapMergerConcurrent(java8.util.function.BinaryOperator<V> binaryOperator) {
        return java8.util.stream.Collectors$$Lambda$24.lambdaFactory$(binaryOperator);
    }

    static /* synthetic */ java.util.concurrent.ConcurrentMap lambda$mapMergerConcurrent$14(java8.util.function.BinaryOperator binaryOperator, java.util.concurrent.ConcurrentMap concurrentMap, java.util.concurrent.ConcurrentMap concurrentMap2) {
        for (java.util.Map.Entry entry : concurrentMap2.entrySet()) {
            java8.util.concurrent.ConcurrentMaps.merge(concurrentMap, entry.getKey(), entry.getValue(), binaryOperator);
        }
        return concurrentMap;
    }

    public static <T, U, A, R> java8.util.stream.Collector<T, ?, R> mapping(java8.util.function.Function<? super T, ? extends U> function, java8.util.stream.Collector<? super U, A, R> collector) {
        return new java8.util.stream.Collectors.CollectorImpl(collector.supplier(), java8.util.stream.Collectors$$Lambda$25.lambdaFactory$(collector.accumulator(), function), collector.combiner(), collector.finisher(), collector.characteristics());
    }

    static /* synthetic */ void lambda$mapping$15(java8.util.function.BiConsumer biConsumer, java8.util.function.Function function, java.lang.Object obj, java.lang.Object obj2) {
        biConsumer.accept(obj, function.apply(obj2));
    }

    public static <T, U, A, R> java8.util.stream.Collector<T, ?, R> flatMapping(java8.util.function.Function<? super T, ? extends java8.util.stream.Stream<? extends U>> function, java8.util.stream.Collector<? super U, A, R> collector) {
        return new java8.util.stream.Collectors.CollectorImpl(collector.supplier(), java8.util.stream.Collectors$$Lambda$26.lambdaFactory$(function, collector.accumulator()), collector.combiner(), collector.finisher(), collector.characteristics());
    }

    static /* synthetic */ void lambda$flatMapping$17(java8.util.function.Function function, java8.util.function.BiConsumer biConsumer, java.lang.Object obj, java.lang.Object obj2) throws java.lang.Throwable {
        java8.util.stream.Stream stream = null;
        try {
            java8.util.stream.Stream stream2 = (java8.util.stream.Stream) function.apply(obj2);
            if (stream2 != null) {
                try {
                    stream2.sequential().forEach(java8.util.stream.Collectors$$Lambda$90.lambdaFactory$(biConsumer, obj));
                } catch (java.lang.Throwable th) {
                    th = th;
                    stream = stream2;
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            if (stream2 != null) {
                try {
                    stream2.close();
                } catch (java.lang.Exception unused2) {
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static <T, A, R> java8.util.stream.Collector<T, ?, R> filtering(java8.util.function.Predicate<? super T> predicate, java8.util.stream.Collector<? super T, A, R> collector) {
        return new java8.util.stream.Collectors.CollectorImpl(collector.supplier(), java8.util.stream.Collectors$$Lambda$27.lambdaFactory$(predicate, collector.accumulator()), collector.combiner(), collector.finisher(), collector.characteristics());
    }

    static /* synthetic */ void lambda$filtering$18(java8.util.function.Predicate predicate, java8.util.function.BiConsumer biConsumer, java.lang.Object obj, java.lang.Object obj2) {
        if (predicate.test(obj2)) {
            biConsumer.accept(obj, obj2);
        }
    }

    public static <T, A, R, RR> java8.util.stream.Collector<T, A, RR> collectingAndThen(java8.util.stream.Collector<T, A, R> collector, java8.util.function.Function<R, RR> function) {
        java.util.Set<java8.util.stream.Collector.Characteristics> setCharacteristics = collector.characteristics();
        if (setCharacteristics.contains(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH)) {
            if (setCharacteristics.size() == 1) {
                setCharacteristics = CH_NOID;
            } else {
                java.util.EnumSet enumSetCopyOf = java.util.EnumSet.copyOf((java.util.Collection) setCharacteristics);
                enumSetCopyOf.remove(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH);
                setCharacteristics = java.util.Collections.unmodifiableSet(enumSetCopyOf);
            }
        }
        return new java8.util.stream.Collectors.CollectorImpl(collector.supplier(), collector.accumulator(), collector.combiner(), java8.util.function.Functions.andThen(collector.finisher(), function), setCharacteristics);
    }

    public static <T> java8.util.stream.Collector<T, ?, java.lang.Long> counting() {
        return summingLong(java8.util.stream.Collectors$$Lambda$28.instance);
    }

    public static <T> java8.util.stream.Collector<T, ?, java8.util.Optional<T>> minBy(java.util.Comparator<? super T> comparator) {
        return reducing(java8.util.function.BinaryOperators.minBy(comparator));
    }

    public static <T> java8.util.stream.Collector<T, ?, java8.util.Optional<T>> maxBy(java.util.Comparator<? super T> comparator) {
        return reducing(java8.util.function.BinaryOperators.maxBy(comparator));
    }

    public static <T> java8.util.stream.Collector<T, ?, java.lang.Integer> summingInt(java8.util.function.ToIntFunction<? super T> toIntFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$29.instance, java8.util.stream.Collectors$$Lambda$30.lambdaFactory$(toIntFunction), java8.util.stream.Collectors$$Lambda$31.instance, java8.util.stream.Collectors$$Lambda$32.instance, CH_NOID);
    }

    static /* synthetic */ int[] lambda$summingInt$20() {
        return new int[1];
    }

    static /* synthetic */ void lambda$summingInt$21(java8.util.function.ToIntFunction toIntFunction, int[] iArr, java.lang.Object obj) {
        iArr[0] = iArr[0] + toIntFunction.applyAsInt(obj);
    }

    static /* synthetic */ int[] lambda$summingInt$22(int[] iArr, int[] iArr2) {
        iArr[0] = iArr[0] + iArr2[0];
        return iArr;
    }

    static /* synthetic */ java.lang.Integer lambda$summingInt$23(int[] iArr) {
        return java.lang.Integer.valueOf(iArr[0]);
    }

    public static <T> java8.util.stream.Collector<T, ?, java.lang.Long> summingLong(java8.util.function.ToLongFunction<? super T> toLongFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$33.instance, java8.util.stream.Collectors$$Lambda$34.lambdaFactory$(toLongFunction), java8.util.stream.Collectors$$Lambda$35.instance, java8.util.stream.Collectors$$Lambda$36.instance, CH_NOID);
    }

    static /* synthetic */ long[] lambda$summingLong$24() {
        return new long[1];
    }

    static /* synthetic */ void lambda$summingLong$25(java8.util.function.ToLongFunction toLongFunction, long[] jArr, java.lang.Object obj) {
        jArr[0] = jArr[0] + toLongFunction.applyAsLong(obj);
    }

    static /* synthetic */ long[] lambda$summingLong$26(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] + jArr2[0];
        return jArr;
    }

    static /* synthetic */ java.lang.Long lambda$summingLong$27(long[] jArr) {
        return java.lang.Long.valueOf(jArr[0]);
    }

    public static <T> java8.util.stream.Collector<T, ?, java.lang.Double> summingDouble(java8.util.function.ToDoubleFunction<? super T> toDoubleFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$37.instance, java8.util.stream.Collectors$$Lambda$38.lambdaFactory$(toDoubleFunction), java8.util.stream.Collectors$$Lambda$39.instance, java8.util.stream.Collectors$$Lambda$40.instance, CH_NOID);
    }

    static /* synthetic */ double[] lambda$summingDouble$28() {
        return new double[3];
    }

    static /* synthetic */ void lambda$summingDouble$29(java8.util.function.ToDoubleFunction toDoubleFunction, double[] dArr, java.lang.Object obj) {
        double dApplyAsDouble = toDoubleFunction.applyAsDouble(obj);
        sumWithCompensation(dArr, dApplyAsDouble);
        dArr[2] = dArr[2] + dApplyAsDouble;
    }

    static /* synthetic */ double[] lambda$summingDouble$30(double[] dArr, double[] dArr2) {
        sumWithCompensation(dArr, dArr2[0]);
        dArr[2] = dArr[2] + dArr2[2];
        return sumWithCompensation(dArr, -dArr2[1]);
    }

    static /* synthetic */ java.lang.Double lambda$summingDouble$31(double[] dArr) {
        return java.lang.Double.valueOf(computeFinalSum(dArr));
    }

    static double[] sumWithCompensation(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
        return dArr;
    }

    static double computeFinalSum(double[] dArr) {
        double d = dArr[0] - dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (java.lang.Double.isNaN(d) && java.lang.Double.isInfinite(d2)) ? d2 : d;
    }

    public static <T> java8.util.stream.Collector<T, ?, java.lang.Double> averagingInt(java8.util.function.ToIntFunction<? super T> toIntFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$41.instance, java8.util.stream.Collectors$$Lambda$42.lambdaFactory$(toIntFunction), java8.util.stream.Collectors$$Lambda$43.instance, java8.util.stream.Collectors$$Lambda$44.instance, CH_NOID);
    }

    static /* synthetic */ long[] lambda$averagingInt$32() {
        return new long[2];
    }

    static /* synthetic */ void lambda$averagingInt$33(java8.util.function.ToIntFunction toIntFunction, long[] jArr, java.lang.Object obj) {
        jArr[0] = jArr[0] + ((long) toIntFunction.applyAsInt(obj));
        jArr[1] = jArr[1] + 1;
    }

    static /* synthetic */ long[] lambda$averagingInt$34(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
        return jArr;
    }

    static /* synthetic */ java.lang.Double lambda$averagingInt$35(long[] jArr) {
        long j = jArr[1];
        return java.lang.Double.valueOf(j == 0 ? 0.0d : jArr[0] / j);
    }

    public static <T> java8.util.stream.Collector<T, ?, java.lang.Double> averagingLong(java8.util.function.ToLongFunction<? super T> toLongFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$45.instance, java8.util.stream.Collectors$$Lambda$46.lambdaFactory$(toLongFunction), java8.util.stream.Collectors$$Lambda$47.instance, java8.util.stream.Collectors$$Lambda$48.instance, CH_NOID);
    }

    static /* synthetic */ long[] lambda$averagingLong$36() {
        return new long[2];
    }

    static /* synthetic */ void lambda$averagingLong$37(java8.util.function.ToLongFunction toLongFunction, long[] jArr, java.lang.Object obj) {
        jArr[0] = jArr[0] + toLongFunction.applyAsLong(obj);
        jArr[1] = jArr[1] + 1;
    }

    static /* synthetic */ long[] lambda$averagingLong$38(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
        return jArr;
    }

    static /* synthetic */ java.lang.Double lambda$averagingLong$39(long[] jArr) {
        long j = jArr[1];
        return java.lang.Double.valueOf(j == 0 ? 0.0d : jArr[0] / j);
    }

    public static <T> java8.util.stream.Collector<T, ?, java.lang.Double> averagingDouble(java8.util.function.ToDoubleFunction<? super T> toDoubleFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$49.instance, java8.util.stream.Collectors$$Lambda$50.lambdaFactory$(toDoubleFunction), java8.util.stream.Collectors$$Lambda$51.instance, java8.util.stream.Collectors$$Lambda$52.instance, CH_NOID);
    }

    static /* synthetic */ double[] lambda$averagingDouble$40() {
        return new double[4];
    }

    static /* synthetic */ void lambda$averagingDouble$41(java8.util.function.ToDoubleFunction toDoubleFunction, double[] dArr, java.lang.Object obj) {
        double dApplyAsDouble = toDoubleFunction.applyAsDouble(obj);
        sumWithCompensation(dArr, dApplyAsDouble);
        dArr[2] = dArr[2] + 1.0d;
        dArr[3] = dArr[3] + dApplyAsDouble;
    }

    static /* synthetic */ double[] lambda$averagingDouble$42(double[] dArr, double[] dArr2) {
        sumWithCompensation(dArr, dArr2[0]);
        sumWithCompensation(dArr, -dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
        return dArr;
    }

    static /* synthetic */ java.lang.Double lambda$averagingDouble$43(double[] dArr) {
        return java.lang.Double.valueOf(dArr[2] != 0.0d ? computeFinalSum(dArr) / dArr[2] : 0.0d);
    }

    public static <T> java8.util.stream.Collector<T, ?, T> reducing(T t, java8.util.function.BinaryOperator<T> binaryOperator) {
        return new java8.util.stream.Collectors.CollectorImpl(boxSupplier(t), java8.util.stream.Collectors$$Lambda$53.lambdaFactory$(binaryOperator), java8.util.stream.Collectors$$Lambda$54.lambdaFactory$(binaryOperator), java8.util.stream.Collectors$$Lambda$55.instance, CH_NOID);
    }

    static /* synthetic */ void lambda$reducing$44(java8.util.function.BinaryOperator binaryOperator, java.lang.Object[] objArr, java.lang.Object obj) {
        objArr[0] = binaryOperator.apply(objArr[0], obj);
    }

    static /* synthetic */ java.lang.Object[] lambda$reducing$45(java8.util.function.BinaryOperator binaryOperator, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        objArr[0] = binaryOperator.apply(objArr[0], objArr2[0]);
        return objArr;
    }

    static /* synthetic */ java.lang.Object lambda$reducing$46(java.lang.Object[] objArr) {
        return objArr[0];
    }

    private static <T> java8.util.function.Supplier<T[]> boxSupplier(T t) {
        return java8.util.stream.Collectors$$Lambda$56.lambdaFactory$(t);
    }

    static /* synthetic */ java.lang.Object[] lambda$boxSupplier$47(java.lang.Object obj) {
        return new java.lang.Object[]{obj};
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: java8.util.stream.Collectors$1OptionalBox, reason: invalid class name */
    class C1OptionalBox<T> implements java8.util.function.Consumer<T> {
        final /* synthetic */ java8.util.function.BinaryOperator val$op;
        T value = null;
        boolean present = false;

        C1OptionalBox(java8.util.function.BinaryOperator binaryOperator) {
            this.val$op = binaryOperator;
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            if (this.present) {
                this.value = this.val$op.apply(this.value, t);
            } else {
                this.value = t;
                this.present = true;
            }
        }
    }

    public static <T> java8.util.stream.Collector<T, ?, java8.util.Optional<T>> reducing(java8.util.function.BinaryOperator<T> binaryOperator) {
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$57.lambdaFactory$(binaryOperator), java8.util.stream.Collectors$$Lambda$58.instance, java8.util.stream.Collectors$$Lambda$59.instance, java8.util.stream.Collectors$$Lambda$60.instance, CH_NOID);
    }

    static /* synthetic */ java8.util.stream.Collectors.C1OptionalBox lambda$reducing$48(java8.util.function.BinaryOperator binaryOperator) {
        return new java8.util.stream.Collectors.C1OptionalBox(binaryOperator);
    }

    static /* synthetic */ java8.util.stream.Collectors.C1OptionalBox lambda$reducing$49(java8.util.stream.Collectors.C1OptionalBox c1OptionalBox, java8.util.stream.Collectors.C1OptionalBox c1OptionalBox2) {
        if (c1OptionalBox2.present) {
            c1OptionalBox.accept(c1OptionalBox2.value);
        }
        return c1OptionalBox;
    }

    static /* synthetic */ java8.util.Optional lambda$reducing$50(java8.util.stream.Collectors.C1OptionalBox c1OptionalBox) {
        return java8.util.Optional.ofNullable(c1OptionalBox.value);
    }

    public static <T, U> java8.util.stream.Collector<T, ?, U> reducing(U u, java8.util.function.Function<? super T, ? extends U> function, java8.util.function.BinaryOperator<U> binaryOperator) {
        return new java8.util.stream.Collectors.CollectorImpl(boxSupplier(u), java8.util.stream.Collectors$$Lambda$61.lambdaFactory$(binaryOperator, function), java8.util.stream.Collectors$$Lambda$62.lambdaFactory$(binaryOperator), java8.util.stream.Collectors$$Lambda$63.instance, CH_NOID);
    }

    static /* synthetic */ void lambda$reducing$51(java8.util.function.BinaryOperator binaryOperator, java8.util.function.Function function, java.lang.Object[] objArr, java.lang.Object obj) {
        objArr[0] = binaryOperator.apply(objArr[0], function.apply(obj));
    }

    static /* synthetic */ java.lang.Object[] lambda$reducing$52(java8.util.function.BinaryOperator binaryOperator, java.lang.Object[] objArr, java.lang.Object[] objArr2) {
        objArr[0] = binaryOperator.apply(objArr[0], objArr2[0]);
        return objArr;
    }

    static /* synthetic */ java.lang.Object lambda$reducing$53(java.lang.Object[] objArr) {
        return objArr[0];
    }

    public static <T, K> java8.util.stream.Collector<T, ?, java.util.Map<K, java.util.List<T>>> groupingBy(java8.util.function.Function<? super T, ? extends K> function) {
        return groupingBy(function, toList());
    }

    public static <T, K, A, D> java8.util.stream.Collector<T, ?, java.util.Map<K, D>> groupingBy(java8.util.function.Function<? super T, ? extends K> function, java8.util.stream.Collector<? super T, A, D> collector) {
        return groupingBy(function, hashMapNew(), collector);
    }

    public static <T, K, D, A, M extends java.util.Map<K, D>> java8.util.stream.Collector<T, ?, M> groupingBy(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Supplier<M> supplier, java8.util.stream.Collector<? super T, A, D> collector) {
        java8.util.function.BiConsumer biConsumerLambdaFactory$ = java8.util.stream.Collectors$$Lambda$64.lambdaFactory$(function, collector.supplier(), collector.accumulator());
        java8.util.function.BinaryOperator binaryOperatorMapMerger = mapMerger(collector.combiner());
        if (collector.characteristics().contains(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH)) {
            return new java8.util.stream.Collectors.CollectorImpl(supplier, biConsumerLambdaFactory$, binaryOperatorMapMerger, CH_ID);
        }
        return new java8.util.stream.Collectors.CollectorImpl(supplier, biConsumerLambdaFactory$, binaryOperatorMapMerger, java8.util.stream.Collectors$$Lambda$65.lambdaFactory$(collector.finisher()), CH_NOID);
    }

    static /* synthetic */ void lambda$groupingBy$55(java8.util.function.Function function, java8.util.function.Supplier supplier, java8.util.function.BiConsumer biConsumer, java.util.Map map, java.lang.Object obj) {
        biConsumer.accept(java8.util.Maps.computeIfAbsent(map, java8.util.Objects.requireNonNull(function.apply(obj), "element cannot be mapped to a null key"), java8.util.stream.Collectors$$Lambda$89.lambdaFactory$(supplier)), obj);
    }

    static /* synthetic */ java.lang.Object lambda$null$54(java8.util.function.Supplier supplier, java.lang.Object obj) {
        return supplier.get();
    }

    static /* synthetic */ java.util.Map lambda$groupingBy$57(java8.util.function.Function function, java.util.Map map) {
        java8.util.Maps.replaceAll(map, java8.util.stream.Collectors$$Lambda$88.lambdaFactory$(function));
        return map;
    }

    static /* synthetic */ java.lang.Object lambda$null$56(java8.util.function.Function function, java.lang.Object obj, java.lang.Object obj2) {
        return function.apply(obj2);
    }

    public static <T, K> java8.util.stream.Collector<T, ?, java.util.concurrent.ConcurrentMap<K, java.util.List<T>>> groupingByConcurrent(java8.util.function.Function<? super T, ? extends K> function) {
        return groupingByConcurrent(function, concHashMapNew(), toList());
    }

    public static <T, K, A, D> java8.util.stream.Collector<T, ?, java.util.concurrent.ConcurrentMap<K, D>> groupingByConcurrent(java8.util.function.Function<? super T, ? extends K> function, java8.util.stream.Collector<? super T, A, D> collector) {
        return groupingByConcurrent(function, concHashMapNew(), collector);
    }

    public static <T, K, A, D, M extends java.util.concurrent.ConcurrentMap<K, D>> java8.util.stream.Collector<T, ?, M> groupingByConcurrent(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Supplier<M> supplier, java8.util.stream.Collector<? super T, A, D> collector) {
        java8.util.function.BiConsumer biConsumerLambdaFactory$;
        java8.util.function.Supplier<A> supplier2 = collector.supplier();
        java8.util.function.BiConsumer<A, ? super T> biConsumerAccumulator = collector.accumulator();
        java8.util.function.BinaryOperator binaryOperatorMapMergerConcurrent = mapMergerConcurrent(collector.combiner());
        if (collector.characteristics().contains(java8.util.stream.Collector.Characteristics.CONCURRENT)) {
            biConsumerLambdaFactory$ = java8.util.stream.Collectors$$Lambda$66.lambdaFactory$(function, supplier2, biConsumerAccumulator);
        } else {
            biConsumerLambdaFactory$ = java8.util.stream.Collectors$$Lambda$67.lambdaFactory$(function, supplier2, biConsumerAccumulator);
        }
        java8.util.function.BiConsumer biConsumer = biConsumerLambdaFactory$;
        if (collector.characteristics().contains(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH)) {
            return new java8.util.stream.Collectors.CollectorImpl(supplier, biConsumer, binaryOperatorMapMergerConcurrent, CH_CONCURRENT_ID);
        }
        return new java8.util.stream.Collectors.CollectorImpl(supplier, biConsumer, binaryOperatorMapMergerConcurrent, java8.util.stream.Collectors$$Lambda$68.lambdaFactory$(collector.finisher()), CH_CONCURRENT_NOID);
    }

    static /* synthetic */ void lambda$groupingByConcurrent$59(java8.util.function.Function function, java8.util.function.Supplier supplier, java8.util.function.BiConsumer biConsumer, java.util.concurrent.ConcurrentMap concurrentMap, java.lang.Object obj) {
        biConsumer.accept(java8.util.concurrent.ConcurrentMaps.computeIfAbsent(concurrentMap, java8.util.Objects.requireNonNull(function.apply(obj), "element cannot be mapped to a null key"), java8.util.stream.Collectors$$Lambda$87.lambdaFactory$(supplier)), obj);
    }

    static /* synthetic */ java.lang.Object lambda$null$58(java8.util.function.Supplier supplier, java.lang.Object obj) {
        return supplier.get();
    }

    static /* synthetic */ void lambda$groupingByConcurrent$61(java8.util.function.Function function, java8.util.function.Supplier supplier, java8.util.function.BiConsumer biConsumer, java.util.concurrent.ConcurrentMap concurrentMap, java.lang.Object obj) {
        java.lang.Object objComputeIfAbsent = java8.util.concurrent.ConcurrentMaps.computeIfAbsent(concurrentMap, java8.util.Objects.requireNonNull(function.apply(obj), "element cannot be mapped to a null key"), java8.util.stream.Collectors$$Lambda$86.lambdaFactory$(supplier));
        synchronized (objComputeIfAbsent) {
            biConsumer.accept(objComputeIfAbsent, obj);
        }
    }

    static /* synthetic */ java.lang.Object lambda$null$60(java8.util.function.Supplier supplier, java.lang.Object obj) {
        return supplier.get();
    }

    static /* synthetic */ java.util.concurrent.ConcurrentMap lambda$groupingByConcurrent$63(java8.util.function.Function function, java.util.concurrent.ConcurrentMap concurrentMap) {
        java8.util.concurrent.ConcurrentMaps.replaceAll(concurrentMap, java8.util.stream.Collectors$$Lambda$85.lambdaFactory$(function));
        return concurrentMap;
    }

    static /* synthetic */ java.lang.Object lambda$null$62(java8.util.function.Function function, java.lang.Object obj, java.lang.Object obj2) {
        return function.apply(obj2);
    }

    public static <T> java8.util.stream.Collector<T, ?, java.util.Map<java.lang.Boolean, java.util.List<T>>> partitioningBy(java8.util.function.Predicate<? super T> predicate) {
        return partitioningBy(predicate, toList());
    }

    public static <T, D, A> java8.util.stream.Collector<T, ?, java.util.Map<java.lang.Boolean, D>> partitioningBy(java8.util.function.Predicate<? super T> predicate, java8.util.stream.Collector<? super T, A, D> collector) {
        java8.util.function.BiConsumer biConsumerLambdaFactory$ = java8.util.stream.Collectors$$Lambda$69.lambdaFactory$(collector.accumulator(), predicate);
        java8.util.function.BinaryOperator binaryOperatorLambdaFactory$ = java8.util.stream.Collectors$$Lambda$70.lambdaFactory$(collector.combiner());
        java8.util.function.Supplier supplierLambdaFactory$ = java8.util.stream.Collectors$$Lambda$71.lambdaFactory$(collector);
        if (collector.characteristics().contains(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH)) {
            return new java8.util.stream.Collectors.CollectorImpl(supplierLambdaFactory$, biConsumerLambdaFactory$, binaryOperatorLambdaFactory$, CH_ID);
        }
        return new java8.util.stream.Collectors.CollectorImpl(supplierLambdaFactory$, biConsumerLambdaFactory$, binaryOperatorLambdaFactory$, java8.util.stream.Collectors$$Lambda$72.lambdaFactory$(collector), CH_NOID);
    }

    static /* synthetic */ void lambda$partitioningBy$64(java8.util.function.BiConsumer biConsumer, java8.util.function.Predicate predicate, java8.util.stream.Collectors.Partition partition, java.lang.Object obj) {
        biConsumer.accept(predicate.test(obj) ? partition.forTrue : partition.forFalse, obj);
    }

    static /* synthetic */ java8.util.stream.Collectors.Partition lambda$partitioningBy$65(java8.util.function.BinaryOperator binaryOperator, java8.util.stream.Collectors.Partition partition, java8.util.stream.Collectors.Partition partition2) {
        return new java8.util.stream.Collectors.Partition(binaryOperator.apply(partition.forTrue, partition2.forTrue), binaryOperator.apply(partition.forFalse, partition2.forFalse));
    }

    static /* synthetic */ java8.util.stream.Collectors.Partition lambda$partitioningBy$66(java8.util.stream.Collector collector) {
        return new java8.util.stream.Collectors.Partition(collector.supplier().get(), collector.supplier().get());
    }

    static /* synthetic */ java.util.Map lambda$partitioningBy$67(java8.util.stream.Collector collector, java8.util.stream.Collectors.Partition partition) {
        return new java8.util.stream.Collectors.Partition(collector.finisher().apply(partition.forTrue), collector.finisher().apply(partition.forFalse));
    }

    public static <T, K, U> java8.util.stream.Collector<T, ?, java.util.Map<K, U>> toMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2) {
        return new java8.util.stream.Collectors.CollectorImpl(hashMapNew(), uniqKeysMapAccumulator(function, function2), uniqKeysMapMerger(), CH_ID);
    }

    public static <T, K, U> java8.util.stream.Collector<T, ?, java.util.Map<K, U>> toUnmodifiableMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2) {
        java8.util.Objects.requireNonNull(function, "keyMapper");
        java8.util.Objects.requireNonNull(function2, "valueMapper");
        return collectingAndThen(toMap(function, function2), unmodMapFinisher());
    }

    public static <T, K, U> java8.util.stream.Collector<T, ?, java.util.Map<K, U>> toMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2, java8.util.function.BinaryOperator<U> binaryOperator) {
        return toMap(function, function2, binaryOperator, hashMapNew());
    }

    public static <T, K, U> java8.util.stream.Collector<T, ?, java.util.Map<K, U>> toUnmodifiableMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2, java8.util.function.BinaryOperator<U> binaryOperator) {
        java8.util.Objects.requireNonNull(function, "keyMapper");
        java8.util.Objects.requireNonNull(function2, "valueMapper");
        java8.util.Objects.requireNonNull(binaryOperator, "mergeFunction");
        return collectingAndThen(toMap(function, function2, binaryOperator, hashMapNew()), unmodMapFinisher());
    }

    public static <T, K, U, M extends java.util.Map<K, U>> java8.util.stream.Collector<T, ?, M> toMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2, java8.util.function.BinaryOperator<U> binaryOperator, java8.util.function.Supplier<M> supplier) {
        return new java8.util.stream.Collectors.CollectorImpl(supplier, java8.util.stream.Collectors$$Lambda$73.lambdaFactory$(function, function2, binaryOperator), mapMerger(binaryOperator), CH_ID);
    }

    static /* synthetic */ void lambda$toMap$68(java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BinaryOperator binaryOperator, java.util.Map map, java.lang.Object obj) {
        java8.util.Maps.merge(map, function.apply(obj), function2.apply(obj), binaryOperator);
    }

    public static <T, K, U> java8.util.stream.Collector<T, ?, java.util.concurrent.ConcurrentMap<K, U>> toConcurrentMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2) {
        return new java8.util.stream.Collectors.CollectorImpl(concHashMapNew2(), uniqKeysMapAccumulator(function, function2), uniqKeysMapMerger(), CH_CONCURRENT_ID);
    }

    public static <T, K, U> java8.util.stream.Collector<T, ?, java.util.concurrent.ConcurrentMap<K, U>> toConcurrentMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2, java8.util.function.BinaryOperator<U> binaryOperator) {
        return toConcurrentMap(function, function2, binaryOperator, concHashMapNew());
    }

    public static <T, K, U, M extends java.util.concurrent.ConcurrentMap<K, U>> java8.util.stream.Collector<T, ?, M> toConcurrentMap(java8.util.function.Function<? super T, ? extends K> function, java8.util.function.Function<? super T, ? extends U> function2, java8.util.function.BinaryOperator<U> binaryOperator, java8.util.function.Supplier<M> supplier) {
        return new java8.util.stream.Collectors.CollectorImpl(supplier, java8.util.stream.Collectors$$Lambda$74.lambdaFactory$(function, function2, binaryOperator), mapMergerConcurrent(binaryOperator), CH_CONCURRENT_ID);
    }

    static /* synthetic */ void lambda$toConcurrentMap$69(java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BinaryOperator binaryOperator, java.util.concurrent.ConcurrentMap concurrentMap, java.lang.Object obj) {
        java8.util.concurrent.ConcurrentMaps.merge(concurrentMap, function.apply(obj), function2.apply(obj), binaryOperator);
    }

    public static <T> java8.util.stream.Collector<T, ?, java8.util.IntSummaryStatistics> summarizingInt(java8.util.function.ToIntFunction<? super T> toIntFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(INT_SUM_STATS, java8.util.stream.Collectors$$Lambda$75.lambdaFactory$(toIntFunction), java8.util.stream.Collectors$$Lambda$76.instance, CH_ID);
    }

    static /* synthetic */ void lambda$summarizingInt$70(java8.util.function.ToIntFunction toIntFunction, java8.util.IntSummaryStatistics intSummaryStatistics, java.lang.Object obj) {
        intSummaryStatistics.accept(toIntFunction.applyAsInt(obj));
    }

    static /* synthetic */ java8.util.IntSummaryStatistics lambda$summarizingInt$71(java8.util.IntSummaryStatistics intSummaryStatistics, java8.util.IntSummaryStatistics intSummaryStatistics2) {
        intSummaryStatistics.combine(intSummaryStatistics2);
        return intSummaryStatistics;
    }

    public static <T> java8.util.stream.Collector<T, ?, java8.util.LongSummaryStatistics> summarizingLong(java8.util.function.ToLongFunction<? super T> toLongFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(LNG_SUM_STATS, java8.util.stream.Collectors$$Lambda$77.lambdaFactory$(toLongFunction), java8.util.stream.Collectors$$Lambda$78.instance, CH_ID);
    }

    static /* synthetic */ void lambda$summarizingLong$72(java8.util.function.ToLongFunction toLongFunction, java8.util.LongSummaryStatistics longSummaryStatistics, java.lang.Object obj) {
        longSummaryStatistics.accept(toLongFunction.applyAsLong(obj));
    }

    static /* synthetic */ java8.util.LongSummaryStatistics lambda$summarizingLong$73(java8.util.LongSummaryStatistics longSummaryStatistics, java8.util.LongSummaryStatistics longSummaryStatistics2) {
        longSummaryStatistics.combine(longSummaryStatistics2);
        return longSummaryStatistics;
    }

    public static <T> java8.util.stream.Collector<T, ?, java8.util.DoubleSummaryStatistics> summarizingDouble(java8.util.function.ToDoubleFunction<? super T> toDoubleFunction) {
        return new java8.util.stream.Collectors.CollectorImpl(DBL_SUM_STATS, java8.util.stream.Collectors$$Lambda$79.lambdaFactory$(toDoubleFunction), java8.util.stream.Collectors$$Lambda$80.instance, CH_ID);
    }

    static /* synthetic */ void lambda$summarizingDouble$74(java8.util.function.ToDoubleFunction toDoubleFunction, java8.util.DoubleSummaryStatistics doubleSummaryStatistics, java.lang.Object obj) {
        doubleSummaryStatistics.accept(toDoubleFunction.applyAsDouble(obj));
    }

    static /* synthetic */ java8.util.DoubleSummaryStatistics lambda$summarizingDouble$75(java8.util.DoubleSummaryStatistics doubleSummaryStatistics, java8.util.DoubleSummaryStatistics doubleSummaryStatistics2) {
        doubleSummaryStatistics.combine(doubleSummaryStatistics2);
        return doubleSummaryStatistics;
    }

    public static <T, R1, R2, R> java8.util.stream.Collector<T, ?, R> teeing(java8.util.stream.Collector<? super T, ?, R1> collector, java8.util.stream.Collector<? super T, ?, R2> collector2, java8.util.function.BiFunction<? super R1, ? super R2, R> biFunction) {
        return teeing0(collector, collector2, biFunction);
    }

    private static <T, A1, A2, R1, R2, R> java8.util.stream.Collector<T, ?, R> teeing0(java8.util.stream.Collector<? super T, A1, R1> collector, java8.util.stream.Collector<? super T, A2, R2> collector2, java8.util.function.BiFunction<? super R1, ? super R2, R> biFunction) {
        java.util.Set<java8.util.stream.Collector.Characteristics> setUnmodifiableSet;
        java8.util.Objects.requireNonNull(collector, "downstream1");
        java8.util.Objects.requireNonNull(collector2, "downstream2");
        java8.util.Objects.requireNonNull(biFunction, "merger");
        java8.util.function.Supplier supplier = (java8.util.function.Supplier) java8.util.Objects.requireNonNull(collector.supplier(), "downstream1 supplier");
        java8.util.function.Supplier supplier2 = (java8.util.function.Supplier) java8.util.Objects.requireNonNull(collector2.supplier(), "downstream2 supplier");
        java8.util.function.BiConsumer biConsumer = (java8.util.function.BiConsumer) java8.util.Objects.requireNonNull(collector.accumulator(), "downstream1 accumulator");
        java8.util.function.BiConsumer biConsumer2 = (java8.util.function.BiConsumer) java8.util.Objects.requireNonNull(collector2.accumulator(), "downstream2 accumulator");
        java8.util.function.BinaryOperator binaryOperator = (java8.util.function.BinaryOperator) java8.util.Objects.requireNonNull(collector.combiner(), "downstream1 combiner");
        java8.util.function.BinaryOperator binaryOperator2 = (java8.util.function.BinaryOperator) java8.util.Objects.requireNonNull(collector2.combiner(), "downstream2 combiner");
        java8.util.function.Function function = (java8.util.function.Function) java8.util.Objects.requireNonNull(collector.finisher(), "downstream1 finisher");
        java8.util.function.Function function2 = (java8.util.function.Function) java8.util.Objects.requireNonNull(collector2.finisher(), "downstream2 finisher");
        java.util.Set<java8.util.stream.Collector.Characteristics> setCharacteristics = collector.characteristics();
        java.util.Set<java8.util.stream.Collector.Characteristics> setCharacteristics2 = collector2.characteristics();
        java.util.Set<java8.util.stream.Collector.Characteristics> set = CH_ID;
        if (set.containsAll(setCharacteristics) || set.containsAll(setCharacteristics2)) {
            setUnmodifiableSet = CH_NOID;
        } else {
            java.util.EnumSet enumSetNoneOf = java.util.EnumSet.noneOf(java8.util.stream.Collector.Characteristics.class);
            enumSetNoneOf.addAll(setCharacteristics);
            enumSetNoneOf.retainAll(setCharacteristics2);
            enumSetNoneOf.remove(java8.util.stream.Collector.Characteristics.IDENTITY_FINISH);
            setUnmodifiableSet = java.util.Collections.unmodifiableSet(enumSetNoneOf);
        }
        return new java8.util.stream.Collectors.CollectorImpl(java8.util.stream.Collectors$$Lambda$81.lambdaFactory$(supplier, supplier2, biConsumer, biConsumer2, binaryOperator, binaryOperator2, function, function2, biFunction), java8.util.stream.Collectors$$Lambda$82.instance, java8.util.stream.Collectors$$Lambda$83.instance, java8.util.stream.Collectors$$Lambda$84.instance, setUnmodifiableSet);
    }

    /* JADX INFO: renamed from: java8.util.stream.Collectors$1PairBox, reason: invalid class name */
    class C1PairBox {
        A1 left;
        A2 right;
        final /* synthetic */ java8.util.function.BiConsumer val$c1Accumulator;
        final /* synthetic */ java8.util.function.BinaryOperator val$c1Combiner;
        final /* synthetic */ java8.util.function.Function val$c1Finisher;
        final /* synthetic */ java8.util.function.Supplier val$c1Supplier;
        final /* synthetic */ java8.util.function.BiConsumer val$c2Accumulator;
        final /* synthetic */ java8.util.function.BinaryOperator val$c2Combiner;
        final /* synthetic */ java8.util.function.Function val$c2Finisher;
        final /* synthetic */ java8.util.function.Supplier val$c2Supplier;
        final /* synthetic */ java8.util.function.BiFunction val$merger;

        /* JADX WARN: Type inference failed for: r1v1, types: [A1, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v2, types: [A2, java.lang.Object] */
        C1PairBox(java8.util.function.Supplier supplier, java8.util.function.Supplier supplier2, java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2, java8.util.function.BinaryOperator binaryOperator, java8.util.function.BinaryOperator binaryOperator2, java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BiFunction biFunction) {
            this.val$c1Supplier = supplier;
            this.val$c2Supplier = supplier2;
            this.val$c1Accumulator = biConsumer;
            this.val$c2Accumulator = biConsumer2;
            this.val$c1Combiner = binaryOperator;
            this.val$c2Combiner = binaryOperator2;
            this.val$c1Finisher = function;
            this.val$c2Finisher = function2;
            this.val$merger = biFunction;
            this.left = supplier.get();
            this.right = supplier2.get();
        }

        void add(T t) {
            this.val$c1Accumulator.accept(this.left, t);
            this.val$c2Accumulator.accept(this.right, t);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [A1, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v2, types: [A2, java.lang.Object] */
        java8.util.stream.Collectors.C1PairBox combine(java8.util.stream.Collectors.C1PairBox c1PairBox) {
            this.left = this.val$c1Combiner.apply(this.left, c1PairBox.left);
            this.right = this.val$c2Combiner.apply(this.right, c1PairBox.right);
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [R, java.lang.Object] */
        R get() {
            return this.val$merger.apply(this.val$c1Finisher.apply(this.left), this.val$c2Finisher.apply(this.right));
        }
    }

    static /* synthetic */ java8.util.stream.Collectors.C1PairBox lambda$teeing0$76(java8.util.function.Supplier supplier, java8.util.function.Supplier supplier2, java8.util.function.BiConsumer biConsumer, java8.util.function.BiConsumer biConsumer2, java8.util.function.BinaryOperator binaryOperator, java8.util.function.BinaryOperator binaryOperator2, java8.util.function.Function function, java8.util.function.Function function2, java8.util.function.BiFunction biFunction) {
        return new java8.util.stream.Collectors.C1PairBox(supplier, supplier2, biConsumer, biConsumer2, binaryOperator, binaryOperator2, function, function2, biFunction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Partition<T> extends java.util.AbstractMap<java.lang.Boolean, T> implements java.util.Map<java.lang.Boolean, T> {
        final T forFalse;
        final T forTrue;

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return 2;
        }

        Partition(T t, T t2) {
            this.forTrue = t;
            this.forFalse = t2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<java.lang.Boolean, T>> entrySet() {
            return new java.util.AbstractSet<java.util.Map.Entry<java.lang.Boolean, T>>() { // from class: java8.util.stream.Collectors.Partition.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return 2;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public java.util.Iterator<java.util.Map.Entry<java.lang.Boolean, T>> iterator() {
                    return java.util.Arrays.asList(new java.util.AbstractMap.SimpleImmutableEntry(false, java8.util.stream.Collectors.Partition.this.forFalse), new java.util.AbstractMap.SimpleImmutableEntry(true, java8.util.stream.Collectors.Partition.this.forTrue)).iterator();
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return obj instanceof java.lang.Boolean;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public T get(java.lang.Object obj) {
            if (obj instanceof java.lang.Boolean) {
                return ((java.lang.Boolean) obj).booleanValue() ? this.forTrue : this.forFalse;
            }
            return null;
        }
    }
}
