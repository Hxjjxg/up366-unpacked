package com.up366.medialibrary.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OneAttachmentView extends android.widget.FrameLayout {
    private com.up366.medialibrary.model.AttachmentInfo attachmentInfo;
    private final android.view.View.OnClickListener clickListener;
    private android.widget.TextView durationTextView;
    private android.view.View ivPlayView;
    private android.util.Size maxSize;
    private android.widget.ImageView photoView;
    private android.view.View rootView;
    private int roundingRadius;
    private int videoThnumbnailRadius;

    public OneAttachmentView(android.content.Context context) {
        super(context);
        this.roundingRadius = 0;
        this.videoThnumbnailRadius = 0;
        this.clickListener = new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.views.OneAttachmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
                    return;
                }
                if (com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo instanceof com.up366.medialibrary.model.ImageAttachmentInfo) {
                    com.up366.medialibrary.activity.OneImagePreviewActivity.openActivity(com.up366.medialibrary.views.OneAttachmentView.this.getContext(), (com.up366.medialibrary.model.ImageAttachmentInfo) com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo);
                } else if (com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo instanceof com.up366.medialibrary.model.VideoAttachmentInfo) {
                    com.up366.medialibrary.activity.OneVideoPlayActivity.openActivity(com.up366.medialibrary.views.OneAttachmentView.this.getContext(), (com.up366.medialibrary.model.VideoAttachmentInfo) com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo);
                }
            }
        };
        initView(null);
    }

    public OneAttachmentView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.roundingRadius = 0;
        this.videoThnumbnailRadius = 0;
        this.clickListener = new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.views.OneAttachmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
                    return;
                }
                if (com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo instanceof com.up366.medialibrary.model.ImageAttachmentInfo) {
                    com.up366.medialibrary.activity.OneImagePreviewActivity.openActivity(com.up366.medialibrary.views.OneAttachmentView.this.getContext(), (com.up366.medialibrary.model.ImageAttachmentInfo) com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo);
                } else if (com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo instanceof com.up366.medialibrary.model.VideoAttachmentInfo) {
                    com.up366.medialibrary.activity.OneVideoPlayActivity.openActivity(com.up366.medialibrary.views.OneAttachmentView.this.getContext(), (com.up366.medialibrary.model.VideoAttachmentInfo) com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo);
                }
            }
        };
        initView(attributeSet);
    }

    public OneAttachmentView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.roundingRadius = 0;
        this.videoThnumbnailRadius = 0;
        this.clickListener = new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.views.OneAttachmentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
                    return;
                }
                if (com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo instanceof com.up366.medialibrary.model.ImageAttachmentInfo) {
                    com.up366.medialibrary.activity.OneImagePreviewActivity.openActivity(com.up366.medialibrary.views.OneAttachmentView.this.getContext(), (com.up366.medialibrary.model.ImageAttachmentInfo) com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo);
                } else if (com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo instanceof com.up366.medialibrary.model.VideoAttachmentInfo) {
                    com.up366.medialibrary.activity.OneVideoPlayActivity.openActivity(com.up366.medialibrary.views.OneAttachmentView.this.getContext(), (com.up366.medialibrary.model.VideoAttachmentInfo) com.up366.medialibrary.views.OneAttachmentView.this.attachmentInfo);
                }
            }
        };
        initView(attributeSet);
    }

    private void initView(android.util.AttributeSet attributeSet) {
        android.view.View viewInflate = android.view.LayoutInflater.from(getContext()).inflate(com.up366.medialibrary.R.layout.media_one_attachment_view, (android.view.ViewGroup) this, true);
        this.rootView = viewInflate;
        this.photoView = (android.widget.ImageView) viewInflate.findViewById(com.up366.medialibrary.R.id.preview_image);
        this.ivPlayView = this.rootView.findViewById(com.up366.medialibrary.R.id.iv_play);
        this.durationTextView = (android.widget.TextView) this.rootView.findViewById(com.up366.medialibrary.R.id.duration);
        this.maxSize = com.up366.medialibrary.common.utils.AttachmentViewUtils.getImageMaxSize(getContext());
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.medialibrary.R.styleable.media_OneAttachmentView);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.up366.medialibrary.R.styleable.media_OneAttachmentView_media_max_width, com.up366.common.DpUtilsUp.dp2px(100.0f));
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.up366.medialibrary.R.styleable.media_OneAttachmentView_media_max_height, com.up366.common.DpUtilsUp.dp2px(100.0f));
            this.roundingRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.up366.medialibrary.R.styleable.media_OneAttachmentView_media_image_rounding_radius, 0);
            this.videoThnumbnailRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.up366.medialibrary.R.styleable.media_OneAttachmentView_media_video_thnumbnail_rounding_radius, 0);
            this.maxSize = new android.util.Size(dimensionPixelSize, dimensionPixelSize2);
            typedArrayObtainStyledAttributes.recycle();
        }
        setOnClickListener(this.clickListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.task.TaskUtils.postMainTaskDelay(25L, new com.up366.common.task.Task() { // from class: com.up366.medialibrary.views.OneAttachmentView$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.m176xe2d37667();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAttachedToWindow$0$com-up366-medialibrary-views-OneAttachmentView, reason: not valid java name */
    /* synthetic */ void m176xe2d37667() throws java.lang.Exception {
        if (getHeight() == 0 || getHeight() >= 100) {
            return;
        }
        this.ivPlayView.getLayoutParams().height = com.up366.common.DpUtilsUp.dp2px(10.0f);
        this.ivPlayView.getLayoutParams().width = com.up366.common.DpUtilsUp.dp2px(10.0f);
    }

    public void setData(com.up366.medialibrary.model.AttachmentInfo attachmentInfo) {
        com.up366.common.log.Logger.info("OneAttachmentView  " + com.alibaba.fastjson.JSON.toJSONString(attachmentInfo));
        this.attachmentInfo = attachmentInfo;
        this.ivPlayView.setVisibility(8);
        this.durationTextView.setVisibility(8);
        if (attachmentInfo.isVideo()) {
            com.up366.medialibrary.model.VideoAttachmentInfo videoAttachmentInfo = (com.up366.medialibrary.model.VideoAttachmentInfo) attachmentInfo;
            if (videoAttachmentInfo.getDuration() > 0) {
                this.durationTextView.setVisibility(0);
                this.durationTextView.setText(com.up366.medialibrary.common.utils.DateUtils.formatSecondDurationTime(videoAttachmentInfo.getDuration()));
            }
            this.ivPlayView.setVisibility(0);
            com.up366.medialibrary.common.utils.AttachmentViewUtils.showVideoThnumbnail(this.photoView, attachmentInfo, this.maxSize, this.videoThnumbnailRadius);
            return;
        }
        if (attachmentInfo.isPicture()) {
            com.up366.medialibrary.common.utils.AttachmentViewUtils.showImageThnumbnail(this.photoView, attachmentInfo, this.maxSize, this.roundingRadius);
        }
    }
}
