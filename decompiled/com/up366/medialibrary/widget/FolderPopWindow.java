package com.up366.medialibrary.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FolderPopWindow extends android.widget.PopupWindow {
    private static final int FOLDER_MAX_COUNT = 8;
    private com.up366.medialibrary.activity.PictureAlbumDirectoryAdapter adapter;
    private final int chooseMode;
    private final com.up366.medialibrary.config.PictureSelectionConfig config;
    private final android.content.Context context;
    private android.graphics.drawable.Drawable drawableDown;
    private android.graphics.drawable.Drawable drawableUp;
    private boolean isDismiss = false;
    private android.widget.ImageView ivArrowView;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private final int maxHeight;
    private android.view.View rootViewBg;
    private final android.view.View window;

    public FolderPopWindow(android.content.Context context) {
        this.context = context;
        com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig = com.up366.medialibrary.config.PictureSelectionConfig.getInstance();
        this.config = pictureSelectionConfig;
        this.chooseMode = pictureSelectionConfig.chooseMode;
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.up366.medialibrary.R.layout.picture_window_folder, (android.view.ViewGroup) null);
        this.window = viewInflate;
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(com.up366.medialibrary.R.style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowUpDrawable != 0) {
                this.drawableUp = androidx.core.content.ContextCompat.getDrawable(context, com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowUpDrawable);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable != 0) {
                this.drawableDown = androidx.core.content.ContextCompat.getDrawable(context, com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable);
            }
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleUpResId != 0) {
                this.drawableUp = androidx.core.content.ContextCompat.getDrawable(context, com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleUpResId);
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleDownResId != 0) {
                this.drawableDown = androidx.core.content.ContextCompat.getDrawable(context, com.up366.medialibrary.config.PictureSelectionConfig.style.pictureTitleDownResId);
            }
        } else if (pictureSelectionConfig.isWeChatStyle) {
            this.drawableUp = androidx.core.content.ContextCompat.getDrawable(context, com.up366.medialibrary.R.drawable.picture_icon_wechat_up);
            this.drawableDown = androidx.core.content.ContextCompat.getDrawable(context, com.up366.medialibrary.R.drawable.picture_icon_wechat_down);
        } else {
            if (pictureSelectionConfig.upResId != 0) {
                this.drawableUp = androidx.core.content.ContextCompat.getDrawable(context, pictureSelectionConfig.upResId);
            } else {
                this.drawableUp = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(context, com.up366.medialibrary.R.attr.picture_arrow_up_icon, com.up366.medialibrary.R.drawable.picture_icon_arrow_up);
            }
            if (pictureSelectionConfig.downResId != 0) {
                this.drawableDown = androidx.core.content.ContextCompat.getDrawable(context, pictureSelectionConfig.downResId);
            } else {
                this.drawableDown = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(context, com.up366.medialibrary.R.attr.picture_arrow_down_icon, com.up366.medialibrary.R.drawable.picture_icon_arrow_down);
            }
        }
        this.maxHeight = (int) (((double) com.up366.medialibrary.common.utils.ScreenUtils.getScreenHeight(context)) * 0.6d);
        initView();
    }

    public void initView() {
        this.rootViewBg = this.window.findViewById(com.up366.medialibrary.R.id.rootViewBg);
        this.adapter = new com.up366.medialibrary.activity.PictureAlbumDirectoryAdapter(this.config);
        androidx.recyclerview.widget.RecyclerView recyclerViewFindViewById = this.window.findViewById(com.up366.medialibrary.R.id.folder_list);
        this.mRecyclerView = recyclerViewFindViewById;
        recyclerViewFindViewById.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.context));
        this.mRecyclerView.setAdapter(this.adapter);
        this.window.findViewById(com.up366.medialibrary.R.id.rootView);
        this.rootViewBg.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.widget.FolderPopWindow$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m177lambda$initView$0$comup366medialibrarywidgetFolderPopWindow(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-up366-medialibrary-widget-FolderPopWindow, reason: not valid java name */
    /* synthetic */ void m177lambda$initView$0$comup366medialibrarywidgetFolderPopWindow(android.view.View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-up366-medialibrary-widget-FolderPopWindow, reason: not valid java name */
    /* synthetic */ void m178lambda$initView$1$comup366medialibrarywidgetFolderPopWindow(android.view.View view) {
        dismiss();
    }

    public void bindFolder(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        this.adapter.setChooseMode(this.chooseMode);
        this.adapter.bindFolderData(list);
        this.mRecyclerView.getLayoutParams().height = list.size() > 8 ? this.maxHeight : -2;
    }

    public java.util.List<com.up366.medialibrary.model.LocalMediaFolder> getFolderData() {
        return this.adapter.getFolderData();
    }

    public boolean isEmpty() {
        return this.adapter.getFolderData().size() == 0;
    }

    public com.up366.medialibrary.model.LocalMediaFolder getFolder(int i) {
        if (this.adapter.getFolderData().size() <= 0 || i >= this.adapter.getFolderData().size()) {
            return null;
        }
        return this.adapter.getFolderData().get(i);
    }

    public void setArrowImageView(android.widget.ImageView imageView) {
        this.ivArrowView = imageView;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view) {
        try {
            if (android.os.Build.VERSION.SDK_INT == 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                showAtLocation(view, 0, 0, iArr[1] + view.getHeight());
            } else {
                super.showAsDropDown(view);
            }
            this.isDismiss = false;
            this.ivArrowView.setImageDrawable(this.drawableUp);
            com.up366.medialibrary.common.utils.AnimUtils.rotateArrow(this.ivArrowView, true);
            this.rootViewBg.animate().alpha(1.0f).setDuration(250L).setStartDelay(250L).start();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnAlbumItemClickListener(com.up366.medialibrary.listener.OnAlbumItemClickListener onAlbumItemClickListener) {
        this.adapter.setOnAlbumItemClickListener(onAlbumItemClickListener);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isDismiss) {
            return;
        }
        this.rootViewBg.animate().alpha(0.0f).setDuration(50L).start();
        this.ivArrowView.setImageDrawable(this.drawableDown);
        com.up366.medialibrary.common.utils.AnimUtils.rotateArrow(this.ivArrowView, false);
        this.isDismiss = true;
        super.dismiss();
        this.isDismiss = false;
    }

    public void updateFolderCheckStatus(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        int i;
        try {
            java.util.List<com.up366.medialibrary.model.LocalMediaFolder> folderData = this.adapter.getFolderData();
            int size = folderData.size();
            int size2 = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = folderData.get(i2);
                localMediaFolder.setCheckedNum(0);
                for (0; i < size2; i + 1) {
                    i = (localMediaFolder.getName().equals(list.get(i).getParentFolderName()) || localMediaFolder.getBucketId() == -1) ? 0 : i + 1;
                    localMediaFolder.setCheckedNum(1);
                    break;
                }
            }
            this.adapter.bindFolderData(folderData);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
