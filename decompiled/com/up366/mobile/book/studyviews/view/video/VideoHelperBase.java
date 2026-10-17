package com.up366.mobile.book.studyviews.view.video;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VideoHelperBase {
    public static final int VIDEO_STATE_COMPLATE = 4;
    public static final int VIDEO_STATE_PAUSE = 2;
    public static final int VIDEO_STATE_PLAYING = 1;
    public static final int VIDEO_STATE_PREPARE = 0;
    private com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack callBack;
    private int curPercent;
    private boolean muteFlag;
    private android.media.MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener1;
    private android.media.MediaPlayer.OnCompletionListener onCompletionListener1;
    private android.media.MediaPlayer.OnErrorListener onErrorListener1;
    private android.media.MediaPlayer.OnInfoListener onInfoListener1;
    private com.up366.mobile.book.studyviews.view.video.VideoHelperBase.OnPauseListener onPauseListener;
    private android.media.MediaPlayer.OnPreparedListener onPreparedListener1;
    private android.view.SurfaceView surfaceView;
    private java.lang.String videoPath;
    private android.media.MediaPlayer video = null;
    private boolean timerStart = false;
    private boolean isPlaying = false;
    private boolean hasInit = false;
    private android.media.MediaPlayer.OnErrorListener onErrorListener = new android.media.MediaPlayer.OnErrorListener() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.1
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.hasInit = false;
            if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video != null) {
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.stop();
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.release();
            }
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video = null;
            com.up366.common.log.Logger.warn("MediaPlayer onErrorListener onError() what:" + i + " extra:" + i2);
            if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onErrorListener1 == null) {
                return true;
            }
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onErrorListener1.onError(mediaPlayer, i, i2);
            return true;
        }
    };
    private android.media.MediaPlayer.OnInfoListener onInfoListener = new android.media.MediaPlayer.OnInfoListener() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.2
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(final android.media.MediaPlayer mediaPlayer, final int i, final int i2) {
            com.up366.common.log.Logger.debug("VVVVV - what:" + i + " extra:" + i2);
            if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onInfoListener1 == null) {
                return false;
            }
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.2.1
                @Override // com.up366.common.task.Task
                public void run() {
                    com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onInfoListener1.onInfo(mediaPlayer, i, i2);
                }
            });
            return false;
        }
    };
    private android.media.MediaPlayer.OnSeekCompleteListener onSeekCompleteListener = new android.media.MediaPlayer.OnSeekCompleteListener() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.3
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
            com.up366.common.log.Logger.debug("onSeekComplete(MediaPlayer) : " + com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.getCurrentTime());
            if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.isPlaying) {
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.start();
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.startTimer();
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onVideoStateChange(1);
                return;
            }
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.pausePlay();
        }
    };
    private android.media.MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = new android.media.MediaPlayer.OnBufferingUpdateListener() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.4
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
            com.up366.common.log.Logger.debug("VVVVV - percent:" + i);
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.curPercent = i;
            if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onBufferingUpdateListener1 != null) {
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onBufferingUpdateListener1.onBufferingUpdate(mediaPlayer, i);
            }
        }
    };
    private android.media.MediaPlayer.OnPreparedListener onPreparedListener = new android.media.MediaPlayer.OnPreparedListener() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.5
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            try {
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.hasInit = true;
                com.up366.common.log.Logger.debug("VVVVV - VideoMgrSp.onPrepared(MediaPlayer mp) isPlaying == ?");
                final int videoWidth = com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.getVideoWidth();
                final int videoHeight = com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.5.1
                        @Override // com.up366.common.task.Task
                        public void run() {
                            try {
                                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.surfaceView.getHolder().setFixedSize(videoWidth, videoHeight);
                            } catch (java.lang.NullPointerException e) {
                                com.up366.common.log.Logger.warn(e.getMessage(), e);
                            }
                        }
                    });
                    if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.isPlaying) {
                        com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.start();
                    }
                    if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.callBack != null) {
                        com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.callBack.initDurtionAndPosition(com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.getDuration(), 0);
                    }
                    com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onVideoStateChange(0);
                } else {
                    com.up366.common.log.Logger.error("Video size is invalid (" + videoWidth + " ," + videoHeight + ")");
                }
                if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onPreparedListener1 != null) {
                    com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onPreparedListener1.onPrepared(mediaPlayer);
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.warn(e.getMessage());
            }
        }
    };
    private android.media.MediaPlayer.OnCompletionListener onCompletionListener = new android.media.MediaPlayer.OnCompletionListener() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
            try {
                if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.video.getDuration() < 2000) {
                    com.up366.mobile.book.studyviews.view.video.VideoHelperBase videoHelperBase = com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this;
                    videoHelperBase.setMediaVideo(videoHelperBase.surfaceView, com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.videoPath);
                } else {
                    com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.pausePlay();
                    com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.seekTo(0);
                }
            } catch (java.lang.Exception unused) {
            }
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onVideoStateChange(4);
            if (com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onCompletionListener1 != null) {
                com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this.onCompletionListener1.onCompletion(mediaPlayer);
            }
        }
    };
    private android.view.SurfaceHolder.Callback surfaceCallback = new android.view.SurfaceHolder.Callback() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase.7
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            com.up366.common.log.Logger.debug("Surface changed.");
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase videoHelperBase = com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this;
            videoHelperBase.changeSurfaceView(videoHelperBase.surfaceView);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            com.up366.common.log.Logger.debug("Surface created.");
            com.up366.mobile.book.studyviews.view.video.VideoHelperBase videoHelperBase = com.up366.mobile.book.studyviews.view.video.VideoHelperBase.this;
            videoHelperBase.changeSurfaceView(videoHelperBase.surfaceView);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.up366.common.log.Logger.debug("Surface destroyed.");
        }
    };

    public interface IHWVideoCallBack {
        void initDurtionAndPosition(int i, int i2);

        void onMediaStateResult(int i);

        void setCurrentPosition(int i);
    }

    public interface OnPauseListener {
        void onPause();
    }

    private void stopTimer() {
        this.timerStart = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        this.timerStart = true;
    }

    private void onTimeout() {
        if (this.timerStart) {
            notifyCurrentPosition(this.video.getCurrentPosition());
        }
    }

    private void notifyCurrentPosition(final int i) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.video.VideoHelperBase$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$notifyCurrentPosition$0(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyCurrentPosition$0(int i) throws java.lang.Exception {
        if (this.isPlaying) {
            this.callBack.setCurrentPosition(i);
        }
    }

    public void onTimeOut() {
        if (this.timerStart) {
            onTimeout();
        }
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener onCompletionListener) {
        this.onCompletionListener1 = onCompletionListener;
    }

    public void setOnBufferingUpdateListener(android.media.MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.onBufferingUpdateListener1 = onBufferingUpdateListener;
    }

    public void setOnPauseListener(com.up366.mobile.book.studyviews.view.video.VideoHelperBase.OnPauseListener onPauseListener) {
        this.onPauseListener = onPauseListener;
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onErrorListener) {
        this.onErrorListener1 = onErrorListener;
    }

    public void setOnInfoListener(android.media.MediaPlayer.OnInfoListener onInfoListener) {
        this.onInfoListener1 = onInfoListener;
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onPreparedListener) {
        this.onPreparedListener1 = onPreparedListener;
    }

    public void setMediaVideo(android.view.SurfaceView surfaceView, java.lang.String str) {
        stopVideo();
        this.surfaceView = surfaceView;
        surfaceView.getHolder().addCallback(this.surfaceCallback);
        this.videoPath = str;
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        this.video = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.onPreparedListener);
        this.video.setOnSeekCompleteListener(this.onSeekCompleteListener);
        this.video.setOnCompletionListener(this.onCompletionListener);
        this.video.setOnBufferingUpdateListener(this.onBufferingUpdateListener);
        this.video.setOnInfoListener(this.onInfoListener);
        this.video.setOnErrorListener(this.onErrorListener);
        this.video.setAudioStreamType(3);
        setVideoMute(this.muteFlag);
        this.isPlaying = false;
        try {
            this.video.setDataSource(str);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage());
        }
        try {
            this.video.setDisplay(this.surfaceView.getHolder());
        } catch (java.lang.Exception e2) {
            com.up366.common.log.Logger.warn(e2.getMessage());
        }
        try {
            this.video.prepareAsync();
        } catch (java.lang.Exception e3) {
            com.up366.common.log.Logger.error(e3.getMessage());
        }
    }

    public void pausePlay() {
        com.up366.mobile.book.studyviews.view.video.VideoHelperBase.OnPauseListener onPauseListener = this.onPauseListener;
        if (onPauseListener != null) {
            try {
                onPauseListener.onPause();
            } catch (java.lang.Exception unused) {
                this.onPauseListener = null;
                com.up366.common.log.Logger.warn("set onPauseListener=null;");
            }
        }
        this.isPlaying = false;
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.video.pause();
        }
        onVideoStateChange(2);
        stopTimer();
    }

    public void resumeVideo() {
        try {
            android.media.MediaPlayer mediaPlayer = this.video;
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                this.video.start();
                this.isPlaying = true;
                startTimer();
            }
        } catch (java.lang.IllegalStateException e) {
            com.up366.common.log.Logger.warn(e.getMessage());
        }
        onVideoStateChange(1);
    }

    public void setVideoMute(boolean z) {
        this.muteFlag = z;
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer != null) {
            if (z) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
    }

    public void toPlay(int i, boolean z) {
        this.isPlaying = z;
        seekTo(i);
    }

    public void seekTo(int i) {
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer == null) {
            com.up366.common.log.Logger.error("Media player is not found!");
            return;
        }
        if (i < 0 || i > mediaPlayer.getDuration()) {
            com.up366.common.log.Logger.error("request to play " + i + " but video duration is 0 - " + this.video.getDuration());
            return;
        }
        this.video.seekTo(i);
    }

    public void changeSurfaceView(android.view.SurfaceView surfaceView) {
        com.up366.common.log.Logger.debug("VVVVV - VideoMgrSp.changeSurfaceView");
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer == null) {
            return;
        }
        this.surfaceView = surfaceView;
        try {
            mediaPlayer.setDisplay(surfaceView.getHolder());
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.warn(e.getMessage());
        }
    }

    public void stopVideo() {
        this.isPlaying = false;
        this.hasInit = false;
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.video.release();
            this.video = null;
        }
        this.surfaceView = null;
        onVideoStateChange(2);
    }

    public int getDuration() {
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer == null || !this.hasInit) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    public int getCurBufferPercent() {
        return this.curPercent;
    }

    public int getCurrentTime() {
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer == null || !this.hasInit) {
            return 0;
        }
        try {
            return mediaPlayer.getCurrentPosition();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.warn(e.getMessage());
            return 0;
        }
    }

    public boolean isPlaying() {
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer == null && !this.timerStart) {
            return false;
        }
        if (!this.timerStart && mediaPlayer.isPlaying()) {
            com.up366.common.log.Logger.warn("VideoMgr isPlaying() state error, mediaPlayer.isPlaying() is " + this.video.isPlaying() + " but timer is null ...");
        }
        return this.timerStart;
    }

    public android.graphics.Point getVideoSize() {
        android.graphics.Point point = new android.graphics.Point();
        android.media.MediaPlayer mediaPlayer = this.video;
        if (mediaPlayer != null) {
            point.x = mediaPlayer.getVideoWidth();
            point.y = this.video.getVideoHeight();
        }
        return point;
    }

    public void setCallBack(com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack iHWVideoCallBack) {
        com.up366.common.log.Logger.debug("VVVVV - VideoMgrSp.setCallBac()");
        this.callBack = iHWVideoCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoStateChange(int i) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack iHWVideoCallBack = this.callBack;
        if (iHWVideoCallBack != null) {
            iHWVideoCallBack.onMediaStateResult(i);
        }
    }
}
