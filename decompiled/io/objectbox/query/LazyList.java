package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LazyList<E> implements java.util.List<E> {
    private final io.objectbox.Box<E> box;
    private final java.util.List<E> entities;
    private volatile int loadedCount;
    private final long[] objectIds;
    final int size;

    protected class LazyIterator implements java.util.ListIterator<E> {
        private int index;

        public LazyIterator(int i) {
            this.index = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i = this.index;
            if (i <= 0) {
                throw new java.util.NoSuchElementException();
            }
            int i2 = i - 1;
            this.index = i2;
            return (E) io.objectbox.query.LazyList.this.get(i2);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < io.objectbox.query.LazyList.this.size;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index >= io.objectbox.query.LazyList.this.size) {
                throw new java.util.NoSuchElementException();
            }
            E e = (E) io.objectbox.query.LazyList.this.get(this.index);
            this.index++;
            return e;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    LazyList(io.objectbox.Box<E> box, long[] jArr, boolean z) {
        if (box == null || jArr == null) {
            throw new java.lang.NullPointerException("Illegal null parameters passed");
        }
        this.box = box;
        this.objectIds = jArr;
        int length = jArr.length;
        this.size = length;
        if (z) {
            this.entities = new java.util.ArrayList(length);
            for (int i = 0; i < this.size; i++) {
                this.entities.add(null);
            }
            return;
        }
        this.entities = null;
    }

    public void loadRemaining() {
        if (this.loadedCount != this.size) {
            checkCached();
            this.box.getStore().runInReadTx(new java.lang.Runnable() { // from class: io.objectbox.query.LazyList$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1397lambda$loadRemaining$0$ioobjectboxqueryLazyList();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$loadRemaining$0$io-objectbox-query-LazyList, reason: not valid java name */
    /* synthetic */ void m1397lambda$loadRemaining$0$ioobjectboxqueryLazyList() {
        for (int i = 0; i < this.size; i++) {
            get(i);
        }
    }

    protected void checkCached() {
        if (this.entities == null) {
            throw new io.objectbox.exception.DbException("This operation only works with cached lazy lists");
        }
    }

    public E peek(int i) {
        java.util.List<E> list = this.entities;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    public boolean isLoadedCompletely() {
        return this.loadedCount == this.size;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(java.util.Collection<? extends E> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, java.util.Collection<? extends E> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(java.lang.Object obj) {
        loadRemaining();
        return this.entities.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(java.util.Collection<?> collection) {
        loadRemaining();
        return this.entities.containsAll(collection);
    }

    @Override // java.util.List
    @javax.annotation.Nullable
    public E get(int i) {
        E e;
        if (i < 0 || i > this.size) {
            throw new java.lang.IndexOutOfBoundsException("Illegal cursor location " + i);
        }
        java.util.List<E> list = this.entities;
        if (list != null) {
            E e2 = list.get(i);
            if (e2 == null) {
                e2 = this.box.get(this.objectIds[i]);
                synchronized (this) {
                    E e3 = this.entities.get(i);
                    if (e3 == null) {
                        this.entities.set(i, e2);
                        this.loadedCount++;
                    } else {
                        e2 = e3;
                    }
                }
            }
            return e2;
        }
        synchronized (this) {
            e = this.box.get(this.objectIds[i]);
        }
        return e;
    }

    @Override // java.util.List
    public int indexOf(java.lang.Object obj) {
        loadRemaining();
        return this.entities.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<E> iterator() {
        return new io.objectbox.query.LazyList.LazyIterator(0);
    }

    @Override // java.util.List
    public int lastIndexOf(java.lang.Object obj) {
        loadRemaining();
        return this.entities.lastIndexOf(obj);
    }

    @Override // java.util.List
    public java.util.ListIterator<E> listIterator() {
        return new io.objectbox.query.LazyList.LazyIterator(0);
    }

    @Override // java.util.List
    public java.util.ListIterator<E> listIterator(int i) {
        return new io.objectbox.query.LazyList.LazyIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(java.util.Collection<?> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(java.util.Collection<?> collection) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public java.util.List<E> subList(int i, int i2) {
        checkCached();
        for (int i3 = i; i3 < i2; i3++) {
            get(i3);
        }
        return this.entities.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public java.lang.Object[] toArray() {
        loadRemaining();
        return this.entities.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return (T[]) this.entities.toArray(tArr);
    }
}
