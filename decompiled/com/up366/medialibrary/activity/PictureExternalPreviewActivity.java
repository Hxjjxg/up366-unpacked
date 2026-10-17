package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureExternalPreviewActivity extends com.up366.medialibrary.activity.PictureBaseActivity implements android.view.View.OnClickListener {
    private com.up366.medialibrary.activity.PictureExternalPreviewActivity.SimpleFragmentAdapter adapter;
    private java.lang.String downloadPath;
    private android.widget.ImageButton ibDelete;
    private android.widget.ImageButton ibLeftBack;
    private java.lang.String mMimeType;
    private int mScreenHeight;
    private int mScreenWidth;
    private android.view.View mTitleBar;
    private android.widget.TextView tvTitle;
    private com.up366.medialibrary.widget.PreviewViewPager viewPager;
    private final java.util.List<com.up366.medialibrary.model.LocalMedia> images = new java.util.ArrayList();
    private int position = 0;

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public int getResourceId() {
        return com.up366.medialibrary.R.layout.picture_activity_external_preview;
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.mTitleBar = findViewById(com.up366.medialibrary.R.id.titleBar);
        this.tvTitle = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_title);
        this.ibLeftBack = (android.widget.ImageButton) findViewById(com.up366.medialibrary.R.id.left_back);
        this.ibDelete = (android.widget.ImageButton) findViewById(com.up366.medialibrary.R.id.ib_delete);
        this.viewPager = (com.up366.medialibrary.widget.PreviewViewPager) findViewById(com.up366.medialibrary.R.id.preview_pager);
        this.position = getIntent().getIntExtra("position", 0);
        this.mScreenWidth = com.up366.medialibrary.common.utils.ScreenUtils.getScreenWidth(getContext());
        this.mScreenHeight = com.up366.medialibrary.common.utils.ScreenUtils.getScreenHeight(getContext());
        java.util.ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_SELECT_LIST);
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            this.images.addAll(parcelableArrayListExtra);
        }
        this.ibLeftBack.setOnClickListener(this);
        this.ibDelete.setOnClickListener(this);
        this.ibDelete.setVisibility((com.up366.medialibrary.config.PictureSelectionConfig.style == null || !com.up366.medialibrary.config.PictureSelectionConfig.style.pictureExternalPreviewGonePreviewDelete) ? 8 : 0);
        initViewPageAdapterData();
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public void initPictureSelectorStyle() {
        if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.tvTitle.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.tvTitle.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.ibLeftBack.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureExternalPreviewDeleteStyle != 0) {
                this.ibDelete.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureExternalPreviewDeleteStyle);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleBarBackgroundColor != 0) {
                this.mTitleBar.setBackgroundColor(this.colorPrimary);
                return;
            }
            return;
        }
        int typeValueColor = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_ac_preview_title_bg);
        if (typeValueColor != 0) {
            this.mTitleBar.setBackgroundColor(typeValueColor);
        } else {
            this.mTitleBar.setBackgroundColor(this.colorPrimary);
        }
    }

    private void initViewPageAdapterData() {
        this.tvTitle.setText(getString(com.up366.medialibrary.R.string.picture_preview_image_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.position + 1), java.lang.Integer.valueOf(this.images.size())}));
        com.up366.medialibrary.activity.PictureExternalPreviewActivity.SimpleFragmentAdapter simpleFragmentAdapter = new com.up366.medialibrary.activity.PictureExternalPreviewActivity.SimpleFragmentAdapter();
        this.adapter = simpleFragmentAdapter;
        this.viewPager.setAdapter(simpleFragmentAdapter);
        this.viewPager.setCurrentItem(this.position);
        this.viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity.1
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.tvTitle.setText(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.getString(com.up366.medialibrary.R.string.picture_preview_image_num, new java.lang.Object[]{java.lang.Integer.valueOf(i + 1), java.lang.Integer.valueOf(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.images.size())}));
                com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.position = i;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.up366.medialibrary.R.id.left_back) {
            finish();
            exitAnimation();
            return;
        }
        if (id != com.up366.medialibrary.R.id.ib_delete || this.images.size() <= 0) {
            return;
        }
        int currentItem = this.viewPager.getCurrentItem();
        this.images.remove(currentItem);
        this.adapter.removeCacheView(currentItem);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("position", currentItem);
        com.up366.medialibrary.manager.BroadcastManager.getInstance(getContext()).action(com.up366.medialibrary.manager.BroadcastManager.ACTION_DELETE_PREVIEW_POSITION).extras(bundle).broadcast();
        if (this.images.size() == 0) {
            onBackPressed();
            return;
        }
        this.tvTitle.setText(getString(com.up366.medialibrary.R.string.picture_preview_image_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.position + 1), java.lang.Integer.valueOf(this.images.size())}));
        this.position = currentItem;
        this.adapter.notifyDataSetChanged();
    }

    public class SimpleFragmentAdapter extends androidx.viewpager.widget.PagerAdapter {
        private static final int MAX_CACHE_SIZE = 20;
        private final android.util.SparseArray<android.view.View> mCacheView = new android.util.SparseArray<>();

        public int getItemPosition(java.lang.Object obj) {
            return -2;
        }

        public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
            return view == obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.mCacheView.clear();
        }

        public void removeCacheView(int i) {
            if (i < this.mCacheView.size()) {
                this.mCacheView.removeAt(i);
            }
        }

        public SimpleFragmentAdapter() {
        }

        public int getCount() {
            return com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.images.size();
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
            java.lang.String compressPath;
            android.view.View viewInflate = this.mCacheView.get(i);
            if (viewInflate == null) {
                viewInflate = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.up366.medialibrary.R.layout.picture_image_preview, viewGroup, false);
                this.mCacheView.put(i, viewInflate);
            }
            ?? r2 = (com.up366.medialibrary.third.photoview.PhotoView) viewInflate.findViewById(com.up366.medialibrary.R.id.preview_image);
            com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView subsamplingScaleImageView = (com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView) viewInflate.findViewById(com.up366.medialibrary.R.id.longImg);
            android.widget.ImageView imageView = (android.widget.ImageView) viewInflate.findViewById(com.up366.medialibrary.R.id.iv_play);
            final com.up366.medialibrary.model.LocalMedia localMedia = (com.up366.medialibrary.model.LocalMedia) com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.images.get(i);
            if (com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.config.isAutoScalePreviewImage) {
                float fMin = java.lang.Math.min(localMedia.getWidth(), localMedia.getHeight());
                float fMax = java.lang.Math.max(localMedia.getHeight(), localMedia.getWidth());
                if (fMin > 0.0f && fMax > 0.0f) {
                    int iCeil = (int) java.lang.Math.ceil((fMax * fMin) / fMin);
                    android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) r2.getLayoutParams();
                    layoutParams.width = com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.mScreenWidth;
                    if (iCeil < com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.mScreenHeight) {
                        iCeil += com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.mScreenHeight;
                    }
                    layoutParams.height = iCeil;
                    layoutParams.gravity = 17;
                }
            }
            if (localMedia.isCut() && !localMedia.isCompressed()) {
                compressPath = localMedia.getCutPath();
            } else if (localMedia.isCompressed() || (localMedia.isCut() && localMedia.isCompressed())) {
                compressPath = localMedia.getCompressPath();
            } else if (localMedia.isToSandboxPath()) {
                compressPath = localMedia.getAndroidQToPath();
            } else {
                compressPath = localMedia.getPath();
            }
            final java.lang.String str = compressPath;
            boolean zIsHttp = com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str);
            java.lang.String imageMimeType = (zIsHttp && android.text.TextUtils.isEmpty(localMedia.getMimeType())) ? com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
            boolean zIsVideo = com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(imageMimeType);
            int i2 = 8;
            imageView.setVisibility(zIsVideo ? 0 : 8);
            boolean zIsGif = com.up366.medialibrary.common.utils.MimeTypeUtils.isGif(imageMimeType);
            boolean zIsLongImg = com.up366.medialibrary.common.utils.MediaUtils.isLongImg(localMedia);
            r2.setVisibility((!zIsLongImg || zIsGif) ? 0 : 8);
            if (zIsLongImg && !zIsGif) {
                i2 = 0;
            }
            subsamplingScaleImageView.setVisibility(i2);
            if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != null) {
                if (zIsHttp) {
                    com.up366.medialibrary.config.PictureSelectionConfig.imageEngine.loadImage(viewInflate.getContext(), str, r2, subsamplingScaleImageView, new com.up366.medialibrary.listener.OnImageCompleteCallback() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity.SimpleFragmentAdapter.1
                        @Override // com.up366.medialibrary.listener.OnImageCompleteCallback
                        public void onShowLoading() {
                            if (android.text.TextUtils.equals(str, ((com.up366.medialibrary.model.LocalMedia) com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.images.get(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.viewPager.getCurrentItem())).getPath())) {
                                com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.showPleaseDialog();
                            }
                        }

                        @Override // com.up366.medialibrary.listener.OnImageCompleteCallback
                        public void onHideLoading() {
                            com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.dismissDialog();
                        }
                    });
                } else if (zIsLongImg) {
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.displayLongPic(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str) ? android.net.Uri.parse(str) : android.net.Uri.fromFile(new java.io.File(str)), subsamplingScaleImageView);
                } else {
                    com.up366.medialibrary.config.PictureSelectionConfig.imageEngine.loadImage(viewInflate.getContext(), str, r2);
                }
            }
            r2.setOnViewTapListener(new com.up366.medialibrary.third.photoview.OnViewTapListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda0
                @Override // com.up366.medialibrary.third.photoview.OnViewTapListener
                public final void onViewTap(android.view.View view, float f, float f2) {
                    this.f$0.m150xd4e7e958(view, f, f2);
                }
            });
            subsamplingScaleImageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.m151x1a892bf7(view);
                }
            });
            if (!zIsVideo) {
                subsamplingScaleImageView.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(android.view.View view) {
                        return this.f$0.m152x602a6e96(str, localMedia, view);
                    }
                });
            }
            if (!zIsVideo) {
                r2.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(android.view.View view) {
                        return this.f$0.m153xa5cbb135(str, localMedia, view);
                    }
                });
            }
            imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity$SimpleFragmentAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.SimpleFragmentAdapter.lambda$instantiateItem$4(localMedia, str, viewGroup, view);
                }
            });
            viewGroup.addView(viewInflate, 0);
            return viewInflate;
        }

        /* JADX INFO: renamed from: lambda$instantiateItem$0$com-up366-medialibrary-activity-PictureExternalPreviewActivity$SimpleFragmentAdapter, reason: not valid java name */
        /* synthetic */ void m150xd4e7e958(android.view.View view, float f, float f2) {
            com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.finish();
            com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.exitAnimation();
        }

        /* JADX INFO: renamed from: lambda$instantiateItem$1$com-up366-medialibrary-activity-PictureExternalPreviewActivity$SimpleFragmentAdapter, reason: not valid java name */
        /* synthetic */ void m151x1a892bf7(android.view.View view) {
            com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.finish();
            com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.exitAnimation();
        }

        /* JADX INFO: renamed from: lambda$instantiateItem$2$com-up366-medialibrary-activity-PictureExternalPreviewActivity$SimpleFragmentAdapter, reason: not valid java name */
        /* synthetic */ boolean m152x602a6e96(java.lang.String str, com.up366.medialibrary.model.LocalMedia localMedia, android.view.View view) {
            if (com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.config.isNotPreviewDownload) {
                if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.getContext(), com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.downloadPath = str;
                    java.lang.String imageMimeType = (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str) && android.text.TextUtils.isEmpty(localMedia.getMimeType())) ? com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity pictureExternalPreviewActivity = com.up366.medialibrary.activity.PictureExternalPreviewActivity.this;
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isJPG(imageMimeType)) {
                        imageMimeType = "image/jpeg";
                    }
                    pictureExternalPreviewActivity.mMimeType = imageMimeType;
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
            }
            return true;
        }

        /* JADX INFO: renamed from: lambda$instantiateItem$3$com-up366-medialibrary-activity-PictureExternalPreviewActivity$SimpleFragmentAdapter, reason: not valid java name */
        /* synthetic */ boolean m153xa5cbb135(java.lang.String str, com.up366.medialibrary.model.LocalMedia localMedia, android.view.View view) {
            if (com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.config.isNotPreviewDownload) {
                if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.getContext(), com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.downloadPath = str;
                    java.lang.String imageMimeType = (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str) && android.text.TextUtils.isEmpty(localMedia.getMimeType())) ? com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity pictureExternalPreviewActivity = com.up366.medialibrary.activity.PictureExternalPreviewActivity.this;
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isJPG(imageMimeType)) {
                        imageMimeType = "image/jpeg";
                    }
                    pictureExternalPreviewActivity.mMimeType = imageMimeType;
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
            }
            return true;
        }

        static /* synthetic */ void lambda$instantiateItem$4(com.up366.medialibrary.model.LocalMedia localMedia, java.lang.String str, android.view.ViewGroup viewGroup, android.view.View view) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.customVideoPlayCallback != null) {
                com.up366.medialibrary.config.PictureSelectionConfig.customVideoPlayCallback.startPlayVideo(localMedia);
                return;
            }
            android.content.Intent intent = new android.content.Intent();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(com.up366.medialibrary.config.PictureConstants.EXTRA_VIDEO_PATH, str);
            intent.putExtras(bundle);
            com.up366.medialibrary.common.utils.JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, com.up366.medialibrary.config.PictureConstants.PREVIEW_VIDEO_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayLongPic(android.net.Uri uri, com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(com.up366.medialibrary.widget.longimage.ImageSource.uri(uri), new com.up366.medialibrary.widget.longimage.ImageViewState(0.0f, new android.graphics.PointF(0.0f, 0.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownLoadDialog() {
        if (isFinishing() || android.text.TextUtils.isEmpty(this.downloadPath)) {
            return;
        }
        final com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog = new com.up366.medialibrary.common.dialog.PictureCustomDialog(getContext(), com.up366.medialibrary.R.layout.picture_wind_base_dialog);
        android.widget.Button button = (android.widget.Button) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btn_cancel);
        android.widget.Button button2 = (android.widget.Button) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btn_commit);
        android.widget.TextView textView = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tvTitle);
        android.widget.TextView textView2 = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tv_content);
        textView.setText(getString(com.up366.medialibrary.R.string.picture_prompt));
        textView2.setText(getString(com.up366.medialibrary.R.string.picture_prompt_content));
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m148xa529f0a5(pictureCustomDialog, view);
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) throws java.lang.Throwable {
                this.f$0.m149x238af484(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showDownLoadDialog$0$com-up366-medialibrary-activity-PictureExternalPreviewActivity, reason: not valid java name */
    /* synthetic */ void m148xa529f0a5(com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog, android.view.View view) {
        if (isFinishing()) {
            return;
        }
        pictureCustomDialog.dismiss();
    }

    /* JADX INFO: renamed from: lambda$showDownLoadDialog$1$com-up366-medialibrary-activity-PictureExternalPreviewActivity, reason: not valid java name */
    /* synthetic */ void m149x238af484(com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog, android.view.View view) throws java.lang.Throwable {
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(this.downloadPath)) {
            showPleaseDialog();
            com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.lang.String>() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity.2
                @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
                public java.lang.String doInBackground() {
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity pictureExternalPreviewActivity = com.up366.medialibrary.activity.PictureExternalPreviewActivity.this;
                    return pictureExternalPreviewActivity.showLoadingImage(pictureExternalPreviewActivity.downloadPath);
                }

                @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
                public void onSuccess(java.lang.String str) {
                    com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.onSuccessful(str);
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.dismissDialog();
                }
            });
        } else if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            savePictureAlbumAndroidQ(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(this.downloadPath) ? android.net.Uri.parse(this.downloadPath) : android.net.Uri.fromFile(new java.io.File(this.downloadPath)));
        } else {
            savePictureAlbum();
        }
        if (isFinishing()) {
            return;
        }
        pictureCustomDialog.dismiss();
    }

    private void savePictureAlbum() throws java.lang.Throwable {
        java.io.File externalFilesDir;
        java.lang.String absolutePath;
        java.lang.String lastImgSuffix = com.up366.medialibrary.common.utils.MimeTypeUtils.getLastImgSuffix(this.mMimeType);
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            externalFilesDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM);
        } else {
            externalFilesDir = getContext().getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
        }
        if (externalFilesDir != null && !externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() || !externalStorageState.equals("mounted")) {
            absolutePath = externalFilesDir.getAbsolutePath();
        } else {
            absolutePath = externalFilesDir.getAbsolutePath() + java.io.File.separator + com.up366.medialibrary.common.utils.MimeTypeUtils.CAMERA + java.io.File.separator;
        }
        java.io.File file = new java.io.File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        java.io.File file2 = new java.io.File(file, com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_") + lastImgSuffix);
        com.up366.medialibrary.common.utils.PictureFileUtils.copyFile(this.downloadPath, file2.getAbsolutePath());
        onSuccessful(file2.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccessful(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), getString(com.up366.medialibrary.R.string.picture_save_error));
            return;
        }
        new com.up366.medialibrary.lib.PictureMediaScannerConnection(getContext(), str, null);
        com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), getString(com.up366.medialibrary.R.string.picture_save_success) + "\n" + str);
    }

    private void savePictureAlbumAndroidQ(final android.net.Uri uri) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", com.up366.medialibrary.common.utils.MimeTypeUtils.DCIM);
        final android.net.Uri uriInsert = getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), getString(com.up366.medialibrary.R.string.picture_save_error));
        } else {
            com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.lang.String>() { // from class: com.up366.medialibrary.activity.PictureExternalPreviewActivity.3
                @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
                public java.lang.String doInBackground() {
                    try {
                        if (com.up366.medialibrary.common.utils.PictureFileUtils.writeFileFromIS(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.getContext(), uri), com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenOutputStream(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.getContext(), uriInsert))) {
                            return com.up366.medialibrary.common.utils.PictureFileUtils.getPath(com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.getContext(), uriInsert);
                        }
                        return "";
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        return "";
                    }
                }

                @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
                public void onSuccess(java.lang.String str) {
                    com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                    com.up366.medialibrary.activity.PictureExternalPreviewActivity.this.onSuccessful(str);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context, com.up366.medialibrary.activity.PictureExternalPreviewActivity] */
    public java.lang.String showLoadingImage(java.lang.String str) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.OutputStream contentResolverOpenOutputStream;
        java.io.InputStream inputStreamOpenStream;
        android.net.Uri uriFromFile;
        java.io.File externalFilesDir;
        java.lang.String absolutePath;
        ?? r1 = 0;
        r1 = 0;
        try {
        } catch (java.lang.Throwable th2) {
            r1 = str;
            th = th2;
        }
        try {
            try {
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                    uriFromFile = com.up366.medialibrary.common.utils.CameraFileUtils.createImageUri(getContext(), "", this.mMimeType);
                } else {
                    java.lang.String lastImgSuffix = com.up366.medialibrary.common.utils.MimeTypeUtils.getLastImgSuffix(this.mMimeType);
                    java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
                    if (externalStorageState.equals("mounted")) {
                        externalFilesDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM);
                    } else {
                        externalFilesDir = getContext().getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
                    }
                    if (!externalFilesDir.exists()) {
                        externalFilesDir.mkdirs();
                    }
                    if (externalStorageState.equals("mounted")) {
                        absolutePath = externalFilesDir.getAbsolutePath() + java.io.File.separator + com.up366.medialibrary.common.utils.MimeTypeUtils.CAMERA + java.io.File.separator;
                    } else {
                        absolutePath = externalFilesDir.getAbsolutePath();
                    }
                    java.io.File file = new java.io.File(absolutePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    uriFromFile = android.net.Uri.fromFile(new java.io.File(file, com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_") + lastImgSuffix));
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                contentResolverOpenOutputStream = null;
            }
            try {
                contentResolverOpenOutputStream = com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenOutputStream(getContext(), uriFromFile);
                try {
                    inputStreamOpenStream = new java.net.URL(str).openStream();
                    try {
                        if (com.up366.medialibrary.common.utils.PictureFileUtils.writeFileFromIS(inputStreamOpenStream, contentResolverOpenOutputStream)) {
                            java.lang.String path = com.up366.medialibrary.common.utils.PictureFileUtils.getPath(this, uriFromFile);
                            com.up366.medialibrary.common.utils.PictureFileUtils.close(inputStreamOpenStream);
                            com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenOutputStream);
                            return path;
                        }
                    } catch (java.lang.Exception unused) {
                        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                            com.up366.medialibrary.common.utils.MediaUtils.deleteUri(getContext(), uriFromFile);
                        }
                    }
                } catch (java.lang.Exception unused2) {
                    inputStreamOpenStream = null;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    com.up366.medialibrary.common.utils.PictureFileUtils.close(r1);
                    com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenOutputStream);
                    throw th;
                }
            } catch (java.lang.Exception unused3) {
                inputStreamOpenStream = null;
                contentResolverOpenOutputStream = null;
            }
        } catch (java.lang.Exception unused4) {
            inputStreamOpenStream = null;
            uriFromFile = null;
            contentResolverOpenOutputStream = null;
        }
        com.up366.medialibrary.common.utils.PictureFileUtils.close(inputStreamOpenStream);
        com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenOutputStream);
        return null;
    }

    public void onBackPressed() {
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        finish();
        exitAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitAnimation() {
        overridePendingTransition(com.up366.medialibrary.R.anim.picture_anim_fade_in, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    public void finish() {
        super.finish();
        com.up366.medialibrary.activity.PictureExternalPreviewActivity.SimpleFragmentAdapter simpleFragmentAdapter = this.adapter;
        if (simpleFragmentAdapter != null) {
            simpleFragmentAdapter.clear();
        }
        com.up366.medialibrary.config.PictureSelectionConfig.destroy();
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            for (int i2 : iArr) {
                if (i2 == 0) {
                    showDownLoadDialog();
                } else {
                    com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), getString(com.up366.medialibrary.R.string.picture_jurisdiction));
                }
            }
        }
    }
}
