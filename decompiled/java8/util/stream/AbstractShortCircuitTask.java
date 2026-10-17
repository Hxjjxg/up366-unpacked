package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class AbstractShortCircuitTask<P_IN, P_OUT, R, K extends java8.util.stream.AbstractShortCircuitTask<P_IN, P_OUT, R, K>> extends java8.util.stream.AbstractTask<P_IN, P_OUT, R, K> {
    protected volatile boolean canceled;
    protected final java.util.concurrent.atomic.AtomicReference<R> sharedResult;

    protected abstract R getEmptyResult();

    protected AbstractShortCircuitTask(java8.util.stream.PipelineHelper<P_OUT> pipelineHelper, java8.util.Spliterator<P_IN> spliterator) {
        super(pipelineHelper, spliterator);
        this.sharedResult = new java.util.concurrent.atomic.AtomicReference<>(null);
    }

    protected AbstractShortCircuitTask(K k, java8.util.Spliterator<P_IN> spliterator) {
        super(k, spliterator);
        this.sharedResult = k.sharedResult;
    }

    @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter
    public void compute() {
        R emptyResult;
        java8.util.Spliterator<P_IN> spliteratorTrySplit;
        java8.util.Spliterator<P_IN> spliterator = this.spliterator;
        long jEstimateSize = spliterator.estimateSize();
        long targetSize = getTargetSize(jEstimateSize);
        java.util.concurrent.atomic.AtomicReference<R> atomicReference = this.sharedResult;
        boolean z = false;
        java8.util.stream.AbstractShortCircuitTask<P_IN, P_OUT, R, K> abstractShortCircuitTask = this;
        while (true) {
            emptyResult = atomicReference.get();
            if (emptyResult != null) {
                break;
            }
            if (abstractShortCircuitTask.taskCanceled()) {
                emptyResult = abstractShortCircuitTask.getEmptyResult();
                break;
            }
            if (jEstimateSize <= targetSize || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            K kMakeChild = abstractShortCircuitTask.makeChild(spliteratorTrySplit);
            abstractShortCircuitTask.leftChild = kMakeChild;
            K kMakeChild2 = abstractShortCircuitTask.makeChild(spliterator);
            abstractShortCircuitTask.rightChild = kMakeChild2;
            abstractShortCircuitTask.setPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
                abstractShortCircuitTask = kMakeChild;
                kMakeChild = kMakeChild2;
            } else {
                abstractShortCircuitTask = kMakeChild2;
            }
            z = !z;
            kMakeChild.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        emptyResult = abstractShortCircuitTask.doLeaf();
        abstractShortCircuitTask.setLocalResult(emptyResult);
        abstractShortCircuitTask.tryComplete();
    }

    protected void shortCircuit(R r) {
        if (r != null) {
            androidx.camera.view.PreviewView$1$.ExternalSyntheticBackportWithForwarding0.m(this.sharedResult, (java.lang.Object) null, r);
        }
    }

    @Override // java8.util.stream.AbstractTask
    protected void setLocalResult(R r) {
        if (!isRoot()) {
            super.setLocalResult(r);
        } else if (r != null) {
            androidx.camera.view.PreviewView$1$.ExternalSyntheticBackportWithForwarding0.m(this.sharedResult, (java.lang.Object) null, r);
        }
    }

    @Override // java8.util.stream.AbstractTask, java8.util.concurrent.CountedCompleter, java8.util.concurrent.ForkJoinTask
    public R getRawResult() {
        return getLocalResult();
    }

    @Override // java8.util.stream.AbstractTask
    public R getLocalResult() {
        if (isRoot()) {
            R r = this.sharedResult.get();
            return r == null ? getEmptyResult() : r;
        }
        return (R) super.getLocalResult();
    }

    protected void cancel() {
        this.canceled = true;
    }

    protected boolean taskCanceled() {
        boolean z = this.canceled;
        if (!z) {
            K parent = getParent();
            while (true) {
                java8.util.stream.AbstractShortCircuitTask abstractShortCircuitTask = parent;
                if (z || abstractShortCircuitTask == null) {
                    break;
                }
                z = abstractShortCircuitTask.canceled;
                parent = (K) abstractShortCircuitTask.getParent();
            }
        }
        return z;
    }

    protected void cancelLaterNodes() {
        java8.util.stream.AbstractShortCircuitTask<P_IN, P_OUT, R, K> abstractShortCircuitTask = this;
        for (K parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent.leftChild == abstractShortCircuitTask) {
                java8.util.stream.AbstractShortCircuitTask abstractShortCircuitTask2 = (java8.util.stream.AbstractShortCircuitTask) parent.rightChild;
                if (!abstractShortCircuitTask2.canceled) {
                    abstractShortCircuitTask2.cancel();
                }
            }
            abstractShortCircuitTask = parent;
        }
    }
}
