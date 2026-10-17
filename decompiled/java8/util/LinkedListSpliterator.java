package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class LinkedListSpliterator<T> implements java8.util.Spliterator<T> {
    private static final int BATCH_UNIT = 1024;
    private static final long FIRST_OFF;
    private static final boolean IS_HARMONY;
    private static final boolean IS_JAVA6;
    private static final int MAX_BATCH = 33554432;
    private static final long MODCOUNT_OFF;
    private static final long NODE_ITEM_OFF;
    private static final long NODE_NEXT_OFF;
    private static final long SIZE_OFF;
    private static final sun.misc.Unsafe U;
    private int batch;
    private java.lang.Object current;
    private final java.lang.Object endOfList;
    private int est;
    private int expectedModCount;
    private final java.util.LinkedList<T> list;

    @Override // java8.util.Spliterator
    public int characteristics() {
        return 16464;
    }

    private LinkedListSpliterator(java.util.LinkedList<T> linkedList, int i, int i2) {
        this.list = linkedList;
        this.est = i;
        this.expectedModCount = i2;
        this.endOfList = (IS_JAVA6 || IS_HARMONY) ? getHeader(linkedList) : null;
    }

    static <E> java8.util.Spliterator<E> spliterator(java.util.LinkedList<E> linkedList) {
        return new java8.util.LinkedListSpliterator(linkedList, -1, 0);
    }

    private int getEst() {
        int i = this.est;
        if (i >= 0) {
            return i;
        }
        java.util.LinkedList<T> linkedList = this.list;
        if (linkedList == null) {
            this.est = 0;
            return 0;
        }
        this.expectedModCount = getModCount(linkedList);
        this.current = getFirst(linkedList);
        int size = getSize(linkedList);
        this.est = size;
        return size;
    }

    @Override // java8.util.Spliterator
    public long estimateSize() {
        return getEst();
    }

    @Override // java8.util.Spliterator
    public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
        java8.util.Objects.requireNonNull(consumer);
        java.lang.Object obj = this.endOfList;
        int est = getEst();
        if (est > 0 && (nextNode = this.current) != obj) {
            this.current = obj;
            this.est = 0;
            do {
                android.R.color colorVar = (java.lang.Object) getNodeItem(nextNode);
                java.lang.Object nextNode = getNextNode(nextNode);
                consumer.accept(colorVar);
                if (nextNode == obj) {
                    break;
                } else {
                    est--;
                }
            } while (est > 0);
        }
        if (this.expectedModCount != getModCount(this.list)) {
            throw new java.util.ConcurrentModificationException();
        }
    }

    @Override // java8.util.Spliterator
    public java.util.Comparator<? super T> getComparator() {
        return java8.util.Spliterators.getComparator(this);
    }

    @Override // java8.util.Spliterator
    public long getExactSizeIfKnown() {
        return java8.util.Spliterators.getExactSizeIfKnown(this);
    }

    @Override // java8.util.Spliterator
    public boolean hasCharacteristics(int i) {
        return java8.util.Spliterators.hasCharacteristics(this, i);
    }

    @Override // java8.util.Spliterator
    public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
        java.lang.Object obj;
        java8.util.Objects.requireNonNull(consumer);
        java.lang.Object obj2 = this.endOfList;
        if (getEst() <= 0 || (obj = this.current) == obj2) {
            return false;
        }
        this.est--;
        android.R.color colorVar = (java.lang.Object) getNodeItem(obj);
        this.current = getNextNode(obj);
        consumer.accept(colorVar);
        if (this.expectedModCount == getModCount(this.list)) {
            return true;
        }
        throw new java.util.ConcurrentModificationException();
    }

    @Override // java8.util.Spliterator
    public java8.util.Spliterator<T> trySplit() {
        java.lang.Object nextNode;
        int i;
        java.lang.Object obj = this.endOfList;
        int est = getEst();
        if (est <= 1 || (nextNode = this.current) == obj) {
            return null;
        }
        int i2 = this.batch + 1024;
        if (i2 > est) {
            i2 = est;
        }
        if (i2 > MAX_BATCH) {
            i2 = MAX_BATCH;
        }
        java.lang.Object[] objArr = new java.lang.Object[i2];
        int i3 = 0;
        while (true) {
            i = i3 + 1;
            objArr[i3] = getNodeItem(nextNode);
            nextNode = getNextNode(nextNode);
            if (nextNode == obj || i >= i2) {
                break;
            }
            i3 = i;
        }
        this.current = nextNode;
        this.batch = i;
        this.est = est - i;
        return java8.util.Spliterators.spliterator(objArr, 0, i, 16);
    }

    private static java.lang.Object getHeader(java.util.LinkedList<?> linkedList) {
        if (linkedList == null) {
            return null;
        }
        return U.getObject(linkedList, FIRST_OFF);
    }

    private java.lang.Object getFirst(java.util.LinkedList<?> linkedList) {
        if (IS_JAVA6 || IS_HARMONY) {
            return getNextNode(this.endOfList);
        }
        return U.getObject(linkedList, FIRST_OFF);
    }

    private static java.lang.Object getNextNode(java.lang.Object obj) {
        if (obj == null) {
            throw new java.util.ConcurrentModificationException();
        }
        return U.getObject(obj, NODE_NEXT_OFF);
    }

    private static <E> E getNodeItem(java.lang.Object obj) {
        if (obj == null) {
            throw new java.util.ConcurrentModificationException();
        }
        return (E) U.getObject(obj, NODE_ITEM_OFF);
    }

    private static int getSize(java.util.LinkedList<?> linkedList) {
        return U.getInt(linkedList, SIZE_OFF);
    }

    private static int getModCount(java.util.LinkedList<?> linkedList) {
        return U.getInt(linkedList, MODCOUNT_OFF);
    }

    static {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        boolean z = java8.util.Spliterators.IS_HARMONY_ANDROID;
        IS_HARMONY = z;
        boolean z2 = java8.util.Spliterators.IS_JAVA6;
        IS_JAVA6 = z2;
        sun.misc.Unsafe unsafe = java8.util.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            MODCOUNT_OFF = unsafe.objectFieldOffset(java.util.AbstractList.class.getDeclaredField("modCount"));
            if (z) {
                str = "voidLink";
            } else {
                str = z2 ? "header" : "first";
            }
            if (z) {
                str2 = "java.util.LinkedList$Link";
            } else {
                str2 = z2 ? "java.util.LinkedList$Entry" : "java.util.LinkedList$Node";
            }
            if (z) {
                str3 = "data";
            } else {
                str3 = z2 ? "element" : "item";
            }
            java.lang.Class<?> cls = java.lang.Class.forName(str2);
            SIZE_OFF = unsafe.objectFieldOffset(java.util.LinkedList.class.getDeclaredField("size"));
            FIRST_OFF = unsafe.objectFieldOffset(java.util.LinkedList.class.getDeclaredField(str));
            NODE_ITEM_OFF = unsafe.objectFieldOffset(cls.getDeclaredField(str3));
            NODE_NEXT_OFF = unsafe.objectFieldOffset(cls.getDeclaredField("next"));
        } catch (java.lang.Exception e) {
            throw new java.lang.Error(e);
        }
    }
}
