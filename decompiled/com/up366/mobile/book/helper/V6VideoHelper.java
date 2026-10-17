package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6VideoHelper {
    private final com.up366.mobile.book.StudyActivity context;
    private final com.up366.mobile.book.helper.V6ChapterDataHelper dataHelper;
    private boolean hasPause = true;
    private final com.up366.mobile.book.model.CatalogPage page;
    private boolean showVideo;
    private final com.up366.mobile.book.studyviews.view.V6ExerciseView v6ExerciseView;
    private com.up366.mobile.book.studyviews.view.video.AnswerVideoView video;
    public com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew;
    private com.up366.mobile.book.webview.StudyPageWebView webView;

    public void onResume() {
    }

    public V6VideoHelper(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.studyviews.view.V6ExerciseView v6ExerciseView, com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, com.up366.mobile.book.helper.V6ChapterDataHelper v6ChapterDataHelper, com.up366.mobile.book.model.CatalogPage catalogPage) {
        this.context = studyActivity;
        this.dataHelper = v6ChapterDataHelper;
        this.page = catalogPage;
        this.v6ExerciseView = v6ExerciseView;
        this.webView = studyPageWebView;
    }

    public void onPause() {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.pausePlay();
        }
    }

    public void onEnterPage() {
        this.hasPause = false;
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.initVideo();
            this.videoHelperNew.setUpFullScreenBtn();
        }
    }

    public void onDestroy() {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.destroy();
        }
    }

    public void playResVedio(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "视频地址不存在。");
            return;
        }
        if (!str.startsWith("http")) {
            str = com.up366.common.FileUtilsUp.join(this.dataHelper.getChapterRootDataDir(this.page), str);
        }
        new android.os.Bundle();
        android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.activity.AnswerVideoActivity.class);
        intent.putExtra("book_id", this.dataHelper.getBook().getBookId());
        intent.putExtra("video_src", str);
        this.context.startActivity(intent);
    }

    public void initVideoView(java.lang.String str, int i, int i2, int i3, int i4, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5 = getCurrentPath() + str2;
        if (str2.contains("..")) {
            str5 = new java.io.File(getCurrentPath()).getParent() + str2.replace("..", "");
        }
        initVideoView();
        this.video.setVisibility(0);
        if (this.videoHelperNew == null) {
            this.videoHelperNew = new com.up366.mobile.book.studyviews.view.video.VideoHelperNew(this.video, this.webView, this.dataHelper);
        }
        this.videoHelperNew.setVideoId(str);
        this.videoHelperNew.setVideoSrc(null, getCurrentPath() + str3);
        this.videoHelperNew.setVideoPost(str5);
        this.videoHelperNew.setPosition(i, i2, i3, i4);
        if (!this.hasPause) {
            this.videoHelperNew.initVideo();
            this.videoHelperNew.setUpFullScreenBtn();
        }
        this.showVideo = true;
    }

    public void initNewVideoView(java.lang.String str, int i, int i2, int i3, int i4, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        java.lang.String str6 = this.dataHelper.getChapterRootDir(this.page) + str2;
        if (str2.contains("..")) {
            str6 = new java.io.File(this.dataHelper.getChapterRootDir(this.page)).getParent() + str2.replace("..", "");
        }
        initVideoView();
        this.video.setVisibility(0);
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew == null) {
            this.videoHelperNew = new com.up366.mobile.book.studyviews.view.video.VideoHelperNew(this.video, this.webView, this.dataHelper);
        } else {
            videoHelperNew.destroy();
        }
        this.videoHelperNew.setVideoId(str);
        this.videoHelperNew.setVideoSrc(str3, getCurrentPath() + str4);
        this.videoHelperNew.setVideoPost(str6);
        this.videoHelperNew.setPosition(i, i2, i3, i4);
        if (!this.hasPause) {
            this.videoHelperNew.initVideo();
            this.videoHelperNew.setUpFullScreenBtn();
        }
        this.showVideo = true;
    }

    private java.lang.String getCurrentPath() {
        java.lang.String pageHtmlPath = this.dataHelper.getPageHtmlPath(this.page);
        return pageHtmlPath.substring(0, pageHtmlPath.lastIndexOf("/") + 1);
    }

    public boolean isShowVideo() {
        return this.showVideo;
    }

    public void setVisiable(boolean z) {
        initVideoView();
        this.video.setVisibility(z ? 0 : 8);
    }

    public void setVideoMute(java.lang.String str, boolean z) {
        initVideoView();
        this.video.setVideoMute(str, z);
    }

    public java.lang.String getVideoImage(java.lang.String str) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            java.lang.String videoImage = videoHelperNew.getVideoImage(str);
            return !com.up366.common.StringUtils.isEmptyOrNull(videoImage) ? videoImage : "file:///android_asset/default_pic.png";
        }
        return "file:///android_asset/default_pic.png";
    }

    public void pausePlayVideo(java.lang.String str) {
        this.videoHelperNew.pausePlay();
    }

    public void resumePlayVideo(java.lang.String str) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.resumeVideo();
        }
    }

    public void startPlayVideo(com.up366.mobile.book.helper.V6VideoHelper v6VideoHelper) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.startPlayVideo();
        }
    }

    public void stopPlayVideo(java.lang.String str) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.pausePlay();
        }
    }

    public int getVideoCurrentTime(java.lang.String str) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            return videoHelperNew.getCurrentTime();
        }
        return 0;
    }

    public int getVideoDuration(java.lang.String str) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            return videoHelperNew.getDuration();
        }
        return 0;
    }

    public void activeVideoControl(boolean z) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.setVideoControlEnable(z);
        }
    }

    public void setVideoControlVisible(java.lang.String str, final boolean z) {
        if (this.videoHelperNew != null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V6VideoHelper.1
                @Override // com.up366.common.task.Task
                public void run() {
                    com.up366.mobile.book.helper.V6VideoHelper.this.videoHelperNew.setVideoControlVisible(z);
                }
            });
        }
        this.webView.setControlsVisible(z);
    }

    public boolean isVideoFullScreen() {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew == null) {
            return false;
        }
        return videoHelperNew.isFullScreen();
    }

    public void toggleVideoFullScreen() {
        com.up366.mobile.book.studyviews.view.video.VideoHelperNew videoHelperNew = this.videoHelperNew;
        if (videoHelperNew != null) {
            videoHelperNew.fullScreen();
        }
    }

    private void initVideoView() {
        if (this.video == null) {
            com.up366.mobile.book.studyviews.view.video.AnswerVideoView answerVideoView = new com.up366.mobile.book.studyviews.view.video.AnswerVideoView(this.context);
            this.video = answerVideoView;
            answerVideoView.setVisibility(8);
            this.v6ExerciseView.videoView = this.video;
            this.v6ExerciseView.addView(this.video);
        }
    }
}
