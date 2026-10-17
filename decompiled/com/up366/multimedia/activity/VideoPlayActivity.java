package com.up366.multimedia.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VideoPlayActivity extends android.app.Activity {
    private long mPositionWhenPaused = -1;
    private com.google.android.exoplayer2.SimpleExoPlayer player;
    private com.google.android.exoplayer2.ui.PlayerView playerView;

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.afollestad.materialcamera.R.layout.media_video_play_activity);
        final java.lang.String stringExtra = getIntent().getStringExtra("video_src");
        boolean booleanExtra = getIntent().getBooleanExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IS_ADD_MODEL, false);
        this.playerView = findViewById(com.afollestad.materialcamera.R.id.player);
        findViewById(com.afollestad.materialcamera.R.id.back).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.VideoPlayActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1329xbb14df21(view);
            }
        });
        findViewById(com.afollestad.materialcamera.R.id.video_delete_btn).setVisibility(booleanExtra ? 0 : 4);
        findViewById(com.afollestad.materialcamera.R.id.video_delete_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.VideoPlayActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1330xba9e7922(stringExtra, view);
            }
        });
        com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayerBuild = new com.google.android.exoplayer2.SimpleExoPlayer.Builder(this).build();
        this.player = simpleExoPlayerBuild;
        this.playerView.setPlayer(simpleExoPlayerBuild);
        this.player.setMediaItem(com.google.android.exoplayer2.MediaItem.fromUri(android.net.Uri.parse(stringExtra)));
        this.player.prepare();
        this.player.setPlayWhenReady(false);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-up366-multimedia-activity-VideoPlayActivity, reason: not valid java name */
    /* synthetic */ void m1329xbb14df21(android.view.View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-up366-multimedia-activity-VideoPlayActivity, reason: not valid java name */
    /* synthetic */ void m1330xba9e7922(java.lang.String str, android.view.View view) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.up366.multimedia.views.PictureVideoGridView gridView = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().getGridView();
        for (com.up366.multimedia.util.AlbumHelper.ImageItem imageItem : gridView.getDatas()) {
            if (!str.equals(imageItem.videoPath)) {
                arrayList.add(imageItem);
            }
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.PictureDeleteUpdateEvent(arrayList, gridView.getViewUuid()));
        finish();
    }

    @Override // android.app.Activity
    public void onPause() {
        this.mPositionWhenPaused = this.player.getCurrentPosition();
        this.player.pause();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        long j = this.mPositionWhenPaused;
        if (j >= 0) {
            this.player.seekTo(j);
            this.mPositionWhenPaused = -1L;
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.playerView = null;
        this.player.release();
        this.player = null;
    }
}
