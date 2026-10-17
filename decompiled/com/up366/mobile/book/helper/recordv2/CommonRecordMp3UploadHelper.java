package com.up366.mobile.book.helper.recordv2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonRecordMp3UploadHelper {
    private static final java.lang.String MP3_EXT = ".mp3";
    private static final java.lang.String TAG = "TAG - CommonRecordMp3UploadHelper";
    private static final com.up366.common.task.TaskExecutor uploadExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("recordv2-mp3-upload");

    public interface UploadCallback {
        void onPrepared(com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadInfo uploadInfo);

        void onResult(int i, java.lang.String str, com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadInfo uploadInfo);
    }

    public void upload(final java.lang.String str, final java.lang.String str2, final com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadCallback uploadCallback) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            uploadCallback.onResult(-1, "audioPracticeId is empty", null);
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            uploadCallback.onResult(-2, "mp3 path is empty", null);
        } else {
            if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
                uploadCallback.onResult(-3, "mp3 file not exists: " + str, null);
                return;
            }
            uploadExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$upload$0(str, str2, uploadCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareAndUpload, reason: merged with bridge method [inline-methods] */
    public void lambda$upload$0(java.lang.String str, final java.lang.String str2, final com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadCallback uploadCallback) {
        final java.lang.String strBuildUploadTargetPath = buildUploadTargetPath(str, str2);
        if (com.up366.common.StringUtils.isEmptyOrNull(strBuildUploadTargetPath)) {
            uploadCallback.onResult(-4, "mp3 upload copy path is empty", null);
            return;
        }
        if (copyMp3ForUpload(str, strBuildUploadTargetPath, str2, uploadCallback)) {
            com.up366.common.log.Logger.info("TAG - CommonRecordMp3UploadHelper - upload - start, audioPracticeId=[" + str2 + "], mp3Path=[" + str + "], uploadPath=[" + strBuildUploadTargetPath + "]");
            com.up366.mobile.common.logic.Auth.cur().fileMgr().save(strBuildUploadTargetPath, ".mp3", com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper$$ExternalSyntheticLambda1
                @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
                public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                    this.f$0.lambda$prepareAndUpload$1(strBuildUploadTargetPath, str2, uploadCallback, fileMapInfo);
                }
            });
        }
    }

    private boolean copyMp3ForUpload(java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadCallback uploadCallback) throws java.lang.Throwable {
        try {
            com.up366.common.FileUtilsUp.mkdirParentDir(str2);
            com.up366.common.FileUtilsUp.copyFileOrDir(new java.io.File(str), new java.io.File(str2));
            return true;
        } catch (java.lang.RuntimeException e) {
            com.up366.common.log.Logger.error("TAG - CommonRecordMp3UploadHelper - upload - copy mp3 failed, audioPracticeId=[" + str3 + "], mp3Path=[" + str + "], uploadPath=[" + str2 + "]", e);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("copy mp3 failed: ");
            sb.append(e.getMessage());
            uploadCallback.onResult(-5, sb.toString(), null);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handlePreparedUpload, reason: merged with bridge method [inline-methods] */
    public void lambda$prepareAndUpload$1(final java.lang.String str, final java.lang.String str2, final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, final com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadCallback uploadCallback) {
        if (fileMapInfo == null) {
            uploadCallback.onResult(-6, "save mp3 file map failed: " + str, null);
        } else if (com.up366.common.StringUtils.isEmptyOrNull(fileMapInfo.getUrl())) {
            uploadCallback.onResult(-7, "mp3 upload url is empty: " + str, null);
        } else {
            final com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadInfo uploadInfo = new com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.UploadInfo(str2, str, fileMapInfo.getUrl());
            uploadCallback.onPrepared(uploadInfo);
            com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.book.helper.recordv2.CommonRecordMp3UploadHelper.1
                @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
                public /* synthetic */ void onProgress(long j, long j2) {
                    com.up366.mobile.common.utils.alifile.IOSSCallback.CC.$default$onProgress(this, j, j2);
                }

                @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
                public void onSuccess() {
                    com.up366.common.log.Logger.info("TAG - CommonRecordMp3UploadHelper - handlePreparedUpload - success, audioPracticeId=[" + str2 + "], uploadPath=[" + str + "], uploadedUrl=[" + fileMapInfo.getUrl() + "]");
                    uploadCallback.onResult(0, null, uploadInfo);
                }

                @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
                public void onFailure(int i, java.lang.String str3) {
                    com.up366.common.log.Logger.error("TAG - CommonRecordMp3UploadHelper - handlePreparedUpload - failed, audioPracticeId=[" + str2 + "], uploadPath=[" + str + "], code=[" + i + "], info=[" + str3 + "]");
                    uploadCallback.onResult(i, str3, uploadInfo);
                }
            });
        }
    }

    public static java.lang.String buildUploadTargetPath(java.lang.String str, java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return "";
        }
        java.io.File file = new java.io.File(str);
        java.lang.String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        java.lang.String strSubstring = iLastIndexOf >= 0 ? name.substring(0, iLastIndexOf) : name;
        java.lang.String strSubstring2 = iLastIndexOf >= 0 ? name.substring(iLastIndexOf) : ".mp3";
        java.io.File parentFile = file.getParentFile();
        return new java.io.File(parentFile != null ? parentFile.getAbsolutePath() : "", strSubstring + "_" + str2 + "_upload" + strSubstring2).getAbsolutePath();
    }

    public static final class UploadInfo {
        private final java.lang.String audioPracticeId;
        private final java.lang.String uploadPath;
        private final java.lang.String uploadedUrl;

        public UploadInfo(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.audioPracticeId = str;
            this.uploadPath = str2;
            this.uploadedUrl = str3;
        }

        public java.lang.String getAudioPracticeId() {
            return this.audioPracticeId;
        }

        public java.lang.String getUploadPath() {
            return this.uploadPath;
        }

        public java.lang.String getUploadedUrl() {
            return this.uploadedUrl;
        }
    }
}
