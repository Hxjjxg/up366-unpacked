package com.up366.mobile.book.dict;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictDataHelper {
    public com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.dict.js.DictDataHolder dataHolder;

    public void init(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.dict.js.DictDataHolder dictDataHolder) {
        this.context = studyActivity;
        this.dataHolder = dictDataHolder;
    }

    public java.lang.String getPath() {
        if (com.up366.mobile.book.dict.DictResourceHelper.isTestDir()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "加载测试版词典引擎");
        }
        java.lang.String dictRootDir = com.up366.mobile.book.dict.DictResourceHelper.getDictRootDir();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.book.dict.DictResourceHelper.getDictConfig());
        if (object == null) {
            com.up366.common.log.Logger.error("TAG - DictDataHelper - getPath - configJson == null");
            return "about:blank";
        }
        return "file://" + com.up366.common.FileUtilsUp.join(dictRootDir, object.getJSONObject(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH).getString(com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX));
    }

    public java.lang.String getDbPath(java.lang.String str) {
        java.lang.String dictRootDir = com.up366.mobile.book.dict.DictResourceHelper.getDictRootDir();
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.book.dict.DictResourceHelper.getDictConfig());
        if (object == null) {
            com.up366.common.log.Logger.error("TAG - DictDataHelper - getDbPath - configJson == null");
            return null;
        }
        return com.up366.common.FileUtilsUp.join(dictRootDir, object.getJSONObject(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH).getString(str));
    }
}
