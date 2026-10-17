package com.up366.medialibrary.third.ucrop;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureMultiCuttingActivity extends com.up366.medialibrary.third.ucrop.UCropActivity {
    private static final int MIN_NUM = 1;
    private int cutIndex;
    private boolean isAnimation;
    private boolean isCamera;
    private boolean isWithVideoImage;
    private final java.util.ArrayList<com.up366.medialibrary.model.LocalMedia> list = new java.util.ArrayList<>();
    private com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter mAdapter;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private int oldCutIndex;
    private java.lang.String renameCropFilename;

    @Override // com.up366.medialibrary.third.ucrop.UCropActivity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.content.Intent intent = getIntent();
        this.renameCropFilename = intent.getStringExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_RENAME_CROP_FILENAME);
        this.isCamera = intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CAMERA, false);
        this.isWithVideoImage = intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_WITH_VIDEO_IMAGE, false);
        java.util.ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CUT_CROP);
        this.isAnimation = getIntent().getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_MULTIPLE_RECYCLERANIMATION, true);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
            onBackPressed();
            return;
        }
        this.list.addAll(parcelableArrayListExtra);
        if (this.list.size() > 1) {
            initLoadCutData();
            addPhotoRecyclerView();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addPhotoRecyclerView() {
        boolean booleanExtra = getIntent().getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_SKIP_MULTIPLE_CROP, true);
        androidx.recyclerview.widget.RecyclerView recyclerView = new androidx.recyclerview.widget.RecyclerView(this);
        this.mRecyclerView = recyclerView;
        recyclerView.setId(com.up366.medialibrary.R.id.id_recycler);
        this.mRecyclerView.setBackgroundColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_widget_background));
        this.mRecyclerView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, com.up366.medialibrary.common.utils.ScreenUtils.dip2px(this, 80.0f)));
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = new androidx.recyclerview.widget.LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        if (this.isAnimation) {
            this.mRecyclerView.setLayoutAnimation(android.view.animation.AnimationUtils.loadLayoutAnimation(getApplicationContext(), com.up366.medialibrary.R.anim.ucrop_layout_animation_fall_down));
        }
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        ((androidx.recyclerview.widget.SimpleItemAnimator) java.util.Objects.requireNonNull(this.mRecyclerView.getItemAnimator())).setSupportsChangeAnimations(false);
        resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter picturePhotoGalleryAdapter = new com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter(this.list);
        this.mAdapter = picturePhotoGalleryAdapter;
        this.mRecyclerView.setAdapter(picturePhotoGalleryAdapter);
        if (booleanExtra) {
            this.mAdapter.setOnItemClickListener(new com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.OnItemClickListener() { // from class: com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.1
                @Override // com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.OnItemClickListener
                public void onItemClick(int i, android.view.View view) {
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(((com.up366.medialibrary.model.LocalMedia) com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.this.list.get(i)).getMimeType()) || com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.this.cutIndex == i) {
                        return;
                    }
                    com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.this.resetLastCropStatus();
                    com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.this.cutIndex = i;
                    com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity pictureMultiCuttingActivity = com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.this;
                    pictureMultiCuttingActivity.oldCutIndex = pictureMultiCuttingActivity.cutIndex;
                    com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.this.resetCutData();
                }
            });
        }
        this.uCropPhotoBox.addView(this.mRecyclerView);
        changeLayoutParams(this.mShowBottomControls);
        ((android.widget.RelativeLayout.LayoutParams) ((android.widget.FrameLayout) findViewById(com.up366.medialibrary.R.id.ucrop_frame)).getLayoutParams()).addRule(2, com.up366.medialibrary.R.id.id_recycler);
        ((android.widget.RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, com.up366.medialibrary.R.id.controls_wrapper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void resetCutData() {
        android.net.Uri uriFromFile;
        java.lang.String strRename;
        this.uCropPhotoBox.removeView(this.mRecyclerView);
        if (this.mBlockingView != null) {
            this.uCropPhotoBox.removeView(this.mBlockingView);
        }
        setContentView(com.up366.medialibrary.R.layout.ucrop_activity_photobox);
        this.uCropPhotoBox = (android.widget.RelativeLayout) findViewById(com.up366.medialibrary.R.id.ucrop_photobox);
        addBlockingView();
        android.content.Intent intent = getIntent();
        android.os.Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new android.os.Bundle();
        }
        com.up366.medialibrary.model.LocalMedia localMedia = this.list.get(this.cutIndex);
        java.lang.String path = localMedia.getPath();
        boolean zIsHttp = com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(path);
        java.lang.String lastImgType = com.up366.medialibrary.common.utils.MimeTypeUtils.getLastImgType(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(path) ? com.up366.medialibrary.common.utils.PictureFileUtils.getPath(this, android.net.Uri.parse(path)) : path);
        if (localMedia.isToSandboxPath()) {
            uriFromFile = android.net.Uri.fromFile(new java.io.File(localMedia.getAndroidQToPath()));
        } else {
            uriFromFile = (zIsHttp || com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(path)) ? android.net.Uri.parse(path) : android.net.Uri.fromFile(new java.io.File(path));
        }
        extras.putInt(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_INPUT_IMAGE_WIDTH, localMedia.getWidth());
        extras.putInt(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_INPUT_IMAGE_HEIGHT, localMedia.getHeight());
        extras.putParcelable(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_INPUT_URI, uriFromFile);
        java.io.File externalFilesDir = android.os.Environment.getExternalStorageState().equals("mounted") ? getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES) : getCacheDir();
        if (android.text.TextUtils.isEmpty(this.renameCropFilename)) {
            strRename = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_CROP_") + lastImgType;
        } else {
            strRename = this.isCamera ? this.renameCropFilename : com.up366.medialibrary.common.utils.PictureFileUtils.rename(this.renameCropFilename);
        }
        extras.putParcelable(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_URI, android.net.Uri.fromFile(new java.io.File(externalFilesDir, strRename)));
        intent.putExtras(extras);
        setupViews(intent);
        refreshPhotoRecyclerData();
        setImageData(intent);
        setInitialState();
        double dDip2px = this.cutIndex * com.up366.medialibrary.common.utils.ScreenUtils.dip2px(this, 60.0f);
        if (dDip2px > ((double) this.mScreenWidth) * 0.8d) {
            this.mRecyclerView.scrollBy(com.up366.medialibrary.common.utils.ScreenUtils.dip2px(this, 60.0f), 0);
        } else if (dDip2px < ((double) this.mScreenWidth) * 0.4d) {
            this.mRecyclerView.scrollBy(com.up366.medialibrary.common.utils.ScreenUtils.dip2px(this, -60.0f), 0);
        }
    }

    private void refreshPhotoRecyclerData() {
        resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        this.mAdapter.notifyItemChanged(this.cutIndex);
        this.uCropPhotoBox.addView(this.mRecyclerView);
        changeLayoutParams(this.mShowBottomControls);
        ((android.widget.RelativeLayout.LayoutParams) ((android.widget.FrameLayout) findViewById(com.up366.medialibrary.R.id.ucrop_frame)).getLayoutParams()).addRule(2, com.up366.medialibrary.R.id.id_recycler);
        ((android.widget.RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, com.up366.medialibrary.R.id.controls_wrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetLastCropStatus() {
        int i;
        int size = this.list.size();
        if (size <= 1 || size <= (i = this.oldCutIndex)) {
            return;
        }
        this.list.get(i).setCut(false);
        this.mAdapter.notifyItemChanged(this.cutIndex);
    }

    private void resetCutDataStatus() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            this.list.get(i).setCut(false);
        }
    }

    private void initLoadCutData() {
        java.util.ArrayList<com.up366.medialibrary.model.LocalMedia> arrayList = this.list;
        if (arrayList == null || arrayList.size() == 0) {
            onBackPressed();
            return;
        }
        int size = this.list.size();
        if (this.isWithVideoImage) {
            getIndex(size);
        }
    }

    private void getIndex(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            com.up366.medialibrary.model.LocalMedia localMedia = this.list.get(i2);
            if (localMedia != null && com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType())) {
                this.cutIndex = i2;
                return;
            }
        }
    }

    private void changeLayoutParams(boolean z) {
        if (this.mRecyclerView.getLayoutParams() == null) {
            return;
        }
        if (z) {
            ((android.widget.RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(12, 0);
            ((android.widget.RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, com.up366.medialibrary.R.id.wrapper_controls);
        } else {
            ((android.widget.RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(12);
            ((android.widget.RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, 0);
        }
    }

    @Override // com.up366.medialibrary.third.ucrop.UCropActivity
    protected void setResultUri(android.net.Uri uri, float f, int i, int i2, int i3, int i4) {
        try {
            int size = this.list.size();
            int i5 = this.cutIndex;
            if (size < i5) {
                onBackPressed();
                return;
            }
            com.up366.medialibrary.model.LocalMedia localMedia = this.list.get(i5);
            localMedia.setCutPath(uri.getPath());
            localMedia.setCut(true);
            localMedia.setCropResultAspectRatio(f);
            localMedia.setCropOffsetX(i);
            localMedia.setCropOffsetY(i2);
            localMedia.setCropImageWidth(i3);
            localMedia.setCropImageHeight(i4);
            localMedia.setAndroidQToPath(com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() ? localMedia.getCutPath() : localMedia.getAndroidQToPath());
            resetLastCropStatus();
            int i6 = this.cutIndex + 1;
            this.cutIndex = i6;
            if (this.isWithVideoImage && i6 < this.list.size() && com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(this.list.get(this.cutIndex).getMimeType())) {
                while (this.cutIndex < this.list.size() && !com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(this.list.get(this.cutIndex).getMimeType())) {
                    this.cutIndex++;
                }
            }
            int i7 = this.cutIndex;
            this.oldCutIndex = i7;
            if (i7 >= this.list.size()) {
                for (int i8 = 0; i8 < this.list.size(); i8++) {
                    this.list.get(i8).setCut(!android.text.TextUtils.isEmpty(r5.getCutPath()));
                }
                setResult(-1, new android.content.Intent().putExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_OUTPUT_URI_LIST, this.list));
                onBackPressed();
                return;
            }
            resetCutData();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDestroy() {
        com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter picturePhotoGalleryAdapter = this.mAdapter;
        if (picturePhotoGalleryAdapter != null) {
            picturePhotoGalleryAdapter.setOnItemClickListener(null);
        }
        super.onDestroy();
    }
}
