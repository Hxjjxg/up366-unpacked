package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class KeyValueHolder<K, V> implements java.util.Map.Entry<K, V> {
    final K key;
    final V value;

    KeyValueHolder(K k, V v) {
        this.key = (K) java8.util.Objects.requireNonNull(k);
        this.value = (V) java8.util.Objects.requireNonNull(v);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new java.lang.UnsupportedOperationException("not supported");
    }

    @Override // java.util.Map.Entry
    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof java.util.Map.Entry)) {
            return false;
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) obj;
        return this.key.equals(entry.getKey()) && this.value.equals(entry.getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }

    public java.lang.String toString() {
        return this.key + "=" + this.value;
    }
}
