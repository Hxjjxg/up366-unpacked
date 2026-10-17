package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class LruArrayPool implements com.up366.medialibrary.common.io.ArrayPool {
    public static final int DEFAULT_SIZE = 4194304;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final java.util.Map<java.lang.Class<?>, com.up366.medialibrary.common.io.ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final com.up366.medialibrary.common.io.GroupedLinkedMap<com.up366.medialibrary.common.io.LruArrayPool.Key, java.lang.Object> groupedMap;
    private final com.up366.medialibrary.common.io.LruArrayPool.KeyPool keyPool;
    private final int maxSize;
    private final java.util.Map<java.lang.Class<?>, java.util.NavigableMap<java.lang.Integer, java.lang.Integer>> sortedSizes;

    public LruArrayPool() {
        this.groupedMap = new com.up366.medialibrary.common.io.GroupedLinkedMap<>();
        this.keyPool = new com.up366.medialibrary.common.io.LruArrayPool.KeyPool();
        this.sortedSizes = new java.util.HashMap();
        this.adapters = new java.util.HashMap();
        this.maxSize = DEFAULT_SIZE;
    }

    public LruArrayPool(int i) {
        this.groupedMap = new com.up366.medialibrary.common.io.GroupedLinkedMap<>();
        this.keyPool = new com.up366.medialibrary.common.io.LruArrayPool.KeyPool();
        this.sortedSizes = new java.util.HashMap();
        this.adapters = new java.util.HashMap();
        this.maxSize = i;
    }

    @Override // com.up366.medialibrary.common.io.ArrayPool
    @java.lang.Deprecated
    public <T> void put(T t, java.lang.Class<T> cls) {
        put(t);
    }

    @Override // com.up366.medialibrary.common.io.ArrayPool
    public synchronized <T> void put(T t) {
        java.lang.Class<?> cls = t.getClass();
        com.up366.medialibrary.common.io.ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            com.up366.medialibrary.common.io.LruArrayPool.Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t);
            java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForAdapter = getSizesForAdapter(cls);
            java.lang.Integer num = (java.lang.Integer) sizesForAdapter.get(java.lang.Integer.valueOf(key.size));
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(key.size);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            sizesForAdapter.put(numValueOf, java.lang.Integer.valueOf(iIntValue));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    @Override // com.up366.medialibrary.common.io.ArrayPool
    public synchronized <T> T get(int i, java.lang.Class<T> cls) {
        com.up366.medialibrary.common.io.LruArrayPool.Key key;
        java.lang.Integer numCeilingKey = getSizesForAdapter(cls).ceilingKey(java.lang.Integer.valueOf(i));
        if (mayFillRequest(i, numCeilingKey)) {
            key = this.keyPool.get(numCeilingKey.intValue(), cls);
        } else {
            key = this.keyPool.get(i, cls);
        }
        return (T) getForKey(key, cls);
    }

    private <T> T getForKey(com.up366.medialibrary.common.io.LruArrayPool.Key key, java.lang.Class<T> cls) {
        com.up366.medialibrary.common.io.ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T t = (T) getArrayForKey(key);
        if (t != null) {
            this.currentSize -= adapterFromType.getArrayLength(t) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (android.util.Log.isLoggable(adapterFromType.getTag(), 2)) {
            android.util.Log.v(adapterFromType.getTag(), "Allocated " + key.size + " bytes");
        }
        return adapterFromType.newArray(key.size);
    }

    private <T> T getArrayForKey(com.up366.medialibrary.common.io.LruArrayPool.Key key) {
        return (T) this.groupedMap.get(key);
    }

    private boolean isSmallEnoughForReuse(int i) {
        return i <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i, java.lang.Integer num) {
        return num != null && (isNoMoreThanHalfFull() || num.intValue() <= i * 8);
    }

    private boolean isNoMoreThanHalfFull() {
        int i = this.currentSize;
        return i == 0 || this.maxSize / i >= 2;
    }

    @Override // com.up366.medialibrary.common.io.ArrayPool
    public synchronized void clearMemory() {
        evictToSize(0);
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i) {
        while (this.currentSize > i) {
            java.lang.Object objRemoveLast = this.groupedMap.removeLast();
            androidx.core.util.Preconditions.checkNotNull(objRemoveLast);
            com.up366.medialibrary.common.io.ArrayAdapterInterface adapterFromObject = getAdapterFromObject(objRemoveLast);
            this.currentSize -= adapterFromObject.getArrayLength(objRemoveLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(objRemoveLast), objRemoveLast.getClass());
            if (android.util.Log.isLoggable(adapterFromObject.getTag(), 2)) {
                android.util.Log.v(adapterFromObject.getTag(), "evicted: " + adapterFromObject.getArrayLength(objRemoveLast));
            }
        }
    }

    private void decrementArrayOfSize(int i, java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> sizesForAdapter = getSizesForAdapter(cls);
        java.lang.Integer num = (java.lang.Integer) sizesForAdapter.get(java.lang.Integer.valueOf(i));
        if (num == null) {
            throw new java.lang.NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
        if (num.intValue() == 1) {
            sizesForAdapter.remove(java.lang.Integer.valueOf(i));
        } else {
            sizesForAdapter.put(java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(num.intValue() - 1));
        }
    }

    private java.util.NavigableMap<java.lang.Integer, java.lang.Integer> getSizesForAdapter(java.lang.Class<?> cls) {
        java.util.NavigableMap<java.lang.Integer, java.lang.Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        java.util.TreeMap treeMap = new java.util.TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    private <T> com.up366.medialibrary.common.io.ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    private <T> com.up366.medialibrary.common.io.ArrayAdapterInterface<T> getAdapterFromType(java.lang.Class<T> cls) {
        com.up366.medialibrary.common.io.ArrayAdapterInterface<T> byteArrayAdapter = (com.up366.medialibrary.common.io.ArrayAdapterInterface) this.adapters.get(cls);
        if (byteArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                byteArrayAdapter = new com.up366.medialibrary.common.io.IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                byteArrayAdapter = new com.up366.medialibrary.common.io.ByteArrayAdapter();
            } else {
                throw new java.lang.IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.adapters.put(cls, byteArrayAdapter);
        }
        return byteArrayAdapter;
    }

    int getCurrentSize() {
        int iIntValue = 0;
        for (java.lang.Class<?> cls : this.sortedSizes.keySet()) {
            for (java.lang.Integer num : this.sortedSizes.get(cls).keySet()) {
                iIntValue += num.intValue() * ((java.lang.Integer) this.sortedSizes.get(cls).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return iIntValue;
    }

    private static final class KeyPool extends com.up366.medialibrary.common.io.BaseKeyPool<com.up366.medialibrary.common.io.LruArrayPool.Key> {
        KeyPool() {
        }

        com.up366.medialibrary.common.io.LruArrayPool.Key get(int i, java.lang.Class<?> cls) {
            com.up366.medialibrary.common.io.LruArrayPool.Key key = get();
            key.init(i, cls);
            return key;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.up366.medialibrary.common.io.BaseKeyPool
        public com.up366.medialibrary.common.io.LruArrayPool.Key create() {
            return new com.up366.medialibrary.common.io.LruArrayPool.Key(this);
        }
    }

    private static final class Key implements com.up366.medialibrary.common.io.PoolAble {
        private java.lang.Class<?> arrayClass;
        private final com.up366.medialibrary.common.io.LruArrayPool.KeyPool pool;
        int size;

        Key(com.up366.medialibrary.common.io.LruArrayPool.KeyPool keyPool) {
            this.pool = keyPool;
        }

        void init(int i, java.lang.Class<?> cls) {
            this.size = i;
            this.arrayClass = cls;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.up366.medialibrary.common.io.LruArrayPool.Key)) {
                return false;
            }
            com.up366.medialibrary.common.io.LruArrayPool.Key key = (com.up366.medialibrary.common.io.LruArrayPool.Key) obj;
            return this.size == key.size && this.arrayClass == key.arrayClass;
        }

        public java.lang.String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }

        @Override // com.up366.medialibrary.common.io.PoolAble
        public void offer() {
            this.pool.offer(this);
        }

        public int hashCode() {
            int i = this.size * 31;
            java.lang.Class<?> cls = this.arrayClass;
            return i + (cls != null ? cls.hashCode() : 0);
        }
    }
}
