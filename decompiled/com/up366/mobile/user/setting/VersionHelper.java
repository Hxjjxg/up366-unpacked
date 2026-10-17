package com.up366.mobile.user.setting;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VersionHelper {
    public static java.lang.String getVersionInfo() {
        try {
            return getXotVersion() + "\n" + getDictVersion() + "\n" + getEngineVersion() + "\n" + getAsesModelVersion();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getVersionInfo error " + e.getMessage(), e);
            return "has error";
        }
    }

    private static java.lang.String getXotVersion() {
        return "Xot : " + com.up366.mobile.book.exercise.ExerciseResourceHelper.getXotVersionName();
    }

    private static java.lang.String getDictVersion() {
        return "DICT : " + com.up366.mobile.book.dict.DictResourceHelper.getDictVersionName();
    }

    private static java.lang.String getEngineVersion() {
        return "ASES : " + new com.up366.asecengine.jni.AsesJni().LsxAsesVersion();
    }

    public static java.lang.String getAsesVersion() {
        try {
            return getEngineVersion() + com.igexin.push.core.b.an + getAsesModelVersion();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getAsesVersion error " + e.getMessage(), e);
            return "ASES : 0";
        }
    }

    private static java.lang.String getAsesModelVersion() throws java.lang.Throwable {
        try {
            com.up366.asecengine.englishengine.AsesModelHelper asesModelHelperCreate = com.up366.asecengine.englishengine.AsesModelHelper.create();
            if (!asesModelHelperCreate.hasModel()) {
                return "ASES MODEL : 0";
            }
            return "ASES MODEL: " + com.alibaba.fastjson.JSON.parseObject(com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(asesModelHelperCreate.getModelDir(), "config.json"))).getString("version");
        } catch (java.lang.Exception unused) {
            return "ASES MODEL : 0";
        }
    }
}
