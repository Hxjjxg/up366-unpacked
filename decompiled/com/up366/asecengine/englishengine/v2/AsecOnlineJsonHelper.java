package com.up366.asecengine.englishengine.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class AsecOnlineJsonHelper {
    private AsecOnlineJsonHelper() {
    }

    public static com.alibaba.fastjson.JSONObject parseObject(java.lang.String str) {
        return com.alibaba.fastjson.JSON.parseObject(str);
    }

    public static com.alibaba.fastjson.JSONObject cloneObject(com.alibaba.fastjson.JSONObject jSONObject) {
        return jSONObject == null ? new com.alibaba.fastjson.JSONObject() : com.alibaba.fastjson.JSON.parseObject(jSONObject.toJSONString());
    }

    static com.alibaba.fastjson.JSONObject normalizeObjectField(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null) {
            jSONObject = new com.alibaba.fastjson.JSONObject();
        }
        coerceJsonField(jSONObject, str);
        return jSONObject;
    }

    static com.alibaba.fastjson.JSONObject buildPingFrame(long j, java.lang.String str, java.lang.String str2) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        put(jSONObject, "command", "ping");
        putRequestId(jSONObject, str);
        put(jSONObject, "connection_id", str2);
        put(jSONObject, "timestamp", java.lang.Long.valueOf(j));
        return jSONObject;
    }

    static com.alibaba.fastjson.JSONObject buildControlFrame(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str2, java.lang.String str3) {
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        put(jSONObject2, "command", "control");
        if (str3 != null && str3.length() > 0) {
            put(jSONObject2, "connection_id", str3);
        }
        put(jSONObject2, "type", str);
        putRequestId(jSONObject2, str2);
        put(jSONObject2, "req", jSONObject);
        return jSONObject2;
    }

    static com.alibaba.fastjson.JSONObject buildDisconnectFrame(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        put(jSONObject, "connection_id", str2);
        return buildControlFrame(str, jSONObject, str3, str2);
    }

    static void putIfMissing(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) {
        if (jSONObject == null || jSONObject.containsKey(str)) {
            return;
        }
        put(jSONObject, str, obj);
    }

    static void put(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, java.lang.Object obj) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.put(str, obj);
    }

    static com.alibaba.fastjson.JSONObject optObject(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject != null) {
            return jSONObject.getJSONObject(str);
        }
        return null;
    }

    static int optInt(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, int i) {
        if (jSONObject != null && str != null && jSONObject.containsKey(str)) {
            java.lang.Object obj = jSONObject.get(str);
            if (obj instanceof java.lang.Number) {
                return ((java.lang.Number) obj).intValue();
            }
            if (obj != null) {
                try {
                    return java.lang.Integer.parseInt(java.lang.String.valueOf(obj));
                } catch (java.lang.Exception unused) {
                }
            }
        }
        return i;
    }

    static long optLong(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str, long j) {
        if (jSONObject != null && str != null && jSONObject.containsKey(str)) {
            java.lang.Object obj = jSONObject.get(str);
            if (obj instanceof java.lang.Number) {
                return ((java.lang.Number) obj).longValue();
            }
            if (obj != null) {
                try {
                    return java.lang.Long.parseLong(java.lang.String.valueOf(obj));
                } catch (java.lang.Exception unused) {
                }
            }
        }
        return j;
    }

    static java.lang.String optString(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        java.lang.Object obj;
        if (jSONObject == null || str == null || !jSONObject.containsKey(str) || (obj = jSONObject.get(str)) == null) {
            return null;
        }
        java.lang.String strValueOf = java.lang.String.valueOf(obj);
        if (strValueOf.length() == 0 || com.igexin.push.core.b.m.equals(strValueOf)) {
            return null;
        }
        return strValueOf;
    }

    static java.lang.String resolveRequestId(com.alibaba.fastjson.JSONObject jSONObject) {
        return optString(jSONObject, "request_id");
    }

    static java.lang.String resolveMessageType(com.alibaba.fastjson.JSONObject jSONObject) {
        return optString(jSONObject, "type");
    }

    static java.lang.String resolveMessage(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        return firstNonEmpty(optString(jSONObject, "message"), optString(jSONObject, "msg"), str);
    }

    static java.lang.String valueOrDash(java.lang.String str) {
        return (str == null || str.length() <= 0) ? "-" : str;
    }

    static java.lang.String firstNonEmpty(java.lang.String... strArr) {
        if (strArr == null) {
            return null;
        }
        for (java.lang.String str : strArr) {
            if (str != null && str.length() > 0) {
                return str;
            }
        }
        return null;
    }

    private static void putRequestId(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        put(jSONObject, "request_id", com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.requireRequestId(str));
    }

    private static void coerceJsonField(com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null || str == null || !jSONObject.containsKey(str)) {
            return;
        }
        java.lang.Object obj = jSONObject.get(str);
        if (obj instanceof java.lang.String) {
            java.lang.Object compatibleValue = parseCompatibleValue((java.lang.String) obj);
            if ((compatibleValue instanceof com.alibaba.fastjson.JSONObject) || (compatibleValue instanceof com.alibaba.fastjson.JSONArray)) {
                put(jSONObject, str, compatibleValue);
            }
        }
    }

    private static java.lang.Object parseCompatibleValue(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String strTrim = str.trim();
        if (strTrim.startsWith("{") && strTrim.endsWith("}")) {
            try {
                return com.alibaba.fastjson.JSON.parseObject(strTrim);
            } catch (java.lang.Exception unused) {
            }
        }
        if (!strTrim.startsWith("[") || !strTrim.endsWith("]")) {
            return str;
        }
        try {
            return com.alibaba.fastjson.JSON.parseArray(strTrim);
        } catch (java.lang.Exception unused2) {
            return str;
        }
    }
}
