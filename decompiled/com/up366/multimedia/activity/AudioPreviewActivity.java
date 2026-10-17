package com.up366.multimedia.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AudioPreviewActivity extends android.app.Activity {
    @Override // android.app.Activity
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.afollestad.materialcamera.R.layout.media_attachment_audio_preview_activity);
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.title_tv);
        findViewById(com.afollestad.materialcamera.R.id.back).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.AudioPreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1327x896258be(view);
            }
        });
        com.up366.multimedia.model.MediaAttachInfo mediaAttachInfo = (com.up366.multimedia.model.MediaAttachInfo) getIntent().getSerializableExtra("attachInfo");
        textView.setText(mediaAttachInfo.getName());
        ((com.up366.multimedia.views.AudioPlayView) findViewById(com.afollestad.materialcamera.R.id.audio_play_view)).setData(mediaAttachInfo);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-up366-multimedia-activity-AudioPreviewActivity, reason: not valid java name */
    /* synthetic */ void m1327x896258be(android.view.View view) {
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.MediaStopEvent());
    }
}
