package com.up366.multimedia.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AlbumActivity extends android.app.Activity implements com.up366.multimedia.listener.OnDataUpdateListener, android.view.View.OnClickListener {
    private com.up366.multimedia.activity.AlbumAdapter albumAdapter;
    private android.view.View albumBack;
    private android.widget.TextView albumSelect;
    private android.widget.TextView finishButton;
    private java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems;
    private android.widget.TextView mediaAlbumTitleTv;
    private androidx.recyclerview.widget.RecyclerView myGrid;
    private android.widget.TextView previewView;
    private java.lang.String viewId = com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID;
    private int maxSize = 9;
    private int albumType = 0;
    private java.lang.String imageType = "";
    private int bucketSelectPostion = 0;
    private com.up366.multimedia.dialog.TopPopupDialog dialog = null;

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.afollestad.materialcamera.R.layout.media_album_activity);
        if (getIntent() != null) {
            this.albumType = getIntent().getIntExtra(com.up366.multimedia.util.AlbumHelper.INTENT_KEY_ALBUM_TYPE, 1);
            this.imageType = getIntent().getStringExtra(com.up366.multimedia.util.AlbumHelper.INTENT_KEY_ALBUM_IMAGE_TYPE);
        }
        this.myGrid = findViewById(com.afollestad.materialcamera.R.id.myGrid);
        this.finishButton = (android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.album_finish_button);
        this.previewView = (android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.album_preview);
        this.albumSelect = (android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.album_select);
        this.mediaAlbumTitleTv = (android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.media_album_title_tv);
        this.albumBack = findViewById(com.afollestad.materialcamera.R.id.album_back);
        this.finishButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.AlbumActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1324lambda$onCreate$0$comup366multimediaactivityAlbumActivity(view);
            }
        });
        this.albumSelect.setOnClickListener(this);
        this.previewView.setOnClickListener(this);
        this.albumBack.setOnClickListener(this);
        initData();
        handleBtnByMaxSize();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-up366-multimedia-activity-AlbumActivity, reason: not valid java name */
    /* synthetic */ void m1324lambda$onCreate$0$comup366multimediaactivityAlbumActivity(android.view.View view) {
        this.finishButton.setEnabled(false);
        com.up366.multimedia.util.MediaHelper.getInstance().onAlbumSelected(new com.up366.multimedia.event.PictureLoadEvent(this.imageItems, this.viewId), this.maxSize);
        setResult(-1);
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.up366.multimedia.activity.AlbumAdapter albumAdapter = this.albumAdapter;
        if (albumAdapter != null) {
            albumAdapter.setDatas(convertToDataHolder(com.up366.multimedia.util.AlbumHelper.getHelper().getImageList(this, this.albumType, this.imageType)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> convertToDataHolder(java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> datas) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (datas.size() == 0) {
            arrayList.add(new com.up366.multimedia.base.BaseAdapter.DataHolder(3));
        } else {
            java.util.Iterator<com.up366.multimedia.util.AlbumHelper.ImageItem> it = datas.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.up366.multimedia.base.BaseAdapter.DataHolder(1, it.next()));
            }
        }
        return arrayList;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    private void initData() {
        this.imageItems = getIntent().getParcelableArrayListExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IMAGE_ITEMS);
        this.viewId = getIntent().getStringExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID);
        this.maxSize = getIntent().getIntExtra("maxSize", 9);
        if (com.up366.common.StringUtils.isEmptyOrNull(this.viewId)) {
            this.viewId = com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID;
        }
        if (this.imageItems == null) {
            this.imageItems = new java.util.ArrayList<>();
        }
        java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> imageList = com.up366.multimedia.util.AlbumHelper.getHelper().getImageList(this, this.albumType, this.imageType);
        this.myGrid.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(this, 4));
        com.up366.multimedia.activity.AlbumAdapter albumAdapter = new com.up366.multimedia.activity.AlbumAdapter();
        this.albumAdapter = albumAdapter;
        albumAdapter.setMaxSize(this.maxSize);
        this.albumAdapter.setListener(this);
        this.albumAdapter.setSelectItems(this.imageItems);
        showFinishView();
        showPreviewView();
        this.myGrid.setAdapter(this.albumAdapter);
        this.myGrid.addItemDecoration(new com.up366.multimedia.base.CommonDivider(4).height(com.up366.common.DpUtilsUp.dp2px(3.0f)));
        this.albumAdapter.setDatas(convertToDataHolder(imageList));
    }

    private void handleBtnByMaxSize() {
        if (this.maxSize == 1) {
            findViewById(com.afollestad.materialcamera.R.id.bottom_layout).setVisibility(8);
        }
    }

    @Override // com.up366.multimedia.listener.OnDataUpdateListener
    public void onSelectedUpdate(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems) {
        if (this.maxSize == 1) {
            com.up366.multimedia.util.MediaHelper.getInstance().onAlbumSelected(new com.up366.multimedia.event.PictureLoadEvent(this.imageItems, this.viewId), this.maxSize);
            setResult(-1);
            finish();
            return;
        }
        updateActivityImageItemsState(imageItems);
    }

    private void updateActivityImageItemsState(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems) {
        this.imageItems = imageItems;
        showFinishView();
        showPreviewView();
    }

    private void showPreviewView() {
        android.content.res.Resources resources;
        int i;
        int size = this.imageItems.size();
        android.widget.TextView textView = this.previewView;
        if (size == 0) {
            resources = getResources();
            i = com.afollestad.materialcamera.R.color.media_gray;
        } else {
            resources = getResources();
            i = com.afollestad.materialcamera.R.color.media_blue;
        }
        textView.setTextColor(resources.getColor(i));
    }

    private void showFinishView() {
        java.lang.String str;
        int size = this.imageItems.size();
        android.widget.TextView textView = this.finishButton;
        if (size == 0) {
            str = "完成";
        } else {
            str = "完成（" + size + "）";
        }
        textView.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (com.afollestad.materialcamera.R.id.album_back == id) {
            finish();
            return;
        }
        if (com.afollestad.materialcamera.R.id.album_select == id) {
            handleSelect();
            return;
        }
        if (com.afollestad.materialcamera.R.id.album_preview != id || this.imageItems.size() == 0) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.up366.multimedia.activity.PreviewActivity.class);
        intent.putParcelableArrayListExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IMAGE_ITEMS, this.imageItems);
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IS_ADD_MODEL, true);
        startActivity(intent);
    }

    private void handleSelect() {
        if (this.dialog == null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(com.up366.multimedia.util.AlbumHelper.getHelper().getImageBuckets(this, this.albumType));
            com.up366.multimedia.dialog.TopPopupDialog topPopupDialog = (com.up366.multimedia.dialog.TopPopupDialog) new com.up366.multimedia.dialog.TopPopupDialog(this, arrayList).dimEnabled(false);
            this.dialog = topPopupDialog;
            topPopupDialog.setShowStateUpdateListener(new com.up366.multimedia.dialog.TopPopupDialog.OnShowStateUpdateListener() { // from class: com.up366.multimedia.activity.AlbumActivity.1
                @Override // com.up366.multimedia.dialog.TopPopupDialog.OnShowStateUpdateListener
                public void onShowStateChanged(boolean isShow) {
                    com.up366.multimedia.activity.AlbumActivity.this.albumBack.setVisibility(isShow ? 4 : 0);
                    com.up366.multimedia.activity.AlbumActivity.this.mediaAlbumTitleTv.setText(isShow ? com.afollestad.materialcamera.R.string.select_album : com.afollestad.materialcamera.R.string.album_select_pic);
                    android.graphics.drawable.Drawable drawable = com.up366.multimedia.activity.AlbumActivity.this.getResources().getDrawable(isShow ? com.afollestad.materialcamera.R.drawable.push_up_pic : com.afollestad.materialcamera.R.drawable.drop_down_pic);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    com.up366.multimedia.activity.AlbumActivity.this.albumSelect.setCompoundDrawables(drawable, null, null, null);
                }
            });
            this.dialog.setOnOperItemClickL(new com.flyco.dialog.listener.OnOperItemClickL() { // from class: com.up366.multimedia.activity.AlbumActivity.2
                public void onOperItemClick(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                    com.up366.multimedia.dialog.TopPopupAdapter topPopupAdapter = (com.up366.multimedia.dialog.TopPopupAdapter) parent.getAdapter();
                    com.up366.multimedia.activity.AlbumActivity.this.bucketSelectPostion = position;
                    com.up366.multimedia.util.AlbumHelper.ImageBucket imageBucket = topPopupAdapter.getDatas().get(position);
                    com.up366.multimedia.activity.AlbumActivity.this.albumAdapter.setDatas(com.up366.multimedia.activity.AlbumActivity.this.convertToDataHolder(imageBucket.imageList));
                    com.up366.multimedia.activity.AlbumActivity.this.albumSelect.setText(java.lang.String.valueOf(imageBucket.bucketName));
                    com.up366.multimedia.activity.AlbumActivity.this.dialog.dismiss();
                }
            });
        }
        this.dialog.setSelectedPostion(this.bucketSelectPostion);
        this.dialog.show();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.PictureDeleteUpdateEvent event) {
        updateActivityImageItemsState(event.getImageItems());
        this.albumAdapter.setSelectItems(this.imageItems);
    }
}
