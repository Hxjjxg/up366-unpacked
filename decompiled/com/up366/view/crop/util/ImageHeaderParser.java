package com.up366.view.crop.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ImageHeaderParser {
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final java.lang.String TAG = "ImageHeaderParser";
    public static final int UNKNOWN_ORIENTATION = -1;
    private final com.up366.view.crop.util.ImageHeaderParser.Reader reader;
    private static final java.lang.String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(java.nio.charset.Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private interface Reader {
        int getUInt16() throws java.io.IOException;

        short getUInt8() throws java.io.IOException;

        int read(byte[] bArr, int i) throws java.io.IOException;

        long skip(long j) throws java.io.IOException;
    }

    private static int calcTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    public ImageHeaderParser(java.io.InputStream inputStream) {
        this.reader = new com.up366.view.crop.util.ImageHeaderParser.StreamReader(inputStream);
    }

    public int getOrientation() throws java.io.IOException {
        int uInt16 = this.reader.getUInt16();
        if (!handles(uInt16)) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Parser doesn't handle magic number: " + uInt16);
            }
            return -1;
        }
        int iMoveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength();
        if (iMoveToExifSegmentAndGetLength == -1) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        return parseExifSegment(new byte[iMoveToExifSegmentAndGetLength], iMoveToExifSegmentAndGetLength);
    }

    private int parseExifSegment(byte[] bArr, int i) throws java.io.IOException {
        int i2 = this.reader.read(bArr, i);
        if (i2 != i) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + i2);
            }
            return -1;
        }
        if (hasJpegExifPreamble(bArr, i)) {
            return parseExifSegment(new com.up366.view.crop.util.ImageHeaderParser.RandomAccessReader(bArr, i));
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            android.util.Log.d(TAG, "Missing jpeg exif preamble");
        }
        return -1;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        boolean z = bArr != null && i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength() throws java.io.IOException {
        short uInt8;
        int uInt16;
        long j;
        long jSkip;
        do {
            short uInt82 = this.reader.getUInt8();
            if (uInt82 != SEGMENT_START_ID) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    android.util.Log.d(TAG, "Unknown segmentId=" + ((int) uInt82));
                }
                return -1;
            }
            uInt8 = this.reader.getUInt8();
            if (uInt8 == SEGMENT_SOS) {
                return -1;
            }
            if (uInt8 == MARKER_EOI) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    android.util.Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = this.reader.getUInt16() - 2;
            if (uInt8 == EXIF_SEGMENT_TYPE) {
                return uInt16;
            }
            j = uInt16;
            jSkip = this.reader.skip(j);
        } while (jSkip == j);
        if (android.util.Log.isLoggable(TAG, 3)) {
            android.util.Log.d(TAG, "Unable to skip enough data, type: " + ((int) uInt8) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int parseExifSegment(com.up366.view.crop.util.ImageHeaderParser.RandomAccessReader randomAccessReader) {
        java.nio.ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == MOTOROLA_TIFF_MAGIC_NUMBER) {
            byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        } else if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        } else {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Unknown endianness = " + ((int) int16));
            }
            byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i = 0; i < int162; i++) {
            int iCalcTagOffset = calcTagOffset(int32, i);
            short int163 = randomAccessReader.getInt16(iCalcTagOffset);
            if (int163 == ORIENTATION_TAG_TYPE) {
                short int164 = randomAccessReader.getInt16(iCalcTagOffset + 2);
                if (int164 < 1 || int164 > 12) {
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        android.util.Log.d(TAG, "Got invalid format code = " + ((int) int164));
                    }
                } else {
                    int int322 = randomAccessReader.getInt32(iCalcTagOffset + 4);
                    if (int322 < 0) {
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            android.util.Log.d(TAG, "Negative tiff component count");
                        }
                    } else {
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            android.util.Log.d(TAG, "Got tagIndex=" + i + " tagType=" + ((int) int163) + " formatCode=" + ((int) int164) + " componentCount=" + int322);
                        }
                        int i2 = int322 + BYTES_PER_FORMAT[int164];
                        if (i2 > 4) {
                            if (android.util.Log.isLoggable(TAG, 3)) {
                                android.util.Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) int164));
                            }
                        } else {
                            int i3 = iCalcTagOffset + 8;
                            if (i3 < 0 || i3 > randomAccessReader.length()) {
                                if (android.util.Log.isLoggable(TAG, 3)) {
                                    android.util.Log.d(TAG, "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) int163));
                                }
                            } else if (i2 < 0 || i2 + i3 > randomAccessReader.length()) {
                                if (android.util.Log.isLoggable(TAG, 3)) {
                                    android.util.Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + ((int) int163));
                                }
                            } else {
                                return randomAccessReader.getInt16(i3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static class RandomAccessReader {
        private final java.nio.ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i) {
            this.data = (java.nio.ByteBuffer) java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.BIG_ENDIAN).limit(i);
        }

        public void order(java.nio.ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }

        public int length() {
            return this.data.remaining();
        }

        public int getInt32(int i) {
            return this.data.getInt(i);
        }

        public short getInt16(int i) {
            return this.data.getShort(i);
        }
    }

    private static class StreamReader implements com.up366.view.crop.util.ImageHeaderParser.Reader {
        private final java.io.InputStream is;

        public StreamReader(java.io.InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.up366.view.crop.util.ImageHeaderParser.Reader
        public int getUInt16() throws java.io.IOException {
            return ((this.is.read() << 8) & 65280) | (this.is.read() & com.up366.view.crop.util.ImageHeaderParser.SEGMENT_START_ID);
        }

        @Override // com.up366.view.crop.util.ImageHeaderParser.Reader
        public short getUInt8() throws java.io.IOException {
            return (short) (this.is.read() & com.up366.view.crop.util.ImageHeaderParser.SEGMENT_START_ID);
        }

        @Override // com.up366.view.crop.util.ImageHeaderParser.Reader
        public long skip(long j) throws java.io.IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.is.skip(j2);
                if (jSkip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        @Override // com.up366.view.crop.util.ImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws java.io.IOException {
            int i2 = i;
            while (i2 > 0) {
                int i3 = this.is.read(bArr, i - i2, i2);
                if (i3 == -1) {
                    break;
                }
                i2 -= i3;
            }
            return i - i2;
        }
    }

    public static void copyExif(android.media.ExifInterface exifInterface, int i, int i2, java.lang.String str) {
        java.lang.String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            android.media.ExifInterface exifInterface2 = new android.media.ExifInterface(str);
            for (int i3 = 0; i3 < 21; i3++) {
                java.lang.String str2 = strArr[i3];
                java.lang.String attribute = exifInterface.getAttribute(str2);
                if (!android.text.TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute("ImageWidth", java.lang.String.valueOf(i));
            exifInterface2.setAttribute("ImageLength", java.lang.String.valueOf(i2));
            exifInterface2.setAttribute("Orientation", "0");
            exifInterface2.saveAttributes();
        } catch (java.io.IOException e) {
            android.util.Log.d(TAG, e.getMessage());
        }
    }
}
