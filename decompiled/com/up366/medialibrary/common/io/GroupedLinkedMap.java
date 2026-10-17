package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class GroupedLinkedMap<K extends com.up366.medialibrary.common.io.PoolAble, V> {
    private final com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> head = new com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<>();
    private final java.util.Map<K, com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V>> keyToEntry = new java.util.HashMap();

    GroupedLinkedMap() {
    }

    public void put(K k, V v) {
        com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<>(k);
            makeTail(linkedEntry);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        linkedEntry.add(v);
    }

    public V get(K k) {
        com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<>(k);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        makeHead(linkedEntry);
        return linkedEntry.removeLast();
    }

    public V removeLast() {
        for (com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry linkedEntry = this.head.prev; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.prev) {
            V v = (V) linkedEntry.removeLast();
            if (v != null) {
                return v;
            }
            removeEntry(linkedEntry);
            this.keyToEntry.remove(linkedEntry.key);
            ((com.up366.medialibrary.common.io.PoolAble) linkedEntry.key).offer();
        }
        return null;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("GroupedLinkedMap( ");
        com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry linkedEntry = this.head.next;
        boolean z = false;
        while (!linkedEntry.equals(this.head)) {
            sb.append('{');
            sb.append(linkedEntry.key);
            sb.append(':');
            sb.append(linkedEntry.size());
            sb.append("}, ");
            linkedEntry = linkedEntry.next;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    private void makeHead(com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.prev = this.head;
        linkedEntry.next = this.head.next;
        updateEntry(linkedEntry);
    }

    private void makeTail(com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.prev = this.head.prev;
        linkedEntry.next = this.head;
        updateEntry(linkedEntry);
    }

    private static <K, V> void updateEntry(com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        linkedEntry.next.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    private static <K, V> void removeEntry(com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> linkedEntry) {
        linkedEntry.prev.next = linkedEntry.next;
        linkedEntry.next.prev = linkedEntry.prev;
    }

    private static class LinkedEntry<K, V> {
        final K key;
        com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> next;
        com.up366.medialibrary.common.io.GroupedLinkedMap.LinkedEntry<K, V> prev;
        private java.util.List<V> values;

        LinkedEntry() {
            this(null);
        }

        LinkedEntry(K k) {
            this.prev = this;
            this.next = this;
            this.key = k;
        }

        public V removeLast() {
            int size = size();
            if (size > 0) {
                return this.values.remove(size - 1);
            }
            return null;
        }

        public int size() {
            java.util.List<V> list = this.values;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void add(V v) {
            if (this.values == null) {
                this.values = new java.util.ArrayList();
            }
            this.values.add(v);
        }
    }
}
