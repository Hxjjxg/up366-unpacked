package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0056m {
    private void a() {
    }

    private void a(com.chuanglan.shanyan_sdk.C0062s c0062s) {
    }

    public abstract void a(java.lang.String str, java.lang.String str2);

    protected abstract void a(byte[] bArr);

    public void a(java.net.HttpURLConnection httpURLConnection) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 300) {
                        a(new com.chuanglan.shanyan_sdk.C0062s(httpURLConnection.getContentType(), httpURLConnection.getContentLength()));
                        bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            a(a(bufferedInputStream));
                            bufferedInputStream2 = bufferedInputStream;
                        } catch (java.lang.Exception e) {
                            e = e;
                            bufferedInputStream2 = bufferedInputStream;
                            a(e.toString(), e.getClass().getSimpleName());
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            a();
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            a();
                            throw th;
                        }
                    } else {
                        a(responseCode + "", responseCode + "");
                    }
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
            } catch (java.lang.Exception e4) {
                e = e4;
            }
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            a();
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    public void a(javax.net.ssl.HttpsURLConnection httpsURLConnection) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                try {
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 300) {
                        a(new com.chuanglan.shanyan_sdk.C0062s(httpsURLConnection.getContentType(), httpsURLConnection.getContentLength()));
                        bufferedInputStream = new java.io.BufferedInputStream(httpsURLConnection.getInputStream());
                        try {
                            a(a(bufferedInputStream));
                            bufferedInputStream2 = bufferedInputStream;
                        } catch (java.io.IOException e) {
                            e = e;
                            bufferedInputStream2 = bufferedInputStream;
                            a(e.toString(), e.getClass().getSimpleName());
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            a();
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            a();
                            throw th;
                        }
                    } else {
                        a("Bad Response Code" + responseCode, responseCode + "");
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
            }
            a();
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    private byte[] a(java.io.InputStream inputStream) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[io.objectbox.model.PropertyFlags.INDEX_HASH];
            while (true) {
                int i = inputStream.read(bArr, 0, io.objectbox.model.PropertyFlags.INDEX_HASH);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e3) {
            e = e3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            e.printStackTrace();
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                }
            }
            byteArrayOutputStream = byteArrayOutputStream2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                } catch (java.lang.Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
