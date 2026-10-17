package com.up366.mobile.book.studyviews.view.video;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VideoHelperLDX {
    private static final java.lang.String TAG = "VideoHelperLDX";
    private final java.lang.String bookId;
    private java.lang.String fileId;
    private int maxPlayTime;
    private com.up366.mobile.book.studyviews.view.video.AnswerVideoView video;
    private java.lang.String videoPath;

    public VideoHelperLDX(com.up366.mobile.book.studyviews.view.video.AnswerVideoView answerVideoView, java.lang.String str) {
        this.video = answerVideoView;
        this.bookId = str;
    }

    public void setVideoSrc(java.lang.String str, java.lang.String str2) {
        this.fileId = str;
        this.videoPath = str2;
    }

    public void setVideoPost(java.lang.String str) {
        if (com.up366.common.BitmapUtilsUp.isPicture(str)) {
            this.video.setPost(str);
        }
    }

    public void pausePlay() {
        this.video.pausePlay();
    }

    public void startPlayVideo() {
        this.video.startPlayVideo();
    }

    public void resumeVideo() {
        startPlayVideo();
    }

    public int getCurrentTime() {
        return this.video.getCurrentTime();
    }

    public void initVideo() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.videoPath) && com.up366.common.StringUtils.isEmptyOrNull(this.fileId)) {
            return;
        }
        this.video.setVideoCallBack(new com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperLDX.1
            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void initDurtionAndPosition(int i, int i2) {
            }

            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void onMediaStateResult(int i) {
            }

            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void setCurrentPosition(int i) {
                if (com.up366.mobile.book.studyviews.view.video.VideoHelperLDX.this.maxPlayTime < i) {
                    com.up366.mobile.book.studyviews.view.video.VideoHelperLDX.this.maxPlayTime = i;
                }
            }
        });
        if (com.up366.common.StringUtils.isEmptyOrNull(this.fileId)) {
            this.video.setVideoPath(this.videoPath);
            return;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.bookId, "tem", this.fileId);
        this.videoPath = strJoin;
        if (com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
            this.video.setVideoPath(this.videoPath);
            this.video.setDownload(true);
        } else {
            this.video.setDownload(false);
            this.video.setDownloadCallBack(new com.up366.mobile.book.studyviews.view.video.AnswerVideoView.DownloadCallBack() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperLDX$$ExternalSyntheticLambda0
                @Override // com.up366.mobile.book.studyviews.view.video.AnswerVideoView.DownloadCallBack
                public final void onDownload() {
                    this.f$0.lambda$initVideo$0();
                }
            });
            toDownloadVideo(this.fileId, this.videoPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideo$0() {
        toDownloadVideo(this.fileId, this.videoPath);
    }

    private com.up366.common.download.DownloadInfo toDownloadVideo(java.lang.String str, java.lang.String str2) {
        final com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setName("videoId:" + str);
        downloadInfo.setKey(str);
        downloadInfo.setDownType(12);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setFilePath(str2);
        com.up366.mobile.common.logic.Auth.cur().book().fetchFileInfo(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperLDX$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$toDownloadVideo$1(downloadInfo, response, (com.up366.mobile.book.model.FileInfo) obj);
            }
        });
        return downloadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toDownloadVideo$1(com.up366.common.download.DownloadInfo downloadInfo, com.up366.common.http.Response response, com.up366.mobile.book.model.FileInfo fileInfo) {
        if (response.isError()) {
            downloadInfo.setState(5);
            com.up366.mobile.common.utils.ToastPopupUtil.show("资源获取失败:");
            com.up366.common.log.Logger.warn("资源获取失败:" + response.getInfo());
            this.video.setDownFiled("资源获取失败:" + response.getInfo());
            return;
        }
        downloadInfo.setDownloadUrl(fileInfo.getDownloadUrl());
        downloadInfo.setFileMD5(fileInfo.getFileMd5());
        downloadInfo.setFileSize(fileInfo.getFileSize());
        downloadInfo.setNeedCheck(true);
        com.up366.mobile.common.utils.DownloadHelper.add(downloadInfo);
        com.up366.common.log.Logger.debug("LLLLL - VideoHelperLDX FlipbookMgr-toDownloadFileByResId() : " + com.alibaba.fastjson.JSON.toJSONString(downloadInfo));
    }

    public void downloadEvent(com.up366.common.event.DownloadEvent downloadEvent) {
        java.lang.String str = this.fileId;
        if (str == null || !str.equals(downloadEvent.getKey())) {
            return;
        }
        int state = downloadEvent.getState();
        if (state == 0 || state == 1) {
            this.video.setDownProgress(0);
            return;
        }
        if (state == 2) {
            this.video.setDownProgress(downloadEvent.getPercent());
            return;
        }
        if (state == 4) {
            this.video.setDownload(true);
            this.video.setVideoPath(this.videoPath);
        } else {
            if (state != 5) {
                return;
            }
            this.video.setDownFiled(downloadEvent.getErrInfo());
        }
    }

    public int getMaxPlayTime() {
        return this.maxPlayTime;
    }

    public void stopVideo() {
        this.video.destroy();
    }
}
