package com.up366.asecengine.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JsonToColorHtml {
    public java.lang.String parse(java.lang.String str) {
        try {
            com.alibaba.fastjson.JSONArray<com.alibaba.fastjson.JSONObject> jSONArray = com.alibaba.fastjson.JSON.parseObject(str).getJSONArray("sentences");
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            for (com.alibaba.fastjson.JSONObject jSONObject : jSONArray) {
                byte[] bytes = jSONObject.getString("text").getBytes("GBK");
                int i = 0;
                for (com.alibaba.fastjson.JSONObject jSONObject2 : jSONObject.getJSONArray("words")) {
                    byte[] bytes2 = jSONObject2.getString(com.igexin.sdk.FlymePushReceiver.CONTENT).getBytes("GBK");
                    int intValue = jSONObject2.getIntValue("start");
                    int intValue2 = jSONObject2.getIntValue("length");
                    float floatValue = jSONObject2.getFloatValue("score");
                    byteArrayOutputStream.write(bytes, i, intValue - i);
                    buildColorWord(byteArrayOutputStream, "GBK", bytes2, intValue2, floatValue);
                    i = intValue + intValue2;
                }
                byteArrayOutputStream.write(bytes, i, bytes.length - i);
            }
            return new java.lang.String(byteArrayOutputStream.toByteArray(), "GBK");
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - 2019/4/4 - AsecSession - getHtmlResult - ", e);
            return "";
        }
    }

    protected void buildColorWord(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str, byte[] bArr, int i, float f) throws java.io.IOException {
        byteArrayOutputStream.write(getScoreColor(f).getBytes(str));
        byteArrayOutputStream.write(bArr, 0, i);
        byteArrayOutputStream.write("</span>".getBytes(str));
    }

    protected java.lang.String getScoreColor(float f) {
        if (f < 60.0f) {
            return "<span style=\"color:red;\">";
        }
        if (f < 80.0f) {
            return "<span style=\"color:black;\">";
        }
        return "<span style=\"color:green;\">";
    }
}
