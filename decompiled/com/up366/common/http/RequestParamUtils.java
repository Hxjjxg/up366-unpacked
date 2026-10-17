package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RequestParamUtils {
    public static java.lang.String encodeStringParts(java.util.Map<java.lang.String, java.lang.String> map) {
        return encodeStringParts("UTF-8", map);
    }

    public static java.lang.String encodeStringParts(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            for (java.lang.String str2 : map.keySet()) {
                arrayList.add(str2 + "=" + java.net.URLEncoder.encode(map.get(str2), str));
            }
        } catch (java.io.UnsupportedEncodingException e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
        }
        return com.up366.common.StringUtils.join(arrayList.toArray(), "&");
    }
}
