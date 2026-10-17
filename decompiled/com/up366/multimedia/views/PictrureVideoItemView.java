package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PictrureVideoItemView extends android.widget.FrameLayout {
    private android.view.View addBtnView;
    private android.widget.ImageView delView;
    private boolean editMode;
    private boolean isAddModel;
    private com.up366.multimedia.listener.OnPicVideoItemClickListener itemClickListener;
    private int itemSize;
    private com.up366.multimedia.model.PictureVideo pictureVideo;
    private int position;
    private android.widget.ImageView viewPicImage;
    private android.widget.ImageView viewPicVideoBtn;

    public PictrureVideoItemView(android.content.Context context) {
        super(context);
        init(context);
    }

    public PictrureVideoItemView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PictrureVideoItemView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -2;
        requestLayout();
    }

    private void init(android.content.Context context) {
        android.view.View viewInflate = android.view.View.inflate(context, com.afollestad.materialcamera.R.layout.view_picture_video_item, this);
        this.viewPicVideoBtn = (android.widget.ImageView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.view_pic_video_btn);
        this.delView = (android.widget.ImageView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.view_delete_view);
        this.viewPicVideoBtn.setVisibility(8);
        this.delView.setVisibility(8);
        this.viewPicImage = (android.widget.ImageView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.view_pic_image);
        this.addBtnView = viewInflate.findViewById(com.afollestad.materialcamera.R.id.add_btn_layout);
        this.delView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.views.PictrureVideoItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1333lambda$init$0$comup366multimediaviewsPictrureVideoItemView(view);
            }
        });
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.views.PictrureVideoItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1334lambda$init$1$comup366multimediaviewsPictrureVideoItemView(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$init$0$com-up366-multimedia-views-PictrureVideoItemView, reason: not valid java name */
    /* synthetic */ void m1333lambda$init$0$comup366multimediaviewsPictrureVideoItemView(android.view.View view) {
        com.up366.multimedia.listener.OnPicVideoItemClickListener onPicVideoItemClickListener = this.itemClickListener;
        if (onPicVideoItemClickListener != null) {
            onPicVideoItemClickListener.onDeleteItem(view, this.pictureVideo, this.position);
        }
    }

    /* JADX INFO: renamed from: lambda$init$1$com-up366-multimedia-views-PictrureVideoItemView, reason: not valid java name */
    /* synthetic */ void m1334lambda$init$1$comup366multimediaviewsPictrureVideoItemView(android.view.View view) {
        com.up366.multimedia.listener.OnPicVideoItemClickListener onPicVideoItemClickListener = this.itemClickListener;
        if (onPicVideoItemClickListener != null) {
            onPicVideoItemClickListener.onItemClick(view, this.pictureVideo, this.position, this.editMode);
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setData(com.up366.multimedia.model.PictureVideo pictureVideo) {
        this.pictureVideo = pictureVideo;
        this.viewPicVideoBtn.setVisibility(pictureVideo.isVideo() ? 0 : 8);
        this.addBtnView.setVisibility(8);
        this.viewPicImage.setVisibility(8);
        if (pictureVideo.type == 0) {
            this.addBtnView.setVisibility(0);
            return;
        }
        if (pictureVideo.type == 1) {
            this.viewPicImage.setVisibility(0);
            if (!this.isAddModel && this.itemSize == 1) {
                this.viewPicImage.setAdjustViewBounds(true);
                this.viewPicImage.setScaleType(android.widget.ImageView.ScaleType.FIT_START);
            }
            if (pictureVideo.uri != null) {
                com.bumptech.glide.Glide.with(this.viewPicImage).load(pictureVideo.uri).into(this.viewPicImage);
                return;
            } else {
                com.up366.common.BitmapUtilsUp.display(this.viewPicImage, pictureVideo.url, com.afollestad.materialcamera.R.drawable.media_default);
                return;
            }
        }
        this.viewPicImage.setVisibility(0);
        if (!this.isAddModel && this.itemSize == 1) {
            this.viewPicImage.setAdjustViewBounds(true);
            this.viewPicImage.setScaleType(android.widget.ImageView.ScaleType.FIT_START);
        }
        if (pictureVideo.uri != null) {
            com.bumptech.glide.Glide.with(this.viewPicImage).load(pictureVideo.uri).into(this.viewPicImage);
        } else if (pictureVideo.url.startsWith("/")) {
            com.bumptech.glide.Glide.with(this.viewPicImage.getContext()).load(android.net.Uri.fromFile(new java.io.File(pictureVideo.url))).into(this.viewPicImage);
        } else {
            com.bumptech.glide.Glide.with(this.viewPicImage.getContext()).load(android.net.Uri.parse(pictureVideo.url)).into(this.viewPicImage);
        }
    }

    public void setItemClickListener(com.up366.multimedia.listener.OnPicVideoItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
        this.delView.setVisibility(editMode ? 0 : 8);
    }

    public void setModelAndSize(boolean isAddModel, int size) {
        this.isAddModel = isAddModel;
        this.itemSize = size;
    }
}
