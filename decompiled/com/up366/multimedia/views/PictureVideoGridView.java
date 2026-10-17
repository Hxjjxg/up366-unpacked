package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PictureVideoGridView extends android.view.ViewGroup {
    private android.view.View.OnClickListener addListener;
    private int aspectX;
    private int aspectY;
    private android.content.Context context;
    private int dividerHeight;
    private volatile boolean editMode;
    private final java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems;
    private boolean isAddModel;
    private boolean isAttachSubView;
    private boolean isSupportAddPicture;
    private boolean isSupportAddVideo;
    private boolean isSupportZoom;
    private com.up366.multimedia.listener.OnPicVideoItemClickListener itemClickListener;
    private int maxCount;
    private int[] onePicture;
    private int outputX;
    private int outputY;
    private int videoMaxDuration;
    private int videoMaxSize;
    private boolean videoPictureSameExist;
    private java.lang.String viewUuid;
    private android.util.LruCache<java.lang.String, int[]> whMap;

    public interface OnItemClickListener {
        void onItemClick(int position, com.flyco.dialog.widget.ActionSheetDialog dialog);
    }

    public PictureVideoGridView(android.content.Context context) {
        super(context);
        this.imageItems = new java.util.ArrayList<>();
        this.viewUuid = "viewUuid";
        this.isAddModel = false;
        this.isAttachSubView = false;
        this.onePicture = null;
        this.dividerHeight = 0;
        this.isSupportZoom = false;
        this.isSupportAddVideo = false;
        this.isSupportAddPicture = false;
        this.aspectX = 3;
        this.aspectY = 4;
        this.outputX = 1024;
        this.outputY = 1365;
        this.videoMaxSize = 1;
        this.videoMaxDuration = 1;
        this.videoPictureSameExist = false;
        this.whMap = new android.util.LruCache<>(100);
        init(context, null);
    }

    public PictureVideoGridView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        this.imageItems = new java.util.ArrayList<>();
        this.viewUuid = "viewUuid";
        this.isAddModel = false;
        this.isAttachSubView = false;
        this.onePicture = null;
        this.dividerHeight = 0;
        this.isSupportZoom = false;
        this.isSupportAddVideo = false;
        this.isSupportAddPicture = false;
        this.aspectX = 3;
        this.aspectY = 4;
        this.outputX = 1024;
        this.outputY = 1365;
        this.videoMaxSize = 1;
        this.videoMaxDuration = 1;
        this.videoPictureSameExist = false;
        this.whMap = new android.util.LruCache<>(100);
        init(context, attrs);
    }

    public PictureVideoGridView(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.imageItems = new java.util.ArrayList<>();
        this.viewUuid = "viewUuid";
        this.isAddModel = false;
        this.isAttachSubView = false;
        this.onePicture = null;
        this.dividerHeight = 0;
        this.isSupportZoom = false;
        this.isSupportAddVideo = false;
        this.isSupportAddPicture = false;
        this.aspectX = 3;
        this.aspectY = 4;
        this.outputX = 1024;
        this.outputY = 1365;
        this.videoMaxSize = 1;
        this.videoMaxDuration = 1;
        this.videoPictureSameExist = false;
        this.whMap = new android.util.LruCache<>(100);
        init(context, attrs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.multimedia.util.GlobalClickHelper.getInst().addGlobalClickOnAttached(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
        com.up366.multimedia.util.GlobalClickHelper.getInst().removeListenerOnDetached(this);
    }

    private void init(final android.content.Context context, android.util.AttributeSet attrs) {
        this.context = context;
        this.viewUuid = java.util.UUID.randomUUID().toString();
        if (attrs != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, com.afollestad.materialcamera.R.styleable.PictureVideoGridView);
            this.dividerHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_dividerHeight, com.up366.common.DpUtilsUp.dp2px(2.0f));
            this.maxCount = typedArrayObtainStyledAttributes.getInt(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_maxCount, 9);
            this.isSupportZoom = typedArrayObtainStyledAttributes.getBoolean(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_isSupportZoom, false);
            this.isSupportAddVideo = typedArrayObtainStyledAttributes.getBoolean(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_isSupportAddVideo, false);
            this.videoMaxSize = typedArrayObtainStyledAttributes.getInt(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_videoMaxSize, this.maxCount);
            this.videoMaxDuration = typedArrayObtainStyledAttributes.getInt(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_videoMaxDuration, 180);
            this.videoPictureSameExist = typedArrayObtainStyledAttributes.getBoolean(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_videoPictureSameExist, false);
            this.isSupportAddPicture = typedArrayObtainStyledAttributes.getBoolean(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_isSupportAddPicture, false);
            this.aspectX = typedArrayObtainStyledAttributes.getInt(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_aspectX, 3);
            this.aspectY = typedArrayObtainStyledAttributes.getInt(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_aspectY, 4);
            this.outputX = typedArrayObtainStyledAttributes.getInt(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_outputX, 1024);
            this.outputY = typedArrayObtainStyledAttributes.getInt(com.afollestad.materialcamera.R.styleable.PictureVideoGridView_outputY, 1365);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.isAddModel = this.isSupportAddPicture || this.isSupportZoom || this.isSupportAddVideo;
        this.editMode = true;
        setDatas(new java.util.ArrayList<>());
        this.addListener = com.up366.multimedia.views.AddListenerHelper.getInst().initDefaultAddClickListener(this.isSupportAddVideo, this.isSupportZoom, this.videoMaxDuration);
        setItemClickListener(new com.up366.multimedia.listener.OnPicVideoItemClickListener() { // from class: com.up366.multimedia.views.PictureVideoGridView.1
            @Override // com.up366.multimedia.listener.OnPicVideoItemClickListener
            public void onItemClick(android.view.View view, com.up366.multimedia.model.PictureVideo video, int position, boolean editMode) {
                com.up366.multimedia.util.MediaHelper.getInstance().handleItemClick(com.up366.multimedia.views.PictureVideoGridView.this, view, video);
            }

            @Override // com.up366.multimedia.listener.OnPicVideoItemClickListener
            public void onDeleteItem(android.view.View view, com.up366.multimedia.model.PictureVideo video, int position) {
                com.up366.multimedia.util.MediaHelper.getInstance().deleteItem(com.up366.multimedia.views.PictureVideoGridView.this, position);
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        if (this.isAddModel) {
            editOnMeasure(widthSpec);
        } else {
            measure(widthSpec);
        }
    }

    private void editOnMeasure(int widthSpec) {
        int size = android.view.View.MeasureSpec.getSize(widthSpec);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i = (paddingLeft - (this.dividerHeight * 2)) / 3;
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).measure(iMakeMeasureSpec, iMakeMeasureSpec);
        }
        if (childCount == 1) {
            size = iMakeMeasureSpec;
        } else if (childCount == 2) {
            size = this.dividerHeight + (iMakeMeasureSpec * 2);
        }
        int i3 = (childCount - 1) / 3;
        setMeasuredDimension(size, (i * (i3 + 1)) + (this.dividerHeight * i3));
    }

    private void measure(int widthSpec) {
        int[] iArr;
        int size = android.view.View.MeasureSpec.getSize(widthSpec);
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int i = (size - paddingLeft) - paddingRight;
        int clumnSize = getClumnSize(getChildCount());
        if (clumnSize == 0) {
            setMeasuredDimension(widthSpec, paddingTop + paddingBottom);
            return;
        }
        int i2 = (i - (this.dividerHeight * clumnSize)) / clumnSize;
        int childCount = (getChildCount() - 1) / clumnSize;
        int i3 = ((childCount + 1) * i2) + (this.dividerHeight * childCount);
        if (clumnSize == 1 && (iArr = this.onePicture) != null) {
            int i4 = (int) ((i * 2.0f) / 3.0f);
            int i5 = iArr[0];
            int i6 = iArr[1];
            if (i5 > i6) {
                i3 = (int) (((i6 * 1.0f) * i4) / i5);
                size = i4;
            } else {
                size = (int) (((i5 * 1.0f) * i4) / i6);
                i3 = i4;
            }
            getChildAt(0).measure(android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.medialibrary.common.utils.PictureFileUtils.GB), android.view.View.MeasureSpec.makeMeasureSpec(i3, com.up366.medialibrary.common.utils.PictureFileUtils.GB));
        } else {
            int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i2, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                getChildAt(i7).measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
        }
        setMeasuredDimension(size, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (this.isAddModel) {
            editOnLayout();
        } else {
            layout();
        }
    }

    private void layout() {
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int childCount = getChildCount();
        int clumnSize = getClumnSize(childCount);
        int i = 0;
        if (childCount == 1) {
            int[] iArr = this.onePicture;
            if (iArr[1] > iArr[0]) {
                width = getHeight() - paddingTop;
            }
            getChildAt(0).layout(paddingLeft, paddingTop, paddingLeft + width, width + paddingTop);
            return;
        }
        int i2 = (width - ((clumnSize - 1) * this.dividerHeight)) / clumnSize;
        int i3 = paddingLeft + i2;
        int i4 = paddingTop + i2;
        if (childCount == 4) {
            clumnSize = 2;
        }
        while (true) {
            int i5 = paddingLeft;
            int i6 = i3;
            while (i < childCount) {
                getChildAt(i).layout(i5, paddingTop, i6, i4);
                i++;
                if (i % clumnSize == 0) {
                    break;
                }
                i5 = i5 + this.dividerHeight + i2;
                i6 = i5 + i2;
            }
            return;
            paddingTop = (i / clumnSize) * (this.dividerHeight + i2);
            i4 = paddingTop + i2;
        }
    }

    private void editOnLayout() {
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int childCount = getChildCount();
        if (childCount >= 3) {
            childCount = 3;
        }
        int i = (width - ((childCount - 1) * this.dividerHeight)) / childCount;
        int i2 = paddingLeft + i;
        int i3 = paddingTop + i;
        int i4 = 0;
        while (true) {
            int i5 = i2;
            int i6 = paddingLeft;
            while (i4 < getChildCount()) {
                getChildAt(i4).layout(i6, paddingTop, i5, i3);
                i4++;
                if (i4 % 3 == 0) {
                    break;
                }
                i6 = i6 + this.dividerHeight + i;
                i5 = i6 + i;
            }
            return;
            paddingTop = (i4 / 3) * (this.dividerHeight + i);
            i3 = paddingTop + i;
        }
    }

    private int getClumnSize(int childCount) {
        return (!this.isAddModel && childCount == 1) ? 1 : 3;
    }

    public int getCurrentPattern() {
        if (this.videoPictureSameExist || this.imageItems.size() == 0) {
            return 0;
        }
        return com.up366.common.StringUtils.isEmptyOrNull(this.imageItems.get(0).videoPath) ? 1 : 2;
    }

    public void setDatas(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems) {
        this.imageItems.clear();
        this.imageItems.addAll(imageItems == null ? java.util.Collections.emptyList() : imageItems);
        java.util.List<com.up366.multimedia.model.PictureVideo> listConvertImageItemToPicture = convertImageItemToPicture(imageItems);
        if (this.isAddModel) {
            listConvertImageItemToPicture.add(new com.up366.multimedia.model.PictureVideo(0, "", "", null));
        }
        int iMin = java.lang.Math.min(listConvertImageItemToPicture.size(), getMaxCountWithVideoAndPicture());
        removeAllViews();
        for (int i = 0; i < iMin; i++) {
            com.up366.multimedia.views.PictrureVideoItemView pictrureVideoItemView = new com.up366.multimedia.views.PictrureVideoItemView(this.context);
            boolean z = true;
            if (iMin == 1) {
                this.onePicture = getImageWidthHeight(listConvertImageItemToPicture.get(i).getUrl());
                pictrureVideoItemView.setModelAndSize(this.isAddModel, 1);
            }
            pictrureVideoItemView.setData(listConvertImageItemToPicture.get(i));
            pictrureVideoItemView.setItemClickListener(this.itemClickListener);
            if (listConvertImageItemToPicture.get(i).type == 0 || !this.isAddModel) {
                z = false;
            }
            pictrureVideoItemView.setEditMode(z);
            pictrureVideoItemView.setPosition(i);
            addView(pictrureVideoItemView);
        }
    }

    private java.util.List<com.up366.multimedia.model.PictureVideo> convertImageItemToPicture(java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() != 0) {
            for (com.up366.multimedia.util.AlbumHelper.ImageItem imageItem : list) {
                if (!com.up366.common.StringUtils.isEmptyOrNull(imageItem.videoPath)) {
                    arrayList.add(new com.up366.multimedia.model.PictureVideo(2, imageItem.videoPath, imageItem.imagePath, imageItem.uri));
                } else {
                    arrayList.add(new com.up366.multimedia.model.PictureVideo(1, imageItem.imagePath, imageItem.imagePath, imageItem.uri));
                }
            }
        }
        return arrayList;
    }

    private int[] getImageWidthHeight(java.lang.String path) {
        if (com.up366.common.StringUtils.isEmptyOrNull(path)) {
            return new int[]{50, 50};
        }
        if (this.whMap.get(path) != null) {
            return this.whMap.get(path);
        }
        if (path.startsWith("http")) {
            getNetImageWidthHeight(path);
            return new int[]{100, 100};
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(path, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    private void getNetImageWidthHeight(final java.lang.String path) {
        com.bumptech.glide.Glide.with(com.up366.common.global.GB.get().getApplicationContext()).asBitmap().load(path).into(new com.bumptech.glide.request.target.SimpleTarget<android.graphics.Bitmap>() { // from class: com.up366.multimedia.views.PictureVideoGridView.2
            public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object resource, com.bumptech.glide.request.transition.Transition transition) {
                onResourceReady((android.graphics.Bitmap) resource, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
            }

            public void onResourceReady(android.graphics.Bitmap resource, com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
                com.up366.multimedia.views.PictureVideoGridView.this.whMap.put(path, new int[]{resource.getWidth(), resource.getHeight()});
                if (com.up366.multimedia.views.PictureVideoGridView.this.isAddModel) {
                    return;
                }
                for (com.up366.multimedia.util.AlbumHelper.ImageItem imageItem : com.up366.multimedia.views.PictureVideoGridView.this.imageItems) {
                    if (!com.up366.multimedia.views.PictureVideoGridView.this.isAttachSubView && (path.equals(imageItem.imagePath) || path.equals(imageItem.videoPath))) {
                        return;
                    }
                }
                com.up366.multimedia.views.PictureVideoGridView.this.setDatas(new java.util.ArrayList<>(com.up366.multimedia.views.PictureVideoGridView.this.imageItems));
            }
        });
    }

    private int getMaxCountWithVideoAndPicture() {
        if (2 == getCurrentPattern()) {
            return this.videoMaxSize;
        }
        return this.maxCount;
    }

    public java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> getDatas() {
        return new java.util.ArrayList<>(this.imageItems);
    }

    public void setItemClickListener(com.up366.multimedia.listener.OnPicVideoItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        for (int i = 0; i < getChildCount(); i++) {
            ((com.up366.multimedia.views.PictrureVideoItemView) getChildAt(i)).setItemClickListener(this.itemClickListener);
        }
    }

    public void setEditMode(boolean editMode) {
        if (this.editMode == editMode) {
            return;
        }
        this.editMode = editMode;
        setDatas(new java.util.ArrayList<>(this.imageItems));
    }

    public void delete(int position) {
        this.imageItems.remove(position);
        if (this.imageItems.size() == 0) {
            this.editMode = false;
        }
        setDatas(new java.util.ArrayList<>(this.imageItems));
    }

    public void clear() {
        setDatas(new java.util.ArrayList<>());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.PictureLoadEvent event) {
        if (this.viewUuid.equals(event.getViewId())) {
            setDatas(event.getImageItems());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.PictureDeleteUpdateEvent event) {
        if (this.viewUuid.equals(event.getViewId())) {
            setDatas(event.getImageItems());
        }
    }

    public android.view.View.OnClickListener getAddListener() {
        return this.addListener;
    }

    public void setAddListener(android.view.View.OnClickListener addListener) {
        this.addListener = addListener;
    }

    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        com.up366.multimedia.views.PictureVideoGridView pictureVideoGridView = (com.up366.multimedia.views.PictureVideoGridView) o;
        if (this.viewUuid == null) {
            this.viewUuid = java.util.UUID.randomUUID().toString();
        }
        return this.viewUuid.equals(pictureVideoGridView.viewUuid);
    }

    public int hashCode() {
        if (this.viewUuid == null) {
            this.viewUuid = java.util.UUID.randomUUID().toString();
        }
        return this.viewUuid.hashCode();
    }

    public int getVideoMaxDuration() {
        return this.videoMaxDuration;
    }

    public void setVideoMaxDuration(int videoMaxDuration) {
        this.videoMaxDuration = videoMaxDuration;
    }

    public boolean isAddModel() {
        return this.isAddModel;
    }

    public void setAddModel(boolean addModel) {
        this.isAddModel = addModel;
    }

    public boolean isSupportZoom() {
        return this.isSupportZoom;
    }

    public void setSupportZoom(boolean supportZoom) {
        this.isSupportZoom = supportZoom;
    }

    public java.lang.String getViewUuid() {
        return this.viewUuid;
    }

    public int getAspectX() {
        return this.aspectX;
    }

    public void setAspectX(int aspectX) {
        this.aspectX = aspectX;
    }

    public int getAspectY() {
        return this.aspectY;
    }

    public void setAspectY(int aspectY) {
        this.aspectY = aspectY;
    }

    public int getOutputX() {
        return this.outputX;
    }

    public void setOutputX(int outputX) {
        this.outputX = outputX;
    }

    public int getOutputY() {
        return this.outputY;
    }

    public void setOutputY(int outputY) {
        this.outputY = outputY;
    }

    public boolean isSupportAddVideo() {
        return this.isSupportAddVideo;
    }

    public void setSupportAddVideo(boolean supportAddVideo) {
        this.isSupportAddVideo = supportAddVideo;
    }

    public boolean isSupportAddPicture() {
        return this.isSupportAddPicture;
    }

    public void setSupportAddPicture(boolean supportAddPicture) {
        this.isSupportAddPicture = supportAddPicture;
    }

    public int getVideoMaxSize() {
        return this.videoMaxSize;
    }

    public void setVideoMaxSize(int videoMaxSize) {
        this.videoMaxSize = videoMaxSize;
    }

    public int getDividerHeight() {
        return this.dividerHeight;
    }

    public void setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public boolean isVideoPictureSameExist() {
        return this.videoPictureSameExist;
    }

    public void setAttachSubView(boolean attachSubView) {
        this.isAttachSubView = attachSubView;
    }

    public void setVideoPictureSameExist(boolean videoPictureSameExist) {
        this.videoPictureSameExist = videoPictureSameExist;
    }

    public void setCustomItemListener(final com.up366.multimedia.views.PictureVideoGridView.OnItemClickListener itemClickListener) {
        setAddListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.views.PictureVideoGridView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1335x9cef5f0e(itemClickListener, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setCustomItemListener$1$com-up366-multimedia-views-PictureVideoGridView, reason: not valid java name */
    /* synthetic */ void m1335x9cef5f0e(final com.up366.multimedia.views.PictureVideoGridView.OnItemClickListener onItemClickListener, android.view.View view) {
        com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().setTakePhotoSupportZoom(this.isSupportZoom);
        java.lang.String[] strArr = {"拍照", "相册选取"};
        if (this.isSupportAddVideo) {
            strArr = new java.lang.String[]{"拍照", "相册选取", "录视频"};
        }
        final com.flyco.dialog.widget.ActionSheetDialog actionSheetDialog = new com.flyco.dialog.widget.ActionSheetDialog(com.up366.common.global.GB.get().getCurrentActivity(), strArr, (android.view.View) null);
        actionSheetDialog.title("请选择方式");
        actionSheetDialog.titleTextSize_SP(13.0f);
        actionSheetDialog.setOnOperItemClickL(new com.flyco.dialog.listener.OnOperItemClickL() { // from class: com.up366.multimedia.views.PictureVideoGridView$$ExternalSyntheticLambda0
            public final void onOperItemClick(android.widget.AdapterView adapterView, android.view.View view2, int i, long j) {
                onItemClickListener.onItemClick(i, actionSheetDialog);
            }
        });
        actionSheetDialog.show();
    }
}
