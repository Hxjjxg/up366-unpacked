package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureVideoPlayActivity extends com.up366.medialibrary.activity.PictureBaseActivity implements android.view.View.OnClickListener {
    private android.widget.ImageButton ibLeftBack;
    private long mPositionWhenPaused = -1;
    private com.google.android.exoplayer2.ui.PlayerView mVideoView;
    private com.google.android.exoplayer2.SimpleExoPlayer player;
    private java.lang.String videoPath;

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
        getWindow().addFlags(67108864);
        super.onCreate(bundle);
        initializePlayer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initializePlayer() {
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayerBuild = new com.google.android.exoplayer2.SimpleExoPlayer.Builder(this).build();
        this.player = simpleExoPlayerBuild;
        this.mVideoView.setPlayer(simpleExoPlayerBuild);
        this.mVideoView.setVisibility(0);
        this.player.setMediaItem(com.google.android.exoplayer2.MediaItem.fromUri(android.net.Uri.parse(this.videoPath)));
        this.player.prepare();
        this.player.setPlayWhenReady(true);
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public int getResourceId() {
        return com.up366.medialibrary.R.layout.picture_activity_video_play;
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initPictureSelectorStyle() {
        if (com.up366.medialibrary.config.PictureSelectionConfig.style == null || com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon == 0) {
            return;
        }
        this.ibLeftBack.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon);
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.videoPath = getIntent().getStringExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_VIDEO_PATH);
        boolean booleanExtra = getIntent().getBooleanExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_VIDEO, false);
        if (android.text.TextUtils.isEmpty(this.videoPath)) {
            com.up366.medialibrary.model.LocalMedia localMedia = (com.up366.medialibrary.model.LocalMedia) getIntent().getParcelableExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_KEY);
            if (localMedia == null || android.text.TextUtils.isEmpty(localMedia.getPath())) {
                finish();
                return;
            }
            this.videoPath = localMedia.getPath();
        }
        if (android.text.TextUtils.isEmpty(this.videoPath)) {
            exit();
            return;
        }
        this.ibLeftBack = (android.widget.ImageButton) findViewById(com.up366.medialibrary.R.id.pictureLeftBack);
        this.mVideoView = findViewById(com.up366.medialibrary.R.id.video_view);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.tv_confirm);
        this.mVideoView.setBackgroundColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
        this.ibLeftBack.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView.setVisibility((this.config.selectionMode == 1 && this.config.enPreviewVideo && !booleanExtra) ? 0 : 8);
    }

    public void onPause() {
        this.mPositionWhenPaused = this.player.getCurrentPosition();
        this.player.pause();
        super.onPause();
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onDestroy() {
        this.mVideoView = null;
        this.player.release();
        this.player = null;
        super.onDestroy();
    }

    public void onResume() {
        long j = this.mPositionWhenPaused;
        if (j >= 0) {
            this.player.seekTo(j);
            this.mPositionWhenPaused = -1L;
        }
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.up366.medialibrary.R.id.pictureLeftBack) {
            onBackPressed();
        } else if (id == com.up366.medialibrary.R.id.tv_confirm) {
            java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
            arrayList.add((com.up366.medialibrary.model.LocalMedia) getIntent().getParcelableExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_KEY));
            setResult(-1, new android.content.Intent().putParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST, arrayList));
            onBackPressed();
        }
    }

    public void onBackPressed() {
        if (com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle != null && com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation != 0) {
            finish();
            overridePendingTransition(0, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
        } else {
            exit();
        }
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(new android.content.ContextWrapper(context) { // from class: com.up366.medialibrary.activity.PictureVideoPlayActivity.1
            @Override // android.content.ContextWrapper, android.content.Context
            public java.lang.Object getSystemService(java.lang.String str) {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO.equals(str)) {
                    return getApplicationContext().getSystemService(str);
                }
                return super.getSystemService(str);
            }
        });
    }

    public static void openActivity(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.medialibrary.activity.PictureVideoPlayActivity.class);
        intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_VIDEO_PATH, str);
        intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_VIDEO, true);
        context.startActivity(intent);
    }
}
