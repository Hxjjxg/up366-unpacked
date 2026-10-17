package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CookieManager implements okhttp3.CookieJar {
    private static final java.util.Map<java.lang.String, okhttp3.Cookie> cookieMap = new java.util.concurrent.ConcurrentHashMap();

    public void saveFromResponse(okhttp3.HttpUrl httpUrl, java.util.List<okhttp3.Cookie> list) {
        java.util.Iterator<okhttp3.Cookie> it = list.iterator();
        while (it.hasNext()) {
            addCookie(httpUrl.host(), it.next());
        }
    }

    public java.util.List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, okhttp3.Cookie>> it = cookieMap.entrySet().iterator();
        while (it.hasNext()) {
            okhttp3.Cookie value = it.next().getValue();
            if (value.matches(httpUrl)) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public void clear() {
        cookieMap.clear();
    }

    public void clear(java.lang.String str) {
        okhttp3.HttpUrl httpUrl = okhttp3.HttpUrl.parse(str);
        if (httpUrl == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, okhttp3.Cookie> entry : cookieMap.entrySet()) {
            if (entry.getValue().matches(httpUrl)) {
                cookieMap.remove(entry.getKey());
            }
        }
    }

    public void addCookie(java.lang.String str, okhttp3.Cookie cookie) {
        cookieMap.put(cookie.name() + str + cookie.path(), cookie);
    }
}
