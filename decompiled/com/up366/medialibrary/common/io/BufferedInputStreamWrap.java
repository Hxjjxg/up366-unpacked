package com.up366.medialibrary.common.io;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BufferedInputStreamWrap extends java.io.FilterInputStream {
    public static final int DEFAULT_MARK_READ_LIMIT = 5242880;
    private volatile byte[] buf;
    private int count;
    private int markLimit;
    private int markPos;
    private int pos;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public BufferedInputStreamWrap(java.io.InputStream inputStream) {
        this(inputStream, 65536);
    }

    BufferedInputStreamWrap(java.io.InputStream inputStream, int i) {
        super(inputStream);
        this.markPos = -1;
        this.buf = com.up366.medialibrary.common.io.ArrayPoolProvide.getInstance().get(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws java.io.IOException {
        java.io.InputStream inputStream = this.in;
        if (this.buf != null && inputStream != null) {
            return (this.count - this.pos) + inputStream.available();
        }
        return 0;
    }

    private static java.io.IOException streamClosed() throws java.io.IOException {
        throw new java.io.IOException("BufferedInputStream is closed");
    }

    public synchronized void fixMarkLimit() {
        this.markLimit = this.buf.length;
    }

    public synchronized void release() {
        if (this.buf != null) {
            com.up366.medialibrary.common.io.ArrayPoolProvide.getInstance().put(this.buf);
            this.buf = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.buf != null) {
            com.up366.medialibrary.common.io.ArrayPoolProvide.getInstance().put(this.buf);
            this.buf = null;
        }
        java.io.InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int fillbuf(java.io.InputStream inputStream, byte[] bArr) throws java.io.IOException {
        int i = this.markPos;
        if (i != -1) {
            int i2 = this.pos - i;
            int i3 = this.markLimit;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = com.up366.medialibrary.common.io.ArrayPoolProvide.getInstance().get(i3);
                    java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.buf = bArr2;
                    com.up366.medialibrary.common.io.ArrayPoolProvide.getInstance().put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    java.lang.System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.pos - this.markPos;
                this.pos = i4;
                this.markPos = 0;
                this.count = 0;
                int i5 = inputStream.read(bArr, i4, bArr.length - i4);
                int i6 = this.pos;
                if (i5 > 0) {
                    i6 += i5;
                }
                this.count = i6;
                return i5;
            }
        }
        int i7 = inputStream.read(bArr);
        if (i7 > 0) {
            this.markPos = -1;
            this.pos = 0;
            this.count = i7;
        }
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.markLimit = java.lang.Math.max(this.markLimit, i);
        this.markPos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws java.io.IOException {
        byte[] bArr = this.buf;
        java.io.InputStream inputStream = this.in;
        if (bArr == null || inputStream == null) {
            throw streamClosed();
        }
        if (this.pos >= this.count && fillbuf(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.buf && (bArr = this.buf) == null) {
            throw streamClosed();
        }
        int i = this.count;
        int i2 = this.pos;
        if (i - i2 <= 0) {
            return -1;
        }
        this.pos = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        int iMin;
        byte[] bArr2 = this.buf;
        if (bArr2 == null) {
            throw streamClosed();
        }
        if (i2 == 0) {
            return 0;
        }
        java.io.InputStream inputStream = this.in;
        if (inputStream == null) {
            throw streamClosed();
        }
        int i4 = this.pos;
        int i5 = this.count;
        if (i4 < i5) {
            int iMin2 = java.lang.Math.min(i5 - i4, i2);
            java.lang.System.arraycopy(bArr2, this.pos, bArr, i, iMin2);
            this.pos += iMin2;
            if (iMin2 == i2 || inputStream.available() == 0) {
                return iMin2;
            }
            i += iMin2;
            i3 = i2 - iMin2;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.markPos == -1 && i3 >= bArr2.length) {
                iMin = inputStream.read(bArr, i, i3);
                if (iMin == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else {
                if (fillbuf(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
                if (bArr2 != this.buf && (bArr2 = this.buf) == null) {
                    throw streamClosed();
                }
                iMin = java.lang.Math.min(this.count - this.pos, i3);
                java.lang.System.arraycopy(bArr2, this.pos, bArr, i, iMin);
                this.pos += iMin;
            }
            i3 -= iMin;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += iMin;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws java.io.IOException {
        if (this.buf == null) {
            throw new java.io.IOException("Stream is closed");
        }
        int i = this.markPos;
        if (-1 == i) {
            throw new com.up366.medialibrary.common.io.BufferedInputStreamWrap.InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.markLimit);
        }
        this.pos = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws java.io.IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.buf;
        if (bArr == null) {
            throw streamClosed();
        }
        java.io.InputStream inputStream = this.in;
        if (inputStream == null) {
            throw streamClosed();
        }
        int i = this.count;
        int i2 = this.pos;
        if (i - i2 >= j) {
            this.pos = (int) (((long) i2) + j);
            return j;
        }
        long j2 = ((long) i) - ((long) i2);
        this.pos = i;
        if (this.markPos != -1 && j <= this.markLimit) {
            if (fillbuf(inputStream, bArr) == -1) {
                return j2;
            }
            int i3 = this.count;
            int i4 = this.pos;
            if (i3 - i4 >= j - j2) {
                this.pos = (int) ((((long) i4) + j) - j2);
                return j;
            }
            long j3 = (j2 + ((long) i3)) - ((long) i4);
            this.pos = i3;
            return j3;
        }
        return j2 + inputStream.skip(j - j2);
    }

    static class InvalidMarkException extends java.io.IOException {
        private static final long serialVersionUID = -4338378848813561759L;

        InvalidMarkException(java.lang.String str) {
            super(str);
        }
    }
}
