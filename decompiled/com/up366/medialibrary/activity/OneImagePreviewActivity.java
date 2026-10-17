package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OneImagePreviewActivity extends com.up366.medialibrary.activity.PictureBaseActivity {
    private com.up366.medialibrary.model.ImageAttachmentInfo<?> attachmentInfo;
    private com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView longImageView;
    private android.view.View moreBtn;
    private com.up366.medialibrary.third.photoview.PhotoView photoView;

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public int getResourceId() {
        return com.up366.medialibrary.R.layout.media_one_image_preview;
    }

    public void setContentView(android.view.View view) {
        super.setContentView(view);
        getWindow().requestFeature(12);
        getWindow().setEnterTransition(new android.transition.Fade(1));
        getWindow().setExitTransition(new android.transition.Fade(2));
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.medialibrary.common.utils.LightStatusBarUtils.setUpStatusBarLightMode(getWindow(), true);
        this.attachmentInfo = (com.up366.medialibrary.model.ImageAttachmentInfo) getIntent().getSerializableExtra("attachmentInfo");
        initView();
        initViewData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super.onResume();
        com.up366.common.global.GB.get().setCurrentActivity(this);
    }

    private void initView() {
        this.photoView = (com.up366.medialibrary.third.photoview.PhotoView) findViewById(com.up366.medialibrary.R.id.preview_image);
        this.longImageView = (com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView) findViewById(com.up366.medialibrary.R.id.longImg);
        findViewById(com.up366.medialibrary.R.id.close_btn).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.OneImagePreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m133xb9db8d53(view);
            }
        });
        android.view.View viewFindViewById = findViewById(com.up366.medialibrary.R.id.more_btn);
        this.moreBtn = viewFindViewById;
        viewFindViewById.setVisibility(com.up366.medialibrary.helper.MediaHelperManager.getPreviewHelper().getConfig().isShowMoreBtn() ? 0 : 4);
        this.moreBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.OneImagePreviewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m134xdf6f9654(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-up366-medialibrary-activity-OneImagePreviewActivity, reason: not valid java name */
    /* synthetic */ void m133xb9db8d53(android.view.View view) {
        onBackPressed();
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-up366-medialibrary-activity-OneImagePreviewActivity, reason: not valid java name */
    /* synthetic */ void m134xdf6f9654(android.view.View view) {
        com.up366.medialibrary.helper.MediaHelperManager.getPreviewHelper().getConfig().getActionListener().onClick(view, this.attachmentInfo);
    }

    private void initViewData() {
        java.lang.String path = this.attachmentInfo.getPath();
        java.lang.String localImagePath = com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalImagePath(path);
        if (com.up366.common.FileUtilsUp.isFileExists(localImagePath) || !com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(path)) {
            com.up366.medialibrary.model.MediaExtraInfo imageSize = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(localImagePath);
            showLocal(com.up366.medialibrary.common.utils.MediaUtils.isLargeImg(imageSize.getWidth(), imageSize.getHeight()), localImagePath);
        } else {
            showPleaseDialog();
            this.moreBtn.setVisibility(4);
            com.up366.medialibrary.helper.MediaHelperManager.getTools().downloadFile(path, localImagePath, new com.up366.medialibrary.activity.OneImagePreviewActivity.AnonymousClass1(localImagePath));
        }
    }

    /* JADX INFO: renamed from: com.up366.medialibrary.activity.OneImagePreviewActivity$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.medialibrary.listener.OnDownloadListener {
        final /* synthetic */ java.lang.String val$localPath;

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onProgress(int i, java.lang.String str) {
        }

        AnonymousClass1(java.lang.String str) {
            this.val$localPath = str;
        }

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onSuccess() {
            final java.lang.String str = this.val$localPath;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.activity.OneImagePreviewActivity$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.m136xa45f015(str);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onSuccess$0$com-up366-medialibrary-activity-OneImagePreviewActivity$1, reason: not valid java name */
        /* synthetic */ void m136xa45f015(java.lang.String str) throws java.lang.Exception {
            com.up366.medialibrary.model.MediaExtraInfo imageSize = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(str);
            com.up366.medialibrary.activity.OneImagePreviewActivity.this.showLocal(com.up366.medialibrary.common.utils.MediaUtils.isLargeImg(imageSize.getWidth(), imageSize.getHeight()), str);
            com.up366.medialibrary.activity.OneImagePreviewActivity.this.moreBtn.setVisibility(0);
        }

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onError(int i, java.lang.String str) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(this.val$localPath);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.activity.OneImagePreviewActivity$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.m135xc853425b();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onError$1$com-up366-medialibrary-activity-OneImagePreviewActivity$1, reason: not valid java name */
        /* synthetic */ void m135xc853425b() throws java.lang.Exception {
            com.bumptech.glide.Glide.with(com.up366.medialibrary.activity.OneImagePreviewActivity.this).load(java.lang.Integer.valueOf(com.up366.medialibrary.R.drawable.picture_image_placeholder)).into(com.up366.medialibrary.activity.OneImagePreviewActivity.this.photoView);
            com.up366.medialibrary.activity.OneImagePreviewActivity.this.dismissDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showLocal(boolean z, java.lang.String str) {
        if (z) {
            android.net.Uri uriFromFile = com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str) ? android.net.Uri.parse(str) : android.net.Uri.fromFile(new java.io.File(str));
            this.longImageView.setOnImageEventListener(new com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView.DefaultOnImageEventListener() { // from class: com.up366.medialibrary.activity.OneImagePreviewActivity.2
                @Override // com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView.DefaultOnImageEventListener, com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView.OnImageEventListener
                public void onDrawOver() {
                    super.onDrawOver();
                    com.up366.medialibrary.activity.OneImagePreviewActivity.this.dismissDialog();
                }
            });
            com.up366.medialibrary.common.utils.LongImageUtils.displayLongPic(uriFromFile, this.longImageView);
        } else {
            com.up366.medialibrary.common.engine.GlideEngine.createGlideEngine().loadImage(this, str, this.photoView);
            dismissDialog();
        }
    }

    public static void openActivity(android.content.Context context, com.up366.medialibrary.model.ImageAttachmentInfo<?> imageAttachmentInfo) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.medialibrary.activity.OneImagePreviewActivity.class);
        intent.putExtra("attachmentInfo", imageAttachmentInfo);
        context.startActivity(intent, android.app.ActivityOptions.makeSceneTransitionAnimation((android.app.Activity) context, new android.util.Pair[0]).toBundle());
    }
}
