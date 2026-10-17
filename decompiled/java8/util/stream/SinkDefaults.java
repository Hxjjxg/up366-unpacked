package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class SinkDefaults {

    static final class OfInt {
        static void accept(java8.util.stream.Sink.OfInt ofInt, java.lang.Integer num) {
            ofInt.accept(num.intValue());
        }

        private OfInt() {
        }
    }

    static final class OfLong {
        static void accept(java8.util.stream.Sink.OfLong ofLong, java.lang.Long l) {
            ofLong.accept(l.longValue());
        }

        private OfLong() {
        }
    }

    static final class OfDouble {
        static void accept(java8.util.stream.Sink.OfDouble ofDouble, java.lang.Double d) {
            ofDouble.accept(d.doubleValue());
        }

        private OfDouble() {
        }
    }

    static <T> void reject() {
        throw new java.lang.IllegalStateException("called wrong accept method");
    }

    private SinkDefaults() {
    }
}
