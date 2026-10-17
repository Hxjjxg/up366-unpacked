package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JSUploadFileHelper {
    private final com.up366.mobile.book.helper.DataHelper dataHelper;

    public JSUploadFileHelper(com.up366.mobile.book.helper.DataHelper dataHelper) {
        this.dataHelper = dataHelper;
    }

    public void upload(java.lang.String str) {
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            final com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(10, object.getString(com.igexin.push.core.b.C));
            com.up366.mobile.common.logic.Auth.cur().fileMgr().load(object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL), null, new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.helper.JSUploadFileHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str2, java.lang.Object obj) {
                    com.up366.mobile.book.helper.JSUploadFileHelper.lambda$upload$0(batchUploadLog, i, str2, (com.up366.mobile.common.utils.alifile.FileMapInfo) obj);
                }
            });
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
        }
    }

    static /* synthetic */ void lambda$upload$0(com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog, int i, java.lang.String str, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        if (i != 0) {
            batchUploadLog.setState(-1);
            batchUploadLog.setErrCode(-5);
            batchUploadLog.setErrInfo("文件不存在");
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.CommonUploadLogEvent(batchUploadLog));
            return;
        }
        if (fileMapInfo.getPath().endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.WAV)) {
            batchUploadLog.addWav(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
        } else {
            batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
        }
        com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
    }
}
