package com.up366.mobile.book.studyviews.view.video;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VideoHelperNew {
    private static final java.lang.String TAG = "VideoHelperNew";
    private final com.up366.mobile.book.helper.V6ChapterDataHelper dataHelper;
    private java.lang.String fileId;
    private final com.up366.mobile.book.studyviews.view.video.AnswerVideoView video;
    private java.lang.String videoId;
    private java.lang.String videoPath;
    private java.lang.String videoPost;
    private com.up366.mobile.book.webview.StudyPageWebView webView;

    public VideoHelperNew(com.up366.mobile.book.studyviews.view.video.AnswerVideoView answerVideoView, final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V6ChapterDataHelper v6ChapterDataHelper) {
        this.video = answerVideoView;
        this.webView = studyPageWebView;
        this.dataHelper = v6ChapterDataHelper;
        studyPageWebView.setVideoContent(answerVideoView);
        answerVideoView.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperNew.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                studyPageWebView.refreshVideoPosition();
            }
        });
    }

    public void setVideoSrc(java.lang.String str, java.lang.String str2) {
        this.videoPath = str2;
        this.fileId = str;
    }

    public void setVideoPost(java.lang.String str) {
        if (com.up366.common.BitmapUtilsUp.isPicture(str)) {
            this.videoPost = str;
            this.video.setPost(str);
        }
    }

    public void setPosition(int i, int i2, int i3, int i4) {
        int iDp2px = com.up366.common.DpUtilsUp.dp2px(i);
        int iDp2px2 = com.up366.common.DpUtilsUp.dp2px(i2);
        int iDp2px3 = com.up366.common.DpUtilsUp.dp2px(i3);
        int iDp2px4 = com.up366.common.DpUtilsUp.dp2px(i4);
        this.webView.setVideoPosition(iDp2px, iDp2px2);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.video.getLayoutParams();
        layoutParams.height = iDp2px4;
        layoutParams.width = iDp2px3;
        layoutParams.setMargins(iDp2px, iDp2px2, 0, 0);
        this.video.requestLayout();
    }

    public void setVideoId(java.lang.String str) {
        this.videoId = str;
    }

    public void pausePlay() {
        this.video.pausePlay();
    }

    public void startPlayVideo() {
        this.video.startPlayVideo();
    }

    public void resumeVideo() {
        this.video.resumePlayVideo();
    }

    public int getCurrentTime() {
        return this.video.getCurrentTime();
    }

    public void setUpFullScreenBtn() {
        this.video.setUpFullScreenBtn();
    }

    public void initVideo() {
        this.video.initViews();
        if (com.up366.common.StringUtils.isEmptyOrNull(this.videoPath)) {
            return;
        }
        this.video.setVideoCallBack(new com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperNew.2
            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void initDurtionAndPosition(int i, int i2) {
            }

            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void setCurrentPosition(int i) {
            }

            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void onMediaStateResult(int i) {
                com.up366.mobile.book.studyviews.view.video.VideoHelperNew.this.webView.callJSMethod("onVideoStateChange('" + com.up366.mobile.book.studyviews.view.video.VideoHelperNew.this.videoId + "'," + i + ")");
            }
        });
        if (com.up366.common.StringUtils.isEmptyOrNull(this.fileId)) {
            this.video.setVideoPath(this.videoPath);
            return;
        }
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(this.dataHelper.getBookPath(), "temp", this.fileId);
        this.videoPath = strJoin;
        if (com.up366.common.FileUtilsUp.isFileExists(strJoin)) {
            this.video.setVideoPath(this.videoPath);
            this.video.setDownload(true);
        } else {
            this.video.setDownload(false);
            this.video.setDownloadCallBack(new com.up366.mobile.book.studyviews.view.video.AnswerVideoView.DownloadCallBack() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperNew$$ExternalSyntheticLambda1
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

    public void fullScreen() {
        this.video.fullScreen();
    }

    public boolean isFullScreen() {
        return this.video.isFullScreen();
    }

    public com.up366.common.download.DownloadInfo toDownloadVideo(java.lang.String str, java.lang.String str2) {
        final com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setName("videoId:" + str);
        downloadInfo.setKey(str);
        downloadInfo.setDownType(12);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setFilePath(str2);
        com.up366.mobile.common.logic.Auth.cur().book().fetchFileInfo(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperNew$$ExternalSyntheticLambda0
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
        com.up366.common.log.Logger.debug("LLLLL - VideoHelperNow FlipbookMgr-toDownloadFileByResId() : " + com.alibaba.fastjson.JSON.toJSONString(downloadInfo));
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

    public void destroy() {
        pausePlay();
        this.video.destroy();
    }

    public void setVisiable(boolean z) {
        this.video.setVisibility(z ? 0 : 8);
    }

    public void setVideoMute(java.lang.String str, boolean z) {
        this.video.setVideoMute(str, z);
    }

    public java.lang.String getVideoImage(java.lang.String str) {
        return this.video.getVideoImage(str);
    }

    public void setVideoControlEnable(boolean z) {
        this.video.setVideoControlEnable(z);
    }

    public void setVideoControlVisible(boolean z) {
        this.video.setVideoControlVisible(z);
    }

    public int getDuration() {
        return this.video.getDuration();
    }
}
