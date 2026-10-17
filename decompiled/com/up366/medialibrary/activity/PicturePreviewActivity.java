package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PicturePreviewActivity extends com.up366.medialibrary.activity.PictureBaseActivity implements android.view.View.OnClickListener, com.up366.medialibrary.activity.PictureSimpleFragmentAdapter.OnCallBackActivity {
    public static final java.lang.String TAG = "PicturePreviewActivity";
    protected com.up366.medialibrary.activity.PictureSimpleFragmentAdapter adapter;
    protected android.view.animation.Animation animation;
    protected android.view.View btnCheck;
    protected android.widget.TextView check;
    protected java.lang.String currentDirectory;
    protected java.lang.String fileSize;
    protected int index;
    protected boolean isBottomPreview;
    protected boolean isChangeSelectedData;
    protected boolean isCompleteOrSelected;
    protected boolean isShowCamera;
    protected android.widget.CheckBox mCbOriginal;
    protected android.widget.ImageView mIvArrow;
    protected android.widget.TextView mPictureEditor;
    protected android.view.View mPicturePreview;
    protected android.view.ViewGroup mTitleBar;
    protected android.widget.TextView mTvPictureOk;
    protected android.widget.TextView mTvPictureRight;
    protected android.widget.ImageView pictureLeftBack;
    protected int position;
    protected boolean refresh;
    protected int screenWidth;
    protected android.widget.RelativeLayout selectBarLayout;
    private int totalNumber;
    protected android.widget.TextView tvMediaNum;
    protected android.widget.TextView tvTitle;
    protected com.up366.medialibrary.widget.PreviewViewPager viewPager;
    protected java.util.List<com.up366.medialibrary.model.LocalMedia> selectData = new java.util.ArrayList();
    private int mPage = 0;

    protected void onPageSelectedChange(com.up366.medialibrary.model.LocalMedia localMedia) {
    }

    protected void onSelectedChange(boolean z, com.up366.medialibrary.model.LocalMedia localMedia) {
    }

    protected void onUpdateGalleryChange(com.up366.medialibrary.model.LocalMedia localMedia) {
    }

    protected void onUpdateSelectedChange(com.up366.medialibrary.model.LocalMedia localMedia) {
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public int getResourceId() {
        return com.up366.medialibrary.R.layout.picture_preview;
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            java.util.List<com.up366.medialibrary.model.LocalMedia> listObtainSelectorList = com.up366.medialibrary.PictureSelector.obtainSelectorList(bundle);
            if (listObtainSelectorList == null) {
                listObtainSelectorList = this.selectData;
            }
            this.selectData = listObtainSelectorList;
            this.isCompleteOrSelected = bundle.getBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_COMPLETE_SELECTED, false);
            this.isChangeSelectedData = bundle.getBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_CHANGE_SELECTED_DATA, false);
            onImageChecked(this.position);
            onSelectNumChange(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.mTitleBar = (android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.titleBar);
        this.screenWidth = com.up366.medialibrary.common.utils.ScreenUtils.getScreenWidth(this);
        this.animation = android.view.animation.AnimationUtils.loadAnimation(this, com.up366.medialibrary.R.anim.picture_anim_modal_in);
        this.pictureLeftBack = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.pictureLeftBack);
        this.mTvPictureRight = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_right);
        this.mIvArrow = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.ivArrow);
        this.viewPager = (com.up366.medialibrary.widget.PreviewViewPager) findViewById(com.up366.medialibrary.R.id.preview_pager);
        this.mPicturePreview = findViewById(com.up366.medialibrary.R.id.picture_id_preview);
        this.mPictureEditor = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_id_editor);
        this.btnCheck = findViewById(com.up366.medialibrary.R.id.btnCheck);
        this.check = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.check);
        this.pictureLeftBack.setOnClickListener(this);
        this.mTvPictureOk = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_tv_ok);
        this.mCbOriginal = (android.widget.CheckBox) findViewById(com.up366.medialibrary.R.id.cb_original);
        this.tvMediaNum = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.tv_media_num);
        this.selectBarLayout = (android.widget.RelativeLayout) findViewById(com.up366.medialibrary.R.id.select_bar_layout);
        this.mTvPictureOk.setOnClickListener(this);
        this.tvMediaNum.setOnClickListener(this);
        this.tvTitle = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.picture_title);
        this.mPicturePreview.setVisibility(8);
        this.mIvArrow.setVisibility(8);
        this.mTvPictureRight.setVisibility(8);
        this.check.setVisibility(0);
        this.btnCheck.setVisibility(0);
        if (this.config.isEditorImage) {
            this.mPictureEditor.setVisibility(0);
            this.mPictureEditor.setOnClickListener(this);
        } else {
            this.mPictureEditor.setVisibility(8);
        }
        this.position = getIntent().getIntExtra("position", 0);
        if (this.numComplete) {
            initCompleteText(0);
        }
        this.tvMediaNum.setSelected(this.config.checkNumMode);
        this.btnCheck.setOnClickListener(this);
        if (getIntent().getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST) != null) {
            this.selectData = getIntent().getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST);
        }
        this.isBottomPreview = getIntent().getBooleanExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_BOTTOM_PREVIEW, false);
        this.isShowCamera = getIntent().getBooleanExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SHOW_CAMERA, this.config.isCamera);
        this.currentDirectory = getIntent().getStringExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_IS_CURRENT_DIRECTORY);
        if (this.isBottomPreview) {
            initViewPageAdapterData(getIntent().getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_SELECT_LIST));
        } else {
            final java.util.ArrayList arrayList = new java.util.ArrayList(com.up366.medialibrary.manager.ImagesObservable.getInstance().getData());
            com.up366.medialibrary.manager.ImagesObservable.getInstance().clearData();
            this.totalNumber = getIntent().getIntExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_DATA_COUNT, 0);
            if (this.config.isPageStrategy && !this.config.isOnlySandboxDir) {
                if (arrayList.size() == 0) {
                    setNewTitle();
                    initViewPageAdapterData(arrayList);
                    loadData();
                } else {
                    this.mPage = getIntent().getIntExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, 0);
                    initViewPageAdapterData(arrayList);
                }
            } else {
                initViewPageAdapterData(arrayList);
                if (arrayList.size() == 0) {
                    if (this.config.isOnlySandboxDir) {
                        this.mLoader.loadOnlyInAppDirectoryAllMedia(new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder>() { // from class: com.up366.medialibrary.activity.PicturePreviewActivity.1
                            @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
                            public void onComplete(com.up366.medialibrary.model.LocalMediaFolder localMediaFolder) {
                                com.up366.medialibrary.activity.PicturePreviewActivity.this.initViewPageAdapterData(localMediaFolder != null ? localMediaFolder.getData() : arrayList);
                            }
                        });
                    } else {
                        this.config.isPageStrategy = true;
                        this.mLoader = new com.up366.medialibrary.loader.LocalMediaPageLoader(getContext(), this.config);
                        setNewTitle();
                        loadData();
                    }
                }
            }
        }
        this.viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() { // from class: com.up366.medialibrary.activity.PicturePreviewActivity.2
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                com.up366.medialibrary.activity.PicturePreviewActivity picturePreviewActivity = com.up366.medialibrary.activity.PicturePreviewActivity.this;
                picturePreviewActivity.isPreviewEggs(picturePreviewActivity.config.previewEggs, i, i2);
            }

            public void onPageSelected(int i) {
                com.up366.medialibrary.activity.PicturePreviewActivity.this.position = i;
                com.up366.medialibrary.activity.PicturePreviewActivity.this.setTitle();
                com.up366.medialibrary.model.LocalMedia item = com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter.getItem(com.up366.medialibrary.activity.PicturePreviewActivity.this.position);
                if (item == null) {
                    return;
                }
                com.up366.medialibrary.activity.PicturePreviewActivity.this.index = item.getPosition();
                if (!com.up366.medialibrary.activity.PicturePreviewActivity.this.config.previewEggs) {
                    if (com.up366.medialibrary.activity.PicturePreviewActivity.this.config.checkNumMode) {
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.check.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(item.getNum())));
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.notifyCheckChanged(item);
                    }
                    com.up366.medialibrary.activity.PicturePreviewActivity picturePreviewActivity = com.up366.medialibrary.activity.PicturePreviewActivity.this;
                    picturePreviewActivity.onImageChecked(picturePreviewActivity.position);
                }
                if (com.up366.medialibrary.activity.PicturePreviewActivity.this.config.isOriginalControl) {
                    com.up366.medialibrary.activity.PicturePreviewActivity.this.mCbOriginal.setChecked(com.up366.medialibrary.activity.PicturePreviewActivity.this.config.isCheckOriginalImage);
                    if (com.up366.medialibrary.activity.PicturePreviewActivity.this.config.isDisplayOriginalSize) {
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.fileSize = com.up366.medialibrary.common.utils.PictureFileUtils.formatFileSize(item.getSize(), 2);
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.mCbOriginal.setText(com.up366.medialibrary.activity.PicturePreviewActivity.this.getString(com.up366.medialibrary.R.string.picture_original_image, new java.lang.Object[]{com.up366.medialibrary.activity.PicturePreviewActivity.this.fileSize}));
                    } else {
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.mCbOriginal.setText(com.up366.medialibrary.activity.PicturePreviewActivity.this.getString(com.up366.medialibrary.R.string.picture_default_original_image));
                    }
                }
                if (com.up366.medialibrary.activity.PicturePreviewActivity.this.config.isEditorImage) {
                    com.up366.medialibrary.activity.PicturePreviewActivity.this.mPictureEditor.setVisibility(com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(item.getMimeType()) ? 8 : 0);
                } else {
                    com.up366.medialibrary.activity.PicturePreviewActivity.this.mPictureEditor.setVisibility(8);
                }
                com.up366.medialibrary.activity.PicturePreviewActivity.this.onPageSelectedChange(item);
                if (!com.up366.medialibrary.activity.PicturePreviewActivity.this.config.isPageStrategy || com.up366.medialibrary.activity.PicturePreviewActivity.this.isBottomPreview || com.up366.medialibrary.activity.PicturePreviewActivity.this.config.isOnlySandboxDir || !com.up366.medialibrary.activity.PicturePreviewActivity.this.isHasMore) {
                    return;
                }
                if (com.up366.medialibrary.activity.PicturePreviewActivity.this.position == com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter.getSize() - 11 || com.up366.medialibrary.activity.PicturePreviewActivity.this.position == com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter.getSize() - 1) {
                    com.up366.medialibrary.activity.PicturePreviewActivity.this.loadMoreData();
                }
            }
        });
        if (this.config.isOriginalControl) {
            boolean booleanExtra = getIntent().getBooleanExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
            this.mCbOriginal.setVisibility(0);
            this.config.isCheckOriginalImage = booleanExtra;
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
            this.mCbOriginal.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.up366.medialibrary.activity.PicturePreviewActivity$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                    this.f$0.m157x88f5c238(compoundButton, z);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$initWidgets$0$com-up366-medialibrary-activity-PicturePreviewActivity, reason: not valid java name */
    /* synthetic */ void m157x88f5c238(android.widget.CompoundButton compoundButton, boolean z) {
        this.config.isCheckOriginalImage = z;
        if (this.selectData.size() == 0 && z) {
            onCheckedComplete();
        }
    }

    private void loadData() {
        long longExtra = getIntent().getLongExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID, -1L);
        this.mPage++;
        this.mLoader.loadPageMediaData(longExtra, this.mPage, this.config.pageSize, new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.activity.PicturePreviewActivity.3
            @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
            public void onComplete(java.util.List<com.up366.medialibrary.model.LocalMedia> list, int i, boolean z) {
                if (com.up366.medialibrary.activity.PicturePreviewActivity.this.isFinishing()) {
                    return;
                }
                com.up366.medialibrary.activity.PicturePreviewActivity.this.isHasMore = z;
                if (z) {
                    if (list.size() <= 0 || com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter == null) {
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.loadMoreData();
                    } else {
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter.getData().addAll(list);
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreData() {
        long longExtra = getIntent().getLongExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID, -1L);
        this.mPage++;
        this.mLoader.loadPageMediaData(longExtra, this.mPage, this.config.pageSize, new com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.activity.PicturePreviewActivity.4
            @Override // com.up366.medialibrary.listener.OnQueryDataResultListener
            public void onComplete(java.util.List<com.up366.medialibrary.model.LocalMedia> list, int i, boolean z) {
                if (com.up366.medialibrary.activity.PicturePreviewActivity.this.isFinishing()) {
                    return;
                }
                com.up366.medialibrary.activity.PicturePreviewActivity.this.isHasMore = z;
                if (z) {
                    if (list.size() <= 0 || com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter == null) {
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.loadMoreData();
                    } else {
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter.getData().addAll(list);
                        com.up366.medialibrary.activity.PicturePreviewActivity.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void initCompleteText(int i) {
        if (this.config.selectionMode == 1) {
            if (i <= 0) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                    this.mTvPictureOk.setText(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText : com.up366.medialibrary.R.string.picture_please_select));
                    return;
                } else {
                    if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                        this.mTvPictureOk.setText(!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText) ? com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText : getString(com.up366.medialibrary.R.string.picture_please_select));
                        return;
                    }
                    return;
                }
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum && com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText(java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), java.lang.Integer.valueOf(i), 1));
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
                this.mTvPictureOk.setText((!com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum || com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText == 0) ? getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}) : java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)));
                return;
            } else {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                    this.mTvPictureOk.setText((!com.up366.medialibrary.config.PictureSelectionConfig.style.isCompleteReplaceNum || android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText)) ? getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}) : com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText);
                    return;
                }
                return;
            }
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.isCompleteReplaceNum && com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                this.mTvPictureOk.setText(java.lang.String.format(getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)));
                return;
            } else {
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}));
                return;
            }
        }
        if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.isCompleteReplaceNum && !android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText(java.lang.String.format(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)));
            } else {
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_done_front_num, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.config.maxSelectNum)}));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    public void initPictureSelectorStyle() {
        android.content.res.ColorStateList colorStateList;
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                this.tvTitle.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextSize != 0) {
                this.tvTitle.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_leftBack != 0) {
                this.pictureLeftBack.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_leftBack);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.selectBarLayout.setBackgroundColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground != 0) {
                this.tvMediaNum.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_style != 0) {
                this.check.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_style);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor.length > 0 && (colorStateList = com.up366.medialibrary.common.utils.AttrsUtils.getColorStateList(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor)) != null) {
                this.mTvPictureOk.setTextColor(colorStateList);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.selectBarLayout.getLayoutParams().height = com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isEditorImage) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextSize != 0) {
                    this.mPictureEditor.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextSize);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextColor != 0) {
                    this.mPictureEditor.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextColor);
                }
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
                    this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_53575e));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_53575e));
            }
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.tvTitle.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.tvTitle.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.pictureLeftBack.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewBottomBgColor != 0) {
                this.selectBarLayout.setBackgroundColor(com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewBottomBgColor);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckNumBgStyle != 0) {
                this.tvMediaNum.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckNumBgStyle);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckedStyle != 0) {
                this.check.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckedStyle);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (!android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteText);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleBarHeight;
            }
            if (this.config.isEditorImage) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewEditorTextSize != 0) {
                    this.mPictureEditor.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewEditorTextSize);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewEditorTextColor != 0) {
                    this.mPictureEditor.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.picturePreviewEditorTextColor);
                }
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
                    this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_53575e));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalTextSize != 0) {
                    this.mCbOriginal.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureOriginalTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.up366.medialibrary.R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.picture_color_53575e));
            }
        } else {
            this.check.setBackground(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_checked_style, com.up366.medialibrary.R.drawable.picture_checkbox_selector));
            android.content.res.ColorStateList typeValueColorStateList = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColorStateList(getContext(), com.up366.medialibrary.R.attr.picture_ac_preview_complete_textColor);
            if (typeValueColorStateList != null) {
                this.mTvPictureOk.setTextColor(typeValueColorStateList);
            }
            this.pictureLeftBack.setImageDrawable(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_preview_leftBack_icon, com.up366.medialibrary.R.drawable.picture_icon_back));
            int typeValueColor = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_ac_preview_title_textColor);
            if (typeValueColor != 0) {
                this.tvTitle.setTextColor(typeValueColor);
            }
            this.tvMediaNum.setBackground(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_num_style, com.up366.medialibrary.R.drawable.picture_num_oval));
            int typeValueColor2 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_ac_preview_bottom_bg);
            if (typeValueColor2 != 0) {
                this.selectBarLayout.setBackgroundColor(typeValueColor2);
            }
            int typeValueSizeForInt = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueSizeForInt(getContext(), com.up366.medialibrary.R.attr.picture_titleBar_height);
            if (typeValueSizeForInt > 0) {
                this.mTitleBar.getLayoutParams().height = typeValueSizeForInt;
            }
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(getContext(), com.up366.medialibrary.R.attr.picture_original_check_style, com.up366.medialibrary.R.drawable.picture_original_wechat_checkbox));
                int typeValueColor3 = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(getContext(), com.up366.medialibrary.R.attr.picture_original_text_color);
                if (typeValueColor3 != 0) {
                    this.mCbOriginal.setTextColor(typeValueColor3);
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        onSelectNumChange(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isPreviewEggs(boolean z, int i, int i2) {
        if (!z || this.adapter.getSize() <= 0) {
            return;
        }
        if (i2 < this.screenWidth / 2) {
            com.up366.medialibrary.model.LocalMedia item = this.adapter.getItem(i);
            if (item != null) {
                this.check.setSelected(isSelected(item));
                if (this.config.isWeChatStyle) {
                    onUpdateSelectedChange(item);
                    return;
                } else {
                    if (this.config.checkNumMode) {
                        this.check.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(item.getNum())));
                        notifyCheckChanged(item);
                        onImageChecked(i);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        int i3 = i + 1;
        com.up366.medialibrary.model.LocalMedia item2 = this.adapter.getItem(i3);
        if (item2 != null) {
            this.check.setSelected(isSelected(item2));
            if (this.config.isWeChatStyle) {
                onUpdateSelectedChange(item2);
            } else if (this.config.checkNumMode) {
                this.check.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(item2.getNum())));
                notifyCheckChanged(item2);
                onImageChecked(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPageAdapterData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        com.up366.medialibrary.activity.PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = new com.up366.medialibrary.activity.PictureSimpleFragmentAdapter(getContext(), this.config, this);
        this.adapter = pictureSimpleFragmentAdapter;
        pictureSimpleFragmentAdapter.bindData(list);
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.setCurrentItem(this.position);
        setTitle();
        onImageChecked(this.position);
        com.up366.medialibrary.model.LocalMedia item = this.adapter.getItem(this.position);
        if (item != null) {
            this.index = item.getPosition();
            if (this.config.isOriginalControl) {
                if (this.config.isDisplayOriginalSize) {
                    this.fileSize = com.up366.medialibrary.common.utils.PictureFileUtils.formatFileSize(item.getSize(), 2);
                    this.mCbOriginal.setText(getString(com.up366.medialibrary.R.string.picture_original_image, new java.lang.Object[]{this.fileSize}));
                } else {
                    this.mCbOriginal.setText(getString(com.up366.medialibrary.R.string.picture_default_original_image));
                }
            }
            if (this.config.checkNumMode) {
                this.tvMediaNum.setSelected(true);
                this.check.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(item.getNum())));
                notifyCheckChanged(item);
            }
            if (this.config.isEditorImage) {
                this.mPictureEditor.setVisibility(com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(item.getMimeType()) ? 8 : 0);
            } else {
                this.mPictureEditor.setVisibility(8);
            }
        }
    }

    private void setNewTitle() {
        this.mPage = 0;
        this.position = 0;
        setTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle() {
        if (this.config.isPageStrategy && !this.isBottomPreview && !this.config.isOnlySandboxDir) {
            this.tvTitle.setText(getString(com.up366.medialibrary.R.string.picture_preview_image_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.position + 1), java.lang.Integer.valueOf(this.totalNumber)}));
        } else {
            this.tvTitle.setText(getString(com.up366.medialibrary.R.string.picture_preview_image_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.position + 1), java.lang.Integer.valueOf(this.adapter.getSize())}));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCheckChanged(com.up366.medialibrary.model.LocalMedia localMedia) {
        if (this.config.checkNumMode) {
            this.check.setText("");
            int size = this.selectData.size();
            for (int i = 0; i < size; i++) {
                com.up366.medialibrary.model.LocalMedia localMedia2 = this.selectData.get(i);
                if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    this.check.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(localMedia.getNum())));
                }
            }
        }
    }

    private void subSelectPosition() {
        int size = this.selectData.size();
        int i = 0;
        while (i < size) {
            com.up366.medialibrary.model.LocalMedia localMedia = this.selectData.get(i);
            i++;
            localMedia.setNum(i);
        }
    }

    public void onImageChecked(int i) {
        if (this.adapter.getSize() > 0) {
            com.up366.medialibrary.model.LocalMedia item = this.adapter.getItem(i);
            if (item != null) {
                this.check.setSelected(isSelected(item));
                return;
            }
            return;
        }
        this.check.setSelected(false);
    }

    protected boolean isSelected(com.up366.medialibrary.model.LocalMedia localMedia) {
        int size = this.selectData.size();
        for (int i = 0; i < size; i++) {
            com.up366.medialibrary.model.LocalMedia localMedia2 = this.selectData.get(i);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                return true;
            }
        }
        return false;
    }

    protected void onSelectNumChange(boolean z) {
        this.refresh = z;
        if (this.selectData.size() != 0) {
            this.mTvPictureOk.setEnabled(true);
            this.mTvPictureOk.setSelected(true);
            if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteTextColor);
                } else {
                    this.mTvPictureOk.setTextColor(androidx.core.content.ContextCompat.getColor(getContext(), com.up366.medialibrary.R.color.picture_color_fa632d));
                }
            }
            if (this.numComplete) {
                initCompleteText(this.selectData.size());
                return;
            }
            if (this.refresh) {
                this.tvMediaNum.startAnimation(this.animation);
            }
            this.tvMediaNum.setVisibility(0);
            this.tvMediaNum.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(this.selectData.size())));
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText);
                    return;
                }
                return;
            } else {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                    if (android.text.TextUtils.isEmpty(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText)) {
                        return;
                    }
                    this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCompleteText);
                    return;
                }
                this.mTvPictureOk.setText(getString(com.up366.medialibrary.R.string.picture_completed));
                return;
            }
        }
        this.mTvPictureOk.setEnabled(false);
        this.mTvPictureOk.setSelected(false);
        if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureUnCompleteTextColor);
            } else {
                this.mTvPictureOk.setTextColor(androidx.core.content.ContextCompat.getColor(getContext(), com.up366.medialibrary.R.color.picture_color_9b));
            }
        }
        if (this.numComplete) {
            initCompleteText(0);
            return;
        }
        this.tvMediaNum.setVisibility(4);
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
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

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.up366.medialibrary.R.id.pictureLeftBack) {
            onBackPressed();
            return;
        }
        if (id == com.up366.medialibrary.R.id.picture_tv_ok || id == com.up366.medialibrary.R.id.tv_media_num) {
            onComplete();
        } else if (id == com.up366.medialibrary.R.id.btnCheck) {
            onCheckedComplete();
        } else if (id == com.up366.medialibrary.R.id.picture_id_editor) {
            onEditorImage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onEditorImage() {
        if (this.adapter.getSize() > 0) {
            com.up366.medialibrary.model.LocalMedia item = this.adapter.getItem(this.viewPager.getCurrentItem());
            com.up366.medialibrary.manager.UCropManager.ofEditorImage(this, item.getPath(), item.getMimeType(), item.getWidth(), item.getHeight());
        }
    }

    protected void onCheckedComplete() {
        boolean z;
        if (this.adapter.getSize() > 0) {
            com.up366.medialibrary.model.LocalMedia item = this.adapter.getItem(this.viewPager.getCurrentItem());
            java.lang.String realPath = item.getRealPath();
            if (!android.text.TextUtils.isEmpty(realPath) && !new java.io.File(realPath).exists()) {
                com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), com.up366.medialibrary.common.utils.MimeTypeUtils.s(getContext(), item.getMimeType()));
                return;
            }
            java.lang.String mimeType = this.selectData.size() > 0 ? this.selectData.get(0).getMimeType() : "";
            int size = this.selectData.size();
            if (this.config.isWithVideoImage) {
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(this.selectData.get(i2).getMimeType())) {
                        i++;
                    }
                }
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(item.getMimeType())) {
                    if (this.config.maxVideoSelectNum <= 0) {
                        showPromptDialog(getString(com.up366.medialibrary.R.string.picture_rule));
                        return;
                    }
                    if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                        showPromptDialog(getString(com.up366.medialibrary.R.string.picture_message_max_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.maxSelectNum)}));
                        return;
                    }
                    if (i >= this.config.maxVideoSelectNum && !this.check.isSelected()) {
                        showPromptDialog(com.up366.medialibrary.common.utils.StringUtils.getMsg(getContext(), item.getMimeType(), this.config.maxVideoSelectNum));
                        return;
                    }
                    if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < this.config.videoMinSecond) {
                        showPromptDialog(getContext().getString(com.up366.medialibrary.R.string.picture_choose_min_seconds, java.lang.Integer.valueOf(this.config.videoMinSecond / 1000)));
                        return;
                    } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > this.config.videoMaxSecond) {
                        showPromptDialog(getContext().getString(com.up366.medialibrary.R.string.picture_choose_max_seconds, java.lang.Integer.valueOf(this.config.videoMaxSecond / 1000)));
                        return;
                    }
                } else if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_message_max_num, new java.lang.Object[]{java.lang.Integer.valueOf(this.config.maxSelectNum)}));
                    return;
                }
            } else {
                if (!android.text.TextUtils.isEmpty(mimeType) && !com.up366.medialibrary.common.utils.MimeTypeUtils.isMimeTypeSame(mimeType, item.getMimeType())) {
                    showPromptDialog(getString(com.up366.medialibrary.R.string.picture_rule));
                    return;
                }
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(mimeType) && this.config.maxVideoSelectNum > 0) {
                    if (size >= this.config.maxVideoSelectNum && !this.check.isSelected()) {
                        showPromptDialog(com.up366.medialibrary.common.utils.StringUtils.getMsg(getContext(), mimeType, this.config.maxVideoSelectNum));
                        return;
                    }
                    if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < this.config.videoMinSecond) {
                        showPromptDialog(getContext().getString(com.up366.medialibrary.R.string.picture_choose_min_seconds, java.lang.Integer.valueOf(this.config.videoMinSecond / 1000)));
                        return;
                    } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > this.config.videoMaxSecond) {
                        showPromptDialog(getContext().getString(com.up366.medialibrary.R.string.picture_choose_max_seconds, java.lang.Integer.valueOf(this.config.videoMaxSecond / 1000)));
                        return;
                    }
                } else {
                    if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                        showPromptDialog(com.up366.medialibrary.common.utils.StringUtils.getMsg(getContext(), mimeType, this.config.maxSelectNum));
                        return;
                    }
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(item.getMimeType())) {
                        if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < this.config.videoMinSecond) {
                            showPromptDialog(getContext().getString(com.up366.medialibrary.R.string.picture_choose_min_seconds, java.lang.Integer.valueOf(this.config.videoMinSecond / 1000)));
                            return;
                        } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > this.config.videoMaxSecond) {
                            showPromptDialog(getContext().getString(com.up366.medialibrary.R.string.picture_choose_max_seconds, java.lang.Integer.valueOf(this.config.videoMaxSecond / 1000)));
                            return;
                        }
                    }
                }
            }
            if (!this.check.isSelected()) {
                this.check.setSelected(true);
                this.check.startAnimation(this.animation);
                z = true;
            } else {
                this.check.setSelected(false);
                z = false;
            }
            this.isChangeSelectedData = true;
            if (z) {
                com.up366.medialibrary.common.utils.VoiceUtils.getInstance().play();
                if (this.config.selectionMode == 1) {
                    this.selectData.clear();
                }
                this.selectData.add(item);
                onSelectedChange(true, item);
                item.setNum(this.selectData.size());
                if (this.config.checkNumMode) {
                    this.check.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(item.getNum())));
                }
            } else {
                int size2 = this.selectData.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    com.up366.medialibrary.model.LocalMedia localMedia = this.selectData.get(i3);
                    if (localMedia.getPath().equals(item.getPath()) || localMedia.getId() == item.getId()) {
                        this.selectData.remove(localMedia);
                        onSelectedChange(false, item);
                        subSelectPosition();
                        notifyCheckChanged(localMedia);
                        break;
                    }
                }
            }
            onSelectNumChange(true);
        }
    }

    protected void onComplete() {
        int size = this.selectData.size();
        com.up366.medialibrary.model.LocalMedia localMedia = this.selectData.size() > 0 ? this.selectData.get(0) : null;
        java.lang.String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        if (this.config.isWithVideoImage) {
            int size2 = this.selectData.size();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(this.selectData.get(i3).getMimeType())) {
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
        this.isCompleteOrSelected = true;
        this.isChangeSelectedData = true;
        if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll() && this.config.isWithVideoImage) {
            bothMimeTypeWith(mimeType, localMedia);
        } else {
            separateMimeTypeWith(mimeType, localMedia);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bothMimeTypeWith(java.lang.String str, com.up366.medialibrary.model.LocalMedia localMedia) {
        if (this.config.enableCrop && !this.config.isCheckOriginalImage) {
            this.isCompleteOrSelected = false;
            boolean zIsImage = com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(str);
            if (this.config.selectionMode == 1 && zIsImage) {
                this.config.originalPath = localMedia.getPath();
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType(), localMedia.getWidth(), localMedia.getHeight());
                return;
            }
            int size = this.selectData.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                com.up366.medialibrary.model.LocalMedia localMedia2 = this.selectData.get(i2);
                if (localMedia2 != null && !android.text.TextUtils.isEmpty(localMedia2.getPath()) && com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia2.getMimeType())) {
                    i++;
                }
            }
            if (i <= 0) {
                this.isCompleteOrSelected = true;
                onBackPressed();
                return;
            } else {
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, (java.util.ArrayList) this.selectData);
                return;
            }
        }
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void separateMimeTypeWith(java.lang.String str, com.up366.medialibrary.model.LocalMedia localMedia) {
        if (this.config.enableCrop && !this.config.isCheckOriginalImage && com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(str)) {
            this.isCompleteOrSelected = false;
            if (this.config.selectionMode == 1) {
                this.config.originalPath = localMedia.getPath();
                com.up366.medialibrary.manager.UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType(), localMedia.getWidth(), localMedia.getHeight());
                return;
            }
            com.up366.medialibrary.manager.UCropManager.ofCrop(this, (java.util.ArrayList) this.selectData);
            return;
        }
        onBackPressed();
    }

    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.lang.Throwable th;
        com.up366.medialibrary.model.LocalMedia localMedia;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 != 96 || (th = (java.lang.Throwable) intent.getSerializableExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ERROR)) == null) {
                return;
            }
            com.up366.medialibrary.common.utils.ToastUtils.s(getContext(), th.getMessage());
            return;
        }
        if (i != 69) {
            if (i != 609) {
                return;
            }
            intent.putParcelableArrayListExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_OUTPUT_URI_LIST, com.up366.medialibrary.third.ucrop.UCrop.getMultipleOutput(intent));
            intent.putParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST, (java.util.ArrayList) this.selectData);
            setResult(-1, intent);
            finish();
            return;
        }
        if (intent != null) {
            if (!intent.getBooleanExtra("com.up366.medialibrary.third.ucrop.EditorImage", false)) {
                intent.putParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST, (java.util.ArrayList) this.selectData);
                setResult(-1, intent);
                finish();
                return;
            }
            android.net.Uri output = com.up366.medialibrary.third.ucrop.UCrop.getOutput(intent);
            if (output == null || this.adapter == null) {
                return;
            }
            java.lang.String path = output.getPath();
            com.up366.medialibrary.model.LocalMedia item = this.adapter.getItem(this.viewPager.getCurrentItem());
            for (int i3 = 0; i3 < this.selectData.size(); i3++) {
                localMedia = this.selectData.get(i3);
                if (android.text.TextUtils.equals(item.getPath(), localMedia.getPath()) || item.getId() == localMedia.getId()) {
                    z = true;
                    break;
                }
            }
            localMedia = null;
            z = false;
            item.setCut(!android.text.TextUtils.isEmpty(path));
            item.setCutPath(path);
            item.setCropOffsetX(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_X, 0));
            item.setCropOffsetY(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_Y, 0));
            item.setCropResultAspectRatio(intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f));
            item.setCropImageWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, 0));
            item.setCropImageHeight(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, 0));
            item.setEditorImage(item.isCut());
            if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(item.getPath())) {
                item.setAndroidQToPath(path);
            }
            if (z) {
                localMedia.setCut(!android.text.TextUtils.isEmpty(path));
                localMedia.setCutPath(path);
                localMedia.setCropOffsetX(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_X, 0));
                localMedia.setCropOffsetY(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_Y, 0));
                localMedia.setCropResultAspectRatio(intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f));
                localMedia.setCropImageWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, 0));
                localMedia.setCropImageHeight(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, 0));
                localMedia.setEditorImage(item.isCut());
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(item.getPath())) {
                    localMedia.setAndroidQToPath(path);
                }
                this.isChangeSelectedData = true;
                onUpdateGalleryChange(localMedia);
            } else {
                onCheckedComplete();
            }
            this.adapter.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        updateResult();
        finish();
        overridePendingTransition(0, com.up366.medialibrary.config.PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    private void updateResult() {
        android.content.Intent intent = new android.content.Intent();
        if (this.isChangeSelectedData) {
            intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
            intent.putParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST, (java.util.ArrayList) this.selectData);
        }
        if (this.config.isOriginalControl) {
            intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        }
        setResult(0, intent);
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
        bundle.putBoolean(com.up366.medialibrary.config.PictureConstants.EXTRA_CHANGE_SELECTED_DATA, this.isChangeSelectedData);
        com.up366.medialibrary.PictureSelector.saveSelectorList(bundle, this.selectData);
        if (this.adapter != null) {
            com.up366.medialibrary.manager.ImagesObservable.getInstance().saveData(this.adapter.getData());
        }
    }

    @Override // com.up366.medialibrary.activity.PictureBaseActivity
    protected void onDestroy() {
        super.onDestroy();
        android.view.animation.Animation animation = this.animation;
        if (animation != null) {
            animation.cancel();
        }
        com.up366.medialibrary.activity.PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = this.adapter;
        if (pictureSimpleFragmentAdapter != null) {
            pictureSimpleFragmentAdapter.clear();
        }
    }

    @Override // com.up366.medialibrary.activity.PictureSimpleFragmentAdapter.OnCallBackActivity
    public void onActivityBackPressed() {
        onBackPressed();
    }
}
