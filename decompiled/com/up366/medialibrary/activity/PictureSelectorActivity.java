package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureSelectorActivity extends com.up366.medialibrary.activity.PictureBaseActivity implements android.view.View.OnClickListener, com.up366.medialibrary.listener.OnAlbumItemClickListener, com.up366.medialibrary.listener.OnPhotoSelectChangedListener<com.up366.medialibrary.model.LocalMedia>, com.up366.medialibrary.listener.OnItemClickListener, com.up366.medialibrary.listener.OnRecyclerViewPreloadMoreListener {
    private static final java.lang.String TAG = "PictureSelectorActivity";
    private int allFolderSize;
    protected com.up366.medialibrary.common.dialog.PictureCustomDialog audioDialog;
    protected com.up366.medialibrary.widget.FolderPopWindow folderWindow;
    protected boolean isEnterSetting;
    protected com.up366.medialibrary.activity.PictureImageGridAdapter mAdapter;
    protected android.widget.RelativeLayout mBottomLayout;
    protected android.widget.CheckBox mCbOriginal;
    protected android.widget.ImageView mIvArrow;
    protected android.widget.ImageView mIvPictureLeftBack;
    private int mOpenCameraCount;
    protected com.up366.medialibrary.widget.RecyclerPreloadView mRecyclerView;
    protected android.view.View mTitleBar;
    protected android.widget.TextView mTvEmpty;
    protected android.widget.TextView mTvMusicStatus;
    protected android.widget.TextView mTvMusicTime;
    protected android.widget.TextView mTvMusicTotal;
    protected android.widget.TextView mTvPictureImgNum;
    protected android.widget.TextView mTvPictureOk;
    protected android.widget.TextView mTvPicturePreview;
    protected android.widget.TextView mTvPictureRight;
    protected android.widget.TextView mTvPictureTitle;
    protected android.widget.TextView mTvPlayPause;
    protected android.widget.TextView mTvPreviewNum;
    protected android.widget.TextView mTvQuit;
    protected android.widget.TextView mTvStop;
    protected android.media.MediaPlayer mediaPlayer;
    protected android.widget.SeekBar musicSeekBar;
    protected int oldCurrentListSize;
    protected android.view.View viewClickMask;
    protected android.view.animation.Animation animation = null;
    protected boolean isStartAnimation = false;
    protected boolean isPlayAudio = false;
    private long intervalClickTime = 0;
    public java.lang.Runnable mRunnable = new java.lang.Runnable() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.9
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.up366.medialibrary.activity.PictureSelectorActivity.this.mediaPlayer != null) {
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.mTvMusicTime.setText(com.up366.medialibrary.common.utils.DateUtils.formatDurationTime(com.up366.medialibrary.activity.PictureSelectorActivity.this.mediaPlayer.getCurrentPosition()));
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.musicSeekBar.setProgress(com.up366.medialibrary.activity.PictureSelectorActivity.this.mediaPlayer.getCurrentPosition());
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.musicSeekBar.setMax(com.up366.medialibrary.activity.PictureSelectorActivity.this.mediaPlayer.getDuration());
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.mTvMusicTotal.setText(com.up366.medialibrary.common.utils.DateUtils.formatDurationTime(com.up366.medialibrary.activity.PictureSelectorActivity.this.mediaPlayer.getDuration()));
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.mHandler.postDelayed(com.up366.medialibrary.activity.PictureSelectorActivity.this.mRunnable, 200L);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    };

    protected void onChangeData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.allFolderSize = bundle.getInt(com.up366.medialibrary.config.PictureConstants.EXTRA_ALL_FOLDER_SIZE);
            this.oldCurrentListSize = bundle.getInt(com.up366.medialibrary.config.PictureConstants.EXTRA_OLD_CURRENT_LIST_SIZE, 0);
            java.util.List<com.up366.medialibrary.model.LocalMedia> listObtainSelectorList = com.up366.medialibrary.PictureSelector.obtainSelectorList(bundle);
            if (listObtainSelectorList == null) {
                listObtainSelectorList = this.selectionMedias;
            }
            this.selectionMedias = listObtainSelectorList;
            com.up366.medialibrary.activity.PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
            if (pictureImageGridAdapter != null) {
                this.isStartAnimation = true;
                pictureImageGridAdapter.bindSelectData(this.selectionMedias);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        android.widget.CheckBox checkBox;
        super.onResume();
        if (this.isEnterSetting) {
            if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                if (this.mAdapter.isDataEmpty()) {
                    readLocalMedia();
                }
            } else {
                showPermissionsDialog(false, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, getString(com.up366.medialibrary.R.string.picture_jurisdiction));
            }
            this.isEnterSetting = false;
        }
        if (!this.config.isOriginalControl || (checkBox = this.mCbOriginal) == null) {
            return;
        }
        checkBox.setChecked(this.config.isCheckOriginalImage);
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public int getResourceId() {
        return com.up366.medialibrary.R.layout.picture_selector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initWidgets() {
        java.lang.String string;
        super.initWidgets();
        this.container = findViewById(com.up366.medialibrary.R.id.container);
        this.mTitleBar = findViewById(com.up366.medialibrary.R.id.titleBar);
        this.mIvPictureLeftBack = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.pictureLeftBack);
        this.mTvPictureTitle = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_title);
        this.mTvPictureRight = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_right);
        this.mTvPictureOk = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_tv_ok);
        this.mCbOriginal = (android.widget.CheckBox) findViewById(com.up366.medialibrary.R.id.cb_original);
        this.mIvArrow = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.ivArrow);
        this.viewClickMask = findViewById(com.up366.medialibrary.R.id.viewClickMask);
        this.mTvPicturePreview = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_id_preview);
        this.mTvPreviewNum = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.tv_preview_media_num);
        this.mTvPictureImgNum = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.tv_media_num);
        this.mRecyclerView = (com.up366.medialibrary.widget.RecyclerPreloadView) findViewById(com.up366.medialibrary.R.id.picture_recycler);
        this.mBottomLayout = (android.widget.RelativeLayout) findViewById(com.up366.medialibrary.R.id.select_bar_layout);
        this.mTvEmpty = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.tv_empty);
        isNumComplete(this.numComplete);
        if (!this.numComplete) {
            this.animation = android.view.animation.AnimationUtils.loadAnimation(this, com.up366.medialibrary.R.anim.picture_anim_modal_in);
        }
        this.mTvPicturePreview.setOnClickListener(this);
        if (this.config.isAutomaticTitleRecyclerTop) {
            this.mTitleBar.setOnClickListener(this);
        }
        this.mTvPicturePreview.setVisibility((this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio() || !this.config.enablePreview) ? 8 : 0);
        this.mBottomLayout.setVisibility((this.config.selectionMode == 1 && this.config.isSingleDirectReturn) ? 8 : 0);
        this.mIvPictureLeftBack.setOnClickListener(this);
        this.mTvPictureRight.setOnClickListener(this);
        this.mTvPictureOk.setOnClickListener(this);
        this.viewClickMask.setOnClickListener(this);
        this.mTvPictureImgNum.setOnClickListener(this);
        setTitle(null);
        com.up366.medialibrary.widget.FolderPopWindow folderPopWindow = new com.up366.medialibrary.widget.FolderPopWindow(this);
        this.folderWindow = folderPopWindow;
        folderPopWindow.setArrowImageView(this.mIvArrow);
        this.folderWindow.setOnAlbumItemClickListener(this);
        this.mRecyclerView.addItemDecoration(new com.up366.medialibrary.common.decoration.GridSpacingItemDecoration(this.config.imageSpanCount <= 0 ? 4 : this.config.imageSpanCount, com.up366.medialibrary.common.utils.ScreenUtils.dip2px(this, 2.0f), false));
        this.mRecyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(getContext(), this.config.imageSpanCount > 0 ? this.config.imageSpanCount : 4));
        if (!this.config.isPageStrategy) {
            this.mRecyclerView.setHasFixedSize(true);
        } else {
            this.mRecyclerView.setReachBottomRow(2);
            this.mRecyclerView.setOnRecyclerViewPreloadListener(this);
        }
        androidx.recyclerview.widget.SimpleItemAnimator itemAnimator = this.mRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setSupportsChangeAnimations(false);
            this.mRecyclerView.setItemAnimator(null);
        }
        loadAllMediaData();
        android.widget.TextView textView = this.mTvEmpty;
        if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()) {
            string = getString(com.up366.medialibrary.R.string.picture_audio_empty);
        } else {
            string = getString(com.up366.medialibrary.R.string.picture_empty);
        }
        textView.setText(string);
        com.up366.medialibrary.common.utils.StringUtils.tempTextFont(this.mTvEmpty, this.config.chooseMode);
        com.up366.medialibrary.activity.PictureImageGridAdapter pictureImageGridAdapter = new com.up366.medialibrary.activity.PictureImageGridAdapter(getContext(), this.config);
        this.mAdapter = pictureImageGridAdapter;
        pictureImageGridAdapter.setOnPhotoSelectChangedListener(this);
        int i = this.config.animationMode;
        if (i == 1) {
            this.mRecyclerView.setAdapter(new com.up366.medialibrary.common.animators.AlphaInAnimationAdapter(this.mAdapter));
        } else if (i == 2) {
            this.mRecyclerView.setAdapter(new com.up366.medialibrary.common.animators.SlideInBottomAnimationAdapter(this.mAdapter));
        } else {
            this.mRecyclerView.setAdapter(this.mAdapter);
        }
        if (this.config.isOriginalControl) {
            this.mCbOriginal.setVisibility(0);
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
            this.mCbOriginal.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity$$ExternalSyntheticLambda3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                    this.f$0.m158xd9d14ed(compoundButton, z);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$initWidgets$0$com-up366-medialibrary-activity-PictureSelectorActivity, reason: not valid java name */
    /* synthetic */ void m158xd9d14ed(android.widget.CompoundButton compoundButton, boolean z) {
        this.config.isCheckOriginalImage = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.mTvPictureTitle.setText(getString(this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio() ? com.up366.medialibrary.R.string.picture_all_audio : com.up366.medialibrary.R.string.picture_camera_roll));
        } else {
            this.mTvPictureTitle.setText(str);
        }
        this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_tag, -1);
    }

    @Override // com.up366.medialibrary.listener.OnRecyclerViewPreloadMoreListener
    public void onRecyclerViewPreloadMore() {
        loadMoreData();
    }

    private int getPageLimit() {
        if (com.up366.medialibrary.common.utils.ValueOf.toInt(this.mTvPictureTitle.getTag(com.up366.medialibrary.R.id.view_tag)) == -1) {
            int i = this.mOpenCameraCount > 0 ? this.config.pageSize - this.mOpenCameraCount : this.config.pageSize;
            this.mOpenCameraCount = 0;
            return i;
        }
        return this.config.pageSize;
    }

    private void loadMoreData() {
        if (this.mAdapter == null || !this.isHasMore) {
            return;
        }
        this.mPage++;
        final long j = com.up366.medialibrary.common.utils.ValueOf.toLong(this.mTvPictureTitle.getTag(com.up366.medialibrary.R.id.view_tag));
        this.mLoader.loadPageMediaData(j, this.mPage, getPageLimit(), new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.1
            @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
            public void onComplete(java.util.List<com.up366.medialibrary.model.LocalMedia> list, int i, boolean z) {
                if (com.up366.medialibrary.activity.PictureSelectorActivity.this.isFinishing()) {
                    return;
                }
                com.up366.medialibrary.activity.PictureSelectorActivity.this.isHasMore = z;
                if (z) {
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.hideDataNull();
                    int size = list.size();
                    if (size > 0) {
                        int size2 = com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.getSize();
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.getData().addAll(list);
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.notifyItemRangeChanged(size2, com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.getItemCount());
                    } else {
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.onRecyclerViewPreloadMore();
                    }
                    if (size < 10) {
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.mRecyclerView.onScrolled(com.up366.medialibrary.activity.PictureSelectorActivity.this.mRecyclerView.getScrollX(), com.up366.medialibrary.activity.PictureSelectorActivity.this.mRecyclerView.getScrollY());
                        return;
                    }
                    return;
                }
                if (com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.isDataEmpty()) {
                    com.up366.medialibrary.activity.PictureSelectorActivity pictureSelectorActivity = com.up366.medialibrary.activity.PictureSelectorActivity.this;
                    pictureSelectorActivity.showDataNull(pictureSelectorActivity.getString(j == -1 ? com.up366.medialibrary.R.string.picture_empty : com.up366.medialibrary.R.string.picture_data_null), com.up366.medialibrary.R.drawable.picture_icon_no_data);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void loadAllMediaData() {
        if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE)) {
            readLocalMedia();
        } else {
            com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public void initPictureSelectorStyle() {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2;
        android.content.res.ColorStateList colorStateList3;
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable != 0) {
                this.mIvArrow.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable));
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                this.mTvPictureTitle.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextSize != 0) {
                this.mTvPictureTitle.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor.length > 0 && (colorStateList3 = com.up366.medialibrary.common.utils.AttrsUtils.getColorStateList(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor)) != null) {
                this.mTvPictureRight.setTextColor(colorStateList3);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize != 0) {
                this.mTvPictureRight.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_leftBack != 0) {
                this.mIvPictureLeftBack.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_leftBack);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor.length > 0 && (colorStateList2 = com.up366.medialibrary.common.utils.AttrsUtils.getColorStateList(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor)) != null) {
                this.mTvPicturePreview.setTextColor(colorStateList2);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewTextSize != 0) {
                this.mTvPicturePreview.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground != 0) {
                this.mTvPictureImgNum.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextSize != 0) {
                this.mTvPictureImgNum.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextColor != 0) {
                this.mTvPictureImgNum.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor.length > 0 && (colorStateList = com.up366.medialibrary.common.utils.AttrsUtils.getColorStateList(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor)) != null) {
                this.mTvPictureOk.setTextColor(colorStateList);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeTextSize != 0) {
                this.mTvPictureOk.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.mBottomLayout.setBackgroundColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_container_backgroundColor != 0) {
                this.container.setBackgroundColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_container_backgroundColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                this.mTvPictureRight.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText != 0) {
                this.mTvPicturePreview.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding != 0) {
                ((android.widget.RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.mBottomLayout.getLayoutParams().height = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isOriginalControl) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.R.drawable.picture_original_checkbox));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                } else {
                    this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_white));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText != 0) {
                    this.mCbOriginal.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_white));
            }
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleDownResId != 0) {
                this.mIvArrow.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleDownResId));
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.mTvPictureTitle.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.mTvPictureTitle.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureRightDefaultTextColor != 0) {
                this.mTvPictureRight.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureRightDefaultTextColor);
            } else if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCancelTextColor != 0) {
                this.mTvPictureRight.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCancelTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureRightTextSize != 0) {
                this.mTvPictureRight.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureRightTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.mIvPictureLeftBack.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                this.mTvPicturePreview.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewTextSize != 0) {
                this.mTvPicturePreview.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckNumBgStyle != 0) {
                this.mTvPictureImgNum.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckNumBgStyle);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteTextSize != 0) {
                this.mTvPictureOk.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureBottomBgColor != 0) {
                this.mBottomLayout.setBackgroundColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureBottomBgColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureContainerBackgroundColor != 0) {
                this.container.setBackgroundColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureContainerBackgroundColor);
            }
            if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureRightDefaultText)) {
                this.mTvPictureRight.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureRightDefaultText);
            }
            if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText);
            }
            if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewText);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding != 0) {
                ((android.widget.RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleBarHeight;
            }
            if (this.config.isOriginalControl) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalControlStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalControlStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.R.drawable.picture_original_checkbox));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalFontColor != 0) {
                    this.mCbOriginal.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalFontColor);
                } else {
                    this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_white));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalTextSize != 0) {
                    this.mCbOriginal.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_white));
            }
        } else {
            int typeValueColor = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_title_textColor);
            if (typeValueColor != 0) {
                this.mTvPictureTitle.setTextColor(typeValueColor);
            }
            int typeValueColor2 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_right_textColor);
            if (typeValueColor2 != 0) {
                this.mTvPictureRight.setTextColor(typeValueColor2);
            }
            int typeValueColor3 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_container_backgroundColor);
            if (typeValueColor3 != 0) {
                this.container.setBackgroundColor(typeValueColor3);
            }
            this.mIvPictureLeftBack.setImageDrawable(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_leftBack_icon, com.up366.medialibrary.R.drawable.picture_icon_back));
            if (this.config.downResId != 0) {
                this.mIvArrow.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this, this.config.downResId));
            } else {
                this.mIvArrow.setImageDrawable(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_arrow_down_icon, com.up366.medialibrary.R.drawable.picture_icon_arrow_down));
            }
            int typeValueColor4 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_bottom_bg);
            if (typeValueColor4 != 0) {
                this.mBottomLayout.setBackgroundColor(typeValueColor4);
            }
            android.content.res.ColorStateList typeValueColorStateList = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColorStateList(getContext(), com.up366.medialibrary.R.attr.picture_complete_textColor);
            if (typeValueColorStateList != null) {
                this.mTvPictureOk.setTextColor(typeValueColorStateList);
            }
            android.content.res.ColorStateList typeValueColorStateList2 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColorStateList(getContext(), com.up366.medialibrary.R.attr.picture_preview_textColor);
            if (typeValueColorStateList2 != null) {
                this.mTvPicturePreview.setTextColor(typeValueColorStateList2);
            }
            int typeValueSizeForInt = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueSizeForInt(getContext(), com.up366.medialibrary.R.attr.picture_titleRightArrow_LeftPadding);
            if (typeValueSizeForInt != 0) {
                ((android.widget.RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = typeValueSizeForInt;
            }
            this.mTvPictureImgNum.setBackground(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_num_style, com.up366.medialibrary.R.drawable.picture_num_oval));
            int typeValueSizeForInt2 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueSizeForInt(getContext(), com.up366.medialibrary.R.attr.picture_titleBar_height);
            if (typeValueSizeForInt2 > 0) {
                this.mTitleBar.getLayoutParams().height = typeValueSizeForInt2;
            }
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_original_check_style, com.up366.medialibrary.R.drawable.picture_original_wechat_checkbox));
                int typeValueColor5 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_original_text_color);
                if (typeValueColor5 != 0) {
                    this.mCbOriginal.setTextColor(typeValueColor5);
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        this.mAdapter.bindSelectData(this.selectionMedias);
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.up366.medialibrary.activity.PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        if (pictureImageGridAdapter != null) {
            bundle.putInt(com.up366.medialibrary.config.PictureConstants.EXTRA_OLD_CURRENT_LIST_SIZE, pictureImageGridAdapter.getSize());
            if (this.folderWindow.getFolderData().size() > 0) {
                bundle.putInt(com.up366.medialibrary.config.PictureConstants.EXTRA_ALL_FOLDER_SIZE, this.folderWindow.getFolder(0).getImageNum());
            }
            if (this.mAdapter.getSelectedData() != null) {
                com.up366.medialibrary.PictureSelector.saveSelectorList(bundle, this.mAdapter.getSelectedData());
            }
        }
    }

    private void isNumComplete(boolean z) {
        if (z) {
            initCompleteText(0);
        }
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initCompleteText(int i) {
        java.lang.String string;
        java.lang.String string2;
        java.lang.String string3;
        java.lang.String string4;
        if (this.config.selectionMode == 1) {
            if (i <= 0) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                    if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                        this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), java.lang.Integer.valueOf(i), 1) : getString(com.up366.medialibrary.R.string.picture_please_select));
                        return;
                    } else {
                        this.mTvPictureOk.setText(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText : com.up366.medialibrary.R.string.picture_please_select));
                        return;
                    }
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                    if (com.up366.medialibrary.config.PictureSelectionConfig.style.isCompleteReplaceNum && !android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText)) {
                        this.mTvPictureOk.setText(java.lang.String.format(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText, java.lang.Integer.valueOf(i), 1));
                        return;
                    } else {
                        this.mTvPictureOk.setText(!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText) ? com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText : getString(com.up366.medialibrary.R.string.picture_done));
                        return;
                    }
                }
                return;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0 ? java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), java.lang.Integer.valueOf(i), 1) : getString(com.up366.medialibrary.R.string.picture_done));
                    return;
                } else {
                    this.mTvPictureOk.setText(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0 ? com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText : com.up366.medialibrary.R.string.picture_done));
                    return;
                }
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.isCompleteReplaceNum && !android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureOk.setText(java.lang.String.format(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText, java.lang.Integer.valueOf(i), 1));
                    return;
                } else {
                    this.mTvPictureOk.setText(!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText) ? com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText : getString(com.up366.medialibrary.R.string.picture_done));
                    return;
                }
            }
            return;
        }
        if (i <= 0) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    android.widget.TextView textView = this.mTvPictureOk;
                    if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                        string4 = java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum));
                    } else {
                        string4 = getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)});
                    }
                    textView.setText(string4);
                    return;
                }
                android.widget.TextView textView2 = this.mTvPictureOk;
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                    string3 = getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
                } else {
                    string3 = getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)});
                }
                textView2.setText(string3);
                return;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.isCompleteReplaceNum) {
                    android.widget.TextView textView3 = this.mTvPictureOk;
                    if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText)) {
                        string2 = java.lang.String.format(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum));
                    } else {
                        string2 = getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)});
                    }
                    textView3.setText(string2);
                    return;
                }
                android.widget.TextView textView4 = this.mTvPictureOk;
                if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText)) {
                    string = com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText;
                } else {
                    string = getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)});
                }
                textView4.setText(string);
                return;
            }
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText(java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}));
                    return;
                }
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText));
                return;
            } else {
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}));
                return;
            }
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.isCompleteReplaceNum) {
                if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureOk.setText(java.lang.String.format(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}));
                    return;
                }
            }
            if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText);
            } else {
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}));
            }
        }
    }

    protected void readLocalMedia() {
        showPleaseDialog();
        if (this.config.isOnlySandboxDir) {
            this.mLoader.loadOnlyInAppDirectoryAllMedia(new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder>() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.2
                @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
                public void onComplete(com.up366.medialibrary.model.LocalMediaFolder localMediaFolder) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    if (localMediaFolder == null) {
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.setTitle(null);
                    } else {
                        arrayList.add(localMediaFolder);
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.setTitle(localMediaFolder.getName());
                    }
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.initAllModel(arrayList);
                }
            });
        } else if (this.config.isPageStrategy) {
            this.mLoader.loadAllMedia(new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder>() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.3
                @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
                public void onComplete(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
                    if (com.up366.medialibrary.activity.PictureSelectorActivity.this.isFinishing()) {
                        return;
                    }
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.isHasMore = true;
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.initPageModel(list);
                }
            });
        } else {
            this.mLoader.loadAllMedia(new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder>() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.4
                @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
                public void onComplete(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.initAllModel(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPageModel(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        this.folderWindow.bindFolder(list);
        this.mPage = 1;
        final com.up366.medialibrary.model.LocalMediaFolder folder = this.folderWindow.getFolder(0);
        this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_count_tag, java.lang.Integer.valueOf(folder != null ? folder.getImageNum() : 0));
        this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_index_tag, 0);
        long bucketId = folder != null ? folder.getBucketId() : -1L;
        this.mRecyclerView.setEnabledLoadMore(true);
        this.mLoader.loadPageMediaData(bucketId, this.mPage, new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.5
            @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
            public void onComplete(java.util.List<com.up366.medialibrary.model.LocalMedia> list2, int i, boolean z) {
                com.up366.medialibrary.model.LocalMediaFolder localMediaFolder;
                if (com.up366.medialibrary.activity.PictureSelectorActivity.this.isFinishing()) {
                    return;
                }
                com.up366.medialibrary.activity.PictureSelectorActivity.this.dismissDialog();
                if (com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter != null) {
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.isHasMore = true;
                    if (z && list2.size() == 0) {
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.onRecyclerViewPreloadMore();
                        return;
                    }
                    int size = com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.getSize();
                    int size2 = list2.size();
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.oldCurrentListSize += size;
                    if (size2 >= size) {
                        if (size > 0 && size < size2 && com.up366.medialibrary.activity.PictureSelectorActivity.this.oldCurrentListSize != size2 && !com.up366.medialibrary.activity.PictureSelectorActivity.this.isLocalMediaSame(list2.get(0))) {
                            com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.getData().addAll(list2);
                        } else {
                            if (i == 1 && (localMediaFolder = folder) != null) {
                                list2.addAll(0, localMediaFolder.getData());
                                com.up366.medialibrary.common.utils.SortUtils.sortLocalMediaAddedTime(list2);
                            }
                            com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.bindData(list2);
                        }
                    }
                    if (!com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.isDataEmpty()) {
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.hideDataNull();
                    } else {
                        com.up366.medialibrary.activity.PictureSelectorActivity pictureSelectorActivity = com.up366.medialibrary.activity.PictureSelectorActivity.this;
                        pictureSelectorActivity.showDataNull(pictureSelectorActivity.getString(com.up366.medialibrary.R.string.picture_empty), com.up366.medialibrary.R.drawable.picture_icon_no_data);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAllModel(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        if (list != null) {
            if (list.size() > 0) {
                this.folderWindow.bindFolder(list);
                com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = list.get(0);
                localMediaFolder.setChecked(true);
                this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_count_tag, java.lang.Integer.valueOf(localMediaFolder.getImageNum()));
                java.util.List<com.up366.medialibrary.model.LocalMedia> data = localMediaFolder.getData();
                com.up366.medialibrary.activity.PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
                if (pictureImageGridAdapter != null) {
                    int size = pictureImageGridAdapter.getSize();
                    int size2 = data.size();
                    int i = this.oldCurrentListSize + size;
                    this.oldCurrentListSize = i;
                    if (size2 >= size) {
                        if (size > 0 && size < size2 && i != size2) {
                            this.mAdapter.getData().addAll(data);
                            com.up366.medialibrary.model.LocalMedia localMedia = this.mAdapter.getData().get(0);
                            localMediaFolder.setFirstImagePath(localMedia.getPath());
                            localMediaFolder.getData().add(0, localMedia);
                            localMediaFolder.setCheckedNum(1);
                            localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                            updateMediaFolder(this.folderWindow.getFolderData(), localMedia);
                        } else {
                            this.mAdapter.bindData(data);
                        }
                    }
                    if (this.mAdapter.isDataEmpty()) {
                        showDataNull(getString(com.up366.medialibrary.R.string.picture_empty), com.up366.medialibrary.R.drawable.picture_icon_no_data);
                    } else {
                        hideDataNull();
                    }
                }
            } else {
                showDataNull(getString(com.up366.medialibrary.R.string.picture_empty), com.up366.medialibrary.R.drawable.picture_icon_no_data);
            }
        } else {
            showDataNull(getString(com.up366.medialibrary.R.string.picture_data_exception), com.up366.medialibrary.R.drawable.picture_icon_data_error);
        }
        dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocalMediaSame(com.up366.medialibrary.model.LocalMedia localMedia) {
        com.up366.medialibrary.model.LocalMedia item = this.mAdapter.getItem(0);
        if (item != null && localMedia != null) {
            if (item.getPath().equals(localMedia.getPath())) {
                return true;
            }
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(localMedia.getPath()) && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(item.getPath()) && !android.text.TextUtils.isEmpty(localMedia.getPath()) && !android.text.TextUtils.isEmpty(item.getPath())) {
                return localMedia.getPath().substring(localMedia.getPath().lastIndexOf("/") + 1).equals(item.getPath().substring(item.getPath().lastIndexOf("/") + 1));
            }
        }
        return false;
    }

    public void startCamera() {
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
            if (this.config.chooseMode == 0) {
                com.up366.medialibrary.common.dialog.PhotoItemSelectedDialog photoItemSelectedDialogNewInstance = com.up366.medialibrary.common.dialog.PhotoItemSelectedDialog.newInstance();
                photoItemSelectedDialogNewInstance.setOnItemClickListener(this);
                photoItemSelectedDialogNewInstance.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
                return;
            } else {
                com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, this.config.chooseMode);
                this.config.cameraMimeType = this.config.chooseMode;
                return;
            }
        }
        int i = this.config.chooseMode;
        if (i != 0) {
            if (i == 1) {
                startOpenCameraImage();
                return;
            } else if (i == 2) {
                startOpenCameraVideo();
                return;
            } else {
                if (i != 3) {
                    return;
                }
                startOpenCameraAudio();
                return;
            }
        }
        if (this.config.ofAllCameraType == com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()) {
            startOpenCameraImage();
        } else {
            if (this.config.ofAllCameraType == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()) {
                startOpenCameraVideo();
                return;
            }
            com.up366.medialibrary.common.dialog.PhotoItemSelectedDialog photoItemSelectedDialogNewInstance2 = com.up366.medialibrary.common.dialog.PhotoItemSelectedDialog.newInstance();
            photoItemSelectedDialogNewInstance2.setOnItemClickListener(this);
            photoItemSelectedDialogNewInstance2.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.up366.medialibrary.R.id.pictureLeftBack || id == com.up366.medialibrary.R.id.picture_right) {
            com.up366.medialibrary.widget.FolderPopWindow folderPopWindow = this.folderWindow;
            if (folderPopWindow != null && folderPopWindow.isShowing()) {
                this.folderWindow.dismiss();
                return;
            } else {
                onBackPressed();
                return;
            }
        }
        if (id == com.up366.medialibrary.R.id.picture_title || id == com.up366.medialibrary.R.id.ivArrow || id == com.up366.medialibrary.R.id.viewClickMask) {
            if (this.config.isOnlySandboxDir) {
                return;
            }
            if (this.folderWindow.isShowing()) {
                this.folderWindow.dismiss();
                return;
            }
            if (this.folderWindow.isEmpty()) {
                return;
            }
            this.folderWindow.showAsDropDown(this.mTitleBar);
            if (this.config.isSingleDirectReturn) {
                return;
            }
            this.folderWindow.updateFolderCheckStatus(this.mAdapter.getSelectedData());
            return;
        }
        if (id == com.up366.medialibrary.R.id.picture_id_preview) {
            onPreview();
            return;
        }
        if (id == com.up366.medialibrary.R.id.picture_tv_ok || id == com.up366.medialibrary.R.id.tv_media_num) {
            onComplete();
            return;
        }
        if (id == com.up366.medialibrary.R.id.titleBar && this.config.isAutomaticTitleRecyclerTop) {
            if (android.os.SystemClock.uptimeMillis() - this.intervalClickTime < 500) {
                if (this.mAdapter.getItemCount() > 0) {
                    this.mRecyclerView.scrollToPosition(0);
                    return;
                }
                return;
            }
            this.intervalClickTime = android.os.SystemClock.uptimeMillis();
        }
    }

    private void onPreview() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> selectedData = this.mAdapter.getSelectedData();
        java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
        int size = selectedData.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(selectedData.get(i));
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.onCustomImagePreviewCallback != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.onCustomImagePreviewCallback.onCustomPreviewCallback(getContext(), selectedData, 0);
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelableArrayList(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_SELECT_LIST, arrayList);
        bundle.putParcelableArrayList(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST, (java.util.ArrayList) selectedData);
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_BOTTOM_PREVIEW, true);
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
        bundle.putString(com.up366.medialibrary.config.PictureConstants.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
        com.up366.medialibrary.common.utils.JumpUtils.startPicturePreviewActivity(getContext(), this.config.isWeChatStyle, bundle, this.config.selectionMode == 1 ? 69 : com.up366.medialibrary.third.ucrop.UCrop.REQUEST_MULTI_CROP);
        overridePendingTransition(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, com.up366.medialibrary.R.anim.picture_anim_fade_in);
    }

    private void onComplete() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> selectedData = this.mAdapter.getSelectedData();
        int size = selectedData.size();
        com.up366.medialibrary.model.LocalMedia localMedia = selectedData.size() > 0 ? selectedData.get(0) : null;
        java.lang.String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        boolean zIsImage = com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(mimeType);
        if (this.config.isWithVideoImage) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(selectedData.get(i3).getMimeType())) {
                    i2++;
                } else {
                    i++;
                }
            }
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && i < this.config.minSelectNum) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_min_img_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.minSelectNum)}));
                    return;
                } else if (this.config.minVideoSelectNum > 0 && i2 < this.config.minVideoSelectNum) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_min_video_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.minVideoSelectNum)}));
                    return;
                }
            }
        } else if (this.config.selectionMode == 2) {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(mimeType) && this.config.minSelectNum > 0 && size < this.config.minSelectNum) {
                showPromptDialog(getString(com.up366.medialibrary.R.string.picture_min_img_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.minSelectNum)}));
                return;
            } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(mimeType) && this.config.minVideoSelectNum > 0 && size < this.config.minVideoSelectNum) {
                showPromptDialog(getString(com.up366.medialibrary.R.string.picture_min_video_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.minVideoSelectNum)}));
                return;
            }
        }
        if (this.config.returnEmpty && size == 0) {
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && size < this.config.minSelectNum) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_min_img_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.minSelectNum)}));
                    return;
                } else if (this.config.minVideoSelectNum > 0 && size < this.config.minVideoSelectNum) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_min_video_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.minVideoSelectNum)}));
                    return;
                }
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
                com.up366.medialibrary.config.PictureSelectionConfig.listener.onResult(selectedData);
            } else {
                setResult(-1, com.up366.medialibrary.PictureSelector.putIntentResult(selectedData));
            }
            exit();
            return;
        }
        if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll() && this.config.isWithVideoImage) {
            bothMimeTypeWith(zIsImage, selectedData);
        } else {
            separateMimeTypeWith(zIsImage, selectedData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bothMimeTypeWith(boolean z, java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        int i = 0;
        com.up366.medialibrary.model.LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        if (this.config.enableCrop && !this.config.isCheckOriginalImage) {
            if (this.config.selectionMode == 1 && z) {
                this.config.originalPath = localMedia.getPath();
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType(), localMedia.getWidth(), localMedia.getHeight());
                return;
            }
            int size = list.size();
            int i2 = 0;
            while (i < size) {
                com.up366.medialibrary.model.LocalMedia localMedia2 = list.get(i);
                if (localMedia2 != null && !android.text.TextUtils.isEmpty(localMedia2.getPath()) && com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia2.getMimeType())) {
                    i2++;
                }
                i++;
            }
            if (i2 <= 0) {
                onResult(list);
                return;
            } else {
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, (java.util.ArrayList) list);
                return;
            }
        }
        if (this.config.isCompress) {
            int size2 = list.size();
            while (i < size2) {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(list.get(i).getMimeType())) {
                    compressImage(list);
                    return;
                }
                i++;
            }
            onResult(list);
            return;
        }
        onResult(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void separateMimeTypeWith(boolean z, java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        com.up366.medialibrary.model.LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        if (this.config.enableCrop && !this.config.isCheckOriginalImage && z) {
            if (this.config.selectionMode == 1) {
                this.config.originalPath = localMedia.getPath();
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType(), localMedia.getWidth(), localMedia.getHeight());
                return;
            } else {
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, (java.util.ArrayList) list);
                return;
            }
        }
        if (this.config.isCompress && z) {
            compressImage(list);
        } else {
            onResult(list);
        }
    }

    private void startPlayAudioDialog(final java.lang.String str) {
        if (isFinishing()) {
            return;
        }
        com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog = new com.up366.medialibrary.common.dialog.PictureCustomDialog(getContext(), com.up366.medialibrary.R.layout.picture_audio_dialog);
        this.audioDialog = pictureCustomDialog;
        pictureCustomDialog.getWindow().setWindowAnimations(com.up366.medialibrary.R.style.Picture_Theme_Dialog_AudioStyle);
        this.mTvMusicStatus = (android.widget.TextView) this.audioDialog.findViewById(com.up366.medialibrary.R.id.tv_musicStatus);
        this.mTvMusicTime = (android.widget.TextView) this.audioDialog.findViewById(com.up366.medialibrary.R.id.tv_musicTime);
        this.musicSeekBar = (android.widget.SeekBar) this.audioDialog.findViewById(com.up366.medialibrary.R.id.musicSeekBar);
        this.mTvMusicTotal = (android.widget.TextView) this.audioDialog.findViewById(com.up366.medialibrary.R.id.tv_musicTotal);
        this.mTvPlayPause = (android.widget.TextView) this.audioDialog.findViewById(com.up366.medialibrary.R.id.tv_PlayPause);
        this.mTvStop = (android.widget.TextView) this.audioDialog.findViewById(com.up366.medialibrary.R.id.tv_Stop);
        this.mTvQuit = (android.widget.TextView) this.audioDialog.findViewById(com.up366.medialibrary.R.id.tv_Quit);
        this.mHandler.postDelayed(new java.lang.Runnable() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.6
            @Override // java.lang.Runnable
            public void run() {
                com.up366.medialibrary.activity.PictureSelectorActivity.this.initPlayer(str);
            }
        }, 30L);
        this.mTvPlayPause.setOnClickListener(new com.up366.medialibrary.activity.PictureSelectorActivity.onAudioOnClick(str));
        this.mTvStop.setOnClickListener(new com.up366.medialibrary.activity.PictureSelectorActivity.onAudioOnClick(str));
        this.mTvQuit.setOnClickListener(new com.up366.medialibrary.activity.PictureSelectorActivity.onAudioOnClick(str));
        this.musicSeekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
                if (z) {
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.mediaPlayer.seekTo(i);
                }
            }
        });
        this.audioDialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.m161x24dd4af1(str, dialogInterface);
            }
        });
        this.mHandler.post(this.mRunnable);
        this.audioDialog.show();
    }

    /* JADX INFO: renamed from: lambda$startPlayAudioDialog$1$com-up366-medialibrary-activity-PictureSelectorActivity, reason: not valid java name */
    /* synthetic */ void m161x24dd4af1(final java.lang.String str, android.content.DialogInterface dialogInterface) {
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.postDelayed(new java.lang.Runnable() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.8
            @Override // java.lang.Runnable
            public void run() {
                com.up366.medialibrary.activity.PictureSelectorActivity.this.stop(str);
            }
        }, 30L);
        try {
            com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog = this.audioDialog;
            if (pictureCustomDialog == null || !pictureCustomDialog.isShowing()) {
                return;
            }
            this.audioDialog.dismiss();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPlayer(java.lang.String str) {
        this.mediaPlayer = new android.media.MediaPlayer();
        try {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                this.mediaPlayer.setDataSource(getContext(), android.net.Uri.parse(str));
            } else {
                this.mediaPlayer.setDataSource(str);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            playAudio();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public class onAudioOnClick implements android.view.View.OnClickListener {
        private java.lang.String path;

        public onAudioOnClick(java.lang.String str) {
            this.path = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            int id = view.getId();
            if (id == com.up366.medialibrary.R.id.tv_PlayPause) {
                com.up366.medialibrary.activity.PictureSelectorActivity.this.playAudio();
            }
            if (id == com.up366.medialibrary.R.id.tv_Stop) {
                com.up366.medialibrary.activity.PictureSelectorActivity.this.mTvMusicStatus.setText(com.up366.medialibrary.activity.PictureSelectorActivity.this.getString(com.up366.medialibrary.R.string.picture_stop_audio));
                com.up366.medialibrary.activity.PictureSelectorActivity.this.mTvPlayPause.setText(com.up366.medialibrary.activity.PictureSelectorActivity.this.getString(com.up366.medialibrary.R.string.picture_play_audio));
                com.up366.medialibrary.activity.PictureSelectorActivity.this.stop(this.path);
            }
            if (id == com.up366.medialibrary.R.id.tv_Quit) {
                com.up366.medialibrary.activity.PictureSelectorActivity.this.mHandler.postDelayed(new java.lang.Runnable() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity$onAudioOnClick$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m162xa7d62c9f();
                    }
                }, 30L);
                try {
                    if (com.up366.medialibrary.activity.PictureSelectorActivity.this.audioDialog != null && com.up366.medialibrary.activity.PictureSelectorActivity.this.audioDialog.isShowing()) {
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.audioDialog.dismiss();
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                com.up366.medialibrary.activity.PictureSelectorActivity.this.mHandler.removeCallbacks(com.up366.medialibrary.activity.PictureSelectorActivity.this.mRunnable);
            }
        }

        /* JADX INFO: renamed from: lambda$onClick$0$com-up366-medialibrary-activity-PictureSelectorActivity$onAudioOnClick, reason: not valid java name */
        /* synthetic */ void m162xa7d62c9f() {
            com.up366.medialibrary.activity.PictureSelectorActivity.this.stop(this.path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAudio() {
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            this.musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        if (this.mTvPlayPause.getText().toString().equals(getString(com.up366.medialibrary.R.string.picture_play_audio))) {
            this.mTvPlayPause.setText(getString(com.up366.medialibrary.R.string.picture_pause_audio));
            this.mTvMusicStatus.setText(getString(com.up366.medialibrary.R.string.picture_play_audio));
        } else {
            this.mTvPlayPause.setText(getString(com.up366.medialibrary.R.string.picture_play_audio));
            this.mTvMusicStatus.setText(getString(com.up366.medialibrary.R.string.picture_pause_audio));
        }
        playOrPause();
        if (this.isPlayAudio) {
            return;
        }
        this.mHandler.post(this.mRunnable);
        this.isPlayAudio = true;
    }

    public void stop(java.lang.String str) {
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.mediaPlayer.reset();
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                    this.mediaPlayer.setDataSource(getContext(), android.net.Uri.parse(str));
                } else {
                    this.mediaPlayer.setDataSource(str);
                }
                this.mediaPlayer.prepare();
                this.mediaPlayer.seekTo(0);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void playOrPause() {
        try {
            android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.mediaPlayer.pause();
                } else {
                    this.mediaPlayer.start();
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.up366.medialibrary.listener.OnAlbumItemClickListener
    public void onItemClick(int i, boolean z, long j, java.lang.String str, java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        this.mAdapter.setShowCamera(this.config.isCamera && z);
        this.mTvPictureTitle.setText(str);
        long j2 = com.up366.medialibrary.common.utils.ValueOf.toLong(this.mTvPictureTitle.getTag(com.up366.medialibrary.R.id.view_tag));
        this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_count_tag, java.lang.Integer.valueOf(this.folderWindow.getFolder(i) != null ? this.folderWindow.getFolder(i).getImageNum() : 0));
        if (!this.config.isPageStrategy) {
            this.mAdapter.bindData(list);
            this.mRecyclerView.smoothScrollToPosition(0);
        } else if (j2 != j) {
            setLastCacheFolderData();
            if (!isCurrentCacheFolderData(i)) {
                this.mPage = 1;
                showPleaseDialog();
                this.mLoader.loadPageMediaData(j, this.mPage, new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.10
                    @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
                    public void onComplete(java.util.List<com.up366.medialibrary.model.LocalMedia> list2, int i2, boolean z2) {
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.isHasMore = z2;
                        if (com.up366.medialibrary.activity.PictureSelectorActivity.this.isFinishing()) {
                            return;
                        }
                        if (list2.size() == 0) {
                            com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.clear();
                        }
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.mAdapter.bindData(list2);
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.mRecyclerView.onScrolled(0, 0);
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.mRecyclerView.smoothScrollToPosition(0);
                        com.up366.medialibrary.activity.PictureSelectorActivity.this.dismissDialog();
                    }
                });
            }
        }
        this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_tag, java.lang.Long.valueOf(j));
        this.folderWindow.dismiss();
    }

    private void setLastCacheFolderData() {
        com.up366.medialibrary.model.LocalMediaFolder folder = this.folderWindow.getFolder(com.up366.medialibrary.common.utils.ValueOf.toInt(this.mTvPictureTitle.getTag(com.up366.medialibrary.R.id.view_index_tag)));
        folder.setData(this.mAdapter.getData());
        folder.setCurrentDataPage(this.mPage);
        folder.setHasMore(this.isHasMore);
    }

    private boolean isCurrentCacheFolderData(int i) {
        this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_index_tag, java.lang.Integer.valueOf(i));
        com.up366.medialibrary.model.LocalMediaFolder folder = this.folderWindow.getFolder(i);
        if (folder == null || folder.getData() == null || folder.getData().size() <= 0) {
            return false;
        }
        this.mAdapter.bindData(folder.getData());
        this.mPage = folder.getCurrentDataPage();
        this.isHasMore = folder.isHasMore();
        this.mRecyclerView.smoothScrollToPosition(0);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.listener.OnPhotoSelectChangedListener
    public void onTakePhoto() {
        if (com.up366.medialibrary.common.permissions.PermissionChecker.checkSelfPermission(this, com.up366.mobile.common.utils.permissions.Permission.CAMERA)) {
            startCamera();
        } else {
            com.up366.medialibrary.common.permissions.PermissionChecker.requestPermissions(this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, 2);
        }
    }

    @Override // com.up366.medialibrary.listener.OnPhotoSelectChangedListener
    public void onChange(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        changeImageNumber(list);
        calculateFileTotalSize(list);
    }

    protected void calculateFileTotalSize(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (this.config.isOriginalControl) {
            if (this.config.isDisplayOriginalSize) {
                long size = 0;
                for (int i = 0; i < list.size(); i++) {
                    size += list.get(i).getSize();
                }
                if (size > 0) {
                    this.mCbOriginal.setText(getString(com.up366.medialibrary.R.string.picture_original_image, new java.lang.Object[]{com.up366.medialibrary.common.utils.PictureFileUtils.formatFileSize(size, 2)}));
                    return;
                } else {
                    this.mCbOriginal.setText(getString(com.up366.medialibrary.R.string.picture_default_original_image));
                    return;
                }
            }
            this.mCbOriginal.setText(getString(com.up366.medialibrary.R.string.picture_default_original_image));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.listener.OnPhotoSelectChangedListener
    public void onPictureClick(com.up366.medialibrary.model.LocalMedia localMedia, int i) {
        if (this.config.selectionMode == 1 && this.config.isSingleDirectReturn) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(localMedia);
            if (this.config.enableCrop && com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType()) && !this.config.isCheckOriginalImage) {
                this.mAdapter.bindSelectData(arrayList);
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, localMedia.getPath(), localMedia.getMimeType(), localMedia.getWidth(), localMedia.getHeight());
                return;
            } else {
                handlerResult(arrayList);
                return;
            }
        }
        startPreview(this.mAdapter.getData(), i);
    }

    public void startPreview(java.util.List<com.up366.medialibrary.model.LocalMedia> list, int i) {
        com.up366.medialibrary.model.LocalMedia localMedia = list.get(i);
        java.lang.String mimeType = localMedia.getMimeType();
        android.os.Bundle bundle = new android.os.Bundle();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(mimeType)) {
            if (this.config.selectionMode == 1 && !this.config.enPreviewVideo) {
                arrayList.add(localMedia);
                onResult(arrayList);
                return;
            } else if (com.up366.medialibrary.config.PictureSelectionConfig.customVideoPlayCallback != null) {
                com.up366.medialibrary.config.PictureSelectionConfig.customVideoPlayCallback.startPlayVideo(localMedia);
                return;
            } else {
                bundle.putParcelable(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_KEY, localMedia);
                com.up366.medialibrary.common.utils.JumpUtils.startPictureVideoPlayActivity(getContext(), bundle, com.up366.medialibrary.config.PictureConstants.PREVIEW_VIDEO_CODE);
                return;
            }
        }
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(mimeType)) {
            if (this.config.selectionMode == 1) {
                arrayList.add(localMedia);
                onResult(arrayList);
                return;
            } else {
                startPlayAudioDialog(localMedia.getPath());
                return;
            }
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.onCustomImagePreviewCallback != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.onCustomImagePreviewCallback.onCustomPreviewCallback(getContext(), list, i);
            return;
        }
        java.util.List<com.up366.medialibrary.model.LocalMedia> selectedData = this.mAdapter.getSelectedData();
        com.up366.medialibrary.manager.ImagesObservable.getInstance().saveData(new java.util.ArrayList(list));
        bundle.putParcelableArrayList(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST, (java.util.ArrayList) selectedData);
        bundle.putInt("position", i);
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
        bundle.putLong(com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID, com.up366.medialibrary.common.utils.ValueOf.toLong(this.mTvPictureTitle.getTag(com.up366.medialibrary.R.id.view_tag)));
        bundle.putInt(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, this.mPage);
        bundle.putParcelable(com.up366.medialibrary.config.PictureConstants.EXTRA_CONFIG, this.config);
        bundle.putInt(com.up366.medialibrary.config.PictureConstants.EXTRA_DATA_COUNT, com.up366.medialibrary.common.utils.ValueOf.toInt(this.mTvPictureTitle.getTag(com.up366.medialibrary.R.id.view_count_tag)));
        bundle.putString(com.up366.medialibrary.config.PictureConstants.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
        com.up366.medialibrary.common.utils.JumpUtils.startPicturePreviewActivity(getContext(), this.config.isWeChatStyle, bundle, this.config.selectionMode == 1 ? 69 : com.up366.medialibrary.third.ucrop.UCrop.REQUEST_MULTI_CROP);
        overridePendingTransition(com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, com.up366.medialibrary.R.anim.picture_anim_fade_in);
    }

    protected void changeImageNumber(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (list.size() != 0) {
            this.mTvPictureOk.setEnabled(true);
            this.mTvPictureOk.setSelected(true);
            this.mTvPicturePreview.setEnabled(true);
            this.mTvPicturePreview.setSelected(true);
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText != 0) {
                    if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                        this.mTvPicturePreview.setText(java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText), java.lang.Integer.valueOf(list.size())));
                        this.mTvPreviewNum.setVisibility(0);
                        this.mTvPreviewNum.setText(java.text.MessageFormat.format("{0}", java.lang.Integer.valueOf(list.size())));
                    } else {
                        this.mTvPicturePreview.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
                    }
                } else {
                    this.mTvPicturePreview.setText(getString(com.up366.medialibrary.R.string.picture_preview_num, new java.lang.Object[]{java.lang.Integer.valueOf(list.size())}));
                }
            } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteTextColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewTextColor);
                }
                if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewText)) {
                    this.mTvPicturePreview.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewText);
                } else {
                    this.mTvPicturePreview.setText(getString(com.up366.medialibrary.R.string.picture_preview_num, new java.lang.Object[]{java.lang.Integer.valueOf(list.size())}));
                }
            }
            if (this.numComplete) {
                initCompleteText(list.size());
                return;
            }
            if (!this.isStartAnimation) {
                this.mTvPictureImgNum.startAnimation(this.animation);
            }
            this.mTvPictureImgNum.setVisibility(0);
            this.mTvPictureImgNum.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(list.size())));
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText));
                }
            } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText);
                }
            } else {
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_completed));
            }
            this.isStartAnimation = false;
            return;
        }
        this.mTvPictureOk.setEnabled(this.config.returnEmpty);
        this.mTvPictureOk.setSelected(false);
        this.mTvPicturePreview.setEnabled(false);
        this.mTvPicturePreview.setSelected(false);
        this.mTvPreviewNum.setVisibility(4);
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText != 0) {
                this.mTvPicturePreview.setText(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText));
            } else {
                this.mTvPicturePreview.setText(getString(com.up366.medialibrary.R.string.picture_preview));
            }
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                this.mTvPicturePreview.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewTextColor);
            }
            if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnPreviewText);
            } else {
                this.mTvPicturePreview.setText(getString(com.up366.medialibrary.R.string.picture_preview));
            }
        }
        if (this.numComplete) {
            initCompleteText(list.size());
            return;
        }
        this.mTvPictureImgNum.setVisibility(4);
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText));
            }
        } else {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText)) {
                    return;
                }
                this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText);
                return;
            }
            this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_please_select));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, android.content.Intent intent) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.util.ArrayList parcelableArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 == 0) {
                previewCallback(intent);
                if (i == 909) {
                    com.up366.medialibrary.common.utils.MediaUtils.deleteCamera(this, this.config.cameraPath);
                    return;
                }
                return;
            }
            if (i2 != 96 || intent == null || (th = (java.lang.Throwable) intent.getSerializableExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ERROR)) == null) {
                return;
            }
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), th.getMessage());
            return;
        }
        if (i == 69) {
            singleCropHandleResult(intent);
            return;
        }
        if (i == 166) {
            if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST)) == null || parcelableArrayListExtra.size() <= 0) {
                return;
            }
            onResult(parcelableArrayListExtra);
            return;
        }
        if (i == 609) {
            multiCropHandleResult(intent);
        } else {
            if (i != 909) {
                return;
            }
            dispatchHandleCamera(intent);
        }
    }

    private void previewCallback(android.content.Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.config.isOriginalControl) {
            this.config.isCheckOriginalImage = intent.getBooleanExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
        }
        java.util.ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST);
        if (this.mAdapter == null || parcelableArrayListExtra == null) {
            return;
        }
        int i = 0;
        if (intent.getBooleanExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_COMPLETE_SELECTED, false)) {
            onChangeData(parcelableArrayListExtra);
            if (this.config.isWithVideoImage) {
                int size = parcelableArrayListExtra.size();
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(parcelableArrayListExtra.get(i).getMimeType())) {
                        i++;
                    } else if (!this.config.isCompress) {
                        break;
                    } else {
                        compressImage(parcelableArrayListExtra);
                    }
                }
                onResult(parcelableArrayListExtra);
            } else {
                java.lang.String mimeType = parcelableArrayListExtra.size() > 0 ? parcelableArrayListExtra.get(0).getMimeType() : "";
                if (this.config.isCompress && com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(mimeType)) {
                    compressImage(parcelableArrayListExtra);
                } else {
                    onResult(parcelableArrayListExtra);
                }
            }
        } else {
            this.isStartAnimation = true;
        }
        this.mAdapter.bindSelectData(parcelableArrayListExtra);
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void singleDirectReturnCameraHandleResult(com.up366.medialibrary.model.LocalMedia localMedia) {
        java.lang.String mimeType = localMedia.getMimeType();
        boolean zIsImage = com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(mimeType);
        if (this.config.enableCrop && !this.config.isCheckOriginalImage && zIsImage) {
            this.config.originalPath = this.config.cameraPath;
            com.up366.medialibrary.manager.UCropManager.ofCrop(this, this.config.originalPath, mimeType, localMedia.getWidth(), localMedia.getHeight());
        } else if (this.config.isCompress && zIsImage) {
            compressImage(this.mAdapter.getSelectedData());
        } else {
            onResult(this.mAdapter.getSelectedData());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchHandleCamera(android.content.Intent intent) throws java.lang.Throwable {
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig;
        java.lang.String imageMimeType;
        int dCIMLastImageId;
        if (intent != null) {
            try {
                pictureSelectionConfig = (com.up366.medialibrary.config.PictureSelectionConfig) intent.getParcelableExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_CONFIG);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            pictureSelectionConfig = null;
        }
        if (pictureSelectionConfig != null) {
            this.config = pictureSelectionConfig;
        }
        if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()) {
            this.config.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio();
            this.config.cameraPath = getAudioPath(intent);
            if (android.text.TextUtils.isEmpty(this.config.cameraPath)) {
                return;
            }
            if (com.up366.medialibrary.common.utils.SdkVersionUtils.isR()) {
                try {
                    android.net.Uri uriCreateAudioUri = com.up366.medialibrary.common.utils.CameraFileUtils.createAudioUri(getContext(), android.text.TextUtils.isEmpty(this.config.cameraAudioFormatForQ) ? this.config.suffixType : this.config.cameraAudioFormatForQ);
                    if (uriCreateAudioUri != null) {
                        com.up366.medialibrary.common.utils.PictureFileUtils.writeFileFromIS(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(this, android.net.Uri.parse(this.config.cameraPath)), com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenOutputStream(this, uriCreateAudioUri));
                        this.config.cameraPath = uriCreateAudioUri.toString();
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (android.text.TextUtils.isEmpty(this.config.cameraPath)) {
            return;
        }
        com.up366.medialibrary.model.LocalMedia localMedia = new com.up366.medialibrary.model.LocalMedia();
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(this.config.cameraPath)) {
            java.lang.String path = com.up366.medialibrary.common.utils.PictureFileUtils.getPath(getContext(), android.net.Uri.parse(this.config.cameraPath));
            java.io.File file = new java.io.File(path);
            imageMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(path, this.config.cameraMimeType);
            localMedia.setSize(file.length());
            localMedia.setFileName(file.getName());
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(imageMimeType)) {
                com.up366.medialibrary.model.MediaExtraInfo imageSize = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(getContext(), this.config.cameraPath);
                localMedia.setWidth(imageSize.getWidth());
                localMedia.setHeight(imageSize.getHeight());
            } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(imageMimeType)) {
                com.up366.medialibrary.model.MediaExtraInfo videoSize = com.up366.medialibrary.common.utils.MediaUtils.getVideoSize(getContext(), this.config.cameraPath);
                localMedia.setWidth(videoSize.getWidth());
                localMedia.setHeight(videoSize.getHeight());
                localMedia.setDuration(videoSize.getDuration());
            } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(imageMimeType)) {
                localMedia.setDuration(com.up366.medialibrary.common.utils.MediaUtils.getAudioSize(getContext(), this.config.cameraPath).getDuration());
            }
            int iLastIndexOf = this.config.cameraPath.lastIndexOf("/") + 1;
            localMedia.setId(iLastIndexOf > 0 ? com.up366.medialibrary.common.utils.ValueOf.toLong(this.config.cameraPath.substring(iLastIndexOf)) : -1L);
            localMedia.setRealPath(path);
            java.lang.String stringExtra = intent != null ? intent.getStringExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_PATH) : null;
            localMedia.setAndroidQToPath(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(stringExtra) ? null : stringExtra);
            localMedia.setBucketId(com.up366.medialibrary.common.utils.AlbumUtils.generateCameraBucketId(getContext(), file, ""));
            localMedia.setDateAddedTime(file.lastModified() / 1000);
        } else {
            java.io.File file2 = new java.io.File(this.config.cameraPath);
            imageMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(this.config.cameraPath, this.config.cameraMimeType);
            localMedia.setSize(file2.length());
            localMedia.setFileName(file2.getName());
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(imageMimeType)) {
                com.up366.medialibrary.common.utils.BitmapUtils.rotateImage(getContext(), this.config.isCameraRotateImage, this.config.cameraPath);
                com.up366.medialibrary.model.MediaExtraInfo imageSize2 = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(getContext(), this.config.cameraPath);
                localMedia.setWidth(imageSize2.getWidth());
                localMedia.setHeight(imageSize2.getHeight());
            } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(imageMimeType)) {
                com.up366.medialibrary.model.MediaExtraInfo videoSize2 = com.up366.medialibrary.common.utils.MediaUtils.getVideoSize(getContext(), this.config.cameraPath);
                localMedia.setWidth(videoSize2.getWidth());
                localMedia.setHeight(videoSize2.getHeight());
                localMedia.setDuration(videoSize2.getDuration());
            } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(imageMimeType)) {
                localMedia.setDuration(com.up366.medialibrary.common.utils.MediaUtils.getAudioSize(getContext(), this.config.cameraPath).getDuration());
            }
            localMedia.setId(java.lang.System.currentTimeMillis());
            localMedia.setRealPath(this.config.cameraPath);
            java.lang.String stringExtra2 = intent != null ? intent.getStringExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_MEDIA_PATH) : null;
            if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                if (!android.text.TextUtils.isEmpty(stringExtra2) && !com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(stringExtra2)) {
                    localMedia.setAndroidQToPath(stringExtra2);
                } else {
                    localMedia.setAndroidQToPath(this.config.cameraPath);
                }
            }
            localMedia.setBucketId(com.up366.medialibrary.common.utils.AlbumUtils.generateCameraBucketId(getContext(), file2, this.config.outPutCameraPath));
            localMedia.setDateAddedTime(file2.lastModified() / 1000);
        }
        localMedia.setPath(this.config.cameraPath);
        localMedia.setMimeType(imageMimeType);
        localMedia.setParentFolderName(com.up366.medialibrary.common.utils.AlbumUtils.generateCameraFolderName(this.config.cameraPath, imageMimeType, this.config.outPutCameraPath));
        localMedia.setChooseModel(this.config.chooseMode);
        notifyAdapterData(localMedia);
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType()) && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(this.config.cameraPath)) {
                if (this.config.isFallbackVersion3) {
                    new com.up366.medialibrary.lib.PictureMediaScannerConnection(getContext(), localMedia.getRealPath());
                    return;
                } else {
                    sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.fromFile(new java.io.File(localMedia.getRealPath()))));
                    return;
                }
            }
            return;
        }
        if (this.config.isFallbackVersion3) {
            new com.up366.medialibrary.lib.PictureMediaScannerConnection(getContext(), this.config.cameraPath);
        } else {
            sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.fromFile(new java.io.File(this.config.cameraPath))));
        }
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType()) || (dCIMLastImageId = com.up366.medialibrary.common.utils.MediaUtils.getDCIMLastImageId(getContext())) == -1) {
            return;
        }
        com.up366.medialibrary.common.utils.MediaUtils.removeMedia(getContext(), dCIMLastImageId);
    }

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
    private void notifyAdapterData(com.up366.medialibrary.model.LocalMedia localMedia) {
        if (this.mAdapter != null) {
            if (!isAddSameImp(this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0)) {
                this.mAdapter.getData().add(0, localMedia);
                this.mOpenCameraCount++;
            }
            if (checkVideoLegitimacy(localMedia)) {
                if (this.config.selectionMode == 1) {
                    dispatchHandleSingle(localMedia);
                } else {
                    dispatchHandleMultiple(localMedia);
                }
            }
            this.mAdapter.notifyItemInserted(this.config.isCamera ? 1 : 0);
            this.mAdapter.notifyItemRangeChanged(this.config.isCamera ? 1 : 0, this.mAdapter.getSize());
            if (this.config.isOnlySandboxDir) {
                setTitle(localMedia.getParentFolderName());
            } else if (this.config.isPageStrategy) {
                manualSaveFolderForPageModel(localMedia);
            } else {
                manualSaveFolder(localMedia);
            }
            this.mTvEmpty.setVisibility((this.mAdapter.getSize() > 0 || this.config.isSingleDirectReturn) ? 8 : 0);
            if (this.folderWindow.getFolder(0) != null) {
                this.mTvPictureTitle.setTag(com.up366.medialibrary.R.id.view_count_tag, java.lang.Integer.valueOf(this.folderWindow.getFolder(0).getImageNum()));
            }
            this.allFolderSize = 0;
        }
    }

    private void dispatchHandleMultiple(com.up366.medialibrary.model.LocalMedia localMedia) {
        java.util.List<com.up366.medialibrary.model.LocalMedia> selectedData = this.mAdapter.getSelectedData();
        int size = selectedData.size();
        java.lang.String mimeType = size > 0 ? selectedData.get(0).getMimeType() : "";
        boolean zIsMimeTypeSame = com.up366.medialibrary.common.utils.MimeTypeUtils.isMimeTypeSame(mimeType, localMedia.getMimeType());
        if (this.config.isWithVideoImage) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(selectedData.get(i2).getMimeType())) {
                    i++;
                }
            }
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
                if (this.config.maxVideoSelectNum <= 0) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_rule));
                    return;
                } else if (i >= this.config.maxVideoSelectNum) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_message_max_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.maxVideoSelectNum)}));
                    return;
                } else {
                    selectedData.add(localMedia);
                    this.mAdapter.bindSelectData(selectedData);
                    return;
                }
            }
            if (selectedData.size() < this.config.maxSelectNum) {
                selectedData.add(localMedia);
                this.mAdapter.bindSelectData(selectedData);
                return;
            } else {
                showPromptDialog(com.up366.medialibrary.common.utils.StringUtils.getMsg(getContext(), localMedia.getMimeType(), this.config.maxSelectNum));
                return;
            }
        }
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(mimeType) && this.config.maxVideoSelectNum > 0) {
            if (size < this.config.maxVideoSelectNum) {
                if ((zIsMimeTypeSame || size == 0) && selectedData.size() < this.config.maxVideoSelectNum) {
                    selectedData.add(localMedia);
                    this.mAdapter.bindSelectData(selectedData);
                    return;
                }
                return;
            }
            showPromptDialog(com.up366.medialibrary.common.utils.StringUtils.getMsg(getContext(), mimeType, this.config.maxVideoSelectNum));
            return;
        }
        if (size >= this.config.maxSelectNum) {
            showPromptDialog(com.up366.medialibrary.common.utils.StringUtils.getMsg(getContext(), mimeType, this.config.maxSelectNum));
        } else if (zIsMimeTypeSame || size == 0) {
            selectedData.add(localMedia);
            this.mAdapter.bindSelectData(selectedData);
        }
    }

    private void dispatchHandleSingle(com.up366.medialibrary.model.LocalMedia localMedia) {
        java.util.List<com.up366.medialibrary.model.LocalMedia> selectedData = this.mAdapter.getSelectedData();
        if (this.config.isSingleDirectReturn) {
            selectedData.add(localMedia);
            this.mAdapter.bindSelectData(selectedData);
            singleDirectReturnCameraHandleResult(localMedia);
        } else {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isMimeTypeSame(selectedData.size() > 0 ? selectedData.get(0).getMimeType() : "", localMedia.getMimeType()) || selectedData.size() == 0) {
                singleRadioMediaImage();
                selectedData.add(localMedia);
                this.mAdapter.bindSelectData(selectedData);
            }
        }
    }

    private boolean checkVideoLegitimacy(com.up366.medialibrary.model.LocalMedia localMedia) {
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
            return true;
        }
        if (this.config.videoMinSecond <= 0 || this.config.videoMaxSecond <= 0) {
            if (this.config.videoMinSecond > 0) {
                if (localMedia.getDuration() >= this.config.videoMinSecond) {
                    return true;
                }
                showPromptDialog(getString(com.up366.medialibrary.R.string.picture_choose_min_seconds, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.videoMinSecond / 1000)}));
            } else {
                if (this.config.videoMaxSecond <= 0 || localMedia.getDuration() <= this.config.videoMaxSecond) {
                    return true;
                }
                showPromptDialog(getString(com.up366.medialibrary.R.string.picture_choose_max_seconds, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.videoMaxSecond / 1000)}));
            }
        } else {
            if (localMedia.getDuration() >= this.config.videoMinSecond && localMedia.getDuration() <= this.config.videoMaxSecond) {
                return true;
            }
            showPromptDialog(getString(com.up366.medialibrary.R.string.picture_choose_limit_seconds, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.videoMinSecond / 1000), java.lang.Integer.valueOf(this.config.videoMaxSecond / 1000)}));
        }
        return false;
    }

    private void singleCropHandleResult(android.content.Intent intent) {
        android.net.Uri output;
        if (intent == null || (output = com.up366.medialibrary.third.ucrop.UCrop.getOutput(intent)) == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String path = output.getPath();
        if (this.mAdapter != null) {
            java.util.ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST);
            if (parcelableArrayListExtra != null) {
                this.mAdapter.bindSelectData(parcelableArrayListExtra);
                this.mAdapter.notifyDataSetChanged();
            }
            java.util.List<com.up366.medialibrary.model.LocalMedia> selectedData = this.mAdapter.getSelectedData();
            com.up366.medialibrary.model.LocalMedia localMedia = null;
            com.up366.medialibrary.model.LocalMedia localMedia2 = (selectedData == null || selectedData.size() <= 0) ? null : selectedData.get(0);
            if (localMedia2 != null) {
                this.config.originalPath = localMedia2.getPath();
                localMedia2.setCutPath(path);
                localMedia2.setChooseModel(this.config.chooseMode);
                boolean z = !android.text.TextUtils.isEmpty(path);
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(localMedia2.getPath())) {
                    localMedia2.setAndroidQToPath(path);
                }
                localMedia2.setCropImageWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, 0));
                localMedia2.setCropImageHeight(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, 0));
                localMedia2.setCropOffsetX(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_X, 0));
                localMedia2.setCropOffsetY(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_Y, 0));
                localMedia2.setCropResultAspectRatio(intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f));
                localMedia2.setEditorImage(intent.getBooleanExtra("com.up366.medialibrary.third.ucrop.EditorImage", false));
                localMedia2.setCut(z);
                arrayList.add(localMedia2);
                handlerResult(arrayList);
                return;
            }
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                localMedia = (com.up366.medialibrary.model.LocalMedia) parcelableArrayListExtra.get(0);
            }
            if (localMedia != null) {
                this.config.originalPath = localMedia.getPath();
                localMedia.setCutPath(path);
                localMedia.setChooseModel(this.config.chooseMode);
                boolean z2 = !android.text.TextUtils.isEmpty(path);
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(localMedia.getPath())) {
                    localMedia.setAndroidQToPath(path);
                }
                localMedia.setCropImageWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, 0));
                localMedia.setCropImageHeight(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, 0));
                localMedia.setCropOffsetX(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_X, 0));
                localMedia.setCropOffsetY(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_Y, 0));
                localMedia.setCropResultAspectRatio(intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f));
                localMedia.setEditorImage(intent.getBooleanExtra("com.up366.medialibrary.third.ucrop.EditorImage", false));
                localMedia.setCut(z2);
                arrayList.add(localMedia);
                handlerResult(arrayList);
            }
        }
    }

    protected void multiCropHandleResult(android.content.Intent intent) {
        java.util.ArrayList<com.up366.medialibrary.model.LocalMedia> multipleOutput;
        if (intent == null || (multipleOutput = com.up366.medialibrary.third.ucrop.UCrop.getMultipleOutput(intent)) == null || multipleOutput.size() <= 0) {
            return;
        }
        this.mAdapter.bindSelectData(multipleOutput);
        this.mAdapter.notifyDataSetChanged();
        handlerResult(multipleOutput);
    }

    private void singleRadioMediaImage() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> selectedData = this.mAdapter.getSelectedData();
        if (selectedData == null || selectedData.size() <= 0) {
            return;
        }
        int position = selectedData.get(0).getPosition();
        selectedData.clear();
        this.mAdapter.notifyItemChanged(position);
    }

    private void manualSaveFolderForPageModel(com.up366.medialibrary.model.LocalMedia localMedia) {
        if (localMedia == null) {
            return;
        }
        int size = this.folderWindow.getFolderData().size();
        com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = size > 0 ? this.folderWindow.getFolderData().get(0) : new com.up366.medialibrary.model.LocalMediaFolder();
        int imageNum = localMediaFolder.getImageNum();
        localMediaFolder.setFirstImagePath(localMedia.getPath());
        localMediaFolder.setFirstMimeType(localMedia.getMimeType());
        localMediaFolder.setImageNum(isAddSameImp(imageNum) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1);
        if (size == 0) {
            localMediaFolder.setName(getString(this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio() ? com.up366.medialibrary.R.string.picture_all_audio : com.up366.medialibrary.R.string.picture_camera_roll));
            localMediaFolder.setOfAllType(this.config.chooseMode);
            localMediaFolder.setCameraFolder(true);
            localMediaFolder.setChecked(true);
            localMediaFolder.setBucketId(-1L);
            this.folderWindow.getFolderData().add(0, localMediaFolder);
            com.up366.medialibrary.model.LocalMediaFolder localMediaFolder2 = new com.up366.medialibrary.model.LocalMediaFolder();
            localMediaFolder2.setName(localMedia.getParentFolderName());
            localMediaFolder2.setImageNum(isAddSameImp(imageNum) ? localMediaFolder2.getImageNum() : localMediaFolder2.getImageNum() + 1);
            localMediaFolder2.setFirstImagePath(localMedia.getPath());
            localMediaFolder2.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder2.setBucketId(localMedia.getBucketId());
            this.folderWindow.getFolderData().add(this.folderWindow.getFolderData().size(), localMediaFolder2);
        } else {
            java.lang.String strGenerateCameraFolderName = com.up366.medialibrary.common.utils.AlbumUtils.generateCameraFolderName(localMedia.getPath(), localMedia.getMimeType(), this.config.outPutCameraPath);
            int i = 0;
            while (true) {
                if (i < size) {
                    com.up366.medialibrary.model.LocalMediaFolder localMediaFolder3 = this.folderWindow.getFolderData().get(i);
                    if (android.text.TextUtils.isEmpty(localMediaFolder3.getName()) || !localMediaFolder3.getName().startsWith(strGenerateCameraFolderName)) {
                        i++;
                    } else {
                        localMedia.setBucketId(localMediaFolder3.getBucketId());
                        localMediaFolder3.setFirstImagePath(this.config.cameraPath);
                        localMediaFolder3.setFirstMimeType(localMedia.getMimeType());
                        localMediaFolder3.setImageNum(isAddSameImp(imageNum) ? localMediaFolder3.getImageNum() : localMediaFolder3.getImageNum() + 1);
                        if (localMediaFolder3.getData() != null && localMediaFolder3.getData().size() > 0) {
                            localMediaFolder3.getData().add(0, localMedia);
                        }
                    }
                } else {
                    com.up366.medialibrary.model.LocalMediaFolder localMediaFolder4 = new com.up366.medialibrary.model.LocalMediaFolder();
                    localMediaFolder4.setName(localMedia.getParentFolderName());
                    localMediaFolder4.setImageNum(isAddSameImp(imageNum) ? localMediaFolder4.getImageNum() : localMediaFolder4.getImageNum() + 1);
                    localMediaFolder4.setFirstImagePath(localMedia.getPath());
                    localMediaFolder4.setFirstMimeType(localMedia.getMimeType());
                    localMediaFolder4.setBucketId(localMedia.getBucketId());
                    this.folderWindow.getFolderData().add(localMediaFolder4);
                    sortFolder(this.folderWindow.getFolderData());
                }
            }
        }
        com.up366.medialibrary.widget.FolderPopWindow folderPopWindow = this.folderWindow;
        folderPopWindow.bindFolder(folderPopWindow.getFolderData());
    }

    private void manualSaveFolder(com.up366.medialibrary.model.LocalMedia localMedia) {
        com.up366.medialibrary.model.LocalMediaFolder localMediaFolder;
        try {
            boolean zIsEmpty = this.folderWindow.isEmpty();
            int imageNum = this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0;
            if (zIsEmpty) {
                createNewFolder(this.folderWindow.getFolderData());
                localMediaFolder = this.folderWindow.getFolderData().size() > 0 ? this.folderWindow.getFolderData().get(0) : null;
                if (localMediaFolder == null) {
                    localMediaFolder = new com.up366.medialibrary.model.LocalMediaFolder();
                    this.folderWindow.getFolderData().add(0, localMediaFolder);
                }
            } else {
                localMediaFolder = this.folderWindow.getFolderData().get(0);
            }
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setData(this.mAdapter.getData());
            localMediaFolder.setBucketId(-1L);
            localMediaFolder.setImageNum(isAddSameImp(imageNum) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1);
            com.up366.medialibrary.model.LocalMediaFolder imageFolder = getImageFolder(localMedia.getPath(), localMedia.getRealPath(), localMedia.getMimeType(), this.folderWindow.getFolderData());
            if (imageFolder != null) {
                imageFolder.setImageNum(isAddSameImp(imageNum) ? imageFolder.getImageNum() : imageFolder.getImageNum() + 1);
                if (!isAddSameImp(imageNum)) {
                    imageFolder.getData().add(0, localMedia);
                }
                imageFolder.setBucketId(localMedia.getBucketId());
                imageFolder.setFirstImagePath(this.config.cameraPath);
                imageFolder.setFirstMimeType(localMedia.getMimeType());
            }
            com.up366.medialibrary.widget.FolderPopWindow folderPopWindow = this.folderWindow;
            folderPopWindow.bindFolder(folderPopWindow.getFolderData());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isAddSameImp(int i) {
        int i2;
        return i != 0 && (i2 = this.allFolderSize) > 0 && i2 < i;
    }

    private void updateMediaFolder(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list, com.up366.medialibrary.model.LocalMedia localMedia) {
        java.io.File parentFile = new java.io.File(localMedia.getRealPath()).getParentFile();
        if (parentFile == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = list.get(i);
            java.lang.String name = localMediaFolder.getName();
            if (!android.text.TextUtils.isEmpty(name) && name.equals(parentFile.getName())) {
                localMediaFolder.setFirstImagePath(this.config.cameraPath);
                localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                localMediaFolder.setCheckedNum(1);
                localMediaFolder.getData().add(0, localMedia);
                return;
            }
        }
    }

    public void onBackPressed() {
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.listener.onCancel();
        }
        exit();
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onDestroy() {
        super.onDestroy();
        android.view.animation.Animation animation = this.animation;
        if (animation != null) {
            animation.cancel();
            this.animation = null;
        }
        if (this.mediaPlayer != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    @Override // com.up366.medialibrary.listener.OnItemClickListener
    public void onItemClick(android.view.View view, int i) {
        if (i == 0) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
                com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
                this.config.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage();
                return;
            }
            startOpenCameraImage();
            return;
        }
        if (i != 1) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
            this.config.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo();
            return;
        }
        startOpenCameraVideo();
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                readLocalMedia();
                return;
            } else {
                showPermissionsDialog(false, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, getString(com.up366.medialibrary.R.string.picture_jurisdiction));
                return;
            }
        }
        if (i == 2) {
            if (iArr.length > 0 && iArr[0] == 0) {
                onTakePhoto();
                return;
            } else {
                showPermissionsDialog(true, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, getString(com.up366.medialibrary.R.string.picture_camera));
                return;
            }
        }
        if (i != 5) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            startCamera();
        } else {
            showPermissionsDialog(false, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, getString(com.up366.medialibrary.R.string.picture_jurisdiction));
        }
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void showPermissionsDialog(final boolean z, java.lang.String[] strArr, java.lang.String str) {
        if (isFinishing()) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.onPermissionsObtainCallback != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.onPermissionsObtainCallback.onPermissionsIntercept(getContext(), z, strArr, str, new com.up366.medialibrary.listener.OnPermissionDialogOptionCallback() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity.11
                @Override // com.up366.medialibrary.listener.OnPermissionDialogOptionCallback
                public void onCancel() {
                    if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
                        com.up366.medialibrary.config.PictureSelectionConfig.listener.onCancel();
                    }
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.exit();
                }

                @Override // com.up366.medialibrary.listener.OnPermissionDialogOptionCallback
                public void onSetting() {
                    com.up366.medialibrary.activity.PictureSelectorActivity.this.isEnterSetting = true;
                }
            });
            return;
        }
        final com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog = new com.up366.medialibrary.common.dialog.PictureCustomDialog(getContext(), com.up366.medialibrary.R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        android.widget.Button button = (android.widget.Button) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btn_cancel);
        android.widget.Button button2 = (android.widget.Button) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btn_commit);
        button2.setText(getString(com.up366.medialibrary.R.string.picture_go_setting));
        android.widget.TextView textView = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tvTitle);
        android.widget.TextView textView2 = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tv_content);
        textView.setText(getString(com.up366.medialibrary.R.string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m159x6aaf951f(pictureCustomDialog, z, view);
            }
        });
        button2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureSelectorActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m160x90439e20(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showPermissionsDialog$2$com-up366-medialibrary-activity-PictureSelectorActivity, reason: not valid java name */
    /* synthetic */ void m159x6aaf951f(com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog, boolean z, android.view.View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (z) {
            return;
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.listener != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.listener.onCancel();
        }
        exit();
    }

    /* JADX INFO: renamed from: lambda$showPermissionsDialog$3$com-up366-medialibrary-activity-PictureSelectorActivity, reason: not valid java name */
    /* synthetic */ void m160x90439e20(com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog, android.view.View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        com.up366.medialibrary.common.permissions.PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDataNull(java.lang.String str, int i) {
        if (this.mTvEmpty.getVisibility() == 8 || this.mTvEmpty.getVisibility() == 4) {
            this.mTvEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, i, 0, 0);
            this.mTvEmpty.setText(str);
            this.mTvEmpty.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideDataNull() {
        if (this.mTvEmpty.getVisibility() == 0) {
            this.mTvEmpty.setVisibility(8);
        }
    }
}
