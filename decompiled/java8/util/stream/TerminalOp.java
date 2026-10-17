package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
interface TerminalOp<E_IN, R> {
    <P_IN> R evaluateParallel(java8.util.stream.PipelineHelper<E_IN> pipelineHelper, java8.util.Spliterator<P_IN> spliterator);

    <P_IN> R evaluateSequential(java8.util.stream.PipelineHelper<E_IN> pipelineHelper, java8.util.Spliterator<P_IN> spliterator);

    int getOpFlags();

    java8.util.stream.StreamShape inputShape();
}
