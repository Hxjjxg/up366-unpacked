package com.up366.medialibrary.common.compress;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
enum Checker {
    SINGLE;

    private static final java.lang.String JPG = ".jpg";
    public static final java.lang.String MIME_TYPE_HEIC = "image/heic";
    public static final java.lang.String MIME_TYPE_JPEG = "image/jpeg";
    public static final java.lang.String MIME_TYPE_JPG = "image/jpg";
    private static final java.lang.String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE = {-1, -40, -1};

    Checker() {
    }

    boolean isJPG(java.io.InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    boolean isJPG(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(MIME_TYPE_HEIC) || str.startsWith("image/jpeg") || str.startsWith(MIME_TYPE_JPG);
    }

    int getOrientation(java.io.InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return java.util.Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
    
        android.util.Log.e(com.up366.medialibrary.common.compress.Checker.TAG, "Invalid length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        r9 = 0;
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getOrientation(byte[] r12) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.common.compress.Checker.getOrientation(byte[]):int");
    }

    java.lang.String extSuffix(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        try {
            return str.replace(str.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO) ? "video/" : "image/", ".");
        } catch (java.lang.Exception unused) {
            return ".jpg";
        }
    }

    boolean needCompress(int i, java.lang.String str) {
        if (i <= 0) {
            return true;
        }
        java.io.File file = new java.io.File(str);
        return file.exists() && file.length() > ((long) (i << 10));
    }

    boolean needCompressToLocalMedia(int i, java.lang.String str) {
        if (i <= 0 || android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        java.io.File file = new java.io.File(str);
        return file.exists() && file.length() > ((long) (i << 10));
    }

    private int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    private byte[] toByteArray(java.io.InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr, 0, 4096);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        try {
                            break;
                        } catch (java.io.IOException unused) {
                        }
                    }
                } finally {
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
            } catch (java.lang.Exception unused3) {
                byte[] bArr2 = new byte[0];
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException unused4) {
                }
                return bArr2;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
