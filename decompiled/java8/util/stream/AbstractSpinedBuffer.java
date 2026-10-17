package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
abstract class AbstractSpinedBuffer {
    public static final int MAX_CHUNK_POWER = 30;
    public static final int MIN_CHUNK_POWER = 4;
    public static final int MIN_CHUNK_SIZE = 16;
    public static final int MIN_SPINE_SIZE = 8;
    protected int elementIndex;
    protected final int initialChunkPower;
    protected long[] priorElementCount;
    protected int spineIndex;

    public abstract void clear();

    protected AbstractSpinedBuffer() {
        this.initialChunkPower = 4;
    }

    protected AbstractSpinedBuffer(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Illegal Capacity: " + i);
        }
        this.initialChunkPower = java.lang.Math.max(4, 32 - java.lang.Integer.numberOfLeadingZeros(i - 1));
    }

    public boolean isEmpty() {
        return this.spineIndex == 0 && this.elementIndex == 0;
    }

    public long count() {
        int i = this.spineIndex;
        return i == 0 ? this.elementIndex : this.priorElementCount[i] + ((long) this.elementIndex);
    }

    protected int chunkSize(int i) {
        int iMin;
        if (i == 0 || i == 1) {
            iMin = this.initialChunkPower;
        } else {
            iMin = java.lang.Math.min((this.initialChunkPower + i) - 1, 30);
        }
        return 1 << iMin;
    }
}
