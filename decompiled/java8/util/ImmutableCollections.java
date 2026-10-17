package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class ImmutableCollections {
    static final java.lang.Object EMPTY;
    static final java8.util.ImmutableCollections.ListN<?> EMPTY_LIST;
    static final java8.util.ImmutableCollections.MapN<?, ?> EMPTY_MAP;
    static final java8.util.ImmutableCollections.SetN<?> EMPTY_SET;
    static final int EXPAND_FACTOR = 2;
    static final boolean REVERSE;
    static final long SALT32L;

    static {
        long jNanoTime = (int) ((java.lang.System.nanoTime() * 2611923443488327891L) >> 16);
        SALT32L = 4294967295L & jNanoTime;
        REVERSE = (jNanoTime & 1) == 0;
        EMPTY = new java.lang.Object();
        EMPTY_LIST = new java8.util.ImmutableCollections.ListN<>(new java.lang.Object[0]);
        EMPTY_SET = new java8.util.ImmutableCollections.SetN<>(new java.lang.Object[0]);
        EMPTY_MAP = new java8.util.ImmutableCollections.MapN<>(new java.lang.Object[0]);
    }

    private ImmutableCollections() {
    }

    static java.lang.UnsupportedOperationException uoe() {
        return new java.lang.UnsupportedOperationException();
    }

    static abstract class AbstractImmutableCollection<E> extends java.util.AbstractCollection<E> {
        AbstractImmutableCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(java.util.Collection<? extends E> collection) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(java.lang.Object obj) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(java.util.Collection<?> collection) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(java.util.Collection<?> collection) {
            throw java8.util.ImmutableCollections.uoe();
        }
    }

    static <E> java.util.List<E> listCopy(java.util.Collection<? extends E> collection) {
        if ((collection instanceof java8.util.ImmutableCollections.AbstractImmutableList) && collection.getClass() != java8.util.ImmutableCollections.SubList.class) {
            return (java.util.List) collection;
        }
        return java8.util.Lists.of(collection.toArray());
    }

    static abstract class AbstractImmutableList<E> extends java8.util.ImmutableCollections.AbstractImmutableCollection<E> implements java.util.List<E>, java.util.RandomAccess {
        AbstractImmutableList() {
        }

        @Override // java.util.List
        public void add(int i, E e) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public boolean addAll(int i, java.util.Collection<? extends E> collection) {
            java8.util.ImmutableCollections.rangeCheckForAdd(i, size());
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public E remove(int i) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public E set(int i, E e) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public java.util.List<E> subList(int i, int i2) {
            subListRangeCheck(i, i2, size());
            return java8.util.ImmutableCollections.SubList.fromList(this, i, i2);
        }

        static void subListRangeCheck(int i, int i2, int i3) {
            if (i < 0) {
                throw new java.lang.IndexOutOfBoundsException("fromIndex = " + i);
            }
            if (i2 > i3) {
                throw new java.lang.IndexOutOfBoundsException("toIndex = " + i2);
            }
            if (i <= i2) {
                return;
            }
            throw new java.lang.IllegalArgumentException("fromIndex(" + i + ") > toIndex(" + i2 + ")");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public java.util.Iterator<E> iterator() {
            return new java8.util.ImmutableCollections.ListItr(this, size());
        }

        @Override // java.util.List
        public java.util.ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List
        public java.util.ListIterator<E> listIterator(int i) {
            int size = size();
            if (i < 0 || i > size) {
                throw outOfBounds(i);
            }
            return new java8.util.ImmutableCollections.ListItr(this, size, i);
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof java.util.List)) {
                return false;
            }
            java.util.Iterator<E> it = ((java.util.List) obj).iterator();
            int size = size();
            for (int i = 0; i < size; i++) {
                if (!it.hasNext() || !get(i).equals(it.next())) {
                    return false;
                }
            }
            return !it.hasNext();
        }

        @Override // java.util.List
        public int indexOf(java.lang.Object obj) {
            java8.util.Objects.requireNonNull(obj);
            int size = size();
            for (int i = 0; i < size; i++) {
                if (obj.equals(get(i))) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(java.lang.Object obj) {
            java8.util.Objects.requireNonNull(obj);
            for (int size = size() - 1; size >= 0; size--) {
                if (obj.equals(get(size))) {
                    return size;
                }
            }
            return -1;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int size = size();
            int iHashCode = 1;
            for (int i = 0; i < size; i++) {
                iHashCode = (iHashCode * 31) + get(i).hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(java.lang.Object obj) {
            return indexOf(obj) >= 0;
        }

        java.lang.IndexOutOfBoundsException outOfBounds(int i) {
            return new java.lang.IndexOutOfBoundsException("Index: " + i + " Size: " + size());
        }
    }

    static final class ListItr<E> implements java.util.ListIterator<E> {
        private int cursor;
        private final boolean isListIterator;
        private final java.util.List<E> list;
        private final int size;

        ListItr(java.util.List<E> list, int i) {
            this.list = list;
            this.size = i;
            this.cursor = 0;
            this.isListIterator = false;
        }

        ListItr(java.util.List<E> list, int i, int i2) {
            this.list = list;
            this.size = i;
            this.cursor = i2;
            this.isListIterator = true;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor != this.size;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            try {
                int i = this.cursor;
                E e = this.list.get(i);
                this.cursor = i + 1;
                return e;
            } catch (java.lang.IndexOutOfBoundsException unused) {
                throw new java.util.NoSuchElementException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.isListIterator) {
                return this.cursor != 0;
            }
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!this.isListIterator) {
                throw java8.util.ImmutableCollections.uoe();
            }
            try {
                int i = this.cursor - 1;
                E e = this.list.get(i);
                this.cursor = i;
                return e;
            } catch (java.lang.IndexOutOfBoundsException unused) {
                throw new java.util.NoSuchElementException();
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            if (!this.isListIterator) {
                throw java8.util.ImmutableCollections.uoe();
            }
            return this.cursor;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            if (!this.isListIterator) {
                throw java8.util.ImmutableCollections.uoe();
            }
            return this.cursor - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw java8.util.ImmutableCollections.uoe();
        }
    }

    static final class SubList<E> extends java8.util.ImmutableCollections.AbstractImmutableList<E> implements java.util.RandomAccess {
        private final int offset;
        private final java.util.List<E> root;
        private final int size;

        private SubList(java.util.List<E> list, int i, int i2) {
            this.root = list;
            this.offset = i;
            this.size = i2;
        }

        static <E> java8.util.ImmutableCollections.SubList<E> fromSubList(java8.util.ImmutableCollections.SubList<E> subList, int i, int i2) {
            return new java8.util.ImmutableCollections.SubList<>(((java8.util.ImmutableCollections.SubList) subList).root, ((java8.util.ImmutableCollections.SubList) subList).offset + i, i2 - i);
        }

        static <E> java8.util.ImmutableCollections.SubList<E> fromList(java.util.List<E> list, int i, int i2) {
            return new java8.util.ImmutableCollections.SubList<>(list, i, i2 - i);
        }

        @Override // java.util.List
        public E get(int i) {
            java8.util.Objects.checkIndex(i, this.size);
            return this.root.get(this.offset + i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        @Override // java8.util.ImmutableCollections.AbstractImmutableList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public java.util.Iterator<E> iterator() {
            return new java8.util.ImmutableCollections.ListItr(this, size());
        }

        @Override // java8.util.ImmutableCollections.AbstractImmutableList, java.util.List
        public java.util.ListIterator<E> listIterator(int i) {
            rangeCheck(i);
            return new java8.util.ImmutableCollections.ListItr(this, size(), i);
        }

        @Override // java8.util.ImmutableCollections.AbstractImmutableList, java.util.List
        public java.util.List<E> subList(int i, int i2) {
            subListRangeCheck(i, i2, this.size);
            return fromSubList(this, i, i2);
        }

        private void rangeCheck(int i) {
            if (i < 0 || i > this.size) {
                throw outOfBounds(i);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public java.lang.Object[] toArray() {
            java.lang.Object[] objArr = new java.lang.Object[this.size];
            for (int i = 0; i < this.size; i++) {
                objArr[i] = get(i);
            }
            return objArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            int i;
            if (tArr.length < this.size) {
                tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), this.size));
            }
            int i2 = 0;
            while (true) {
                i = this.size;
                if (i2 >= i) {
                    break;
                }
                tArr[i2] = get(i2);
                i2++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }
    }

    static final class List12<E> extends java8.util.ImmutableCollections.AbstractImmutableList<E> implements java.io.Serializable {
        private final E e0;
        private final java.lang.Object e1;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        List12(E e) {
            this.e0 = (E) java8.util.Objects.requireNonNull(e);
            this.e1 = java8.util.ImmutableCollections.EMPTY;
        }

        List12(E e, E e2) {
            this.e0 = (E) java8.util.Objects.requireNonNull(e);
            this.e1 = java8.util.Objects.requireNonNull(e2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.e1 != java8.util.ImmutableCollections.EMPTY ? 2 : 1;
        }

        @Override // java.util.List
        public E get(int i) {
            if (i == 0) {
                return this.e0;
            }
            if (i == 1 && this.e1 != java8.util.ImmutableCollections.EMPTY) {
                return (E) this.e1;
            }
            throw outOfBounds(i);
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            throw new java.io.InvalidObjectException("not serial proxy");
        }

        private java.lang.Object writeReplace() {
            if (this.e1 == java8.util.ImmutableCollections.EMPTY) {
                return new java8.util.ColSer(1, this.e0);
            }
            return new java8.util.ColSer(1, this.e0, this.e1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public java.lang.Object[] toArray() {
            return this.e1 == java8.util.ImmutableCollections.EMPTY ? new java.lang.Object[]{this.e0} : new java.lang.Object[]{this.e0, this.e1};
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            tArr[0] = this.e0;
            if (size == 2) {
                tArr[1] = this.e1;
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    static final class ListN<E> extends java8.util.ImmutableCollections.AbstractImmutableList<E> implements java.io.Serializable {
        private final E[] elements;

        /* JADX WARN: Multi-variable type inference failed */
        ListN(E... eArr) {
            E[] eArr2 = (E[]) new java.lang.Object[eArr.length];
            for (int i = 0; i < eArr.length; i++) {
                eArr2[i] = java8.util.Objects.requireNonNull(eArr[i]);
            }
            this.elements = eArr2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.elements.length == 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.elements.length;
        }

        @Override // java.util.List
        public E get(int i) {
            return this.elements[i];
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            throw new java.io.InvalidObjectException("not serial proxy");
        }

        private java.lang.Object writeReplace() {
            return new java8.util.ColSer(1, this.elements);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public java.lang.Object[] toArray() {
            E[] eArr = this.elements;
            return java.util.Arrays.copyOf(eArr, eArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            E[] eArr = this.elements;
            int length = eArr.length;
            if (tArr.length < length) {
                return (T[]) java.util.Arrays.copyOf(eArr, length, tArr.getClass());
            }
            java.lang.System.arraycopy(eArr, 0, tArr, 0, length);
            if (tArr.length > length) {
                tArr[length] = null;
            }
            return tArr;
        }
    }

    static abstract class AbstractImmutableSet<E> extends java8.util.ImmutableCollections.AbstractImmutableCollection<E> implements java.util.Set<E> {
        @Override // java.util.Collection, java.util.Set
        public abstract int hashCode();

        AbstractImmutableSet() {
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof java.util.Set)) {
                return false;
            }
            java.util.Collection collection = (java.util.Collection) obj;
            if (collection.size() != size()) {
                return false;
            }
            for (E e : collection) {
                if (e == null || !contains(e)) {
                    return false;
                }
            }
            return true;
        }
    }

    static final class Set12<E> extends java8.util.ImmutableCollections.AbstractImmutableSet<E> implements java.io.Serializable {
        final E e0;
        final java.lang.Object e1;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        Set12(E e) {
            this.e0 = (E) java8.util.Objects.requireNonNull(e);
            this.e1 = java8.util.ImmutableCollections.EMPTY;
        }

        Set12(E e, E e2) {
            if (e.equals(java8.util.Objects.requireNonNull(e2))) {
                throw new java.lang.IllegalArgumentException("duplicate element: " + e);
            }
            this.e0 = e;
            this.e1 = e2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.e1 == java8.util.ImmutableCollections.EMPTY ? 1 : 2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return obj.equals(this.e0) || this.e1.equals(obj);
        }

        @Override // java8.util.ImmutableCollections.AbstractImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.e0.hashCode() + (this.e1 == java8.util.ImmutableCollections.EMPTY ? 0 : this.e1.hashCode());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return new java8.util.Iterators.ImmutableIt<E>() { // from class: java8.util.ImmutableCollections.Set12.1
                private int idx;

                {
                    this.idx = java8.util.ImmutableCollections.Set12.this.e1 == java8.util.ImmutableCollections.EMPTY ? 1 : 2;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.idx > 0;
                }

                @Override // java.util.Iterator
                public E next() {
                    int i = this.idx;
                    if (i == 1) {
                        this.idx = 0;
                        return (java8.util.ImmutableCollections.REVERSE || java8.util.ImmutableCollections.Set12.this.e1 == java8.util.ImmutableCollections.EMPTY) ? java8.util.ImmutableCollections.Set12.this.e0 : (E) java8.util.ImmutableCollections.Set12.this.e1;
                    }
                    if (i == 2) {
                        this.idx = 1;
                        return java8.util.ImmutableCollections.REVERSE ? (E) java8.util.ImmutableCollections.Set12.this.e1 : java8.util.ImmutableCollections.Set12.this.e0;
                    }
                    throw new java.util.NoSuchElementException();
                }
            };
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            throw new java.io.InvalidObjectException("not serial proxy");
        }

        private java.lang.Object writeReplace() {
            if (this.e1 == java8.util.ImmutableCollections.EMPTY) {
                return new java8.util.ColSer(2, this.e0);
            }
            return new java8.util.ColSer(2, this.e0, this.e1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            if (this.e1 == java8.util.ImmutableCollections.EMPTY) {
                return new java.lang.Object[]{this.e0};
            }
            if (java8.util.ImmutableCollections.REVERSE) {
                return new java.lang.Object[]{this.e1, this.e0};
            }
            return new java.lang.Object[]{this.e0, this.e1};
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            if (size == 1) {
                tArr[0] = this.e0;
            } else if (java8.util.ImmutableCollections.REVERSE) {
                tArr[0] = this.e1;
                tArr[1] = this.e0;
            } else {
                tArr[0] = this.e0;
                tArr[1] = this.e1;
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    static final class SetN<E> extends java8.util.ImmutableCollections.AbstractImmutableSet<E> implements java.io.Serializable {
        final E[] elements;
        final int size;

        SetN(E... eArr) {
            this.size = eArr.length;
            this.elements = (E[]) new java.lang.Object[eArr.length * 2];
            for (E e : eArr) {
                int iProbe = probe(e);
                if (iProbe >= 0) {
                    throw new java.lang.IllegalArgumentException("duplicate element: " + e);
                }
                this.elements[-(iProbe + 1)] = e;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            java8.util.Objects.requireNonNull(obj);
            return this.size > 0 && probe(obj) >= 0;
        }

        private final class SetNIterator extends java8.util.Iterators.ImmutableIt<E> implements java.util.Iterator<E> {
            private int idx;
            private int remaining;

            SetNIterator() {
                this.remaining = java8.util.ImmutableCollections.SetN.this.size;
                this.idx = (int) ((java8.util.ImmutableCollections.SALT32L * ((long) java8.util.ImmutableCollections.SetN.this.elements.length)) >>> 32);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.remaining > 0;
            }

            @Override // java.util.Iterator
            public E next() {
                E e;
                if (this.remaining > 0) {
                    int i = this.idx;
                    int length = java8.util.ImmutableCollections.SetN.this.elements.length;
                    do {
                        if (java8.util.ImmutableCollections.REVERSE) {
                            i++;
                            if (i >= length) {
                                i = 0;
                            }
                        } else {
                            i--;
                            if (i < 0) {
                                i = length - 1;
                            }
                        }
                        e = java8.util.ImmutableCollections.SetN.this.elements[i];
                    } while (e == null);
                    this.idx = i;
                    this.remaining--;
                    return e;
                }
                throw new java.util.NoSuchElementException();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<E> iterator() {
            return new java8.util.ImmutableCollections.SetN.SetNIterator();
        }

        @Override // java8.util.ImmutableCollections.AbstractImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            int iHashCode = 0;
            for (E e : this.elements) {
                if (e != null) {
                    iHashCode += e.hashCode();
                }
            }
            return iHashCode;
        }

        private int probe(java.lang.Object obj) {
            int iFloorMod = java8.util.ImmutableCollections.floorMod(obj.hashCode(), this.elements.length);
            while (true) {
                E e = this.elements[iFloorMod];
                if (e == null) {
                    return (-iFloorMod) - 1;
                }
                if (obj.equals(e)) {
                    return iFloorMod;
                }
                iFloorMod++;
                if (iFloorMod == this.elements.length) {
                    iFloorMod = 0;
                }
            }
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            throw new java.io.InvalidObjectException("not serial proxy");
        }

        private java.lang.Object writeReplace() {
            java.lang.Object[] objArr = new java.lang.Object[this.size];
            int i = 0;
            for (E e : this.elements) {
                if (e != null) {
                    objArr[i] = e;
                    i++;
                }
            }
            return new java8.util.ColSer(2, objArr);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public java.lang.Object[] toArray() {
            java.lang.Object[] objArr = new java.lang.Object[this.size];
            java.util.Iterator<E> it = iterator();
            for (int i = 0; i < this.size; i++) {
                objArr[i] = it.next();
            }
            return objArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int i;
            if (tArr.length < this.size) {
                tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), this.size));
            }
            java.util.Iterator<E> it = iterator();
            int i2 = 0;
            while (true) {
                i = this.size;
                if (i2 >= i) {
                    break;
                }
                tArr[i2] = it.next();
                i2++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }
    }

    static abstract class AbstractImmutableMap<K, V> extends java.util.AbstractMap<K, V> implements java.io.Serializable {
        AbstractImmutableMap() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(java.util.Map<? extends K, ? extends V> map) {
            throw java8.util.ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(java.lang.Object obj) {
            throw java8.util.ImmutableCollections.uoe();
        }
    }

    static final class Map1<K, V> extends java8.util.ImmutableCollections.AbstractImmutableMap<K, V> {
        private final K k0;
        private final V v0;

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return 1;
        }

        Map1(K k, V v) {
            this.k0 = (K) java8.util.Objects.requireNonNull(k);
            this.v0 = (V) java8.util.Objects.requireNonNull(v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
            return java8.util.Sets.of(new java8.util.KeyValueHolder(this.k0, this.v0));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(java.lang.Object obj) {
            if (obj.equals(this.k0)) {
                return this.v0;
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            return obj.equals(this.k0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(java.lang.Object obj) {
            return obj.equals(this.v0);
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            throw new java.io.InvalidObjectException("not serial proxy");
        }

        private java.lang.Object writeReplace() {
            return new java8.util.ColSer(3, this.k0, this.v0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.k0.hashCode() ^ this.v0.hashCode();
        }
    }

    static final class MapN<K, V> extends java8.util.ImmutableCollections.AbstractImmutableMap<K, V> {
        final int size;
        final java.lang.Object[] table;

        MapN(java.lang.Object... objArr) {
            if ((objArr.length & 1) != 0) {
                throw new java.lang.InternalError("length is odd");
            }
            this.size = objArr.length >> 1;
            this.table = new java.lang.Object[((objArr.length * 2) + 1) & (-2)];
            for (int i = 0; i < objArr.length; i += 2) {
                java.lang.Object objRequireNonNull = java8.util.Objects.requireNonNull(objArr[i]);
                java.lang.Object objRequireNonNull2 = java8.util.Objects.requireNonNull(objArr[i + 1]);
                int iProbe = probe(objRequireNonNull);
                if (iProbe >= 0) {
                    throw new java.lang.IllegalArgumentException("duplicate key: " + objRequireNonNull);
                }
                int i2 = -(iProbe + 1);
                java.lang.Object[] objArr2 = this.table;
                objArr2[i2] = objRequireNonNull;
                objArr2[i2 + 1] = objRequireNonNull2;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(java.lang.Object obj) {
            java8.util.Objects.requireNonNull(obj);
            return this.size > 0 && probe(obj) >= 0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(java.lang.Object obj) {
            java8.util.Objects.requireNonNull(obj);
            int i = 1;
            while (true) {
                java.lang.Object[] objArr = this.table;
                if (i >= objArr.length) {
                    return false;
                }
                java.lang.Object obj2 = objArr[i];
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
                i += 2;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            int i = 0;
            int iHashCode = 0;
            while (true) {
                java.lang.Object[] objArr = this.table;
                if (i >= objArr.length) {
                    return iHashCode;
                }
                java.lang.Object obj = objArr[i];
                if (obj != null) {
                    iHashCode += obj.hashCode() ^ this.table[i + 1].hashCode();
                }
                i += 2;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(java.lang.Object obj) {
            if (this.size == 0) {
                java8.util.Objects.requireNonNull(obj);
                return null;
            }
            int iProbe = probe(obj);
            if (iProbe >= 0) {
                return (V) this.table[iProbe + 1];
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.size == 0;
        }

        class MapNIterator extends java8.util.Iterators.ImmutableIt<java.util.Map.Entry<K, V>> implements java.util.Iterator<java.util.Map.Entry<K, V>> {
            private int idx;
            private int remaining;

            MapNIterator() {
                this.remaining = java8.util.ImmutableCollections.MapN.this.size;
                this.idx = ((int) ((java8.util.ImmutableCollections.SALT32L * ((long) (java8.util.ImmutableCollections.MapN.this.table.length >> 1))) >>> 32)) << 1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.remaining > 0;
            }

            private int nextIndex() {
                int length;
                int i = this.idx;
                if (java8.util.ImmutableCollections.REVERSE) {
                    length = i + 2;
                    if (length >= java8.util.ImmutableCollections.MapN.this.table.length) {
                        length = 0;
                    }
                } else {
                    length = i - 2;
                    if (length < 0) {
                        length = java8.util.ImmutableCollections.MapN.this.table.length - 2;
                    }
                }
                this.idx = length;
                return length;
            }

            @Override // java.util.Iterator
            public java.util.Map.Entry<K, V> next() {
                java.lang.Object[] objArr;
                int iNextIndex;
                if (this.remaining > 0) {
                    do {
                        objArr = java8.util.ImmutableCollections.MapN.this.table;
                        iNextIndex = nextIndex();
                    } while (objArr[iNextIndex] == null);
                    this.remaining--;
                    return new java8.util.KeyValueHolder(java8.util.ImmutableCollections.MapN.this.table[iNextIndex], java8.util.ImmutableCollections.MapN.this.table[iNextIndex + 1]);
                }
                throw new java.util.NoSuchElementException();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
            return new java.util.AbstractSet<java.util.Map.Entry<K, V>>() { // from class: java8.util.ImmutableCollections.MapN.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return java8.util.ImmutableCollections.MapN.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                    return new java8.util.ImmutableCollections.MapN.MapNIterator();
                }
            };
        }

        private int probe(java.lang.Object obj) {
            int iFloorMod = java8.util.ImmutableCollections.floorMod(obj.hashCode(), this.table.length >> 1) << 1;
            while (true) {
                java.lang.Object obj2 = this.table[iFloorMod];
                if (obj2 == null) {
                    return (-iFloorMod) - 1;
                }
                if (obj.equals(obj2)) {
                    return iFloorMod;
                }
                iFloorMod += 2;
                if (iFloorMod == this.table.length) {
                    iFloorMod = 0;
                }
            }
        }

        private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
            throw new java.io.InvalidObjectException("not serial proxy");
        }

        private java.lang.Object writeReplace() {
            java.lang.Object[] objArr = new java.lang.Object[this.size * 2];
            int length = this.table.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2 += 2) {
                java.lang.Object[] objArr2 = this.table;
                java.lang.Object obj = objArr2[i2];
                if (obj != null) {
                    int i3 = i + 1;
                    objArr[i] = obj;
                    i += 2;
                    objArr[i3] = objArr2[i2 + 1];
                }
            }
            return new java8.util.ColSer(3, objArr);
        }
    }

    static void rangeCheckForAdd(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new java.lang.IndexOutOfBoundsException("Index: " + i + ", Size: " + i2);
        }
    }

    static int floorMod(int i, int i2) {
        int i3 = i % i2;
        return ((i3 ^ i2) >= 0 || i3 == 0) ? i3 : i3 + i2;
    }
}
