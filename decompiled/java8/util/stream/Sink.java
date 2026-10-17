package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
interface Sink<T> extends java8.util.function.Consumer<T> {

    public interface OfDouble extends java8.util.stream.Sink<java.lang.Double>, java8.util.function.DoubleConsumer {
        @Override // java8.util.stream.Sink
        void accept(double d);

        void accept(java.lang.Double d);
    }

    public interface OfInt extends java8.util.stream.Sink<java.lang.Integer>, java8.util.function.IntConsumer {
        @Override // java8.util.stream.Sink
        void accept(int i);

        void accept(java.lang.Integer num);
    }

    public interface OfLong extends java8.util.stream.Sink<java.lang.Long>, java8.util.function.LongConsumer {
        @Override // java8.util.stream.Sink
        void accept(long j);

        void accept(java.lang.Long l);
    }

    void accept(double d);

    void accept(int i);

    void accept(long j);

    void begin(long j);

    boolean cancellationRequested();

    void end();

    public static abstract class ChainedReference<T, E_OUT> implements java8.util.stream.Sink<T> {
        protected final java8.util.stream.Sink<? super E_OUT> downstream;

        public ChainedReference(java8.util.stream.Sink<? super E_OUT> sink) {
            this.downstream = (java8.util.stream.Sink) java8.util.Objects.requireNonNull(sink);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.downstream.begin(j);
        }

        @Override // java8.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
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
    }

    public static abstract class ChainedInt<E_OUT> implements java8.util.stream.Sink.OfInt {
        protected final java8.util.stream.Sink<? super E_OUT> downstream;

        public ChainedInt(java8.util.stream.Sink<? super E_OUT> sink) {
            this.downstream = (java8.util.stream.Sink) java8.util.Objects.requireNonNull(sink);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.downstream.begin(j);
        }

        @Override // java8.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Integer num) {
            java8.util.stream.SinkDefaults.OfInt.accept(this, num);
        }
    }

    public static abstract class ChainedLong<E_OUT> implements java8.util.stream.Sink.OfLong {
        protected final java8.util.stream.Sink<? super E_OUT> downstream;

        public ChainedLong(java8.util.stream.Sink<? super E_OUT> sink) {
            this.downstream = (java8.util.stream.Sink) java8.util.Objects.requireNonNull(sink);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.downstream.begin(j);
        }

        @Override // java8.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Long l) {
            java8.util.stream.SinkDefaults.OfLong.accept(this, l);
        }

        @Override // java8.util.stream.Sink
        public void accept(double d) {
            java8.util.stream.SinkDefaults.reject();
        }
    }

    public static abstract class ChainedDouble<E_OUT> implements java8.util.stream.Sink.OfDouble {
        protected final java8.util.stream.Sink<? super E_OUT> downstream;

        public ChainedDouble(java8.util.stream.Sink<? super E_OUT> sink) {
            this.downstream = (java8.util.stream.Sink) java8.util.Objects.requireNonNull(sink);
        }

        @Override // java8.util.stream.Sink
        public void begin(long j) {
            this.downstream.begin(j);
        }

        @Override // java8.util.stream.Sink
        public void end() {
            this.downstream.end();
        }

        @Override // java8.util.stream.Sink
        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }

        @Override // java8.util.stream.Sink
        public void accept(int i) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.stream.Sink
        public void accept(long j) {
            java8.util.stream.SinkDefaults.reject();
        }

        @Override // java8.util.function.Consumer
        public void accept(java.lang.Double d) {
            java8.util.stream.SinkDefaults.OfDouble.accept(this, d);
        }
    }
}
