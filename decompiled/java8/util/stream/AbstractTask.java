package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class AbstractTask<P_IN, P_OUT, R, K extends java8.util.stream.AbstractTask<P_IN, P_OUT, R, K>> extends java8.util.concurrent.CountedCompleter<R> {
    private static final int LEAF_TARGET = java8.util.concurrent.ForkJoinPool.getCommonPoolParallelism() << 2;
    protected final java8.util.stream.PipelineHelper<P_OUT> helper;
    protected K leftChild;
    private R localResult;
    protected K rightChild;
    protected java8.util.Spliterator<P_IN> spliterator;
    protected long targetSize;

    protected abstract R doLeaf();

    protected abstract K makeChild(java8.util.Spliterator<P_IN> spliterator);

    protected AbstractTask(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
        super(null);
        this.helper = pipelineHelper;
        this.spliterator = spliterator;
        this.targetSize = 0L;
    }

    protected AbstractTask(K k, java8.util.Spliterator<P_IN> spliterator) {
        super(k);
        this.spliterator = spliterator;
        this.helper = k.helper;
        this.targetSize = k.targetSize;
    }

    public static int getLeafTarget() {
        java.lang.Thread threadCurrentThread = java.lang.Thread.currentThread();
        if (threadCurrentThread instanceof java8.util.concurrent.ForkJoinWorkerThread) {
            return ((java8.util.concurrent.ForkJoinWorkerThread) threadCurrentThread).getPool().getParallelism() << 2;
        }
        return LEAF_TARGET;
    }

    public static long suggestTargetSize(long j) {
        long leafTarget = j / ((long) getLeafTarget());
        if (leafTarget > 0) {
            return leafTarget;
        }
        return 1L;
    }

    protected final long getTargetSize(long j) {
        long j2 = this.targetSize;
        if (j2 != 0) {
            return j2;
        }
        long jSuggestTargetSize = suggestTargetSize(j);
        this.targetSize = jSuggestTargetSize;
        return jSuggestTargetSize;
    }

    @Override // java8.util.concurrent.CountedCompleter, java8.util.concurrent.ForkJoinTask
    public R getRawResult() {
        return this.localResult;
    }

    @Override // java8.util.concurrent.CountedCompleter, java8.util.concurrent.ForkJoinTask
    protected void setRawResult(R r) {
        if (r != null) {
            throw new java.lang.IllegalStateException();
        }
    }

    protected R getLocalResult() {
        return this.localResult;
    }

    protected void setLocalResult(R r) {
        this.localResult = r;
    }

    protected boolean isLeaf() {
        return this.leftChild == null;
    }

    protected boolean isRoot() {
        return getParent() == null;
    }

    protected K getParent() {
        return (K) getCompleter();
    }

    @Override // java8.util.concurrent.CountedCompleter
    public void compute() {
        java8.util.Spliterator<P_IN> spliteratorTrySplit;
        java8.util.Spliterator<P_IN> spliterator = this.spliterator;
        long jEstimateSize = spliterator.estimateSize();
        long targetSize = getTargetSize(jEstimateSize);
        boolean z = false;
        java8.util.stream.AbstractTask<P_IN, P_OUT, R, K> abstractTask = this;
        while (jEstimateSize > targetSize && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            java8.util.stream.AbstractTask<P_IN, P_OUT, R, K> abstractTaskMakeChild = abstractTask.makeChild(spliteratorTrySplit);
            abstractTask.leftChild = abstractTaskMakeChild;
            java8.util.stream.AbstractTask<P_IN, P_OUT, R, K> abstractTaskMakeChild2 = abstractTask.makeChild(spliterator);
            abstractTask.rightChild = abstractTaskMakeChild2;
            abstractTask.setPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
                abstractTask = abstractTaskMakeChild;
                abstractTaskMakeChild = abstractTaskMakeChild2;
            } else {
                abstractTask = abstractTaskMakeChild2;
            }
            z = !z;
            abstractTaskMakeChild.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        abstractTask.setLocalResult(abstractTask.doLeaf());
        abstractTask.tryComplete();
    }

    @Override // java8.util.concurrent.CountedCompleter
    public void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
        this.spliterator = null;
        this.rightChild = null;
        this.leftChild = null;
    }

    protected boolean isLeftmostNode() {
        java8.util.stream.AbstractTask<P_IN, P_OUT, R, K> abstractTask = this;
        while (abstractTask != null) {
            java8.util.stream.AbstractTask<P_IN, P_OUT, R, K> parent = abstractTask.getParent();
            if (parent != null && parent.leftChild != abstractTask) {
                return false;
            }
            abstractTask = parent;
        }
        return true;
    }
}
