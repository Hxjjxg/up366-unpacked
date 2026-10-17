package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class SpinedBuffer<E> extends java8.util.stream.AbstractSpinedBuffer implements java8.util.function.Consumer<E> {
    private static final int SPLITERATOR_CHARACTERISTICS = 16464;
    protected E[] curChunk;
    protected E[][] spine;

    SpinedBuffer(int i) {
        super(i);
        this.curChunk = (E[]) new java.lang.Object[1 << this.initialChunkPower];
    }

    SpinedBuffer() {
        this.curChunk = (E[]) new java.lang.Object[1 << this.initialChunkPower];
    }

    protected long capacity() {
        return this.spineIndex == 0 ? this.curChunk.length : this.priorElementCount[this.spineIndex] + ((long) this.spine[this.spineIndex].length);
    }

    private void inflateSpine() {
        if (this.spine == null) {
            this.spine = (E[][]) new java.lang.Object[8][];
            this.priorElementCount = new long[8];
            this.spine[0] = this.curChunk;
        }
    }

    protected final void ensureCapacity(long j) {
        long jCapacity = capacity();
        if (j <= jCapacity) {
            return;
        }
        inflateSpine();
        int i = this.spineIndex;
        while (true) {
            i++;
            if (j <= jCapacity) {
                return;
            }
            E[][] eArr = this.spine;
            if (i >= eArr.length) {
                int length = eArr.length * 2;
                this.spine = (E[][]) ((java.lang.Object[][]) java.util.Arrays.copyOf(eArr, length));
                this.priorElementCount = java.util.Arrays.copyOf(this.priorElementCount, length);
            }
            int iChunkSize = chunkSize(i);
            ((E[][]) this.spine)[i] = new java.lang.Object[iChunkSize];
            int i2 = i - 1;
            this.priorElementCount[i] = this.priorElementCount[i2] + ((long) this.spine[i2].length);
            jCapacity += (long) iChunkSize;
        }
    }

    protected void increaseCapacity() {
        ensureCapacity(capacity() + 1);
    }

    public E get(long j) {
        if (this.spineIndex == 0) {
            if (j < this.elementIndex) {
                return this.curChunk[(int) j];
            }
            throw new java.lang.IndexOutOfBoundsException(java.lang.Long.toString(j));
        }
        if (j >= count()) {
            throw new java.lang.IndexOutOfBoundsException(java.lang.Long.toString(j));
        }
        for (int i = 0; i <= this.spineIndex; i++) {
            long j2 = this.priorElementCount[i];
            E[] eArr = this.spine[i];
            if (j < j2 + ((long) eArr.length)) {
                return eArr[(int) (j - this.priorElementCount[i])];
            }
        }
        throw new java.lang.IndexOutOfBoundsException(java.lang.Long.toString(j));
    }

    public void copyInto(E[] eArr, int i) {
        long j = i;
        long jCount = count() + j;
        if (jCount > eArr.length || jCount < j) {
            throw new java.lang.IndexOutOfBoundsException("does not fit");
        }
        if (this.spineIndex == 0) {
            java.lang.System.arraycopy(this.curChunk, 0, eArr, i, this.elementIndex);
            return;
        }
        for (int i2 = 0; i2 < this.spineIndex; i2++) {
            E[] eArr2 = this.spine[i2];
            java.lang.System.arraycopy(eArr2, 0, eArr, i, eArr2.length);
            i += this.spine[i2].length;
        }
        if (this.elementIndex > 0) {
            java.lang.System.arraycopy(this.curChunk, 0, eArr, i, this.elementIndex);
        }
    }

    public E[] asArray(java8.util.function.IntFunction<E[]> intFunction) {
        long jCount = count();
        if (jCount >= 2147483639) {
            throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
        }
        E[] eArrApply = intFunction.apply((int) jCount);
        copyInto(eArrApply, 0);
        return eArrApply;
    }

    @Override // java8.util.stream.AbstractSpinedBuffer
    public void clear() {
        E[][] eArr = this.spine;
        if (eArr != null) {
            this.curChunk = eArr[0];
            int i = 0;
            while (true) {
                E[] eArr2 = this.curChunk;
                if (i >= eArr2.length) {
                    break;
                }
                eArr2[i] = null;
                i++;
            }
            this.spine = null;
            this.priorElementCount = null;
        } else {
            for (int i2 = 0; i2 < this.elementIndex; i2++) {
                this.curChunk[i2] = null;
            }
        }
        this.elementIndex = 0;
        this.spineIndex = 0;
    }

    public java.util.Iterator<E> iterator() {
        return java8.util.Spliterators.iterator(spliterator());
    }

    public void forEach(java8.util.function.Consumer<? super E> consumer) {
        for (int i = 0; i < this.spineIndex; i++) {
            for (android.R.color colorVar : this.spine[i]) {
                consumer.accept(colorVar);
            }
        }
        for (int i2 = 0; i2 < this.elementIndex; i2++) {
            consumer.accept(this.curChunk[i2]);
        }
    }

    public void accept(E e) {
        if (this.elementIndex == this.curChunk.length) {
            inflateSpine();
            int i = this.spineIndex + 1;
            E[][] eArr = this.spine;
            if (i >= eArr.length || eArr[this.spineIndex + 1] == null) {
                increaseCapacity();
            }
            this.elementIndex = 0;
            this.spineIndex++;
            this.curChunk = this.spine[this.spineIndex];
        }
        E[] eArr2 = this.curChunk;
        int i2 = this.elementIndex;
        this.elementIndex = i2 + 1;
        eArr2[i2] = e;
    }

    public java.lang.String toString() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        forEach(java8.util.stream.SpinedBuffer$$Lambda$1.lambdaFactory$(arrayList));
        return "SpinedBuffer:" + arrayList.toString();
    }

    /* JADX INFO: renamed from: java8.util.stream.SpinedBuffer$1Splitr, reason: invalid class name */
    class C1Splitr implements java8.util.Spliterator<E> {
        final int lastSpineElementFence;
        final int lastSpineIndex;
        E[] splChunk;
        int splElementIndex;
        int splSpineIndex;

        @Override // java8.util.Spliterator
        public int characteristics() {
            return java8.util.stream.SpinedBuffer.SPLITERATOR_CHARACTERISTICS;
        }

        C1Splitr(int i, int i2, int i3, int i4) {
            this.splSpineIndex = i;
            this.lastSpineIndex = i2;
            this.splElementIndex = i3;
            this.lastSpineElementFence = i4;
            this.splChunk = java8.util.stream.SpinedBuffer.this.spine == null ? java8.util.stream.SpinedBuffer.this.curChunk : java8.util.stream.SpinedBuffer.this.spine[i];
        }

        @Override // java8.util.Spliterator
        public long estimateSize() {
            return this.splSpineIndex == this.lastSpineIndex ? ((long) this.lastSpineElementFence) - ((long) this.splElementIndex) : ((java8.util.stream.SpinedBuffer.this.priorElementCount[this.lastSpineIndex] + ((long) this.lastSpineElementFence)) - java8.util.stream.SpinedBuffer.this.priorElementCount[this.splSpineIndex]) - ((long) this.splElementIndex);
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
        public java.util.Comparator<? super E> getComparator() {
            return java8.util.Spliterators.getComparator(this);
        }

        @Override // java8.util.Spliterator
        public boolean tryAdvance(java8.util.function.Consumer<? super E> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            int i = this.splSpineIndex;
            int i2 = this.lastSpineIndex;
            if (i >= i2 && (i != i2 || this.splElementIndex >= this.lastSpineElementFence)) {
                return false;
            }
            E[] eArr = this.splChunk;
            int i3 = this.splElementIndex;
            this.splElementIndex = i3 + 1;
            consumer.accept(eArr[i3]);
            if (this.splElementIndex == this.splChunk.length) {
                this.splElementIndex = 0;
                this.splSpineIndex++;
                if (java8.util.stream.SpinedBuffer.this.spine != null && this.splSpineIndex <= this.lastSpineIndex) {
                    this.splChunk = java8.util.stream.SpinedBuffer.this.spine[this.splSpineIndex];
                }
            }
            return true;
        }

        @Override // java8.util.Spliterator
        public void forEachRemaining(java8.util.function.Consumer<? super E> consumer) {
            int i;
            java8.util.Objects.requireNonNull(consumer);
            int i2 = this.splSpineIndex;
            int i3 = this.lastSpineIndex;
            if (i2 < i3 || (i2 == i3 && this.splElementIndex < this.lastSpineElementFence)) {
                int i4 = this.splElementIndex;
                while (true) {
                    i = this.lastSpineIndex;
                    if (i2 >= i) {
                        break;
                    }
                    android.R.color[] colorVarArr = java8.util.stream.SpinedBuffer.this.spine[i2];
                    while (i4 < colorVarArr.length) {
                        consumer.accept(colorVarArr[i4]);
                        i4++;
                    }
                    i2++;
                    i4 = 0;
                }
                E[] eArr = this.splSpineIndex == i ? this.splChunk : (E[]) java8.util.stream.SpinedBuffer.this.spine[this.lastSpineIndex];
                int i5 = this.lastSpineElementFence;
                while (i4 < i5) {
                    consumer.accept(eArr[i4]);
                    i4++;
                }
                this.splSpineIndex = this.lastSpineIndex;
                this.splElementIndex = this.lastSpineElementFence;
            }
        }

        @Override // java8.util.Spliterator
        public java8.util.Spliterator<E> trySplit() {
            int i = this.splSpineIndex;
            int i2 = this.lastSpineIndex;
            if (i < i2) {
                java8.util.stream.SpinedBuffer spinedBuffer = java8.util.stream.SpinedBuffer.this;
                java8.util.stream.SpinedBuffer.C1Splitr c1Splitr = new java8.util.stream.SpinedBuffer.C1Splitr(i, i2 - 1, this.splElementIndex, spinedBuffer.spine[this.lastSpineIndex - 1].length);
                this.splSpineIndex = this.lastSpineIndex;
                this.splElementIndex = 0;
                this.splChunk = java8.util.stream.SpinedBuffer.this.spine[this.splSpineIndex];
                return c1Splitr;
            }
            if (i != i2) {
                return null;
            }
            int i3 = this.lastSpineElementFence;
            int i4 = this.splElementIndex;
            int i5 = (i3 - i4) / 2;
            if (i5 == 0) {
                return null;
            }
            java8.util.Spliterator<E> spliterator = java8.util.J8Arrays.spliterator(this.splChunk, i4, i4 + i5);
            this.splElementIndex += i5;
            return spliterator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public java8.util.Spliterator<E> spliterator() {
        return new java8.util.stream.SpinedBuffer.C1Splitr(0, this.spineIndex, 0, this.elementIndex);
    }

    static abstract class OfPrimitive<E, T_ARR, T_CONS> extends java8.util.stream.AbstractSpinedBuffer {
        T_ARR curChunk;
        T_ARR[] spine;

        protected abstract void arrayForEach(T_ARR t_arr, int i, int i2, T_CONS t_cons);

        protected abstract int arrayLength(T_ARR t_arr);

        public abstract void forEach(java8.util.function.Consumer<? super E> consumer);

        public abstract java.util.Iterator<E> iterator();

        public abstract T_ARR newArray(int i);

        protected abstract T_ARR[] newArrayArray(int i);

        OfPrimitive(int i) {
            super(i);
            this.curChunk = newArray(1 << this.initialChunkPower);
        }

        OfPrimitive() {
            this.curChunk = newArray(1 << this.initialChunkPower);
        }

        protected long capacity() {
            if (this.spineIndex == 0) {
                return arrayLength(this.curChunk);
            }
            return this.priorElementCount[this.spineIndex] + ((long) arrayLength(this.spine[this.spineIndex]));
        }

        private void inflateSpine() {
            if (this.spine == null) {
                this.spine = newArrayArray(8);
                this.priorElementCount = new long[8];
                this.spine[0] = this.curChunk;
            }
        }

        protected final void ensureCapacity(long j) {
            long jCapacity = capacity();
            if (j <= jCapacity) {
                return;
            }
            inflateSpine();
            int i = this.spineIndex;
            while (true) {
                i++;
                if (j <= jCapacity) {
                    return;
                }
                T_ARR[] t_arrArr = this.spine;
                if (i >= t_arrArr.length) {
                    int length = t_arrArr.length * 2;
                    this.spine = (T_ARR[]) java.util.Arrays.copyOf(t_arrArr, length);
                    this.priorElementCount = java.util.Arrays.copyOf(this.priorElementCount, length);
                }
                int iChunkSize = chunkSize(i);
                this.spine[i] = newArray(iChunkSize);
                int i2 = i - 1;
                this.priorElementCount[i] = this.priorElementCount[i2] + ((long) arrayLength(this.spine[i2]));
                jCapacity += (long) iChunkSize;
            }
        }

        protected void increaseCapacity() {
            ensureCapacity(capacity() + 1);
        }

        protected int chunkFor(long j) {
            if (this.spineIndex == 0) {
                if (j < this.elementIndex) {
                    return 0;
                }
                throw new java.lang.IndexOutOfBoundsException(java.lang.Long.toString(j));
            }
            if (j >= count()) {
                throw new java.lang.IndexOutOfBoundsException(java.lang.Long.toString(j));
            }
            for (int i = 0; i <= this.spineIndex; i++) {
                if (j < this.priorElementCount[i] + ((long) arrayLength(this.spine[i]))) {
                    return i;
                }
            }
            throw new java.lang.IndexOutOfBoundsException(java.lang.Long.toString(j));
        }

        public void copyInto(T_ARR t_arr, int i) {
            long j = i;
            long jCount = count() + j;
            if (jCount > arrayLength(t_arr) || jCount < j) {
                throw new java.lang.IndexOutOfBoundsException("does not fit");
            }
            if (this.spineIndex == 0) {
                java.lang.System.arraycopy(this.curChunk, 0, t_arr, i, this.elementIndex);
                return;
            }
            for (int i2 = 0; i2 < this.spineIndex; i2++) {
                T_ARR t_arr2 = this.spine[i2];
                java.lang.System.arraycopy(t_arr2, 0, t_arr, i, arrayLength(t_arr2));
                i += arrayLength(this.spine[i2]);
            }
            if (this.elementIndex > 0) {
                java.lang.System.arraycopy(this.curChunk, 0, t_arr, i, this.elementIndex);
            }
        }

        public T_ARR asPrimitiveArray() {
            long jCount = count();
            if (jCount >= 2147483639) {
                throw new java.lang.IllegalArgumentException("Stream size exceeds max array size");
            }
            T_ARR t_arrNewArray = newArray((int) jCount);
            copyInto(t_arrNewArray, 0);
            return t_arrNewArray;
        }

        protected void preAccept() {
            if (this.elementIndex == arrayLength(this.curChunk)) {
                inflateSpine();
                int i = this.spineIndex + 1;
                T_ARR[] t_arrArr = this.spine;
                if (i >= t_arrArr.length || t_arrArr[this.spineIndex + 1] == null) {
                    increaseCapacity();
                }
                this.elementIndex = 0;
                this.spineIndex++;
                this.curChunk = this.spine[this.spineIndex];
            }
        }

        @Override // java8.util.stream.AbstractSpinedBuffer
        public void clear() {
            T_ARR[] t_arrArr = this.spine;
            if (t_arrArr != null) {
                this.curChunk = t_arrArr[0];
                this.spine = null;
                this.priorElementCount = null;
            }
            this.elementIndex = 0;
            this.spineIndex = 0;
        }

        public void forEach(T_CONS t_cons) {
            for (int i = 0; i < this.spineIndex; i++) {
                T_ARR t_arr = this.spine[i];
                arrayForEach(t_arr, 0, arrayLength(t_arr), t_cons);
            }
            arrayForEach(this.curChunk, 0, this.elementIndex, t_cons);
        }

        abstract class BaseSpliterator<T_SPLITR extends java8.util.Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>> implements java8.util.Spliterator.OfPrimitive<E, T_CONS, T_SPLITR> {
            final int lastSpineElementFence;
            final int lastSpineIndex;
            T_ARR splChunk;
            int splElementIndex;
            int splSpineIndex;

            abstract void arrayForOne(T_ARR t_arr, int i, T_CONS t_cons);

            abstract T_SPLITR arraySpliterator(T_ARR t_arr, int i, int i2);

            @Override // java8.util.Spliterator
            public int characteristics() {
                return java8.util.stream.SpinedBuffer.SPLITERATOR_CHARACTERISTICS;
            }

            abstract T_SPLITR newSpliterator(int i, int i2, int i3, int i4);

            BaseSpliterator(int i, int i2, int i3, int i4) {
                this.splSpineIndex = i;
                this.lastSpineIndex = i2;
                this.splElementIndex = i3;
                this.lastSpineElementFence = i4;
                this.splChunk = java8.util.stream.SpinedBuffer.OfPrimitive.this.spine == null ? java8.util.stream.SpinedBuffer.OfPrimitive.this.curChunk : java8.util.stream.SpinedBuffer.OfPrimitive.this.spine[i];
            }

            @Override // java8.util.Spliterator
            public long estimateSize() {
                return this.splSpineIndex == this.lastSpineIndex ? ((long) this.lastSpineElementFence) - ((long) this.splElementIndex) : ((java8.util.stream.SpinedBuffer.OfPrimitive.this.priorElementCount[this.lastSpineIndex] + ((long) this.lastSpineElementFence)) - java8.util.stream.SpinedBuffer.OfPrimitive.this.priorElementCount[this.splSpineIndex]) - ((long) this.splElementIndex);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS t_cons) {
                java8.util.Objects.requireNonNull(t_cons);
                int i = this.splSpineIndex;
                int i2 = this.lastSpineIndex;
                if (i >= i2 && (i != i2 || this.splElementIndex >= this.lastSpineElementFence)) {
                    return false;
                }
                T_ARR t_arr = this.splChunk;
                int i3 = this.splElementIndex;
                this.splElementIndex = i3 + 1;
                arrayForOne(t_arr, i3, t_cons);
                if (this.splElementIndex == java8.util.stream.SpinedBuffer.OfPrimitive.this.arrayLength(this.splChunk)) {
                    this.splElementIndex = 0;
                    this.splSpineIndex++;
                    if (java8.util.stream.SpinedBuffer.OfPrimitive.this.spine != null && this.splSpineIndex <= this.lastSpineIndex) {
                        this.splChunk = java8.util.stream.SpinedBuffer.OfPrimitive.this.spine[this.splSpineIndex];
                    }
                }
                return true;
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS t_cons) {
                int i;
                java8.util.Objects.requireNonNull(t_cons);
                int i2 = this.splSpineIndex;
                int i3 = this.lastSpineIndex;
                if (i2 < i3 || (i2 == i3 && this.splElementIndex < this.lastSpineElementFence)) {
                    int i4 = this.splElementIndex;
                    while (true) {
                        i = this.lastSpineIndex;
                        if (i2 >= i) {
                            break;
                        }
                        T_ARR t_arr = java8.util.stream.SpinedBuffer.OfPrimitive.this.spine[i2];
                        java8.util.stream.SpinedBuffer.OfPrimitive ofPrimitive = java8.util.stream.SpinedBuffer.OfPrimitive.this;
                        ofPrimitive.arrayForEach(t_arr, i4, ofPrimitive.arrayLength(t_arr), t_cons);
                        i2++;
                        i4 = 0;
                    }
                    java8.util.stream.SpinedBuffer.OfPrimitive.this.arrayForEach(this.splSpineIndex == i ? this.splChunk : java8.util.stream.SpinedBuffer.OfPrimitive.this.spine[this.lastSpineIndex], i4, this.lastSpineElementFence, t_cons);
                    this.splSpineIndex = this.lastSpineIndex;
                    this.splElementIndex = this.lastSpineElementFence;
                }
            }

            @Override // java8.util.Spliterator
            public T_SPLITR trySplit() {
                int i = this.splSpineIndex;
                int i2 = this.lastSpineIndex;
                if (i < i2) {
                    int i3 = this.splElementIndex;
                    java8.util.stream.SpinedBuffer.OfPrimitive ofPrimitive = java8.util.stream.SpinedBuffer.OfPrimitive.this;
                    T_SPLITR t_splitr = (T_SPLITR) newSpliterator(i, i2 - 1, i3, ofPrimitive.arrayLength(ofPrimitive.spine[this.lastSpineIndex - 1]));
                    this.splSpineIndex = this.lastSpineIndex;
                    this.splElementIndex = 0;
                    this.splChunk = java8.util.stream.SpinedBuffer.OfPrimitive.this.spine[this.splSpineIndex];
                    return t_splitr;
                }
                if (i != i2) {
                    return null;
                }
                int i4 = this.lastSpineElementFence;
                int i5 = this.splElementIndex;
                int i6 = (i4 - i5) / 2;
                if (i6 == 0) {
                    return null;
                }
                T_SPLITR t_splitr2 = (T_SPLITR) arraySpliterator(this.splChunk, i5, i6);
                this.splElementIndex += i6;
                return t_splitr2;
            }
        }
    }

    static class OfInt extends java8.util.stream.SpinedBuffer.OfPrimitive<java.lang.Integer, int[], java8.util.function.IntConsumer> implements java8.util.function.IntConsumer {
        OfInt() {
        }

        OfInt(int i) {
            super(i);
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public void forEach(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            if (consumer instanceof java8.util.function.IntConsumer) {
                forEach((java8.util.function.IntConsumer) consumer);
            } else {
                spliterator().forEachRemaining((java8.util.function.Consumer) consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public int[][] newArrayArray(int i) {
            return new int[i][];
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public int[] newArray(int i) {
            return new int[i];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(int[] iArr) {
            return iArr.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(int[] iArr, int i, int i2, java8.util.function.IntConsumer intConsumer) {
            while (i < i2) {
                intConsumer.accept(iArr[i]);
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(int i) {
            preAccept();
            int[] iArr = (int[]) this.curChunk;
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            iArr[i2] = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int get(long j) {
            int iChunkFor = chunkFor(j);
            if (this.spineIndex == 0 && iChunkFor == 0) {
                return ((int[]) this.curChunk)[(int) j];
            }
            return ((int[][]) this.spine)[iChunkFor][(int) (j - this.priorElementCount[iChunkFor])];
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public java.util.Iterator<java.lang.Integer> iterator() {
            return java8.util.Spliterators.iterator(spliterator());
        }

        /* JADX INFO: renamed from: java8.util.stream.SpinedBuffer$OfInt$1Splitr, reason: invalid class name */
        class C1Splitr extends java8.util.stream.SpinedBuffer.OfPrimitive<java.lang.Integer, int[], java8.util.function.IntConsumer>.BaseSpliterator<java8.util.Spliterator.OfInt> implements java8.util.Spliterator.OfInt {
            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                super.forEachRemaining(intConsumer);
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                return super.tryAdvance(intConsumer);
            }

            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            C1Splitr(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public java8.util.stream.SpinedBuffer.OfInt.C1Splitr newSpliterator(int i, int i2, int i3, int i4) {
                return java8.util.stream.SpinedBuffer.OfInt.this.new C1Splitr(i, i2, i3, i4);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(int[] iArr, int i, java8.util.function.IntConsumer intConsumer) {
                intConsumer.accept(iArr[i]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public java8.util.Spliterator.OfInt arraySpliterator(int[] iArr, int i, int i2) {
                return java8.util.J8Arrays.spliterator(iArr, i, i2 + i);
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
            public java.util.Comparator<? super java.lang.Integer> getComparator() {
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                return java8.util.Spliterators.OfInt.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.Spliterators.OfInt.forEachRemaining(this, consumer);
            }
        }

        public java8.util.Spliterator.OfInt spliterator() {
            return new java8.util.stream.SpinedBuffer.OfInt.C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public java.lang.String toString() {
            int[] iArrAsPrimitiveArray = asPrimitiveArray();
            if (iArrAsPrimitiveArray.length < 200) {
                return java.lang.String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), java.lang.Integer.valueOf(iArrAsPrimitiveArray.length), java.lang.Integer.valueOf(this.spineIndex), java.util.Arrays.toString(iArrAsPrimitiveArray));
            }
            return java.lang.String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), java.lang.Integer.valueOf(iArrAsPrimitiveArray.length), java.lang.Integer.valueOf(this.spineIndex), java.util.Arrays.toString(java.util.Arrays.copyOf(iArrAsPrimitiveArray, 200)));
        }
    }

    static class OfLong extends java8.util.stream.SpinedBuffer.OfPrimitive<java.lang.Long, long[], java8.util.function.LongConsumer> implements java8.util.function.LongConsumer {
        OfLong() {
        }

        OfLong(int i) {
            super(i);
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public void forEach(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            if (consumer instanceof java8.util.function.LongConsumer) {
                forEach((java8.util.function.LongConsumer) consumer);
            } else {
                spliterator().forEachRemaining((java8.util.function.Consumer) consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public long[][] newArrayArray(int i) {
            return new long[i][];
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public long[] newArray(int i) {
            return new long[i];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(long[] jArr) {
            return jArr.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(long[] jArr, int i, int i2, java8.util.function.LongConsumer longConsumer) {
            while (i < i2) {
                longConsumer.accept(jArr[i]);
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(long j) {
            preAccept();
            long[] jArr = (long[]) this.curChunk;
            int i = this.elementIndex;
            this.elementIndex = i + 1;
            jArr[i] = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public long get(long j) {
            int iChunkFor = chunkFor(j);
            if (this.spineIndex == 0 && iChunkFor == 0) {
                return ((long[]) this.curChunk)[(int) j];
            }
            return ((long[][]) this.spine)[iChunkFor][(int) (j - this.priorElementCount[iChunkFor])];
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public java.util.Iterator<java.lang.Long> iterator() {
            return java8.util.Spliterators.iterator(spliterator());
        }

        /* JADX INFO: renamed from: java8.util.stream.SpinedBuffer$OfLong$1Splitr, reason: invalid class name */
        class C1Splitr extends java8.util.stream.SpinedBuffer.OfPrimitive<java.lang.Long, long[], java8.util.function.LongConsumer>.BaseSpliterator<java8.util.Spliterator.OfLong> implements java8.util.Spliterator.OfLong {
            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                super.forEachRemaining(longConsumer);
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                return super.tryAdvance(longConsumer);
            }

            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            C1Splitr(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public java8.util.stream.SpinedBuffer.OfLong.C1Splitr newSpliterator(int i, int i2, int i3, int i4) {
                return java8.util.stream.SpinedBuffer.OfLong.this.new C1Splitr(i, i2, i3, i4);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(long[] jArr, int i, java8.util.function.LongConsumer longConsumer) {
                longConsumer.accept(jArr[i]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public java8.util.Spliterator.OfLong arraySpliterator(long[] jArr, int i, int i2) {
                return java8.util.J8Arrays.spliterator(jArr, i, i2 + i);
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
            public java.util.Comparator<? super java.lang.Long> getComparator() {
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                return java8.util.Spliterators.OfLong.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.Spliterators.OfLong.forEachRemaining(this, consumer);
            }
        }

        public java8.util.Spliterator.OfLong spliterator() {
            return new java8.util.stream.SpinedBuffer.OfLong.C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public java.lang.String toString() {
            long[] jArrAsPrimitiveArray = asPrimitiveArray();
            if (jArrAsPrimitiveArray.length < 200) {
                return java.lang.String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), java.lang.Integer.valueOf(jArrAsPrimitiveArray.length), java.lang.Integer.valueOf(this.spineIndex), java.util.Arrays.toString(jArrAsPrimitiveArray));
            }
            return java.lang.String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), java.lang.Integer.valueOf(jArrAsPrimitiveArray.length), java.lang.Integer.valueOf(this.spineIndex), java.util.Arrays.toString(java.util.Arrays.copyOf(jArrAsPrimitiveArray, 200)));
        }
    }

    static class OfDouble extends java8.util.stream.SpinedBuffer.OfPrimitive<java.lang.Double, double[], java8.util.function.DoubleConsumer> implements java8.util.function.DoubleConsumer {
        OfDouble() {
        }

        OfDouble(int i) {
            super(i);
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public void forEach(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            if (consumer instanceof java8.util.function.DoubleConsumer) {
                forEach((java8.util.function.DoubleConsumer) consumer);
            } else {
                spliterator().forEachRemaining((java8.util.function.Consumer) consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public double[][] newArrayArray(int i) {
            return new double[i][];
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public double[] newArray(int i) {
            return new double[i];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public int arrayLength(double[] dArr) {
            return dArr.length;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public void arrayForEach(double[] dArr, int i, int i2, java8.util.function.DoubleConsumer doubleConsumer) {
            while (i < i2) {
                doubleConsumer.accept(dArr[i]);
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(double d) {
            preAccept();
            double[] dArr = (double[]) this.curChunk;
            int i = this.elementIndex;
            this.elementIndex = i + 1;
            dArr[i] = d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public double get(long j) {
            int iChunkFor = chunkFor(j);
            if (this.spineIndex == 0 && iChunkFor == 0) {
                return ((double[]) this.curChunk)[(int) j];
            }
            return ((double[][]) this.spine)[iChunkFor][(int) (j - this.priorElementCount[iChunkFor])];
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive
        public java.util.Iterator<java.lang.Double> iterator() {
            return java8.util.Spliterators.iterator(spliterator());
        }

        /* JADX INFO: renamed from: java8.util.stream.SpinedBuffer$OfDouble$1Splitr, reason: invalid class name */
        class C1Splitr extends java8.util.stream.SpinedBuffer.OfPrimitive<java.lang.Double, double[], java8.util.function.DoubleConsumer>.BaseSpliterator<java8.util.Spliterator.OfDouble> implements java8.util.Spliterator.OfDouble {
            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                super.forEachRemaining(doubleConsumer);
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                return super.tryAdvance(doubleConsumer);
            }

            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator, java8.util.Spliterator.OfPrimitive, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            C1Splitr(int i, int i2, int i3, int i4) {
                super(i, i2, i3, i4);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public java8.util.stream.SpinedBuffer.OfDouble.C1Splitr newSpliterator(int i, int i2, int i3, int i4) {
                return java8.util.stream.SpinedBuffer.OfDouble.this.new C1Splitr(i, i2, i3, i4);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public void arrayForOne(double[] dArr, int i, java8.util.function.DoubleConsumer doubleConsumer) {
                doubleConsumer.accept(dArr[i]);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.SpinedBuffer.OfPrimitive.BaseSpliterator
            public java8.util.Spliterator.OfDouble arraySpliterator(double[] dArr, int i, int i2) {
                return java8.util.J8Arrays.spliterator(dArr, i, i2 + i);
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
            public java.util.Comparator<? super java.lang.Double> getComparator() {
                return java8.util.Spliterators.getComparator(this);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                return java8.util.Spliterators.OfDouble.tryAdvance(this, consumer);
            }

            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.Spliterators.OfDouble.forEachRemaining(this, consumer);
            }
        }

        public java8.util.Spliterator.OfDouble spliterator() {
            return new java8.util.stream.SpinedBuffer.OfDouble.C1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public java.lang.String toString() {
            double[] dArrAsPrimitiveArray = asPrimitiveArray();
            if (dArrAsPrimitiveArray.length < 200) {
                return java.lang.String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), java.lang.Integer.valueOf(dArrAsPrimitiveArray.length), java.lang.Integer.valueOf(this.spineIndex), java.util.Arrays.toString(dArrAsPrimitiveArray));
            }
            return java.lang.String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), java.lang.Integer.valueOf(dArrAsPrimitiveArray.length), java.lang.Integer.valueOf(this.spineIndex), java.util.Arrays.toString(java.util.Arrays.copyOf(dArrAsPrimitiveArray, 200)));
        }
    }
}
