package com.up366.multimediav2.activity;

/* JADX INFO: compiled from: SmartAnswerCameraActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000Á\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001 \u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0002efB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\u0010\u00105\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020.H\u0002J\u0010\u00107\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u00108\u001a\u00020.H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020:0>2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u00020.2\u0006\u0010@\u001a\u00020A2\u0006\u00101\u001a\u000202H\u0003J\b\u0010C\u001a\u00020.H\u0002J\b\u0010D\u001a\u00020.H\u0002J\b\u0010E\u001a\u00020.H\u0002J\u001a\u0010F\u001a\u00020.2\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020JH\u0016J\u0012\u0010K\u001a\u00020.2\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u00020.H\u0014J-\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020J2\u000e\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050R2\u0006\u0010S\u001a\u00020TH\u0016¢\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020.H\u0014J\u0012\u0010W\u001a\u00020.2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\b\u0010Z\u001a\u00020.H\u0014J\u0010\u0010[\u001a\u00020.2\u0006\u0010\\\u001a\u00020\u0014H\u0002J\u0010\u0010]\u001a\u00020.2\u0006\u0010^\u001a\u00020\u0014H\u0002J\u0010\u0010_\u001a\u00020.2\u0006\u0010^\u001a\u00020\u0014H\u0003J\b\u0010`\u001a\u00020.H\u0002J\b\u0010a\u001a\u00020.H\u0002J\u0010\u0010b\u001a\u00020.2\u0006\u0010c\u001a\u00020\u0014H\u0002J\u001c\u0010d\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u0001022\b\b\u0002\u0010c\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010%\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\f\u001a\u0004\b&\u0010\nR\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/up366/multimediav2/activity/SmartAnswerCameraActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/hardware/SensorEventListener;", "()V", "TAG", "", "analyzeExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getAnalyzeExecutor", "()Ljava/util/concurrent/ExecutorService;", "analyzeExecutor$delegate", "Lkotlin/Lazy;", "b", "Lcom/up366/multimediav2/databinding/ActivityAnswerSmartCameraBinding;", "defaultImagePath", "getDefaultImagePath", "()Ljava/lang/String;", "defaultImagePath$delegate", "firstShowLightToast", "", "imagePath", "lightAnimator", "Landroid/animation/ObjectAnimator;", "lightStatus", "mCameraControl", "Landroidx/camera/core/CameraControl;", "mCameraInfo", "Landroidx/camera/core/CameraInfo;", "mCameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "mHandler", "com/up366/multimediav2/activity/SmartAnswerCameraActivity$mHandler$1", "Lcom/up366/multimediav2/activity/SmartAnswerCameraActivity$mHandler$1;", "mImageCapture", "Landroidx/camera/core/ImageCapture;", "needUpdateGraphicOverlayImageSourceInfo", "pictureExecutor", "getPictureExecutor", "pictureExecutor$delegate", "resultStatistics", "Lcom/up366/smart/paper/ResultStatistics;", "startAnalyzer", "tipsToastPopupWindow", "Landroid/widget/PopupWindow;", "analysisResult", "", "bitmap", "Landroid/graphics/Bitmap;", "analyzeResult", "Lcom/up366/smart/paper/BitmapAnalyzeResult;", "closeTakePictureTipsToast", "controlLight", "finishByHandTakePicture", "finishByNoHandle", "finishByRecognitionTakePicture", "finishGotoAlbumActivity", "getSupportSize", "Landroid/util/Size;", "context", "Landroid/content/Context;", "getSupportedResolutions", "", "handImage", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Landroidx/camera/core/ImageProxy;", "handleImage", "initCameraController", "initData", "initView", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onStop", "setLightDrawableByStatus", "status", "showGuideDialog", "manual", "showSmartGuideDialog", "showTakePictureTipsToast", "startCamera", "switchScene", "hand", "takeOnePicture", "Companion", "ImageAnalyzer", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmartAnswerCameraActivity extends androidx.appcompat.app.AppCompatActivity implements android.hardware.SensorEventListener {
    public static final int CLOSE_OPERATION_TIPS_DIALOG = 102;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.multimediav2.activity.SmartAnswerCameraActivity.Companion INSTANCE = new com.up366.multimediav2.activity.SmartAnswerCameraActivity.Companion(null);
    public static final java.lang.String IMAGE_SAVE_PATH_AND_NAME = "result_image_path";
    public static final java.lang.String INTENT_ALBUM_MAX_SIZE = "max_size";
    public static final java.lang.String INTENT_KEY_IMAGE_SAVE_PATH = "image_save_path";
    public static final java.lang.String INTENT_KEY_JSON_DATA = "json_data_string";
    public static final java.lang.String KEY_FIRST_GUIDE = "smart_camera_guide";
    public static final int RESULT_CODE_TO_ALBUM = 100;
    public static final int SHOW_OPERATION_TIPS_DIALOG = 101;
    public static final java.lang.String TAKE_PICTURE_SMART = "take_picture_smart";
    private static boolean isClosePad;
    private com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding b;
    private java.lang.String imagePath;
    private android.animation.ObjectAnimator lightAnimator;
    private boolean lightStatus;
    private androidx.camera.core.CameraControl mCameraControl;
    private androidx.camera.core.CameraInfo mCameraInfo;
    private androidx.camera.lifecycle.ProcessCameraProvider mCameraProvider;
    private final com.up366.multimediav2.activity.SmartAnswerCameraActivity$mHandler$1 mHandler;
    private androidx.camera.core.ImageCapture mImageCapture;
    private volatile boolean needUpdateGraphicOverlayImageSourceInfo;
    private volatile boolean startAnalyzer;
    private android.widget.PopupWindow tipsToastPopupWindow;
    private final java.lang.String TAG = "SmartAnswerCameraActivity";
    private boolean firstShowLightToast = true;

    /* JADX INFO: renamed from: analyzeExecutor$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy analyzeExecutor = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0<java.util.concurrent.ExecutorService>() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$analyzeExecutor$2
        public final java.util.concurrent.ExecutorService invoke() {
            return java.util.concurrent.Executors.newSingleThreadExecutor();
        }
    });

    /* JADX INFO: renamed from: pictureExecutor$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy pictureExecutor = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0<java.util.concurrent.ExecutorService>() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$pictureExecutor$2
        public final java.util.concurrent.ExecutorService invoke() {
            return java.util.concurrent.Executors.newSingleThreadExecutor();
        }
    });
    private final com.up366.smart.paper.ResultStatistics resultStatistics = new com.up366.smart.paper.ResultStatistics();

    /* JADX INFO: renamed from: defaultImagePath$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy defaultImagePath = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$defaultImagePath$2
        {
            super(0);
        }

        public final java.lang.String invoke() {
            return this.this$0.getFilesDir().getAbsolutePath() + "/article_ocr_pic/" + java.lang.System.currentTimeMillis() + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
        }
    });

    @kotlin.jvm.JvmStatic
    public static final void startCameraActivityForResult(android.app.Activity activity, int i, java.lang.String str) {
        INSTANCE.startCameraActivityForResult(activity, i, str);
    }

    @kotlin.jvm.JvmStatic
    public static final void startCameraActivityForResultV2(android.app.Activity activity, int i, java.lang.String str, java.lang.String str2) {
        INSTANCE.startCameraActivityForResultV2(activity, i, str, str2);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.up366.multimediav2.activity.SmartAnswerCameraActivity$mHandler$1] */
    public SmartAnswerCameraActivity() {
        final android.os.Looper mainLooper = android.os.Looper.getMainLooper();
        this.mHandler = new android.os.Handler(mainLooper) { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$mHandler$1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message msg) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                int i = msg.what;
                if (i == 101) {
                    this.this$0.showTakePictureTipsToast();
                } else {
                    if (i != 102) {
                        return;
                    }
                    this.this$0.closeTakePictureTipsToast();
                }
            }
        };
        this.needUpdateGraphicOverlayImageSourceInfo = true;
    }

    private final java.util.concurrent.ExecutorService getAnalyzeExecutor() {
        return (java.util.concurrent.ExecutorService) this.analyzeExecutor.getValue();
    }

    private final java.util.concurrent.ExecutorService getPictureExecutor() {
        return (java.util.concurrent.ExecutorService) this.pictureExecutor.getValue();
    }

    private final java.lang.String getDefaultImagePath() {
        return (java.lang.String) this.defaultImagePath.getValue();
    }

    /* JADX INFO: compiled from: SmartAnswerCameraActivity.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H\u0007J(\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/up366/multimediav2/activity/SmartAnswerCameraActivity$Companion;", "", "()V", "CLOSE_OPERATION_TIPS_DIALOG", "", "IMAGE_SAVE_PATH_AND_NAME", "", "INTENT_ALBUM_MAX_SIZE", "INTENT_KEY_IMAGE_SAVE_PATH", "INTENT_KEY_JSON_DATA", "KEY_FIRST_GUIDE", "RESULT_CODE_TO_ALBUM", "SHOW_OPERATION_TIPS_DIALOG", "TAKE_PICTURE_SMART", "isClosePad", "", "()Z", "setClosePad", "(Z)V", "startCameraActivityForResult", "", "activity", "Landroid/app/Activity;", "requestCode", "outputImagePathAndName", "startCameraActivityForResultV2", "jsonData", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isClosePad() {
            return com.up366.multimediav2.activity.SmartAnswerCameraActivity.isClosePad;
        }

        public final void setClosePad(boolean z) {
            com.up366.multimediav2.activity.SmartAnswerCameraActivity.isClosePad = z;
        }

        @kotlin.jvm.JvmStatic
        public final void startCameraActivityForResult(android.app.Activity activity, int requestCode, java.lang.String outputImagePathAndName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outputImagePathAndName, "outputImagePathAndName");
            android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.multimediav2.activity.SmartAnswerCameraActivity.class);
            intent.putExtra(com.up366.multimediav2.activity.SmartAnswerCameraActivity.INTENT_KEY_IMAGE_SAVE_PATH, outputImagePathAndName);
            activity.startActivityForResult(intent, requestCode);
        }

        @kotlin.jvm.JvmStatic
        public final void startCameraActivityForResultV2(android.app.Activity activity, int requestCode, java.lang.String outputImagePathAndName, java.lang.String jsonData) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outputImagePathAndName, "outputImagePathAndName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.multimediav2.activity.SmartAnswerCameraActivity.class);
            intent.putExtra(com.up366.multimediav2.activity.SmartAnswerCameraActivity.INTENT_KEY_IMAGE_SAVE_PATH, outputImagePathAndName);
            intent.putExtra(com.up366.multimediav2.activity.SmartAnswerCameraActivity.INTENT_KEY_JSON_DATA, jsonData);
            activity.startActivityForResult(intent, requestCode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.up366.smart.paper.SmartPaperLib.init((android.content.Context) this);
        supportRequestWindowFeature(1);
        getWindow().addFlags(128);
        getWindow().addFlags(1024);
        getWindow().setFlags(16777216, 16777216);
        androidx.databinding.ViewDataBinding contentView = androidx.databinding.DataBindingUtil.setContentView((android.app.Activity) this, com.up366.multimediav2.R.layout.activity_answer_smart_camera);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, R.l…vity_answer_smart_camera)");
        this.b = (com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding) contentView;
        initData();
        initView();
    }

    private final void initView() {
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = this.b;
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = null;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        activityAnswerSmartCameraBinding.btBack.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$0(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding3 = this.b;
        if (activityAnswerSmartCameraBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding3 = null;
        }
        activityAnswerSmartCameraBinding3.btLightStatus.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$1(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding4 = this.b;
        if (activityAnswerSmartCameraBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding4 = null;
        }
        activityAnswerSmartCameraBinding4.btHelp.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$2(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding5 = this.b;
        if (activityAnswerSmartCameraBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding5 = null;
        }
        activityAnswerSmartCameraBinding5.ibSelectPic.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$3(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding6 = this.b;
        if (activityAnswerSmartCameraBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding6 = null;
        }
        activityAnswerSmartCameraBinding6.qrbHandPicture.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$4(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding7 = this.b;
        if (activityAnswerSmartCameraBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding7 = null;
        }
        activityAnswerSmartCameraBinding7.qrbAutoPicture.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$5(this.f$0, view);
            }
        });
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding8 = this.b;
        if (activityAnswerSmartCameraBinding8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding8 = null;
        }
        activityAnswerSmartCameraBinding8.ibHandTakePic.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$6(this.f$0, view);
            }
        });
        switchScene(true);
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding9 = this.b;
        if (activityAnswerSmartCameraBinding9 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding9 = null;
        }
        final kotlin.jvm.functions.Function1<androidx.camera.view.PreviewView.StreamState, kotlin.Unit> function1 = new kotlin.jvm.functions.Function1<androidx.camera.view.PreviewView.StreamState, kotlin.Unit>() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView.8
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((androidx.camera.view.PreviewView.StreamState) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(androidx.camera.view.PreviewView.StreamState streamState) {
                com.up366.common.log.Logger.info(com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.TAG + " previewView stream state " + streamState);
                if (streamState == androidx.camera.view.PreviewView.StreamState.STREAMING) {
                    com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.showGuideDialog(false);
                }
            }
        };
        activityAnswerSmartCameraBinding9.previewView.getPreviewStreamState().observe((androidx.lifecycle.LifecycleOwner) this, new androidx.lifecycle.Observer() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda2
            public final void onChanged(java.lang.Object obj) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initView$lambda$7(function1, obj);
            }
        });
        if (isClosePad) {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding10 = this.b;
            if (activityAnswerSmartCameraBinding10 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityAnswerSmartCameraBinding2 = activityAnswerSmartCameraBinding10;
            }
            activityAnswerSmartCameraBinding2.ibSelectPic.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.controlLight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.showGuideDialog(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.finishGotoAlbumActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.switchScene(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.switchScene(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.takeOnePicture(null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(kotlin.jvm.functions.Function1 function1, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startCamera() {
        if (com.up366.multimediav2.util.PermissionUtils.hasCameraPermissions((android.content.Context) this)) {
            initCameraController();
        } else {
            androidx.core.app.ActivityCompat.requestPermissions((android.app.Activity) this, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, 101);
        }
    }

    public void onRequestPermissionsResult(int requestCode, java.lang.String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            for (int i : grantResults) {
                if (i != 0) {
                    finishByNoHandle();
                    return;
                }
            }
            startCamera();
        }
    }

    private final void finishByNoHandle() {
        setResult(0);
        finish();
    }

    private final void finishByRecognitionTakePicture(java.lang.String imagePath) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(TAKE_PICTURE_SMART, true);
        intent.putExtra(IMAGE_SAVE_PATH_AND_NAME, imagePath);
        setResult(-1, intent);
        finish();
    }

    private final void finishByHandTakePicture(java.lang.String imagePath) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(TAKE_PICTURE_SMART, false);
        intent.putExtra(IMAGE_SAVE_PATH_AND_NAME, imagePath);
        setResult(-1, intent);
        finish();
    }

    private final void finishGotoAlbumActivity() {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("max_size", 1);
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID, 123);
        setResult(100, intent);
        finish();
    }

    protected void onResume() {
        super.onResume();
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = this.b;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        activityAnswerSmartCameraBinding.previewView.post(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.onResume$lambda$8(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$8(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.startCamera();
    }

    protected void onStop() {
        super.onStop();
        androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbind(new androidx.camera.core.UseCase[0]);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        removeCallbacksAndMessages(null);
        getAnalyzeExecutor().shutdown();
        getPictureExecutor().shutdown();
        androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbind(new androidx.camera.core.UseCase[0]);
        }
    }

    private final void initData() {
        android.content.Intent intent = getIntent();
        android.animation.ObjectAnimator objectAnimator = null;
        java.lang.String stringExtra = intent != null ? intent.getStringExtra(INTENT_KEY_IMAGE_SAVE_PATH) : null;
        if (stringExtra == null) {
            stringExtra = getDefaultImagePath();
        }
        this.imagePath = stringExtra;
        android.content.Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.getStringExtra(INTENT_KEY_JSON_DATA);
        }
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = this.b;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(activityAnswerSmartCameraBinding.btLightStatus, com.up366.qmui.skin.QMUISkinValueBuilder.ALPHA, 1.0f, 0.0f);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(b.btLightStatus, \"alpha\", 1f, 0f)");
        this.lightAnimator = objectAnimatorOfFloat;
        if (objectAnimatorOfFloat == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
            objectAnimatorOfFloat = null;
        }
        objectAnimatorOfFloat.setDuration(400L);
        android.animation.ObjectAnimator objectAnimator2 = this.lightAnimator;
        if (objectAnimator2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
            objectAnimator2 = null;
        }
        objectAnimator2.setInterpolator(new android.view.animation.AccelerateInterpolator());
        android.animation.ObjectAnimator objectAnimator3 = this.lightAnimator;
        if (objectAnimator3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
            objectAnimator3 = null;
        }
        objectAnimator3.setRepeatCount(-1);
        android.animation.ObjectAnimator objectAnimator4 = this.lightAnimator;
        if (objectAnimator4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
            objectAnimator4 = null;
        }
        objectAnimator4.setRepeatMode(2);
        android.animation.ObjectAnimator objectAnimator5 = this.lightAnimator;
        if (objectAnimator5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
        } else {
            objectAnimator = objectAnimator5;
        }
        objectAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity.initData.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animation) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animation, "animation");
                com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.b;
                if (activityAnswerSmartCameraBinding2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                    activityAnswerSmartCameraBinding2 = null;
                }
                activityAnswerSmartCameraBinding2.btLightStatus.animate().alpha(1.0f).setDuration(50L).start();
            }
        });
        this.resultStatistics.setCallback(new com.up366.smart.paper.ResultStatistics.Callback() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda4
            @Override // com.up366.smart.paper.ResultStatistics.Callback
            public final void onResult(com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResult) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initData$lambda$10(this.f$0, bitmapAnalyzeResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$10(final com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, final com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initData$lambda$10$lambda$9(this.f$0, bitmapAnalyzeResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$10$lambda$9(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.mHandler.removeCallbacksAndMessages(null);
        takeOnePicture$default(smartAnswerCameraActivity, bitmapAnalyzeResult, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initCameraController() {
        android.content.Context context = (android.content.Context) this;
        final com.google.common.util.concurrent.ListenableFuture companion = androidx.camera.lifecycle.ProcessCameraProvider.Companion.getInstance(context);
        companion.addListener(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initCameraController$lambda$12(this.f$0, companion);
            }
        }, androidx.core.content.ContextCompat.getMainExecutor(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initCameraController$lambda$12(final com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, com.google.common.util.concurrent.ListenableFuture listenableFuture) {
        androidx.camera.core.Preview previewBuild;
        androidx.camera.core.ImageAnalysis imageAnalysisBuild;
        androidx.lifecycle.LiveData torchState;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listenableFuture, "$cameraProviderFuture");
        smartAnswerCameraActivity.mCameraProvider = (androidx.camera.lifecycle.ProcessCameraProvider) listenableFuture.get();
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = smartAnswerCameraActivity.b;
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = null;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        int rotation = activityAnswerSmartCameraBinding.previewView.getDisplay().getRotation();
        java.lang.String str = android.os.Build.MODEL;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        if (kotlin.text.StringsKt.contains$default(str, "23073RPBFC", false, 2, (java.lang.Object) null)) {
            androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setResolutionStrategy(new androidx.camera.core.resolutionselector.ResolutionStrategy(new android.util.Size(1280, 720), 2)).setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "Builder().setResolutionS…IGHER_RESOLUTION).build()");
            previewBuild = new androidx.camera.core.Preview.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild).build();
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding3 = smartAnswerCameraActivity.b;
            if (activityAnswerSmartCameraBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding3 = null;
            }
            previewBuild.setSurfaceProvider(activityAnswerSmartCameraBinding3.previewView.getSurfaceProvider());
            imageAnalysisBuild = new androidx.camera.core.ImageAnalysis.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild).setOutputImageFormat(2).setBackpressureStrategy(0).build();
        } else {
            androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild2 = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild2, "Builder().setAspectRatio…IGHER_RESOLUTION).build()");
            previewBuild = new androidx.camera.core.Preview.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild2).build();
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding4 = smartAnswerCameraActivity.b;
            if (activityAnswerSmartCameraBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding4 = null;
            }
            previewBuild.setSurfaceProvider(activityAnswerSmartCameraBinding4.previewView.getSurfaceProvider());
            androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild3 = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setResolutionStrategy(new androidx.camera.core.resolutionselector.ResolutionStrategy(new android.util.Size(640, 480), 2)).setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild3, "Builder().setResolutionS…IGHER_RESOLUTION).build()");
            imageAnalysisBuild = new androidx.camera.core.ImageAnalysis.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild3).setOutputImageFormat(2).setBackpressureStrategy(0).build();
        }
        imageAnalysisBuild.setAnalyzer(smartAnswerCameraActivity.getAnalyzeExecutor(), smartAnswerCameraActivity.new ImageAnalyzer());
        androidx.camera.core.resolutionselector.ResolutionSelector resolutionSelectorBuild4 = new androidx.camera.core.resolutionselector.ResolutionSelector.Builder().setResolutionStrategy(new androidx.camera.core.resolutionselector.ResolutionStrategy(smartAnswerCameraActivity.getSupportSize((android.content.Context) smartAnswerCameraActivity), 2)).setAspectRatioStrategy(new androidx.camera.core.resolutionselector.AspectRatioStrategy(0, 1)).setAllowedResolutionMode(0).build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild4, "Builder().setResolutionS…IGHER_RESOLUTION).build()");
        smartAnswerCameraActivity.mImageCapture = new androidx.camera.core.ImageCapture.Builder().setTargetRotation(rotation).setResolutionSelector(resolutionSelectorBuild4).setCaptureMode(0).setJpegQuality(90).setFlashMode(2).build();
        androidx.camera.core.UseCaseGroup.Builder builder = new androidx.camera.core.UseCaseGroup.Builder();
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding5 = smartAnswerCameraActivity.b;
        if (activityAnswerSmartCameraBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityAnswerSmartCameraBinding2 = activityAnswerSmartCameraBinding5;
        }
        androidx.camera.core.ViewPort viewPort = activityAnswerSmartCameraBinding2.previewView.getViewPort();
        kotlin.jvm.internal.Intrinsics.checkNotNull(viewPort);
        androidx.camera.core.UseCaseGroup.Builder builderAddUseCase = builder.setViewPort(viewPort).addUseCase((androidx.camera.core.UseCase) previewBuild).addUseCase((androidx.camera.core.UseCase) imageAnalysisBuild);
        androidx.camera.core.UseCase useCase = smartAnswerCameraActivity.mImageCapture;
        kotlin.jvm.internal.Intrinsics.checkNotNull(useCase);
        androidx.camera.core.UseCaseGroup useCaseGroupBuild = builderAddUseCase.addUseCase(useCase).build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(useCaseGroupBuild, "Builder().setViewPort(b.…(mImageCapture!!).build()");
        androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider = smartAnswerCameraActivity.mCameraProvider;
        kotlin.jvm.internal.Intrinsics.checkNotNull(processCameraProvider);
        processCameraProvider.unbindAll();
        androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider2 = smartAnswerCameraActivity.mCameraProvider;
        kotlin.jvm.internal.Intrinsics.checkNotNull(processCameraProvider2);
        androidx.lifecycle.LifecycleOwner lifecycleOwner = (androidx.lifecycle.LifecycleOwner) smartAnswerCameraActivity;
        androidx.camera.core.CameraSelector cameraSelector = androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraSelector, "DEFAULT_BACK_CAMERA");
        androidx.camera.core.Camera cameraBindToLifecycle = processCameraProvider2.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroupBuild);
        smartAnswerCameraActivity.mCameraControl = cameraBindToLifecycle.getCameraControl();
        androidx.camera.core.CameraInfo cameraInfo = cameraBindToLifecycle.getCameraInfo();
        smartAnswerCameraActivity.mCameraInfo = cameraInfo;
        if (cameraInfo == null || (torchState = cameraInfo.getTorchState()) == null) {
            return;
        }
        final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> function1 = new kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit>() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$initCameraController$1$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((java.lang.Integer) obj);
                return kotlin.Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(java.lang.Integer r3) {
                /*
                    r2 = this;
                    com.up366.multimediav2.activity.SmartAnswerCameraActivity r0 = r2.this$0
                    androidx.camera.core.ImageCapture r0 = com.up366.multimediav2.activity.SmartAnswerCameraActivity.access$getMImageCapture$p(r0)
                    if (r0 != 0) goto L9
                    goto L18
                L9:
                    if (r3 != 0) goto Lc
                    goto L14
                Lc:
                    int r3 = r3.intValue()
                    r1 = 1
                    if (r3 != r1) goto L14
                    goto L15
                L14:
                    r1 = 2
                L15:
                    r0.setFlashMode(r1)
                L18:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.up366.multimediav2.activity.SmartAnswerCameraActivity$initCameraController$1$1.invoke(java.lang.Integer):void");
            }
        };
        torchState.observe(lifecycleOwner, new androidx.lifecycle.Observer() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda9
            public final void onChanged(java.lang.Object obj) {
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.initCameraController$lambda$12$lambda$11(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCameraController$lambda$12$lambda$11(kotlin.jvm.functions.Function1 function1, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void switchScene(boolean hand) {
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = null;
        if (hand) {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = this.b;
            if (activityAnswerSmartCameraBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding2 = null;
            }
            activityAnswerSmartCameraBinding2.ibHandTakePic.setVisibility(0);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding3 = this.b;
            if (activityAnswerSmartCameraBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding3 = null;
            }
            activityAnswerSmartCameraBinding3.qrbAutoPicture.setVisibility(0);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding4 = this.b;
            if (activityAnswerSmartCameraBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding4 = null;
            }
            activityAnswerSmartCameraBinding4.ibSelectPic.setVisibility(0);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding5 = this.b;
            if (activityAnswerSmartCameraBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding5 = null;
            }
            activityAnswerSmartCameraBinding5.qrbHandPicture.setVisibility(8);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding6 = this.b;
            if (activityAnswerSmartCameraBinding6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding6 = null;
            }
            activityAnswerSmartCameraBinding6.tvAnalyzeResult.setVisibility(8);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding7 = this.b;
            if (activityAnswerSmartCameraBinding7 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding7 = null;
            }
            activityAnswerSmartCameraBinding7.borderView.setVisibility(8);
            removeMessages(101);
            this.startAnalyzer = false;
        } else {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding8 = this.b;
            if (activityAnswerSmartCameraBinding8 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding8 = null;
            }
            activityAnswerSmartCameraBinding8.qrbHandPicture.setVisibility(0);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding9 = this.b;
            if (activityAnswerSmartCameraBinding9 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding9 = null;
            }
            activityAnswerSmartCameraBinding9.tvAnalyzeResult.setVisibility(0);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding10 = this.b;
            if (activityAnswerSmartCameraBinding10 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding10 = null;
            }
            activityAnswerSmartCameraBinding10.ibSelectPic.setVisibility(8);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding11 = this.b;
            if (activityAnswerSmartCameraBinding11 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding11 = null;
            }
            activityAnswerSmartCameraBinding11.ibHandTakePic.setVisibility(8);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding12 = this.b;
            if (activityAnswerSmartCameraBinding12 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding12 = null;
            }
            activityAnswerSmartCameraBinding12.qrbAutoPicture.setVisibility(8);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding13 = this.b;
            if (activityAnswerSmartCameraBinding13 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding13 = null;
            }
            activityAnswerSmartCameraBinding13.borderView.clear();
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding14 = this.b;
            if (activityAnswerSmartCameraBinding14 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding14 = null;
            }
            activityAnswerSmartCameraBinding14.borderView.setVisibility(0);
            this.startAnalyzer = true;
        }
        if (isClosePad) {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding15 = this.b;
            if (activityAnswerSmartCameraBinding15 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityAnswerSmartCameraBinding = activityAnswerSmartCameraBinding15;
            }
            activityAnswerSmartCameraBinding.ibSelectPic.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SmartAnswerCameraActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/up366/multimediav2/activity/SmartAnswerCameraActivity$ImageAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "(Lcom/up366/multimediav2/activity/SmartAnswerCameraActivity;)V", "hadLog", "", "analyze", "", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Landroidx/camera/core/ImageProxy;", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ImageAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
        private boolean hadLog;

        public /* synthetic */ android.util.Size getDefaultTargetResolution() {
            return androidx.camera.core.ImageAnalysis.Analyzer.-CC.$default$getDefaultTargetResolution(this);
        }

        public /* synthetic */ int getTargetCoordinateSystem() {
            return androidx.camera.core.ImageAnalysis.Analyzer.-CC.$default$getTargetCoordinateSystem(this);
        }

        public /* synthetic */ void updateTransform(android.graphics.Matrix matrix) {
            androidx.camera.core.ImageAnalysis.Analyzer.-CC.$default$updateTransform(this, matrix);
        }

        public ImageAnalyzer() {
        }

        public void analyze(androidx.camera.core.ImageProxy image) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
            if (!com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.startAnalyzer) {
                image.close();
                return;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            android.graphics.Bitmap bitmapCreateBitmapFromImageProxy = androidx.camera.core.internal.utils.ImageUtil.createBitmapFromImageProxy(image);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmapFromImageProxy, "createBitmapFromImageProxy(image)");
            int rotationDegrees = image.getImageInfo().getRotationDegrees();
            android.graphics.Bitmap bitmapRotateBitmap = com.up366.smart.paper.utils.BitmapUtils.rotateBitmap(bitmapCreateBitmapFromImageProxy, rotationDegrees, false, false);
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapCreateBitmapFromImageProxy, bitmapRotateBitmap);
            android.graphics.Rect rectRotateRect = com.up366.smart.paper.CameraUtil.rotateRect(image.getCropRect(), bitmapRotateBitmap.getWidth(), bitmapRotateBitmap.getHeight(), rotationDegrees);
            final android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapRotateBitmap, rectRotateRect.left, rectRotateRect.top, rectRotateRect.width(), rectRotateRect.height());
            if (com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.needUpdateGraphicOverlayImageSourceInfo) {
                com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.b;
                if (activityAnswerSmartCameraBinding == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                    activityAnswerSmartCameraBinding = null;
                }
                activityAnswerSmartCameraBinding.borderView.setImageSourceInfo(bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), false);
                com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.needUpdateGraphicOverlayImageSourceInfo = false;
            }
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapRotateBitmap, bitmapCreateBitmap);
            final com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResultAnalyze = com.up366.smart.paper.opencv.OpencvImageAnalyze.analyze(bitmapCreateBitmap);
            image.close();
            if (bitmapAnalyzeResultAnalyze != null) {
                bitmapAnalyzeResultAnalyze.setBitmapDegrees(0);
            }
            if (bitmapAnalyzeResultAnalyze != null) {
                bitmapAnalyzeResultAnalyze.setBitmapRect(rectRotateRect);
            }
            if (!this.hadLog) {
                com.up366.common.log.Logger.info(com.up366.multimediav2.activity.SmartAnswerCameraActivity.this.TAG + " analyze bitmap w=" + bitmapCreateBitmap.getWidth() + " h=" + bitmapCreateBitmap.getHeight() + " degrees=" + rotationDegrees + " cropRect=" + rectRotateRect + " time=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                this.hadLog = true;
            }
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapCreateBitmap);
            final com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity = com.up366.multimediav2.activity.SmartAnswerCameraActivity.this;
            smartAnswerCameraActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$ImageAnalyzer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.multimediav2.activity.SmartAnswerCameraActivity.ImageAnalyzer.analyze$lambda$0(smartAnswerCameraActivity, bitmapCreateBitmap, bitmapAnalyzeResultAnalyze);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void analyze$lambda$0(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.graphics.Bitmap bitmap, com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResult) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmap, "analyzedBitmap");
            smartAnswerCameraActivity.analysisResult(bitmap, bitmapAnalyzeResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void analysisResult(android.graphics.Bitmap bitmap, com.up366.smart.paper.BitmapAnalyzeResult analyzeResult) {
        com.up366.smart.paper.CameraUtil.gcBitmap(bitmap);
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = null;
        if (analyzeResult == null || analyzeResult.getPoints().size() != 4) {
            this.resultStatistics.clear();
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = this.b;
            if (activityAnswerSmartCameraBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding2 = null;
            }
            activityAnswerSmartCameraBinding2.tvAnalyzeResult.setText("请将纸显示在屏幕内");
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding3 = this.b;
            if (activityAnswerSmartCameraBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityAnswerSmartCameraBinding = activityAnswerSmartCameraBinding3;
            }
            activityAnswerSmartCameraBinding.borderView.clear();
            return;
        }
        if (!hasMessages(101)) {
            sendEmptyMessageDelayed(101, com.igexin.push.config.c.s);
        }
        if (!analyzeResult.isAllowArea()) {
            this.resultStatistics.clear();
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding4 = this.b;
            if (activityAnswerSmartCameraBinding4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding4 = null;
            }
            activityAnswerSmartCameraBinding4.tvAnalyzeResult.setText("离纸近一点");
        } else {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding5 = this.b;
            if (activityAnswerSmartCameraBinding5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding5 = null;
            }
            activityAnswerSmartCameraBinding5.tvAnalyzeResult.setText("拍摄中...保持稳定");
            java.lang.Boolean boolAddAnalyzeResult = this.resultStatistics.addAnalyzeResult(analyzeResult);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(boolAddAnalyzeResult, "resultStatistics.addAnalyzeResult(analyzeResult)");
            if (boolAddAnalyzeResult.booleanValue()) {
                this.startAnalyzer = false;
                this.resultStatistics.clear();
                removeCallbacksAndMessages(null);
            }
        }
        if (this.startAnalyzer) {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding6 = this.b;
            if (activityAnswerSmartCameraBinding6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding6 = null;
            }
            activityAnswerSmartCameraBinding6.borderView.clear();
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding7 = this.b;
            if (activityAnswerSmartCameraBinding7 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding7 = null;
            }
            com.up366.smart.paper.view.GraphicOverlay graphicOverlay = activityAnswerSmartCameraBinding7.borderView;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(graphicOverlay, "b.borderView");
            java.util.List<org.opencv.core.Point> points = analyzeResult.getPoints();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(points, "analyzeResult.points");
            com.up366.multimediav2.views.BorderGraphic borderGraphic = new com.up366.multimediav2.views.BorderGraphic(graphicOverlay, points, analyzeResult.isAllowArea());
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding8 = this.b;
            if (activityAnswerSmartCameraBinding8 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding8 = null;
            }
            activityAnswerSmartCameraBinding8.borderView.add(borderGraphic);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding9 = this.b;
            if (activityAnswerSmartCameraBinding9 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityAnswerSmartCameraBinding = activityAnswerSmartCameraBinding9;
            }
            activityAnswerSmartCameraBinding.borderView.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showTakePictureTipsToast() {
        if (getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.RESUMED)) {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = null;
            if (this.tipsToastPopupWindow == null) {
                android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(android.view.LayoutInflater.from((android.content.Context) this).inflate(com.up366.multimediav2.R.layout.toast_smart_camera_take_pic_tips, (android.view.ViewGroup) null, false), com.up366.qmui.util.QMUIDisplayHelper.dpToPx(268), com.up366.qmui.util.QMUIDisplayHelper.dpToPx(com.igexin.push.config.c.E), true);
                this.tipsToastPopupWindow = popupWindow;
                kotlin.jvm.internal.Intrinsics.checkNotNull(popupWindow);
                popupWindow.setBackgroundDrawable(null);
                android.widget.PopupWindow popupWindow2 = this.tipsToastPopupWindow;
                kotlin.jvm.internal.Intrinsics.checkNotNull(popupWindow2);
                popupWindow2.setTouchable(false);
            }
            android.widget.PopupWindow popupWindow3 = this.tipsToastPopupWindow;
            kotlin.jvm.internal.Intrinsics.checkNotNull(popupWindow3);
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = this.b;
            if (activityAnswerSmartCameraBinding2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            } else {
                activityAnswerSmartCameraBinding = activityAnswerSmartCameraBinding2;
            }
            popupWindow3.showAtLocation((android.view.View) activityAnswerSmartCameraBinding.previewView, 17, 0, 0);
            sendEmptyMessageDelayed(102, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeTakePictureTipsToast() {
        android.widget.PopupWindow popupWindow;
        android.widget.PopupWindow popupWindow2;
        if (!getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.RESUMED) || (popupWindow = this.tipsToastPopupWindow) == null || !popupWindow.isShowing() || (popupWindow2 = this.tipsToastPopupWindow) == null) {
            return;
        }
        popupWindow2.dismiss();
    }

    static /* synthetic */ void takeOnePicture$default(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResult, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        smartAnswerCameraActivity.takeOnePicture(bitmapAnalyzeResult, z);
    }

    private final void takeOnePicture(final com.up366.smart.paper.BitmapAnalyzeResult analyzeResult, final boolean hand) {
        androidx.camera.core.ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture != null) {
            imageCapture.takePicture(getPictureExecutor(), new androidx.camera.core.ImageCapture.OnImageCapturedCallback() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity.takeOnePicture.1
                public void onCaptureSuccess(androidx.camera.core.ImageProxy image) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
                    super.onCaptureSuccess(image);
                    if (hand) {
                        this.handImage(image);
                        return;
                    }
                    com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity = this;
                    com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResult = analyzeResult;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(bitmapAnalyzeResult);
                    smartAnswerCameraActivity.handleImage(image, bitmapAnalyzeResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handImage(androidx.camera.core.ImageProxy image) {
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            byte[] bArrJpegImageToJpegByteArray = com.up366.smart.paper.CameraUtil.jpegImageToJpegByteArray(image);
            android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArrJpegImageToJpegByteArray, 0, bArrJpegImageToJpegByteArray.length);
            int rotationDegrees = image.getImageInfo().getRotationDegrees();
            android.graphics.Rect cropRect = image.getCropRect();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cropRect, "image.cropRect");
            com.up366.common.log.Logger.info(this.TAG + " handTakePicture w=" + image.getWidth() + " h=" + image.getHeight() + " cropRect=" + cropRect + "  degrees=" + image.getImageInfo().getRotationDegrees() + " time=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            image.close();
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapDecodeByteArray, cropRect.left, cropRect.top, cropRect.width(), cropRect.height());
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapDecodeByteArray, bitmapCreateBitmap);
            if (image.getWidth() > image.getHeight() && (rotationDegrees == 0 || rotationDegrees == 180)) {
                rotationDegrees = rotationDegrees == 0 ? rotationDegrees + 90 : rotationDegrees - 90;
            }
            android.graphics.Bitmap bitmapBitmapRotate = rotationDegrees != 0 ? com.up366.smart.paper.CameraUtil.bitmapRotate(bitmapCreateBitmap, rotationDegrees) : bitmapCreateBitmap;
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapCreateBitmap, bitmapBitmapRotate);
            java.lang.String str = this.imagePath;
            if (str == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imagePath");
                str = null;
            }
            com.up366.smart.paper.CameraUtil.saveBitmap(bitmapBitmapRotate, str);
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapBitmapRotate);
            runOnUiThread(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.multimediav2.activity.SmartAnswerCameraActivity.handImage$lambda$13(this.f$0);
                }
            });
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.OutOfMemoryError) {
                com.up366.common.log.Logger.error(this.TAG + " hand take picture outOfMemoryError");
                return;
            }
            com.up366.common.log.Logger.info(this.TAG + " hand take picture error " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handImage$lambda$13(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        java.lang.String str = smartAnswerCameraActivity.imagePath;
        if (str == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imagePath");
            str = null;
        }
        smartAnswerCameraActivity.finishByHandTakePicture(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleImage(androidx.camera.core.ImageProxy image, com.up366.smart.paper.BitmapAnalyzeResult analyzeResult) {
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            byte[] bArrJpegImageToJpegByteArray = androidx.camera.core.internal.utils.ImageUtil.jpegImageToJpegByteArray(image, image.getCropRect(), 100);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArrJpegImageToJpegByteArray, "jpegImageToJpegByteArray…age, image.cropRect, 100)");
            image.close();
            android.graphics.Bitmap bitmapDecodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArrJpegImageToJpegByteArray, 0, bArrJpegImageToJpegByteArray.length);
            android.graphics.Bitmap bitmapRotateBitmap = com.up366.smart.paper.utils.BitmapUtils.rotateBitmap(bitmapDecodeByteArray, image.getImageInfo().getRotationDegrees(), false, false);
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapDecodeByteArray, bitmapRotateBitmap);
            android.graphics.Bitmap bitmapBitmapTransformCrop = com.up366.smart.paper.opencv.OpencvCrop.bitmapTransformCrop(bitmapRotateBitmap, com.up366.smart.paper.CameraUtil.scalePoints(analyzeResult.getPoints(), analyzeResult.getBitmapRect(), bitmapRotateBitmap.getWidth(), bitmapRotateBitmap.getHeight()));
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapRotateBitmap);
            java.lang.String str = this.imagePath;
            if (str == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imagePath");
                str = null;
            }
            com.up366.smart.paper.CameraUtil.saveBitmap(bitmapBitmapTransformCrop, str);
            com.up366.smart.paper.CameraUtil.gcBitmap(bitmapBitmapTransformCrop);
            com.up366.common.log.Logger.info(this.TAG + " takePicture w=" + image.getWidth() + " h=" + image.getHeight() + "  cropw=" + image.getCropRect().width() + " croph=" + image.getCropRect().height() + " degrees=" + image.getImageInfo().getRotationDegrees() + " time=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            image.close();
            runOnUiThread(new java.lang.Runnable() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.multimediav2.activity.SmartAnswerCameraActivity.handleImage$lambda$14(this.f$0);
                }
            });
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.OutOfMemoryError) {
                com.up366.common.log.Logger.error(this.TAG + " take picture outOfMemoryError");
                return;
            }
            com.up366.common.log.Logger.info(this.TAG + " take picture error " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleImage$lambda$14(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = smartAnswerCameraActivity.b;
        java.lang.String str = null;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        activityAnswerSmartCameraBinding.tvAnalyzeResult.setVisibility(8);
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = smartAnswerCameraActivity.b;
        if (activityAnswerSmartCameraBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding2 = null;
        }
        activityAnswerSmartCameraBinding2.tvMovePageOrPhone.setVisibility(8);
        java.lang.String str2 = smartAnswerCameraActivity.imagePath;
        if (str2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imagePath");
        } else {
            str = str2;
        }
        smartAnswerCameraActivity.finishByRecognitionTakePicture(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGuideDialog(boolean manual) {
        showSmartGuideDialog(manual);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showSmartGuideDialog(boolean manual) {
        if (manual || getSharedPreferences(com.up366.multimediav2.util.Constants.PREFERENCE_NAME, 0).getBoolean(KEY_FIRST_GUIDE, true)) {
            new com.up366.multimediav2.dialog.SmartCameraGuideDialog((android.content.Context) this).setDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.multimediav2.activity.SmartAnswerCameraActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    com.up366.multimediav2.activity.SmartAnswerCameraActivity.showSmartGuideDialog$lambda$15(this.f$0, dialogInterface);
                }
            }).show();
            this.startAnalyzer = false;
            return;
        }
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = this.b;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        this.startAnalyzer = activityAnswerSmartCameraBinding.ibHandTakePic.getVisibility() == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSmartGuideDialog$lambda$15(com.up366.multimediav2.activity.SmartAnswerCameraActivity smartAnswerCameraActivity, android.content.DialogInterface dialogInterface) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartAnswerCameraActivity, "this$0");
        smartAnswerCameraActivity.getSharedPreferences(com.up366.multimediav2.util.Constants.PREFERENCE_NAME, 0).edit().putBoolean(KEY_FIRST_GUIDE, false).apply();
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = smartAnswerCameraActivity.b;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        smartAnswerCameraActivity.startAnalyzer = activityAnswerSmartCameraBinding.ibHandTakePic.getVisibility() == 8;
    }

    private final void controlLight() {
        android.animation.ObjectAnimator objectAnimator = this.lightAnimator;
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = null;
        if (objectAnimator == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
            objectAnimator = null;
        }
        if (objectAnimator.isStarted()) {
            android.animation.ObjectAnimator objectAnimator2 = this.lightAnimator;
            if (objectAnimator2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
                objectAnimator2 = null;
            }
            objectAnimator2.cancel();
        }
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = this.b;
        if (activityAnswerSmartCameraBinding2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding2 = null;
        }
        if (activityAnswerSmartCameraBinding2.tvLightToast.getVisibility() == 0) {
            com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding3 = this.b;
            if (activityAnswerSmartCameraBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                activityAnswerSmartCameraBinding3 = null;
            }
            activityAnswerSmartCameraBinding3.tvLightToast.setVisibility(8);
        }
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding4 = this.b;
        if (activityAnswerSmartCameraBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityAnswerSmartCameraBinding = activityAnswerSmartCameraBinding4;
        }
        activityAnswerSmartCameraBinding.btLightStatus.animate().alpha(1.0f).setDuration(50L).start();
        boolean z = !this.lightStatus;
        this.lightStatus = z;
        setLightDrawableByStatus(z);
        androidx.camera.core.CameraControl cameraControl = this.mCameraControl;
        if (cameraControl != null) {
            cameraControl.enableTorch(this.lightStatus);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent event) {
        android.hardware.Sensor sensor;
        if (event == null || (sensor = event.sensor) == null || sensor.getType() != 5) {
            return;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(event);
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = null;
        android.animation.ObjectAnimator objectAnimator = null;
        if (event.values[0] < 40.0f) {
            if (this.lightStatus) {
                return;
            }
            if (this.firstShowLightToast) {
                com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding2 = this.b;
                if (activityAnswerSmartCameraBinding2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
                    activityAnswerSmartCameraBinding2 = null;
                }
                activityAnswerSmartCameraBinding2.tvLightToast.setVisibility(0);
                this.firstShowLightToast = false;
            }
            android.animation.ObjectAnimator objectAnimator2 = this.lightAnimator;
            if (objectAnimator2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
                objectAnimator2 = null;
            }
            objectAnimator2.cancel();
            setLightDrawableByStatus(true);
            android.animation.ObjectAnimator objectAnimator3 = this.lightAnimator;
            if (objectAnimator3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
            } else {
                objectAnimator = objectAnimator3;
            }
            objectAnimator.start();
            return;
        }
        android.animation.ObjectAnimator objectAnimator4 = this.lightAnimator;
        if (objectAnimator4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("lightAnimator");
            objectAnimator4 = null;
        }
        objectAnimator4.cancel();
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding3 = this.b;
        if (activityAnswerSmartCameraBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
        } else {
            activityAnswerSmartCameraBinding = activityAnswerSmartCameraBinding3;
        }
        activityAnswerSmartCameraBinding.tvLightToast.setVisibility(8);
        if (this.lightStatus) {
            return;
        }
        setLightDrawableByStatus(false);
    }

    private final void setLightDrawableByStatus(boolean status) {
        int i;
        com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding activityAnswerSmartCameraBinding = this.b;
        if (activityAnswerSmartCameraBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("b");
            activityAnswerSmartCameraBinding = null;
        }
        android.widget.ImageButton imageButton = activityAnswerSmartCameraBinding.btLightStatus;
        if (status) {
            i = com.up366.multimediav2.R.drawable.smart_camera_light_open;
        } else {
            i = com.up366.multimediav2.R.drawable.smart_camera_light_normal;
        }
        imageButton.setImageResource(i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NotImplementedError */
    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) throws kotlin.NotImplementedError {
        throw new kotlin.NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final android.util.Size getSupportSize(android.content.Context context) throws android.hardware.camera2.CameraAccessException {
        android.util.Size size = new android.util.Size(4000, 3000);
        java.util.List<android.util.Size> supportedResolutions = getSupportedResolutions(context);
        if (supportedResolutions.isEmpty()) {
            return size;
        }
        boolean z = false;
        for (android.util.Size size2 : supportedResolutions) {
            if (size2.getWidth() >= 3200 && size2.getHeight() >= 2400 && size2.getWidth() * size2.getHeight() < size.getWidth() * size.getHeight()) {
                z = true;
                size = size2;
            }
        }
        if (!z) {
            size = supportedResolutions.get(0);
        }
        com.up366.common.log.Logger.info("supportSizes:" + supportedResolutions + ", defaultSize:" + size);
        return size;
    }

    private final java.util.List<android.util.Size> getSupportedResolutions(android.content.Context context) throws android.hardware.camera2.CameraAccessException {
        java.lang.Object systemService = context.getSystemService("camera");
        kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) systemService;
        java.lang.String[] cameraIdList = cameraManager.getCameraIdList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraIdList, "cameraManager.cameraIdList");
        for (java.lang.String str : cameraIdList) {
            android.hardware.camera2.CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraId)");
            java.lang.Integer num = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING);
            if (num != null && num.intValue() == 1) {
                android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                android.util.Size[] outputSizes = streamConfigurationMap != null ? streamConfigurationMap.getOutputSizes(256) : null;
                if (outputSizes != null) {
                    return kotlin.collections.ArraysKt.toList(outputSizes);
                }
            }
        }
        return kotlin.collections.CollectionsKt.emptyList();
    }
}
