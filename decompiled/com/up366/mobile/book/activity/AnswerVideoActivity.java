package com.up366.mobile.book.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AnswerVideoActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.IsBookVActivityMainBinding binding;
    private java.lang.String fileId;
    private com.up366.mobile.book.studyviews.view.video.VideoHelperLDX helper;
    private java.lang.String videoSrc;

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.IsBookVActivityMainBinding isBookVActivityMainBinding = (com.up366.mobile.databinding.IsBookVActivityMainBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.is_book_v_activity_main);
        this.binding = isBookVActivityMainBinding;
        isBookVActivityMainBinding.isbvamTitleBack.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.AnswerVideoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        com.up366.common.EventBusUtilsUp.register(this);
        getWindow().addFlags(128);
        initData();
        initViewData();
        this.binding.video.setFullBtnVisible(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        finish();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        super.onPause();
        this.helper.pausePlay();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        java.lang.String str = this.fileId;
        if (str == null) {
            str = this.videoSrc;
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.LDXVideoResult(str, this.helper.getMaxPlayTime()));
        getWindow().clearFlags(128);
        this.helper.stopVideo();
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    private void initData() {
        java.lang.String stringExtra = getIntent().getStringExtra("book_id");
        this.fileId = getIntent().getStringExtra("video_id");
        this.videoSrc = getIntent().getStringExtra("video_src");
        com.up366.mobile.book.studyviews.view.video.VideoHelperLDX videoHelperLDX = new com.up366.mobile.book.studyviews.view.video.VideoHelperLDX(this.binding.video, stringExtra);
        this.helper = videoHelperLDX;
        videoHelperLDX.setVideoSrc(this.fileId, this.videoSrc);
    }

    private void initViewData() {
        this.helper.initVideo();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onEventMainThread(com.up366.common.event.DownloadEvent downloadEvent) {
        com.up366.mobile.book.studyviews.view.video.VideoHelperLDX videoHelperLDX;
        if (downloadEvent.getDownType() != 12 || (videoHelperLDX = this.helper) == null) {
            return;
        }
        videoHelperLDX.downloadEvent(downloadEvent);
    }
}
