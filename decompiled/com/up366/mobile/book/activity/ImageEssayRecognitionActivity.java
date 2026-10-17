package com.up366.mobile.book.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImageEssayRecognitionActivity extends com.up366.mobile.common.base.BaseActivity implements android.view.View.OnClickListener {
    public static final java.lang.String INTENT_IMAGE_NET_URL = "image_net_url";
    private static final java.lang.String INTENT_IMAGE_PATH = "image_path";
    public static final java.lang.String INTENT_OCR_TID = "cor_tid";
    public static final java.lang.String INTENT_RECOGNITION_RESULT = "recognition_result";
    private static final java.lang.String INTENT_SKIP_CONFIRM = "skipConfirm";
    public static final int RESULT_CODE_TO_CAMERA = 100;
    private android.widget.Button btRecognitionLow;
    private android.widget.ImageButton ibAfterRecognitionBack;
    private android.widget.ImageButton ibBeforeRecognitionBack;
    private android.widget.ImageButton ibRecognitionOk;
    private java.lang.String imageNetUrl;
    private java.lang.String imagePath;
    private pl.droidsonroids.gif.GifImageView ivRecognitionDoing;
    private android.widget.ImageView ivRecognitionImage;
    private java.lang.String ocrTid;
    private com.up366.mobile.book.helper.ImageEssayRecognitionHelper recognitionHelper;
    private java.lang.String recognitionResult;
    private android.widget.RelativeLayout rlResultLayout;
    private int skipConfirm;
    private android.widget.TextView tvRecognitionToast;
    private android.widget.TextView tvResult;

    public static void startEssayRecognitionActivityForResult(android.app.Activity activity, int i, java.lang.String str, int i2) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.activity.ImageEssayRecognitionActivity.class);
        intent.putExtra(INTENT_IMAGE_PATH, str);
        intent.putExtra(INTENT_SKIP_CONFIRM, i2);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.up366.mobile.R.layout.activity_image_essay_recognition);
        initView();
        initData();
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.mobile.book.helper.ImageEssayRecognitionHelper imageEssayRecognitionHelper = new com.up366.mobile.book.helper.ImageEssayRecognitionHelper(this.imagePath);
        this.recognitionHelper = imageEssayRecognitionHelper;
        imageEssayRecognitionHelper.start();
    }

    private void initData() {
        this.imagePath = getIntent().getStringExtra(INTENT_IMAGE_PATH);
        this.skipConfirm = getIntent().getIntExtra(INTENT_SKIP_CONFIRM, 0);
        com.bumptech.glide.Glide.with(this).load(this.imagePath).apply(com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf(true)).apply(com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE)).into(this.ivRecognitionImage);
    }

    private void initView() {
        this.ivRecognitionImage = (android.widget.ImageView) findViewById(com.up366.mobile.R.id.iv_recognition_image);
        android.widget.ImageButton imageButton = (android.widget.ImageButton) findViewById(com.up366.mobile.R.id.ib_before_recognition_back);
        this.ibBeforeRecognitionBack = imageButton;
        imageButton.setOnClickListener(this);
        android.widget.ImageButton imageButton2 = (android.widget.ImageButton) findViewById(com.up366.mobile.R.id.ib_confirm_recognition_result);
        this.ibRecognitionOk = imageButton2;
        imageButton2.setOnClickListener(this);
        this.ivRecognitionDoing = findViewById(com.up366.mobile.R.id.iv_recognition_doing);
        this.rlResultLayout = (android.widget.RelativeLayout) findViewById(com.up366.mobile.R.id.rl_recognition_result);
        android.widget.ImageButton imageButton3 = (android.widget.ImageButton) findViewById(com.up366.mobile.R.id.ib_after_recognition_back);
        this.ibAfterRecognitionBack = imageButton3;
        imageButton3.setOnClickListener(this);
        this.tvResult = (android.widget.TextView) findViewById(com.up366.mobile.R.id.tv_recognition_result);
        android.widget.Button button = (android.widget.Button) findViewById(com.up366.mobile.R.id.bt_recognition_low);
        this.btRecognitionLow = button;
        button.setOnClickListener(this);
        this.tvRecognitionToast = (android.widget.TextView) findViewById(com.up366.mobile.R.id.tv_recognition_toast);
        this.tvRecognitionToast.setBackground(com.up366.mobile.common.utils.ShapeDrawableUtils.createShapeDrawable(4, "#B3000000"));
        showViewByRecognition(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        switch (view.getId()) {
            case com.up366.mobile.R.id.bt_recognition_low /* 2131361995 */:
                startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.book.activity.PhotoGraphRecognitionSkillActivity.class));
                break;
            case com.up366.mobile.R.id.ib_after_recognition_back /* 2131362544 */:
            case com.up366.mobile.R.id.ib_before_recognition_back /* 2131362546 */:
                setResult(0);
                finish();
                break;
            case com.up366.mobile.R.id.ib_confirm_recognition_result /* 2131362549 */:
                recognitionOver();
                break;
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.ImageEssayRecognitionEvent imageEssayRecognitionEvent) {
        int code = imageEssayRecognitionEvent.getCode();
        if (code == -123456) {
            showRecognitionErrorDialog();
            return;
        }
        if (code == -1) {
            showNetErrorDialog();
        } else if (code == 0) {
            recognitionSuccess(imageEssayRecognitionEvent);
        } else {
            showErrorDialog(imageEssayRecognitionEvent.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showErrorDialog(java.lang.String str) {
        showViewByNetError();
        com.up366.mobile.common.dialog.AppDialog.create(this).title(str).left(getString(com.up366.mobile.R.string.photograph_close), new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.ImageEssayRecognitionActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showErrorDialog$0(view);
            }
        }).right(getString(com.up366.mobile.R.string.photograph_again), new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.ImageEssayRecognitionActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showErrorDialog$1(view);
            }
        }).setCancelable(false).setBtnCloseVisibility(8).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorDialog$0(android.view.View view) {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorDialog$1(android.view.View view) {
        setResult(100);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showRecognitionErrorDialog() {
        showViewByNetError();
        com.up366.mobile.common.dialog.AppDialog.create(this).title(getString(com.up366.mobile.R.string.photograph_recognition_result_error)).left(getString(com.up366.mobile.R.string.photograph_close), new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.ImageEssayRecognitionActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showRecognitionErrorDialog$2(view);
            }
        }).right(getString(com.up366.mobile.R.string.photograph_again), new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.ImageEssayRecognitionActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showRecognitionErrorDialog$3(view);
            }
        }).setBtnCloseVisibility(8).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRecognitionErrorDialog$2(android.view.View view) {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRecognitionErrorDialog$3(android.view.View view) {
        setResult(100);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showNetErrorDialog() {
        showViewByNetError();
        com.up366.mobile.common.dialog.AppDialog.create(this).title(getString(com.up366.mobile.R.string.net_error)).message(getString(com.up366.mobile.R.string.check_your_phone_net)).left(getString(com.up366.mobile.R.string.photograph_close), new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.ImageEssayRecognitionActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showNetErrorDialog$4(view);
            }
        }).right(getString(com.up366.mobile.R.string.refresh), new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.ImageEssayRecognitionActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$showNetErrorDialog$5(view);
            }
        }).setCancelable(false).setBtnCloseVisibility(8).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetErrorDialog$4(android.view.View view) {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetErrorDialog$5(android.view.View view) {
        showViewByRecognition(true);
        com.up366.mobile.book.helper.ImageEssayRecognitionHelper imageEssayRecognitionHelper = new com.up366.mobile.book.helper.ImageEssayRecognitionHelper(this.imagePath);
        this.recognitionHelper = imageEssayRecognitionHelper;
        imageEssayRecognitionHelper.start();
    }

    private void showViewByNetError() {
        showViewByRecognition(true);
        gone(this.ivRecognitionDoing);
        visible(this.ibRecognitionOk);
    }

    private void recognitionSuccess(com.up366.mobile.common.event.ImageEssayRecognitionEvent imageEssayRecognitionEvent) {
        this.recognitionResult = imageEssayRecognitionEvent.getResultString();
        this.imageNetUrl = imageEssayRecognitionEvent.getImageNetUrl();
        this.ocrTid = imageEssayRecognitionEvent.getOcrTid();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(this.recognitionResult);
            int i = jSONObject.getInt("code");
            java.lang.String string = "";
            if (jSONObject.has("errorMsgUser")) {
                string = jSONObject.getString("errorMsgUser");
            }
            if (i != 0 && !com.up366.common.StringUtils.isEmptyOrNull(string)) {
                showErrorDialog(string);
                return;
            }
            if (!jSONObject.has("paragraphs")) {
                showRecognitionErrorDialog();
                return;
            }
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("paragraphs");
            if (jSONArray.length() == 0) {
                showRecognitionErrorDialog();
                return;
            }
            if (this.skipConfirm == 0) {
                showViewByRecognition(false);
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    stringBuffer.append(jSONArray.get(i2).toString()).append("\n");
                }
                this.tvResult.setText(stringBuffer);
                return;
            }
            recognitionOver();
        } catch (org.json.JSONException e) {
            com.up366.common.log.Logger.info("recognitionSuccess error " + e.getMessage());
        }
    }

    private void recognitionOver() {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(INTENT_RECOGNITION_RESULT, this.recognitionResult);
        intent.putExtra(INTENT_IMAGE_NET_URL, this.imageNetUrl);
        intent.putExtra(INTENT_OCR_TID, this.ocrTid);
        setResult(-1, intent);
        finish();
    }

    private void showViewByRecognition(boolean z) {
        if (z) {
            gone(this.rlResultLayout, this.ibRecognitionOk, this.btRecognitionLow);
            visible(this.ibBeforeRecognitionBack, this.ivRecognitionDoing, this.tvRecognitionToast);
        } else {
            gone(this.ivRecognitionDoing, this.ibBeforeRecognitionBack, this.tvRecognitionToast);
            visible(this.rlResultLayout, this.ibRecognitionOk, this.btRecognitionLow);
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
        this.recognitionHelper.stop();
    }
}
