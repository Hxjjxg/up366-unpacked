package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class ArrayPrefixHelpers {
    static final int CUMULATE = 1;
    static final int FINISHED = 4;
    static final int MIN_PARTITION = 16;
    static final int SUMMED = 2;

    private ArrayPrefixHelpers() {
    }

    static final class CumulateTask<T> extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        final T[] array;
        final int fence;
        final java8.util.function.BinaryOperator<T> function;
        final int hi;
        T in;
        java8.util.ArrayPrefixHelpers.CumulateTask<T> left;
        final int lo;
        final int origin;
        T out;
        java8.util.ArrayPrefixHelpers.CumulateTask<T> right;
        final int threshold;

        public CumulateTask(java8.util.ArrayPrefixHelpers.CumulateTask<T> cumulateTask, java8.util.function.BinaryOperator<T> binaryOperator, T[] tArr, int i, int i2) {
            super(cumulateTask);
            this.function = binaryOperator;
            this.array = tArr;
            this.origin = i;
            this.lo = i;
            this.fence = i2;
            this.hi = i2;
            int commonPoolParallelism = (i2 - i) / (java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = commonPoolParallelism <= 16 ? 16 : commonPoolParallelism;
        }

        CumulateTask(java8.util.ArrayPrefixHelpers.CumulateTask<T> cumulateTask, java8.util.function.BinaryOperator<T> binaryOperator, T[] tArr, int i, int i2, int i3, int i4, int i5) {
            super(cumulateTask);
            this.function = binaryOperator;
            this.array = tArr;
            this.origin = i;
            this.fence = i2;
            this.threshold = i3;
            this.lo = i4;
            this.hi = i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:112:0x0156 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0086 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
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
        @Override // java8.util.concurrent.CountedCompleter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void compute() {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.ArrayPrefixHelpers.CumulateTask.compute():void");
        }
    }

    static final class LongCumulateTask extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        final long[] array;
        final int fence;
        final java8.util.function.LongBinaryOperator function;
        final int hi;
        long in;
        java8.util.ArrayPrefixHelpers.LongCumulateTask left;
        final int lo;
        final int origin;
        long out;
        java8.util.ArrayPrefixHelpers.LongCumulateTask right;
        final int threshold;

        public LongCumulateTask(java8.util.ArrayPrefixHelpers.LongCumulateTask longCumulateTask, java8.util.function.LongBinaryOperator longBinaryOperator, long[] jArr, int i, int i2) {
            super(longCumulateTask);
            this.function = longBinaryOperator;
            this.array = jArr;
            this.origin = i;
            this.lo = i;
            this.fence = i2;
            this.hi = i2;
            int commonPoolParallelism = (i2 - i) / (java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = commonPoolParallelism <= 16 ? 16 : commonPoolParallelism;
        }

        LongCumulateTask(java8.util.ArrayPrefixHelpers.LongCumulateTask longCumulateTask, java8.util.function.LongBinaryOperator longBinaryOperator, long[] jArr, int i, int i2, int i3, int i4, int i5) {
            super(longCumulateTask);
            this.function = longBinaryOperator;
            this.array = jArr;
            this.origin = i;
            this.fence = i2;
            this.threshold = i3;
            this.lo = i4;
            this.hi = i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x0156 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0086 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
        @Override // java8.util.concurrent.CountedCompleter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void compute() {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.ArrayPrefixHelpers.LongCumulateTask.compute():void");
        }
    }

    static final class DoubleCumulateTask extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        final double[] array;
        final int fence;
        final java8.util.function.DoubleBinaryOperator function;
        final int hi;
        double in;
        java8.util.ArrayPrefixHelpers.DoubleCumulateTask left;
        final int lo;
        final int origin;
        double out;
        java8.util.ArrayPrefixHelpers.DoubleCumulateTask right;
        final int threshold;

        public DoubleCumulateTask(java8.util.ArrayPrefixHelpers.DoubleCumulateTask doubleCumulateTask, java8.util.function.DoubleBinaryOperator doubleBinaryOperator, double[] dArr, int i, int i2) {
            super(doubleCumulateTask);
            this.function = doubleBinaryOperator;
            this.array = dArr;
            this.origin = i;
            this.lo = i;
            this.fence = i2;
            this.hi = i2;
            int commonPoolParallelism = (i2 - i) / (java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = commonPoolParallelism <= 16 ? 16 : commonPoolParallelism;
        }

        DoubleCumulateTask(java8.util.ArrayPrefixHelpers.DoubleCumulateTask doubleCumulateTask, java8.util.function.DoubleBinaryOperator doubleBinaryOperator, double[] dArr, int i, int i2, int i3, int i4, int i5) {
            super(doubleCumulateTask);
            this.function = doubleBinaryOperator;
            this.array = dArr;
            this.origin = i;
            this.fence = i2;
            this.threshold = i3;
            this.lo = i4;
            this.hi = i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x0156 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0086 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
        @Override // java8.util.concurrent.CountedCompleter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void compute() {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.ArrayPrefixHelpers.DoubleCumulateTask.compute():void");
        }
    }

    static final class IntCumulateTask extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        final int[] array;
        final int fence;
        final java8.util.function.IntBinaryOperator function;
        final int hi;
        int in;
        java8.util.ArrayPrefixHelpers.IntCumulateTask left;
        final int lo;
        final int origin;
        int out;
        java8.util.ArrayPrefixHelpers.IntCumulateTask right;
        final int threshold;

        public IntCumulateTask(java8.util.ArrayPrefixHelpers.IntCumulateTask intCumulateTask, java8.util.function.IntBinaryOperator intBinaryOperator, int[] iArr, int i, int i2) {
            super(intCumulateTask);
            this.function = intBinaryOperator;
            this.array = iArr;
            this.origin = i;
            this.lo = i;
            this.fence = i2;
            this.hi = i2;
            int commonPoolParallelism = (i2 - i) / (java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = commonPoolParallelism <= 16 ? 16 : commonPoolParallelism;
        }

        IntCumulateTask(java8.util.ArrayPrefixHelpers.IntCumulateTask intCumulateTask, java8.util.function.IntBinaryOperator intBinaryOperator, int[] iArr, int i, int i2, int i3, int i4, int i5) {
            super(intCumulateTask);
            this.function = intBinaryOperator;
            this.array = iArr;
            this.origin = i;
            this.fence = i2;
            this.threshold = i3;
            this.lo = i4;
            this.hi = i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:112:0x0156 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0086 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
        @Override // java8.util.concurrent.CountedCompleter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void compute() {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: java8.util.ArrayPrefixHelpers.IntCumulateTask.compute():void");
        }
    }
}
