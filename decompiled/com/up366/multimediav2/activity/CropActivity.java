package com.up366.multimediav2.activity;

/* JADX INFO: compiled from: CropActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002J\u001e\u0010(\u001a\u00020\u00192\u0014\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00190*H\u0002J\u0012\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\u0019H\u0014J\u0010\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/up366/multimediav2/activity/CropActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "b", "Lcom/up366/multimediav2/databinding/ActivityCropBinding;", "clippedDesc", "", "clippedTitle", "imagePath", "jsonData", "mBitmap", "Landroid/graphics/Bitmap;", "mCanAgainPhoto", "", "mSmartPicture", "outImagePath", "popupGuide", "Landroid/widget/PopupWindow;", "getPopupGuide", "()Landroid/widget/PopupWindow;", "popupGuide$delegate", "Lkotlin/Lazy;", "start", "", "checkImageSize", "", "resultUri", "Landroid/net/Uri;", "cropImage", "cropImageByAuto", "cropImageByRect", "cropImageRotateNinety", "dismissLoading", "finishCropSuccess", "finishNoHandle", "initAutoCropView", "initIntentData", "initRectCropView", "initView", "initViewByData", "loadBitmap", "callback", "Lkotlin/Function1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showAutoCropGuide", "fromTouch", "showTooBigDialog", "Companion", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CropActivity extends androidx.appcompat.app.AppCompatActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.multimediav2.activity.CropActivity.Companion INSTANCE = new com.up366.multimediav2.activity.CropActivity.Companion(null);
    private static final long IMAGE_MAX_SIZE = 3145728;
    private static final java.lang.String INTENT_IMAGE_INPUT_URI = "IMAGE_INPUT_URI";
    public static final java.lang.String INTENT_IMAGE_OUTPUT_URI = "IMAGE_OUTPUT_URI";
    private static final java.lang.String INTENT_KEY_CAN_AGAIN_PHOTO = "can_again_photo";
    private static final java.lang.String INTENT_KEY_JSON_DATA = "json_data_string";
    private static final java.lang.String KEY_AUTO_CROP_GTUIDE = "auto_crop_guide";
    private static final java.lang.String KEY_BUNDLE_SMART_HAND = "smart_or_hand";
    private static final java.lang.String TAG = "CropActivity";
    private com.up366.multimediav2.databinding.ActivityCropBinding b;
    private java.lang.String imagePath;
    private java.lang.String jsonData;
    private android.graphics.Bitmap mBitmap;
    private java.lang.String outImagePath;
    private long start;
    private boolean mSmartPicture = true;
    private boolean mCanAgainPhoto = true;
    private java.lang.String clippedTitle = "剪裁只可保留英文区域";
    private java.lang.String clippedDesc = "拖动四角，调整识别区范围\n区内只显示需要识别的内容";

    /* JADX INFO: renamed from: popupGuide$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy popupGuide = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0<android.widget.PopupWindow>() { // from class: com.up366.multimediav2.activity.CropActivity$popupGuide$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final android.widget.PopupWindow m1342invoke() {
            android.view.View viewInflate = this.this$0.getLayoutInflater().inflate(com.up366.multimediav2.R.layout.view_guide_picture_auto_crop, (android.view.ViewGroup) null);
            android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable();
            float f = android.content.res.Resources.getSystem().getDisplayMetrics().density * 20;
            shapeDrawable.setShape(new android.graphics.drawable.shapes.RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
            shapeDrawable.getPaint().setColor(-1);
            viewInflate.setBackground(shapeDrawable);
            com.bumptech.glide.Glide.with(this.this$0).load(java.lang.Integer.valueOf(com.up366.multimediav2.R.drawable.free_auto_crop_guide)).into((android.widget.ImageView) viewInflate.findViewById(com.up366.multimediav2.R.id.iv_guide));
            android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(viewInflate, com.up366.qmui.util.QMUIDisplayHelper.dpToPx(310), com.up366.qmui.util.QMUIDisplayHelper.dpToPx(365));
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);
            return popupWindow;
        }
    });

    @kotlin.jvm.JvmStatic
    public static final void startCropActivity(android.app.Activity activity, java.lang.String str, java.lang.String str2, boolean z, int i) {
        INSTANCE.startCropActivity(activity, str, str2, z, i);
    }

    @kotlin.jvm.JvmStatic
    public static final void startCropActivity(android.app.Activity activity, java.lang.String str, java.lang.String str2, boolean z, int i, boolean z2) {
        INSTANCE.startCropActivity(activity, str, str2, z, i, z2);
    }

    @kotlin.jvm.JvmStatic
    public static final void startCropActivity(android.app.Activity activity, java.lang.String str, java.lang.String str2, boolean z, int i, boolean z2, java.lang.String str3) {
        INSTANCE.startCropActivity(activity, str, str2, z, i, z2, str3);
    }

    private final android.widget.PopupWindow getPopupGuide() {
        return (android.widget.PopupWindow) this.popupGuide.getValue();
    }

    /* JADX INFO: compiled from: CropActivity.kt */
    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J:\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0007JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/up366/multimediav2/activity/CropActivity$Companion;", "", "()V", "IMAGE_MAX_SIZE", "", "INTENT_IMAGE_INPUT_URI", "", "INTENT_IMAGE_OUTPUT_URI", "INTENT_KEY_CAN_AGAIN_PHOTO", "INTENT_KEY_JSON_DATA", "KEY_AUTO_CROP_GTUIDE", "KEY_BUNDLE_SMART_HAND", "TAG", "startCropActivity", "", "activity", "Landroid/app/Activity;", "imagePath", "outputImagePath", "smartPicture", "", "requestCode", "", "canAgainPhoto", "jsonData", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final void startCropActivity(android.app.Activity activity, java.lang.String imagePath, java.lang.String outputImagePath, boolean smartPicture, int requestCode) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outputImagePath, "outputImagePath");
            startCropActivity(activity, imagePath, outputImagePath, smartPicture, requestCode, true);
        }

        public static /* synthetic */ void startCropActivity$default(com.up366.multimediav2.activity.CropActivity.Companion companion, android.app.Activity activity, java.lang.String str, java.lang.String str2, boolean z, int i, boolean z2, int i2, java.lang.Object obj) {
            if ((i2 & 32) != 0) {
                z2 = true;
            }
            companion.startCropActivity(activity, str, str2, z, i, z2);
        }

        @kotlin.jvm.JvmStatic
        public final void startCropActivity(android.app.Activity activity, java.lang.String imagePath, java.lang.String outputImagePath, boolean smartPicture, int requestCode, boolean canAgainPhoto) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outputImagePath, "outputImagePath");
            startCropActivity(activity, imagePath, outputImagePath, smartPicture, requestCode, canAgainPhoto, "");
        }

        @kotlin.jvm.JvmStatic
        public final void startCropActivity(android.app.Activity activity, java.lang.String imagePath, java.lang.String outputImagePath, boolean smartPicture, int requestCode, boolean canAgainPhoto, java.lang.String jsonData) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outputImagePath, "outputImagePath");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.multimediav2.activity.CropActivity.class);
            intent.putExtra(com.up366.multimediav2.activity.CropActivity.INTENT_IMAGE_INPUT_URI, imagePath);
            intent.putExtra(com.up366.multimediav2.activity.CropActivity.INTENT_IMAGE_OUTPUT_URI, outputImagePath);
            intent.putExtra(com.up366.multimediav2.activity.CropActivity.KEY_BUNDLE_SMART_HAND, smartPicture);
            intent.putExtra(com.up366.multimediav2.activity.CropActivity.INTENT_KEY_CAN_AGAIN_PHOTO, canAgainPhoto);
            intent.putExtra("json_data_string", jsonData);
            activity.startActivityForResult(intent, requestCode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.app.Activity activity = (android.app.Activity) this;
        com.up366.qmui.util.QMUIStatusBarHelper.translucent(activity);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarDarkMode(activity);
        androidx.databinding.ViewDataBinding contentView = androidx.databinding.DataBindingUtil.setContentView(activity, com.up366.multimediav2.R.layout.activity_crop);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, R.layout.activity_crop)");
        this.b = (com.up366.multimediav2.databinding.ActivityCropBinding) contentView;
        this.start = java.lang.System.currentTimeMillis();
        initIntentData();
        initView();
    }

    private final void initIntentData() {
        this.mSmartPicture = getIntent().getBooleanExtra(KEY_BUNDLE_SMART_HAND, true);
        this.imagePath = getIntent().getStringExtra(INTENT_IMAGE_INPUT_URI);
        this.outImagePath = getIntent().getStringExtra(INTENT_IMAGE_OUTPUT_URI);
        this.mCanAgainPhoto = getIntent().getBooleanExtra(INTENT_KEY_CAN_AGAIN_PHOTO, true);
        java.lang.String stringExtra = getIntent().getStringExtra("json_data_string");
        this.jsonData = stringExtra;
        if (stringExtra != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(stringExtra);
            if (stringExtra.length() > 0) {
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(this.jsonData);
                java.lang.String string = object.getString("clippedTitle");
                java.lang.String string2 = object.getString("clippedDesc");
                if (!com.up366.common.StringUtils.isEmptyOrNull(string)) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "title");
                    this.clippedTitle = string;
                }
                if (!com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "desc");
                    this.clippedDesc = string2;
                }
            }
        }
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        activityCropBinding.tvTitle.setText(this.clippedTitle);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
        if (activityCropBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityCropBinding2 = activityCropBinding3;
        }
        activityCropBinding2.tvDesc.setText(this.clippedDesc);
        com.up366.common.log.Logger.info("CropActivity imagePath:" + this.imagePath + " outImagePath:" + this.outImagePath + "  smart:" + this.mSmartPicture);
        if (com.up366.common.StringUtils.isEmptyOrNull(this.imagePath) || com.up366.common.StringUtils.isEmptyOrNull(this.outImagePath)) {
            finishNoHandle();
        }
    }

    private final void initView() {
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        activityCropBinding.tvRetry.setVisibility(this.mCanAgainPhoto ? 0 : 8);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
        if (activityCropBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding3 = null;
        }
        activityCropBinding3.ibCropTakePicture.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initView$lambda$0(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding4 = this.b;
        if (activityCropBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding4 = null;
        }
        activityCropBinding4.ibCropRotate.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initView$lambda$1(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding5 = this.b;
        if (activityCropBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding5 = null;
        }
        activityCropBinding5.ibCropBack.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initView$lambda$2(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding6 = this.b;
        if (activityCropBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityCropBinding2 = activityCropBinding6;
        }
        activityCropBinding2.tvRetry.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initView$lambda$3(this.f$0, view);
            }
        });
        if (this.mSmartPicture) {
            initRectCropView();
        } else {
            initAutoCropView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.cropImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.cropImageRotateNinety();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.finishNoHandle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.finishNoHandle();
    }

    private final void initRectCropView() {
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        activityCropBinding.ucrop.setVisibility(0);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
        if (activityCropBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding3 = null;
        }
        activityCropBinding3.autoCropView.setVisibility(8);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding4 = this.b;
        if (activityCropBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding4 = null;
        }
        activityCropBinding4.llAutoTitle.setVisibility(8);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding5 = this.b;
        if (activityCropBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding5 = null;
        }
        com.up366.view.crop.view.GestureCropImageView cropImageView = activityCropBinding5.ucrop.getCropImageView();
        cropImageView.setRotateEnabled(false);
        cropImageView.setTranslateEnabled(false);
        cropImageView.setScaleEnabled(false);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding6 = this.b;
        if (activityCropBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding6 = null;
        }
        com.up366.view.crop.view.OverlayView overlayView = activityCropBinding6.ucrop.getOverlayView();
        overlayView.setAcrossStartBorderEnabled(true);
        overlayView.setCropFrameColor(android.graphics.Color.parseColor("#FEFEFE"));
        overlayView.setFreestyleCropMode(1);
        overlayView.setCropGridCornerColor(android.graphics.Color.parseColor("#5C7CFF"));
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding7 = this.b;
        if (activityCropBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding7 = null;
        }
        activityCropBinding7.ibCropTakePicture.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initRectCropView$lambda$6(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding8 = this.b;
        if (activityCropBinding8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding8 = null;
        }
        activityCropBinding8.ibCropRotate.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initRectCropView$lambda$7(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding9 = this.b;
        if (activityCropBinding9 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding9 = null;
        }
        activityCropBinding9.ibCropBack.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initRectCropView$lambda$8(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding10 = this.b;
        if (activityCropBinding10 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityCropBinding2 = activityCropBinding10;
        }
        activityCropBinding2.ucrop.post(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.multimediav2.activity.CropActivity.initRectCropView$lambda$9(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRectCropView$lambda$6(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.cropImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRectCropView$lambda$7(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.cropImageRotateNinety();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRectCropView$lambda$8(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.finishNoHandle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRectCropView$lambda$9(com.up366.multimediav2.activity.CropActivity cropActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = cropActivity.b;
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        int width = activityCropBinding.ucrop.getWidth();
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = cropActivity.b;
        if (activityCropBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding3 = null;
        }
        int iCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(width, activityCropBinding3.ucrop.getHeight());
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding4 = cropActivity.b;
        if (activityCropBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityCropBinding2 = activityCropBinding4;
        }
        activityCropBinding2.ucrop.getCropImageView().setMaxBitmapSize(iCoerceAtLeast);
        cropActivity.initViewByData();
    }

    private final void initAutoCropView() {
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        activityCropBinding.ucrop.setVisibility(8);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
        if (activityCropBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding3 = null;
        }
        activityCropBinding3.llAutoTitle.setVisibility(0);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding4 = this.b;
        if (activityCropBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding4 = null;
        }
        activityCropBinding4.autoCropView.setVisibility(0);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding5 = this.b;
        if (activityCropBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding5 = null;
        }
        activityCropBinding5.pbLoading.animate().setInterpolator(new android.view.animation.LinearInterpolator()).rotationBy(1296000.0f).setDuration(3600000L).start();
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding6 = this.b;
        if (activityCropBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityCropBinding2 = activityCropBinding6;
        }
        activityCropBinding2.ibAutoTips.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.CropActivity.initAutoCropView$lambda$10(this.f$0, view);
            }
        });
        loadBitmap(new com.up366.multimediav2.activity.CropActivity.AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.up366.multimediav2.activity.CropActivity$initAutoCropView$2, reason: invalid class name */
    /* JADX INFO: compiled from: CropActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<android.graphics.Bitmap, kotlin.Unit> {
        AnonymousClass2() {
            super(1);
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
            invoke((android.graphics.Bitmap) obj);
            return kotlin.Unit.INSTANCE;
        }

        public final void invoke(final android.graphics.Bitmap bitmap) {
            final com.up366.multimediav2.activity.CropActivity cropActivity = com.up366.multimediav2.activity.CropActivity.this;
            cropActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.CropActivity$initAutoCropView$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.multimediav2.activity.CropActivity.AnonymousClass2.invoke$lambda$0(cropActivity, bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(com.up366.multimediav2.activity.CropActivity cropActivity, android.graphics.Bitmap bitmap) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
            cropActivity.mBitmap = bitmap;
            cropActivity.dismissLoading();
            com.up366.common.log.Logger.info("CropActivity autoCropView 图片加载完毕 " + (java.lang.System.currentTimeMillis() - cropActivity.start));
            if (bitmap != null) {
                com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = cropActivity.b;
                if (activityCropBinding == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                    activityCropBinding = null;
                }
                activityCropBinding.autoCropView.setImageToCrop(cropActivity.mBitmap);
                return;
            }
            com.up366.common.log.Logger.error("CropActivity 图片加载失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAutoCropView$lambda$10(com.up366.multimediav2.activity.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        cropActivity.showAutoCropGuide(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoading() {
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        if (activityCropBinding.pbLoading.getVisibility() == 0) {
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
            if (activityCropBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding3 = null;
            }
            activityCropBinding3.pbLoading.clearAnimation();
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding4 = this.b;
            if (activityCropBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding4 = null;
            }
            activityCropBinding4.pbLoading.setRotation(0.0f);
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding5 = this.b;
            if (activityCropBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityCropBinding2 = activityCropBinding5;
            }
            activityCropBinding2.pbLoading.setVisibility(8);
        }
    }

    private final void showAutoCropGuide(boolean fromTouch) {
        boolean z = getSharedPreferences(com.up366.multimediav2.util.Constants.PREFERENCE_NAME, 0).getBoolean(KEY_AUTO_CROP_GTUIDE, true);
        if ((fromTouch || z) && !getPopupGuide().isShowing()) {
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
            if (activityCropBinding == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding = null;
            }
            int width = (activityCropBinding.llAutoTitle.getWidth() / 2) - (getPopupGuide().getWidth() / 2);
            android.widget.PopupWindow popupGuide = getPopupGuide();
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
            if (activityCropBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityCropBinding2 = activityCropBinding3;
            }
            popupGuide.showAsDropDown(activityCropBinding2.llAutoTitle, width, 20);
            getSharedPreferences(com.up366.multimediav2.util.Constants.PREFERENCE_NAME, 0).edit().putBoolean(KEY_AUTO_CROP_GTUIDE, true).commit();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        dismissLoading();
    }

    private final void initViewByData() {
        try {
            android.net.Uri uriFromFile = android.net.Uri.fromFile(new java.io.File(this.imagePath));
            android.net.Uri uriFromFile2 = android.net.Uri.fromFile(new java.io.File(this.outImagePath));
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = null;
            if (activityCropBinding == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding = null;
            }
            activityCropBinding.ucrop.getCropImageView().setTransformImageListener(new com.up366.view.crop.view.TransformImageView.TransformImageListener() { // from class: com.up366.multimediav2.activity.CropActivity.initViewByData.1
                @Override // com.up366.view.crop.view.TransformImageView.TransformImageListener
                public void onRotate(float currentAngle) {
                }

                @Override // com.up366.view.crop.view.TransformImageView.TransformImageListener
                public void onScale(float currentScale) {
                }

                @Override // com.up366.view.crop.view.TransformImageView.TransformImageListener
                public void onLoadComplete() {
                    com.up366.common.log.Logger.info("图片加载完毕 " + (java.lang.System.currentTimeMillis() - com.up366.multimediav2.activity.CropActivity.this.start));
                    com.up366.multimediav2.activity.CropActivity.this.dismissLoading();
                }

                @Override // com.up366.view.crop.view.TransformImageView.TransformImageListener
                public void onLoadFailure(java.lang.Exception e) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(e, "e");
                    com.up366.multimediav2.activity.CropActivity.this.dismissLoading();
                    android.widget.Toast.makeText((android.content.Context) com.up366.multimediav2.activity.CropActivity.this, "图片加载失败", 0).show();
                    com.up366.multimediav2.activity.CropActivity.this.finishNoHandle();
                }
            });
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
            if (activityCropBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityCropBinding2 = activityCropBinding3;
            }
            activityCropBinding2.ucrop.getCropImageView().setImageUri(uriFromFile, uriFromFile2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private final void cropImageRotateNinety() {
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = null;
        if (this.mSmartPicture) {
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = this.b;
            if (activityCropBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding2 = null;
            }
            activityCropBinding2.ucrop.getCropImageView().postRotate(90.0f);
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
            if (activityCropBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding3 = null;
            }
            com.up366.view.crop.view.GestureCropImageView cropImageView = activityCropBinding3.ucrop.getCropImageView();
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding4 = this.b;
            if (activityCropBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding4 = null;
            }
            cropImageView.zoomInImage(activityCropBinding4.ucrop.getCropImageView().getMinScale());
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding5 = this.b;
            if (activityCropBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding5 = null;
            }
            com.up366.view.crop.view.OverlayView overlayView = activityCropBinding5.ucrop.getOverlayView();
            float f = 1;
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding6 = this.b;
            if (activityCropBinding6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityCropBinding = activityCropBinding6;
            }
            overlayView.setTargetAspectRatio(f / activityCropBinding.ucrop.getOverlayView().getmTargetAspectRatio());
            return;
        }
        android.graphics.Bitmap bitmapBitmapRotate = com.up366.smart.paper.CameraUtil.bitmapRotate(this.mBitmap, 90.0f);
        com.up366.smart.paper.CameraUtil.gcBitmap(this.mBitmap, bitmapBitmapRotate);
        this.mBitmap = bitmapBitmapRotate;
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding7 = this.b;
        if (activityCropBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityCropBinding = activityCropBinding7;
        }
        activityCropBinding.autoCropView.setImageToCrop(this.mBitmap);
    }

    private final void cropImage() {
        if (this.mSmartPicture) {
            cropImageByRect();
        } else {
            cropImageByAuto();
        }
    }

    private final void cropImageByAuto() {
        android.graphics.Bitmap bitmap;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = null;
        try {
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = this.b;
            if (activityCropBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding2 = null;
            }
            android.graphics.Point[] cropPoints = activityCropBinding2.autoCropView.getCropPoints();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cropPoints, "b.autoCropView.cropPoints");
            for (android.graphics.Point point : cropPoints) {
                arrayList.add(new org.opencv.core.Point(point.x, point.y));
            }
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding3 = this.b;
            if (activityCropBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityCropBinding3 = null;
            }
            bitmap = com.up366.smart.paper.opencv.OpencvCrop.bitmapTransformCrop(activityCropBinding3.autoCropView.getBitmap(), arrayList);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("cropImageByAuto error " + e.getMessage(), e);
            bitmap = null;
        }
        if (bitmap == null) {
            com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding4 = this.b;
            if (activityCropBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityCropBinding = activityCropBinding4;
            }
            bitmap = activityCropBinding.autoCropView.getBitmap();
        }
        com.up366.smart.paper.CameraUtil.saveBitmap(bitmap, this.outImagePath);
        android.net.Uri uriFromFile = android.net.Uri.fromFile(new java.io.File(this.outImagePath));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(File(outImagePath))");
        checkImageSize(uriFromFile);
    }

    private final void cropImageByRect() {
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        activityCropBinding.ucrop.getCropImageView().cropAndSaveImage(android.graphics.Bitmap.CompressFormat.JPEG, 90, new com.up366.view.crop.callback.BitmapCropCallback() { // from class: com.up366.multimediav2.activity.CropActivity.cropImageByRect.1
            @Override // com.up366.view.crop.callback.BitmapCropCallback
            public void onBitmapCropped(android.net.Uri resultUri, int offsetX, int offsetY, int imageWidth, int imageHeight) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resultUri, "resultUri");
                com.up366.multimediav2.activity.CropActivity.this.checkImageSize(resultUri);
            }

            @Override // com.up366.view.crop.callback.BitmapCropCallback
            public void onCropFailure(java.lang.Throwable t) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "t");
                com.up366.common.log.Logger.info("CropActivity crop fail t=" + t.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkImageSize(final android.net.Uri resultUri) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.multimediav2.activity.CropActivity.checkImageSize$lambda$12(resultUri, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkImageSize$lambda$12(android.net.Uri uri, com.up366.multimediav2.activity.CropActivity cropActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "$resultUri");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        com.up366.common.BitmapUtilsUp.compressBitmap(uri.getPath(), uri.getPath(), 2000, 2000, 80);
        if (com.up366.common.FileUtilsUp.getFileSize(uri.getPath()) > IMAGE_MAX_SIZE) {
            cropActivity.showTooBigDialog();
        } else {
            cropActivity.finishCropSuccess(uri);
        }
    }

    private final void showTooBigDialog() {
        runOnUiThread(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.multimediav2.activity.CropActivity.showTooBigDialog$lambda$14(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showTooBigDialog$lambda$14(final com.up366.multimediav2.activity.CropActivity cropActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        final com.up366.multimediav2.dialog.DialogCommon dialogCommon = new com.up366.multimediav2.dialog.DialogCommon((android.content.Context) cropActivity);
        dialogCommon.setTitleMsg(cropActivity.getString(com.up366.multimediav2.R.string.picture_too_big_again_crop));
        dialogCommon.setCancleMsg(cropActivity.getString(com.up366.multimediav2.R.string.photograph_again));
        dialogCommon.setOkMsg(cropActivity.getString(com.up366.multimediav2.R.string.crop_again));
        dialogCommon.setCallBack(new com.up366.multimediav2.dialog.DialogCommon.RequestCallBack() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda3
            @Override // com.up366.multimediav2.dialog.DialogCommon.RequestCallBack
            public final void onResult(boolean z) {
                com.up366.multimediav2.activity.CropActivity.showTooBigDialog$lambda$14$lambda$13(this.f$0, dialogCommon, z);
            }
        });
        dialogCommon.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTooBigDialog$lambda$14$lambda$13(com.up366.multimediav2.activity.CropActivity cropActivity, com.up366.multimediav2.dialog.DialogCommon dialogCommon, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialogCommon, "$dialog");
        if (!z) {
            cropActivity.finishNoHandle();
        }
        dialogCommon.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishNoHandle() {
        setResult(0);
        finish();
    }

    private final void finishCropSuccess(final android.net.Uri resultUri) {
        runOnUiThread(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.multimediav2.activity.CropActivity.finishCropSuccess$lambda$15(resultUri, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishCropSuccess$lambda$15(android.net.Uri uri, com.up366.multimediav2.activity.CropActivity cropActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "$resultUri");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(INTENT_IMAGE_OUTPUT_URI, uri.getPath());
        cropActivity.setResult(-1, intent);
        cropActivity.finish();
    }

    private final void loadBitmap(final kotlin.jvm.functions.Function1<? super android.graphics.Bitmap, kotlin.Unit> callback) {
        if (com.up366.common.task.TaskUtils.isMainThread()) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.multimediav2.activity.CropActivity$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.multimediav2.activity.CropActivity.loadBitmap$lambda$16(this.f$0, callback);
                }
            });
            return;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(this.imagePath, options);
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding = this.b;
        if (activityCropBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding = null;
        }
        int width = activityCropBinding.rlRoot.getWidth();
        com.up366.multimediav2.databinding.ActivityCropBinding activityCropBinding2 = this.b;
        if (activityCropBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityCropBinding2 = null;
        }
        options.inSampleSize = com.up366.view.crop.util.BitmapLoadUtils.calculateInSampleSize(options, width, activityCropBinding2.rlRoot.getHeight());
        options.inJustDecodeBounds = false;
        try {
            callback.invoke(android.graphics.BitmapFactory.decodeFile(this.imagePath, options));
        } catch (java.lang.Exception unused) {
            callback.invoke((java.lang.Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadBitmap$lambda$16(com.up366.multimediav2.activity.CropActivity cropActivity, kotlin.jvm.functions.Function1 function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "$callback");
        cropActivity.loadBitmap(function1);
    }
}
