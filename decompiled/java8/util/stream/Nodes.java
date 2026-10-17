package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class Nodes {
    static final java.lang.String BAD_SIZE = "Stream size exceeds max array size";
    static final long MAX_ARRAY_SIZE = 2147483639;
    private static final java8.util.stream.Node EMPTY_NODE = new java8.util.stream.Nodes.EmptyNode.OfRef(null);
    private static final java8.util.stream.Node.OfInt EMPTY_INT_NODE = new java8.util.stream.Nodes.EmptyNode.OfInt();
    private static final java8.util.stream.Node.OfLong EMPTY_LONG_NODE = new java8.util.stream.Nodes.EmptyNode.OfLong();
    private static final java8.util.stream.Node.OfDouble EMPTY_DOUBLE_NODE = new java8.util.stream.Nodes.EmptyNode.OfDouble();
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    static <T> int getChildCount() {
        return 0;
    }

    static /* synthetic */ void lambda$truncate$104(java.lang.Object obj) {
    }

    private Nodes() {
        throw new java.lang.Error("no instances");
    }

    static <T> java8.util.stream.StreamShape getShape() {
        return java8.util.stream.StreamShape.REFERENCE;
    }

    static <T> java8.util.stream.Node<T> getChild() {
        throw new java.lang.IndexOutOfBoundsException();
    }

    static <T> java8.util.stream.Node<T> truncate(java8.util.stream.Node<T> node, long j, long j2, java8.util.function.IntFunction<T[]> intFunction) {
        if (j == 0 && j2 == node.count()) {
            return node;
        }
        java8.util.Spliterator<T> spliterator = node.spliterator();
        long j3 = j2 - j;
        java8.util.stream.Node.Builder builder = builder(j3, intFunction);
        builder.begin(j3);
        for (int i = 0; i < j && spliterator.tryAdvance(java8.util.stream.Nodes$$Lambda$1.instance); i++) {
        }
        if (j2 == node.count()) {
            spliterator.forEachRemaining(builder);
        } else {
            for (int i2 = 0; i2 < j3 && spliterator.tryAdvance(builder); i2++) {
            }
        }
        builder.end();
        return builder.build2();
    }

    static final class OfPrimitive {
        static <T, T_CONS, T_ARR, T_NODE extends java8.util.stream.Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> T_NODE getChild() {
            throw new java.lang.IndexOutOfBoundsException();
        }

        static <T, T_CONS, T_ARR, T_NODE extends java8.util.stream.Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> T[] asArray(java8.util.stream.Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE> ofPrimitive, java8.util.function.IntFunction<T[]> intFunction) {
            if (ofPrimitive.count() >= java8.util.stream.Nodes.MAX_ARRAY_SIZE) {
                throw new java.lang.IllegalArgumentException(java8.util.stream.Nodes.BAD_SIZE);
            }
            T[] tArrApply = intFunction.apply((int) ofPrimitive.count());
            ofPrimitive.copyInto((java.lang.Object[]) tArrApply, 0);
            return tArrApply;
        }

        private OfPrimitive() {
        }
    }

    static final class OfDouble {
        static /* synthetic */ void lambda$truncate$105(double d) {
        }

        /* JADX WARN: Type inference failed for: r7v6, types: [java8.util.stream.Node$OfDouble] */
        static java8.util.stream.Node.OfDouble truncate(java8.util.stream.Node.OfDouble ofDouble, long j, long j2, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
            if (j == 0 && j2 == ofDouble.count()) {
                return ofDouble;
            }
            long j3 = j2 - j;
            java8.util.Spliterator.OfDouble ofDoubleSpliterator = ofDouble.spliterator();
            java8.util.stream.Node.Builder.OfDouble ofDoubleDoubleBuilder = java8.util.stream.Nodes.doubleBuilder(j3);
            ofDoubleDoubleBuilder.begin(j3);
            for (int i = 0; i < j && ofDoubleSpliterator.tryAdvance(java8.util.stream.Nodes$OfDouble$$Lambda$1.instance); i++) {
            }
            if (j2 == ofDouble.count()) {
                ofDoubleSpliterator.forEachRemaining((java8.util.function.DoubleConsumer) ofDoubleDoubleBuilder);
            } else {
                for (int i2 = 0; i2 < j3 && ofDoubleSpliterator.tryAdvance((java8.util.function.DoubleConsumer) ofDoubleDoubleBuilder); i2++) {
                }
            }
            ofDoubleDoubleBuilder.end();
            return ofDoubleDoubleBuilder.build2();
        }

        static void forEach(java8.util.stream.Node.OfDouble ofDouble, java8.util.function.Consumer<? super java.lang.Double> consumer) {
            if (consumer instanceof java8.util.function.DoubleConsumer) {
                ofDouble.forEach((java8.util.function.DoubleConsumer) consumer);
            } else {
                ofDouble.spliterator().forEachRemaining(consumer);
            }
        }

        static void copyInto(java8.util.stream.Node.OfDouble ofDouble, java.lang.Double[] dArr, int i) {
            double[] dArrAsPrimitiveArray = ofDouble.asPrimitiveArray();
            for (int i2 = 0; i2 < dArrAsPrimitiveArray.length; i2++) {
                dArr[i + i2] = java.lang.Double.valueOf(dArrAsPrimitiveArray[i2]);
            }
        }

        static double[] newArray(java8.util.stream.Node.OfDouble ofDouble, int i) {
            return new double[i];
        }

        static java8.util.stream.StreamShape getShape() {
            return java8.util.stream.StreamShape.DOUBLE_VALUE;
        }

        private OfDouble() {
        }
    }

    static final class OfLong {
        static /* synthetic */ void lambda$truncate$106(long j) {
        }

        /* JADX WARN: Type inference failed for: r7v6, types: [java8.util.stream.Node$OfLong] */
        static java8.util.stream.Node.OfLong truncate(java8.util.stream.Node.OfLong ofLong, long j, long j2, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
            if (j == 0 && j2 == ofLong.count()) {
                return ofLong;
            }
            long j3 = j2 - j;
            java8.util.Spliterator.OfLong ofLongSpliterator = ofLong.spliterator();
            java8.util.stream.Node.Builder.OfLong ofLongLongBuilder = java8.util.stream.Nodes.longBuilder(j3);
            ofLongLongBuilder.begin(j3);
            for (int i = 0; i < j && ofLongSpliterator.tryAdvance(java8.util.stream.Nodes$OfLong$$Lambda$1.instance); i++) {
            }
            if (j2 == ofLong.count()) {
                ofLongSpliterator.forEachRemaining((java8.util.function.LongConsumer) ofLongLongBuilder);
            } else {
                for (int i2 = 0; i2 < j3 && ofLongSpliterator.tryAdvance((java8.util.function.LongConsumer) ofLongLongBuilder); i2++) {
                }
            }
            ofLongLongBuilder.end();
            return ofLongLongBuilder.build2();
        }

        static void forEach(java8.util.stream.Node.OfLong ofLong, java8.util.function.Consumer<? super java.lang.Long> consumer) {
            if (consumer instanceof java8.util.function.LongConsumer) {
                ofLong.forEach((java8.util.function.LongConsumer) consumer);
            } else {
                ofLong.spliterator().forEachRemaining(consumer);
            }
        }

        static void copyInto(java8.util.stream.Node.OfLong ofLong, java.lang.Long[] lArr, int i) {
            long[] jArrAsPrimitiveArray = ofLong.asPrimitiveArray();
            for (int i2 = 0; i2 < jArrAsPrimitiveArray.length; i2++) {
                lArr[i + i2] = java.lang.Long.valueOf(jArrAsPrimitiveArray[i2]);
            }
        }

        static long[] newArray(java8.util.stream.Node.OfLong ofLong, int i) {
            return new long[i];
        }

        static java8.util.stream.StreamShape getShape() {
            return java8.util.stream.StreamShape.LONG_VALUE;
        }

        private OfLong() {
        }
    }

    static final class OfInt {
        static /* synthetic */ void lambda$truncate$107(int i) {
        }

        /* JADX WARN: Type inference failed for: r7v6, types: [java8.util.stream.Node$OfInt] */
        static java8.util.stream.Node.OfInt truncate(java8.util.stream.Node.OfInt ofInt, long j, long j2, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
            if (j == 0 && j2 == ofInt.count()) {
                return ofInt;
            }
            long j3 = j2 - j;
            java8.util.Spliterator.OfInt ofIntSpliterator = ofInt.spliterator();
            java8.util.stream.Node.Builder.OfInt ofIntIntBuilder = java8.util.stream.Nodes.intBuilder(j3);
            ofIntIntBuilder.begin(j3);
            for (int i = 0; i < j && ofIntSpliterator.tryAdvance(java8.util.stream.Nodes$OfInt$$Lambda$1.instance); i++) {
            }
            if (j2 == ofInt.count()) {
                ofIntSpliterator.forEachRemaining((java8.util.function.IntConsumer) ofIntIntBuilder);
            } else {
                for (int i2 = 0; i2 < j3 && ofIntSpliterator.tryAdvance((java8.util.function.IntConsumer) ofIntIntBuilder); i2++) {
                }
            }
            ofIntIntBuilder.end();
            return ofIntIntBuilder.build2();
        }

        static void forEach(java8.util.stream.Node.OfInt ofInt, java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            if (consumer instanceof java8.util.function.IntConsumer) {
                ofInt.forEach((java8.util.function.IntConsumer) consumer);
            } else {
                ofInt.spliterator().forEachRemaining(consumer);
            }
        }

        static void copyInto(java8.util.stream.Node.OfInt ofInt, java.lang.Integer[] numArr, int i) {
            int[] iArrAsPrimitiveArray = ofInt.asPrimitiveArray();
            for (int i2 = 0; i2 < iArrAsPrimitiveArray.length; i2++) {
                numArr[i + i2] = java.lang.Integer.valueOf(iArrAsPrimitiveArray[i2]);
            }
        }

        static int[] newArray(java8.util.stream.Node.OfInt ofInt, int i) {
            return new int[i];
        }

        static java8.util.stream.StreamShape getShape() {
            return java8.util.stream.StreamShape.INT_VALUE;
        }

        private OfInt() {
        }
    }

    static <T> java8.util.function.IntFunction<T[]> castingArray() {
        return java8.util.stream.Nodes$$Lambda$2.instance;
    }

    static /* synthetic */ java.lang.Object[] lambda$castingArray$108(int i) {
        return new java.lang.Object[i];
    }

    /* JADX INFO: renamed from: java8.util.stream.Nodes$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java8$util$stream$StreamShape;

        static {
            int[] iArr = new int[java8.util.stream.StreamShape.values().length];
            $SwitchMap$java8$util$stream$StreamShape = iArr;
            try {
                iArr[java8.util.stream.StreamShape.REFERENCE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java8$util$stream$StreamShape[java8.util.stream.StreamShape.INT_VALUE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java8$util$stream$StreamShape[java8.util.stream.StreamShape.LONG_VALUE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java8$util$stream$StreamShape[java8.util.stream.StreamShape.DOUBLE_VALUE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    static <T> java8.util.stream.Node<T> emptyNode(java8.util.stream.StreamShape streamShape) {
        int i = java8.util.stream.Nodes.AnonymousClass1.$SwitchMap$java8$util$stream$StreamShape[streamShape.ordinal()];
        if (i == 1) {
            return EMPTY_NODE;
        }
        if (i == 2) {
            return EMPTY_INT_NODE;
        }
        if (i == 3) {
            return EMPTY_LONG_NODE;
        }
        if (i == 4) {
            return EMPTY_DOUBLE_NODE;
        }
        throw new java.lang.IllegalStateException("Unknown shape " + streamShape);
    }

    static <T> java8.util.stream.Node<T> conc(java8.util.stream.StreamShape streamShape, java8.util.stream.Node<T> node, java8.util.stream.Node<T> node2) {
        int i = java8.util.stream.Nodes.AnonymousClass1.$SwitchMap$java8$util$stream$StreamShape[streamShape.ordinal()];
        if (i == 1) {
            return new java8.util.stream.Nodes.ConcNode(node, node2);
        }
        if (i == 2) {
            return new java8.util.stream.Nodes.ConcNode.OfInt((java8.util.stream.Node.OfInt) node, (java8.util.stream.Node.OfInt) node2);
        }
        if (i == 3) {
            return new java8.util.stream.Nodes.ConcNode.OfLong((java8.util.stream.Node.OfLong) node, (java8.util.stream.Node.OfLong) node2);
        }
        if (i == 4) {
            return new java8.util.stream.Nodes.ConcNode.OfDouble((java8.util.stream.Node.OfDouble) node, (java8.util.stream.Node.OfDouble) node2);
        }
        throw new java.lang.IllegalStateException("Unknown shape " + streamShape);
    }

    static <T> java8.util.stream.Node<T> node(T[] tArr) {
        return new java8.util.stream.Nodes.ArrayNode(tArr);
    }

    static <T> java8.util.stream.Node<T> node(java.util.Collection<T> collection) {
        return new java8.util.stream.Nodes.CollectionNode(collection);
    }

    static <T> java8.util.stream.Node.Builder<T> builder(long j, java8.util.function.IntFunction<T[]> intFunction) {
        if (j >= 0 && j < MAX_ARRAY_SIZE) {
            return new java8.util.stream.Nodes.FixedNodeBuilder(j, intFunction);
        }
        return builder();
    }

    static <T> java8.util.stream.Node.Builder<T> builder() {
        return new java8.util.stream.Nodes.SpinedNodeBuilder();
    }

    static java8.util.stream.Node.OfInt node(int[] iArr) {
        return new java8.util.stream.Nodes.IntArrayNode(iArr);
    }

    static java8.util.stream.Node.Builder.OfInt intBuilder(long j) {
        if (j >= 0 && j < MAX_ARRAY_SIZE) {
            return new java8.util.stream.Nodes.IntFixedNodeBuilder(j);
        }
        return intBuilder();
    }

    static java8.util.stream.Node.Builder.OfInt intBuilder() {
        return new java8.util.stream.Nodes.IntSpinedNodeBuilder();
    }

    static java8.util.stream.Node.OfLong node(long[] jArr) {
        return new java8.util.stream.Nodes.LongArrayNode(jArr);
    }

    static java8.util.stream.Node.Builder.OfLong longBuilder(long j) {
        if (j >= 0 && j < MAX_ARRAY_SIZE) {
            return new java8.util.stream.Nodes.LongFixedNodeBuilder(j);
        }
        return longBuilder();
    }

    static java8.util.stream.Node.Builder.OfLong longBuilder() {
        return new java8.util.stream.Nodes.LongSpinedNodeBuilder();
    }

    static java8.util.stream.Node.OfDouble node(double[] dArr) {
        return new java8.util.stream.Nodes.DoubleArrayNode(dArr);
    }

    static java8.util.stream.Node.Builder.OfDouble doubleBuilder(long j) {
        if (j >= 0 && j < MAX_ARRAY_SIZE) {
            return new java8.util.stream.Nodes.DoubleFixedNodeBuilder(j);
        }
        return doubleBuilder();
    }

    static java8.util.stream.Node.Builder.OfDouble doubleBuilder() {
        return new java8.util.stream.Nodes.DoubleSpinedNodeBuilder();
    }

    public static <P_IN, P_OUT> java8.util.stream.Node<P_OUT> collect(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z, java8.util.function.IntFunction<P_OUT[]> intFunction) {
        long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (jExactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            java8.util.stream.Node<P_OUT> node = (java8.util.stream.Node) new java8.util.stream.Nodes.CollectorTask.OfRef(pipelineHelper, intFunction, spliterator).invoke();
            return z ? flatten(node, intFunction) : node;
        }
        if (jExactOutputSizeIfKnown >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        P_OUT[] p_outArrApply = intFunction.apply((int) jExactOutputSizeIfKnown);
        new java8.util.stream.Nodes.SizedCollectorTask.OfRef(spliterator, pipelineHelper, p_outArrApply).invoke();
        return node(p_outArrApply);
    }

    public static <P_IN> java8.util.stream.Node.OfInt collectInt(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
        long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (jExactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            java8.util.stream.Node.OfInt ofInt = (java8.util.stream.Node.OfInt) new java8.util.stream.Nodes.CollectorTask.OfInt(pipelineHelper, spliterator).invoke();
            return z ? flattenInt(ofInt) : ofInt;
        }
        if (jExactOutputSizeIfKnown >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        int[] iArr = new int[(int) jExactOutputSizeIfKnown];
        new java8.util.stream.Nodes.SizedCollectorTask.OfInt(spliterator, pipelineHelper, iArr).invoke();
        return node(iArr);
    }

    public static <P_IN> java8.util.stream.Node.OfLong collectLong(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
        long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (jExactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            java8.util.stream.Node.OfLong ofLong = (java8.util.stream.Node.OfLong) new java8.util.stream.Nodes.CollectorTask.OfLong(pipelineHelper, spliterator).invoke();
            return z ? flattenLong(ofLong) : ofLong;
        }
        if (jExactOutputSizeIfKnown >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        long[] jArr = new long[(int) jExactOutputSizeIfKnown];
        new java8.util.stream.Nodes.SizedCollectorTask.OfLong(spliterator, pipelineHelper, jArr).invoke();
        return node(jArr);
    }

    public static <P_IN> java8.util.stream.Node.OfDouble collectDouble(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, boolean z) {
        long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
        if (jExactOutputSizeIfKnown < 0 || !spliterator.hasCharacteristics(16384)) {
            java8.util.stream.Node.OfDouble ofDouble = (java8.util.stream.Node.OfDouble) new java8.util.stream.Nodes.CollectorTask.OfDouble(pipelineHelper, spliterator).invoke();
            return z ? flattenDouble(ofDouble) : ofDouble;
        }
        if (jExactOutputSizeIfKnown >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        double[] dArr = new double[(int) jExactOutputSizeIfKnown];
        new java8.util.stream.Nodes.SizedCollectorTask.OfDouble(spliterator, pipelineHelper, dArr).invoke();
        return node(dArr);
    }

    public static <T> java8.util.stream.Node<T> flatten(java8.util.stream.Node<T> node, java8.util.function.IntFunction<T[]> intFunction) {
        if (node.getChildCount() <= 0) {
            return node;
        }
        long jCount = node.count();
        if (jCount >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        T[] tArrApply = intFunction.apply((int) jCount);
        new java8.util.stream.Nodes.ToArrayTask.OfRef(node, tArrApply, 0, null).invoke();
        return node(tArrApply);
    }

    public static java8.util.stream.Node.OfInt flattenInt(java8.util.stream.Node.OfInt ofInt) {
        if (ofInt.getChildCount() <= 0) {
            return ofInt;
        }
        long jCount = ofInt.count();
        if (jCount >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        int[] iArr = new int[(int) jCount];
        new java8.util.stream.Nodes.ToArrayTask.OfInt(ofInt, iArr, 0, null).invoke();
        return node(iArr);
    }

    public static java8.util.stream.Node.OfLong flattenLong(java8.util.stream.Node.OfLong ofLong) {
        if (ofLong.getChildCount() <= 0) {
            return ofLong;
        }
        long jCount = ofLong.count();
        if (jCount >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        long[] jArr = new long[(int) jCount];
        new java8.util.stream.Nodes.ToArrayTask.OfLong(ofLong, jArr, 0, null).invoke();
        return node(jArr);
    }

    public static java8.util.stream.Node.OfDouble flattenDouble(java8.util.stream.Node.OfDouble ofDouble) {
        if (ofDouble.getChildCount() <= 0) {
            return ofDouble;
        }
        long jCount = ofDouble.count();
        if (jCount >= MAX_ARRAY_SIZE) {
            throw new java.lang.IllegalArgumentException(BAD_SIZE);
        }
        double[] dArr = new double[(int) jCount];
        new java8.util.stream.Nodes.ToArrayTask.OfDouble(ofDouble, dArr, 0, null).invoke();
        return node(dArr);
    }

    private static abstract class EmptyNode<T, T_ARR, T_CONS> implements java8.util.stream.Node<T> {
        public void copyInto(T_ARR t_arr, int i) {
        }

        @Override // java8.util.stream.Node
        public long count() {
            return 0L;
        }

        public void forEach(T_CONS t_cons) {
        }

        EmptyNode() {
        }

        @Override // java8.util.stream.Node
        public T[] asArray(java8.util.function.IntFunction<T[]> intFunction) {
            return intFunction.apply(0);
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.getShape();
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> getChild(int i) {
            return java8.util.stream.Nodes.getChild();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> truncate(long j, long j2, java8.util.function.IntFunction<T[]> intFunction) {
            return java8.util.stream.Nodes.truncate(this, j, j2, intFunction);
        }

        private static class OfRef<T> extends java8.util.stream.Nodes.EmptyNode<T, T[], java8.util.function.Consumer<? super T>> {
            /* synthetic */ OfRef(java8.util.stream.Nodes.AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ void copyInto(java.lang.Object[] objArr, int i) {
                super.copyInto(objArr, i);
            }

            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ void forEach(java8.util.function.Consumer consumer) {
                super.forEach(consumer);
            }

            private OfRef() {
            }

            @Override // java8.util.stream.Node
            public java8.util.Spliterator<T> spliterator() {
                return java8.util.Spliterators.emptySpliterator();
            }
        }

        private static final class OfInt extends java8.util.stream.Nodes.EmptyNode<java.lang.Integer, int[], java8.util.function.IntConsumer> implements java8.util.stream.Node.OfInt {
            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
            }

            OfInt() {
            }

            @Override // java8.util.stream.Node
            public void forEach(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.stream.Nodes.OfInt.forEach(this, consumer);
            }

            @Override // java8.util.stream.Node
            public java8.util.Spliterator.OfInt spliterator() {
                return java8.util.Spliterators.emptyIntSpliterator();
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public java8.util.stream.Node.OfInt getChild(int i) {
                return (java8.util.stream.Node.OfInt) java8.util.stream.Nodes.OfPrimitive.getChild();
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public java8.util.stream.Node.OfInt truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
                return java8.util.stream.Nodes.OfInt.truncate(this, j, j2, intFunction);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public int[] asPrimitiveArray() {
                return java8.util.stream.Nodes.EMPTY_INT_ARRAY;
            }

            @Override // java8.util.stream.Node
            public void copyInto(java.lang.Integer[] numArr, int i) {
                java8.util.stream.Nodes.OfInt.copyInto(this, numArr, i);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public int[] newArray(int i) {
                return java8.util.stream.Nodes.OfInt.newArray(this, i);
            }
        }

        private static final class OfLong extends java8.util.stream.Nodes.EmptyNode<java.lang.Long, long[], java8.util.function.LongConsumer> implements java8.util.stream.Node.OfLong {
            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
            }

            OfLong() {
            }

            @Override // java8.util.stream.Node
            public void forEach(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.stream.Nodes.OfLong.forEach(this, consumer);
            }

            @Override // java8.util.stream.Node
            public java8.util.Spliterator.OfLong spliterator() {
                return java8.util.Spliterators.emptyLongSpliterator();
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public java8.util.stream.Node.OfLong getChild(int i) {
                return (java8.util.stream.Node.OfLong) java8.util.stream.Nodes.OfPrimitive.getChild();
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public java8.util.stream.Node.OfLong truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
                return java8.util.stream.Nodes.OfLong.truncate(this, j, j2, intFunction);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public long[] asPrimitiveArray() {
                return java8.util.stream.Nodes.EMPTY_LONG_ARRAY;
            }

            @Override // java8.util.stream.Node
            public void copyInto(java.lang.Long[] lArr, int i) {
                java8.util.stream.Nodes.OfLong.copyInto(this, lArr, i);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public long[] newArray(int i) {
                return java8.util.stream.Nodes.OfLong.newArray(this, i);
            }
        }

        private static final class OfDouble extends java8.util.stream.Nodes.EmptyNode<java.lang.Double, double[], java8.util.function.DoubleConsumer> implements java8.util.stream.Node.OfDouble {
            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
            }

            OfDouble() {
            }

            @Override // java8.util.stream.Node
            public void forEach(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.stream.Nodes.OfDouble.forEach(this, consumer);
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public java8.util.stream.Node.OfDouble getChild(int i) {
                return (java8.util.stream.Node.OfDouble) java8.util.stream.Nodes.OfPrimitive.getChild();
            }

            @Override // java8.util.stream.Nodes.EmptyNode, java8.util.stream.Node
            public java8.util.stream.Node.OfDouble truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
                return java8.util.stream.Nodes.OfDouble.truncate(this, j, j2, intFunction);
            }

            @Override // java8.util.stream.Node
            public java8.util.Spliterator.OfDouble spliterator() {
                return java8.util.Spliterators.emptyDoubleSpliterator();
            }

            @Override // java8.util.stream.Node
            public void copyInto(java.lang.Double[] dArr, int i) {
                java8.util.stream.Nodes.OfDouble.copyInto(this, dArr, i);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public double[] asPrimitiveArray() {
                return java8.util.stream.Nodes.EMPTY_DOUBLE_ARRAY;
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public double[] newArray(int i) {
                return java8.util.stream.Nodes.OfDouble.newArray(this, i);
            }
        }
    }

    private static class ArrayNode<T> implements java8.util.stream.Node<T> {
        final T[] array;
        int curSize;

        ArrayNode(long j, java8.util.function.IntFunction<T[]> intFunction) {
            if (j >= java8.util.stream.Nodes.MAX_ARRAY_SIZE) {
                throw new java.lang.IllegalArgumentException(java8.util.stream.Nodes.BAD_SIZE);
            }
            this.array = intFunction.apply((int) j);
            this.curSize = 0;
        }

        ArrayNode(T[] tArr) {
            this.array = tArr;
            this.curSize = tArr.length;
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator<T> spliterator() {
            return java8.util.J8Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.getShape();
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> getChild(int i) {
            return java8.util.stream.Nodes.getChild();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> truncate(long j, long j2, java8.util.function.IntFunction<T[]> intFunction) {
            return java8.util.stream.Nodes.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Node
        public void copyInto(T[] tArr, int i) {
            java.lang.System.arraycopy(this.array, 0, tArr, i, this.curSize);
        }

        @Override // java8.util.stream.Node
        public T[] asArray(java8.util.function.IntFunction<T[]> intFunction) {
            T[] tArr = this.array;
            if (tArr.length == this.curSize) {
                return tArr;
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // java8.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java8.util.stream.Node
        public void forEach(java8.util.function.Consumer<? super T> consumer) {
            for (int i = 0; i < this.curSize; i++) {
                consumer.accept(this.array[i]);
            }
        }

        public java.lang.String toString() {
            return java.lang.String.format("ArrayNode[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static final class CollectionNode<T> implements java8.util.stream.Node<T> {
        private final java.util.Collection<T> c;

        CollectionNode(java.util.Collection<T> collection) {
            this.c = collection;
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator<T> spliterator() {
            return java8.util.Spliterators.spliterator(this.c);
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.getShape();
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> getChild(int i) {
            return java8.util.stream.Nodes.getChild();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> truncate(long j, long j2, java8.util.function.IntFunction<T[]> intFunction) {
            return java8.util.stream.Nodes.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Node
        public void copyInto(T[] tArr, int i) {
            java.util.Iterator<T> it = this.c.iterator();
            while (it.hasNext()) {
                tArr[i] = it.next();
                i++;
            }
        }

        @Override // java8.util.stream.Node
        public T[] asArray(java8.util.function.IntFunction<T[]> intFunction) {
            java.util.Collection<T> collection = this.c;
            return (T[]) collection.toArray(intFunction.apply(collection.size()));
        }

        @Override // java8.util.stream.Node
        public long count() {
            return this.c.size();
        }

        @Override // java8.util.stream.Node
        public void forEach(java8.util.function.Consumer<? super T> consumer) {
            java8.util.Objects.requireNonNull(consumer);
            java.util.Iterator<T> it = this.c.iterator();
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }

        public java.lang.String toString() {
            return java.lang.String.format("CollectionNode[%d][%s]", java.lang.Integer.valueOf(this.c.size()), this.c);
        }
    }

    private static abstract class AbstractConcNode<T, T_NODE extends java8.util.stream.Node<T>> implements java8.util.stream.Node<T> {
        protected final T_NODE left;
        protected final T_NODE right;
        private final long size;

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return 2;
        }

        AbstractConcNode(T_NODE t_node, T_NODE t_node2) {
            this.left = t_node;
            this.right = t_node2;
            this.size = t_node.count() + t_node2.count();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.getShape();
        }

        @Override // java8.util.stream.Node
        public T_NODE getChild(int i) {
            if (i == 0) {
                return this.left;
            }
            if (i == 1) {
                return this.right;
            }
            throw new java.lang.IndexOutOfBoundsException();
        }

        @Override // java8.util.stream.Node
        public long count() {
            return this.size;
        }
    }

    static final class ConcNode<T> extends java8.util.stream.Nodes.AbstractConcNode<T, java8.util.stream.Node<T>> implements java8.util.stream.Node<T> {
        ConcNode(java8.util.stream.Node<T> node, java8.util.stream.Node<T> node2) {
            super(node, node2);
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator<T> spliterator() {
            return new java8.util.stream.Nodes.InternalNodeSpliterator.OfRef(this);
        }

        @Override // java8.util.stream.Node
        public void copyInto(T[] tArr, int i) {
            java8.util.Objects.requireNonNull(tArr);
            this.left.copyInto(tArr, i);
            this.right.copyInto(tArr, i + ((int) this.left.count()));
        }

        @Override // java8.util.stream.Node
        public T[] asArray(java8.util.function.IntFunction<T[]> intFunction) {
            long jCount = count();
            if (jCount >= java8.util.stream.Nodes.MAX_ARRAY_SIZE) {
                throw new java.lang.IllegalArgumentException(java8.util.stream.Nodes.BAD_SIZE);
            }
            T[] tArrApply = intFunction.apply((int) jCount);
            copyInto(tArrApply, 0);
            return tArrApply;
        }

        @Override // java8.util.stream.Node
        public void forEach(java8.util.function.Consumer<? super T> consumer) {
            this.left.forEach(consumer);
            this.right.forEach(consumer);
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> truncate(long j, long j2, java8.util.function.IntFunction<T[]> intFunction) {
            if (j == 0 && j2 == count()) {
                return this;
            }
            long jCount = this.left.count();
            if (j >= jCount) {
                return this.right.truncate(j - jCount, j2 - jCount, intFunction);
            }
            if (j2 <= jCount) {
                return this.left.truncate(j, j2, intFunction);
            }
            return java8.util.stream.Nodes.conc(getShape(), this.left.truncate(j, jCount, intFunction), this.right.truncate(0L, j2 - jCount, intFunction));
        }

        public java.lang.String toString() {
            return count() < 32 ? java.lang.String.format("ConcNode[%s.%s]", this.left, this.right) : java.lang.String.format("ConcNode[size=%d]", java.lang.Long.valueOf(count()));
        }

        private static abstract class OfPrimitive<E, T_CONS, T_ARR, T_SPLITR extends java8.util.Spliterator.OfPrimitive<E, T_CONS, T_SPLITR>, T_NODE extends java8.util.stream.Node.OfPrimitive<E, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends java8.util.stream.Nodes.AbstractConcNode<E, T_NODE> implements java8.util.stream.Node.OfPrimitive<E, T_CONS, T_ARR, T_SPLITR, T_NODE> {
            @Override // java8.util.stream.Nodes.AbstractConcNode, java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive getChild(int i) {
                return (java8.util.stream.Node.OfPrimitive) super.getChild(i);
            }

            OfPrimitive(T_NODE t_node, T_NODE t_node2) {
                super(t_node, t_node2);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public void forEach(T_CONS t_cons) {
                ((java8.util.stream.Node.OfPrimitive) this.left).forEach(t_cons);
                ((java8.util.stream.Node.OfPrimitive) this.right).forEach(t_cons);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public void copyInto(T_ARR t_arr, int i) {
                ((java8.util.stream.Node.OfPrimitive) this.left).copyInto(t_arr, i);
                ((java8.util.stream.Node.OfPrimitive) this.right).copyInto(t_arr, i + ((int) ((java8.util.stream.Node.OfPrimitive) this.left).count()));
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public T_ARR asPrimitiveArray() {
                long jCount = count();
                if (jCount >= java8.util.stream.Nodes.MAX_ARRAY_SIZE) {
                    throw new java.lang.IllegalArgumentException(java8.util.stream.Nodes.BAD_SIZE);
                }
                T_ARR t_arrNewArray = newArray((int) jCount);
                copyInto(t_arrNewArray, 0);
                return t_arrNewArray;
            }

            @Override // java8.util.stream.Node
            public E[] asArray(java8.util.function.IntFunction<E[]> intFunction) {
                return (E[]) java8.util.stream.Nodes.OfPrimitive.asArray(this, intFunction);
            }

            public java.lang.String toString() {
                return count() < 32 ? java.lang.String.format("%s[%s.%s]", getClass().getName(), this.left, this.right) : java.lang.String.format("%s[size=%d]", getClass().getName(), java.lang.Long.valueOf(count()));
            }
        }

        static final class OfInt extends java8.util.stream.Nodes.ConcNode.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, int[], java8.util.Spliterator.OfInt, java8.util.stream.Node.OfInt> implements java8.util.stream.Node.OfInt {
            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
            }

            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
            }

            OfInt(java8.util.stream.Node.OfInt ofInt, java8.util.stream.Node.OfInt ofInt2) {
                super(ofInt, ofInt2);
            }

            @Override // java8.util.stream.Node
            public void forEach(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
                java8.util.stream.Nodes.OfInt.forEach(this, consumer);
            }

            @Override // java8.util.stream.Node
            public java8.util.Spliterator.OfInt spliterator() {
                return new java8.util.stream.Nodes.InternalNodeSpliterator.OfInt(this);
            }

            @Override // java8.util.stream.Node
            public java8.util.stream.Node.OfInt truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
                return java8.util.stream.Nodes.OfInt.truncate(this, j, j2, intFunction);
            }

            @Override // java8.util.stream.Node
            public void copyInto(java.lang.Integer[] numArr, int i) {
                java8.util.stream.Nodes.OfInt.copyInto(this, numArr, i);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public int[] newArray(int i) {
                return java8.util.stream.Nodes.OfInt.newArray(this, i);
            }
        }

        static final class OfLong extends java8.util.stream.Nodes.ConcNode.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, long[], java8.util.Spliterator.OfLong, java8.util.stream.Node.OfLong> implements java8.util.stream.Node.OfLong {
            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
            }

            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
            }

            OfLong(java8.util.stream.Node.OfLong ofLong, java8.util.stream.Node.OfLong ofLong2) {
                super(ofLong, ofLong2);
            }

            @Override // java8.util.stream.Node
            public void forEach(java8.util.function.Consumer<? super java.lang.Long> consumer) {
                java8.util.stream.Nodes.OfLong.forEach(this, consumer);
            }

            @Override // java8.util.stream.Node
            public java8.util.stream.Node.OfLong truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
                return java8.util.stream.Nodes.OfLong.truncate(this, j, j2, intFunction);
            }

            @Override // java8.util.stream.Node
            public java8.util.Spliterator.OfLong spliterator() {
                return new java8.util.stream.Nodes.InternalNodeSpliterator.OfLong(this);
            }

            @Override // java8.util.stream.Node
            public void copyInto(java.lang.Long[] lArr, int i) {
                java8.util.stream.Nodes.OfLong.copyInto(this, lArr, i);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public long[] newArray(int i) {
                return java8.util.stream.Nodes.OfLong.newArray(this, i);
            }
        }

        static final class OfDouble extends java8.util.stream.Nodes.ConcNode.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, double[], java8.util.Spliterator.OfDouble, java8.util.stream.Node.OfDouble> implements java8.util.stream.Node.OfDouble {
            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
            }

            @Override // java8.util.stream.Node
            public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
                return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
            }

            OfDouble(java8.util.stream.Node.OfDouble ofDouble, java8.util.stream.Node.OfDouble ofDouble2) {
                super(ofDouble, ofDouble2);
            }

            @Override // java8.util.stream.Node
            public void forEach(java8.util.function.Consumer<? super java.lang.Double> consumer) {
                java8.util.stream.Nodes.OfDouble.forEach(this, consumer);
            }

            @Override // java8.util.stream.Node
            public java8.util.stream.Node.OfDouble truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
                return java8.util.stream.Nodes.OfDouble.truncate(this, j, j2, intFunction);
            }

            @Override // java8.util.stream.Node
            public java8.util.Spliterator.OfDouble spliterator() {
                return new java8.util.stream.Nodes.InternalNodeSpliterator.OfDouble(this);
            }

            @Override // java8.util.stream.Node
            public void copyInto(java.lang.Double[] dArr, int i) {
                java8.util.stream.Nodes.OfDouble.copyInto(this, dArr, i);
            }

            @Override // java8.util.stream.Node.OfPrimitive
            public double[] newArray(int i) {
                return java8.util.stream.Nodes.OfDouble.newArray(this, i);
            }
        }
    }

    private static abstract class InternalNodeSpliterator<T, S extends java8.util.Spliterator<T>, N extends java8.util.stream.Node<T>> implements java8.util.Spliterator<T> {
        int curChildIndex;
        N curNode;
        S lastNodeSpliterator;
        S tryAdvanceSpliterator;
        java.util.Deque<N> tryAdvanceStack;

        @Override // java8.util.Spliterator
        public final int characteristics() {
            return 64;
        }

        InternalNodeSpliterator(N n) {
            this.curNode = n;
        }

        protected final java.util.Deque<N> initStack() {
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque(8);
            int childCount = this.curNode.getChildCount();
            while (true) {
                childCount--;
                if (childCount < this.curChildIndex) {
                    return arrayDeque;
                }
                arrayDeque.addFirst(this.curNode.getChild(childCount));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected final N findNextLeafNode(java.util.Deque<N> deque) {
            while (true) {
                N n = (N) deque.pollFirst();
                if (n == null) {
                    return null;
                }
                if (n.getChildCount() != 0) {
                    for (int childCount = n.getChildCount() - 1; childCount >= 0; childCount--) {
                        deque.addFirst(n.getChild(childCount));
                    }
                } else if (n.count() > 0) {
                    return n;
                }
            }
        }

        protected final boolean initTryAdvance() {
            if (this.curNode == null) {
                return false;
            }
            if (this.tryAdvanceSpliterator != null) {
                return true;
            }
            S s = this.lastNodeSpliterator;
            if (s == null) {
                java.util.Deque<N> dequeInitStack = initStack();
                this.tryAdvanceStack = dequeInitStack;
                java8.util.stream.Node nodeFindNextLeafNode = findNextLeafNode(dequeInitStack);
                if (nodeFindNextLeafNode != null) {
                    this.tryAdvanceSpliterator = (S) nodeFindNextLeafNode.spliterator();
                    return true;
                }
                this.curNode = null;
                return false;
            }
            this.tryAdvanceSpliterator = s;
            return true;
        }

        @Override // java8.util.Spliterator
        public final S trySplit() {
            N n = this.curNode;
            if (n == null || this.tryAdvanceSpliterator != null) {
                return null;
            }
            S s = this.lastNodeSpliterator;
            if (s != null) {
                return (S) s.trySplit();
            }
            if (this.curChildIndex < n.getChildCount() - 1) {
                N n2 = this.curNode;
                int i = this.curChildIndex;
                this.curChildIndex = i + 1;
                return n2.getChild(i).spliterator();
            }
            N n3 = (N) this.curNode.getChild(this.curChildIndex);
            this.curNode = n3;
            if (n3.getChildCount() == 0) {
                S s2 = (S) this.curNode.spliterator();
                this.lastNodeSpliterator = s2;
                return (S) s2.trySplit();
            }
            N n4 = this.curNode;
            this.curChildIndex = 1;
            return n4.getChild(0).spliterator();
        }

        @Override // java8.util.Spliterator
        public final long estimateSize() {
            long jCount = 0;
            if (this.curNode == null) {
                return 0L;
            }
            S s = this.lastNodeSpliterator;
            if (s != null) {
                return s.estimateSize();
            }
            for (int i = this.curChildIndex; i < this.curNode.getChildCount(); i++) {
                jCount += this.curNode.getChild(i).count();
            }
            return jCount;
        }

        private static final class OfRef<T> extends java8.util.stream.Nodes.InternalNodeSpliterator<T, java8.util.Spliterator<T>, java8.util.stream.Node<T>> {
            OfRef(java8.util.stream.Node<T> node) {
                super(node);
            }

            @Override // java8.util.Spliterator
            public boolean tryAdvance(java8.util.function.Consumer<? super T> consumer) {
                java8.util.stream.Node<T> nodeFindNextLeafNode;
                if (!initTryAdvance()) {
                    return false;
                }
                boolean zTryAdvance = this.tryAdvanceSpliterator.tryAdvance(consumer);
                if (!zTryAdvance) {
                    if (this.lastNodeSpliterator == null && (nodeFindNextLeafNode = findNextLeafNode(this.tryAdvanceStack)) != null) {
                        this.tryAdvanceSpliterator = nodeFindNextLeafNode.spliterator();
                        return this.tryAdvanceSpliterator.tryAdvance(consumer);
                    }
                    this.curNode = null;
                }
                return zTryAdvance;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java8.util.Spliterator
            public void forEachRemaining(java8.util.function.Consumer<? super T> consumer) {
                if (this.curNode == null) {
                    return;
                }
                if (this.tryAdvanceSpliterator == null) {
                    if (this.lastNodeSpliterator == null) {
                        java.util.Deque dequeInitStack = initStack();
                        while (true) {
                            java8.util.stream.Node nodeFindNextLeafNode = findNextLeafNode(dequeInitStack);
                            if (nodeFindNextLeafNode != null) {
                                nodeFindNextLeafNode.forEach(consumer);
                            } else {
                                this.curNode = null;
                                return;
                            }
                        }
                    } else {
                        this.lastNodeSpliterator.forEachRemaining(consumer);
                    }
                } else {
                    while (tryAdvance(consumer)) {
                    }
                }
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
            public java.util.Comparator<? super T> getComparator() {
                return java8.util.Spliterators.getComparator(this);
            }
        }

        private static abstract class OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, N extends java8.util.stream.Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, N>> extends java8.util.stream.Nodes.InternalNodeSpliterator<T, T_SPLITR, N> implements java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            @Override // java8.util.stream.Nodes.InternalNodeSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfPrimitive trySplit() {
                return (java8.util.Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(N n) {
                super(n);
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS t_cons) {
                N nFindNextLeafNode;
                if (!initTryAdvance()) {
                    return false;
                }
                boolean zTryAdvance = ((java8.util.Spliterator.OfPrimitive) this.tryAdvanceSpliterator).tryAdvance(t_cons);
                if (!zTryAdvance) {
                    if (this.lastNodeSpliterator == null && (nFindNextLeafNode = findNextLeafNode(this.tryAdvanceStack)) != null) {
                        this.tryAdvanceSpliterator = nFindNextLeafNode.spliterator();
                        return ((java8.util.Spliterator.OfPrimitive) this.tryAdvanceSpliterator).tryAdvance(t_cons);
                    }
                    this.curNode = null;
                }
                return zTryAdvance;
            }

            @Override // java8.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS t_cons) {
                if (this.curNode == null) {
                    return;
                }
                if (this.tryAdvanceSpliterator == null) {
                    if (this.lastNodeSpliterator == null) {
                        java.util.Deque<N> dequeInitStack = initStack();
                        while (true) {
                            N nFindNextLeafNode = findNextLeafNode(dequeInitStack);
                            if (nFindNextLeafNode != null) {
                                nFindNextLeafNode.forEach(t_cons);
                            } else {
                                this.curNode = null;
                                return;
                            }
                        }
                    } else {
                        ((java8.util.Spliterator.OfPrimitive) this.lastNodeSpliterator).forEachRemaining(t_cons);
                    }
                } else {
                    while (tryAdvance(t_cons)) {
                    }
                }
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
            public java.util.Comparator<? super T> getComparator() {
                return java8.util.Spliterators.getComparator(this);
            }
        }

        private static final class OfInt extends java8.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, int[], java8.util.Spliterator.OfInt, java8.util.stream.Node.OfInt> implements java8.util.Spliterator.OfInt {
            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.IntConsumer intConsumer) {
                super.forEachRemaining(intConsumer);
            }

            @Override // java8.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.IntConsumer intConsumer) {
                return super.tryAdvance(intConsumer);
            }

            @Override // java8.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive, java8.util.stream.Nodes.InternalNodeSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfInt trySplit() {
                return (java8.util.Spliterator.OfInt) super.trySplit();
            }

            OfInt(java8.util.stream.Node.OfInt ofInt) {
                super(ofInt);
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

        private static final class OfLong extends java8.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, long[], java8.util.Spliterator.OfLong, java8.util.stream.Node.OfLong> implements java8.util.Spliterator.OfLong {
            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.LongConsumer longConsumer) {
                super.forEachRemaining(longConsumer);
            }

            @Override // java8.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.LongConsumer longConsumer) {
                return super.tryAdvance(longConsumer);
            }

            @Override // java8.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive, java8.util.stream.Nodes.InternalNodeSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfLong trySplit() {
                return (java8.util.Spliterator.OfLong) super.trySplit();
            }

            OfLong(java8.util.stream.Node.OfLong ofLong) {
                super(ofLong);
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

        private static final class OfDouble extends java8.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, double[], java8.util.Spliterator.OfDouble, java8.util.stream.Node.OfDouble> implements java8.util.Spliterator.OfDouble {
            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(java8.util.function.DoubleConsumer doubleConsumer) {
                super.forEachRemaining(doubleConsumer);
            }

            @Override // java8.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(java8.util.function.DoubleConsumer doubleConsumer) {
                return super.tryAdvance(doubleConsumer);
            }

            @Override // java8.util.stream.Nodes.InternalNodeSpliterator.OfPrimitive, java8.util.stream.Nodes.InternalNodeSpliterator, java8.util.Spliterator
            public /* bridge */ /* synthetic */ java8.util.Spliterator.OfDouble trySplit() {
                return (java8.util.Spliterator.OfDouble) super.trySplit();
            }

            OfDouble(java8.util.stream.Node.OfDouble ofDouble) {
                super(ofDouble);
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
    }

    private static final class FixedNodeBuilder<T> extends java8.util.stream.Nodes.ArrayNode<T> implements java8.util.stream.Node.Builder<T> {
        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        FixedNodeBuilder(long j, java8.util.function.IntFunction<T[]> intFunction) {
            super(j, intFunction);
        }

        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build */
        public java8.util.stream.Node<T> build2() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Current size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            if (j != this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("Begin size %d is not equal to fixed size %d", java.lang.Long.valueOf(j), java.lang.Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java8.util.function.Consumer
        public void accept(T t) {
            if (this.curSize < this.array.length) {
                T[] tArr = this.array;
                int i = this.curSize;
                this.curSize = i + 1;
                tArr[i] = t;
                return;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Accept exceeded fixed size of %d", java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("End size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
            }
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Nodes.ArrayNode
        public java.lang.String toString() {
            return java.lang.String.format("FixedNodeBuilder[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static final class SpinedNodeBuilder<T> extends java8.util.stream.SpinedBuffer<T> implements java8.util.stream.Node<T>, java8.util.stream.Node.Builder<T> {
        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build */
        public java8.util.stream.Node<T> build2() {
            return this;
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        SpinedNodeBuilder() {
        }

        @Override // java8.util.stream.SpinedBuffer, java8.util.stream.Node
        public java8.util.Spliterator<T> spliterator() {
            return super.spliterator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java8.util.stream.SpinedBuffer, java8.util.stream.Node
        public void forEach(java8.util.function.Consumer<? super T> consumer) {
            super.forEach(consumer);
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.getShape();
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> getChild(int i) {
            return java8.util.stream.Nodes.getChild();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node<T> truncate(long j, long j2, java8.util.function.IntFunction<T[]> intFunction) {
            return java8.util.stream.Nodes.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        @Override // java8.util.stream.SpinedBuffer, java8.util.function.Consumer
        public void accept(T t) {
            super.accept(t);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.SpinedBuffer, java8.util.stream.Node
        public void copyInto(T[] tArr, int i) {
            super.copyInto(tArr, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java8.util.stream.SpinedBuffer, java8.util.stream.Node
        public T[] asArray(java8.util.function.IntFunction<T[]> intFunction) {
            return (T[]) super.asArray(intFunction);
        }
    }

    private static class IntArrayNode implements java8.util.stream.Node.OfInt {
        final int[] array;
        int curSize;

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java.lang.Object[] asArray(java8.util.function.IntFunction intFunction) {
            return asArray((java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
        }

        @Override // java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
        }

        IntArrayNode(long j) {
            if (j >= java8.util.stream.Nodes.MAX_ARRAY_SIZE) {
                throw new java.lang.IllegalArgumentException(java8.util.stream.Nodes.BAD_SIZE);
            }
            this.array = new int[(int) j];
            this.curSize = 0;
        }

        IntArrayNode(int[] iArr) {
            this.array = iArr;
            this.curSize = iArr.length;
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node.OfInt, java8.util.stream.Node
        public void forEach(java8.util.function.Consumer<? super java.lang.Integer> consumer) {
            java8.util.stream.Nodes.OfInt.forEach(this, consumer);
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node.OfInt getChild(int i) {
            return (java8.util.stream.Node.OfInt) java8.util.stream.Nodes.OfPrimitive.getChild();
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator.OfInt spliterator() {
            return java8.util.J8Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java8.util.stream.Node.OfInt, java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java8.util.stream.Node.OfInt truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
            return java8.util.stream.Nodes.OfInt.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Node
        public void copyInto(java.lang.Integer[] numArr, int i) {
            java8.util.stream.Nodes.OfInt.copyInto(this, numArr, i);
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public int[] asPrimitiveArray() {
            int[] iArr = this.array;
            int length = iArr.length;
            int i = this.curSize;
            return length == i ? iArr : java.util.Arrays.copyOf(iArr, i);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java.lang.Integer[] asArray(java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
            return (java.lang.Integer[]) java8.util.stream.Nodes.OfPrimitive.asArray(this, intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public int[] newArray(int i) {
            return java8.util.stream.Nodes.OfInt.newArray(this, i);
        }

        @Override // java8.util.stream.Node.OfInt, java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.OfInt.getShape();
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public void copyInto(int[] iArr, int i) {
            java.lang.System.arraycopy(this.array, 0, iArr, i, this.curSize);
        }

        @Override // java8.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public void forEach(java8.util.function.IntConsumer intConsumer) {
            for (int i = 0; i < this.curSize; i++) {
                intConsumer.accept(this.array[i]);
            }
        }

        public java.lang.String toString() {
            return java.lang.String.format("IntArrayNode[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static class LongArrayNode implements java8.util.stream.Node.OfLong {
        final long[] array;
        int curSize;

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java.lang.Object[] asArray(java8.util.function.IntFunction intFunction) {
            return asArray((java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
        }

        @Override // java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
        }

        LongArrayNode(long j) {
            if (j >= java8.util.stream.Nodes.MAX_ARRAY_SIZE) {
                throw new java.lang.IllegalArgumentException(java8.util.stream.Nodes.BAD_SIZE);
            }
            this.array = new long[(int) j];
            this.curSize = 0;
        }

        LongArrayNode(long[] jArr) {
            this.array = jArr;
            this.curSize = jArr.length;
        }

        @Override // java8.util.stream.Node.OfLong, java8.util.stream.Node
        public void forEach(java8.util.function.Consumer<? super java.lang.Long> consumer) {
            java8.util.stream.Nodes.OfLong.forEach(this, consumer);
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node.OfLong getChild(int i) {
            return (java8.util.stream.Node.OfLong) java8.util.stream.Nodes.OfPrimitive.getChild();
        }

        @Override // java8.util.stream.Node
        public void copyInto(java.lang.Long[] lArr, int i) {
            java8.util.stream.Nodes.OfLong.copyInto(this, lArr, i);
        }

        @Override // java8.util.stream.Node.OfLong, java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java8.util.stream.Node.OfLong truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
            return java8.util.stream.Nodes.OfLong.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator.OfLong spliterator() {
            return java8.util.J8Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public long[] asPrimitiveArray() {
            long[] jArr = this.array;
            int length = jArr.length;
            int i = this.curSize;
            return length == i ? jArr : java.util.Arrays.copyOf(jArr, i);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java.lang.Long[] asArray(java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
            return (java.lang.Long[]) java8.util.stream.Nodes.OfPrimitive.asArray(this, intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public long[] newArray(int i) {
            return java8.util.stream.Nodes.OfLong.newArray(this, i);
        }

        @Override // java8.util.stream.Node.OfLong, java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.OfLong.getShape();
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public void copyInto(long[] jArr, int i) {
            java.lang.System.arraycopy(this.array, 0, jArr, i, this.curSize);
        }

        @Override // java8.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public void forEach(java8.util.function.LongConsumer longConsumer) {
            for (int i = 0; i < this.curSize; i++) {
                longConsumer.accept(this.array[i]);
            }
        }

        public java.lang.String toString() {
            return java.lang.String.format("LongArrayNode[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static class DoubleArrayNode implements java8.util.stream.Node.OfDouble {
        final double[] array;
        int curSize;

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java.lang.Object[] asArray(java8.util.function.IntFunction intFunction) {
            return asArray((java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
        }

        @Override // java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
        }

        DoubleArrayNode(long j) {
            if (j >= java8.util.stream.Nodes.MAX_ARRAY_SIZE) {
                throw new java.lang.IllegalArgumentException(java8.util.stream.Nodes.BAD_SIZE);
            }
            this.array = new double[(int) j];
            this.curSize = 0;
        }

        DoubleArrayNode(double[] dArr) {
            this.array = dArr;
            this.curSize = dArr.length;
        }

        @Override // java8.util.stream.Node.OfDouble, java8.util.stream.Node
        public void forEach(java8.util.function.Consumer<? super java.lang.Double> consumer) {
            java8.util.stream.Nodes.OfDouble.forEach(this, consumer);
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node.OfDouble getChild(int i) {
            return (java8.util.stream.Node.OfDouble) java8.util.stream.Nodes.OfPrimitive.getChild();
        }

        @Override // java8.util.stream.Node.OfDouble, java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java8.util.stream.Node.OfDouble truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
            return java8.util.stream.Nodes.OfDouble.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator.OfDouble spliterator() {
            return java8.util.J8Arrays.spliterator(this.array, 0, this.curSize);
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public double[] asPrimitiveArray() {
            double[] dArr = this.array;
            int length = dArr.length;
            int i = this.curSize;
            return length == i ? dArr : java.util.Arrays.copyOf(dArr, i);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java.lang.Double[] asArray(java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
            return (java.lang.Double[]) java8.util.stream.Nodes.OfPrimitive.asArray(this, intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public double[] newArray(int i) {
            return java8.util.stream.Nodes.OfDouble.newArray(this, i);
        }

        @Override // java8.util.stream.Node
        public void copyInto(java.lang.Double[] dArr, int i) {
            java8.util.stream.Nodes.OfDouble.copyInto(this, dArr, i);
        }

        @Override // java8.util.stream.Node.OfDouble, java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.OfDouble.getShape();
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public void copyInto(double[] dArr, int i) {
            java.lang.System.arraycopy(this.array, 0, dArr, i, this.curSize);
        }

        @Override // java8.util.stream.Node
        public long count() {
            return this.curSize;
        }

        @Override // java8.util.stream.Node.OfPrimitive
        public void forEach(java8.util.function.DoubleConsumer doubleConsumer) {
            for (int i = 0; i < this.curSize; i++) {
                doubleConsumer.accept(this.array[i]);
            }
        }

        public java.lang.String toString() {
            return java.lang.String.format("DoubleArrayNode[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static final class IntFixedNodeBuilder extends java8.util.stream.Nodes.IntArrayNode implements java8.util.stream.Node.Builder.OfInt {
        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        IntFixedNodeBuilder(long j) {
            super(j);
        }

        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build */
        public java8.util.stream.Node<java.lang.Integer> build2() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Current size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            if (j != this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("Begin size %d is not equal to fixed size %d", java.lang.Long.valueOf(j), java.lang.Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            if (this.curSize < this.array.length) {
                int[] iArr = this.array;
                int i2 = this.curSize;
                this.curSize = i2 + 1;
                iArr[i2] = i;
                return;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Accept exceeded fixed size of %d", java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Integer num) {
            java8.util.stream.SinkDefaults.OfInt.accept(this, num);
        }

        @Override // java8.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("End size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
            }
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Nodes.IntArrayNode
        public java.lang.String toString() {
            return java.lang.String.format("IntFixedNodeBuilder[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static final class LongFixedNodeBuilder extends java8.util.stream.Nodes.LongArrayNode implements java8.util.stream.Node.Builder.OfLong {
        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        LongFixedNodeBuilder(long j) {
            super(j);
        }

        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build */
        public java8.util.stream.Node<java.lang.Long> build2() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Current size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            if (j != this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("Begin size %d is not equal to fixed size %d", java.lang.Long.valueOf(j), java.lang.Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            if (this.curSize < this.array.length) {
                long[] jArr = this.array;
                int i = this.curSize;
                this.curSize = i + 1;
                jArr[i] = j;
                return;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Accept exceeded fixed size of %d", java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Long l) {
            java8.util.stream.SinkDefaults.OfLong.accept(this, l);
        }

        @Override // java8.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("End size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
            }
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Nodes.LongArrayNode
        public java.lang.String toString() {
            return java.lang.String.format("LongFixedNodeBuilder[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static final class DoubleFixedNodeBuilder extends java8.util.stream.Nodes.DoubleArrayNode implements java8.util.stream.Node.Builder.OfDouble {
        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        DoubleFixedNodeBuilder(long j) {
            super(j);
        }

        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build, reason: merged with bridge method [inline-methods] */
        public java8.util.stream.Node<java.lang.Double> build2() {
            if (this.curSize >= this.array.length) {
                return this;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Current size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            if (j != this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("Begin size %d is not equal to fixed size %d", java.lang.Long.valueOf(j), java.lang.Integer.valueOf(this.array.length)));
            }
            this.curSize = 0;
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            if (this.curSize < this.array.length) {
                double[] dArr = this.array;
                int i = this.curSize;
                this.curSize = i + 1;
                dArr[i] = d;
                return;
            }
            throw new java.lang.IllegalStateException(java.lang.String.format("Accept exceeded fixed size of %d", java.lang.Integer.valueOf(this.array.length)));
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Double d) {
            java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
        }

        @Override // java8.util.stream.Sink
        public void end() {
            if (this.curSize < this.array.length) {
                throw new java.lang.IllegalStateException(java.lang.String.format("End size %d is less than fixed size %d", java.lang.Integer.valueOf(this.curSize), java.lang.Integer.valueOf(this.array.length)));
            }
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Nodes.DoubleArrayNode
        public java.lang.String toString() {
            return java.lang.String.format("DoubleFixedNodeBuilder[%d][%s]", java.lang.Integer.valueOf(this.array.length - this.curSize), java.util.Arrays.toString(this.array));
        }
    }

    private static final class IntSpinedNodeBuilder extends java8.util.stream.SpinedBuffer.OfInt implements java8.util.stream.Node.OfInt, java8.util.stream.Node.Builder.OfInt {
        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build */
        public java8.util.stream.Node<java.lang.Integer> build2() {
            return this;
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java.lang.Object[] asArray(java8.util.function.IntFunction intFunction) {
            return asArray((java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
        }

        @Override // java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Integer[]>) intFunction);
        }

        IntSpinedNodeBuilder() {
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator.OfInt spliterator() {
            return super.spliterator();
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public void forEach(java8.util.function.IntConsumer intConsumer) {
            super.forEach(intConsumer);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        @Override // java8.util.stream.SpinedBuffer.OfInt, java8.util.function.IntConsumer
        public void accept(int i) {
            super.accept(i);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Integer num) {
            java8.util.stream.SinkDefaults.OfInt.accept(this, num);
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public void copyInto(int[] iArr, int i) throws java.lang.IndexOutOfBoundsException {
            super.copyInto(iArr, i);
        }

        @Override // java8.util.stream.Node
        public void copyInto(java.lang.Integer[] numArr, int i) {
            java8.util.stream.Nodes.OfInt.copyInto(this, numArr, i);
        }

        @Override // java8.util.stream.Node.OfInt, java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java8.util.stream.Node.OfInt truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
            return java8.util.stream.Nodes.OfInt.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public int[] asPrimitiveArray() {
            return (int[]) super.asPrimitiveArray();
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java.lang.Integer[] asArray(java8.util.function.IntFunction<java.lang.Integer[]> intFunction) {
            return (java.lang.Integer[]) java8.util.stream.Nodes.OfPrimitive.asArray(this, intFunction);
        }

        @Override // java8.util.stream.Node.OfInt, java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.OfInt.getShape();
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node.OfInt getChild(int i) {
            return (java8.util.stream.Node.OfInt) java8.util.stream.Nodes.OfPrimitive.getChild();
        }
    }

    private static final class LongSpinedNodeBuilder extends java8.util.stream.SpinedBuffer.OfLong implements java8.util.stream.Node.OfLong, java8.util.stream.Node.Builder.OfLong {
        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build */
        public java8.util.stream.Node<java.lang.Long> build2() {
            return this;
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java.lang.Object[] asArray(java8.util.function.IntFunction intFunction) {
            return asArray((java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
        }

        @Override // java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Long[]>) intFunction);
        }

        LongSpinedNodeBuilder() {
        }

        @Override // java8.util.stream.Node.OfLong, java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java8.util.stream.Node.OfLong truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
            return java8.util.stream.Nodes.OfLong.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator.OfLong spliterator() {
            return super.spliterator();
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public void forEach(java8.util.function.LongConsumer longConsumer) {
            super.forEach(longConsumer);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        @Override // java8.util.stream.SpinedBuffer.OfLong, java8.util.function.LongConsumer
        public void accept(long j) {
            super.accept(j);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Long l) {
            java8.util.stream.SinkDefaults.OfLong.accept(this, l);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public void copyInto(long[] jArr, int i) {
            super.copyInto(jArr, i);
        }

        @Override // java8.util.stream.Node
        public void copyInto(java.lang.Long[] lArr, int i) {
            java8.util.stream.Nodes.OfLong.copyInto(this, lArr, i);
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public long[] asPrimitiveArray() {
            return (long[]) super.asPrimitiveArray();
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java.lang.Long[] asArray(java8.util.function.IntFunction<java.lang.Long[]> intFunction) {
            return (java.lang.Long[]) java8.util.stream.Nodes.OfPrimitive.asArray(this, intFunction);
        }

        @Override // java8.util.stream.Node.OfLong, java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.OfLong.getShape();
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node.OfLong getChild(int i) {
            return (java8.util.stream.Node.OfLong) java8.util.stream.Nodes.OfPrimitive.getChild();
        }
    }

    private static final class DoubleSpinedNodeBuilder extends java8.util.stream.SpinedBuffer.OfDouble implements java8.util.stream.Node.OfDouble, java8.util.stream.Node.Builder.OfDouble {
        @Override // java8.util.stream.Node.Builder
        /* JADX INFO: renamed from: build */
        public java8.util.stream.Node<java.lang.Double> build2() {
            return this;
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java.lang.Object[] asArray(java8.util.function.IntFunction intFunction) {
            return asArray((java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node.OfPrimitive truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
        }

        @Override // java8.util.stream.Node
        public /* bridge */ /* synthetic */ java8.util.stream.Node truncate(long j, long j2, java8.util.function.IntFunction intFunction) {
            return truncate(j, j2, (java8.util.function.IntFunction<java.lang.Double[]>) intFunction);
        }

        DoubleSpinedNodeBuilder() {
        }

        @Override // java8.util.stream.Node.OfDouble, java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java8.util.stream.Node.OfDouble truncate(long j, long j2, java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
            return java8.util.stream.Nodes.OfDouble.truncate(this, j, j2, intFunction);
        }

        @Override // java8.util.stream.Node
        public java8.util.Spliterator.OfDouble spliterator() {
            return super.spliterator();
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public void forEach(java8.util.function.DoubleConsumer doubleConsumer) {
            super.forEach(doubleConsumer);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            clear();
            ensureCapacity(j);
        }

        @Override // java8.util.stream.SpinedBuffer.OfDouble, java8.util.function.DoubleConsumer
        public void accept(double d) {
            super.accept(d);
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Double d) {
            java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public void copyInto(double[] dArr, int i) {
            super.copyInto(dArr, i);
        }

        @Override // java8.util.stream.Node
        public void copyInto(java.lang.Double[] dArr, int i) {
            java8.util.stream.Nodes.OfDouble.copyInto(this, dArr, i);
        }

        @Override // java8.util.stream.SpinedBuffer.OfPrimitive, java8.util.stream.Node.OfPrimitive
        public double[] asPrimitiveArray() {
            return (double[]) super.asPrimitiveArray();
        }

        @Override // java8.util.stream.Node.OfPrimitive, java8.util.stream.Node
        public java.lang.Double[] asArray(java8.util.function.IntFunction<java.lang.Double[]> intFunction) {
            return (java.lang.Double[]) java8.util.stream.Nodes.OfPrimitive.asArray(this, intFunction);
        }

        @Override // java8.util.stream.Node
        public int getChildCount() {
            return java8.util.stream.Nodes.getChildCount();
        }

        @Override // java8.util.stream.Node
        public java8.util.stream.Node.OfDouble getChild(int i) {
            return (java8.util.stream.Node.OfDouble) java8.util.stream.Nodes.OfPrimitive.getChild();
        }

        @Override // java8.util.stream.Node.OfDouble, java8.util.stream.Node
        public java8.util.stream.StreamShape getShape() {
            return java8.util.stream.Nodes.OfDouble.getShape();
        }
    }

    private static abstract class SizedCollectorTask<P_IN, P_OUT, T_SINK extends java8.util.stream.Sink<P_OUT>, K extends java8.util.stream.Nodes.SizedCollectorTask<P_IN, P_OUT, T_SINK, K>> extends java8.util.concurrent.CountedCompleter<java.lang.Void> implements java8.util.stream.Sink<P_OUT> {
        protected int fence;
        protected final java8.util.stream.PipelineHelper<P_OUT> helper;
        protected int index;
        protected long length;
        protected long offset;
        protected final java8.util.Spliterator<P_IN> spliterator;
        protected final long targetSize;

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return false;
        }

        @Override // java8.util.stream.Sink
        public void end() {
        }

        abstract K makeChild(java8.util.Spliterator<P_IN> spliterator, long j, long j2);

        SizedCollectorTask(java8.util.Spliterator<P_IN> spliterator, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, int i) {
            this.spliterator = spliterator;
            this.helper = pipelineHelper;
            this.targetSize = java8.util.stream.AbstractTask.suggestTargetSize(spliterator.estimateSize());
            this.offset = 0L;
            this.length = i;
        }

        SizedCollectorTask(K k, java8.util.Spliterator<P_IN> spliterator, long j, long j2, int i) {
            super(k);
            this.spliterator = spliterator;
            this.helper = k.helper;
            this.targetSize = k.targetSize;
            this.offset = j;
            this.length = j2;
            if (j < 0 || j2 < 0 || (j + j2) - 1 >= i) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Integer.valueOf(i)));
            }
        }

        @Override // java8.util.concurrent.CountedCompleter
        public void compute() {
            java8.util.Spliterator<P_IN> spliteratorTrySplit;
            java8.util.Spliterator<P_IN> spliterator = this.spliterator;
            java8.util.stream.Nodes.SizedCollectorTask<P_IN, P_OUT, T_SINK, K> sizedCollectorTaskMakeChild = this;
            while (spliterator.estimateSize() > sizedCollectorTaskMakeChild.targetSize && (spliteratorTrySplit = spliterator.trySplit()) != null) {
                sizedCollectorTaskMakeChild.setPendingCount(1);
                long jEstimateSize = spliteratorTrySplit.estimateSize();
                sizedCollectorTaskMakeChild.makeChild(spliteratorTrySplit, sizedCollectorTaskMakeChild.offset, jEstimateSize).fork();
                sizedCollectorTaskMakeChild = sizedCollectorTaskMakeChild.makeChild(spliterator, sizedCollectorTaskMakeChild.offset + jEstimateSize, sizedCollectorTaskMakeChild.length - jEstimateSize);
            }
            sizedCollectorTaskMakeChild.helper.wrapAndCopyInto(sizedCollectorTaskMakeChild, (java8.util.Spliterator) spliterator);
            sizedCollectorTaskMakeChild.propagateCompletion();
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            long j2 = this.length;
            if (j > j2) {
                throw new java.lang.IllegalStateException("size passed to Sink.begin exceeds array length");
            }
            int i = (int) this.offset;
            this.index = i;
            this.fence = i + ((int) j2);
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        static final class OfRef<P_IN, P_OUT> extends java8.util.stream.Nodes.SizedCollectorTask<P_IN, P_OUT, java8.util.stream.Sink<P_OUT>, java8.util.stream.Nodes.SizedCollectorTask.OfRef<P_IN, P_OUT>> implements java8.util.stream.Sink<P_OUT> {
            private final P_OUT[] array;

            OfRef(java8.util.Spliterator<P_IN> spliterator, java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, P_OUT[] p_outArr) {
                super(spliterator, pipelineHelper, p_outArr.length);
                this.array = p_outArr;
            }

            OfRef(java8.util.stream.Nodes.SizedCollectorTask.OfRef<P_IN, P_OUT> ofRef, java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                super(ofRef, spliterator, j, j2, ofRef.array.length);
                this.array = ofRef.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.Nodes.SizedCollectorTask
            public java8.util.stream.Nodes.SizedCollectorTask.OfRef<P_IN, P_OUT> makeChild(java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                return new java8.util.stream.Nodes.SizedCollectorTask.OfRef<>(this, spliterator, j, j2);
            }

            @Override // java8.util.function.Consumer
            public void accept(P_OUT p_out) {
                if (this.index >= this.fence) {
                    throw new java.lang.IndexOutOfBoundsException(java.lang.Integer.toString(this.index));
                }
                P_OUT[] p_outArr = this.array;
                int i = this.index;
                this.index = i + 1;
                p_outArr[i] = p_out;
            }
        }

        static final class OfInt<P_IN> extends java8.util.stream.Nodes.SizedCollectorTask<P_IN, java.lang.Integer, java8.util.stream.Sink.OfInt, java8.util.stream.Nodes.SizedCollectorTask.OfInt<P_IN>> implements java8.util.stream.Sink.OfInt {
            private final int[] array;

            OfInt(java8.util.Spliterator<P_IN> spliterator, java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, int[] iArr) {
                super(spliterator, pipelineHelper, iArr.length);
                this.array = iArr;
            }

            OfInt(java8.util.stream.Nodes.SizedCollectorTask.OfInt<P_IN> ofInt, java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                super(ofInt, spliterator, j, j2, ofInt.array.length);
                this.array = ofInt.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.Nodes.SizedCollectorTask
            public java8.util.stream.Nodes.SizedCollectorTask.OfInt<P_IN> makeChild(java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                return new java8.util.stream.Nodes.SizedCollectorTask.OfInt<>(this, spliterator, j, j2);
            }

            @Override // java8.util.stream.Nodes.SizedCollectorTask, java8.util.stream.Sink
            public void accept(int i) {
                if (this.index >= this.fence) {
                    throw new java.lang.IndexOutOfBoundsException(java.lang.Integer.toString(this.index));
                }
                int[] iArr = this.array;
                int i2 = this.index;
                this.index = i2 + 1;
                iArr[i2] = i;
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Integer num) {
                java8.util.stream.SinkDefaults.OfInt.accept(this, num);
            }
        }

        static final class OfLong<P_IN> extends java8.util.stream.Nodes.SizedCollectorTask<P_IN, java.lang.Long, java8.util.stream.Sink.OfLong, java8.util.stream.Nodes.SizedCollectorTask.OfLong<P_IN>> implements java8.util.stream.Sink.OfLong {
            private final long[] array;

            OfLong(java8.util.Spliterator<P_IN> spliterator, java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, long[] jArr) {
                super(spliterator, pipelineHelper, jArr.length);
                this.array = jArr;
            }

            OfLong(java8.util.stream.Nodes.SizedCollectorTask.OfLong<P_IN> ofLong, java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                super(ofLong, spliterator, j, j2, ofLong.array.length);
                this.array = ofLong.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.Nodes.SizedCollectorTask
            public java8.util.stream.Nodes.SizedCollectorTask.OfLong<P_IN> makeChild(java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                return new java8.util.stream.Nodes.SizedCollectorTask.OfLong<>(this, spliterator, j, j2);
            }

            @Override // java8.util.stream.Nodes.SizedCollectorTask, java8.util.stream.Sink
            public void accept(long j) {
                if (this.index >= this.fence) {
                    throw new java.lang.IndexOutOfBoundsException(java.lang.Integer.toString(this.index));
                }
                long[] jArr = this.array;
                int i = this.index;
                this.index = i + 1;
                jArr[i] = j;
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Long l) {
                java8.util.stream.SinkDefaults.OfLong.accept(this, l);
            }
        }

        static final class OfDouble<P_IN> extends java8.util.stream.Nodes.SizedCollectorTask<P_IN, java.lang.Double, java8.util.stream.Sink.OfDouble, java8.util.stream.Nodes.SizedCollectorTask.OfDouble<P_IN>> implements java8.util.stream.Sink.OfDouble {
            private final double[] array;

            OfDouble(java8.util.Spliterator<P_IN> spliterator, java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, double[] dArr) {
                super(spliterator, pipelineHelper, dArr.length);
                this.array = dArr;
            }

            OfDouble(java8.util.stream.Nodes.SizedCollectorTask.OfDouble<P_IN> ofDouble, java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                super(ofDouble, spliterator, j, j2, ofDouble.array.length);
                this.array = ofDouble.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.Nodes.SizedCollectorTask
            public java8.util.stream.Nodes.SizedCollectorTask.OfDouble<P_IN> makeChild(java8.util.Spliterator<P_IN> spliterator, long j, long j2) {
                return new java8.util.stream.Nodes.SizedCollectorTask.OfDouble<>(this, spliterator, j, j2);
            }

            @Override // java8.util.stream.Nodes.SizedCollectorTask, java8.util.stream.Sink
            public void accept(double d) {
                if (this.index >= this.fence) {
                    throw new java.lang.IndexOutOfBoundsException(java.lang.Integer.toString(this.index));
                }
                double[] dArr = this.array;
                int i = this.index;
                this.index = i + 1;
                dArr[i] = d;
            }

            @Override // java8.util.function.Consumer
            public void accept(java.lang.Double d) {
                java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
            }
        }
    }

    private static abstract class ToArrayTask<T, T_NODE extends java8.util.stream.Node<T>, K extends java8.util.stream.Nodes.ToArrayTask<T, T_NODE, K>> extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        protected final T_NODE node;
        protected final int offset;

        abstract void copyNodeToArray();

        abstract K makeChild(int i, int i2);

        ToArrayTask(T_NODE t_node, int i) {
            this.node = t_node;
            this.offset = i;
        }

        ToArrayTask(K k, T_NODE t_node, int i) {
            super(k);
            this.node = t_node;
            this.offset = i;
        }

        @Override // java8.util.concurrent.CountedCompleter
        public void compute() {
            java8.util.stream.Nodes.ToArrayTask<T, T_NODE, K> toArrayTaskMakeChild = this;
            while (toArrayTaskMakeChild.node.getChildCount() != 0) {
                toArrayTaskMakeChild.setPendingCount(toArrayTaskMakeChild.node.getChildCount() - 1);
                int i = 0;
                int iCount = 0;
                while (i < toArrayTaskMakeChild.node.getChildCount() - 1) {
                    java8.util.stream.Nodes.ToArrayTask toArrayTaskMakeChild2 = toArrayTaskMakeChild.makeChild(i, toArrayTaskMakeChild.offset + iCount);
                    iCount = (int) (((long) iCount) + toArrayTaskMakeChild2.node.count());
                    toArrayTaskMakeChild2.fork();
                    i++;
                }
                toArrayTaskMakeChild = toArrayTaskMakeChild.makeChild(i, toArrayTaskMakeChild.offset + iCount);
            }
            toArrayTaskMakeChild.copyNodeToArray();
            toArrayTaskMakeChild.propagateCompletion();
        }

        private static final class OfRef<T> extends java8.util.stream.Nodes.ToArrayTask<T, java8.util.stream.Node<T>, java8.util.stream.Nodes.ToArrayTask.OfRef<T>> {
            private final T[] array;

            /* synthetic */ OfRef(java8.util.stream.Node node, java.lang.Object[] objArr, int i, java8.util.stream.Nodes.AnonymousClass1 anonymousClass1) {
                this(node, objArr, i);
            }

            private OfRef(java8.util.stream.Node<T> node, T[] tArr, int i) {
                super(node, i);
                this.array = tArr;
            }

            private OfRef(java8.util.stream.Nodes.ToArrayTask.OfRef<T> ofRef, java8.util.stream.Node<T> node, int i) {
                super(ofRef, node, i);
                this.array = ofRef.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.Nodes.ToArrayTask
            public java8.util.stream.Nodes.ToArrayTask.OfRef<T> makeChild(int i, int i2) {
                return new java8.util.stream.Nodes.ToArrayTask.OfRef<>(this, this.node.getChild(i), i2);
            }

            @Override // java8.util.stream.Nodes.ToArrayTask
            void copyNodeToArray() {
                this.node.copyInto(this.array, this.offset);
            }
        }

        private static class OfPrimitive<T, T_CONS, T_ARR, T_SPLITR extends java8.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_NODE extends java8.util.stream.Node.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> extends java8.util.stream.Nodes.ToArrayTask<T, T_NODE, java8.util.stream.Nodes.ToArrayTask.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE>> {
            private final T_ARR array;

            /* synthetic */ OfPrimitive(java8.util.stream.Node.OfPrimitive ofPrimitive, java.lang.Object obj, int i, java8.util.stream.Nodes.AnonymousClass1 anonymousClass1) {
                this(ofPrimitive, obj, i);
            }

            private OfPrimitive(T_NODE t_node, T_ARR t_arr, int i) {
                super(t_node, i);
                this.array = t_arr;
            }

            private OfPrimitive(java8.util.stream.Nodes.ToArrayTask.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE> ofPrimitive, T_NODE t_node, int i) {
                super(ofPrimitive, t_node, i);
                this.array = ofPrimitive.array;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java8.util.stream.Nodes.ToArrayTask
            public java8.util.stream.Nodes.ToArrayTask.OfPrimitive<T, T_CONS, T_ARR, T_SPLITR, T_NODE> makeChild(int i, int i2) {
                return new java8.util.stream.Nodes.ToArrayTask.OfPrimitive<>(this, ((java8.util.stream.Node.OfPrimitive) this.node).getChild(i), i2);
            }

            @Override // java8.util.stream.Nodes.ToArrayTask
            void copyNodeToArray() {
                ((java8.util.stream.Node.OfPrimitive) this.node).copyInto(this.array, this.offset);
            }
        }

        private static final class OfInt extends java8.util.stream.Nodes.ToArrayTask.OfPrimitive<java.lang.Integer, java8.util.function.IntConsumer, int[], java8.util.Spliterator.OfInt, java8.util.stream.Node.OfInt> {
            /* synthetic */ OfInt(java8.util.stream.Node.OfInt ofInt, int[] iArr, int i, java8.util.stream.Nodes.AnonymousClass1 anonymousClass1) {
                this(ofInt, iArr, i);
            }

            private OfInt(java8.util.stream.Node.OfInt ofInt, int[] iArr, int i) {
                super(ofInt, iArr, i, null);
            }
        }

        private static final class OfLong extends java8.util.stream.Nodes.ToArrayTask.OfPrimitive<java.lang.Long, java8.util.function.LongConsumer, long[], java8.util.Spliterator.OfLong, java8.util.stream.Node.OfLong> {
            /* synthetic */ OfLong(java8.util.stream.Node.OfLong ofLong, long[] jArr, int i, java8.util.stream.Nodes.AnonymousClass1 anonymousClass1) {
                this(ofLong, jArr, i);
            }

            private OfLong(java8.util.stream.Node.OfLong ofLong, long[] jArr, int i) {
                super(ofLong, jArr, i, null);
            }
        }

        private static final class OfDouble extends java8.util.stream.Nodes.ToArrayTask.OfPrimitive<java.lang.Double, java8.util.function.DoubleConsumer, double[], java8.util.Spliterator.OfDouble, java8.util.stream.Node.OfDouble> {
            /* synthetic */ OfDouble(java8.util.stream.Node.OfDouble ofDouble, double[] dArr, int i, java8.util.stream.Nodes.AnonymousClass1 anonymousClass1) {
                this(ofDouble, dArr, i);
            }

            private OfDouble(java8.util.stream.Node.OfDouble ofDouble, double[] dArr, int i) {
                super(ofDouble, dArr, i, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class CollectorTask<P_IN, P_OUT, T_NODE extends java8.util.stream.Node<P_OUT>, T_BUILDER extends java8.util.stream.Node.Builder<P_OUT>> extends java8.util.stream.AbstractTask<P_IN, P_OUT, T_NODE, java8.util.stream.Nodes.CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER>> {
        protected final java8.util.function.LongFunction<T_BUILDER> builderFactory;
        protected final java8.util.function.BinaryOperator<T_NODE> concFactory;
        protected final java8.util.stream.PipelineHelper<P_OUT> helper;

        CollectorTask(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator, java8.util.function.LongFunction<T_BUILDER> longFunction, java8.util.function.BinaryOperator<T_NODE> binaryOperator) {
            super(pipelineHelper, spliterator);
            this.helper = pipelineHelper;
            this.builderFactory = longFunction;
            this.concFactory = binaryOperator;
        }

        CollectorTask(java8.util.stream.Nodes.CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER> collectorTask, java8.util.Spliterator<P_IN> spliterator) {
            super(collectorTask, spliterator);
            this.helper = collectorTask.helper;
            this.builderFactory = collectorTask.builderFactory;
            this.concFactory = collectorTask.concFactory;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public java8.util.stream.Nodes.CollectorTask<P_IN, P_OUT, T_NODE, T_BUILDER> makeChild(java8.util.Spliterator<P_IN> spliterator) {
            return new java8.util.stream.Nodes.CollectorTask<>(this, spliterator);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java8.util.stream.AbstractTask
        public T_NODE doLeaf() {
            return (T_NODE) ((java8.util.stream.Node.Builder) this.helper.wrapAndCopyInto(this.builderFactory.apply(this.helper.exactOutputSizeIfKnown(this.spliterator)), (java8.util.Spliterator) this.spliterator)).build2();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter
        public void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            if (!isLeaf()) {
                setLocalResult(this.concFactory.apply(((java8.util.stream.Nodes.CollectorTask) this.leftChild).getLocalResult(), ((java8.util.stream.Nodes.CollectorTask) this.rightChild).getLocalResult()));
            }
            super.onCompletion(countedCompleter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static final class OfRef<P_IN, P_OUT> extends java8.util.stream.Nodes.CollectorTask<P_IN, P_OUT, java8.util.stream.Node<P_OUT>, java8.util.stream.Node.Builder<P_OUT>> {
            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java.lang.Object doLeaf() {
                return super.doLeaf();
            }

            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java8.util.stream.AbstractTask makeChild(java8.util.Spliterator spliterator) {
                return super.makeChild(spliterator);
            }

            OfRef(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.function.IntFunction<P_OUT[]> intFunction, java8.util.Spliterator<P_IN> spliterator) {
                super(pipelineHelper, spliterator, java8.util.stream.Nodes$CollectorTask$OfRef$$Lambda$1.lambdaFactory$(intFunction), java8.util.stream.Nodes$CollectorTask$OfRef$$Lambda$2.instance);
            }

            static /* synthetic */ java8.util.stream.Node.Builder lambda$new$109(java8.util.function.IntFunction intFunction, long j) {
                return java8.util.stream.Nodes.builder(j, intFunction);
            }
        }

        private static final class OfInt<P_IN> extends java8.util.stream.Nodes.CollectorTask<P_IN, java.lang.Integer, java8.util.stream.Node.OfInt, java8.util.stream.Node.Builder.OfInt> {
            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java.lang.Object doLeaf() {
                return super.doLeaf();
            }

            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java8.util.stream.AbstractTask makeChild(java8.util.Spliterator spliterator) {
                return super.makeChild(spliterator);
            }

            OfInt(java8.util.stream.PipelineHelper<java.lang.Integer> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                super(pipelineHelper, spliterator, java8.util.stream.Nodes$CollectorTask$OfInt$$Lambda$1.instance, java8.util.stream.Nodes$CollectorTask$OfInt$$Lambda$2.instance);
            }
        }

        private static final class OfLong<P_IN> extends java8.util.stream.Nodes.CollectorTask<P_IN, java.lang.Long, java8.util.stream.Node.OfLong, java8.util.stream.Node.Builder.OfLong> {
            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java.lang.Object doLeaf() {
                return super.doLeaf();
            }

            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java8.util.stream.AbstractTask makeChild(java8.util.Spliterator spliterator) {
                return super.makeChild(spliterator);
            }

            OfLong(java8.util.stream.PipelineHelper<java.lang.Long> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                super(pipelineHelper, spliterator, java8.util.stream.Nodes$CollectorTask$OfLong$$Lambda$1.instance, java8.util.stream.Nodes$CollectorTask$OfLong$$Lambda$2.instance);
            }
        }

        private static final class OfDouble<P_IN> extends java8.util.stream.Nodes.CollectorTask<P_IN, java.lang.Double, java8.util.stream.Node.OfDouble, java8.util.stream.Node.Builder.OfDouble> {
            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java.lang.Object doLeaf() {
                return super.doLeaf();
            }

            @Override // java8.util.stream.Nodes.CollectorTask, java8.util.stream.AbstractTask
            protected /* bridge */ /* synthetic */ java8.util.stream.AbstractTask makeChild(java8.util.Spliterator spliterator) {
                return super.makeChild(spliterator);
            }

            OfDouble(java8.util.stream.PipelineHelper<java.lang.Double> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
                super(pipelineHelper, spliterator, java8.util.stream.Nodes$CollectorTask$OfDouble$$Lambda$1.instance, java8.util.stream.Nodes$CollectorTask$OfDouble$$Lambda$2.instance);
            }
        }
    }
}
