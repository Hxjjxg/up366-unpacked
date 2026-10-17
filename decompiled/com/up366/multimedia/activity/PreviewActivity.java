package com.up366.multimedia.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PreviewActivity extends android.app.Activity implements android.view.View.OnClickListener {
    public static final java.lang.String INTENT_CUR_PICTURE_VIDEO = "cur";
    public static final java.lang.String INTENT_IMAGE_ITEMS = "images";
    public static final java.lang.String INTENT_IS_ADD_MODEL = "isAddModel";
    public static final java.lang.String INTENT_IS_LIGHT_MODEL = "isLightModel";
    public static final java.lang.String INTENT_SHOW_INDEX = "show_image_index";
    public static final java.lang.String INTENT_VIEW_ID = "viewId";
    private com.up366.multimedia.model.PictureVideo cur;
    private java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems;
    private android.widget.TextView pageView;
    private android.widget.TextView pageViewBlack;
    private com.up366.multimedia.activity.PreviewAdpter previewAdpter;
    private android.view.View previewDeleteBtn;
    private java.lang.String viewId;
    private androidx.viewpager.widget.ViewPager viewPager;
    private int curPageIndex = 0;
    private boolean lightModel = true;
    private boolean showIndex = true;
    private final androidx.viewpager.widget.ViewPager.OnPageChangeListener listener = new androidx.viewpager.widget.ViewPager.OnPageChangeListener() { // from class: com.up366.multimedia.activity.PreviewActivity.1
        public void onPageScrollStateChanged(int state) {
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        public void onPageSelected(int position) {
            com.up366.multimedia.activity.PreviewActivity.this.curPageIndex = position;
            com.up366.multimedia.activity.PreviewActivity.this.pageView.setText(com.up366.multimedia.activity.PreviewActivity.this.getPageText());
            com.up366.multimedia.activity.PreviewActivity.this.pageViewBlack.setText(com.up366.multimedia.activity.PreviewActivity.this.getPageText());
        }
    };

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean booleanExtra = getIntent().getBooleanExtra(INTENT_IS_LIGHT_MODEL, true);
        this.lightModel = booleanExtra;
        if (!booleanExtra) {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
        }
        setContentView(com.afollestad.materialcamera.R.layout.media_preview_activity);
        this.imageItems = getIntent().getParcelableArrayListExtra(INTENT_IMAGE_ITEMS);
        this.viewId = getIntent().getStringExtra(INTENT_VIEW_ID);
        this.showIndex = getIntent().getBooleanExtra(INTENT_SHOW_INDEX, true);
        boolean booleanExtra2 = getIntent().getBooleanExtra(INTENT_IS_ADD_MODEL, false);
        if (this.imageItems == null) {
            this.imageItems = new java.util.ArrayList();
        }
        this.cur = (com.up366.multimedia.model.PictureVideo) getIntent().getParcelableExtra(INTENT_CUR_PICTURE_VIDEO);
        initPageIndex();
        this.previewDeleteBtn = findViewById(com.afollestad.materialcamera.R.id.preview_delete_btn);
        this.viewPager = findViewById(com.afollestad.materialcamera.R.id.preview_viewpager);
        this.pageView = (android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.preview_pages);
        this.pageViewBlack = (android.widget.TextView) findViewById(com.afollestad.materialcamera.R.id.preview_pages_black);
        com.up366.multimedia.activity.PreviewAdpter previewAdpter = new com.up366.multimedia.activity.PreviewAdpter(this);
        this.previewAdpter = previewAdpter;
        previewAdpter.setDatas(this.imageItems);
        this.viewPager.setAdapter(this.previewAdpter);
        this.viewPager.addOnPageChangeListener(this.listener);
        this.viewPager.setCurrentItem(this.curPageIndex, true);
        this.pageView.setText(getPageText());
        this.pageViewBlack.setText(getPageText());
        this.previewDeleteBtn.setVisibility(booleanExtra2 ? 0 : 4);
        this.pageView.setOnClickListener(this);
        this.previewDeleteBtn.setOnClickListener(this);
        if (this.lightModel) {
            return;
        }
        findViewById(com.afollestad.materialcamera.R.id.headview).setVisibility(8);
        findViewById(com.afollestad.materialcamera.R.id.headview_black).setVisibility(0);
        findViewById(com.afollestad.materialcamera.R.id.iv_back_black).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.PreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1328lambda$onCreate$0$comup366multimediaactivityPreviewActivity(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-up366-multimedia-activity-PreviewActivity, reason: not valid java name */
    /* synthetic */ void m1328lambda$onCreate$0$comup366multimediaactivityPreviewActivity(android.view.View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getPageText() {
        if (this.showIndex) {
            return (this.curPageIndex + 1) + "/" + this.imageItems.size();
        }
        return "";
    }

    private void initPageIndex() {
        if (this.cur == null) {
            return;
        }
        int i = 0;
        while (i < this.imageItems.size()) {
            com.up366.multimedia.util.AlbumHelper.ImageItem imageItem = this.imageItems.get(i);
            if (this.cur.url.equals(imageItem.imagePath) || this.cur.url.equals(imageItem.videoPath)) {
                break;
            } else {
                i++;
            }
        }
        this.curPageIndex = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (com.afollestad.materialcamera.R.id.preview_pages == view.getId()) {
            finish();
            return;
        }
        if (com.afollestad.materialcamera.R.id.preview_delete_btn == view.getId()) {
            try {
                if (this.imageItems.size() != 0) {
                    this.imageItems.remove(this.curPageIndex);
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.PictureDeleteUpdateEvent((java.util.ArrayList) this.imageItems, this.viewId));
            } catch (java.lang.Exception unused) {
                com.up366.common.log.Logger.error("onClick remove error" + this.curPageIndex);
            }
            if (this.imageItems.size() == 0) {
                finish();
                return;
            }
            this.previewAdpter.deleteItem(this.curPageIndex);
            this.pageView.setText(getPageText());
            this.pageViewBlack.setText(getPageText());
        }
    }
}
