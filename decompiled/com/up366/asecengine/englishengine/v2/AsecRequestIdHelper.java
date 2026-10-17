package com.up366.asecengine.englishengine.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class AsecRequestIdHelper {
    private static final int MAX_REQUEST_ID = Integer.MAX_VALUE;
    private static final java.util.concurrent.atomic.AtomicInteger REQUEST_COUNTER = new java.util.concurrent.atomic.AtomicInteger(createInitialSeed());
    public static final int REQUEST_ID_BYTES = 4;
    private static final int REQUEST_ID_SEED_SALT = 1380533332;

    private static int normalizeSeed(int i) {
        int i2 = i & Integer.MAX_VALUE;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    private AsecRequestIdHelper() {
    }

    public static java.lang.String newRequestId() {
        return java.lang.Integer.toString(nextRequestIdValue());
    }

    public static java.lang.String normalizeRequestId(java.lang.String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        return java.lang.Integer.toString(parseRequestId(str));
    }

    public static java.lang.String requireRequestId(java.lang.String str) {
        java.lang.String strNormalizeRequestId = normalizeRequestId(str);
        if (strNormalizeRequestId != null) {
            return strNormalizeRequestId;
        }
        throw new java.lang.IllegalArgumentException("requestId is empty");
    }

    public static int parseRequestId(java.lang.String str) {
        if (str == null || str.trim().length() == 0) {
            throw new java.lang.IllegalArgumentException("requestId is empty");
        }
        try {
            int i = java.lang.Integer.parseInt(str.trim());
            if (i > 0) {
                return i;
            }
            throw new java.lang.IllegalArgumentException("requestId must be > 0: " + str);
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalArgumentException("requestId is not positive int32: " + str, e);
        }
    }

    public static java.lang.String appendRequestIdToUrl(java.lang.String str, java.lang.String str2) {
        boolean z;
        java.lang.String strRequireRequestId = requireRequestId(str2);
        if (str == null || str.trim().length() == 0) {
            throw new java.lang.IllegalArgumentException("webSocketUrl is empty");
        }
        java.lang.String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(35);
        java.lang.String strSubstring = iIndexOf >= 0 ? strTrim.substring(iIndexOf) : "";
        boolean z2 = false;
        if (iIndexOf >= 0) {
            strTrim = strTrim.substring(0, iIndexOf);
        }
        int iIndexOf2 = strTrim.indexOf(63);
        if (iIndexOf2 < 0) {
            return strTrim + "?request_id=" + strRequireRequestId + strSubstring;
        }
        java.lang.String strSubstring2 = strTrim.substring(0, iIndexOf2);
        java.lang.String strSubstring3 = strTrim.substring(iIndexOf2 + 1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(strSubstring2);
        sb.append('?');
        if (strSubstring3.length() > 0) {
            z = false;
            boolean z3 = false;
            for (java.lang.String str3 : strSubstring3.split("&")) {
                if (str3 != null && str3.length() != 0) {
                    int iIndexOf3 = str3.indexOf(61);
                    if (!"request_id".equals(iIndexOf3 >= 0 ? str3.substring(0, iIndexOf3) : str3)) {
                        if (z) {
                            sb.append('&');
                        }
                        sb.append(str3);
                        z = true;
                    } else if (!z3) {
                        if (z) {
                            sb.append('&');
                        }
                        sb.append("request_id=");
                        sb.append(strRequireRequestId);
                        z = true;
                        z3 = true;
                    }
                }
            }
            z2 = z3;
        } else {
            z = false;
        }
        if (!z2) {
            if (z) {
                sb.append('&');
            }
            sb.append("request_id=");
            sb.append(strRequireRequestId);
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    private static int nextRequestIdValue() {
        while (true) {
            java.util.concurrent.atomic.AtomicInteger atomicInteger = REQUEST_COUNTER;
            int i = atomicInteger.get();
            int iNormalizeSeed = normalizeSeed(i);
            if (i != iNormalizeSeed) {
                atomicInteger.compareAndSet(i, iNormalizeSeed);
            } else {
                if (atomicInteger.compareAndSet(iNormalizeSeed, iNormalizeSeed >= Integer.MAX_VALUE ? 1 : iNormalizeSeed + 1)) {
                    return iNormalizeSeed;
                }
            }
        }
    }

    private static int createInitialSeed() {
        int iCurrentTimeMillis = (int) ((java.lang.System.currentTimeMillis() ^ java.lang.Long.rotateLeft(java.lang.System.nanoTime(), 17)) ^ 1380533332);
        if (iCurrentTimeMillis == 0) {
            iCurrentTimeMillis = REQUEST_ID_SEED_SALT;
        }
        return normalizeSeed(iCurrentTimeMillis);
    }
}
