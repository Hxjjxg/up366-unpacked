package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class EncryptInterceptor implements okhttp3.Interceptor {
    public static final java.lang.String ENC_HEADER_KEY = "sb";
    static final int TYPE_DECRYPT = 1;
    static final int TYPE_ENCRYPT = 0;
    int type;

    public EncryptInterceptor(int i) {
        this.type = i;
    }

    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.Request request = chain.request();
        okhttp3.Request.Builder builderNewBuilder = request.newBuilder();
        if (this.type == 0) {
            okhttp3.RequestBody requestBodyBody = request.body();
            okio.Buffer buffer = new okio.Buffer();
            int[] keyVersion = parseKeyVersion(request.header(ENC_HEADER_KEY));
            int i = keyVersion[0];
            int i2 = keyVersion[1];
            if (requestBodyBody != null && i == 1) {
                requestBodyBody.writeTo(buffer);
                byte[] byteArray = buffer.buffer().readByteArray();
                edmm(i2, byteArray);
                final byte[] bArrEncode = android.util.Base64.encode(byteArray, 11);
                builderNewBuilder.header("Content-Length", java.lang.Long.toString(bArrEncode.length));
                builderNewBuilder.post(new okhttp3.RequestBody() { // from class: com.up366.common.http.EncryptInterceptor.1
                    public okhttp3.MediaType contentType() {
                        return null;
                    }

                    public long contentLength() {
                        return bArrEncode.length;
                    }

                    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
                        bufferedSink.write(bArrEncode);
                    }
                });
            }
            return chain.proceed(builderNewBuilder.build());
        }
        okhttp3.Response responseProceed = chain.proceed(builderNewBuilder.build());
        okhttp3.Response.Builder builderRequest = responseProceed.newBuilder().request(request);
        int[] keyVersion2 = parseKeyVersion(responseProceed.header(ENC_HEADER_KEY));
        int i3 = keyVersion2[0];
        int i4 = keyVersion2[1];
        if (responseProceed.body() != null && i3 == 1) {
            final byte[] bArrBytes = responseProceed.body().bytes();
            edmm(i4, bArrBytes);
            final okio.Buffer buffer2 = new okio.Buffer();
            buffer2.write(bArrBytes, 0, bArrBytes.length);
            builderRequest.body(new okhttp3.ResponseBody() { // from class: com.up366.common.http.EncryptInterceptor.2
                public okhttp3.MediaType contentType() {
                    return null;
                }

                public long contentLength() {
                    return bArrBytes.length;
                }

                public okio.BufferedSource source() {
                    return buffer2;
                }
            });
        }
        return builderRequest.build();
    }

    private void edmm(int i, byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i = ((i + 7) * 13) % 999997;
            bArr[i2] = (byte) (bArr[i2] ^ i);
        }
    }

    public int[] parseKeyVersion(java.lang.String str) {
        int[] iArr = {0, 0};
        if (str != null) {
            try {
                java.lang.String[] strArrSplit = str.split("-");
                if (strArrSplit.length == 2) {
                    iArr[0] = java.lang.Integer.parseInt(strArrSplit[0]);
                    iArr[1] = java.lang.Integer.parseInt(strArrSplit[1]);
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.warn("TAG - EncryptInterceptor - intercept - ", e);
            }
        }
        return iArr;
    }
}
