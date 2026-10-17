package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LaunchOptionsHelper {
    public com.alibaba.fastjson.JSONObject getLaunchOptions(com.up366.mobile.book.StudyActivityInterface studyActivityInterface, java.lang.String str) {
        java.lang.String string;
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = studyActivityInterface.getOpenConfigInfo();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(openConfigInfo.exerciseData);
        if (object == null) {
            object = new com.alibaba.fastjson.JSONObject();
        }
        com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(openConfigInfo.commonParams);
        if (object2 != null) {
            object.putAll(object2);
            string = object2.getString("qrCode");
        } else {
            string = null;
        }
        if (!object.containsKey("fileId")) {
            object.put("fileId", com.up366.mobile.book.helper.Tools.getMainFileIdFromCfg(openConfigInfo));
        }
        if (!object.containsKey("baseInfo")) {
            object.put("baseInfo", com.up366.mobile.book.helper.Tools.getSimpleTreeInfoByCfg(openConfigInfo));
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("qrCode", string);
        jSONObject.put("extraData", object);
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("referrerInfo", jSONObject);
        com.up366.common.log.Logger.debug("LaunchOptions - " + jSONObject2);
        return jSONObject2;
    }
}
