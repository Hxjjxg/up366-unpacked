package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class PipelineHelper<P_OUT> {
    abstract <P_IN> void copyInto(java8.util.stream.Sink<P_IN> sink, java8.util.Spliterator<P_IN> spliterator);

    abstract <P_IN> boolean copyIntoWithCancel(java8.util.stream.Sink<P_IN> sink, java8.util.Spliterator<P_IN> spliterator);

    abstract <P_IN> java8.util.stream.Node<P_OUT> evaluate(java8.util.Spliterator<P_IN> spliterator, boolean z, java8.util.function.IntFunction<P_OUT[]> intFunction);

    abstract <P_IN> long exactOutputSizeIfKnown(java8.util.Spliterator<P_IN> spliterator);

    abstract java8.util.stream.StreamShape getSourceShape();

    abstract int getStreamAndOpFlags();

    abstract java8.util.stream.Node.Builder<P_OUT> makeNodeBuilder(long j, java8.util.function.IntFunction<P_OUT[]> intFunction);

    abstract <P_IN, S extends java8.util.function.Consumer<P_OUT>> S wrapAndCopyInto(S s, java8.util.Spliterator<P_IN> spliterator);

    abstract <P_IN, S extends java8.util.stream.Sink<P_OUT>> S wrapAndCopyInto(S s, java8.util.Spliterator<P_IN> spliterator);

    abstract <P_IN> java8.util.stream.Sink<P_IN> wrapSink(java8.util.function.Consumer<P_OUT> consumer);

    abstract <P_IN> java8.util.stream.Sink<P_IN> wrapSink(java8.util.stream.Sink<P_OUT> sink);

    abstract <P_IN> java8.util.Spliterator<P_OUT> wrapSpliterator(java8.util.Spliterator<P_IN> spliterator);

    PipelineHelper() {
    }
}
