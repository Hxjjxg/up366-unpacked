package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureSimpleFragmentAdapter extends androidx.viewpager.widget.PagerAdapter {
    private static final int MAX_CACHE_SIZE = 20;
    private final com.up366.medialibrary.config.PictureSelectionConfig config;
    private final java.util.List<com.up366.medialibrary.model.LocalMedia> data = new java.util.ArrayList();
    private final android.util.SparseArray<android.view.View> mCacheView = new android.util.SparseArray<>();
    private final int mScreenHeight;
    private final int mScreenWidth;
    private final com.up366.medialibrary.activity.PictureSimpleFragmentAdapter.OnCallBackActivity onBackPressed;

    public interface OnCallBackActivity {
        void onActivityBackPressed();
    }

    public int getItemPosition(java.lang.Object obj) {
        return -2;
    }

    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public void clear() {
        this.mCacheView.clear();
    }

    public void removeCacheView(int i) {
        if (i < this.mCacheView.size()) {
            this.mCacheView.removeAt(i);
        }
    }

    public PictureSimpleFragmentAdapter(android.content.Context context, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig, com.up366.medialibrary.activity.PictureSimpleFragmentAdapter.OnCallBackActivity onCallBackActivity) {
        this.config = pictureSelectionConfig;
        this.onBackPressed = onCallBackActivity;
        this.mScreenWidth = com.up366.medialibrary.common.utils.ScreenUtils.getScreenWidth(context);
        this.mScreenHeight = com.up366.medialibrary.common.utils.ScreenUtils.getScreenHeight(context);
    }

    public void bindData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (list != null) {
            this.data.clear();
            this.data.addAll(list);
        }
    }

    public java.util.List<com.up366.medialibrary.model.LocalMedia> getData() {
        return this.data;
    }

    public int getSize() {
        return this.data.size();
    }

    public void remove(int i) {
        if (getSize() > i) {
            this.data.remove(i);
        }
    }

    public com.up366.medialibrary.model.LocalMedia getItem(int i) {
        if (getSize() <= 0 || i >= getSize()) {
            return null;
        }
        return this.data.get(i);
    }

    public int getCount() {
        return this.data.size();
    }

    public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        viewGroup.removeView((android.view.View) obj);
        if (this.mCacheView.size() > 20) {
            this.mCacheView.remove(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.ImageView, com.up366.medialibrary.third.photoview.PhotoView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public java.lang.Object instantiateItem(final android.view.ViewGroup viewGroup, int i) {
        final java.lang.String compressPath;
        android.view.View viewInflate = this.mCacheView.get(i);
        if (viewInflate == null) {
            viewInflate = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.up366.medialibrary.R.layout.picture_image_preview, viewGroup, false);
            this.mCacheView.put(i, viewInflate);
        }
        ?? r2 = (com.up366.medialibrary.third.photoview.PhotoView) viewInflate.findViewById(com.up366.medialibrary.R.id.preview_image);
        com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView subsamplingScaleImageView = (com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView) viewInflate.findViewById(com.up366.medialibrary.R.id.longImg);
        android.widget.ImageView imageView = (android.widget.ImageView) viewInflate.findViewById(com.up366.medialibrary.R.id.iv_play);
        final com.up366.medialibrary.model.LocalMedia item = getItem(i);
        if (this.config.isAutoScalePreviewImage) {
            float fMin = java.lang.Math.min(item.getWidth(), item.getHeight());
            float fMax = java.lang.Math.max(item.getHeight(), item.getWidth());
            if (fMin > 0.0f && fMax > 0.0f) {
                int iCeil = (int) java.lang.Math.ceil((fMax * fMin) / fMin);
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) r2.getLayoutParams();
                layoutParams.width = this.mScreenWidth;
                int i2 = this.mScreenHeight;
                if (iCeil < i2) {
                    iCeil += i2;
                }
                layoutParams.height = iCeil;
                layoutParams.gravity = 17;
            }
        }
        java.lang.String mimeType = item.getMimeType();
        if (item.isCut() && !item.isCompressed()) {
            compressPath = item.getCutPath();
        } else if (item.isCompressed() || (item.isCut() && item.isCompressed())) {
            compressPath = item.getCompressPath();
        } else {
            compressPath = item.getPath();
        }
        boolean zIsGif = com.up366.medialibrary.common.utils.MimeTypeUtils.isGif(mimeType);
        int i3 = 8;
        imageView.setVisibility(com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(mimeType) ? 0 : 8);
        imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureSimpleFragmentAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.medialibrary.activity.PictureSimpleFragmentAdapter.lambda$instantiateItem$0(item, compressPath, viewGroup, view);
            }
        });
        boolean zIsLongImg = com.up366.medialibrary.common.utils.MediaUtils.isLongImg(item);
        r2.setVisibility((!zIsLongImg || zIsGif) ? 0 : 8);
        r2.setOnViewTapListener(new com.up366.medialibrary.third.photoview.OnViewTapListener() { // from class: com.up366.medialibrary.activity.PictureSimpleFragmentAdapter$$ExternalSyntheticLambda1
            @Override // com.up366.medialibrary.third.photoview.OnViewTapListener
            public final void onViewTap(android.view.View view, float f, float f2) {
                this.f$0.m163x34f7350f(view, f, f2);
            }
        });
        if (zIsLongImg && !zIsGif) {
            i3 = 0;
        }
        subsamplingScaleImageView.setVisibility(i3);
        subsamplingScaleImageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureSimpleFragmentAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m164xc935a4ae(view);
            }
        });
        if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != null) {
            if (zIsLongImg) {
                displayLongPic(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(compressPath) ? android.net.Uri.parse(compressPath) : android.net.Uri.fromFile(new java.io.File(compressPath)), subsamplingScaleImageView);
            } else {
                com.up366.medialibrary.config.PictureSelectionConfig.imageEngine.loadImage(viewInflate.getContext(), compressPath, r2);
            }
        }
        viewGroup.addView(viewInflate, 0);
        return viewInflate;
    }

    static /* synthetic */ void lambda$instantiateItem$0(com.up366.medialibrary.model.LocalMedia localMedia, java.lang.String str, android.view.ViewGroup viewGroup, android.view.View view) {
        if (com.up366.medialibrary.config.PictureSelectionConfig.customVideoPlayCallback != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.customVideoPlayCallback.startPlayVideo(localMedia);
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_VIDEO, true);
        bundle.putString(com.up366.medialibrary.config.PictureConstants.EXTRA_VIDEO_PATH, str);
        intent.putExtras(bundle);
        com.up366.medialibrary.common.utils.JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, com.up366.medialibrary.config.PictureConstants.PREVIEW_VIDEO_CODE);
    }

    /* JADX INFO: renamed from: lambda$instantiateItem$1$com-up366-medialibrary-activity-PictureSimpleFragmentAdapter, reason: not valid java name */
    /* synthetic */ void m163x34f7350f(android.view.View view, float f, float f2) {
        com.up366.medialibrary.activity.PictureSimpleFragmentAdapter.OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }

    /* JADX INFO: renamed from: lambda$instantiateItem$2$com-up366-medialibrary-activity-PictureSimpleFragmentAdapter, reason: not valid java name */
    /* synthetic */ void m164xc935a4ae(android.view.View view) {
        com.up366.medialibrary.activity.PictureSimpleFragmentAdapter.OnCallBackActivity onCallBackActivity = this.onBackPressed;
        if (onCallBackActivity != null) {
            onCallBackActivity.onActivityBackPressed();
        }
    }

    private void displayLongPic(android.net.Uri uri, com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(com.up366.medialibrary.widget.longimage.ImageSource.uri(uri), new com.up366.medialibrary.widget.longimage.ImageViewState(0.0f, new android.graphics.PointF(0.0f, 0.0f), 0));
    }
}
