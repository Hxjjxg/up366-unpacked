package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class HMSpliterators {
    private static final long ENTRYSET_$0_OFF;
    private static final long HASHSET_MAP_OFF;
    private static final long KEYSET_$0_OFF;
    private static final sun.misc.Unsafe U;
    private static final long VALUES_$0_OFF;

    private HMSpliterators() {
    }

    static <K> java8.util.Spliterator<K> getKeySetSpliterator(java.util.Set<K> set) {
        return new java8.util.HMSpliterators.KeySpliterator(getHashMapFromKeySet(set), 0, -1, 0, 0);
    }

    static <K, V> java8.util.Spliterator<java.util.Map.Entry<K, V>> getEntrySetSpliterator(java.util.Set<java.util.Map.Entry<K, V>> set) {
        return new java8.util.HMSpliterators.EntrySpliterator(getHashMapFromEntrySet(set), 0, -1, 0, 0);
    }

    static <V> java8.util.Spliterator<V> getValuesSpliterator(java.util.Collection<V> collection) {
        return new java8.util.HMSpliterators.ValueSpliterator(getHashMapFromValues(collection), 0, -1, 0, 0);
    }

    static <E> java8.util.Spliterator<E> getHashSetSpliterator(java.util.HashSet<E> hashSet) {
        return new java8.util.HMSpliterators.KeySpliterator(getHashMapFromHashSet(hashSet), 0, -1, 0, 0);
    }

    private static final class KeySpliterator<K, V> extends java8.util.HMSpliterators.HashMapSpliterator<K, V> implements java8.util.Spliterator<K> {
        KeySpliterator(java.util.HashMap<K, V> map, int i, int i2, int i3, int i4) {
            super(map, i, i2, i3, i4);
        }

        @Override // java8.util.Spliterator
        public java8.util.HMSpliterators.KeySpliterator<K, V> trySplit() {
            int fence = getFence();
            int i = this.index;
            int i2 = (fence + i) >>> 1;
            if (i >= i2 || this.current != null) {
                return null;
            }
            java.util.HashMap<K, V> map = this.map;
            this.index = i2;
            int i3 = this.est >>> 1;
            this.est = i3;
            return new java8.util.HMSpliterators.KeySpliterator<>(map, i, i2, i3, this.expectedModCount);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super K> consumer) {
            int i;
            int i2;
            java8.util.Objects.requireNonNull(consumer);
            java.util.HashMap<K, V> map = this.map;
            java.lang.Object[] table = getTable(map);
            int i3 = this.fence;
            if (i3 < 0) {
                int modCount = getModCount(map);
                this.expectedModCount = modCount;
                int length = table == null ? 0 : table.length;
                this.fence = length;
                int i4 = length;
                i = modCount;
                i3 = i4;
            } else {
                i = this.expectedModCount;
            }
            if (table == null || table.length < i3 || (i2 = this.index) < 0) {
                return;
            }
            this.index = i3;
            if (i2 < i3 || this.current != null) {
                java.lang.Object nextNode = this.current;
                this.current = null;
                while (true) {
                    if (nextNode == null) {
                        nextNode = table[i2];
                        i2++;
                    } else {
                        consumer.accept((java.lang.Object) java8.util.HMSpliterators.HashMapSpliterator.getNodeKey(nextNode));
                        nextNode = getNextNode(nextNode);
                    }
                    if (nextNode == null && i2 >= i3) {
                        break;
                    }
                }
                if (i != getModCount(map)) {
                    throw new java.util.ConcurrentModificationException();
                }
            }
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super K> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            java.lang.Object[] table = getTable(this.map);
            if (table == null) {
                return false;
            }
            int length = table.length;
            int fence = getFence();
            if (length < fence || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current == null && this.index >= fence) {
                    return false;
                }
                if (this.current == null) {
                    int i = this.index;
                    this.index = i + 1;
                    this.current = table[i];
                } else {
                    android.R.color colorVar = (java.lang.Object) getNodeKey(this.current);
                    this.current = getNextNode(this.current);
                    consumer.accept(colorVar);
                    if (this.expectedModCount == getModCount(this.map)) {
                        return true;
                    }
                    throw new java.util.ConcurrentModificationException();
                }
            }
        }

        @Override // java8.util.HMSpliterators.HashMapSpliterator, java8.util.Spliterator
        public int characteristics() {
            return ((this.fence < 0 || this.est == this.map.size()) ? 64 : 0) | 1;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super K> getComparator() {
            return java8.util.Spliterators.getComparator(null);
        }
    }

    private static final class ValueSpliterator<K, V> extends java8.util.HMSpliterators.HashMapSpliterator<K, V> implements java8.util.Spliterator<V> {
        ValueSpliterator(java.util.HashMap<K, V> map, int i, int i2, int i3, int i4) {
            super(map, i, i2, i3, i4);
        }

        @Override // java8.util.Spliterator
        public java8.util.HMSpliterators.ValueSpliterator<K, V> trySplit() {
            int fence = getFence();
            int i = this.index;
            int i2 = (fence + i) >>> 1;
            if (i >= i2 || this.current != null) {
                return null;
            }
            java.util.HashMap<K, V> map = this.map;
            this.index = i2;
            int i3 = this.est >>> 1;
            this.est = i3;
            return new java8.util.HMSpliterators.ValueSpliterator<>(map, i, i2, i3, this.expectedModCount);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super V> consumer) {
            int i;
            int i2;
            java8.util.Objects.requireNonNull(consumer);
            java.util.HashMap<K, V> map = this.map;
            java.lang.Object[] table = getTable(map);
            int i3 = this.fence;
            if (i3 < 0) {
                int modCount = getModCount(map);
                this.expectedModCount = modCount;
                int length = table == null ? 0 : table.length;
                this.fence = length;
                int i4 = length;
                i = modCount;
                i3 = i4;
            } else {
                i = this.expectedModCount;
            }
            if (table == null || table.length < i3 || (i2 = this.index) < 0) {
                return;
            }
            this.index = i3;
            if (i2 < i3 || this.current != null) {
                java.lang.Object nextNode = this.current;
                this.current = null;
                while (true) {
                    if (nextNode == null) {
                        nextNode = table[i2];
                        i2++;
                    } else {
                        consumer.accept((java.lang.Object) java8.util.HMSpliterators.HashMapSpliterator.getNodeValue(nextNode));
                        nextNode = getNextNode(nextNode);
                    }
                    if (nextNode == null && i2 >= i3) {
                        break;
                    }
                }
                if (i != getModCount(map)) {
                    throw new java.util.ConcurrentModificationException();
                }
            }
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super V> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            java.lang.Object[] table = getTable(this.map);
            if (table == null) {
                return false;
            }
            int length = table.length;
            int fence = getFence();
            if (length < fence || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current == null && this.index >= fence) {
                    return false;
                }
                if (this.current == null) {
                    int i = this.index;
                    this.index = i + 1;
                    this.current = table[i];
                } else {
                    android.R.color colorVar = (java.lang.Object) getNodeValue(this.current);
                    this.current = getNextNode(this.current);
                    consumer.accept(colorVar);
                    if (this.expectedModCount == getModCount(this.map)) {
                        return true;
                    }
                    throw new java.util.ConcurrentModificationException();
                }
            }
        }

        @Override // java8.util.HMSpliterators.HashMapSpliterator, java8.util.Spliterator
        public int characteristics() {
            return (this.fence < 0 || this.est == this.map.size()) ? 64 : 0;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super V> getComparator() {
            return java8.util.Spliterators.getComparator(null);
        }
    }

    private static final class EntrySpliterator<K, V> extends java8.util.HMSpliterators.HashMapSpliterator<K, V> implements java8.util.Spliterator<java.util.Map.Entry<K, V>> {
        EntrySpliterator(java.util.HashMap<K, V> map, int i, int i2, int i3, int i4) {
            super(map, i, i2, i3, i4);
        }

        @Override // java8.util.Spliterator
        public java8.util.HMSpliterators.EntrySpliterator<K, V> trySplit() {
            int fence = getFence();
            int i = this.index;
            int i2 = (fence + i) >>> 1;
            if (i >= i2 || this.current != null) {
                return null;
            }
            java.util.HashMap<K, V> map = this.map;
            this.index = i2;
            int i3 = this.est >>> 1;
            this.est = i3;
            return new java8.util.HMSpliterators.EntrySpliterator<>(map, i, i2, i3, this.expectedModCount);
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super java.util.Map.Entry<K, V>> consumer) {
            int i;
            int i2;
            java8.util.Objects.requireNonNull(consumer);
            java.util.HashMap<K, V> map = this.map;
            java.lang.Object[] table = getTable(map);
            int i3 = this.fence;
            if (i3 < 0) {
                int modCount = getModCount(map);
                this.expectedModCount = modCount;
                int length = table == null ? 0 : table.length;
                this.fence = length;
                int i4 = length;
                i = modCount;
                i3 = i4;
            } else {
                i = this.expectedModCount;
            }
            if (table == null || table.length < i3 || (i2 = this.index) < 0) {
                return;
            }
            this.index = i3;
            if (i2 < i3 || this.current != null) {
                java.lang.Object nextNode = this.current;
                this.current = null;
                while (true) {
                    if (nextNode == null) {
                        nextNode = table[i2];
                        i2++;
                    } else {
                        consumer.accept((java.util.Map.Entry) nextNode);
                        nextNode = getNextNode(nextNode);
                    }
                    if (nextNode == null && i2 >= i3) {
                        break;
                    }
                }
                if (i != getModCount(map)) {
                    throw new java.util.ConcurrentModificationException();
                }
            }
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super java.util.Map.Entry<K, V>> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            java.lang.Object[] table = getTable(this.map);
            if (table == null) {
                return false;
            }
            int length = table.length;
            int fence = getFence();
            if (length < fence || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current == null && this.index >= fence) {
                    return false;
                }
                if (this.current == null) {
                    int i = this.index;
                    this.index = i + 1;
                    this.current = table[i];
                } else {
                    java.util.Map.Entry entry = (java.util.Map.Entry) this.current;
                    this.current = getNextNode(this.current);
                    consumer.accept(entry);
                    if (this.expectedModCount == getModCount(this.map)) {
                        return true;
                    }
                    throw new java.util.ConcurrentModificationException();
                }
            }
        }

        @Override // java8.util.HMSpliterators.HashMapSpliterator, java8.util.Spliterator
        public int characteristics() {
            return ((this.fence < 0 || this.est == this.map.size()) ? 64 : 0) | 1;
        }

        @Override // java8.util.Spliterator
        public java.util.Comparator<? super java.util.Map.Entry<K, V>> getComparator() {
            return java8.util.Spliterators.getComparator(null);
        }
    }

    private static abstract class HashMapSpliterator<K, V> {
        private static final long MODCOUNT_OFF;
        private static final long NODE_KEY_OFF;
        private static final long NODE_NXT_OFF;
        private static final long NODE_VAL_OFF;
        private static final long TABLE_OFF;
        private static final sun.misc.Unsafe U;
        java.lang.Object current;
        int est;
        int expectedModCount;
        int fence;
        int index;
        final java.util.HashMap<K, V> map;

        public abstract int characteristics();

        HashMapSpliterator(java.util.HashMap<K, V> map, int i, int i2, int i3, int i4) {
            this.map = map;
            this.index = i;
            this.fence = i2;
            this.est = i3;
            this.expectedModCount = i4;
        }

        final int getFence() {
            int length = this.fence;
            if (length < 0) {
                java.util.HashMap<K, V> map = this.map;
                this.est = map.size();
                this.expectedModCount = getModCount(map);
                java.lang.Object[] table = getTable(map);
                length = table == null ? 0 : table.length;
                this.fence = length;
            }
            return length;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final long getExactSizeIfKnown() {
            return java8.util.Spliterators.getExactSizeIfKnown((java8.util.Spliterator) this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean hasCharacteristics(int i) {
            return java8.util.Spliterators.hasCharacteristics((java8.util.Spliterator) this, i);
        }

        public final long estimateSize() {
            getFence();
            return this.est;
        }

        static int getModCount(java.util.HashMap<?, ?> map) {
            return U.getInt(map, MODCOUNT_OFF);
        }

        static java.lang.Object[] getTable(java.util.HashMap<?, ?> map) {
            return (java.lang.Object[]) U.getObject(map, TABLE_OFF);
        }

        static <K> K getNodeKey(java.lang.Object obj) {
            return (K) U.getObject(obj, NODE_KEY_OFF);
        }

        static <T> T getNodeValue(java.lang.Object obj) {
            return (T) U.getObject(obj, NODE_VAL_OFF);
        }

        static java.lang.Object getNextNode(java.lang.Object obj) {
            return U.getObject(obj, NODE_NXT_OFF);
        }

        static java.lang.Class<?> nodeClass() throws java.lang.ClassNotFoundException {
            try {
                return java.lang.Class.forName("java.util.HashMap$".concat((java8.util.Spliterators.IS_ANDROID || java8.util.Spliterators.HAS_STREAMS) ? "Node" : "Entry"));
            } catch (java.lang.ClassNotFoundException e) {
                if (java8.util.Spliterators.IS_ANDROID) {
                    return java.lang.Class.forName("java.util.HashMap$HashMapEntry");
                }
                throw e;
            }
        }

        static {
            sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
            U = unsafe;
            try {
                TABLE_OFF = unsafe.objectFieldOffset(java.util.HashMap.class.getDeclaredField("table"));
                MODCOUNT_OFF = unsafe.objectFieldOffset(java.util.HashMap.class.getDeclaredField("modCount"));
                java.lang.Class<?> clsNodeClass = nodeClass();
                NODE_KEY_OFF = unsafe.objectFieldOffset(clsNodeClass.getDeclaredField("key"));
                NODE_VAL_OFF = unsafe.objectFieldOffset(clsNodeClass.getDeclaredField("value"));
                NODE_NXT_OFF = unsafe.objectFieldOffset(clsNodeClass.getDeclaredField("next"));
            } catch (java.lang.Exception e) {
                throw new java.lang.Error(e);
            }
        }
    }

    private static <K, V> java.util.HashMap<K, V> getHashMapFromKeySet(java.util.Set<K> set) {
        return (java.util.HashMap) U.getObject(set, KEYSET_$0_OFF);
    }

    private static <K, V> java.util.HashMap<K, V> getHashMapFromEntrySet(java.util.Set<java.util.Map.Entry<K, V>> set) {
        return (java.util.HashMap) U.getObject(set, ENTRYSET_$0_OFF);
    }

    private static <K, V> java.util.HashMap<K, V> getHashMapFromValues(java.util.Collection<V> collection) {
        return (java.util.HashMap) U.getObject(collection, VALUES_$0_OFF);
    }

    private static <K, V> java.util.HashMap<K, V> getHashMapFromHashSet(java.util.HashSet<K> hashSet) {
        return (java.util.HashMap) U.getObject(hashSet, HASHSET_MAP_OFF);
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("java.util.HashMap$Values");
            java.lang.Class<?> cls2 = java.lang.Class.forName("java.util.HashMap$KeySet");
            java.lang.Class<?> cls3 = java.lang.Class.forName("java.util.HashMap$EntrySet");
            VALUES_$0_OFF = unsafe.objectFieldOffset(cls.getDeclaredField("this$0"));
            KEYSET_$0_OFF = unsafe.objectFieldOffset(cls2.getDeclaredField("this$0"));
            ENTRYSET_$0_OFF = unsafe.objectFieldOffset(cls3.getDeclaredField("this$0"));
            HASHSET_MAP_OFF = unsafe.objectFieldOffset(java.util.HashSet.class.getDeclaredField("map"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
