package com.up366.mobile.book.studyviews.view.video;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AnswerVideoView extends android.widget.FrameLayout implements android.view.View.OnClickListener, android.view.View.OnTouchListener {
    private static final java.lang.String TAG = "AnswerVideoView";
    private com.up366.mobile.databinding.AnswerVideoViewLayoutBinding binding;
    private android.os.CountDownTimer countDownTimer;
    private boolean doPlay;
    private int downProgress;
    private boolean download;
    private com.up366.mobile.book.studyviews.view.video.AnswerVideoView.DownloadCallBack downloadCallBack;
    private boolean fullScreen;
    private android.view.ViewGroup fullscreenContainer;
    boolean isLocalVideo;
    private boolean muteFlag;
    private boolean onTouchSeekBar;
    private boolean prepared;
    private android.widget.SeekBar.OnSeekBarChangeListener seekBarChangeListener;
    private int seekBarProgress;
    private com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack videoCallBack;
    private boolean videoControlEnable;
    private boolean videoControlVisible;
    private com.up366.mobile.book.studyviews.view.video.VideoHelperBase videoMgr;
    private java.lang.String videoPath;
    private java.lang.String videoPost;

    public interface DownloadCallBack {
        void onDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlayTimeAnim() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPlayTimeAnim() {
    }

    public AnswerVideoView(android.content.Context context) {
        super(context);
        this.fullScreen = false;
        this.prepared = false;
        this.doPlay = false;
        this.isLocalVideo = false;
        this.download = true;
        this.videoControlEnable = true;
        this.videoControlVisible = true;
        this.muteFlag = false;
        this.seekBarProgress = 0;
        this.onTouchSeekBar = false;
        this.seekBarChangeListener = new android.widget.SeekBar.OnSeekBarChangeListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = false;
                    if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlVisible) {
                        com.up366.mobile.common.utils.ViewUtil.invisible(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.binding.playMain);
                    }
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.toPlay(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.seekBarProgress, true);
                    if (!com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.isPlaying()) {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startPlayVideo();
                    } else {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startAnim();
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startPlayTimeAnim();
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = true;
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.stopPlayTimeAnim();
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.stopAnim();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    if (i < 0) {
                        i = 0;
                    }
                    if (i > seekBar.getMax()) {
                        i = seekBar.getMax();
                    }
                    if (z) {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = true;
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.seekBarProgress = i;
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.setTimeLabel(i, seekBar.getMax());
                    }
                }
            }
        };
        init(context, null, 0);
    }

    public AnswerVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fullScreen = false;
        this.prepared = false;
        this.doPlay = false;
        this.isLocalVideo = false;
        this.download = true;
        this.videoControlEnable = true;
        this.videoControlVisible = true;
        this.muteFlag = false;
        this.seekBarProgress = 0;
        this.onTouchSeekBar = false;
        this.seekBarChangeListener = new android.widget.SeekBar.OnSeekBarChangeListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = false;
                    if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlVisible) {
                        com.up366.mobile.common.utils.ViewUtil.invisible(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.binding.playMain);
                    }
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.toPlay(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.seekBarProgress, true);
                    if (!com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.isPlaying()) {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startPlayVideo();
                    } else {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startAnim();
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startPlayTimeAnim();
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = true;
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.stopPlayTimeAnim();
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.stopAnim();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    if (i < 0) {
                        i = 0;
                    }
                    if (i > seekBar.getMax()) {
                        i = seekBar.getMax();
                    }
                    if (z) {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = true;
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.seekBarProgress = i;
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.setTimeLabel(i, seekBar.getMax());
                    }
                }
            }
        };
        init(context, attributeSet, 0);
    }

    public AnswerVideoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fullScreen = false;
        this.prepared = false;
        this.doPlay = false;
        this.isLocalVideo = false;
        this.download = true;
        this.videoControlEnable = true;
        this.videoControlVisible = true;
        this.muteFlag = false;
        this.seekBarProgress = 0;
        this.onTouchSeekBar = false;
        this.seekBarChangeListener = new android.widget.SeekBar.OnSeekBarChangeListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = false;
                    if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlVisible) {
                        com.up366.mobile.common.utils.ViewUtil.invisible(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.binding.playMain);
                    }
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.toPlay(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.seekBarProgress, true);
                    if (!com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.isPlaying()) {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startPlayVideo();
                    } else {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startAnim();
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startPlayTimeAnim();
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = true;
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.stopPlayTimeAnim();
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.stopAnim();
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(android.widget.SeekBar seekBar, int i2, boolean z) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoControlEnable) {
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    if (i2 > seekBar.getMax()) {
                        i2 = seekBar.getMax();
                    }
                    if (z) {
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar = true;
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.seekBarProgress = i2;
                        com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.setTimeLabel(i2, seekBar.getMax());
                    }
                }
            }
        };
        init(context, attributeSet, i);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this.binding = (com.up366.mobile.databinding.AnswerVideoViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.answer_video_view_layout, this, true);
        if (isInEditMode()) {
            return;
        }
        this.videoMgr = new com.up366.mobile.book.studyviews.view.video.VideoHelperBase();
        setTimeLabel(0, 0);
        this.binding.seekBar.setSecondaryProgress(0);
        this.binding.seekBarStatic.setSecondaryProgress(0);
        this.binding.seekBar.setOnSeekBarChangeListener(this.seekBarChangeListener);
        this.binding.seekBarStatic.setOnSeekBarChangeListener(this.seekBarChangeListener);
        this.binding.progress.hide();
        stopAnim();
        this.videoMgr.setOnPauseListener(new com.up366.mobile.book.studyviews.view.video.VideoHelperBase.OnPauseListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.OnPauseListener
            public final void onPause() {
                this.f$0.lambda$init$0();
            }
        });
        initViews();
        this.binding.playMain.setOnClickListener(this);
        this.binding.playBtn.setOnClickListener(this);
        this.binding.playBtnStatic.setOnClickListener(this);
        this.binding.fullBtn.setOnClickListener(this);
        this.binding.avvErrorRefresh.setOnClickListener(this);
        this.binding.avvPost.setOnTouchListener(this);
        this.binding.alphaLayer.setOnTouchListener(this);
        this.binding.avvSurface.setOnTouchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        if (this.download) {
            this.doPlay = false;
            if (this.videoControlVisible) {
                com.up366.mobile.common.utils.ViewUtil.visible(this.binding.playMain);
            }
            this.binding.progress.hide();
            stopAnim();
        }
    }

    public void setFullBtnVisible(int i) {
        this.binding.fullBtn.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.videoControlEnable) {
            int id = view.getId();
            if (id == 2131361944) {
                com.up366.mobile.book.studyviews.view.video.AnswerVideoView.DownloadCallBack downloadCallBack = this.downloadCallBack;
                if (downloadCallBack != null) {
                    downloadCallBack.onDownload();
                }
                com.up366.mobile.common.utils.ViewUtil.gone(this.binding.errTip);
                com.up366.mobile.common.utils.ViewUtil.visible(this.binding.loadTip);
                return;
            }
            if (id != 2131362485) {
                switch (id) {
                    case com.up366.mobile.R.id.play_btn /* 2131362976 */:
                    case com.up366.mobile.R.id.play_btn_static /* 2131362977 */:
                    case com.up366.mobile.R.id.play_main /* 2131362978 */:
                        playVideo();
                        break;
                }
            }
            fullScreen();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return true;
        }
        switch (view.getId()) {
            case com.up366.mobile.R.id.alpha_layer /* 2131361902 */:
            case com.up366.mobile.R.id.avv_post /* 2131361946 */:
            case com.up366.mobile.R.id.avv_surface /* 2131361947 */:
                if (this.videoMgr.isPlaying()) {
                    startAnim();
                    break;
                }
            default:
                return true;
        }
    }

    public void destroy() {
        stopAnim();
        com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.avvSurface);
        if (this.videoControlVisible) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.playMain);
        }
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.avvPost, this.binding.alphaLayer);
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.avvSurface);
        this.videoMgr.stopVideo();
        setTimeLabel(0, 0);
        this.doPlay = false;
        this.prepared = false;
    }

    public void fullScreen() {
        if (this.videoMgr.isPlaying()) {
            startAnim();
        }
        if (this.videoMgr.isPlaying()) {
            this.videoMgr.pausePlay();
            com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$fullScreen$1();
                }
            });
        }
        if (this.fullScreen) {
            this.binding.fullBtn.setImageResource(com.up366.mobile.R.drawable.avv_full_btn_01);
            android.app.Activity activity = (android.app.Activity) getContext();
            ((android.widget.FrameLayout) activity.getWindow().getDecorView()).removeView(this.fullscreenContainer);
            this.fullscreenContainer.removeView(this.binding.videoLayout);
            this.fullscreenContainer = null;
            activity.setRequestedOrientation(1);
            addView(this.binding.videoLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            setStatusBarVisibility(true);
        } else {
            removeView(this.binding.videoLayout);
            this.binding.fullBtn.setImageResource(com.up366.mobile.R.drawable.avv_full_btn_02);
            android.app.Activity activity2 = (android.app.Activity) getContext();
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) activity2.getWindow().getDecorView();
            com.up366.mobile.book.studyviews.view.video.FullscreenHolder fullscreenHolder = new com.up366.mobile.book.studyviews.view.video.FullscreenHolder(activity2);
            this.fullscreenContainer = fullscreenHolder;
            fullscreenHolder.addView(this.binding.videoLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.fullscreenContainer, new android.widget.FrameLayout.LayoutParams(-1, -1));
            activity2.setRequestedOrientation(0);
            setStatusBarVisibility(false);
        }
        this.fullScreen = !this.fullScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fullScreen$1() throws java.lang.Exception {
        this.videoMgr.resumeVideo();
        startAnim();
        if (this.videoMgr.isPlaying()) {
            com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.playMain);
        } else if (this.videoControlVisible) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.playMain);
        }
    }

    public void setLeft(float f) {
        if (this.fullScreen) {
            super.setLeft(0);
        } else {
            super.setLeft((int) f);
        }
    }

    public void setTop(float f) {
        if (this.fullScreen) {
            super.setTop(0);
            return;
        }
        if (getHeight() + f < this.binding.staticControlBar.getHeight()) {
            offsetTopAndBottom(this.binding.staticControlBar.getHeight() - getBottom());
            if (this.binding.staticControlBar.getVisibility() == 4) {
                com.up366.mobile.common.utils.AnimUtils.fadeIn(this.binding.staticControlBar);
            }
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.staticControlBar);
            return;
        }
        offsetTopAndBottom((int) (f - getTop()));
        if (this.binding.staticControlBar.getVisibility() == 0) {
            com.up366.mobile.common.utils.AnimUtils.fadeOut(this.binding.staticControlBar);
        }
        com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.staticControlBar);
    }

    private void playVideo() {
        if (this.videoMgr.isPlaying()) {
            pausePlay();
        } else if (this.videoMgr.getCurrentTime() > 0) {
            resumePlayVideo();
        } else {
            startPlayVideo();
        }
    }

    public void setVideoPath(java.lang.String str) {
        this.videoPath = str;
    }

    public void setVideo(java.lang.String str) {
        this.videoPath = str;
        this.videoMgr.setMediaVideo(this.binding.avvSurface, str);
        this.videoMgr.setCallBack(new com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView.2
            int duration = 0;

            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void onMediaStateResult(int i) {
                com.up366.common.log.Logger.debug("video state : " + i);
                if (i == 1) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.binding.playBtn.setImageResource(com.up366.mobile.R.drawable.avv_pause_btn);
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.binding.playBtnStatic.setImageResource(com.up366.mobile.R.drawable.avv_pause_btn);
                } else if (i == 2 || i == 4) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.binding.playBtn.setImageResource(com.up366.mobile.R.drawable.avv_play_btn_bottom);
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.binding.playBtnStatic.setImageResource(com.up366.mobile.R.drawable.avv_play_btn_bottom);
                }
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoCallBack != null) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoCallBack.onMediaStateResult(i);
                }
            }

            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void initDurtionAndPosition(int i, int i2) {
                this.duration = i;
                com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.setTimeLabel(i2, i);
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoCallBack != null) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoCallBack.initDurtionAndPosition(i, i2);
                }
            }

            @Override // com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack
            public void setCurrentPosition(int i) {
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTouchSeekBar) {
                    return;
                }
                com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.setTimeLabel(i, this.duration);
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoCallBack != null) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoCallBack.setCurrentPosition(i);
                }
            }
        });
        this.videoMgr.setOnBufferingUpdateListener(new android.media.MediaPlayer.OnBufferingUpdateListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
                this.f$0.lambda$setVideo$2(mediaPlayer, i);
            }
        });
        this.videoMgr.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                return this.f$0.lambda$setVideo$3(mediaPlayer, i, i2);
            }
        });
        this.videoMgr.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                return this.f$0.lambda$setVideo$4(mediaPlayer, i, i2);
            }
        });
        this.videoMgr.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView$$ExternalSyntheticLambda5
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(android.media.MediaPlayer mediaPlayer) {
                this.f$0.lambda$setVideo$5(mediaPlayer);
            }
        });
        this.videoMgr.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView$$ExternalSyntheticLambda6
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(android.media.MediaPlayer mediaPlayer) {
                this.f$0.lambda$setVideo$6(mediaPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$2(android.media.MediaPlayer mediaPlayer, int i) {
        com.up366.common.log.Logger.debug("on buffer update : " + i);
        this.binding.seekBar.setSecondaryProgress((this.binding.seekBar.getMax() * i) / 100);
        this.binding.seekBarStatic.setSecondaryProgress((i * this.binding.seekBarStatic.getMax()) / 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setVideo$3(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 701) {
            if (!this.videoMgr.isPlaying()) {
                return false;
            }
            this.binding.progress.show();
            return false;
        }
        if (i == 702) {
            this.binding.progress.hide();
            return false;
        }
        android.util.Log.d(TAG, "onInfo: what - " + i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setVideo$4(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        com.up366.common.log.Logger.error("play video fail what : " + i + " extra : " + i2);
        this.doPlay = false;
        pausePlay();
        setVideo(this.videoPath);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$5(android.media.MediaPlayer mediaPlayer) {
        this.prepared = true;
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView.3
            @Override // com.up366.common.task.Task
            public void run() {
                com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.setTimeLabel(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.getCurrentTime(), com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.videoMgr.getDuration());
                if (com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.doPlay) {
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.doPlay = false;
                    com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.startPlayVideo();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideo$6(android.media.MediaPlayer mediaPlayer) {
        pausePlay();
        setTimeLabel(0, this.binding.seekBar.getMax());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeLabel(int i, int i2) {
        this.binding.seekBar.setMax(i2);
        this.binding.seekBarStatic.setMax(i2);
        this.binding.seekBar.setProgress(i);
        this.binding.seekBarStatic.setProgress(i);
        int i3 = i / 1000;
        int i4 = i3 % 60;
        int i5 = i3 / 60;
        int i6 = i2 / 1000;
        int i7 = i6 % 60;
        int i8 = i6 / 60;
        this.binding.timeTextCur.setText(java.lang.String.format(java.util.Locale.getDefault(), "%02d:%02d", java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i4)));
        this.binding.timeTextCurStatic.setText(java.lang.String.format(java.util.Locale.getDefault(), "%02d:%02d", java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i4)));
        this.binding.timeTextTot.setText(java.lang.String.format(java.util.Locale.getDefault(), "%02d:%02d", java.lang.Integer.valueOf(i8), java.lang.Integer.valueOf(i7)));
        this.binding.timeTextTotStatic.setText(java.lang.String.format(java.util.Locale.getDefault(), "%02d:%02d", java.lang.Integer.valueOf(i8), java.lang.Integer.valueOf(i7)));
    }

    public void startPlayVideo() {
        initVideoMute();
        if (this.prepared) {
            this.binding.progress.hide();
            com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.playMain, this.binding.avvPost, this.binding.alphaLayer);
            this.videoMgr.toPlay(0, true);
            startAnim();
            return;
        }
        setVideo(this.videoPath);
        this.binding.progress.show();
        com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.playMain);
        this.doPlay = true;
    }

    public void resumePlayVideo() {
        if (this.prepared) {
            this.binding.progress.hide();
            com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.playMain, this.binding.avvPost, this.binding.alphaLayer);
            this.videoMgr.resumeVideo();
            startAnim();
            return;
        }
        setVideo(this.videoPath);
        this.binding.progress.show();
        com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.playMain);
        this.doPlay = true;
    }

    public void pausePlay() {
        stopAnim();
        this.videoMgr.pausePlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim() {
        if (this.videoControlVisible) {
            com.up366.mobile.common.utils.AnimUtils.delay2sHideAnimFullAfter(this.binding.ctrlContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAnim() {
        if (this.videoControlVisible) {
            com.up366.mobile.common.utils.ViewUtil.clearAnim(this.binding.ctrlContent);
        }
    }

    public void setVideoCallBack(com.up366.mobile.book.studyviews.view.video.VideoHelperBase.IHWVideoCallBack iHWVideoCallBack) {
        this.videoCallBack = iHWVideoCallBack;
    }

    public int getCurrentTime() {
        return this.videoMgr.getCurrentTime();
    }

    public void setPost(java.lang.String str) {
        this.videoPost = str;
        com.up366.common.BitmapUtilsUp.display(this.binding.avvPost, this.videoPost);
    }

    public void setDownload(boolean z) {
        this.download = z;
        if (z) {
            com.up366.mobile.common.utils.ViewUtil.gone(this.binding.loadTip, this.binding.errTip);
            if (this.videoControlVisible) {
                com.up366.mobile.common.utils.ViewUtil.visible(this.binding.playMain, this.binding.ctrlContent);
                return;
            }
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.loadTip);
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.playMain, this.binding.errTip, this.binding.ctrlContent);
    }

    public void setDownloadCallBack(com.up366.mobile.book.studyviews.view.video.AnswerVideoView.DownloadCallBack downloadCallBack) {
        this.downloadCallBack = downloadCallBack;
    }

    public void setDownProgress(int i) {
        this.downProgress = i;
        this.binding.loadProgress.setProgress(i);
        this.binding.loadProgressText.setText(i + "%");
    }

    public void setDownFiled(java.lang.String str) {
        com.up366.mobile.common.utils.ToastPopupUtil.show(str);
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.playBtn, this.binding.loadTip);
        com.up366.mobile.common.utils.ViewUtil.visible(this.binding.errTip);
    }

    public void initViews() {
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.loadTip, this.binding.errTip);
        setVideoControlVisible(this.videoControlVisible);
    }

    public void setUpFullScreenBtn() {
        this.binding.fullBtn.setImageResource(com.up366.mobile.R.drawable.avv_full_btn_01);
    }

    public void setVideoMute(java.lang.String str, boolean z) {
        this.muteFlag = z;
        this.videoMgr.setVideoMute(z);
    }

    private void initVideoMute() {
        this.videoMgr.setVideoMute(this.muteFlag);
    }

    public java.lang.String getVideoImage(java.lang.String str) {
        return bitmapToBase64(com.up366.multimedia.util.SkipUtil.getVideoFrame(0L, this.videoPath));
    }

    public static java.lang.String bitmapToBase64(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
            return android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setVideoControlEnable(boolean z) {
        this.videoControlEnable = z;
    }

    public void setVideoControlVisible(boolean z) {
        this.videoControlVisible = z;
        if (!z) {
            com.up366.mobile.common.utils.ViewUtil.clearAnim(this.binding.ctrlContent, this.binding.playMain);
            com.up366.mobile.common.utils.ViewUtil.gone(this.binding.ctrlContent, this.binding.playMain);
        } else {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.ctrlContent);
            if (this.videoMgr.isPlaying()) {
                return;
            }
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.playMain);
        }
    }

    public int getDuration() {
        return this.videoMgr.getDuration();
    }

    public void onTimeOut() {
        this.videoMgr.onTimeOut();
    }

    private void setStatusBarVisibility(boolean z) {
        ((android.app.Activity) getContext()).getWindow().setFlags(z ? 0 : 1024, 1024);
        hideBottomUIMenu(z);
    }

    protected void hideBottomUIMenu(boolean z) {
        ((android.app.Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(z ? 0 : 4102);
    }

    public boolean isFullScreen() {
        return this.fullScreen;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.up366.mobile.book.studyviews.view.video.AnswerVideoView$4] */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.countDownTimer = new android.os.CountDownTimer(1000L, 100L) { // from class: com.up366.mobile.book.studyviews.view.video.AnswerVideoView.4
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.onTimeOut();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.book.studyviews.view.video.AnswerVideoView.this.countDownTimer.start();
            }
        }.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.countDownTimer.cancel();
        this.countDownTimer = null;
    }
}
