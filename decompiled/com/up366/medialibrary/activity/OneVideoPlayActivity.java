package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OneVideoPlayActivity extends com.up366.medialibrary.activity.PictureBaseActivity {
    private com.up366.medialibrary.model.VideoAttachmentInfo<?> attachmentInfo;
    private android.view.View errorTipView;
    private android.widget.TextView loadTextView;
    private com.up366.medialibrary.views.LoadingProgressView loadingView;
    private com.google.android.exoplayer2.ui.PlayerView mVideoView;
    private android.view.View moreBtn;
    private com.google.android.exoplayer2.SimpleExoPlayer player;
    private com.google.android.exoplayer2.ui.PlayerControlView playerControlView;
    private java.lang.String videoPath;
    private long mPositionWhenPaused = -1;
    com.google.android.exoplayer2.Player.Listener eventListener = new com.google.android.exoplayer2.Player.Listener() { // from class: com.up366.medialibrary.activity.OneVideoPlayActivity.2
        public /* synthetic */ void onAudioAttributesChanged(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onAudioAttributesChanged(this, audioAttributes);
        }

        public /* synthetic */ void onAudioSessionIdChanged(int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onAudioSessionIdChanged(this, i);
        }

        public /* synthetic */ void onAvailableCommandsChanged(com.google.android.exoplayer2.Player.Commands commands) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onAvailableCommandsChanged(this, commands);
        }

        public /* synthetic */ void onCues(com.google.android.exoplayer2.text.CueGroup cueGroup) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onCues(this, cueGroup);
        }

        public /* synthetic */ void onCues(java.util.List list) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onCues(this, list);
        }

        public /* synthetic */ void onDeviceInfoChanged(com.google.android.exoplayer2.DeviceInfo deviceInfo) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onDeviceInfoChanged(this, deviceInfo);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onDeviceVolumeChanged(this, i, z);
        }

        public /* synthetic */ void onEvents(com.google.android.exoplayer2.Player player, com.google.android.exoplayer2.Player.Events events) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onEvents(this, player, events);
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onIsLoadingChanged(this, z);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onIsPlayingChanged(this, z);
        }

        public /* synthetic */ void onLoadingChanged(boolean z) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
        }

        public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.MediaItem mediaItem, int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        public /* synthetic */ void onMediaMetadataChanged(com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onMediaMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onMetadata(this, metadata);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackStateChanged(this, i);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public void onPlayerError(com.google.android.exoplayer2.PlaybackException playbackException) {
        }

        public /* synthetic */ void onPlayerErrorChanged(com.google.android.exoplayer2.PlaybackException playbackException) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlayerErrorChanged(this, playbackException);
        }

        public /* synthetic */ void onPlaylistMetadataChanged(com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPositionDiscontinuity(this, i);
        }

        public /* synthetic */ void onPositionDiscontinuity(com.google.android.exoplayer2.Player.PositionInfo positionInfo, com.google.android.exoplayer2.Player.PositionInfo positionInfo2, int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
        }

        public /* synthetic */ void onRenderedFirstFrame() {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onRenderedFirstFrame(this);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onRepeatModeChanged(this, i);
        }

        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onSeekBackIncrementChanged(this, j);
        }

        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onSeekForwardIncrementChanged(this, j);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onSkipSilenceEnabledChanged(this, z);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onTimelineChanged(this, timeline, i);
        }

        public /* synthetic */ void onTrackSelectionParametersChanged(com.google.android.exoplayer2.trackselection.TrackSelectionParameters trackSelectionParameters) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
        }

        public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.Tracks tracks) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onTracksChanged(this, tracks);
        }

        public /* synthetic */ void onVideoSizeChanged(com.google.android.exoplayer2.video.VideoSize videoSize) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onVideoSizeChanged(this, videoSize);
        }

        public /* synthetic */ void onVolumeChanged(float f) {
            com.google.android.exoplayer2.Player.Listener.-CC.$default$onVolumeChanged(this, f);
        }

        public void onPlayerStateChanged(boolean z, int i) {
            if (i != 2 || !com.up366.medialibrary.activity.OneVideoPlayActivity.this.player.getPlayWhenReady()) {
                com.up366.medialibrary.activity.OneVideoPlayActivity.this.playerControlView.setShowTimeoutMs(5000);
            } else {
                com.up366.medialibrary.activity.OneVideoPlayActivity.this.playerControlView.setShowTimeoutMs(60000);
                com.up366.medialibrary.activity.OneVideoPlayActivity.this.playerControlView.show();
            }
            if (i != 3 || com.up366.medialibrary.activity.OneVideoPlayActivity.this.player.getPlayWhenReady()) {
                com.up366.medialibrary.activity.OneVideoPlayActivity.this.playerControlView.setShowTimeoutMs(5000);
            } else {
                com.up366.medialibrary.activity.OneVideoPlayActivity.this.playerControlView.setShowTimeoutMs(180000);
                com.up366.medialibrary.activity.OneVideoPlayActivity.this.playerControlView.show();
            }
        }
    };

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public boolean isRequestedOrientation() {
        return false;
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        com.up366.medialibrary.common.utils.LightStatusBarUtils.setUpStatusBarLightMode(getWindow(), false);
        super.onCreate(bundle);
        com.up366.medialibrary.model.VideoAttachmentInfo<?> videoAttachmentInfo = (com.up366.medialibrary.model.VideoAttachmentInfo) getIntent().getSerializableExtra("attachmentInfo");
        this.attachmentInfo = videoAttachmentInfo;
        java.lang.String path = videoAttachmentInfo.getPath();
        this.videoPath = path;
        if (com.up366.common.StringUtils.isEmptyOrNull(path)) {
            com.up366.medialibrary.helper.MediaHelperManager.getTools().toastMessage("预览失败，视频资源不存在");
            finish();
        } else {
            initializePlayer();
        }
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public int getResourceId() {
        return com.up366.medialibrary.R.layout.activity_one_video_play;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initializePlayer() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayerBuild = new com.google.android.exoplayer2.SimpleExoPlayer.Builder(this).build();
        this.player = simpleExoPlayerBuild;
        simpleExoPlayerBuild.addListener(this.eventListener);
        this.mVideoView.setPlayer(this.player);
        this.playerControlView = this.mVideoView.findViewById(com.up366.medialibrary.R.id.exo_controller);
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(this.videoPath)) {
            this.mVideoView.setVisibility(0);
            this.player.setMediaItem(com.google.android.exoplayer2.MediaItem.fromUri(getLocalUri(this.videoPath)));
            this.player.prepare();
            this.player.setPlayWhenReady(true);
            return;
        }
        if (com.up366.common.FileUtilsUp.isFileExists(com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalVideoPath(this.videoPath))) {
            this.player.setMediaItem(com.google.android.exoplayer2.MediaItem.fromUri(getLocalUri(this.videoPath)));
            this.player.prepare();
            this.player.setPlayWhenReady(true);
        } else {
            this.loadingView.setVisibility(0);
            this.loadTextView.setVisibility(0);
            this.mVideoView.setVisibility(4);
            this.moreBtn.setVisibility(4);
            toDownload(this.videoPath);
        }
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initWidgets() {
        findViewById(com.up366.medialibrary.R.id.close_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.OneVideoPlayActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m137xf5b9ac97(view);
            }
        });
        android.view.View viewFindViewById = findViewById(com.up366.medialibrary.R.id.more_btn);
        this.moreBtn = viewFindViewById;
        viewFindViewById.setVisibility(com.up366.medialibrary.helper.MediaHelperManager.getPreviewHelper().getConfig().isShowMoreBtn() ? 0 : 4);
        this.moreBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.OneVideoPlayActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m138xfd52b36(view);
            }
        });
        com.google.android.exoplayer2.ui.PlayerView playerViewFindViewById = findViewById(com.up366.medialibrary.R.id.video_view);
        this.mVideoView = playerViewFindViewById;
        playerViewFindViewById.setBackgroundColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        this.loadTextView = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.loading_TextView);
        com.up366.medialibrary.views.LoadingProgressView loadingProgressView = (com.up366.medialibrary.views.LoadingProgressView) findViewById(com.up366.medialibrary.R.id.loading);
        this.loadingView = loadingProgressView;
        loadingProgressView.setTextView(this.loadTextView);
        android.view.View viewFindViewById2 = findViewById(com.up366.medialibrary.R.id.error_layout);
        this.errorTipView = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.OneVideoPlayActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m139x29f0a9d5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initWidgets$0$com-up366-medialibrary-activity-OneVideoPlayActivity, reason: not valid java name */
    /* synthetic */ void m137xf5b9ac97(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: renamed from: lambda$initWidgets$1$com-up366-medialibrary-activity-OneVideoPlayActivity, reason: not valid java name */
    /* synthetic */ void m138xfd52b36(android.view.View view) {
        com.up366.medialibrary.helper.MediaHelperManager.getPreviewHelper().getConfig().getActionListener().onClick(view, this.attachmentInfo);
    }

    /* JADX INFO: renamed from: lambda$initWidgets$2$com-up366-medialibrary-activity-OneVideoPlayActivity, reason: not valid java name */
    /* synthetic */ void m139x29f0a9d5(android.view.View view) {
        this.errorTipView.setVisibility(4);
        this.loadingView.setVisibility(0);
        this.loadTextView.setVisibility(0);
        toDownload(this.videoPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.net.Uri getLocalUri(java.lang.String str) {
        return android.net.Uri.parse((com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(this.videoPath) ? com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalVideoPath(str) : this.videoPath).replace("#", "%23"));
    }

    private void toDownload(java.lang.String str) {
        this.playerControlView.setVisibility(4);
        java.lang.String localVideoPath = com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalVideoPath(str);
        com.up366.common.FileUtilsUp.mkdirParentDir(localVideoPath);
        com.up366.medialibrary.helper.MediaHelperManager.getTools().downloadFile(str, localVideoPath, new com.up366.medialibrary.activity.OneVideoPlayActivity.AnonymousClass1(str, localVideoPath));
    }

    /* JADX INFO: renamed from: com.up366.medialibrary.activity.OneVideoPlayActivity$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.medialibrary.listener.OnDownloadListener {
        final /* synthetic */ java.lang.String val$localPath;
        final /* synthetic */ java.lang.String val$videoPath;

        AnonymousClass1(java.lang.String str, java.lang.String str2) {
            this.val$videoPath = str;
            this.val$localPath = str2;
        }

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onSuccess() {
            final java.lang.String str = this.val$videoPath;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.activity.OneVideoPlayActivity$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.m142xffdd889f(str);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onSuccess$0$com-up366-medialibrary-activity-OneVideoPlayActivity$1, reason: not valid java name */
        /* synthetic */ void m142xffdd889f(java.lang.String str) throws java.lang.Exception {
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.player.setMediaItem(com.google.android.exoplayer2.MediaItem.fromUri(com.up366.medialibrary.activity.OneVideoPlayActivity.this.getLocalUri(str)));
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.player.prepare();
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.player.setPlayWhenReady(false);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.mVideoView.setVisibility(0);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.moreBtn.setVisibility(0);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadingView.setVisibility(4);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadTextView.setVisibility(4);
        }

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onError(int i, java.lang.String str) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(this.val$localPath);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.activity.OneVideoPlayActivity$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.m140x841ccc19();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onError$1$com-up366-medialibrary-activity-OneVideoPlayActivity$1, reason: not valid java name */
        /* synthetic */ void m140x841ccc19() throws java.lang.Exception {
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadingView.setVisibility(4);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadTextView.setVisibility(4);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.errorTipView.setVisibility(0);
        }

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onProgress(final int i, java.lang.String str) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.activity.OneVideoPlayActivity$1$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.m141xfdf73efb(i);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onProgress$2$com-up366-medialibrary-activity-OneVideoPlayActivity$1, reason: not valid java name */
        /* synthetic */ void m141xfdf73efb(int i) throws java.lang.Exception {
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadingView.setVisibility(0);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadTextView.setVisibility(0);
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadTextView.setText(java.lang.Math.min(i, 100) + "%");
            com.up366.medialibrary.activity.OneVideoPlayActivity.this.loadingView.setProgressNum((float) java.lang.Math.min(i, 100), 0);
        }
    }

    public void onPause() {
        this.mPositionWhenPaused = this.player.getCurrentPosition();
        this.player.pause();
        super.onPause();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        long j = this.mPositionWhenPaused;
        if (j >= 0) {
            this.player.seekTo(j);
            this.mPositionWhenPaused = -1L;
        }
        super.onResume();
        com.up366.common.global.GB.get().setCurrentActivity(this);
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onDestroy() {
        super.onDestroy();
        this.mVideoView = null;
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            this.player = null;
        }
    }

    public static void openActivity(android.content.Context context, com.up366.medialibrary.model.VideoAttachmentInfo<?> videoAttachmentInfo) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.medialibrary.activity.OneVideoPlayActivity.class);
        intent.putExtra("attachmentInfo", videoAttachmentInfo);
        context.startActivity(intent);
    }
}
