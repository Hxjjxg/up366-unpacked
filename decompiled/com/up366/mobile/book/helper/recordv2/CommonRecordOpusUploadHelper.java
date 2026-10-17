package com.up366.mobile.book.helper.recordv2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonRecordOpusUploadHelper {
    private static final java.lang.String OPUS_EXT = ".ogg";
    private static final java.lang.String TAG = "TAG - CommonRecordOpusUploadHelper";

    @java.lang.FunctionalInterface
    public interface UploadCallback {
        void onResult(int i, java.lang.String str, java.lang.String str2);
    }

    public void upload(final java.lang.String str, final com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper.UploadCallback uploadCallback) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            uploadCallback.onResult(-1, "opus path is empty", null);
            return;
        }
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            uploadCallback.onResult(-2, "opus file not exists: " + str, null);
        } else {
            com.up366.common.log.Logger.info("TAG - CommonRecordOpusUploadHelper - upload - start, opusPath=[" + str + "]");
            com.up366.mobile.common.logic.Auth.cur().fileMgr().save(str, OPUS_EXT, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                    this.f$0.lambda$upload$0(str, uploadCallback, fileMapInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uploadWithInfo, reason: merged with bridge method [inline-methods] */
    public void lambda$upload$0(final java.lang.String str, final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, final com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper.UploadCallback uploadCallback) {
        if (fileMapInfo == null) {
            uploadCallback.onResult(-3, "save opus file map failed: " + str, null);
        } else {
            if (com.up366.common.StringUtils.isEmptyOrNull(fileMapInfo.getUrl())) {
                uploadCallback.onResult(-4, "opus upload url is empty: " + str, null);
                return;
            }
            com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordOpusUploadHelper.1
                @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
                public /* synthetic */ void onProgress(long j, long j2) {
                    com.up366.mobile.common.utils.alifile.IOSSCallback.CC.$default$onProgress(this, j, j2);
                }

                @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
                public void onSuccess() {
                    com.up366.common.log.Logger.info("TAG - CommonRecordOpusUploadHelper - uploadWithInfo - success, opusPath=[" + str + "], uploadedUrl=[" + fileMapInfo.getUrl() + "]");
                    uploadCallback.onResult(0, null, fileMapInfo.getUrl());
                }

                @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
                public void onFailure(int i, java.lang.String str2) {
                    com.up366.common.log.Logger.error("TAG - CommonRecordOpusUploadHelper - uploadWithInfo - failed, opusPath=[" + str + "], code=[" + i + "], info=[" + str2 + "]");
                    uploadCallback.onResult(i, str2, null);
                }
            });
        }
    }
}
